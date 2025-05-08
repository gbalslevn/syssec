package dk.molslinjen.ui.views.screens.booking.passengers.create;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.ProfilePassengerInputContentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckoutPassengerCreateScreenKt$PassengerCreate$4 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ IPassengerInputHandler $inputHandler;
    final /* synthetic */ MutableState<Boolean> $isFormValid$delegate;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ MutableState<Boolean> $submitFieldsTrigger$delegate;
    final /* synthetic */ PassengerCreateViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckoutPassengerCreateScreenKt$PassengerCreate$4(IPassengerInputHandler iPassengerInputHandler, PassengerCreateViewState passengerCreateViewState, DestinationsNavigator destinationsNavigator, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
        this.$inputHandler = iPassengerInputHandler;
        this.$viewState = passengerCreateViewState;
        this.$navigator = destinationsNavigator;
        this.$submitFieldsTrigger$delegate = mutableState;
        this.$isFormValid$delegate = mutableState2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState, boolean z5) {
        CheckoutPassengerCreateScreenKt.PassengerCreate$lambda$8(mutableState, z5);
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
        boolean PassengerCreate$lambda$10;
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1461610008, i5, -1, "dk.molslinjen.ui.views.screens.booking.passengers.create.PassengerCreate.<anonymous> (CheckoutPassengerCreateScreen.kt:83)");
        }
        IPassengerInputHandler iPassengerInputHandler = this.$inputHandler;
        boolean isLoading = this.$viewState.getIsLoading();
        PassengerCreate$lambda$10 = CheckoutPassengerCreateScreenKt.PassengerCreate$lambda$10(this.$submitFieldsTrigger$delegate);
        composer.startReplaceGroup(-259821550);
        final MutableState<Boolean> mutableState = this.$isFormValid$delegate;
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.create.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = CheckoutPassengerCreateScreenKt$PassengerCreate$4.invoke$lambda$1$lambda$0(MutableState.this, ((Boolean) obj).booleanValue());
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function1 function1 = (Function1) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-259819337);
        boolean changed = composer.changed(this.$navigator);
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.create.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = CheckoutPassengerCreateScreenKt$PassengerCreate$4.invoke$lambda$3$lambda$2(DestinationsNavigator.this);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        ProfilePassengerInputContentKt.ProfilePassengerInputContent(null, iPassengerInputHandler, isLoading, PassengerCreate$lambda$10, null, function1, (Function0) rememberedValue2, composer, 196608, 17);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
