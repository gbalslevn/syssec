package dk.molslinjen.api.services.multiRide.response;

import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO$$serializer;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/multiRide/response/MultiRideCardSummaryResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/multiRide/response/MultiRideCardSummaryResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class MultiRideCardSummaryResponseDTO$$serializer implements GeneratedSerializer<MultiRideCardSummaryResponseDTO> {
    public static final MultiRideCardSummaryResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MultiRideCardSummaryResponseDTO$$serializer multiRideCardSummaryResponseDTO$$serializer = new MultiRideCardSummaryResponseDTO$$serializer();
        INSTANCE = multiRideCardSummaryResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.multiRide.response.MultiRideCardSummaryResponseDTO", multiRideCardSummaryResponseDTO$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("cardNumber", false);
        pluginGeneratedSerialDescriptor.addElement("cardType", false);
        pluginGeneratedSerialDescriptor.addElement("totalPrice", false);
        pluginGeneratedSerialDescriptor.addElement("numberOfTickets", false);
        pluginGeneratedSerialDescriptor.addElement("validUntil", false);
        pluginGeneratedSerialDescriptor.addElement("category", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MultiRideCardSummaryResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), stringSerializer, PriceWithCurrencyDTO$$serializer.INSTANCE, IntSerializer.INSTANCE, LocalDateWithTimeSerializer.INSTANCE, MultiRideTicketCategoryResponseDTO$$serializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0062. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final MultiRideCardSummaryResponseDTO deserialize(Decoder decoder) {
        int i5;
        int i6;
        String str;
        String str2;
        PriceWithCurrencyDTO priceWithCurrencyDTO;
        LocalDate localDate;
        MultiRideTicketCategoryResponseDTO multiRideTicketCategoryResponseDTO;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i7 = 5;
        if (beginStructure.decodeSequentially()) {
            String str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            PriceWithCurrencyDTO priceWithCurrencyDTO2 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, PriceWithCurrencyDTO$$serializer.INSTANCE, null);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 3);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 4, LocalDateWithTimeSerializer.INSTANCE, null);
            str = str3;
            multiRideTicketCategoryResponseDTO = (MultiRideTicketCategoryResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 5, MultiRideTicketCategoryResponseDTO$$serializer.INSTANCE, null);
            i5 = decodeIntElement;
            localDate = localDate2;
            priceWithCurrencyDTO = priceWithCurrencyDTO2;
            str2 = decodeStringElement;
            i6 = 63;
        } else {
            boolean z5 = true;
            int i8 = 0;
            String str4 = null;
            String str5 = null;
            PriceWithCurrencyDTO priceWithCurrencyDTO3 = null;
            LocalDate localDate3 = null;
            MultiRideTicketCategoryResponseDTO multiRideTicketCategoryResponseDTO2 = null;
            int i9 = 0;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        i7 = 5;
                    case 0:
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str4);
                        i9 |= 1;
                        i7 = 5;
                    case 1:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i9 |= 2;
                    case 2:
                        priceWithCurrencyDTO3 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO3);
                        i9 |= 4;
                    case 3:
                        i8 = beginStructure.decodeIntElement(serialDescriptor, 3);
                        i9 |= 8;
                    case 4:
                        localDate3 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 4, LocalDateWithTimeSerializer.INSTANCE, localDate3);
                        i9 |= 16;
                    case 5:
                        multiRideTicketCategoryResponseDTO2 = (MultiRideTicketCategoryResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, i7, MultiRideTicketCategoryResponseDTO$$serializer.INSTANCE, multiRideTicketCategoryResponseDTO2);
                        i9 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i8;
            i6 = i9;
            str = str4;
            str2 = str5;
            priceWithCurrencyDTO = priceWithCurrencyDTO3;
            localDate = localDate3;
            multiRideTicketCategoryResponseDTO = multiRideTicketCategoryResponseDTO2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new MultiRideCardSummaryResponseDTO(i6, str, str2, priceWithCurrencyDTO, i5, localDate, multiRideTicketCategoryResponseDTO, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, MultiRideCardSummaryResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        MultiRideCardSummaryResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
