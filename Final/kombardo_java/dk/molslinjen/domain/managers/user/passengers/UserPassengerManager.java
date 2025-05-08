package dk.molslinjen.domain.managers.user.passengers;

import dk.molslinjen.api.extensions.ApiResultExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.passenger.IAccountPassengerService;
import dk.molslinjen.api.services.account.passenger.request.RegisterPassengerRequestParameter;
import dk.molslinjen.api.services.account.passenger.request.UpdatePassengerRequestParameter;
import dk.molslinjen.api.services.account.passenger.response.AccountPassengerDTO;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.localstorage.passengers.IPassengerRepository;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.merge.AssetsMergeType;
import dk.molslinjen.domain.managers.user.passengers.UserPassengerManager;
import dk.molslinjen.domain.model.account.AuthToken;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.domain.model.account.user.UserInfo;
import dk.molslinjen.domain.model.account.user.UserPersonalDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0096@¢\u0006\u0002\u0010\u0017J<\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\"J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010$\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010%J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010'\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020*H\u0096@¢\u0006\u0002\u0010\u0017J\u000e\u0010+\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Ldk/molslinjen/domain/managers/user/passengers/UserPassengerManager;", "Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;", "passengersService", "Ldk/molslinjen/api/services/account/passenger/IAccountPassengerService;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "passengerRepository", "Ldk/molslinjen/domain/localstorage/passengers/IPassengerRepository;", "<init>", "(Ldk/molslinjen/api/services/account/passenger/IAccountPassengerService;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/domain/localstorage/passengers/IPassengerRepository;)V", "passengersState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/user/passengers/UserPassengersState;", "getPassengersState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "isAuthenticated", BuildConfig.FLAVOR, "()Z", "localScope", "Lkotlinx/coroutines/CoroutineScope;", "loadPassengers", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerPassenger", "Ldk/molslinjen/domain/model/account/UserPassenger;", "firstName", BuildConfig.FLAVOR, "lastName", "gender", "Ldk/molslinjen/domain/model/account/Gender;", "birthDate", "Lorg/threeten/bp/LocalDate;", "nationality", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/account/Gender;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePassenger", "updatedPassenger", "(Ldk/molslinjen/domain/model/account/UserPassenger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePassenger", "passengerLocalId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportLocalAssets", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType$PassengersAssets;", "removeLocalAssets", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserPassengerManager implements IUserPassengerManager {
    private final CoroutineScope localScope;
    private final IPassengerRepository passengerRepository;
    private final IAccountPassengerService passengersService;
    private final MutableStateFlow<UserPassengersState> passengersState;
    private final IUserManager userManager;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.user.passengers.UserPassengerManager$1", f = "UserPassengerManager.kt", l = {41}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.user.passengers.UserPassengerManager$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/domain/managers/user/AuthenticationType;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.domain.managers.user.passengers.UserPassengerManager$1$1", f = "UserPassengerManager.kt", l = {42}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.domain.managers.user.passengers.UserPassengerManager$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00431 extends SuspendLambda implements Function2<AuthenticationType, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ UserPassengerManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00431(UserPassengerManager userPassengerManager, Continuation<? super C00431> continuation) {
                super(2, continuation);
                this.this$0 = userPassengerManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00431(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AuthenticationType authenticationType, Continuation<? super Unit> continuation) {
                return ((C00431) create(authenticationType, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    UserPassengerManager userPassengerManager = this.this$0;
                    this.label = 1;
                    if (userPassengerManager.loadPassengers(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<AuthenticationType> authenticationType = UserPassengerManager.this.userManager.getAuthenticationType();
                C00431 c00431 = new C00431(UserPassengerManager.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(authenticationType, c00431, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public UserPassengerManager(IAccountPassengerService passengersService, IUserManager userManager, IPassengerRepository passengerRepository) {
        Intrinsics.checkNotNullParameter(passengersService, "passengersService");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(passengerRepository, "passengerRepository");
        this.passengersService = passengersService;
        this.userManager = userManager;
        this.passengerRepository = passengerRepository;
        this.passengersState = StateFlowKt.MutableStateFlow(new UserPassengersState(null, 1, null));
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.localScope = CoroutineScope;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    private final boolean isAuthenticated() {
        return this.userManager.getAuthenticationType().getValue().isAuthenticated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserPassenger registerPassenger$lambda$3(AccountPassengerDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new UserPassenger(it);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deletePassenger(String str, Continuation<? super ManagerResult<Unit>> continuation) {
        UserPassengerManager$deletePassenger$1 userPassengerManager$deletePassenger$1;
        int i5;
        UserPassengerManager userPassengerManager;
        UserPassengerManager userPassengerManager2;
        List<UserPassenger> list;
        MutableStateFlow<UserPassengersState> passengersState;
        UserPassengersState value;
        if (continuation instanceof UserPassengerManager$deletePassenger$1) {
            userPassengerManager$deletePassenger$1 = (UserPassengerManager$deletePassenger$1) continuation;
            int i6 = userPassengerManager$deletePassenger$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userPassengerManager$deletePassenger$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userPassengerManager$deletePassenger$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userPassengerManager$deletePassenger$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!isAuthenticated()) {
                        IPassengerRepository iPassengerRepository = this.passengerRepository;
                        userPassengerManager$deletePassenger$1.L$0 = this;
                        userPassengerManager$deletePassenger$1.label = 3;
                        obj = iPassengerRepository.deletePassenger(str, userPassengerManager$deletePassenger$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userPassengerManager = this;
                        list = (List) obj;
                        passengersState = userPassengerManager.getPassengersState();
                        do {
                            value = passengersState.getValue();
                        } while (!passengersState.compareAndSet(value, value.copy(list)));
                        return new ManagerResult.Success(Unit.INSTANCE);
                    }
                    String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IAccountPassengerService iAccountPassengerService = this.passengersService;
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    userPassengerManager$deletePassenger$1.L$0 = this;
                    userPassengerManager$deletePassenger$1.L$1 = str;
                    userPassengerManager$deletePassenger$1.label = 1;
                    obj = iAccountPassengerService.deletePassenger(str, m3214toDTOimpl, userPassengerManager$deletePassenger$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userPassengerManager2 = this;
                    UserPassengerManager$deletePassenger$2 userPassengerManager$deletePassenger$2 = new UserPassengerManager$deletePassenger$2(userPassengerManager2, str, null);
                    userPassengerManager$deletePassenger$1.L$0 = null;
                    userPassengerManager$deletePassenger$1.L$1 = null;
                    userPassengerManager$deletePassenger$1.label = 2;
                    obj = ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, userPassengerManager$deletePassenger$2, userPassengerManager$deletePassenger$1);
                    if (obj == coroutine_suspended) {
                    }
                } else if (i5 == 1) {
                    str = (String) userPassengerManager$deletePassenger$1.L$1;
                    userPassengerManager2 = (UserPassengerManager) userPassengerManager$deletePassenger$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    UserPassengerManager$deletePassenger$2 userPassengerManager$deletePassenger$22 = new UserPassengerManager$deletePassenger$2(userPassengerManager2, str, null);
                    userPassengerManager$deletePassenger$1.L$0 = null;
                    userPassengerManager$deletePassenger$1.L$1 = null;
                    userPassengerManager$deletePassenger$1.label = 2;
                    obj = ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, userPassengerManager$deletePassenger$22, userPassengerManager$deletePassenger$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        userPassengerManager = (UserPassengerManager) userPassengerManager$deletePassenger$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        list = (List) obj;
                        passengersState = userPassengerManager.getPassengersState();
                        do {
                            value = passengersState.getValue();
                        } while (!passengersState.compareAndSet(value, value.copy(list)));
                        return new ManagerResult.Success(Unit.INSTANCE);
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
            }
        }
        userPassengerManager$deletePassenger$1 = new UserPassengerManager$deletePassenger$1(this, continuation);
        Object obj2 = userPassengerManager$deletePassenger$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userPassengerManager$deletePassenger$1.label;
        if (i5 != 0) {
        }
        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a0 A[PHI: r9
      0x00a0: PHI (r9v23 java.lang.Object) = (r9v22 java.lang.Object), (r9v1 java.lang.Object) binds: [B:27:0x009d, B:23:0x0044] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadPassengers(Continuation<? super ManagerResult<Unit>> continuation) {
        UserPassengerManager$loadPassengers$1 userPassengerManager$loadPassengers$1;
        int i5;
        UserPassengerManager userPassengerManager;
        UserPassenger userPassenger;
        UserPassengerManager userPassengerManager2;
        ApiResult apiResult;
        UserPassengerManager$loadPassengers$2 userPassengerManager$loadPassengers$2;
        ApiResult apiResult2;
        List plus;
        MutableStateFlow<UserPassengersState> passengersState;
        UserPassengersState value;
        if (continuation instanceof UserPassengerManager$loadPassengers$1) {
            userPassengerManager$loadPassengers$1 = (UserPassengerManager$loadPassengers$1) continuation;
            int i6 = userPassengerManager$loadPassengers$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userPassengerManager$loadPassengers$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userPassengerManager$loadPassengers$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userPassengerManager$loadPassengers$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!isAuthenticated()) {
                        UserInfo details = this.userManager.getCurrentUserState().getValue().getUser().getDetails();
                        UserPersonalDetails personalDetails = details != null ? details.getPersonalDetails() : null;
                        UserPassenger invoke = personalDetails != null ? UserPassenger.INSTANCE.invoke(personalDetails) : null;
                        IPassengerRepository iPassengerRepository = this.passengerRepository;
                        userPassengerManager$loadPassengers$1.L$0 = this;
                        userPassengerManager$loadPassengers$1.L$1 = invoke;
                        userPassengerManager$loadPassengers$1.label = 4;
                        obj = iPassengerRepository.getPassengers(userPassengerManager$loadPassengers$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userPassengerManager = this;
                        userPassenger = invoke;
                        plus = CollectionsKt.plus((Collection<? extends UserPassenger>) obj, userPassenger);
                        passengersState = userPassengerManager.getPassengersState();
                        do {
                            value = passengersState.getValue();
                        } while (!passengersState.compareAndSet(value, value.copy(CollectionsKt.sortedWith(CollectionsKt.filterNotNull(plus), new Comparator() { // from class: dk.molslinjen.domain.managers.user.passengers.UserPassengerManager$loadPassengers$lambda$2$$inlined$sortedBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t5, T t6) {
                                return ComparisonsKt.compareValues(((UserPassenger) t5).getFirstName(), ((UserPassenger) t6).getFirstName());
                            }
                        }))));
                        return new ManagerResult.Success(Unit.INSTANCE);
                    }
                    String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IAccountPassengerService iAccountPassengerService = this.passengersService;
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    userPassengerManager$loadPassengers$1.L$0 = this;
                    userPassengerManager$loadPassengers$1.label = 1;
                    obj = iAccountPassengerService.getPassengers(m3214toDTOimpl, userPassengerManager$loadPassengers$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userPassengerManager2 = this;
                    apiResult = (ApiResult) obj;
                    userPassengerManager$loadPassengers$2 = new UserPassengerManager$loadPassengers$2(userPassengerManager2, null);
                    userPassengerManager$loadPassengers$1.L$0 = apiResult;
                    userPassengerManager$loadPassengers$1.label = 2;
                    if (ApiResultExtensionsKt.onSuccess(apiResult, userPassengerManager$loadPassengers$2, userPassengerManager$loadPassengers$1) != coroutine_suspended) {
                    }
                } else if (i5 == 1) {
                    userPassengerManager2 = (UserPassengerManager) userPassengerManager$loadPassengers$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    apiResult = (ApiResult) obj;
                    userPassengerManager$loadPassengers$2 = new UserPassengerManager$loadPassengers$2(userPassengerManager2, null);
                    userPassengerManager$loadPassengers$1.L$0 = apiResult;
                    userPassengerManager$loadPassengers$1.label = 2;
                    if (ApiResultExtensionsKt.onSuccess(apiResult, userPassengerManager$loadPassengers$2, userPassengerManager$loadPassengers$1) != coroutine_suspended) {
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
                        userPassenger = (UserPassenger) userPassengerManager$loadPassengers$1.L$1;
                        userPassengerManager = (UserPassengerManager) userPassengerManager$loadPassengers$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        plus = CollectionsKt.plus((Collection<? extends UserPassenger>) obj, userPassenger);
                        passengersState = userPassengerManager.getPassengersState();
                        do {
                            value = passengersState.getValue();
                        } while (!passengersState.compareAndSet(value, value.copy(CollectionsKt.sortedWith(CollectionsKt.filterNotNull(plus), new Comparator() { // from class: dk.molslinjen.domain.managers.user.passengers.UserPassengerManager$loadPassengers$lambda$2$$inlined$sortedBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t5, T t6) {
                                return ComparisonsKt.compareValues(((UserPassenger) t5).getFirstName(), ((UserPassenger) t6).getFirstName());
                            }
                        }))));
                        return new ManagerResult.Success(Unit.INSTANCE);
                    }
                    apiResult2 = (ApiResult) userPassengerManager$loadPassengers$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                userPassengerManager$loadPassengers$1.L$0 = null;
                userPassengerManager$loadPassengers$1.label = 3;
                obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult(apiResult2, userPassengerManager$loadPassengers$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        userPassengerManager$loadPassengers$1 = new UserPassengerManager$loadPassengers$1(this, continuation);
        Object obj2 = userPassengerManager$loadPassengers$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userPassengerManager$loadPassengers$1.label;
        if (i5 != 0) {
        }
        userPassengerManager$loadPassengers$1.L$0 = null;
        userPassengerManager$loadPassengers$1.label = 3;
        obj2 = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult(apiResult2, userPassengerManager$loadPassengers$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0100 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b6 A[PHI: r1
      0x00b6: PHI (r1v15 java.lang.Object) = (r1v14 java.lang.Object), (r1v1 java.lang.Object) binds: [B:30:0x00b3, B:26:0x0053] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object registerPassenger(String str, String str2, Gender gender, LocalDate localDate, String str3, Continuation<? super ManagerResult<UserPassenger>> continuation) {
        UserPassengerManager$registerPassenger$1 userPassengerManager$registerPassenger$1;
        int i5;
        UserPassengerManager userPassengerManager;
        UserPassenger userPassenger;
        UserPassengerManager userPassengerManager2;
        boolean z5;
        UserPassenger userPassenger2;
        if (continuation instanceof UserPassengerManager$registerPassenger$1) {
            userPassengerManager$registerPassenger$1 = (UserPassengerManager$registerPassenger$1) continuation;
            int i6 = userPassengerManager$registerPassenger$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userPassengerManager$registerPassenger$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userPassengerManager$registerPassenger$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userPassengerManager$registerPassenger$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (isAuthenticated()) {
                        String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                        if (mo3198getAuthTokenOEbVFrA == null) {
                            return ManagerResult.Error.INSTANCE.noMessage();
                        }
                        IAccountPassengerService iAccountPassengerService = this.passengersService;
                        RegisterPassengerRequestParameter registerPassengerRequestParameter = new RegisterPassengerRequestParameter(str, str2, gender.toDTO(), localDate, str3);
                        AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                        userPassengerManager$registerPassenger$1.L$0 = this;
                        userPassengerManager$registerPassenger$1.label = 1;
                        obj = iAccountPassengerService.registerPassenger(registerPassengerRequestParameter, m3214toDTOimpl, userPassengerManager$registerPassenger$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userPassengerManager2 = this;
                        ManagerResult managerResult = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj, new Function1() { // from class: I1.a
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                UserPassenger registerPassenger$lambda$3;
                                registerPassenger$lambda$3 = UserPassengerManager.registerPassenger$lambda$3((AccountPassengerDTO) obj2);
                                return registerPassenger$lambda$3;
                            }
                        });
                        UserPassengerManager$registerPassenger$3 userPassengerManager$registerPassenger$3 = new UserPassengerManager$registerPassenger$3(userPassengerManager2, null);
                        userPassengerManager$registerPassenger$1.L$0 = null;
                        userPassengerManager$registerPassenger$1.label = 2;
                        obj = ManagerResultExtensionsKt.onSuccess(managerResult, userPassengerManager$registerPassenger$3, userPassengerManager$registerPassenger$1);
                        if (obj != coroutine_suspended) {
                        }
                    } else {
                        String uuid = UUID.randomUUID().toString();
                        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
                        UserPassenger userPassenger3 = new UserPassenger(uuid, null, str, str2, gender, localDate, str3, false);
                        IPassengerRepository iPassengerRepository = this.passengerRepository;
                        userPassengerManager$registerPassenger$1.L$0 = this;
                        userPassengerManager$registerPassenger$1.L$1 = userPassenger3;
                        userPassengerManager$registerPassenger$1.label = 3;
                        Object save = iPassengerRepository.save(userPassenger3, userPassengerManager$registerPassenger$1);
                        if (save == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userPassengerManager = this;
                        userPassenger = userPassenger3;
                        obj = save;
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        userPassengerManager$registerPassenger$1.L$0 = userPassenger;
                        userPassengerManager$registerPassenger$1.L$1 = null;
                        userPassengerManager$registerPassenger$1.Z$0 = booleanValue;
                        userPassengerManager$registerPassenger$1.label = 4;
                        if (userPassengerManager.loadPassengers(userPassengerManager$registerPassenger$1) != coroutine_suspended) {
                        }
                    }
                } else {
                    if (i5 == 1) {
                        userPassengerManager2 = (UserPassengerManager) userPassengerManager$registerPassenger$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        ManagerResult managerResult2 = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj, new Function1() { // from class: I1.a
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                UserPassenger registerPassenger$lambda$3;
                                registerPassenger$lambda$3 = UserPassengerManager.registerPassenger$lambda$3((AccountPassengerDTO) obj2);
                                return registerPassenger$lambda$3;
                            }
                        });
                        UserPassengerManager$registerPassenger$3 userPassengerManager$registerPassenger$32 = new UserPassengerManager$registerPassenger$3(userPassengerManager2, null);
                        userPassengerManager$registerPassenger$1.L$0 = null;
                        userPassengerManager$registerPassenger$1.label = 2;
                        obj = ManagerResultExtensionsKt.onSuccess(managerResult2, userPassengerManager$registerPassenger$32, userPassengerManager$registerPassenger$1);
                        return obj != coroutine_suspended ? coroutine_suspended : obj;
                    }
                    if (i5 == 2) {
                        ResultKt.throwOnFailure(obj);
                    }
                    if (i5 != 3) {
                        if (i5 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        z5 = userPassengerManager$registerPassenger$1.Z$0;
                        userPassenger2 = (UserPassenger) userPassengerManager$registerPassenger$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return !z5 ? new ManagerResult.Success(userPassenger2) : ManagerResult.Error.INSTANCE.noMessage();
                    }
                    userPassenger = (UserPassenger) userPassengerManager$registerPassenger$1.L$1;
                    userPassengerManager = (UserPassengerManager) userPassengerManager$registerPassenger$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    boolean booleanValue2 = ((Boolean) obj).booleanValue();
                    userPassengerManager$registerPassenger$1.L$0 = userPassenger;
                    userPassengerManager$registerPassenger$1.L$1 = null;
                    userPassengerManager$registerPassenger$1.Z$0 = booleanValue2;
                    userPassengerManager$registerPassenger$1.label = 4;
                    if (userPassengerManager.loadPassengers(userPassengerManager$registerPassenger$1) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z5 = booleanValue2;
                    userPassenger2 = userPassenger;
                    if (!z5) {
                    }
                }
            }
        }
        userPassengerManager$registerPassenger$1 = new UserPassengerManager$registerPassenger$1(this, continuation);
        Object obj2 = userPassengerManager$registerPassenger$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userPassengerManager$registerPassenger$1.label;
        if (i5 != 0) {
        }
    }

    @Override // dk.molslinjen.domain.managers.user.merge.IAssetsMerger
    public Object removeLocalAssets(Continuation<? super Unit> continuation) {
        UserPassengersState value;
        MutableStateFlow<UserPassengersState> passengersState = getPassengersState();
        do {
            value = passengersState.getValue();
        } while (!passengersState.compareAndSet(value, value.copy(CollectionsKt.emptyList())));
        Object clear = this.passengerRepository.clear(continuation);
        return clear == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clear : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.user.merge.IAssetsMerger
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object reportLocalAssets(Continuation<? super AssetsMergeType.PassengersAssets> continuation) {
        UserPassengerManager$reportLocalAssets$1 userPassengerManager$reportLocalAssets$1;
        int i5;
        List<UserPassenger> passengers;
        if (continuation instanceof UserPassengerManager$reportLocalAssets$1) {
            userPassengerManager$reportLocalAssets$1 = (UserPassengerManager$reportLocalAssets$1) continuation;
            int i6 = userPassengerManager$reportLocalAssets$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userPassengerManager$reportLocalAssets$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userPassengerManager$reportLocalAssets$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userPassengerManager$reportLocalAssets$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    passengers = getPassengersState().getValue().getPassengers();
                    if (passengers.isEmpty()) {
                        IPassengerRepository iPassengerRepository = this.passengerRepository;
                        userPassengerManager$reportLocalAssets$1.label = 1;
                        obj = iPassengerRepository.getPassengers(userPassengerManager$reportLocalAssets$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : passengers) {
                        if (!((UserPassenger) obj2).isCurrentUser()) {
                            arrayList.add(obj2);
                        }
                    }
                    return new AssetsMergeType.PassengersAssets(arrayList);
                }
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                passengers = (List) obj;
                ArrayList arrayList2 = new ArrayList();
                while (r5.hasNext()) {
                }
                return new AssetsMergeType.PassengersAssets(arrayList2);
            }
        }
        userPassengerManager$reportLocalAssets$1 = new UserPassengerManager$reportLocalAssets$1(this, continuation);
        Object obj3 = userPassengerManager$reportLocalAssets$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userPassengerManager$reportLocalAssets$1.label;
        if (i5 != 0) {
        }
        passengers = (List) obj3;
        ArrayList arrayList22 = new ArrayList();
        while (r5.hasNext()) {
        }
        return new AssetsMergeType.PassengersAssets(arrayList22);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updatePassenger(UserPassenger userPassenger, Continuation<? super ManagerResult<Unit>> continuation) {
        UserPassengerManager$updatePassenger$1 userPassengerManager$updatePassenger$1;
        int i5;
        UserPassengerManager userPassengerManager;
        String remoteId;
        UserPassengerManager userPassengerManager2;
        boolean z5;
        if (continuation instanceof UserPassengerManager$updatePassenger$1) {
            userPassengerManager$updatePassenger$1 = (UserPassengerManager$updatePassenger$1) continuation;
            int i6 = userPassengerManager$updatePassenger$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userPassengerManager$updatePassenger$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userPassengerManager$updatePassenger$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userPassengerManager$updatePassenger$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (isAuthenticated()) {
                        String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                        if (mo3198getAuthTokenOEbVFrA != null && (remoteId = userPassenger.getRemoteId()) != null) {
                            UpdatePassengerRequestParameter updatePassengerRequestParameter = new UpdatePassengerRequestParameter(remoteId, userPassenger.getFirstName(), userPassenger.getLastName(), userPassenger.getGender().toDTO(), userPassenger.getBirthdate(), userPassenger.getNationality());
                            IAccountPassengerService iAccountPassengerService = this.passengersService;
                            AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                            userPassengerManager$updatePassenger$1.L$0 = this;
                            userPassengerManager$updatePassenger$1.label = 1;
                            obj = iAccountPassengerService.updatePassenger(updatePassengerRequestParameter, m3214toDTOimpl, userPassengerManager$updatePassenger$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            userPassengerManager2 = this;
                            UserPassengerManager$updatePassenger$2 userPassengerManager$updatePassenger$2 = new UserPassengerManager$updatePassenger$2(userPassengerManager2, null);
                            userPassengerManager$updatePassenger$1.L$0 = null;
                            userPassengerManager$updatePassenger$1.label = 2;
                            obj = ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, userPassengerManager$updatePassenger$2, userPassengerManager$updatePassenger$1);
                            if (obj == coroutine_suspended) {
                            }
                            return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
                        }
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IPassengerRepository iPassengerRepository = this.passengerRepository;
                    userPassengerManager$updatePassenger$1.L$0 = this;
                    userPassengerManager$updatePassenger$1.label = 3;
                    obj = iPassengerRepository.updatePassenger(userPassenger, userPassengerManager$updatePassenger$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userPassengerManager = this;
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    userPassengerManager$updatePassenger$1.L$0 = null;
                    userPassengerManager$updatePassenger$1.Z$0 = booleanValue;
                    userPassengerManager$updatePassenger$1.label = 4;
                    if (userPassengerManager.loadPassengers(userPassengerManager$updatePassenger$1) != coroutine_suspended) {
                    }
                } else {
                    if (i5 == 1) {
                        userPassengerManager2 = (UserPassengerManager) userPassengerManager$updatePassenger$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        UserPassengerManager$updatePassenger$2 userPassengerManager$updatePassenger$22 = new UserPassengerManager$updatePassenger$2(userPassengerManager2, null);
                        userPassengerManager$updatePassenger$1.L$0 = null;
                        userPassengerManager$updatePassenger$1.label = 2;
                        obj = ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, userPassengerManager$updatePassenger$22, userPassengerManager$updatePassenger$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
                    }
                    if (i5 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
                    }
                    if (i5 != 3) {
                        if (i5 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        z5 = userPassengerManager$updatePassenger$1.Z$0;
                        ResultKt.throwOnFailure(obj);
                        return !z5 ? new ManagerResult.Success(Unit.INSTANCE) : ManagerResult.Error.INSTANCE.noMessage();
                    }
                    userPassengerManager = (UserPassengerManager) userPassengerManager$updatePassenger$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    boolean booleanValue2 = ((Boolean) obj).booleanValue();
                    userPassengerManager$updatePassenger$1.L$0 = null;
                    userPassengerManager$updatePassenger$1.Z$0 = booleanValue2;
                    userPassengerManager$updatePassenger$1.label = 4;
                    if (userPassengerManager.loadPassengers(userPassengerManager$updatePassenger$1) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z5 = booleanValue2;
                    if (!z5) {
                    }
                }
            }
        }
        userPassengerManager$updatePassenger$1 = new UserPassengerManager$updatePassenger$1(this, continuation);
        Object obj2 = userPassengerManager$updatePassenger$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userPassengerManager$updatePassenger$1.label;
        if (i5 != 0) {
        }
    }

    @Override // dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager
    public MutableStateFlow<UserPassengersState> getPassengersState() {
        return this.passengersState;
    }
}
