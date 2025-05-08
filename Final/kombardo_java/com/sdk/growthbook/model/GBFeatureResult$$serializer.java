package com.sdk.growthbook.model;

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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sdk/growthbook/model/GBFeatureResult.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sdk/growthbook/model/GBFeatureResult;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public final class GBFeatureResult$$serializer implements GeneratedSerializer<GBFeatureResult> {
    public static final GBFeatureResult$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        GBFeatureResult$$serializer gBFeatureResult$$serializer = new GBFeatureResult$$serializer();
        INSTANCE = gBFeatureResult$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sdk.growthbook.model.GBFeatureResult", gBFeatureResult$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("value", false);
        pluginGeneratedSerialDescriptor.addElement("on", true);
        pluginGeneratedSerialDescriptor.addElement("off", true);
        pluginGeneratedSerialDescriptor.addElement("source", false);
        pluginGeneratedSerialDescriptor.addElement("experiment", true);
        pluginGeneratedSerialDescriptor.addElement("experimentResult", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GBFeatureResult$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = GBFeatureResult.$childSerializers;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE);
        KSerializer<?> kSerializer = kSerializerArr[3];
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(GBExperiment$$serializer.INSTANCE);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(GBExperimentResult$$serializer.INSTANCE);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{nullable, booleanSerializer, booleanSerializer, kSerializer, nullable2, nullable3};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0069. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public GBFeatureResult deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        boolean z5;
        int i5;
        boolean z6;
        JsonElement jsonElement;
        GBFeatureSource gBFeatureSource;
        GBExperiment gBExperiment;
        GBExperimentResult gBExperimentResult;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = GBFeatureResult.$childSerializers;
        int i6 = 5;
        if (beginStructure.decodeSequentially()) {
            JsonElement jsonElement2 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 0, JsonElementSerializer.INSTANCE, null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(descriptor2, 1);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(descriptor2, 2);
            GBFeatureSource gBFeatureSource2 = (GBFeatureSource) beginStructure.decodeSerializableElement(descriptor2, 3, kSerializerArr[3], null);
            GBExperiment gBExperiment2 = (GBExperiment) beginStructure.decodeNullableSerializableElement(descriptor2, 4, GBExperiment$$serializer.INSTANCE, null);
            gBFeatureSource = gBFeatureSource2;
            jsonElement = jsonElement2;
            gBExperimentResult = (GBExperimentResult) beginStructure.decodeNullableSerializableElement(descriptor2, 5, GBExperimentResult$$serializer.INSTANCE, null);
            gBExperiment = gBExperiment2;
            z5 = decodeBooleanElement2;
            i5 = 63;
            z6 = decodeBooleanElement;
        } else {
            boolean z7 = true;
            boolean z8 = false;
            boolean z9 = false;
            JsonElement jsonElement3 = null;
            GBFeatureSource gBFeatureSource3 = null;
            GBExperiment gBExperiment3 = null;
            GBExperimentResult gBExperimentResult2 = null;
            int i7 = 0;
            while (z7) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z7 = false;
                        i6 = 5;
                    case 0:
                        jsonElement3 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 0, JsonElementSerializer.INSTANCE, jsonElement3);
                        i7 |= 1;
                        i6 = 5;
                    case 1:
                        z9 = beginStructure.decodeBooleanElement(descriptor2, 1);
                        i7 |= 2;
                    case 2:
                        z8 = beginStructure.decodeBooleanElement(descriptor2, 2);
                        i7 |= 4;
                    case 3:
                        gBFeatureSource3 = (GBFeatureSource) beginStructure.decodeSerializableElement(descriptor2, 3, kSerializerArr[3], gBFeatureSource3);
                        i7 |= 8;
                    case 4:
                        gBExperiment3 = (GBExperiment) beginStructure.decodeNullableSerializableElement(descriptor2, 4, GBExperiment$$serializer.INSTANCE, gBExperiment3);
                        i7 |= 16;
                    case 5:
                        gBExperimentResult2 = (GBExperimentResult) beginStructure.decodeNullableSerializableElement(descriptor2, i6, GBExperimentResult$$serializer.INSTANCE, gBExperimentResult2);
                        i7 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z5 = z8;
            i5 = i7;
            z6 = z9;
            jsonElement = jsonElement3;
            gBFeatureSource = gBFeatureSource3;
            gBExperiment = gBExperiment3;
            gBExperimentResult = gBExperimentResult2;
        }
        beginStructure.endStructure(descriptor2);
        return new GBFeatureResult(i5, jsonElement, z6, z5, gBFeatureSource, gBExperiment, gBExperimentResult, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, GBFeatureResult value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        GBFeatureResult.write$Self$GrowthBook_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
