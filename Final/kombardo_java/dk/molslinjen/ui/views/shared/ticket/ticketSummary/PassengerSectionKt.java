package dk.molslinjen.ui.views.shared.ticket.ticketSummary;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.adjust.sdk.Constants;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.PassengerSectionKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a=\u0010\n\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "bookingPassengers", BuildConfig.FLAVOR, "showDetails", "focused", BuildConfig.FLAVOR, "passengerCount", "showPassengerNames", BuildConfig.FLAVOR, "PassengerSection", "(Ljava/util/List;ZZIZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PassengerSectionKt {
    public static final void PassengerSection(final List<BookingPassenger> bookingPassengers, final boolean z5, final boolean z6, final int i5, final boolean z7, Composer composer, final int i6) {
        int i7;
        Intrinsics.checkNotNullParameter(bookingPassengers, "bookingPassengers");
        Composer startRestartGroup = composer.startRestartGroup(-919855104);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(bookingPassengers) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i7 |= startRestartGroup.changed(z6) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i7 |= startRestartGroup.changed(i5) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i7 |= startRestartGroup.changed(z7) ? 16384 : 8192;
        }
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-919855104, i7, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.PassengerSection (PassengerSection.kt:19)");
            }
            float f5 = 8;
            SectionContainerKt.m3561SectionContainervCe147k(StringResources_androidKt.stringResource(R.string.ticketSummary_passengerSection_title, startRestartGroup, 6), z6, z5, z7 && bookingPassengers.isEmpty(), null, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), false, false, ComposableLambdaKt.rememberComposableLambda(1708004046, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.PassengerSectionKt$PassengerSection$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    if ((i8 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1708004046, i8, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.PassengerSection.<anonymous> (PassengerSection.kt:28)");
                    }
                    int size = z7 ? bookingPassengers.size() : i5;
                    String quantityString = ((Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getQuantityString(R.plurals.ticketSummary_passengers, size, Integer.valueOf(size));
                    Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                    SummaryRowKt.SummaryRow(R.drawable.icon_profile, quantityString, null, null, composer2, 6, 12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1382659136, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.PassengerSectionKt$PassengerSection$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    if ((i8 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1382659136, i8, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.PassengerSection.<anonymous> (PassengerSection.kt:33)");
                    }
                    if (z7) {
                        composer2.startReplaceGroup(1421271466);
                        Iterator<BookingPassenger> it = bookingPassengers.iterator();
                        while (it.hasNext()) {
                            SummaryRowKt.SummaryRow(R.drawable.icon_profile, it.next().fullName(), null, null, composer2, 6, 12);
                        }
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(1421473183);
                        Resources resources = ((Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources();
                        int i9 = i5;
                        String quantityString = resources.getQuantityString(R.plurals.ticketSummary_passengers, i9, Integer.valueOf(i9));
                        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                        SummaryRowKt.SummaryRow(R.drawable.icon_profile, quantityString, null, null, composer2, 6, 12);
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ((i7 >> 3) & 112) | 807075840 | ((i7 << 3) & 896), 6, Constants.MINIMAL_ERROR_STATUS_CODE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: C4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PassengerSection$lambda$0;
                    PassengerSection$lambda$0 = PassengerSectionKt.PassengerSection$lambda$0(bookingPassengers, z5, z6, i5, z7, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return PassengerSection$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerSection$lambda$0(List list, boolean z5, boolean z6, int i5, boolean z7, int i6, Composer composer, int i7) {
        PassengerSection(list, z5, z6, i5, z7, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }
}
