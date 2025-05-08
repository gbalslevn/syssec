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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class SaleOnBoardLineItem$$serializer implements GeneratedSerializer<SaleOnBoardLineItem> {
    public static final SaleOnBoardLineItem$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SaleOnBoardLineItem$$serializer saleOnBoardLineItem$$serializer = new SaleOnBoardLineItem$$serializer();
        INSTANCE = saleOnBoardLineItem$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem", saleOnBoardLineItem$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, true);
        pluginGeneratedSerialDescriptor.addElement("product", false);
        pluginGeneratedSerialDescriptor.addElement("unitPrice", false);
        pluginGeneratedSerialDescriptor.addElement("quantity", false);
        pluginGeneratedSerialDescriptor.addElement("variant", false);
        pluginGeneratedSerialDescriptor.addElement("addOns", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SaleOnBoardLineItem$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = SaleOnBoardLineItem.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, SaleOnBoardProduct$$serializer.INSTANCE, PriceWithCurrency$$serializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(SaleOnBoardVariant$$serializer.INSTANCE), kSerializerArr[5]};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0067. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final SaleOnBoardLineItem deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        int i6;
        String str;
        SaleOnBoardProduct saleOnBoardProduct;
        PriceWithCurrency priceWithCurrency;
        SaleOnBoardVariant saleOnBoardVariant;
        List list;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = SaleOnBoardLineItem.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            SaleOnBoardProduct saleOnBoardProduct2 = (SaleOnBoardProduct) beginStructure.decodeSerializableElement(serialDescriptor, 1, SaleOnBoardProduct$$serializer.INSTANCE, null);
            PriceWithCurrency priceWithCurrency2 = (PriceWithCurrency) beginStructure.decodeSerializableElement(serialDescriptor, 2, PriceWithCurrency$$serializer.INSTANCE, null);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 3);
            SaleOnBoardVariant saleOnBoardVariant2 = (SaleOnBoardVariant) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, SaleOnBoardVariant$$serializer.INSTANCE, null);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
            str = decodeStringElement;
            i5 = decodeIntElement;
            saleOnBoardVariant = saleOnBoardVariant2;
            priceWithCurrency = priceWithCurrency2;
            i6 = 63;
            saleOnBoardProduct = saleOnBoardProduct2;
        } else {
            boolean z5 = true;
            int i7 = 0;
            String str2 = null;
            SaleOnBoardProduct saleOnBoardProduct3 = null;
            PriceWithCurrency priceWithCurrency3 = null;
            SaleOnBoardVariant saleOnBoardVariant3 = null;
            List list2 = null;
            int i8 = 0;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                    case 0:
                        str2 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i8 |= 1;
                    case 1:
                        saleOnBoardProduct3 = (SaleOnBoardProduct) beginStructure.decodeSerializableElement(serialDescriptor, 1, SaleOnBoardProduct$$serializer.INSTANCE, saleOnBoardProduct3);
                        i8 |= 2;
                    case 2:
                        priceWithCurrency3 = (PriceWithCurrency) beginStructure.decodeSerializableElement(serialDescriptor, 2, PriceWithCurrency$$serializer.INSTANCE, priceWithCurrency3);
                        i8 |= 4;
                    case 3:
                        i7 = beginStructure.decodeIntElement(serialDescriptor, 3);
                        i8 |= 8;
                    case 4:
                        saleOnBoardVariant3 = (SaleOnBoardVariant) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, SaleOnBoardVariant$$serializer.INSTANCE, saleOnBoardVariant3);
                        i8 |= 16;
                    case 5:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], list2);
                        i8 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i7;
            i6 = i8;
            str = str2;
            saleOnBoardProduct = saleOnBoardProduct3;
            priceWithCurrency = priceWithCurrency3;
            saleOnBoardVariant = saleOnBoardVariant3;
            list = list2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SaleOnBoardLineItem(i6, str, saleOnBoardProduct, priceWithCurrency, i5, saleOnBoardVariant, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SaleOnBoardLineItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SaleOnBoardLineItem.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
