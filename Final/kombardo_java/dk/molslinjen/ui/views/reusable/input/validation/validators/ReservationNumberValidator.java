package dk.molslinjen.ui.views.reusable.input.validation.validators;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/validators/ReservationNumberValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/NumberWithExactLengthValidator;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ReservationNumberValidator extends NumberWithExactLengthValidator {
    public static final ReservationNumberValidator INSTANCE = new ReservationNumberValidator();

    private ReservationNumberValidator() {
        super(8);
    }
}
