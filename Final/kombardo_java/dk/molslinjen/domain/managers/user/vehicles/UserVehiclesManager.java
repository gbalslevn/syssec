package dk.molslinjen.domain.managers.user.vehicles;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.helpers.NetworkStatus;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.account.vehicle.IAccountVehicleService;
import dk.molslinjen.api.services.account.vehicle.request.UpdateVehicleRequestParameter;
import dk.molslinjen.api.services.account.vehicle.response.LicensePlateValidationResultResponseDTO;
import dk.molslinjen.api.services.account.vehicle.response.VehicleLicensePlateValidationDTO;
import dk.molslinjen.api.services.account.vehicle.response.VehicleValidationDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.extensions.ApiResultExtensionsKt;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.localstorage.vehicle.IVehicleRepository;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.merge.AssetsMergeType;
import dk.molslinjen.domain.model.account.AuthToken;
import dk.molslinjen.domain.model.account.LicensePlateValidation;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.providers.IStringsProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0096@¢\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ.\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096@¢\u0006\u0002\u0010!J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010'\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ,\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0006\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J2\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0006\u0010)\u001a\u00020$2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001b0/2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u00100J\u000e\u00101\u001a\u000202H\u0096@¢\u0006\u0002\u0010\u0017J\u000e\u00103\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u00064"}, d2 = {"Ldk/molslinjen/domain/managers/user/vehicles/UserVehiclesManager;", "Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;", "vehiclesService", "Ldk/molslinjen/api/services/account/vehicle/IAccountVehicleService;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "vehicleRepository", "Ldk/molslinjen/domain/localstorage/vehicle/IVehicleRepository;", "stringsProvider", "Ldk/molslinjen/domain/providers/IStringsProvider;", "<init>", "(Ldk/molslinjen/api/services/account/vehicle/IAccountVehicleService;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/domain/localstorage/vehicle/IVehicleRepository;Ldk/molslinjen/domain/providers/IStringsProvider;)V", "isAuthenticated", BuildConfig.FLAVOR, "()Z", "vehiclesState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/user/vehicles/UserVehiclesState;", "getVehiclesState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "loadVehicles", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateLicensePlate", "Ldk/molslinjen/domain/model/account/LicensePlateValidation;", "licensePlate", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerVehicle", "name", "vehicleInfo", "Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateVehicle", "updatedVehicle", "Ldk/molslinjen/domain/model/account/UserVehicle;", "(Ldk/molslinjen/domain/model/account/UserVehicle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteVehicle", Constants.ID_ATTRIBUTE_KEY, "validateVehicle", "vehicle", "carId", "site", "Ldk/molslinjen/domain/model/config/Site;", "(Ldk/molslinjen/domain/model/account/UserVehicle;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "carIds", BuildConfig.FLAVOR, "(Ldk/molslinjen/domain/model/account/UserVehicle;Ljava/util/List;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportLocalAssets", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType$VehiclesAssets;", "removeLocalAssets", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserVehiclesManager implements IUserVehiclesManager {
    private final IStringsProvider stringsProvider;
    private final IUserManager userManager;
    private final IVehicleRepository vehicleRepository;
    private final IAccountVehicleService vehiclesService;
    private final MutableStateFlow<UserVehiclesState> vehiclesState;

    public UserVehiclesManager(IAccountVehicleService vehiclesService, IUserManager userManager, IVehicleRepository vehicleRepository, IStringsProvider stringsProvider) {
        Intrinsics.checkNotNullParameter(vehiclesService, "vehiclesService");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(vehicleRepository, "vehicleRepository");
        Intrinsics.checkNotNullParameter(stringsProvider, "stringsProvider");
        this.vehiclesService = vehiclesService;
        this.userManager = userManager;
        this.vehicleRepository = vehicleRepository;
        this.stringsProvider = stringsProvider;
        this.vehiclesState = StateFlowKt.MutableStateFlow(new UserVehiclesState(null, 1, null));
    }

    private final boolean isAuthenticated() {
        return this.userManager.getAuthenticationType().getValue().isAuthenticated();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deleteVehicle(String str, Continuation<? super ManagerResult<Unit>> continuation) {
        UserVehiclesManager$deleteVehicle$1 userVehiclesManager$deleteVehicle$1;
        int i5;
        UserVehiclesManager userVehiclesManager;
        UserVehiclesManager userVehiclesManager2;
        List<UserVehicle> list;
        MutableStateFlow<UserVehiclesState> vehiclesState;
        UserVehiclesState value;
        if (continuation instanceof UserVehiclesManager$deleteVehicle$1) {
            userVehiclesManager$deleteVehicle$1 = (UserVehiclesManager$deleteVehicle$1) continuation;
            int i6 = userVehiclesManager$deleteVehicle$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userVehiclesManager$deleteVehicle$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userVehiclesManager$deleteVehicle$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userVehiclesManager$deleteVehicle$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!isAuthenticated()) {
                        IVehicleRepository iVehicleRepository = this.vehicleRepository;
                        userVehiclesManager$deleteVehicle$1.L$0 = this;
                        userVehiclesManager$deleteVehicle$1.label = 3;
                        obj = iVehicleRepository.deleteVehicle(str, userVehiclesManager$deleteVehicle$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userVehiclesManager = this;
                        list = (List) obj;
                        vehiclesState = userVehiclesManager.getVehiclesState();
                        do {
                            value = vehiclesState.getValue();
                        } while (!vehiclesState.compareAndSet(value, value.copy(list)));
                        return new ManagerResult.Success(Unit.INSTANCE);
                    }
                    String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IAccountVehicleService iAccountVehicleService = this.vehiclesService;
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    userVehiclesManager$deleteVehicle$1.L$0 = this;
                    userVehiclesManager$deleteVehicle$1.L$1 = str;
                    userVehiclesManager$deleteVehicle$1.label = 1;
                    obj = iAccountVehicleService.deleteVehicle(str, m3214toDTOimpl, userVehiclesManager$deleteVehicle$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userVehiclesManager2 = this;
                    UserVehiclesManager$deleteVehicle$2 userVehiclesManager$deleteVehicle$2 = new UserVehiclesManager$deleteVehicle$2(userVehiclesManager2, str, null);
                    userVehiclesManager$deleteVehicle$1.L$0 = null;
                    userVehiclesManager$deleteVehicle$1.L$1 = null;
                    userVehiclesManager$deleteVehicle$1.label = 2;
                    obj = ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj, userVehiclesManager$deleteVehicle$2, userVehiclesManager$deleteVehicle$1);
                    if (obj != coroutine_suspended) {
                    }
                } else if (i5 == 1) {
                    str = (String) userVehiclesManager$deleteVehicle$1.L$1;
                    userVehiclesManager2 = (UserVehiclesManager) userVehiclesManager$deleteVehicle$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    UserVehiclesManager$deleteVehicle$2 userVehiclesManager$deleteVehicle$22 = new UserVehiclesManager$deleteVehicle$2(userVehiclesManager2, str, null);
                    userVehiclesManager$deleteVehicle$1.L$0 = null;
                    userVehiclesManager$deleteVehicle$1.L$1 = null;
                    userVehiclesManager$deleteVehicle$1.label = 2;
                    obj = ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj, userVehiclesManager$deleteVehicle$22, userVehiclesManager$deleteVehicle$1);
                    if (obj != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        userVehiclesManager = (UserVehiclesManager) userVehiclesManager$deleteVehicle$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        list = (List) obj;
                        vehiclesState = userVehiclesManager.getVehiclesState();
                        do {
                            value = vehiclesState.getValue();
                        } while (!vehiclesState.compareAndSet(value, value.copy(list)));
                        return new ManagerResult.Success(Unit.INSTANCE);
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return obj;
            }
        }
        userVehiclesManager$deleteVehicle$1 = new UserVehiclesManager$deleteVehicle$1(this, continuation);
        Object obj2 = userVehiclesManager$deleteVehicle$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userVehiclesManager$deleteVehicle$1.label;
        if (i5 != 0) {
        }
        return obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009c A[PHI: r9
      0x009c: PHI (r9v14 java.lang.Object) = (r9v13 java.lang.Object), (r9v1 java.lang.Object) binds: [B:27:0x0099, B:23:0x0040] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadVehicles(Continuation<? super ManagerResult<Unit>> continuation) {
        UserVehiclesManager$loadVehicles$1 userVehiclesManager$loadVehicles$1;
        int i5;
        UserVehiclesManager userVehiclesManager;
        UserVehiclesManager userVehiclesManager2;
        ApiResult apiResult;
        UserVehiclesManager$loadVehicles$2 userVehiclesManager$loadVehicles$2;
        ApiResult apiResult2;
        List<UserVehicle> list;
        MutableStateFlow<UserVehiclesState> vehiclesState;
        UserVehiclesState value;
        if (continuation instanceof UserVehiclesManager$loadVehicles$1) {
            userVehiclesManager$loadVehicles$1 = (UserVehiclesManager$loadVehicles$1) continuation;
            int i6 = userVehiclesManager$loadVehicles$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userVehiclesManager$loadVehicles$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userVehiclesManager$loadVehicles$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userVehiclesManager$loadVehicles$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!isAuthenticated()) {
                        IVehicleRepository iVehicleRepository = this.vehicleRepository;
                        userVehiclesManager$loadVehicles$1.L$0 = this;
                        userVehiclesManager$loadVehicles$1.label = 4;
                        obj = iVehicleRepository.getVehicles(userVehiclesManager$loadVehicles$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userVehiclesManager = this;
                        list = (List) obj;
                        vehiclesState = userVehiclesManager.getVehiclesState();
                        do {
                            value = vehiclesState.getValue();
                        } while (!vehiclesState.compareAndSet(value, value.copy(list)));
                        return new ManagerResult.Success(Unit.INSTANCE);
                    }
                    String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IAccountVehicleService iAccountVehicleService = this.vehiclesService;
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    userVehiclesManager$loadVehicles$1.L$0 = this;
                    userVehiclesManager$loadVehicles$1.label = 1;
                    obj = iAccountVehicleService.getVehicles(m3214toDTOimpl, userVehiclesManager$loadVehicles$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userVehiclesManager2 = this;
                    apiResult = (ApiResult) obj;
                    userVehiclesManager$loadVehicles$2 = new UserVehiclesManager$loadVehicles$2(userVehiclesManager2, null);
                    userVehiclesManager$loadVehicles$1.L$0 = apiResult;
                    userVehiclesManager$loadVehicles$1.label = 2;
                    if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, userVehiclesManager$loadVehicles$2, userVehiclesManager$loadVehicles$1) != coroutine_suspended) {
                    }
                } else if (i5 == 1) {
                    userVehiclesManager2 = (UserVehiclesManager) userVehiclesManager$loadVehicles$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    apiResult = (ApiResult) obj;
                    userVehiclesManager$loadVehicles$2 = new UserVehiclesManager$loadVehicles$2(userVehiclesManager2, null);
                    userVehiclesManager$loadVehicles$1.L$0 = apiResult;
                    userVehiclesManager$loadVehicles$1.label = 2;
                    if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, userVehiclesManager$loadVehicles$2, userVehiclesManager$loadVehicles$1) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    apiResult2 = apiResult;
                } else {
                    if (i5 != 2) {
                        if (i5 == 3) {
                            ResultKt.throwOnFailure(obj);
                        }
                        if (i5 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        userVehiclesManager = (UserVehiclesManager) userVehiclesManager$loadVehicles$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        list = (List) obj;
                        vehiclesState = userVehiclesManager.getVehiclesState();
                        do {
                            value = vehiclesState.getValue();
                        } while (!vehiclesState.compareAndSet(value, value.copy(list)));
                        return new ManagerResult.Success(Unit.INSTANCE);
                    }
                    apiResult2 = (ApiResult) userVehiclesManager$loadVehicles$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                userVehiclesManager$loadVehicles$1.L$0 = null;
                userVehiclesManager$loadVehicles$1.label = 3;
                obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult2, userVehiclesManager$loadVehicles$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        userVehiclesManager$loadVehicles$1 = new UserVehiclesManager$loadVehicles$1(this, continuation);
        Object obj2 = userVehiclesManager$loadVehicles$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userVehiclesManager$loadVehicles$1.label;
        if (i5 != 0) {
        }
        userVehiclesManager$loadVehicles$1.L$0 = null;
        userVehiclesManager$loadVehicles$1.label = 3;
        obj2 = ApiResultExtensionsKt.toUnitManagerResult(apiResult2, userVehiclesManager$loadVehicles$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0187 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0173 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011a A[EDGE_INSN: B:61:0x011a->B:32:0x011a BREAK  A[LOOP:0: B:54:0x00f9->B:60:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c7 A[PHI: r3
      0x00c7: PHI (r3v11 java.lang.Object) = (r3v10 java.lang.Object), (r3v1 java.lang.Object) binds: [B:66:0x00c4, B:62:0x006b] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    @Override // dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object registerVehicle(String str, String str2, LicensePlateValidation.Valid valid, Continuation<? super ManagerResult<Unit>> continuation) {
        UserVehiclesManager$registerVehicle$1 userVehiclesManager$registerVehicle$1;
        int i5;
        UserVehiclesManager userVehiclesManager;
        String str3;
        String str4;
        LicensePlateValidation.Valid valid2;
        UserVehiclesManager userVehiclesManager2;
        Iterable iterable;
        Iterator it;
        UserVehiclesManager userVehiclesManager3;
        String model;
        String manufacturer;
        boolean z5;
        if (continuation instanceof UserVehiclesManager$registerVehicle$1) {
            userVehiclesManager$registerVehicle$1 = (UserVehiclesManager$registerVehicle$1) continuation;
            int i6 = userVehiclesManager$registerVehicle$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userVehiclesManager$registerVehicle$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userVehiclesManager$registerVehicle$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userVehiclesManager$registerVehicle$1.label;
                String str5 = BuildConfig.FLAVOR;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (isAuthenticated()) {
                        String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                        if (mo3198getAuthTokenOEbVFrA == null) {
                            return ManagerResult.Error.INSTANCE.noMessage();
                        }
                        IAccountVehicleService iAccountVehicleService = this.vehiclesService;
                        String nullIfEmpty = StringExtensionsKt.nullIfEmpty(str);
                        if (nullIfEmpty == null) {
                            String displayName = valid != null ? valid.displayName() : null;
                            if (displayName != null) {
                                str5 = displayName;
                            }
                        } else {
                            str5 = nullIfEmpty;
                        }
                        AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                        userVehiclesManager$registerVehicle$1.L$0 = this;
                        userVehiclesManager$registerVehicle$1.label = 1;
                        obj = iAccountVehicleService.registerVehicle(str5, str2, m3214toDTOimpl, userVehiclesManager$registerVehicle$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userVehiclesManager2 = this;
                        UserVehiclesManager$registerVehicle$2 userVehiclesManager$registerVehicle$2 = new UserVehiclesManager$registerVehicle$2(userVehiclesManager2, null);
                        userVehiclesManager$registerVehicle$1.L$0 = null;
                        userVehiclesManager$registerVehicle$1.label = 2;
                        obj = ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj, userVehiclesManager$registerVehicle$2, userVehiclesManager$registerVehicle$1);
                        if (obj != coroutine_suspended) {
                        }
                    } else {
                        IVehicleRepository iVehicleRepository = this.vehicleRepository;
                        userVehiclesManager$registerVehicle$1.L$0 = this;
                        userVehiclesManager$registerVehicle$1.L$1 = str;
                        userVehiclesManager$registerVehicle$1.L$2 = str2;
                        userVehiclesManager$registerVehicle$1.L$3 = valid;
                        userVehiclesManager$registerVehicle$1.label = 3;
                        obj = iVehicleRepository.getVehicles(userVehiclesManager$registerVehicle$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userVehiclesManager = this;
                        str3 = str;
                        str4 = str2;
                        valid2 = valid;
                        iterable = (Iterable) obj;
                        if (iterable instanceof Collection) {
                        }
                        it = iterable.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                            }
                        }
                        IVehicleRepository iVehicleRepository2 = userVehiclesManager.vehicleRepository;
                        String uuid = UUID.randomUUID().toString();
                        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
                        UserVehicle userVehicle = new UserVehicle(uuid, str3, str4, (valid2 != null || (manufacturer = valid2.getManufacturer()) == null) ? BuildConfig.FLAVOR : manufacturer, (valid2 != null || (model = valid2.getModel()) == null) ? BuildConfig.FLAVOR : model, valid2 == null ? valid2.getHeightInMeters() : null, valid2 == null ? valid2.getLengthInMeters() : null);
                        userVehiclesManager$registerVehicle$1.L$0 = userVehiclesManager;
                        userVehiclesManager$registerVehicle$1.L$1 = null;
                        userVehiclesManager$registerVehicle$1.L$2 = null;
                        userVehiclesManager$registerVehicle$1.L$3 = null;
                        userVehiclesManager$registerVehicle$1.label = 4;
                        obj = iVehicleRepository2.save(userVehicle, userVehiclesManager$registerVehicle$1);
                        if (obj != coroutine_suspended) {
                        }
                    }
                } else {
                    if (i5 == 1) {
                        userVehiclesManager2 = (UserVehiclesManager) userVehiclesManager$registerVehicle$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        UserVehiclesManager$registerVehicle$2 userVehiclesManager$registerVehicle$22 = new UserVehiclesManager$registerVehicle$2(userVehiclesManager2, null);
                        userVehiclesManager$registerVehicle$1.L$0 = null;
                        userVehiclesManager$registerVehicle$1.label = 2;
                        obj = ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj, userVehiclesManager$registerVehicle$22, userVehiclesManager$registerVehicle$1);
                        return obj != coroutine_suspended ? coroutine_suspended : obj;
                    }
                    if (i5 == 2) {
                        ResultKt.throwOnFailure(obj);
                    }
                    if (i5 == 3) {
                        valid2 = (LicensePlateValidation.Valid) userVehiclesManager$registerVehicle$1.L$3;
                        str4 = (String) userVehiclesManager$registerVehicle$1.L$2;
                        String str6 = (String) userVehiclesManager$registerVehicle$1.L$1;
                        userVehiclesManager = (UserVehiclesManager) userVehiclesManager$registerVehicle$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        str3 = str6;
                        iterable = (Iterable) obj;
                        if ((iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                            it = iterable.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                if (StringsKt.equals(((UserVehicle) it.next()).getLicensePlate(), str4, true)) {
                                    new ManagerResult.Error.ErrorString(null, userVehiclesManager.stringsProvider.getValidationLicensePlateExists(), 1, null);
                                    break;
                                }
                            }
                        }
                        IVehicleRepository iVehicleRepository22 = userVehiclesManager.vehicleRepository;
                        String uuid2 = UUID.randomUUID().toString();
                        Intrinsics.checkNotNullExpressionValue(uuid2, "toString(...)");
                        UserVehicle userVehicle2 = new UserVehicle(uuid2, str3, str4, (valid2 != null || (manufacturer = valid2.getManufacturer()) == null) ? BuildConfig.FLAVOR : manufacturer, (valid2 != null || (model = valid2.getModel()) == null) ? BuildConfig.FLAVOR : model, valid2 == null ? valid2.getHeightInMeters() : null, valid2 == null ? valid2.getLengthInMeters() : null);
                        userVehiclesManager$registerVehicle$1.L$0 = userVehiclesManager;
                        userVehiclesManager$registerVehicle$1.L$1 = null;
                        userVehiclesManager$registerVehicle$1.L$2 = null;
                        userVehiclesManager$registerVehicle$1.L$3 = null;
                        userVehiclesManager$registerVehicle$1.label = 4;
                        obj = iVehicleRepository22.save(userVehicle2, userVehiclesManager$registerVehicle$1);
                        if (obj != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userVehiclesManager3 = userVehiclesManager;
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        userVehiclesManager$registerVehicle$1.L$0 = null;
                        userVehiclesManager$registerVehicle$1.Z$0 = booleanValue;
                        userVehiclesManager$registerVehicle$1.label = 5;
                        if (userVehiclesManager3.loadVehicles(userVehiclesManager$registerVehicle$1) != coroutine_suspended) {
                        }
                    } else if (i5 == 4) {
                        userVehiclesManager3 = (UserVehiclesManager) userVehiclesManager$registerVehicle$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        boolean booleanValue2 = ((Boolean) obj).booleanValue();
                        userVehiclesManager$registerVehicle$1.L$0 = null;
                        userVehiclesManager$registerVehicle$1.Z$0 = booleanValue2;
                        userVehiclesManager$registerVehicle$1.label = 5;
                        if (userVehiclesManager3.loadVehicles(userVehiclesManager$registerVehicle$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z5 = booleanValue2;
                    } else {
                        if (i5 != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        z5 = userVehiclesManager$registerVehicle$1.Z$0;
                        ResultKt.throwOnFailure(obj);
                    }
                }
                return !z5 ? new ManagerResult.Success(Unit.INSTANCE) : ManagerResult.Error.INSTANCE.noMessage();
            }
        }
        userVehiclesManager$registerVehicle$1 = new UserVehiclesManager$registerVehicle$1(this, continuation);
        Object obj2 = userVehiclesManager$registerVehicle$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userVehiclesManager$registerVehicle$1.label;
        String str52 = BuildConfig.FLAVOR;
        if (i5 != 0) {
        }
        if (!z5) {
        }
    }

    @Override // dk.molslinjen.domain.managers.user.merge.IAssetsMerger
    public Object removeLocalAssets(Continuation<? super Unit> continuation) {
        UserVehiclesState value;
        MutableStateFlow<UserVehiclesState> vehiclesState = getVehiclesState();
        do {
            value = vehiclesState.getValue();
        } while (!vehiclesState.compareAndSet(value, value.copy(CollectionsKt.emptyList())));
        Object clear = this.vehicleRepository.clear(continuation);
        return clear == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clear : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.user.merge.IAssetsMerger
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object reportLocalAssets(Continuation<? super AssetsMergeType.VehiclesAssets> continuation) {
        UserVehiclesManager$reportLocalAssets$1 userVehiclesManager$reportLocalAssets$1;
        int i5;
        List<UserVehicle> vehicles;
        if (continuation instanceof UserVehiclesManager$reportLocalAssets$1) {
            userVehiclesManager$reportLocalAssets$1 = (UserVehiclesManager$reportLocalAssets$1) continuation;
            int i6 = userVehiclesManager$reportLocalAssets$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userVehiclesManager$reportLocalAssets$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userVehiclesManager$reportLocalAssets$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userVehiclesManager$reportLocalAssets$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    vehicles = getVehiclesState().getValue().getVehicles();
                    if (vehicles.isEmpty()) {
                        IVehicleRepository iVehicleRepository = this.vehicleRepository;
                        userVehiclesManager$reportLocalAssets$1.label = 1;
                        obj = iVehicleRepository.getVehicles(userVehiclesManager$reportLocalAssets$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return new AssetsMergeType.VehiclesAssets(vehicles);
                }
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                vehicles = (List) obj;
                return new AssetsMergeType.VehiclesAssets(vehicles);
            }
        }
        userVehiclesManager$reportLocalAssets$1 = new UserVehiclesManager$reportLocalAssets$1(this, continuation);
        Object obj2 = userVehiclesManager$reportLocalAssets$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userVehiclesManager$reportLocalAssets$1.label;
        if (i5 != 0) {
        }
        vehicles = (List) obj2;
        return new AssetsMergeType.VehiclesAssets(vehicles);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009f A[PHI: r10
      0x009f: PHI (r10v12 java.lang.Object) = (r10v11 java.lang.Object), (r10v1 java.lang.Object) binds: [B:30:0x009c, B:26:0x0046] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateVehicle(UserVehicle userVehicle, Continuation<? super ManagerResult<Unit>> continuation) {
        UserVehiclesManager$updateVehicle$1 userVehiclesManager$updateVehicle$1;
        int i5;
        UserVehiclesManager userVehiclesManager;
        UserVehiclesManager userVehiclesManager2;
        boolean z5;
        if (continuation instanceof UserVehiclesManager$updateVehicle$1) {
            userVehiclesManager$updateVehicle$1 = (UserVehiclesManager$updateVehicle$1) continuation;
            int i6 = userVehiclesManager$updateVehicle$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userVehiclesManager$updateVehicle$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userVehiclesManager$updateVehicle$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userVehiclesManager$updateVehicle$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (isAuthenticated()) {
                        String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                        if (mo3198getAuthTokenOEbVFrA == null) {
                            return ManagerResult.Error.INSTANCE.noMessage();
                        }
                        UpdateVehicleRequestParameter updateVehicleRequestParameter = new UpdateVehicleRequestParameter(userVehicle.getId(), userVehicle.getName(), userVehicle.getLicensePlate());
                        IAccountVehicleService iAccountVehicleService = this.vehiclesService;
                        AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                        userVehiclesManager$updateVehicle$1.L$0 = this;
                        userVehiclesManager$updateVehicle$1.label = 1;
                        obj = iAccountVehicleService.updateVehicle(updateVehicleRequestParameter, m3214toDTOimpl, userVehiclesManager$updateVehicle$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userVehiclesManager2 = this;
                        UserVehiclesManager$updateVehicle$2 userVehiclesManager$updateVehicle$2 = new UserVehiclesManager$updateVehicle$2(userVehiclesManager2, null);
                        userVehiclesManager$updateVehicle$1.L$0 = null;
                        userVehiclesManager$updateVehicle$1.label = 2;
                        obj = ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj, userVehiclesManager$updateVehicle$2, userVehiclesManager$updateVehicle$1);
                        if (obj != coroutine_suspended) {
                        }
                    } else {
                        IVehicleRepository iVehicleRepository = this.vehicleRepository;
                        userVehiclesManager$updateVehicle$1.L$0 = this;
                        userVehiclesManager$updateVehicle$1.label = 3;
                        obj = iVehicleRepository.updateVehicle(userVehicle, userVehiclesManager$updateVehicle$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userVehiclesManager = this;
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        userVehiclesManager$updateVehicle$1.L$0 = null;
                        userVehiclesManager$updateVehicle$1.Z$0 = booleanValue;
                        userVehiclesManager$updateVehicle$1.label = 4;
                        if (userVehiclesManager.loadVehicles(userVehiclesManager$updateVehicle$1) != coroutine_suspended) {
                        }
                    }
                } else {
                    if (i5 == 1) {
                        userVehiclesManager2 = (UserVehiclesManager) userVehiclesManager$updateVehicle$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        UserVehiclesManager$updateVehicle$2 userVehiclesManager$updateVehicle$22 = new UserVehiclesManager$updateVehicle$2(userVehiclesManager2, null);
                        userVehiclesManager$updateVehicle$1.L$0 = null;
                        userVehiclesManager$updateVehicle$1.label = 2;
                        obj = ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj, userVehiclesManager$updateVehicle$22, userVehiclesManager$updateVehicle$1);
                        return obj != coroutine_suspended ? coroutine_suspended : obj;
                    }
                    if (i5 == 2) {
                        ResultKt.throwOnFailure(obj);
                    }
                    if (i5 != 3) {
                        if (i5 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        z5 = userVehiclesManager$updateVehicle$1.Z$0;
                        ResultKt.throwOnFailure(obj);
                        return !z5 ? new ManagerResult.Success(Unit.INSTANCE) : ManagerResult.Error.INSTANCE.noMessage();
                    }
                    userVehiclesManager = (UserVehiclesManager) userVehiclesManager$updateVehicle$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    boolean booleanValue2 = ((Boolean) obj).booleanValue();
                    userVehiclesManager$updateVehicle$1.L$0 = null;
                    userVehiclesManager$updateVehicle$1.Z$0 = booleanValue2;
                    userVehiclesManager$updateVehicle$1.label = 4;
                    if (userVehiclesManager.loadVehicles(userVehiclesManager$updateVehicle$1) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z5 = booleanValue2;
                    if (!z5) {
                    }
                }
            }
        }
        userVehiclesManager$updateVehicle$1 = new UserVehiclesManager$updateVehicle$1(this, continuation);
        Object obj2 = userVehiclesManager$updateVehicle$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userVehiclesManager$updateVehicle$1.label;
        if (i5 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object validateLicensePlate(String str, Continuation<? super ManagerResult<? extends LicensePlateValidation>> continuation) {
        UserVehiclesManager$validateLicensePlate$1 userVehiclesManager$validateLicensePlate$1;
        int i5;
        ApiResult apiResult;
        if (continuation instanceof UserVehiclesManager$validateLicensePlate$1) {
            userVehiclesManager$validateLicensePlate$1 = (UserVehiclesManager$validateLicensePlate$1) continuation;
            int i6 = userVehiclesManager$validateLicensePlate$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userVehiclesManager$validateLicensePlate$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userVehiclesManager$validateLicensePlate$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userVehiclesManager$validateLicensePlate$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IAccountVehicleService iAccountVehicleService = this.vehiclesService;
                    userVehiclesManager$validateLicensePlate$1.label = 1;
                    obj = iAccountVehicleService.validateLicensePlate(str, userVehiclesManager$validateLicensePlate$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                apiResult = (ApiResult) obj;
                if (!(apiResult instanceof ApiResult.Error)) {
                    return ((ApiResult.Error) apiResult).getNetworkStatus() == NetworkStatus.NotFound ? new ManagerResult.Success(LicensePlateValidation.NotFound.INSTANCE) : ManagerResultExtensionsKt.toManagerResult(apiResult);
                }
                if (apiResult instanceof ApiResult.Success) {
                    return new ManagerResult.Success(new LicensePlateValidation.Valid((VehicleLicensePlateValidationDTO) ((ApiResult.Success) apiResult).getData()));
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        userVehiclesManager$validateLicensePlate$1 = new UserVehiclesManager$validateLicensePlate$1(this, continuation);
        Object obj2 = userVehiclesManager$validateLicensePlate$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userVehiclesManager$validateLicensePlate$1.label;
        if (i5 != 0) {
        }
        apiResult = (ApiResult) obj2;
        if (!(apiResult instanceof ApiResult.Error)) {
        }
    }

    @Override // dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager
    public Object validateVehicle(UserVehicle userVehicle, String str, Site site, Continuation<? super ManagerResult<Boolean>> continuation) {
        return validateVehicle(userVehicle, CollectionsKt.listOf(str), site, continuation);
    }

    @Override // dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager
    public MutableStateFlow<UserVehiclesState> getVehiclesState() {
        return this.vehiclesState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v15, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0094 -> B:10:0x0098). Please report as a decompilation issue!!! */
    @Override // dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object validateVehicle(UserVehicle userVehicle, List<String> list, Site site, Continuation<? super ManagerResult<Boolean>> continuation) {
        UserVehiclesManager$validateVehicle$2 userVehiclesManager$validateVehicle$2;
        int i5;
        UserVehiclesManager userVehiclesManager;
        UserVehicle userVehicle2;
        Collection collection;
        Site site2;
        Iterator it;
        ApiResult.Error error;
        ManagerResult managerResult;
        if (continuation instanceof UserVehiclesManager$validateVehicle$2) {
            userVehiclesManager$validateVehicle$2 = (UserVehiclesManager$validateVehicle$2) continuation;
            int i6 = userVehiclesManager$validateVehicle$2.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userVehiclesManager$validateVehicle$2.label = i6 - Integer.MIN_VALUE;
                Object obj = userVehiclesManager$validateVehicle$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userVehiclesManager$validateVehicle$2.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    List<String> list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    Iterator it2 = list2.iterator();
                    userVehiclesManager = this;
                    userVehicle2 = userVehicle;
                    collection = arrayList;
                    site2 = site;
                    it = it2;
                    if (it.hasNext()) {
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    collection = (Collection) userVehiclesManager$validateVehicle$2.L$5;
                    Iterator it3 = (Iterator) userVehiclesManager$validateVehicle$2.L$4;
                    Collection collection2 = (Collection) userVehiclesManager$validateVehicle$2.L$3;
                    Site site3 = (Site) userVehiclesManager$validateVehicle$2.L$2;
                    UserVehicle userVehicle3 = (UserVehicle) userVehiclesManager$validateVehicle$2.L$1;
                    userVehiclesManager = (UserVehiclesManager) userVehiclesManager$validateVehicle$2.L$0;
                    ResultKt.throwOnFailure(obj);
                    Iterator it4 = it3;
                    userVehicle2 = userVehicle3;
                    UserVehiclesManager$validateVehicle$2 userVehiclesManager$validateVehicle$22 = userVehiclesManager$validateVehicle$2;
                    Site site4 = site3;
                    Object validateVehicle = obj;
                    collection.add((ApiResult) validateVehicle);
                    collection = collection2;
                    it = it4;
                    site2 = site4;
                    userVehiclesManager$validateVehicle$2 = userVehiclesManager$validateVehicle$22;
                    if (it.hasNext()) {
                        String str = (String) it.next();
                        IAccountVehicleService iAccountVehicleService = userVehiclesManager.vehiclesService;
                        String licensePlate = userVehicle2.getLicensePlate();
                        SiteDTO dto = site2.toDTO();
                        userVehiclesManager$validateVehicle$2.L$0 = userVehiclesManager;
                        userVehiclesManager$validateVehicle$2.L$1 = userVehicle2;
                        userVehiclesManager$validateVehicle$2.L$2 = site2;
                        userVehiclesManager$validateVehicle$2.L$3 = collection;
                        userVehiclesManager$validateVehicle$2.L$4 = it;
                        userVehiclesManager$validateVehicle$2.L$5 = collection;
                        userVehiclesManager$validateVehicle$2.label = 1;
                        validateVehicle = iAccountVehicleService.validateVehicle(licensePlate, str, dto, userVehiclesManager$validateVehicle$2);
                        if (validateVehicle == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userVehiclesManager$validateVehicle$22 = userVehiclesManager$validateVehicle$2;
                        site4 = site2;
                        it4 = it;
                        collection2 = collection;
                        collection.add((ApiResult) validateVehicle);
                        collection = collection2;
                        it = it4;
                        site2 = site4;
                        userVehiclesManager$validateVehicle$2 = userVehiclesManager$validateVehicle$22;
                        if (it.hasNext()) {
                            List list3 = (List) collection;
                            if (!list3.isEmpty()) {
                                List<ApiResult> list4 = list3;
                                if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                                    for (ApiResult apiResult : list4) {
                                        if (apiResult instanceof ApiResult.Success) {
                                            ApiResult.Success success = (ApiResult.Success) apiResult;
                                            if (((VehicleValidationDTO) success.getData()).getValidationResult() != LicensePlateValidationResultResponseDTO.Valid && ((VehicleValidationDTO) success.getData()).getValidationResult() != LicensePlateValidationResultResponseDTO.Unknown) {
                                            }
                                        }
                                    }
                                }
                                Iterator it5 = list3.iterator();
                                while (true) {
                                    if (!it5.hasNext()) {
                                        error = 0;
                                        break;
                                    }
                                    error = it5.next();
                                    if (((ApiResult) error) instanceof ApiResult.Error) {
                                        break;
                                    }
                                }
                                ApiResult.Error error2 = error instanceof ApiResult.Error ? error : null;
                                return (error2 == null || (managerResult = ManagerResultExtensionsKt.toManagerResult(error2)) == null) ? new ManagerResult.Success(Boxing.boxBoolean(false)) : managerResult;
                            }
                            return new ManagerResult.Success(Boxing.boxBoolean(true));
                        }
                    }
                }
            }
        }
        userVehiclesManager$validateVehicle$2 = new UserVehiclesManager$validateVehicle$2(this, continuation);
        Object obj2 = userVehiclesManager$validateVehicle$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userVehiclesManager$validateVehicle$2.label;
        if (i5 != 0) {
        }
    }
}
