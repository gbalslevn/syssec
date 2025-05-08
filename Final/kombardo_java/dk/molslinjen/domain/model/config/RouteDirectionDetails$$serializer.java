package dk.molslinjen.domain.model.config;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.model.booking.RouteType;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/config/RouteDirectionDetails.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/config/RouteDirectionDetails;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class RouteDirectionDetails$$serializer implements GeneratedSerializer<RouteDirectionDetails> {
    public static final RouteDirectionDetails$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        RouteDirectionDetails$$serializer routeDirectionDetails$$serializer = new RouteDirectionDetails$$serializer();
        INSTANCE = routeDirectionDetails$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.config.RouteDirectionDetails", routeDirectionDetails$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("askForPersonData", false);
        pluginGeneratedSerialDescriptor.addElement("departureHarbor", false);
        pluginGeneratedSerialDescriptor.addElement("arrivalHarbor", false);
        pluginGeneratedSerialDescriptor.addElement("useRegionsAsHarbors", false);
        pluginGeneratedSerialDescriptor.addElement("routeType", false);
        pluginGeneratedSerialDescriptor.addElement("isSubRoute", false);
        pluginGeneratedSerialDescriptor.addElement("subline", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RouteDirectionDetails$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = RouteDirectionDetails.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[6];
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(Subline$$serializer.INSTANCE);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        HarborReference$$serializer harborReference$$serializer = HarborReference$$serializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, booleanSerializer, harborReference$$serializer, harborReference$$serializer, booleanSerializer, kSerializer, booleanSerializer, nullable};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0081. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final RouteDirectionDetails deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        boolean z5;
        Subline subline;
        RouteType routeType;
        HarborReference harborReference;
        HarborReference harborReference2;
        boolean z6;
        boolean z7;
        int i5;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = RouteDirectionDetails.$childSerializers;
        int i6 = 7;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 2);
            HarborReference$$serializer harborReference$$serializer = HarborReference$$serializer.INSTANCE;
            HarborReference harborReference3 = (HarborReference) beginStructure.decodeSerializableElement(serialDescriptor, 3, harborReference$$serializer, null);
            HarborReference harborReference4 = (HarborReference) beginStructure.decodeSerializableElement(serialDescriptor, 4, harborReference$$serializer, null);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 5);
            routeType = (RouteType) beginStructure.decodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], null);
            str = decodeStringElement;
            z5 = beginStructure.decodeBooleanElement(serialDescriptor, 7);
            z6 = decodeBooleanElement2;
            harborReference2 = harborReference3;
            subline = (Subline) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, Subline$$serializer.INSTANCE, null);
            harborReference = harborReference4;
            z7 = decodeBooleanElement;
            i5 = 511;
            str2 = decodeStringElement2;
        } else {
            boolean z8 = true;
            boolean z9 = false;
            boolean z10 = false;
            int i7 = 0;
            Subline subline2 = null;
            RouteType routeType2 = null;
            HarborReference harborReference5 = null;
            String str3 = null;
            String str4 = null;
            HarborReference harborReference6 = null;
            boolean z11 = false;
            while (z8) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z8 = false;
                        i6 = 7;
                    case 0:
                        str3 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i7 |= 1;
                        i6 = 7;
                    case 1:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i7 |= 2;
                        i6 = 7;
                    case 2:
                        z10 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                        i7 |= 4;
                        i6 = 7;
                    case 3:
                        harborReference6 = (HarborReference) beginStructure.decodeSerializableElement(serialDescriptor, 3, HarborReference$$serializer.INSTANCE, harborReference6);
                        i7 |= 8;
                        i6 = 7;
                    case 4:
                        harborReference5 = (HarborReference) beginStructure.decodeSerializableElement(serialDescriptor, 4, HarborReference$$serializer.INSTANCE, harborReference5);
                        i7 |= 16;
                        i6 = 7;
                    case 5:
                        z11 = beginStructure.decodeBooleanElement(serialDescriptor, 5);
                        i7 |= 32;
                    case 6:
                        routeType2 = (RouteType) beginStructure.decodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], routeType2);
                        i7 |= 64;
                    case 7:
                        z9 = beginStructure.decodeBooleanElement(serialDescriptor, i6);
                        i7 |= 128;
                    case 8:
                        subline2 = (Subline) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, Subline$$serializer.INSTANCE, subline2);
                        i7 |= 256;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z5 = z9;
            subline = subline2;
            routeType = routeType2;
            harborReference = harborReference5;
            harborReference2 = harborReference6;
            z6 = z11;
            z7 = z10;
            i5 = i7;
            str = str3;
            str2 = str4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new RouteDirectionDetails(i5, str, str2, z7, harborReference2, harborReference, z6, routeType, z5, subline, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, RouteDirectionDetails value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        RouteDirectionDetails.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
