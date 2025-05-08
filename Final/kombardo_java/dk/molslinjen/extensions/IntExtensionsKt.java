package dk.molslinjen.extensions;

import com.adjust.sdk.Constants;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {BuildConfig.FLAVOR, BuildConfig.FLAVOR, "secondsAsMilliseconds", "(I)J", "millisecondsAsNano", "(J)J", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class IntExtensionsKt {
    public static final long millisecondsAsNano(long j5) {
        return j5 * 1000000;
    }

    public static final long secondsAsMilliseconds(int i5) {
        return i5 * Constants.ONE_SECOND;
    }
}
