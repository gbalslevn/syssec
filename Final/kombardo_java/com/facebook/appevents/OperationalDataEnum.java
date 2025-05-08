package com.facebook.appevents;

import java.util.Arrays;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/OperationalDataEnum;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IAPParameters", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public enum OperationalDataEnum {
    IAPParameters("iap_parameters");

    private final String value;

    OperationalDataEnum(String str) {
        this.value = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static OperationalDataEnum[] valuesCustom() {
        OperationalDataEnum[] valuesCustom = values();
        return (OperationalDataEnum[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    public final String getValue() {
        return this.value;
    }
}
