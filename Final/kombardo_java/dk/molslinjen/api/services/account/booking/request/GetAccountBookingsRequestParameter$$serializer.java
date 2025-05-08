package dk.molslinjen.api.services.account.booking.request;

import dk.molslinjen.api.helpers.serializers.LocalDateNoDashesSerializer;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/account/booking/request/GetAccountBookingsRequestParameter.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/account/booking/request/GetAccountBookingsRequestParameter;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class GetAccountBookingsRequestParameter$$serializer implements GeneratedSerializer<GetAccountBookingsRequestParameter> {
    public static final GetAccountBookingsRequestParameter$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GetAccountBookingsRequestParameter$$serializer getAccountBookingsRequestParameter$$serializer = new GetAccountBookingsRequestParameter$$serializer();
        INSTANCE = getAccountBookingsRequestParameter$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.account.booking.request.GetAccountBookingsRequestParameter", getAccountBookingsRequestParameter$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("active", false);
        pluginGeneratedSerialDescriptor.addElement("take", false);
        pluginGeneratedSerialDescriptor.addElement("skip", false);
        pluginGeneratedSerialDescriptor.addElement("masterID", false);
        pluginGeneratedSerialDescriptor.addElement("startDate", false);
        pluginGeneratedSerialDescriptor.addElement("endDate", false);
        pluginGeneratedSerialDescriptor.addElement("companyID", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GetAccountBookingsRequestParameter$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(intSerializer);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(intSerializer);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        LocalDateNoDashesSerializer localDateNoDashesSerializer = LocalDateNoDashesSerializer.INSTANCE;
        return new KSerializer[]{BooleanSerializer.INSTANCE, nullable, nullable2, stringSerializer, BuiltinSerializersKt.getNullable(localDateNoDashesSerializer), BuiltinSerializersKt.getNullable(localDateNoDashesSerializer), BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x006b. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final GetAccountBookingsRequestParameter deserialize(Decoder decoder) {
        boolean z5;
        String str;
        int i5;
        Integer num;
        Integer num2;
        String str2;
        LocalDate localDate;
        LocalDate localDate2;
        boolean z6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i6 = 6;
        if (beginStructure.decodeSequentially()) {
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 0);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            Integer num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, intSerializer, null);
            Integer num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, intSerializer, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 3);
            LocalDateNoDashesSerializer localDateNoDashesSerializer = LocalDateNoDashesSerializer.INSTANCE;
            LocalDate localDate3 = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, localDateNoDashesSerializer, null);
            LocalDate localDate4 = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, localDateNoDashesSerializer, null);
            z5 = decodeBooleanElement;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, null);
            localDate2 = localDate4;
            str2 = decodeStringElement;
            localDate = localDate3;
            num2 = num4;
            num = num3;
            i5 = 127;
        } else {
            boolean z7 = true;
            boolean z8 = false;
            Integer num5 = null;
            Integer num6 = null;
            String str3 = null;
            LocalDate localDate5 = null;
            LocalDate localDate6 = null;
            String str4 = null;
            int i7 = 0;
            while (z7) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z7 = false;
                    case 0:
                        z6 = true;
                        z8 = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                        i7 |= 1;
                        i6 = 6;
                    case 1:
                        z6 = true;
                        num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, num5);
                        i7 |= 2;
                        i6 = 6;
                    case 2:
                        num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num6);
                        i7 |= 4;
                    case 3:
                        str3 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i7 |= 8;
                    case 4:
                        localDate5 = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LocalDateNoDashesSerializer.INSTANCE, localDate5);
                        i7 |= 16;
                    case 5:
                        localDate6 = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LocalDateNoDashesSerializer.INSTANCE, localDate6);
                        i7 |= 32;
                    case 6:
                        str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i6, StringSerializer.INSTANCE, str4);
                        i7 |= 64;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z5 = z8;
            str = str4;
            i5 = i7;
            num = num5;
            num2 = num6;
            str2 = str3;
            localDate = localDate5;
            localDate2 = localDate6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new GetAccountBookingsRequestParameter(i5, z5, num, num2, str2, localDate, localDate2, str, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, GetAccountBookingsRequestParameter value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        GetAccountBookingsRequestParameter.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
