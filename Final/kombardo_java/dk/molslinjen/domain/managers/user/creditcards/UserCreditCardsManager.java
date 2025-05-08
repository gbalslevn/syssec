package dk.molslinjen.domain.managers.user.creditcards;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.creditcard.IAccountCreditCardsService;
import dk.molslinjen.api.services.account.creditcard.response.CreditCardTypeDTO;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.domain.analytics.IFacebookTracker;
import dk.molslinjen.domain.extensions.ApiResultExtensionsKt;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.localstorage.creditcard.ICreditCardsRepository;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.merge.AssetsMergeType;
import dk.molslinjen.domain.model.account.AuthToken;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.account.CreditCardType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\u0016\u001a\u00020\u00172\u0018\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u00170\u0019H\u0096@¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eH\u0096@¢\u0006\u0002\u0010\u001fJ\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u001e2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010#J<\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00170\u001e2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\u00020-H\u0096@¢\u0006\u0002\u0010\u001fJ\u000e\u0010.\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Ldk/molslinjen/domain/managers/user/creditcards/UserCreditCardsManager;", "Ldk/molslinjen/domain/managers/user/creditcards/IUserCreditCardsManager;", "api", "Ldk/molslinjen/api/services/account/creditcard/IAccountCreditCardsService;", "creditCardRepo", "Ldk/molslinjen/domain/localstorage/creditcard/ICreditCardsRepository;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "<init>", "(Ldk/molslinjen/api/services/account/creditcard/IAccountCreditCardsService;Ldk/molslinjen/domain/localstorage/creditcard/ICreditCardsRepository;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", "creditCardsState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/user/creditcards/UserCreditCardsState;", "getCreditCardsState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "isAuthenticated", BuildConfig.FLAVOR, "()Z", "localScope", "Lkotlinx/coroutines/CoroutineScope;", "collectLatestValidCards", BuildConfig.FLAVOR, "observer", "Lkotlin/Function1;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/CreditCard;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadCreditCards", "Ldk/molslinjen/domain/managers/ManagerResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCreditCard", "cardId", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addCreditCard", "maskedNumber", "cardType", "Ldk/molslinjen/domain/model/account/CreditCardType;", "expirationMonth", "expirationYear", "creditCardToken", "(Ljava/lang/String;Ldk/molslinjen/domain/model/account/CreditCardType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportLocalAssets", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType$CreditCardsAssets;", "removeLocalAssets", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserCreditCardsManager implements IUserCreditCardsManager {
    private final IAccountCreditCardsService api;
    private final ICreditCardsRepository creditCardRepo;
    private final MutableStateFlow<UserCreditCardsState> creditCardsState;
    private final IFacebookTracker facebookTracker;
    private final CoroutineScope localScope;
    private final IUserManager userManager;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.user.creditcards.UserCreditCardsManager$1", f = "UserCreditCardsManager.kt", l = {38}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.user.creditcards.UserCreditCardsManager$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/domain/managers/user/AuthenticationType;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.domain.managers.user.creditcards.UserCreditCardsManager$1$1", f = "UserCreditCardsManager.kt", l = {39}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.domain.managers.user.creditcards.UserCreditCardsManager$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00411 extends SuspendLambda implements Function2<AuthenticationType, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ UserCreditCardsManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00411(UserCreditCardsManager userCreditCardsManager, Continuation<? super C00411> continuation) {
                super(2, continuation);
                this.this$0 = userCreditCardsManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00411(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AuthenticationType authenticationType, Continuation<? super Unit> continuation) {
                return ((C00411) create(authenticationType, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    UserCreditCardsManager userCreditCardsManager = this.this$0;
                    this.label = 1;
                    if (userCreditCardsManager.loadCreditCards(this) == coroutine_suspended) {
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
                StateFlow<AuthenticationType> authenticationType = UserCreditCardsManager.this.userManager.getAuthenticationType();
                C00411 c00411 = new C00411(UserCreditCardsManager.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(authenticationType, c00411, this) == coroutine_suspended) {
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

    public UserCreditCardsManager(IAccountCreditCardsService api, ICreditCardsRepository creditCardRepo, IUserManager userManager, IFacebookTracker facebookTracker) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(creditCardRepo, "creditCardRepo");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
        this.api = api;
        this.creditCardRepo = creditCardRepo;
        this.userManager = userManager;
        this.facebookTracker = facebookTracker;
        this.creditCardsState = StateFlowKt.MutableStateFlow(new UserCreditCardsState(null, 1, null));
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.localScope = CoroutineScope;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    private final boolean isAuthenticated() {
        return this.userManager.getAuthenticationType().getValue().isAuthenticated();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    @Override // dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object addCreditCard(String str, CreditCardType creditCardType, String str2, String str3, String str4, Continuation<? super ManagerResult<Unit>> continuation) {
        UserCreditCardsManager$addCreditCard$1 userCreditCardsManager$addCreditCard$1;
        int i5;
        UserCreditCardsManager userCreditCardsManager;
        UserCreditCardsManager userCreditCardsManager2;
        ManagerResult managerResult;
        if (continuation instanceof UserCreditCardsManager$addCreditCard$1) {
            userCreditCardsManager$addCreditCard$1 = (UserCreditCardsManager$addCreditCard$1) continuation;
            int i6 = userCreditCardsManager$addCreditCard$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userCreditCardsManager$addCreditCard$1.label = i6 - Integer.MIN_VALUE;
                UserCreditCardsManager$addCreditCard$1 userCreditCardsManager$addCreditCard$12 = userCreditCardsManager$addCreditCard$1;
                Object obj = userCreditCardsManager$addCreditCard$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userCreditCardsManager$addCreditCard$12.label;
                if (i5 == 0) {
                    if (i5 == 1) {
                        userCreditCardsManager2 = (UserCreditCardsManager) userCreditCardsManager$addCreditCard$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        managerResult = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
                        BuildersKt__Builders_commonKt.launch$default(userCreditCardsManager2.localScope, null, null, new UserCreditCardsManager$addCreditCard$2(userCreditCardsManager2, managerResult, null), 3, null);
                        return managerResult;
                    }
                    if (i5 != 2) {
                        if (i5 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        userCreditCardsManager2 = (UserCreditCardsManager) userCreditCardsManager$addCreditCard$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        managerResult = new ManagerResult.Success(Unit.INSTANCE);
                        BuildersKt__Builders_commonKt.launch$default(userCreditCardsManager2.localScope, null, null, new UserCreditCardsManager$addCreditCard$2(userCreditCardsManager2, managerResult, null), 3, null);
                        return managerResult;
                    }
                    userCreditCardsManager = (UserCreditCardsManager) userCreditCardsManager$addCreditCard$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    userCreditCardsManager$addCreditCard$12.L$0 = userCreditCardsManager;
                    userCreditCardsManager$addCreditCard$12.label = 3;
                    if (userCreditCardsManager.loadCreditCards(userCreditCardsManager$addCreditCard$12) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userCreditCardsManager2 = userCreditCardsManager;
                    managerResult = new ManagerResult.Success(Unit.INSTANCE);
                    BuildersKt__Builders_commonKt.launch$default(userCreditCardsManager2.localScope, null, null, new UserCreditCardsManager$addCreditCard$2(userCreditCardsManager2, managerResult, null), 3, null);
                    return managerResult;
                }
                ResultKt.throwOnFailure(obj);
                if (isAuthenticated()) {
                    String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IAccountCreditCardsService iAccountCreditCardsService = this.api;
                    CreditCardTypeDTO dto = creditCardType.toDTO();
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    userCreditCardsManager$addCreditCard$12.L$0 = this;
                    userCreditCardsManager$addCreditCard$12.label = 1;
                    obj = iAccountCreditCardsService.registerCard(str, dto, str2, str3, str4, m3214toDTOimpl, userCreditCardsManager$addCreditCard$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userCreditCardsManager2 = this;
                    managerResult = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
                    BuildersKt__Builders_commonKt.launch$default(userCreditCardsManager2.localScope, null, null, new UserCreditCardsManager$addCreditCard$2(userCreditCardsManager2, managerResult, null), 3, null);
                    return managerResult;
                }
                ICreditCardsRepository iCreditCardsRepository = this.creditCardRepo;
                CreditCard creditCard = new CreditCard(str4, str, creditCardType, str2, str3, str4);
                userCreditCardsManager$addCreditCard$12.L$0 = this;
                userCreditCardsManager$addCreditCard$12.label = 2;
                if (iCreditCardsRepository.save(creditCard, userCreditCardsManager$addCreditCard$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                userCreditCardsManager = this;
                userCreditCardsManager$addCreditCard$12.L$0 = userCreditCardsManager;
                userCreditCardsManager$addCreditCard$12.label = 3;
                if (userCreditCardsManager.loadCreditCards(userCreditCardsManager$addCreditCard$12) != coroutine_suspended) {
                }
            }
        }
        userCreditCardsManager$addCreditCard$1 = new UserCreditCardsManager$addCreditCard$1(this, continuation);
        UserCreditCardsManager$addCreditCard$1 userCreditCardsManager$addCreditCard$122 = userCreditCardsManager$addCreditCard$1;
        Object obj2 = userCreditCardsManager$addCreditCard$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userCreditCardsManager$addCreditCard$122.label;
        if (i5 == 0) {
        }
    }

    @Override // dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager
    public Object collectLatestValidCards(Function1<? super List<CreditCard>, Unit> function1, Continuation<? super Unit> continuation) {
        Object collectLatest = FlowKt.collectLatest(getCreditCardsState(), new UserCreditCardsManager$collectLatestValidCards$2(function1, null), continuation);
        return collectLatest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectLatest : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deleteCreditCard(String str, Continuation<? super ManagerResult<Unit>> continuation) {
        UserCreditCardsManager$deleteCreditCard$1 userCreditCardsManager$deleteCreditCard$1;
        int i5;
        UserCreditCardsManager userCreditCardsManager;
        UserCreditCardsManager userCreditCardsManager2;
        List<CreditCard> list;
        MutableStateFlow<UserCreditCardsState> creditCardsState;
        UserCreditCardsState value;
        if (continuation instanceof UserCreditCardsManager$deleteCreditCard$1) {
            userCreditCardsManager$deleteCreditCard$1 = (UserCreditCardsManager$deleteCreditCard$1) continuation;
            int i6 = userCreditCardsManager$deleteCreditCard$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userCreditCardsManager$deleteCreditCard$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userCreditCardsManager$deleteCreditCard$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userCreditCardsManager$deleteCreditCard$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!isAuthenticated()) {
                        ICreditCardsRepository iCreditCardsRepository = this.creditCardRepo;
                        userCreditCardsManager$deleteCreditCard$1.L$0 = this;
                        userCreditCardsManager$deleteCreditCard$1.label = 3;
                        obj = iCreditCardsRepository.deleteCard(str, userCreditCardsManager$deleteCreditCard$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userCreditCardsManager = this;
                        list = (List) obj;
                        creditCardsState = userCreditCardsManager.getCreditCardsState();
                        do {
                            value = creditCardsState.getValue();
                        } while (!creditCardsState.compareAndSet(value, value.copy(list)));
                        return new ManagerResult.Success(Unit.INSTANCE);
                    }
                    String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IAccountCreditCardsService iAccountCreditCardsService = this.api;
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    userCreditCardsManager$deleteCreditCard$1.L$0 = this;
                    userCreditCardsManager$deleteCreditCard$1.L$1 = str;
                    userCreditCardsManager$deleteCreditCard$1.label = 1;
                    obj = iAccountCreditCardsService.deleteCard(str, m3214toDTOimpl, userCreditCardsManager$deleteCreditCard$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userCreditCardsManager2 = this;
                    UserCreditCardsManager$deleteCreditCard$result$1 userCreditCardsManager$deleteCreditCard$result$1 = new UserCreditCardsManager$deleteCreditCard$result$1(userCreditCardsManager2, str, null);
                    userCreditCardsManager$deleteCreditCard$1.L$0 = null;
                    userCreditCardsManager$deleteCreditCard$1.L$1 = null;
                    userCreditCardsManager$deleteCreditCard$1.label = 2;
                    obj = ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj, userCreditCardsManager$deleteCreditCard$result$1, userCreditCardsManager$deleteCreditCard$1);
                    if (obj == coroutine_suspended) {
                    }
                } else if (i5 == 1) {
                    str = (String) userCreditCardsManager$deleteCreditCard$1.L$1;
                    userCreditCardsManager2 = (UserCreditCardsManager) userCreditCardsManager$deleteCreditCard$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    UserCreditCardsManager$deleteCreditCard$result$1 userCreditCardsManager$deleteCreditCard$result$12 = new UserCreditCardsManager$deleteCreditCard$result$1(userCreditCardsManager2, str, null);
                    userCreditCardsManager$deleteCreditCard$1.L$0 = null;
                    userCreditCardsManager$deleteCreditCard$1.L$1 = null;
                    userCreditCardsManager$deleteCreditCard$1.label = 2;
                    obj = ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj, userCreditCardsManager$deleteCreditCard$result$12, userCreditCardsManager$deleteCreditCard$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        userCreditCardsManager = (UserCreditCardsManager) userCreditCardsManager$deleteCreditCard$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        list = (List) obj;
                        creditCardsState = userCreditCardsManager.getCreditCardsState();
                        do {
                            value = creditCardsState.getValue();
                        } while (!creditCardsState.compareAndSet(value, value.copy(list)));
                        return new ManagerResult.Success(Unit.INSTANCE);
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return (ManagerResult) obj;
            }
        }
        userCreditCardsManager$deleteCreditCard$1 = new UserCreditCardsManager$deleteCreditCard$1(this, continuation);
        Object obj2 = userCreditCardsManager$deleteCreditCard$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userCreditCardsManager$deleteCreditCard$1.label;
        if (i5 != 0) {
        }
        return (ManagerResult) obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009c A[PHI: r9
      0x009c: PHI (r9v14 java.lang.Object) = (r9v13 java.lang.Object), (r9v1 java.lang.Object) binds: [B:27:0x0099, B:23:0x0040] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadCreditCards(Continuation<? super ManagerResult<Unit>> continuation) {
        UserCreditCardsManager$loadCreditCards$1 userCreditCardsManager$loadCreditCards$1;
        int i5;
        UserCreditCardsManager userCreditCardsManager;
        UserCreditCardsManager userCreditCardsManager2;
        ApiResult apiResult;
        UserCreditCardsManager$loadCreditCards$2 userCreditCardsManager$loadCreditCards$2;
        ApiResult apiResult2;
        List<CreditCard> list;
        MutableStateFlow<UserCreditCardsState> creditCardsState;
        UserCreditCardsState value;
        if (continuation instanceof UserCreditCardsManager$loadCreditCards$1) {
            userCreditCardsManager$loadCreditCards$1 = (UserCreditCardsManager$loadCreditCards$1) continuation;
            int i6 = userCreditCardsManager$loadCreditCards$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userCreditCardsManager$loadCreditCards$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userCreditCardsManager$loadCreditCards$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userCreditCardsManager$loadCreditCards$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!isAuthenticated()) {
                        ICreditCardsRepository iCreditCardsRepository = this.creditCardRepo;
                        userCreditCardsManager$loadCreditCards$1.L$0 = this;
                        userCreditCardsManager$loadCreditCards$1.label = 4;
                        obj = iCreditCardsRepository.getCards(userCreditCardsManager$loadCreditCards$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userCreditCardsManager = this;
                        list = (List) obj;
                        creditCardsState = userCreditCardsManager.getCreditCardsState();
                        do {
                            value = creditCardsState.getValue();
                        } while (!creditCardsState.compareAndSet(value, value.copy(list)));
                        return new ManagerResult.Success(Unit.INSTANCE);
                    }
                    String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IAccountCreditCardsService iAccountCreditCardsService = this.api;
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    userCreditCardsManager$loadCreditCards$1.L$0 = this;
                    userCreditCardsManager$loadCreditCards$1.label = 1;
                    obj = iAccountCreditCardsService.getCards(m3214toDTOimpl, userCreditCardsManager$loadCreditCards$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userCreditCardsManager2 = this;
                    apiResult = (ApiResult) obj;
                    userCreditCardsManager$loadCreditCards$2 = new UserCreditCardsManager$loadCreditCards$2(userCreditCardsManager2, null);
                    userCreditCardsManager$loadCreditCards$1.L$0 = apiResult;
                    userCreditCardsManager$loadCreditCards$1.label = 2;
                    if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, userCreditCardsManager$loadCreditCards$2, userCreditCardsManager$loadCreditCards$1) != coroutine_suspended) {
                    }
                } else if (i5 == 1) {
                    userCreditCardsManager2 = (UserCreditCardsManager) userCreditCardsManager$loadCreditCards$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    apiResult = (ApiResult) obj;
                    userCreditCardsManager$loadCreditCards$2 = new UserCreditCardsManager$loadCreditCards$2(userCreditCardsManager2, null);
                    userCreditCardsManager$loadCreditCards$1.L$0 = apiResult;
                    userCreditCardsManager$loadCreditCards$1.label = 2;
                    if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, userCreditCardsManager$loadCreditCards$2, userCreditCardsManager$loadCreditCards$1) != coroutine_suspended) {
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
                        userCreditCardsManager = (UserCreditCardsManager) userCreditCardsManager$loadCreditCards$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        list = (List) obj;
                        creditCardsState = userCreditCardsManager.getCreditCardsState();
                        do {
                            value = creditCardsState.getValue();
                        } while (!creditCardsState.compareAndSet(value, value.copy(list)));
                        return new ManagerResult.Success(Unit.INSTANCE);
                    }
                    apiResult2 = (ApiResult) userCreditCardsManager$loadCreditCards$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                userCreditCardsManager$loadCreditCards$1.L$0 = null;
                userCreditCardsManager$loadCreditCards$1.label = 3;
                obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult2, userCreditCardsManager$loadCreditCards$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        userCreditCardsManager$loadCreditCards$1 = new UserCreditCardsManager$loadCreditCards$1(this, continuation);
        Object obj2 = userCreditCardsManager$loadCreditCards$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userCreditCardsManager$loadCreditCards$1.label;
        if (i5 != 0) {
        }
        userCreditCardsManager$loadCreditCards$1.L$0 = null;
        userCreditCardsManager$loadCreditCards$1.label = 3;
        obj2 = ApiResultExtensionsKt.toUnitManagerResult(apiResult2, userCreditCardsManager$loadCreditCards$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    @Override // dk.molslinjen.domain.managers.user.merge.IAssetsMerger
    public Object removeLocalAssets(Continuation<? super Unit> continuation) {
        UserCreditCardsState value;
        MutableStateFlow<UserCreditCardsState> creditCardsState = getCreditCardsState();
        do {
            value = creditCardsState.getValue();
        } while (!creditCardsState.compareAndSet(value, value.copy(CollectionsKt.emptyList())));
        Object clear = this.creditCardRepo.clear(continuation);
        return clear == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clear : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.user.merge.IAssetsMerger
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object reportLocalAssets(Continuation<? super AssetsMergeType.CreditCardsAssets> continuation) {
        UserCreditCardsManager$reportLocalAssets$1 userCreditCardsManager$reportLocalAssets$1;
        int i5;
        List<CreditCard> creditCards;
        if (continuation instanceof UserCreditCardsManager$reportLocalAssets$1) {
            userCreditCardsManager$reportLocalAssets$1 = (UserCreditCardsManager$reportLocalAssets$1) continuation;
            int i6 = userCreditCardsManager$reportLocalAssets$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userCreditCardsManager$reportLocalAssets$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userCreditCardsManager$reportLocalAssets$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userCreditCardsManager$reportLocalAssets$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    creditCards = getCreditCardsState().getValue().getCreditCards();
                    if (creditCards.isEmpty()) {
                        ICreditCardsRepository iCreditCardsRepository = this.creditCardRepo;
                        userCreditCardsManager$reportLocalAssets$1.label = 1;
                        obj = iCreditCardsRepository.getCards(userCreditCardsManager$reportLocalAssets$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return new AssetsMergeType.CreditCardsAssets(creditCards);
                }
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                creditCards = (List) obj;
                return new AssetsMergeType.CreditCardsAssets(creditCards);
            }
        }
        userCreditCardsManager$reportLocalAssets$1 = new UserCreditCardsManager$reportLocalAssets$1(this, continuation);
        Object obj2 = userCreditCardsManager$reportLocalAssets$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userCreditCardsManager$reportLocalAssets$1.label;
        if (i5 != 0) {
        }
        creditCards = (List) obj2;
        return new AssetsMergeType.CreditCardsAssets(creditCards);
    }

    @Override // dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager
    public MutableStateFlow<UserCreditCardsState> getCreditCardsState() {
        return this.creditCardsState;
    }
}
