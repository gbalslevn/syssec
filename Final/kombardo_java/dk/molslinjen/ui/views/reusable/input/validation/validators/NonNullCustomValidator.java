package dk.molslinjen.ui.views.reusable.input.validation.validators;

import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/NonNullCustomValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$CustomValidator;", "<init>", "()V", "validateInput", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "input", BuildConfig.FLAVOR, "Gender", "Birthdate", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/NonNullCustomValidator$Birthdate;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/NonNullCustomValidator$Gender;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class NonNullCustomValidator implements IInputValidator.CustomValidator {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/NonNullCustomValidator$Birthdate;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/NonNullCustomValidator;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Birthdate extends NonNullCustomValidator {
        public static final Birthdate INSTANCE = new Birthdate();

        private Birthdate() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/NonNullCustomValidator$Gender;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/NonNullCustomValidator;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Gender extends NonNullCustomValidator {
        public static final Gender INSTANCE = new Gender();

        private Gender() {
            super(null);
        }
    }

    public /* synthetic */ NonNullCustomValidator(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final InputValidationError validateInput(Object input) {
        if (input == null) {
            return InputValidationError.Empty.INSTANCE;
        }
        return null;
    }

    private NonNullCustomValidator() {
    }
}
