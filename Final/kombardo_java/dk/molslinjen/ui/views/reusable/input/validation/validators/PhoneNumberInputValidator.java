package dk.molslinjen.ui.views.reusable.input.validation.validators;

import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/PhoneNumberInputValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$StringValidator;", "<init>", "()V", "CountryCode", "NationalNumber", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/PhoneNumberInputValidator$CountryCode;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/PhoneNumberInputValidator$NationalNumber;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PhoneNumberInputValidator implements IInputValidator.StringValidator {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/PhoneNumberInputValidator$CountryCode;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/PhoneNumberInputValidator;", "<init>", "()V", "validate", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "input", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class CountryCode extends PhoneNumberInputValidator {
        public static final CountryCode INSTANCE = new CountryCode();

        private CountryCode() {
            super(null);
        }

        @Override // dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator.StringValidator
        public InputValidationError validate(String input) {
            if (input == null || !new Regex("^(\\+?\\d{1,3})$").containsMatchIn(input)) {
                return InputValidationError.PhoneNumber.InvalidCountryCode.INSTANCE;
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/PhoneNumberInputValidator$NationalNumber;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/PhoneNumberInputValidator;", "<init>", "()V", "validate", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "input", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class NationalNumber extends PhoneNumberInputValidator {
        public static final NationalNumber INSTANCE = new NationalNumber();

        private NationalNumber() {
            super(null);
        }

        @Override // dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator.StringValidator
        public InputValidationError validate(String input) {
            if (input == null || !new Regex("^\\d{6,20}$").containsMatchIn(input)) {
                return InputValidationError.PhoneNumber.InvalidNationalNumber.INSTANCE;
            }
            return null;
        }
    }

    public /* synthetic */ PhoneNumberInputValidator(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PhoneNumberInputValidator() {
    }
}
