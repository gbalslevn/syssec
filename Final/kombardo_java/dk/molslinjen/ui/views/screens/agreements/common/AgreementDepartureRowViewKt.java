package dk.molslinjen.ui.views.screens.agreements.common;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.material3.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.domain.model.agreement.IAgreementDeparture;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.ui.views.screens.agreements.common.AgreementDepartureRowViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aC\u0010\n\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/agreement/IAgreementDeparture;", "agreementDeparture", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "ticketCategory", "Lkotlin/Function2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "showDetails", BuildConfig.FLAVOR, "isHistory", "AgreementDepartureRowView", "(Ldk/molslinjen/domain/model/agreement/IAgreementDeparture;Ldk/molslinjen/domain/model/booking/TicketCategoryType;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AgreementDepartureRowViewKt {
    public static final void AgreementDepartureRowView(final IAgreementDeparture agreementDeparture, final TicketCategoryType ticketCategoryType, final Function2<? super String, ? super String, Unit> showDetails, final boolean z5, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(agreementDeparture, "agreementDeparture");
        Intrinsics.checkNotNullParameter(showDetails, "showDetails");
        Composer startRestartGroup = composer.startRestartGroup(-1531000582);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(agreementDeparture) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(ticketCategoryType) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(showDetails) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1531000582, i6, -1, "dk.molslinjen.ui.views.screens.agreements.common.AgreementDepartureRowView (AgreementDepartureRowView.kt:59)");
            }
            startRestartGroup.startReplaceGroup(-1654833843);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Animatable animatable = (Animatable) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue2 = compositionScopedCoroutineScopeCanceller;
            }
            CompositionLocalKt.CompositionLocalProvider(RippleKt.getLocalRippleConfiguration().provides(null), ComposableLambdaKt.rememberComposableLambda(694791226, true, new AgreementDepartureRowViewKt$AgreementDepartureRowView$1(agreementDeparture.getPhone() != null, ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope(), animatable, agreementDeparture, showDetails, z5, ticketCategoryType), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: o2.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AgreementDepartureRowView$lambda$1;
                    AgreementDepartureRowView$lambda$1 = AgreementDepartureRowViewKt.AgreementDepartureRowView$lambda$1(IAgreementDeparture.this, ticketCategoryType, showDetails, z5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AgreementDepartureRowView$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementDepartureRowView$lambda$1(IAgreementDeparture iAgreementDeparture, TicketCategoryType ticketCategoryType, Function2 function2, boolean z5, int i5, Composer composer, int i6) {
        AgreementDepartureRowView(iAgreementDeparture, ticketCategoryType, function2, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
