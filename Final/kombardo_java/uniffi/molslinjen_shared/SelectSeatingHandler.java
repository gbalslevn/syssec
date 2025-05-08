package uniffi.molslinjen_shared;

import com.sun.jna.Pointer;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.RustBuffer;
import uniffi.molslinjen_shared.UniffiCleaner;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 92\u00020\u00012\u00020\u00022\u00020\u0003:\u00029:B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ-\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0010H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010!\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0096@ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J)\u0010%\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0096@ø\u0001\u0001¢\u0006\u0004\b%\u0010&J\u001b\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00020$H\u0096@ø\u0001\u0001¢\u0006\u0004\b(\u0010)J)\u0010*\u001a\u00020\f2\u0006\u0010'\u001a\u00020$2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0096@ø\u0001\u0001¢\u0006\u0004\b*\u0010+R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b-\u0010\u0016R\u001a\u0010/\u001a\u00020.8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006;"}, d2 = {"Luniffi/molslinjen_shared/SelectSeatingHandler;", "Luniffi/molslinjen_shared/Disposable;", "Ljava/lang/AutoCloseable;", "Luniffi/molslinjen_shared/SelectSeatingHandlerInterface;", "Lcom/sun/jna/Pointer;", "pointer", "<init>", "(Lcom/sun/jna/Pointer;)V", "Luniffi/molslinjen_shared/NoPointer;", "noPointer", "(Luniffi/molslinjen_shared/NoPointer;)V", "()V", BuildConfig.FLAVOR, "destroy", "close", "R", "Lkotlin/Function1;", "block", "callWithPointer$shared_release", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "callWithPointer", "uniffiClonePointer", "()Lcom/sun/jna/Pointer;", "Luniffi/molslinjen_shared/DepartureId;", "departureId", BuildConfig.FLAVOR, "ferryName", "Luniffi/molslinjen_shared/Currency;", "currency", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatId;", "reservedSeats", "Luniffi/molslinjen_shared/FerryFloorPlan;", "getFloorPlan", "(Luniffi/molslinjen_shared/DepartureId;Ljava/lang/String;Luniffi/molslinjen_shared/Currency;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seatIds", "Luniffi/molslinjen_shared/SeatReservationId;", "reserveSeats", "(Luniffi/molslinjen_shared/DepartureId;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seatReservationId", "unReserveSeats", "(Luniffi/molslinjen_shared/SeatReservationId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateReservedSeats", "(Luniffi/molslinjen_shared/SeatReservationId;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sun/jna/Pointer;", "getPointer", "Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "cleanable", "Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "getCleanable", "()Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "wasDestroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicLong;", "callCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "Companion", "UniffiCleanAction", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class SelectSeatingHandler implements Disposable, AutoCloseable, SelectSeatingHandlerInterface {
    private final AtomicLong callCounter;
    private final UniffiCleaner.Cleanable cleanable;
    private final Pointer pointer;
    private final AtomicBoolean wasDestroyed;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Luniffi/molslinjen_shared/SelectSeatingHandler$UniffiCleanAction;", "Ljava/lang/Runnable;", "pointer", "Lcom/sun/jna/Pointer;", "(Lcom/sun/jna/Pointer;)V", "run", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class UniffiCleanAction implements Runnable {
        private final Pointer pointer;

        public UniffiCleanAction(Pointer pointer) {
            this.pointer = pointer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Pointer pointer = this.pointer;
            if (pointer != null) {
                UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
                UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
                UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_free_selectseatinghandler(pointer, uniffiRustCallStatus);
                Unit unit = Unit.INSTANCE;
                Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
            }
        }
    }

    public SelectSeatingHandler(Pointer pointer) {
        Intrinsics.checkNotNullParameter(pointer, "pointer");
        this.wasDestroyed = new AtomicBoolean(false);
        this.callCounter = new AtomicLong(1L);
        this.pointer = pointer;
        this.cleanable = UniffiLib.INSTANCE.getCLEANER$shared_release().register(this, new UniffiCleanAction(pointer));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0076, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0081, code lost:
    
        if (r18.callCounter.decrementAndGet() == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0083, code lost:
    
        r18.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008a, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object getFloorPlan$suspendImpl(SelectSeatingHandler selectSeatingHandler, DepartureId departureId, String str, Currency currency, List<FerrySeatId> list, Continuation<? super FerryFloorPlan> continuation) {
        long j5;
        do {
            j5 = selectSeatingHandler.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(selectSeatingHandler.getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(selectSeatingHandler.getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!selectSeatingHandler.callCounter.compareAndSet(j5, 1 + j5));
        return Molslinjen_sharedKt.uniffiRustCallAsync(UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_selectseatinghandler_get_floor_plan(selectSeatingHandler.uniffiClonePointer(), FfiConverterTypeDepartureId.INSTANCE.lower2((Object) departureId), FfiConverterString.INSTANCE.lower2(str), FfiConverterTypeCurrency.INSTANCE.lower2((Object) currency), FfiConverterSequenceTypeFerrySeatId.INSTANCE.lower2((Object) list)), new Function3<Long, UniffiRustFutureContinuationCallback, Long, Unit>() { // from class: uniffi.molslinjen_shared.SelectSeatingHandler$getFloorPlan$3
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, Long l6) {
                invoke(l5.longValue(), uniffiRustFutureContinuationCallback, l6.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustFutureContinuationCallback callback, long j7) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_poll_rust_buffer(j6, callback, j7);
            }
        }, new Function2<Long, UniffiRustCallStatus, RustBuffer.ByValue>() { // from class: uniffi.molslinjen_shared.SelectSeatingHandler$getFloorPlan$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ RustBuffer.ByValue invoke(Long l5, UniffiRustCallStatus uniffiRustCallStatus) {
                return invoke(l5.longValue(), uniffiRustCallStatus);
            }

            public final RustBuffer.ByValue invoke(long j6, UniffiRustCallStatus continuation2) {
                Intrinsics.checkNotNullParameter(continuation2, "continuation");
                return UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_complete_rust_buffer(j6, continuation2);
            }
        }, new Function1<Long, Unit>() { // from class: uniffi.molslinjen_shared.SelectSeatingHandler$getFloorPlan$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                invoke(l5.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6) {
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_free_rust_buffer(j6);
            }
        }, new Function1<RustBuffer.ByValue, FerryFloorPlan>() { // from class: uniffi.molslinjen_shared.SelectSeatingHandler$getFloorPlan$6
            @Override // kotlin.jvm.functions.Function1
            public final FerryFloorPlan invoke(RustBuffer.ByValue it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return (FerryFloorPlan) FfiConverterTypeFerryFloorPlan.INSTANCE.lift2(it);
            }
        }, SelectSeatingHandlerException.INSTANCE, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
    
        if (r12.callCounter.decrementAndGet() == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006e, code lost:
    
        r12.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0075, code lost:
    
        throw r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object reserveSeats$suspendImpl(SelectSeatingHandler selectSeatingHandler, DepartureId departureId, List<FerrySeatId> list, Continuation<? super SeatReservationId> continuation) {
        long j5;
        do {
            j5 = selectSeatingHandler.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(selectSeatingHandler.getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(selectSeatingHandler.getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!selectSeatingHandler.callCounter.compareAndSet(j5, 1 + j5));
        return Molslinjen_sharedKt.uniffiRustCallAsync(UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_selectseatinghandler_reserve_seats(selectSeatingHandler.uniffiClonePointer(), FfiConverterTypeDepartureId.INSTANCE.lower2((Object) departureId), FfiConverterSequenceTypeFerrySeatId.INSTANCE.lower2((Object) list)), new Function3<Long, UniffiRustFutureContinuationCallback, Long, Unit>() { // from class: uniffi.molslinjen_shared.SelectSeatingHandler$reserveSeats$3
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, Long l6) {
                invoke(l5.longValue(), uniffiRustFutureContinuationCallback, l6.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustFutureContinuationCallback callback, long j7) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_poll_rust_buffer(j6, callback, j7);
            }
        }, new Function2<Long, UniffiRustCallStatus, RustBuffer.ByValue>() { // from class: uniffi.molslinjen_shared.SelectSeatingHandler$reserveSeats$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ RustBuffer.ByValue invoke(Long l5, UniffiRustCallStatus uniffiRustCallStatus) {
                return invoke(l5.longValue(), uniffiRustCallStatus);
            }

            public final RustBuffer.ByValue invoke(long j6, UniffiRustCallStatus continuation2) {
                Intrinsics.checkNotNullParameter(continuation2, "continuation");
                return UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_complete_rust_buffer(j6, continuation2);
            }
        }, new Function1<Long, Unit>() { // from class: uniffi.molslinjen_shared.SelectSeatingHandler$reserveSeats$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                invoke(l5.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6) {
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_free_rust_buffer(j6);
            }
        }, new Function1<RustBuffer.ByValue, SeatReservationId>() { // from class: uniffi.molslinjen_shared.SelectSeatingHandler$reserveSeats$6
            @Override // kotlin.jvm.functions.Function1
            public final SeatReservationId invoke(RustBuffer.ByValue it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return (SeatReservationId) FfiConverterTypeSeatReservationId.INSTANCE.lift2(it);
            }
        }, SelectSeatingHandlerException.INSTANCE, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        if (r12.callCounter.decrementAndGet() == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0071, code lost:
    
        r12.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
    
        throw r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object unReserveSeats$suspendImpl(SelectSeatingHandler selectSeatingHandler, SeatReservationId seatReservationId, Continuation<? super Unit> continuation) {
        long j5;
        do {
            j5 = selectSeatingHandler.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(selectSeatingHandler.getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(selectSeatingHandler.getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!selectSeatingHandler.callCounter.compareAndSet(j5, 1 + j5));
        Object uniffiRustCallAsync = Molslinjen_sharedKt.uniffiRustCallAsync(UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_selectseatinghandler_un_reserve_seats(selectSeatingHandler.uniffiClonePointer(), FfiConverterTypeSeatReservationId.INSTANCE.lower2((Object) seatReservationId)), new Function3<Long, UniffiRustFutureContinuationCallback, Long, Unit>() { // from class: uniffi.molslinjen_shared.SelectSeatingHandler$unReserveSeats$3
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, Long l6) {
                invoke(l5.longValue(), uniffiRustFutureContinuationCallback, l6.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustFutureContinuationCallback callback, long j7) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_poll_void(j6, callback, j7);
            }
        }, new Function2<Long, UniffiRustCallStatus, Unit>() { // from class: uniffi.molslinjen_shared.SelectSeatingHandler$unReserveSeats$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustCallStatus uniffiRustCallStatus) {
                invoke(l5.longValue(), uniffiRustCallStatus);
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustCallStatus continuation2) {
                Intrinsics.checkNotNullParameter(continuation2, "continuation");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_complete_void(j6, continuation2);
            }
        }, new Function1<Long, Unit>() { // from class: uniffi.molslinjen_shared.SelectSeatingHandler$unReserveSeats$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                invoke(l5.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6) {
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_free_void(j6);
            }
        }, new Function1<Unit, Unit>() { // from class: uniffi.molslinjen_shared.SelectSeatingHandler$unReserveSeats$6
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, SelectSeatingHandlerException.INSTANCE, continuation);
        return uniffiRustCallAsync == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? uniffiRustCallAsync : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006a, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0075, code lost:
    
        if (r12.callCounter.decrementAndGet() == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0077, code lost:
    
        r12.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
    
        throw r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object updateReservedSeats$suspendImpl(SelectSeatingHandler selectSeatingHandler, SeatReservationId seatReservationId, List<FerrySeatId> list, Continuation<? super Unit> continuation) {
        long j5;
        do {
            j5 = selectSeatingHandler.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(selectSeatingHandler.getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(selectSeatingHandler.getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!selectSeatingHandler.callCounter.compareAndSet(j5, 1 + j5));
        Object uniffiRustCallAsync = Molslinjen_sharedKt.uniffiRustCallAsync(UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_selectseatinghandler_update_reserved_seats(selectSeatingHandler.uniffiClonePointer(), FfiConverterTypeSeatReservationId.INSTANCE.lower2((Object) seatReservationId), FfiConverterSequenceTypeFerrySeatId.INSTANCE.lower2((Object) list)), new Function3<Long, UniffiRustFutureContinuationCallback, Long, Unit>() { // from class: uniffi.molslinjen_shared.SelectSeatingHandler$updateReservedSeats$3
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, Long l6) {
                invoke(l5.longValue(), uniffiRustFutureContinuationCallback, l6.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustFutureContinuationCallback callback, long j7) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_poll_void(j6, callback, j7);
            }
        }, new Function2<Long, UniffiRustCallStatus, Unit>() { // from class: uniffi.molslinjen_shared.SelectSeatingHandler$updateReservedSeats$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustCallStatus uniffiRustCallStatus) {
                invoke(l5.longValue(), uniffiRustCallStatus);
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustCallStatus continuation2) {
                Intrinsics.checkNotNullParameter(continuation2, "continuation");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_complete_void(j6, continuation2);
            }
        }, new Function1<Long, Unit>() { // from class: uniffi.molslinjen_shared.SelectSeatingHandler$updateReservedSeats$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                invoke(l5.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6) {
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_free_void(j6);
            }
        }, new Function1<Unit, Unit>() { // from class: uniffi.molslinjen_shared.SelectSeatingHandler$updateReservedSeats$6
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, SelectSeatingHandlerException.INSTANCE, continuation);
        return uniffiRustCallAsync == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? uniffiRustCallAsync : Unit.INSTANCE;
    }

    public final <R> R callWithPointer$shared_release(Function1<? super Pointer, ? extends R> block) {
        long j5;
        Intrinsics.checkNotNullParameter(block, "block");
        do {
            j5 = this.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!this.callCounter.compareAndSet(j5, 1 + j5));
        try {
            return block.invoke(uniffiClonePointer());
        } finally {
            InlineMarker.finallyStart(1);
            if (this.callCounter.decrementAndGet() == 0) {
                this.cleanable.clean();
            }
            InlineMarker.finallyEnd(1);
        }
    }

    @Override // java.lang.AutoCloseable
    public synchronized void close() {
        destroy();
    }

    @Override // uniffi.molslinjen_shared.Disposable
    public void destroy() {
        if (this.wasDestroyed.compareAndSet(false, true) && this.callCounter.decrementAndGet() == 0) {
            this.cleanable.clean();
        }
    }

    protected final UniffiCleaner.Cleanable getCleanable() {
        return this.cleanable;
    }

    @Override // uniffi.molslinjen_shared.SelectSeatingHandlerInterface
    public Object getFloorPlan(DepartureId departureId, String str, Currency currency, List<FerrySeatId> list, Continuation<? super FerryFloorPlan> continuation) {
        return getFloorPlan$suspendImpl(this, departureId, str, currency, list, continuation);
    }

    protected final Pointer getPointer() {
        return this.pointer;
    }

    @Override // uniffi.molslinjen_shared.SelectSeatingHandlerInterface
    public Object reserveSeats(DepartureId departureId, List<FerrySeatId> list, Continuation<? super SeatReservationId> continuation) {
        return reserveSeats$suspendImpl(this, departureId, list, continuation);
    }

    @Override // uniffi.molslinjen_shared.SelectSeatingHandlerInterface
    public Object unReserveSeats(SeatReservationId seatReservationId, Continuation<? super Unit> continuation) {
        return unReserveSeats$suspendImpl(this, seatReservationId, continuation);
    }

    public final Pointer uniffiClonePointer() {
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        UniffiLib iNSTANCE$shared_release = UniffiLib.INSTANCE.getINSTANCE$shared_release();
        Pointer pointer = this.pointer;
        Intrinsics.checkNotNull(pointer);
        Pointer uniffi_molslinjen_shared_fn_clone_selectseatinghandler = iNSTANCE$shared_release.uniffi_molslinjen_shared_fn_clone_selectseatinghandler(pointer, uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return uniffi_molslinjen_shared_fn_clone_selectseatinghandler;
    }

    @Override // uniffi.molslinjen_shared.SelectSeatingHandlerInterface
    public Object updateReservedSeats(SeatReservationId seatReservationId, List<FerrySeatId> list, Continuation<? super Unit> continuation) {
        return updateReservedSeats$suspendImpl(this, seatReservationId, list, continuation);
    }

    public SelectSeatingHandler(NoPointer noPointer) {
        Intrinsics.checkNotNullParameter(noPointer, "noPointer");
        this.wasDestroyed = new AtomicBoolean(false);
        this.callCounter = new AtomicLong(1L);
        this.pointer = null;
        this.cleanable = UniffiLib.INSTANCE.getCLEANER$shared_release().register(this, new UniffiCleanAction(null));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SelectSeatingHandler() {
        this(r2);
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        Pointer uniffi_molslinjen_shared_fn_constructor_selectseatinghandler_new = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_constructor_selectseatinghandler_new(uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
    }
}
