package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.image.ImageHelper;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.LabelCardKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a3\u0010\u0007\u001a\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/model/config/Transportation;", "transportation", BuildConfig.FLAVOR, "weight", "Lkotlin/Function0;", BuildConfig.FLAVOR, "showTransportationSelector", "TransportationSelectorView", "(Ldk/molslinjen/domain/model/config/Transportation;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TransportationSelectorViewKt {
    /* JADX WARN: Removed duplicated region for block: B:44:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TransportationSelectorView(final Transportation transportation, final Integer num, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        String str;
        String name;
        Composer composer2;
        String str2;
        Composer startRestartGroup = composer.startRestartGroup(1332388160);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(transportation) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(num) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1332388160, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorView (TransportationSelectorView.kt:14)");
            }
            startRestartGroup.startReplaceGroup(326481929);
            if (num != null) {
                if (transportation == null || (str2 = transportation.getName()) == null) {
                    str2 = BuildConfig.FLAVOR;
                }
                name = StringResources_androidKt.stringResource(R.string.transportation_withCargo, new Object[]{str2, num}, startRestartGroup, 6);
            } else if (transportation != null) {
                name = transportation.getName();
            } else {
                str = null;
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                LabelCardKt.m3391LabelCardTek12BE(StringResources_androidKt.stringResource(R.string.transportation_headline, startRestartGroup, 6), str, null, null, ImageHelper.INSTANCE.m3193buildImageUrlC8IHX40(transportation == null ? transportation.getImageUrl() : null, null, Dp.m2597boximpl(Dp.m2599constructorimpl(24)), startRestartGroup, 3456, 2), null, false, 0L, 0.0f, function0 != null ? function0 : null, composer2, 0, 492);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            str = name;
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LabelCardKt.m3391LabelCardTek12BE(StringResources_androidKt.stringResource(R.string.transportation_headline, startRestartGroup, 6), str, null, null, ImageHelper.INSTANCE.m3193buildImageUrlC8IHX40(transportation == null ? transportation.getImageUrl() : null, null, Dp.m2597boximpl(Dp.m2599constructorimpl(24)), startRestartGroup, 3456, 2), null, false, 0L, 0.0f, function0 != null ? function0 : null, composer2, 0, 492);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: R2.D
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TransportationSelectorView$lambda$1;
                    TransportationSelectorView$lambda$1 = TransportationSelectorViewKt.TransportationSelectorView$lambda$1(Transportation.this, num, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TransportationSelectorView$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationSelectorView$lambda$1(Transportation transportation, Integer num, Function0 function0, int i5, Composer composer, int i6) {
        TransportationSelectorView(transportation, num, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
