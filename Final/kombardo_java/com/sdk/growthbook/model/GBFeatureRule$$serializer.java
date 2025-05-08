package com.sdk.growthbook.model;

import com.sdk.growthbook.utils.Constants;
import com.sdk.growthbook.utils.OptionalProperty;
import com.sdk.growthbook.utils.RangeSerializer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArraySerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sdk/growthbook/model/GBFeatureRule.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sdk/growthbook/model/GBFeatureRule;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public final class GBFeatureRule$$serializer implements GeneratedSerializer<GBFeatureRule> {
    public static final GBFeatureRule$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        GBFeatureRule$$serializer gBFeatureRule$$serializer = new GBFeatureRule$$serializer();
        INSTANCE = gBFeatureRule$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sdk.growthbook.model.GBFeatureRule", gBFeatureRule$$serializer, 23);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, true);
        pluginGeneratedSerialDescriptor.addElement("condition", true);
        pluginGeneratedSerialDescriptor.addElement("parentConditions", true);
        pluginGeneratedSerialDescriptor.addElement("coverage", true);
        pluginGeneratedSerialDescriptor.addElement("force", true);
        pluginGeneratedSerialDescriptor.addElement("variations", true);
        pluginGeneratedSerialDescriptor.addElement("key", true);
        pluginGeneratedSerialDescriptor.addElement("weights", true);
        pluginGeneratedSerialDescriptor.addElement("namespace", true);
        pluginGeneratedSerialDescriptor.addElement("hashAttribute", true);
        pluginGeneratedSerialDescriptor.addElement("hashVersion", true);
        pluginGeneratedSerialDescriptor.addElement("range", true);
        pluginGeneratedSerialDescriptor.addElement("ranges", true);
        pluginGeneratedSerialDescriptor.addElement("meta", true);
        pluginGeneratedSerialDescriptor.addElement("filters", true);
        pluginGeneratedSerialDescriptor.addElement("seed", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("phase", true);
        pluginGeneratedSerialDescriptor.addElement("fallbackAttribute", true);
        pluginGeneratedSerialDescriptor.addElement("disableStickyBucketing", true);
        pluginGeneratedSerialDescriptor.addElement("bucketVersion", true);
        pluginGeneratedSerialDescriptor.addElement("minBucketVersion", true);
        pluginGeneratedSerialDescriptor.addElement("tracks", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GBFeatureRule$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = GBFeatureRule.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(kSerializerArr[2]);
        KSerializer<?> nullable4 = BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE);
        KSerializer<?> kSerializer = kSerializerArr[4];
        KSerializer<?> nullable5 = BuiltinSerializersKt.getNullable(kSerializerArr[5]);
        KSerializer<?> nullable6 = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable7 = BuiltinSerializersKt.getNullable(kSerializerArr[7]);
        KSerializer<?> nullable8 = BuiltinSerializersKt.getNullable(JsonArraySerializer.INSTANCE);
        KSerializer<?> nullable9 = BuiltinSerializersKt.getNullable(stringSerializer);
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{nullable, nullable2, nullable3, nullable4, kSerializer, nullable5, nullable6, nullable7, nullable8, nullable9, BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(RangeSerializer.GBBucketRangeSerializer.INSTANCE), BuiltinSerializersKt.getNullable(RangeSerializer.GBBucketRangeListSerializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[13]), BuiltinSerializersKt.getNullable(kSerializerArr[14]), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(kSerializerArr[22])};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0162. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public GBFeatureRule deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        String str;
        Float f5;
        ArrayList arrayList;
        JsonArray jsonArray;
        List list;
        int i5;
        Pair pair;
        Integer num;
        List list2;
        OptionalProperty optionalProperty;
        String str2;
        String str3;
        Boolean bool;
        String str4;
        String str5;
        String str6;
        ArrayList arrayList2;
        List list3;
        ArrayList arrayList3;
        String str7;
        Integer num2;
        Integer num3;
        JsonElement jsonElement;
        ArrayList arrayList4;
        KSerializer[] kSerializerArr2;
        JsonElement jsonElement2;
        String str8;
        Boolean bool2;
        Boolean bool3;
        JsonElement jsonElement3;
        String str9;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = GBFeatureRule.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str10 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, stringSerializer, null);
            JsonElement jsonElement4 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 1, JsonElementSerializer.INSTANCE, null);
            ArrayList arrayList5 = (ArrayList) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kSerializerArr[2], null);
            Float f6 = (Float) beginStructure.decodeNullableSerializableElement(descriptor2, 3, FloatSerializer.INSTANCE, null);
            OptionalProperty optionalProperty2 = (OptionalProperty) beginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], null);
            List list4 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, stringSerializer, null);
            List list5 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 7, kSerializerArr[7], null);
            JsonArray jsonArray2 = (JsonArray) beginStructure.decodeNullableSerializableElement(descriptor2, 8, JsonArraySerializer.INSTANCE, null);
            String str12 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 9, stringSerializer, null);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            Integer num4 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 10, intSerializer, null);
            Pair pair2 = (Pair) beginStructure.decodeNullableSerializableElement(descriptor2, 11, RangeSerializer.GBBucketRangeSerializer.INSTANCE, null);
            List list6 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 12, RangeSerializer.GBBucketRangeListSerializer.INSTANCE, null);
            ArrayList arrayList6 = (ArrayList) beginStructure.decodeNullableSerializableElement(descriptor2, 13, kSerializerArr[13], null);
            ArrayList arrayList7 = (ArrayList) beginStructure.decodeNullableSerializableElement(descriptor2, 14, kSerializerArr[14], null);
            String str13 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 15, stringSerializer, null);
            String str14 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 16, stringSerializer, null);
            String str15 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 17, stringSerializer, null);
            String str16 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 18, stringSerializer, null);
            Boolean bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 19, BooleanSerializer.INSTANCE, null);
            Integer num5 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 20, intSerializer, null);
            Integer num6 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 21, intSerializer, null);
            bool = bool4;
            arrayList4 = (ArrayList) beginStructure.decodeNullableSerializableElement(descriptor2, 22, kSerializerArr[22], null);
            num3 = num6;
            num2 = num5;
            str7 = str13;
            list2 = list5;
            optionalProperty = optionalProperty2;
            str = str10;
            i5 = 8388607;
            f5 = f6;
            str3 = str12;
            str2 = str11;
            list = list4;
            jsonArray = jsonArray2;
            str4 = str16;
            str5 = str15;
            str6 = str14;
            arrayList3 = arrayList7;
            arrayList2 = arrayList6;
            list3 = list6;
            pair = pair2;
            num = num4;
            arrayList = arrayList5;
            jsonElement = jsonElement4;
        } else {
            boolean z5 = true;
            Float f7 = null;
            ArrayList arrayList8 = null;
            JsonArray jsonArray3 = null;
            List list7 = null;
            String str17 = null;
            Integer num7 = null;
            List list8 = null;
            OptionalProperty optionalProperty3 = null;
            String str18 = null;
            String str19 = null;
            Pair pair3 = null;
            List list9 = null;
            ArrayList arrayList9 = null;
            ArrayList arrayList10 = null;
            String str20 = null;
            String str21 = null;
            String str22 = null;
            String str23 = null;
            Boolean bool5 = null;
            Integer num8 = null;
            Integer num9 = null;
            ArrayList arrayList11 = null;
            int i6 = 0;
            JsonElement jsonElement5 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        kSerializerArr2 = kSerializerArr;
                        jsonElement2 = jsonElement5;
                        str8 = str17;
                        bool2 = bool5;
                        z5 = false;
                        jsonElement5 = jsonElement2;
                        str17 = str8;
                        bool5 = bool2;
                        kSerializerArr = kSerializerArr2;
                    case 0:
                        kSerializerArr2 = kSerializerArr;
                        bool2 = bool5;
                        jsonElement2 = jsonElement5;
                        str8 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str17);
                        i6 |= 1;
                        jsonElement5 = jsonElement2;
                        str17 = str8;
                        bool5 = bool2;
                        kSerializerArr = kSerializerArr2;
                    case 1:
                        bool3 = bool5;
                        i6 |= 2;
                        jsonElement5 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 1, JsonElementSerializer.INSTANCE, jsonElement5);
                        kSerializerArr = kSerializerArr;
                        str17 = str17;
                        bool5 = bool3;
                    case 2:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        arrayList8 = (ArrayList) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kSerializerArr[2], arrayList8);
                        i6 |= 4;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 3:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        f7 = (Float) beginStructure.decodeNullableSerializableElement(descriptor2, 3, FloatSerializer.INSTANCE, f7);
                        i6 |= 8;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 4:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        optionalProperty3 = (OptionalProperty) beginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], optionalProperty3);
                        i6 |= 16;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 5:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        list7 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 5, kSerializerArr[5], list7);
                        i6 |= 32;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 6:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str18);
                        i6 |= 64;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 7:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        list8 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 7, kSerializerArr[7], list8);
                        i6 |= 128;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 8:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        jsonArray3 = (JsonArray) beginStructure.decodeNullableSerializableElement(descriptor2, 8, JsonArraySerializer.INSTANCE, jsonArray3);
                        i6 |= 256;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 9:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, str19);
                        i6 |= 512;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 10:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        num7 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 10, IntSerializer.INSTANCE, num7);
                        i6 |= 1024;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 11:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        pair3 = (Pair) beginStructure.decodeNullableSerializableElement(descriptor2, 11, RangeSerializer.GBBucketRangeSerializer.INSTANCE, pair3);
                        i6 |= 2048;
                        list9 = list9;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 12:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        list9 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 12, RangeSerializer.GBBucketRangeListSerializer.INSTANCE, list9);
                        i6 |= 4096;
                        arrayList9 = arrayList9;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 13:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        arrayList9 = (ArrayList) beginStructure.decodeNullableSerializableElement(descriptor2, 13, kSerializerArr[13], arrayList9);
                        i6 |= 8192;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 14:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        arrayList10 = (ArrayList) beginStructure.decodeNullableSerializableElement(descriptor2, 14, kSerializerArr[14], arrayList10);
                        i6 |= 16384;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 15:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        str20 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, str20);
                        i6 |= 32768;
                        str21 = str21;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 16:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        str21 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 16, StringSerializer.INSTANCE, str21);
                        i6 |= 65536;
                        str22 = str22;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 17:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        str22 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 17, StringSerializer.INSTANCE, str22);
                        i6 |= 131072;
                        str23 = str23;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 18:
                        jsonElement3 = jsonElement5;
                        str9 = str17;
                        bool3 = bool5;
                        str23 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 18, StringSerializer.INSTANCE, str23);
                        i6 |= 262144;
                        str17 = str9;
                        jsonElement5 = jsonElement3;
                        bool5 = bool3;
                    case 19:
                        i6 |= 524288;
                        num8 = num8;
                        str17 = str17;
                        jsonElement5 = jsonElement5;
                        bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 19, BooleanSerializer.INSTANCE, bool5);
                    case 20:
                        num8 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 20, IntSerializer.INSTANCE, num8);
                        i6 |= 1048576;
                        str17 = str17;
                        jsonElement5 = jsonElement5;
                    case 21:
                        num9 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 21, IntSerializer.INSTANCE, num9);
                        i6 |= 2097152;
                        str17 = str17;
                        jsonElement5 = jsonElement5;
                        arrayList11 = arrayList11;
                    case 22:
                        arrayList11 = (ArrayList) beginStructure.decodeNullableSerializableElement(descriptor2, 22, kSerializerArr[22], arrayList11);
                        i6 |= 4194304;
                        str17 = str17;
                        jsonElement5 = jsonElement5;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str17;
            f5 = f7;
            arrayList = arrayList8;
            jsonArray = jsonArray3;
            list = list7;
            i5 = i6;
            pair = pair3;
            num = num7;
            list2 = list8;
            optionalProperty = optionalProperty3;
            str2 = str18;
            str3 = str19;
            bool = bool5;
            str4 = str23;
            str5 = str22;
            str6 = str21;
            arrayList2 = arrayList9;
            list3 = list9;
            arrayList3 = arrayList10;
            str7 = str20;
            num2 = num8;
            num3 = num9;
            jsonElement = jsonElement5;
            arrayList4 = arrayList11;
        }
        beginStructure.endStructure(descriptor2);
        return new GBFeatureRule(i5, str, jsonElement, arrayList, f5, optionalProperty, list, str2, list2, jsonArray, str3, num, pair, list3, arrayList2, arrayList3, str7, str6, str5, str4, bool, num2, num3, arrayList4, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, GBFeatureRule value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        GBFeatureRule.write$Self$GrowthBook_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
