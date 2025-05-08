package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class CompositionLayer extends BaseLayer {
    private boolean clipToCompositionBounds;
    private Boolean hasMasks;
    private Boolean hasMatte;
    private final Paint layerPaint;
    private final List<BaseLayer> layers;
    private final RectF newClipRect;
    private final RectF rect;
    private BaseKeyframeAnimation<Float, Float> timeRemapping;

    /* renamed from: com.airbnb.lottie.model.layer.CompositionLayer$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        int i5;
        BaseLayer baseLayer;
        this.layers = new ArrayList();
        this.rect = new RectF();
        this.newClipRect = new RectF();
        this.layerPaint = new Paint();
        this.clipToCompositionBounds = true;
        AnimatableFloatValue timeRemapping = layer.getTimeRemapping();
        if (timeRemapping != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation = timeRemapping.createAnimation();
            this.timeRemapping = createAnimation;
            addAnimation(createAnimation);
            this.timeRemapping.addUpdateListener(this);
        } else {
            this.timeRemapping = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.getLayers().size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            BaseLayer forModel = BaseLayer.forModel(this, layer2, lottieDrawable, lottieComposition);
            if (forModel != null) {
                longSparseArray.put(forModel.getLayerModel().getId(), forModel);
                if (baseLayer2 != null) {
                    baseLayer2.setMatteLayer(forModel);
                    baseLayer2 = null;
                } else {
                    this.layers.add(0, forModel);
                    int i6 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[layer2.getMatteType().ordinal()];
                    if (i6 == 1 || i6 == 2) {
                        baseLayer2 = forModel;
                    }
                }
            }
            size--;
        }
        for (i5 = 0; i5 < longSparseArray.size(); i5++) {
            BaseLayer baseLayer3 = (BaseLayer) longSparseArray.get(longSparseArray.keyAt(i5));
            if (baseLayer3 != null && (baseLayer = (BaseLayer) longSparseArray.get(baseLayer3.getLayerModel().getParentId())) != null) {
                baseLayer3.setParentLayer(baseLayer);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t5, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t5, lottieValueCallback);
        if (t5 == LottieProperty.TIME_REMAP) {
            if (lottieValueCallback == null) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.timeRemapping;
                if (baseKeyframeAnimation != null) {
                    baseKeyframeAnimation.setValueCallback(null);
                    return;
                }
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.timeRemapping = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            addAnimation(this.timeRemapping);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void drawLayer(Canvas canvas, Matrix matrix, int i5) {
        L.beginSection("CompositionLayer#draw");
        this.newClipRect.set(0.0f, 0.0f, this.layerModel.getPreCompWidth(), this.layerModel.getPreCompHeight());
        matrix.mapRect(this.newClipRect);
        boolean z5 = this.lottieDrawable.isApplyingOpacityToLayersEnabled() && this.layers.size() > 1 && i5 != 255;
        if (z5) {
            this.layerPaint.setAlpha(i5);
            Utils.saveLayerCompat(canvas, this.newClipRect, this.layerPaint);
        } else {
            canvas.save();
        }
        if (z5) {
            i5 = 255;
        }
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            if (((this.clipToCompositionBounds || !"__container".equals(this.layerModel.getName())) && !this.newClipRect.isEmpty()) ? canvas.clipRect(this.newClipRect) : true) {
                this.layers.get(size).draw(canvas, matrix, i5);
            }
        }
        canvas.restore();
        L.endSection("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z5) {
        super.getBounds(rectF, matrix, z5);
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.layers.get(size).getBounds(this.rect, this.boundsMatrix, true);
            rectF.union(this.rect);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    protected void resolveChildKeyPath(KeyPath keyPath, int i5, List<KeyPath> list, KeyPath keyPath2) {
        for (int i6 = 0; i6 < this.layers.size(); i6++) {
            this.layers.get(i6).resolveKeyPath(keyPath, i5, list, keyPath2);
        }
    }

    public void setClipToCompositionBounds(boolean z5) {
        this.clipToCompositionBounds = z5;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void setOutlineMasksAndMattes(boolean z5) {
        super.setOutlineMasksAndMattes(z5);
        Iterator<BaseLayer> it = this.layers.iterator();
        while (it.hasNext()) {
            it.next().setOutlineMasksAndMattes(z5);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void setProgress(float f5) {
        super.setProgress(f5);
        if (this.timeRemapping != null) {
            f5 = ((this.timeRemapping.getValue().floatValue() * this.layerModel.getComposition().getFrameRate()) - this.layerModel.getComposition().getStartFrame()) / (this.lottieDrawable.getComposition().getDurationFrames() + 0.01f);
        }
        if (this.timeRemapping == null) {
            f5 -= this.layerModel.getStartProgress();
        }
        if (this.layerModel.getTimeStretch() != 0.0f && !"__container".equals(this.layerModel.getName())) {
            f5 /= this.layerModel.getTimeStretch();
        }
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            this.layers.get(size).setProgress(f5);
        }
    }
}
