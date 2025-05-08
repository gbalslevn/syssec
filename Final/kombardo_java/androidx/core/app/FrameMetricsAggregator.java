package androidx.core.app;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class FrameMetricsAggregator {
    private static final int LAST_INDEX = 8;
    private final FrameMetricsBaseImpl mInstance;

    /* loaded from: classes.dex */
    private static class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {
        private static final int NANOS_PER_MS = 1000000;
        private static final int NANOS_ROUNDING_VALUE = 500000;
        private static Handler sHandler;
        private static HandlerThread sHandlerThread;
        int mTrackingFlags;
        SparseIntArray[] mMetrics = new SparseIntArray[9];
        private final ArrayList<WeakReference<Activity>> mActivities = new ArrayList<>();
        Window.OnFrameMetricsAvailableListener mListener = new Window.OnFrameMetricsAvailableListener() { // from class: androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.1
            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i5) {
                FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl.mTrackingFlags & 1) != 0) {
                    frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[0], frameMetrics.getMetric(8));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl2 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl2.mTrackingFlags & 2) != 0) {
                    frameMetricsApi24Impl2.addDurationItem(frameMetricsApi24Impl2.mMetrics[1], frameMetrics.getMetric(1));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl3 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl3.mTrackingFlags & 4) != 0) {
                    frameMetricsApi24Impl3.addDurationItem(frameMetricsApi24Impl3.mMetrics[2], frameMetrics.getMetric(3));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl4 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl4.mTrackingFlags & 8) != 0) {
                    frameMetricsApi24Impl4.addDurationItem(frameMetricsApi24Impl4.mMetrics[3], frameMetrics.getMetric(4));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl5 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl5.mTrackingFlags & 16) != 0) {
                    frameMetricsApi24Impl5.addDurationItem(frameMetricsApi24Impl5.mMetrics[4], frameMetrics.getMetric(5));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl6 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl6.mTrackingFlags & 64) != 0) {
                    frameMetricsApi24Impl6.addDurationItem(frameMetricsApi24Impl6.mMetrics[6], frameMetrics.getMetric(7));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl7 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl7.mTrackingFlags & 32) != 0) {
                    frameMetricsApi24Impl7.addDurationItem(frameMetricsApi24Impl7.mMetrics[5], frameMetrics.getMetric(6));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl8 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl8.mTrackingFlags & 128) != 0) {
                    frameMetricsApi24Impl8.addDurationItem(frameMetricsApi24Impl8.mMetrics[7], frameMetrics.getMetric(0));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl9 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl9.mTrackingFlags & 256) != 0) {
                    frameMetricsApi24Impl9.addDurationItem(frameMetricsApi24Impl9.mMetrics[8], frameMetrics.getMetric(2));
                }
            }
        };

        FrameMetricsApi24Impl(int i5) {
            this.mTrackingFlags = i5;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public void add(Activity activity) {
            if (sHandlerThread == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                sHandlerThread = handlerThread;
                handlerThread.start();
                sHandler = new Handler(sHandlerThread.getLooper());
            }
            for (int i5 = 0; i5 <= 8; i5++) {
                SparseIntArray[] sparseIntArrayArr = this.mMetrics;
                if (sparseIntArrayArr[i5] == null && (this.mTrackingFlags & (1 << i5)) != 0) {
                    sparseIntArrayArr[i5] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.mListener, sHandler);
            this.mActivities.add(new WeakReference<>(activity));
        }

        void addDurationItem(SparseIntArray sparseIntArray, long j5) {
            if (sparseIntArray != null) {
                int i5 = (int) ((500000 + j5) / 1000000);
                if (j5 >= 0) {
                    sparseIntArray.put(i5, sparseIntArray.get(i5) + 1);
                }
            }
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] getMetrics() {
            return this.mMetrics;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] remove(Activity activity) {
            Iterator<WeakReference<Activity>> it = this.mActivities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<Activity> next = it.next();
                if (next.get() == activity) {
                    this.mActivities.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
            return this.mMetrics;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] reset() {
            SparseIntArray[] sparseIntArrayArr = this.mMetrics;
            this.mMetrics = new SparseIntArray[9];
            return sparseIntArrayArr;
        }
    }

    /* loaded from: classes.dex */
    private static class FrameMetricsBaseImpl {
        FrameMetricsBaseImpl() {
        }

        public abstract void add(Activity activity);

        public abstract SparseIntArray[] getMetrics();

        public abstract SparseIntArray[] remove(Activity activity);

        public abstract SparseIntArray[] reset();
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public void add(Activity activity) {
        this.mInstance.add(activity);
    }

    public SparseIntArray[] getMetrics() {
        return this.mInstance.getMetrics();
    }

    public SparseIntArray[] remove(Activity activity) {
        return this.mInstance.remove(activity);
    }

    public SparseIntArray[] reset() {
        return this.mInstance.reset();
    }

    public FrameMetricsAggregator(int i5) {
        this.mInstance = new FrameMetricsApi24Impl(i5);
    }
}
