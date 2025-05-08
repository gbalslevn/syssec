package dk.molslinjen.domain.model.account;

import com.sdk.growthbook.utils.Constants;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/account/UserVehicle.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/account/UserVehicle;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class UserVehicle$$serializer implements GeneratedSerializer<UserVehicle> {
    public static final UserVehicle$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        UserVehicle$$serializer userVehicle$$serializer = new UserVehicle$$serializer();
        INSTANCE = userVehicle$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.account.UserVehicle", userVehicle$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("licensePlate", false);
        pluginGeneratedSerialDescriptor.addElement("manufacturer", false);
        pluginGeneratedSerialDescriptor.addElement("model", false);
        pluginGeneratedSerialDescriptor.addElement("heightInMeters", false);
        pluginGeneratedSerialDescriptor.addElement("lengthInMeters", false);
        pluginGeneratedSerialDescriptor.addElement("displayName", true);
        pluginGeneratedSerialDescriptor.addElement("formattedModelName", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UserVehicle$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(doubleSerializer), BuiltinSerializersKt.getNullable(doubleSerializer), stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0077. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final UserVehicle deserialize(Decoder decoder) {
        int i5;
        String str;
        Double d5;
        Double d6;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        String str8 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 3);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 4);
            DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
            Double d7 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, doubleSerializer, null);
            Double d8 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, doubleSerializer, null);
            str2 = decodeStringElement;
            str7 = beginStructure.decodeStringElement(serialDescriptor, 7);
            d5 = d8;
            d6 = d7;
            str5 = decodeStringElement4;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, null);
            str6 = decodeStringElement5;
            str4 = decodeStringElement3;
            str3 = decodeStringElement2;
            i5 = 511;
        } else {
            boolean z5 = true;
            int i6 = 0;
            String str9 = null;
            Double d9 = null;
            Double d10 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                    case 0:
                        i6 |= 1;
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 0);
                    case 1:
                        i6 |= 2;
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 1);
                    case 2:
                        i6 |= 4;
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 2);
                    case 3:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i6 |= 8;
                    case 4:
                        str13 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i6 |= 16;
                    case 5:
                        d10 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, DoubleSerializer.INSTANCE, d10);
                        i6 |= 32;
                    case 6:
                        d9 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, DoubleSerializer.INSTANCE, d9);
                        i6 |= 64;
                    case 7:
                        str14 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i6 |= 128;
                    case 8:
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str9);
                        i6 |= 256;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i6;
            str = str9;
            d5 = d9;
            d6 = d10;
            str2 = str8;
            str3 = str10;
            str4 = str11;
            str5 = str12;
            str6 = str13;
            str7 = str14;
        }
        beginStructure.endStructure(serialDescriptor);
        return new UserVehicle(i5, str2, str3, str4, str5, str6, d6, d5, str7, str, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, UserVehicle value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        UserVehicle.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
