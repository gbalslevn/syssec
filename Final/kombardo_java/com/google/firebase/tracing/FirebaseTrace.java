package com.google.firebase.tracing;

import android.os.Trace;

/* loaded from: classes2.dex */
public abstract class FirebaseTrace {
    public static void popTrace() {
        Trace.endSection();
    }

    public static void pushTrace(String str) {
        Trace.beginSection(str);
    }
}
