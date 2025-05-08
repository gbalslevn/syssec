package dk.molslinjen.domain.model.booking;

import com.sdk.growthbook.utils.Constants;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/booking/TicketCategory.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/booking/TicketCategory;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class TicketCategory$$serializer implements GeneratedSerializer<TicketCategory> {
    public static final TicketCategory$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        TicketCategory$$serializer ticketCategory$$serializer = new TicketCategory$$serializer();
        INSTANCE = ticketCategory$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.booking.TicketCategory", ticketCategory$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("subHeader", false);
        pluginGeneratedSerialDescriptor.addElement("descriptionItems", false);
        pluginGeneratedSerialDescriptor.addElement("shortDescriptionItems", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TicketCategory$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = TicketCategory.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[1];
        KSerializer<?> kSerializer2 = kSerializerArr[4];
        KSerializer<?> kSerializer3 = kSerializerArr[5];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, kSerializer, stringSerializer, stringSerializer, kSerializer2, kSerializer3};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0062. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final TicketCategory deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        String str;
        TicketCategoryType ticketCategoryType;
        String str2;
        String str3;
        List list;
        List list2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = TicketCategory.$childSerializers;
        String str4 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            TicketCategoryType ticketCategoryType2 = (TicketCategoryType) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 3);
            List list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
            str = decodeStringElement;
            str3 = decodeStringElement3;
            str2 = decodeStringElement2;
            i5 = 63;
            list = list3;
            ticketCategoryType = ticketCategoryType2;
        } else {
            boolean z5 = true;
            int i6 = 0;
            TicketCategoryType ticketCategoryType3 = null;
            String str5 = null;
            String str6 = null;
            List list4 = null;
            List list5 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                    case 0:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i6 |= 1;
                    case 1:
                        ticketCategoryType3 = (TicketCategoryType) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], ticketCategoryType3);
                        i6 |= 2;
                    case 2:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i6 |= 4;
                    case 3:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i6 |= 8;
                    case 4:
                        list4 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], list4);
                        i6 |= 16;
                    case 5:
                        list5 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], list5);
                        i6 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i6;
            str = str4;
            ticketCategoryType = ticketCategoryType3;
            str2 = str5;
            str3 = str6;
            list = list4;
            list2 = list5;
        }
        beginStructure.endStructure(serialDescriptor);
        return new TicketCategory(i5, str, ticketCategoryType, str2, str3, list, list2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, TicketCategory value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        TicketCategory.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
