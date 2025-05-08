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
import uniffi.molslinjen_shared.RustBuffer;
import uniffi.molslinjen_shared.UniffiCleaner;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 '2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002'(B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ-\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0010H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u001c8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2 = {"Luniffi/molslinjen_shared/ApiAuthenticationBridgeImpl;", "Luniffi/molslinjen_shared/Disposable;", "Ljava/lang/AutoCloseable;", "Luniffi/molslinjen_shared/ApiAuthenticationBridge;", "Lcom/sun/jna/Pointer;", "pointer", "<init>", "(Lcom/sun/jna/Pointer;)V", "Luniffi/molslinjen_shared/NoPointer;", "noPointer", "(Luniffi/molslinjen_shared/NoPointer;)V", BuildConfig.FLAVOR, "destroy", "()V", "close", "R", "Lkotlin/Function1;", "block", "callWithPointer$shared_release", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "callWithPointer", "uniffiClonePointer", "()Lcom/sun/jna/Pointer;", "Luniffi/molslinjen_shared/BasicAuth;", "currentAgillicAuthentication", "()Luniffi/molslinjen_shared/BasicAuth;", "Lcom/sun/jna/Pointer;", "getPointer", "Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "cleanable", "Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "getCleanable", "()Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "wasDestroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicLong;", "callCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "Companion", "UniffiCleanAction", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ApiAuthenticationBridgeImpl implements Disposable, AutoCloseable, ApiAuthenticationBridge {
    private final AtomicLong callCounter;
    private final UniffiCleaner.Cleanable cleanable;
    private final Pointer pointer;
    private final AtomicBoolean wasDestroyed;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Luniffi/molslinjen_shared/ApiAuthenticationBridgeImpl$UniffiCleanAction;", "Ljava/lang/Runnable;", "pointer", "Lcom/sun/jna/Pointer;", "(Lcom/sun/jna/Pointer;)V", "run", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
                UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_free_apiauthenticationbridge(pointer, uniffiRustCallStatus);
                Unit unit = Unit.INSTANCE;
                Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
            }
        }
    }

    public ApiAuthenticationBridgeImpl(Pointer pointer) {
        Intrinsics.checkNotNullParameter(pointer, "pointer");
        this.wasDestroyed = new AtomicBoolean(false);
        this.callCounter = new AtomicLong(1L);
        this.pointer = pointer;
        this.cleanable = UniffiLib.INSTANCE.getCLEANER$shared_release().register(this, new UniffiCleanAction(pointer));
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
    @Override // uniffi.molslinjen_shared.ApiAuthenticationBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BasicAuth currentAgillicAuthentication() {
        long j5;
        FfiConverterTypeBasicAuth ffiConverterTypeBasicAuth = FfiConverterTypeBasicAuth.INSTANCE;
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
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_apiauthenticationbridge_current_agillic_authentication = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_apiauthenticationbridge_current_agillic_authentication(uniffiClonePointer, uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return (BasicAuth) ffiConverterTypeBasicAuth.lift2(uniffi_molslinjen_shared_fn_method_apiauthenticationbridge_current_agillic_authentication);
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

    protected final Pointer getPointer() {
        return this.pointer;
    }

    public final Pointer uniffiClonePointer() {
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        UniffiLib iNSTANCE$shared_release = UniffiLib.INSTANCE.getINSTANCE$shared_release();
        Pointer pointer = this.pointer;
        Intrinsics.checkNotNull(pointer);
        Pointer uniffi_molslinjen_shared_fn_clone_apiauthenticationbridge = iNSTANCE$shared_release.uniffi_molslinjen_shared_fn_clone_apiauthenticationbridge(pointer, uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return uniffi_molslinjen_shared_fn_clone_apiauthenticationbridge;
    }

    public ApiAuthenticationBridgeImpl(NoPointer noPointer) {
        Intrinsics.checkNotNullParameter(noPointer, "noPointer");
        this.wasDestroyed = new AtomicBoolean(false);
        this.callCounter = new AtomicLong(1L);
        this.pointer = null;
        this.cleanable = UniffiLib.INSTANCE.getCLEANER$shared_release().register(this, new UniffiCleanAction(null));
    }
}
