package dk.molslinjen.api.services.booking.response.booking;

import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.services.booking.response.booking.BookingHeaderResponseDTO;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO.RefundInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO$RefundInfo;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BookingHeaderResponseDTO$RefundInfo$$serializer implements GeneratedSerializer<BookingHeaderResponseDTO.RefundInfo> {
    public static final BookingHeaderResponseDTO$RefundInfo$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BookingHeaderResponseDTO$RefundInfo$$serializer bookingHeaderResponseDTO$RefundInfo$$serializer = new BookingHeaderResponseDTO$RefundInfo$$serializer();
        INSTANCE = bookingHeaderResponseDTO$RefundInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.response.booking.BookingHeaderResponseDTO.RefundInfo", bookingHeaderResponseDTO$RefundInfo$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("isRefunded", false);
        pluginGeneratedSerialDescriptor.addElement("refundDate", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BookingHeaderResponseDTO$RefundInfo$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(LocalDateWithTimeSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final BookingHeaderResponseDTO.RefundInfo deserialize(Decoder decoder) {
        boolean z5;
        LocalDate localDate;
        int i5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            z5 = beginStructure.decodeBooleanElement(serialDescriptor, 0);
            localDate = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LocalDateWithTimeSerializer.INSTANCE, null);
            i5 = 3;
        } else {
            boolean z6 = true;
            z5 = false;
            int i6 = 0;
            LocalDate localDate2 = null;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z6 = false;
                } else if (decodeElementIndex == 0) {
                    z5 = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                    i6 |= 1;
                } else {
                    if (decodeElementIndex != 1) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    localDate2 = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LocalDateWithTimeSerializer.INSTANCE, localDate2);
                    i6 |= 2;
                }
            }
            localDate = localDate2;
            i5 = i6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BookingHeaderResponseDTO.RefundInfo(i5, z5, localDate, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BookingHeaderResponseDTO.RefundInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BookingHeaderResponseDTO.RefundInfo.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
