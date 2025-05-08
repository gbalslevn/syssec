package dk.molslinjen.core.migration.oldApp;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.core.migration.oldApp.OldAppSaleOnBoardOrder;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class OldAppSaleOnBoardOrder$$serializer implements GeneratedSerializer<OldAppSaleOnBoardOrder> {
    public static final int $stable;
    public static final OldAppSaleOnBoardOrder$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        OldAppSaleOnBoardOrder$$serializer oldAppSaleOnBoardOrder$$serializer = new OldAppSaleOnBoardOrder$$serializer();
        INSTANCE = oldAppSaleOnBoardOrder$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.core.migration.oldApp.OldAppSaleOnBoardOrder", oldAppSaleOnBoardOrder$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("startDateTime", false);
        pluginGeneratedSerialDescriptor.addElement("endDateTime", false);
        pluginGeneratedSerialDescriptor.addElement("departure", false);
        pluginGeneratedSerialDescriptor.addElement("status", false);
        pluginGeneratedSerialDescriptor.addElement("products", false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("email", false);
        pluginGeneratedSerialDescriptor.addElement("phoneNumber", false);
        pluginGeneratedSerialDescriptor.addElement("shopImageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("shopLocation", false);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private OldAppSaleOnBoardOrder$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = OldAppSaleOnBoardOrder.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[4];
        KSerializer<?> kSerializer2 = kSerializerArr[5];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        OldAppLocalDateTime$$serializer oldAppLocalDateTime$$serializer = OldAppLocalDateTime$$serializer.INSTANCE;
        return new KSerializer[]{stringSerializer, oldAppLocalDateTime$$serializer, oldAppLocalDateTime$$serializer, OldAppSaleOnBoardOrder$OldAppSaleOnBoardDeparture$$serializer.INSTANCE, kSerializer, kSerializer2, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0098. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final OldAppSaleOnBoardOrder deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        OldAppSaleOnBoardOrder.OldAppOrderStatus oldAppOrderStatus;
        OldAppSaleOnBoardOrder.OldAppSaleOnBoardDeparture oldAppSaleOnBoardDeparture;
        List list;
        OldAppLocalDateTime oldAppLocalDateTime;
        OldAppLocalDateTime oldAppLocalDateTime2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = OldAppSaleOnBoardOrder.$childSerializers;
        int i6 = 10;
        int i7 = 9;
        String str7 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            OldAppLocalDateTime$$serializer oldAppLocalDateTime$$serializer = OldAppLocalDateTime$$serializer.INSTANCE;
            OldAppLocalDateTime oldAppLocalDateTime3 = (OldAppLocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 1, oldAppLocalDateTime$$serializer, null);
            OldAppLocalDateTime oldAppLocalDateTime4 = (OldAppLocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 2, oldAppLocalDateTime$$serializer, null);
            OldAppSaleOnBoardOrder.OldAppSaleOnBoardDeparture oldAppSaleOnBoardDeparture2 = (OldAppSaleOnBoardOrder.OldAppSaleOnBoardDeparture) beginStructure.decodeSerializableElement(serialDescriptor, 3, OldAppSaleOnBoardOrder$OldAppSaleOnBoardDeparture$$serializer.INSTANCE, null);
            OldAppSaleOnBoardOrder.OldAppOrderStatus oldAppOrderStatus2 = (OldAppSaleOnBoardOrder.OldAppOrderStatus) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 6);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 7);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 8);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 9);
            list = list2;
            str = decodeStringElement;
            str6 = beginStructure.decodeStringElement(serialDescriptor, 10);
            str5 = decodeStringElement5;
            str3 = decodeStringElement3;
            str2 = decodeStringElement2;
            oldAppSaleOnBoardDeparture = oldAppSaleOnBoardDeparture2;
            str4 = decodeStringElement4;
            oldAppLocalDateTime = oldAppLocalDateTime4;
            i5 = 2047;
            oldAppOrderStatus = oldAppOrderStatus2;
            oldAppLocalDateTime2 = oldAppLocalDateTime3;
        } else {
            boolean z5 = true;
            int i8 = 0;
            OldAppSaleOnBoardOrder.OldAppOrderStatus oldAppOrderStatus3 = null;
            OldAppSaleOnBoardOrder.OldAppSaleOnBoardDeparture oldAppSaleOnBoardDeparture3 = null;
            List list3 = null;
            OldAppLocalDateTime oldAppLocalDateTime5 = null;
            OldAppLocalDateTime oldAppLocalDateTime6 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        i7 = 9;
                    case 0:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i8 |= 1;
                        i6 = 10;
                        i7 = 9;
                    case 1:
                        oldAppLocalDateTime6 = (OldAppLocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 1, OldAppLocalDateTime$$serializer.INSTANCE, oldAppLocalDateTime6);
                        i8 |= 2;
                        i6 = 10;
                        i7 = 9;
                    case 2:
                        oldAppLocalDateTime5 = (OldAppLocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 2, OldAppLocalDateTime$$serializer.INSTANCE, oldAppLocalDateTime5);
                        i8 |= 4;
                        i6 = 10;
                        i7 = 9;
                    case 3:
                        oldAppSaleOnBoardDeparture3 = (OldAppSaleOnBoardOrder.OldAppSaleOnBoardDeparture) beginStructure.decodeSerializableElement(serialDescriptor, 3, OldAppSaleOnBoardOrder$OldAppSaleOnBoardDeparture$$serializer.INSTANCE, oldAppSaleOnBoardDeparture3);
                        i8 |= 8;
                        i6 = 10;
                        i7 = 9;
                    case 4:
                        oldAppOrderStatus3 = (OldAppSaleOnBoardOrder.OldAppOrderStatus) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], oldAppOrderStatus3);
                        i8 |= 16;
                        i6 = 10;
                        i7 = 9;
                    case 5:
                        list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], list3);
                        i8 |= 32;
                        i6 = 10;
                    case 6:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i8 |= 64;
                    case 7:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i8 |= 128;
                    case 8:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i8 |= 256;
                    case 9:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, i7);
                        i8 |= 512;
                    case 10:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, i6);
                        i8 |= 1024;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i8;
            oldAppOrderStatus = oldAppOrderStatus3;
            oldAppSaleOnBoardDeparture = oldAppSaleOnBoardDeparture3;
            list = list3;
            oldAppLocalDateTime = oldAppLocalDateTime5;
            oldAppLocalDateTime2 = oldAppLocalDateTime6;
            str = str7;
            str2 = str8;
            str3 = str9;
            str4 = str10;
            str5 = str11;
            str6 = str12;
        }
        beginStructure.endStructure(serialDescriptor);
        return new OldAppSaleOnBoardOrder(i5, str, oldAppLocalDateTime2, oldAppLocalDateTime, oldAppSaleOnBoardDeparture, oldAppOrderStatus, list, str2, str3, str4, str5, str6, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, OldAppSaleOnBoardOrder value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        OldAppSaleOnBoardOrder.write$Self$app_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
