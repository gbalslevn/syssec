package dk.molslinjen.api.services.newsletters.response;

import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.newsletters.response.NewslettersSubscriptionsResponseDTO;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/newsletters/response/NewslettersSubscriptionsResponseDTO.NewsletterSubscriptionDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/newsletters/response/NewslettersSubscriptionsResponseDTO$NewsletterSubscriptionDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class NewslettersSubscriptionsResponseDTO$NewsletterSubscriptionDTO$$serializer implements GeneratedSerializer<NewslettersSubscriptionsResponseDTO.NewsletterSubscriptionDTO> {
    public static final NewslettersSubscriptionsResponseDTO$NewsletterSubscriptionDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        NewslettersSubscriptionsResponseDTO$NewsletterSubscriptionDTO$$serializer newslettersSubscriptionsResponseDTO$NewsletterSubscriptionDTO$$serializer = new NewslettersSubscriptionsResponseDTO$NewsletterSubscriptionDTO$$serializer();
        INSTANCE = newslettersSubscriptionsResponseDTO$NewsletterSubscriptionDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.newsletters.response.NewslettersSubscriptionsResponseDTO.NewsletterSubscriptionDTO", newslettersSubscriptionsResponseDTO$NewsletterSubscriptionDTO$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("site", false);
        pluginGeneratedSerialDescriptor.addElement("allowsNewsletters", false);
        pluginGeneratedSerialDescriptor.addElement("allowsPromotions", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private NewslettersSubscriptionsResponseDTO$NewsletterSubscriptionDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = NewslettersSubscriptionsResponseDTO.NewsletterSubscriptionDTO.$childSerializers;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{kSerializerArr[0], booleanSerializer, booleanSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final NewslettersSubscriptionsResponseDTO.NewsletterSubscriptionDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        boolean z5;
        boolean z6;
        int i5;
        SiteDTO siteDTO;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = NewslettersSubscriptionsResponseDTO.NewsletterSubscriptionDTO.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            siteDTO = (SiteDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            z5 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
            z6 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
            i5 = 7;
        } else {
            boolean z7 = true;
            boolean z8 = false;
            int i6 = 0;
            SiteDTO siteDTO2 = null;
            boolean z9 = false;
            while (z7) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z7 = false;
                } else if (decodeElementIndex == 0) {
                    siteDTO2 = (SiteDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], siteDTO2);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    z8 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                    i6 |= 2;
                } else {
                    if (decodeElementIndex != 2) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    z9 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                    i6 |= 4;
                }
            }
            z5 = z8;
            z6 = z9;
            i5 = i6;
            siteDTO = siteDTO2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new NewslettersSubscriptionsResponseDTO.NewsletterSubscriptionDTO(i5, siteDTO, z5, z6, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, NewslettersSubscriptionsResponseDTO.NewsletterSubscriptionDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        NewslettersSubscriptionsResponseDTO.NewsletterSubscriptionDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
