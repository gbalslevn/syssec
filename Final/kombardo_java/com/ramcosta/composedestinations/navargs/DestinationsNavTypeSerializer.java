package com.ramcosta.composedestinations.navargs;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0004H&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/ramcosta/composedestinations/navargs/DestinationsNavTypeSerializer;", "T", BuildConfig.FLAVOR, "toRouteString", BuildConfig.FLAVOR, "value", "(Ljava/lang/Object;)Ljava/lang/String;", "fromRouteString", "routeStr", "(Ljava/lang/String;)Ljava/lang/Object;", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DestinationsNavTypeSerializer<T> {
    T fromRouteString(String routeStr);

    String toRouteString(T value);
}
