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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sdk/growthbook/model/GBExperimentResult.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sdk/growthbook/model/GBExperimentResult;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public final class GBExperimentResult$$serializer implements GeneratedSerializer<GBExperimentResult> {
    public static final GBExperimentResult$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        GBExperimentResult$$serializer gBExperimentResult$$serializer = new GBExperimentResult$$serializer();
        INSTANCE = gBExperimentResult$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sdk.growthbook.model.GBExperimentResult", gBExperimentResult$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("inExperiment", true);
        pluginGeneratedSerialDescriptor.addElement("variationId", true);
        pluginGeneratedSerialDescriptor.addElement("value", true);
        pluginGeneratedSerialDescriptor.addElement("hashAttribute", true);
        pluginGeneratedSerialDescriptor.addElement("hashValue", true);
        pluginGeneratedSerialDescriptor.addElement("key", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("bucket", true);
        pluginGeneratedSerialDescriptor.addElement("passthrough", true);
        pluginGeneratedSerialDescriptor.addElement("hashUsed", true);
        pluginGeneratedSerialDescriptor.addElement("featureId", true);
        pluginGeneratedSerialDescriptor.addElement("stickyBucketUsed", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GBExperimentResult$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{booleanSerializer, IntSerializer.INSTANCE, JsonElementSerializer.INSTANCE, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(booleanSerializer), BuiltinSerializersKt.getNullable(booleanSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(booleanSerializer)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00a5. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public GBExperimentResult deserialize(Decoder decoder) {
        boolean z5;
        int i5;
        String str;
        Boolean bool;
        Boolean bool2;
        String str2;
        Boolean bool3;
        Float f5;
        String str3;
        String str4;
        JsonElement jsonElement;
        int i6;
        String str5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        if (beginStructure.decodeSequentially()) {
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(descriptor2, 0);
            int decodeIntElement = beginStructure.decodeIntElement(descriptor2, 1);
            JsonElement jsonElement2 = (JsonElement) beginStructure.decodeSerializableElement(descriptor2, 2, JsonElementSerializer.INSTANCE, null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str6 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, stringSerializer, null);
            String str7 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, stringSerializer, null);
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 5);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, stringSerializer, null);
            Float f6 = (Float) beginStructure.decodeNullableSerializableElement(descriptor2, 7, FloatSerializer.INSTANCE, null);
            BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
            Boolean bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 8, booleanSerializer, null);
            Boolean bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 9, booleanSerializer, null);
            z5 = decodeBooleanElement;
            f5 = f6;
            str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 10, stringSerializer, null);
            bool = bool5;
            bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 11, booleanSerializer, null);
            str2 = str8;
            str5 = decodeStringElement;
            str4 = str6;
            bool2 = bool4;
            str3 = str7;
            jsonElement = jsonElement2;
            i5 = decodeIntElement;
            i6 = 4095;
        } else {
            boolean z6 = true;
            boolean z7 = false;
            int i7 = 0;
            String str9 = null;
            Boolean bool6 = null;
            Boolean bool7 = null;
            String str10 = null;
            Boolean bool8 = null;
            Float f7 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            JsonElement jsonElement3 = null;
            int i8 = 0;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z6 = false;
                    case 0:
                        i8 |= 1;
                        z7 = beginStructure.decodeBooleanElement(descriptor2, 0);
                    case 1:
                        i7 = beginStructure.decodeIntElement(descriptor2, 1);
                        i8 |= 2;
                    case 2:
                        jsonElement3 = (JsonElement) beginStructure.decodeSerializableElement(descriptor2, 2, JsonElementSerializer.INSTANCE, jsonElement3);
                        i8 |= 4;
                    case 3:
                        str12 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str12);
                        i8 |= 8;
                    case 4:
                        str11 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str11);
                        i8 |= 16;
                    case 5:
                        str13 = beginStructure.decodeStringElement(descriptor2, 5);
                        i8 |= 32;
                    case 6:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str10);
                        i8 |= 64;
                    case 7:
                        f7 = (Float) beginStructure.decodeNullableSerializableElement(descriptor2, 7, FloatSerializer.INSTANCE, f7);
                        i8 |= 128;
                    case 8:
                        bool7 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 8, BooleanSerializer.INSTANCE, bool7);
                        i8 |= 256;
                    case 9:
                        bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 9, BooleanSerializer.INSTANCE, bool6);
                        i8 |= 512;
                    case 10:
                        str9 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, str9);
                        i8 |= 1024;
                    case 11:
                        bool8 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 11, BooleanSerializer.INSTANCE, bool8);
                        i8 |= 2048;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z5 = z7;
            i5 = i7;
            str = str9;
            bool = bool6;
            bool2 = bool7;
            str2 = str10;
            bool3 = bool8;
            f5 = f7;
            str3 = str11;
            str4 = str12;
            jsonElement = jsonElement3;
            i6 = i8;
            str5 = str13;
        }
        beginStructure.endStructure(descriptor2);
        return new GBExperimentResult(i6, z5, i5, jsonElement, str4, str3, str5, str2, f5, bool2, bool, str, bool3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, GBExperimentResult value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        GBExperimentResult.write$Self$GrowthBook_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
