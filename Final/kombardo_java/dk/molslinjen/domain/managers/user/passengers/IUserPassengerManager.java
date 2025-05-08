package dk.molslinjen.domain.managers.user.passengers;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.merge.IAssetsMerger;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.account.UserPassenger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH¦@¢\u0006\u0002\u0010\nJ<\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0017\u001a\u00020\fH¦@¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001a\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u001bR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;", "Ldk/molslinjen/domain/managers/user/merge/IAssetsMerger;", "passengersState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/user/passengers/UserPassengersState;", "getPassengersState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadPassengers", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerPassenger", "Ldk/molslinjen/domain/model/account/UserPassenger;", "firstName", BuildConfig.FLAVOR, "lastName", "gender", "Ldk/molslinjen/domain/model/account/Gender;", "birthDate", "Lorg/threeten/bp/LocalDate;", "nationality", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/account/Gender;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePassenger", "updatedPassenger", "(Ldk/molslinjen/domain/model/account/UserPassenger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePassenger", "passengerLocalId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IUserPassengerManager extends IAssetsMerger {
    Object deletePassenger(String str, Continuation<? super ManagerResult<Unit>> continuation);

    StateFlow<UserPassengersState> getPassengersState();

    Object loadPassengers(Continuation<? super ManagerResult<Unit>> continuation);

    Object registerPassenger(String str, String str2, Gender gender, LocalDate localDate, String str3, Continuation<? super ManagerResult<UserPassenger>> continuation);

    Object updatePassenger(UserPassenger userPassenger, Continuation<? super ManagerResult<Unit>> continuation);
}
