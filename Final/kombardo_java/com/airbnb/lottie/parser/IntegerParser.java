package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes.dex */
public class IntegerParser implements ValueParser<Integer> {
    public static final IntegerParser INSTANCE = new IntegerParser();

    private IntegerParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public Integer parse(JsonReader jsonReader, float f5) {
        return Integer.valueOf(Math.round(JsonUtils.valueFromObject(jsonReader) * f5));
    }
}
