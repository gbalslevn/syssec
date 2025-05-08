package com.facebook.internal.instrument;

import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentUtility;
import com.sun.jna.Callback;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\t\u0010\fJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007¢\u0006\u0004\b\u0016\u0010\u0015J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007¢\u0006\u0004\b\u0017\u0010\u0015J#\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\rH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001f\u001a\u00020\u001e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b!\u0010\"J+\u0010(\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010%\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0007¢\u0006\u0004\b(\u0010)J\u0011\u0010*\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\r2\u0006\u0010-\u001a\u00020,H\u0007¢\u0006\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00101R\u0014\u00103\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u00101R\u0014\u00104\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00101R\u0014\u00105\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00101¨\u00066"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentUtility;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "e", BuildConfig.FLAVOR, "getCause", "(Ljava/lang/Throwable;)Ljava/lang/String;", "getStackTrace", "Ljava/lang/Thread;", "thread", "(Ljava/lang/Thread;)Ljava/lang/String;", BuildConfig.FLAVOR, "isSDKRelatedException", "(Ljava/lang/Throwable;)Z", "isSDKRelatedThread", "(Ljava/lang/Thread;)Z", BuildConfig.FLAVOR, "Ljava/io/File;", "listAnrReportFiles", "()[Ljava/io/File;", "listExceptionAnalysisReportFiles", "listExceptionReportFiles", "filename", "deleteOnException", "Lorg/json/JSONObject;", "readFile", "(Ljava/lang/String;Z)Lorg/json/JSONObject;", "content", BuildConfig.FLAVOR, "writeFile", "(Ljava/lang/String;Ljava/lang/String;)V", "deleteFile", "(Ljava/lang/String;)Z", "key", "Lorg/json/JSONArray;", "reports", "Lcom/facebook/GraphRequest$Callback;", Callback.METHOD_NAME, "sendReports", "(Ljava/lang/String;Lorg/json/JSONArray;Lcom/facebook/GraphRequest$Callback;)V", "getInstrumentReportDir", "()Ljava/io/File;", "Ljava/lang/StackTraceElement;", "element", "isFromFbOrMeta", "(Ljava/lang/StackTraceElement;)Z", "FBSDK_PREFIX", "Ljava/lang/String;", "METASDK_PREFIX", "CODELESS_PREFIX", "SUGGESTED_EVENTS_PREFIX", "INSTRUMENT_DIR", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class InstrumentUtility {
    private static final String CODELESS_PREFIX = "com.facebook.appevents.codeless";
    private static final String FBSDK_PREFIX = "com.facebook";
    public static final InstrumentUtility INSTANCE = new InstrumentUtility();
    private static final String INSTRUMENT_DIR = "instrument";
    private static final String METASDK_PREFIX = "com.meta";
    private static final String SUGGESTED_EVENTS_PREFIX = "com.facebook.appevents.suggestedevents";

    private InstrumentUtility() {
    }

    public static final boolean deleteFile(String filename) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null || filename == null) {
            return false;
        }
        return new File(instrumentReportDir, filename).delete();
    }

    public static final String getCause(Throwable e5) {
        if (e5 == null) {
            return null;
        }
        return e5.getCause() == null ? e5.toString() : String.valueOf(e5.getCause());
    }

    public static final File getInstrumentReportDir() {
        File file = new File(FacebookSdk.getApplicationContext().getCacheDir(), INSTRUMENT_DIR);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static final String getStackTrace(Throwable e5) {
        Throwable th = null;
        if (e5 == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        while (e5 != null && e5 != th) {
            StackTraceElement[] stackTrace = e5.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "t.stackTrace");
            int length = stackTrace.length;
            int i5 = 0;
            while (i5 < length) {
                StackTraceElement stackTraceElement = stackTrace[i5];
                i5++;
                jSONArray.put(stackTraceElement.toString());
            }
            th = e5;
            e5 = e5.getCause();
        }
        return jSONArray.toString();
    }

    public static final boolean isFromFbOrMeta(StackTraceElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        String className = element.getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "element.className");
        if (!StringsKt.startsWith$default(className, FBSDK_PREFIX, false, 2, (Object) null)) {
            String className2 = element.getClassName();
            Intrinsics.checkNotNullExpressionValue(className2, "element.className");
            if (!StringsKt.startsWith$default(className2, METASDK_PREFIX, false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isSDKRelatedException(Throwable e5) {
        if (e5 == null) {
            return false;
        }
        Throwable th = null;
        while (e5 != null && e5 != th) {
            StackTraceElement[] stackTrace = e5.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "t.stackTrace");
            int length = stackTrace.length;
            int i5 = 0;
            while (i5 < length) {
                StackTraceElement element = stackTrace[i5];
                i5++;
                Intrinsics.checkNotNullExpressionValue(element, "element");
                if (isFromFbOrMeta(element)) {
                    return true;
                }
            }
            th = e5;
            e5 = e5.getCause();
        }
        return false;
    }

    public static final boolean isSDKRelatedThread(Thread thread) {
        StackTraceElement[] stackTrace;
        if (thread != null && (stackTrace = thread.getStackTrace()) != null) {
            for (StackTraceElement element : stackTrace) {
                Intrinsics.checkNotNullExpressionValue(element, "element");
                if (isFromFbOrMeta(element)) {
                    String className = element.getClassName();
                    Intrinsics.checkNotNullExpressionValue(className, "element.className");
                    if (!StringsKt.startsWith$default(className, CODELESS_PREFIX, false, 2, (Object) null)) {
                        String className2 = element.getClassName();
                        Intrinsics.checkNotNullExpressionValue(className2, "element.className");
                        if (!StringsKt.startsWith$default(className2, SUGGESTED_EVENTS_PREFIX, false, 2, (Object) null)) {
                            return true;
                        }
                    }
                    String methodName = element.getMethodName();
                    Intrinsics.checkNotNullExpressionValue(methodName, "element.methodName");
                    if (StringsKt.startsWith$default(methodName, "onClick", false, 2, (Object) null)) {
                        continue;
                    } else {
                        String methodName2 = element.getMethodName();
                        Intrinsics.checkNotNullExpressionValue(methodName2, "element.methodName");
                        if (StringsKt.startsWith$default(methodName2, "onItemClick", false, 2, (Object) null)) {
                            continue;
                        } else {
                            String methodName3 = element.getMethodName();
                            Intrinsics.checkNotNullExpressionValue(methodName3, "element.methodName");
                            if (!StringsKt.startsWith$default(methodName3, "onTouch", false, 2, (Object) null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final File[] listAnrReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: p0.f
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                boolean m2874listAnrReportFiles$lambda1;
                m2874listAnrReportFiles$lambda1 = InstrumentUtility.m2874listAnrReportFiles$lambda1(file, str);
                return m2874listAnrReportFiles$lambda1;
            }
        });
        return listFiles == null ? new File[0] : listFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listAnrReportFiles$lambda-1, reason: not valid java name */
    public static final boolean m2874listAnrReportFiles$lambda1(File file, String name) {
        Intrinsics.checkNotNullExpressionValue(name, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{"anr_log_"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return new Regex(format).matches(name);
    }

    public static final File[] listExceptionAnalysisReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: p0.g
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                boolean m2875listExceptionAnalysisReportFiles$lambda2;
                m2875listExceptionAnalysisReportFiles$lambda2 = InstrumentUtility.m2875listExceptionAnalysisReportFiles$lambda2(file, str);
                return m2875listExceptionAnalysisReportFiles$lambda2;
            }
        });
        return listFiles == null ? new File[0] : listFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listExceptionAnalysisReportFiles$lambda-2, reason: not valid java name */
    public static final boolean m2875listExceptionAnalysisReportFiles$lambda2(File file, String name) {
        Intrinsics.checkNotNullExpressionValue(name, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{"analysis_log_"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return new Regex(format).matches(name);
    }

    public static final File[] listExceptionReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: p0.e
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                boolean m2876listExceptionReportFiles$lambda3;
                m2876listExceptionReportFiles$lambda3 = InstrumentUtility.m2876listExceptionReportFiles$lambda3(file, str);
                return m2876listExceptionReportFiles$lambda3;
            }
        });
        return listFiles == null ? new File[0] : listFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listExceptionReportFiles$lambda-3, reason: not valid java name */
    public static final boolean m2876listExceptionReportFiles$lambda3(File file, String name) {
        Intrinsics.checkNotNullExpressionValue(name, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("^(%s|%s|%s)[0-9]+.json$", Arrays.copyOf(new Object[]{"crash_log_", "shield_log_", "thread_check_log_"}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return new Regex(format).matches(name);
    }

    public static final JSONObject readFile(String filename, boolean deleteOnException) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir != null && filename != null) {
            try {
                return new JSONObject(Utility.readStreamToString(new FileInputStream(new File(instrumentReportDir, filename))));
            } catch (Exception unused) {
                if (deleteOnException) {
                    deleteFile(filename);
                }
            }
        }
        return null;
    }

    public static final void sendReports(String key, JSONArray reports, GraphRequest.Callback callback) {
        Intrinsics.checkNotNullParameter(reports, "reports");
        if (reports.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(key, reports.toString());
            JSONObject dataProcessingOptions = Utility.getDataProcessingOptions();
            if (dataProcessingOptions != null) {
                Iterator<String> keys = dataProcessingOptions.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, dataProcessingOptions.get(next));
                }
            }
            GraphRequest.Companion companion = GraphRequest.INSTANCE;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            companion.newPostRequest(null, format, jSONObject, callback).executeAsync();
        } catch (JSONException unused) {
        }
    }

    public static final void writeFile(String filename, String content) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null || filename == null || content == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(instrumentReportDir, filename));
            byte[] bytes = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }

    public static final String getStackTrace(Thread thread) {
        Intrinsics.checkNotNullParameter(thread, "thread");
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONArray jSONArray = new JSONArray();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
        int length = stackTrace.length;
        int i5 = 0;
        while (i5 < length) {
            StackTraceElement stackTraceElement = stackTrace[i5];
            i5++;
            jSONArray.put(stackTraceElement.toString());
        }
        return jSONArray.toString();
    }
}
