package dk.molslinjen.api.helpers.serializers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.DateTimeFormatter;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/api/helpers/serializers/LocalDateTimeRetailItsSerializer;", "Lkotlinx/serialization/KSerializer;", "Lorg/threeten/bp/LocalDateTime;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "formatter", "Lorg/threeten/bp/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "Lorg/threeten/bp/format/DateTimeFormatter;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalDateTimeRetailItsSerializer implements KSerializer<LocalDateTime> {
    public static final LocalDateTimeRetailItsSerializer INSTANCE = new LocalDateTimeRetailItsSerializer();
    private static final SerialDescriptor descriptor;
    private static final DateTimeFormatter formatter;

    static {
        String simpleName = LocalDate.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor(simpleName, PrimitiveKind.STRING.INSTANCE);
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'");
    }

    private LocalDateTimeRetailItsSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [org.threeten.bp.ZonedDateTime] */
    /* JADX WARN: Type inference failed for: r2v5, types: [org.threeten.bp.LocalDateTime, java.lang.Object] */
    @Override // kotlinx.serialization.DeserializationStrategy
    public LocalDateTime deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        ?? localDateTime2 = LocalDateTime.parse(decoder.decodeString(), formatter).atZone2(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime2();
        Intrinsics.checkNotNullExpressionValue(localDateTime2, "toLocalDateTime(...)");
        return localDateTime2;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, LocalDateTime value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        String format = formatter.format(value);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        encoder.encodeString(format);
    }
}
