package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes.dex */
final class zzk implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        selectionResult.localVersion = iVersions.zza(context, str);
        int i5 = 1;
        int zzb = iVersions.zzb(context, str, true);
        selectionResult.remoteVersion = zzb;
        int i6 = selectionResult.localVersion;
        if (i6 == 0) {
            i6 = 0;
            if (zzb == 0) {
                i5 = 0;
                selectionResult.selection = i5;
                return selectionResult;
            }
        }
        if (zzb < i6) {
            i5 = -1;
        }
        selectionResult.selection = i5;
        return selectionResult;
    }
}
