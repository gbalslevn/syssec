package dk.molslinjen.api.services.multiRide.response;

import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import java.util.List;
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
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/multiRide/response/AccountMultiRideResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/multiRide/response/AccountMultiRideResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class AccountMultiRideResponseDTO$$serializer implements GeneratedSerializer<AccountMultiRideResponseDTO> {
    public static final AccountMultiRideResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        AccountMultiRideResponseDTO$$serializer accountMultiRideResponseDTO$$serializer = new AccountMultiRideResponseDTO$$serializer();
        INSTANCE = accountMultiRideResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.multiRide.response.AccountMultiRideResponseDTO", accountMultiRideResponseDTO$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement("agreementNumber", false);
        pluginGeneratedSerialDescriptor.addElement("agreementType", false);
        pluginGeneratedSerialDescriptor.addElement("multiRideTypeId", false);
        pluginGeneratedSerialDescriptor.addElement("ticketTypeName", false);
        pluginGeneratedSerialDescriptor.addElement("ticketTypeId", false);
        pluginGeneratedSerialDescriptor.addElement("enabledTransports", false);
        pluginGeneratedSerialDescriptor.addElement("defaultTransport", false);
        pluginGeneratedSerialDescriptor.addElement("remainingTrips", false);
        pluginGeneratedSerialDescriptor.addElement("canRefill", false);
        pluginGeneratedSerialDescriptor.addElement("customer", false);
        pluginGeneratedSerialDescriptor.addElement("allowedRoundtripRouteIds", false);
        pluginGeneratedSerialDescriptor.addElement("validUntil", false);
        pluginGeneratedSerialDescriptor.addElement("ticketExpiration", false);
        pluginGeneratedSerialDescriptor.addElement("ticketExpiringCount", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AccountMultiRideResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = AccountMultiRideResponseDTO.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[5];
        KSerializer<?> kSerializer2 = kSerializerArr[10];
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(DurationSerializer.INSTANCE);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, kSerializer, MultiRideTransportDTO$$serializer.INSTANCE, intSerializer, BooleanSerializer.INSTANCE, stringSerializer, kSerializer2, LocalDateWithTimeSerializer.INSTANCE, nullable, intSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00bc. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final AccountMultiRideResponseDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        MultiRideTransportDTO multiRideTransportDTO;
        List list;
        String str;
        LocalDate localDate;
        Duration duration;
        List list2;
        int i5;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i6;
        int i7;
        boolean z5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = AccountMultiRideResponseDTO.$childSerializers;
        String str7 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 3);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 4);
            List list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
            MultiRideTransportDTO multiRideTransportDTO2 = (MultiRideTransportDTO) beginStructure.decodeSerializableElement(serialDescriptor, 6, MultiRideTransportDTO$$serializer.INSTANCE, null);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 7);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 8);
            String decodeStringElement6 = beginStructure.decodeStringElement(serialDescriptor, 9);
            List list4 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 10, kSerializerArr[10], null);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 11, LocalDateWithTimeSerializer.INSTANCE, null);
            duration = (Duration) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, DurationSerializer.INSTANCE, null);
            str = decodeStringElement;
            str2 = decodeStringElement2;
            str3 = decodeStringElement3;
            i6 = beginStructure.decodeIntElement(serialDescriptor, 13);
            str6 = decodeStringElement6;
            i7 = decodeIntElement;
            multiRideTransportDTO = multiRideTransportDTO2;
            str4 = decodeStringElement4;
            z5 = decodeBooleanElement;
            str5 = decodeStringElement5;
            list = list3;
            localDate = localDate2;
            i5 = 16383;
            list2 = list4;
        } else {
            int i8 = 13;
            boolean z6 = true;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            boolean z7 = false;
            MultiRideTransportDTO multiRideTransportDTO3 = null;
            List list5 = null;
            LocalDate localDate3 = null;
            Duration duration2 = null;
            List list6 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z6 = false;
                        i8 = 13;
                    case 0:
                        i9 |= 1;
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i8 = 13;
                    case 1:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i9 |= 2;
                        i8 = 13;
                    case 2:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i9 |= 4;
                        i8 = 13;
                    case 3:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i9 |= 8;
                        i8 = 13;
                    case 4:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i9 |= 16;
                        i8 = 13;
                    case 5:
                        list5 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], list5);
                        i9 |= 32;
                        i8 = 13;
                    case 6:
                        multiRideTransportDTO3 = (MultiRideTransportDTO) beginStructure.decodeSerializableElement(serialDescriptor, 6, MultiRideTransportDTO$$serializer.INSTANCE, multiRideTransportDTO3);
                        i9 |= 64;
                        i8 = 13;
                    case 7:
                        i11 = beginStructure.decodeIntElement(serialDescriptor, 7);
                        i9 |= 128;
                        i8 = 13;
                    case 8:
                        z7 = beginStructure.decodeBooleanElement(serialDescriptor, 8);
                        i9 |= 256;
                        i8 = 13;
                    case 9:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 9);
                        i9 |= 512;
                        i8 = 13;
                    case 10:
                        list6 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 10, kSerializerArr[10], list6);
                        i9 |= 1024;
                        i8 = 13;
                    case 11:
                        localDate3 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 11, LocalDateWithTimeSerializer.INSTANCE, localDate3);
                        i9 |= 2048;
                        i8 = 13;
                    case 12:
                        duration2 = (Duration) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, DurationSerializer.INSTANCE, duration2);
                        i9 |= 4096;
                        i8 = 13;
                    case 13:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, i8);
                        i9 |= 8192;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            multiRideTransportDTO = multiRideTransportDTO3;
            list = list5;
            str = str7;
            localDate = localDate3;
            duration = duration2;
            list2 = list6;
            i5 = i9;
            str2 = str8;
            str3 = str9;
            str4 = str10;
            str5 = str11;
            str6 = str12;
            i6 = i10;
            i7 = i11;
            z5 = z7;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AccountMultiRideResponseDTO(i5, str, str2, str3, str4, str5, list, multiRideTransportDTO, i7, z5, str6, list2, localDate, duration, i6, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, AccountMultiRideResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AccountMultiRideResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
