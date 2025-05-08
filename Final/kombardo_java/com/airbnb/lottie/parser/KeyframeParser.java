package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
abstract class KeyframeParser {
    private static final float MAX_CP_VALUE = 100.0f;
    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    static JsonReader.Options NAMES = JsonReader.Options.of("t", "s", "e", "o", "i", "h", "to", "ti");
    static JsonReader.Options INTERPOLATOR_NAMES = JsonReader.Options.of("x", "y");

    private static WeakReference<Interpolator> getInterpolator(int i5) {
        WeakReference<Interpolator> weakReference;
        synchronized (KeyframeParser.class) {
            weakReference = pathInterpolatorCache().get(i5);
        }
        return weakReference;
    }

    private static Interpolator interpolatorFor(PointF pointF, PointF pointF2) {
        Interpolator create;
        pointF.x = MiscUtils.clamp(pointF.x, -1.0f, 1.0f);
        pointF.y = MiscUtils.clamp(pointF.y, -100.0f, MAX_CP_VALUE);
        pointF2.x = MiscUtils.clamp(pointF2.x, -1.0f, 1.0f);
        float clamp = MiscUtils.clamp(pointF2.y, -100.0f, MAX_CP_VALUE);
        pointF2.y = clamp;
        int hashFor = Utils.hashFor(pointF.x, pointF.y, pointF2.x, clamp);
        WeakReference<Interpolator> interpolator = L.getDisablePathInterpolatorCache() ? null : getInterpolator(hashFor);
        Interpolator interpolator2 = interpolator != null ? interpolator.get() : null;
        if (interpolator == null || interpolator2 == null) {
            try {
                create = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e5) {
                create = "The Path cannot loop back on itself.".equals(e5.getMessage()) ? PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
            }
            interpolator2 = create;
            if (!L.getDisablePathInterpolatorCache()) {
                try {
                    putInterpolator(hashFor, new WeakReference(interpolator2));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Keyframe<T> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f5, ValueParser<T> valueParser, boolean z5, boolean z6) {
        return (z5 && z6) ? parseMultiDimensionalKeyframe(lottieComposition, jsonReader, f5, valueParser) : z5 ? parseKeyframe(lottieComposition, jsonReader, f5, valueParser) : parseStaticValue(jsonReader, f5, valueParser);
    }

    private static <T> Keyframe<T> parseKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f5, ValueParser<T> valueParser) {
        Interpolator interpolatorFor;
        T t5;
        jsonReader.beginObject();
        PointF pointF = null;
        T t6 = null;
        T t7 = null;
        PointF pointF2 = null;
        PointF pointF3 = null;
        float f6 = 0.0f;
        boolean z5 = false;
        PointF pointF4 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    f6 = (float) jsonReader.nextDouble();
                    break;
                case 1:
                    t7 = valueParser.parse(jsonReader, f5);
                    break;
                case 2:
                    t6 = valueParser.parse(jsonReader, f5);
                    break;
                case 3:
                    pointF = JsonUtils.jsonToPoint(jsonReader, 1.0f);
                    break;
                case 4:
                    pointF4 = JsonUtils.jsonToPoint(jsonReader, 1.0f);
                    break;
                case 5:
                    if (jsonReader.nextInt() != 1) {
                        z5 = false;
                        break;
                    } else {
                        z5 = true;
                        break;
                    }
                case 6:
                    pointF2 = JsonUtils.jsonToPoint(jsonReader, f5);
                    break;
                case 7:
                    pointF3 = JsonUtils.jsonToPoint(jsonReader, f5);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z5) {
            interpolatorFor = LINEAR_INTERPOLATOR;
            t5 = t7;
        } else {
            interpolatorFor = (pointF == null || pointF4 == null) ? LINEAR_INTERPOLATOR : interpolatorFor(pointF, pointF4);
            t5 = t6;
        }
        Keyframe<T> keyframe = new Keyframe<>(lottieComposition, t7, t5, interpolatorFor, f6, null);
        keyframe.pathCp1 = pointF2;
        keyframe.pathCp2 = pointF3;
        return keyframe;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0023. Please report as an issue. */
    private static <T> Keyframe<T> parseMultiDimensionalKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f5, ValueParser<T> valueParser) {
        Interpolator interpolator;
        Interpolator interpolatorFor;
        Interpolator interpolatorFor2;
        T t5;
        PointF pointF;
        Keyframe<T> keyframe;
        PointF pointF2;
        float f6;
        PointF pointF3;
        jsonReader.beginObject();
        PointF pointF4 = null;
        boolean z5 = false;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        T t6 = null;
        PointF pointF8 = null;
        PointF pointF9 = null;
        PointF pointF10 = null;
        float f7 = 0.0f;
        PointF pointF11 = null;
        T t7 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    pointF2 = pointF4;
                    f7 = (float) jsonReader.nextDouble();
                    pointF4 = pointF2;
                    break;
                case 1:
                    pointF2 = pointF4;
                    t6 = valueParser.parse(jsonReader, f5);
                    pointF4 = pointF2;
                    break;
                case 2:
                    pointF2 = pointF4;
                    t7 = valueParser.parse(jsonReader, f5);
                    pointF4 = pointF2;
                    break;
                case 3:
                    pointF2 = pointF4;
                    f6 = f7;
                    PointF pointF12 = pointF11;
                    if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float f8 = 0.0f;
                        float f9 = 0.0f;
                        float f10 = 0.0f;
                        float f11 = 0.0f;
                        while (jsonReader.hasNext()) {
                            int selectName = jsonReader.selectName(INTERPOLATOR_NAMES);
                            if (selectName == 0) {
                                JsonReader.Token peek = jsonReader.peek();
                                JsonReader.Token token = JsonReader.Token.NUMBER;
                                if (peek == token) {
                                    f10 = (float) jsonReader.nextDouble();
                                    f8 = f10;
                                } else {
                                    jsonReader.beginArray();
                                    f8 = (float) jsonReader.nextDouble();
                                    f10 = jsonReader.peek() == token ? (float) jsonReader.nextDouble() : f8;
                                    jsonReader.endArray();
                                }
                            } else if (selectName != 1) {
                                jsonReader.skipValue();
                            } else {
                                JsonReader.Token peek2 = jsonReader.peek();
                                JsonReader.Token token2 = JsonReader.Token.NUMBER;
                                if (peek2 == token2) {
                                    f11 = (float) jsonReader.nextDouble();
                                    f9 = f11;
                                } else {
                                    jsonReader.beginArray();
                                    f9 = (float) jsonReader.nextDouble();
                                    f11 = jsonReader.peek() == token2 ? (float) jsonReader.nextDouble() : f9;
                                    jsonReader.endArray();
                                }
                            }
                        }
                        PointF pointF13 = new PointF(f8, f9);
                        PointF pointF14 = new PointF(f10, f11);
                        jsonReader.endObject();
                        pointF8 = pointF14;
                        pointF7 = pointF13;
                        pointF11 = pointF12;
                        f7 = f6;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF5 = JsonUtils.jsonToPoint(jsonReader, f5);
                        f7 = f6;
                        pointF11 = pointF12;
                        pointF4 = pointF2;
                    }
                case 4:
                    if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float f12 = 0.0f;
                        float f13 = 0.0f;
                        float f14 = 0.0f;
                        float f15 = 0.0f;
                        while (jsonReader.hasNext()) {
                            PointF pointF15 = pointF11;
                            int selectName2 = jsonReader.selectName(INTERPOLATOR_NAMES);
                            if (selectName2 != 0) {
                                pointF3 = pointF4;
                                if (selectName2 != 1) {
                                    jsonReader.skipValue();
                                } else {
                                    JsonReader.Token peek3 = jsonReader.peek();
                                    JsonReader.Token token3 = JsonReader.Token.NUMBER;
                                    if (peek3 == token3) {
                                        f15 = (float) jsonReader.nextDouble();
                                        f7 = f7;
                                        f13 = f15;
                                    } else {
                                        float f16 = f7;
                                        jsonReader.beginArray();
                                        float nextDouble = (float) jsonReader.nextDouble();
                                        float nextDouble2 = jsonReader.peek() == token3 ? (float) jsonReader.nextDouble() : nextDouble;
                                        jsonReader.endArray();
                                        f7 = f16;
                                        pointF11 = pointF15;
                                        pointF4 = pointF3;
                                        f15 = nextDouble2;
                                        f13 = nextDouble;
                                    }
                                }
                            } else {
                                pointF3 = pointF4;
                                float f17 = f7;
                                JsonReader.Token peek4 = jsonReader.peek();
                                JsonReader.Token token4 = JsonReader.Token.NUMBER;
                                if (peek4 == token4) {
                                    f14 = (float) jsonReader.nextDouble();
                                    f7 = f17;
                                    f12 = f14;
                                } else {
                                    jsonReader.beginArray();
                                    f12 = (float) jsonReader.nextDouble();
                                    f14 = jsonReader.peek() == token4 ? (float) jsonReader.nextDouble() : f12;
                                    jsonReader.endArray();
                                    f7 = f17;
                                }
                            }
                            pointF11 = pointF15;
                            pointF4 = pointF3;
                        }
                        pointF2 = pointF4;
                        f6 = f7;
                        PointF pointF16 = new PointF(f12, f13);
                        PointF pointF17 = new PointF(f14, f15);
                        jsonReader.endObject();
                        pointF10 = pointF17;
                        pointF9 = pointF16;
                        f7 = f6;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF2 = pointF4;
                        pointF6 = JsonUtils.jsonToPoint(jsonReader, f5);
                        pointF4 = pointF2;
                    }
                case 5:
                    if (jsonReader.nextInt() != 1) {
                        z5 = false;
                        break;
                    } else {
                        z5 = true;
                        break;
                    }
                case 6:
                    pointF11 = JsonUtils.jsonToPoint(jsonReader, f5);
                    break;
                case 7:
                    pointF4 = JsonUtils.jsonToPoint(jsonReader, f5);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        PointF pointF18 = pointF4;
        float f18 = f7;
        PointF pointF19 = pointF11;
        jsonReader.endObject();
        if (z5) {
            interpolator = LINEAR_INTERPOLATOR;
            t5 = t6;
        } else {
            if (pointF5 != null && pointF6 != null) {
                interpolator = interpolatorFor(pointF5, pointF6);
            } else {
                if (pointF7 != null && pointF8 != null && pointF9 != null && pointF10 != null) {
                    interpolatorFor = interpolatorFor(pointF7, pointF9);
                    interpolatorFor2 = interpolatorFor(pointF8, pointF10);
                    t5 = t7;
                    interpolator = null;
                    if (interpolatorFor != null || interpolatorFor2 == null) {
                        pointF = pointF19;
                        keyframe = new Keyframe<>(lottieComposition, t6, t5, interpolator, f18, null);
                    } else {
                        pointF = pointF19;
                        keyframe = new Keyframe<>(lottieComposition, t6, t5, interpolatorFor, interpolatorFor2, f18, null);
                    }
                    keyframe.pathCp1 = pointF;
                    keyframe.pathCp2 = pointF18;
                    return keyframe;
                }
                interpolator = LINEAR_INTERPOLATOR;
            }
            t5 = t7;
        }
        interpolatorFor = null;
        interpolatorFor2 = null;
        if (interpolatorFor != null) {
        }
        pointF = pointF19;
        keyframe = new Keyframe<>(lottieComposition, t6, t5, interpolator, f18, null);
        keyframe.pathCp1 = pointF;
        keyframe.pathCp2 = pointF18;
        return keyframe;
    }

    private static <T> Keyframe<T> parseStaticValue(JsonReader jsonReader, float f5, ValueParser<T> valueParser) {
        return new Keyframe<>(valueParser.parse(jsonReader, f5));
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache() {
        if (pathInterpolatorCache == null) {
            pathInterpolatorCache = new SparseArrayCompat<>();
        }
        return pathInterpolatorCache;
    }

    private static void putInterpolator(int i5, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser.class) {
            pathInterpolatorCache.put(i5, weakReference);
        }
    }
}
