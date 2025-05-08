package dk.molslinjen.api.services.saleOnBoard.request;

import dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters.AddOnRequestParameters.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$AddOnRequestParameters;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class PatchOrderRequestParameters$AddOnRequestParameters$$serializer implements GeneratedSerializer<PatchOrderRequestParameters.AddOnRequestParameters> {
    public static final PatchOrderRequestParameters$AddOnRequestParameters$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PatchOrderRequestParameters$AddOnRequestParameters$$serializer patchOrderRequestParameters$AddOnRequestParameters$$serializer = new PatchOrderRequestParameters$AddOnRequestParameters$$serializer();
        INSTANCE = patchOrderRequestParameters$AddOnRequestParameters$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters.AddOnRequestParameters", patchOrderRequestParameters$AddOnRequestParameters$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("itemNo", false);
        pluginGeneratedSerialDescriptor.addElement("description", false);
        pluginGeneratedSerialDescriptor.addElement("price", false);
        pluginGeneratedSerialDescriptor.addElement("quantity", false);
        pluginGeneratedSerialDescriptor.addElement("addOn", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PatchOrderRequestParameters$AddOnRequestParameters$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, DoubleSerializer.INSTANCE, IntSerializer.INSTANCE, BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final PatchOrderRequestParameters.AddOnRequestParameters deserialize(Decoder decoder) {
        String str;
        int i5;
        boolean z5;
        int i6;
        String str2;
        double d5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 2);
            str = decodeStringElement;
            i5 = beginStructure.decodeIntElement(serialDescriptor, 3);
            z5 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
            i6 = 31;
            str2 = decodeStringElement2;
            d5 = decodeDoubleElement;
        } else {
            String str3 = null;
            String str4 = null;
            boolean z6 = true;
            int i7 = 0;
            double d6 = 0.0d;
            int i8 = 0;
            boolean z7 = false;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z6 = false;
                } else if (decodeElementIndex == 0) {
                    str3 = beginStructure.decodeStringElement(serialDescriptor, 0);
                    i7 |= 1;
                } else if (decodeElementIndex == 1) {
                    str4 = beginStructure.decodeStringElement(serialDescriptor, 1);
                    i7 |= 2;
                } else if (decodeElementIndex == 2) {
                    d6 = beginStructure.decodeDoubleElement(serialDescriptor, 2);
                    i7 |= 4;
                } else if (decodeElementIndex == 3) {
                    i8 = beginStructure.decodeIntElement(serialDescriptor, 3);
                    i7 |= 8;
                } else {
                    if (decodeElementIndex != 4) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    z7 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
                    i7 |= 16;
                }
            }
            str = str3;
            i5 = i8;
            z5 = z7;
            i6 = i7;
            str2 = str4;
            d5 = d6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new PatchOrderRequestParameters.AddOnRequestParameters(i6, str, str2, d5, i5, z5, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, PatchOrderRequestParameters.AddOnRequestParameters value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        PatchOrderRequestParameters.AddOnRequestParameters.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
