package com.google.android.gms.internal.measurement;

import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public enum zznj {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(BuildConfig.FLAVOR),
    BYTE_STRING(zziy.zza),
    ENUM(null),
    MESSAGE(null);

    zznj(Object obj) {
    }
}
