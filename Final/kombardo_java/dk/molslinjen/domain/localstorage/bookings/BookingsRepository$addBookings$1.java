package dk.molslinjen.domain.localstorage.bookings;

import androidx.appcompat.R$styleable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.localstorage.bookings.BookingsRepository", f = "BookingsRepository.kt", l = {R$styleable.Toolbar_titleMarginEnd, R$styleable.Toolbar_titleMarginBottom}, m = "addBookings")
/* loaded from: classes2.dex */
public final class BookingsRepository$addBookings$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BookingsRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookingsRepository$addBookings$1(BookingsRepository bookingsRepository, Continuation<? super BookingsRepository$addBookings$1> continuation) {
        super(continuation);
        this.this$0 = bookingsRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addBookings(null, this);
    }
}
