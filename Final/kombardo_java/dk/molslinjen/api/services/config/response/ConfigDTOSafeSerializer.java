package dk.molslinjen.api.services.config.response;

import dk.molslinjen.api.helpers.serializers.SafeListSerializer;
import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.encoding.Decoder;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigDTOSafeSerializer;", "Ldk/molslinjen/api/helpers/serializers/SafeListSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$ConfigDTO;", "<init>", "()V", "itemSerializer", "Lkotlinx/serialization/KSerializer;", "getItemSerializer", "()Lkotlinx/serialization/KSerializer;", "deserialize", BuildConfig.FLAVOR, "decoder", "Lkotlinx/serialization/encoding/Decoder;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConfigDTOSafeSerializer extends SafeListSerializer<ConfigurationResponseDTO.ConfigDTO> {
    public static final ConfigDTOSafeSerializer INSTANCE = new ConfigDTOSafeSerializer();
    private static final KSerializer<ConfigurationResponseDTO.ConfigDTO> itemSerializer = ConfigurationResponseDTO.ConfigDTO.INSTANCE.serializer();

    private ConfigDTOSafeSerializer() {
    }

    @Override // dk.molslinjen.api.helpers.serializers.SafeListSerializer
    protected KSerializer<ConfigurationResponseDTO.ConfigDTO> getItemSerializer() {
        return itemSerializer;
    }

    @Override // dk.molslinjen.api.helpers.serializers.SafeListSerializer, kotlinx.serialization.DeserializationStrategy
    public List<ConfigurationResponseDTO.ConfigDTO> deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        List<ConfigurationResponseDTO.ConfigDTO> deserialize = super.deserialize(decoder);
        if (deserialize.isEmpty()) {
            throw new SerializationException("Could not deserialize any configs");
        }
        return deserialize;
    }
}
