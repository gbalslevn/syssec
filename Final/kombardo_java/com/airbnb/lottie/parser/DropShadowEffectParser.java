package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public class DropShadowEffectParser {
    private static final JsonReader.Options DROP_SHADOW_EFFECT_NAMES = JsonReader.Options.of("ef");
    private static final JsonReader.Options INNER_EFFECT_NAMES = JsonReader.Options.of("nm", "v");
    private AnimatableColorValue color;
    private AnimatableFloatValue direction;
    private AnimatableFloatValue distance;
    private AnimatableFloatValue opacity;
    private AnimatableFloatValue radius;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
    
        switch(r3) {
            case 0: goto L50;
            case 1: goto L49;
            case 2: goto L48;
            case 3: goto L47;
            case 4: goto L46;
            default: goto L51;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        r5.radius = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006e, code lost:
    
        r5.color = com.airbnb.lottie.parser.AnimatableValueParser.parseColor(r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0075, code lost:
    
        r5.direction = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(r6, r7, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007c, code lost:
    
        r5.opacity = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(r6, r7, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
    
        r5.distance = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0063, code lost:
    
        r6.skipValue();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void maybeParseInnerEffect(JsonReader jsonReader, LottieComposition lottieComposition) {
        jsonReader.beginObject();
        String str = BuildConfig.FLAVOR;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(INNER_EFFECT_NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                str.hashCode();
                char c5 = 65535;
                switch (str.hashCode()) {
                    case 353103893:
                        if (str.equals("Distance")) {
                            c5 = 0;
                            break;
                        }
                        break;
                    case 397447147:
                        if (str.equals("Opacity")) {
                            c5 = 1;
                            break;
                        }
                        break;
                    case 1041377119:
                        if (str.equals("Direction")) {
                            c5 = 2;
                            break;
                        }
                        break;
                    case 1379387491:
                        if (str.equals("Shadow Color")) {
                            c5 = 3;
                            break;
                        }
                        break;
                    case 1383710113:
                        if (str.equals("Softness")) {
                            c5 = 4;
                            break;
                        }
                        break;
                }
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DropShadowEffect parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        AnimatableFloatValue animatableFloatValue;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableFloatValue animatableFloatValue3;
        AnimatableFloatValue animatableFloatValue4;
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(DROP_SHADOW_EFFECT_NAMES) != 0) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    maybeParseInnerEffect(jsonReader, lottieComposition);
                }
                jsonReader.endArray();
            }
        }
        AnimatableColorValue animatableColorValue = this.color;
        if (animatableColorValue == null || (animatableFloatValue = this.opacity) == null || (animatableFloatValue2 = this.direction) == null || (animatableFloatValue3 = this.distance) == null || (animatableFloatValue4 = this.radius) == null) {
            return null;
        }
        return new DropShadowEffect(animatableColorValue, animatableFloatValue, animatableFloatValue2, animatableFloatValue3, animatableFloatValue4);
    }
}
