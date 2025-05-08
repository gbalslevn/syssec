package com.sdk.growthbook.utils;

import java.util.Map;
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
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sdk/growthbook/utils/GBStickyAssignmentsDocument.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sdk/growthbook/utils/GBStickyAssignmentsDocument;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public final class GBStickyAssignmentsDocument$$serializer implements GeneratedSerializer<GBStickyAssignmentsDocument> {
    public static final GBStickyAssignmentsDocument$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        GBStickyAssignmentsDocument$$serializer gBStickyAssignmentsDocument$$serializer = new GBStickyAssignmentsDocument$$serializer();
        INSTANCE = gBStickyAssignmentsDocument$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sdk.growthbook.utils.GBStickyAssignmentsDocument", gBStickyAssignmentsDocument$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("attributeName", false);
        pluginGeneratedSerialDescriptor.addElement("attributeValue", false);
        pluginGeneratedSerialDescriptor.addElement("assignments", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GBStickyAssignmentsDocument$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = GBStickyAssignmentsDocument.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[2];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, kSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public GBStickyAssignmentsDocument deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        String str;
        String str2;
        Map map;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = GBStickyAssignmentsDocument.$childSerializers;
        String str3 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(descriptor2, 1);
            map = (Map) beginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], null);
            str = decodeStringElement;
            i5 = 7;
            str2 = decodeStringElement2;
        } else {
            boolean z5 = true;
            int i6 = 0;
            String str4 = null;
            Map map2 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    str3 = beginStructure.decodeStringElement(descriptor2, 0);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    str4 = beginStructure.decodeStringElement(descriptor2, 1);
                    i6 |= 2;
                } else {
                    if (decodeElementIndex != 2) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    map2 = (Map) beginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], map2);
                    i6 |= 4;
                }
            }
            i5 = i6;
            str = str3;
            str2 = str4;
            map = map2;
        }
        beginStructure.endStructure(descriptor2);
        return new GBStickyAssignmentsDocument(i5, str, str2, map, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, GBStickyAssignmentsDocument value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        GBStickyAssignmentsDocument.write$Self$GrowthBook_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
