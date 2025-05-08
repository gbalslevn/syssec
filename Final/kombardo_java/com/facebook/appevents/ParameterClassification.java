package com.facebook.appevents;

import java.util.Arrays;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/ParameterClassification;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CustomData", "OperationalData", "CustomAndOperationalData", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public enum ParameterClassification {
    CustomData("custom_data"),
    OperationalData("operational_data"),
    CustomAndOperationalData("custom_and_operational_data");

    private final String value;

    ParameterClassification(String str) {
        this.value = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static ParameterClassification[] valuesCustom() {
        ParameterClassification[] valuesCustom = values();
        return (ParameterClassification[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
