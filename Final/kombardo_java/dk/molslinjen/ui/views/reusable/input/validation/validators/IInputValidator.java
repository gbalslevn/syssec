package dk.molslinjen.ui.views.reusable.input.validation.validators;

import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator;", BuildConfig.FLAVOR, "StringValidator", "CustomValidator", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$CustomValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$StringValidator;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IInputValidator {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$CustomValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface CustomValidator extends IInputValidator {
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$StringValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator;", "validate", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "input", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface StringValidator extends IInputValidator {
        InputValidationError validate(String input);
    }
}
