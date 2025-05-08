package uniffi.molslinjen_shared;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FfiConverterRustBuffer;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\fJ%\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u000fø\u0001\u0001\u0082\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0010"}, d2 = {"Luniffi/molslinjen_shared/FfiConverterOptionalUInt;", "Luniffi/molslinjen_shared/FfiConverterRustBuffer;", "Lkotlin/UInt;", "()V", "allocationSize", "Lkotlin/ULong;", "value", "allocationSize-hExw-GI", "(Lkotlin/UInt;)J", "read", "buf", "Ljava/nio/ByteBuffer;", "read-gbq4QnA", "write", BuildConfig.FLAVOR, "write-aPkLuA0", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FfiConverterOptionalUInt implements FfiConverterRustBuffer<UInt> {
    public static final FfiConverterOptionalUInt INSTANCE = new FfiConverterOptionalUInt();

    private FfiConverterOptionalUInt() {
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: allocationSize-hExw-GI, reason: not valid java name and merged with bridge method [inline-methods] */
    public long mo3834allocationSizeI7RO_PI(UInt value) {
        if (value == null) {
            return 1L;
        }
        return ULong.m3622constructorimpl(FfiConverterUInt.INSTANCE.m3913allocationSizej8A87jM(value.getData()) + 1);
    }

    @Override // uniffi.molslinjen_shared.FfiConverterRustBuffer
    /* renamed from: lift-gbq4QnA, reason: not valid java name and merged with bridge method [inline-methods] */
    public UInt lift2(RustBuffer.ByValue byValue) {
        return (UInt) FfiConverterRustBuffer.DefaultImpls.lift(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: liftFromRustBuffer-gbq4QnA, reason: not valid java name and merged with bridge method [inline-methods] */
    public UInt liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return (UInt) FfiConverterRustBuffer.DefaultImpls.liftFromRustBuffer(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverterRustBuffer, uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lower-ExVfyTY, reason: not valid java name and merged with bridge method [inline-methods] */
    public RustBuffer.ByValue lower2(UInt uInt) {
        return FfiConverterRustBuffer.DefaultImpls.lower(this, uInt);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lowerIntoRustBuffer-ExVfyTY, reason: not valid java name and merged with bridge method [inline-methods] */
    public RustBuffer.ByValue lowerIntoRustBuffer(UInt uInt) {
        return FfiConverterRustBuffer.DefaultImpls.lowerIntoRustBuffer(this, uInt);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: read-gbq4QnA, reason: not valid java name and merged with bridge method [inline-methods] */
    public UInt read(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (buf.get() == 0) {
            return null;
        }
        return UInt.m3598boximpl(FfiConverterUInt.INSTANCE.m3918readOGnWXxg(buf));
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: write-aPkLuA0, reason: not valid java name and merged with bridge method [inline-methods] */
    public void write(UInt value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (value == null) {
            buf.put((byte) 0);
        } else {
            buf.put((byte) 1);
            FfiConverterUInt.INSTANCE.m3919writeqim9Vi0(value.getData(), buf);
        }
    }
}
