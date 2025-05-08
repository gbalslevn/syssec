package uniffi.molslinjen_shared;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \u00102\u00020\u0001:\u0003\u000e\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\rR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Luniffi/molslinjen_shared/RustBuffer;", "Lcom/sun/jna/Structure;", "()V", "capacity", BuildConfig.FLAVOR, "data", "Lcom/sun/jna/Pointer;", "len", "asByteBuffer", "Ljava/nio/ByteBuffer;", "setValue", BuildConfig.FLAVOR, "other", "setValue$shared_release", "ByReference", "ByValue", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Structure.FieldOrder({"capacity", "len", "data"})
/* loaded from: classes3.dex */
public class RustBuffer extends Structure {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public long capacity;
    public Pointer data;
    public long len;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Luniffi/molslinjen_shared/RustBuffer$ByReference;", "Luniffi/molslinjen_shared/RustBuffer;", "Lcom/sun/jna/Structure$ByReference;", "()V", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ByReference extends RustBuffer implements Structure.ByReference {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Luniffi/molslinjen_shared/RustBuffer$ByValue;", "Luniffi/molslinjen_shared/RustBuffer;", "Lcom/sun/jna/Structure$ByValue;", "()V", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ByValue extends RustBuffer implements Structure.ByValue {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Luniffi/molslinjen_shared/RustBuffer$Companion;", BuildConfig.FLAVOR, "()V", "alloc", "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "size", "Lkotlin/ULong;", "alloc-VKZWuLQ$shared_release", "(J)Luniffi/molslinjen_shared/RustBuffer$ByValue;", "create", "capacity", "len", "data", "Lcom/sun/jna/Pointer;", "create-twO9MuI$shared_release", "(JJLcom/sun/jna/Pointer;)Luniffi/molslinjen_shared/RustBuffer$ByValue;", "free", BuildConfig.FLAVOR, "buf", "free$shared_release", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: alloc-VKZWuLQ$shared_release$default, reason: not valid java name */
        public static /* synthetic */ ByValue m3920allocVKZWuLQ$shared_release$default(Companion companion, long j5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                j5 = 0;
            }
            return companion.m3921allocVKZWuLQ$shared_release(j5);
        }

        /* renamed from: alloc-VKZWuLQ$shared_release, reason: not valid java name */
        public final ByValue m3921allocVKZWuLQ$shared_release(long size) {
            UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
            UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
            ByValue ffi_molslinjen_shared_rustbuffer_alloc = UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rustbuffer_alloc(size, uniffiRustCallStatus);
            Molslinjen_sharedKt.access$uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
            if (ffi_molslinjen_shared_rustbuffer_alloc.data != null) {
                return ffi_molslinjen_shared_rustbuffer_alloc;
            }
            throw new RuntimeException("RustBuffer.alloc() returned null data pointer (size=" + ULong.m3626toStringimpl(size) + ")");
        }

        /* renamed from: create-twO9MuI$shared_release, reason: not valid java name */
        public final ByValue m3922createtwO9MuI$shared_release(long capacity, long len, Pointer data) {
            ByValue byValue = new ByValue();
            byValue.capacity = capacity;
            byValue.len = len;
            byValue.data = data;
            return byValue;
        }

        public final void free$shared_release(ByValue buf) {
            Intrinsics.checkNotNullParameter(buf, "buf");
            UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
            UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
            UniffiLib.INSTANCE.getINSTANCE$shared_release().ffi_molslinjen_shared_rustbuffer_free(buf, uniffiRustCallStatus);
            Unit unit = Unit.INSTANCE;
            Molslinjen_sharedKt.access$uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        }

        private Companion() {
        }
    }

    public final ByteBuffer asByteBuffer() {
        ByteBuffer byteBuffer;
        Pointer pointer = this.data;
        if (pointer == null || (byteBuffer = pointer.getByteBuffer(0L, this.len)) == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        return byteBuffer;
    }

    public final void setValue$shared_release(RustBuffer other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.capacity = other.capacity;
        this.len = other.len;
        this.data = other.data;
    }
}
