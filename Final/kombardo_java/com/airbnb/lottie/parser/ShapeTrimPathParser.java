package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes.dex */
abstract class ShapeTrimPathParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("s", "e", "o", "nm", "m", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeTrimPath parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        String str = null;
        ShapeTrimPath.Type type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        boolean z5 = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
            } else if (selectName == 1) {
                animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
            } else if (selectName == 2) {
                animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
            } else if (selectName == 3) {
                str = jsonReader.nextString();
            } else if (selectName == 4) {
                type = ShapeTrimPath.Type.forId(jsonReader.nextInt());
            } else if (selectName != 5) {
                jsonReader.skipValue();
            } else {
                z5 = jsonReader.nextBoolean();
            }
        }
        return new ShapeTrimPath(str, type, animatableFloatValue, animatableFloatValue2, animatableFloatValue3, z5);
    }
}
