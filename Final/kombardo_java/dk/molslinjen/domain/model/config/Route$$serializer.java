package dk.molslinjen.domain.model.config;

import com.sdk.growthbook.utils.Constants;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/config/Route.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/config/Route;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class Route$$serializer implements GeneratedSerializer<Route> {
    public static final Route$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Route$$serializer route$$serializer = new Route$$serializer();
        INSTANCE = route$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.config.Route", route$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("outRoute", false);
        pluginGeneratedSerialDescriptor.addElement("returnRoute", false);
        pluginGeneratedSerialDescriptor.addElement("usesRegions", false);
        pluginGeneratedSerialDescriptor.addElement("isEarlyCheckInPossible", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Route$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        RouteDirectionGroup$$serializer routeDirectionGroup$$serializer = RouteDirectionGroup$$serializer.INSTANCE;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{StringSerializer.INSTANCE, routeDirectionGroup$$serializer, routeDirectionGroup$$serializer, booleanSerializer, booleanSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Route deserialize(Decoder decoder) {
        boolean z5;
        boolean z6;
        int i5;
        String str;
        RouteDirectionGroup routeDirectionGroup;
        RouteDirectionGroup routeDirectionGroup2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            RouteDirectionGroup$$serializer routeDirectionGroup$$serializer = RouteDirectionGroup$$serializer.INSTANCE;
            RouteDirectionGroup routeDirectionGroup3 = (RouteDirectionGroup) beginStructure.decodeSerializableElement(serialDescriptor, 1, routeDirectionGroup$$serializer, null);
            RouteDirectionGroup routeDirectionGroup4 = (RouteDirectionGroup) beginStructure.decodeSerializableElement(serialDescriptor, 2, routeDirectionGroup$$serializer, null);
            str = decodeStringElement;
            z5 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
            z6 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
            routeDirectionGroup2 = routeDirectionGroup4;
            routeDirectionGroup = routeDirectionGroup3;
            i5 = 31;
        } else {
            boolean z7 = true;
            boolean z8 = false;
            int i6 = 0;
            String str2 = null;
            RouteDirectionGroup routeDirectionGroup5 = null;
            RouteDirectionGroup routeDirectionGroup6 = null;
            boolean z9 = false;
            while (z7) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z7 = false;
                } else if (decodeElementIndex == 0) {
                    str2 = beginStructure.decodeStringElement(serialDescriptor, 0);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    routeDirectionGroup5 = (RouteDirectionGroup) beginStructure.decodeSerializableElement(serialDescriptor, 1, RouteDirectionGroup$$serializer.INSTANCE, routeDirectionGroup5);
                    i6 |= 2;
                } else if (decodeElementIndex == 2) {
                    routeDirectionGroup6 = (RouteDirectionGroup) beginStructure.decodeSerializableElement(serialDescriptor, 2, RouteDirectionGroup$$serializer.INSTANCE, routeDirectionGroup6);
                    i6 |= 4;
                } else if (decodeElementIndex == 3) {
                    z8 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                    i6 |= 8;
                } else {
                    if (decodeElementIndex != 4) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    z9 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
                    i6 |= 16;
                }
            }
            z5 = z8;
            z6 = z9;
            i5 = i6;
            str = str2;
            routeDirectionGroup = routeDirectionGroup5;
            routeDirectionGroup2 = routeDirectionGroup6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new Route(i5, str, routeDirectionGroup, routeDirectionGroup2, z5, z6, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Route value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        Route.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
