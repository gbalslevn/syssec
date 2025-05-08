package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a,\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0000\u001a,\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¨\u0006\t"}, d2 = {"systemProp", BuildConfig.FLAVOR, "propertyName", BuildConfig.FLAVOR, "defaultValue", BuildConfig.FLAVOR, "minValue", "maxValue", BuildConfig.FLAVOR, "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/internal/SystemPropsKt")
/* loaded from: classes3.dex */
public abstract /* synthetic */ class SystemPropsKt__SystemProps_commonKt {
    public static final boolean systemProp(String str, boolean z5) {
        String systemProp = SystemPropsKt.systemProp(str);
        return systemProp != null ? Boolean.parseBoolean(systemProp) : z5;
    }

    public static /* synthetic */ int systemProp$default(String str, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            i6 = 1;
        }
        if ((i8 & 8) != 0) {
            i7 = Integer.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(str, i5, i6, i7);
    }

    public static final int systemProp(String str, int i5, int i6, int i7) {
        return (int) SystemPropsKt.systemProp(str, i5, i6, i7);
    }

    public static /* synthetic */ long systemProp$default(String str, long j5, long j6, long j7, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            j6 = 1;
        }
        long j8 = j6;
        if ((i5 & 8) != 0) {
            j7 = Long.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(str, j5, j8, j7);
    }

    public static final long systemProp(String str, long j5, long j6, long j7) {
        String systemProp = SystemPropsKt.systemProp(str);
        if (systemProp == null) {
            return j5;
        }
        Long longOrNull = StringsKt.toLongOrNull(systemProp);
        if (longOrNull == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + systemProp + '\'').toString());
        }
        long longValue = longOrNull.longValue();
        if (j6 <= longValue && longValue <= j7) {
            return longValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j6 + ".." + j7 + ", but is '" + longValue + '\'').toString());
    }

    public static final String systemProp(String str, String str2) {
        String systemProp = SystemPropsKt.systemProp(str);
        return systemProp == null ? str2 : systemProp;
    }
}
