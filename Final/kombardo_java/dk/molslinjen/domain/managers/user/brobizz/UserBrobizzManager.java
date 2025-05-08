package dk.molslinjen.domain.managers.user.brobizz;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.brobizz.IAccountBrobizzService;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.domain.extensions.ApiResultExtensionsKt;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.AuthToken;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0096@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0016\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/domain/managers/user/brobizz/UserBrobizzManager;", "Ldk/molslinjen/domain/managers/user/brobizz/IUserBrobizzManager;", "brobizzService", "Ldk/molslinjen/api/services/account/brobizz/IAccountBrobizzService;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "<init>", "(Ldk/molslinjen/api/services/account/brobizz/IAccountBrobizzService;Ldk/molslinjen/domain/managers/user/IUserManager;)V", "brobizzState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/user/brobizz/UserBrobizzState;", "getBrobizzState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "loadBrobizz", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerBrobizz", "brobizzNumber", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeBrobizz", "brobizzId", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserBrobizzManager implements IUserBrobizzManager {
    private final IAccountBrobizzService brobizzService;
    private final MutableStateFlow<UserBrobizzState> brobizzState;
    private final IUserManager userManager;

    public UserBrobizzManager(IAccountBrobizzService brobizzService, IUserManager userManager) {
        Intrinsics.checkNotNullParameter(brobizzService, "brobizzService");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        this.brobizzService = brobizzService;
        this.userManager = userManager;
        this.brobizzState = StateFlowKt.MutableStateFlow(new UserBrobizzState(null, 1, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008a A[PHI: r8
      0x008a: PHI (r8v11 java.lang.Object) = (r8v10 java.lang.Object), (r8v1 java.lang.Object) binds: [B:18:0x0087, B:11:0x002c] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // dk.molslinjen.domain.managers.user.brobizz.IUserBrobizzManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadBrobizz(Continuation<? super ManagerResult<Unit>> continuation) {
        UserBrobizzManager$loadBrobizz$1 userBrobizzManager$loadBrobizz$1;
        Object coroutine_suspended;
        int i5;
        UserBrobizzManager userBrobizzManager;
        ApiResult apiResult;
        UserBrobizzManager$loadBrobizz$2 userBrobizzManager$loadBrobizz$2;
        ApiResult apiResult2;
        if (continuation instanceof UserBrobizzManager$loadBrobizz$1) {
            userBrobizzManager$loadBrobizz$1 = (UserBrobizzManager$loadBrobizz$1) continuation;
            int i6 = userBrobizzManager$loadBrobizz$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userBrobizzManager$loadBrobizz$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userBrobizzManager$loadBrobizz$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userBrobizzManager$loadBrobizz$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IAccountBrobizzService iAccountBrobizzService = this.brobizzService;
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    userBrobizzManager$loadBrobizz$1.L$0 = this;
                    userBrobizzManager$loadBrobizz$1.label = 1;
                    obj = iAccountBrobizzService.getBrobizz(m3214toDTOimpl, userBrobizzManager$loadBrobizz$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userBrobizzManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 == 3) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        apiResult2 = (ApiResult) userBrobizzManager$loadBrobizz$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        userBrobizzManager$loadBrobizz$1.L$0 = null;
                        userBrobizzManager$loadBrobizz$1.label = 3;
                        obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult2, userBrobizzManager$loadBrobizz$1);
                        return obj != coroutine_suspended ? coroutine_suspended : obj;
                    }
                    userBrobizzManager = (UserBrobizzManager) userBrobizzManager$loadBrobizz$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                apiResult = (ApiResult) obj;
                userBrobizzManager$loadBrobizz$2 = new UserBrobizzManager$loadBrobizz$2(userBrobizzManager, null);
                userBrobizzManager$loadBrobizz$1.L$0 = apiResult;
                userBrobizzManager$loadBrobizz$1.label = 2;
                if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, userBrobizzManager$loadBrobizz$2, userBrobizzManager$loadBrobizz$1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiResult2 = apiResult;
                userBrobizzManager$loadBrobizz$1.L$0 = null;
                userBrobizzManager$loadBrobizz$1.label = 3;
                obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult2, userBrobizzManager$loadBrobizz$1);
                if (obj != coroutine_suspended) {
                }
            }
        }
        userBrobizzManager$loadBrobizz$1 = new UserBrobizzManager$loadBrobizz$1(this, continuation);
        Object obj2 = userBrobizzManager$loadBrobizz$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userBrobizzManager$loadBrobizz$1.label;
        if (i5 != 0) {
        }
        apiResult = (ApiResult) obj2;
        userBrobizzManager$loadBrobizz$2 = new UserBrobizzManager$loadBrobizz$2(userBrobizzManager, null);
        userBrobizzManager$loadBrobizz$1.L$0 = apiResult;
        userBrobizzManager$loadBrobizz$1.label = 2;
        if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, userBrobizzManager$loadBrobizz$2, userBrobizzManager$loadBrobizz$1) != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.user.brobizz.IUserBrobizzManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object registerBrobizz(String str, Continuation<? super ManagerResult<Unit>> continuation) {
        UserBrobizzManager$registerBrobizz$1 userBrobizzManager$registerBrobizz$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        UserBrobizzManager userBrobizzManager;
        if (continuation instanceof UserBrobizzManager$registerBrobizz$1) {
            userBrobizzManager$registerBrobizz$1 = (UserBrobizzManager$registerBrobizz$1) continuation;
            int i6 = userBrobizzManager$registerBrobizz$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userBrobizzManager$registerBrobizz$1.label = i6 - Integer.MIN_VALUE;
                obj = userBrobizzManager$registerBrobizz$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userBrobizzManager$registerBrobizz$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IAccountBrobizzService iAccountBrobizzService = this.brobizzService;
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    userBrobizzManager$registerBrobizz$1.L$0 = this;
                    userBrobizzManager$registerBrobizz$1.label = 1;
                    obj = iAccountBrobizzService.registerBrobizz(str, m3214toDTOimpl, userBrobizzManager$registerBrobizz$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userBrobizzManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
                    }
                    userBrobizzManager = (UserBrobizzManager) userBrobizzManager$registerBrobizz$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                UserBrobizzManager$registerBrobizz$2 userBrobizzManager$registerBrobizz$2 = new UserBrobizzManager$registerBrobizz$2(userBrobizzManager, null);
                userBrobizzManager$registerBrobizz$1.L$0 = null;
                userBrobizzManager$registerBrobizz$1.label = 2;
                obj = dk.molslinjen.api.extensions.ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, userBrobizzManager$registerBrobizz$2, userBrobizzManager$registerBrobizz$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
            }
        }
        userBrobizzManager$registerBrobizz$1 = new UserBrobizzManager$registerBrobizz$1(this, continuation);
        obj = userBrobizzManager$registerBrobizz$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userBrobizzManager$registerBrobizz$1.label;
        if (i5 != 0) {
        }
        UserBrobizzManager$registerBrobizz$2 userBrobizzManager$registerBrobizz$22 = new UserBrobizzManager$registerBrobizz$2(userBrobizzManager, null);
        userBrobizzManager$registerBrobizz$1.L$0 = null;
        userBrobizzManager$registerBrobizz$1.label = 2;
        obj = dk.molslinjen.api.extensions.ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, userBrobizzManager$registerBrobizz$22, userBrobizzManager$registerBrobizz$1);
        if (obj == coroutine_suspended) {
        }
        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.user.brobizz.IUserBrobizzManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object removeBrobizz(String str, Continuation<? super ManagerResult<Unit>> continuation) {
        UserBrobizzManager$removeBrobizz$1 userBrobizzManager$removeBrobizz$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        UserBrobizzManager userBrobizzManager;
        if (continuation instanceof UserBrobizzManager$removeBrobizz$1) {
            userBrobizzManager$removeBrobizz$1 = (UserBrobizzManager$removeBrobizz$1) continuation;
            int i6 = userBrobizzManager$removeBrobizz$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userBrobizzManager$removeBrobizz$1.label = i6 - Integer.MIN_VALUE;
                obj = userBrobizzManager$removeBrobizz$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userBrobizzManager$removeBrobizz$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IAccountBrobizzService iAccountBrobizzService = this.brobizzService;
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    userBrobizzManager$removeBrobizz$1.L$0 = this;
                    userBrobizzManager$removeBrobizz$1.L$1 = str;
                    userBrobizzManager$removeBrobizz$1.label = 1;
                    obj = iAccountBrobizzService.removeBrobizz(str, m3214toDTOimpl, userBrobizzManager$removeBrobizz$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userBrobizzManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
                    }
                    str = (String) userBrobizzManager$removeBrobizz$1.L$1;
                    userBrobizzManager = (UserBrobizzManager) userBrobizzManager$removeBrobizz$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                UserBrobizzManager$removeBrobizz$2 userBrobizzManager$removeBrobizz$2 = new UserBrobizzManager$removeBrobizz$2(userBrobizzManager, str, null);
                userBrobizzManager$removeBrobizz$1.L$0 = null;
                userBrobizzManager$removeBrobizz$1.L$1 = null;
                userBrobizzManager$removeBrobizz$1.label = 2;
                obj = dk.molslinjen.api.extensions.ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, userBrobizzManager$removeBrobizz$2, userBrobizzManager$removeBrobizz$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
            }
        }
        userBrobizzManager$removeBrobizz$1 = new UserBrobizzManager$removeBrobizz$1(this, continuation);
        obj = userBrobizzManager$removeBrobizz$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userBrobizzManager$removeBrobizz$1.label;
        if (i5 != 0) {
        }
        UserBrobizzManager$removeBrobizz$2 userBrobizzManager$removeBrobizz$22 = new UserBrobizzManager$removeBrobizz$2(userBrobizzManager, str, null);
        userBrobizzManager$removeBrobizz$1.L$0 = null;
        userBrobizzManager$removeBrobizz$1.L$1 = null;
        userBrobizzManager$removeBrobizz$1.label = 2;
        obj = dk.molslinjen.api.extensions.ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, userBrobizzManager$removeBrobizz$22, userBrobizzManager$removeBrobizz$1);
        if (obj == coroutine_suspended) {
        }
        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
    }

    @Override // dk.molslinjen.domain.managers.user.brobizz.IUserBrobizzManager
    public MutableStateFlow<UserBrobizzState> getBrobizzState() {
        return this.brobizzState;
    }
}
