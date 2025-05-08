package dk.molslinjen.domain.model.saleOnBoard;

import dk.molslinjen.api.helpers.serializers.LocalDateTimeSerializer;
import dk.molslinjen.domain.model.booking.SaleOnBoardContactInfo;
import dk.molslinjen.domain.model.booking.SaleOnBoardContactInfo$$serializer;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
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
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class SaleOnBoardOrder$$serializer implements GeneratedSerializer<SaleOnBoardOrder> {
    public static final SaleOnBoardOrder$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SaleOnBoardOrder$$serializer saleOnBoardOrder$$serializer = new SaleOnBoardOrder$$serializer();
        INSTANCE = saleOnBoardOrder$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder", saleOnBoardOrder$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("orderNumber", false);
        pluginGeneratedSerialDescriptor.addElement("startDateTime", false);
        pluginGeneratedSerialDescriptor.addElement("endDateTime", false);
        pluginGeneratedSerialDescriptor.addElement("departure", false);
        pluginGeneratedSerialDescriptor.addElement("status", false);
        pluginGeneratedSerialDescriptor.addElement("lineItems", false);
        pluginGeneratedSerialDescriptor.addElement("shopImageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("shopLocation", false);
        pluginGeneratedSerialDescriptor.addElement("contactInfo", false);
        pluginGeneratedSerialDescriptor.addElement("notificationType", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SaleOnBoardOrder$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = SaleOnBoardOrder.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[4];
        KSerializer<?> kSerializer2 = kSerializerArr[5];
        KSerializer<?> kSerializer3 = kSerializerArr[9];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        LocalDateTimeSerializer localDateTimeSerializer = LocalDateTimeSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, localDateTimeSerializer, localDateTimeSerializer, SaleOnBoardDeparture$$serializer.INSTANCE, kSerializer, kSerializer2, stringSerializer, stringSerializer, SaleOnBoardContactInfo$$serializer.INSTANCE, kSerializer3};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0094. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final SaleOnBoardOrder deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        List list;
        SaleOnBoardOrder.OrderStatus orderStatus;
        NotificationType notificationType;
        SaleOnBoardContactInfo saleOnBoardContactInfo;
        SaleOnBoardDeparture saleOnBoardDeparture;
        LocalDateTime localDateTime;
        String str;
        LocalDateTime localDateTime2;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = SaleOnBoardOrder.$childSerializers;
        int i6 = 7;
        String str4 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            LocalDateTimeSerializer localDateTimeSerializer = LocalDateTimeSerializer.INSTANCE;
            LocalDateTime localDateTime3 = (LocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 1, localDateTimeSerializer, null);
            LocalDateTime localDateTime4 = (LocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 2, localDateTimeSerializer, null);
            SaleOnBoardDeparture saleOnBoardDeparture2 = (SaleOnBoardDeparture) beginStructure.decodeSerializableElement(serialDescriptor, 3, SaleOnBoardDeparture$$serializer.INSTANCE, null);
            SaleOnBoardOrder.OrderStatus orderStatus2 = (SaleOnBoardOrder.OrderStatus) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 6);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 7);
            SaleOnBoardContactInfo saleOnBoardContactInfo2 = (SaleOnBoardContactInfo) beginStructure.decodeSerializableElement(serialDescriptor, 8, SaleOnBoardContactInfo$$serializer.INSTANCE, null);
            notificationType = (NotificationType) beginStructure.decodeSerializableElement(serialDescriptor, 9, kSerializerArr[9], null);
            str = decodeStringElement;
            str3 = decodeStringElement3;
            str2 = decodeStringElement2;
            saleOnBoardDeparture = saleOnBoardDeparture2;
            saleOnBoardContactInfo = saleOnBoardContactInfo2;
            localDateTime = localDateTime4;
            i5 = 1023;
            list = list2;
            orderStatus = orderStatus2;
            localDateTime2 = localDateTime3;
        } else {
            boolean z5 = true;
            int i7 = 0;
            List list3 = null;
            SaleOnBoardOrder.OrderStatus orderStatus3 = null;
            NotificationType notificationType2 = null;
            SaleOnBoardContactInfo saleOnBoardContactInfo3 = null;
            SaleOnBoardDeparture saleOnBoardDeparture3 = null;
            LocalDateTime localDateTime5 = null;
            LocalDateTime localDateTime6 = null;
            String str5 = null;
            String str6 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        i6 = 7;
                    case 0:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i7 |= 1;
                        i6 = 7;
                    case 1:
                        localDateTime6 = (LocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalDateTimeSerializer.INSTANCE, localDateTime6);
                        i7 |= 2;
                        i6 = 7;
                    case 2:
                        localDateTime5 = (LocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 2, LocalDateTimeSerializer.INSTANCE, localDateTime5);
                        i7 |= 4;
                        i6 = 7;
                    case 3:
                        saleOnBoardDeparture3 = (SaleOnBoardDeparture) beginStructure.decodeSerializableElement(serialDescriptor, 3, SaleOnBoardDeparture$$serializer.INSTANCE, saleOnBoardDeparture3);
                        i7 |= 8;
                        i6 = 7;
                    case 4:
                        orderStatus3 = (SaleOnBoardOrder.OrderStatus) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], orderStatus3);
                        i7 |= 16;
                        i6 = 7;
                    case 5:
                        list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], list3);
                        i7 |= 32;
                        i6 = 7;
                    case 6:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i7 |= 64;
                    case 7:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, i6);
                        i7 |= 128;
                    case 8:
                        saleOnBoardContactInfo3 = (SaleOnBoardContactInfo) beginStructure.decodeSerializableElement(serialDescriptor, 8, SaleOnBoardContactInfo$$serializer.INSTANCE, saleOnBoardContactInfo3);
                        i7 |= 256;
                    case 9:
                        notificationType2 = (NotificationType) beginStructure.decodeSerializableElement(serialDescriptor, 9, kSerializerArr[9], notificationType2);
                        i7 |= 512;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i7;
            list = list3;
            orderStatus = orderStatus3;
            notificationType = notificationType2;
            saleOnBoardContactInfo = saleOnBoardContactInfo3;
            saleOnBoardDeparture = saleOnBoardDeparture3;
            localDateTime = localDateTime5;
            str = str4;
            localDateTime2 = localDateTime6;
            str2 = str5;
            str3 = str6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SaleOnBoardOrder(i5, str, localDateTime2, localDateTime, saleOnBoardDeparture, orderStatus, list, str2, str3, saleOnBoardContactInfo, notificationType, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SaleOnBoardOrder value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SaleOnBoardOrder.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
