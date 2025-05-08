package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.Symbol;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\u0006\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\f\"6\u0010\u0010\u001a$\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\u0002`\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\"\u0014\u0010\u0014\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013\"\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013\"\u0014\u0010\u0016\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013\"\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019\"\u0014\u0010\u001b\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019\"\u0014\u0010\u001c\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019\"\u001a\u0010\u001d\u001a\u00020\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001f*d\b\u0007\u0010!\".\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00020\r2.\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00020\r*H\b\u0007\u0010\"\" \u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2 \u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r*H\b\u0007\u0010#\" \u0012\u0004\u0012\u00020\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00010\r2 \u0012\u0004\u0012\u00020\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00010\r¨\u0006$"}, d2 = {"Lkotlinx/coroutines/CancellableContinuation;", BuildConfig.FLAVOR, "Lkotlin/Function1;", BuildConfig.FLAVOR, "onCancellation", BuildConfig.FLAVOR, "tryResume", "(Lkotlinx/coroutines/CancellableContinuation;Lkotlin/jvm/functions/Function1;)Z", BuildConfig.FLAVOR, "trySelectInternalResult", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "TrySelectDetailedResult", "(I)Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "Lkotlin/Function3;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/selects/ProcessResultFunction;", "DUMMY_PROCESS_RESULT_FUNCTION", "Lkotlin/jvm/functions/Function3;", "TRY_SELECT_SUCCESSFUL", "I", "TRY_SELECT_REREGISTER", "TRY_SELECT_CANCELLED", "TRY_SELECT_ALREADY_SELECTED", "Lkotlinx/coroutines/internal/Symbol;", "STATE_REG", "Lkotlinx/coroutines/internal/Symbol;", "STATE_COMPLETED", "STATE_CANCELLED", "NO_RESULT", "PARAM_CLAUSE_0", "getPARAM_CLAUSE_0", "()Lkotlinx/coroutines/internal/Symbol;", "Lkotlinx/coroutines/selects/SelectInstance;", "OnCancellationConstructor", "ProcessResultFunction", "RegistrationFunction", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SelectKt {
    private static final int TRY_SELECT_ALREADY_SELECTED = 3;
    private static final int TRY_SELECT_CANCELLED = 2;
    private static final int TRY_SELECT_REREGISTER = 1;
    private static final int TRY_SELECT_SUCCESSFUL = 0;
    private static final Function3<Object, Object, Object, Object> DUMMY_PROCESS_RESULT_FUNCTION = new Function3() { // from class: kotlinx.coroutines.selects.SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1
        @Override // kotlin.jvm.functions.Function3
        public final Void invoke(Object obj, Object obj2, Object obj3) {
            return null;
        }
    };
    private static final Symbol STATE_REG = new Symbol("STATE_REG");
    private static final Symbol STATE_COMPLETED = new Symbol("STATE_COMPLETED");
    private static final Symbol STATE_CANCELLED = new Symbol("STATE_CANCELLED");
    private static final Symbol NO_RESULT = new Symbol("NO_RESULT");
    private static final Symbol PARAM_CLAUSE_0 = new Symbol("PARAM_CLAUSE_0");

    /* JADX INFO: Access modifiers changed from: private */
    public static final TrySelectDetailedResult TrySelectDetailedResult(int i5) {
        if (i5 == 0) {
            return TrySelectDetailedResult.SUCCESSFUL;
        }
        if (i5 == 1) {
            return TrySelectDetailedResult.REREGISTER;
        }
        if (i5 == 2) {
            return TrySelectDetailedResult.CANCELLED;
        }
        if (i5 == 3) {
            return TrySelectDetailedResult.ALREADY_SELECTED;
        }
        throw new IllegalStateException(("Unexpected internal result: " + i5).toString());
    }

    public static final Symbol getPARAM_CLAUSE_0() {
        return PARAM_CLAUSE_0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean tryResume(CancellableContinuation<? super Unit> cancellableContinuation, Function1<? super Throwable, Unit> function1) {
        Object tryResume = cancellableContinuation.tryResume(Unit.INSTANCE, null, function1);
        if (tryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(tryResume);
        return true;
    }
}
