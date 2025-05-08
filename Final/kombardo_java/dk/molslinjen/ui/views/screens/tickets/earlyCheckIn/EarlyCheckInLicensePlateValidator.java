package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn;

import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/EarlyCheckInLicensePlateValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$CustomValidator;", "<init>", "()V", "validateInput", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "selectedVehicle", "Ldk/molslinjen/domain/model/account/UserVehicle;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EarlyCheckInLicensePlateValidator implements IInputValidator.CustomValidator {
    public static final EarlyCheckInLicensePlateValidator INSTANCE = new EarlyCheckInLicensePlateValidator();

    private EarlyCheckInLicensePlateValidator() {
    }

    public final InputValidationError validateInput(UserVehicle selectedVehicle) {
        if (selectedVehicle == null) {
            return InputValidationError.EarlyCheckInLicensePlateRequired.INSTANCE;
        }
        return null;
    }
}
