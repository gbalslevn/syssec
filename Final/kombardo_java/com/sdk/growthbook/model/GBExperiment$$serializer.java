package com.sdk.growthbook.model;

import com.sdk.growthbook.utils.RangeSerializer;
import java.util.ArrayList;
import java.util.List;
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
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArraySerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sdk/growthbook/model/GBExperiment.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sdk/growthbook/model/GBExperiment;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public final class GBExperiment$$serializer implements GeneratedSerializer<GBExperiment> {
    public static final GBExperiment$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        GBExperiment$$serializer gBExperiment$$serializer = new GBExperiment$$serializer();
        INSTANCE = gBExperiment$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sdk.growthbook.model.GBExperiment", gBExperiment$$serializer, 21);
        pluginGeneratedSerialDescriptor.addElement("key", false);
        pluginGeneratedSerialDescriptor.addElement("variations", true);
        pluginGeneratedSerialDescriptor.addElement("namespace", true);
        pluginGeneratedSerialDescriptor.addElement("hashAttribute", true);
        pluginGeneratedSerialDescriptor.addElement("weights", true);
        pluginGeneratedSerialDescriptor.addElement("active", true);
        pluginGeneratedSerialDescriptor.addElement("coverage", true);
        pluginGeneratedSerialDescriptor.addElement("condition", true);
        pluginGeneratedSerialDescriptor.addElement("parentConditions", true);
        pluginGeneratedSerialDescriptor.addElement("force", true);
        pluginGeneratedSerialDescriptor.addElement("hashVersion", true);
        pluginGeneratedSerialDescriptor.addElement("ranges", true);
        pluginGeneratedSerialDescriptor.addElement("meta", true);
        pluginGeneratedSerialDescriptor.addElement("filters", true);
        pluginGeneratedSerialDescriptor.addElement("seed", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("phase", true);
        pluginGeneratedSerialDescriptor.addElement("fallBackAttribute", true);
        pluginGeneratedSerialDescriptor.addElement("disableStickyBucketing", true);
        pluginGeneratedSerialDescriptor.addElement("bucketVersion", true);
        pluginGeneratedSerialDescriptor.addElement("minBucketVersion", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GBExperiment$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = GBExperiment.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> kSerializer = kSerializerArr[1];
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(JsonArraySerializer.INSTANCE);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(kSerializerArr[4]);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        KSerializer<?> nullable4 = BuiltinSerializersKt.getNullable(booleanSerializer);
        KSerializer<?> nullable5 = BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE);
        KSerializer<?> nullable6 = BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE);
        KSerializer<?> nullable7 = BuiltinSerializersKt.getNullable(kSerializerArr[8]);
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, kSerializer, nullable, nullable2, nullable3, nullable4, nullable5, nullable6, nullable7, BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(RangeSerializer.GBBucketRangeListSerializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[12]), BuiltinSerializersKt.getNullable(kSerializerArr[13]), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(booleanSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x013d. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public GBExperiment deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        List list;
        JsonArray jsonArray;
        Boolean bool;
        String str;
        String str2;
        String str3;
        List list2;
        Integer num;
        int i5;
        ArrayList arrayList;
        String str4;
        Integer num2;
        ArrayList arrayList2;
        Integer num3;
        String str5;
        List list3;
        Float f5;
        JsonElement jsonElement;
        ArrayList arrayList3;
        String str6;
        Boolean bool2;
        Integer num4;
        Integer num5;
        int i6;
        ArrayList arrayList4;
        Integer num6;
        JsonArray jsonArray2;
        KSerializer[] kSerializerArr2;
        ArrayList arrayList5;
        Integer num7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = GBExperiment.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 0);
            List list4 = (List) beginStructure.decodeSerializableElement(descriptor2, 1, kSerializerArr[1], null);
            JsonArray jsonArray3 = (JsonArray) beginStructure.decodeNullableSerializableElement(descriptor2, 2, JsonArraySerializer.INSTANCE, null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str7 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, stringSerializer, null);
            List list5 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 4, kSerializerArr[4], null);
            BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
            Boolean bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 5, booleanSerializer, null);
            Float f6 = (Float) beginStructure.decodeNullableSerializableElement(descriptor2, 6, FloatSerializer.INSTANCE, null);
            JsonElement jsonElement2 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 7, JsonElementSerializer.INSTANCE, null);
            ArrayList arrayList6 = (ArrayList) beginStructure.decodeNullableSerializableElement(descriptor2, 8, kSerializerArr[8], null);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            Integer num8 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 9, intSerializer, null);
            Integer num9 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 10, intSerializer, null);
            List list6 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 11, RangeSerializer.GBBucketRangeListSerializer.INSTANCE, null);
            ArrayList arrayList7 = (ArrayList) beginStructure.decodeNullableSerializableElement(descriptor2, 12, kSerializerArr[12], null);
            ArrayList arrayList8 = (ArrayList) beginStructure.decodeNullableSerializableElement(descriptor2, 13, kSerializerArr[13], null);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 14, stringSerializer, null);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 15, stringSerializer, null);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 16, stringSerializer, null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 17, stringSerializer, null);
            Boolean bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 18, booleanSerializer, null);
            Integer num10 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 19, intSerializer, null);
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 20, intSerializer, null);
            arrayList2 = arrayList7;
            str4 = str8;
            list = list4;
            jsonArray = jsonArray3;
            bool = bool4;
            arrayList3 = arrayList6;
            list3 = list5;
            i5 = 2097151;
            num = num10;
            f5 = f6;
            jsonElement = jsonElement2;
            bool2 = bool3;
            str2 = str11;
            str3 = str10;
            str = str9;
            arrayList = arrayList8;
            list2 = list6;
            num3 = num9;
            num4 = num8;
            str6 = decodeStringElement;
            str5 = str7;
        } else {
            boolean z5 = true;
            ArrayList arrayList9 = null;
            Boolean bool5 = null;
            String str12 = null;
            String str13 = null;
            List list7 = null;
            Integer num11 = null;
            ArrayList arrayList10 = null;
            String str14 = null;
            Integer num12 = null;
            Integer num13 = null;
            Integer num14 = null;
            String str15 = null;
            List list8 = null;
            JsonArray jsonArray4 = null;
            String str16 = null;
            List list9 = null;
            Boolean bool6 = null;
            Float f7 = null;
            JsonElement jsonElement3 = null;
            ArrayList arrayList11 = null;
            int i7 = 0;
            String str17 = null;
            while (z5) {
                Integer num15 = num13;
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        arrayList4 = arrayList9;
                        num6 = num12;
                        jsonArray2 = jsonArray4;
                        kSerializerArr2 = kSerializerArr;
                        z5 = false;
                        num12 = num6;
                        kSerializerArr = kSerializerArr2;
                        num13 = num15;
                        jsonArray4 = jsonArray2;
                        arrayList9 = arrayList4;
                    case 0:
                        arrayList4 = arrayList9;
                        num6 = num12;
                        jsonArray2 = jsonArray4;
                        kSerializerArr2 = kSerializerArr;
                        str15 = beginStructure.decodeStringElement(descriptor2, 0);
                        i7 |= 1;
                        num12 = num6;
                        kSerializerArr = kSerializerArr2;
                        num13 = num15;
                        jsonArray4 = jsonArray2;
                        arrayList9 = arrayList4;
                    case 1:
                        arrayList4 = arrayList9;
                        num6 = num12;
                        jsonArray2 = jsonArray4;
                        kSerializerArr2 = kSerializerArr;
                        list8 = (List) beginStructure.decodeSerializableElement(descriptor2, 1, kSerializerArr[1], list8);
                        i7 |= 2;
                        num12 = num6;
                        kSerializerArr = kSerializerArr2;
                        num13 = num15;
                        jsonArray4 = jsonArray2;
                        arrayList9 = arrayList4;
                    case 2:
                        jsonArray4 = (JsonArray) beginStructure.decodeNullableSerializableElement(descriptor2, 2, JsonArraySerializer.INSTANCE, jsonArray4);
                        i7 |= 4;
                        arrayList9 = arrayList9;
                        num12 = num12;
                        str16 = str16;
                        num13 = num15;
                    case 3:
                        str16 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str16);
                        i7 |= 8;
                        arrayList9 = arrayList9;
                        num12 = num12;
                        list9 = list9;
                        num13 = num15;
                    case 4:
                        arrayList5 = arrayList9;
                        num7 = num12;
                        list9 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 4, kSerializerArr[4], list9);
                        i7 |= 16;
                        arrayList9 = arrayList5;
                        num12 = num7;
                        num13 = num15;
                    case 5:
                        bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, bool6);
                        i7 |= 32;
                        arrayList9 = arrayList9;
                        num12 = num12;
                        f7 = f7;
                        num13 = num15;
                    case 6:
                        f7 = (Float) beginStructure.decodeNullableSerializableElement(descriptor2, 6, FloatSerializer.INSTANCE, f7);
                        i7 |= 64;
                        arrayList9 = arrayList9;
                        num12 = num12;
                        jsonElement3 = jsonElement3;
                        num13 = num15;
                    case 7:
                        jsonElement3 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 7, JsonElementSerializer.INSTANCE, jsonElement3);
                        i7 |= 128;
                        arrayList9 = arrayList9;
                        num12 = num12;
                        arrayList11 = arrayList11;
                        num13 = num15;
                    case 8:
                        arrayList5 = arrayList9;
                        num7 = num12;
                        arrayList11 = (ArrayList) beginStructure.decodeNullableSerializableElement(descriptor2, 8, kSerializerArr[8], arrayList11);
                        i7 |= 256;
                        arrayList9 = arrayList5;
                        num12 = num7;
                        num13 = num15;
                    case 9:
                        num13 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 9, IntSerializer.INSTANCE, num15);
                        i7 |= 512;
                        arrayList9 = arrayList9;
                        num12 = num12;
                    case 10:
                        i7 |= 1024;
                        num12 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 10, IntSerializer.INSTANCE, num12);
                        arrayList9 = arrayList9;
                        num13 = num15;
                    case 11:
                        num5 = num12;
                        list7 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 11, RangeSerializer.GBBucketRangeListSerializer.INSTANCE, list7);
                        i7 |= 2048;
                        num13 = num15;
                        num12 = num5;
                    case 12:
                        num5 = num12;
                        arrayList9 = (ArrayList) beginStructure.decodeNullableSerializableElement(descriptor2, 12, kSerializerArr[12], arrayList9);
                        i7 |= 4096;
                        num13 = num15;
                        num12 = num5;
                    case 13:
                        num5 = num12;
                        arrayList10 = (ArrayList) beginStructure.decodeNullableSerializableElement(descriptor2, 13, kSerializerArr[13], arrayList10);
                        i7 |= 8192;
                        num13 = num15;
                        num12 = num5;
                    case 14:
                        num5 = num12;
                        str14 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 14, StringSerializer.INSTANCE, str14);
                        i7 |= 16384;
                        num13 = num15;
                        num12 = num5;
                    case 15:
                        num5 = num12;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, str17);
                        i6 = 32768;
                        i7 |= i6;
                        num13 = num15;
                        num12 = num5;
                    case 16:
                        num5 = num12;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 16, StringSerializer.INSTANCE, str13);
                        i6 = 65536;
                        i7 |= i6;
                        num13 = num15;
                        num12 = num5;
                    case 17:
                        num5 = num12;
                        str12 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 17, StringSerializer.INSTANCE, str12);
                        i6 = 131072;
                        i7 |= i6;
                        num13 = num15;
                        num12 = num5;
                    case 18:
                        num5 = num12;
                        bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 18, BooleanSerializer.INSTANCE, bool5);
                        i6 = 262144;
                        i7 |= i6;
                        num13 = num15;
                        num12 = num5;
                    case 19:
                        num5 = num12;
                        num11 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 19, IntSerializer.INSTANCE, num11);
                        i6 = 524288;
                        i7 |= i6;
                        num13 = num15;
                        num12 = num5;
                    case 20:
                        num5 = num12;
                        num14 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 20, IntSerializer.INSTANCE, num14);
                        i6 = 1048576;
                        i7 |= i6;
                        num13 = num15;
                        num12 = num5;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list8;
            jsonArray = jsonArray4;
            bool = bool5;
            str = str17;
            str2 = str12;
            str3 = str13;
            list2 = list7;
            num = num11;
            i5 = i7;
            arrayList = arrayList10;
            str4 = str14;
            num2 = num14;
            arrayList2 = arrayList9;
            num3 = num12;
            str5 = str16;
            list3 = list9;
            f5 = f7;
            jsonElement = jsonElement3;
            arrayList3 = arrayList11;
            str6 = str15;
            bool2 = bool6;
            num4 = num13;
        }
        beginStructure.endStructure(descriptor2);
        return new GBExperiment(i5, str6, list, jsonArray, str5, list3, bool2, f5, jsonElement, arrayList3, num4, num3, list2, arrayList2, arrayList, str4, str, str3, str2, bool, num, num2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, GBExperiment value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        GBExperiment.write$Self$GrowthBook_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
