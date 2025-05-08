package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class AnimatablePathValueParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("k", "x", "y");

    public static AnimatablePathValue parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(PathKeyframeParser.parse(jsonReader, lottieComposition));
            }
            jsonReader.endArray();
            KeyframesParser.setEndFrames(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.jsonToPoint(jsonReader, Utils.dpScale())));
        }
        return new AnimatablePathValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableValue<PointF, PointF> parseSplitPath(JsonReader jsonReader, LottieComposition lottieComposition) {
        jsonReader.beginObject();
        AnimatablePathValue animatablePathValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        boolean z5 = false;
        AnimatableFloatValue animatableFloatValue2 = null;
        while (jsonReader.peek() != JsonReader.Token.END_OBJECT) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                animatablePathValue = parse(jsonReader, lottieComposition);
            } else if (selectName != 1) {
                if (selectName != 2) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else if (jsonReader.peek() == JsonReader.Token.STRING) {
                    jsonReader.skipValue();
                    z5 = true;
                } else {
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                }
            } else if (jsonReader.peek() == JsonReader.Token.STRING) {
                jsonReader.skipValue();
                z5 = true;
            } else {
                animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            }
        }
        jsonReader.endObject();
        if (z5) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
        }
        return animatablePathValue != null ? animatablePathValue : new AnimatableSplitDimensionPathValue(animatableFloatValue2, animatableFloatValue);
    }
}
