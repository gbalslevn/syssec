package dk.molslinjen.ui.views.screens.booking.departures.selectRoute;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectRoute.RouteSelectorScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"RouteSelectorScreen", BuildConfig.FLAVOR, "navigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "(Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class RouteSelectorScreenKt {
    public static final void RouteSelectorScreen(final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(204557290);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(navigator) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(204557290, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectRoute.RouteSelectorScreen (RouteSelectorScreen.kt:26)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.departures_routeSelector_title, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(2140942549);
            boolean z5 = (i6 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new RouteSelectorScreenKt$RouteSelectorScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(fillMaxSize$default, 0.0f, stringResource, null, 0L, null, (Function0) rememberedValue, null, null, ComposableLambdaKt.rememberComposableLambda(-1892032649, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectRoute.RouteSelectorScreenKt$RouteSelectorScreen$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i7) {
                    Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                    if ((i7 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1892032649, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectRoute.RouteSelectorScreen.<anonymous> (RouteSelectorScreen.kt:32)");
                    }
                    DestinationsNavigator destinationsNavigator = DestinationsNavigator.this;
                    composer3.startReplaceGroup(-1863135404);
                    boolean changed = composer3.changed(destinationsNavigator);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new RouteSelectorScreenKt$RouteSelectorScreen$2$1$1(destinationsNavigator);
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceGroup();
                    dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorViewKt.RouteSelectorView((Function0) rememberedValue2, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 805306374, 442);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: P2.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RouteSelectorScreen$lambda$1;
                    RouteSelectorScreen$lambda$1 = RouteSelectorScreenKt.RouteSelectorScreen$lambda$1(DestinationsNavigator.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return RouteSelectorScreen$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorScreen$lambda$1(DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        RouteSelectorScreen(destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
