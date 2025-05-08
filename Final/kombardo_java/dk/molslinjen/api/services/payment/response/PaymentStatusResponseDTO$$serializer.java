package dk.molslinjen.api.services.payment.response;

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
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/payment/response/PaymentStatusResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/payment/response/PaymentStatusResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class PaymentStatusResponseDTO$$serializer implements GeneratedSerializer<PaymentStatusResponseDTO> {
    public static final PaymentStatusResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PaymentStatusResponseDTO$$serializer paymentStatusResponseDTO$$serializer = new PaymentStatusResponseDTO$$serializer();
        INSTANCE = paymentStatusResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.payment.response.PaymentStatusResponseDTO", paymentStatusResponseDTO$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("cardExpiryDate", false);
        pluginGeneratedSerialDescriptor.addElement("cardNumber", false);
        pluginGeneratedSerialDescriptor.addElement("creditCardToken", false);
        pluginGeneratedSerialDescriptor.addElement("isCompleted", false);
        pluginGeneratedSerialDescriptor.addElement("isPending", false);
        pluginGeneratedSerialDescriptor.addElement("paymentId", false);
        pluginGeneratedSerialDescriptor.addElement("paymentType", false);
        pluginGeneratedSerialDescriptor.addElement("transactionId", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaymentStatusResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable4 = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable5 = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable6 = BuiltinSerializersKt.getNullable(stringSerializer);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{nullable, nullable2, nullable3, booleanSerializer, booleanSerializer, nullable4, nullable5, nullable6};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0071. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final PaymentStatusResponseDTO deserialize(Decoder decoder) {
        int i5;
        String str;
        String str2;
        String str3;
        boolean z5;
        boolean z6;
        String str4;
        String str5;
        String str6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i6 = 7;
        int i7 = 6;
        if (beginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 3);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, stringSerializer, null);
            i5 = 255;
            str2 = str11;
            str3 = str10;
            z5 = decodeBooleanElement;
            z6 = decodeBooleanElement2;
            str6 = str9;
            str5 = str8;
            str4 = str7;
        } else {
            boolean z7 = true;
            int i8 = 0;
            boolean z8 = false;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            String str16 = null;
            String str17 = null;
            boolean z9 = false;
            while (z7) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z7 = false;
                        i7 = 6;
                    case 0:
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str14);
                        i8 |= 1;
                        i6 = 7;
                        i7 = 6;
                    case 1:
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str15);
                        i8 |= 2;
                        i6 = 7;
                        i7 = 6;
                    case 2:
                        str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str16);
                        i8 |= 4;
                        i6 = 7;
                        i7 = 6;
                    case 3:
                        z9 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                        i8 |= 8;
                    case 4:
                        z8 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
                        i8 |= 16;
                    case 5:
                        str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str17);
                        i8 |= 32;
                    case 6:
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i7, StringSerializer.INSTANCE, str13);
                        i8 |= 64;
                    case 7:
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i6, StringSerializer.INSTANCE, str12);
                        i8 |= 128;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i8;
            str = str12;
            str2 = str13;
            str3 = str17;
            z5 = z9;
            z6 = z8;
            str4 = str14;
            str5 = str15;
            str6 = str16;
        }
        beginStructure.endStructure(serialDescriptor);
        return new PaymentStatusResponseDTO(i5, str4, str5, str6, z5, z6, str3, str2, str, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, PaymentStatusResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        PaymentStatusResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
