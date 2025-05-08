package uniffi.molslinjen_shared;

import java.nio.ByteBuffer;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FfiConverter;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u000b\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0014\u0010\f\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u0014\u0010\r\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\b\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Luniffi/molslinjen_shared/FfiConverterTypeUuid;", "Luniffi/molslinjen_shared/FfiConverter;", "Ljava/util/UUID;", "Luniffi/molslinjen_shared/Uuid;", "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "()V", "allocationSize", "Lkotlin/ULong;", "value", "allocationSize-I7RO_PI", "(Ljava/util/UUID;)J", "lift", "lower", "read", "buf", "Ljava/nio/ByteBuffer;", "write", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FfiConverterTypeUuid implements FfiConverter<UUID, RustBuffer.ByValue> {
    public static final FfiConverterTypeUuid INSTANCE = new FfiConverterTypeUuid();

    private FfiConverterTypeUuid() {
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: allocationSize-I7RO_PI, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public long mo3834allocationSizeI7RO_PI(UUID value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String uuid = value.toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        return FfiConverterString.INSTANCE.mo3834allocationSizeI7RO_PI(uuid);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lift, reason: avoid collision after fix types in other method */
    public UUID lift2(RustBuffer.ByValue value) {
        Intrinsics.checkNotNullParameter(value, "value");
        UUID fromString = UUID.fromString(FfiConverterString.INSTANCE.lift2(value));
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(...)");
        return fromString;
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public UUID liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return (UUID) FfiConverter.DefaultImpls.liftFromRustBuffer(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lower, reason: avoid collision after fix types in other method */
    public RustBuffer.ByValue lower2(UUID value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String uuid = value.toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        return FfiConverterString.INSTANCE.lower2(uuid);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public RustBuffer.ByValue lowerIntoRustBuffer(UUID uuid) {
        return FfiConverter.DefaultImpls.lowerIntoRustBuffer(this, uuid);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public UUID read(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        UUID fromString = UUID.fromString(FfiConverterString.INSTANCE.read(buf));
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(...)");
        return fromString;
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public void write(UUID value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(buf, "buf");
        String uuid = value.toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        FfiConverterString.INSTANCE.write(uuid, buf);
    }
}
