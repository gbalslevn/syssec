package uniffi.molslinjen_shared;

import com.sun.jna.Pointer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FfiConverter;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Luniffi/molslinjen_shared/FfiConverterTypeRustLoggerTrait;", "Luniffi/molslinjen_shared/FfiConverter;", "Luniffi/molslinjen_shared/RustLoggerTrait;", "Lcom/sun/jna/Pointer;", "()V", "handleMap", "Luniffi/molslinjen_shared/UniffiHandleMap;", "getHandleMap$shared_release", "()Luniffi/molslinjen_shared/UniffiHandleMap;", "allocationSize", "Lkotlin/ULong;", "value", "allocationSize-I7RO_PI", "(Luniffi/molslinjen_shared/RustLoggerTrait;)J", "lift", "lower", "read", "buf", "Ljava/nio/ByteBuffer;", "write", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FfiConverterTypeRustLoggerTrait implements FfiConverter<RustLoggerTrait, Pointer> {
    public static final FfiConverterTypeRustLoggerTrait INSTANCE = new FfiConverterTypeRustLoggerTrait();
    private static final UniffiHandleMap<RustLoggerTrait> handleMap = new UniffiHandleMap<>();

    private FfiConverterTypeRustLoggerTrait() {
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: allocationSize-I7RO_PI, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public long mo3834allocationSizeI7RO_PI(RustLoggerTrait value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return 8L;
    }

    public final UniffiHandleMap<RustLoggerTrait> getHandleMap$shared_release() {
        return handleMap;
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lift, reason: avoid collision after fix types in other method */
    public RustLoggerTrait lift2(Pointer value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new RustLoggerTraitImpl(value);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public RustLoggerTrait liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return (RustLoggerTrait) FfiConverter.DefaultImpls.liftFromRustBuffer(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lower, reason: avoid collision after fix types in other method */
    public Pointer lower2(RustLoggerTrait value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new Pointer(handleMap.insert(value));
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public RustBuffer.ByValue lowerIntoRustBuffer(RustLoggerTrait rustLoggerTrait) {
        return FfiConverter.DefaultImpls.lowerIntoRustBuffer(this, rustLoggerTrait);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public RustLoggerTrait read(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        return lift2(new Pointer(buf.getLong()));
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public void write(RustLoggerTrait value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.putLong(Pointer.nativeValue(lower2(value)));
    }
}
