package dk.molslinjen.ui.views.screens.booking.passengers;

import android.content.Context;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/PassengerValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$CustomValidator;", "<init>", "()V", "validateInput", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "remainingAdultCount", BuildConfig.FLAVOR, "remainingChildCount", "remainingInfantCount", "remainingPassengerCount", "isWalking", BuildConfig.FLAVOR, "passengerCount", "context", "Landroid/content/Context;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PassengerValidator implements IInputValidator.CustomValidator {
    public static final PassengerValidator INSTANCE = new PassengerValidator();

    private PassengerValidator() {
    }

    public final InputValidationError validateInput(int remainingAdultCount, int remainingChildCount, int remainingInfantCount, int remainingPassengerCount, boolean isWalking, int passengerCount, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isWalking && passengerCount < 1) {
            return InputValidationError.Passenger.SelectMorePassengers.INSTANCE;
        }
        if (!isWalking && remainingPassengerCount < 0) {
            String quantityString = context.getResources().getQuantityString(R.plurals.passengers_validation_editToMaySelected, Math.abs(remainingPassengerCount), Integer.valueOf(Math.abs(remainingPassengerCount)));
            Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
            return new InputValidationError.Passenger.RemoveSelectedPassengers(quantityString);
        }
        if (isWalking && (remainingAdultCount > 0 || remainingChildCount > 0 || remainingInfantCount > 0)) {
            return InputValidationError.Passenger.SelectMorePassengers.INSTANCE;
        }
        if (!isWalking || (remainingAdultCount >= 0 && remainingChildCount >= 0 && remainingInfantCount >= 0)) {
            return null;
        }
        List listOf = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(remainingAdultCount), Integer.valueOf(remainingChildCount), Integer.valueOf(remainingInfantCount)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listOf) {
            if (((Number) obj).intValue() < 0) {
                arrayList.add(obj);
            }
        }
        int abs = Math.abs(CollectionsKt.sumOfInt(arrayList));
        String quantityString2 = context.getResources().getQuantityString(R.plurals.passengers_validation_editToMaySelected, abs, Integer.valueOf(abs));
        Intrinsics.checkNotNullExpressionValue(quantityString2, "getQuantityString(...)");
        return new InputValidationError.Passenger.RemoveSelectedPassengers(quantityString2);
    }
}
