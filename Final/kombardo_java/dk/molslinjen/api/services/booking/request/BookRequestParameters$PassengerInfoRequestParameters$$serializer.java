package dk.molslinjen.api.services.booking.request;

import dk.molslinjen.api.services.booking.request.BookRequestParameters;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/request/BookRequestParameters.PassengerInfoRequestParameters.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerInfoRequestParameters;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BookRequestParameters$PassengerInfoRequestParameters$$serializer implements GeneratedSerializer<BookRequestParameters.PassengerInfoRequestParameters> {
    public static final BookRequestParameters$PassengerInfoRequestParameters$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BookRequestParameters$PassengerInfoRequestParameters$$serializer bookRequestParameters$PassengerInfoRequestParameters$$serializer = new BookRequestParameters$PassengerInfoRequestParameters$$serializer();
        INSTANCE = bookRequestParameters$PassengerInfoRequestParameters$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.request.BookRequestParameters.PassengerInfoRequestParameters", bookRequestParameters$PassengerInfoRequestParameters$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("adultCount", false);
        pluginGeneratedSerialDescriptor.addElement("childCount", false);
        pluginGeneratedSerialDescriptor.addElement("infantCount", false);
        pluginGeneratedSerialDescriptor.addElement("passengerData", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BookRequestParameters$PassengerInfoRequestParameters$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = BookRequestParameters.PassengerInfoRequestParameters.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[3];
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{intSerializer, intSerializer, intSerializer, kSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final BookRequestParameters.PassengerInfoRequestParameters deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        int i6;
        int i7;
        int i8;
        List list;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = BookRequestParameters.PassengerInfoRequestParameters.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 1);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 2);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
            i5 = decodeIntElement;
            i6 = decodeIntElement3;
            i7 = 15;
            i8 = decodeIntElement2;
        } else {
            boolean z5 = true;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            List list2 = null;
            int i12 = 0;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    i9 = beginStructure.decodeIntElement(serialDescriptor, 0);
                    i10 |= 1;
                } else if (decodeElementIndex == 1) {
                    i11 = beginStructure.decodeIntElement(serialDescriptor, 1);
                    i10 |= 2;
                } else if (decodeElementIndex == 2) {
                    i12 = beginStructure.decodeIntElement(serialDescriptor, 2);
                    i10 |= 4;
                } else {
                    if (decodeElementIndex != 3) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], list2);
                    i10 |= 8;
                }
            }
            i5 = i9;
            i6 = i12;
            i7 = i10;
            i8 = i11;
            list = list2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BookRequestParameters.PassengerInfoRequestParameters(i7, i5, i8, i6, list, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BookRequestParameters.PassengerInfoRequestParameters value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BookRequestParameters.PassengerInfoRequestParameters.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
