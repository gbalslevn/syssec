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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/config/LocalizedSiteConfiguration.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class LocalizedSiteConfiguration$$serializer implements GeneratedSerializer<LocalizedSiteConfiguration> {
    public static final LocalizedSiteConfiguration$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LocalizedSiteConfiguration$$serializer localizedSiteConfiguration$$serializer = new LocalizedSiteConfiguration$$serializer();
        INSTANCE = localizedSiteConfiguration$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.config.LocalizedSiteConfiguration", localizedSiteConfiguration$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement("routes", false);
        pluginGeneratedSerialDescriptor.addElement("transportationCategories", false);
        pluginGeneratedSerialDescriptor.addElement("extraTransportations", false);
        pluginGeneratedSerialDescriptor.addElement("harbors", false);
        pluginGeneratedSerialDescriptor.addElement("regions", false);
        pluginGeneratedSerialDescriptor.addElement("multiRideTypes", false);
        pluginGeneratedSerialDescriptor.addElement("ferries", false);
        pluginGeneratedSerialDescriptor.addElement("ageClassifications", false);
        pluginGeneratedSerialDescriptor.addElement("siteName", false);
        pluginGeneratedSerialDescriptor.addElement("lineLogoUrl", false);
        pluginGeneratedSerialDescriptor.addElement("site", false);
        pluginGeneratedSerialDescriptor.addElement("supportInfo", false);
        pluginGeneratedSerialDescriptor.addElement("enabledCurrencies", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LocalizedSiteConfiguration$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = LocalizedSiteConfiguration.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[0];
        KSerializer<?> kSerializer2 = kSerializerArr[1];
        KSerializer<?> kSerializer3 = kSerializerArr[2];
        KSerializer<?> kSerializer4 = kSerializerArr[3];
        KSerializer<?> kSerializer5 = kSerializerArr[4];
        KSerializer<?> kSerializer6 = kSerializerArr[5];
        KSerializer<?> kSerializer7 = kSerializerArr[6];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{kSerializer, kSerializer2, kSerializer3, kSerializer4, kSerializer5, kSerializer6, kSerializer7, AgeClassifications$$serializer.INSTANCE, stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), kSerializerArr[10], SiteSupportInfo$$serializer.INSTANCE, kSerializerArr[12]};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00cb. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final LocalizedSiteConfiguration deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        List list;
        int i5;
        List list2;
        String str;
        Site site;
        List list3;
        AgeClassifications ageClassifications;
        List list4;
        List list5;
        List list6;
        List list7;
        List list8;
        SiteSupportInfo siteSupportInfo;
        String str2;
        KSerializer[] kSerializerArr2;
        SiteSupportInfo siteSupportInfo2;
        List list9;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = LocalizedSiteConfiguration.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            List list10 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            List list11 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            List list12 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            List list13 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
            List list14 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            List list15 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
            List list16 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], null);
            AgeClassifications ageClassifications2 = (AgeClassifications) beginStructure.decodeSerializableElement(serialDescriptor, 7, AgeClassifications$$serializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 8);
            String str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, null);
            Site site2 = (Site) beginStructure.decodeSerializableElement(serialDescriptor, 10, kSerializerArr[10], null);
            SiteSupportInfo siteSupportInfo3 = (SiteSupportInfo) beginStructure.decodeSerializableElement(serialDescriptor, 11, SiteSupportInfo$$serializer.INSTANCE, null);
            list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 12, kSerializerArr[12], null);
            siteSupportInfo = siteSupportInfo3;
            i5 = 8191;
            str = str3;
            ageClassifications = ageClassifications2;
            str2 = decodeStringElement;
            list2 = list11;
            site = site2;
            list4 = list16;
            list6 = list15;
            list7 = list13;
            list5 = list14;
            list8 = list12;
            list = list10;
        } else {
            SiteSupportInfo siteSupportInfo4 = null;
            String str4 = null;
            Site site3 = null;
            List list17 = null;
            AgeClassifications ageClassifications3 = null;
            List list18 = null;
            List list19 = null;
            List list20 = null;
            List list21 = null;
            List list22 = null;
            String str5 = null;
            boolean z5 = true;
            List list23 = null;
            int i6 = 0;
            List list24 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        kSerializerArr2 = kSerializerArr;
                        siteSupportInfo2 = siteSupportInfo4;
                        z5 = false;
                        siteSupportInfo4 = siteSupportInfo2;
                        kSerializerArr = kSerializerArr2;
                    case 0:
                        siteSupportInfo2 = siteSupportInfo4;
                        kSerializerArr2 = kSerializerArr;
                        list22 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], list22);
                        i6 |= 1;
                        list24 = list24;
                        siteSupportInfo4 = siteSupportInfo2;
                        kSerializerArr = kSerializerArr2;
                    case 1:
                        i6 |= 2;
                        list24 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], list24);
                        siteSupportInfo4 = siteSupportInfo4;
                    case 2:
                        list9 = list24;
                        list23 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], list23);
                        i6 |= 4;
                        list24 = list9;
                    case 3:
                        list9 = list24;
                        list21 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], list21);
                        i6 |= 8;
                        list24 = list9;
                    case 4:
                        list9 = list24;
                        list19 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], list19);
                        i6 |= 16;
                        list24 = list9;
                    case 5:
                        list9 = list24;
                        list20 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], list20);
                        i6 |= 32;
                        list24 = list9;
                    case 6:
                        list9 = list24;
                        list18 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], list18);
                        i6 |= 64;
                        list24 = list9;
                    case 7:
                        list9 = list24;
                        ageClassifications3 = (AgeClassifications) beginStructure.decodeSerializableElement(serialDescriptor, 7, AgeClassifications$$serializer.INSTANCE, ageClassifications3);
                        i6 |= 128;
                        list24 = list9;
                    case 8:
                        list9 = list24;
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i6 |= 256;
                        list24 = list9;
                    case 9:
                        list9 = list24;
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str4);
                        i6 |= 512;
                        list24 = list9;
                    case 10:
                        list9 = list24;
                        site3 = (Site) beginStructure.decodeSerializableElement(serialDescriptor, 10, kSerializerArr[10], site3);
                        i6 |= 1024;
                        list24 = list9;
                    case 11:
                        list9 = list24;
                        siteSupportInfo4 = (SiteSupportInfo) beginStructure.decodeSerializableElement(serialDescriptor, 11, SiteSupportInfo$$serializer.INSTANCE, siteSupportInfo4);
                        i6 |= 2048;
                        list24 = list9;
                    case 12:
                        list17 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 12, kSerializerArr[12], list17);
                        i6 |= 4096;
                        list24 = list24;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list22;
            i5 = i6;
            list2 = list24;
            str = str4;
            site = site3;
            list3 = list17;
            ageClassifications = ageClassifications3;
            list4 = list18;
            list5 = list19;
            list6 = list20;
            list7 = list21;
            list8 = list23;
            siteSupportInfo = siteSupportInfo4;
            str2 = str5;
        }
        beginStructure.endStructure(serialDescriptor);
        return new LocalizedSiteConfiguration(i5, list, list2, list8, list7, list5, list6, list4, ageClassifications, str2, str, site, siteSupportInfo, list3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, LocalizedSiteConfiguration value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        LocalizedSiteConfiguration.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
