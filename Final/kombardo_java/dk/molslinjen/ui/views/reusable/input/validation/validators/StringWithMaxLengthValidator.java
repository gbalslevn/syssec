package dk.molslinjen.ui.views.reusable.input.validation.validators;

import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/StringWithMaxLengthValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$StringValidator;", "maxLength", BuildConfig.FLAVOR, "<init>", "(I)V", "validate", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "input", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class StringWithMaxLengthValidator implements IInputValidator.StringValidator {
    private final int maxLength;

    public StringWithMaxLengthValidator(int i5) {
        this.maxLength = i5;
    }

    @Override // dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator.StringValidator
    public InputValidationError validate(String input) {
        if (input == null || input.length() <= this.maxLength) {
            return null;
        }
        return new InputValidationError.Length.Max(this.maxLength);
    }
}
