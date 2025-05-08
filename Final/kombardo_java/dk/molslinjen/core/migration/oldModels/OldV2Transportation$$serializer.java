package dk.molslinjen.core.migration.oldModels;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.model.config.PassengerEntryType;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/core/migration/oldModels/OldV2Transportation.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/core/migration/oldModels/OldV2Transportation;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class OldV2Transportation$$serializer implements GeneratedSerializer<OldV2Transportation> {
    public static final int $stable;
    public static final OldV2Transportation$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        OldV2Transportation$$serializer oldV2Transportation$$serializer = new OldV2Transportation$$serializer();
        INSTANCE = oldV2Transportation$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.core.migration.oldModels.OldV2Transportation", oldV2Transportation$$serializer, 20);
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
        pluginGeneratedSerialDescriptor.addElement("passengerEntryType", false);
        pluginGeneratedSerialDescriptor.addElement("personDataOnlyForChauffeur", false);
        pluginGeneratedSerialDescriptor.addElement("licensePlateRequired", false);
        pluginGeneratedSerialDescriptor.addElement("trailerAllowed", false);
        pluginGeneratedSerialDescriptor.addElement("isTura", false);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private OldV2Transportation$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = OldV2Transportation.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[0];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> kSerializer2 = kSerializerArr[15];
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{kSerializer, booleanSerializer, booleanSerializer, booleanSerializer, nullable, stringSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, doubleSerializer, doubleSerializer, IntSerializer.INSTANCE, doubleSerializer, stringSerializer, kSerializer2, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00fe. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final OldV2Transportation deserialize(Decoder decoder) {
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
        String str2;
        String str3;
        boolean z12;
        int i6;
        boolean z13;
        boolean z14;
        boolean z15;
        double d5;
        double d6;
        double d7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = OldV2Transportation.$childSerializers;
        int i7 = 8;
        int i8 = 4;
        if (beginStructure.decodeSequentially()) {
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 1);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
            boolean decodeBooleanElement3 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
            String str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
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
            PassengerEntryType passengerEntryType2 = (PassengerEntryType) beginStructure.decodeSerializableElement(serialDescriptor, 15, kSerializerArr[15], null);
            boolean decodeBooleanElement8 = beginStructure.decodeBooleanElement(serialDescriptor, 16);
            boolean decodeBooleanElement9 = beginStructure.decodeBooleanElement(serialDescriptor, 17);
            z5 = beginStructure.decodeBooleanElement(serialDescriptor, 18);
            z6 = decodeBooleanElement8;
            z7 = decodeBooleanElement3;
            str = str4;
            z8 = decodeBooleanElement6;
            z9 = decodeBooleanElement2;
            z10 = decodeBooleanElement;
            z11 = beginStructure.decodeBooleanElement(serialDescriptor, 19);
            z12 = decodeBooleanElement9;
            i6 = decodeIntElement;
            z13 = decodeBooleanElement7;
            z14 = decodeBooleanElement5;
            z15 = decodeBooleanElement4;
            str3 = decodeStringElement2;
            str2 = decodeStringElement;
            passengerEntryType = passengerEntryType2;
            i5 = 1048575;
            list = list2;
            d5 = decodeDoubleElement3;
            d6 = decodeDoubleElement;
            d7 = decodeDoubleElement2;
        } else {
            int i9 = 19;
            int i10 = 0;
            boolean z16 = false;
            boolean z17 = false;
            boolean z18 = false;
            boolean z19 = false;
            boolean z20 = false;
            int i11 = 0;
            boolean z21 = false;
            boolean z22 = false;
            boolean z23 = false;
            boolean z24 = true;
            PassengerEntryType passengerEntryType3 = null;
            List list3 = null;
            String str5 = null;
            String str6 = null;
            double d8 = 0.0d;
            double d9 = 0.0d;
            double d10 = 0.0d;
            boolean z25 = false;
            boolean z26 = false;
            String str7 = null;
            boolean z27 = false;
            while (z24) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z24 = false;
                        i7 = 8;
                        i9 = 19;
                    case 0:
                        list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], list3);
                        i10 |= 1;
                        i8 = 4;
                        i7 = 8;
                        i9 = 19;
                    case 1:
                        z18 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                        i10 |= 2;
                        i9 = 19;
                    case 2:
                        z17 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                        i10 |= 4;
                        i9 = 19;
                    case 3:
                        z26 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                        i10 |= 8;
                        i9 = 19;
                    case 4:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i8, StringSerializer.INSTANCE, str7);
                        i10 |= 16;
                        i9 = 19;
                    case 5:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i10 |= 32;
                        i9 = 19;
                    case 6:
                        z23 = beginStructure.decodeBooleanElement(serialDescriptor, 6);
                        i10 |= 64;
                        i9 = 19;
                    case 7:
                        z22 = beginStructure.decodeBooleanElement(serialDescriptor, 7);
                        i10 |= 128;
                        i9 = 19;
                    case 8:
                        z16 = beginStructure.decodeBooleanElement(serialDescriptor, i7);
                        i10 |= 256;
                        i9 = 19;
                    case 9:
                        z21 = beginStructure.decodeBooleanElement(serialDescriptor, 9);
                        i10 |= 512;
                        i9 = 19;
                    case 10:
                        d9 = beginStructure.decodeDoubleElement(serialDescriptor, 10);
                        i10 |= 1024;
                        i9 = 19;
                    case 11:
                        d10 = beginStructure.decodeDoubleElement(serialDescriptor, 11);
                        i10 |= 2048;
                        i9 = 19;
                    case 12:
                        i11 = beginStructure.decodeIntElement(serialDescriptor, 12);
                        i10 |= 4096;
                        i9 = 19;
                    case 13:
                        d8 = beginStructure.decodeDoubleElement(serialDescriptor, 13);
                        i10 |= 8192;
                        i9 = 19;
                    case 14:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 14);
                        i10 |= 16384;
                        i9 = 19;
                    case 15:
                        passengerEntryType3 = (PassengerEntryType) beginStructure.decodeSerializableElement(serialDescriptor, 15, kSerializerArr[15], passengerEntryType3);
                        i10 |= 32768;
                        i9 = 19;
                    case 16:
                        z25 = beginStructure.decodeBooleanElement(serialDescriptor, 16);
                        i10 |= 65536;
                    case 17:
                        z20 = beginStructure.decodeBooleanElement(serialDescriptor, 17);
                        i10 |= 131072;
                    case 18:
                        z27 = beginStructure.decodeBooleanElement(serialDescriptor, 18);
                        i10 |= 262144;
                    case 19:
                        z19 = beginStructure.decodeBooleanElement(serialDescriptor, i9);
                        i10 |= 524288;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str7;
            list = list3;
            i5 = i10;
            passengerEntryType = passengerEntryType3;
            z5 = z27;
            z6 = z25;
            z7 = z26;
            z8 = z16;
            z9 = z17;
            z10 = z18;
            z11 = z19;
            str2 = str5;
            str3 = str6;
            z12 = z20;
            i6 = i11;
            z13 = z21;
            z14 = z22;
            z15 = z23;
            d5 = d8;
            d6 = d9;
            d7 = d10;
        }
        beginStructure.endStructure(serialDescriptor);
        return new OldV2Transportation(i5, list, z10, z9, z7, str, str2, z15, z14, z8, z13, d6, d7, i6, d5, str3, passengerEntryType, z6, z12, z5, z11, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, OldV2Transportation value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        OldV2Transportation.write$Self$app_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
