package dk.molslinjen.domain.localstorage.bookings;

import android.content.Context;
import dk.molslinjen.domain.localstorage.base.FileCollectionRepository;
import dk.molslinjen.domain.model.booking.BookingHeader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0096@¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0096@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0096@¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/domain/localstorage/bookings/BookingsRepository;", "Ldk/molslinjen/domain/localstorage/bookings/IBookingsRepository;", "Ldk/molslinjen/domain/localstorage/base/FileCollectionRepository;", "Ldk/molslinjen/domain/model/booking/BookingHeader;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getBookings", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAll", BuildConfig.FLAVOR, "bookings", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addBookings", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BookingsRepository extends FileCollectionRepository<BookingHeader> implements IBookingsRepository {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookingsRepository(Context appContext) {
        super(appContext, "bookings_v2.json", BookingHeader.INSTANCE.serializer());
        Intrinsics.checkNotNullParameter(appContext, "appContext");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.localstorage.bookings.IBookingsRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object addBookings(List<BookingHeader> list, Continuation<? super Unit> continuation) {
        BookingsRepository$addBookings$1 bookingsRepository$addBookings$1;
        Object coroutine_suspended;
        int i5;
        List<BookingHeader> list2;
        BookingsRepository bookingsRepository;
        ArrayList arrayList;
        if (continuation instanceof BookingsRepository$addBookings$1) {
            bookingsRepository$addBookings$1 = (BookingsRepository$addBookings$1) continuation;
            int i6 = bookingsRepository$addBookings$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                bookingsRepository$addBookings$1.label = i6 - Integer.MIN_VALUE;
                Object obj = bookingsRepository$addBookings$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = bookingsRepository$addBookings$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    bookingsRepository$addBookings$1.L$0 = list;
                    bookingsRepository$addBookings$1.L$1 = this;
                    bookingsRepository$addBookings$1.label = 1;
                    obj = getBookings(bookingsRepository$addBookings$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list2 = list;
                    bookingsRepository = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    bookingsRepository = (BookingsRepository) bookingsRepository$addBookings$1.L$1;
                    list2 = (List) bookingsRepository$addBookings$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                List plus = CollectionsKt.plus((Collection) obj, (Iterable) list2);
                HashSet hashSet = new HashSet();
                arrayList = new ArrayList();
                for (Object obj2 : plus) {
                    if (hashSet.add(((BookingHeader) obj2).getReservationId())) {
                        arrayList.add(obj2);
                    }
                }
                bookingsRepository$addBookings$1.L$0 = null;
                bookingsRepository$addBookings$1.L$1 = null;
                bookingsRepository$addBookings$1.label = 2;
                if (bookingsRepository.save(arrayList, bookingsRepository$addBookings$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        bookingsRepository$addBookings$1 = new BookingsRepository$addBookings$1(this, continuation);
        Object obj3 = bookingsRepository$addBookings$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = bookingsRepository$addBookings$1.label;
        if (i5 != 0) {
        }
        List plus2 = CollectionsKt.plus((Collection) obj3, (Iterable) list2);
        HashSet hashSet2 = new HashSet();
        arrayList = new ArrayList();
        while (r9.hasNext()) {
        }
        bookingsRepository$addBookings$1.L$0 = null;
        bookingsRepository$addBookings$1.L$1 = null;
        bookingsRepository$addBookings$1.label = 2;
        if (bookingsRepository.save(arrayList, bookingsRepository$addBookings$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.localstorage.bookings.IBookingsRepository
    public Object getBookings(Continuation<? super List<BookingHeader>> continuation) {
        return get(continuation);
    }

    @Override // dk.molslinjen.domain.localstorage.bookings.IBookingsRepository
    public Object saveAll(List<BookingHeader> list, Continuation<? super Unit> continuation) {
        Object save = save(list, continuation);
        return save == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? save : Unit.INSTANCE;
    }
}
