package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007\"\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b\"\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000b\"\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000b\"\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000b\"\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {BuildConfig.FLAVOR, "locked", "Lkotlinx/coroutines/sync/Mutex;", "Mutex", "(Z)Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/internal/Symbol;", "NO_OWNER", "Lkotlinx/coroutines/internal/Symbol;", "ON_LOCK_ALREADY_LOCKED_BY_OWNER", BuildConfig.FLAVOR, "TRY_LOCK_SUCCESS", "I", "TRY_LOCK_FAILED", "TRY_LOCK_ALREADY_LOCKED_BY_OWNER", "HOLDS_LOCK_UNLOCKED", "HOLDS_LOCK_YES", "HOLDS_LOCK_ANOTHER_OWNER", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class MutexKt {
    private static final int HOLDS_LOCK_ANOTHER_OWNER = 2;
    private static final int HOLDS_LOCK_UNLOCKED = 0;
    private static final int HOLDS_LOCK_YES = 1;
    private static final Symbol NO_OWNER = new Symbol("NO_OWNER");
    private static final Symbol ON_LOCK_ALREADY_LOCKED_BY_OWNER = new Symbol("ALREADY_LOCKED_BY_OWNER");
    private static final int TRY_LOCK_ALREADY_LOCKED_BY_OWNER = 2;
    private static final int TRY_LOCK_FAILED = 1;
    private static final int TRY_LOCK_SUCCESS = 0;

    public static final Mutex Mutex(boolean z5) {
        return new MutexImpl(z5);
    }

    public static /* synthetic */ Mutex Mutex$default(boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        return Mutex(z5);
    }
}
