package dk.molslinjen.ui.views.screens.booking.passengers.edit;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.domain.model.booking.AgeGroup;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.config.AgeClassifications;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler;
import java.util.Locale;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.passengers.edit.CheckoutPassengerEditViewModel$updatePassenger$1", f = "CheckoutPassengerEditViewModel.kt", l = {98, 111, 129}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class CheckoutPassengerEditViewModel$updatePassenger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $finishFlow;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ CheckoutPassengerEditViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckoutPassengerEditViewModel$updatePassenger$1(CheckoutPassengerEditViewModel checkoutPassengerEditViewModel, Function0<Unit> function0, Continuation<? super CheckoutPassengerEditViewModel$updatePassenger$1> continuation) {
        super(2, continuation);
        this.this$0 = checkoutPassengerEditViewModel;
        this.$finishFlow = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CheckoutPassengerEditViewModel$updatePassenger$1(this.this$0, this.$finishFlow, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x01b5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        BookingPassenger bookingPassenger;
        Locale nationality;
        IConfigurationManager iConfigurationManager;
        Site site;
        Object activeConfiguration;
        String str;
        String str2;
        Gender gender;
        LocalDate localDate;
        AgeClassifications ageClassifications;
        BookingPassenger bookingPassenger2;
        BookingPassenger bookingPassenger3;
        BookingPassenger bookingPassenger4;
        ICheckoutPassengerManager iCheckoutPassengerManager;
        DepartureDirection departureDirection;
        String str3;
        String str4;
        Gender gender2;
        LocalDate localDate2;
        UserPassenger userPassenger;
        UserPassenger userPassenger2;
        UserPassenger userPassenger3;
        UserPassenger userPassenger4;
        MutableStateFlow mutableStateFlow;
        Object value;
        IUserPassengerManager iUserPassengerManager;
        Object updatePassenger;
        ManagerResult managerResult;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            bookingPassenger = this.this$0.originalPassenger;
            if (bookingPassenger == null) {
                return Unit.INSTANCE;
            }
            IPassengerInputHandler.InputState value3 = this.this$0.getPassengerInput().getValue();
            String firstName = value3.getFirstName();
            String lastName = value3.getLastName();
            Gender gender3 = value3.getGender();
            LocalDate birthdate = value3.getBirthdate();
            nationality = value3.getNationality();
            if (StringsKt.isBlank(firstName) || StringsKt.isBlank(lastName) || gender3 == null || birthdate == null) {
                return Unit.INSTANCE;
            }
            iConfigurationManager = this.this$0.configurationManager;
            site = this.this$0.site;
            this.L$0 = firstName;
            this.L$1 = lastName;
            this.L$2 = gender3;
            this.L$3 = birthdate;
            this.L$4 = nationality;
            this.label = 1;
            activeConfiguration = iConfigurationManager.getActiveConfiguration(site, this);
            if (activeConfiguration == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = firstName;
            str2 = lastName;
            gender = gender3;
            localDate = birthdate;
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    updatePassenger = obj;
                    managerResult = (ManagerResult) updatePassenger;
                    if (!(managerResult instanceof ManagerResult.Error)) {
                        mutableStateFlow2 = this.this$0._viewState;
                        do {
                            value2 = mutableStateFlow2.getValue();
                        } while (!mutableStateFlow2.compareAndSet(value2, PassengerEditViewState.copy$default((PassengerEditViewState) value2, null, null, false, false, false, 27, null)));
                    } else {
                        if (!(managerResult instanceof ManagerResult.Success)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        this.$finishFlow.invoke();
                    }
                    return Unit.INSTANCE;
                }
                nationality = (Locale) this.L$4;
                LocalDate localDate3 = (LocalDate) this.L$3;
                Gender gender4 = (Gender) this.L$2;
                String str5 = (String) this.L$1;
                String str6 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                localDate2 = localDate3;
                gender2 = gender4;
                str4 = str5;
                str3 = str6;
                userPassenger = this.this$0.originalUserPassenger;
                if (userPassenger != null) {
                    this.$finishFlow.invoke();
                    return Unit.INSTANCE;
                }
                userPassenger2 = this.this$0.originalUserPassenger;
                String localId = userPassenger2.getLocalId();
                userPassenger3 = this.this$0.originalUserPassenger;
                String remoteId = userPassenger3.getRemoteId();
                String country = nationality.getCountry();
                Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
                userPassenger4 = this.this$0.originalUserPassenger;
                UserPassenger userPassenger5 = new UserPassenger(localId, remoteId, str3, str4, gender2, localDate2, country, userPassenger4.isCurrentUser());
                mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, PassengerEditViewState.copy$default((PassengerEditViewState) value, null, null, true, false, false, 27, null)));
                iUserPassengerManager = this.this$0.passengersManager;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.label = 3;
                updatePassenger = iUserPassengerManager.updatePassenger(userPassenger5, this);
                if (updatePassenger == coroutine_suspended) {
                    return coroutine_suspended;
                }
                managerResult = (ManagerResult) updatePassenger;
                if (!(managerResult instanceof ManagerResult.Error)) {
                }
                return Unit.INSTANCE;
            }
            nationality = (Locale) this.L$4;
            LocalDate localDate4 = (LocalDate) this.L$3;
            Gender gender5 = (Gender) this.L$2;
            String str7 = (String) this.L$1;
            String str8 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            localDate = localDate4;
            gender = gender5;
            str2 = str7;
            str = str8;
            activeConfiguration = obj;
        }
        LocalizedSiteConfiguration localizedSiteConfiguration = (LocalizedSiteConfiguration) activeConfiguration;
        if (localizedSiteConfiguration == null || (ageClassifications = localizedSiteConfiguration.getAgeClassifications()) == null) {
            return Unit.INSTANCE;
        }
        bookingPassenger2 = this.this$0.originalPassenger;
        String localId2 = bookingPassenger2.getLocalId();
        bookingPassenger3 = this.this$0.originalPassenger;
        String remoteId2 = bookingPassenger3.getRemoteId();
        String country2 = nationality.getCountry();
        Intrinsics.checkNotNullExpressionValue(country2, "getCountry(...)");
        bookingPassenger4 = this.this$0.originalPassenger;
        String str9 = str2;
        String str10 = str;
        Gender gender6 = gender;
        LocalDate localDate5 = localDate;
        BookingPassenger bookingPassenger5 = new BookingPassenger(localId2, remoteId2, AgeGroup.INSTANCE.get(ageClassifications, localDate), localDate, str, str9, country2, gender6, bookingPassenger4.isCurrentUser());
        iCheckoutPassengerManager = this.this$0.checkoutPassengerManager;
        departureDirection = this.this$0.departureDirection;
        this.L$0 = str10;
        this.L$1 = str9;
        this.L$2 = gender6;
        this.L$3 = localDate5;
        this.L$4 = nationality;
        this.label = 2;
        if (iCheckoutPassengerManager.updatePassenger(bookingPassenger5, departureDirection, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        str3 = str10;
        str4 = str9;
        gender2 = gender6;
        localDate2 = localDate5;
        userPassenger = this.this$0.originalUserPassenger;
        if (userPassenger != null) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CheckoutPassengerEditViewModel$updatePassenger$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
