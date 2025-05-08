package uniffi.molslinjen_shared;

import com.sun.jna.Pointer;
import dk.molslinjen.domain.model.constants.Constants;
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
import org.threeten.bp.LocalDateTime;
import uniffi.molslinjen_shared.UniffiCleaner;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 ?2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002?@B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ-\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0010H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0096@ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J/\u0010$\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\n\u0010#\u001a\u00060!j\u0002`\"H\u0096@ø\u0001\u0001¢\u0006\u0004\b$\u0010%JA\u0010,\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)H\u0096@ø\u0001\u0001¢\u0006\u0004\b,\u0010-J+\u0010.\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020\u0019H\u0096@ø\u0001\u0001¢\u0006\u0004\b.\u0010/J#\u00100\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0096@ø\u0001\u0001¢\u0006\u0004\b0\u00101R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u00102\u001a\u0004\b3\u0010\u0016R\u001a\u00105\u001a\u0002048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006A"}, d2 = {"Luniffi/molslinjen_shared/AgillicHandler;", "Luniffi/molslinjen_shared/Disposable;", "Ljava/lang/AutoCloseable;", "Luniffi/molslinjen_shared/AgillicHandlerInterface;", "Lcom/sun/jna/Pointer;", "pointer", "<init>", "(Lcom/sun/jna/Pointer;)V", "Luniffi/molslinjen_shared/NoPointer;", "noPointer", "(Luniffi/molslinjen_shared/NoPointer;)V", "()V", BuildConfig.FLAVOR, "destroy", "close", "R", "Lkotlin/Function1;", "block", "callWithPointer$shared_release", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "callWithPointer", "uniffiClonePointer", "()Lcom/sun/jna/Pointer;", BuildConfig.FLAVOR, "email", "Luniffi/molslinjen_shared/AgillicClientId;", "clientAppId", "Luniffi/molslinjen_shared/AgillicReportId;", Constants.IntentExtra.ReportId, "Luniffi/molslinjen_shared/FeedbackStatus;", "feedbackStatus", "feedback", "(Ljava/lang/String;Luniffi/molslinjen_shared/AgillicClientId;Luniffi/molslinjen_shared/AgillicReportId;Luniffi/molslinjen_shared/FeedbackStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lorg/threeten/bp/LocalDateTime;", "Luniffi/molslinjen_shared/UtcDateTime;", "validUntil", "giveConsent", "(Ljava/lang/String;Luniffi/molslinjen_shared/AgillicClientId;Lorg/threeten/bp/LocalDateTime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Luniffi/molslinjen_shared/AgillicInstallationId;", "appInstallationId", "pushNotificationToken", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/Consent;", "consent", "register", "(Ljava/lang/String;Luniffi/molslinjen_shared/AgillicInstallationId;Luniffi/molslinjen_shared/AgillicClientId;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregister", "(Ljava/lang/String;Luniffi/molslinjen_shared/AgillicInstallationId;Luniffi/molslinjen_shared/AgillicClientId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withdrawConsent", "(Ljava/lang/String;Luniffi/molslinjen_shared/AgillicClientId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sun/jna/Pointer;", "getPointer", "Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "cleanable", "Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "getCleanable", "()Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "wasDestroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicLong;", "callCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "Companion", "UniffiCleanAction", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class AgillicHandler implements Disposable, AutoCloseable, AgillicHandlerInterface {
    private final AtomicLong callCounter;
    private final UniffiCleaner.Cleanable cleanable;
    private final Pointer pointer;
    private final AtomicBoolean wasDestroyed;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Luniffi/molslinjen_shared/AgillicHandler$UniffiCleanAction;", "Ljava/lang/Runnable;", "pointer", "Lcom/sun/jna/Pointer;", "(Lcom/sun/jna/Pointer;)V", "run", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
                UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_free_agillichandler(pointer, uniffiRustCallStatus);
                Unit unit = Unit.INSTANCE;
                Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
            }
        }
    }

    public AgillicHandler(Pointer pointer) {
        Intrinsics.checkNotNullParameter(pointer, "pointer");
        this.wasDestroyed = new AtomicBoolean(false);
        this.callCounter = new AtomicLong(1L);
        this.pointer = pointer;
        this.cleanable = UniffiLib.INSTANCE.getCLEANER$shared_release().register(this, new UniffiCleanAction(pointer));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x007f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008a, code lost:
    
        if (r18.callCounter.decrementAndGet() == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008c, code lost:
    
        r18.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0093, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object feedback$suspendImpl(AgillicHandler agillicHandler, String str, AgillicClientId agillicClientId, AgillicReportId agillicReportId, FeedbackStatus feedbackStatus, Continuation<? super Unit> continuation) {
        long j5;
        do {
            j5 = agillicHandler.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(agillicHandler.getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(agillicHandler.getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!agillicHandler.callCounter.compareAndSet(j5, 1 + j5));
        Object uniffiRustCallAsync = Molslinjen_sharedKt.uniffiRustCallAsync(UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_agillichandler_feedback(agillicHandler.uniffiClonePointer(), FfiConverterString.INSTANCE.lower2(str), FfiConverterTypeAgillicClientId.INSTANCE.lower2((Object) agillicClientId), FfiConverterTypeAgillicReportId.INSTANCE.lower2((Object) agillicReportId), FfiConverterTypeFeedbackStatus.INSTANCE.lower2((Object) feedbackStatus)), new Function3<Long, UniffiRustFutureContinuationCallback, Long, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$feedback$3
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, Long l6) {
                invoke(l5.longValue(), uniffiRustFutureContinuationCallback, l6.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustFutureContinuationCallback callback, long j7) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_poll_void(j6, callback, j7);
            }
        }, new Function2<Long, UniffiRustCallStatus, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$feedback$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustCallStatus uniffiRustCallStatus) {
                invoke(l5.longValue(), uniffiRustCallStatus);
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustCallStatus continuation2) {
                Intrinsics.checkNotNullParameter(continuation2, "continuation");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_complete_void(j6, continuation2);
            }
        }, new Function1<Long, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$feedback$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                invoke(l5.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6) {
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_free_void(j6);
            }
        }, new Function1<Unit, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$feedback$6
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, AgillicHandlerException.INSTANCE, continuation);
        return uniffiRustCallAsync == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? uniffiRustCallAsync : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x007b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0086, code lost:
    
        if (r18.callCounter.decrementAndGet() == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0088, code lost:
    
        r18.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008f, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object giveConsent$suspendImpl(AgillicHandler agillicHandler, String str, AgillicClientId agillicClientId, LocalDateTime localDateTime, Continuation<? super Unit> continuation) {
        long j5;
        do {
            j5 = agillicHandler.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(agillicHandler.getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(agillicHandler.getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!agillicHandler.callCounter.compareAndSet(j5, 1 + j5));
        Object uniffiRustCallAsync = Molslinjen_sharedKt.uniffiRustCallAsync(UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_agillichandler_give_consent(agillicHandler.uniffiClonePointer(), FfiConverterString.INSTANCE.lower2(str), FfiConverterTypeAgillicClientId.INSTANCE.lower2((Object) agillicClientId), FfiConverterTypeUtcDateTime.INSTANCE.lower2(localDateTime).longValue()), new Function3<Long, UniffiRustFutureContinuationCallback, Long, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$giveConsent$3
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, Long l6) {
                invoke(l5.longValue(), uniffiRustFutureContinuationCallback, l6.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustFutureContinuationCallback callback, long j7) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_poll_void(j6, callback, j7);
            }
        }, new Function2<Long, UniffiRustCallStatus, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$giveConsent$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustCallStatus uniffiRustCallStatus) {
                invoke(l5.longValue(), uniffiRustCallStatus);
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustCallStatus continuation2) {
                Intrinsics.checkNotNullParameter(continuation2, "continuation");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_complete_void(j6, continuation2);
            }
        }, new Function1<Long, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$giveConsent$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                invoke(l5.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6) {
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_free_void(j6);
            }
        }, new Function1<Unit, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$giveConsent$6
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, AgillicHandlerException.INSTANCE, continuation);
        return uniffiRustCallAsync == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? uniffiRustCallAsync : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0085, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0090, code lost:
    
        if (r19.callCounter.decrementAndGet() == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0092, code lost:
    
        r19.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0099, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object register$suspendImpl(AgillicHandler agillicHandler, String str, AgillicInstallationId agillicInstallationId, AgillicClientId agillicClientId, String str2, List<Consent> list, Continuation<? super Unit> continuation) {
        long j5;
        do {
            j5 = agillicHandler.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(agillicHandler.getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(agillicHandler.getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!agillicHandler.callCounter.compareAndSet(j5, 1 + j5));
        Pointer uniffiClonePointer = agillicHandler.uniffiClonePointer();
        UniffiLib iNSTANCE$shared_release = UniffiLib.INSTANCE.getINSTANCE$shared_release();
        FfiConverterString ffiConverterString = FfiConverterString.INSTANCE;
        Object uniffiRustCallAsync = Molslinjen_sharedKt.uniffiRustCallAsync(iNSTANCE$shared_release.uniffi_molslinjen_shared_fn_method_agillichandler_register(uniffiClonePointer, ffiConverterString.lower2(str), FfiConverterTypeAgillicInstallationId.INSTANCE.lower2((Object) agillicInstallationId), FfiConverterTypeAgillicClientId.INSTANCE.lower2((Object) agillicClientId), ffiConverterString.lower2(str2), FfiConverterSequenceTypeConsent.INSTANCE.lower2((Object) list)), new Function3<Long, UniffiRustFutureContinuationCallback, Long, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$register$3
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, Long l6) {
                invoke(l5.longValue(), uniffiRustFutureContinuationCallback, l6.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustFutureContinuationCallback callback, long j7) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_poll_void(j6, callback, j7);
            }
        }, new Function2<Long, UniffiRustCallStatus, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$register$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustCallStatus uniffiRustCallStatus) {
                invoke(l5.longValue(), uniffiRustCallStatus);
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustCallStatus continuation2) {
                Intrinsics.checkNotNullParameter(continuation2, "continuation");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_complete_void(j6, continuation2);
            }
        }, new Function1<Long, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$register$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                invoke(l5.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6) {
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_free_void(j6);
            }
        }, new Function1<Unit, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$register$6
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, AgillicHandlerException.INSTANCE, continuation);
        return uniffiRustCallAsync == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? uniffiRustCallAsync : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0082, code lost:
    
        if (r15.callCounter.decrementAndGet() == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
    
        r15.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008b, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object unregister$suspendImpl(AgillicHandler agillicHandler, String str, AgillicInstallationId agillicInstallationId, AgillicClientId agillicClientId, Continuation<? super Unit> continuation) {
        long j5;
        do {
            j5 = agillicHandler.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(agillicHandler.getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(agillicHandler.getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!agillicHandler.callCounter.compareAndSet(j5, 1 + j5));
        Object uniffiRustCallAsync = Molslinjen_sharedKt.uniffiRustCallAsync(UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_agillichandler_unregister(agillicHandler.uniffiClonePointer(), FfiConverterString.INSTANCE.lower2(str), FfiConverterTypeAgillicInstallationId.INSTANCE.lower2((Object) agillicInstallationId), FfiConverterTypeAgillicClientId.INSTANCE.lower2((Object) agillicClientId)), new Function3<Long, UniffiRustFutureContinuationCallback, Long, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$unregister$3
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, Long l6) {
                invoke(l5.longValue(), uniffiRustFutureContinuationCallback, l6.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustFutureContinuationCallback callback, long j7) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_poll_void(j6, callback, j7);
            }
        }, new Function2<Long, UniffiRustCallStatus, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$unregister$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustCallStatus uniffiRustCallStatus) {
                invoke(l5.longValue(), uniffiRustCallStatus);
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustCallStatus continuation2) {
                Intrinsics.checkNotNullParameter(continuation2, "continuation");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_complete_void(j6, continuation2);
            }
        }, new Function1<Long, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$unregister$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                invoke(l5.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6) {
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_free_void(j6);
            }
        }, new Function1<Unit, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$unregister$6
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, AgillicHandlerException.INSTANCE, continuation);
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
    static /* synthetic */ Object withdrawConsent$suspendImpl(AgillicHandler agillicHandler, String str, AgillicClientId agillicClientId, Continuation<? super Unit> continuation) {
        long j5;
        do {
            j5 = agillicHandler.callCounter.get();
            if (j5 == 0) {
                throw new IllegalStateException(agillicHandler.getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j5 == Long.MAX_VALUE) {
                throw new IllegalStateException(agillicHandler.getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!agillicHandler.callCounter.compareAndSet(j5, 1 + j5));
        Object uniffiRustCallAsync = Molslinjen_sharedKt.uniffiRustCallAsync(UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_agillichandler_withdraw_consent(agillicHandler.uniffiClonePointer(), FfiConverterString.INSTANCE.lower2(str), FfiConverterTypeAgillicClientId.INSTANCE.lower2((Object) agillicClientId)), new Function3<Long, UniffiRustFutureContinuationCallback, Long, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$withdrawConsent$3
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, Long l6) {
                invoke(l5.longValue(), uniffiRustFutureContinuationCallback, l6.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustFutureContinuationCallback callback, long j7) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_poll_void(j6, callback, j7);
            }
        }, new Function2<Long, UniffiRustCallStatus, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$withdrawConsent$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l5, UniffiRustCallStatus uniffiRustCallStatus) {
                invoke(l5.longValue(), uniffiRustCallStatus);
                return Unit.INSTANCE;
            }

            public final void invoke(long j6, UniffiRustCallStatus continuation2) {
                Intrinsics.checkNotNullParameter(continuation2, "continuation");
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_complete_void(j6, continuation2);
            }
        }, new Function1<Long, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$withdrawConsent$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                invoke(l5.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j6) {
                UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rust_future_free_void(j6);
            }
        }, new Function1<Unit, Unit>() { // from class: uniffi.molslinjen_shared.AgillicHandler$withdrawConsent$6
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, AgillicHandlerException.INSTANCE, continuation);
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

    @Override // uniffi.molslinjen_shared.AgillicHandlerInterface
    public Object feedback(String str, AgillicClientId agillicClientId, AgillicReportId agillicReportId, FeedbackStatus feedbackStatus, Continuation<? super Unit> continuation) {
        return feedback$suspendImpl(this, str, agillicClientId, agillicReportId, feedbackStatus, continuation);
    }

    protected final UniffiCleaner.Cleanable getCleanable() {
        return this.cleanable;
    }

    protected final Pointer getPointer() {
        return this.pointer;
    }

    @Override // uniffi.molslinjen_shared.AgillicHandlerInterface
    public Object giveConsent(String str, AgillicClientId agillicClientId, LocalDateTime localDateTime, Continuation<? super Unit> continuation) {
        return giveConsent$suspendImpl(this, str, agillicClientId, localDateTime, continuation);
    }

    @Override // uniffi.molslinjen_shared.AgillicHandlerInterface
    public Object register(String str, AgillicInstallationId agillicInstallationId, AgillicClientId agillicClientId, String str2, List<Consent> list, Continuation<? super Unit> continuation) {
        return register$suspendImpl(this, str, agillicInstallationId, agillicClientId, str2, list, continuation);
    }

    public final Pointer uniffiClonePointer() {
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        UniffiLib iNSTANCE$shared_release = UniffiLib.INSTANCE.getINSTANCE$shared_release();
        Pointer pointer = this.pointer;
        Intrinsics.checkNotNull(pointer);
        Pointer uniffi_molslinjen_shared_fn_clone_agillichandler = iNSTANCE$shared_release.uniffi_molslinjen_shared_fn_clone_agillichandler(pointer, uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return uniffi_molslinjen_shared_fn_clone_agillichandler;
    }

    @Override // uniffi.molslinjen_shared.AgillicHandlerInterface
    public Object unregister(String str, AgillicInstallationId agillicInstallationId, AgillicClientId agillicClientId, Continuation<? super Unit> continuation) {
        return unregister$suspendImpl(this, str, agillicInstallationId, agillicClientId, continuation);
    }

    @Override // uniffi.molslinjen_shared.AgillicHandlerInterface
    public Object withdrawConsent(String str, AgillicClientId agillicClientId, Continuation<? super Unit> continuation) {
        return withdrawConsent$suspendImpl(this, str, agillicClientId, continuation);
    }

    public AgillicHandler(NoPointer noPointer) {
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
    public AgillicHandler() {
        this(r2);
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        Pointer uniffi_molslinjen_shared_fn_constructor_agillichandler_new = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_constructor_agillichandler_new(uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
    }
}
