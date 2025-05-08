package dk.molslinjen.ui.views.reusable.input.validation.validators;

import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/RequiredBooleanCustomValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$CustomValidator;", "<init>", "()V", "validate", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "input", BuildConfig.FLAVOR, "(Ljava/lang/Boolean;)Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RequiredBooleanCustomValidator implements IInputValidator.CustomValidator {
    public static final RequiredBooleanCustomValidator INSTANCE = new RequiredBooleanCustomValidator();

    private RequiredBooleanCustomValidator() {
    }

    public final InputValidationError validate(Boolean input) {
        if (input == null || !input.booleanValue()) {
            return InputValidationError.Empty.INSTANCE;
        }
        return null;
    }
}
