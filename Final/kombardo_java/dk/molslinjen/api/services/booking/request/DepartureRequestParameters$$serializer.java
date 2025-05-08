package dk.molslinjen.api.services.booking.request;

import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.services.booking.request.DepartureRequestParameters;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/request/DepartureRequestParameters.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class DepartureRequestParameters$$serializer implements GeneratedSerializer<DepartureRequestParameters> {
    public static final DepartureRequestParameters$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        DepartureRequestParameters$$serializer departureRequestParameters$$serializer = new DepartureRequestParameters$$serializer();
        INSTANCE = departureRequestParameters$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.request.DepartureRequestParameters", departureRequestParameters$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement("commuteAgreementId", false);
        pluginGeneratedSerialDescriptor.addElement("date", false);
        pluginGeneratedSerialDescriptor.addElement("goods", false);
        pluginGeneratedSerialDescriptor.addElement("multiRide", false);
        pluginGeneratedSerialDescriptor.addElement("outboundTrip", false);
        pluginGeneratedSerialDescriptor.addElement("passengerInfo", false);
        pluginGeneratedSerialDescriptor.addElement("phone", false);
        pluginGeneratedSerialDescriptor.addElement("products", true);
        pluginGeneratedSerialDescriptor.addElement("regionId", false);
        pluginGeneratedSerialDescriptor.addElement("reservationId", false);
        pluginGeneratedSerialDescriptor.addElement("routeId", false);
        pluginGeneratedSerialDescriptor.addElement("transportId", false);
        pluginGeneratedSerialDescriptor.addElement("currency", false);
        pluginGeneratedSerialDescriptor.addElement("includeEnRouteDepartures", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DepartureRequestParameters$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = DepartureRequestParameters.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), LocalDateWithTimeSerializer.INSTANCE, BuiltinSerializersKt.getNullable(DepartureRequestParameters$GoodsRequestParameters$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(DepartureRequestParameters$MultiRideRequestParameters$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(DepartureRequestParameters$OutboundTripRequestParameters$$serializer.INSTANCE), DepartureRequestParameters$DeparturePassengerInfoRequestParameters$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(stringSerializer), kSerializerArr[7], BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), stringSerializer, stringSerializer, CurrencyTypeDTO.Serializer.INSTANCE, BooleanSerializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00c9. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final DepartureRequestParameters deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        String str;
        DepartureRequestParameters.MultiRideRequestParameters multiRideRequestParameters;
        DepartureRequestParameters.GoodsRequestParameters goodsRequestParameters;
        LocalDate localDate;
        int i5;
        String str2;
        List list;
        DepartureRequestParameters.DeparturePassengerInfoRequestParameters departurePassengerInfoRequestParameters;
        CurrencyTypeDTO currencyTypeDTO;
        String str3;
        DepartureRequestParameters.OutboundTripRequestParameters outboundTripRequestParameters;
        String str4;
        String str5;
        String str6;
        boolean z5;
        String str7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = DepartureRequestParameters.$childSerializers;
        String str8 = null;
        if (beginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalDateWithTimeSerializer.INSTANCE, null);
            DepartureRequestParameters.GoodsRequestParameters goodsRequestParameters2 = (DepartureRequestParameters.GoodsRequestParameters) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, DepartureRequestParameters$GoodsRequestParameters$$serializer.INSTANCE, null);
            DepartureRequestParameters.MultiRideRequestParameters multiRideRequestParameters2 = (DepartureRequestParameters.MultiRideRequestParameters) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, DepartureRequestParameters$MultiRideRequestParameters$$serializer.INSTANCE, null);
            DepartureRequestParameters.OutboundTripRequestParameters outboundTripRequestParameters2 = (DepartureRequestParameters.OutboundTripRequestParameters) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, DepartureRequestParameters$OutboundTripRequestParameters$$serializer.INSTANCE, null);
            DepartureRequestParameters.DeparturePassengerInfoRequestParameters departurePassengerInfoRequestParameters2 = (DepartureRequestParameters.DeparturePassengerInfoRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 5, DepartureRequestParameters$DeparturePassengerInfoRequestParameters$$serializer.INSTANCE, null);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 7, kSerializerArr[7], null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, stringSerializer, null);
            String str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, stringSerializer, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 10);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 11);
            currencyTypeDTO = (CurrencyTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 12, CurrencyTypeDTO.Serializer.INSTANCE, null);
            str4 = str12;
            localDate = localDate2;
            str = str9;
            z5 = beginStructure.decodeBooleanElement(serialDescriptor, 13);
            goodsRequestParameters = goodsRequestParameters2;
            str5 = decodeStringElement;
            str3 = str10;
            departurePassengerInfoRequestParameters = departurePassengerInfoRequestParameters2;
            multiRideRequestParameters = multiRideRequestParameters2;
            str2 = str11;
            outboundTripRequestParameters = outboundTripRequestParameters2;
            str6 = decodeStringElement2;
            i5 = 16383;
            list = list2;
        } else {
            boolean z6 = true;
            int i6 = 0;
            boolean z7 = false;
            DepartureRequestParameters.MultiRideRequestParameters multiRideRequestParameters3 = null;
            DepartureRequestParameters.GoodsRequestParameters goodsRequestParameters3 = null;
            LocalDate localDate3 = null;
            String str13 = null;
            List list3 = null;
            DepartureRequestParameters.DeparturePassengerInfoRequestParameters departurePassengerInfoRequestParameters3 = null;
            CurrencyTypeDTO currencyTypeDTO2 = null;
            String str14 = null;
            DepartureRequestParameters.OutboundTripRequestParameters outboundTripRequestParameters3 = null;
            String str15 = null;
            String str16 = null;
            String str17 = null;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z6 = false;
                        kSerializerArr = kSerializerArr;
                    case 0:
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str8);
                        i6 |= 1;
                        kSerializerArr = kSerializerArr;
                    case 1:
                        str7 = str8;
                        localDate3 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalDateWithTimeSerializer.INSTANCE, localDate3);
                        i6 |= 2;
                        str8 = str7;
                    case 2:
                        str7 = str8;
                        goodsRequestParameters3 = (DepartureRequestParameters.GoodsRequestParameters) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, DepartureRequestParameters$GoodsRequestParameters$$serializer.INSTANCE, goodsRequestParameters3);
                        i6 |= 4;
                        str8 = str7;
                    case 3:
                        str7 = str8;
                        multiRideRequestParameters3 = (DepartureRequestParameters.MultiRideRequestParameters) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, DepartureRequestParameters$MultiRideRequestParameters$$serializer.INSTANCE, multiRideRequestParameters3);
                        i6 |= 8;
                        str8 = str7;
                    case 4:
                        str7 = str8;
                        outboundTripRequestParameters3 = (DepartureRequestParameters.OutboundTripRequestParameters) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, DepartureRequestParameters$OutboundTripRequestParameters$$serializer.INSTANCE, outboundTripRequestParameters3);
                        i6 |= 16;
                        str8 = str7;
                    case 5:
                        str7 = str8;
                        departurePassengerInfoRequestParameters3 = (DepartureRequestParameters.DeparturePassengerInfoRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 5, DepartureRequestParameters$DeparturePassengerInfoRequestParameters$$serializer.INSTANCE, departurePassengerInfoRequestParameters3);
                        i6 |= 32;
                        str8 = str7;
                    case 6:
                        str7 = str8;
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str14);
                        i6 |= 64;
                        str8 = str7;
                    case 7:
                        str7 = str8;
                        list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 7, kSerializerArr[7], list3);
                        i6 |= 128;
                        str8 = str7;
                    case 8:
                        str7 = str8;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str13);
                        i6 |= 256;
                        str8 = str7;
                    case 9:
                        str7 = str8;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str15);
                        i6 |= 512;
                        str8 = str7;
                    case 10:
                        str7 = str8;
                        str16 = beginStructure.decodeStringElement(serialDescriptor, 10);
                        i6 |= 1024;
                        str8 = str7;
                    case 11:
                        str7 = str8;
                        str17 = beginStructure.decodeStringElement(serialDescriptor, 11);
                        i6 |= 2048;
                        str8 = str7;
                    case 12:
                        str7 = str8;
                        currencyTypeDTO2 = (CurrencyTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 12, CurrencyTypeDTO.Serializer.INSTANCE, currencyTypeDTO2);
                        i6 |= 4096;
                        str8 = str7;
                    case 13:
                        z7 = beginStructure.decodeBooleanElement(serialDescriptor, 13);
                        i6 |= 8192;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str8;
            multiRideRequestParameters = multiRideRequestParameters3;
            goodsRequestParameters = goodsRequestParameters3;
            localDate = localDate3;
            i5 = i6;
            str2 = str13;
            list = list3;
            departurePassengerInfoRequestParameters = departurePassengerInfoRequestParameters3;
            currencyTypeDTO = currencyTypeDTO2;
            str3 = str14;
            outboundTripRequestParameters = outboundTripRequestParameters3;
            str4 = str15;
            str5 = str16;
            str6 = str17;
            z5 = z7;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DepartureRequestParameters(i5, str, localDate, goodsRequestParameters, multiRideRequestParameters, outboundTripRequestParameters, departurePassengerInfoRequestParameters, str3, list, str2, str4, str5, str6, currencyTypeDTO, z5, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, DepartureRequestParameters value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DepartureRequestParameters.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
