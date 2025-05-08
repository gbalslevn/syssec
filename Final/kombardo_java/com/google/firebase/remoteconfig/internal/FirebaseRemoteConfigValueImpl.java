package com.google.firebase.remoteconfig.internal;

import com.adjust.sdk.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigValueImpl implements FirebaseRemoteConfigValue {
    private static final String ILLEGAL_ARGUMENT_STRING_FORMAT = "[Value: %s] cannot be converted to a %s.";
    private final int source;
    private final String value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseRemoteConfigValueImpl(String str, int i5) {
        this.value = str;
        this.source = i5;
    }

    private String asTrimmedString() {
        return asString().trim();
    }

    private void throwIfNullValue() {
        if (this.value == null) {
            throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
        }
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public boolean asBoolean() {
        if (this.source == 0) {
            return false;
        }
        String asTrimmedString = asTrimmedString();
        if (ConfigGetParameterHandler.TRUE_REGEX.matcher(asTrimmedString).matches()) {
            return true;
        }
        if (ConfigGetParameterHandler.FALSE_REGEX.matcher(asTrimmedString).matches()) {
            return false;
        }
        throw new IllegalArgumentException(String.format(ILLEGAL_ARGUMENT_STRING_FORMAT, asTrimmedString, "boolean"));
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public double asDouble() {
        if (this.source == 0) {
            return 0.0d;
        }
        String asTrimmedString = asTrimmedString();
        try {
            return Double.valueOf(asTrimmedString).doubleValue();
        } catch (NumberFormatException e5) {
            throw new IllegalArgumentException(String.format(ILLEGAL_ARGUMENT_STRING_FORMAT, asTrimmedString, "double"), e5);
        }
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public long asLong() {
        if (this.source == 0) {
            return 0L;
        }
        String asTrimmedString = asTrimmedString();
        try {
            return Long.valueOf(asTrimmedString).longValue();
        } catch (NumberFormatException e5) {
            throw new IllegalArgumentException(String.format(ILLEGAL_ARGUMENT_STRING_FORMAT, asTrimmedString, Constants.LONG), e5);
        }
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public String asString() {
        if (this.source == 0) {
            return BuildConfig.FLAVOR;
        }
        throwIfNullValue();
        return this.value;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public int getSource() {
        return this.source;
    }
}
