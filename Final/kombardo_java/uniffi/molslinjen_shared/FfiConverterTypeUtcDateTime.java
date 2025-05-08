package uniffi.molslinjen_shared;

import com.adjust.sdk.Constants;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import uniffi.molslinjen_shared.FfiConverter;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u000b\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0019\u0010\f\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\n\u0010\b\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Luniffi/molslinjen_shared/FfiConverterTypeUtcDateTime;", "Luniffi/molslinjen_shared/FfiConverter;", "Lorg/threeten/bp/LocalDateTime;", "Luniffi/molslinjen_shared/UtcDateTime;", BuildConfig.FLAVOR, "()V", "allocationSize", "Lkotlin/ULong;", "value", "allocationSize-I7RO_PI", "(Lorg/threeten/bp/LocalDateTime;)J", "lift", "lower", "(Lorg/threeten/bp/LocalDateTime;)Ljava/lang/Long;", "read", "buf", "Ljava/nio/ByteBuffer;", "write", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FfiConverterTypeUtcDateTime implements FfiConverter<LocalDateTime, Long> {
    public static final FfiConverterTypeUtcDateTime INSTANCE = new FfiConverterTypeUtcDateTime();

    private FfiConverterTypeUtcDateTime() {
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lift */
    public /* bridge */ /* synthetic */ LocalDateTime lift2(Long l5) {
        return lift(l5.longValue());
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: allocationSize-I7RO_PI, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public long mo3834allocationSizeI7RO_PI(LocalDateTime value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return FfiConverterLong.INSTANCE.m3838allocationSizeI7RO_PI(value.toInstant(ZoneOffset.UTC).toEpochMilli());
    }

    public LocalDateTime lift(long value) {
        long longValue = FfiConverterLong.INSTANCE.lift(value).longValue();
        long j5 = Constants.ONE_SECOND;
        LocalDateTime ofEpochSecond = LocalDateTime.ofEpochSecond(longValue / j5, (int) (j5 * (longValue % j5)), ZoneOffset.UTC);
        Intrinsics.checkNotNullExpressionValue(ofEpochSecond, "ofEpochSecond(...)");
        return ofEpochSecond;
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public LocalDateTime liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return (LocalDateTime) FfiConverter.DefaultImpls.liftFromRustBuffer(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lower, reason: avoid collision after fix types in other method */
    public Long lower2(LocalDateTime value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return FfiConverterLong.INSTANCE.lower(value.toInstant(ZoneOffset.UTC).toEpochMilli());
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public RustBuffer.ByValue lowerIntoRustBuffer(LocalDateTime localDateTime) {
        return FfiConverter.DefaultImpls.lowerIntoRustBuffer(this, localDateTime);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public LocalDateTime read(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        long longValue = FfiConverterLong.INSTANCE.read(buf).longValue();
        long j5 = Constants.ONE_SECOND;
        LocalDateTime ofEpochSecond = LocalDateTime.ofEpochSecond(longValue / j5, (int) (j5 * (longValue % j5)), ZoneOffset.UTC);
        Intrinsics.checkNotNullExpressionValue(ofEpochSecond, "ofEpochSecond(...)");
        return ofEpochSecond;
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public void write(LocalDateTime value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(buf, "buf");
        FfiConverterLong.INSTANCE.write(value.toInstant(ZoneOffset.UTC).toEpochMilli(), buf);
    }
}
