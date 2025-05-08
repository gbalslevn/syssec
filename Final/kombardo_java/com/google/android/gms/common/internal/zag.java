package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* loaded from: classes.dex */
public abstract class zag implements DialogInterface.OnClickListener {
    public static zag zab(Activity activity, Intent intent, int i5) {
        return new zad(intent, activity, i5);
    }

    public static zag zad(LifecycleFragment lifecycleFragment, Intent intent, int i5) {
        return new zaf(intent, lifecycleFragment, 2);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) {
        try {
            try {
                zaa();
            } catch (ActivityNotFoundException e5) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e5);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }

    protected abstract void zaa();
}
