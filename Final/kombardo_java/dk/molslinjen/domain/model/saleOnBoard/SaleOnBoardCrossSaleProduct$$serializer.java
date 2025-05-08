package dk.molslinjen.domain.model.saleOnBoard;

import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.domain.model.shared.PriceWithCurrency$$serializer;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSaleProduct.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSaleProduct;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class SaleOnBoardCrossSaleProduct$$serializer implements GeneratedSerializer<SaleOnBoardCrossSaleProduct> {
    public static final SaleOnBoardCrossSaleProduct$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SaleOnBoardCrossSaleProduct$$serializer saleOnBoardCrossSaleProduct$$serializer = new SaleOnBoardCrossSaleProduct$$serializer();
        INSTANCE = saleOnBoardCrossSaleProduct$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCrossSaleProduct", saleOnBoardCrossSaleProduct$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("productId", false);
        pluginGeneratedSerialDescriptor.addElement("product", true);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("description", false);
        pluginGeneratedSerialDescriptor.addElement("price", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SaleOnBoardCrossSaleProduct$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, BuiltinSerializersKt.getNullable(SaleOnBoardProduct$$serializer.INSTANCE), stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), PriceWithCurrency$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final SaleOnBoardCrossSaleProduct deserialize(Decoder decoder) {
        int i5;
        String str;
        SaleOnBoardProduct saleOnBoardProduct;
        String str2;
        String str3;
        PriceWithCurrency priceWithCurrency;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        String str4 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            SaleOnBoardProduct saleOnBoardProduct2 = (SaleOnBoardProduct) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, SaleOnBoardProduct$$serializer.INSTANCE, null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            str = decodeStringElement;
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            priceWithCurrency = (PriceWithCurrency) beginStructure.decodeSerializableElement(serialDescriptor, 4, PriceWithCurrency$$serializer.INSTANCE, null);
            str2 = decodeStringElement2;
            saleOnBoardProduct = saleOnBoardProduct2;
            i5 = 31;
        } else {
            boolean z5 = true;
            int i6 = 0;
            SaleOnBoardProduct saleOnBoardProduct3 = null;
            String str5 = null;
            String str6 = null;
            PriceWithCurrency priceWithCurrency2 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    str4 = beginStructure.decodeStringElement(serialDescriptor, 0);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    saleOnBoardProduct3 = (SaleOnBoardProduct) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, SaleOnBoardProduct$$serializer.INSTANCE, saleOnBoardProduct3);
                    i6 |= 2;
                } else if (decodeElementIndex == 2) {
                    str5 = beginStructure.decodeStringElement(serialDescriptor, 2);
                    i6 |= 4;
                } else if (decodeElementIndex == 3) {
                    str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str6);
                    i6 |= 8;
                } else {
                    if (decodeElementIndex != 4) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    priceWithCurrency2 = (PriceWithCurrency) beginStructure.decodeSerializableElement(serialDescriptor, 4, PriceWithCurrency$$serializer.INSTANCE, priceWithCurrency2);
                    i6 |= 16;
                }
            }
            i5 = i6;
            str = str4;
            saleOnBoardProduct = saleOnBoardProduct3;
            str2 = str5;
            str3 = str6;
            priceWithCurrency = priceWithCurrency2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SaleOnBoardCrossSaleProduct(i5, str, saleOnBoardProduct, str2, str3, priceWithCurrency, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SaleOnBoardCrossSaleProduct value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SaleOnBoardCrossSaleProduct.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
