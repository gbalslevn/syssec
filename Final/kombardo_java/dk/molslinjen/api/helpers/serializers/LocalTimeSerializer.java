package dk.molslinjen.api.helpers.serializers;

import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalTime;
import org.threeten.bp.format.DateTimeFormatter;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/api/helpers/serializers/LocalTimeSerializer;", "Lkotlinx/serialization/KSerializer;", "Lorg/threeten/bp/LocalTime;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalTimeSerializer implements KSerializer<LocalTime> {
    public static final LocalTimeSerializer INSTANCE = new LocalTimeSerializer();
    private static final SerialDescriptor descriptor;

    static {
        String simpleName = LocalTime.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor(simpleName, PrimitiveKind.STRING.INSTANCE);
    }

    private LocalTimeSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public LocalTime deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        String decodeString = decoder.decodeString();
        if (StringsKt.startsWith$default(decodeString, "-", false, 2, (Object) null)) {
            Logger.INSTANCE.logCritical(new CriticalLog("Invalid time format " + decodeString));
        }
        LocalTime parse = LocalTime.parse(StringsKt.trimStart(decodeString, '-'), DateTimeFormatter.ISO_LOCAL_TIME);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        return parse;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, LocalTime value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        String format = DateTimeFormatter.ISO_LOCAL_TIME.format(value);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        encoder.encodeString(format);
    }
}
