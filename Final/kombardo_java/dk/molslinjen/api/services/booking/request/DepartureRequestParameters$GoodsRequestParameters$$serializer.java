package dk.molslinjen.api.services.booking.request;

import dk.molslinjen.api.services.booking.request.DepartureRequestParameters;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/request/DepartureRequestParameters.GoodsRequestParameters.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$GoodsRequestParameters;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class DepartureRequestParameters$GoodsRequestParameters$$serializer implements GeneratedSerializer<DepartureRequestParameters.GoodsRequestParameters> {
    public static final DepartureRequestParameters$GoodsRequestParameters$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        DepartureRequestParameters$GoodsRequestParameters$$serializer departureRequestParameters$GoodsRequestParameters$$serializer = new DepartureRequestParameters$GoodsRequestParameters$$serializer();
        INSTANCE = departureRequestParameters$GoodsRequestParameters$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.request.DepartureRequestParameters.GoodsRequestParameters", departureRequestParameters$GoodsRequestParameters$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("hasDangerousGoods", false);
        pluginGeneratedSerialDescriptor.addElement("hasLimitedQuantity", false);
        pluginGeneratedSerialDescriptor.addElement("weight", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DepartureRequestParameters$GoodsRequestParameters$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{booleanSerializer, booleanSerializer, nullable};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final DepartureRequestParameters.GoodsRequestParameters deserialize(Decoder decoder) {
        boolean z5;
        boolean z6;
        int i5;
        Double d5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 0);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
            z5 = decodeBooleanElement;
            d5 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, DoubleSerializer.INSTANCE, null);
            z6 = decodeBooleanElement2;
            i5 = 7;
        } else {
            boolean z7 = true;
            boolean z8 = false;
            int i6 = 0;
            Double d6 = null;
            boolean z9 = false;
            while (z7) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z7 = false;
                } else if (decodeElementIndex == 0) {
                    z8 = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    z9 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                    i6 |= 2;
                } else {
                    if (decodeElementIndex != 2) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    d6 = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, DoubleSerializer.INSTANCE, d6);
                    i6 |= 4;
                }
            }
            z5 = z8;
            z6 = z9;
            i5 = i6;
            d5 = d6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DepartureRequestParameters.GoodsRequestParameters(i5, z5, z6, d5, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, DepartureRequestParameters.GoodsRequestParameters value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DepartureRequestParameters.GoodsRequestParameters.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
