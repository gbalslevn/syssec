package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes.dex */
abstract class MergePathsParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "mm", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MergePaths parse(JsonReader jsonReader) {
        String str = null;
        boolean z5 = false;
        MergePaths.MergePathsMode mergePathsMode = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.nextInt());
            } else if (selectName != 2) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                z5 = jsonReader.nextBoolean();
            }
        }
        return new MergePaths(str, mergePathsMode, z5);
    }
}
