package androidx.tracing;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class Trace {
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static boolean sHasAppTracingEnabled;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    public static void beginAsyncSection(String str, int i5) {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.beginAsyncSection(truncatedTraceSectionLabel(str), i5);
        } else {
            beginAsyncSectionFallback(truncatedTraceSectionLabel(str), i5);
        }
    }

    private static void beginAsyncSectionFallback(String str, int i5) {
        try {
            if (sAsyncTraceBeginMethod == null) {
                sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            sAsyncTraceBeginMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i5));
        } catch (Exception e5) {
            handleException("asyncTraceBegin", e5);
        }
    }

    public static void beginSection(String str) {
        TraceApi18Impl.beginSection(truncatedTraceSectionLabel(str));
    }

    public static void endAsyncSection(String str, int i5) {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.endAsyncSection(truncatedTraceSectionLabel(str), i5);
        } else {
            endAsyncSectionFallback(truncatedTraceSectionLabel(str), i5);
        }
    }

    private static void endAsyncSectionFallback(String str, int i5) {
        try {
            if (sAsyncTraceEndMethod == null) {
                sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            sAsyncTraceEndMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i5));
        } catch (Exception e5) {
            handleException("asyncTraceEnd", e5);
        }
    }

    public static void endSection() {
        TraceApi18Impl.endSection();
    }

    private static void handleException(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean isEnabled() {
        return Build.VERSION.SDK_INT >= 29 ? TraceApi29Impl.isEnabled() : isEnabledFallback();
    }

    private static boolean isEnabledFallback() {
        try {
            if (sIsTagEnabledMethod == null) {
                sTraceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                sIsTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) sIsTagEnabledMethod.invoke(null, Long.valueOf(sTraceTagApp))).booleanValue();
        } catch (Exception e5) {
            handleException("isTagEnabled", e5);
            return false;
        }
    }

    private static String truncatedTraceSectionLabel(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }
}
