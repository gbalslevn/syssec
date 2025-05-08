package com.google.android.gms.common.api;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

@Deprecated
/* loaded from: classes.dex */
public abstract class GoogleApiClient {
    private static final Set zaa = Collections.newSetFromMap(new WeakHashMap());

    @Deprecated
    /* loaded from: classes.dex */
    public interface ConnectionCallbacks extends com.google.android.gms.common.api.internal.ConnectionCallbacks {
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface OnConnectionFailedListener extends com.google.android.gms.common.api.internal.OnConnectionFailedListener {
    }
}
