package dk.molslinjen.api.services.geolocator.response;

import dk.molslinjen.api.services.geolocator.response.TravelModeDTO;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/geolocator/response/TravelTimeResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/geolocator/response/TravelTimeResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class TravelTimeResponseDTO$$serializer implements GeneratedSerializer<TravelTimeResponseDTO> {
    public static final TravelTimeResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        TravelTimeResponseDTO$$serializer travelTimeResponseDTO$$serializer = new TravelTimeResponseDTO$$serializer();
        INSTANCE = travelTimeResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.geolocator.response.TravelTimeResponseDTO", travelTimeResponseDTO$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("travelMode", false);
        pluginGeneratedSerialDescriptor.addElement("travelTimeMinutes", false);
        pluginGeneratedSerialDescriptor.addElement("travelTimeHours", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TravelTimeResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{TravelModeDTO.Serializer.INSTANCE, intSerializer, intSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final TravelTimeResponseDTO deserialize(Decoder decoder) {
        int i5;
        int i6;
        int i7;
        TravelModeDTO travelModeDTO;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            TravelModeDTO travelModeDTO2 = (TravelModeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, TravelModeDTO.Serializer.INSTANCE, null);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 1);
            travelModeDTO = travelModeDTO2;
            i5 = beginStructure.decodeIntElement(serialDescriptor, 2);
            i6 = decodeIntElement;
            i7 = 7;
        } else {
            boolean z5 = true;
            int i8 = 0;
            int i9 = 0;
            TravelModeDTO travelModeDTO3 = null;
            int i10 = 0;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    travelModeDTO3 = (TravelModeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, TravelModeDTO.Serializer.INSTANCE, travelModeDTO3);
                    i9 |= 1;
                } else if (decodeElementIndex == 1) {
                    i10 = beginStructure.decodeIntElement(serialDescriptor, 1);
                    i9 |= 2;
                } else {
                    if (decodeElementIndex != 2) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    i8 = beginStructure.decodeIntElement(serialDescriptor, 2);
                    i9 |= 4;
                }
            }
            i5 = i8;
            i6 = i10;
            i7 = i9;
            travelModeDTO = travelModeDTO3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new TravelTimeResponseDTO(i7, travelModeDTO, i6, i5, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, TravelTimeResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        TravelTimeResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
