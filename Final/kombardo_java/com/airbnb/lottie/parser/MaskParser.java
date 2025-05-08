package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class MaskParser {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Mask parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        boolean z5;
        boolean z6;
        jsonReader.beginObject();
        Mask.MaskMode maskMode = null;
        AnimatableShapeValue animatableShapeValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        boolean z7 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName.hashCode()) {
                case 111:
                    if (nextName.equals("o")) {
                        z5 = false;
                        break;
                    }
                    break;
                case 3588:
                    if (nextName.equals("pt")) {
                        z5 = true;
                        break;
                    }
                    break;
                case 104433:
                    if (nextName.equals("inv")) {
                        z5 = 2;
                        break;
                    }
                    break;
                case 3357091:
                    if (nextName.equals("mode")) {
                        z5 = 3;
                        break;
                    }
                    break;
            }
            z5 = -1;
            switch (z5) {
                case false:
                    animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    break;
                case true:
                    animatableShapeValue = AnimatableValueParser.parseShapeData(jsonReader, lottieComposition);
                    break;
                case true:
                    z7 = jsonReader.nextBoolean();
                    break;
                case true:
                    String nextString = jsonReader.nextString();
                    nextString.hashCode();
                    switch (nextString.hashCode()) {
                        case 97:
                            if (nextString.equals("a")) {
                                z6 = false;
                                break;
                            }
                            break;
                        case 105:
                            if (nextString.equals("i")) {
                                z6 = true;
                                break;
                            }
                            break;
                        case 110:
                            if (nextString.equals("n")) {
                                z6 = 2;
                                break;
                            }
                            break;
                        case 115:
                            if (nextString.equals("s")) {
                                z6 = 3;
                                break;
                            }
                            break;
                    }
                    z6 = -1;
                    switch (z6) {
                        case false:
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                        case true:
                            lottieComposition.addWarning("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                            break;
                        case true:
                            maskMode = Mask.MaskMode.MASK_MODE_NONE;
                            break;
                        case true:
                            maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            Logger.warning("Unknown mask mode " + nextName + ". Defaulting to Add.");
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new Mask(maskMode, animatableShapeValue, animatableIntegerValue, z7);
    }
}
