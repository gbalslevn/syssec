package uniffi.molslinjen_shared;

import com.sun.jna.Pointer;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002>?B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ-\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0010H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 J!\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010(\u001a\u00020'2\u0006\u0010$\u001a\u00020!2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b(\u0010)J3\u0010/\u001a\b\u0012\u0004\u0012\u00020.0*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020!0*2\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020%H\u0016¢\u0006\u0004\b/\u00100R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b2\u0010\u0016R\u001a\u00104\u001a\u0002038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006@"}, d2 = {"Luniffi/molslinjen_shared/SelectSeatingHelper;", "Luniffi/molslinjen_shared/Disposable;", "Ljava/lang/AutoCloseable;", "Luniffi/molslinjen_shared/SelectSeatingHelperInterface;", "Lcom/sun/jna/Pointer;", "pointer", "<init>", "(Lcom/sun/jna/Pointer;)V", "Luniffi/molslinjen_shared/NoPointer;", "noPointer", "(Luniffi/molslinjen_shared/NoPointer;)V", "()V", BuildConfig.FLAVOR, "destroy", "close", "R", "Lkotlin/Function1;", "block", "callWithPointer$shared_release", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "callWithPointer", "uniffiClonePointer", "()Lcom/sun/jna/Pointer;", "Luniffi/molslinjen_shared/FerryFloorPlan;", "floorPlan", "Luniffi/molslinjen_shared/FerrySeatId;", "seatId", "Luniffi/molslinjen_shared/FerrySeat;", "findSeat", "(Luniffi/molslinjen_shared/FerryFloorPlan;Luniffi/molslinjen_shared/FerrySeatId;)Luniffi/molslinjen_shared/FerrySeat;", "Luniffi/molslinjen_shared/FerrySeatingGroup;", "findSeatGroup", "(Luniffi/molslinjen_shared/FerryFloorPlan;Luniffi/molslinjen_shared/FerrySeatId;)Luniffi/molslinjen_shared/FerrySeatingGroup;", "Luniffi/molslinjen_shared/FerrySeatingSection;", "findSection", "(Luniffi/molslinjen_shared/FerryFloorPlan;Luniffi/molslinjen_shared/FerrySeatId;)Luniffi/molslinjen_shared/FerrySeatingSection;", "section", BuildConfig.FLAVOR, "targetSeatSize", "Luniffi/molslinjen_shared/FerrySeatingSectionDetails;", "toDetails", "(Luniffi/molslinjen_shared/FerrySeatingSection;D)Luniffi/molslinjen_shared/FerrySeatingSectionDetails;", BuildConfig.FLAVOR, "sections", "targetWidth", "targetHeight", "Luniffi/molslinjen_shared/FerrySeatingSectionOverview;", "toOverview", "(Ljava/util/List;DD)Ljava/util/List;", "Lcom/sun/jna/Pointer;", "getPointer", "Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "cleanable", "Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "getCleanable", "()Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "wasDestroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicLong;", "callCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "Companion", "UniffiCleanAction", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class SelectSeatingHelper implements Disposable, AutoCloseable, SelectSeatingHelperInterface {
    private final AtomicLong callCounter;
    private final UniffiCleaner.Cleanable cleanable;
    private final Pointer pointer;
    private final AtomicBoolean wasDestroyed;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Luniffi/molslinjen_shared/SelectSeatingHelper$UniffiCleanAction;", "Ljava/lang/Runnable;", "pointer", "Lcom/sun/jna/Pointer;", "(Lcom/sun/jna/Pointer;)V", "run", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
                UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_free_selectseatinghelper(pointer, uniffiRustCallStatus);
                Unit unit = Unit.INSTANCE;
                Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
            }
        }
    }

    public SelectSeatingHelper(Pointer pointer) {
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

    @Override // uniffi.molslinjen_shared.Disposable
    public void destroy() {
        if (this.wasDestroyed.compareAndSet(false, true) && this.callCounter.decrementAndGet() == 0) {
            this.cleanable.clean();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006e, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0079, code lost:
    
        if (r8.callCounter.decrementAndGet() == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007b, code lost:
    
        r8.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0082, code lost:
    
        throw r9;
     */
    @Override // uniffi.molslinjen_shared.SelectSeatingHelperInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FerrySeat findSeat(FerryFloorPlan floorPlan, FerrySeatId seatId) {
        long j5;
        Intrinsics.checkNotNullParameter(floorPlan, "floorPlan");
        Intrinsics.checkNotNullParameter(seatId, "seatId");
        FfiConverterOptionalTypeFerrySeat ffiConverterOptionalTypeFerrySeat = FfiConverterOptionalTypeFerrySeat.INSTANCE;
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
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_selectseatinghelper_find_seat = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_selectseatinghelper_find_seat(uniffiClonePointer, FfiConverterTypeFerryFloorPlan.INSTANCE.lower2((Object) floorPlan), FfiConverterTypeFerrySeatId.INSTANCE.lower2((Object) seatId), uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return (FerrySeat) ffiConverterOptionalTypeFerrySeat.lift2(uniffi_molslinjen_shared_fn_method_selectseatinghelper_find_seat);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006e, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0079, code lost:
    
        if (r8.callCounter.decrementAndGet() == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007b, code lost:
    
        r8.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0082, code lost:
    
        throw r9;
     */
    @Override // uniffi.molslinjen_shared.SelectSeatingHelperInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FerrySeatingGroup findSeatGroup(FerryFloorPlan floorPlan, FerrySeatId seatId) {
        long j5;
        Intrinsics.checkNotNullParameter(floorPlan, "floorPlan");
        Intrinsics.checkNotNullParameter(seatId, "seatId");
        FfiConverterOptionalTypeFerrySeatingGroup ffiConverterOptionalTypeFerrySeatingGroup = FfiConverterOptionalTypeFerrySeatingGroup.INSTANCE;
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
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_selectseatinghelper_find_seat_group = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_selectseatinghelper_find_seat_group(uniffiClonePointer, FfiConverterTypeFerryFloorPlan.INSTANCE.lower2((Object) floorPlan), FfiConverterTypeFerrySeatId.INSTANCE.lower2((Object) seatId), uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return (FerrySeatingGroup) ffiConverterOptionalTypeFerrySeatingGroup.lift2(uniffi_molslinjen_shared_fn_method_selectseatinghelper_find_seat_group);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006e, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0079, code lost:
    
        if (r8.callCounter.decrementAndGet() == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007b, code lost:
    
        r8.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0082, code lost:
    
        throw r9;
     */
    @Override // uniffi.molslinjen_shared.SelectSeatingHelperInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FerrySeatingSection findSection(FerryFloorPlan floorPlan, FerrySeatId seatId) {
        long j5;
        Intrinsics.checkNotNullParameter(floorPlan, "floorPlan");
        Intrinsics.checkNotNullParameter(seatId, "seatId");
        FfiConverterOptionalTypeFerrySeatingSection ffiConverterOptionalTypeFerrySeatingSection = FfiConverterOptionalTypeFerrySeatingSection.INSTANCE;
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
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_selectseatinghelper_find_section = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_selectseatinghelper_find_section(uniffiClonePointer, FfiConverterTypeFerryFloorPlan.INSTANCE.lower2((Object) floorPlan), FfiConverterTypeFerrySeatId.INSTANCE.lower2((Object) seatId), uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return (FerrySeatingSection) ffiConverterOptionalTypeFerrySeatingSection.lift2(uniffi_molslinjen_shared_fn_method_selectseatinghelper_find_section);
    }

    protected final UniffiCleaner.Cleanable getCleanable() {
        return this.cleanable;
    }

    protected final Pointer getPointer() {
        return this.pointer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006e, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0079, code lost:
    
        if (r11.callCounter.decrementAndGet() == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007b, code lost:
    
        r11.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0082, code lost:
    
        throw r12;
     */
    @Override // uniffi.molslinjen_shared.SelectSeatingHelperInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FerrySeatingSectionDetails toDetails(FerrySeatingSection section, double targetSeatSize) {
        long j5;
        Intrinsics.checkNotNullParameter(section, "section");
        FfiConverterTypeFerrySeatingSectionDetails ffiConverterTypeFerrySeatingSectionDetails = FfiConverterTypeFerrySeatingSectionDetails.INSTANCE;
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
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_selectseatinghelper_to_details = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_method_selectseatinghelper_to_details(uniffiClonePointer, FfiConverterTypeFerrySeatingSection.INSTANCE.lower2((Object) section), FfiConverterDouble.INSTANCE.lower(targetSeatSize).doubleValue(), uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return (FerrySeatingSectionDetails) ffiConverterTypeFerrySeatingSectionDetails.lift2(uniffi_molslinjen_shared_fn_method_selectseatinghelper_to_details);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0086, code lost:
    
        if (r14.callCounter.decrementAndGet() == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0088, code lost:
    
        r14.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008f, code lost:
    
        throw r0;
     */
    @Override // uniffi.molslinjen_shared.SelectSeatingHelperInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<FerrySeatingSectionOverview> toOverview(List<FerrySeatingSection> sections, double targetWidth, double targetHeight) {
        long j5;
        Intrinsics.checkNotNullParameter(sections, "sections");
        FfiConverterSequenceTypeFerrySeatingSectionOverview ffiConverterSequenceTypeFerrySeatingSectionOverview = FfiConverterSequenceTypeFerrySeatingSectionOverview.INSTANCE;
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
        UniffiLib iNSTANCE$shared_release = UniffiLib.INSTANCE.getINSTANCE$shared_release();
        RustBuffer.ByValue lower2 = FfiConverterSequenceTypeFerrySeatingSection.INSTANCE.lower2((Object) sections);
        FfiConverterDouble ffiConverterDouble = FfiConverterDouble.INSTANCE;
        RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_selectseatinghelper_to_overview = iNSTANCE$shared_release.uniffi_molslinjen_shared_fn_method_selectseatinghelper_to_overview(uniffiClonePointer, lower2, ffiConverterDouble.lower(targetWidth).doubleValue(), ffiConverterDouble.lower(targetHeight).doubleValue(), uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return (List) ffiConverterSequenceTypeFerrySeatingSectionOverview.lift2(uniffi_molslinjen_shared_fn_method_selectseatinghelper_to_overview);
    }

    public final Pointer uniffiClonePointer() {
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        UniffiLib iNSTANCE$shared_release = UniffiLib.INSTANCE.getINSTANCE$shared_release();
        Pointer pointer = this.pointer;
        Intrinsics.checkNotNull(pointer);
        Pointer uniffi_molslinjen_shared_fn_clone_selectseatinghelper = iNSTANCE$shared_release.uniffi_molslinjen_shared_fn_clone_selectseatinghelper(pointer, uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return uniffi_molslinjen_shared_fn_clone_selectseatinghelper;
    }

    public SelectSeatingHelper(NoPointer noPointer) {
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
    public SelectSeatingHelper() {
        this(r2);
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        Pointer uniffi_molslinjen_shared_fn_constructor_selectseatinghelper_new = UniffiLib.INSTANCE.getINSTANCE$shared_release().uniffi_molslinjen_shared_fn_constructor_selectseatinghelper_new(uniffiRustCallStatus);
        Molslinjen_sharedKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
    }
}
