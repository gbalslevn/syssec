package dk.molslinjen.domain.model.agreement.multiRide;

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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/agreement/multiRide/MultiRideTransport.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideTransport;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class MultiRideTransport$$serializer implements GeneratedSerializer<MultiRideTransport> {
    public static final MultiRideTransport$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MultiRideTransport$$serializer multiRideTransport$$serializer = new MultiRideTransport$$serializer();
        INSTANCE = multiRideTransport$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.agreement.multiRide.MultiRideTransport", multiRideTransport$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("transportId", false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("maxHeightInMeters", false);
        pluginGeneratedSerialDescriptor.addElement("maxLengthInMeters", false);
        pluginGeneratedSerialDescriptor.addElement("maxWeight", false);
        pluginGeneratedSerialDescriptor.addElement("icon", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MultiRideTransport$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, doubleSerializer, doubleSerializer, doubleSerializer, stringSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0055. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final MultiRideTransport deserialize(Decoder decoder) {
        String str;
        String str2;
        double d5;
        int i5;
        String str3;
        double d6;
        double d7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 2);
            double decodeDoubleElement2 = beginStructure.decodeDoubleElement(serialDescriptor, 3);
            double decodeDoubleElement3 = beginStructure.decodeDoubleElement(serialDescriptor, 4);
            str = decodeStringElement;
            str2 = beginStructure.decodeStringElement(serialDescriptor, 5);
            d5 = decodeDoubleElement3;
            i5 = 63;
            str3 = decodeStringElement2;
            d6 = decodeDoubleElement;
            d7 = decodeDoubleElement2;
        } else {
            String str4 = null;
            String str5 = null;
            boolean z5 = true;
            int i6 = 0;
            double d8 = 0.0d;
            double d9 = 0.0d;
            double d10 = 0.0d;
            String str6 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                    case 0:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i6 |= 1;
                    case 1:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i6 |= 2;
                    case 2:
                        d8 = beginStructure.decodeDoubleElement(serialDescriptor, 2);
                        i6 |= 4;
                    case 3:
                        d9 = beginStructure.decodeDoubleElement(serialDescriptor, 3);
                        i6 |= 8;
                    case 4:
                        d10 = beginStructure.decodeDoubleElement(serialDescriptor, 4);
                        i6 |= 16;
                    case 5:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i6 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str4;
            str2 = str6;
            d5 = d10;
            i5 = i6;
            str3 = str5;
            d6 = d8;
            d7 = d9;
        }
        beginStructure.endStructure(serialDescriptor);
        return new MultiRideTransport(i5, str, str3, d6, d7, d5, str2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, MultiRideTransport value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        MultiRideTransport.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
