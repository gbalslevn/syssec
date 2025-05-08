package com.google.firebase.installations;

import com.google.android.gms.tasks.Task;

/* loaded from: classes2.dex */
public interface FirebaseInstallationsApi {
    Task<String> getId();

    Task<InstallationTokenResult> getToken(boolean z5);
}
