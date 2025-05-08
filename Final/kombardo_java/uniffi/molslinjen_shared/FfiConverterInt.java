package uniffi.molslinjen_shared;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FfiConverter;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\nJ\u0015\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Luniffi/molslinjen_shared/FfiConverterInt;", "Luniffi/molslinjen_shared/FfiConverter;", BuildConfig.FLAVOR, "()V", "allocationSize", "Lkotlin/ULong;", "value", "allocationSize-I7RO_PI", "(I)J", "lift", "(I)Ljava/lang/Integer;", "lower", "read", "buf", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)Ljava/lang/Integer;", "write", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FfiConverterInt implements FfiConverter<Integer, Integer> {
    public static final FfiConverterInt INSTANCE = new FfiConverterInt();

    private FfiConverterInt() {
    }

    /* renamed from: allocationSize-I7RO_PI, reason: not valid java name */
    public long m3837allocationSizeI7RO_PI(int value) {
        return 4L;
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public /* bridge */ /* synthetic */ Integer lift(Integer num) {
        return lift(num.intValue());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // uniffi.molslinjen_shared.FfiConverter
    public Integer liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return (Integer) FfiConverter.DefaultImpls.liftFromRustBuffer(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public /* bridge */ /* synthetic */ Integer lower(Integer num) {
        return lower(num.intValue());
    }

    public RustBuffer.ByValue lowerIntoRustBuffer(int i5) {
        return FfiConverter.DefaultImpls.lowerIntoRustBuffer(this, Integer.valueOf(i5));
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public /* bridge */ /* synthetic */ void write(Integer num, ByteBuffer byteBuffer) {
        write(num.intValue(), byteBuffer);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: allocationSize-I7RO_PI */
    public /* bridge */ /* synthetic */ long mo3834allocationSizeI7RO_PI(Integer num) {
        return m3837allocationSizeI7RO_PI(num.intValue());
    }

    public Integer lift(int value) {
        return Integer.valueOf(value);
    }

    public Integer lower(int value) {
        return Integer.valueOf(value);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public /* bridge */ /* synthetic */ RustBuffer.ByValue lowerIntoRustBuffer(Integer num) {
        return lowerIntoRustBuffer(num.intValue());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // uniffi.molslinjen_shared.FfiConverter
    public Integer read(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        return Integer.valueOf(buf.getInt());
    }

    public void write(int value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.putInt(value);
    }
}
