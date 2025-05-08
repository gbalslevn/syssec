package com.ramcosta.composedestinations.spec;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"Direction", "Lcom/ramcosta/composedestinations/spec/Direction;", "route", BuildConfig.FLAVOR, "compose-destinations_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DirectionKt {
    public static final Direction Direction(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return new DirectionImpl(route);
    }
}
