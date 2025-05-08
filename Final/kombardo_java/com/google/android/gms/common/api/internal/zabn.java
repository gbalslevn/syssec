package com.google.android.gms.common.api.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zabn implements Runnable {
    final /* synthetic */ int zaa;
    final /* synthetic */ zabq zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zabn(zabq zabqVar, int i5) {
        this.zab = zabqVar;
        this.zaa = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zab.zaI(this.zaa);
    }
}
