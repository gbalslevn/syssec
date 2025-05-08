package dk.molslinjen.api.services.booking.request;

import dk.molslinjen.api.services.booking.request.BookRequestParameters;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/request/BookRequestParameters.BookingRequestParameters.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookingRequestParameters;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BookRequestParameters$BookingRequestParameters$$serializer implements GeneratedSerializer<BookRequestParameters.BookingRequestParameters> {
    public static final BookRequestParameters$BookingRequestParameters$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BookRequestParameters$BookingRequestParameters$$serializer bookRequestParameters$BookingRequestParameters$$serializer = new BookRequestParameters$BookingRequestParameters$$serializer();
        INSTANCE = bookRequestParameters$BookingRequestParameters$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.request.BookRequestParameters.BookingRequestParameters", bookRequestParameters$BookingRequestParameters$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("customerInfo", false);
        pluginGeneratedSerialDescriptor.addElement("tickets", false);
        pluginGeneratedSerialDescriptor.addElement("commuteAgreementId", false);
        pluginGeneratedSerialDescriptor.addElement("multiRide", false);
        pluginGeneratedSerialDescriptor.addElement("reservationId", false);
        pluginGeneratedSerialDescriptor.addElement("currency", false);
        pluginGeneratedSerialDescriptor.addElement("originalPhoneNumber", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BookRequestParameters$BookingRequestParameters$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = BookRequestParameters.BookingRequestParameters.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[1];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{BookRequestParameters$CustomerInfoRequestParameters$$serializer.INSTANCE, kSerializer, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(BookRequestParameters$MultiRideRequestParameters$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(stringSerializer), CurrencyTypeDTO.Serializer.INSTANCE, BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0076. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final BookRequestParameters.BookingRequestParameters deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        String str;
        CurrencyTypeDTO currencyTypeDTO;
        BookRequestParameters.CustomerInfoRequestParameters customerInfoRequestParameters;
        List list;
        String str2;
        BookRequestParameters.MultiRideRequestParameters multiRideRequestParameters;
        String str3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = BookRequestParameters.BookingRequestParameters.$childSerializers;
        int i6 = 6;
        int i7 = 5;
        BookRequestParameters.CustomerInfoRequestParameters customerInfoRequestParameters2 = null;
        if (beginStructure.decodeSequentially()) {
            BookRequestParameters.CustomerInfoRequestParameters customerInfoRequestParameters3 = (BookRequestParameters.CustomerInfoRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 0, BookRequestParameters$CustomerInfoRequestParameters$$serializer.INSTANCE, null);
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            BookRequestParameters.MultiRideRequestParameters multiRideRequestParameters2 = (BookRequestParameters.MultiRideRequestParameters) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BookRequestParameters$MultiRideRequestParameters$$serializer.INSTANCE, null);
            String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            CurrencyTypeDTO currencyTypeDTO2 = (CurrencyTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 5, CurrencyTypeDTO.Serializer.INSTANCE, null);
            list = list2;
            customerInfoRequestParameters = customerInfoRequestParameters3;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            currencyTypeDTO = currencyTypeDTO2;
            multiRideRequestParameters = multiRideRequestParameters2;
            str3 = str5;
            str2 = str4;
            i5 = 127;
        } else {
            boolean z5 = true;
            int i8 = 0;
            String str6 = null;
            CurrencyTypeDTO currencyTypeDTO3 = null;
            List list3 = null;
            String str7 = null;
            BookRequestParameters.MultiRideRequestParameters multiRideRequestParameters3 = null;
            String str8 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        i7 = 5;
                    case 0:
                        customerInfoRequestParameters2 = (BookRequestParameters.CustomerInfoRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 0, BookRequestParameters$CustomerInfoRequestParameters$$serializer.INSTANCE, customerInfoRequestParameters2);
                        i8 |= 1;
                        i6 = 6;
                        i7 = 5;
                    case 1:
                        list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], list3);
                        i8 |= 2;
                        i6 = 6;
                    case 2:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str7);
                        i8 |= 4;
                        i6 = 6;
                    case 3:
                        multiRideRequestParameters3 = (BookRequestParameters.MultiRideRequestParameters) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BookRequestParameters$MultiRideRequestParameters$$serializer.INSTANCE, multiRideRequestParameters3);
                        i8 |= 8;
                    case 4:
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str8);
                        i8 |= 16;
                    case 5:
                        currencyTypeDTO3 = (CurrencyTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, i7, CurrencyTypeDTO.Serializer.INSTANCE, currencyTypeDTO3);
                        i8 |= 32;
                    case 6:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i6, StringSerializer.INSTANCE, str6);
                        i8 |= 64;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i8;
            str = str6;
            currencyTypeDTO = currencyTypeDTO3;
            customerInfoRequestParameters = customerInfoRequestParameters2;
            list = list3;
            str2 = str7;
            multiRideRequestParameters = multiRideRequestParameters3;
            str3 = str8;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BookRequestParameters.BookingRequestParameters(i5, customerInfoRequestParameters, list, str2, multiRideRequestParameters, str3, currencyTypeDTO, str, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BookRequestParameters.BookingRequestParameters value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BookRequestParameters.BookingRequestParameters.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
