package dk.molslinjen.domain.model.config;

import java.util.List;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/config/RouteDirectionGroup.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/config/RouteDirectionGroup;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class RouteDirectionGroup$$serializer implements GeneratedSerializer<RouteDirectionGroup> {
    public static final RouteDirectionGroup$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        RouteDirectionGroup$$serializer routeDirectionGroup$$serializer = new RouteDirectionGroup$$serializer();
        INSTANCE = routeDirectionGroup$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.config.RouteDirectionGroup", routeDirectionGroup$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("mainRouteId", false);
        pluginGeneratedSerialDescriptor.addElement("routes", false);
        pluginGeneratedSerialDescriptor.addElement("useRegionsAsHarbors", false);
        pluginGeneratedSerialDescriptor.addElement("departureHarbor", false);
        pluginGeneratedSerialDescriptor.addElement("arrivalHarbor", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RouteDirectionGroup$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = RouteDirectionGroup.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[1];
        HarborReference$$serializer harborReference$$serializer = HarborReference$$serializer.INSTANCE;
        return new KSerializer[]{StringSerializer.INSTANCE, kSerializer, BooleanSerializer.INSTANCE, harborReference$$serializer, harborReference$$serializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final RouteDirectionGroup deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        boolean z5;
        int i5;
        String str;
        List list;
        HarborReference harborReference;
        HarborReference harborReference2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = RouteDirectionGroup.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 2);
            HarborReference$$serializer harborReference$$serializer = HarborReference$$serializer.INSTANCE;
            list = list2;
            str = decodeStringElement;
            harborReference = (HarborReference) beginStructure.decodeSerializableElement(serialDescriptor, 3, harborReference$$serializer, null);
            harborReference2 = (HarborReference) beginStructure.decodeSerializableElement(serialDescriptor, 4, harborReference$$serializer, null);
            z5 = decodeBooleanElement;
            i5 = 31;
        } else {
            boolean z6 = true;
            boolean z7 = false;
            String str2 = null;
            List list3 = null;
            HarborReference harborReference3 = null;
            HarborReference harborReference4 = null;
            int i6 = 0;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z6 = false;
                } else if (decodeElementIndex == 0) {
                    str2 = beginStructure.decodeStringElement(serialDescriptor, 0);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], list3);
                    i6 |= 2;
                } else if (decodeElementIndex == 2) {
                    z7 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                    i6 |= 4;
                } else if (decodeElementIndex == 3) {
                    harborReference3 = (HarborReference) beginStructure.decodeSerializableElement(serialDescriptor, 3, HarborReference$$serializer.INSTANCE, harborReference3);
                    i6 |= 8;
                } else {
                    if (decodeElementIndex != 4) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    harborReference4 = (HarborReference) beginStructure.decodeSerializableElement(serialDescriptor, 4, HarborReference$$serializer.INSTANCE, harborReference4);
                    i6 |= 16;
                }
            }
            z5 = z7;
            i5 = i6;
            str = str2;
            list = list3;
            harborReference = harborReference3;
            harborReference2 = harborReference4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new RouteDirectionGroup(i5, str, list, z5, harborReference, harborReference2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, RouteDirectionGroup value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        RouteDirectionGroup.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
