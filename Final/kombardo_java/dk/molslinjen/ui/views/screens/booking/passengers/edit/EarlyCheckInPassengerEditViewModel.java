package dk.molslinjen.ui.views.screens.booking.passengers.edit;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInPassengerEditScreenDestination;
import dk.molslinjen.domain.managers.checkout.IEarlyCheckInPassengerManager;
import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.PassengerInputHandler;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u00020\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0019H\u0096\u0001¢\u0006\u0004\b\u001e\u0010\u001cJ\u001a\u0010!\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0096\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010#H\u0096\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010'H\u0096\u0001¢\u0006\u0004\b)\u0010*J\u0018\u0010-\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020+H\u0096\u0001¢\u0006\u0004\b-\u0010.R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010/R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00100R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u0004\u0018\u00010+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0004\u0018\u0001078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R \u0010>\u001a\b\u0012\u0004\u0012\u00020;0:8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b>\u0010=\u001a\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020E0D8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006I"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/edit/EarlyCheckInPassengerEditViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;", "passengersManager", "Ldk/molslinjen/domain/managers/checkout/IEarlyCheckInPassengerManager;", "earlyCheckInPassengerManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "configurationManager", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "<init>", "(Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;Ldk/molslinjen/domain/managers/checkout/IEarlyCheckInPassengerManager;Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;Landroidx/lifecycle/SavedStateHandle;)V", BuildConfig.FLAVOR, "startDeleteFlow", "()V", "cancelDeleteFlow", "Lkotlin/Function0;", "finishFlow", "deletePassenger", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlinx/coroutines/Job;", "updatePassenger", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/Job;", BuildConfig.FLAVOR, "firstName", "updateFirstName", "(Ljava/lang/String;)V", "lastName", "updateLastName", "Ldk/molslinjen/domain/model/account/Gender;", "gender", "updateGender", "(Ldk/molslinjen/domain/model/account/Gender;)V", "Lorg/threeten/bp/LocalDate;", "birthdate", "updateBirthDate", "(Lorg/threeten/bp/LocalDate;)V", "Ljava/util/Locale;", "nationality", "updateNationality", "(Ljava/util/Locale;)V", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "passenger", "setDataForPassenger", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;)V", "Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;", "Ldk/molslinjen/domain/managers/checkout/IEarlyCheckInPassengerManager;", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "Ldk/molslinjen/ui/views/screens/booking/passengers/edit/EarlyCheckInPassengerEditScreenNavArgs;", "navArgs", "Ldk/molslinjen/ui/views/screens/booking/passengers/edit/EarlyCheckInPassengerEditScreenNavArgs;", "originalPassenger", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "Ldk/molslinjen/domain/model/account/UserPassenger;", "originalUserPassenger", "Ldk/molslinjen/domain/model/account/UserPassenger;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/passengers/edit/PassengerEditViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/model/config/Site;", "site", "Ldk/molslinjen/domain/model/config/Site;", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler$InputState;", "getPassengerInput", "()Lkotlinx/coroutines/flow/StateFlow;", "passengerInput", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EarlyCheckInPassengerEditViewModel extends ViewModel implements IPassengerInputHandler {
    private final /* synthetic */ PassengerInputHandler $$delegate_0;
    private MutableStateFlow<PassengerEditViewState> _viewState;
    private final IConfigurationManager configurationManager;
    private final IEarlyCheckInPassengerManager earlyCheckInPassengerManager;
    private final EarlyCheckInPassengerEditScreenNavArgs navArgs;
    private final BookingPassenger originalPassenger;
    private final UserPassenger originalUserPassenger;
    private final IUserPassengerManager passengersManager;
    private final Site site;
    private final MutableStateFlow<PassengerEditViewState> viewState;

    public EarlyCheckInPassengerEditViewModel(IUserPassengerManager passengersManager, IEarlyCheckInPassengerManager earlyCheckInPassengerManager, IConfigurationManager configurationManager, SavedStateHandle savedStateHandle) {
        Object obj;
        Object obj2;
        PassengerEditViewState value;
        Object obj3;
        Intrinsics.checkNotNullParameter(passengersManager, "passengersManager");
        Intrinsics.checkNotNullParameter(earlyCheckInPassengerManager, "earlyCheckInPassengerManager");
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.$$delegate_0 = new PassengerInputHandler();
        this.passengersManager = passengersManager;
        this.earlyCheckInPassengerManager = earlyCheckInPassengerManager;
        this.configurationManager = configurationManager;
        EarlyCheckInPassengerEditScreenNavArgs argsFrom = EarlyCheckInPassengerEditScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        MutableStateFlow<PassengerEditViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new PassengerEditViewState(null, null, false, false, false, 31, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        this.site = argsFrom.getSite();
        String passengerLocalId = argsFrom.getPassengerLocalId();
        StateFlow<PassengerSelectionHelper.PassengerState> passengerState = earlyCheckInPassengerManager.getPassengerState();
        Iterator<T> it = passengerState.getValue().getPassengers().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            } else {
                obj2 = it.next();
                if (Intrinsics.areEqual(((BookingPassenger) obj2).getLocalId(), passengerLocalId)) {
                    break;
                }
            }
        }
        BookingPassenger bookingPassenger = (BookingPassenger) obj2;
        if (bookingPassenger == null) {
            Iterator<T> it2 = passengerState.getValue().getSelectedPassengers().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj3 = null;
                    break;
                } else {
                    obj3 = it2.next();
                    if (Intrinsics.areEqual(((BookingPassenger) obj3).getLocalId(), passengerLocalId)) {
                        break;
                    }
                }
            }
            bookingPassenger = (BookingPassenger) obj3;
            if (bookingPassenger == null) {
                BookingPassenger currentUser = passengerState.getValue().getCurrentUser();
                bookingPassenger = Intrinsics.areEqual(currentUser != null ? currentUser.getLocalId() : null, passengerLocalId) ? passengerState.getValue().getCurrentUser() : null;
            }
        }
        this.originalPassenger = bookingPassenger;
        Iterator<T> it3 = this.passengersManager.getPassengersState().getValue().getPassengers().iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next = it3.next();
            if (Intrinsics.areEqual(((UserPassenger) next).getLocalId(), passengerLocalId)) {
                obj = next;
                break;
            }
        }
        this.originalUserPassenger = (UserPassenger) obj;
        BookingPassenger bookingPassenger2 = this.originalPassenger;
        if (bookingPassenger2 != null) {
            MutableStateFlow<PassengerEditViewState> mutableStateFlow = this._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, PassengerEditViewState.copy$default(value, bookingPassenger2, this.originalUserPassenger, false, false, false, 28, null)));
            setDataForPassenger(bookingPassenger2);
        }
    }

    public void cancelDeleteFlow() {
        PassengerEditViewState value;
        MutableStateFlow<PassengerEditViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, PassengerEditViewState.copy$default(value, null, null, false, false, false, 15, null)));
    }

    public void deletePassenger(Function0<Unit> finishFlow) {
        Intrinsics.checkNotNullParameter(finishFlow, "finishFlow");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new EarlyCheckInPassengerEditViewModel$deletePassenger$1(this, finishFlow, null), 3, null);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public StateFlow<IPassengerInputHandler.InputState> getPassengerInput() {
        return this.$$delegate_0.getPassengerInput();
    }

    public MutableStateFlow<PassengerEditViewState> getViewState() {
        return this.viewState;
    }

    public void setDataForPassenger(BookingPassenger passenger) {
        Intrinsics.checkNotNullParameter(passenger, "passenger");
        this.$$delegate_0.setDataForPassenger(passenger);
    }

    public void startDeleteFlow() {
        PassengerEditViewState value;
        MutableStateFlow<PassengerEditViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, PassengerEditViewState.copy$default(value, null, null, false, false, true, 15, null)));
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

    public Job updatePassenger(Function0<Unit> finishFlow) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(finishFlow, "finishFlow");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new EarlyCheckInPassengerEditViewModel$updatePassenger$1(this, finishFlow, null), 3, null);
        return launch$default;
    }
}
