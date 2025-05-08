package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public class EllipseContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final float ELLIPSE_CONTROL_POINT_PERCENTAGE = 0.55228f;
    private final CircleShape circleShape;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    private final Path path = new Path();
    private final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    public EllipseContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, CircleShape circleShape) {
        this.name = circleShape.getName();
        this.lottieDrawable = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> createAnimation = circleShape.getSize().createAnimation();
        this.sizeAnimation = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = circleShape.getPosition().createAnimation();
        this.positionAnimation = createAnimation2;
        this.circleShape = circleShape;
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t5, LottieValueCallback<T> lottieValueCallback) {
        if (t5 == LottieProperty.ELLIPSE_SIZE) {
            this.sizeAnimation.setValueCallback(lottieValueCallback);
        } else if (t5 == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.circleShape.isHidden()) {
            this.isPathValid = true;
            return this.path;
        }
        PointF value = this.sizeAnimation.getValue();
        float f5 = value.x / 2.0f;
        float f6 = value.y / 2.0f;
        float f7 = f5 * ELLIPSE_CONTROL_POINT_PERCENTAGE;
        float f8 = ELLIPSE_CONTROL_POINT_PERCENTAGE * f6;
        this.path.reset();
        if (this.circleShape.isReversed()) {
            float f9 = -f6;
            this.path.moveTo(0.0f, f9);
            float f10 = 0.0f - f7;
            float f11 = -f5;
            float f12 = 0.0f - f8;
            this.path.cubicTo(f10, f9, f11, f12, f11, 0.0f);
            float f13 = f8 + 0.0f;
            this.path.cubicTo(f11, f13, f10, f6, 0.0f, f6);
            float f14 = f7 + 0.0f;
            this.path.cubicTo(f14, f6, f5, f13, f5, 0.0f);
            this.path.cubicTo(f5, f12, f14, f9, 0.0f, f9);
        } else {
            float f15 = -f6;
            this.path.moveTo(0.0f, f15);
            float f16 = f7 + 0.0f;
            float f17 = 0.0f - f8;
            this.path.cubicTo(f16, f15, f5, f17, f5, 0.0f);
            float f18 = f8 + 0.0f;
            this.path.cubicTo(f5, f18, f16, f6, 0.0f, f6);
            float f19 = 0.0f - f7;
            float f20 = -f5;
            this.path.cubicTo(f19, f6, f20, f18, f20, 0.0f);
            this.path.cubicTo(f20, f17, f19, f15, 0.0f, f15);
        }
        PointF value2 = this.positionAnimation.getValue();
        this.path.offset(value2.x, value2.y);
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
        }
    }
}
