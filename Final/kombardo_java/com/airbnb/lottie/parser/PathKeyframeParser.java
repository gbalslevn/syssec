package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;

/* loaded from: classes.dex */
abstract class PathKeyframeParser {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static PathKeyframe parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new PathKeyframe(lottieComposition, KeyframeParser.parse(jsonReader, lottieComposition, Utils.dpScale(), PathParser.INSTANCE, jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT, false));
    }
}
