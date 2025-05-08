package dk.molslinjen.api.services.saleOnBoard.response;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.serializers.LocalDateTimeRetailItsSerializer;
import dk.molslinjen.api.services.saleOnBoard.response.TimeSlotsResponseDTO;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO.TimeSlotResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO$TimeSlotResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class TimeSlotsResponseDTO$TimeSlotResponseDTO$$serializer implements GeneratedSerializer<TimeSlotsResponseDTO.TimeSlotResponseDTO> {
    public static final TimeSlotsResponseDTO$TimeSlotResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        TimeSlotsResponseDTO$TimeSlotResponseDTO$$serializer timeSlotsResponseDTO$TimeSlotResponseDTO$$serializer = new TimeSlotsResponseDTO$TimeSlotResponseDTO$$serializer();
        INSTANCE = timeSlotsResponseDTO$TimeSlotResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.saleOnBoard.response.TimeSlotsResponseDTO.TimeSlotResponseDTO", timeSlotsResponseDTO$TimeSlotResponseDTO$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("endDateTime", false);
        pluginGeneratedSerialDescriptor.addElement("fullyBooked", false);
        pluginGeneratedSerialDescriptor.addElement("occupancyRate", false);
        pluginGeneratedSerialDescriptor.addElement("startDateTime", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TimeSlotsResponseDTO$TimeSlotResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        LocalDateTimeRetailItsSerializer localDateTimeRetailItsSerializer = LocalDateTimeRetailItsSerializer.INSTANCE;
        return new KSerializer[]{intSerializer, localDateTimeRetailItsSerializer, BooleanSerializer.INSTANCE, intSerializer, localDateTimeRetailItsSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final TimeSlotsResponseDTO.TimeSlotResponseDTO deserialize(Decoder decoder) {
        int i5;
        int i6;
        boolean z5;
        int i7;
        LocalDateTime localDateTime;
        LocalDateTime localDateTime2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            LocalDateTimeRetailItsSerializer localDateTimeRetailItsSerializer = LocalDateTimeRetailItsSerializer.INSTANCE;
            LocalDateTime localDateTime3 = (LocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 1, localDateTimeRetailItsSerializer, null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 2);
            i5 = decodeIntElement;
            i6 = beginStructure.decodeIntElement(serialDescriptor, 3);
            localDateTime2 = (LocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 4, localDateTimeRetailItsSerializer, null);
            z5 = decodeBooleanElement;
            localDateTime = localDateTime3;
            i7 = 31;
        } else {
            boolean z6 = true;
            int i8 = 0;
            boolean z7 = false;
            int i9 = 0;
            LocalDateTime localDateTime4 = null;
            LocalDateTime localDateTime5 = null;
            int i10 = 0;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z6 = false;
                } else if (decodeElementIndex == 0) {
                    i8 = beginStructure.decodeIntElement(serialDescriptor, 0);
                    i9 |= 1;
                } else if (decodeElementIndex == 1) {
                    localDateTime4 = (LocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalDateTimeRetailItsSerializer.INSTANCE, localDateTime4);
                    i9 |= 2;
                } else if (decodeElementIndex == 2) {
                    z7 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                    i9 |= 4;
                } else if (decodeElementIndex == 3) {
                    i10 = beginStructure.decodeIntElement(serialDescriptor, 3);
                    i9 |= 8;
                } else {
                    if (decodeElementIndex != 4) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    localDateTime5 = (LocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 4, LocalDateTimeRetailItsSerializer.INSTANCE, localDateTime5);
                    i9 |= 16;
                }
            }
            i5 = i8;
            i6 = i10;
            z5 = z7;
            i7 = i9;
            localDateTime = localDateTime4;
            localDateTime2 = localDateTime5;
        }
        beginStructure.endStructure(serialDescriptor);
        return new TimeSlotsResponseDTO.TimeSlotResponseDTO(i7, i5, localDateTime, z5, i6, localDateTime2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, TimeSlotsResponseDTO.TimeSlotResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        TimeSlotsResponseDTO.TimeSlotResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
