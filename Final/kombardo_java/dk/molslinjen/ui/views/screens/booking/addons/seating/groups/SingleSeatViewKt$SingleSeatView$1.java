package dk.molslinjen.ui.views.screens.booking.addons.seating.groups;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.seat.FerrySeatViewKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uniffi.molslinjen_shared.FerrySeat;
import uniffi.molslinjen_shared.FerrySeatType;
import uniffi.molslinjen_shared.FerrySeatingGroupType;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class SingleSeatViewKt$SingleSeatView$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ Function1<FerrySeat, Unit> $onSeatPressed;
    final /* synthetic */ float $rotation;
    final /* synthetic */ List<FerrySeat> $selectedSeats;
    final /* synthetic */ FerrySeatingGroupType.SingleSeat $singleSeat;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SingleSeatViewKt$SingleSeatView$1(FerrySeatingGroupType.SingleSeat singleSeat, float f5, List<FerrySeat> list, Function1<? super FerrySeat, Unit> function1) {
        this.$singleSeat = singleSeat;
        this.$rotation = f5;
        this.$selectedSeats = list;
        this.$onSeatPressed = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function1 function1, FerrySeatingGroupType.SingleSeat singleSeat) {
        function1.invoke(singleSeat.getSeat());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope BaseSeatingContainer, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(BaseSeatingContainer, "$this$BaseSeatingContainer");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(662680704, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SingleSeatView.<anonymous> (SingleSeatView.kt:22)");
        }
        FerrySeatingGroupType.SingleSeat singleSeat = this.$singleSeat;
        FerrySeatType seatType = singleSeat.getSeat().getSeatType();
        float f5 = this.$rotation;
        boolean contains = this.$selectedSeats.contains(this.$singleSeat.getSeat());
        composer.startReplaceGroup(-1923032549);
        boolean changed = composer.changed(this.$onSeatPressed) | composer.changedInstance(this.$singleSeat);
        final Function1<FerrySeat, Unit> function1 = this.$onSeatPressed;
        final FerrySeatingGroupType.SingleSeat singleSeat2 = this.$singleSeat;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.s
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SingleSeatViewKt$SingleSeatView$1.invoke$lambda$1$lambda$0(Function1.this, singleSeat2);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        FerrySeatViewKt.m3442FerrySeatViewaA_HZ9I(singleSeat, 1, seatType, 0.0f, null, f5, contains, (Function0) rememberedValue, composer, 48, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
