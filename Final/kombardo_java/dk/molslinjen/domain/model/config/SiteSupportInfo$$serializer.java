package dk.molslinjen.domain.model.config;

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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/config/SiteSupportInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/config/SiteSupportInfo;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class SiteSupportInfo$$serializer implements GeneratedSerializer<SiteSupportInfo> {
    public static final SiteSupportInfo$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SiteSupportInfo$$serializer siteSupportInfo$$serializer = new SiteSupportInfo$$serializer();
        INSTANCE = siteSupportInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.config.SiteSupportInfo", siteSupportInfo$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("contactInfo", false);
        pluginGeneratedSerialDescriptor.addElement("openingHours", false);
        pluginGeneratedSerialDescriptor.addElement("lostAndFoundPageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("suggestionsAndComplaintsPageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("privacyPolicyPageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("termsAndConditionsPageUrl", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SiteSupportInfo$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = SiteSupportInfo.$childSerializers;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(kSerializerArr[1]);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{SiteSupportContact$$serializer.INSTANCE, nullable, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0068. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final SiteSupportInfo deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        SiteSupportContact siteSupportContact;
        List list;
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = SiteSupportInfo.$childSerializers;
        int i6 = 5;
        SiteSupportContact siteSupportContact2 = null;
        if (beginStructure.decodeSequentially()) {
            SiteSupportContact siteSupportContact3 = (SiteSupportContact) beginStructure.decodeSerializableElement(serialDescriptor, 0, SiteSupportContact$$serializer.INSTANCE, null);
            List list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            list = list2;
            siteSupportContact = siteSupportContact3;
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            str2 = str6;
            str3 = str7;
            str = str5;
            i5 = 63;
        } else {
            boolean z5 = true;
            int i7 = 0;
            List list3 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        i6 = 5;
                    case 0:
                        siteSupportContact2 = (SiteSupportContact) beginStructure.decodeSerializableElement(serialDescriptor, 0, SiteSupportContact$$serializer.INSTANCE, siteSupportContact2);
                        i7 |= 1;
                        i6 = 5;
                    case 1:
                        list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, kSerializerArr[1], list3);
                        i7 |= 2;
                    case 2:
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str8);
                        i7 |= 4;
                    case 3:
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str9);
                        i7 |= 8;
                    case 4:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str10);
                        i7 |= 16;
                    case 5:
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i6, StringSerializer.INSTANCE, str11);
                        i7 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i7;
            siteSupportContact = siteSupportContact2;
            list = list3;
            str = str8;
            str2 = str9;
            str3 = str10;
            str4 = str11;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SiteSupportInfo(i5, siteSupportContact, list, str, str2, str3, str4, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SiteSupportInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SiteSupportInfo.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
