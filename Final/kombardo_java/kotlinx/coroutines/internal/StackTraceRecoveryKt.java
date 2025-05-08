package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFrames;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0007\"\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u001c\u0010\r\u001a\n \f*\u0004\u0018\u00010\u00050\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0007\"\u001c\u0010\u000e\u001a\n \f*\u0004\u0018\u00010\u00050\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0007*\f\b\u0000\u0010\u0010\"\u00020\u000f2\u00020\u000f*\f\b\u0000\u0010\u0011\"\u00020\t2\u00020\t¨\u0006\u0012"}, d2 = {BuildConfig.FLAVOR, "E", "exception", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", BuildConfig.FLAVOR, "baseContinuationImplClass", "Ljava/lang/String;", "stackTraceRecoveryClass", "Ljava/lang/StackTraceElement;", "ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "kotlin.jvm.PlatformType", "baseContinuationImplClassName", "stackTraceRecoveryClassName", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class StackTraceRecoveryKt {
    private static final StackTraceElement ARTIFICIAL_FRAME = new ArtificialStackFrames().coroutineBoundary();
    private static final String baseContinuationImplClass = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    private static final String baseContinuationImplClassName;
    private static final String stackTraceRecoveryClass = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    private static final String stackTraceRecoveryClassName;

    static {
        Object m3567constructorimpl;
        Object m3567constructorimpl2;
        try {
            Result.Companion companion = Result.INSTANCE;
            m3567constructorimpl = Result.m3567constructorimpl(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3567constructorimpl = Result.m3567constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m3570exceptionOrNullimpl(m3567constructorimpl) != null) {
            m3567constructorimpl = baseContinuationImplClass;
        }
        baseContinuationImplClassName = (String) m3567constructorimpl;
        try {
            m3567constructorimpl2 = Result.m3567constructorimpl(StackTraceRecoveryKt.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            m3567constructorimpl2 = Result.m3567constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m3570exceptionOrNullimpl(m3567constructorimpl2) != null) {
            m3567constructorimpl2 = stackTraceRecoveryClass;
        }
        stackTraceRecoveryClassName = (String) m3567constructorimpl2;
    }

    public static final <E extends Throwable> E recoverStackTrace(E e5) {
        return e5;
    }
}
