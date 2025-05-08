package dk.molslinjen.ui.views.screens.booking.passengers;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.PassengersScreenDestination;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.site.ISiteManager;
import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.account.user.UserInfo;
import dk.molslinjen.domain.model.account.user.UserPersonalDetails;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.SiteSupportInfo;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.PassengerInputHandler;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001EB9\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0019\u001a\u00020\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ>\u0010$\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0096\u0001¢\u0006\u0004\b$\u0010%J\u0018\u0010&\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0001¢\u0006\u0004\b&\u0010'J\u0018\u0010(\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001bH\u0096\u0001¢\u0006\u0004\b(\u0010'J\u001a\u0010)\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0096\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010+\u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010 H\u0096\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010-\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\"H\u0096\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b/\u00100R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00101R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00102R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u00109\u001a\b\u0012\u0004\u0012\u000208078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u0004\u0018\u00010;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u0002080>8F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020B0>8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bC\u0010@¨\u0006F"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/CreateYourSelfAsPassengerViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;", "Ldk/molslinjen/domain/managers/user/IUserManager;", "userManager", "Ldk/molslinjen/domain/managers/checkout/ICheckoutPassengerManager;", "checkoutPassengerManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "configurationManager", "Ldk/molslinjen/domain/managers/site/ISiteManager;", "siteManager", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "checkoutManager", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "<init>", "(Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/domain/managers/checkout/ICheckoutPassengerManager;Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;Ldk/molslinjen/domain/managers/site/ISiteManager;Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;Landroidx/lifecycle/SavedStateHandle;)V", BuildConfig.FLAVOR, "shouldSave", BuildConfig.FLAVOR, "updateSaveInfoToAccount", "(Z)V", "Lkotlin/Function0;", "proceed", "Lkotlinx/coroutines/Job;", "registerPassenger", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/Job;", BuildConfig.FLAVOR, "firstName", "lastName", "Ldk/molslinjen/domain/model/account/Gender;", "gender", "Lorg/threeten/bp/LocalDate;", "birthdate", "Ljava/util/Locale;", "nationality", "setPrefillData", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/account/Gender;Lorg/threeten/bp/LocalDate;Ljava/util/Locale;)V", "updateFirstName", "(Ljava/lang/String;)V", "updateLastName", "updateGender", "(Ldk/molslinjen/domain/model/account/Gender;)V", "updateBirthDate", "(Lorg/threeten/bp/LocalDate;)V", "updateNationality", "(Ljava/util/Locale;)V", "resetPassengerInput", "()V", "Ldk/molslinjen/domain/managers/user/IUserManager;", "Ldk/molslinjen/domain/managers/checkout/ICheckoutPassengerManager;", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "Ldk/molslinjen/ui/views/screens/booking/passengers/PassengersScreenNavArgs;", "navArgs", "Ldk/molslinjen/ui/views/screens/booking/passengers/PassengersScreenNavArgs;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/passengers/CreateYourSelfAsPassengerViewModel$ViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/model/config/Site;", "currentSite", "Ldk/molslinjen/domain/model/config/Site;", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "viewState", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler$InputState;", "getPassengerInput", "passengerInput", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CreateYourSelfAsPassengerViewModel extends ViewModel implements IPassengerInputHandler {
    private final /* synthetic */ PassengerInputHandler $$delegate_0;
    private final MutableStateFlow<ViewState> _viewState;
    private final ICheckoutPassengerManager checkoutPassengerManager;
    private final IConfigurationManager configurationManager;
    private final Site currentSite;
    private final PassengersScreenNavArgs navArgs;
    private final IUserManager userManager;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.passengers.CreateYourSelfAsPassengerViewModel$2", f = "CreateYourSelfAsPassengerViewModel.kt", l = {57}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.passengers.CreateYourSelfAsPassengerViewModel$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "authType", "Ldk/molslinjen/domain/managers/user/AuthenticationType;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.passengers.CreateYourSelfAsPassengerViewModel$2$1", f = "CreateYourSelfAsPassengerViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.booking.passengers.CreateYourSelfAsPassengerViewModel$2$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<AuthenticationType, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ CreateYourSelfAsPassengerViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(CreateYourSelfAsPassengerViewModel createYourSelfAsPassengerViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = createYourSelfAsPassengerViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AuthenticationType authenticationType, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(authenticationType, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object value;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                boolean isAuthenticated = ((AuthenticationType) this.L$0).isAuthenticated();
                UserInfo details = this.this$0.userManager.getCurrentUserState().getValue().getUser().getDetails();
                UserPersonalDetails personalDetails = details != null ? details.getPersonalDetails() : null;
                if (personalDetails != null) {
                    CreateYourSelfAsPassengerViewModel createYourSelfAsPassengerViewModel = this.this$0;
                    String firstName = personalDetails.getFirstName();
                    String lastName = personalDetails.getLastName();
                    Gender gender = personalDetails.getGender();
                    LocalDate birthDate = personalDetails.getBirthDate();
                    String nationality = personalDetails.getNationality();
                    createYourSelfAsPassengerViewModel.setPrefillData(firstName, lastName, gender, birthDate, nationality != null ? new Locale(BuildConfig.FLAVOR, nationality) : null);
                }
                MutableStateFlow mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, false, isAuthenticated && (personalDetails == null || personalDetails.getHasPartialData()), false, null, null, 29, null)));
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
                StateFlow<AuthenticationType> authenticationType = CreateYourSelfAsPassengerViewModel.this.userManager.getAuthenticationType();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(CreateYourSelfAsPassengerViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(authenticationType, anonymousClass1, this) == coroutine_suspended) {
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

    public CreateYourSelfAsPassengerViewModel(IUserManager userManager, ICheckoutPassengerManager checkoutPassengerManager, IConfigurationManager configurationManager, ISiteManager siteManager, ICheckoutManager checkoutManager, SavedStateHandle savedStateHandle) {
        String str;
        Object obj;
        SiteSupportInfo supportInfo;
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(checkoutPassengerManager, "checkoutPassengerManager");
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        Intrinsics.checkNotNullParameter(siteManager, "siteManager");
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.$$delegate_0 = new PassengerInputHandler();
        this.userManager = userManager;
        this.checkoutPassengerManager = checkoutPassengerManager;
        this.configurationManager = configurationManager;
        this.navArgs = PassengersScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        CheckoutManager.CheckoutState value = checkoutManager.getCheckoutState().getValue();
        this.currentSite = value != null ? value.getSite() : null;
        List<SiteInfo> value2 = siteManager.getAvailableSites().getValue();
        if (value2 != null) {
            Iterator<T> it = value2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((SiteInfo) obj).getSite() == this.currentSite) {
                        break;
                    }
                }
            }
            SiteInfo siteInfo = (SiteInfo) obj;
            if (siteInfo != null && (supportInfo = siteInfo.getSupportInfo()) != null) {
                str = supportInfo.getPrivacyPolicyPageUrl();
                this._viewState = StateFlowKt.MutableStateFlow(new ViewState(false, false, false, str, this.navArgs.getDepartureDirection(), 7, null));
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
            }
        }
        str = null;
        this._viewState = StateFlowKt.MutableStateFlow(new ViewState(false, false, false, str, this.navArgs.getDepartureDirection(), 7, null));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public StateFlow<IPassengerInputHandler.InputState> getPassengerInput() {
        return this.$$delegate_0.getPassengerInput();
    }

    public final StateFlow<ViewState> getViewState() {
        return this._viewState;
    }

    public final Job registerPassenger(Function0<Unit> proceed) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CreateYourSelfAsPassengerViewModel$registerPassenger$1(this, proceed, null), 3, null);
        return launch$default;
    }

    public void resetPassengerInput() {
        this.$$delegate_0.resetPassengerInput();
    }

    public void setPrefillData(String firstName, String lastName, Gender gender, LocalDate birthdate, Locale nationality) {
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        this.$$delegate_0.setPrefillData(firstName, lastName, gender, birthdate, nationality);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public void updateBirthDate(LocalDate birthdate) {
        this.$$delegate_0.updateBirthDate(birthdate);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public void updateFirstName(String firstName) {
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        this.$$delegate_0.updateFirstName(firstName);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public void updateGender(Gender gender) {
        this.$$delegate_0.updateGender(gender);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public void updateLastName(String lastName) {
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        this.$$delegate_0.updateLastName(lastName);
    }

    public void updateNationality(Locale nationality) {
        this.$$delegate_0.updateNationality(nationality);
    }

    public final void updateSaveInfoToAccount(boolean shouldSave) {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, false, shouldSave, null, null, 27, null)));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJD\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0003\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\u0017R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u000fR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/CreateYourSelfAsPassengerViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", "hasPartialAccountData", "saveInfoToAccount", BuildConfig.FLAVOR, "privacyPolicyUrl", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "departureDirection", "<init>", "(ZZZLjava/lang/String;Ldk/molslinjen/domain/model/booking/DepartureDirection;)V", "copy", "(ZZZLjava/lang/String;Ldk/molslinjen/domain/model/booking/DepartureDirection;)Ldk/molslinjen/ui/views/screens/booking/passengers/CreateYourSelfAsPassengerViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "getHasPartialAccountData", "getSaveInfoToAccount", "Ljava/lang/String;", "getPrivacyPolicyUrl", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getDepartureDirection", "()Ldk/molslinjen/domain/model/booking/DepartureDirection;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final DepartureDirection departureDirection;
        private final boolean hasPartialAccountData;
        private final boolean isLoading;
        private final String privacyPolicyUrl;
        private final boolean saveInfoToAccount;

        public ViewState(boolean z5, boolean z6, boolean z7, String str, DepartureDirection departureDirection) {
            Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
            this.isLoading = z5;
            this.hasPartialAccountData = z6;
            this.saveInfoToAccount = z7;
            this.privacyPolicyUrl = str;
            this.departureDirection = departureDirection;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, boolean z6, boolean z7, String str, DepartureDirection departureDirection, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 2) != 0) {
                z6 = viewState.hasPartialAccountData;
            }
            boolean z8 = z6;
            if ((i5 & 4) != 0) {
                z7 = viewState.saveInfoToAccount;
            }
            boolean z9 = z7;
            if ((i5 & 8) != 0) {
                str = viewState.privacyPolicyUrl;
            }
            String str2 = str;
            if ((i5 & 16) != 0) {
                departureDirection = viewState.departureDirection;
            }
            return viewState.copy(z5, z8, z9, str2, departureDirection);
        }

        public final ViewState copy(boolean isLoading, boolean hasPartialAccountData, boolean saveInfoToAccount, String privacyPolicyUrl, DepartureDirection departureDirection) {
            Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
            return new ViewState(isLoading, hasPartialAccountData, saveInfoToAccount, privacyPolicyUrl, departureDirection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && this.hasPartialAccountData == viewState.hasPartialAccountData && this.saveInfoToAccount == viewState.saveInfoToAccount && Intrinsics.areEqual(this.privacyPolicyUrl, viewState.privacyPolicyUrl) && this.departureDirection == viewState.departureDirection;
        }

        public final DepartureDirection getDepartureDirection() {
            return this.departureDirection;
        }

        public final boolean getHasPartialAccountData() {
            return this.hasPartialAccountData;
        }

        public final String getPrivacyPolicyUrl() {
            return this.privacyPolicyUrl;
        }

        public final boolean getSaveInfoToAccount() {
            return this.saveInfoToAccount;
        }

        public int hashCode() {
            int hashCode = ((((Boolean.hashCode(this.isLoading) * 31) + Boolean.hashCode(this.hasPartialAccountData)) * 31) + Boolean.hashCode(this.saveInfoToAccount)) * 31;
            String str = this.privacyPolicyUrl;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.departureDirection.hashCode();
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", hasPartialAccountData=" + this.hasPartialAccountData + ", saveInfoToAccount=" + this.saveInfoToAccount + ", privacyPolicyUrl=" + this.privacyPolicyUrl + ", departureDirection=" + this.departureDirection + ")";
        }

        public /* synthetic */ ViewState(boolean z5, boolean z6, boolean z7, String str, DepartureDirection departureDirection, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? false : z6, (i5 & 4) != 0 ? false : z7, (i5 & 8) != 0 ? null : str, departureDirection);
        }
    }
}
