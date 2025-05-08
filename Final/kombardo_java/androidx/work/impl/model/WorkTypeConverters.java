package androidx.work.impl.model;

import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;
import androidx.work.impl.utils.NetworkRequest28;
import androidx.work.impl.utils.NetworkRequestCompat;
import androidx.work.impl.utils.NetworkRequestCompatKt;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\"\u001a\u00020!2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0007¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010$\u001a\u00020!H\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010*\u001a\u00020'2\u0006\u0010$\u001a\u00020!H\u0001¢\u0006\u0004\b(\u0010)J\u0017\u0010.\u001a\u00020!2\u0006\u0010+\u001a\u00020'H\u0001¢\u0006\u0004\b,\u0010-¨\u0006/"}, d2 = {"Landroidx/work/impl/model/WorkTypeConverters;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/work/WorkInfo$State;", "state", BuildConfig.FLAVOR, "stateToInt", "(Landroidx/work/WorkInfo$State;)I", "value", "intToState", "(I)Landroidx/work/WorkInfo$State;", "Landroidx/work/BackoffPolicy;", "backoffPolicy", "backoffPolicyToInt", "(Landroidx/work/BackoffPolicy;)I", "intToBackoffPolicy", "(I)Landroidx/work/BackoffPolicy;", "Landroidx/work/NetworkType;", "networkType", "networkTypeToInt", "(Landroidx/work/NetworkType;)I", "intToNetworkType", "(I)Landroidx/work/NetworkType;", "Landroidx/work/OutOfQuotaPolicy;", "policy", "outOfQuotaPolicyToInt", "(Landroidx/work/OutOfQuotaPolicy;)I", "intToOutOfQuotaPolicy", "(I)Landroidx/work/OutOfQuotaPolicy;", BuildConfig.FLAVOR, "Landroidx/work/Constraints$ContentUriTrigger;", "triggers", BuildConfig.FLAVOR, "setOfTriggersToByteArray", "(Ljava/util/Set;)[B", "bytes", "byteArrayToSetOfTriggers", "([B)Ljava/util/Set;", "Landroidx/work/impl/utils/NetworkRequestCompat;", "toNetworkRequest$work_runtime_release", "([B)Landroidx/work/impl/utils/NetworkRequestCompat;", "toNetworkRequest", "requestCompat", "fromNetworkRequest$work_runtime_release", "(Landroidx/work/impl/utils/NetworkRequestCompat;)[B", "fromNetworkRequest", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WorkTypeConverters {
    public static final WorkTypeConverters INSTANCE = new WorkTypeConverters();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[WorkInfo$State.values().length];
            try {
                iArr[WorkInfo$State.ENQUEUED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkInfo$State.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkInfo$State.SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkInfo$State.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkInfo$State.BLOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[WorkInfo$State.CANCELLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BackoffPolicy.values().length];
            try {
                iArr2[BackoffPolicy.EXPONENTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[BackoffPolicy.LINEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[NetworkType.values().length];
            try {
                iArr3[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[OutOfQuotaPolicy.values().length];
            try {
                iArr4[OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr4[OutOfQuotaPolicy.DROP_WORK_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    private WorkTypeConverters() {
    }

    public static final int backoffPolicyToInt(BackoffPolicy backoffPolicy) {
        Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        int i5 = WhenMappings.$EnumSwitchMapping$1[backoffPolicy.ordinal()];
        if (i5 == 1) {
            return 0;
        }
        if (i5 == 2) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Set<Constraints.ContentUriTrigger> byteArrayToSetOfTriggers(byte[] bytes) {
        ObjectInputStream objectInputStream;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (bytes.length == 0) {
            return linkedHashSet;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            try {
                int readInt = objectInputStream.readInt();
                for (int i5 = 0; i5 < readInt; i5++) {
                    Uri uri = Uri.parse(objectInputStream.readUTF());
                    boolean readBoolean = objectInputStream.readBoolean();
                    Intrinsics.checkNotNullExpressionValue(uri, "uri");
                    linkedHashSet.add(new Constraints.ContentUriTrigger(uri, readBoolean));
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(objectInputStream, null);
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(byteArrayInputStream, null);
                return linkedHashSet;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(byteArrayInputStream, th);
                throw th2;
            }
        }
    }

    public static final byte[] fromNetworkRequest$work_runtime_release(NetworkRequestCompat requestCompat) {
        Intrinsics.checkNotNullParameter(requestCompat, "requestCompat");
        if (Build.VERSION.SDK_INT < 28) {
            return new byte[0];
        }
        NetworkRequest networkRequest = requestCompat.getNetworkRequest();
        if (networkRequest == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                int[] transportTypesCompat = NetworkRequestCompatKt.getTransportTypesCompat(networkRequest);
                int[] capabilitiesCompat = NetworkRequestCompatKt.getCapabilitiesCompat(networkRequest);
                objectOutputStream.writeInt(transportTypesCompat.length);
                for (int i5 : transportTypesCompat) {
                    objectOutputStream.writeInt(i5);
                }
                objectOutputStream.writeInt(capabilitiesCompat.length);
                for (int i6 : capabilitiesCompat) {
                    objectOutputStream.writeInt(i6);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(objectOutputStream, null);
                CloseableKt.closeFinally(byteArrayOutputStream, null);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "outputStream.toByteArray()");
                return byteArray;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(byteArrayOutputStream, th);
                throw th2;
            }
        }
    }

    public static final BackoffPolicy intToBackoffPolicy(int value) {
        if (value == 0) {
            return BackoffPolicy.EXPONENTIAL;
        }
        if (value == 1) {
            return BackoffPolicy.LINEAR;
        }
        throw new IllegalArgumentException("Could not convert " + value + " to BackoffPolicy");
    }

    public static final NetworkType intToNetworkType(int value) {
        if (value == 0) {
            return NetworkType.NOT_REQUIRED;
        }
        if (value == 1) {
            return NetworkType.CONNECTED;
        }
        if (value == 2) {
            return NetworkType.UNMETERED;
        }
        if (value == 3) {
            return NetworkType.NOT_ROAMING;
        }
        if (value == 4) {
            return NetworkType.METERED;
        }
        if (Build.VERSION.SDK_INT >= 30 && value == 5) {
            return NetworkType.TEMPORARILY_UNMETERED;
        }
        throw new IllegalArgumentException("Could not convert " + value + " to NetworkType");
    }

    public static final OutOfQuotaPolicy intToOutOfQuotaPolicy(int value) {
        if (value == 0) {
            return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        }
        if (value == 1) {
            return OutOfQuotaPolicy.DROP_WORK_REQUEST;
        }
        throw new IllegalArgumentException("Could not convert " + value + " to OutOfQuotaPolicy");
    }

    public static final WorkInfo$State intToState(int value) {
        if (value == 0) {
            return WorkInfo$State.ENQUEUED;
        }
        if (value == 1) {
            return WorkInfo$State.RUNNING;
        }
        if (value == 2) {
            return WorkInfo$State.SUCCEEDED;
        }
        if (value == 3) {
            return WorkInfo$State.FAILED;
        }
        if (value == 4) {
            return WorkInfo$State.BLOCKED;
        }
        if (value == 5) {
            return WorkInfo$State.CANCELLED;
        }
        throw new IllegalArgumentException("Could not convert " + value + " to State");
    }

    public static final int networkTypeToInt(NetworkType networkType) {
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        int i5 = WhenMappings.$EnumSwitchMapping$2[networkType.ordinal()];
        if (i5 == 1) {
            return 0;
        }
        int i6 = 2;
        if (i5 == 2) {
            return 1;
        }
        if (i5 != 3) {
            i6 = 4;
            if (i5 == 4) {
                return 3;
            }
            if (i5 != 5) {
                if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
                    return 5;
                }
                throw new IllegalArgumentException("Could not convert " + networkType + " to int");
            }
        }
        return i6;
    }

    public static final int outOfQuotaPolicyToInt(OutOfQuotaPolicy policy) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        int i5 = WhenMappings.$EnumSwitchMapping$3[policy.ordinal()];
        if (i5 == 1) {
            return 0;
        }
        if (i5 == 2) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final byte[] setOfTriggersToByteArray(Set<Constraints.ContentUriTrigger> triggers) {
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        if (triggers.isEmpty()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeInt(triggers.size());
                for (Constraints.ContentUriTrigger contentUriTrigger : triggers) {
                    objectOutputStream.writeUTF(contentUriTrigger.getUri().toString());
                    objectOutputStream.writeBoolean(contentUriTrigger.getIsTriggeredForDescendants());
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(objectOutputStream, null);
                CloseableKt.closeFinally(byteArrayOutputStream, null);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "outputStream.toByteArray()");
                return byteArray;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(byteArrayOutputStream, th);
                throw th2;
            }
        }
    }

    public static final int stateToInt(WorkInfo$State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final NetworkRequestCompat toNetworkRequest$work_runtime_release(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (Build.VERSION.SDK_INT < 28 || bytes.length == 0) {
            return new NetworkRequestCompat(null);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                int readInt = objectInputStream.readInt();
                int[] iArr = new int[readInt];
                for (int i5 = 0; i5 < readInt; i5++) {
                    iArr[i5] = objectInputStream.readInt();
                }
                int readInt2 = objectInputStream.readInt();
                int[] iArr2 = new int[readInt2];
                for (int i6 = 0; i6 < readInt2; i6++) {
                    iArr2[i6] = objectInputStream.readInt();
                }
                NetworkRequestCompat createNetworkRequestCompat$work_runtime_release = NetworkRequest28.INSTANCE.createNetworkRequestCompat$work_runtime_release(iArr2, iArr);
                CloseableKt.closeFinally(objectInputStream, null);
                CloseableKt.closeFinally(byteArrayInputStream, null);
                return createNetworkRequestCompat$work_runtime_release;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(byteArrayInputStream, th);
                throw th2;
            }
        }
    }
}
