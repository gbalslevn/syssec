package dk.molslinjen.ui.views.screens.booking.departures.infoAlert;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import dk.molslinjen.domain.model.info.InfoAlert;
import dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewKt;
import dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel;
import dk.molslinjen.ui.views.shared.components.InfoDialogKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a+\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0003¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/infoAlert/InfoAlertViewModel;", "viewModel", BuildConfig.FLAVOR, "InfoAlertView", "(Ldk/molslinjen/ui/views/screens/booking/departures/infoAlert/InfoAlertViewModel;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/departures/infoAlert/InfoAlertViewModel$ViewState;", "state", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/info/InfoAlert;", "setAsShown", "InfoAlertContent", "(Ldk/molslinjen/ui/views/screens/booking/departures/infoAlert/InfoAlertViewModel$ViewState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class InfoAlertViewKt {
    private static final void InfoAlertContent(final InfoAlertViewModel.ViewState viewState, final Function1<? super InfoAlert, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(46132434);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(46132434, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertContent (InfoAlertView.kt:19)");
            }
            final InfoAlert infoAlert = (InfoAlert) CollectionsKt.firstOrNull((List) viewState.getInfoAlertToShow());
            if (infoAlert != null) {
                startRestartGroup.startReplaceGroup(-455069893);
                boolean changedInstance = ((i6 & 112) == 32) | startRestartGroup.changedInstance(infoAlert);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: L2.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit InfoAlertContent$lambda$3$lambda$2;
                            InfoAlertContent$lambda$3$lambda$2 = InfoAlertViewKt.InfoAlertContent$lambda$3$lambda$2(Function1.this, infoAlert);
                            return InfoAlertContent$lambda$3$lambda$2;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                InfoDialogKt.InfoDialog(infoAlert, (Function0) rememberedValue, startRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: L2.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit InfoAlertContent$lambda$4;
                    InfoAlertContent$lambda$4 = InfoAlertViewKt.InfoAlertContent$lambda$4(InfoAlertViewModel.ViewState.this, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return InfoAlertContent$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoAlertContent$lambda$3$lambda$2(Function1 function1, InfoAlert infoAlert) {
        function1.invoke(infoAlert);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoAlertContent$lambda$4(InfoAlertViewModel.ViewState viewState, Function1 function1, int i5, Composer composer, int i6) {
        InfoAlertContent(viewState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void InfoAlertView(final InfoAlertViewModel viewModel, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(-748128957);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-748128957, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertView (InfoAlertView.kt:9)");
            }
            InfoAlertViewModel.ViewState viewState = (InfoAlertViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(1203778003);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new InfoAlertViewKt$InfoAlertView$1$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            InfoAlertContent(viewState, (Function1) ((KFunction) rememberedValue), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: L2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit InfoAlertView$lambda$1;
                    InfoAlertView$lambda$1 = InfoAlertViewKt.InfoAlertView$lambda$1(InfoAlertViewModel.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return InfoAlertView$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoAlertView$lambda$1(InfoAlertViewModel infoAlertViewModel, int i5, Composer composer, int i6) {
        InfoAlertView(infoAlertViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
