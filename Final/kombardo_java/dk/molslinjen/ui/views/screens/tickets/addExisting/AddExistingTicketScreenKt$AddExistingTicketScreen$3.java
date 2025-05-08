package dk.molslinjen.ui.views.screens.tickets.addExisting;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.ramcosta.composedestinations.generated.destinations.PhoneNumberCodeSelectionScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AddExistingTicketScreenKt$AddExistingTicketScreen$3 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ AddExistingTicketViewModel.ViewState $state;
    final /* synthetic */ AddExistingTicketViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AddExistingTicketScreenKt$AddExistingTicketScreen$3(AddExistingTicketViewModel.ViewState viewState, AddExistingTicketViewModel addExistingTicketViewModel, DestinationsNavigator destinationsNavigator) {
        this.$state = viewState;
        this.$viewModel = addExistingTicketViewModel;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(AddExistingTicketViewModel addExistingTicketViewModel, DestinationsNavigator destinationsNavigator) {
        addExistingTicketViewModel.addTicket(new AddExistingTicketScreenKt$AddExistingTicketScreen$3$3$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$5(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, PhoneNumberCodeSelectionScreenDestination.INSTANCE, null, null, 6, null);
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
            ComposerKt.traceEventStart(-1568165223, i5, -1, "dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketScreen.<anonymous> (AddExistingTicketScreen.kt:55)");
        }
        AddExistingTicketViewModel.ViewState viewState = this.$state;
        AddExistingTicketViewModel addExistingTicketViewModel = this.$viewModel;
        composer.startReplaceGroup(1809926707);
        boolean changedInstance = composer.changedInstance(addExistingTicketViewModel);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new AddExistingTicketScreenKt$AddExistingTicketScreen$3$1$1(addExistingTicketViewModel);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Function1 function1 = (Function1) ((KFunction) rememberedValue);
        AddExistingTicketViewModel addExistingTicketViewModel2 = this.$viewModel;
        composer.startReplaceGroup(1809929017);
        boolean changedInstance2 = composer.changedInstance(addExistingTicketViewModel2);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new AddExistingTicketScreenKt$AddExistingTicketScreen$3$2$1(addExistingTicketViewModel2);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        Function1 function12 = (Function1) ((KFunction) rememberedValue2);
        composer.startReplaceGroup(1809931237);
        boolean changedInstance3 = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
        final AddExistingTicketViewModel addExistingTicketViewModel3 = this.$viewModel;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.addExisting.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = AddExistingTicketScreenKt$AddExistingTicketScreen$3.invoke$lambda$3$lambda$2(AddExistingTicketViewModel.this, destinationsNavigator);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        Function0 function0 = (Function0) rememberedValue3;
        composer.endReplaceGroup();
        AddExistingTicketViewModel addExistingTicketViewModel4 = this.$viewModel;
        composer.startReplaceGroup(1809933973);
        boolean changedInstance4 = composer.changedInstance(addExistingTicketViewModel4);
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = new AddExistingTicketScreenKt$AddExistingTicketScreen$3$4$1(addExistingTicketViewModel4);
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        Function1 function13 = (Function1) ((KFunction) rememberedValue4);
        composer.startReplaceGroup(1809936466);
        boolean changed = composer.changed(this.$navigator);
        final DestinationsNavigator destinationsNavigator2 = this.$navigator;
        Object rememberedValue5 = composer.rememberedValue();
        if (changed || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
            rememberedValue5 = new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.addExisting.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$6$lambda$5;
                    invoke$lambda$6$lambda$5 = AddExistingTicketScreenKt$AddExistingTicketScreen$3.invoke$lambda$6$lambda$5(DestinationsNavigator.this);
                    return invoke$lambda$6$lambda$5;
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceGroup();
        AddExistingTicketScreenKt.AddExistingTicketContent(viewState, function1, function12, function0, function13, (Function0) rememberedValue5, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
