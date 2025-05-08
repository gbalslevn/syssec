package dk.molslinjen.ui.views.screens.profile.authentication.register;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.site.ISiteManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.UserInfoInput;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.SiteSupportInfo;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.ui.views.reusable.model.UIUploadState;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoInputHandler;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0002HGB1\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b\u001f\u0010\u001dJ\u001a\u0010\"\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010 H\u0096\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010$\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0001¢\u0006\u0004\b$\u0010\u0019J\u001a\u0010&\u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010\u001aH\u0096\u0001¢\u0006\u0004\b&\u0010\u001dJ\u001a\u0010)\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010'H\u0096\u0001¢\u0006\u0004\b)\u0010*J\u0018\u0010,\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b,\u0010\u001dJ\u0018\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020-H\u0096\u0001¢\u0006\u0004\b/\u00100J\u0018\u00102\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b2\u0010\u001dJ\u0018\u00104\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b4\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00105R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00106R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u00107R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u00108R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020:098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020:098\u0006¢\u0006\f\n\u0004\b=\u0010<\u001a\u0004\b>\u0010?R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020@098\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bA\u0010?R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000f0C8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bD\u0010E¨\u0006I"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/register/SignupViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/ui/views/screens/profile/shared/userInfo/IUserInfoInputHandler;", "Ldk/molslinjen/domain/managers/user/IUserManager;", "userManager", "Ldk/molslinjen/domain/managers/site/ISiteManager;", "siteManager", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "snackbarService", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "analyticsTracker", "Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "phoneNumberUtil", "<init>", "(Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/domain/managers/site/ISiteManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;)V", BuildConfig.FLAVOR, "accepted", BuildConfig.FLAVOR, "updateTermsAndLicenseAccept", "(Z)V", "submitData", "()V", "Ljava/util/Locale;", "locale", "updatePhoneNumberCodeFromNationality", "(Ljava/util/Locale;)V", BuildConfig.FLAVOR, "firstName", "updateFirstName", "(Ljava/lang/String;)V", "lastName", "updateLastName", "Ldk/molslinjen/domain/model/account/Gender;", "gender", "updateGender", "(Ldk/molslinjen/domain/model/account/Gender;)V", "updateNationality", "phoneNumberCode", "updatePhoneNumberCode", "Lorg/threeten/bp/LocalDate;", "birthdate", "updateBirthdate", "(Lorg/threeten/bp/LocalDate;)V", "zipCode", "updatePostalCode", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "phoneNumber", "updatePhoneNumber", "(Ldk/molslinjen/domain/model/shared/PhoneNumber;)V", "email", "updateEmail", "password", "updatePassword", "Ldk/molslinjen/domain/managers/user/IUserManager;", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/authentication/register/SignupViewModel$ViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/user/UserInfoInput;", "getUserInfoInput", "userInfoInput", "Lkotlinx/coroutines/flow/StateFlow;", "getHasChanges", "()Lkotlinx/coroutines/flow/StateFlow;", "hasChanges", "Companion", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SignupViewModel extends ViewModel implements IUserInfoInputHandler {
    private final /* synthetic */ UserInfoInputHandler $$delegate_0;
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final PhoneNumberUtil phoneNumberUtil;
    private final ISnackbarService snackbarService;
    private final IUserManager userManager;
    private final MutableStateFlow<ViewState> viewState;
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.authentication.register.SignupViewModel$1", f = "SignupViewModel.kt", l = {41}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.authentication.register.SignupViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ISiteManager $siteManager;
        int label;
        final /* synthetic */ SignupViewModel this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "sites", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/site/SiteInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.authentication.register.SignupViewModel$1$1", f = "SignupViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.profile.authentication.register.SignupViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00611 extends SuspendLambda implements Function2<List<? extends SiteInfo>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SignupViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00611(SignupViewModel signupViewModel, Continuation<? super C00611> continuation) {
                super(2, continuation);
                this.this$0 = signupViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00611 c00611 = new C00611(this.this$0, continuation);
                c00611.L$0 = obj;
                return c00611;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(List<? extends SiteInfo> list, Continuation<? super Unit> continuation) {
                return invoke2((List<SiteInfo>) list, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                SiteInfo siteInfo;
                Object value;
                Object obj2;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                List list = (List) this.L$0;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        if (((SiteInfo) obj2).getSite() == Site.Mols) {
                            break;
                        }
                    }
                    siteInfo = (SiteInfo) obj2;
                } else {
                    siteInfo = null;
                }
                MutableStateFlow mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, null, false, siteInfo != null ? siteInfo.getSupportInfo() : null, null, 11, null)));
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(List<SiteInfo> list, Continuation<? super Unit> continuation) {
                return ((C00611) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ISiteManager iSiteManager, SignupViewModel signupViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$siteManager = iSiteManager;
            this.this$0 = signupViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$siteManager, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<List<SiteInfo>> availableSites = this.$siteManager.getAvailableSites();
                C00611 c00611 = new C00611(this.this$0, null);
                this.label = 1;
                if (FlowKt.collectLatest(availableSites, c00611, this) == coroutine_suspended) {
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

    public SignupViewModel(IUserManager userManager, ISiteManager siteManager, ISnackbarService snackbarService, IAnalyticsTracker analyticsTracker, PhoneNumberUtil phoneNumberUtil) {
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(siteManager, "siteManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(phoneNumberUtil, "phoneNumberUtil");
        this.$$delegate_0 = new UserInfoInputHandler(userManager);
        this.userManager = userManager;
        this.snackbarService = snackbarService;
        this.analyticsTracker = analyticsTracker;
        this.phoneNumberUtil = phoneNumberUtil;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, false, null, null, 15, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(siteManager, this, null), 3, null);
    }

    public StateFlow<Boolean> getHasChanges() {
        return this.$$delegate_0.getHasChanges();
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public MutableStateFlow<UserInfoInput> getUserInfoInput() {
        return this.$$delegate_0.getUserInfoInput();
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void submitData() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SignupViewModel$submitData$1(this, null), 3, null);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateBirthdate(LocalDate birthdate) {
        this.$$delegate_0.updateBirthdate(birthdate);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateEmail(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        this.$$delegate_0.updateEmail(email);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateFirstName(String firstName) {
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        this.$$delegate_0.updateFirstName(firstName);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateGender(Gender gender) {
        this.$$delegate_0.updateGender(gender);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateLastName(String lastName) {
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        this.$$delegate_0.updateLastName(lastName);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateNationality(Locale locale) {
        this.$$delegate_0.updateNationality(locale);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updatePassword(String password) {
        Intrinsics.checkNotNullParameter(password, "password");
        this.$$delegate_0.updatePassword(password);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updatePhoneNumber(PhoneNumber phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        this.$$delegate_0.updatePhoneNumber(phoneNumber);
    }

    public void updatePhoneNumberCode(String phoneNumberCode) {
        this.$$delegate_0.updatePhoneNumberCode(phoneNumberCode);
    }

    public final void updatePhoneNumberCodeFromNationality(Locale locale) {
        String country;
        PhoneNumberUtil phoneNumberUtil = this.phoneNumberUtil;
        if (locale == null || (country = locale.getCountry()) == null) {
            return;
        }
        updatePhoneNumberCode("+" + phoneNumberUtil.getCountryCodeForRegion(country));
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updatePostalCode(String zipCode) {
        Intrinsics.checkNotNullParameter(zipCode, "zipCode");
        this.$$delegate_0.updatePostalCode(zipCode);
    }

    public final void updateTermsAndLicenseAccept(boolean accepted) {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, accepted, null, null, 13, null)));
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ<\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010\u000f¨\u0006!"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/register/SignupViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/reusable/model/UIUploadState;", "uiUploadState", BuildConfig.FLAVOR, "termsAndLicenseAccepted", "Ldk/molslinjen/domain/model/config/SiteSupportInfo;", "signupSiteSupportInfo", BuildConfig.FLAVOR, "originRoute", "<init>", "(Ldk/molslinjen/ui/views/reusable/model/UIUploadState;ZLdk/molslinjen/domain/model/config/SiteSupportInfo;Ljava/lang/String;)V", "copy", "(Ldk/molslinjen/ui/views/reusable/model/UIUploadState;ZLdk/molslinjen/domain/model/config/SiteSupportInfo;Ljava/lang/String;)Ldk/molslinjen/ui/views/screens/profile/authentication/register/SignupViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/ui/views/reusable/model/UIUploadState;", "getUiUploadState", "()Ldk/molslinjen/ui/views/reusable/model/UIUploadState;", "Z", "getTermsAndLicenseAccepted", "()Z", "Ldk/molslinjen/domain/model/config/SiteSupportInfo;", "getSignupSiteSupportInfo", "()Ldk/molslinjen/domain/model/config/SiteSupportInfo;", "Ljava/lang/String;", "getOriginRoute", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final String originRoute;
        private final SiteSupportInfo signupSiteSupportInfo;
        private final boolean termsAndLicenseAccepted;
        private final UIUploadState uiUploadState;

        public ViewState(UIUploadState uiUploadState, boolean z5, SiteSupportInfo siteSupportInfo, String str) {
            Intrinsics.checkNotNullParameter(uiUploadState, "uiUploadState");
            this.uiUploadState = uiUploadState;
            this.termsAndLicenseAccepted = z5;
            this.signupSiteSupportInfo = siteSupportInfo;
            this.originRoute = str;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, UIUploadState uIUploadState, boolean z5, SiteSupportInfo siteSupportInfo, String str, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                uIUploadState = viewState.uiUploadState;
            }
            if ((i5 & 2) != 0) {
                z5 = viewState.termsAndLicenseAccepted;
            }
            if ((i5 & 4) != 0) {
                siteSupportInfo = viewState.signupSiteSupportInfo;
            }
            if ((i5 & 8) != 0) {
                str = viewState.originRoute;
            }
            return viewState.copy(uIUploadState, z5, siteSupportInfo, str);
        }

        public final ViewState copy(UIUploadState uiUploadState, boolean termsAndLicenseAccepted, SiteSupportInfo signupSiteSupportInfo, String originRoute) {
            Intrinsics.checkNotNullParameter(uiUploadState, "uiUploadState");
            return new ViewState(uiUploadState, termsAndLicenseAccepted, signupSiteSupportInfo, originRoute);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.uiUploadState == viewState.uiUploadState && this.termsAndLicenseAccepted == viewState.termsAndLicenseAccepted && Intrinsics.areEqual(this.signupSiteSupportInfo, viewState.signupSiteSupportInfo) && Intrinsics.areEqual(this.originRoute, viewState.originRoute);
        }

        public final String getOriginRoute() {
            return this.originRoute;
        }

        public final SiteSupportInfo getSignupSiteSupportInfo() {
            return this.signupSiteSupportInfo;
        }

        public final boolean getTermsAndLicenseAccepted() {
            return this.termsAndLicenseAccepted;
        }

        public final UIUploadState getUiUploadState() {
            return this.uiUploadState;
        }

        public int hashCode() {
            int hashCode = ((this.uiUploadState.hashCode() * 31) + Boolean.hashCode(this.termsAndLicenseAccepted)) * 31;
            SiteSupportInfo siteSupportInfo = this.signupSiteSupportInfo;
            int hashCode2 = (hashCode + (siteSupportInfo == null ? 0 : siteSupportInfo.hashCode())) * 31;
            String str = this.originRoute;
            return hashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "ViewState(uiUploadState=" + this.uiUploadState + ", termsAndLicenseAccepted=" + this.termsAndLicenseAccepted + ", signupSiteSupportInfo=" + this.signupSiteSupportInfo + ", originRoute=" + this.originRoute + ")";
        }

        public /* synthetic */ ViewState(UIUploadState uIUploadState, boolean z5, SiteSupportInfo siteSupportInfo, String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? UIUploadState.Idle : uIUploadState, (i5 & 2) != 0 ? false : z5, (i5 & 4) != 0 ? null : siteSupportInfo, (i5 & 8) != 0 ? null : str);
        }
    }
}
