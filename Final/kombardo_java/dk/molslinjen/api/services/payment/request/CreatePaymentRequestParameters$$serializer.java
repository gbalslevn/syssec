package dk.molslinjen.api.services.payment.request;

import dk.molslinjen.api.services.payment.request.PaymentProductTypeDTO;
import dk.molslinjen.api.services.payment.request.PaymentSourceDTO;
import dk.molslinjen.api.services.paymentTypes.response.PaymentTypeDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/payment/request/CreatePaymentRequestParameters.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/payment/request/CreatePaymentRequestParameters;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class CreatePaymentRequestParameters$$serializer implements GeneratedSerializer<CreatePaymentRequestParameters> {
    public static final CreatePaymentRequestParameters$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CreatePaymentRequestParameters$$serializer createPaymentRequestParameters$$serializer = new CreatePaymentRequestParameters$$serializer();
        INSTANCE = createPaymentRequestParameters$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.payment.request.CreatePaymentRequestParameters", createPaymentRequestParameters$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement("amount", false);
        pluginGeneratedSerialDescriptor.addElement("callbackFailUrl", false);
        pluginGeneratedSerialDescriptor.addElement("creditCardToken", false);
        pluginGeneratedSerialDescriptor.addElement("currency", false);
        pluginGeneratedSerialDescriptor.addElement("language", false);
        pluginGeneratedSerialDescriptor.addElement("orderNumber", false);
        pluginGeneratedSerialDescriptor.addElement("paymentType", false);
        pluginGeneratedSerialDescriptor.addElement("productType", false);
        pluginGeneratedSerialDescriptor.addElement("receiptUrl", false);
        pluginGeneratedSerialDescriptor.addElement("source", false);
        pluginGeneratedSerialDescriptor.addElement("email", false);
        pluginGeneratedSerialDescriptor.addElement("paymentLine", false);
        pluginGeneratedSerialDescriptor.addElement("appPaymentRedirectDetails", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CreatePaymentRequestParameters$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{intSerializer, stringSerializer, nullable, CurrencyTypeDTO.Serializer.INSTANCE, stringSerializer, stringSerializer, PaymentTypeDTO.Serializer.INSTANCE, PaymentProductTypeDTO.Serializer.INSTANCE, stringSerializer, PaymentSourceDTO.Serializer.INSTANCE, stringSerializer, intSerializer, PaymentServiceAppPaymentRedirectDetailsDTO$$serializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00b2. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final CreatePaymentRequestParameters deserialize(Decoder decoder) {
        int i5;
        int i6;
        PaymentServiceAppPaymentRedirectDetailsDTO paymentServiceAppPaymentRedirectDetailsDTO;
        PaymentProductTypeDTO paymentProductTypeDTO;
        PaymentSourceDTO paymentSourceDTO;
        PaymentTypeDTO paymentTypeDTO;
        CurrencyTypeDTO currencyTypeDTO;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i7;
        char c5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i8 = 11;
        int i9 = 10;
        char c6 = 7;
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            CurrencyTypeDTO currencyTypeDTO2 = (CurrencyTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 3, CurrencyTypeDTO.Serializer.INSTANCE, null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 4);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 5);
            PaymentTypeDTO paymentTypeDTO2 = (PaymentTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 6, PaymentTypeDTO.Serializer.INSTANCE, null);
            PaymentProductTypeDTO paymentProductTypeDTO2 = (PaymentProductTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 7, PaymentProductTypeDTO.Serializer.INSTANCE, null);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 8);
            PaymentSourceDTO paymentSourceDTO2 = (PaymentSourceDTO) beginStructure.decodeSerializableElement(serialDescriptor, 9, PaymentSourceDTO.Serializer.INSTANCE, null);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 10);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 11);
            paymentServiceAppPaymentRedirectDetailsDTO = (PaymentServiceAppPaymentRedirectDetailsDTO) beginStructure.decodeSerializableElement(serialDescriptor, 12, PaymentServiceAppPaymentRedirectDetailsDTO$$serializer.INSTANCE, null);
            i6 = 8191;
            i7 = decodeIntElement2;
            str6 = decodeStringElement5;
            paymentSourceDTO = paymentSourceDTO2;
            paymentProductTypeDTO = paymentProductTypeDTO2;
            paymentTypeDTO = paymentTypeDTO2;
            str4 = decodeStringElement3;
            currencyTypeDTO = currencyTypeDTO2;
            str5 = decodeStringElement4;
            str3 = decodeStringElement2;
            str = str7;
            str2 = decodeStringElement;
            i5 = decodeIntElement;
        } else {
            PaymentServiceAppPaymentRedirectDetailsDTO paymentServiceAppPaymentRedirectDetailsDTO2 = null;
            PaymentProductTypeDTO paymentProductTypeDTO3 = null;
            PaymentSourceDTO paymentSourceDTO3 = null;
            PaymentTypeDTO paymentTypeDTO3 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            boolean z5 = true;
            int i10 = 0;
            int i11 = 0;
            CurrencyTypeDTO currencyTypeDTO3 = null;
            int i12 = 0;
            String str13 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        c6 = 7;
                    case 0:
                        i12 |= 1;
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i8 = 11;
                        i9 = 10;
                        c6 = 7;
                    case 1:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i12 |= 2;
                        i8 = 11;
                        i9 = 10;
                        c6 = 7;
                    case 2:
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str13);
                        i12 |= 4;
                        i8 = 11;
                        i9 = 10;
                        c6 = 7;
                    case 3:
                        currencyTypeDTO3 = (CurrencyTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 3, CurrencyTypeDTO.Serializer.INSTANCE, currencyTypeDTO3);
                        i12 |= 8;
                        i8 = 11;
                        i9 = 10;
                        c6 = 7;
                    case 4:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i12 |= 16;
                        i8 = 11;
                        c6 = 7;
                    case 5:
                        c5 = 6;
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i12 |= 32;
                        i8 = 11;
                        c6 = 7;
                    case 6:
                        c5 = 6;
                        paymentTypeDTO3 = (PaymentTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 6, PaymentTypeDTO.Serializer.INSTANCE, paymentTypeDTO3);
                        i12 |= 64;
                        i8 = 11;
                        c6 = 7;
                    case 7:
                        paymentProductTypeDTO3 = (PaymentProductTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 7, PaymentProductTypeDTO.Serializer.INSTANCE, paymentProductTypeDTO3);
                        i12 |= 128;
                        c6 = 7;
                        i8 = 11;
                    case 8:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i12 |= 256;
                        c6 = 7;
                    case 9:
                        paymentSourceDTO3 = (PaymentSourceDTO) beginStructure.decodeSerializableElement(serialDescriptor, 9, PaymentSourceDTO.Serializer.INSTANCE, paymentSourceDTO3);
                        i12 |= 512;
                        c6 = 7;
                    case 10:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, i9);
                        i12 |= 1024;
                        c6 = 7;
                    case 11:
                        i11 = beginStructure.decodeIntElement(serialDescriptor, i8);
                        i12 |= 2048;
                        c6 = 7;
                    case 12:
                        paymentServiceAppPaymentRedirectDetailsDTO2 = (PaymentServiceAppPaymentRedirectDetailsDTO) beginStructure.decodeSerializableElement(serialDescriptor, 12, PaymentServiceAppPaymentRedirectDetailsDTO$$serializer.INSTANCE, paymentServiceAppPaymentRedirectDetailsDTO2);
                        i12 |= 4096;
                        c6 = 7;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i10;
            i6 = i12;
            paymentServiceAppPaymentRedirectDetailsDTO = paymentServiceAppPaymentRedirectDetailsDTO2;
            paymentProductTypeDTO = paymentProductTypeDTO3;
            paymentSourceDTO = paymentSourceDTO3;
            paymentTypeDTO = paymentTypeDTO3;
            currencyTypeDTO = currencyTypeDTO3;
            str = str13;
            str2 = str8;
            str3 = str9;
            str4 = str10;
            str5 = str11;
            str6 = str12;
            i7 = i11;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CreatePaymentRequestParameters(i6, i5, str2, str, currencyTypeDTO, str3, str4, paymentTypeDTO, paymentProductTypeDTO, str5, paymentSourceDTO, str6, i7, paymentServiceAppPaymentRedirectDetailsDTO, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, CreatePaymentRequestParameters value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CreatePaymentRequestParameters.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
