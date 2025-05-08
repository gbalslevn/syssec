package com.google.firebase.perf.metrics;

import android.util.SparseIntArray;

/* loaded from: classes2.dex */
public abstract class FrameMetricsCalculator {

    /* loaded from: classes2.dex */
    public static class PerfFrameMetrics {
        int frozenFrames;
        int slowFrames;
        int totalFrames;

        public PerfFrameMetrics(int i5, int i6, int i7) {
            this.totalFrames = i5;
            this.slowFrames = i6;
            this.frozenFrames = i7;
        }

        public PerfFrameMetrics deltaFrameMetricsFromSnapshot(PerfFrameMetrics perfFrameMetrics) {
            return new PerfFrameMetrics(this.totalFrames - perfFrameMetrics.getTotalFrames(), this.slowFrames - perfFrameMetrics.getSlowFrames(), this.frozenFrames - perfFrameMetrics.getFrozenFrames());
        }

        public int getFrozenFrames() {
            return this.frozenFrames;
        }

        public int getSlowFrames() {
            return this.slowFrames;
        }

        public int getTotalFrames() {
            return this.totalFrames;
        }
    }

    public static PerfFrameMetrics calculateFrameMetrics(SparseIntArray[] sparseIntArrayArr) {
        int i5;
        int i6;
        SparseIntArray sparseIntArray;
        int i7 = 0;
        if (sparseIntArrayArr == null || (sparseIntArray = sparseIntArrayArr[0]) == null) {
            i5 = 0;
            i6 = 0;
        } else {
            int i8 = 0;
            i5 = 0;
            i6 = 0;
            while (i7 < sparseIntArray.size()) {
                int keyAt = sparseIntArray.keyAt(i7);
                int valueAt = sparseIntArray.valueAt(i7);
                i8 += valueAt;
                if (keyAt > 700) {
                    i6 += valueAt;
                }
                if (keyAt > 16) {
                    i5 += valueAt;
                }
                i7++;
            }
            i7 = i8;
        }
        return new PerfFrameMetrics(i7, i5, i6);
    }
}
