package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class ShapeFillParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "c", "o", "fillEnabled", "r", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeFill parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        AnimatableIntegerValue animatableIntegerValue = null;
        String str = null;
        AnimatableColorValue animatableColorValue = null;
        boolean z5 = false;
        boolean z6 = false;
        int i5 = 1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                animatableColorValue = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
            } else if (selectName == 2) {
                animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
            } else if (selectName == 3) {
                z5 = jsonReader.nextBoolean();
            } else if (selectName == 4) {
                i5 = jsonReader.nextInt();
            } else if (selectName != 5) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                z6 = jsonReader.nextBoolean();
            }
        }
        if (animatableIntegerValue == null) {
            animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
        }
        return new ShapeFill(str, z5, i5 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, animatableColorValue, animatableIntegerValue, z6);
    }
}
