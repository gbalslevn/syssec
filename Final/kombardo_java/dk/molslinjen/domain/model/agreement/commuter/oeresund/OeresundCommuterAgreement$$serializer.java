package dk.molslinjen.domain.model.agreement.commuter.oeresund;

import dk.molslinjen.api.helpers.serializers.LocalDateSerializer;
import dk.molslinjen.domain.model.constants.Constants;
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
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class OeresundCommuterAgreement$$serializer implements GeneratedSerializer<OeresundCommuterAgreement> {
    public static final OeresundCommuterAgreement$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        OeresundCommuterAgreement$$serializer oeresundCommuterAgreement$$serializer = new OeresundCommuterAgreement$$serializer();
        INSTANCE = oeresundCommuterAgreement$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreement", oeresundCommuterAgreement$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("agreementId", false);
        pluginGeneratedSerialDescriptor.addElement("agreementType", false);
        pluginGeneratedSerialDescriptor.addElement(Constants.IntentExtra.PushTitle, false);
        pluginGeneratedSerialDescriptor.addElement("transportImageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("transportDescription", false);
        pluginGeneratedSerialDescriptor.addElement("validTo", false);
        pluginGeneratedSerialDescriptor.addElement("numberOfChargesLeft", false);
        pluginGeneratedSerialDescriptor.addElement("number", false);
        pluginGeneratedSerialDescriptor.addElement("lineName", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private OeresundCommuterAgreement$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = OeresundCommuterAgreement.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, kSerializerArr[1], BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(LocalDateSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(stringSerializer), stringSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0086. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final OeresundCommuterAgreement deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        Integer num;
        String str;
        LocalDate localDate;
        String str2;
        String str3;
        String str4;
        OeresundCommuterAgreementType oeresundCommuterAgreementType;
        String str5;
        String str6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = OeresundCommuterAgreement.$childSerializers;
        int i6 = 7;
        String str7 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            OeresundCommuterAgreementType oeresundCommuterAgreementType2 = (OeresundCommuterAgreementType) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LocalDateSerializer.INSTANCE, null);
            Integer num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, null);
            oeresundCommuterAgreementType = oeresundCommuterAgreementType2;
            str4 = decodeStringElement;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, stringSerializer, null);
            num = num2;
            localDate = localDate2;
            str3 = str9;
            str6 = beginStructure.decodeStringElement(serialDescriptor, 8);
            str2 = str10;
            str5 = str8;
            i5 = 511;
        } else {
            boolean z5 = true;
            int i7 = 0;
            Integer num3 = null;
            String str11 = null;
            LocalDate localDate3 = null;
            String str12 = null;
            String str13 = null;
            OeresundCommuterAgreementType oeresundCommuterAgreementType3 = null;
            String str14 = null;
            String str15 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        i6 = 7;
                    case 0:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i7 |= 1;
                        i6 = 7;
                    case 1:
                        oeresundCommuterAgreementType3 = (OeresundCommuterAgreementType) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], oeresundCommuterAgreementType3);
                        i7 |= 2;
                        i6 = 7;
                    case 2:
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str14);
                        i7 |= 4;
                        i6 = 7;
                    case 3:
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str13);
                        i7 |= 8;
                        i6 = 7;
                    case 4:
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str12);
                        i7 |= 16;
                        i6 = 7;
                    case 5:
                        localDate3 = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LocalDateSerializer.INSTANCE, localDate3);
                        i7 |= 32;
                        i6 = 7;
                    case 6:
                        num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, num3);
                        i7 |= 64;
                    case 7:
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i6, StringSerializer.INSTANCE, str11);
                        i7 |= 128;
                    case 8:
                        str15 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i7 |= 256;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i7;
            num = num3;
            str = str11;
            localDate = localDate3;
            str2 = str12;
            str3 = str13;
            str4 = str7;
            oeresundCommuterAgreementType = oeresundCommuterAgreementType3;
            str5 = str14;
            str6 = str15;
        }
        beginStructure.endStructure(serialDescriptor);
        return new OeresundCommuterAgreement(i5, str4, oeresundCommuterAgreementType, str5, str3, str2, localDate, num, str, str6, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, OeresundCommuterAgreement value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        OeresundCommuterAgreement.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
