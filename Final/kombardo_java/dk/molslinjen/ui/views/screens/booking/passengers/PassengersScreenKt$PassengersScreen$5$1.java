package dk.molslinjen.ui.views.screens.booking.passengers;

import dk.molslinjen.domain.model.booking.BookingPassenger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class PassengersScreenKt$PassengersScreen$5$1 extends FunctionReferenceImpl implements Function1<BookingPassenger, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PassengersScreenKt$PassengersScreen$5$1(Object obj) {
        super(1, obj, PassengersViewModel.class, "toggleSelected", "toggleSelected(Ldk/molslinjen/domain/model/booking/BookingPassenger;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BookingPassenger bookingPassenger) {
        invoke2(bookingPassenger);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BookingPassenger p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((PassengersViewModel) this.receiver).toggleSelected(p02);
    }
}
