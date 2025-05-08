package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.value.LottieValueCallback;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    private int alpha;
    private final LottieValueAnimator animator;
    private Rect canvasClipBounds;
    private RectF canvasClipBoundsRectF;
    private boolean clipToCompositionBounds;
    private LottieComposition composition;
    private CompositionLayer compositionLayer;
    String defaultFontFileExtension;
    private boolean enableMergePaths;
    private FontAssetManager fontAssetManager;
    private Map<String, Typeface> fontMap;
    private boolean ignoreSystemAnimationsDisabled;
    private ImageAssetDelegate imageAssetDelegate;
    private ImageAssetManager imageAssetManager;
    private String imageAssetsFolder;
    private boolean isApplyingOpacityToLayersEnabled;
    private boolean isDirty;
    private final ArrayList<LazyCompositionTask> lazyCompositionTasks;
    private boolean maintainOriginalImageBounds;
    private OnVisibleAction onVisibleAction;
    private boolean outlineMasksAndMattes;
    private boolean performanceTrackingEnabled;
    private final ValueAnimator.AnimatorUpdateListener progressUpdateListener;
    private RenderMode renderMode;
    private final Matrix renderingMatrix;
    private boolean safeMode;
    private Bitmap softwareRenderingBitmap;
    private Canvas softwareRenderingCanvas;
    private Rect softwareRenderingDstBoundsRect;
    private RectF softwareRenderingDstBoundsRectF;
    private Matrix softwareRenderingOriginalCanvasMatrix;
    private Matrix softwareRenderingOriginalCanvasMatrixInverse;
    private Paint softwareRenderingPaint;
    private Rect softwareRenderingSrcBoundsRect;
    private RectF softwareRenderingTransformedBounds;
    private boolean systemAnimationsEnabled;
    private boolean useSoftwareRendering;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface LazyCompositionTask {
        void run(LottieComposition lottieComposition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum OnVisibleAction {
        NONE,
        PLAY,
        RESUME
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator = new LottieValueAnimator();
        this.animator = lottieValueAnimator;
        this.systemAnimationsEnabled = true;
        this.ignoreSystemAnimationsDisabled = false;
        this.safeMode = false;
        this.onVisibleAction = OnVisibleAction.NONE;
        this.lazyCompositionTasks = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.LottieDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (LottieDrawable.this.compositionLayer != null) {
                    LottieDrawable.this.compositionLayer.setProgress(LottieDrawable.this.animator.getAnimatedValueAbsolute());
                }
            }
        };
        this.progressUpdateListener = animatorUpdateListener;
        this.maintainOriginalImageBounds = false;
        this.clipToCompositionBounds = true;
        this.alpha = Function.USE_VARARGS;
        this.renderMode = RenderMode.AUTOMATIC;
        this.useSoftwareRendering = false;
        this.renderingMatrix = new Matrix();
        this.isDirty = false;
        lottieValueAnimator.addUpdateListener(animatorUpdateListener);
    }

    private boolean animationsEnabled() {
        return this.systemAnimationsEnabled || this.ignoreSystemAnimationsDisabled;
    }

    private void buildCompositionLayer() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return;
        }
        CompositionLayer compositionLayer = new CompositionLayer(this, LayerParser.parse(lottieComposition), lottieComposition.getLayers(), lottieComposition);
        this.compositionLayer = compositionLayer;
        if (this.outlineMasksAndMattes) {
            compositionLayer.setOutlineMasksAndMattes(true);
        }
        this.compositionLayer.setClipToCompositionBounds(this.clipToCompositionBounds);
    }

    private void computeRenderMode() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return;
        }
        this.useSoftwareRendering = this.renderMode.useSoftwareRendering(Build.VERSION.SDK_INT, lottieComposition.hasDashPattern(), lottieComposition.getMaskAndMatteCount());
    }

    private void convertRect(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void drawDirectlyToCanvas(Canvas canvas) {
        CompositionLayer compositionLayer = this.compositionLayer;
        LottieComposition lottieComposition = this.composition;
        if (compositionLayer == null || lottieComposition == null) {
            return;
        }
        this.renderingMatrix.reset();
        if (!getBounds().isEmpty()) {
            this.renderingMatrix.preScale(r2.width() / lottieComposition.getBounds().width(), r2.height() / lottieComposition.getBounds().height());
            this.renderingMatrix.preTranslate(r2.left, r2.top);
        }
        compositionLayer.draw(canvas, this.renderingMatrix, this.alpha);
    }

    private void ensureSoftwareRenderingBitmap(int i5, int i6) {
        Bitmap bitmap = this.softwareRenderingBitmap;
        if (bitmap == null || bitmap.getWidth() < i5 || this.softwareRenderingBitmap.getHeight() < i6) {
            Bitmap createBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
            this.softwareRenderingBitmap = createBitmap;
            this.softwareRenderingCanvas.setBitmap(createBitmap);
            this.isDirty = true;
            return;
        }
        if (this.softwareRenderingBitmap.getWidth() > i5 || this.softwareRenderingBitmap.getHeight() > i6) {
            Bitmap createBitmap2 = Bitmap.createBitmap(this.softwareRenderingBitmap, 0, 0, i5, i6);
            this.softwareRenderingBitmap = createBitmap2;
            this.softwareRenderingCanvas.setBitmap(createBitmap2);
            this.isDirty = true;
        }
    }

    private void ensureSoftwareRenderingObjectsInitialized() {
        if (this.softwareRenderingCanvas != null) {
            return;
        }
        this.softwareRenderingCanvas = new Canvas();
        this.softwareRenderingTransformedBounds = new RectF();
        this.softwareRenderingOriginalCanvasMatrix = new Matrix();
        this.softwareRenderingOriginalCanvasMatrixInverse = new Matrix();
        this.canvasClipBounds = new Rect();
        this.canvasClipBoundsRectF = new RectF();
        this.softwareRenderingPaint = new LPaint();
        this.softwareRenderingSrcBoundsRect = new Rect();
        this.softwareRenderingDstBoundsRect = new Rect();
        this.softwareRenderingDstBoundsRectF = new RectF();
    }

    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private FontAssetManager getFontAssetManager() {
        if (getCallback() == null) {
            return null;
        }
        if (this.fontAssetManager == null) {
            FontAssetManager fontAssetManager = new FontAssetManager(getCallback(), null);
            this.fontAssetManager = fontAssetManager;
            String str = this.defaultFontFileExtension;
            if (str != null) {
                fontAssetManager.setDefaultFontFileExtension(str);
            }
        }
        return this.fontAssetManager;
    }

    private ImageAssetManager getImageAssetManager() {
        ImageAssetManager imageAssetManager = this.imageAssetManager;
        if (imageAssetManager != null && !imageAssetManager.hasSameContext(getContext())) {
            this.imageAssetManager = null;
        }
        if (this.imageAssetManager == null) {
            this.imageAssetManager = new ImageAssetManager(getCallback(), this.imageAssetsFolder, null, this.composition.getImages());
        }
        return this.imageAssetManager;
    }

    private boolean ignoreCanvasClipBounds() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        if (((View) callback).getParent() instanceof ViewGroup) {
            return !((ViewGroup) r0).getClipChildren();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addValueCallback$14(KeyPath keyPath, Object obj, LottieValueCallback lottieValueCallback, LottieComposition lottieComposition) {
        addValueCallback(keyPath, obj, lottieValueCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playAnimation$0(LottieComposition lottieComposition) {
        playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resumeAnimation$1(LottieComposition lottieComposition) {
        resumeAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFrame$12(int i5, LottieComposition lottieComposition) {
        setFrame(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setProgress$13(float f5, LottieComposition lottieComposition) {
        setProgress(f5);
    }

    private void renderAndDrawAsBitmap(Canvas canvas, CompositionLayer compositionLayer) {
        if (this.composition == null || compositionLayer == null) {
            return;
        }
        ensureSoftwareRenderingObjectsInitialized();
        canvas.getMatrix(this.softwareRenderingOriginalCanvasMatrix);
        canvas.getClipBounds(this.canvasClipBounds);
        convertRect(this.canvasClipBounds, this.canvasClipBoundsRectF);
        this.softwareRenderingOriginalCanvasMatrix.mapRect(this.canvasClipBoundsRectF);
        convertRect(this.canvasClipBoundsRectF, this.canvasClipBounds);
        if (this.clipToCompositionBounds) {
            this.softwareRenderingTransformedBounds.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            compositionLayer.getBounds(this.softwareRenderingTransformedBounds, null, false);
        }
        this.softwareRenderingOriginalCanvasMatrix.mapRect(this.softwareRenderingTransformedBounds);
        Rect bounds = getBounds();
        float width = bounds.width() / getIntrinsicWidth();
        float height = bounds.height() / getIntrinsicHeight();
        scaleRect(this.softwareRenderingTransformedBounds, width, height);
        if (!ignoreCanvasClipBounds()) {
            RectF rectF = this.softwareRenderingTransformedBounds;
            Rect rect = this.canvasClipBounds;
            rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int ceil = (int) Math.ceil(this.softwareRenderingTransformedBounds.width());
        int ceil2 = (int) Math.ceil(this.softwareRenderingTransformedBounds.height());
        if (ceil == 0 || ceil2 == 0) {
            return;
        }
        ensureSoftwareRenderingBitmap(ceil, ceil2);
        if (this.isDirty) {
            this.renderingMatrix.set(this.softwareRenderingOriginalCanvasMatrix);
            this.renderingMatrix.preScale(width, height);
            Matrix matrix = this.renderingMatrix;
            RectF rectF2 = this.softwareRenderingTransformedBounds;
            matrix.postTranslate(-rectF2.left, -rectF2.top);
            this.softwareRenderingBitmap.eraseColor(0);
            compositionLayer.draw(this.softwareRenderingCanvas, this.renderingMatrix, this.alpha);
            this.softwareRenderingOriginalCanvasMatrix.invert(this.softwareRenderingOriginalCanvasMatrixInverse);
            this.softwareRenderingOriginalCanvasMatrixInverse.mapRect(this.softwareRenderingDstBoundsRectF, this.softwareRenderingTransformedBounds);
            convertRect(this.softwareRenderingDstBoundsRectF, this.softwareRenderingDstBoundsRect);
        }
        this.softwareRenderingSrcBoundsRect.set(0, 0, ceil, ceil2);
        canvas.drawBitmap(this.softwareRenderingBitmap, this.softwareRenderingSrcBoundsRect, this.softwareRenderingDstBoundsRect, this.softwareRenderingPaint);
    }

    private void scaleRect(RectF rectF, float f5, float f6) {
        rectF.set(rectF.left * f5, rectF.top * f6, rectF.right * f5, rectF.bottom * f6);
    }

    public <T> void addValueCallback(final KeyPath keyPath, final T t5, final LottieValueCallback<T> lottieValueCallback) {
        CompositionLayer compositionLayer = this.compositionLayer;
        if (compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.e
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.lambda$addValueCallback$14(keyPath, t5, lottieValueCallback, lottieComposition);
                }
            });
            return;
        }
        boolean z5 = true;
        if (keyPath == KeyPath.COMPOSITION) {
            compositionLayer.addValueCallback(t5, lottieValueCallback);
        } else if (keyPath.getResolvedElement() != null) {
            keyPath.getResolvedElement().addValueCallback(t5, lottieValueCallback);
        } else {
            List<KeyPath> resolveKeyPath = resolveKeyPath(keyPath);
            for (int i5 = 0; i5 < resolveKeyPath.size(); i5++) {
                resolveKeyPath.get(i5).getResolvedElement().addValueCallback(t5, lottieValueCallback);
            }
            z5 = true ^ resolveKeyPath.isEmpty();
        }
        if (z5) {
            invalidateSelf();
            if (t5 == LottieProperty.TIME_REMAP) {
                setProgress(getProgress());
            }
        }
    }

    public void clearComposition() {
        if (this.animator.isRunning()) {
            this.animator.cancel();
            if (!isVisible()) {
                this.onVisibleAction = OnVisibleAction.NONE;
            }
        }
        this.composition = null;
        this.compositionLayer = null;
        this.imageAssetManager = null;
        this.animator.clearComposition();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        L.beginSection("Drawable#draw");
        if (this.safeMode) {
            try {
                if (this.useSoftwareRendering) {
                    renderAndDrawAsBitmap(canvas, this.compositionLayer);
                } else {
                    drawDirectlyToCanvas(canvas);
                }
            } catch (Throwable th) {
                Logger.error("Lottie crashed in draw!", th);
            }
        } else if (this.useSoftwareRendering) {
            renderAndDrawAsBitmap(canvas, this.compositionLayer);
        } else {
            drawDirectlyToCanvas(canvas);
        }
        this.isDirty = false;
        L.endSection("Drawable#draw");
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public void endAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.endAnimation();
        if (isVisible()) {
            return;
        }
        this.onVisibleAction = OnVisibleAction.NONE;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    public Bitmap getBitmapForId(String str) {
        ImageAssetManager imageAssetManager = getImageAssetManager();
        if (imageAssetManager != null) {
            return imageAssetManager.bitmapForId(str);
        }
        return null;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.getBounds().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.getBounds().width();
    }

    public LottieImageAsset getLottieImageAssetForId(String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return null;
        }
        return lottieComposition.getImages().get(str);
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.maintainOriginalImageBounds;
    }

    public float getMaxFrame() {
        return this.animator.getMaxFrame();
    }

    public float getMinFrame() {
        return this.animator.getMinFrame();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getProgress() {
        return this.animator.getAnimatedValueAbsolute();
    }

    public int getRepeatCount() {
        return this.animator.getRepeatCount();
    }

    public float getSpeed() {
        return this.animator.getSpeed();
    }

    public TextDelegate getTextDelegate() {
        return null;
    }

    public Typeface getTypeface(Font font) {
        Map<String, Typeface> map = this.fontMap;
        if (map != null) {
            String family = font.getFamily();
            if (map.containsKey(family)) {
                return map.get(family);
            }
            String name = font.getName();
            if (map.containsKey(name)) {
                return map.get(name);
            }
            String str = font.getFamily() + "-" + font.getStyle();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        FontAssetManager fontAssetManager = getFontAssetManager();
        if (fontAssetManager != null) {
            return fontAssetManager.getTypeface(font);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.isDirty) {
            return;
        }
        this.isDirty = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isAnimating() {
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.isRunning();
    }

    public boolean isApplyingOpacityToLayersEnabled() {
        return this.isApplyingOpacityToLayersEnabled;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return isAnimating();
    }

    public void pauseAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.pauseAnimation();
        if (isVisible()) {
            return;
        }
        this.onVisibleAction = OnVisibleAction.NONE;
    }

    public void playAnimation() {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.b
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.lambda$playAnimation$0(lottieComposition);
                }
            });
            return;
        }
        computeRenderMode();
        if (animationsEnabled() || getRepeatCount() == 0) {
            if (isVisible()) {
                this.animator.playAnimation();
                this.onVisibleAction = OnVisibleAction.NONE;
            } else {
                this.onVisibleAction = OnVisibleAction.PLAY;
            }
        }
        if (animationsEnabled()) {
            return;
        }
        setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
        this.animator.endAnimation();
        if (isVisible()) {
            return;
        }
        this.onVisibleAction = OnVisibleAction.NONE;
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        if (this.compositionLayer == null) {
            Logger.warning("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.compositionLayer.resolveKeyPath(keyPath, 0, arrayList, new KeyPath(new String[0]));
        return arrayList;
    }

    public void resumeAnimation() {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.a
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.lambda$resumeAnimation$1(lottieComposition);
                }
            });
            return;
        }
        computeRenderMode();
        if (animationsEnabled() || getRepeatCount() == 0) {
            if (isVisible()) {
                this.animator.resumeAnimation();
                this.onVisibleAction = OnVisibleAction.NONE;
            } else {
                this.onVisibleAction = OnVisibleAction.RESUME;
            }
        }
        if (animationsEnabled()) {
            return;
        }
        setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
        this.animator.endAnimation();
        if (isVisible()) {
            return;
        }
        this.onVisibleAction = OnVisibleAction.NONE;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        this.alpha = i5;
        invalidateSelf();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z5) {
        this.isApplyingOpacityToLayersEnabled = z5;
    }

    public void setClipToCompositionBounds(boolean z5) {
        if (z5 != this.clipToCompositionBounds) {
            this.clipToCompositionBounds = z5;
            CompositionLayer compositionLayer = this.compositionLayer;
            if (compositionLayer != null) {
                compositionLayer.setClipToCompositionBounds(z5);
            }
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Logger.warning("Use addColorFilter instead.");
    }

    public boolean setComposition(LottieComposition lottieComposition) {
        if (this.composition == lottieComposition) {
            return false;
        }
        this.isDirty = true;
        clearComposition();
        this.composition = lottieComposition;
        buildCompositionLayer();
        this.animator.setComposition(lottieComposition);
        setProgress(this.animator.getAnimatedFraction());
        Iterator it = new ArrayList(this.lazyCompositionTasks).iterator();
        while (it.hasNext()) {
            LazyCompositionTask lazyCompositionTask = (LazyCompositionTask) it.next();
            if (lazyCompositionTask != null) {
                lazyCompositionTask.run(lottieComposition);
            }
            it.remove();
        }
        this.lazyCompositionTasks.clear();
        lottieComposition.setPerformanceTrackingEnabled(this.performanceTrackingEnabled);
        computeRenderMode();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void setFontMap(Map<String, Typeface> map) {
        if (map == this.fontMap) {
            return;
        }
        this.fontMap = map;
        invalidateSelf();
    }

    public void setFrame(final int i5) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.d
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.lambda$setFrame$12(i5, lottieComposition);
                }
            });
        } else {
            this.animator.setFrame(i5);
        }
    }

    public void setMaintainOriginalImageBounds(boolean z5) {
        this.maintainOriginalImageBounds = z5;
    }

    public void setOutlineMasksAndMattes(boolean z5) {
        if (this.outlineMasksAndMattes == z5) {
            return;
        }
        this.outlineMasksAndMattes = z5;
        CompositionLayer compositionLayer = this.compositionLayer;
        if (compositionLayer != null) {
            compositionLayer.setOutlineMasksAndMattes(z5);
        }
    }

    public void setProgress(final float f5) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.c
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.lambda$setProgress$13(f5, lottieComposition);
                }
            });
            return;
        }
        L.beginSection("Drawable#setProgress");
        this.animator.setFrame(this.composition.getFrameForProgress(f5));
        L.endSection("Drawable#setProgress");
    }

    public void setRenderMode(RenderMode renderMode) {
        this.renderMode = renderMode;
        computeRenderMode();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        boolean isVisible = isVisible();
        boolean visible = super.setVisible(z5, z6);
        if (z5) {
            OnVisibleAction onVisibleAction = this.onVisibleAction;
            if (onVisibleAction == OnVisibleAction.PLAY) {
                playAnimation();
            } else if (onVisibleAction == OnVisibleAction.RESUME) {
                resumeAnimation();
            }
        } else if (this.animator.isRunning()) {
            pauseAnimation();
            this.onVisibleAction = OnVisibleAction.RESUME;
        } else if (isVisible) {
            this.onVisibleAction = OnVisibleAction.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        playAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        endAnimation();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public boolean useTextGlyphs() {
        return this.fontMap == null && this.composition.getCharacters().size() > 0;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z5) {
        if (this.enableMergePaths == z5) {
            return;
        }
        this.enableMergePaths = z5;
        if (this.composition != null) {
            buildCompositionLayer();
        }
    }

    private void convertRect(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void draw(Canvas canvas, Matrix matrix) {
        CompositionLayer compositionLayer = this.compositionLayer;
        LottieComposition lottieComposition = this.composition;
        if (compositionLayer == null || lottieComposition == null) {
            return;
        }
        if (this.useSoftwareRendering) {
            canvas.save();
            canvas.concat(matrix);
            renderAndDrawAsBitmap(canvas, compositionLayer);
            canvas.restore();
        } else {
            compositionLayer.draw(canvas, matrix, this.alpha);
        }
        this.isDirty = false;
    }
}
