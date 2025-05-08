package dk.molslinjen.api.services.payment.request;

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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/payment/request/PaymentServiceAppPaymentRedirectDetailsDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/payment/request/PaymentServiceAppPaymentRedirectDetailsDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class PaymentServiceAppPaymentRedirectDetailsDTO$$serializer implements GeneratedSerializer<PaymentServiceAppPaymentRedirectDetailsDTO> {
    public static final PaymentServiceAppPaymentRedirectDetailsDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PaymentServiceAppPaymentRedirectDetailsDTO$$serializer paymentServiceAppPaymentRedirectDetailsDTO$$serializer = new PaymentServiceAppPaymentRedirectDetailsDTO$$serializer();
        INSTANCE = paymentServiceAppPaymentRedirectDetailsDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.payment.request.PaymentServiceAppPaymentRedirectDetailsDTO", paymentServiceAppPaymentRedirectDetailsDTO$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("cardHolderName", false);
        pluginGeneratedSerialDescriptor.addElement("accept", false);
        pluginGeneratedSerialDescriptor.addElement("acceptLanguage", false);
        pluginGeneratedSerialDescriptor.addElement("userAgent", false);
        pluginGeneratedSerialDescriptor.addElement("ip", false);
        pluginGeneratedSerialDescriptor.addElement("forwardedIp", false);
        pluginGeneratedSerialDescriptor.addElement("javaEnabled", false);
        pluginGeneratedSerialDescriptor.addElement("javeScriptEnabled", false);
        pluginGeneratedSerialDescriptor.addElement("timeZone", false);
        pluginGeneratedSerialDescriptor.addElement("screenHeight", false);
        pluginGeneratedSerialDescriptor.addElement("screenWidth", false);
        pluginGeneratedSerialDescriptor.addElement("colorDepth", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaymentServiceAppPaymentRedirectDetailsDTO$$serializer() {
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
        KSerializer<?> nullable7 = BuiltinSerializersKt.getNullable(booleanSerializer);
        KSerializer<?> nullable8 = BuiltinSerializersKt.getNullable(booleanSerializer);
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        KSerializer<?> nullable9 = BuiltinSerializersKt.getNullable(intSerializer);
        FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
        return new KSerializer[]{nullable, nullable2, nullable3, nullable4, nullable5, nullable6, nullable7, nullable8, nullable9, BuiltinSerializersKt.getNullable(floatSerializer), BuiltinSerializersKt.getNullable(floatSerializer), BuiltinSerializersKt.getNullable(intSerializer)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00a6. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final PaymentServiceAppPaymentRedirectDetailsDTO deserialize(Decoder decoder) {
        int i5;
        String str;
        Integer num;
        Float f5;
        Integer num2;
        Boolean bool;
        String str2;
        Float f6;
        Boolean bool2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        String str8 = null;
        if (beginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            String str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            String str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            String str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
            Boolean bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, booleanSerializer, null);
            Boolean bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, booleanSerializer, null);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            Integer num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, intSerializer, null);
            FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
            Float f7 = (Float) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, floatSerializer, null);
            str2 = str14;
            f6 = (Float) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, floatSerializer, null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, intSerializer, null);
            f5 = f7;
            bool = bool4;
            bool2 = bool3;
            i5 = 4095;
            str4 = str12;
            num2 = num3;
            str3 = str13;
            str5 = str11;
            str6 = str10;
            str = str9;
        } else {
            boolean z5 = true;
            int i6 = 0;
            String str15 = null;
            Integer num4 = null;
            Float f8 = null;
            Integer num5 = null;
            Boolean bool5 = null;
            String str16 = null;
            Float f9 = null;
            Boolean bool6 = null;
            String str17 = null;
            String str18 = null;
            String str19 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        str8 = str8;
                        str15 = str15;
                    case 0:
                        i6 |= 1;
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str8);
                        str15 = str15;
                    case 1:
                        str7 = str8;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str15);
                        i6 |= 2;
                        str8 = str7;
                    case 2:
                        str7 = str8;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str19);
                        i6 |= 4;
                        str8 = str7;
                    case 3:
                        str7 = str8;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str18);
                        i6 |= 8;
                        str8 = str7;
                    case 4:
                        str7 = str8;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str17);
                        i6 |= 16;
                        str8 = str7;
                    case 5:
                        str7 = str8;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str16);
                        i6 |= 32;
                        str8 = str7;
                    case 6:
                        str7 = str8;
                        bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, BooleanSerializer.INSTANCE, bool6);
                        i6 |= 64;
                        str8 = str7;
                    case 7:
                        str7 = str8;
                        bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, BooleanSerializer.INSTANCE, bool5);
                        i6 |= 128;
                        str8 = str7;
                    case 8:
                        str7 = str8;
                        num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, num5);
                        i6 |= 256;
                        str8 = str7;
                    case 9:
                        str7 = str8;
                        f8 = (Float) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, FloatSerializer.INSTANCE, f8);
                        i6 |= 512;
                        str8 = str7;
                    case 10:
                        f9 = (Float) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, FloatSerializer.INSTANCE, f9);
                        i6 |= 1024;
                        str8 = str8;
                    case 11:
                        str7 = str8;
                        num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, IntSerializer.INSTANCE, num4);
                        i6 |= 2048;
                        str8 = str7;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i6;
            str = str8;
            num = num4;
            f5 = f8;
            num2 = num5;
            bool = bool5;
            str2 = str16;
            f6 = f9;
            bool2 = bool6;
            str3 = str17;
            str4 = str18;
            str5 = str19;
            str6 = str15;
        }
        beginStructure.endStructure(serialDescriptor);
        return new PaymentServiceAppPaymentRedirectDetailsDTO(i5, str, str6, str5, str4, str3, str2, bool2, bool, num2, f5, f6, num, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, PaymentServiceAppPaymentRedirectDetailsDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        PaymentServiceAppPaymentRedirectDetailsDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
