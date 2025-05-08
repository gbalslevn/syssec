package dk.molslinjen.api.services.booking.request;

import dk.molslinjen.api.services.booking.request.BookRequestParameters;
import dk.molslinjen.api.services.booking.request.PaymentTypeRequestParameters;
import dk.molslinjen.api.services.booking.response.booking.ApiAppPaymentRedirectDetailsDTO;
import dk.molslinjen.api.services.booking.response.booking.ApiAppPaymentRedirectDetailsDTO$$serializer;
import dk.molslinjen.api.shared.request.PaymentDataRequestParameters;
import dk.molslinjen.api.shared.request.PaymentDataRequestParameters$$serializer;
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
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/request/BookRequestParameters.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BookRequestParameters$$serializer implements GeneratedSerializer<BookRequestParameters> {
    public static final BookRequestParameters$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BookRequestParameters$$serializer bookRequestParameters$$serializer = new BookRequestParameters$$serializer();
        INSTANCE = bookRequestParameters$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.request.BookRequestParameters", bookRequestParameters$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("booking", false);
        pluginGeneratedSerialDescriptor.addElement("paymentType", false);
        pluginGeneratedSerialDescriptor.addElement("subscribeToNewsletter", false);
        pluginGeneratedSerialDescriptor.addElement("subscribeToPromotions", false);
        pluginGeneratedSerialDescriptor.addElement("paymentRedirectDetails", false);
        pluginGeneratedSerialDescriptor.addElement("paymentData", false);
        pluginGeneratedSerialDescriptor.addElement("version", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BookRequestParameters$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{BookRequestParameters$BookingRequestParameters$$serializer.INSTANCE, PaymentTypeRequestParameters.Serializer.INSTANCE, booleanSerializer, booleanSerializer, ApiAppPaymentRedirectDetailsDTO$$serializer.INSTANCE, PaymentDataRequestParameters$$serializer.INSTANCE, StringSerializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x006c. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final BookRequestParameters deserialize(Decoder decoder) {
        boolean z5;
        boolean z6;
        int i5;
        BookRequestParameters.BookingRequestParameters bookingRequestParameters;
        PaymentTypeRequestParameters paymentTypeRequestParameters;
        ApiAppPaymentRedirectDetailsDTO apiAppPaymentRedirectDetailsDTO;
        PaymentDataRequestParameters paymentDataRequestParameters;
        String str;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i6 = 6;
        if (beginStructure.decodeSequentially()) {
            BookRequestParameters.BookingRequestParameters bookingRequestParameters2 = (BookRequestParameters.BookingRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 0, BookRequestParameters$BookingRequestParameters$$serializer.INSTANCE, null);
            PaymentTypeRequestParameters paymentTypeRequestParameters2 = (PaymentTypeRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 1, PaymentTypeRequestParameters.Serializer.INSTANCE, null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 2);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
            ApiAppPaymentRedirectDetailsDTO apiAppPaymentRedirectDetailsDTO2 = (ApiAppPaymentRedirectDetailsDTO) beginStructure.decodeSerializableElement(serialDescriptor, 4, ApiAppPaymentRedirectDetailsDTO$$serializer.INSTANCE, null);
            PaymentDataRequestParameters paymentDataRequestParameters2 = (PaymentDataRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 5, PaymentDataRequestParameters$$serializer.INSTANCE, null);
            bookingRequestParameters = bookingRequestParameters2;
            str = beginStructure.decodeStringElement(serialDescriptor, 6);
            paymentDataRequestParameters = paymentDataRequestParameters2;
            z5 = decodeBooleanElement2;
            apiAppPaymentRedirectDetailsDTO = apiAppPaymentRedirectDetailsDTO2;
            z6 = decodeBooleanElement;
            paymentTypeRequestParameters = paymentTypeRequestParameters2;
            i5 = 127;
        } else {
            boolean z7 = true;
            boolean z8 = false;
            int i7 = 0;
            BookRequestParameters.BookingRequestParameters bookingRequestParameters3 = null;
            PaymentTypeRequestParameters paymentTypeRequestParameters3 = null;
            ApiAppPaymentRedirectDetailsDTO apiAppPaymentRedirectDetailsDTO3 = null;
            PaymentDataRequestParameters paymentDataRequestParameters3 = null;
            String str2 = null;
            boolean z9 = false;
            while (z7) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z7 = false;
                        i6 = 6;
                    case 0:
                        bookingRequestParameters3 = (BookRequestParameters.BookingRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 0, BookRequestParameters$BookingRequestParameters$$serializer.INSTANCE, bookingRequestParameters3);
                        i7 |= 1;
                        i6 = 6;
                    case 1:
                        paymentTypeRequestParameters3 = (PaymentTypeRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 1, PaymentTypeRequestParameters.Serializer.INSTANCE, paymentTypeRequestParameters3);
                        i7 |= 2;
                    case 2:
                        z9 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                        i7 |= 4;
                    case 3:
                        z8 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                        i7 |= 8;
                    case 4:
                        apiAppPaymentRedirectDetailsDTO3 = (ApiAppPaymentRedirectDetailsDTO) beginStructure.decodeSerializableElement(serialDescriptor, 4, ApiAppPaymentRedirectDetailsDTO$$serializer.INSTANCE, apiAppPaymentRedirectDetailsDTO3);
                        i7 |= 16;
                    case 5:
                        paymentDataRequestParameters3 = (PaymentDataRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 5, PaymentDataRequestParameters$$serializer.INSTANCE, paymentDataRequestParameters3);
                        i7 |= 32;
                    case 6:
                        str2 = beginStructure.decodeStringElement(serialDescriptor, i6);
                        i7 |= 64;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z5 = z8;
            z6 = z9;
            i5 = i7;
            bookingRequestParameters = bookingRequestParameters3;
            paymentTypeRequestParameters = paymentTypeRequestParameters3;
            apiAppPaymentRedirectDetailsDTO = apiAppPaymentRedirectDetailsDTO3;
            paymentDataRequestParameters = paymentDataRequestParameters3;
            str = str2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BookRequestParameters(i5, bookingRequestParameters, paymentTypeRequestParameters, z6, z5, apiAppPaymentRedirectDetailsDTO, paymentDataRequestParameters, str, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BookRequestParameters value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BookRequestParameters.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
