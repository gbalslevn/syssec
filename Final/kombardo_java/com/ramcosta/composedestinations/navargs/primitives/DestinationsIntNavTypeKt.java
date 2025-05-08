package com.ramcosta.composedestinations.navargs.primitives;

import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"intNavType", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", BuildConfig.FLAVOR, "getIntNavType", "()Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", "compose-destinations_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DestinationsIntNavTypeKt {
    private static final DestinationsNavType<Integer> intNavType = DestinationsIntNavType.INSTANCE;

    public static final DestinationsNavType<Integer> getIntNavType() {
        return intNavType;
    }
}
