package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes.dex */
final class zzl implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) {
        int zzb;
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int zza = iVersions.zza(context, str);
        selectionResult.localVersion = zza;
        int i5 = 1;
        int i6 = 0;
        if (zza != 0) {
            zzb = iVersions.zzb(context, str, false);
            selectionResult.remoteVersion = zzb;
        } else {
            zzb = iVersions.zzb(context, str, true);
            selectionResult.remoteVersion = zzb;
        }
        int i7 = selectionResult.localVersion;
        if (i7 != 0) {
            i6 = i7;
        } else if (zzb == 0) {
            i5 = 0;
            selectionResult.selection = i5;
            return selectionResult;
        }
        if (zzb < i6) {
            i5 = -1;
        }
        selectionResult.selection = i5;
        return selectionResult;
    }
}
