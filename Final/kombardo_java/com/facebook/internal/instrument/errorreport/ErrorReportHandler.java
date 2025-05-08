package com.facebook.internal.instrument.errorreport;

import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.errorreport.ErrorReportData;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\b\u0010\u000e\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/internal/instrument/errorreport/ErrorReportHandler;", BuildConfig.FLAVOR, "()V", "MAX_ERROR_REPORT_NUM", BuildConfig.FLAVOR, "enable", BuildConfig.FLAVOR, "listErrorReportFiles", BuildConfig.FLAVOR, "Ljava/io/File;", "()[Ljava/io/File;", "save", "msg", BuildConfig.FLAVOR, "sendErrorReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ErrorReportHandler {
    public static final ErrorReportHandler INSTANCE = new ErrorReportHandler();
    private static final int MAX_ERROR_REPORT_NUM = 1000;

    private ErrorReportHandler() {
    }

    public static final void enable() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            sendErrorReports();
        }
    }

    public static final File[] listErrorReportFiles() {
        File instrumentReportDir = InstrumentUtility.getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: s0.c
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                boolean m2882listErrorReportFiles$lambda3;
                m2882listErrorReportFiles$lambda3 = ErrorReportHandler.m2882listErrorReportFiles$lambda3(file, str);
                return m2882listErrorReportFiles$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(listFiles, "reportDir.listFiles { dir, name ->\n      name.matches(Regex(String.format(\"^%s[0-9]+.json$\", InstrumentUtility.ERROR_REPORT_PREFIX)))\n    }");
        return listFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listErrorReportFiles$lambda-3, reason: not valid java name */
    public static final boolean m2882listErrorReportFiles$lambda3(File file, String name) {
        Intrinsics.checkNotNullExpressionValue(name, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{"error_log_"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return new Regex(format).matches(name);
    }

    public static final void save(String msg) {
        try {
            new ErrorReportData(msg).save();
        } catch (Exception unused) {
        }
    }

    public static final void sendErrorReports() {
        if (Utility.isDataProcessingRestricted()) {
            return;
        }
        File[] listErrorReportFiles = listErrorReportFiles();
        final ArrayList arrayList = new ArrayList();
        int length = listErrorReportFiles.length;
        int i5 = 0;
        while (i5 < length) {
            File file = listErrorReportFiles[i5];
            i5++;
            ErrorReportData errorReportData = new ErrorReportData(file);
            if (errorReportData.isValid()) {
                arrayList.add(errorReportData);
            }
        }
        CollectionsKt.sortWith(arrayList, new Comparator() { // from class: s0.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int m2883sendErrorReports$lambda0;
                m2883sendErrorReports$lambda0 = ErrorReportHandler.m2883sendErrorReports$lambda0((ErrorReportData) obj, (ErrorReportData) obj2);
                return m2883sendErrorReports$lambda0;
            }
        });
        JSONArray jSONArray = new JSONArray();
        for (int i6 = 0; i6 < arrayList.size() && i6 < 1000; i6++) {
            jSONArray.put(arrayList.get(i6));
        }
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        InstrumentUtility.sendReports("error_reports", jSONArray, new GraphRequest.Callback() { // from class: s0.b
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                ErrorReportHandler.m2884sendErrorReports$lambda2(arrayList, graphResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendErrorReports$lambda-0, reason: not valid java name */
    public static final int m2883sendErrorReports$lambda0(ErrorReportData errorReportData, ErrorReportData o22) {
        Intrinsics.checkNotNullExpressionValue(o22, "o2");
        return errorReportData.compareTo(o22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendErrorReports$lambda-2, reason: not valid java name */
    public static final void m2884sendErrorReports$lambda2(ArrayList validReports, GraphResponse response) {
        Intrinsics.checkNotNullParameter(validReports, "$validReports");
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            if (response.getError() == null) {
                JSONObject jsonObject = response.getJsonObject();
                if (Intrinsics.areEqual(jsonObject == null ? null : Boolean.valueOf(jsonObject.getBoolean("success")), Boolean.TRUE)) {
                    Iterator it = validReports.iterator();
                    while (it.hasNext()) {
                        ((ErrorReportData) it.next()).clear();
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }
}
