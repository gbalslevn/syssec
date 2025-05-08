package dk.molslinjen.ui.views.screens.agreements.multiride.common;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideChargesExpiry;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.InfoBoxViewKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideExpireInfoBoxKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "multiRideCard", BuildConfig.FLAVOR, "MultiRideExpireInfoBox", "(Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MultiRideExpireInfoBoxKt {
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MultiRideExpireInfoBox(final MultiRideCard multiRideCard, Composer composer, final int i5) {
        int i6;
        String str;
        String pluralStringResource;
        Intrinsics.checkNotNullParameter(multiRideCard, "multiRideCard");
        Composer startRestartGroup = composer.startRestartGroup(1265007593);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(multiRideCard) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1265007593, i6, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideExpireInfoBox (MultiRideExpireInfoBox.kt:19)");
            }
            MultiRideChargesExpiry chargesExpirySoon = multiRideCard.getChargesExpirySoon();
            if (multiRideCard.isExpired()) {
                startRestartGroup.startReplaceGroup(-1355389406);
                pluralStringResource = StringResources_androidKt.stringResource(R.string.multiRide_expired, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            } else if (chargesExpirySoon != null) {
                startRestartGroup.startReplaceGroup(932698096);
                int daysLeft = chargesExpirySoon.getDaysLeft();
                pluralStringResource = StringResources_androidKt.pluralStringResource(R.plurals.multiRide_chargesExpiresInDays, daysLeft, new Object[]{StringResources_androidKt.pluralStringResource(R.plurals.multiRide_numberOfCharges, chargesExpirySoon.getCharges(), new Object[]{Integer.valueOf(chargesExpirySoon.getCharges())}, startRestartGroup, 6), Integer.valueOf(daysLeft)}, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            } else if (multiRideCard.getExpiresSoon()) {
                startRestartGroup.startReplaceGroup(933120440);
                pluralStringResource = StringResources_androidKt.pluralStringResource(R.plurals.multiRide_chargesExpiresInDays, multiRideCard.getDaysUntilCardExpiry(), new Object[]{StringResources_androidKt.pluralStringResource(R.plurals.multiRide_numberOfCharges, multiRideCard.getRemainingCharges(), new Object[]{Integer.valueOf(multiRideCard.getRemainingCharges())}, startRestartGroup, 6), Integer.valueOf(multiRideCard.getDaysUntilCardExpiry())}, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(933621802);
                startRestartGroup.endReplaceGroup();
                str = null;
                if (str != null) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    float f5 = 8;
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                    InfoBoxViewKt.InfoBoxView(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0, str, false, startRestartGroup, 6, 10);
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            str = pluralStringResource;
            if (str != null) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: x2.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MultiRideExpireInfoBox$lambda$1;
                    MultiRideExpireInfoBox$lambda$1 = MultiRideExpireInfoBoxKt.MultiRideExpireInfoBox$lambda$1(MultiRideCard.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MultiRideExpireInfoBox$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideExpireInfoBox$lambda$1(MultiRideCard multiRideCard, int i5, Composer composer, int i6) {
        MultiRideExpireInfoBox(multiRideCard, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
