package uniffi.molslinjen_shared;

import com.sun.jna.Pointer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;
import uniffi.molslinjen_shared.RustBuffer;
import uniffi.molslinjen_shared.UniffiCleaner;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 52\u00020\u00012\u00020\u00022\u00020\u0003:\u000256B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ-\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0010H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016JU\u0010&\u001a\u00020%2\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u00182\n\u0010\u001a\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020#H\u0096@ø\u0001\u0001¢\u0006\u0004\b&\u0010'R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010(\u001a\u0004\b)\u0010\u0016R\u001a\u0010+\u001a\u00020*8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u00067"}, d2 = {"Luniffi/molslinjen_shared/DepartureLowPriceHandler;", "Luniffi/molslinjen_shared/Disposable;", "Ljava/lang/AutoCloseable;", "Luniffi/molslinjen_shared/DepartureLowPriceHandlerInterface;", "Lcom/sun/jna/Pointer;", "pointer", "<init>", "(Lcom/sun/jna/Pointer;)V", "Luniffi/molslinjen_shared/NoPointer;", "noPointer", "(Luniffi/molslinjen_shared/NoPointer;)V", "()V", BuildConfig.FLAVOR, "destroy", "close", "R", "Lkotlin/Function1;", "block", "callWithPointer$shared_release", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "callWithPointer", "uniffiClonePointer", "()Lcom/sun/jna/Pointer;", "Lorg/threeten/bp/LocalDateTime;", "Luniffi/molslinjen_shared/UtcDateTime;", "pricesFromDate", "pricesToDate", "Luniffi/molslinjen_shared/Currency;", "currencyType", "Luniffi/molslinjen_shared/TransportId;", "transportId", "Luniffi/molslinjen_shared/RegionId;", "departureRegionId", "Luniffi/molslinjen_shared/DepartureRouteId;", "departureRouteId", "Luniffi/molslinjen_shared/SiteId;", "siteId", "Luniffi/molslinjen_shared/DepartureCalendarPrices;", "getLowestPrices", "(Lorg/threeten/bp/LocalDateTime;Lorg/threeten/bp/LocalDateTime;Luniffi/molslinjen_shared/Currency;Luniffi/molslinjen_shared/TransportId;Luniffi/molslinjen_shared/RegionId;Luniffi/molslinjen_shared/DepartureRouteId;Luniffi/molslinjen_shared/SiteId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sun/jna/Pointer;", "getPointer", "Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "cleanable", "Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "getCleanable", "()Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "wasDestroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicLong;", "callCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "Companion", "UniffiCleanAction", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class DepartureLowPriceHandler implements Disposable, AutoCloseable, DepartureLowPriceHandlerInterface {
    private final AtomicLong callCounter;
    private final UniffiCleaner.Cleanable cleanable;
    private final Pointer pointer;
    private final AtomicBoolean wasDestroyed;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Luniffi/molslinjen_shared/DepartureLowPriceHandler$UniffiCleanAction;", "Ljava/lang/Runnable;", "pointer", "Lcom/sun/jna/Pointer;", "(Lcom/sun/jna/Pointer;)V", "run", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
                UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_free_departurelowpricehandler(pointer, uniffiRustCallStatus);
                Unit unit = Unit.INSTANCE;
                Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
            }
        }
    }

    public DepartureLowPriceHandler(Pointer pointer) {
        Intrinsics.checkNotNullParameter(pointer, "pointer");
        this.wasDestroyed = new AtomicBoolean(false);
        this.callCounter = new AtomicLong(1L);
        this.pointer = pointer;
        this.cleanable = UniffiLib.INSTANCE.getCLEANER$shared_release().register(this, new UniffiCleanAction(pointer));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x009f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00aa, code lost:
    
        if (r15.callCounter.decrementAndGet() == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ac, code lost:
    
        r15.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b3, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object getLowestPrices$suspendImpl(DepartureLowPriceHandler departureLowPriceHandler, LocalDateTime localDateTime, LocalDateTime localDateTime2, Currency currency, TransportId transportId, RegionId regionId, DepartureRouteId departureRouteId, SiteId siteId, Continuation<? super DepartureCalendarPrices> continuation) {
        long j5;
        do {
            j5 = departureLowPriceHandler.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(departureLowPriceHandler.getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(departureLowPriceHandler.getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!departureLowPriceHandler.callCounter.compareAndSet(j5, 1 + j5));
        Pointer uniffiClonePointer = departureLowPriceHandler.uniffiClonePointer();
        UniffiLib iNSTANCE$shared_release = UniffiLib.INSTANCE.getINSTANCE$shared_release();
        FfiConverterTypeUtcDateTime ffiConverterTypeUtcDateTime = FfiConverterTypeUtcDateTime.INSTANCE;
        return Molslinjen_sharedKt.uniffiRustCallAsync(iNSTANCE$shared_release.uniffi_molslinjen_shared_fn_method_departurelowpricehandler_get_lowest_prices(uniffiClonePointer, ffiConverterTypeUtcDateTime.lower2(localDateTime).longValue(), ffiConverterTypeUtcDateTime.lower2(localDateTime2).longValue(), FfiConverterTypeCurrency.INSTANCE.lower2((Object) currency), FfiConverterTypeTransportId.INSTANCE.lower2((Object) transportId), FfiConverterTypeRegionId.INSTANCE.lower2((Object) regionId), FfiConverterOptionalTypeDepartureRouteId.INSTANCE.lower2((Object) departureRouteId), FfiConverterTypeSiteId.INSTANCE.lower2((Object) siteId)), new Function3<Long, UniffiRustFutureContinuationCallback, Long, Unit>() { // from class: uniffi.molslinjen_shared.DepartureLowPriceHandler$getLowestPrices$3
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, Long l6) {
                invoke(l5.longValue(), uniffiRustFutureContinuationCallback, l6.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustFutureContinuationCallback callback, long j7) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_poll_rust_buffer(j6, callback, j7);
            }
        }, new Function2<Long, UniffiRustCallStatus, RustBuffer.ByValue>() { // from class: uniffi.molslinjen_shared.DepartureLowPriceHandler$getLowestPrices$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ RustBuffer.ByValue invoke(Long l5, UniffiRustCallStatus uniffiRustCallStatus) {
                return invoke(l5.longValue(), uniffiRustCallStatus);
            }

            public final RustBuffer.ByValue invoke(long j6, UniffiRustCallStatus continuation2) {
                Intrinsics.checkNotNullParameter(continuation2, "continuation");
                return UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_complete_rust_buffer(j6, continuation2);
            }
        }, new Function1<Long, Unit>() { // from class: uniffi.molslinjen_shared.DepartureLowPriceHandler$getLowestPrices$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                invoke(l5.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6) {
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_free_rust_buffer(j6);
            }
        }, new Function1<RustBuffer.ByValue, DepartureCalendarPrices>() { // from class: uniffi.molslinjen_shared.DepartureLowPriceHandler$getLowestPrices$6
            @Override // kotlin.jvm.functions.Function1
            public final DepartureCalendarPrices invoke(RustBuffer.ByValue it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return (DepartureCalendarPrices) FfiConverterTypeDepartureCalendarPrices.INSTANCE.lift2(it);
            }
        }, DepartureLowPriceException.INSTANCE, continuation);
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

    @Override // uniffi.molslinjen_shared.DepartureLowPriceHandlerInterface
    public Object getLowestPrices(LocalDateTime localDateTime, LocalDateTime localDateTime2, Currency currency, TransportId transportId, RegionId regionId, DepartureRouteId departureRouteId, SiteId siteId, Continuation<? super DepartureCalendarPrices> continuation) {
        return getLowestPrices$suspendImpl(this, localDateTime, localDateTime2, currency, transportId, regionId, departureRouteId, siteId, continuation);
    }

    protected final Pointer getPointer() {
        return this.pointer;
    }

    public final Pointer uniffiClonePointer() {
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        UniffiLib iNSTANCE$shared_release = UniffiLib.INSTANCE.getINSTANCE$shared_release();
        Pointer pointer = this.pointer;
        Intrinsics.checkNotNull(pointer);
        Pointer uniffi_molslinjen_shared_fn_clone_departurelowpricehandler = iNSTANCE$shared_release.uniffi_molslinjen_shared_fn_clone_departurelowpricehandler(pointer, uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return uniffi_molslinjen_shared_fn_clone_departurelowpricehandler;
    }

    public DepartureLowPriceHandler(NoPointer noPointer) {
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
    public DepartureLowPriceHandler() {
        this(r2);
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        Pointer uniffi_molslinjen_shared_fn_constructor_departurelowpricehandler_new = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_constructor_departurelowpricehandler_new(uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
    }
}
