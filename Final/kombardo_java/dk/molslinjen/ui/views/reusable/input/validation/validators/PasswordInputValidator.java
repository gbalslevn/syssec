package dk.molslinjen.ui.views.reusable.input.validation.validators;

import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/PasswordInputValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$StringValidator;", "<init>", "()V", "validate", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "input", BuildConfig.FLAVOR, "LengthValidator", "UppercaseValidator", "LowercaseValidator", "NumberOrSpecialCharacterValidator", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PasswordInputValidator implements IInputValidator.StringValidator {
    public static final PasswordInputValidator INSTANCE = new PasswordInputValidator();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/PasswordInputValidator$LengthValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$StringValidator;", "<init>", "()V", "minLength", BuildConfig.FLAVOR, "validate", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "input", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class LengthValidator implements IInputValidator.StringValidator {
        public static final LengthValidator INSTANCE = new LengthValidator();
        private static final int minLength = 8;

        private LengthValidator() {
        }

        @Override // dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator.StringValidator
        public InputValidationError validate(String input) {
            if (input == null || input.length() < 8) {
                return InputValidationError.Password.TooShort.INSTANCE;
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/PasswordInputValidator$LowercaseValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$StringValidator;", "<init>", "()V", "validate", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "input", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class LowercaseValidator implements IInputValidator.StringValidator {
        public static final LowercaseValidator INSTANCE = new LowercaseValidator();

        private LowercaseValidator() {
        }

        @Override // dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator.StringValidator
        public InputValidationError validate(String input) {
            if (input == null || !StringExtensionsKt.containsLowerCaseLetters(input)) {
                return InputValidationError.Password.NoLowercase.INSTANCE;
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/PasswordInputValidator$NumberOrSpecialCharacterValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$StringValidator;", "<init>", "()V", "validate", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "input", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class NumberOrSpecialCharacterValidator implements IInputValidator.StringValidator {
        public static final NumberOrSpecialCharacterValidator INSTANCE = new NumberOrSpecialCharacterValidator();

        private NumberOrSpecialCharacterValidator() {
        }

        @Override // dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator.StringValidator
        public InputValidationError validate(String input) {
            if (input == null || !(StringExtensionsKt.containsNumber(input) || StringExtensionsKt.containsSpecialCharacter(input))) {
                return InputValidationError.Password.NoNumberOrSpecialCharacter.INSTANCE;
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/PasswordInputValidator$UppercaseValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$StringValidator;", "<init>", "()V", "validate", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "input", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class UppercaseValidator implements IInputValidator.StringValidator {
        public static final UppercaseValidator INSTANCE = new UppercaseValidator();

        private UppercaseValidator() {
        }

        @Override // dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator.StringValidator
        public InputValidationError validate(String input) {
            if (input == null || !StringExtensionsKt.containsUpperCaseLetters(input)) {
                return InputValidationError.Password.NoUppercase.INSTANCE;
            }
            return null;
        }
    }

    private PasswordInputValidator() {
    }

    @Override // dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator.StringValidator
    public InputValidationError validate(String input) {
        InputValidationError validate = LengthValidator.INSTANCE.validate(input);
        if (validate != null) {
            return validate;
        }
        InputValidationError validate2 = UppercaseValidator.INSTANCE.validate(input);
        if (validate2 != null) {
            return validate2;
        }
        InputValidationError validate3 = LowercaseValidator.INSTANCE.validate(input);
        return validate3 == null ? NumberOrSpecialCharacterValidator.INSTANCE.validate(input) : validate3;
    }
}
