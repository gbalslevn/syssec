package uniffi.molslinjen_shared;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.UCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FfiConverterRustBuffer;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Luniffi/molslinjen_shared/FfiConverterSequenceTypeFerrySeatingGroup;", "Luniffi/molslinjen_shared/FfiConverterRustBuffer;", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatingGroup;", "()V", "allocationSize", "Lkotlin/ULong;", "value", "allocationSize-I7RO_PI", "(Ljava/util/List;)J", "read", "buf", "Ljava/nio/ByteBuffer;", "write", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FfiConverterSequenceTypeFerrySeatingGroup implements FfiConverterRustBuffer<List<? extends FerrySeatingGroup>> {
    public static final FfiConverterSequenceTypeFerrySeatingGroup INSTANCE = new FfiConverterSequenceTypeFerrySeatingGroup();

    private FfiConverterSequenceTypeFerrySeatingGroup() {
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: allocationSize-I7RO_PI, reason: not valid java name and merged with bridge method [inline-methods] */
    public long mo3834allocationSizeI7RO_PI(List<FerrySeatingGroup> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        List<FerrySeatingGroup> list = value;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ULong.m3621boximpl(FfiConverterTypeFerrySeatingGroup.INSTANCE.mo3834allocationSizeI7RO_PI((FerrySeatingGroup) it.next())));
        }
        return ULong.m3622constructorimpl(4 + UCollectionsKt.sumOfULong(arrayList));
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public List<FerrySeatingGroup> liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return (List) FfiConverterRustBuffer.DefaultImpls.liftFromRustBuffer(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public RustBuffer.ByValue lowerIntoRustBuffer(List<FerrySeatingGroup> list) {
        return FfiConverterRustBuffer.DefaultImpls.lowerIntoRustBuffer(this, list);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public List<FerrySeatingGroup> read(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        int i5 = buf.getInt();
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            arrayList.add(FfiConverterTypeFerrySeatingGroup.INSTANCE.read(buf));
        }
        return arrayList;
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public void write(List<FerrySeatingGroup> value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.putInt(value.size());
        Iterator<FerrySeatingGroup> it = value.iterator();
        while (it.hasNext()) {
            FfiConverterTypeFerrySeatingGroup.INSTANCE.write(it.next(), buf);
        }
    }

    @Override // uniffi.molslinjen_shared.FfiConverterRustBuffer
    /* renamed from: lift */
    public List<? extends FerrySeatingGroup> lift2(RustBuffer.ByValue byValue) {
        return (List) FfiConverterRustBuffer.DefaultImpls.lift(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverterRustBuffer, uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lower, reason: merged with bridge method [inline-methods] */
    public RustBuffer.ByValue lower2(List<FerrySeatingGroup> list) {
        return FfiConverterRustBuffer.DefaultImpls.lower(this, list);
    }
}
