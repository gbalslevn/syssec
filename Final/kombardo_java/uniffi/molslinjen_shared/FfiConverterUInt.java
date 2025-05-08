package uniffi.molslinjen_shared;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FfiConverter;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ \u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018ø\u0001\u0001\u0082\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0019"}, d2 = {"Luniffi/molslinjen_shared/FfiConverterUInt;", "Luniffi/molslinjen_shared/FfiConverter;", "Lkotlin/UInt;", BuildConfig.FLAVOR, "()V", "allocationSize", "Lkotlin/ULong;", "value", "allocationSize-j8A87jM", "(I)J", "lift", "lift-OGnWXxg", "(I)I", "lower", "lower-WZ4Q5Ns", "(I)Ljava/lang/Integer;", "read", "buf", "Ljava/nio/ByteBuffer;", "read-OGnWXxg", "(Ljava/nio/ByteBuffer;)I", "write", BuildConfig.FLAVOR, "write-qim9Vi0", "(ILjava/nio/ByteBuffer;)V", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FfiConverterUInt implements FfiConverter<UInt, Integer> {
    public static final FfiConverterUInt INSTANCE = new FfiConverterUInt();

    private FfiConverterUInt() {
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: allocationSize-I7RO_PI */
    public /* bridge */ /* synthetic */ long mo3834allocationSizeI7RO_PI(UInt uInt) {
        return m3913allocationSizej8A87jM(uInt.getData());
    }

    /* renamed from: allocationSize-j8A87jM, reason: not valid java name */
    public long m3913allocationSizej8A87jM(int value) {
        return 4L;
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lift */
    public /* bridge */ /* synthetic */ UInt lift2(Integer num) {
        return UInt.m3598boximpl(m3914liftOGnWXxg(num.intValue()));
    }

    /* renamed from: lift-OGnWXxg, reason: not valid java name */
    public int m3914liftOGnWXxg(int value) {
        return UInt.m3599constructorimpl(value);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public /* bridge */ /* synthetic */ UInt liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return UInt.m3598boximpl(m3915liftFromRustBufferOGnWXxg(byValue));
    }

    /* renamed from: liftFromRustBuffer-OGnWXxg, reason: not valid java name */
    public int m3915liftFromRustBufferOGnWXxg(RustBuffer.ByValue byValue) {
        return ((UInt) FfiConverter.DefaultImpls.liftFromRustBuffer(this, byValue)).getData();
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lower */
    public /* bridge */ /* synthetic */ Integer lower2(UInt uInt) {
        return m3916lowerWZ4Q5Ns(uInt.getData());
    }

    /* renamed from: lower-WZ4Q5Ns, reason: not valid java name */
    public Integer m3916lowerWZ4Q5Ns(int value) {
        return Integer.valueOf(value);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public /* bridge */ /* synthetic */ RustBuffer.ByValue lowerIntoRustBuffer(UInt uInt) {
        return m3917lowerIntoRustBufferWZ4Q5Ns(uInt.getData());
    }

    /* renamed from: lowerIntoRustBuffer-WZ4Q5Ns, reason: not valid java name */
    public RustBuffer.ByValue m3917lowerIntoRustBufferWZ4Q5Ns(int i5) {
        return FfiConverter.DefaultImpls.lowerIntoRustBuffer(this, UInt.m3598boximpl(i5));
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public /* bridge */ /* synthetic */ UInt read(ByteBuffer byteBuffer) {
        return UInt.m3598boximpl(m3918readOGnWXxg(byteBuffer));
    }

    /* renamed from: read-OGnWXxg, reason: not valid java name */
    public int m3918readOGnWXxg(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        return m3914liftOGnWXxg(buf.getInt());
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public /* bridge */ /* synthetic */ void write(UInt uInt, ByteBuffer byteBuffer) {
        m3919writeqim9Vi0(uInt.getData(), byteBuffer);
    }

    /* renamed from: write-qim9Vi0, reason: not valid java name */
    public void m3919writeqim9Vi0(int value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.putInt(value);
    }
}
