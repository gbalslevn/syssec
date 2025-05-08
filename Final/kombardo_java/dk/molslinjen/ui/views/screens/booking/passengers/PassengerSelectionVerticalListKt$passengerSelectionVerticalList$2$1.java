package dk.molslinjen.ui.views.screens.booking.passengers;

import android.content.Context;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState;
import dk.molslinjen.domain.model.booking.AgeGroup;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.extensions.domain.AgeGroupExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PassengerSelectionVerticalListKt$passengerSelectionVerticalList$2$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<String, Unit> $editPassenger;
    final /* synthetic */ BookingPassenger $passenger;
    final /* synthetic */ PassengerSelectionHelper.PassengerState $passengerState;
    final /* synthetic */ Function0<Unit> $showAgeGroupError;
    final /* synthetic */ ISharedPassengerSelectionViewState $state;
    final /* synthetic */ Function1<BookingPassenger, Unit> $toggleSelected;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public PassengerSelectionVerticalListKt$passengerSelectionVerticalList$2$1(PassengerSelectionHelper.PassengerState passengerState, ISharedPassengerSelectionViewState iSharedPassengerSelectionViewState, BookingPassenger bookingPassenger, Context context, Function1<? super BookingPassenger, Unit> function1, Function1<? super String, Unit> function12, Function0<Unit> function0) {
        this.$passengerState = passengerState;
        this.$state = iSharedPassengerSelectionViewState;
        this.$passenger = bookingPassenger;
        this.$context = context;
        this.$toggleSelected = function1;
        this.$editPassenger = function12;
        this.$showAgeGroupError = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(ISharedPassengerSelectionViewState iSharedPassengerSelectionViewState, Function0 function0) {
        if (iSharedPassengerSelectionViewState.getShowAgeGroup()) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(LazyItemScope item, Composer composer, int i5) {
        boolean z5;
        boolean changedInstance;
        Object rememberedValue;
        boolean isAgeGroupEnabled;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1909430749, i5, -1, "dk.molslinjen.ui.views.screens.booking.passengers.passengerSelectionVerticalList.<anonymous>.<anonymous> (PassengerSelectionVerticalList.kt:41)");
        }
        boolean currentUserSelected = this.$passengerState.getCurrentUserSelected();
        String name = this.$state.getShowAgeGroup() ? AgeGroupExtensionsKt.name(this.$passenger.getAgeGroup(), this.$context) : null;
        if (!this.$passengerState.getCurrentUserSelected()) {
            AgeGroup ageGroup = this.$passenger.getAgeGroup();
            ISharedPassengerSelectionViewState iSharedPassengerSelectionViewState = this.$state;
            isAgeGroupEnabled = PassengerSelectionVerticalListKt.isAgeGroupEnabled(ageGroup, iSharedPassengerSelectionViewState, iSharedPassengerSelectionViewState.getShowAgeGroup());
            if (!isAgeGroupEnabled) {
                z5 = false;
                boolean z6 = z5;
                BookingPassenger bookingPassenger = this.$passenger;
                Function1<BookingPassenger, Unit> function1 = this.$toggleSelected;
                Function1<String, Unit> function12 = this.$editPassenger;
                composer.startReplaceGroup(-2083624754);
                changedInstance = composer.changedInstance(this.$state) | composer.changed(this.$showAgeGroupError);
                final ISharedPassengerSelectionViewState iSharedPassengerSelectionViewState2 = this.$state;
                final Function0<Unit> function0 = this.$showAgeGroupError;
                rememberedValue = composer.rememberedValue();
                if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$1$lambda$0;
                            invoke$lambda$1$lambda$0 = PassengerSelectionVerticalListKt$passengerSelectionVerticalList$2$1.invoke$lambda$1$lambda$0(ISharedPassengerSelectionViewState.this, function0);
                            return invoke$lambda$1$lambda$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                CheckoutPassengerRowKt.CheckoutPassengerRow(bookingPassenger, currentUserSelected, function1, function12, (Function0) rememberedValue, name, z6, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    return;
                }
                ComposerKt.traceEventEnd();
                return;
            }
        }
        z5 = true;
        boolean z62 = z5;
        BookingPassenger bookingPassenger2 = this.$passenger;
        Function1<BookingPassenger, Unit> function13 = this.$toggleSelected;
        Function1<String, Unit> function122 = this.$editPassenger;
        composer.startReplaceGroup(-2083624754);
        changedInstance = composer.changedInstance(this.$state) | composer.changed(this.$showAgeGroupError);
        final ISharedPassengerSelectionViewState iSharedPassengerSelectionViewState22 = this.$state;
        final Function0 function02 = this.$showAgeGroupError;
        rememberedValue = composer.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit invoke$lambda$1$lambda$0;
                invoke$lambda$1$lambda$0 = PassengerSelectionVerticalListKt$passengerSelectionVerticalList$2$1.invoke$lambda$1$lambda$0(ISharedPassengerSelectionViewState.this, function02);
                return invoke$lambda$1$lambda$0;
            }
        };
        composer.updateRememberedValue(rememberedValue);
        composer.endReplaceGroup();
        CheckoutPassengerRowKt.CheckoutPassengerRow(bookingPassenger2, currentUserSelected, function13, function122, (Function0) rememberedValue, name, z62, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
    }
}
