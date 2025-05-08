package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012(\u0010\b\u001a$\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007\u0012<\b\u0002\u0010\f\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t\u0018\u00010\u0004j\u0004\u0018\u0001`\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R<\u0010\b\u001a$\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014RN\u0010\f\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t\u0018\u00010\u0004j\u0004\u0018\u0001`\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R<\u0010\u0017\u001a$\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004j\u0002`\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/selects/SelectClause0Impl;", "Lkotlinx/coroutines/selects/SelectClause0;", BuildConfig.FLAVOR, "clauseObject", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/selects/RegistrationFunction;", "regFunc", "Lkotlin/Function1;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onCancellationConstructor", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;)V", "Ljava/lang/Object;", "getClauseObject", "()Ljava/lang/Object;", "Lkotlin/jvm/functions/Function3;", "getRegFunc", "()Lkotlin/jvm/functions/Function3;", "getOnCancellationConstructor", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "processResFunc", "getProcessResFunc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SelectClause0Impl implements SelectClause0 {
    private final Object clauseObject;
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onCancellationConstructor;
    private final Function3<Object, Object, Object, Object> processResFunc;
    private final Function3<Object, SelectInstance<?>, Object, Unit> regFunc;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectClause0Impl(Object obj, Function3<Object, ? super SelectInstance<?>, Object, Unit> function3, Function3<? super SelectInstance<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> function32) {
        Function3<Object, Object, Object, Object> function33;
        this.clauseObject = obj;
        this.regFunc = function3;
        this.onCancellationConstructor = function32;
        function33 = SelectKt.DUMMY_PROCESS_RESULT_FUNCTION;
        this.processResFunc = function33;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Object getClauseObject() {
        return this.clauseObject;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> getOnCancellationConstructor() {
        return this.onCancellationConstructor;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3<Object, Object, Object, Object> getProcessResFunc() {
        return this.processResFunc;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3<Object, SelectInstance<?>, Object, Unit> getRegFunc() {
        return this.regFunc;
    }

    public /* synthetic */ SelectClause0Impl(Object obj, Function3 function3, Function3 function32, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, function3, (i5 & 4) != 0 ? null : function32);
    }
}
