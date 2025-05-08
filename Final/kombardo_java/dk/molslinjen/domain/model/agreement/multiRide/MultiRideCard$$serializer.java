package dk.molslinjen.domain.model.agreement.multiRide;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/agreement/multiRide/MultiRideCard.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class MultiRideCard$$serializer implements GeneratedSerializer<MultiRideCard> {
    public static final MultiRideCard$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MultiRideCard$$serializer multiRideCard$$serializer = new MultiRideCard$$serializer();
        INSTANCE = multiRideCard$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard", multiRideCard$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("multiRideTypeId", false);
        pluginGeneratedSerialDescriptor.addElement("ticketType", false);
        pluginGeneratedSerialDescriptor.addElement("ticketTypeName", false);
        pluginGeneratedSerialDescriptor.addElement("enabledTransportations", false);
        pluginGeneratedSerialDescriptor.addElement("defaultTransportation", false);
        pluginGeneratedSerialDescriptor.addElement("remainingCharges", false);
        pluginGeneratedSerialDescriptor.addElement("customer", false);
        pluginGeneratedSerialDescriptor.addElement("allowedRouteIds", false);
        pluginGeneratedSerialDescriptor.addElement("canRefill", false);
        pluginGeneratedSerialDescriptor.addElement("validUntil", false);
        pluginGeneratedSerialDescriptor.addElement("chargesExpirySoonInternal", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MultiRideCard$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = MultiRideCard.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[2];
        KSerializer<?> kSerializer2 = kSerializerArr[4];
        KSerializer<?> kSerializer3 = kSerializerArr[8];
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(MultiRideChargesExpiry$$serializer.INSTANCE);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, kSerializer, stringSerializer, kSerializer2, MultiRideTransport$$serializer.INSTANCE, IntSerializer.INSTANCE, stringSerializer, kSerializer3, BooleanSerializer.INSTANCE, LocalDateWithTimeSerializer.INSTANCE, nullable};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00a7. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final MultiRideCard deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        String str;
        String str2;
        int i5;
        MultiRideChargesExpiry multiRideChargesExpiry;
        List list;
        LocalDate localDate;
        MultiRideTransport multiRideTransport;
        List list2;
        TicketCategoryType ticketCategoryType;
        String str3;
        String str4;
        boolean z5;
        int i6;
        int i7;
        int i8;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = MultiRideCard.$childSerializers;
        int i9 = 10;
        int i10 = 9;
        int i11 = 8;
        String str5 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            TicketCategoryType ticketCategoryType2 = (TicketCategoryType) beginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 3);
            List list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            MultiRideTransport multiRideTransport2 = (MultiRideTransport) beginStructure.decodeSerializableElement(serialDescriptor, 5, MultiRideTransport$$serializer.INSTANCE, null);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 6);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 7);
            List list4 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 8, kSerializerArr[8], null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 9);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 10, LocalDateWithTimeSerializer.INSTANCE, null);
            list = list4;
            str2 = decodeStringElement;
            multiRideChargesExpiry = (MultiRideChargesExpiry) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, MultiRideChargesExpiry$$serializer.INSTANCE, null);
            localDate = localDate2;
            z5 = decodeBooleanElement;
            str4 = decodeStringElement4;
            i6 = decodeIntElement;
            multiRideTransport = multiRideTransport2;
            str3 = decodeStringElement3;
            i5 = 4095;
            list2 = list3;
            ticketCategoryType = ticketCategoryType2;
            str = decodeStringElement2;
        } else {
            String str6 = null;
            MultiRideChargesExpiry multiRideChargesExpiry2 = null;
            List list5 = null;
            LocalDate localDate3 = null;
            MultiRideTransport multiRideTransport3 = null;
            String str7 = null;
            String str8 = null;
            boolean z6 = true;
            int i12 = 0;
            boolean z7 = false;
            int i13 = 0;
            List list6 = null;
            TicketCategoryType ticketCategoryType3 = null;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z6 = false;
                    case 0:
                        i12 |= 1;
                        i11 = i11;
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i9 = 10;
                        i10 = 9;
                    case 1:
                        i7 = i11;
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i12 |= 2;
                        i11 = i7;
                        i9 = 10;
                        i10 = 9;
                    case 2:
                        i7 = i11;
                        ticketCategoryType3 = (TicketCategoryType) beginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], ticketCategoryType3);
                        i12 |= 4;
                        i11 = i7;
                        i9 = 10;
                        i10 = 9;
                    case 3:
                        i7 = i11;
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i12 |= 8;
                        i11 = i7;
                        i9 = 10;
                        i10 = 9;
                    case 4:
                        i7 = i11;
                        list6 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], list6);
                        i12 |= 16;
                        i11 = i7;
                        i9 = 10;
                        i10 = 9;
                    case 5:
                        i7 = i11;
                        multiRideTransport3 = (MultiRideTransport) beginStructure.decodeSerializableElement(serialDescriptor, 5, MultiRideTransport$$serializer.INSTANCE, multiRideTransport3);
                        i12 |= 32;
                        i11 = i7;
                        i9 = 10;
                        i10 = 9;
                    case 6:
                        i8 = i11;
                        i13 = beginStructure.decodeIntElement(serialDescriptor, 6);
                        i12 |= 64;
                        i11 = i8;
                        i9 = 10;
                    case 7:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i12 |= 128;
                        i11 = i11;
                        i9 = 10;
                    case 8:
                        i8 = i11;
                        list5 = (List) beginStructure.decodeSerializableElement(serialDescriptor, i8, kSerializerArr[i8], list5);
                        i12 |= 256;
                        i11 = i8;
                        i9 = 10;
                    case 9:
                        z7 = beginStructure.decodeBooleanElement(serialDescriptor, i10);
                        i12 |= 512;
                        i11 = 8;
                    case 10:
                        localDate3 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, i9, LocalDateWithTimeSerializer.INSTANCE, localDate3);
                        i12 |= 1024;
                        i11 = 8;
                    case 11:
                        multiRideChargesExpiry2 = (MultiRideChargesExpiry) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, MultiRideChargesExpiry$$serializer.INSTANCE, multiRideChargesExpiry2);
                        i12 |= 2048;
                        i11 = 8;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str6;
            str2 = str5;
            i5 = i12;
            multiRideChargesExpiry = multiRideChargesExpiry2;
            list = list5;
            localDate = localDate3;
            multiRideTransport = multiRideTransport3;
            list2 = list6;
            ticketCategoryType = ticketCategoryType3;
            str3 = str7;
            str4 = str8;
            z5 = z7;
            i6 = i13;
        }
        beginStructure.endStructure(serialDescriptor);
        return new MultiRideCard(i5, str2, str, ticketCategoryType, str3, list2, multiRideTransport, i6, str4, list, z5, localDate, multiRideChargesExpiry, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, MultiRideCard value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        MultiRideCard.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
