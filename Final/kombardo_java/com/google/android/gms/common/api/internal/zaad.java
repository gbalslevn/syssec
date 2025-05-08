package com.google.android.gms.common.api.internal;

import android.support.v4.media.session.a;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zaad {
    private final Map zaa = Collections.synchronizedMap(new WeakHashMap());
    private final Map zab = Collections.synchronizedMap(new WeakHashMap());

    private final void zah(boolean z5, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.zaa) {
            hashMap = new HashMap(this.zaa);
        }
        synchronized (this.zab) {
            hashMap2 = new HashMap(this.zab);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z5 || ((Boolean) entry.getValue()).booleanValue()) {
                a.a(entry.getKey());
                throw null;
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z5 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new ApiException(status));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zad(TaskCompletionSource taskCompletionSource, boolean z5) {
        this.zab.put(taskCompletionSource, Boolean.valueOf(z5));
        taskCompletionSource.getTask().addOnCompleteListener(new zaac(this, taskCompletionSource));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zae(int i5, String str) {
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i5 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i5 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        zah(true, new Status(20, sb.toString()));
    }

    public final void zaf() {
        zah(false, GoogleApiManager.zaa);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zag() {
        return (this.zaa.isEmpty() && this.zab.isEmpty()) ? false : true;
    }
}
