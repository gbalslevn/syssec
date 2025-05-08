package uniffi.molslinjen_shared;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FfiConverterRustBuffer;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Luniffi/molslinjen_shared/FfiConverterOptionalTypeAmount;", "Luniffi/molslinjen_shared/FfiConverterRustBuffer;", "Luniffi/molslinjen_shared/Amount;", "()V", "allocationSize", "Lkotlin/ULong;", "value", "allocationSize-I7RO_PI", "(Luniffi/molslinjen_shared/Amount;)J", "read", "buf", "Ljava/nio/ByteBuffer;", "write", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FfiConverterOptionalTypeAmount implements FfiConverterRustBuffer<Amount> {
    public static final FfiConverterOptionalTypeAmount INSTANCE = new FfiConverterOptionalTypeAmount();

    private FfiConverterOptionalTypeAmount() {
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: allocationSize-I7RO_PI, reason: not valid java name and merged with bridge method [inline-methods] */
    public long mo3834allocationSizeI7RO_PI(Amount value) {
        if (value == null) {
            return 1L;
        }
        return ULong.m3622constructorimpl(FfiConverterTypeAmount.INSTANCE.mo3834allocationSizeI7RO_PI(value) + 1);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public Amount liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return (Amount) FfiConverterRustBuffer.DefaultImpls.liftFromRustBuffer(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public RustBuffer.ByValue lowerIntoRustBuffer(Amount amount) {
        return FfiConverterRustBuffer.DefaultImpls.lowerIntoRustBuffer(this, amount);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public Amount read(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (buf.get() == 0) {
            return null;
        }
        return FfiConverterTypeAmount.INSTANCE.read(buf);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public void write(Amount value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (value == null) {
            buf.put((byte) 0);
        } else {
            buf.put((byte) 1);
            FfiConverterTypeAmount.INSTANCE.write(value, buf);
        }
    }

    @Override // uniffi.molslinjen_shared.FfiConverterRustBuffer
    /* renamed from: lift */
    public Amount lift2(RustBuffer.ByValue byValue) {
        return (Amount) FfiConverterRustBuffer.DefaultImpls.lift(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverterRustBuffer, uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lower, reason: merged with bridge method [inline-methods] */
    public RustBuffer.ByValue lower2(Amount amount) {
        return FfiConverterRustBuffer.DefaultImpls.lower(this, amount);
    }
}
