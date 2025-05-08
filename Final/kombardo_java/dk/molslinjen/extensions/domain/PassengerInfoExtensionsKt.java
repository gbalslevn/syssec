package dk.molslinjen.extensions.domain;

import android.content.Context;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"formatted", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "context", "Landroid/content/Context;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PassengerInfoExtensionsKt {
    public static final String formatted(PassengerInfo passengerInfo, Context context) {
        Intrinsics.checkNotNullParameter(passengerInfo, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        StringBuilder sb = new StringBuilder();
        if (passengerInfo.getAdultCount() > 0) {
            sb.append(passengerInfo.getAdultCount() + " " + context.getResources().getQuantityString(R.plurals.passengers_adult, passengerInfo.getAdultCount()));
        }
        if (passengerInfo.getChildCount() > 0) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(passengerInfo.getChildCount() + " " + context.getResources().getQuantityString(R.plurals.passengers_child, passengerInfo.getChildCount()));
        }
        if (passengerInfo.getInfantCount() > 0) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(passengerInfo.getInfantCount() + " " + context.getResources().getQuantityString(R.plurals.passengers_infant, passengerInfo.getInfantCount()));
        }
        return sb.toString();
    }
}
