package dk.molslinjen.domain.managers.user;

import android.content.Context;
import com.google.firebase.crashlytics.ktx.FirebaseCrashlyticsKt;
import com.google.firebase.crashlytics.ktx.KeyValueBuilder;
import com.google.firebase.ktx.Firebase;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.IAccountService;
import dk.molslinjen.api.services.account.request.CreateAccountRequestParameters;
import dk.molslinjen.api.services.account.request.MergeAccountAssetsRequestParameters;
import dk.molslinjen.api.services.account.request.UpdateAccountRequestParameters;
import dk.molslinjen.api.services.account.response.AccountInfoResponseDTO;
import dk.molslinjen.api.services.account.response.AccountUpdateInfoResponseDTO;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.account.response.MergeAccountAssetsResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.core.Environment;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.extensions.ApiResultExtensionsKt;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.extensions.domain.AssetsMergeTypeExtensionsKt;
import dk.molslinjen.domain.localstorage.user.IUserRepository;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.UserManager;
import dk.molslinjen.domain.managers.user.merge.AssetsMergeContext;
import dk.molslinjen.domain.managers.user.merge.AssetsMergeMethod;
import dk.molslinjen.domain.managers.user.merge.AssetsMergeType;
import dk.molslinjen.domain.model.account.AuthToken;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.account.MergeResult;
import dk.molslinjen.domain.model.account.user.AccountUser;
import dk.molslinjen.domain.model.account.user.LocalUser;
import dk.molslinjen.domain.model.account.user.Uninitialized;
import dk.molslinjen.domain.model.account.user.User;
import dk.molslinjen.domain.model.account.user.UserCompany;
import dk.molslinjen.domain.model.account.user.UserContactDetails;
import dk.molslinjen.domain.model.account.user.UserInfo;
import dk.molslinjen.domain.model.account.user.UserPersonalDetails;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020)H\u0016J\u000e\u0010*\u001a\u00020%H\u0096@¢\u0006\u0002\u0010+J\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020%0-2\u0006\u0010.\u001a\u00020)H\u0096@¢\u0006\u0002\u0010/J\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020%0-2\u0006\u0010.\u001a\u00020)H\u0096@¢\u0006\u0002\u0010/J\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020%0-2\u0006\u00102\u001a\u000203H\u0096@¢\u0006\u0002\u00104J&\u00101\u001a\b\u0012\u0004\u0012\u00020%0-2\u0006\u00105\u001a\u0002062\u0006\u0010\u0018\u001a\u00020\u001aH\u0082@¢\u0006\u0004\b7\u00108J\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020%0-2\u0006\u00102\u001a\u000203H\u0096@¢\u0006\u0002\u00104J\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020%0-2\u0006\u0010:\u001a\u00020;H\u0096@¢\u0006\u0002\u0010<J(\u00109\u001a\b\u0012\u0004\u0012\u00020%0-2\b\u00102\u001a\u0004\u0018\u0001032\b\u0010:\u001a\u0004\u0018\u00010;H\u0082@¢\u0006\u0002\u0010=J$\u0010>\u001a\b\u0012\u0004\u0012\u00020?0-2\u0006\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010BJ\u000e\u0010C\u001a\u00020DH\u0082@¢\u0006\u0002\u0010+J\u0011\u0010E\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\bF\u0010GJ\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020%0-2\u0006\u0010@\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010IJ6\u0010L\u001a\b\u0012\u0004\u0012\u00020?0-2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020O0N2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u001c2\u0006\u0010Q\u001a\u00020RH\u0082@¢\u0006\u0002\u0010SJ*\u0010T\u001a\u00020?2\u0006\u0010U\u001a\u00020\u001a2\b\u0010P\u001a\u0004\u0018\u00010\u001c2\u0006\u0010Q\u001a\u00020RH\u0082@¢\u0006\u0004\bV\u0010WJ$\u0010X\u001a\b\u0012\u0004\u0012\u00020?0-2\u0006\u0010Y\u001a\u00020\u001c2\u0006\u0010Z\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010BJ\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020?0-2\u0006\u0010\\\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010IJ$\u0010]\u001a\b\u0012\u0004\u0012\u00020%0-2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010Y\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010BJ\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020%0-H\u0096@¢\u0006\u0002\u0010+J\u001e\u0010`\u001a\b\u0012\u0004\u0012\u00020%0-2\b\u0010P\u001a\u0004\u0018\u00010\u001cH\u0096@¢\u0006\u0002\u0010IJ\u0010\u0010a\u001a\u00020%2\u0006\u0010b\u001a\u00020DH\u0002J\u000e\u0010c\u001a\u00020%H\u0096@¢\u0006\u0002\u0010+J\u0014\u0010d\u001a\b\u0012\u0004\u0012\u00020%0-H\u0096@¢\u0006\u0002\u0010+J\u001c\u0010e\u001a\b\u0012\u0004\u0012\u00020f0-2\u0006\u0010g\u001a\u00020hH\u0096@¢\u0006\u0002\u0010iJ0\u0010j\u001a\b\u0012\u0004\u0012\u00020f0-2\u0010\u0010k\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030m0l2\u0006\u0010\u0018\u001a\u00020\u001aH\u0082@¢\u0006\u0004\bn\u0010oJ\u000e\u0010p\u001a\u00020%H\u0096@¢\u0006\u0002\u0010+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Ldk/molslinjen/domain/managers/user/UserManager;", "Ldk/molslinjen/domain/managers/user/IUserManager;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "userRepository", "Ldk/molslinjen/domain/localstorage/user/IUserRepository;", "accountService", "Ldk/molslinjen/api/services/account/IAccountService;", "networkManager", "Ldk/molslinjen/api/INetworkManager;", "applicationContext", "Landroid/content/Context;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/domain/model/settings/ISettings;Ldk/molslinjen/domain/localstorage/user/IUserRepository;Ldk/molslinjen/api/services/account/IAccountService;Ldk/molslinjen/api/INetworkManager;Landroid/content/Context;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "localScope", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "pendingAccountActivation", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/user/IUserManager$ActivationInfo;", "getPendingAccountActivation", "()Lkotlinx/coroutines/flow/StateFlow;", "authToken", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/model/account/AuthToken;", "activeCompanyId", BuildConfig.FLAVOR, "currentUserState", "Ldk/molslinjen/domain/managers/user/IUserManager$UserState;", "getCurrentUserState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "authenticationType", "Ldk/molslinjen/domain/managers/user/AuthenticationType;", "getAuthenticationType", "getAuthenticationFromSettings", BuildConfig.FLAVOR, "getAccountSite", "Ldk/molslinjen/domain/model/config/Site;", "createUserInfoInput", "Ldk/molslinjen/domain/managers/user/UserInfoInput;", "clearPendingActivation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAccount", "Ldk/molslinjen/domain/managers/ManagerResult;", "userInfoInput", "(Ldk/molslinjen/domain/managers/user/UserInfoInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUser", "updateAccountUser", "personalDetails", "Ldk/molslinjen/domain/model/account/user/UserPersonalDetails;", "(Ldk/molslinjen/domain/model/account/user/UserPersonalDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestParameters", "Ldk/molslinjen/api/services/account/request/UpdateAccountRequestParameters;", "updateAccountUser-hlWoXfE", "(Ldk/molslinjen/api/services/account/request/UpdateAccountRequestParameters;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocalUser", "contactDetails", "Ldk/molslinjen/domain/model/account/user/UserContactDetails;", "(Ldk/molslinjen/domain/model/account/user/UserContactDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ldk/molslinjen/domain/model/account/user/UserPersonalDetails;Ldk/molslinjen/domain/model/account/user/UserContactDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Ldk/molslinjen/domain/managers/user/LoginResult;", "email", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalUser", "Ldk/molslinjen/domain/model/account/user/User;", "getAuthToken", "getAuthToken-OEbVFrA", "()Ljava/lang/String;", "forgotPassword", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "assetsMergeContext", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeContext;", "handleAuthTokenResponse", "apiResult", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "companyId", "skipMerge", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/helpers/ApiResult;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleValidAuthToken", "newToken", "handleValidAuthToken-zHhnIQY", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPassword", "newPassword", "resetToken", "activateAccount", "activationToken", "changePassword", "currentPassword", "loadUserInfo", "changeAccount", "updateUserState", "user", "logout", "deleteAccount", "mergeAssets", "Ldk/molslinjen/domain/model/account/MergeResult;", "method", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeMethod;", "(Ldk/molslinjen/domain/managers/user/merge/AssetsMergeMethod;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadMergeAssets", "items", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType;", "uploadMergeAssets-hlWoXfE", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelMerge", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserManager implements IUserManager {
    private final IAccountService accountService;
    private MutableStateFlow<String> activeCompanyId;
    private final IAnalyticsTracker analyticsTracker;
    private final Context applicationContext;
    private AssetsMergeContext assetsMergeContext;
    private MutableStateFlow<AuthToken> authToken;
    private final StateFlow<AuthenticationType> authenticationType;
    private final CoroutineScope coroutineScope;
    private final MutableStateFlow<IUserManager.UserState> currentUserState;
    private final CoroutineScope localScope;
    private final StateFlow<IUserManager.ActivationInfo> pendingAccountActivation;
    private final ISettings settings;
    private final IUserRepository userRepository;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.user.UserManager$1", f = "UserManager.kt", l = {116}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.user.UserManager$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ INetworkManager $networkManager;
        int label;
        final /* synthetic */ UserManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(INetworkManager iNetworkManager, UserManager userManager, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$networkManager = iNetworkManager;
            this.this$0 = userManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$networkManager, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<Unit> onUnauthorized = this.$networkManager.getOnUnauthorized();
                final UserManager userManager = this.this$0;
                FlowCollector<? super Unit> flowCollector = new FlowCollector() { // from class: dk.molslinjen.domain.managers.user.UserManager.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Unit) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                        Object logout = UserManager.this.logout(continuation);
                        return logout == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? logout : Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (onUnauthorized.collect(flowCollector, this) == coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.user.UserManager$2", f = "UserManager.kt", l = {122}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.user.UserManager$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/domain/model/account/AuthToken;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.domain.managers.user.UserManager$2$1", f = "UserManager.kt", l = {124, 131}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.domain.managers.user.UserManager$2$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<AuthToken, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ UserManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(UserManager userManager, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = userManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(AuthToken authToken, Continuation<? super Unit> continuation) {
                AuthToken authToken2 = authToken;
                return m3205invokeeNgTBRE(authToken2 != null ? authToken2.m3216unboximpl() : null, continuation);
            }

            /* renamed from: invoke-eNgTBRE, reason: not valid java name */
            public final Object m3205invokeeNgTBRE(String str, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(str != null ? AuthToken.m3209boximpl(str) : null, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                try {
                } catch (CancellationException unused) {
                } catch (Exception e5) {
                    Logger.INSTANCE.logCritical(new CriticalLog("Failed to set user auth token: " + ExceptionsKt.stackTraceToString(e5)));
                }
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    AuthToken authToken = (AuthToken) this.L$0;
                    String str = null;
                    String m3216unboximpl = authToken != null ? authToken.m3216unboximpl() : null;
                    ISettings iSettings = this.this$0.settings;
                    SettingsProperty.AuthToken authToken2 = SettingsProperty.AuthToken.INSTANCE;
                    if (m3216unboximpl != null) {
                        str = m3216unboximpl;
                    }
                    this.label = 1;
                    if (iSettings.update(authToken2, str, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                UserManager userManager = this.this$0;
                this.label = 2;
                if (userManager.loadUserInfo(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow mutableStateFlow = UserManager.this.authToken;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(UserManager.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(mutableStateFlow, anonymousClass1, this) == coroutine_suspended) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.user.UserManager$3", f = "UserManager.kt", l = {135}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.user.UserManager$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.domain.managers.user.UserManager$3$1", f = "UserManager.kt", l = {137, 144}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.domain.managers.user.UserManager$3$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ UserManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(UserManager userManager, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = userManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                try {
                } catch (CancellationException unused) {
                } catch (Exception e5) {
                    Logger.INSTANCE.logCritical(new CriticalLog("Failed to set user active company id: " + ExceptionsKt.stackTraceToString(e5)));
                }
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    String str = (String) this.L$0;
                    ISettings iSettings = this.this$0.settings;
                    SettingsProperty.ActiveCompanyId activeCompanyId = SettingsProperty.ActiveCompanyId.INSTANCE;
                    this.label = 1;
                    if (iSettings.update(activeCompanyId, str, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                UserManager userManager = this.this$0;
                this.label = 2;
                if (userManager.loadUserInfo(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(String str, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow mutableStateFlow = UserManager.this.activeCompanyId;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(UserManager.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(mutableStateFlow, anonymousClass1, this) == coroutine_suspended) {
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
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.user.UserManager$4", f = "UserManager.kt", l = {149}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.user.UserManager$4, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<AuthenticationType> authenticationType = UserManager.this.getAuthenticationType();
                final UserManager userManager = UserManager.this;
                FlowCollector<? super AuthenticationType> flowCollector = new FlowCollector() { // from class: dk.molslinjen.domain.managers.user.UserManager.4.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((AuthenticationType) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(AuthenticationType authenticationType2, Continuation<? super Unit> continuation) {
                        UserManager.this.analyticsTracker.updateStateTracking(UserManager.this, null);
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (authenticationType.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public UserManager(ISettings settings, IUserRepository userRepository, IAccountService accountService, INetworkManager networkManager, Context applicationContext, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(userRepository, "userRepository");
        Intrinsics.checkNotNullParameter(accountService, "accountService");
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.settings = settings;
        this.userRepository = userRepository;
        this.accountService = accountService;
        this.applicationContext = applicationContext;
        this.analyticsTracker = analyticsTracker;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.localScope = CoroutineScope;
        CoroutineScope CoroutineScope2 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.coroutineScope = CoroutineScope2;
        this.pendingAccountActivation = settings.get(CoroutineScope, SettingsProperty.User.PendingAccountActivation.INSTANCE);
        this.authToken = StateFlowKt.MutableStateFlow(null);
        this.activeCompanyId = StateFlowKt.MutableStateFlow(null);
        this.currentUserState = StateFlowKt.MutableStateFlow(new IUserManager.UserState(Uninitialized.INSTANCE, null, 2, null));
        this.authenticationType = FlowKt.stateIn(FlowKt.distinctUntilChanged(FlowKt.combine(this.authToken, this.activeCompanyId, new UserManager$authenticationType$1(null))), CoroutineScope2, SharingStarted.INSTANCE.getEagerly(), AuthenticationType.None.INSTANCE);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope2, null, null, new AnonymousClass1(networkManager, this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope2, null, null, new AnonymousClass2(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope2, null, null, new AnonymousClass3(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope2, null, null, new AnonymousClass4(null), 3, null);
        getAuthenticationFromSettings();
    }

    private final Site getAccountSite() {
        return Environment.INSTANCE.isKombardo() ? Site.Kombardo : Site.Mols;
    }

    private final void getAuthenticationFromSettings() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new UserManager$getAuthenticationFromSettings$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getLocalUser(Continuation<? super User> continuation) {
        UserManager$getLocalUser$1 userManager$getLocalUser$1;
        int i5;
        if (continuation instanceof UserManager$getLocalUser$1) {
            userManager$getLocalUser$1 = (UserManager$getLocalUser$1) continuation;
            int i6 = userManager$getLocalUser$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$getLocalUser$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userManager$getLocalUser$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$getLocalUser$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IUserRepository iUserRepository = this.userRepository;
                    userManager$getLocalUser$1.label = 1;
                    obj = iUserRepository.getUser(userManager$getLocalUser$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                User user = (User) obj;
                return user != null ? new LocalUser(UserInfo.INSTANCE.getEmpty()) : user;
            }
        }
        userManager$getLocalUser$1 = new UserManager$getLocalUser$1(this, continuation);
        Object obj2 = userManager$getLocalUser$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$getLocalUser$1.label;
        if (i5 != 0) {
        }
        User user2 = (User) obj2;
        if (user2 != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleAuthTokenResponse(ApiResult<AuthTokenDTO> apiResult, String str, boolean z5, Continuation<? super ManagerResult<? extends LoginResult>> continuation) {
        UserManager$handleAuthTokenResponse$1 userManager$handleAuthTokenResponse$1;
        int i5;
        if (continuation instanceof UserManager$handleAuthTokenResponse$1) {
            userManager$handleAuthTokenResponse$1 = (UserManager$handleAuthTokenResponse$1) continuation;
            int i6 = userManager$handleAuthTokenResponse$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$handleAuthTokenResponse$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userManager$handleAuthTokenResponse$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$handleAuthTokenResponse$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (apiResult instanceof ApiResult.Error) {
                        return ManagerResultExtensionsKt.toManagerResult(apiResult);
                    }
                    if (!(apiResult instanceof ApiResult.Success)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    String m3210constructorimpl = AuthToken.m3210constructorimpl(((AuthTokenDTO) ((ApiResult.Success) apiResult).getData()).getToken());
                    userManager$handleAuthTokenResponse$1.label = 1;
                    obj = m3202handleValidAuthTokenzHhnIQY(m3210constructorimpl, str, z5, userManager$handleAuthTokenResponse$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return new ManagerResult.Success(obj);
            }
        }
        userManager$handleAuthTokenResponse$1 = new UserManager$handleAuthTokenResponse$1(this, continuation);
        Object obj2 = userManager$handleAuthTokenResponse$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$handleAuthTokenResponse$1.label;
        if (i5 != 0) {
        }
        return new ManagerResult.Success(obj2);
    }

    static /* synthetic */ Object handleAuthTokenResponse$default(UserManager userManager, ApiResult apiResult, String str, boolean z5, Continuation continuation, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = null;
        }
        return userManager.handleAuthTokenResponse(apiResult, str, z5, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* renamed from: handleValidAuthToken-zHhnIQY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3202handleValidAuthTokenzHhnIQY(String str, String str2, boolean z5, Continuation<? super LoginResult> continuation) {
        UserManager$handleValidAuthToken$1 userManager$handleValidAuthToken$1;
        Object coroutine_suspended;
        int i5;
        AssetsMergeContext assetsMergeContext;
        UserManager userManager;
        Object mergePending;
        UserManager userManager2;
        String str3;
        String str4;
        IUserRepository iUserRepository;
        MutableStateFlow<IUserManager.UserState> currentUserState;
        IUserManager.UserState value;
        MutableStateFlow<String> mutableStateFlow;
        MutableStateFlow<AuthToken> mutableStateFlow2;
        AuthToken value2;
        AuthToken authToken;
        if (continuation instanceof UserManager$handleValidAuthToken$1) {
            userManager$handleValidAuthToken$1 = (UserManager$handleValidAuthToken$1) continuation;
            int i6 = userManager$handleValidAuthToken$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$handleValidAuthToken$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userManager$handleValidAuthToken$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$handleValidAuthToken$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    assetsMergeContext = new AssetsMergeContext(str, new UserManager$handleValidAuthToken$mergeContext$1(this), this.applicationContext, null);
                    if (z5) {
                        userManager = this;
                        userManager.assetsMergeContext = null;
                        userManager$handleValidAuthToken$1.L$0 = userManager;
                        userManager$handleValidAuthToken$1.L$1 = str;
                        userManager$handleValidAuthToken$1.L$2 = str2;
                        userManager$handleValidAuthToken$1.L$3 = null;
                        userManager$handleValidAuthToken$1.label = 2;
                        if (userManager.clearPendingActivation(userManager$handleValidAuthToken$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userManager2 = userManager;
                        String str5 = str2;
                        str3 = str;
                        str4 = str5;
                        iUserRepository = userManager2.userRepository;
                        userManager$handleValidAuthToken$1.L$0 = userManager2;
                        userManager$handleValidAuthToken$1.L$1 = str3;
                        userManager$handleValidAuthToken$1.L$2 = str4;
                        userManager$handleValidAuthToken$1.label = 3;
                        if (iUserRepository.clear(userManager$handleValidAuthToken$1) == coroutine_suspended) {
                        }
                        currentUserState = userManager2.getCurrentUserState();
                        do {
                            value = currentUserState.getValue();
                        } while (!currentUserState.compareAndSet(value, IUserManager.UserState.copy$default(value, null, str4, 1, null)));
                        mutableStateFlow = userManager2.activeCompanyId;
                        do {
                        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), str4));
                        mutableStateFlow2 = userManager2.authToken;
                        do {
                            value2 = mutableStateFlow2.getValue();
                            authToken = value2;
                            if (authToken != null) {
                            }
                        } while (!mutableStateFlow2.compareAndSet(value2, str3 != null ? AuthToken.m3209boximpl(str3) : null));
                        return LoginResult.Success;
                    }
                    userManager$handleValidAuthToken$1.L$0 = this;
                    userManager$handleValidAuthToken$1.L$1 = str;
                    userManager$handleValidAuthToken$1.L$2 = str2;
                    userManager$handleValidAuthToken$1.L$3 = assetsMergeContext;
                    userManager$handleValidAuthToken$1.label = 1;
                    mergePending = assetsMergeContext.mergePending(userManager$handleValidAuthToken$1);
                    if (mergePending == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            str4 = (String) userManager$handleValidAuthToken$1.L$2;
                            str3 = (String) userManager$handleValidAuthToken$1.L$1;
                            userManager2 = (UserManager) userManager$handleValidAuthToken$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            currentUserState = userManager2.getCurrentUserState();
                            do {
                                value = currentUserState.getValue();
                            } while (!currentUserState.compareAndSet(value, IUserManager.UserState.copy$default(value, null, str4, 1, null)));
                            mutableStateFlow = userManager2.activeCompanyId;
                            do {
                            } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), str4));
                            mutableStateFlow2 = userManager2.authToken;
                            do {
                                value2 = mutableStateFlow2.getValue();
                                authToken = value2;
                                if (authToken != null) {
                                    authToken.m3216unboximpl();
                                }
                            } while (!mutableStateFlow2.compareAndSet(value2, str3 != null ? AuthToken.m3209boximpl(str3) : null));
                            return LoginResult.Success;
                        }
                        str4 = (String) userManager$handleValidAuthToken$1.L$2;
                        str3 = (String) userManager$handleValidAuthToken$1.L$1;
                        userManager2 = (UserManager) userManager$handleValidAuthToken$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        iUserRepository = userManager2.userRepository;
                        userManager$handleValidAuthToken$1.L$0 = userManager2;
                        userManager$handleValidAuthToken$1.L$1 = str3;
                        userManager$handleValidAuthToken$1.L$2 = str4;
                        userManager$handleValidAuthToken$1.label = 3;
                        if (iUserRepository.clear(userManager$handleValidAuthToken$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        currentUserState = userManager2.getCurrentUserState();
                        do {
                            value = currentUserState.getValue();
                        } while (!currentUserState.compareAndSet(value, IUserManager.UserState.copy$default(value, null, str4, 1, null)));
                        mutableStateFlow = userManager2.activeCompanyId;
                        do {
                        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), str4));
                        mutableStateFlow2 = userManager2.authToken;
                        do {
                            value2 = mutableStateFlow2.getValue();
                            authToken = value2;
                            if (authToken != null) {
                            }
                        } while (!mutableStateFlow2.compareAndSet(value2, str3 != null ? AuthToken.m3209boximpl(str3) : null));
                        return LoginResult.Success;
                    }
                    AssetsMergeContext assetsMergeContext2 = (AssetsMergeContext) userManager$handleValidAuthToken$1.L$3;
                    str2 = (String) userManager$handleValidAuthToken$1.L$2;
                    String str6 = (String) userManager$handleValidAuthToken$1.L$1;
                    userManager = (UserManager) userManager$handleValidAuthToken$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    assetsMergeContext = assetsMergeContext2;
                    str = str6;
                    mergePending = obj;
                }
                if (((Boolean) mergePending).booleanValue()) {
                    userManager.assetsMergeContext = assetsMergeContext;
                    return LoginResult.MergePending;
                }
                userManager.assetsMergeContext = null;
                userManager$handleValidAuthToken$1.L$0 = userManager;
                userManager$handleValidAuthToken$1.L$1 = str;
                userManager$handleValidAuthToken$1.L$2 = str2;
                userManager$handleValidAuthToken$1.L$3 = null;
                userManager$handleValidAuthToken$1.label = 2;
                if (userManager.clearPendingActivation(userManager$handleValidAuthToken$1) == coroutine_suspended) {
                }
            }
        }
        userManager$handleValidAuthToken$1 = new UserManager$handleValidAuthToken$1(this, continuation);
        Object obj2 = userManager$handleValidAuthToken$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$handleValidAuthToken$1.label;
        if (i5 != 0) {
        }
        if (((Boolean) mergePending).booleanValue()) {
        }
        userManager.assetsMergeContext = null;
        userManager$handleValidAuthToken$1.L$0 = userManager;
        userManager$handleValidAuthToken$1.L$1 = str;
        userManager$handleValidAuthToken$1.L$2 = str2;
        userManager$handleValidAuthToken$1.L$3 = null;
        userManager$handleValidAuthToken$1.label = 2;
        if (userManager.clearPendingActivation(userManager$handleValidAuthToken$1) == coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: updateAccountUser-hlWoXfE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3203updateAccountUserhlWoXfE(UpdateAccountRequestParameters updateAccountRequestParameters, String str, Continuation<? super ManagerResult<Unit>> continuation) {
        UserManager$updateAccountUser$3 userManager$updateAccountUser$3;
        int i5;
        AccountUser accountUser;
        UserManager userManager;
        ApiResult apiResult;
        if (continuation instanceof UserManager$updateAccountUser$3) {
            userManager$updateAccountUser$3 = (UserManager$updateAccountUser$3) continuation;
            int i6 = userManager$updateAccountUser$3.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$updateAccountUser$3.label = i6 - Integer.MIN_VALUE;
                Object obj = userManager$updateAccountUser$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$updateAccountUser$3.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    User user = getCurrentUserState().getValue().getUser();
                    accountUser = user instanceof AccountUser ? (AccountUser) user : null;
                    if (accountUser == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IAccountService iAccountService = this.accountService;
                    SiteDTO dto = getAccountSite().toDTO();
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(str);
                    userManager$updateAccountUser$3.L$0 = this;
                    userManager$updateAccountUser$3.L$1 = accountUser;
                    userManager$updateAccountUser$3.label = 1;
                    obj = iAccountService.update(updateAccountRequestParameters, dto, m3214toDTOimpl, userManager$updateAccountUser$3);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        if (i5 == 3) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    accountUser = (AccountUser) userManager$updateAccountUser$3.L$1;
                    userManager = (UserManager) userManager$updateAccountUser$3.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                AccountUser accountUser2 = accountUser;
                apiResult = (ApiResult) obj;
                if (!(apiResult instanceof ApiResult.Error)) {
                    userManager$updateAccountUser$3.L$0 = null;
                    userManager$updateAccountUser$3.L$1 = null;
                    userManager$updateAccountUser$3.label = 2;
                    obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult, userManager$updateAccountUser$3);
                    return obj == coroutine_suspended ? coroutine_suspended : obj;
                }
                if (!(apiResult instanceof ApiResult.Success)) {
                    throw new NoWhenBranchMatchedException();
                }
                userManager.updateUserState(AccountUser.copy$default(accountUser2, null, null, new UserInfo((AccountUpdateInfoResponseDTO) ((ApiResult.Success) apiResult).getData()), 3, null));
                userManager.analyticsTracker.updateStateTracking(userManager, null);
                userManager$updateAccountUser$3.L$0 = null;
                userManager$updateAccountUser$3.L$1 = null;
                userManager$updateAccountUser$3.label = 3;
                obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult, userManager$updateAccountUser$3);
                return obj == coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        userManager$updateAccountUser$3 = new UserManager$updateAccountUser$3(this, continuation);
        Object obj2 = userManager$updateAccountUser$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$updateAccountUser$3.label;
        if (i5 != 0) {
        }
        AccountUser accountUser22 = accountUser;
        apiResult = (ApiResult) obj2;
        if (!(apiResult instanceof ApiResult.Error)) {
        }
    }

    private final void updateUserState(final User user) {
        IUserManager.UserState value;
        IUserManager.UserState userState;
        String str;
        final String str2;
        UserContactDetails contactDetails;
        String value2 = this.activeCompanyId.getValue();
        MutableStateFlow<IUserManager.UserState> currentUserState = getCurrentUserState();
        do {
            value = currentUserState.getValue();
            userState = value;
            if (user instanceof AccountUser) {
                List<UserCompany> companies = ((AccountUser) user).getCompanies();
                if (!(companies instanceof Collection) || !companies.isEmpty()) {
                    Iterator<T> it = companies.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(((UserCompany) it.next()).getCompanyId(), value2)) {
                            str = value2;
                            break;
                        }
                    }
                }
            } else if (!(user instanceof LocalUser) && !Intrinsics.areEqual(user, Uninitialized.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            str = null;
        } while (!currentUserState.compareAndSet(value, userState.copy(user, str)));
        this.analyticsTracker.updateStateTracking(this, null);
        UserInfo details = user.getDetails();
        if (details == null || (contactDetails = details.getContactDetails()) == null || (str2 = contactDetails.getEmail()) == null) {
            str2 = "-";
        }
        FirebaseCrashlyticsKt.setCustomKeys(FirebaseCrashlyticsKt.getCrashlytics(Firebase.INSTANCE), new Function1() { // from class: H1.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit updateUserState$lambda$9;
                updateUserState$lambda$9 = UserManager.updateUserState$lambda$9(User.this, str2, (KeyValueBuilder) obj);
                return updateUserState$lambda$9;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateUserState$lambda$9(User user, String str, KeyValueBuilder setCustomKeys) {
        Intrinsics.checkNotNullParameter(setCustomKeys, "$this$setCustomKeys");
        setCustomKeys.key(Constants.FirebaseCustomKeys.HasProfile, user instanceof AccountUser);
        setCustomKeys.key(Constants.FirebaseCustomKeys.UserEmail, str);
        FirebaseCrashlyticsKt.getCrashlytics(Firebase.INSTANCE).setUserId(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: uploadMergeAssets-hlWoXfE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3204uploadMergeAssetshlWoXfE(List<? extends AssetsMergeType<?>> list, String str, Continuation<? super ManagerResult<MergeResult>> continuation) {
        UserManager$uploadMergeAssets$1 userManager$uploadMergeAssets$1;
        int i5;
        ApiResult apiResult;
        if (continuation instanceof UserManager$uploadMergeAssets$1) {
            userManager$uploadMergeAssets$1 = (UserManager$uploadMergeAssets$1) continuation;
            int i6 = userManager$uploadMergeAssets$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$uploadMergeAssets$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userManager$uploadMergeAssets$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$uploadMergeAssets$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IAccountService iAccountService = this.accountService;
                    MergeAccountAssetsRequestParameters requestParameters = AssetsMergeTypeExtensionsKt.toRequestParameters(list);
                    SiteDTO dto = getAccountSite().toDTO();
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(str);
                    userManager$uploadMergeAssets$1.label = 1;
                    obj = iAccountService.mergeAccount(requestParameters, dto, m3214toDTOimpl, userManager$uploadMergeAssets$1);
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
                    return ManagerResultExtensionsKt.toManagerResult(apiResult);
                }
                if (apiResult instanceof ApiResult.Success) {
                    return new ManagerResult.Success(new MergeResult(((MergeAccountAssetsResponseDTO) ((ApiResult.Success) apiResult).getData()).getHasError()));
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        userManager$uploadMergeAssets$1 = new UserManager$uploadMergeAssets$1(this, continuation);
        Object obj2 = userManager$uploadMergeAssets$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$uploadMergeAssets$1.label;
        if (i5 != 0) {
        }
        apiResult = (ApiResult) obj2;
        if (!(apiResult instanceof ApiResult.Error)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006c A[PHI: r10
      0x006c: PHI (r10v7 java.lang.Object) = (r10v6 java.lang.Object), (r10v1 java.lang.Object) binds: [B:18:0x0069, B:11:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    @Override // dk.molslinjen.domain.managers.user.IUserManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object activateAccount(String str, Continuation<? super ManagerResult<? extends LoginResult>> continuation) {
        UserManager$activateAccount$1 userManager$activateAccount$1;
        int i5;
        UserManager userManager;
        if (continuation instanceof UserManager$activateAccount$1) {
            userManager$activateAccount$1 = (UserManager$activateAccount$1) continuation;
            int i6 = userManager$activateAccount$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$activateAccount$1.label = i6 - Integer.MIN_VALUE;
                UserManager$activateAccount$1 userManager$activateAccount$12 = userManager$activateAccount$1;
                Object obj = userManager$activateAccount$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$activateAccount$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IAccountService iAccountService = this.accountService;
                    SiteDTO dto = getAccountSite().toDTO();
                    userManager$activateAccount$12.L$0 = this;
                    userManager$activateAccount$12.label = 1;
                    obj = iAccountService.activate(str, dto, userManager$activateAccount$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    UserManager userManager2 = (UserManager) userManager$activateAccount$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    userManager = userManager2;
                }
                userManager$activateAccount$12.L$0 = null;
                userManager$activateAccount$12.label = 2;
                obj = handleAuthTokenResponse$default(userManager, (ApiResult) obj, null, false, userManager$activateAccount$12, 2, null);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        userManager$activateAccount$1 = new UserManager$activateAccount$1(this, continuation);
        UserManager$activateAccount$1 userManager$activateAccount$122 = userManager$activateAccount$1;
        Object obj2 = userManager$activateAccount$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$activateAccount$122.label;
        if (i5 != 0) {
        }
        userManager$activateAccount$122.L$0 = null;
        userManager$activateAccount$122.label = 2;
        obj2 = handleAuthTokenResponse$default(userManager, (ApiResult) obj2, null, false, userManager$activateAccount$122, 2, null);
        if (obj2 != coroutine_suspended2) {
        }
    }

    @Override // dk.molslinjen.domain.managers.user.IUserManager
    public Object cancelMerge(Continuation<? super Unit> continuation) {
        this.assetsMergeContext = null;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0093 A[PHI: r10
      0x0093: PHI (r10v8 java.lang.Object) = (r10v7 java.lang.Object), (r10v1 java.lang.Object) binds: [B:18:0x0090, B:11:0x002c] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // dk.molslinjen.domain.managers.user.IUserManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object changeAccount(String str, Continuation<? super ManagerResult<Unit>> continuation) {
        UserManager$changeAccount$1 userManager$changeAccount$1;
        Object coroutine_suspended;
        int i5;
        UserManager userManager;
        ApiResult<AuthTokenDTO> apiResult;
        ApiResult<AuthTokenDTO> apiResult2;
        if (continuation instanceof UserManager$changeAccount$1) {
            userManager$changeAccount$1 = (UserManager$changeAccount$1) continuation;
            int i6 = userManager$changeAccount$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$changeAccount$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userManager$changeAccount$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$changeAccount$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String mo3198getAuthTokenOEbVFrA = mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IAccountService iAccountService = this.accountService;
                    SiteDTO dto = getAccountSite().toDTO();
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    userManager$changeAccount$1.L$0 = this;
                    userManager$changeAccount$1.L$1 = str;
                    userManager$changeAccount$1.label = 1;
                    obj = iAccountService.changeAccountContext(str, dto, m3214toDTOimpl, userManager$changeAccount$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 == 3) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        apiResult2 = (ApiResult) userManager$changeAccount$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        userManager$changeAccount$1.L$0 = null;
                        userManager$changeAccount$1.label = 3;
                        obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult2, userManager$changeAccount$1);
                        return obj != coroutine_suspended ? coroutine_suspended : obj;
                    }
                    str = (String) userManager$changeAccount$1.L$1;
                    userManager = (UserManager) userManager$changeAccount$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                apiResult = (ApiResult) obj;
                userManager$changeAccount$1.L$0 = apiResult;
                userManager$changeAccount$1.L$1 = null;
                userManager$changeAccount$1.label = 2;
                if (userManager.handleAuthTokenResponse(apiResult, str, true, userManager$changeAccount$1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiResult2 = apiResult;
                userManager$changeAccount$1.L$0 = null;
                userManager$changeAccount$1.label = 3;
                obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult2, userManager$changeAccount$1);
                if (obj != coroutine_suspended) {
                }
            }
        }
        userManager$changeAccount$1 = new UserManager$changeAccount$1(this, continuation);
        Object obj2 = userManager$changeAccount$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$changeAccount$1.label;
        if (i5 != 0) {
        }
        apiResult = (ApiResult) obj2;
        userManager$changeAccount$1.L$0 = apiResult;
        userManager$changeAccount$1.L$1 = null;
        userManager$changeAccount$1.label = 2;
        if (userManager.handleAuthTokenResponse(apiResult, str, true, userManager$changeAccount$1) != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0095 A[PHI: r13
      0x0095: PHI (r13v7 java.lang.Object) = (r13v6 java.lang.Object), (r13v1 java.lang.Object) binds: [B:18:0x0092, B:11:0x002b] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // dk.molslinjen.domain.managers.user.IUserManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object changePassword(String str, String str2, Continuation<? super ManagerResult<Unit>> continuation) {
        UserManager$changePassword$1 userManager$changePassword$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        UserManager userManager;
        ApiResult apiResult;
        if (continuation instanceof UserManager$changePassword$1) {
            userManager$changePassword$1 = (UserManager$changePassword$1) continuation;
            int i6 = userManager$changePassword$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$changePassword$1.label = i6 - Integer.MIN_VALUE;
                obj = userManager$changePassword$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$changePassword$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String mo3198getAuthTokenOEbVFrA = mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IAccountService iAccountService = this.accountService;
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    SiteDTO dto = getAccountSite().toDTO();
                    userManager$changePassword$1.L$0 = this;
                    userManager$changePassword$1.label = 1;
                    obj = iAccountService.changePassword(str, str2, dto, m3214toDTOimpl, userManager$changePassword$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 == 3) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        apiResult = (ApiResult) userManager$changePassword$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        userManager$changePassword$1.L$0 = null;
                        userManager$changePassword$1.label = 3;
                        obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult, userManager$changePassword$1);
                        return obj == coroutine_suspended ? coroutine_suspended : obj;
                    }
                    UserManager userManager2 = (UserManager) userManager$changePassword$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    userManager = userManager2;
                }
                apiResult = (ApiResult) obj;
                userManager$changePassword$1.L$0 = apiResult;
                userManager$changePassword$1.label = 2;
                if (handleAuthTokenResponse$default(userManager, apiResult, null, true, userManager$changePassword$1, 2, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                userManager$changePassword$1.L$0 = null;
                userManager$changePassword$1.label = 3;
                obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult, userManager$changePassword$1);
                if (obj == coroutine_suspended) {
                }
            }
        }
        userManager$changePassword$1 = new UserManager$changePassword$1(this, continuation);
        obj = userManager$changePassword$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$changePassword$1.label;
        if (i5 != 0) {
        }
        apiResult = (ApiResult) obj;
        userManager$changePassword$1.L$0 = apiResult;
        userManager$changePassword$1.label = 2;
        if (handleAuthTokenResponse$default(userManager, apiResult, null, true, userManager$changePassword$1, 2, null) == coroutine_suspended) {
        }
        userManager$changePassword$1.L$0 = null;
        userManager$changePassword$1.label = 3;
        obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult, userManager$changePassword$1);
        if (obj == coroutine_suspended) {
        }
    }

    @Override // dk.molslinjen.domain.managers.user.IUserManager
    public Object clearPendingActivation(Continuation<? super Unit> continuation) {
        Object reset = this.settings.reset(SettingsProperty.User.PendingAccountActivation.INSTANCE, continuation);
        return reset == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? reset : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00fe A[PHI: r1
      0x00fe: PHI (r1v11 java.lang.Object) = (r1v10 java.lang.Object), (r1v1 java.lang.Object) binds: [B:18:0x00fb, B:11:0x0030] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    @Override // dk.molslinjen.domain.managers.user.IUserManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object createAccount(UserInfoInput userInfoInput, Continuation<? super ManagerResult<Unit>> continuation) {
        UserManager$createAccount$1 userManager$createAccount$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        String firstName;
        UserManager userManager;
        String str;
        String str2;
        ApiResult apiResult;
        UserManager$createAccount$2 userManager$createAccount$2;
        if (continuation instanceof UserManager$createAccount$1) {
            userManager$createAccount$1 = (UserManager$createAccount$1) continuation;
            int i6 = userManager$createAccount$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$createAccount$1.label = i6 - Integer.MIN_VALUE;
                obj = userManager$createAccount$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$createAccount$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    firstName = userInfoInput.getFirstName();
                    String lastName = userInfoInput.getLastName();
                    Gender gender = userInfoInput.getGender();
                    Locale nationality = userInfoInput.getNationality();
                    String country = nationality != null ? nationality.getCountry() : null;
                    LocalDate birthdate = userInfoInput.getBirthdate();
                    String postalCode = userInfoInput.getPostalCode();
                    PhoneNumber phoneNumber = userInfoInput.getPhoneNumber();
                    String email = userInfoInput.getEmail();
                    String password = userInfoInput.getPassword();
                    if (firstName == null || lastName == null || email == null || password == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IAccountService iAccountService = this.accountService;
                    CreateAccountRequestParameters createAccountRequestParameters = new CreateAccountRequestParameters(email, password, gender != null ? gender.toDTO() : null, firstName, lastName, birthdate, country, phoneNumber.getCountryCode(), phoneNumber.getNationalNumber(), postalCode);
                    SiteDTO dto = getAccountSite().toDTO();
                    userManager$createAccount$1.L$0 = this;
                    userManager$createAccount$1.L$1 = firstName;
                    userManager$createAccount$1.L$2 = lastName;
                    userManager$createAccount$1.L$3 = email;
                    userManager$createAccount$1.label = 1;
                    Object create = iAccountService.create(createAccountRequestParameters, dto, userManager$createAccount$1);
                    if (create == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userManager = this;
                    str = lastName;
                    str2 = email;
                    obj = create;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 == 3) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        apiResult = (ApiResult) userManager$createAccount$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        userManager$createAccount$1.L$0 = null;
                        userManager$createAccount$1.label = 3;
                        obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult, userManager$createAccount$1);
                        return obj == coroutine_suspended ? coroutine_suspended : obj;
                    }
                    String str3 = (String) userManager$createAccount$1.L$3;
                    String str4 = (String) userManager$createAccount$1.L$2;
                    firstName = (String) userManager$createAccount$1.L$1;
                    userManager = (UserManager) userManager$createAccount$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str2 = str3;
                    str = str4;
                }
                apiResult = (ApiResult) obj;
                userManager$createAccount$2 = new UserManager$createAccount$2(userManager, firstName, str, str2, null);
                userManager$createAccount$1.L$0 = apiResult;
                userManager$createAccount$1.L$1 = null;
                userManager$createAccount$1.L$2 = null;
                userManager$createAccount$1.L$3 = null;
                userManager$createAccount$1.label = 2;
                if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, userManager$createAccount$2, userManager$createAccount$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                userManager$createAccount$1.L$0 = null;
                userManager$createAccount$1.label = 3;
                obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult, userManager$createAccount$1);
                if (obj == coroutine_suspended) {
                }
            }
        }
        userManager$createAccount$1 = new UserManager$createAccount$1(this, continuation);
        obj = userManager$createAccount$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$createAccount$1.label;
        if (i5 != 0) {
        }
        apiResult = (ApiResult) obj;
        userManager$createAccount$2 = new UserManager$createAccount$2(userManager, firstName, str, str2, null);
        userManager$createAccount$1.L$0 = apiResult;
        userManager$createAccount$1.L$1 = null;
        userManager$createAccount$1.L$2 = null;
        userManager$createAccount$1.L$3 = null;
        userManager$createAccount$1.label = 2;
        if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, userManager$createAccount$2, userManager$createAccount$1) == coroutine_suspended) {
        }
        userManager$createAccount$1.L$0 = null;
        userManager$createAccount$1.label = 3;
        obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult, userManager$createAccount$1);
        if (obj == coroutine_suspended) {
        }
    }

    @Override // dk.molslinjen.domain.managers.user.IUserManager
    public UserInfoInput createUserInfoInput() {
        return new UserInfoInput(getCurrentUserState().getValue().getUser().getDetails());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0090 A[PHI: r9
      0x0090: PHI (r9v10 java.lang.Object) = (r9v9 java.lang.Object), (r9v1 java.lang.Object) binds: [B:18:0x008d, B:11:0x002c] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // dk.molslinjen.domain.managers.user.IUserManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deleteAccount(Continuation<? super ManagerResult<Unit>> continuation) {
        UserManager$deleteAccount$1 userManager$deleteAccount$1;
        Object coroutine_suspended;
        int i5;
        UserManager userManager;
        ApiResult apiResult;
        UserManager$deleteAccount$2 userManager$deleteAccount$2;
        ApiResult apiResult2;
        if (continuation instanceof UserManager$deleteAccount$1) {
            userManager$deleteAccount$1 = (UserManager$deleteAccount$1) continuation;
            int i6 = userManager$deleteAccount$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$deleteAccount$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userManager$deleteAccount$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$deleteAccount$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String mo3198getAuthTokenOEbVFrA = mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IAccountService iAccountService = this.accountService;
                    SiteDTO dto = getAccountSite().toDTO();
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    userManager$deleteAccount$1.L$0 = this;
                    userManager$deleteAccount$1.label = 1;
                    obj = iAccountService.delete(dto, m3214toDTOimpl, userManager$deleteAccount$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 == 3) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        apiResult2 = (ApiResult) userManager$deleteAccount$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        userManager$deleteAccount$1.L$0 = null;
                        userManager$deleteAccount$1.label = 3;
                        obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult2, userManager$deleteAccount$1);
                        return obj != coroutine_suspended ? coroutine_suspended : obj;
                    }
                    userManager = (UserManager) userManager$deleteAccount$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                apiResult = (ApiResult) obj;
                userManager$deleteAccount$2 = new UserManager$deleteAccount$2(userManager, null);
                userManager$deleteAccount$1.L$0 = apiResult;
                userManager$deleteAccount$1.label = 2;
                if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, userManager$deleteAccount$2, userManager$deleteAccount$1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiResult2 = apiResult;
                userManager$deleteAccount$1.L$0 = null;
                userManager$deleteAccount$1.label = 3;
                obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult2, userManager$deleteAccount$1);
                if (obj != coroutine_suspended) {
                }
            }
        }
        userManager$deleteAccount$1 = new UserManager$deleteAccount$1(this, continuation);
        Object obj2 = userManager$deleteAccount$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$deleteAccount$1.label;
        if (i5 != 0) {
        }
        apiResult = (ApiResult) obj2;
        userManager$deleteAccount$2 = new UserManager$deleteAccount$2(userManager, null);
        userManager$deleteAccount$1.L$0 = apiResult;
        userManager$deleteAccount$1.label = 2;
        if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, userManager$deleteAccount$2, userManager$deleteAccount$1) != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0059 A[PHI: r7
      0x0059: PHI (r7v7 java.lang.Object) = (r7v6 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x0056, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.user.IUserManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object forgotPassword(String str, Continuation<? super ManagerResult<Unit>> continuation) {
        UserManager$forgotPassword$1 userManager$forgotPassword$1;
        int i5;
        if (continuation instanceof UserManager$forgotPassword$1) {
            userManager$forgotPassword$1 = (UserManager$forgotPassword$1) continuation;
            int i6 = userManager$forgotPassword$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$forgotPassword$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userManager$forgotPassword$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$forgotPassword$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IAccountService iAccountService = this.accountService;
                    SiteDTO dto = getAccountSite().toDTO();
                    userManager$forgotPassword$1.label = 1;
                    obj = iAccountService.forgotPassword(str, dto, userManager$forgotPassword$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                userManager$forgotPassword$1.label = 2;
                obj = ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj, userManager$forgotPassword$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        userManager$forgotPassword$1 = new UserManager$forgotPassword$1(this, continuation);
        Object obj2 = userManager$forgotPassword$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$forgotPassword$1.label;
        if (i5 != 0) {
        }
        userManager$forgotPassword$1.label = 2;
        obj2 = ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj2, userManager$forgotPassword$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    @Override // dk.molslinjen.domain.managers.user.IUserManager
    /* renamed from: getAuthToken-OEbVFrA */
    public String mo3198getAuthTokenOEbVFrA() {
        AuthToken value = this.authToken.getValue();
        if (value != null) {
            return value.m3216unboximpl();
        }
        return null;
    }

    @Override // dk.molslinjen.domain.managers.user.IUserManager
    public StateFlow<AuthenticationType> getAuthenticationType() {
        return this.authenticationType;
    }

    @Override // dk.molslinjen.domain.managers.user.IUserManager
    public StateFlow<IUserManager.ActivationInfo> getPendingAccountActivation() {
        return this.pendingAccountActivation;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // dk.molslinjen.domain.managers.user.IUserManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadUserInfo(Continuation<? super ManagerResult<Unit>> continuation) {
        UserManager$loadUserInfo$1 userManager$loadUserInfo$1;
        int i5;
        UserManager userManager;
        UserManager userManager2;
        ApiResult apiResult;
        AccountUser accountUser;
        if (continuation instanceof UserManager$loadUserInfo$1) {
            userManager$loadUserInfo$1 = (UserManager$loadUserInfo$1) continuation;
            int i6 = userManager$loadUserInfo$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$loadUserInfo$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userManager$loadUserInfo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$loadUserInfo$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String mo3198getAuthTokenOEbVFrA = mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        userManager$loadUserInfo$1.L$0 = this;
                        userManager$loadUserInfo$1.label = 3;
                        obj = getLocalUser(userManager$loadUserInfo$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userManager = this;
                        userManager.updateUserState((User) obj);
                        return new ManagerResult.Success(Unit.INSTANCE);
                    }
                    IAccountService iAccountService = this.accountService;
                    SiteDTO dto = getAccountSite().toDTO();
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    userManager$loadUserInfo$1.L$0 = this;
                    userManager$loadUserInfo$1.label = 1;
                    obj = iAccountService.getAccountInfo(dto, m3214toDTOimpl, userManager$loadUserInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userManager2 = this;
                    apiResult = (ApiResult) obj;
                    if (!(apiResult instanceof ApiResult.Error)) {
                    }
                    userManager2.updateUserState(accountUser);
                    userManager$loadUserInfo$1.L$0 = null;
                    userManager$loadUserInfo$1.label = 2;
                    obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult, userManager$loadUserInfo$1);
                    if (obj != coroutine_suspended) {
                    }
                } else if (i5 == 1) {
                    userManager2 = (UserManager) userManager$loadUserInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    apiResult = (ApiResult) obj;
                    if (!(apiResult instanceof ApiResult.Error)) {
                        accountUser = new AccountUser((String) null, (List) null, (UserInfo) null, 2, (DefaultConstructorMarker) null);
                    } else {
                        if (!(apiResult instanceof ApiResult.Success)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        accountUser = new AccountUser((AccountInfoResponseDTO) ((ApiResult.Success) apiResult).getData());
                    }
                    userManager2.updateUserState(accountUser);
                    userManager$loadUserInfo$1.L$0 = null;
                    userManager$loadUserInfo$1.label = 2;
                    obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult, userManager$loadUserInfo$1);
                    if (obj != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        userManager = (UserManager) userManager$loadUserInfo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        userManager.updateUserState((User) obj);
                        return new ManagerResult.Success(Unit.INSTANCE);
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return obj;
            }
        }
        userManager$loadUserInfo$1 = new UserManager$loadUserInfo$1(this, continuation);
        Object obj2 = userManager$loadUserInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$loadUserInfo$1.label;
        if (i5 != 0) {
        }
        return obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006c A[PHI: r11
      0x006c: PHI (r11v6 java.lang.Object) = (r11v5 java.lang.Object), (r11v1 java.lang.Object) binds: [B:18:0x0069, B:11:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    @Override // dk.molslinjen.domain.managers.user.IUserManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object login(String str, String str2, Continuation<? super ManagerResult<? extends LoginResult>> continuation) {
        UserManager$login$1 userManager$login$1;
        int i5;
        UserManager userManager;
        if (continuation instanceof UserManager$login$1) {
            userManager$login$1 = (UserManager$login$1) continuation;
            int i6 = userManager$login$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$login$1.label = i6 - Integer.MIN_VALUE;
                UserManager$login$1 userManager$login$12 = userManager$login$1;
                Object obj = userManager$login$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$login$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IAccountService iAccountService = this.accountService;
                    SiteDTO dto = getAccountSite().toDTO();
                    userManager$login$12.L$0 = this;
                    userManager$login$12.label = 1;
                    obj = iAccountService.login(str, str2, dto, userManager$login$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    UserManager userManager2 = (UserManager) userManager$login$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    userManager = userManager2;
                }
                userManager$login$12.L$0 = null;
                userManager$login$12.label = 2;
                obj = handleAuthTokenResponse$default(userManager, (ApiResult) obj, null, false, userManager$login$12, 2, null);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        userManager$login$1 = new UserManager$login$1(this, continuation);
        UserManager$login$1 userManager$login$122 = userManager$login$1;
        Object obj2 = userManager$login$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$login$122.label;
        if (i5 != 0) {
        }
        userManager$login$122.L$0 = null;
        userManager$login$122.label = 2;
        obj2 = handleAuthTokenResponse$default(userManager, (ApiResult) obj2, null, false, userManager$login$122, 2, null);
        if (obj2 != coroutine_suspended2) {
        }
    }

    @Override // dk.molslinjen.domain.managers.user.IUserManager
    public Object logout(Continuation<? super Unit> continuation) {
        AuthToken value;
        MutableStateFlow<AuthToken> mutableStateFlow = this.authToken;
        do {
            value = mutableStateFlow.getValue();
            AuthToken authToken = value;
            if (authToken != null) {
                authToken.m3216unboximpl();
            }
        } while (!mutableStateFlow.compareAndSet(value, null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.user.IUserManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mergeAssets(AssetsMergeMethod assetsMergeMethod, Continuation<? super ManagerResult<MergeResult>> continuation) {
        UserManager$mergeAssets$1 userManager$mergeAssets$1;
        int i5;
        UserManager userManager;
        AssetsMergeContext assetsMergeContext;
        if (continuation instanceof UserManager$mergeAssets$1) {
            userManager$mergeAssets$1 = (UserManager$mergeAssets$1) continuation;
            int i6 = userManager$mergeAssets$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$mergeAssets$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userManager$mergeAssets$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$mergeAssets$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    AssetsMergeContext assetsMergeContext2 = this.assetsMergeContext;
                    if (assetsMergeContext2 == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    userManager$mergeAssets$1.L$0 = this;
                    userManager$mergeAssets$1.L$1 = assetsMergeContext2;
                    userManager$mergeAssets$1.label = 1;
                    Object merge = assetsMergeContext2.merge(assetsMergeMethod, userManager$mergeAssets$1);
                    if (merge == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userManager = this;
                    obj = merge;
                    assetsMergeContext = assetsMergeContext2;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ManagerResult managerResult = (ManagerResult) userManager$mergeAssets$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return managerResult;
                    }
                    assetsMergeContext = (AssetsMergeContext) userManager$mergeAssets$1.L$1;
                    userManager = (UserManager) userManager$mergeAssets$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ManagerResult managerResult2 = (ManagerResult) obj;
                UserManager$mergeAssets$2 userManager$mergeAssets$2 = new UserManager$mergeAssets$2(assetsMergeContext, userManager, null);
                userManager$mergeAssets$1.L$0 = managerResult2;
                userManager$mergeAssets$1.L$1 = null;
                userManager$mergeAssets$1.label = 2;
                return ManagerResultExtensionsKt.onSuccess(managerResult2, userManager$mergeAssets$2, userManager$mergeAssets$1) != coroutine_suspended ? coroutine_suspended : managerResult2;
            }
        }
        userManager$mergeAssets$1 = new UserManager$mergeAssets$1(this, continuation);
        Object obj2 = userManager$mergeAssets$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$mergeAssets$1.label;
        if (i5 != 0) {
        }
        ManagerResult managerResult22 = (ManagerResult) obj2;
        UserManager$mergeAssets$2 userManager$mergeAssets$22 = new UserManager$mergeAssets$2(assetsMergeContext, userManager, null);
        userManager$mergeAssets$1.L$0 = managerResult22;
        userManager$mergeAssets$1.L$1 = null;
        userManager$mergeAssets$1.label = 2;
        if (ManagerResultExtensionsKt.onSuccess(managerResult22, userManager$mergeAssets$22, userManager$mergeAssets$1) != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006c A[PHI: r11
      0x006c: PHI (r11v6 java.lang.Object) = (r11v5 java.lang.Object), (r11v1 java.lang.Object) binds: [B:18:0x0069, B:11:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    @Override // dk.molslinjen.domain.managers.user.IUserManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resetPassword(String str, String str2, Continuation<? super ManagerResult<? extends LoginResult>> continuation) {
        UserManager$resetPassword$1 userManager$resetPassword$1;
        int i5;
        UserManager userManager;
        if (continuation instanceof UserManager$resetPassword$1) {
            userManager$resetPassword$1 = (UserManager$resetPassword$1) continuation;
            int i6 = userManager$resetPassword$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$resetPassword$1.label = i6 - Integer.MIN_VALUE;
                UserManager$resetPassword$1 userManager$resetPassword$12 = userManager$resetPassword$1;
                Object obj = userManager$resetPassword$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$resetPassword$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IAccountService iAccountService = this.accountService;
                    SiteDTO dto = getAccountSite().toDTO();
                    userManager$resetPassword$12.L$0 = this;
                    userManager$resetPassword$12.label = 1;
                    obj = iAccountService.resetPassword(str, str2, dto, userManager$resetPassword$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    UserManager userManager2 = (UserManager) userManager$resetPassword$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    userManager = userManager2;
                }
                userManager$resetPassword$12.L$0 = null;
                userManager$resetPassword$12.label = 2;
                obj = handleAuthTokenResponse$default(userManager, (ApiResult) obj, null, false, userManager$resetPassword$12, 2, null);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        userManager$resetPassword$1 = new UserManager$resetPassword$1(this, continuation);
        UserManager$resetPassword$1 userManager$resetPassword$122 = userManager$resetPassword$1;
        Object obj2 = userManager$resetPassword$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$resetPassword$122.label;
        if (i5 != 0) {
        }
        userManager$resetPassword$122.L$0 = null;
        userManager$resetPassword$122.label = 2;
        obj2 = handleAuthTokenResponse$default(userManager, (ApiResult) obj2, null, false, userManager$resetPassword$122, 2, null);
        if (obj2 != coroutine_suspended2) {
        }
    }

    @Override // dk.molslinjen.domain.managers.user.IUserManager
    public Object updateAccountUser(UserPersonalDetails userPersonalDetails, Continuation<? super ManagerResult<Unit>> continuation) {
        UserContactDetails contactDetails;
        String mo3198getAuthTokenOEbVFrA = mo3198getAuthTokenOEbVFrA();
        if (mo3198getAuthTokenOEbVFrA == null) {
            return ManagerResult.Error.INSTANCE.noMessage();
        }
        UserInfo details = getCurrentUserState().getValue().getUser().getDetails();
        if (details == null || (contactDetails = details.getContactDetails()) == null) {
            return ManagerResult.Error.INSTANCE.noMessage();
        }
        String email = contactDetails.getEmail();
        Gender gender = userPersonalDetails.getGender();
        return m3203updateAccountUserhlWoXfE(new UpdateAccountRequestParameters(email, gender != null ? gender.toDTO() : null, userPersonalDetails.getFirstName(), userPersonalDetails.getLastName(), userPersonalDetails.getBirthDate(), userPersonalDetails.getNationality(), contactDetails.getPhoneNumber().getCountryCode(), contactDetails.getPhoneNumber().getNationalNumber(), contactDetails.getPostalCode()), mo3198getAuthTokenOEbVFrA, continuation);
    }

    @Override // dk.molslinjen.domain.managers.user.IUserManager
    public Object updateLocalUser(UserPersonalDetails userPersonalDetails, Continuation<? super ManagerResult<Unit>> continuation) {
        return updateLocalUser(userPersonalDetails, null, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // dk.molslinjen.domain.managers.user.IUserManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateUser(UserInfoInput userInfoInput, Continuation<? super ManagerResult<Unit>> continuation) {
        UserManager$updateUser$1 userManager$updateUser$1;
        int i5;
        UserManager userManager;
        LocalUser localUser;
        if (continuation instanceof UserManager$updateUser$1) {
            userManager$updateUser$1 = (UserManager$updateUser$1) continuation;
            int i6 = userManager$updateUser$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$updateUser$1.label = i6 - Integer.MIN_VALUE;
                Object obj = userManager$updateUser$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$updateUser$1.label;
                if (i5 == 0) {
                    if (i5 == 1) {
                        ResultKt.throwOnFailure(obj);
                    }
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    localUser = (LocalUser) userManager$updateUser$1.L$1;
                    userManager = (UserManager) userManager$updateUser$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    userManager.updateUserState(localUser);
                    userManager.analyticsTracker.updateStateTracking(userManager, null);
                    return new ManagerResult.Success(Unit.INSTANCE);
                }
                ResultKt.throwOnFailure(obj);
                String firstName = userInfoInput.getFirstName();
                String lastName = userInfoInput.getLastName();
                Gender gender = userInfoInput.getGender();
                Locale nationality = userInfoInput.getNationality();
                String country = nationality != null ? nationality.getCountry() : null;
                LocalDate birthdate = userInfoInput.getBirthdate();
                String postalCode = userInfoInput.getPostalCode();
                PhoneNumber phoneNumber = userInfoInput.getPhoneNumber();
                String email = userInfoInput.getEmail();
                if (firstName == null || lastName == null || email == null) {
                    return ManagerResult.Error.INSTANCE.noMessage();
                }
                String mo3198getAuthTokenOEbVFrA = mo3198getAuthTokenOEbVFrA();
                if (mo3198getAuthTokenOEbVFrA != null) {
                    UpdateAccountRequestParameters updateAccountRequestParameters = new UpdateAccountRequestParameters(email, gender != null ? gender.toDTO() : null, firstName, lastName, birthdate, country, phoneNumber.getCountryCode(), phoneNumber.getNationalNumber(), postalCode);
                    userManager$updateUser$1.label = 1;
                    obj = m3203updateAccountUserhlWoXfE(updateAccountRequestParameters, mo3198getAuthTokenOEbVFrA, userManager$updateUser$1);
                    return obj == coroutine_suspended ? coroutine_suspended : obj;
                }
                LocalUser localUser2 = new LocalUser(new UserInfo(email, gender, firstName, lastName, birthdate, country, phoneNumber, postalCode));
                IUserRepository iUserRepository = this.userRepository;
                userManager$updateUser$1.L$0 = this;
                userManager$updateUser$1.L$1 = localUser2;
                userManager$updateUser$1.label = 2;
                if (iUserRepository.save(localUser2, userManager$updateUser$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                userManager = this;
                localUser = localUser2;
                userManager.updateUserState(localUser);
                userManager.analyticsTracker.updateStateTracking(userManager, null);
                return new ManagerResult.Success(Unit.INSTANCE);
            }
        }
        userManager$updateUser$1 = new UserManager$updateUser$1(this, continuation);
        Object obj2 = userManager$updateUser$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$updateUser$1.label;
        if (i5 == 0) {
        }
    }

    @Override // dk.molslinjen.domain.managers.user.IUserManager
    public MutableStateFlow<IUserManager.UserState> getCurrentUserState() {
        return this.currentUserState;
    }

    @Override // dk.molslinjen.domain.managers.user.IUserManager
    public Object updateLocalUser(UserContactDetails userContactDetails, Continuation<? super ManagerResult<Unit>> continuation) {
        return updateLocalUser(null, userContactDetails, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateLocalUser(UserPersonalDetails userPersonalDetails, UserContactDetails userContactDetails, Continuation<? super ManagerResult<Unit>> continuation) {
        UserManager$updateLocalUser$3 userManager$updateLocalUser$3;
        int i5;
        UserManager userManager;
        LocalUser localUser;
        if (continuation instanceof UserManager$updateLocalUser$3) {
            userManager$updateLocalUser$3 = (UserManager$updateLocalUser$3) continuation;
            int i6 = userManager$updateLocalUser$3.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                userManager$updateLocalUser$3.label = i6 - Integer.MIN_VALUE;
                Object obj = userManager$updateLocalUser$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = userManager$updateLocalUser$3.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    User user = getCurrentUserState().getValue().getUser();
                    if (user instanceof LocalUser) {
                        UserInfo userInfo = ((LocalUser) user).getUserInfo();
                        if (userContactDetails == null) {
                            userContactDetails = userInfo.getContactDetails();
                        }
                        if (userPersonalDetails == null) {
                            userPersonalDetails = userInfo.getPersonalDetails();
                        }
                        LocalUser localUser2 = new LocalUser(userInfo.copy(userPersonalDetails, userContactDetails));
                        IUserRepository iUserRepository = this.userRepository;
                        userManager$updateLocalUser$3.L$0 = this;
                        userManager$updateLocalUser$3.L$1 = localUser2;
                        userManager$updateLocalUser$3.label = 1;
                        if (iUserRepository.save(localUser2, userManager$updateLocalUser$3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userManager = this;
                        localUser = localUser2;
                    } else {
                        if (!(user instanceof AccountUser) && !Intrinsics.areEqual(user, Uninitialized.INSTANCE)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    localUser = (LocalUser) userManager$updateLocalUser$3.L$1;
                    userManager = (UserManager) userManager$updateLocalUser$3.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                userManager.updateUserState(localUser);
                userManager.analyticsTracker.updateStateTracking(userManager, null);
                return new ManagerResult.Success(Unit.INSTANCE);
            }
        }
        userManager$updateLocalUser$3 = new UserManager$updateLocalUser$3(this, continuation);
        Object obj2 = userManager$updateLocalUser$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = userManager$updateLocalUser$3.label;
        if (i5 != 0) {
        }
        userManager.updateUserState(localUser);
        userManager.analyticsTracker.updateStateTracking(userManager, null);
        return new ManagerResult.Success(Unit.INSTANCE);
    }
}
