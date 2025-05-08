package dk.molslinjen.api.services.commuter.bornholm.response;

import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import dk.molslinjen.domain.model.constants.Constants;
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
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterAgreementResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterAgreementResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BornholmCommuterAgreementResponseDTO$$serializer implements GeneratedSerializer<BornholmCommuterAgreementResponseDTO> {
    public static final BornholmCommuterAgreementResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BornholmCommuterAgreementResponseDTO$$serializer bornholmCommuterAgreementResponseDTO$$serializer = new BornholmCommuterAgreementResponseDTO$$serializer();
        INSTANCE = bornholmCommuterAgreementResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterAgreementResponseDTO", bornholmCommuterAgreementResponseDTO$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("activeTickets", false);
        pluginGeneratedSerialDescriptor.addElement("validToDate", false);
        pluginGeneratedSerialDescriptor.addElement("commuteAgreementId", false);
        pluginGeneratedSerialDescriptor.addElement("deleteTicketsAllowed", false);
        pluginGeneratedSerialDescriptor.addElement("allowedRoundtripRouteIds", false);
        pluginGeneratedSerialDescriptor.addElement("isApproved", false);
        pluginGeneratedSerialDescriptor.addElement("noOfPersons", false);
        pluginGeneratedSerialDescriptor.addElement("text", false);
        pluginGeneratedSerialDescriptor.addElement(Constants.IntentExtra.PushTitle, false);
        pluginGeneratedSerialDescriptor.addElement("transportType", false);
        pluginGeneratedSerialDescriptor.addElement("currency", false);
        pluginGeneratedSerialDescriptor.addElement("lineName", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BornholmCommuterAgreementResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = BornholmCommuterAgreementResponseDTO.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[0];
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(LocalDateWithTimeSerializer.INSTANCE);
        KSerializer<?> kSerializer2 = kSerializerArr[4];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{kSerializer, nullable, stringSerializer, booleanSerializer, kSerializer2, booleanSerializer, IntSerializer.INSTANCE, stringSerializer, stringSerializer, stringSerializer, CurrencyTypeDTO.Serializer.INSTANCE, stringSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00a5. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final BornholmCommuterAgreementResponseDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        List list;
        int i5;
        CurrencyTypeDTO currencyTypeDTO;
        List list2;
        LocalDate localDate;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i6;
        boolean z5;
        boolean z6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = BornholmCommuterAgreementResponseDTO.$childSerializers;
        int i7 = 10;
        List list3 = null;
        if (beginStructure.decodeSequentially()) {
            List list4 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LocalDateWithTimeSerializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 2);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 3);
            List list5 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 5);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 6);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 7);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 8);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 9);
            list2 = list5;
            list = list4;
            currencyTypeDTO = (CurrencyTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 10, CurrencyTypeDTO.Serializer.INSTANCE, null);
            str5 = beginStructure.decodeStringElement(serialDescriptor, 11);
            str4 = decodeStringElement4;
            str2 = decodeStringElement2;
            i6 = decodeIntElement;
            z5 = decodeBooleanElement2;
            z6 = decodeBooleanElement;
            str3 = decodeStringElement3;
            str = decodeStringElement;
            i5 = 4095;
            localDate = localDate2;
        } else {
            int i8 = 11;
            CurrencyTypeDTO currencyTypeDTO2 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            boolean z7 = true;
            int i9 = 0;
            int i10 = 0;
            boolean z8 = false;
            boolean z9 = false;
            List list6 = null;
            LocalDate localDate3 = null;
            while (z7) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z7 = false;
                        i8 = 11;
                    case 0:
                        list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], list3);
                        i9 |= 1;
                        i8 = 11;
                        i7 = 10;
                    case 1:
                        localDate3 = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LocalDateWithTimeSerializer.INSTANCE, localDate3);
                        i9 |= 2;
                        i8 = 11;
                        i7 = 10;
                    case 2:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i9 |= 4;
                        i8 = 11;
                    case 3:
                        z9 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                        i9 |= 8;
                        i8 = 11;
                    case 4:
                        list6 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], list6);
                        i9 |= 16;
                        i8 = 11;
                    case 5:
                        z8 = beginStructure.decodeBooleanElement(serialDescriptor, 5);
                        i9 |= 32;
                    case 6:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 6);
                        i9 |= 64;
                    case 7:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i9 |= 128;
                    case 8:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i9 |= 256;
                    case 9:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 9);
                        i9 |= 512;
                    case 10:
                        currencyTypeDTO2 = (CurrencyTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, i7, CurrencyTypeDTO.Serializer.INSTANCE, currencyTypeDTO2);
                        i9 |= 1024;
                    case 11:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, i8);
                        i9 |= 2048;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list3;
            i5 = i9;
            currencyTypeDTO = currencyTypeDTO2;
            list2 = list6;
            localDate = localDate3;
            str = str6;
            str2 = str7;
            str3 = str8;
            str4 = str9;
            str5 = str10;
            i6 = i10;
            z5 = z8;
            z6 = z9;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BornholmCommuterAgreementResponseDTO(i5, list, localDate, str, z6, list2, z5, i6, str2, str3, str4, currencyTypeDTO, str5, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BornholmCommuterAgreementResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BornholmCommuterAgreementResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
