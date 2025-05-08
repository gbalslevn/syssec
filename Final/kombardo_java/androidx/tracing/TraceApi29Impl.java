package androidx.tracing;

/* loaded from: classes.dex */
abstract class TraceApi29Impl {
    public static void beginAsyncSection(String str, int i5) {
        android.os.Trace.beginAsyncSection(str, i5);
    }

    public static void endAsyncSection(String str, int i5) {
        android.os.Trace.endAsyncSection(str, i5);
    }

    public static boolean isEnabled() {
        return android.os.Trace.isEnabled();
    }
}
