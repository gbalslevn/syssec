package dk.molslinjen.api.services.account.vehicle.response;

import dk.molslinjen.api.helpers.serializers.LocalDateTimeSerializer;
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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/account/vehicle/response/VehicleDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/account/vehicle/response/VehicleDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class VehicleDTO$$serializer implements GeneratedSerializer<VehicleDTO> {
    public static final VehicleDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        VehicleDTO$$serializer vehicleDTO$$serializer = new VehicleDTO$$serializer();
        INSTANCE = vehicleDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.account.vehicle.response.VehicleDTO", vehicleDTO$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("vehicleId", false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("licensePlate", false);
        pluginGeneratedSerialDescriptor.addElement("manufacturer", false);
        pluginGeneratedSerialDescriptor.addElement("model", false);
        pluginGeneratedSerialDescriptor.addElement("height", false);
        pluginGeneratedSerialDescriptor.addElement("length", false);
        pluginGeneratedSerialDescriptor.addElement("lastUsed", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private VehicleDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(LocalDateTimeSerializer.INSTANCE);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, doubleSerializer, doubleSerializer, nullable};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x006a. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final VehicleDTO deserialize(Decoder decoder) {
        int i5;
        LocalDateTime localDateTime;
        String str;
        double d5;
        String str2;
        String str3;
        String str4;
        String str5;
        double d6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        String str6 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 3);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 4);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 5);
            double decodeDoubleElement2 = beginStructure.decodeDoubleElement(serialDescriptor, 6);
            str = decodeStringElement;
            localDateTime = (LocalDateTime) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, LocalDateTimeSerializer.INSTANCE, null);
            d5 = decodeDoubleElement2;
            str4 = decodeStringElement4;
            str5 = decodeStringElement5;
            str3 = decodeStringElement3;
            str2 = decodeStringElement2;
            i5 = 255;
            d6 = decodeDoubleElement;
        } else {
            double d7 = 0.0d;
            boolean z5 = true;
            int i6 = 0;
            LocalDateTime localDateTime2 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            double d8 = 0.0d;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                    case 0:
                        i6 |= 1;
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 0);
                    case 1:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i6 |= 2;
                    case 2:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i6 |= 4;
                    case 3:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i6 |= 8;
                    case 4:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i6 |= 16;
                    case 5:
                        d8 = beginStructure.decodeDoubleElement(serialDescriptor, 5);
                        i6 |= 32;
                    case 6:
                        d7 = beginStructure.decodeDoubleElement(serialDescriptor, 6);
                        i6 |= 64;
                    case 7:
                        localDateTime2 = (LocalDateTime) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, LocalDateTimeSerializer.INSTANCE, localDateTime2);
                        i6 |= 128;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i6;
            localDateTime = localDateTime2;
            str = str6;
            d5 = d7;
            str2 = str7;
            str3 = str8;
            str4 = str9;
            str5 = str10;
            d6 = d8;
        }
        beginStructure.endStructure(serialDescriptor);
        return new VehicleDTO(i5, str, str2, str3, str4, str5, d6, d5, localDateTime, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, VehicleDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        VehicleDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
