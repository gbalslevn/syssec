package androidx.core.view;

import android.view.MotionEvent;

/* loaded from: classes.dex */
class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private final float[] mMovements = new float[20];
    private final long[] mEventTimes = new long[20];
    private float mLastComputedVelocity = 0.0f;
    private int mDataPointsBufferSize = 0;
    private int mDataPointsBufferLastUsedIndex = 0;

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private float getCurrentVelocity() {
        long[] jArr;
        long j5;
        int i5 = this.mDataPointsBufferSize;
        if (i5 < 2) {
            return 0.0f;
        }
        int i6 = this.mDataPointsBufferLastUsedIndex;
        int i7 = ((i6 + 20) - (i5 - 1)) % 20;
        long j6 = this.mEventTimes[i6];
        while (true) {
            jArr = this.mEventTimes;
            j5 = jArr[i7];
            if (j6 - j5 <= RANGE_MS) {
                break;
            }
            this.mDataPointsBufferSize--;
            i7 = (i7 + 1) % 20;
        }
        int i8 = this.mDataPointsBufferSize;
        if (i8 < 2) {
            return 0.0f;
        }
        if (i8 == 2) {
            int i9 = (i7 + 1) % 20;
            long j7 = jArr[i9];
            if (j5 == j7) {
                return 0.0f;
            }
            return this.mMovements[i9] / ((float) (j7 - j5));
        }
        float f5 = 0.0f;
        int i10 = 0;
        for (int i11 = 0; i11 < this.mDataPointsBufferSize - 1; i11++) {
            int i12 = i11 + i7;
            long[] jArr2 = this.mEventTimes;
            long j8 = jArr2[i12 % 20];
            int i13 = (i12 + 1) % 20;
            if (jArr2[i13] != j8) {
                i10++;
                float kineticEnergyToVelocity = kineticEnergyToVelocity(f5);
                float f6 = this.mMovements[i13] / ((float) (this.mEventTimes[i13] - j8));
                f5 += (f6 - kineticEnergyToVelocity) * Math.abs(f6);
                if (i10 == 1) {
                    f5 *= 0.5f;
                }
            }
        }
        return kineticEnergyToVelocity(f5);
    }

    private static float kineticEnergyToVelocity(float f5) {
        return (f5 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f5) * 2.0f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addMovement(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.mDataPointsBufferSize != 0 && eventTime - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > ASSUME_POINTER_STOPPED_MS) {
            clear();
        }
        int i5 = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = i5;
        int i6 = this.mDataPointsBufferSize;
        if (i6 != 20) {
            this.mDataPointsBufferSize = i6 + 1;
        }
        this.mMovements[i5] = motionEvent.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = eventTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void computeCurrentVelocity(int i5, float f5) {
        float currentVelocity = getCurrentVelocity() * i5;
        this.mLastComputedVelocity = currentVelocity;
        if (currentVelocity < (-Math.abs(f5))) {
            this.mLastComputedVelocity = -Math.abs(f5);
        } else if (this.mLastComputedVelocity > Math.abs(f5)) {
            this.mLastComputedVelocity = Math.abs(f5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getAxisVelocity(int i5) {
        if (i5 != 26) {
            return 0.0f;
        }
        return this.mLastComputedVelocity;
    }
}
