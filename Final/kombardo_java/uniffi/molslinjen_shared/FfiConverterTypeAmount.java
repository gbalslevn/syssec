package uniffi.molslinjen_shared;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.Amount;
import uniffi.molslinjen_shared.FfiConverterRustBuffer;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Luniffi/molslinjen_shared/FfiConverterTypeAmount;", "Luniffi/molslinjen_shared/FfiConverterRustBuffer;", "Luniffi/molslinjen_shared/Amount;", "()V", "allocationSize", "Lkotlin/ULong;", "value", "allocationSize-I7RO_PI", "(Luniffi/molslinjen_shared/Amount;)J", "read", "buf", "Ljava/nio/ByteBuffer;", "write", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FfiConverterTypeAmount implements FfiConverterRustBuffer<Amount> {
    public static final FfiConverterTypeAmount INSTANCE = new FfiConverterTypeAmount();

    private FfiConverterTypeAmount() {
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: allocationSize-I7RO_PI, reason: not valid java name and merged with bridge method [inline-methods] */
    public long mo3834allocationSizeI7RO_PI(Amount value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof Amount.Charge) {
            return ULong.m3622constructorimpl(FfiConverterLong.INSTANCE.m3838allocationSizeI7RO_PI(((Amount.Charge) value).getCount()) + 4);
        }
        if (value instanceof Amount.Monetary) {
            Amount.Monetary monetary = (Amount.Monetary) value;
            return ULong.m3622constructorimpl(ULong.m3622constructorimpl(FfiConverterLong.INSTANCE.m3838allocationSizeI7RO_PI(monetary.getAmount()) + 4) + FfiConverterTypeCurrency.INSTANCE.mo3834allocationSizeI7RO_PI(monetary.getCurrency()));
        }
        if (!(value instanceof Amount.Mixed)) {
            throw new NoWhenBranchMatchedException();
        }
        FfiConverterLong ffiConverterLong = FfiConverterLong.INSTANCE;
        Amount.Mixed mixed = (Amount.Mixed) value;
        return ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ffiConverterLong.m3838allocationSizeI7RO_PI(mixed.getChargeCount()) + 4) + ffiConverterLong.m3838allocationSizeI7RO_PI(mixed.getMonetaryAmount())) + FfiConverterTypeCurrency.INSTANCE.mo3834allocationSizeI7RO_PI(mixed.getCurrency()));
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
        int i5 = buf.getInt();
        if (i5 == 1) {
            return new Amount.Charge(FfiConverterLong.INSTANCE.read(buf).longValue());
        }
        if (i5 == 2) {
            return new Amount.Monetary(FfiConverterLong.INSTANCE.read(buf).longValue(), FfiConverterTypeCurrency.INSTANCE.read(buf));
        }
        if (i5 == 3) {
            FfiConverterLong ffiConverterLong = FfiConverterLong.INSTANCE;
            return new Amount.Mixed(ffiConverterLong.read(buf).longValue(), ffiConverterLong.read(buf).longValue(), FfiConverterTypeCurrency.INSTANCE.read(buf));
        }
        throw new RuntimeException("invalid enum value, something is very wrong!!");
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public void write(Amount value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (value instanceof Amount.Charge) {
            buf.putInt(1);
            FfiConverterLong.INSTANCE.write(((Amount.Charge) value).getCount(), buf);
        } else if (value instanceof Amount.Monetary) {
            buf.putInt(2);
            Amount.Monetary monetary = (Amount.Monetary) value;
            FfiConverterLong.INSTANCE.write(monetary.getAmount(), buf);
            FfiConverterTypeCurrency.INSTANCE.write(monetary.getCurrency(), buf);
        } else {
            if (!(value instanceof Amount.Mixed)) {
                throw new NoWhenBranchMatchedException();
            }
            buf.putInt(3);
            FfiConverterLong ffiConverterLong = FfiConverterLong.INSTANCE;
            Amount.Mixed mixed = (Amount.Mixed) value;
            ffiConverterLong.write(mixed.getChargeCount(), buf);
            ffiConverterLong.write(mixed.getMonetaryAmount(), buf);
            FfiConverterTypeCurrency.INSTANCE.write(mixed.getCurrency(), buf);
        }
        Unit unit = Unit.INSTANCE;
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
