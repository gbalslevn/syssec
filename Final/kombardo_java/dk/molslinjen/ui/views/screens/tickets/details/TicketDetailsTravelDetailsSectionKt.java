package dk.molslinjen.ui.views.screens.tickets.details;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.KombardoTravelDetailsViewKt;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.TravelDetailsState;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsTravelDetailsSectionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a+\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/shared/kombardoTravelDetails/IKombardoTravelDetailsHandler$TravelDetailsState;", "state", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "showOnMap", "TicketDetailsTravelDetailsSection", "(Ldk/molslinjen/ui/views/screens/booking/shared/kombardoTravelDetails/IKombardoTravelDetailsHandler$TravelDetailsState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketDetailsTravelDetailsSectionKt {
    public static final void TicketDetailsTravelDetailsSection(final TravelDetailsState state, final Function1<? super String, Unit> showOnMap, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(showOnMap, "showOnMap");
        Composer startRestartGroup = composer.startRestartGroup(321003032);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(state) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(showOnMap) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(321003032, i6, -1, "dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsTravelDetailsSection (TicketDetailsTravelDetailsSection.kt:20)");
            }
            if (state.getDetailSteps().isEmpty()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: p4.T
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TicketDetailsTravelDetailsSection$lambda$0;
                            TicketDetailsTravelDetailsSection$lambda$0 = TicketDetailsTravelDetailsSectionKt.TicketDetailsTravelDetailsSection$lambda$0(TravelDetailsState.this, showOnMap, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return TicketDetailsTravelDetailsSection$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 16;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.ticketDetails_kombardoTravelDetails, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(24), 0.0f, Dp.m2599constructorimpl(f5), 5, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 0, 0, 131068);
            Modifier clip = ClipKt.clip(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), ThemeShapesKt.getThemeShapes().getMedium());
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, clip);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer2 = startRestartGroup;
            KombardoTravelDetailsViewKt.KombardoTravelDetailsView(PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(companion, AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f5)), state.getDetailSteps(), true, true, showOnMap, null, startRestartGroup, ((i6 << 9) & 57344) | 200070, 0);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: p4.U
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketDetailsTravelDetailsSection$lambda$2;
                    TicketDetailsTravelDetailsSection$lambda$2 = TicketDetailsTravelDetailsSectionKt.TicketDetailsTravelDetailsSection$lambda$2(TravelDetailsState.this, showOnMap, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketDetailsTravelDetailsSection$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsTravelDetailsSection$lambda$0(TravelDetailsState travelDetailsState, Function1 function1, int i5, Composer composer, int i6) {
        TicketDetailsTravelDetailsSection(travelDetailsState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsTravelDetailsSection$lambda$2(TravelDetailsState travelDetailsState, Function1 function1, int i5, Composer composer, int i6) {
        TicketDetailsTravelDetailsSection(travelDetailsState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
