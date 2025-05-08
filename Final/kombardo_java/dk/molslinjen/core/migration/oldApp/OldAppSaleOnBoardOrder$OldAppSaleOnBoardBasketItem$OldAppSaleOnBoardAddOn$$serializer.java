package dk.molslinjen.core.migration.oldApp;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.core.migration.oldApp.OldAppSaleOnBoardOrder;
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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem.OldAppSaleOnBoardAddOn.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn$$serializer implements GeneratedSerializer<OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem.OldAppSaleOnBoardAddOn> {
    public static final int $stable;
    public static final OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn$$serializer oldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn$$serializer = new OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn$$serializer();
        INSTANCE = oldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.core.migration.oldApp.OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem.OldAppSaleOnBoardAddOn", oldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("itemNo", false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("price", false);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, DoubleSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem.OldAppSaleOnBoardAddOn deserialize(Decoder decoder) {
        String str;
        int i5;
        String str2;
        String str3;
        double d5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            str = decodeStringElement;
            i5 = 15;
            str2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            str3 = decodeStringElement2;
            d5 = beginStructure.decodeDoubleElement(serialDescriptor, 3);
        } else {
            String str4 = null;
            String str5 = null;
            boolean z5 = true;
            double d6 = 0.0d;
            String str6 = null;
            int i6 = 0;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    str4 = beginStructure.decodeStringElement(serialDescriptor, 0);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    str5 = beginStructure.decodeStringElement(serialDescriptor, 1);
                    i6 |= 2;
                } else if (decodeElementIndex == 2) {
                    str6 = beginStructure.decodeStringElement(serialDescriptor, 2);
                    i6 |= 4;
                } else {
                    if (decodeElementIndex != 3) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    d6 = beginStructure.decodeDoubleElement(serialDescriptor, 3);
                    i6 |= 8;
                }
            }
            str = str4;
            i5 = i6;
            str2 = str6;
            str3 = str5;
            d5 = d6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem.OldAppSaleOnBoardAddOn(i5, str, str3, str2, d5, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem.OldAppSaleOnBoardAddOn value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        OldAppSaleOnBoardOrder.OldAppSaleOnBoardBasketItem.OldAppSaleOnBoardAddOn.write$Self$app_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
