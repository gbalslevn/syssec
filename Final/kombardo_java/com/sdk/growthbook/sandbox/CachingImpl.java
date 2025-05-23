package com.sdk.growthbook.sandbox;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/sdk/growthbook/sandbox/CachingImpl;", BuildConfig.FLAVOR, "()V", "getLayer", "Lcom/sdk/growthbook/sandbox/CachingLayer;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CachingImpl {
    public static final CachingImpl INSTANCE = new CachingImpl();

    private CachingImpl() {
    }

    public final CachingLayer getLayer() {
        return new CachingAndroid();
    }
}
