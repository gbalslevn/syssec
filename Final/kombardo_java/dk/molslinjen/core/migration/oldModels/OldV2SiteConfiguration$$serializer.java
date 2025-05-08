package dk.molslinjen.core.migration.oldModels;

import dk.molslinjen.domain.model.config.Site;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/core/migration/oldModels/OldV2SiteConfiguration.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/core/migration/oldModels/OldV2SiteConfiguration;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class OldV2SiteConfiguration$$serializer implements GeneratedSerializer<OldV2SiteConfiguration> {
    public static final int $stable;
    public static final OldV2SiteConfiguration$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        OldV2SiteConfiguration$$serializer oldV2SiteConfiguration$$serializer = new OldV2SiteConfiguration$$serializer();
        INSTANCE = oldV2SiteConfiguration$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.core.migration.oldModels.OldV2SiteConfiguration", oldV2SiteConfiguration$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("site", false);
        pluginGeneratedSerialDescriptor.addElement("danishConfiguration", false);
        pluginGeneratedSerialDescriptor.addElement("englishConfiguration", false);
        pluginGeneratedSerialDescriptor.addElement("swedishConfiguration", false);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private OldV2SiteConfiguration$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = OldV2SiteConfiguration.$childSerializers;
        OldV2LocalizedSiteConfiguration$$serializer oldV2LocalizedSiteConfiguration$$serializer = OldV2LocalizedSiteConfiguration$$serializer.INSTANCE;
        return new KSerializer[]{kSerializerArr[0], oldV2LocalizedSiteConfiguration$$serializer, oldV2LocalizedSiteConfiguration$$serializer, oldV2LocalizedSiteConfiguration$$serializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final OldV2SiteConfiguration deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        Site site;
        OldV2LocalizedSiteConfiguration oldV2LocalizedSiteConfiguration;
        OldV2LocalizedSiteConfiguration oldV2LocalizedSiteConfiguration2;
        OldV2LocalizedSiteConfiguration oldV2LocalizedSiteConfiguration3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = OldV2SiteConfiguration.$childSerializers;
        Site site2 = null;
        if (beginStructure.decodeSequentially()) {
            Site site3 = (Site) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            OldV2LocalizedSiteConfiguration$$serializer oldV2LocalizedSiteConfiguration$$serializer = OldV2LocalizedSiteConfiguration$$serializer.INSTANCE;
            OldV2LocalizedSiteConfiguration oldV2LocalizedSiteConfiguration4 = (OldV2LocalizedSiteConfiguration) beginStructure.decodeSerializableElement(serialDescriptor, 1, oldV2LocalizedSiteConfiguration$$serializer, null);
            OldV2LocalizedSiteConfiguration oldV2LocalizedSiteConfiguration5 = (OldV2LocalizedSiteConfiguration) beginStructure.decodeSerializableElement(serialDescriptor, 2, oldV2LocalizedSiteConfiguration$$serializer, null);
            site = site3;
            oldV2LocalizedSiteConfiguration3 = (OldV2LocalizedSiteConfiguration) beginStructure.decodeSerializableElement(serialDescriptor, 3, oldV2LocalizedSiteConfiguration$$serializer, null);
            i5 = 15;
            oldV2LocalizedSiteConfiguration2 = oldV2LocalizedSiteConfiguration5;
            oldV2LocalizedSiteConfiguration = oldV2LocalizedSiteConfiguration4;
        } else {
            boolean z5 = true;
            int i6 = 0;
            OldV2LocalizedSiteConfiguration oldV2LocalizedSiteConfiguration6 = null;
            OldV2LocalizedSiteConfiguration oldV2LocalizedSiteConfiguration7 = null;
            OldV2LocalizedSiteConfiguration oldV2LocalizedSiteConfiguration8 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    site2 = (Site) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], site2);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    oldV2LocalizedSiteConfiguration6 = (OldV2LocalizedSiteConfiguration) beginStructure.decodeSerializableElement(serialDescriptor, 1, OldV2LocalizedSiteConfiguration$$serializer.INSTANCE, oldV2LocalizedSiteConfiguration6);
                    i6 |= 2;
                } else if (decodeElementIndex == 2) {
                    oldV2LocalizedSiteConfiguration7 = (OldV2LocalizedSiteConfiguration) beginStructure.decodeSerializableElement(serialDescriptor, 2, OldV2LocalizedSiteConfiguration$$serializer.INSTANCE, oldV2LocalizedSiteConfiguration7);
                    i6 |= 4;
                } else {
                    if (decodeElementIndex != 3) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    oldV2LocalizedSiteConfiguration8 = (OldV2LocalizedSiteConfiguration) beginStructure.decodeSerializableElement(serialDescriptor, 3, OldV2LocalizedSiteConfiguration$$serializer.INSTANCE, oldV2LocalizedSiteConfiguration8);
                    i6 |= 8;
                }
            }
            i5 = i6;
            site = site2;
            oldV2LocalizedSiteConfiguration = oldV2LocalizedSiteConfiguration6;
            oldV2LocalizedSiteConfiguration2 = oldV2LocalizedSiteConfiguration7;
            oldV2LocalizedSiteConfiguration3 = oldV2LocalizedSiteConfiguration8;
        }
        beginStructure.endStructure(serialDescriptor);
        return new OldV2SiteConfiguration(i5, site, oldV2LocalizedSiteConfiguration, oldV2LocalizedSiteConfiguration2, oldV2LocalizedSiteConfiguration3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, OldV2SiteConfiguration value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        OldV2SiteConfiguration.write$Self$app_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
