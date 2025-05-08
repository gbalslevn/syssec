package dk.molslinjen.domain.managers.user.vehicles;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.merge.IAssetsMerger;
import dk.molslinjen.domain.model.account.LicensePlateValidation;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.config.Site;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH¦@¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ.\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H¦@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0016\u001a\u00020\u0017H¦@¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001a\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ,\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\b2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H¦@¢\u0006\u0002\u0010!J2\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\b2\u0006\u0010\u001d\u001a\u00020\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0#2\u0006\u0010\u001f\u001a\u00020 H¦@¢\u0006\u0002\u0010$R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006%"}, d2 = {"Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;", "Ldk/molslinjen/domain/managers/user/merge/IAssetsMerger;", "vehiclesState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/user/vehicles/UserVehiclesState;", "getVehiclesState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadVehicles", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateLicensePlate", "Ldk/molslinjen/domain/model/account/LicensePlateValidation;", "licensePlate", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerVehicle", "name", "vehicleInfo", "Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateVehicle", "updatedVehicle", "Ldk/molslinjen/domain/model/account/UserVehicle;", "(Ldk/molslinjen/domain/model/account/UserVehicle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteVehicle", Constants.ID_ATTRIBUTE_KEY, "validateVehicle", BuildConfig.FLAVOR, "vehicle", "carId", "site", "Ldk/molslinjen/domain/model/config/Site;", "(Ldk/molslinjen/domain/model/account/UserVehicle;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "carIds", BuildConfig.FLAVOR, "(Ldk/molslinjen/domain/model/account/UserVehicle;Ljava/util/List;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IUserVehiclesManager extends IAssetsMerger {
    Object deleteVehicle(String str, Continuation<? super ManagerResult<Unit>> continuation);

    StateFlow<UserVehiclesState> getVehiclesState();

    Object loadVehicles(Continuation<? super ManagerResult<Unit>> continuation);

    Object registerVehicle(String str, String str2, LicensePlateValidation.Valid valid, Continuation<? super ManagerResult<Unit>> continuation);

    Object updateVehicle(UserVehicle userVehicle, Continuation<? super ManagerResult<Unit>> continuation);

    Object validateLicensePlate(String str, Continuation<? super ManagerResult<? extends LicensePlateValidation>> continuation);

    Object validateVehicle(UserVehicle userVehicle, String str, Site site, Continuation<? super ManagerResult<Boolean>> continuation);

    Object validateVehicle(UserVehicle userVehicle, List<String> list, Site site, Continuation<? super ManagerResult<Boolean>> continuation);
}
