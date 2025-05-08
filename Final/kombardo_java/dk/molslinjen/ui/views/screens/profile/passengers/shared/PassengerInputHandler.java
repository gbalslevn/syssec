package dk.molslinjen.ui.views.screens.profile.passengers.shared;

import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/passengers/shared/PassengerInputHandler;", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;", "<init>", "()V", "passengerInput", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler$InputState;", "getPassengerInput", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setPrefillData", BuildConfig.FLAVOR, "firstName", BuildConfig.FLAVOR, "lastName", "gender", "Ldk/molslinjen/domain/model/account/Gender;", "birthdate", "Lorg/threeten/bp/LocalDate;", "nationality", "Ljava/util/Locale;", "updateFirstName", "updateLastName", "updateGender", "updateBirthDate", "updateNationality", "setDataForPassenger", "passenger", "Ldk/molslinjen/domain/model/account/UserPassenger;", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "resetPassengerInput", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PassengerInputHandler implements IPassengerInputHandler {
    private final MutableStateFlow<IPassengerInputHandler.InputState> passengerInput = StateFlowKt.MutableStateFlow(new IPassengerInputHandler.InputState(null, null, null, null, null, 31, null));

    public void resetPassengerInput() {
        MutableStateFlow<IPassengerInputHandler.InputState> passengerInput = getPassengerInput();
        do {
        } while (!passengerInput.compareAndSet(passengerInput.getValue(), new IPassengerInputHandler.InputState(null, null, null, null, null, 31, null)));
    }

    public void setDataForPassenger(UserPassenger passenger) {
        IPassengerInputHandler.InputState value;
        Intrinsics.checkNotNullParameter(passenger, "passenger");
        MutableStateFlow<IPassengerInputHandler.InputState> passengerInput = getPassengerInput();
        do {
            value = passengerInput.getValue();
        } while (!passengerInput.compareAndSet(value, value.copy(passenger.getFirstName(), passenger.getLastName(), passenger.getGender(), passenger.getBirthdate(), new Locale(BuildConfig.FLAVOR, passenger.getNationality()))));
    }

    public void setPrefillData(String firstName, String lastName, Gender gender, LocalDate birthdate, Locale nationality) {
        IPassengerInputHandler.InputState value;
        IPassengerInputHandler.InputState inputState;
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        MutableStateFlow<IPassengerInputHandler.InputState> passengerInput = getPassengerInput();
        do {
            value = passengerInput.getValue();
            inputState = value;
        } while (!passengerInput.compareAndSet(value, inputState.copy(firstName, lastName, gender, birthdate, nationality == null ? inputState.getNationality() : nationality)));
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public void updateBirthDate(LocalDate birthdate) {
        IPassengerInputHandler.InputState value;
        MutableStateFlow<IPassengerInputHandler.InputState> passengerInput = getPassengerInput();
        do {
            value = passengerInput.getValue();
        } while (!passengerInput.compareAndSet(value, IPassengerInputHandler.InputState.copy$default(value, null, null, null, birthdate, null, 23, null)));
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public void updateFirstName(String firstName) {
        IPassengerInputHandler.InputState value;
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        MutableStateFlow<IPassengerInputHandler.InputState> passengerInput = getPassengerInput();
        do {
            value = passengerInput.getValue();
        } while (!passengerInput.compareAndSet(value, IPassengerInputHandler.InputState.copy$default(value, firstName, null, null, null, null, 30, null)));
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public void updateGender(Gender gender) {
        IPassengerInputHandler.InputState value;
        MutableStateFlow<IPassengerInputHandler.InputState> passengerInput = getPassengerInput();
        do {
            value = passengerInput.getValue();
        } while (!passengerInput.compareAndSet(value, IPassengerInputHandler.InputState.copy$default(value, null, null, gender, null, null, 27, null)));
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public void updateLastName(String lastName) {
        IPassengerInputHandler.InputState value;
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        MutableStateFlow<IPassengerInputHandler.InputState> passengerInput = getPassengerInput();
        do {
            value = passengerInput.getValue();
        } while (!passengerInput.compareAndSet(value, IPassengerInputHandler.InputState.copy$default(value, null, lastName, null, null, null, 29, null)));
    }

    public void updateNationality(Locale nationality) {
        IPassengerInputHandler.InputState value;
        IPassengerInputHandler.InputState inputState;
        MutableStateFlow<IPassengerInputHandler.InputState> passengerInput = getPassengerInput();
        do {
            value = passengerInput.getValue();
            inputState = value;
        } while (!passengerInput.compareAndSet(value, IPassengerInputHandler.InputState.copy$default(inputState, null, null, null, null, nationality == null ? inputState.getNationality() : nationality, 15, null)));
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public MutableStateFlow<IPassengerInputHandler.InputState> getPassengerInput() {
        return this.passengerInput;
    }

    public void setDataForPassenger(BookingPassenger passenger) {
        IPassengerInputHandler.InputState value;
        Intrinsics.checkNotNullParameter(passenger, "passenger");
        MutableStateFlow<IPassengerInputHandler.InputState> passengerInput = getPassengerInput();
        do {
            value = passengerInput.getValue();
        } while (!passengerInput.compareAndSet(value, value.copy(passenger.getFirstName(), passenger.getLastName(), passenger.getGender(), passenger.getBirthDate(), new Locale(BuildConfig.FLAVOR, passenger.getNationality()))));
    }
}
