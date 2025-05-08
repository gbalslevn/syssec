package uniffi.molslinjen_shared;

import com.sun.jna.Pointer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H&¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0014H&¢\u0006\u0002\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0014H&¢\u0006\u0002\u0010\u0018\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Luniffi/molslinjen_shared/FfiConverter;", "KotlinType", "FfiType", BuildConfig.FLAVOR, "allocationSize", "Lkotlin/ULong;", "value", "allocationSize-I7RO_PI", "(Ljava/lang/Object;)J", "lift", "(Ljava/lang/Object;)Ljava/lang/Object;", "liftFromRustBuffer", "rbuf", "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "(Luniffi/molslinjen_shared/RustBuffer$ByValue;)Ljava/lang/Object;", "lower", "lowerIntoRustBuffer", "(Ljava/lang/Object;)Luniffi/molslinjen_shared/RustBuffer$ByValue;", "read", "buf", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)Ljava/lang/Object;", "write", BuildConfig.FLAVOR, "(Ljava/lang/Object;Ljava/nio/ByteBuffer;)V", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface FfiConverter<KotlinType, FfiType> {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static <KotlinType, FfiType> KotlinType liftFromRustBuffer(FfiConverter<KotlinType, FfiType> ffiConverter, RustBuffer.ByValue rbuf) {
            Intrinsics.checkNotNullParameter(rbuf, "rbuf");
            ByteBuffer asByteBuffer = rbuf.asByteBuffer();
            Intrinsics.checkNotNull(asByteBuffer);
            try {
                KotlinType read = ffiConverter.read(asByteBuffer);
                if (asByteBuffer.hasRemaining()) {
                    throw new RuntimeException("junk remaining in buffer after lifting, something is very wrong!!");
                }
                return read;
            } finally {
                RustBuffer.INSTANCE.free$shared_release(rbuf);
            }
        }

        public static <KotlinType, FfiType> RustBuffer.ByValue lowerIntoRustBuffer(FfiConverter<KotlinType, FfiType> ffiConverter, KotlinType kotlintype) {
            RustBuffer.ByValue m3921allocVKZWuLQ$shared_release = RustBuffer.INSTANCE.m3921allocVKZWuLQ$shared_release(ffiConverter.mo3834allocationSizeI7RO_PI(kotlintype));
            try {
                Pointer pointer = m3921allocVKZWuLQ$shared_release.data;
                Intrinsics.checkNotNull(pointer);
                ByteBuffer byteBuffer = pointer.getByteBuffer(0L, m3921allocVKZWuLQ$shared_release.capacity);
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
                Intrinsics.checkNotNull(byteBuffer);
                ffiConverter.write(kotlintype, byteBuffer);
                m3921allocVKZWuLQ$shared_release.writeField("len", Long.valueOf(byteBuffer.position()));
                return m3921allocVKZWuLQ$shared_release;
            } catch (Throwable th) {
                RustBuffer.INSTANCE.free$shared_release(m3921allocVKZWuLQ$shared_release);
                throw th;
            }
        }
    }

    /* renamed from: allocationSize-I7RO_PI, reason: not valid java name */
    long mo3834allocationSizeI7RO_PI(KotlinType value);

    KotlinType lift(FfiType value);

    KotlinType liftFromRustBuffer(RustBuffer.ByValue rbuf);

    FfiType lower(KotlinType value);

    RustBuffer.ByValue lowerIntoRustBuffer(KotlinType value);

    KotlinType read(ByteBuffer buf);

    void write(KotlinType value, ByteBuffer buf);
}
