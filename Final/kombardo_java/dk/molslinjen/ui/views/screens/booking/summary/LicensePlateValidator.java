package dk.molslinjen.ui.views.screens.booking.summary;

import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/summary/LicensePlateValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$CustomValidator;", "<init>", "()V", "validateInput", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "selectedVehicle", "Ldk/molslinjen/domain/model/account/UserVehicle;", "licensePlateRequired", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LicensePlateValidator implements IInputValidator.CustomValidator {
    public static final LicensePlateValidator INSTANCE = new LicensePlateValidator();

    private LicensePlateValidator() {
    }

    public final InputValidationError validateInput(UserVehicle selectedVehicle, boolean licensePlateRequired) {
        if (licensePlateRequired && selectedVehicle == null) {
            return InputValidationError.LicensePlateRequired.INSTANCE;
        }
        return null;
    }
}
