package uniffi.molslinjen_shared;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeatingGroupType;
import uniffi.molslinjen_shared.FfiConverterRustBuffer;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Luniffi/molslinjen_shared/FfiConverterTypeFerrySeatingGroupType;", "Luniffi/molslinjen_shared/FfiConverterRustBuffer;", "Luniffi/molslinjen_shared/FerrySeatingGroupType;", "()V", "allocationSize", "Lkotlin/ULong;", "value", "allocationSize-I7RO_PI", "(Luniffi/molslinjen_shared/FerrySeatingGroupType;)J", "read", "buf", "Ljava/nio/ByteBuffer;", "write", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FfiConverterTypeFerrySeatingGroupType implements FfiConverterRustBuffer<FerrySeatingGroupType> {
    public static final FfiConverterTypeFerrySeatingGroupType INSTANCE = new FfiConverterTypeFerrySeatingGroupType();

    private FfiConverterTypeFerrySeatingGroupType() {
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: allocationSize-I7RO_PI, reason: not valid java name and merged with bridge method [inline-methods] */
    public long mo3834allocationSizeI7RO_PI(FerrySeatingGroupType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof FerrySeatingGroupType.SingleSeat) {
            return ULong.m3622constructorimpl(FfiConverterTypeFerrySeat.INSTANCE.mo3834allocationSizeI7RO_PI(((FerrySeatingGroupType.SingleSeat) value).getSeat()) + 4);
        }
        if (value instanceof FerrySeatingGroupType.DoubleSeat) {
            FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat = FfiConverterTypeFerrySeat.INSTANCE;
            FerrySeatingGroupType.DoubleSeat doubleSeat = (FerrySeatingGroupType.DoubleSeat) value;
            return ULong.m3622constructorimpl(ULong.m3622constructorimpl(ffiConverterTypeFerrySeat.mo3834allocationSizeI7RO_PI(doubleSeat.getLeft()) + 4) + ffiConverterTypeFerrySeat.mo3834allocationSizeI7RO_PI(doubleSeat.getRight()));
        }
        if (value instanceof FerrySeatingGroupType.SmallTable) {
            FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat2 = FfiConverterTypeFerrySeat.INSTANCE;
            FerrySeatingGroupType.SmallTable smallTable = (FerrySeatingGroupType.SmallTable) value;
            return ULong.m3622constructorimpl(ULong.m3622constructorimpl(ffiConverterTypeFerrySeat2.mo3834allocationSizeI7RO_PI(smallTable.getTop()) + 4) + ffiConverterTypeFerrySeat2.mo3834allocationSizeI7RO_PI(smallTable.getBottom()));
        }
        if (value instanceof FerrySeatingGroupType.LargeTable) {
            FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat3 = FfiConverterTypeFerrySeat.INSTANCE;
            FerrySeatingGroupType.LargeTable largeTable = (FerrySeatingGroupType.LargeTable) value;
            return ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ffiConverterTypeFerrySeat3.mo3834allocationSizeI7RO_PI(largeTable.getTopLeft()) + 4) + ffiConverterTypeFerrySeat3.mo3834allocationSizeI7RO_PI(largeTable.getTopRight())) + ffiConverterTypeFerrySeat3.mo3834allocationSizeI7RO_PI(largeTable.getBottomLeft())) + ffiConverterTypeFerrySeat3.mo3834allocationSizeI7RO_PI(largeTable.getBottomRight()));
        }
        if (value instanceof FerrySeatingGroupType.XLargeTable) {
            FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat4 = FfiConverterTypeFerrySeat.INSTANCE;
            FerrySeatingGroupType.XLargeTable xLargeTable = (FerrySeatingGroupType.XLargeTable) value;
            return ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ffiConverterTypeFerrySeat4.mo3834allocationSizeI7RO_PI(xLargeTable.getTopLeft()) + 4) + ffiConverterTypeFerrySeat4.mo3834allocationSizeI7RO_PI(xLargeTable.getTopMiddle())) + ffiConverterTypeFerrySeat4.mo3834allocationSizeI7RO_PI(xLargeTable.getTopRight())) + ffiConverterTypeFerrySeat4.mo3834allocationSizeI7RO_PI(xLargeTable.getBottomLeft())) + ffiConverterTypeFerrySeat4.mo3834allocationSizeI7RO_PI(xLargeTable.getBottomMiddle())) + ffiConverterTypeFerrySeat4.mo3834allocationSizeI7RO_PI(xLargeTable.getBottomRight()));
        }
        if (value instanceof FerrySeatingGroupType.CornerTable) {
            FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat5 = FfiConverterTypeFerrySeat.INSTANCE;
            FerrySeatingGroupType.CornerTable cornerTable = (FerrySeatingGroupType.CornerTable) value;
            return ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ffiConverterTypeFerrySeat5.mo3834allocationSizeI7RO_PI(cornerTable.getTopLeft()) + 4) + ffiConverterTypeFerrySeat5.mo3834allocationSizeI7RO_PI(cornerTable.getTopRight())) + ffiConverterTypeFerrySeat5.mo3834allocationSizeI7RO_PI(cornerTable.getMiddle())) + ffiConverterTypeFerrySeat5.mo3834allocationSizeI7RO_PI(cornerTable.getBottomLeft())) + ffiConverterTypeFerrySeat5.mo3834allocationSizeI7RO_PI(cornerTable.getBottomRight()));
        }
        if (!(value instanceof FerrySeatingGroupType.CornerTableLarge)) {
            throw new NoWhenBranchMatchedException();
        }
        FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat6 = FfiConverterTypeFerrySeat.INSTANCE;
        FerrySeatingGroupType.CornerTableLarge cornerTableLarge = (FerrySeatingGroupType.CornerTableLarge) value;
        return ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ffiConverterTypeFerrySeat6.mo3834allocationSizeI7RO_PI(cornerTableLarge.getTopLeft()) + 4) + ffiConverterTypeFerrySeat6.mo3834allocationSizeI7RO_PI(cornerTableLarge.getTopMiddle())) + ffiConverterTypeFerrySeat6.mo3834allocationSizeI7RO_PI(cornerTableLarge.getTopRight())) + ffiConverterTypeFerrySeat6.mo3834allocationSizeI7RO_PI(cornerTableLarge.getMiddle())) + ffiConverterTypeFerrySeat6.mo3834allocationSizeI7RO_PI(cornerTableLarge.getBottomLeft())) + ffiConverterTypeFerrySeat6.mo3834allocationSizeI7RO_PI(cornerTableLarge.getBottomMiddle())) + ffiConverterTypeFerrySeat6.mo3834allocationSizeI7RO_PI(cornerTableLarge.getBottomRight()));
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public FerrySeatingGroupType liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return (FerrySeatingGroupType) FfiConverterRustBuffer.DefaultImpls.liftFromRustBuffer(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public RustBuffer.ByValue lowerIntoRustBuffer(FerrySeatingGroupType ferrySeatingGroupType) {
        return FfiConverterRustBuffer.DefaultImpls.lowerIntoRustBuffer(this, ferrySeatingGroupType);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public FerrySeatingGroupType read(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        switch (buf.getInt()) {
            case 1:
                return new FerrySeatingGroupType.SingleSeat(FfiConverterTypeFerrySeat.INSTANCE.read(buf));
            case 2:
                FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat = FfiConverterTypeFerrySeat.INSTANCE;
                return new FerrySeatingGroupType.DoubleSeat(ffiConverterTypeFerrySeat.read(buf), ffiConverterTypeFerrySeat.read(buf));
            case 3:
                FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat2 = FfiConverterTypeFerrySeat.INSTANCE;
                return new FerrySeatingGroupType.SmallTable(ffiConverterTypeFerrySeat2.read(buf), ffiConverterTypeFerrySeat2.read(buf));
            case 4:
                FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat3 = FfiConverterTypeFerrySeat.INSTANCE;
                return new FerrySeatingGroupType.LargeTable(ffiConverterTypeFerrySeat3.read(buf), ffiConverterTypeFerrySeat3.read(buf), ffiConverterTypeFerrySeat3.read(buf), ffiConverterTypeFerrySeat3.read(buf));
            case 5:
                FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat4 = FfiConverterTypeFerrySeat.INSTANCE;
                return new FerrySeatingGroupType.XLargeTable(ffiConverterTypeFerrySeat4.read(buf), ffiConverterTypeFerrySeat4.read(buf), ffiConverterTypeFerrySeat4.read(buf), ffiConverterTypeFerrySeat4.read(buf), ffiConverterTypeFerrySeat4.read(buf), ffiConverterTypeFerrySeat4.read(buf));
            case 6:
                FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat5 = FfiConverterTypeFerrySeat.INSTANCE;
                return new FerrySeatingGroupType.CornerTable(ffiConverterTypeFerrySeat5.read(buf), ffiConverterTypeFerrySeat5.read(buf), ffiConverterTypeFerrySeat5.read(buf), ffiConverterTypeFerrySeat5.read(buf), ffiConverterTypeFerrySeat5.read(buf));
            case 7:
                FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat6 = FfiConverterTypeFerrySeat.INSTANCE;
                return new FerrySeatingGroupType.CornerTableLarge(ffiConverterTypeFerrySeat6.read(buf), ffiConverterTypeFerrySeat6.read(buf), ffiConverterTypeFerrySeat6.read(buf), ffiConverterTypeFerrySeat6.read(buf), ffiConverterTypeFerrySeat6.read(buf), ffiConverterTypeFerrySeat6.read(buf), ffiConverterTypeFerrySeat6.read(buf));
            default:
                throw new RuntimeException("invalid enum value, something is very wrong!!");
        }
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public void write(FerrySeatingGroupType value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (value instanceof FerrySeatingGroupType.SingleSeat) {
            buf.putInt(1);
            FfiConverterTypeFerrySeat.INSTANCE.write(((FerrySeatingGroupType.SingleSeat) value).getSeat(), buf);
        } else if (value instanceof FerrySeatingGroupType.DoubleSeat) {
            buf.putInt(2);
            FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat = FfiConverterTypeFerrySeat.INSTANCE;
            FerrySeatingGroupType.DoubleSeat doubleSeat = (FerrySeatingGroupType.DoubleSeat) value;
            ffiConverterTypeFerrySeat.write(doubleSeat.getLeft(), buf);
            ffiConverterTypeFerrySeat.write(doubleSeat.getRight(), buf);
        } else if (value instanceof FerrySeatingGroupType.SmallTable) {
            buf.putInt(3);
            FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat2 = FfiConverterTypeFerrySeat.INSTANCE;
            FerrySeatingGroupType.SmallTable smallTable = (FerrySeatingGroupType.SmallTable) value;
            ffiConverterTypeFerrySeat2.write(smallTable.getTop(), buf);
            ffiConverterTypeFerrySeat2.write(smallTable.getBottom(), buf);
        } else if (value instanceof FerrySeatingGroupType.LargeTable) {
            buf.putInt(4);
            FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat3 = FfiConverterTypeFerrySeat.INSTANCE;
            FerrySeatingGroupType.LargeTable largeTable = (FerrySeatingGroupType.LargeTable) value;
            ffiConverterTypeFerrySeat3.write(largeTable.getTopLeft(), buf);
            ffiConverterTypeFerrySeat3.write(largeTable.getTopRight(), buf);
            ffiConverterTypeFerrySeat3.write(largeTable.getBottomLeft(), buf);
            ffiConverterTypeFerrySeat3.write(largeTable.getBottomRight(), buf);
        } else if (value instanceof FerrySeatingGroupType.XLargeTable) {
            buf.putInt(5);
            FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat4 = FfiConverterTypeFerrySeat.INSTANCE;
            FerrySeatingGroupType.XLargeTable xLargeTable = (FerrySeatingGroupType.XLargeTable) value;
            ffiConverterTypeFerrySeat4.write(xLargeTable.getTopLeft(), buf);
            ffiConverterTypeFerrySeat4.write(xLargeTable.getTopMiddle(), buf);
            ffiConverterTypeFerrySeat4.write(xLargeTable.getTopRight(), buf);
            ffiConverterTypeFerrySeat4.write(xLargeTable.getBottomLeft(), buf);
            ffiConverterTypeFerrySeat4.write(xLargeTable.getBottomMiddle(), buf);
            ffiConverterTypeFerrySeat4.write(xLargeTable.getBottomRight(), buf);
        } else if (value instanceof FerrySeatingGroupType.CornerTable) {
            buf.putInt(6);
            FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat5 = FfiConverterTypeFerrySeat.INSTANCE;
            FerrySeatingGroupType.CornerTable cornerTable = (FerrySeatingGroupType.CornerTable) value;
            ffiConverterTypeFerrySeat5.write(cornerTable.getTopLeft(), buf);
            ffiConverterTypeFerrySeat5.write(cornerTable.getTopRight(), buf);
            ffiConverterTypeFerrySeat5.write(cornerTable.getMiddle(), buf);
            ffiConverterTypeFerrySeat5.write(cornerTable.getBottomLeft(), buf);
            ffiConverterTypeFerrySeat5.write(cornerTable.getBottomRight(), buf);
        } else {
            if (!(value instanceof FerrySeatingGroupType.CornerTableLarge)) {
                throw new NoWhenBranchMatchedException();
            }
            buf.putInt(7);
            FfiConverterTypeFerrySeat ffiConverterTypeFerrySeat6 = FfiConverterTypeFerrySeat.INSTANCE;
            FerrySeatingGroupType.CornerTableLarge cornerTableLarge = (FerrySeatingGroupType.CornerTableLarge) value;
            ffiConverterTypeFerrySeat6.write(cornerTableLarge.getTopLeft(), buf);
            ffiConverterTypeFerrySeat6.write(cornerTableLarge.getTopMiddle(), buf);
            ffiConverterTypeFerrySeat6.write(cornerTableLarge.getTopRight(), buf);
            ffiConverterTypeFerrySeat6.write(cornerTableLarge.getMiddle(), buf);
            ffiConverterTypeFerrySeat6.write(cornerTableLarge.getBottomLeft(), buf);
            ffiConverterTypeFerrySeat6.write(cornerTableLarge.getBottomMiddle(), buf);
            ffiConverterTypeFerrySeat6.write(cornerTableLarge.getBottomRight(), buf);
        }
        Unit unit = Unit.INSTANCE;
    }

    @Override // uniffi.molslinjen_shared.FfiConverterRustBuffer
    /* renamed from: lift */
    public FerrySeatingGroupType lift2(RustBuffer.ByValue byValue) {
        return (FerrySeatingGroupType) FfiConverterRustBuffer.DefaultImpls.lift(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverterRustBuffer, uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lower, reason: merged with bridge method [inline-methods] */
    public RustBuffer.ByValue lower2(FerrySeatingGroupType ferrySeatingGroupType) {
        return FfiConverterRustBuffer.DefaultImpls.lower(this, ferrySeatingGroupType);
    }
}
