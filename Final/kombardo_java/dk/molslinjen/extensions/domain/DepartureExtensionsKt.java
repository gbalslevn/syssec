package dk.molslinjen.extensions.domain;

import android.content.Context;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"getTravelTimeFormatted", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "context", "Landroid/content/Context;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DepartureExtensionsKt {
    public static final String getTravelTimeFormatted(IDepartureInfo iDepartureInfo, Context context) {
        Intrinsics.checkNotNullParameter(iDepartureInfo, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        long hours = iDepartureInfo.getTravelTime().toHours();
        String str = iDepartureInfo.getTravelTime().minusHours(hours).toMinutes() + " " + context.getString(R.string.common_minutesShort);
        if (hours <= 0) {
            return str;
        }
        return hours + " " + context.getResources().getQuantityString(R.plurals.common_hours, (int) hours) + " " + str;
    }
}
