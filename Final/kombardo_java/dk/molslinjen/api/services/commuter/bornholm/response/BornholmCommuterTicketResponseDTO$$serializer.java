package dk.molslinjen.api.services.commuter.bornholm.response;

import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterTicketResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterTicketResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BornholmCommuterTicketResponseDTO$$serializer implements GeneratedSerializer<BornholmCommuterTicketResponseDTO> {
    public static final BornholmCommuterTicketResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BornholmCommuterTicketResponseDTO$$serializer bornholmCommuterTicketResponseDTO$$serializer = new BornholmCommuterTicketResponseDTO$$serializer();
        INSTANCE = bornholmCommuterTicketResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterTicketResponseDTO", bornholmCommuterTicketResponseDTO$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("route", false);
        pluginGeneratedSerialDescriptor.addElement("date", false);
        pluginGeneratedSerialDescriptor.addElement("time", false);
        pluginGeneratedSerialDescriptor.addElement("arrivalTime", false);
        pluginGeneratedSerialDescriptor.addElement("crossingTime", false);
        pluginGeneratedSerialDescriptor.addElement("ferryName", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BornholmCommuterTicketResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, LocalDateWithTimeSerializer.INSTANCE, localTimeSerializer, localTimeSerializer, DurationSerializer.INSTANCE, stringSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x005f. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final BornholmCommuterTicketResponseDTO deserialize(Decoder decoder) {
        int i5;
        String str;
        LocalDate localDate;
        LocalTime localTime;
        LocalTime localTime2;
        Duration duration;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        String str3 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalDateWithTimeSerializer.INSTANCE, null);
            LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
            LocalTime localTime3 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 2, localTimeSerializer, null);
            LocalTime localTime4 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 3, localTimeSerializer, null);
            Duration duration2 = (Duration) beginStructure.decodeSerializableElement(serialDescriptor, 4, DurationSerializer.INSTANCE, null);
            str = decodeStringElement;
            str2 = beginStructure.decodeStringElement(serialDescriptor, 5);
            localTime2 = localTime4;
            duration = duration2;
            localTime = localTime3;
            localDate = localDate2;
            i5 = 63;
        } else {
            boolean z5 = true;
            int i6 = 0;
            LocalDate localDate3 = null;
            LocalTime localTime5 = null;
            LocalTime localTime6 = null;
            Duration duration3 = null;
            String str4 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                    case 0:
                        str3 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i6 |= 1;
                    case 1:
                        localDate3 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalDateWithTimeSerializer.INSTANCE, localDate3);
                        i6 |= 2;
                    case 2:
                        localTime5 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 2, LocalTimeSerializer.INSTANCE, localTime5);
                        i6 |= 4;
                    case 3:
                        localTime6 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 3, LocalTimeSerializer.INSTANCE, localTime6);
                        i6 |= 8;
                    case 4:
                        duration3 = (Duration) beginStructure.decodeSerializableElement(serialDescriptor, 4, DurationSerializer.INSTANCE, duration3);
                        i6 |= 16;
                    case 5:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i6 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i6;
            str = str3;
            localDate = localDate3;
            localTime = localTime5;
            localTime2 = localTime6;
            duration = duration3;
            str2 = str4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BornholmCommuterTicketResponseDTO(i5, str, localDate, localTime, localTime2, duration, str2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BornholmCommuterTicketResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BornholmCommuterTicketResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
