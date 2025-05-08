package uniffi.molslinjen_shared;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FfiConverter;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Luniffi/molslinjen_shared/FfiConverterBoolean;", "Luniffi/molslinjen_shared/FfiConverter;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "()V", "allocationSize", "Lkotlin/ULong;", "value", "allocationSize-I7RO_PI", "(Z)J", "lift", "(B)Ljava/lang/Boolean;", "lower", "(Z)Ljava/lang/Byte;", "read", "buf", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)Ljava/lang/Boolean;", "write", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FfiConverterBoolean implements FfiConverter<Boolean, Byte> {
    public static final FfiConverterBoolean INSTANCE = new FfiConverterBoolean();

    private FfiConverterBoolean() {
    }

    /* renamed from: allocationSize-I7RO_PI, reason: not valid java name */
    public long m3835allocationSizeI7RO_PI(boolean value) {
        return 1L;
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public /* bridge */ /* synthetic */ Boolean lift(Byte b5) {
        return lift(b5.byteValue());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // uniffi.molslinjen_shared.FfiConverter
    public Boolean liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return (Boolean) FfiConverter.DefaultImpls.liftFromRustBuffer(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public /* bridge */ /* synthetic */ Byte lower(Boolean bool) {
        return lower(bool.booleanValue());
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public /* bridge */ /* synthetic */ RustBuffer.ByValue lowerIntoRustBuffer(Boolean bool) {
        return lowerIntoRustBuffer(bool.booleanValue());
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public /* bridge */ /* synthetic */ void write(Boolean bool, ByteBuffer byteBuffer) {
        write(bool.booleanValue(), byteBuffer);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: allocationSize-I7RO_PI */
    public /* bridge */ /* synthetic */ long mo3834allocationSizeI7RO_PI(Boolean bool) {
        return m3835allocationSizeI7RO_PI(bool.booleanValue());
    }

    public Boolean lift(byte value) {
        return Boolean.valueOf(value != 0);
    }

    public Byte lower(boolean value) {
        return Byte.valueOf(value ? (byte) 1 : (byte) 0);
    }

    public RustBuffer.ByValue lowerIntoRustBuffer(boolean z5) {
        return FfiConverter.DefaultImpls.lowerIntoRustBuffer(this, Boolean.valueOf(z5));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // uniffi.molslinjen_shared.FfiConverter
    public Boolean read(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        return lift(buf.get());
    }

    public void write(boolean value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.put(lower(value).byteValue());
    }
}
