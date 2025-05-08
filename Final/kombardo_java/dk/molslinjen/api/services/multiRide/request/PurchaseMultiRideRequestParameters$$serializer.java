package dk.molslinjen.api.services.multiRide.request;

import dk.molslinjen.api.services.booking.request.PaymentTypeRequestParameters;
import dk.molslinjen.api.services.booking.response.booking.ApiAppPaymentRedirectDetailsDTO;
import dk.molslinjen.api.services.booking.response.booking.ApiAppPaymentRedirectDetailsDTO$$serializer;
import dk.molslinjen.api.shared.request.PaymentDataRequestParameters;
import dk.molslinjen.api.shared.request.PaymentDataRequestParameters$$serializer;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/multiRide/request/PurchaseMultiRideRequestParameters.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/multiRide/request/PurchaseMultiRideRequestParameters;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class PurchaseMultiRideRequestParameters$$serializer implements GeneratedSerializer<PurchaseMultiRideRequestParameters> {
    public static final PurchaseMultiRideRequestParameters$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PurchaseMultiRideRequestParameters$$serializer purchaseMultiRideRequestParameters$$serializer = new PurchaseMultiRideRequestParameters$$serializer();
        INSTANCE = purchaseMultiRideRequestParameters$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.multiRide.request.PurchaseMultiRideRequestParameters", purchaseMultiRideRequestParameters$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("cardType", false);
        pluginGeneratedSerialDescriptor.addElement("email", false);
        pluginGeneratedSerialDescriptor.addElement("multiRideId", false);
        pluginGeneratedSerialDescriptor.addElement("numberOfTickets", false);
        pluginGeneratedSerialDescriptor.addElement("paymentType", false);
        pluginGeneratedSerialDescriptor.addElement("phone", false);
        pluginGeneratedSerialDescriptor.addElement("phonePrefix", false);
        pluginGeneratedSerialDescriptor.addElement("postalCode", false);
        pluginGeneratedSerialDescriptor.addElement("paymentData", false);
        pluginGeneratedSerialDescriptor.addElement("version", false);
        pluginGeneratedSerialDescriptor.addElement("appPaymentRedirectDetails", false);
        pluginGeneratedSerialDescriptor.addElement("refill", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PurchaseMultiRideRequestParameters$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), IntSerializer.INSTANCE, PaymentTypeRequestParameters.Serializer.INSTANCE, stringSerializer, stringSerializer, stringSerializer, PaymentDataRequestParameters$$serializer.INSTANCE, stringSerializer, ApiAppPaymentRedirectDetailsDTO$$serializer.INSTANCE, BooleanSerializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x009c. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final PurchaseMultiRideRequestParameters deserialize(Decoder decoder) {
        boolean z5;
        PaymentDataRequestParameters paymentDataRequestParameters;
        ApiAppPaymentRedirectDetailsDTO apiAppPaymentRedirectDetailsDTO;
        PaymentTypeRequestParameters paymentTypeRequestParameters;
        String str;
        int i5;
        int i6;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i7 = 11;
        int i8 = 10;
        int i9 = 0;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 3);
            PaymentTypeRequestParameters paymentTypeRequestParameters2 = (PaymentTypeRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 4, PaymentTypeRequestParameters.Serializer.INSTANCE, null);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 5);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 6);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 7);
            PaymentDataRequestParameters paymentDataRequestParameters2 = (PaymentDataRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 8, PaymentDataRequestParameters$$serializer.INSTANCE, null);
            String decodeStringElement6 = beginStructure.decodeStringElement(serialDescriptor, 9);
            ApiAppPaymentRedirectDetailsDTO apiAppPaymentRedirectDetailsDTO2 = (ApiAppPaymentRedirectDetailsDTO) beginStructure.decodeSerializableElement(serialDescriptor, 10, ApiAppPaymentRedirectDetailsDTO$$serializer.INSTANCE, null);
            str2 = decodeStringElement;
            z5 = beginStructure.decodeBooleanElement(serialDescriptor, 11);
            apiAppPaymentRedirectDetailsDTO = apiAppPaymentRedirectDetailsDTO2;
            str7 = decodeStringElement6;
            str6 = decodeStringElement5;
            str5 = decodeStringElement4;
            str4 = decodeStringElement3;
            i6 = decodeIntElement;
            paymentDataRequestParameters = paymentDataRequestParameters2;
            paymentTypeRequestParameters = paymentTypeRequestParameters2;
            str = str8;
            str3 = decodeStringElement2;
            i5 = 4095;
        } else {
            boolean z6 = true;
            boolean z7 = false;
            PaymentDataRequestParameters paymentDataRequestParameters3 = null;
            ApiAppPaymentRedirectDetailsDTO apiAppPaymentRedirectDetailsDTO3 = null;
            PaymentTypeRequestParameters paymentTypeRequestParameters3 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            int i10 = 0;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z6 = false;
                        i7 = 11;
                    case 0:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i9 |= 1;
                        i7 = 11;
                        i8 = 10;
                    case 1:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i9 |= 2;
                        i7 = 11;
                        i8 = 10;
                    case 2:
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str9);
                        i9 |= 4;
                        i7 = 11;
                        i8 = 10;
                    case 3:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 3);
                        i9 |= 8;
                        i7 = 11;
                        i8 = 10;
                    case 4:
                        paymentTypeRequestParameters3 = (PaymentTypeRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 4, PaymentTypeRequestParameters.Serializer.INSTANCE, paymentTypeRequestParameters3);
                        i9 |= 16;
                        i7 = 11;
                        i8 = 10;
                    case 5:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i9 |= 32;
                    case 6:
                        str13 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i9 |= 64;
                    case 7:
                        str14 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i9 |= 128;
                    case 8:
                        paymentDataRequestParameters3 = (PaymentDataRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 8, PaymentDataRequestParameters$$serializer.INSTANCE, paymentDataRequestParameters3);
                        i9 |= 256;
                    case 9:
                        str15 = beginStructure.decodeStringElement(serialDescriptor, 9);
                        i9 |= 512;
                    case 10:
                        apiAppPaymentRedirectDetailsDTO3 = (ApiAppPaymentRedirectDetailsDTO) beginStructure.decodeSerializableElement(serialDescriptor, i8, ApiAppPaymentRedirectDetailsDTO$$serializer.INSTANCE, apiAppPaymentRedirectDetailsDTO3);
                        i9 |= 1024;
                    case 11:
                        z7 = beginStructure.decodeBooleanElement(serialDescriptor, i7);
                        i9 |= 2048;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z5 = z7;
            paymentDataRequestParameters = paymentDataRequestParameters3;
            apiAppPaymentRedirectDetailsDTO = apiAppPaymentRedirectDetailsDTO3;
            paymentTypeRequestParameters = paymentTypeRequestParameters3;
            str = str9;
            i5 = i9;
            i6 = i10;
            str2 = str10;
            str3 = str11;
            str4 = str12;
            str5 = str13;
            str6 = str14;
            str7 = str15;
        }
        beginStructure.endStructure(serialDescriptor);
        return new PurchaseMultiRideRequestParameters(i5, str2, str3, str, i6, paymentTypeRequestParameters, str4, str5, str6, paymentDataRequestParameters, str7, apiAppPaymentRedirectDetailsDTO, z5, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, PurchaseMultiRideRequestParameters value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        PurchaseMultiRideRequestParameters.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
