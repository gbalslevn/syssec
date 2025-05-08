package uniffi.molslinjen_shared;

import com.sun.jna.Pointer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.AmountException;
import uniffi.molslinjen_shared.RustBuffer;
import uniffi.molslinjen_shared.UniffiCleaner;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 :2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002:;B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J-\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0013H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001aH\u0016¢\u0006\u0004\b!\u0010\"J\u0011\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b&\u0010 J\u000f\u0010'\u001a\u00020\u001aH\u0016¢\u0006\u0004\b'\u0010\"J\u0017\u0010)\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u001aH\u0016¢\u0006\u0004\b)\u0010\u001dJ\u000f\u0010*\u001a\u00020\u000bH\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u000bH\u0016¢\u0006\u0004\b,\u0010+R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010\u0019R\u001a\u00100\u001a\u00020/8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006<"}, d2 = {"Luniffi/molslinjen_shared/AmountWrapper;", "Luniffi/molslinjen_shared/Disposable;", "Ljava/lang/AutoCloseable;", "Luniffi/molslinjen_shared/AmountWrapperInterface;", "Lcom/sun/jna/Pointer;", "pointer", "<init>", "(Lcom/sun/jna/Pointer;)V", "Luniffi/molslinjen_shared/NoPointer;", "noPointer", "(Luniffi/molslinjen_shared/NoPointer;)V", "Luniffi/molslinjen_shared/Amount;", "defaultAmount", "(Luniffi/molslinjen_shared/Amount;)V", BuildConfig.FLAVOR, "destroy", "()V", "close", "R", "Lkotlin/Function1;", "block", "callWithPointer$shared_release", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "callWithPointer", "uniffiClonePointer", "()Lcom/sun/jna/Pointer;", BuildConfig.FLAVOR, "count", "addCharge", "(J)Luniffi/molslinjen_shared/Amount;", "other", "adding", "(Luniffi/molslinjen_shared/Amount;)Luniffi/molslinjen_shared/Amount;", "chargeCount", "()J", "Luniffi/molslinjen_shared/Currency;", "currency", "()Luniffi/molslinjen_shared/Currency;", "ensureAbove", "monetaryAmount", "multiplier", "multipliedBy", "negation", "()Luniffi/molslinjen_shared/Amount;", "removeCharges", "Lcom/sun/jna/Pointer;", "getPointer", "Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "cleanable", "Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "getCleanable", "()Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "wasDestroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicLong;", "callCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "Companion", "UniffiCleanAction", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class AmountWrapper implements Disposable, AutoCloseable, AmountWrapperInterface {
    private final AtomicLong callCounter;
    private final UniffiCleaner.Cleanable cleanable;
    private final Pointer pointer;
    private final AtomicBoolean wasDestroyed;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Luniffi/molslinjen_shared/AmountWrapper$UniffiCleanAction;", "Ljava/lang/Runnable;", "pointer", "Lcom/sun/jna/Pointer;", "(Lcom/sun/jna/Pointer;)V", "run", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
                UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_free_amountwrapper(pointer, uniffiRustCallStatus);
                Unit unit = Unit.INSTANCE;
                Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
            }
        }
    }

    public AmountWrapper(Pointer pointer) {
        Intrinsics.checkNotNullParameter(pointer, "pointer");
        this.wasDestroyed = new AtomicBoolean(false);
        this.callCounter = new AtomicLong(1L);
        this.pointer = pointer;
        this.cleanable = UniffiLib.INSTANCE.getCLEANER$shared_release().register(this, new UniffiCleanAction(pointer));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0062, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
    
        if (r8.callCounter.decrementAndGet() == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:
    
        r8.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0076, code lost:
    
        throw r9;
     */
    @Override // uniffi.molslinjen_shared.AmountWrapperInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Amount addCharge(long count) {
        long j5;
        FfiConverterTypeAmount ffiConverterTypeAmount = FfiConverterTypeAmount.INSTANCE;
        do {
            j5 = this.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!this.callCounter.compareAndSet(j5, 1 + j5));
        Pointer uniffiClonePointer = uniffiClonePointer();
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_amountwrapper_add_charge = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_amountwrapper_add_charge(uniffiClonePointer, FfiConverterLong.INSTANCE.lower(count).longValue(), uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return (Amount) ffiConverterTypeAmount.lift2(uniffi_molslinjen_shared_fn_method_amountwrapper_add_charge);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006e, code lost:
    
        if (r8.callCounter.decrementAndGet() == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
    
        r8.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
    
        throw r9;
     */
    @Override // uniffi.molslinjen_shared.AmountWrapperInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Amount adding(Amount other) {
        long j5;
        Intrinsics.checkNotNullParameter(other, "other");
        FfiConverterTypeAmount ffiConverterTypeAmount = FfiConverterTypeAmount.INSTANCE;
        do {
            j5 = this.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!this.callCounter.compareAndSet(j5, 1 + j5));
        Pointer uniffiClonePointer = uniffiClonePointer();
        AmountException.Companion companion = AmountException.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_amountwrapper_adding = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_amountwrapper_adding(uniffiClonePointer, FfiConverterTypeAmount.INSTANCE.lower2((Object) other), uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(companion, uniffiRustCallStatus);
        return (Amount) ffiConverterTypeAmount.lift2(uniffi_molslinjen_shared_fn_method_amountwrapper_adding);
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

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0065, code lost:
    
        if (r8.callCounter.decrementAndGet() == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
    
        r8.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006e, code lost:
    
        throw r0;
     */
    @Override // uniffi.molslinjen_shared.AmountWrapperInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long chargeCount() {
        long j5;
        FfiConverterLong ffiConverterLong = FfiConverterLong.INSTANCE;
        do {
            j5 = this.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!this.callCounter.compareAndSet(j5, 1 + j5));
        Pointer uniffiClonePointer = uniffiClonePointer();
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        long uniffi_molslinjen_shared_fn_method_amountwrapper_charge_count = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_amountwrapper_charge_count(uniffiClonePointer, uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return ffiConverterLong.lift(uniffi_molslinjen_shared_fn_method_amountwrapper_charge_count).longValue();
    }

    @Override // java.lang.AutoCloseable
    public synchronized void close() {
        destroy();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
    
        if (r8.callCounter.decrementAndGet() == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0065, code lost:
    
        r8.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
    
        throw r0;
     */
    @Override // uniffi.molslinjen_shared.AmountWrapperInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Currency currency() {
        long j5;
        FfiConverterOptionalTypeCurrency ffiConverterOptionalTypeCurrency = FfiConverterOptionalTypeCurrency.INSTANCE;
        do {
            j5 = this.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!this.callCounter.compareAndSet(j5, 1 + j5));
        Pointer uniffiClonePointer = uniffiClonePointer();
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_amountwrapper_currency = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_amountwrapper_currency(uniffiClonePointer, uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return (Currency) ffiConverterOptionalTypeCurrency.lift2(uniffi_molslinjen_shared_fn_method_amountwrapper_currency);
    }

    @Override // uniffi.molslinjen_shared.Disposable
    public void destroy() {
        if (this.wasDestroyed.compareAndSet(false, true) && this.callCounter.decrementAndGet() == 0) {
            this.cleanable.clean();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006e, code lost:
    
        if (r8.callCounter.decrementAndGet() == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
    
        r8.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
    
        throw r9;
     */
    @Override // uniffi.molslinjen_shared.AmountWrapperInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Amount ensureAbove(Amount other) {
        long j5;
        Intrinsics.checkNotNullParameter(other, "other");
        FfiConverterTypeAmount ffiConverterTypeAmount = FfiConverterTypeAmount.INSTANCE;
        do {
            j5 = this.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!this.callCounter.compareAndSet(j5, 1 + j5));
        Pointer uniffiClonePointer = uniffiClonePointer();
        AmountException.Companion companion = AmountException.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_amountwrapper_ensure_above = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_amountwrapper_ensure_above(uniffiClonePointer, FfiConverterTypeAmount.INSTANCE.lower2((Object) other), uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(companion, uniffiRustCallStatus);
        return (Amount) ffiConverterTypeAmount.lift2(uniffi_molslinjen_shared_fn_method_amountwrapper_ensure_above);
    }

    protected final UniffiCleaner.Cleanable getCleanable() {
        return this.cleanable;
    }

    protected final Pointer getPointer() {
        return this.pointer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0065, code lost:
    
        if (r8.callCounter.decrementAndGet() == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
    
        r8.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006e, code lost:
    
        throw r0;
     */
    @Override // uniffi.molslinjen_shared.AmountWrapperInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long monetaryAmount() {
        long j5;
        FfiConverterLong ffiConverterLong = FfiConverterLong.INSTANCE;
        do {
            j5 = this.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!this.callCounter.compareAndSet(j5, 1 + j5));
        Pointer uniffiClonePointer = uniffiClonePointer();
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        long uniffi_molslinjen_shared_fn_method_amountwrapper_monetary_amount = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_amountwrapper_monetary_amount(uniffiClonePointer, uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return ffiConverterLong.lift(uniffi_molslinjen_shared_fn_method_amountwrapper_monetary_amount).longValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0062, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
    
        if (r8.callCounter.decrementAndGet() == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:
    
        r8.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0076, code lost:
    
        throw r9;
     */
    @Override // uniffi.molslinjen_shared.AmountWrapperInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Amount multipliedBy(long multiplier) {
        long j5;
        FfiConverterTypeAmount ffiConverterTypeAmount = FfiConverterTypeAmount.INSTANCE;
        do {
            j5 = this.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!this.callCounter.compareAndSet(j5, 1 + j5));
        Pointer uniffiClonePointer = uniffiClonePointer();
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_amountwrapper_multiplied_by = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_amountwrapper_multiplied_by(uniffiClonePointer, FfiConverterLong.INSTANCE.lower(multiplier).longValue(), uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return (Amount) ffiConverterTypeAmount.lift2(uniffi_molslinjen_shared_fn_method_amountwrapper_multiplied_by);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
    
        if (r8.callCounter.decrementAndGet() == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0065, code lost:
    
        r8.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
    
        throw r0;
     */
    @Override // uniffi.molslinjen_shared.AmountWrapperInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Amount negation() {
        long j5;
        FfiConverterTypeAmount ffiConverterTypeAmount = FfiConverterTypeAmount.INSTANCE;
        do {
            j5 = this.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!this.callCounter.compareAndSet(j5, 1 + j5));
        Pointer uniffiClonePointer = uniffiClonePointer();
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_amountwrapper_negation = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_amountwrapper_negation(uniffiClonePointer, uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return (Amount) ffiConverterTypeAmount.lift2(uniffi_molslinjen_shared_fn_method_amountwrapper_negation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
    
        if (r8.callCounter.decrementAndGet() == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0065, code lost:
    
        r8.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
    
        throw r0;
     */
    @Override // uniffi.molslinjen_shared.AmountWrapperInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Amount removeCharges() {
        long j5;
        FfiConverterTypeAmount ffiConverterTypeAmount = FfiConverterTypeAmount.INSTANCE;
        do {
            j5 = this.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!this.callCounter.compareAndSet(j5, 1 + j5));
        Pointer uniffiClonePointer = uniffiClonePointer();
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_amountwrapper_remove_charges = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_amountwrapper_remove_charges(uniffiClonePointer, uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return (Amount) ffiConverterTypeAmount.lift2(uniffi_molslinjen_shared_fn_method_amountwrapper_remove_charges);
    }

    public final Pointer uniffiClonePointer() {
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        UniffiLib iNSTANCE$shared_release = UniffiLib.INSTANCE.getINSTANCE$shared_release();
        Pointer pointer = this.pointer;
        Intrinsics.checkNotNull(pointer);
        Pointer uniffi_molslinjen_shared_fn_clone_amountwrapper = iNSTANCE$shared_release.uniffi_molslinjen_shared_fn_clone_amountwrapper(pointer, uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return uniffi_molslinjen_shared_fn_clone_amountwrapper;
    }

    public AmountWrapper(NoPointer noPointer) {
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
    public AmountWrapper(Amount defaultAmount) {
        this(r5);
        Intrinsics.checkNotNullParameter(defaultAmount, "defaultAmount");
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        Pointer uniffi_molslinjen_shared_fn_constructor_amountwrapper_new = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_constructor_amountwrapper_new(FfiConverterTypeAmount.INSTANCE.lower2((Object) defaultAmount), uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
    }
}
