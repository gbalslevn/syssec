package dk.molslinjen.api.services.booking.request;

import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.services.account.passenger.response.GenderDTO;
import dk.molslinjen.api.services.booking.request.BookRequestParameters;
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
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/request/BookRequestParameters.PassengerDataRequestParameters.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerDataRequestParameters;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BookRequestParameters$PassengerDataRequestParameters$$serializer implements GeneratedSerializer<BookRequestParameters.PassengerDataRequestParameters> {
    public static final BookRequestParameters$PassengerDataRequestParameters$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BookRequestParameters$PassengerDataRequestParameters$$serializer bookRequestParameters$PassengerDataRequestParameters$$serializer = new BookRequestParameters$PassengerDataRequestParameters$$serializer();
        INSTANCE = bookRequestParameters$PassengerDataRequestParameters$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.request.BookRequestParameters.PassengerDataRequestParameters", bookRequestParameters$PassengerDataRequestParameters$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("birthDate", false);
        pluginGeneratedSerialDescriptor.addElement("firstName", false);
        pluginGeneratedSerialDescriptor.addElement("gender", false);
        pluginGeneratedSerialDescriptor.addElement("lastName", false);
        pluginGeneratedSerialDescriptor.addElement("nationality", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BookRequestParameters$PassengerDataRequestParameters$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{LocalDateWithTimeSerializer.INSTANCE, stringSerializer, GenderDTO.Serializer.INSTANCE, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final BookRequestParameters.PassengerDataRequestParameters deserialize(Decoder decoder) {
        int i5;
        LocalDate localDate;
        String str;
        GenderDTO genderDTO;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        LocalDate localDate2 = null;
        if (beginStructure.decodeSequentially()) {
            LocalDate localDate3 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 0, LocalDateWithTimeSerializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            GenderDTO genderDTO2 = (GenderDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, GenderDTO.Serializer.INSTANCE, null);
            localDate = localDate3;
            str2 = beginStructure.decodeStringElement(serialDescriptor, 3);
            str3 = beginStructure.decodeStringElement(serialDescriptor, 4);
            genderDTO = genderDTO2;
            str = decodeStringElement;
            i5 = 31;
        } else {
            boolean z5 = true;
            int i6 = 0;
            String str4 = null;
            GenderDTO genderDTO3 = null;
            String str5 = null;
            String str6 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    localDate2 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 0, LocalDateWithTimeSerializer.INSTANCE, localDate2);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    str4 = beginStructure.decodeStringElement(serialDescriptor, 1);
                    i6 |= 2;
                } else if (decodeElementIndex == 2) {
                    genderDTO3 = (GenderDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, GenderDTO.Serializer.INSTANCE, genderDTO3);
                    i6 |= 4;
                } else if (decodeElementIndex == 3) {
                    str5 = beginStructure.decodeStringElement(serialDescriptor, 3);
                    i6 |= 8;
                } else {
                    if (decodeElementIndex != 4) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    str6 = beginStructure.decodeStringElement(serialDescriptor, 4);
                    i6 |= 16;
                }
            }
            i5 = i6;
            localDate = localDate2;
            str = str4;
            genderDTO = genderDTO3;
            str2 = str5;
            str3 = str6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BookRequestParameters.PassengerDataRequestParameters(i5, localDate, str, genderDTO, str2, str3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BookRequestParameters.PassengerDataRequestParameters value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BookRequestParameters.PassengerDataRequestParameters.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
