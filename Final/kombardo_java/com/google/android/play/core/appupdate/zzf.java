package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;

/* loaded from: classes.dex */
final class zzf implements IntentSenderForResultStarter {
    final /* synthetic */ Activity zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(zzg zzgVar, Activity activity) {
        this.zza = activity;
    }

    @Override // com.google.android.play.core.common.IntentSenderForResultStarter
    public final void startIntentSenderForResult(IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) {
        this.zza.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8, bundle);
    }
}
