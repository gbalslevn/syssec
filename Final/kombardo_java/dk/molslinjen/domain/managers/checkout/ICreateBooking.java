package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.model.booking.BookingCompleted;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/ICreateBooking;", BuildConfig.FLAVOR, "createBooking", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/model/booking/BookingCompleted;", "screenWidth", BuildConfig.FLAVOR, "screenHeight", "(FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ICreateBooking {
    Object createBooking(float f5, float f6, Continuation<? super ManagerResult<BookingCompleted>> continuation);
}
