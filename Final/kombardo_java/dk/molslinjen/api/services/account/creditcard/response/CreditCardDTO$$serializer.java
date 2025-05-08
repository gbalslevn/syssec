package dk.molslinjen.api.services.account.creditcard.response;

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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/account/creditcard/response/CreditCardDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/account/creditcard/response/CreditCardDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class CreditCardDTO$$serializer implements GeneratedSerializer<CreditCardDTO> {
    public static final CreditCardDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CreditCardDTO$$serializer creditCardDTO$$serializer = new CreditCardDTO$$serializer();
        INSTANCE = creditCardDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.account.creditcard.response.CreditCardDTO", creditCardDTO$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("cardID", false);
        pluginGeneratedSerialDescriptor.addElement("maskedNumber", false);
        pluginGeneratedSerialDescriptor.addElement("paymentType", false);
        pluginGeneratedSerialDescriptor.addElement("expirationMonth", false);
        pluginGeneratedSerialDescriptor.addElement("expirationYear", false);
        pluginGeneratedSerialDescriptor.addElement("creditCardToken", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CreditCardDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = CreditCardDTO.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[2];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, kSerializer, stringSerializer, stringSerializer, stringSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x005a. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final CreditCardDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        String str;
        String str2;
        CreditCardTypeDTO creditCardTypeDTO;
        String str3;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = CreditCardDTO.$childSerializers;
        String str6 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            CreditCardTypeDTO creditCardTypeDTO2 = (CreditCardTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 3);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 4);
            creditCardTypeDTO = creditCardTypeDTO2;
            str = decodeStringElement;
            str5 = beginStructure.decodeStringElement(serialDescriptor, 5);
            str3 = decodeStringElement3;
            str4 = decodeStringElement4;
            i5 = 63;
            str2 = decodeStringElement2;
        } else {
            boolean z5 = true;
            int i6 = 0;
            String str7 = null;
            CreditCardTypeDTO creditCardTypeDTO3 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                    case 0:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i6 |= 1;
                    case 1:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i6 |= 2;
                    case 2:
                        creditCardTypeDTO3 = (CreditCardTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], creditCardTypeDTO3);
                        i6 |= 4;
                    case 3:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i6 |= 8;
                    case 4:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i6 |= 16;
                    case 5:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i6 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i6;
            str = str6;
            str2 = str7;
            creditCardTypeDTO = creditCardTypeDTO3;
            str3 = str8;
            str4 = str9;
            str5 = str10;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CreditCardDTO(i5, str, str2, creditCardTypeDTO, str3, str4, str5, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, CreditCardDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CreditCardDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
