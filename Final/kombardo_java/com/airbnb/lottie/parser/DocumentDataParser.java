package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes.dex */
public class DocumentDataParser implements ValueParser<DocumentData> {
    public static final DocumentDataParser INSTANCE = new DocumentDataParser();
    private static final JsonReader.Options NAMES = JsonReader.Options.of("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz");

    private DocumentDataParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public DocumentData parse(JsonReader jsonReader, float f5) {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.beginObject();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        boolean z5 = true;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    str2 = jsonReader.nextString();
                    break;
                case 2:
                    f6 = (float) jsonReader.nextDouble();
                    break;
                case 3:
                    int nextInt = jsonReader.nextInt();
                    justification2 = DocumentData.Justification.CENTER;
                    if (nextInt <= justification2.ordinal() && nextInt >= 0) {
                        justification2 = DocumentData.Justification.values()[nextInt];
                        break;
                    }
                    break;
                case 4:
                    i5 = jsonReader.nextInt();
                    break;
                case 5:
                    f7 = (float) jsonReader.nextDouble();
                    break;
                case 6:
                    f8 = (float) jsonReader.nextDouble();
                    break;
                case 7:
                    i6 = JsonUtils.jsonToColor(jsonReader);
                    break;
                case 8:
                    i7 = JsonUtils.jsonToColor(jsonReader);
                    break;
                case 9:
                    f9 = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    z5 = jsonReader.nextBoolean();
                    break;
                case 11:
                    jsonReader.beginArray();
                    PointF pointF3 = new PointF(((float) jsonReader.nextDouble()) * f5, ((float) jsonReader.nextDouble()) * f5);
                    jsonReader.endArray();
                    pointF = pointF3;
                    break;
                case 12:
                    jsonReader.beginArray();
                    PointF pointF4 = new PointF(((float) jsonReader.nextDouble()) * f5, ((float) jsonReader.nextDouble()) * f5);
                    jsonReader.endArray();
                    pointF2 = pointF4;
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new DocumentData(str, str2, f6, justification2, i5, f7, f8, i6, i7, f9, z5, pointF, pointF2);
    }
}
