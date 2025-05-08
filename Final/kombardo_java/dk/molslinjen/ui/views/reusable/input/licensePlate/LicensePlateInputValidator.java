package dk.molslinjen.ui.views.reusable.input.licensePlate;

import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import kotlin.Metadata;
import kotlin.ranges.IntRange;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/licensePlate/LicensePlateInputValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$StringValidator;", "<init>", "()V", "range", "Lkotlin/ranges/IntRange;", "validate", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "input", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LicensePlateInputValidator implements IInputValidator.StringValidator {
    public static final LicensePlateInputValidator INSTANCE = new LicensePlateInputValidator();
    private static final IntRange range = new IntRange(2, 10);
    public static final int $stable = 8;

    private LicensePlateInputValidator() {
    }

    @Override // dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator.StringValidator
    public InputValidationError validate(String input) {
        if (input != null && range.contains(input.length())) {
            return null;
        }
        IntRange intRange = range;
        return new InputValidationError.Length.Range(intRange.getFirst(), intRange.getLast());
    }
}
