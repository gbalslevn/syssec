package dk.molslinjen.api.services.saleOnBoard.response;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.saleOnBoard.response.ShopAndProductsResponseDTO;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO.StoreResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$StoreResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class ShopAndProductsResponseDTO$StoreResponseDTO$$serializer implements GeneratedSerializer<ShopAndProductsResponseDTO.StoreResponseDTO> {
    public static final ShopAndProductsResponseDTO$StoreResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ShopAndProductsResponseDTO$StoreResponseDTO$$serializer shopAndProductsResponseDTO$StoreResponseDTO$$serializer = new ShopAndProductsResponseDTO$StoreResponseDTO$$serializer();
        INSTANCE = shopAndProductsResponseDTO$StoreResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.saleOnBoard.response.ShopAndProductsResponseDTO.StoreResponseDTO", shopAndProductsResponseDTO$StoreResponseDTO$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("storeLocation", false);
        pluginGeneratedSerialDescriptor.addElement("storeName", false);
        pluginGeneratedSerialDescriptor.addElement("storeNo", false);
        pluginGeneratedSerialDescriptor.addElement("categories", false);
        pluginGeneratedSerialDescriptor.addElement("bannerImageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("squareImageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("wideImageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("storeLogoImageUrl", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ShopAndProductsResponseDTO$StoreResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = ShopAndProductsResponseDTO.StoreResponseDTO.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, kSerializerArr[4], stringSerializer, stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x007b. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final ShopAndProductsResponseDTO.StoreResponseDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        String str;
        List list;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = ShopAndProductsResponseDTO.StoreResponseDTO.$childSerializers;
        String str9 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 3);
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 5);
            String decodeStringElement6 = beginStructure.decodeStringElement(serialDescriptor, 6);
            list = list2;
            str2 = decodeStringElement;
            str8 = beginStructure.decodeStringElement(serialDescriptor, 7);
            str7 = decodeStringElement6;
            str6 = decodeStringElement5;
            str5 = decodeStringElement4;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, null);
            str4 = decodeStringElement3;
            i5 = 511;
            str3 = decodeStringElement2;
        } else {
            boolean z5 = true;
            int i6 = 0;
            String str10 = null;
            List list3 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            String str16 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                    case 0:
                        i6 |= 1;
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 0);
                    case 1:
                        i6 |= 2;
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 1);
                    case 2:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i6 |= 4;
                    case 3:
                        str13 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i6 |= 8;
                    case 4:
                        list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], list3);
                        i6 |= 16;
                    case 5:
                        str14 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i6 |= 32;
                    case 6:
                        str15 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i6 |= 64;
                    case 7:
                        str16 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i6 |= 128;
                    case 8:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str10);
                        i6 |= 256;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i6;
            str = str10;
            list = list3;
            str2 = str9;
            str3 = str11;
            str4 = str12;
            str5 = str13;
            str6 = str14;
            str7 = str15;
            str8 = str16;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ShopAndProductsResponseDTO.StoreResponseDTO(i5, str2, str3, str4, str5, list, str6, str7, str8, str, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ShopAndProductsResponseDTO.StoreResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ShopAndProductsResponseDTO.StoreResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
