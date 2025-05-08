package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final float POLYGON_MAGIC_NUMBER = 0.25f;
    private static final float POLYSTAR_MAGIC_NUMBER = 0.47829f;
    private final boolean hidden;
    private final BaseKeyframeAnimation<?, Float> innerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> innerRoundednessAnimation;
    private boolean isPathValid;
    private final boolean isReversed;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, Float> outerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> outerRoundednessAnimation;
    private final BaseKeyframeAnimation<?, Float> pointsAnimation;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, Float> rotationAnimation;
    private final PolystarShape.Type type;
    private final Path path = new Path();
    private final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    /* renamed from: com.airbnb.lottie.animation.content.PolystarContent$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.lottieDrawable = lottieDrawable;
        this.name = polystarShape.getName();
        PolystarShape.Type type = polystarShape.getType();
        this.type = type;
        this.hidden = polystarShape.isHidden();
        this.isReversed = polystarShape.isReversed();
        BaseKeyframeAnimation<Float, Float> createAnimation = polystarShape.getPoints().createAnimation();
        this.pointsAnimation = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = polystarShape.getPosition().createAnimation();
        this.positionAnimation = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = polystarShape.getRotation().createAnimation();
        this.rotationAnimation = createAnimation3;
        BaseKeyframeAnimation<Float, Float> createAnimation4 = polystarShape.getOuterRadius().createAnimation();
        this.outerRadiusAnimation = createAnimation4;
        BaseKeyframeAnimation<Float, Float> createAnimation5 = polystarShape.getOuterRoundedness().createAnimation();
        this.outerRoundednessAnimation = createAnimation5;
        PolystarShape.Type type2 = PolystarShape.Type.STAR;
        if (type == type2) {
            this.innerRadiusAnimation = polystarShape.getInnerRadius().createAnimation();
            this.innerRoundednessAnimation = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        baseLayer.addAnimation(createAnimation4);
        baseLayer.addAnimation(createAnimation5);
        if (type == type2) {
            baseLayer.addAnimation(this.innerRadiusAnimation);
            baseLayer.addAnimation(this.innerRoundednessAnimation);
        }
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
        createAnimation4.addUpdateListener(this);
        createAnimation5.addUpdateListener(this);
        if (type == type2) {
            this.innerRadiusAnimation.addUpdateListener(this);
            this.innerRoundednessAnimation.addUpdateListener(this);
        }
    }

    private void createPolygonPath() {
        int i5;
        double d5;
        double d6;
        double d7;
        int floor = (int) Math.floor(this.pointsAnimation.getValue().floatValue());
        double radians = Math.toRadians((this.rotationAnimation == null ? 0.0d : r2.getValue().floatValue()) - 90.0d);
        double d8 = floor;
        float floatValue = this.outerRoundednessAnimation.getValue().floatValue() / 100.0f;
        float floatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        double d9 = floatValue2;
        float cos = (float) (Math.cos(radians) * d9);
        float sin = (float) (Math.sin(radians) * d9);
        this.path.moveTo(cos, sin);
        double d10 = (float) (6.283185307179586d / d8);
        double d11 = radians + d10;
        double ceil = Math.ceil(d8);
        int i6 = 0;
        while (i6 < ceil) {
            float cos2 = (float) (Math.cos(d11) * d9);
            double d12 = ceil;
            float sin2 = (float) (d9 * Math.sin(d11));
            if (floatValue != 0.0f) {
                d6 = d9;
                i5 = i6;
                d5 = d11;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                d7 = d10;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float cos4 = (float) Math.cos(atan22);
                float sin4 = (float) Math.sin(atan22);
                float f5 = floatValue2 * floatValue * POLYGON_MAGIC_NUMBER;
                this.path.cubicTo(cos - (cos3 * f5), sin - (sin3 * f5), cos2 + (cos4 * f5), sin2 + (f5 * sin4), cos2, sin2);
            } else {
                i5 = i6;
                d5 = d11;
                d6 = d9;
                d7 = d10;
                this.path.lineTo(cos2, sin2);
            }
            d11 = d5 + d7;
            i6 = i5 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d12;
            d9 = d6;
            d10 = d7;
        }
        PointF value = this.positionAnimation.getValue();
        this.path.offset(value.x, value.y);
        this.path.close();
    }

    private void createStarPath() {
        int i5;
        float f5;
        float f6;
        double d5;
        float f7;
        float f8;
        float f9;
        float f10;
        double d6;
        float f11;
        float f12;
        float f13;
        double d7;
        float floatValue = this.pointsAnimation.getValue().floatValue();
        double radians = Math.toRadians((this.rotationAnimation == null ? 0.0d : r2.getValue().floatValue()) - 90.0d);
        double d8 = floatValue;
        float f14 = (float) (6.283185307179586d / d8);
        if (this.isReversed) {
            f14 *= -1.0f;
        }
        float f15 = f14 / 2.0f;
        float f16 = floatValue - ((int) floatValue);
        int i6 = (f16 > 0.0f ? 1 : (f16 == 0.0f ? 0 : -1));
        if (i6 != 0) {
            radians += (1.0f - f16) * f15;
        }
        float floatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        float floatValue3 = this.innerRadiusAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.innerRoundednessAnimation;
        float floatValue4 = baseKeyframeAnimation != null ? baseKeyframeAnimation.getValue().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.outerRoundednessAnimation;
        float floatValue5 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.getValue().floatValue() / 100.0f : 0.0f;
        if (i6 != 0) {
            f8 = ((floatValue2 - floatValue3) * f16) + floatValue3;
            i5 = i6;
            double d9 = f8;
            float cos = (float) (d9 * Math.cos(radians));
            f7 = (float) (d9 * Math.sin(radians));
            this.path.moveTo(cos, f7);
            d5 = radians + ((f14 * f16) / 2.0f);
            f5 = cos;
            f6 = f15;
        } else {
            i5 = i6;
            double d10 = floatValue2;
            float cos2 = (float) (Math.cos(radians) * d10);
            float sin = (float) (d10 * Math.sin(radians));
            this.path.moveTo(cos2, sin);
            f5 = cos2;
            f6 = f15;
            d5 = radians + f6;
            f7 = sin;
            f8 = 0.0f;
        }
        double ceil = Math.ceil(d8) * 2.0d;
        int i7 = 0;
        float f17 = f6;
        float f18 = f5;
        boolean z5 = false;
        while (true) {
            double d11 = i7;
            if (d11 >= ceil) {
                PointF value = this.positionAnimation.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
            float f19 = z5 ? floatValue2 : floatValue3;
            if (f8 == 0.0f || d11 != ceil - 2.0d) {
                f9 = f14;
                f10 = f17;
            } else {
                f9 = f14;
                f10 = (f14 * f16) / 2.0f;
            }
            if (f8 == 0.0f || d11 != ceil - 1.0d) {
                d6 = d11;
                f11 = f8;
                f8 = f19;
            } else {
                d6 = d11;
                f11 = f8;
            }
            double d12 = f8;
            double d13 = ceil;
            float cos3 = (float) (d12 * Math.cos(d5));
            float sin2 = (float) (d12 * Math.sin(d5));
            if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                this.path.lineTo(cos3, sin2);
                d7 = d5;
                f12 = floatValue4;
                f13 = floatValue5;
            } else {
                f12 = floatValue4;
                double atan2 = (float) (Math.atan2(f7, f18) - 1.5707963267948966d);
                float cos4 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                f13 = floatValue5;
                d7 = d5;
                double atan22 = (float) (Math.atan2(sin2, cos3) - 1.5707963267948966d);
                float cos5 = (float) Math.cos(atan22);
                float sin4 = (float) Math.sin(atan22);
                float f20 = z5 ? f12 : f13;
                float f21 = z5 ? f13 : f12;
                float f22 = z5 ? floatValue3 : floatValue2;
                float f23 = z5 ? floatValue2 : floatValue3;
                float f24 = f22 * f20 * POLYSTAR_MAGIC_NUMBER;
                float f25 = cos4 * f24;
                float f26 = f24 * sin3;
                float f27 = f23 * f21 * POLYSTAR_MAGIC_NUMBER;
                float f28 = cos5 * f27;
                float f29 = f27 * sin4;
                if (i5 != 0) {
                    if (i7 == 0) {
                        f25 *= f16;
                        f26 *= f16;
                    } else if (d6 == d13 - 1.0d) {
                        f28 *= f16;
                        f29 *= f16;
                    }
                }
                this.path.cubicTo(f18 - f25, f7 - f26, cos3 + f28, sin2 + f29, cos3, sin2);
            }
            d5 = d7 + f10;
            z5 = !z5;
            i7++;
            f18 = cos3;
            f7 = sin2;
            floatValue5 = f13;
            floatValue4 = f12;
            f8 = f11;
            f14 = f9;
            ceil = d13;
        }
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t5, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t5 == LottieProperty.POLYSTAR_POINTS) {
            this.pointsAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t5 == LottieProperty.POLYSTAR_ROTATION) {
            this.rotationAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t5 == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t5 == LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation2 = this.innerRadiusAnimation) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
            return;
        }
        if (t5 == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.outerRadiusAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t5 == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation = this.innerRoundednessAnimation) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        } else if (t5 == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.outerRoundednessAnimation.setValueCallback(lottieValueCallback);
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
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        int i5 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[this.type.ordinal()];
        if (i5 == 1) {
            createStarPath();
        } else if (i5 == 2) {
            createPolygonPath();
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
        }
    }
}
