package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class CircleShapeParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "p", "s", "hd", "d");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CircleShape parse(JsonReader jsonReader, LottieComposition lottieComposition, int i5) {
        boolean z5 = i5 == 3;
        boolean z6 = false;
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                animatableValue = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
            } else if (selectName == 2) {
                animatablePointValue = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
            } else if (selectName == 3) {
                z6 = jsonReader.nextBoolean();
            } else if (selectName != 4) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                z5 = jsonReader.nextInt() == 3;
            }
        }
        return new CircleShape(str, animatableValue, animatablePointValue, z5, z6);
    }
}
