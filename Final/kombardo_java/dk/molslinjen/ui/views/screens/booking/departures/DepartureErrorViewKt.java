package dk.molslinjen.ui.views.screens.booking.departures;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.core.snackbar.SnackbarStyle;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.snackbar.StyledSnackbarKt;
import dk.molslinjen.ui.views.screens.booking.departures.DepartureErrorViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a/\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/layout/BoxScope;", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", BuildConfig.FLAVOR, "reloadDeparturesAfterError", "selectedTripDirection", "DepartureErrorView", "(Landroidx/compose/foundation/layout/BoxScope;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/domain/model/booking/DepartureDirection;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DepartureErrorViewKt {
    public static final void DepartureErrorView(final BoxScope boxScope, final Function1<? super DepartureDirection, Unit> reloadDeparturesAfterError, final DepartureDirection selectedTripDirection, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        Intrinsics.checkNotNullParameter(reloadDeparturesAfterError, "reloadDeparturesAfterError");
        Intrinsics.checkNotNullParameter(selectedTripDirection, "selectedTripDirection");
        Composer startRestartGroup = composer.startRestartGroup(29066332);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(boxScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(reloadDeparturesAfterError) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(selectedTripDirection) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(29066332, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.DepartureErrorView (DepartureErrorView.kt:18)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Modifier align = boxScope.align(companion, companion2.getBottomCenter());
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, align);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            String stringResource = StringResources_androidKt.stringResource(R.string.departures_failedLoadingTryAgain, startRestartGroup, 6);
            String stringResource2 = StringResources_androidKt.stringResource(R.string.common_tryAgain, startRestartGroup, 6);
            SnackbarStyle.Information information = SnackbarStyle.Information.INSTANCE;
            startRestartGroup.startReplaceGroup(1339109666);
            boolean z5 = ((i6 & 112) == 32) | ((i6 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: J2.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DepartureErrorView$lambda$4$lambda$1$lambda$0;
                        DepartureErrorView$lambda$4$lambda$1$lambda$0 = DepartureErrorViewKt.DepartureErrorView$lambda$4$lambda$1$lambda$0(Function1.this, selectedTripDirection);
                        return DepartureErrorView$lambda$4$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1339114255);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: J2.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            StyledSnackbarKt.StyledSnackbar(stringResource, stringResource2, function0, (Function0) rememberedValue2, false, information, startRestartGroup, 224256, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: J2.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DepartureErrorView$lambda$5;
                    DepartureErrorView$lambda$5 = DepartureErrorViewKt.DepartureErrorView$lambda$5(BoxScope.this, reloadDeparturesAfterError, selectedTripDirection, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DepartureErrorView$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureErrorView$lambda$4$lambda$1$lambda$0(Function1 function1, DepartureDirection departureDirection) {
        function1.invoke(departureDirection);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureErrorView$lambda$5(BoxScope boxScope, Function1 function1, DepartureDirection departureDirection, int i5, Composer composer, int i6) {
        DepartureErrorView(boxScope, function1, departureDirection, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
