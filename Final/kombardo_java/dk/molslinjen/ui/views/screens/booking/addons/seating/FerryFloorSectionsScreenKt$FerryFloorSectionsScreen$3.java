package dk.molslinjen.ui.views.screens.booking.addons.seating;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Offset;
import com.ramcosta.composedestinations.generated.destinations.FerrySectionSeatsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import uniffi.molslinjen_shared.FerrySeatingSectionId;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FerryFloorSectionsScreenKt$FerryFloorSectionsScreen$3 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ FerryFloorSectionViewModel.ViewState $state;
    final /* synthetic */ FerryFloorSectionViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FerryFloorSectionsScreenKt$FerryFloorSectionsScreen$3(FerryFloorSectionViewModel.ViewState viewState, ScrollState scrollState, DestinationsNavigator destinationsNavigator, FerryFloorSectionViewModel ferryFloorSectionViewModel) {
        this.$state = viewState;
        this.$scrollState = scrollState;
        this.$navigator = destinationsNavigator;
        this.$viewModel = ferryFloorSectionViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(DestinationsNavigator destinationsNavigator, FerryFloorSectionViewModel.ViewState viewState, FerrySeatingSectionId sectionId, Offset offset) {
        Intrinsics.checkNotNullParameter(sectionId, "sectionId");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, FerrySectionSeatsScreenDestination.INSTANCE.m3071invokeb0fnrdo(sectionId, viewState.getDirection(), offset), null, null, 6, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1748826101, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionsScreen.<anonymous> (FerryFloorSectionsScreen.kt:99)");
        }
        FerryFloorSectionViewModel.ViewState viewState = this.$state;
        ScrollState scrollState = this.$scrollState;
        composer.startReplaceGroup(-1805904379);
        boolean changed = composer.changed(this.$navigator) | composer.changedInstance(this.$state);
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        final FerryFloorSectionViewModel.ViewState viewState2 = this.$state;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function2() { // from class: dk.molslinjen.ui.views.screens.booking.addons.seating.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = FerryFloorSectionsScreenKt$FerryFloorSectionsScreen$3.invoke$lambda$1$lambda$0(DestinationsNavigator.this, viewState2, (FerrySeatingSectionId) obj, (Offset) obj2);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function2 function2 = (Function2) rememberedValue;
        composer.endReplaceGroup();
        FerryFloorSectionViewModel ferryFloorSectionViewModel = this.$viewModel;
        composer.startReplaceGroup(-1805892834);
        boolean changedInstance = composer.changedInstance(ferryFloorSectionViewModel);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new FerryFloorSectionsScreenKt$FerryFloorSectionsScreen$3$2$1(ferryFloorSectionViewModel);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        Function0 function0 = (Function0) ((KFunction) rememberedValue2);
        FerryFloorSectionViewModel ferryFloorSectionViewModel2 = this.$viewModel;
        composer.startReplaceGroup(-1805890728);
        boolean changedInstance2 = composer.changedInstance(ferryFloorSectionViewModel2);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new FerryFloorSectionsScreenKt$FerryFloorSectionsScreen$3$3$1(ferryFloorSectionViewModel2);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        Function1 function1 = (Function1) ((KFunction) rememberedValue3);
        FerryFloorSectionViewModel ferryFloorSectionViewModel3 = this.$viewModel;
        composer.startReplaceGroup(-1805888614);
        boolean changedInstance3 = composer.changedInstance(ferryFloorSectionViewModel3);
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = new FerryFloorSectionsScreenKt$FerryFloorSectionsScreen$3$4$1(ferryFloorSectionViewModel3);
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        FerryFloorSectionsScreenKt.Content(viewState, scrollState, function2, function0, function1, (Function1) ((KFunction) rememberedValue4), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
