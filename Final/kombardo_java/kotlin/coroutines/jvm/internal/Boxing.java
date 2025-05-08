package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\tH\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {BuildConfig.FLAVOR, "primitive", "Ljava/lang/Boolean;", "boxBoolean", "(Z)Ljava/lang/Boolean;", BuildConfig.FLAVOR, "Ljava/lang/Integer;", "boxInt", "(I)Ljava/lang/Integer;", BuildConfig.FLAVOR, "Ljava/lang/Long;", "boxLong", "(J)Ljava/lang/Long;", BuildConfig.FLAVOR, "Ljava/lang/Float;", "boxFloat", "(F)Ljava/lang/Float;", BuildConfig.FLAVOR, "Ljava/lang/Double;", "boxDouble", "(D)Ljava/lang/Double;", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class Boxing {
    public static final Boolean boxBoolean(boolean z5) {
        return Boolean.valueOf(z5);
    }

    public static final Double boxDouble(double d5) {
        return new Double(d5);
    }

    public static final Float boxFloat(float f5) {
        return new Float(f5);
    }

    public static final Integer boxInt(int i5) {
        return new Integer(i5);
    }

    public static final Long boxLong(long j5) {
        return new Long(j5);
    }
}
