package dk.molslinjen.domain.model.config;

import dk.molslinjen.api.helpers.serializers.IntRangeSerializer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/config/AgeClassifications.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/config/AgeClassifications;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class AgeClassifications$$serializer implements GeneratedSerializer<AgeClassifications> {
    public static final AgeClassifications$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        AgeClassifications$$serializer ageClassifications$$serializer = new AgeClassifications$$serializer();
        INSTANCE = ageClassifications$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.config.AgeClassifications", ageClassifications$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("infantRange", false);
        pluginGeneratedSerialDescriptor.addElement("childRange", false);
        pluginGeneratedSerialDescriptor.addElement("adultRange", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AgeClassifications$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        IntRangeSerializer intRangeSerializer = IntRangeSerializer.INSTANCE;
        return new KSerializer[]{intRangeSerializer, intRangeSerializer, intRangeSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final AgeClassifications deserialize(Decoder decoder) {
        int i5;
        IntRange intRange;
        IntRange intRange2;
        IntRange intRange3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        IntRange intRange4 = null;
        if (beginStructure.decodeSequentially()) {
            IntRangeSerializer intRangeSerializer = IntRangeSerializer.INSTANCE;
            IntRange intRange5 = (IntRange) beginStructure.decodeSerializableElement(serialDescriptor, 0, intRangeSerializer, null);
            IntRange intRange6 = (IntRange) beginStructure.decodeSerializableElement(serialDescriptor, 1, intRangeSerializer, null);
            intRange3 = (IntRange) beginStructure.decodeSerializableElement(serialDescriptor, 2, intRangeSerializer, null);
            i5 = 7;
            intRange2 = intRange6;
            intRange = intRange5;
        } else {
            boolean z5 = true;
            int i6 = 0;
            IntRange intRange7 = null;
            IntRange intRange8 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    intRange4 = (IntRange) beginStructure.decodeSerializableElement(serialDescriptor, 0, IntRangeSerializer.INSTANCE, intRange4);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    intRange7 = (IntRange) beginStructure.decodeSerializableElement(serialDescriptor, 1, IntRangeSerializer.INSTANCE, intRange7);
                    i6 |= 2;
                } else {
                    if (decodeElementIndex != 2) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    intRange8 = (IntRange) beginStructure.decodeSerializableElement(serialDescriptor, 2, IntRangeSerializer.INSTANCE, intRange8);
                    i6 |= 4;
                }
            }
            i5 = i6;
            intRange = intRange4;
            intRange2 = intRange7;
            intRange3 = intRange8;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AgeClassifications(i5, intRange, intRange2, intRange3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, AgeClassifications value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AgeClassifications.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
