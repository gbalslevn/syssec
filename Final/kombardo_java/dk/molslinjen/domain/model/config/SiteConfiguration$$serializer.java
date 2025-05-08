package dk.molslinjen.domain.model.config;

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
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/config/SiteConfiguration.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/config/SiteConfiguration;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class SiteConfiguration$$serializer implements GeneratedSerializer<SiteConfiguration> {
    public static final SiteConfiguration$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SiteConfiguration$$serializer siteConfiguration$$serializer = new SiteConfiguration$$serializer();
        INSTANCE = siteConfiguration$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.config.SiteConfiguration", siteConfiguration$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("site", false);
        pluginGeneratedSerialDescriptor.addElement("danishConfiguration", false);
        pluginGeneratedSerialDescriptor.addElement("englishConfiguration", false);
        pluginGeneratedSerialDescriptor.addElement("swedishConfiguration", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SiteConfiguration$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = SiteConfiguration.$childSerializers;
        LocalizedSiteConfiguration$$serializer localizedSiteConfiguration$$serializer = LocalizedSiteConfiguration$$serializer.INSTANCE;
        return new KSerializer[]{kSerializerArr[0], localizedSiteConfiguration$$serializer, localizedSiteConfiguration$$serializer, localizedSiteConfiguration$$serializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final SiteConfiguration deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        Site site;
        LocalizedSiteConfiguration localizedSiteConfiguration;
        LocalizedSiteConfiguration localizedSiteConfiguration2;
        LocalizedSiteConfiguration localizedSiteConfiguration3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = SiteConfiguration.$childSerializers;
        Site site2 = null;
        if (beginStructure.decodeSequentially()) {
            Site site3 = (Site) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            LocalizedSiteConfiguration$$serializer localizedSiteConfiguration$$serializer = LocalizedSiteConfiguration$$serializer.INSTANCE;
            LocalizedSiteConfiguration localizedSiteConfiguration4 = (LocalizedSiteConfiguration) beginStructure.decodeSerializableElement(serialDescriptor, 1, localizedSiteConfiguration$$serializer, null);
            LocalizedSiteConfiguration localizedSiteConfiguration5 = (LocalizedSiteConfiguration) beginStructure.decodeSerializableElement(serialDescriptor, 2, localizedSiteConfiguration$$serializer, null);
            site = site3;
            localizedSiteConfiguration3 = (LocalizedSiteConfiguration) beginStructure.decodeSerializableElement(serialDescriptor, 3, localizedSiteConfiguration$$serializer, null);
            i5 = 15;
            localizedSiteConfiguration2 = localizedSiteConfiguration5;
            localizedSiteConfiguration = localizedSiteConfiguration4;
        } else {
            boolean z5 = true;
            int i6 = 0;
            LocalizedSiteConfiguration localizedSiteConfiguration6 = null;
            LocalizedSiteConfiguration localizedSiteConfiguration7 = null;
            LocalizedSiteConfiguration localizedSiteConfiguration8 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    site2 = (Site) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], site2);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    localizedSiteConfiguration6 = (LocalizedSiteConfiguration) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalizedSiteConfiguration$$serializer.INSTANCE, localizedSiteConfiguration6);
                    i6 |= 2;
                } else if (decodeElementIndex == 2) {
                    localizedSiteConfiguration7 = (LocalizedSiteConfiguration) beginStructure.decodeSerializableElement(serialDescriptor, 2, LocalizedSiteConfiguration$$serializer.INSTANCE, localizedSiteConfiguration7);
                    i6 |= 4;
                } else {
                    if (decodeElementIndex != 3) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    localizedSiteConfiguration8 = (LocalizedSiteConfiguration) beginStructure.decodeSerializableElement(serialDescriptor, 3, LocalizedSiteConfiguration$$serializer.INSTANCE, localizedSiteConfiguration8);
                    i6 |= 8;
                }
            }
            i5 = i6;
            site = site2;
            localizedSiteConfiguration = localizedSiteConfiguration6;
            localizedSiteConfiguration2 = localizedSiteConfiguration7;
            localizedSiteConfiguration3 = localizedSiteConfiguration8;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SiteConfiguration(i5, site, localizedSiteConfiguration, localizedSiteConfiguration2, localizedSiteConfiguration3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SiteConfiguration value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SiteConfiguration.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
