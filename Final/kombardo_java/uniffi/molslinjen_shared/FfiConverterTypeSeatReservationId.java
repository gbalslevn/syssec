package uniffi.molslinjen_shared;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FfiConverterRustBuffer;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Luniffi/molslinjen_shared/FfiConverterTypeSeatReservationId;", "Luniffi/molslinjen_shared/FfiConverterRustBuffer;", "Luniffi/molslinjen_shared/SeatReservationId;", "()V", "allocationSize", "Lkotlin/ULong;", "value", "allocationSize-I7RO_PI", "(Luniffi/molslinjen_shared/SeatReservationId;)J", "read", "buf", "Ljava/nio/ByteBuffer;", "write", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FfiConverterTypeSeatReservationId implements FfiConverterRustBuffer<SeatReservationId> {
    public static final FfiConverterTypeSeatReservationId INSTANCE = new FfiConverterTypeSeatReservationId();

    private FfiConverterTypeSeatReservationId() {
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: allocationSize-I7RO_PI, reason: not valid java name and merged with bridge method [inline-methods] */
    public long mo3834allocationSizeI7RO_PI(SeatReservationId value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return FfiConverterInt.INSTANCE.m3837allocationSizeI7RO_PI(value.getValue());
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public SeatReservationId liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return (SeatReservationId) FfiConverterRustBuffer.DefaultImpls.liftFromRustBuffer(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public RustBuffer.ByValue lowerIntoRustBuffer(SeatReservationId seatReservationId) {
        return FfiConverterRustBuffer.DefaultImpls.lowerIntoRustBuffer(this, seatReservationId);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public SeatReservationId read(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        return new SeatReservationId(FfiConverterInt.INSTANCE.read(buf).intValue());
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public void write(SeatReservationId value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(buf, "buf");
        FfiConverterInt.INSTANCE.write(value.getValue(), buf);
    }

    @Override // uniffi.molslinjen_shared.FfiConverterRustBuffer
    /* renamed from: lift */
    public SeatReservationId lift2(RustBuffer.ByValue byValue) {
        return (SeatReservationId) FfiConverterRustBuffer.DefaultImpls.lift(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverterRustBuffer, uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lower, reason: merged with bridge method [inline-methods] */
    public RustBuffer.ByValue lower2(SeatReservationId seatReservationId) {
        return FfiConverterRustBuffer.DefaultImpls.lower(this, seatReservationId);
    }
}
