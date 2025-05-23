package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;

/* loaded from: classes.dex */
public abstract class AnimatableTransformParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");
    private static final JsonReader.Options ANIMATABLE_NAMES = JsonReader.Options.of("k");

    private static boolean isAnchorPointIdentity(AnimatablePathValue animatablePathValue) {
        return animatablePathValue == null || (animatablePathValue.isStatic() && animatablePathValue.getKeyframes().get(0).startValue.equals(0.0f, 0.0f));
    }

    private static boolean isPositionIdentity(AnimatableValue<PointF, PointF> animatableValue) {
        return animatableValue == null || (!(animatableValue instanceof AnimatableSplitDimensionPathValue) && animatableValue.isStatic() && animatableValue.getKeyframes().get(0).startValue.equals(0.0f, 0.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isRotationIdentity(AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.isStatic() && ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isScaleIdentity(AnimatableScaleValue animatableScaleValue) {
        return animatableScaleValue == null || (animatableScaleValue.isStatic() && ((ScaleXY) ((Keyframe) animatableScaleValue.getKeyframes().get(0)).startValue).equals(1.0f, 1.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isSkewAngleIdentity(AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.isStatic() && ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isSkewIdentity(AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.isStatic() && ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f);
    }

    public static AnimatableTransform parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        boolean z5;
        boolean z6 = false;
        boolean z7 = jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT;
        if (z7) {
            jsonReader.beginObject();
        }
        AnimatableFloatValue animatableFloatValue = null;
        AnimatablePathValue animatablePathValue = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatableScaleValue animatableScaleValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatableFloatValue animatableFloatValue4 = null;
        AnimatableFloatValue animatableFloatValue5 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    boolean z8 = z6;
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.selectName(ANIMATABLE_NAMES) != 0) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            animatablePathValue = AnimatablePathValueParser.parse(jsonReader, lottieComposition);
                        }
                    }
                    jsonReader.endObject();
                    z6 = z8;
                    continue;
                case 1:
                    animatableValue = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
                    continue;
                case 2:
                    animatableScaleValue = AnimatableValueParser.parseScale(jsonReader, lottieComposition);
                    continue;
                case 3:
                    lottieComposition.addWarning("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    continue;
                case 6:
                    animatableFloatValue4 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z6);
                    continue;
                case 7:
                    animatableFloatValue5 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z6);
                    continue;
                case 8:
                    animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z6);
                    continue;
                case 9:
                    animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z6);
                    continue;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue;
            }
            AnimatableFloatValue parseFloat = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z6);
            if (parseFloat.getKeyframes().isEmpty()) {
                parseFloat.getKeyframes().add(new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.getEndFrame())));
            } else if (((Keyframe) parseFloat.getKeyframes().get(0)).startValue == 0) {
                z5 = false;
                parseFloat.getKeyframes().set(0, new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.getEndFrame())));
                z6 = z5;
                animatableFloatValue = parseFloat;
            }
            z5 = false;
            z6 = z5;
            animatableFloatValue = parseFloat;
        }
        if (z7) {
            jsonReader.endObject();
        }
        AnimatablePathValue animatablePathValue2 = isAnchorPointIdentity(animatablePathValue) ? null : animatablePathValue;
        AnimatableValue<PointF, PointF> animatableValue2 = isPositionIdentity(animatableValue) ? null : animatableValue;
        AnimatableFloatValue animatableFloatValue6 = isRotationIdentity(animatableFloatValue) ? null : animatableFloatValue;
        if (isScaleIdentity(animatableScaleValue)) {
            animatableScaleValue = null;
        }
        return new AnimatableTransform(animatablePathValue2, animatableValue2, animatableScaleValue, animatableFloatValue6, animatableIntegerValue, animatableFloatValue4, animatableFloatValue5, isSkewIdentity(animatableFloatValue2) ? null : animatableFloatValue2, isSkewAngleIdentity(animatableFloatValue3) ? null : animatableFloatValue3);
    }
}
