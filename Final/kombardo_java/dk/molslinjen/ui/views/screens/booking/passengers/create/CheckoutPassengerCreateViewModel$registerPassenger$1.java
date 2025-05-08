package dk.molslinjen.ui.views.screens.booking.passengers.create;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.account.UserPassenger;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.passengers.create.CheckoutPassengerCreateViewModel$registerPassenger$1", f = "CheckoutPassengerCreateViewModel.kt", l = {48, 59, 61}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class CheckoutPassengerCreateViewModel$registerPassenger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $proceed;
    Object L$0;
    int label;
    final /* synthetic */ CheckoutPassengerCreateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckoutPassengerCreateViewModel$registerPassenger$1(CheckoutPassengerCreateViewModel checkoutPassengerCreateViewModel, Function0<Unit> function0, Continuation<? super CheckoutPassengerCreateViewModel$registerPassenger$1> continuation) {
        super(2, continuation);
        this.this$0 = checkoutPassengerCreateViewModel;
        this.$proceed = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CheckoutPassengerCreateViewModel$registerPassenger$1(this.this$0, this.$proceed, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        IUserPassengerManager iUserPassengerManager;
        ManagerResult managerResult;
        Site site;
        IConfigurationManager iConfigurationManager;
        MutableStateFlow mutableStateFlow5;
        MutableStateFlow mutableStateFlow6;
        LocalizedSiteConfiguration localizedSiteConfiguration;
        AgeClassifications ageClassifications;
        ICheckoutPassengerManager iCheckoutPassengerManager;
        DepartureDirection departureDirection;
        boolean z5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._viewState;
            mutableStateFlow2 = this.this$0._viewState;
            mutableStateFlow.setValue(((PassengerCreateViewState) mutableStateFlow2.getValue()).copy(true));
            IPassengerInputHandler.InputState value = this.this$0.getPassengerInput().getValue();
            String firstName = value.getFirstName();
            String lastName = value.getLastName();
            Gender gender = value.getGender();
            LocalDate birthdate = value.getBirthdate();
            Locale nationality = value.getNationality();
            if (StringsKt.isBlank(firstName) || StringsKt.isBlank(lastName) || gender == null || birthdate == null) {
                mutableStateFlow3 = this.this$0._viewState;
                mutableStateFlow4 = this.this$0._viewState;
                mutableStateFlow3.setValue(((PassengerCreateViewState) mutableStateFlow4.getValue()).copy(false));
                return Unit.INSTANCE;
            }
            iUserPassengerManager = this.this$0.passengerManager;
            String country = nationality.getCountry();
            Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
            this.label = 1;
            obj = iUserPassengerManager.registerPassenger(firstName, lastName, gender, birthdate, country, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$proceed.invoke();
                    return Unit.INSTANCE;
                }
                managerResult = (ManagerResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                localizedSiteConfiguration = (LocalizedSiteConfiguration) obj;
                if (localizedSiteConfiguration != null || (ageClassifications = localizedSiteConfiguration.getAgeClassifications()) == null) {
                    return Unit.INSTANCE;
                }
                BookingPassenger bookingPassenger = new BookingPassenger((UserPassenger) ((ManagerResult.Success) managerResult).getData(), ageClassifications);
                iCheckoutPassengerManager = this.this$0.checkoutPassengerManager;
                departureDirection = this.this$0.departureDirection;
                z5 = this.this$0.selectAfterCreation;
                this.L$0 = null;
                this.label = 3;
                if (iCheckoutPassengerManager.addPassenger(bookingPassenger, departureDirection, z5, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.$proceed.invoke();
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        managerResult = (ManagerResult) obj;
        if (managerResult instanceof ManagerResult.Error) {
            mutableStateFlow5 = this.this$0._viewState;
            mutableStateFlow6 = this.this$0._viewState;
            mutableStateFlow5.setValue(((PassengerCreateViewState) mutableStateFlow6.getValue()).copy(false));
            return Unit.INSTANCE;
        }
        if (!(managerResult instanceof ManagerResult.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        site = this.this$0.site;
        if (site == null) {
            return Unit.INSTANCE;
        }
        iConfigurationManager = this.this$0.configurationManager;
        this.L$0 = managerResult;
        this.label = 2;
        obj = iConfigurationManager.getActiveConfiguration(site, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        localizedSiteConfiguration = (LocalizedSiteConfiguration) obj;
        if (localizedSiteConfiguration != null) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CheckoutPassengerCreateViewModel$registerPassenger$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
