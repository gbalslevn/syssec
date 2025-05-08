package dk.molslinjen.core.helpers;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import dk.molslinjen.core.helpers.ExternalActionHelper;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tJ>\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tJ\u0016\u0010\u0014\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/core/helpers/ExternalActionHelper;", BuildConfig.FLAVOR, "<init>", "()V", "composeEmail", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "email", BuildConfig.FLAVOR, "openDialer", "phoneNumber", "addToCalendar", "departureTime", "Lorg/threeten/bp/LocalDateTime;", "arrivalTime", "departureLocation", "arrivalLocation", "siteName", "reservationNumber", "safeExecuteExternalAction", "action", "Lkotlin/Function0;", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExternalActionHelper {
    public static final ExternalActionHelper INSTANCE = new ExternalActionHelper();

    private ExternalActionHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addToCalendar$lambda$4(LocalDateTime localDateTime, LocalDateTime localDateTime2, String str, String str2, Context context, String str3, String str4) {
        Intent intent = new Intent("android.intent.action.EDIT");
        intent.setData(CalendarContract.Events.CONTENT_URI);
        intent.putExtra("beginTime", LocalDateTimeExtensionsKt.toMilliseconds(localDateTime));
        intent.putExtra("endTime", LocalDateTimeExtensionsKt.toMilliseconds(localDateTime2));
        intent.putExtra(Constants.IntentExtra.PushTitle, context.getString(R.string.common_calendarEventDeparture, str3, str + " - " + str2, str4));
        context.startActivity(intent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit composeEmail$lambda$1(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        context.startActivity(intent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openDialer$lambda$3(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + StringsKt.replace$default(str, " ", BuildConfig.FLAVOR, false, 4, (Object) null)));
        context.startActivity(intent);
        return Unit.INSTANCE;
    }

    private final boolean safeExecuteExternalAction(Function0<Unit> action) {
        try {
            action.invoke();
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public final boolean addToCalendar(final Context context, final LocalDateTime departureTime, final LocalDateTime arrivalTime, final String departureLocation, final String arrivalLocation, final String siteName, final String reservationNumber) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(departureLocation, "departureLocation");
        Intrinsics.checkNotNullParameter(arrivalLocation, "arrivalLocation");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        return safeExecuteExternalAction(new Function0() { // from class: v1.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit addToCalendar$lambda$4;
                addToCalendar$lambda$4 = ExternalActionHelper.addToCalendar$lambda$4(LocalDateTime.this, arrivalTime, departureLocation, arrivalLocation, context, siteName, reservationNumber);
                return addToCalendar$lambda$4;
            }
        });
    }

    public final boolean composeEmail(final Context context, final String email) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(email, "email");
        return safeExecuteExternalAction(new Function0() { // from class: v1.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit composeEmail$lambda$1;
                composeEmail$lambda$1 = ExternalActionHelper.composeEmail$lambda$1(context, email);
                return composeEmail$lambda$1;
            }
        });
    }

    public final boolean openDialer(final Context context, final String phoneNumber) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        return safeExecuteExternalAction(new Function0() { // from class: v1.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit openDialer$lambda$3;
                openDialer$lambda$3 = ExternalActionHelper.openDialer$lambda$3(context, phoneNumber);
                return openDialer$lambda$3;
            }
        });
    }
}
