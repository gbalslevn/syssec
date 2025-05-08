package dk.molslinjen.api.services.booking.response.booking;

import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
import dk.molslinjen.api.services.booking.response.booking.FerryTypeDTO;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/response/booking/FerryResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class FerryResponseDTO$$serializer implements GeneratedSerializer<FerryResponseDTO> {
    public static final FerryResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        FerryResponseDTO$$serializer ferryResponseDTO$$serializer = new FerryResponseDTO$$serializer();
        INSTANCE = ferryResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.response.booking.FerryResponseDTO", ferryResponseDTO$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("ferryId", false);
        pluginGeneratedSerialDescriptor.addElement("arrivalTime", false);
        pluginGeneratedSerialDescriptor.addElement("departureTime", false);
        pluginGeneratedSerialDescriptor.addElement("departureHarbor", false);
        pluginGeneratedSerialDescriptor.addElement("arrivalHarbor", false);
        pluginGeneratedSerialDescriptor.addElement("ferryName", false);
        pluginGeneratedSerialDescriptor.addElement("ferryType", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private FerryResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
        LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
        return new KSerializer[]{nullable, BuiltinSerializersKt.getNullable(localTimeSerializer), BuiltinSerializersKt.getNullable(localTimeSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(FerryTypeDTO.Serializer.INSTANCE)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x006e. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final FerryResponseDTO deserialize(Decoder decoder) {
        int i5;
        FerryTypeDTO ferryTypeDTO;
        String str;
        LocalTime localTime;
        LocalTime localTime2;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i6 = 6;
        String str5 = null;
        if (beginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
            LocalTime localTime3 = (LocalTime) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, localTimeSerializer, null);
            LocalTime localTime4 = (LocalTime) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, localTimeSerializer, null);
            String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            ferryTypeDTO = (FerryTypeDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, FerryTypeDTO.Serializer.INSTANCE, null);
            i5 = 127;
            str2 = str7;
            str3 = str8;
            localTime2 = localTime4;
            localTime = localTime3;
            str = str6;
        } else {
            boolean z5 = true;
            int i7 = 0;
            FerryTypeDTO ferryTypeDTO2 = null;
            LocalTime localTime5 = null;
            LocalTime localTime6 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        i6 = 6;
                    case 0:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str5);
                        i7 |= 1;
                        i6 = 6;
                    case 1:
                        localTime5 = (LocalTime) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LocalTimeSerializer.INSTANCE, localTime5);
                        i7 |= 2;
                        i6 = 6;
                    case 2:
                        localTime6 = (LocalTime) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, LocalTimeSerializer.INSTANCE, localTime6);
                        i7 |= 4;
                    case 3:
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str9);
                        i7 |= 8;
                    case 4:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str10);
                        i7 |= 16;
                    case 5:
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str11);
                        i7 |= 32;
                    case 6:
                        ferryTypeDTO2 = (FerryTypeDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, i6, FerryTypeDTO.Serializer.INSTANCE, ferryTypeDTO2);
                        i7 |= 64;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i7;
            ferryTypeDTO = ferryTypeDTO2;
            str = str5;
            localTime = localTime5;
            localTime2 = localTime6;
            str2 = str9;
            str3 = str10;
            str4 = str11;
        }
        beginStructure.endStructure(serialDescriptor);
        return new FerryResponseDTO(i5, str, localTime, localTime2, str2, str3, str4, ferryTypeDTO, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, FerryResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        FerryResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
