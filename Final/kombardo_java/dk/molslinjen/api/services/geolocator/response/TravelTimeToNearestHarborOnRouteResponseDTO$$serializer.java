package dk.molslinjen.api.services.geolocator.response;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborOnRouteResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborOnRouteResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class TravelTimeToNearestHarborOnRouteResponseDTO$$serializer implements GeneratedSerializer<TravelTimeToNearestHarborOnRouteResponseDTO> {
    public static final TravelTimeToNearestHarborOnRouteResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        TravelTimeToNearestHarborOnRouteResponseDTO$$serializer travelTimeToNearestHarborOnRouteResponseDTO$$serializer = new TravelTimeToNearestHarborOnRouteResponseDTO$$serializer();
        INSTANCE = travelTimeToNearestHarborOnRouteResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.geolocator.response.TravelTimeToNearestHarborOnRouteResponseDTO", travelTimeToNearestHarborOnRouteResponseDTO$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("address", false);
        pluginGeneratedSerialDescriptor.addElement("city", false);
        pluginGeneratedSerialDescriptor.addElement("harborName", false);
        pluginGeneratedSerialDescriptor.addElement("lineName", false);
        pluginGeneratedSerialDescriptor.addElement("travelTimeMinutes", false);
        pluginGeneratedSerialDescriptor.addElement("travelTimeHours", false);
        pluginGeneratedSerialDescriptor.addElement("harborCoordinates", false);
        pluginGeneratedSerialDescriptor.addElement("isWithinTravelRange", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TravelTimeToNearestHarborOnRouteResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(HarborCoordinatesResponseDTO$$serializer.INSTANCE);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, intSerializer, intSerializer, nullable, BooleanSerializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x006a. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final TravelTimeToNearestHarborOnRouteResponseDTO deserialize(Decoder decoder) {
        boolean z5;
        HarborCoordinatesResponseDTO harborCoordinatesResponseDTO;
        int i5;
        int i6;
        int i7;
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 3);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 4);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 5);
            HarborCoordinatesResponseDTO harborCoordinatesResponseDTO2 = (HarborCoordinatesResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, HarborCoordinatesResponseDTO$$serializer.INSTANCE, null);
            str = decodeStringElement;
            z5 = beginStructure.decodeBooleanElement(serialDescriptor, 7);
            harborCoordinatesResponseDTO = harborCoordinatesResponseDTO2;
            i5 = decodeIntElement2;
            str4 = decodeStringElement4;
            i6 = decodeIntElement;
            str3 = decodeStringElement3;
            str2 = decodeStringElement2;
            i7 = 255;
        } else {
            boolean z6 = true;
            boolean z7 = false;
            int i8 = 0;
            int i9 = 0;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            HarborCoordinatesResponseDTO harborCoordinatesResponseDTO3 = null;
            int i10 = 0;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z6 = false;
                    case 0:
                        i9 |= 1;
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 0);
                    case 1:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i9 |= 2;
                    case 2:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i9 |= 4;
                    case 3:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i9 |= 8;
                    case 4:
                        i8 = beginStructure.decodeIntElement(serialDescriptor, 4);
                        i9 |= 16;
                    case 5:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 5);
                        i9 |= 32;
                    case 6:
                        harborCoordinatesResponseDTO3 = (HarborCoordinatesResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, HarborCoordinatesResponseDTO$$serializer.INSTANCE, harborCoordinatesResponseDTO3);
                        i9 |= 64;
                    case 7:
                        z7 = beginStructure.decodeBooleanElement(serialDescriptor, 7);
                        i9 |= 128;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z5 = z7;
            harborCoordinatesResponseDTO = harborCoordinatesResponseDTO3;
            i5 = i10;
            i6 = i8;
            i7 = i9;
            str = str5;
            str2 = str6;
            str3 = str7;
            str4 = str8;
        }
        beginStructure.endStructure(serialDescriptor);
        return new TravelTimeToNearestHarborOnRouteResponseDTO(i7, str, str2, str3, str4, i6, i5, harborCoordinatesResponseDTO, z5, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, TravelTimeToNearestHarborOnRouteResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        TravelTimeToNearestHarborOnRouteResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
