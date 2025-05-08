package com.google.android.play.core.appupdate;

/* loaded from: classes.dex */
public abstract class AppUpdateOptions {

    /* loaded from: classes.dex */
    public static abstract class Builder {
        public abstract AppUpdateOptions build();

        public abstract Builder setAllowAssetPackDeletion(boolean z5);
    }

    public static AppUpdateOptions defaultOptions(int i5) {
        return newBuilder(i5).build();
    }

    public static Builder newBuilder(int i5) {
        zzv zzvVar = new zzv();
        zzvVar.setAppUpdateType(i5);
        zzvVar.setAllowAssetPackDeletion(false);
        return zzvVar;
    }

    public abstract boolean allowAssetPackDeletion();

    public abstract int appUpdateType();
}
