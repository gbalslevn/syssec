package dk.molslinjen.ui.views.screens.booking.departures.rows;

import android.content.Context;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalTime;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TimeToLocationViewKt$TimeToLocationView$1 implements Function3<RowScope, Composer, Integer, Unit> {
    final /* synthetic */ LocalTime $arrivalTime;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $departingHarborName;
    final /* synthetic */ String $directionsDestination;
    final /* synthetic */ Function2<String, Context, Unit> $showDirections;
    final /* synthetic */ String $siteName;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public TimeToLocationViewKt$TimeToLocationView$1(String str, String str2, LocalTime localTime, Function2<? super String, ? super Context, Unit> function2, String str3, Context context) {
        this.$siteName = str;
        this.$departingHarborName = str2;
        this.$arrivalTime = localTime;
        this.$showDirections = function2;
        this.$directionsDestination = str3;
        this.$context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function2 function2, String str, Context context) {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        function2.invoke(str, context);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
        invoke(rowScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope TimeToLocationView, Composer composer, int i5) {
        String formatTime;
        Intrinsics.checkNotNullParameter(TimeToLocationView, "$this$TimeToLocationView");
        if ((i5 & 6) == 0) {
            i5 |= composer.changed(TimeToLocationView) ? 4 : 2;
        }
        if ((i5 & 19) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2146789084, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.TimeToLocationView.<anonymous> (TimeToLocationView.kt:63)");
        }
        String str = this.$siteName;
        String str2 = str == null ? BuildConfig.FLAVOR : str;
        String str3 = this.$departingHarborName;
        String str4 = str3 == null ? BuildConfig.FLAVOR : str3;
        LocalTime localTime = this.$arrivalTime;
        String str5 = (localTime == null || (formatTime = LocalDateTimeExtensionsKt.toFormatTime(localTime)) == null) ? BuildConfig.FLAVOR : formatTime;
        composer.startReplaceGroup(-1988896907);
        boolean changed = composer.changed(this.$showDirections) | composer.changed(this.$directionsDestination) | composer.changedInstance(this.$context);
        final Function2<String, Context, Unit> function2 = this.$showDirections;
        final String str6 = this.$directionsDestination;
        final Context context = this.$context;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.departures.rows.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = TimeToLocationViewKt$TimeToLocationView$1.invoke$lambda$1$lambda$0(Function2.this, str6, context);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        TimeToLocationViewKt.TimeToLocationGuide(TimeToLocationView, str2, str4, str5, (Function0) rememberedValue, composer, i5 & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
