package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;

/* loaded from: classes.dex */
final class zai implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ OnConnectionFailedListener zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zai(OnConnectionFailedListener onConnectionFailedListener) {
        this.zaa = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zaa.onConnectionFailed(connectionResult);
    }
}
