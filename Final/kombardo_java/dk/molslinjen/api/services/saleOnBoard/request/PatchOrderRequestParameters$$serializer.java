package dk.molslinjen.api.services.saleOnBoard.request;

import dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters;
import java.util.List;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class PatchOrderRequestParameters$$serializer implements GeneratedSerializer<PatchOrderRequestParameters> {
    public static final PatchOrderRequestParameters$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PatchOrderRequestParameters$$serializer patchOrderRequestParameters$$serializer = new PatchOrderRequestParameters$$serializer();
        INSTANCE = patchOrderRequestParameters$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters", patchOrderRequestParameters$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("mobileNo", false);
        pluginGeneratedSerialDescriptor.addElement("email", false);
        pluginGeneratedSerialDescriptor.addElement("notificationMethod", false);
        pluginGeneratedSerialDescriptor.addElement("departureId", false);
        pluginGeneratedSerialDescriptor.addElement("storeNo", false);
        pluginGeneratedSerialDescriptor.addElement("timeSlot", false);
        pluginGeneratedSerialDescriptor.addElement("lines", false);
        pluginGeneratedSerialDescriptor.addElement("transactionId", false);
        pluginGeneratedSerialDescriptor.addElement("paymentMethodCode", false);
        pluginGeneratedSerialDescriptor.addElement("notificationLanguage", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PatchOrderRequestParameters$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = PatchOrderRequestParameters.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[3];
        KSerializer<?> kSerializer2 = kSerializerArr[7];
        KSerializer<?> kSerializer3 = kSerializerArr[9];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, kSerializer, stringSerializer, stringSerializer, IntSerializer.INSTANCE, kSerializer2, stringSerializer, kSerializer3, stringSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0096. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final PatchOrderRequestParameters deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        PatchOrderRequestParameters.PaymentMethodRequestParameters paymentMethodRequestParameters;
        List list;
        PatchOrderRequestParameters.NotificationTypeRequestParameters notificationTypeRequestParameters;
        int i6;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = PatchOrderRequestParameters.$childSerializers;
        int i7 = 10;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 2);
            PatchOrderRequestParameters.NotificationTypeRequestParameters notificationTypeRequestParameters2 = (PatchOrderRequestParameters.NotificationTypeRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 4);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 5);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 6);
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 7, kSerializerArr[7], null);
            String decodeStringElement6 = beginStructure.decodeStringElement(serialDescriptor, 8);
            paymentMethodRequestParameters = (PatchOrderRequestParameters.PaymentMethodRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 9, kSerializerArr[9], null);
            str = decodeStringElement;
            str7 = beginStructure.decodeStringElement(serialDescriptor, 10);
            i5 = decodeIntElement;
            str5 = decodeStringElement5;
            str6 = decodeStringElement6;
            str4 = decodeStringElement4;
            str3 = decodeStringElement3;
            i6 = 2047;
            list = list2;
            notificationTypeRequestParameters = notificationTypeRequestParameters2;
            str2 = decodeStringElement2;
        } else {
            boolean z5 = true;
            int i8 = 0;
            PatchOrderRequestParameters.PaymentMethodRequestParameters paymentMethodRequestParameters2 = null;
            List list3 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            PatchOrderRequestParameters.NotificationTypeRequestParameters notificationTypeRequestParameters3 = null;
            int i9 = 0;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        i7 = 10;
                    case 0:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i9 |= 1;
                        i7 = 10;
                    case 1:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i9 |= 2;
                        i7 = 10;
                    case 2:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i9 |= 4;
                        i7 = 10;
                    case 3:
                        notificationTypeRequestParameters3 = (PatchOrderRequestParameters.NotificationTypeRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], notificationTypeRequestParameters3);
                        i9 |= 8;
                        i7 = 10;
                    case 4:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i9 |= 16;
                    case 5:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i9 |= 32;
                    case 6:
                        i8 = beginStructure.decodeIntElement(serialDescriptor, 6);
                        i9 |= 64;
                    case 7:
                        list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 7, kSerializerArr[7], list3);
                        i9 |= 128;
                    case 8:
                        str13 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i9 |= 256;
                    case 9:
                        paymentMethodRequestParameters2 = (PatchOrderRequestParameters.PaymentMethodRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 9, kSerializerArr[9], paymentMethodRequestParameters2);
                        i9 |= 512;
                    case 10:
                        str14 = beginStructure.decodeStringElement(serialDescriptor, i7);
                        i9 |= 1024;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i8;
            paymentMethodRequestParameters = paymentMethodRequestParameters2;
            list = list3;
            notificationTypeRequestParameters = notificationTypeRequestParameters3;
            i6 = i9;
            str = str8;
            str2 = str9;
            str3 = str10;
            str4 = str11;
            str5 = str12;
            str6 = str13;
            str7 = str14;
        }
        beginStructure.endStructure(serialDescriptor);
        return new PatchOrderRequestParameters(i6, str, str2, str3, notificationTypeRequestParameters, str4, str5, i5, list, str6, paymentMethodRequestParameters, str7, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, PatchOrderRequestParameters value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        PatchOrderRequestParameters.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
