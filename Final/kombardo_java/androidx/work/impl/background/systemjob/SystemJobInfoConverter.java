package androidx.work.impl.background.systemjob;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.BackoffPolicy;
import androidx.work.Clock;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;
import java.util.Iterator;

@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
class SystemJobInfoConverter {
    private static final String TAG = Logger.tagWithPrefix("SystemJobInfoConverter");
    private final Clock mClock;
    private final boolean mMarkImportantWhileForeground;
    private final ComponentName mWorkServiceComponent;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.work.impl.background.systemjob.SystemJobInfoConverter$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$work$NetworkType;

        static {
            int[] iArr = new int[NetworkType.values().length];
            $SwitchMap$androidx$work$NetworkType = iArr;
            try {
                iArr[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$work$NetworkType[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$work$NetworkType[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$work$NetworkType[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$work$NetworkType[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemJobInfoConverter(Context context, Clock clock, boolean z5) {
        this.mClock = clock;
        this.mWorkServiceComponent = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
        this.mMarkImportantWhileForeground = z5;
    }

    private static JobInfo.TriggerContentUri convertContentUriTrigger(Constraints.ContentUriTrigger contentUriTrigger) {
        return new JobInfo.TriggerContentUri(contentUriTrigger.getUri(), contentUriTrigger.getIsTriggeredForDescendants() ? 1 : 0);
    }

    static int convertNetworkType(NetworkType networkType) {
        int i5 = AnonymousClass1.$SwitchMap$androidx$work$NetworkType[networkType.ordinal()];
        if (i5 == 1) {
            return 0;
        }
        if (i5 == 2) {
            return 1;
        }
        if (i5 == 3) {
            return 2;
        }
        if (i5 == 4) {
            return 3;
        }
        if (i5 == 5) {
            return 4;
        }
        Logger.get().debug(TAG, "API version too low. Cannot convert network type value " + networkType);
        return 1;
    }

    static void setRequiredNetwork(JobInfo.Builder builder, NetworkType networkType) {
        if (Build.VERSION.SDK_INT < 30 || networkType != NetworkType.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetworkType(convertNetworkType(networkType));
        } else {
            builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JobInfo convert(WorkSpec workSpec, int i5) {
        String traceTag;
        Constraints constraints = workSpec.constraints;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", workSpec.id);
        persistableBundle.putInt("EXTRA_WORK_SPEC_GENERATION", workSpec.getGeneration());
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", workSpec.isPeriodic());
        JobInfo.Builder extras = new JobInfo.Builder(i5, this.mWorkServiceComponent).setRequiresCharging(constraints.getRequiresCharging()).setRequiresDeviceIdle(constraints.getRequiresDeviceIdle()).setExtras(persistableBundle);
        NetworkRequest requiredNetworkRequest = constraints.getRequiredNetworkRequest();
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 28 || requiredNetworkRequest == null) {
            setRequiredNetwork(extras, constraints.getRequiredNetworkType());
        } else {
            SystemJobInfoConverterExtKt.setRequiredNetworkRequest(extras, requiredNetworkRequest);
        }
        if (!constraints.getRequiresDeviceIdle()) {
            extras.setBackoffCriteria(workSpec.backoffDelayDuration, workSpec.backoffPolicy == BackoffPolicy.LINEAR ? 0 : 1);
        }
        long max = Math.max(workSpec.calculateNextRunTime() - this.mClock.currentTimeMillis(), 0L);
        if (i6 <= 28) {
            extras.setMinimumLatency(max);
        } else if (max > 0) {
            extras.setMinimumLatency(max);
        } else if (!workSpec.expedited && this.mMarkImportantWhileForeground) {
            extras.setImportantWhileForeground(true);
        }
        if (constraints.hasContentUriTriggers()) {
            Iterator<Constraints.ContentUriTrigger> it = constraints.getContentUriTriggers().iterator();
            while (it.hasNext()) {
                extras.addTriggerContentUri(convertContentUriTrigger(it.next()));
            }
            extras.setTriggerContentUpdateDelay(constraints.getContentTriggerUpdateDelayMillis());
            extras.setTriggerContentMaxDelay(constraints.getContentTriggerMaxDelayMillis());
        }
        extras.setPersisted(false);
        int i7 = Build.VERSION.SDK_INT;
        extras.setRequiresBatteryNotLow(constraints.getRequiresBatteryNotLow());
        extras.setRequiresStorageNotLow(constraints.getRequiresStorageNotLow());
        boolean z5 = workSpec.runAttemptCount > 0;
        boolean z6 = max > 0;
        if (i7 >= 31 && workSpec.expedited && !z5 && !z6) {
            extras.setExpedited(true);
        }
        if (i7 >= 35 && (traceTag = workSpec.getTraceTag()) != null) {
            extras.setTraceTag(traceTag);
        }
        return extras.build();
    }
}
