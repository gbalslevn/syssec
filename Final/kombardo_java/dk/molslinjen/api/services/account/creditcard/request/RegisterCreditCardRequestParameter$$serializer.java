package dk.molslinjen.api.services.account.creditcard.request;

import dk.molslinjen.api.services.account.creditcard.response.CreditCardTypeDTO;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/account/creditcard/request/RegisterCreditCardRequestParameter.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/account/creditcard/request/RegisterCreditCardRequestParameter;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class RegisterCreditCardRequestParameter$$serializer implements GeneratedSerializer<RegisterCreditCardRequestParameter> {
    public static final RegisterCreditCardRequestParameter$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        RegisterCreditCardRequestParameter$$serializer registerCreditCardRequestParameter$$serializer = new RegisterCreditCardRequestParameter$$serializer();
        INSTANCE = registerCreditCardRequestParameter$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.account.creditcard.request.RegisterCreditCardRequestParameter", registerCreditCardRequestParameter$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("maskedNumber", false);
        pluginGeneratedSerialDescriptor.addElement("paymentType", false);
        pluginGeneratedSerialDescriptor.addElement("expirationMonth", false);
        pluginGeneratedSerialDescriptor.addElement("expirationYear", false);
        pluginGeneratedSerialDescriptor.addElement("creditCardToken", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RegisterCreditCardRequestParameter$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = RegisterCreditCardRequestParameter.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[1];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, kSerializer, stringSerializer, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final RegisterCreditCardRequestParameter deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        String str;
        CreditCardTypeDTO creditCardTypeDTO;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = RegisterCreditCardRequestParameter.$childSerializers;
        String str5 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            CreditCardTypeDTO creditCardTypeDTO2 = (CreditCardTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            creditCardTypeDTO = creditCardTypeDTO2;
            str = decodeStringElement;
            str3 = beginStructure.decodeStringElement(serialDescriptor, 3);
            str4 = beginStructure.decodeStringElement(serialDescriptor, 4);
            str2 = decodeStringElement2;
            i5 = 31;
        } else {
            boolean z5 = true;
            int i6 = 0;
            CreditCardTypeDTO creditCardTypeDTO3 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    str5 = beginStructure.decodeStringElement(serialDescriptor, 0);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    creditCardTypeDTO3 = (CreditCardTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], creditCardTypeDTO3);
                    i6 |= 2;
                } else if (decodeElementIndex == 2) {
                    str6 = beginStructure.decodeStringElement(serialDescriptor, 2);
                    i6 |= 4;
                } else if (decodeElementIndex == 3) {
                    str7 = beginStructure.decodeStringElement(serialDescriptor, 3);
                    i6 |= 8;
                } else {
                    if (decodeElementIndex != 4) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    str8 = beginStructure.decodeStringElement(serialDescriptor, 4);
                    i6 |= 16;
                }
            }
            i5 = i6;
            str = str5;
            creditCardTypeDTO = creditCardTypeDTO3;
            str2 = str6;
            str3 = str7;
            str4 = str8;
        }
        beginStructure.endStructure(serialDescriptor);
        return new RegisterCreditCardRequestParameter(i5, str, creditCardTypeDTO, str2, str3, str4, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, RegisterCreditCardRequestParameter value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        RegisterCreditCardRequestParameter.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
