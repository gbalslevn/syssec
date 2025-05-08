package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.model.booking.BookingPassenger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class CheckoutPassengerManager$load$3 extends FunctionReferenceImpl implements Function2<List<? extends BookingPassenger>, List<? extends BookingPassenger>, Pair<? extends List<? extends BookingPassenger>, ? extends List<? extends BookingPassenger>>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckoutPassengerManager$load$3(Object obj) {
        super(2, obj, IEditManager.class, "mergeWithEditingPassengers", "mergeWithEditingPassengers(Ljava/util/List;Ljava/util/List;)Lkotlin/Pair;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Pair<? extends List<? extends BookingPassenger>, ? extends List<? extends BookingPassenger>> invoke(List<? extends BookingPassenger> list, List<? extends BookingPassenger> list2) {
        return invoke2((List<BookingPassenger>) list, (List<BookingPassenger>) list2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<List<BookingPassenger>, List<BookingPassenger>> invoke2(List<BookingPassenger> p02, List<BookingPassenger> p12) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        Intrinsics.checkNotNullParameter(p12, "p1");
        return ((IEditManager) this.receiver).mergeWithEditingPassengers(p02, p12);
    }
}
