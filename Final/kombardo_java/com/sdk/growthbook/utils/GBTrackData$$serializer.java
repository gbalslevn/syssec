package com.sdk.growthbook.utils;

import com.sdk.growthbook.model.GBExperiment;
import com.sdk.growthbook.model.GBExperiment$$serializer;
import com.sdk.growthbook.model.GBFeatureResult;
import com.sdk.growthbook.model.GBFeatureResult$$serializer;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sdk/growthbook/utils/GBTrackData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sdk/growthbook/utils/GBTrackData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public final class GBTrackData$$serializer implements GeneratedSerializer<GBTrackData> {
    public static final GBTrackData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        GBTrackData$$serializer gBTrackData$$serializer = new GBTrackData$$serializer();
        INSTANCE = gBTrackData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sdk.growthbook.utils.GBTrackData", gBTrackData$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("experiment", false);
        pluginGeneratedSerialDescriptor.addElement("result", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GBTrackData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{GBExperiment$$serializer.INSTANCE, GBFeatureResult$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public GBTrackData deserialize(Decoder decoder) {
        GBExperiment gBExperiment;
        GBFeatureResult gBFeatureResult;
        int i5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        if (beginStructure.decodeSequentially()) {
            gBExperiment = (GBExperiment) beginStructure.decodeSerializableElement(descriptor2, 0, GBExperiment$$serializer.INSTANCE, null);
            gBFeatureResult = (GBFeatureResult) beginStructure.decodeSerializableElement(descriptor2, 1, GBFeatureResult$$serializer.INSTANCE, null);
            i5 = 3;
        } else {
            boolean z5 = true;
            int i6 = 0;
            gBExperiment = null;
            GBFeatureResult gBFeatureResult2 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    gBExperiment = (GBExperiment) beginStructure.decodeSerializableElement(descriptor2, 0, GBExperiment$$serializer.INSTANCE, gBExperiment);
                    i6 |= 1;
                } else {
                    if (decodeElementIndex != 1) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    gBFeatureResult2 = (GBFeatureResult) beginStructure.decodeSerializableElement(descriptor2, 1, GBFeatureResult$$serializer.INSTANCE, gBFeatureResult2);
                    i6 |= 2;
                }
            }
            gBFeatureResult = gBFeatureResult2;
            i5 = i6;
        }
        beginStructure.endStructure(descriptor2);
        return new GBTrackData(i5, gBExperiment, gBFeatureResult, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, GBTrackData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        GBTrackData.write$Self$GrowthBook_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
