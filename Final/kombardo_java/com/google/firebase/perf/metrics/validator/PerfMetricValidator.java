package com.google.firebase.perf.metrics.validator;

import android.content.Context;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Constants$CounterNames;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.v1.PerfMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class PerfMetricValidator {
    private static List<PerfMetricValidator> getValidators(PerfMetric perfMetric, Context context) {
        ArrayList arrayList = new ArrayList();
        if (perfMetric.hasTraceMetric()) {
            arrayList.add(new FirebasePerfTraceValidator(perfMetric.getTraceMetric()));
        }
        if (perfMetric.hasNetworkRequestMetric()) {
            arrayList.add(new FirebasePerfNetworkValidator(perfMetric.getNetworkRequestMetric(), context));
        }
        if (perfMetric.hasApplicationInfo()) {
            arrayList.add(new FirebasePerfApplicationInfoValidator(perfMetric.getApplicationInfo()));
        }
        if (perfMetric.hasGaugeMetric()) {
            arrayList.add(new FirebasePerfGaugeMetricValidator(perfMetric.getGaugeMetric()));
        }
        return arrayList;
    }

    public static boolean isValid(PerfMetric perfMetric, Context context) {
        List<PerfMetricValidator> validators = getValidators(perfMetric, context);
        if (validators.isEmpty()) {
            AndroidLogger.getInstance().debug("No validators found for PerfMetric.");
            return false;
        }
        Iterator<PerfMetricValidator> it = validators.iterator();
        while (it.hasNext()) {
            if (!it.next().isValidPerfMetric()) {
                return false;
            }
        }
        return true;
    }

    public static void validateAttribute(String str, String str2) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Attribute key must not be null or empty");
        }
        if (str2 == null || str2.length() == 0) {
            throw new IllegalArgumentException("Attribute value must not be null or empty");
        }
        if (str.length() > 40) {
            throw new IllegalArgumentException(String.format(Locale.US, "Attribute key length must not exceed %d characters", 40));
        }
        if (str2.length() > 100) {
            throw new IllegalArgumentException(String.format(Locale.US, "Attribute value length must not exceed %d characters", 100));
        }
        if (!str.matches("^(?!(firebase_|google_|ga_))[A-Za-z][A-Za-z_0-9]*")) {
            throw new IllegalArgumentException("Attribute key must start with letter, must only contain alphanumeric characters and underscore and must not start with \"firebase_\", \"google_\" and \"ga_");
        }
    }

    public static String validateMetricName(String str) {
        if (str == null) {
            return "Metric name must not be null";
        }
        if (str.length() > 100) {
            return String.format(Locale.US, "Metric name must not exceed %d characters", 100);
        }
        if (!str.startsWith("_")) {
            return null;
        }
        for (Constants$CounterNames constants$CounterNames : Constants$CounterNames.values()) {
            if (constants$CounterNames.toString().equals(str)) {
                return null;
            }
        }
        return "Metric name must not start with '_'";
    }

    public static String validateTraceName(String str) {
        if (str == null) {
            return "Trace name must not be null";
        }
        if (str.length() > 100) {
            return String.format(Locale.US, "Trace name must not exceed %d characters", 100);
        }
        if (!str.startsWith("_")) {
            return null;
        }
        for (Constants$TraceNames constants$TraceNames : Constants$TraceNames.values()) {
            if (constants$TraceNames.toString().equals(str)) {
                return null;
            }
        }
        if (str.startsWith("_st_")) {
            return null;
        }
        return "Trace name must not start with '_'";
    }

    public abstract boolean isValidPerfMetric();
}
