package dk.molslinjen.domain.managers.user.brobizz;

import dk.molslinjen.domain.managers.ManagerResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH¦@¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0010\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000eR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/domain/managers/user/brobizz/IUserBrobizzManager;", BuildConfig.FLAVOR, "brobizzState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/user/brobizz/UserBrobizzState;", "getBrobizzState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadBrobizz", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerBrobizz", "brobizzNumber", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeBrobizz", "brobizzId", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IUserBrobizzManager {
    StateFlow<UserBrobizzState> getBrobizzState();

    Object loadBrobizz(Continuation<? super ManagerResult<Unit>> continuation);

    Object registerBrobizz(String str, Continuation<? super ManagerResult<Unit>> continuation);

    Object removeBrobizz(String str, Continuation<? super ManagerResult<Unit>> continuation);
}
