package uniffi.molslinjen_shared;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FfiConverterRustBuffer;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Luniffi/molslinjen_shared/FfiConverterTypeFerrySeatingSection;", "Luniffi/molslinjen_shared/FfiConverterRustBuffer;", "Luniffi/molslinjen_shared/FerrySeatingSection;", "()V", "allocationSize", "Lkotlin/ULong;", "value", "allocationSize-I7RO_PI", "(Luniffi/molslinjen_shared/FerrySeatingSection;)J", "read", "buf", "Ljava/nio/ByteBuffer;", "write", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FfiConverterTypeFerrySeatingSection implements FfiConverterRustBuffer<FerrySeatingSection> {
    public static final FfiConverterTypeFerrySeatingSection INSTANCE = new FfiConverterTypeFerrySeatingSection();

    private FfiConverterTypeFerrySeatingSection() {
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: allocationSize-I7RO_PI, reason: not valid java name and merged with bridge method [inline-methods] */
    public long mo3834allocationSizeI7RO_PI(FerrySeatingSection value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(FfiConverterTypeFerrySeatingSectionId.INSTANCE.mo3834allocationSizeI7RO_PI(value.getId()) + FfiConverterString.INSTANCE.mo3834allocationSizeI7RO_PI(value.getName())) + FfiConverterSequenceTypePoint.INSTANCE.mo3834allocationSizeI7RO_PI(value.getCoordinates())) + FfiConverterSequenceTypeFerrySeatingGroup.INSTANCE.mo3834allocationSizeI7RO_PI(value.getSeatGroups())) + FfiConverterInt.INSTANCE.m3837allocationSizeI7RO_PI(value.getAvailableSeats())) + FfiConverterBoolean.INSTANCE.m3835allocationSizeI7RO_PI(value.getShowAvailableSeats()));
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public FerrySeatingSection liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return (FerrySeatingSection) FfiConverterRustBuffer.DefaultImpls.liftFromRustBuffer(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public RustBuffer.ByValue lowerIntoRustBuffer(FerrySeatingSection ferrySeatingSection) {
        return FfiConverterRustBuffer.DefaultImpls.lowerIntoRustBuffer(this, ferrySeatingSection);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public FerrySeatingSection read(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        return new FerrySeatingSection(FfiConverterTypeFerrySeatingSectionId.INSTANCE.read(buf), FfiConverterString.INSTANCE.read(buf), FfiConverterSequenceTypePoint.INSTANCE.read(buf), FfiConverterSequenceTypeFerrySeatingGroup.INSTANCE.read(buf), FfiConverterInt.INSTANCE.read(buf).intValue(), FfiConverterBoolean.INSTANCE.read(buf).booleanValue());
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public void write(FerrySeatingSection value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(buf, "buf");
        FfiConverterTypeFerrySeatingSectionId.INSTANCE.write(value.getId(), buf);
        FfiConverterString.INSTANCE.write(value.getName(), buf);
        FfiConverterSequenceTypePoint.INSTANCE.write(value.getCoordinates(), buf);
        FfiConverterSequenceTypeFerrySeatingGroup.INSTANCE.write(value.getSeatGroups(), buf);
        FfiConverterInt.INSTANCE.write(value.getAvailableSeats(), buf);
        FfiConverterBoolean.INSTANCE.write(value.getShowAvailableSeats(), buf);
    }

    @Override // uniffi.molslinjen_shared.FfiConverterRustBuffer
    /* renamed from: lift */
    public FerrySeatingSection lift2(RustBuffer.ByValue byValue) {
        return (FerrySeatingSection) FfiConverterRustBuffer.DefaultImpls.lift(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverterRustBuffer, uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lower, reason: merged with bridge method [inline-methods] */
    public RustBuffer.ByValue lower2(FerrySeatingSection ferrySeatingSection) {
        return FfiConverterRustBuffer.DefaultImpls.lower(this, ferrySeatingSection);
    }
}
