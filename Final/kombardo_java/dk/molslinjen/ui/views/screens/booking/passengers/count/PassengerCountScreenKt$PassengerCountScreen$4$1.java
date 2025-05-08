package dk.molslinjen.ui.views.screens.booking.passengers.count;

import dk.molslinjen.domain.model.booking.DepartureDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class PassengerCountScreenKt$PassengerCountScreen$4$1 extends FunctionReferenceImpl implements Function2<Integer, DepartureDirection, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PassengerCountScreenKt$PassengerCountScreen$4$1(Object obj) {
        super(2, obj, PassengerCountViewModel.class, "passengerCountChanged", "passengerCountChanged(ILdk/molslinjen/domain/model/booking/DepartureDirection;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, DepartureDirection departureDirection) {
        invoke(num.intValue(), departureDirection);
        return Unit.INSTANCE;
    }

    public final void invoke(int i5, DepartureDirection p12) {
        Intrinsics.checkNotNullParameter(p12, "p1");
        ((PassengerCountViewModel) this.receiver).passengerCountChanged(i5, p12);
    }
}
