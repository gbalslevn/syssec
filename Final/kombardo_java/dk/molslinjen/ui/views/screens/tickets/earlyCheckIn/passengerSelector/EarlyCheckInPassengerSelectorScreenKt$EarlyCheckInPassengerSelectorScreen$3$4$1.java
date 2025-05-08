package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector;

import dk.molslinjen.domain.model.booking.BookingPassenger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class EarlyCheckInPassengerSelectorScreenKt$EarlyCheckInPassengerSelectorScreen$3$4$1 extends FunctionReferenceImpl implements Function1<BookingPassenger, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EarlyCheckInPassengerSelectorScreenKt$EarlyCheckInPassengerSelectorScreen$3$4$1(Object obj) {
        super(1, obj, EarlyCheckInPassengerSelectorViewModel.class, "toggleSelected", "toggleSelected(Ldk/molslinjen/domain/model/booking/BookingPassenger;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BookingPassenger bookingPassenger) {
        invoke2(bookingPassenger);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BookingPassenger p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((EarlyCheckInPassengerSelectorViewModel) this.receiver).toggleSelected(p02);
    }
}
