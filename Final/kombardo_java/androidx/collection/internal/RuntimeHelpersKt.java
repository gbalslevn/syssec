package androidx.collection.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {BuildConfig.FLAVOR, "message", BuildConfig.FLAVOR, "throwIllegalStateException", "(Ljava/lang/String;)V", "throwIllegalArgumentException", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RuntimeHelpersKt {
    public static final void throwIllegalArgumentException(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        throw new IllegalArgumentException(message);
    }

    public static final void throwIllegalStateException(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        throw new IllegalStateException(message);
    }
}
