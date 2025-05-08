package dk.molslinjen.api.helpers.serializers;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.Json;
import org.conscrypt.BuildConfig;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/api/helpers/serializers/DurationSerializer;", "Lkotlinx/serialization/KSerializer;", "Lorg/threeten/bp/Duration;", "<init>", "()V", "delegateSerializer", "Ldk/molslinjen/api/helpers/serializers/LocalTimeSerializer;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DurationSerializer implements KSerializer<Duration> {
    public static final DurationSerializer INSTANCE = new DurationSerializer();
    private static final LocalTimeSerializer delegateSerializer = LocalTimeSerializer.INSTANCE;
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("Custom" + Duration.class.getSimpleName(), PrimitiveKind.STRING.INSTANCE);

    private DurationSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Duration deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        List split$default = StringsKt.split$default((CharSequence) decoder.decodeString(), new String[]{"."}, false, 0, 6, (Object) null);
        Duration plusDays = Duration.between(LocalTime.MIN, (LocalTime) Json.INSTANCE.decodeFromString(delegateSerializer, "\"" + CollectionsKt.last((List<? extends Object>) split$default) + "\"")).plusDays(split$default.size() == 2 ? Long.parseLong((String) CollectionsKt.first(split$default)) : 0L);
        Intrinsics.checkNotNullExpressionValue(plusDays, "plusDays(...)");
        return plusDays;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Duration value) {
        String str;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.toDays() > 0) {
            str = value.toDays() + ".";
        } else {
            str = BuildConfig.FLAVOR;
        }
        encoder.encodeString(str + StringsKt.trim(Json.INSTANCE.encodeToString(delegateSerializer, LocalTime.MIN.plus(value)), '\"'));
    }
}
