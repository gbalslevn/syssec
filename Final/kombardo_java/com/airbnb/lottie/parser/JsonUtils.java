package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
abstract class JsonUtils {
    private static final JsonReader.Options POINT_NAMES = JsonReader.Options.of("x", "y");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.parser.JsonUtils$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PointF jsonArrayToPoint(JsonReader jsonReader, float f5) {
        jsonReader.beginArray();
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != JsonReader.Token.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(nextDouble * f5, nextDouble2 * f5);
    }

    private static PointF jsonNumbersToPoint(JsonReader jsonReader, float f5) {
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(nextDouble * f5, nextDouble2 * f5);
    }

    private static PointF jsonObjectToPoint(JsonReader jsonReader, float f5) {
        jsonReader.beginObject();
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(POINT_NAMES);
            if (selectName == 0) {
                f6 = valueFromObject(jsonReader);
            } else if (selectName != 1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                f7 = valueFromObject(jsonReader);
            }
        }
        jsonReader.endObject();
        return new PointF(f6 * f5, f7 * f5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int jsonToColor(JsonReader jsonReader) {
        jsonReader.beginArray();
        int nextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(Function.USE_VARARGS, nextDouble, nextDouble2, nextDouble3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF jsonToPoint(JsonReader jsonReader, float f5) {
        int i5 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[jsonReader.peek().ordinal()];
        if (i5 == 1) {
            return jsonNumbersToPoint(jsonReader, f5);
        }
        if (i5 == 2) {
            return jsonArrayToPoint(jsonReader, f5);
        }
        if (i5 == 3) {
            return jsonObjectToPoint(jsonReader, f5);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<PointF> jsonToPoints(JsonReader jsonReader, float f5) {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(jsonToPoint(jsonReader, f5));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float valueFromObject(JsonReader jsonReader) {
        JsonReader.Token peek = jsonReader.peek();
        int i5 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[peek.ordinal()];
        if (i5 == 1) {
            return (float) jsonReader.nextDouble();
        }
        if (i5 != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + peek);
        }
        jsonReader.beginArray();
        float nextDouble = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return nextDouble;
    }
}
