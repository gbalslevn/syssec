package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001R\u0014\u0010\u0004\u001a\u00020\u00018&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003R6\u0010\u000b\u001a$\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR6\u0010\u000e\u001a$\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005j\u0002`\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\nRH\u0010\u0013\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u000f\u0018\u00010\u0005j\u0004\u0018\u0001`\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\n\u0082\u0001\u0002\u0014\u0015¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/selects/SelectClause;", BuildConfig.FLAVOR, "getClauseObject", "()Ljava/lang/Object;", "clauseObject", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/selects/RegistrationFunction;", "getRegFunc", "()Lkotlin/jvm/functions/Function3;", "regFunc", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "getProcessResFunc", "processResFunc", "Lkotlin/Function1;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "getOnCancellationConstructor", "onCancellationConstructor", "Lkotlinx/coroutines/selects/SelectClause0;", "Lkotlinx/coroutines/selects/SelectClause1;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SelectClause {
    Object getClauseObject();

    Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> getOnCancellationConstructor();

    Function3<Object, Object, Object, Object> getProcessResFunc();

    Function3<Object, SelectInstance<?>, Object, Unit> getRegFunc();
}
