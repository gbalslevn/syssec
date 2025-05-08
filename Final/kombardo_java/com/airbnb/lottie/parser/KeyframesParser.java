package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
abstract class KeyframesParser {
    static JsonReader.Options NAMES = JsonReader.Options.of("k");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<Keyframe<T>> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f5, ValueParser<T> valueParser, boolean z5) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonReader.Token.STRING) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(NAMES) != 0) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonReader.Token.NUMBER) {
                    arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f5, valueParser, false, z5));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f5, valueParser, true, z5));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f5, valueParser, false, z5));
            }
        }
        jsonReader.endObject();
        setEndFrames(arrayList);
        return arrayList;
    }

    public static <T> void setEndFrames(List<? extends Keyframe<T>> list) {
        int i5;
        T t5;
        int size = list.size();
        int i6 = 0;
        while (true) {
            i5 = size - 1;
            if (i6 >= i5) {
                break;
            }
            Keyframe<T> keyframe = list.get(i6);
            i6++;
            Keyframe<T> keyframe2 = list.get(i6);
            keyframe.endFrame = Float.valueOf(keyframe2.startFrame);
            if (keyframe.endValue == null && (t5 = keyframe2.startValue) != null) {
                keyframe.endValue = t5;
                if (keyframe instanceof PathKeyframe) {
                    ((PathKeyframe) keyframe).createPath();
                }
            }
        }
        Keyframe<T> keyframe3 = list.get(i5);
        if ((keyframe3.startValue == null || keyframe3.endValue == null) && list.size() > 1) {
            list.remove(keyframe3);
        }
    }
}
