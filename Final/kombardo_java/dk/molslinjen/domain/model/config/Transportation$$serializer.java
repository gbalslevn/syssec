package dk.molslinjen.domain.model.config;

import com.sdk.growthbook.utils.Constants;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/config/Transportation.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/config/Transportation;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class Transportation$$serializer implements GeneratedSerializer<Transportation> {
    public static final Transportation$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Transportation$$serializer transportation$$serializer = new Transportation$$serializer();
        INSTANCE = transportation$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.config.Transportation", transportation$$serializer, 21);
        pluginGeneratedSerialDescriptor.addElement("allowedRouteIds", false);
        pluginGeneratedSerialDescriptor.addElement("adultRequired", false);
        pluginGeneratedSerialDescriptor.addElement("adultRequiredForInfants", false);
        pluginGeneratedSerialDescriptor.addElement("allowLicensePlate", false);
        pluginGeneratedSerialDescriptor.addElement("imageUrl", false);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("isEarlyCheckInAllowed", false);
        pluginGeneratedSerialDescriptor.addElement("isFreightPossible", false);
        pluginGeneratedSerialDescriptor.addElement("isWalking", false);
        pluginGeneratedSerialDescriptor.addElement("isOnlyAvailableWithReturnTicket", false);
        pluginGeneratedSerialDescriptor.addElement("maxHeight", false);
        pluginGeneratedSerialDescriptor.addElement("maxLength", false);
        pluginGeneratedSerialDescriptor.addElement("maxPassengers", false);
        pluginGeneratedSerialDescriptor.addElement("maxWeight", false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("nameWithoutPossibleCategory", false);
        pluginGeneratedSerialDescriptor.addElement("passengerEntryType", false);
        pluginGeneratedSerialDescriptor.addElement("personDataOnlyForChauffeur", false);
        pluginGeneratedSerialDescriptor.addElement("licensePlateRequired", false);
        pluginGeneratedSerialDescriptor.addElement("trailerAllowed", false);
        pluginGeneratedSerialDescriptor.addElement("isTura", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Transportation$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = Transportation.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[0];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> kSerializer2 = kSerializerArr[16];
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{kSerializer, booleanSerializer, booleanSerializer, booleanSerializer, nullable, stringSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, doubleSerializer, doubleSerializer, IntSerializer.INSTANCE, doubleSerializer, stringSerializer, stringSerializer, kSerializer2, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0109. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final Transportation deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        String str;
        List list;
        int i5;
        PassengerEntryType passengerEntryType;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        String str2;
        String str3;
        String str4;
        int i6;
        boolean z14;
        boolean z15;
        double d5;
        double d6;
        double d7;
        char c5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = Transportation.$childSerializers;
        int i7 = 5;
        int i8 = 8;
        char c6 = 4;
        if (beginStructure.decodeSequentially()) {
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 1);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
            boolean decodeBooleanElement3 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
            String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 5);
            boolean decodeBooleanElement4 = beginStructure.decodeBooleanElement(serialDescriptor, 6);
            boolean decodeBooleanElement5 = beginStructure.decodeBooleanElement(serialDescriptor, 7);
            boolean decodeBooleanElement6 = beginStructure.decodeBooleanElement(serialDescriptor, 8);
            boolean decodeBooleanElement7 = beginStructure.decodeBooleanElement(serialDescriptor, 9);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 10);
            double decodeDoubleElement2 = beginStructure.decodeDoubleElement(serialDescriptor, 11);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 12);
            double decodeDoubleElement3 = beginStructure.decodeDoubleElement(serialDescriptor, 13);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 14);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 15);
            PassengerEntryType passengerEntryType2 = (PassengerEntryType) beginStructure.decodeSerializableElement(serialDescriptor, 16, kSerializerArr[16], null);
            boolean decodeBooleanElement8 = beginStructure.decodeBooleanElement(serialDescriptor, 17);
            boolean decodeBooleanElement9 = beginStructure.decodeBooleanElement(serialDescriptor, 18);
            z5 = beginStructure.decodeBooleanElement(serialDescriptor, 19);
            z6 = beginStructure.decodeBooleanElement(serialDescriptor, 20);
            z7 = decodeBooleanElement8;
            str2 = decodeStringElement;
            z8 = decodeBooleanElement3;
            z9 = decodeBooleanElement6;
            str = str5;
            z10 = decodeBooleanElement2;
            z11 = decodeBooleanElement;
            z13 = decodeBooleanElement9;
            str4 = decodeStringElement3;
            i6 = decodeIntElement;
            z14 = decodeBooleanElement7;
            z15 = decodeBooleanElement5;
            str3 = decodeStringElement2;
            passengerEntryType = passengerEntryType2;
            i5 = 2097151;
            list = list2;
            z12 = decodeBooleanElement4;
            d5 = decodeDoubleElement3;
            d6 = decodeDoubleElement;
            d7 = decodeDoubleElement2;
        } else {
            int i9 = 0;
            boolean z16 = false;
            boolean z17 = false;
            boolean z18 = false;
            boolean z19 = false;
            boolean z20 = false;
            boolean z21 = false;
            int i10 = 0;
            boolean z22 = false;
            boolean z23 = false;
            boolean z24 = true;
            PassengerEntryType passengerEntryType3 = null;
            List list3 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            double d8 = 0.0d;
            double d9 = 0.0d;
            double d10 = 0.0d;
            boolean z25 = false;
            boolean z26 = false;
            String str9 = null;
            boolean z27 = false;
            while (z24) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z24 = false;
                        i7 = 5;
                        i8 = 8;
                        c6 = 4;
                    case 0:
                        list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], list3);
                        i9 |= 1;
                        i7 = 5;
                        i8 = 8;
                        c6 = 4;
                    case 1:
                        c5 = c6;
                        z19 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                        i9 |= 2;
                        c6 = c5;
                        i7 = 5;
                    case 2:
                        c5 = c6;
                        z18 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                        i9 |= 4;
                        c6 = c5;
                        i7 = 5;
                    case 3:
                        z26 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                        i9 |= 8;
                        c6 = c6;
                        i7 = 5;
                    case 4:
                        c5 = 4;
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str9);
                        i9 |= 16;
                        c6 = c5;
                        i7 = 5;
                    case 5:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, i7);
                        i9 |= 32;
                        c6 = 4;
                    case 6:
                        z20 = beginStructure.decodeBooleanElement(serialDescriptor, 6);
                        i9 |= 64;
                        c6 = 4;
                    case 7:
                        z23 = beginStructure.decodeBooleanElement(serialDescriptor, 7);
                        i9 |= 128;
                        c6 = 4;
                    case 8:
                        z17 = beginStructure.decodeBooleanElement(serialDescriptor, i8);
                        i9 |= 256;
                        c6 = 4;
                    case 9:
                        z22 = beginStructure.decodeBooleanElement(serialDescriptor, 9);
                        i9 |= 512;
                        c6 = 4;
                    case 10:
                        d9 = beginStructure.decodeDoubleElement(serialDescriptor, 10);
                        i9 |= 1024;
                        c6 = 4;
                    case 11:
                        d10 = beginStructure.decodeDoubleElement(serialDescriptor, 11);
                        i9 |= 2048;
                        c6 = 4;
                    case 12:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 12);
                        i9 |= 4096;
                        c6 = 4;
                    case 13:
                        d8 = beginStructure.decodeDoubleElement(serialDescriptor, 13);
                        i9 |= 8192;
                        c6 = 4;
                    case 14:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 14);
                        i9 |= 16384;
                        c6 = 4;
                    case 15:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 15);
                        i9 |= 32768;
                        c6 = 4;
                    case 16:
                        passengerEntryType3 = (PassengerEntryType) beginStructure.decodeSerializableElement(serialDescriptor, 16, kSerializerArr[16], passengerEntryType3);
                        i9 |= 65536;
                        c6 = 4;
                    case 17:
                        z25 = beginStructure.decodeBooleanElement(serialDescriptor, 17);
                        i9 |= 131072;
                    case 18:
                        z21 = beginStructure.decodeBooleanElement(serialDescriptor, 18);
                        i9 |= 262144;
                    case 19:
                        z27 = beginStructure.decodeBooleanElement(serialDescriptor, 19);
                        i9 |= 524288;
                    case 20:
                        z16 = beginStructure.decodeBooleanElement(serialDescriptor, 20);
                        i9 |= 1048576;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str9;
            list = list3;
            i5 = i9;
            passengerEntryType = passengerEntryType3;
            z5 = z27;
            z6 = z16;
            z7 = z25;
            z8 = z26;
            z9 = z17;
            z10 = z18;
            z11 = z19;
            z12 = z20;
            z13 = z21;
            str2 = str6;
            str3 = str7;
            str4 = str8;
            i6 = i10;
            z14 = z22;
            z15 = z23;
            d5 = d8;
            d6 = d9;
            d7 = d10;
        }
        beginStructure.endStructure(serialDescriptor);
        return new Transportation(i5, list, z11, z10, z8, str, str2, z12, z15, z9, z14, d6, d7, i6, d5, str3, str4, passengerEntryType, z7, z13, z5, z6, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Transportation value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        Transportation.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
