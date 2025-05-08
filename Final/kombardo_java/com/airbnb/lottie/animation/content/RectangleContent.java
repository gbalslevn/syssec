package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public class RectangleContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, PathContent {
    private final BaseKeyframeAnimation<?, Float> cornerRadiusAnimation;
    private final boolean hidden;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    private final Path path = new Path();
    private final RectF rect = new RectF();
    private final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();
    private BaseKeyframeAnimation<Float, Float> roundedCornersAnimation = null;

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RectangleShape rectangleShape) {
        this.name = rectangleShape.getName();
        this.hidden = rectangleShape.isHidden();
        this.lottieDrawable = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> createAnimation = rectangleShape.getPosition().createAnimation();
        this.positionAnimation = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = rectangleShape.getSize().createAnimation();
        this.sizeAnimation = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = rectangleShape.getCornerRadius().createAnimation();
        this.cornerRadiusAnimation = createAnimation3;
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t5, LottieValueCallback<T> lottieValueCallback) {
        if (t5 == LottieProperty.RECTANGLE_SIZE) {
            this.sizeAnimation.setValueCallback(lottieValueCallback);
        } else if (t5 == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
        } else if (t5 == LottieProperty.CORNER_RADIUS) {
            this.cornerRadiusAnimation.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        PointF value = this.sizeAnimation.getValue();
        float f5 = value.x / 2.0f;
        float f6 = value.y / 2.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.cornerRadiusAnimation;
        float floatValue = baseKeyframeAnimation2 == null ? 0.0f : ((FloatKeyframeAnimation) baseKeyframeAnimation2).getFloatValue();
        if (floatValue == 0.0f && (baseKeyframeAnimation = this.roundedCornersAnimation) != null) {
            floatValue = Math.min(baseKeyframeAnimation.getValue().floatValue(), Math.min(f5, f6));
        }
        float min = Math.min(f5, f6);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF value2 = this.positionAnimation.getValue();
        this.path.moveTo(value2.x + f5, (value2.y - f6) + floatValue);
        this.path.lineTo(value2.x + f5, (value2.y + f6) - floatValue);
        if (floatValue > 0.0f) {
            RectF rectF = this.rect;
            float f7 = value2.x;
            float f8 = floatValue * 2.0f;
            float f9 = value2.y;
            rectF.set((f7 + f5) - f8, (f9 + f6) - f8, f7 + f5, f9 + f6);
            this.path.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.path.lineTo((value2.x - f5) + floatValue, value2.y + f6);
        if (floatValue > 0.0f) {
            RectF rectF2 = this.rect;
            float f10 = value2.x;
            float f11 = value2.y;
            float f12 = floatValue * 2.0f;
            rectF2.set(f10 - f5, (f11 + f6) - f12, (f10 - f5) + f12, f11 + f6);
            this.path.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.path.lineTo(value2.x - f5, (value2.y - f6) + floatValue);
        if (floatValue > 0.0f) {
            RectF rectF3 = this.rect;
            float f13 = value2.x;
            float f14 = value2.y;
            float f15 = floatValue * 2.0f;
            rectF3.set(f13 - f5, f14 - f6, (f13 - f5) + f15, (f14 - f6) + f15);
            this.path.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.path.lineTo((value2.x + f5) - floatValue, value2.y - f6);
        if (floatValue > 0.0f) {
            RectF rectF4 = this.rect;
            float f16 = value2.x;
            float f17 = floatValue * 2.0f;
            float f18 = value2.y;
            rectF4.set((f16 + f5) - f17, f18 - f6, f16 + f5, (f18 - f6) + f17);
            this.path.arcTo(this.rect, 270.0f, 90.0f, false);
        }
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidate();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i5, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i5, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            Content content = list.get(i5);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.trimPaths.addTrimPath(trimPathContent);
                    trimPathContent.addListener(this);
                }
            }
            if (content instanceof RoundedCornersContent) {
                this.roundedCornersAnimation = ((RoundedCornersContent) content).getRoundedCorners();
            }
        }
    }
}
