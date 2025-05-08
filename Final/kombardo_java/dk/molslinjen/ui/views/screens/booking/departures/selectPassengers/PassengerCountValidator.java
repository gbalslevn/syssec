package dk.molslinjen.ui.views.screens.booking.departures.selectPassengers;

import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$CustomValidator;", "<init>", "()V", "validateInput", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "adults", BuildConfig.FLAVOR, "children", "infants", "adultRequiredForInfants", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PassengerCountValidator implements IInputValidator.CustomValidator {
    public static final PassengerCountValidator INSTANCE = new PassengerCountValidator();

    private PassengerCountValidator() {
    }

    public final InputValidationError validateInput(int adults, int children, int infants, boolean adultRequiredForInfants) {
        if (children + adults + infants == 0) {
            return InputValidationError.PassengerCount.NoPassengersSelected.INSTANCE;
        }
        if (infants > 0 && adultRequiredForInfants && adults == 0) {
            return InputValidationError.PassengerCount.AdultForInfantRequired.INSTANCE;
        }
        return null;
    }
}
