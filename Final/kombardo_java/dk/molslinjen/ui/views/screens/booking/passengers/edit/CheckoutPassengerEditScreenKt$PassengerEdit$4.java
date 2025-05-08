package dk.molslinjen.ui.views.screens.booking.passengers.edit;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.profile.passengers.edit.PassengerEditViewKt;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckoutPassengerEditScreenKt$PassengerEdit$4 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ IPassengerInputHandler $inputHandler;
    final /* synthetic */ MutableState<Boolean> $isFormValid$delegate;
    final /* synthetic */ boolean $isLoading;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ Function0<Unit> $startDeleteFlow;
    final /* synthetic */ MutableState<Boolean> $submitFieldsTrigger$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckoutPassengerEditScreenKt$PassengerEdit$4(IPassengerInputHandler iPassengerInputHandler, boolean z5, Function0<Unit> function0, DestinationsNavigator destinationsNavigator, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
        this.$inputHandler = iPassengerInputHandler;
        this.$isLoading = z5;
        this.$startDeleteFlow = function0;
        this.$navigator = destinationsNavigator;
        this.$submitFieldsTrigger$delegate = mutableState;
        this.$isFormValid$delegate = mutableState2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState, boolean z5) {
        CheckoutPassengerEditScreenKt.PassengerEdit$lambda$13(mutableState, z5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, NationalitySelectionScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
        int i6;
        boolean PassengerEdit$lambda$15;
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 6) == 0) {
            i6 = i5 | (composer.changed(BottomSheetContainer) ? 4 : 2);
        } else {
            i6 = i5;
        }
        if ((i6 & 19) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(517786464, i6, -1, "dk.molslinjen.ui.views.screens.booking.passengers.edit.PassengerEdit.<anonymous> (CheckoutPassengerEditScreen.kt:107)");
        }
        IPassengerInputHandler iPassengerInputHandler = this.$inputHandler;
        boolean z5 = this.$isLoading;
        PassengerEdit$lambda$15 = CheckoutPassengerEditScreenKt.PassengerEdit$lambda$15(this.$submitFieldsTrigger$delegate);
        Function0<Unit> function0 = this.$startDeleteFlow;
        composer.startReplaceGroup(-1950604274);
        final MutableState<Boolean> mutableState = this.$isFormValid$delegate;
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.edit.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = CheckoutPassengerEditScreenKt$PassengerEdit$4.invoke$lambda$1$lambda$0(MutableState.this, ((Boolean) obj).booleanValue());
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function1 function1 = (Function1) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-1950602089);
        boolean changed = composer.changed(this.$navigator);
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.edit.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = CheckoutPassengerEditScreenKt$PassengerEdit$4.invoke$lambda$3$lambda$2(DestinationsNavigator.this);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        PassengerEditViewKt.PassengerEditView(BottomSheetContainer, iPassengerInputHandler, R.string.passengers_edit_delete, z5, PassengerEdit$lambda$15, function0, function1, (Function0) rememberedValue2, composer, 1573248 | (i6 & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
