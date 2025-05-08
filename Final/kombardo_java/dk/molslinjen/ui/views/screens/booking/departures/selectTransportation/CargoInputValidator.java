package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/CargoInputValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$StringValidator;", BuildConfig.FLAVOR, "maxWeightAllowed", "<init>", "(D)V", BuildConfig.FLAVOR, "input", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "validate", "(Ljava/lang/String;)Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "D", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CargoInputValidator implements IInputValidator.StringValidator {
    private final double maxWeightAllowed;

    public CargoInputValidator(double d5) {
        this.maxWeightAllowed = d5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CargoInputValidator) && Double.compare(this.maxWeightAllowed, ((CargoInputValidator) other).maxWeightAllowed) == 0;
    }

    public int hashCode() {
        return Double.hashCode(this.maxWeightAllowed);
    }

    public String toString() {
        return "CargoInputValidator(maxWeightAllowed=" + this.maxWeightAllowed + ")";
    }

    @Override // dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator.StringValidator
    public InputValidationError validate(String input) {
        Double doubleOrNull = input != null ? StringsKt.toDoubleOrNull(input) : null;
        if (doubleOrNull == null) {
            return InputValidationError.Empty.INSTANCE;
        }
        if (doubleOrNull.doubleValue() > this.maxWeightAllowed) {
            return new InputValidationError.MaxValue(this.maxWeightAllowed, R.string.cargoDetails_weight_description);
        }
        return null;
    }
}
