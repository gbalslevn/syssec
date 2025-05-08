package com.airbnb.lottie;

import androidx.core.os.TraceCompat;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.network.NetworkFetcher;

/* loaded from: classes.dex */
public abstract class L {
    public static boolean DBG = false;
    private static final int MAX_DEPTH = 20;
    private static LottieNetworkCacheProvider cacheProvider = null;
    private static int depthPastMaxDepth = 0;
    private static boolean disablePathInterpolatorCache = true;
    private static LottieNetworkFetcher fetcher = null;
    private static volatile NetworkCache networkCache = null;
    private static boolean networkCacheEnabled = true;
    private static volatile NetworkFetcher networkFetcher = null;
    private static String[] sections = null;
    private static long[] startTimeNs = null;
    private static int traceDepth = 0;
    private static boolean traceEnabled = false;

    public static void beginSection(String str) {
        if (traceEnabled) {
            int i5 = traceDepth;
            if (i5 == 20) {
                depthPastMaxDepth++;
                return;
            }
            sections[i5] = str;
            startTimeNs[i5] = System.nanoTime();
            TraceCompat.beginSection(str);
            traceDepth++;
        }
    }

    public static float endSection(String str) {
        int i5 = depthPastMaxDepth;
        if (i5 > 0) {
            depthPastMaxDepth = i5 - 1;
            return 0.0f;
        }
        if (!traceEnabled) {
            return 0.0f;
        }
        int i6 = traceDepth - 1;
        traceDepth = i6;
        if (i6 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(sections[i6])) {
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - startTimeNs[traceDepth])) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + sections[traceDepth] + ".");
    }

    public static boolean getDisablePathInterpolatorCache() {
        return disablePathInterpolatorCache;
    }
}
