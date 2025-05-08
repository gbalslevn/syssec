package dk.molslinjen.ui.views.screens.booking.departures.selectTrailers;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorScreenKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001ae\u0010\u0015\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u0011H\u0003¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectTrailers/TrailerSelectorViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "TrailerSelectorScreen", "(Ldk/molslinjen/ui/views/screens/booking/departures/selectTrailers/TrailerSelectorViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/departures/selectTrailers/TrailerSelectorViewModel$ViewState;", "viewState", "Ldk/molslinjen/ui/views/screens/booking/departures/selectTrailers/TrailerSelectorViewModel$TrailerSelectedState;", "outboundTrailerState", "returnTrailerState", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "trailerSelected", "Lkotlin/Function0;", "retryLoadingTrailers", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", BuildConfig.FLAVOR, "onChangedForDirection", "TransportationSelectorContent", "(Ldk/molslinjen/ui/views/screens/booking/departures/selectTrailers/TrailerSelectorViewModel$ViewState;Ldk/molslinjen/ui/views/screens/booking/departures/selectTrailers/TrailerSelectorViewModel$TrailerSelectedState;Ldk/molslinjen/ui/views/screens/booking/departures/selectTrailers/TrailerSelectorViewModel$TrailerSelectedState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TrailerSelectorScreenKt {
    public static final void TrailerSelectorScreen(final TrailerSelectorViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-908212001);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-908212001, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorScreen (TrailerSelectorScreen.kt:28)");
            }
            final TrailerSelectorViewModel.ViewState viewState = (TrailerSelectorViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            final TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState = (TrailerSelectorViewModel.TrailerSelectedState) SnapshotStateKt.collectAsState(viewModel.getOutboundTrailerState(), null, startRestartGroup, 0, 1).getValue();
            final TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState2 = (TrailerSelectorViewModel.TrailerSelectedState) SnapshotStateKt.collectAsState(viewModel.getReturnTrailerState(), null, startRestartGroup, 0, 1).getValue();
            String stringResource = StringResources_androidKt.stringResource(R.string.trailer_headline, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-2067527016);
            boolean z5 = (i6 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new TrailerSelectorScreenKt$TrailerSelectorScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(null, 0.0f, stringResource, null, 0L, null, (Function0) rememberedValue, null, ComposableLambdaKt.rememberComposableLambda(551937181, true, new TrailerSelectorScreenKt$TrailerSelectorScreen$2(trailerSelectedState, trailerSelectedState2, viewState, viewModel, navigator), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1571612780, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorScreenKt$TrailerSelectorScreen$3
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
                        ComposerKt.traceEventStart(1571612780, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorScreen.<anonymous> (TrailerSelectorScreen.kt:53)");
                    }
                    TrailerSelectorViewModel.ViewState viewState2 = TrailerSelectorViewModel.ViewState.this;
                    TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState3 = trailerSelectedState;
                    TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState4 = trailerSelectedState2;
                    TrailerSelectorViewModel trailerSelectorViewModel = viewModel;
                    composer3.startReplaceGroup(-918477222);
                    boolean changedInstance = composer3.changedInstance(trailerSelectorViewModel);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new TrailerSelectorScreenKt$TrailerSelectorScreen$3$1$1(trailerSelectorViewModel);
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceGroup();
                    Function1 function1 = (Function1) ((KFunction) rememberedValue2);
                    TrailerSelectorViewModel trailerSelectorViewModel2 = viewModel;
                    composer3.startReplaceGroup(-918475209);
                    boolean changedInstance2 = composer3.changedInstance(trailerSelectorViewModel2);
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new TrailerSelectorScreenKt$TrailerSelectorScreen$3$2$1(trailerSelectorViewModel2);
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceGroup();
                    Function0 function0 = (Function0) ((KFunction) rememberedValue3);
                    TrailerSelectorViewModel trailerSelectorViewModel3 = viewModel;
                    composer3.startReplaceGroup(-918473248);
                    boolean changedInstance3 = composer3.changedInstance(trailerSelectorViewModel3);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changedInstance3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new TrailerSelectorScreenKt$TrailerSelectorScreen$3$3$1(trailerSelectorViewModel3);
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceGroup();
                    TrailerSelectorScreenKt.TransportationSelectorContent(viewState2, trailerSelectedState3, trailerSelectedState4, function1, function0, (Function2) ((KFunction) rememberedValue4), composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, 905969664, 187);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Q2.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TrailerSelectorScreen$lambda$1;
                    TrailerSelectorScreen$lambda$1 = TrailerSelectorScreenKt.TrailerSelectorScreen$lambda$1(TrailerSelectorViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TrailerSelectorScreen$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrailerSelectorScreen$lambda$1(TrailerSelectorViewModel trailerSelectorViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        TrailerSelectorScreen(trailerSelectorViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TransportationSelectorContent(final TrailerSelectorViewModel.ViewState viewState, final TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState, final TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState2, final Function1<? super TrailerProduct, Unit> function1, final Function0<Unit> function0, final Function2<? super DepartureDirection, ? super Boolean, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(2010862554);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(trailerSelectedState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(trailerSelectedState2) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2010862554, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TransportationSelectorContent (TrailerSelectorScreen.kt:72)");
            }
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, viewState.getIsLoading(), 0, viewState.getHasError(), function0, ComposableLambdaKt.rememberComposableLambda(186389518, true, new TrailerSelectorScreenKt$TransportationSelectorContent$1(viewState, trailerSelectedState, trailerSelectedState2, function1, function2), startRestartGroup, 54), startRestartGroup, ((i6 << 3) & 458752) | 1572864, 11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Q2.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TransportationSelectorContent$lambda$2;
                    TransportationSelectorContent$lambda$2 = TrailerSelectorScreenKt.TransportationSelectorContent$lambda$2(TrailerSelectorViewModel.ViewState.this, trailerSelectedState, trailerSelectedState2, function1, function0, function2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TransportationSelectorContent$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationSelectorContent$lambda$2(TrailerSelectorViewModel.ViewState viewState, TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState, TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState2, Function1 function1, Function0 function0, Function2 function2, int i5, Composer composer, int i6) {
        TransportationSelectorContent(viewState, trailerSelectedState, trailerSelectedState2, function1, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
