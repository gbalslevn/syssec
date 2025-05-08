package dk.molslinjen.api.services.booking.request;

import dk.molslinjen.api.services.booking.request.BookRequestParameters;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/request/BookRequestParameters.CustomerInfoRequestParameters.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$CustomerInfoRequestParameters;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BookRequestParameters$CustomerInfoRequestParameters$$serializer implements GeneratedSerializer<BookRequestParameters.CustomerInfoRequestParameters> {
    public static final BookRequestParameters$CustomerInfoRequestParameters$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BookRequestParameters$CustomerInfoRequestParameters$$serializer bookRequestParameters$CustomerInfoRequestParameters$$serializer = new BookRequestParameters$CustomerInfoRequestParameters$$serializer();
        INSTANCE = bookRequestParameters$CustomerInfoRequestParameters$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.request.BookRequestParameters.CustomerInfoRequestParameters", bookRequestParameters$CustomerInfoRequestParameters$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("email", false);
        pluginGeneratedSerialDescriptor.addElement("phone", false);
        pluginGeneratedSerialDescriptor.addElement("postalCode", false);
        pluginGeneratedSerialDescriptor.addElement("prefix", false);
        pluginGeneratedSerialDescriptor.addElement("registrationNumber", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BookRequestParameters$CustomerInfoRequestParameters$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final BookRequestParameters.CustomerInfoRequestParameters deserialize(Decoder decoder) {
        int i5;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        String str6 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 2);
            str = decodeStringElement;
            str4 = beginStructure.decodeStringElement(serialDescriptor, 3);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            str3 = decodeStringElement3;
            str2 = decodeStringElement2;
            i5 = 31;
        } else {
            boolean z5 = true;
            int i6 = 0;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    str6 = beginStructure.decodeStringElement(serialDescriptor, 0);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    str7 = beginStructure.decodeStringElement(serialDescriptor, 1);
                    i6 |= 2;
                } else if (decodeElementIndex == 2) {
                    str8 = beginStructure.decodeStringElement(serialDescriptor, 2);
                    i6 |= 4;
                } else if (decodeElementIndex == 3) {
                    str9 = beginStructure.decodeStringElement(serialDescriptor, 3);
                    i6 |= 8;
                } else {
                    if (decodeElementIndex != 4) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str10);
                    i6 |= 16;
                }
            }
            i5 = i6;
            str = str6;
            str2 = str7;
            str3 = str8;
            str4 = str9;
            str5 = str10;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BookRequestParameters.CustomerInfoRequestParameters(i5, str, str2, str3, str4, str5, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BookRequestParameters.CustomerInfoRequestParameters value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BookRequestParameters.CustomerInfoRequestParameters.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
