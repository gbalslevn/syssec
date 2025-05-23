package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public abstract class zai {
    public final int zac;

    public zai(int i5) {
        this.zac = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Status zah(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void zad(Status status);

    public abstract void zae(Exception exc);

    public abstract void zaf(zabq zabqVar);

    public abstract void zag(zaad zaadVar, boolean z5);
}
