package io.michaelrocks.libphonenumber.android.metadata.source;

import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class MultiFileModeFileNameProvider implements PhoneMetadataFileNameProvider {
    private static final Pattern ALPHANUMERIC = Pattern.compile("^[\\p{L}\\p{N}]+$");
    private final String phoneMetadataFileNamePrefix;

    public MultiFileModeFileNameProvider(String str) {
        this.phoneMetadataFileNamePrefix = str + "_";
    }

    @Override // io.michaelrocks.libphonenumber.android.metadata.source.PhoneMetadataFileNameProvider
    public String getFor(Object obj) {
        String obj2 = obj.toString();
        if (ALPHANUMERIC.matcher(obj2).matches()) {
            return this.phoneMetadataFileNamePrefix + obj;
        }
        throw new IllegalArgumentException("Invalid key: " + obj2);
    }
}
