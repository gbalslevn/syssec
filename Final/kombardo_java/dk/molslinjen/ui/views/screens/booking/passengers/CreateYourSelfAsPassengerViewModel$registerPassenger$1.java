package dk.molslinjen.ui.views.screens.booking.passengers;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.account.user.UserPersonalDetails;
import dk.molslinjen.domain.model.booking.AgeGroup;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.config.AgeClassifications;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.screens.booking.passengers.CreateYourSelfAsPassengerViewModel;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.passengers.CreateYourSelfAsPassengerViewModel$registerPassenger$1", f = "CreateYourSelfAsPassengerViewModel.kt", l = {95, 106, 118, 126}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class CreateYourSelfAsPassengerViewModel$registerPassenger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $proceed;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ CreateYourSelfAsPassengerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateYourSelfAsPassengerViewModel$registerPassenger$1(CreateYourSelfAsPassengerViewModel createYourSelfAsPassengerViewModel, Function0<Unit> function0, Continuation<? super CreateYourSelfAsPassengerViewModel$registerPassenger$1> continuation) {
        super(2, continuation);
        this.this$0 = createYourSelfAsPassengerViewModel;
        this.$proceed = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateYourSelfAsPassengerViewModel$registerPassenger$1(this.this$0, this.$proceed, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object value;
        LocalDate birthdate;
        Object value2;
        Object updateLocalUser;
        Site site;
        IConfigurationManager iConfigurationManager;
        Site site2;
        Object activeConfiguration;
        Locale locale;
        CreateYourSelfAsPassengerViewModel.ViewState viewState;
        Gender gender;
        String str;
        String str2;
        Object updateAccountUser;
        Object obj2;
        LocalizedSiteConfiguration localizedSiteConfiguration;
        AgeClassifications ageClassifications;
        ICheckoutPassengerManager iCheckoutPassengerManager;
        Object value3;
        Object value4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, CreateYourSelfAsPassengerViewModel.ViewState.copy$default((CreateYourSelfAsPassengerViewModel.ViewState) value, true, false, false, null, null, 30, null)));
            IPassengerInputHandler.InputState value5 = this.this$0.getPassengerInput().getValue();
            String firstName = value5.getFirstName();
            String lastName = value5.getLastName();
            Gender gender2 = value5.getGender();
            birthdate = value5.getBirthdate();
            Locale nationality = value5.getNationality();
            if (StringsKt.isBlank(firstName) || StringsKt.isBlank(lastName) || gender2 == null || birthdate == null) {
                MutableStateFlow mutableStateFlow2 = this.this$0._viewState;
                do {
                    value2 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value2, CreateYourSelfAsPassengerViewModel.ViewState.copy$default((CreateYourSelfAsPassengerViewModel.ViewState) value2, false, false, false, null, null, 30, null)));
                return Unit.INSTANCE;
            }
            CreateYourSelfAsPassengerViewModel.ViewState viewState2 = (CreateYourSelfAsPassengerViewModel.ViewState) this.this$0._viewState.getValue();
            if (!viewState2.getHasPartialAccountData()) {
                IUserManager iUserManager = this.this$0.userManager;
                UserPersonalDetails userPersonalDetails = new UserPersonalDetails(gender2, firstName, lastName, birthdate, nationality.getCountry());
                this.label = 4;
                updateLocalUser = iUserManager.updateLocalUser(userPersonalDetails, this);
                if (updateLocalUser == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = (ManagerResult) updateLocalUser;
            } else {
                if (!viewState2.getSaveInfoToAccount()) {
                    site = this.this$0.currentSite;
                    if (site == null) {
                        return Unit.INSTANCE;
                    }
                    iConfigurationManager = this.this$0.configurationManager;
                    site2 = this.this$0.currentSite;
                    this.L$0 = firstName;
                    this.L$1 = lastName;
                    this.L$2 = gender2;
                    this.L$3 = birthdate;
                    this.L$4 = nationality;
                    this.L$5 = viewState2;
                    this.label = 2;
                    activeConfiguration = iConfigurationManager.getActiveConfiguration(site2, this);
                    if (activeConfiguration == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    locale = nationality;
                    viewState = viewState2;
                    gender = gender2;
                    str = firstName;
                    str2 = lastName;
                    localizedSiteConfiguration = (LocalizedSiteConfiguration) activeConfiguration;
                    if (localizedSiteConfiguration != null) {
                    }
                    return Unit.INSTANCE;
                }
                IUserManager iUserManager2 = this.this$0.userManager;
                UserPersonalDetails userPersonalDetails2 = new UserPersonalDetails(gender2, firstName, lastName, birthdate, nationality.getCountry());
                this.label = 1;
                updateAccountUser = iUserManager2.updateAccountUser(userPersonalDetails2, this);
                if (updateAccountUser == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = (ManagerResult) updateAccountUser;
            }
        } else if (i5 == 1) {
            ResultKt.throwOnFailure(obj);
            updateAccountUser = obj;
            obj2 = (ManagerResult) updateAccountUser;
        } else if (i5 == 2) {
            viewState = (CreateYourSelfAsPassengerViewModel.ViewState) this.L$5;
            Locale locale2 = (Locale) this.L$4;
            LocalDate localDate = (LocalDate) this.L$3;
            Gender gender3 = (Gender) this.L$2;
            String str3 = (String) this.L$1;
            String str4 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            birthdate = localDate;
            gender = gender3;
            str2 = str3;
            str = str4;
            locale = locale2;
            activeConfiguration = obj;
            localizedSiteConfiguration = (LocalizedSiteConfiguration) activeConfiguration;
            if (localizedSiteConfiguration != null || (ageClassifications = localizedSiteConfiguration.getAgeClassifications()) == null) {
                return Unit.INSTANCE;
            }
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            AgeGroup ageGroup = AgeGroup.INSTANCE.get(ageClassifications, birthdate);
            String country = locale.getCountry();
            Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
            BookingPassenger bookingPassenger = new BookingPassenger(uuid, null, ageGroup, birthdate, str, str2, country, gender, true);
            iCheckoutPassengerManager = this.this$0.checkoutPassengerManager;
            DepartureDirection departureDirection = viewState.getDepartureDirection();
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.label = 3;
            if (iCheckoutPassengerManager.addPassenger(bookingPassenger, departureDirection, true, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj2 = new ManagerResult.Success(Unit.INSTANCE);
        } else if (i5 == 3) {
            ResultKt.throwOnFailure(obj);
            obj2 = new ManagerResult.Success(Unit.INSTANCE);
        } else {
            if (i5 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            updateLocalUser = obj;
            obj2 = (ManagerResult) updateLocalUser;
        }
        if (obj2 instanceof ManagerResult.Error) {
            MutableStateFlow mutableStateFlow3 = this.this$0._viewState;
            do {
                value4 = mutableStateFlow3.getValue();
            } while (!mutableStateFlow3.compareAndSet(value4, CreateYourSelfAsPassengerViewModel.ViewState.copy$default((CreateYourSelfAsPassengerViewModel.ViewState) value4, false, false, false, null, null, 30, null)));
        } else {
            if (!(obj2 instanceof ManagerResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            MutableStateFlow mutableStateFlow4 = this.this$0._viewState;
            do {
                value3 = mutableStateFlow4.getValue();
            } while (!mutableStateFlow4.compareAndSet(value3, CreateYourSelfAsPassengerViewModel.ViewState.copy$default((CreateYourSelfAsPassengerViewModel.ViewState) value3, false, false, false, null, null, 30, null)));
            this.this$0.resetPassengerInput();
            this.$proceed.invoke();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreateYourSelfAsPassengerViewModel$registerPassenger$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
