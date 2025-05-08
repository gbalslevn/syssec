package dk.molslinjen.domain.model.saleOnBoard;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.domain.model.shared.PriceWithCurrency$$serializer;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class SaleOnBoardProduct$$serializer implements GeneratedSerializer<SaleOnBoardProduct> {
    public static final SaleOnBoardProduct$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SaleOnBoardProduct$$serializer saleOnBoardProduct$$serializer = new SaleOnBoardProduct$$serializer();
        INSTANCE = saleOnBoardProduct$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct", saleOnBoardProduct$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("addOns", false);
        pluginGeneratedSerialDescriptor.addElement("crossSale", false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("description", false);
        pluginGeneratedSerialDescriptor.addElement("itemNumber", false);
        pluginGeneratedSerialDescriptor.addElement("variants", false);
        pluginGeneratedSerialDescriptor.addElement("price", false);
        pluginGeneratedSerialDescriptor.addElement("squareImageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("wideImageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("isSoldOut", false);
        pluginGeneratedSerialDescriptor.addElement("categoryName", false);
        pluginGeneratedSerialDescriptor.addElement("categoryId", false);
        pluginGeneratedSerialDescriptor.addElement("positionInCategory", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SaleOnBoardProduct$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = SaleOnBoardProduct.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, kSerializerArr[1], BuiltinSerializersKt.getNullable(SaleOnBoardCrossSales$$serializer.INSTANCE), stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), stringSerializer, BuiltinSerializersKt.getNullable(SaleOnBoardVariants$$serializer.INSTANCE), PriceWithCurrency$$serializer.INSTANCE, stringSerializer, stringSerializer, BooleanSerializer.INSTANCE, stringSerializer, stringSerializer, IntSerializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00ba. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final SaleOnBoardProduct deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        SaleOnBoardCrossSales saleOnBoardCrossSales;
        List list;
        String str;
        int i5;
        SaleOnBoardVariants saleOnBoardVariants;
        PriceWithCurrency priceWithCurrency;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z5;
        int i6;
        char c5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = SaleOnBoardProduct.$childSerializers;
        int i7 = 10;
        String str9 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            SaleOnBoardCrossSales saleOnBoardCrossSales2 = (SaleOnBoardCrossSales) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, SaleOnBoardCrossSales$$serializer.INSTANCE, null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 3);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 5);
            SaleOnBoardVariants saleOnBoardVariants2 = (SaleOnBoardVariants) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, SaleOnBoardVariants$$serializer.INSTANCE, null);
            PriceWithCurrency priceWithCurrency2 = (PriceWithCurrency) beginStructure.decodeSerializableElement(serialDescriptor, 7, PriceWithCurrency$$serializer.INSTANCE, null);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 8);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 9);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 10);
            list = list2;
            str = decodeStringElement;
            saleOnBoardCrossSales = saleOnBoardCrossSales2;
            str3 = decodeStringElement2;
            priceWithCurrency = priceWithCurrency2;
            z5 = decodeBooleanElement;
            str6 = decodeStringElement5;
            str5 = decodeStringElement4;
            saleOnBoardVariants = saleOnBoardVariants2;
            str4 = decodeStringElement3;
            str2 = str10;
            str7 = beginStructure.decodeStringElement(serialDescriptor, 11);
            str8 = beginStructure.decodeStringElement(serialDescriptor, 12);
            i6 = beginStructure.decodeIntElement(serialDescriptor, 13);
            i5 = 16383;
        } else {
            int i8 = 13;
            boolean z6 = true;
            int i9 = 0;
            boolean z7 = false;
            int i10 = 0;
            SaleOnBoardCrossSales saleOnBoardCrossSales3 = null;
            List list3 = null;
            SaleOnBoardVariants saleOnBoardVariants3 = null;
            PriceWithCurrency priceWithCurrency3 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            String str16 = null;
            String str17 = null;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z6 = false;
                        i7 = 10;
                    case 0:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i9 |= 1;
                        i8 = 13;
                        i7 = 10;
                    case 1:
                        list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], list3);
                        i9 |= 2;
                        i8 = 13;
                        i7 = 10;
                    case 2:
                        saleOnBoardCrossSales3 = (SaleOnBoardCrossSales) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, SaleOnBoardCrossSales$$serializer.INSTANCE, saleOnBoardCrossSales3);
                        i9 |= 4;
                        i8 = 13;
                        i7 = 10;
                    case 3:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i9 |= 8;
                        i8 = 13;
                        i7 = 10;
                    case 4:
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str11);
                        i9 |= 16;
                        i8 = 13;
                        i7 = 10;
                    case 5:
                        c5 = 6;
                        str13 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i9 |= 32;
                        i8 = 13;
                        i7 = 10;
                    case 6:
                        c5 = 6;
                        saleOnBoardVariants3 = (SaleOnBoardVariants) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, SaleOnBoardVariants$$serializer.INSTANCE, saleOnBoardVariants3);
                        i9 |= 64;
                        i8 = 13;
                        i7 = 10;
                    case 7:
                        priceWithCurrency3 = (PriceWithCurrency) beginStructure.decodeSerializableElement(serialDescriptor, 7, PriceWithCurrency$$serializer.INSTANCE, priceWithCurrency3);
                        i9 |= 128;
                        i8 = 13;
                    case 8:
                        str14 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i9 |= 256;
                        i8 = 13;
                    case 9:
                        str15 = beginStructure.decodeStringElement(serialDescriptor, 9);
                        i9 |= 512;
                        i8 = 13;
                    case 10:
                        z7 = beginStructure.decodeBooleanElement(serialDescriptor, i7);
                        i9 |= 1024;
                        i8 = 13;
                    case 11:
                        str16 = beginStructure.decodeStringElement(serialDescriptor, 11);
                        i9 |= 2048;
                        i8 = 13;
                    case 12:
                        str17 = beginStructure.decodeStringElement(serialDescriptor, 12);
                        i9 |= 4096;
                    case 13:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, i8);
                        i9 |= 8192;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            saleOnBoardCrossSales = saleOnBoardCrossSales3;
            list = list3;
            str = str9;
            i5 = i9;
            saleOnBoardVariants = saleOnBoardVariants3;
            priceWithCurrency = priceWithCurrency3;
            str2 = str11;
            str3 = str12;
            str4 = str13;
            str5 = str14;
            str6 = str15;
            str7 = str16;
            str8 = str17;
            z5 = z7;
            i6 = i10;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SaleOnBoardProduct(i5, str, list, saleOnBoardCrossSales, str3, str2, str4, saleOnBoardVariants, priceWithCurrency, str5, str6, z5, str7, str8, i6, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SaleOnBoardProduct value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SaleOnBoardProduct.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
