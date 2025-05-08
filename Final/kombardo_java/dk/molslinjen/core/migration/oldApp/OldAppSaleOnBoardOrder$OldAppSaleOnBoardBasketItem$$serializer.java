package dk.molslinjen.core.migration.oldApp;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.core.migration.oldApp.OldAppSaleOnBoardOrder;
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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$$serializer implements GeneratedSerializer<OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem> {
    public static final int $stable;
    public static final OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$$serializer oldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$$serializer = new OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$$serializer();
        INSTANCE = oldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.core.migration.oldApp.OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem", oldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("itemNo", false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("imageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("price", false);
        pluginGeneratedSerialDescriptor.addElement("quantity", false);
        pluginGeneratedSerialDescriptor.addElement("categoryName", false);
        pluginGeneratedSerialDescriptor.addElement("categoryId", false);
        pluginGeneratedSerialDescriptor.addElement("variant", true);
        pluginGeneratedSerialDescriptor.addElement("addOns", false);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem.$childSerializers;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardVariant$$serializer.INSTANCE);
        KSerializer<?> kSerializer = kSerializerArr[9];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, DoubleSerializer.INSTANCE, IntSerializer.INSTANCE, stringSerializer, stringSerializer, nullable, kSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x008b. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        List list;
        OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem.OldAppSaleOnBoardVariant oldAppSaleOnBoardVariant;
        int i6;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        double d5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem.$childSerializers;
        int i7 = 7;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 3);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 4);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 5);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 6);
            String decodeStringElement6 = beginStructure.decodeStringElement(serialDescriptor, 7);
            OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem.OldAppSaleOnBoardVariant oldAppSaleOnBoardVariant2 = (OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem.OldAppSaleOnBoardVariant) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardVariant$$serializer.INSTANCE, null);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 9, kSerializerArr[9], null);
            str = decodeStringElement;
            str6 = decodeStringElement6;
            str5 = decodeStringElement5;
            i5 = decodeIntElement;
            str4 = decodeStringElement4;
            oldAppSaleOnBoardVariant = oldAppSaleOnBoardVariant2;
            i6 = 1023;
            str3 = decodeStringElement3;
            str2 = decodeStringElement2;
            d5 = decodeDoubleElement;
        } else {
            boolean z5 = true;
            int i8 = 0;
            List list2 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            double d6 = 0.0d;
            String str11 = null;
            String str12 = null;
            OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem.OldAppSaleOnBoardVariant oldAppSaleOnBoardVariant3 = null;
            int i9 = 0;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        i7 = 7;
                    case 0:
                        i9 |= 1;
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i7 = 7;
                    case 1:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i9 |= 2;
                        i7 = 7;
                    case 2:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i9 |= 4;
                    case 3:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i9 |= 8;
                    case 4:
                        d6 = beginStructure.decodeDoubleElement(serialDescriptor, 4);
                        i9 |= 16;
                    case 5:
                        i8 = beginStructure.decodeIntElement(serialDescriptor, 5);
                        i9 |= 32;
                    case 6:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i9 |= 64;
                    case 7:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, i7);
                        i9 |= 128;
                    case 8:
                        oldAppSaleOnBoardVariant3 = (OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem.OldAppSaleOnBoardVariant) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardVariant$$serializer.INSTANCE, oldAppSaleOnBoardVariant3);
                        i9 |= 256;
                    case 9:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 9, kSerializerArr[9], list2);
                        i9 |= 512;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i8;
            list = list2;
            oldAppSaleOnBoardVariant = oldAppSaleOnBoardVariant3;
            i6 = i9;
            str = str11;
            str2 = str12;
            str3 = str7;
            str4 = str8;
            str5 = str9;
            str6 = str10;
            d5 = d6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem(i6, str, str2, str3, str4, d5, i5, str5, str6, oldAppSaleOnBoardVariant, list, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem.write$Self$app_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
