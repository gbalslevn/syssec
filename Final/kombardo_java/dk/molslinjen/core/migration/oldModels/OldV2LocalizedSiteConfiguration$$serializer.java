package dk.molslinjen.core.migration.oldModels;

import dk.molslinjen.domain.model.config.AgeClassifications;
import dk.molslinjen.domain.model.config.AgeClassifications$$serializer;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.SiteSupportInfo;
import dk.molslinjen.domain.model.config.SiteSupportInfo$$serializer;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/core/migration/oldModels/OldV2LocalizedSiteConfiguration.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/core/migration/oldModels/OldV2LocalizedSiteConfiguration;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class OldV2LocalizedSiteConfiguration$$serializer implements GeneratedSerializer<OldV2LocalizedSiteConfiguration> {
    public static final int $stable;
    public static final OldV2LocalizedSiteConfiguration$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        OldV2LocalizedSiteConfiguration$$serializer oldV2LocalizedSiteConfiguration$$serializer = new OldV2LocalizedSiteConfiguration$$serializer();
        INSTANCE = oldV2LocalizedSiteConfiguration$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.core.migration.oldModels.OldV2LocalizedSiteConfiguration", oldV2LocalizedSiteConfiguration$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("routes", false);
        pluginGeneratedSerialDescriptor.addElement("transportations", false);
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
        $stable = 8;
    }

    private OldV2LocalizedSiteConfiguration$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = OldV2LocalizedSiteConfiguration.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[0];
        KSerializer<?> kSerializer2 = kSerializerArr[1];
        KSerializer<?> kSerializer3 = kSerializerArr[2];
        KSerializer<?> kSerializer4 = kSerializerArr[3];
        KSerializer<?> kSerializer5 = kSerializerArr[4];
        KSerializer<?> kSerializer6 = kSerializerArr[5];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{kSerializer, kSerializer2, kSerializer3, kSerializer4, kSerializer5, kSerializer6, AgeClassifications$$serializer.INSTANCE, stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), kSerializerArr[9], SiteSupportInfo$$serializer.INSTANCE, kSerializerArr[11]};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00bc. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final OldV2LocalizedSiteConfiguration deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        List list;
        Site site;
        String str;
        SiteSupportInfo siteSupportInfo;
        int i5;
        List list2;
        AgeClassifications ageClassifications;
        List list3;
        List list4;
        List list5;
        List list6;
        List list7;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = OldV2LocalizedSiteConfiguration.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            List list8 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            List list9 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            List list10 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            List list11 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
            List list12 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            List list13 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
            AgeClassifications ageClassifications2 = (AgeClassifications) beginStructure.decodeSerializableElement(serialDescriptor, 6, AgeClassifications$$serializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 7);
            String str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, null);
            Site site2 = (Site) beginStructure.decodeSerializableElement(serialDescriptor, 9, kSerializerArr[9], null);
            SiteSupportInfo siteSupportInfo2 = (SiteSupportInfo) beginStructure.decodeSerializableElement(serialDescriptor, 10, SiteSupportInfo$$serializer.INSTANCE, null);
            list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 11, kSerializerArr[11], null);
            list = list8;
            siteSupportInfo = siteSupportInfo2;
            str2 = decodeStringElement;
            ageClassifications = ageClassifications2;
            str = str3;
            i5 = 4095;
            site = site2;
            list4 = list13;
            list5 = list11;
            list3 = list12;
            list6 = list10;
            list7 = list9;
        } else {
            int i6 = 11;
            Site site3 = null;
            String str4 = null;
            SiteSupportInfo siteSupportInfo3 = null;
            List list14 = null;
            AgeClassifications ageClassifications3 = null;
            List list15 = null;
            List list16 = null;
            List list17 = null;
            List list18 = null;
            String str5 = null;
            boolean z5 = true;
            List list19 = null;
            int i7 = 0;
            List list20 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        kSerializerArr = kSerializerArr;
                    case 0:
                        list18 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], list18);
                        i7 |= 1;
                        kSerializerArr = kSerializerArr;
                        i6 = 11;
                    case 1:
                        list20 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], list20);
                        i7 |= 2;
                        i6 = 11;
                    case 2:
                        list19 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], list19);
                        i7 |= 4;
                        i6 = 11;
                    case 3:
                        list17 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], list17);
                        i7 |= 8;
                        i6 = 11;
                    case 4:
                        list15 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], list15);
                        i7 |= 16;
                        i6 = 11;
                    case 5:
                        list16 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], list16);
                        i7 |= 32;
                        i6 = 11;
                    case 6:
                        ageClassifications3 = (AgeClassifications) beginStructure.decodeSerializableElement(serialDescriptor, 6, AgeClassifications$$serializer.INSTANCE, ageClassifications3);
                        i7 |= 64;
                        i6 = 11;
                    case 7:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i7 |= 128;
                        i6 = 11;
                    case 8:
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str4);
                        i7 |= 256;
                        i6 = 11;
                    case 9:
                        site3 = (Site) beginStructure.decodeSerializableElement(serialDescriptor, 9, kSerializerArr[9], site3);
                        i7 |= 512;
                        i6 = 11;
                    case 10:
                        siteSupportInfo3 = (SiteSupportInfo) beginStructure.decodeSerializableElement(serialDescriptor, 10, SiteSupportInfo$$serializer.INSTANCE, siteSupportInfo3);
                        i7 |= 1024;
                        i6 = 11;
                    case 11:
                        list14 = (List) beginStructure.decodeSerializableElement(serialDescriptor, i6, kSerializerArr[i6], list14);
                        i7 |= 2048;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list18;
            site = site3;
            str = str4;
            siteSupportInfo = siteSupportInfo3;
            i5 = i7;
            list2 = list14;
            ageClassifications = ageClassifications3;
            list3 = list15;
            list4 = list16;
            list5 = list17;
            list6 = list19;
            list7 = list20;
            str2 = str5;
        }
        beginStructure.endStructure(serialDescriptor);
        return new OldV2LocalizedSiteConfiguration(i5, list, list7, list6, list5, list3, list4, ageClassifications, str2, str, site, siteSupportInfo, list2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, OldV2LocalizedSiteConfiguration value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        OldV2LocalizedSiteConfiguration.write$Self$app_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
