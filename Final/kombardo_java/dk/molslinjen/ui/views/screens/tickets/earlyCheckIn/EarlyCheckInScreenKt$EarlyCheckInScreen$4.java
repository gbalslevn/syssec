package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInAddonsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInFoodScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInPassengerSelectorScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.VehicleSelectorScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EarlyCheckInScreenKt$EarlyCheckInScreen$4 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ PassengerSelectionHelper.PassengerState $passengerState;
    final /* synthetic */ SimpleChangeCheckoutManager.SimpleChangeCheckoutState $simpleChangeCheckoutState;
    final /* synthetic */ EarlyCheckInViewModel.ViewState $state;
    final /* synthetic */ FormValidator $validator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EarlyCheckInScreenKt$EarlyCheckInScreen$4(EarlyCheckInViewModel.ViewState viewState, PassengerSelectionHelper.PassengerState passengerState, SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, FormValidator formValidator, DestinationsNavigator destinationsNavigator) {
        this.$state = viewState;
        this.$passengerState = passengerState;
        this.$simpleChangeCheckoutState = simpleChangeCheckoutState;
        this.$validator = formValidator;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(EarlyCheckInViewModel.ViewState viewState, DestinationsNavigator destinationsNavigator) {
        Booking booking = viewState.getBooking();
        if (booking == null) {
            return Unit.INSTANCE;
        }
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, VehicleSelectorScreenDestination.INSTANCE.invoke(CollectionsKt.arrayListOf(booking.getTicket().getCarId()), CollectionsKt.arrayListOf(booking.getTicket().getTransport().getId()), booking.getSite()), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, EarlyCheckInPassengerSelectorScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$4(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, EarlyCheckInFoodScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$6(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, EarlyCheckInAddonsScreenDestination.INSTANCE, null, null, 6, null);
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
            ComposerKt.traceEventStart(321937317, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInScreen.<anonymous> (EarlyCheckInScreen.kt:157)");
        }
        EarlyCheckInViewModel.ViewState viewState = this.$state;
        PassengerSelectionHelper.PassengerState passengerState = this.$passengerState;
        SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState = this.$simpleChangeCheckoutState;
        FormValidator formValidator = this.$validator;
        composer.startReplaceGroup(-898710290);
        boolean changedInstance = composer.changedInstance(this.$state) | composer.changed(this.$navigator);
        final EarlyCheckInViewModel.ViewState viewState2 = this.$state;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = EarlyCheckInScreenKt$EarlyCheckInScreen$4.invoke$lambda$1$lambda$0(EarlyCheckInViewModel.ViewState.this, destinationsNavigator);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function0 function0 = (Function0) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-898695889);
        boolean changed = composer.changed(this.$navigator);
        final DestinationsNavigator destinationsNavigator2 = this.$navigator;
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = EarlyCheckInScreenKt$EarlyCheckInScreen$4.invoke$lambda$3$lambda$2(DestinationsNavigator.this);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        Function0 function02 = (Function0) rememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-898691582);
        boolean changed2 = composer.changed(this.$navigator);
        final DestinationsNavigator destinationsNavigator3 = this.$navigator;
        Object rememberedValue3 = composer.rememberedValue();
        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$5$lambda$4;
                    invoke$lambda$5$lambda$4 = EarlyCheckInScreenKt$EarlyCheckInScreen$4.invoke$lambda$5$lambda$4(DestinationsNavigator.this);
                    return invoke$lambda$5$lambda$4;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        Function0 function03 = (Function0) rememberedValue3;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-898687612);
        boolean changed3 = composer.changed(this.$navigator);
        final DestinationsNavigator destinationsNavigator4 = this.$navigator;
        Object rememberedValue4 = composer.rememberedValue();
        if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$7$lambda$6;
                    invoke$lambda$7$lambda$6 = EarlyCheckInScreenKt$EarlyCheckInScreen$4.invoke$lambda$7$lambda$6(DestinationsNavigator.this);
                    return invoke$lambda$7$lambda$6;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        EarlyCheckInScreenKt.EarlyCheckInContent(viewState, passengerState, simpleChangeCheckoutState, formValidator, function0, function02, function03, (Function0) rememberedValue4, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
