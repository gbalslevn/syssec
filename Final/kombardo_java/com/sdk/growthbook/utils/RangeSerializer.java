package com.sdk.growthbook.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/sdk/growthbook/utils/RangeSerializer;", BuildConfig.FLAVOR, "()V", "GBBucketRangeListSerializer", "GBBucketRangeSerializer", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RangeSerializer {
    public static final RangeSerializer INSTANCE = new RangeSerializer();

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0006J&\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J.\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/sdk/growthbook/utils/RangeSerializer$GBBucketRangeListSerializer;", "Lkotlinx/serialization/KSerializer;", BuildConfig.FLAVOR, "Lkotlin/Pair;", BuildConfig.FLAVOR, "Lcom/sdk/growthbook/utils/GBBucketRange;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class GBBucketRangeListSerializer implements KSerializer<List<? extends Pair<? extends Float, ? extends Float>>> {
        public static final GBBucketRangeListSerializer INSTANCE = new GBBucketRangeListSerializer();
        private static final SerialDescriptor descriptor;

        static {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            descriptor = BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.PairSerializer(BuiltinSerializersKt.serializer(floatCompanionObject), BuiltinSerializersKt.serializer(floatCompanionObject))).getDescriptor();
        }

        private GBBucketRangeListSerializer() {
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public List<Pair<Float, Float>> deserialize(Decoder decoder) {
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            JsonArray jsonArray = (JsonArray) decoder.decodeSerializableValue(JsonArray.INSTANCE.serializer());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
            for (JsonElement jsonElement : jsonArray) {
                Float floatOrNull = JsonElementKt.getFloatOrNull(JsonElementKt.getJsonPrimitive(JsonElementKt.getJsonArray(jsonElement).get(0)));
                Float floatOrNull2 = JsonElementKt.getFloatOrNull(JsonElementKt.getJsonPrimitive(JsonElementKt.getJsonArray(jsonElement).get(1)));
                if (floatOrNull != null && floatOrNull2 != null) {
                    arrayList.add(TuplesKt.to(floatOrNull, floatOrNull2));
                } else {
                    throw new IllegalArgumentException("Invalid range format");
                }
            }
            return arrayList;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder, List<Pair<Float, Float>> value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            List<Pair<Float, Float>> list = value;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                arrayList.add(new JsonArray(CollectionsKt.listOf((Object[]) new JsonPrimitive[]{JsonElementKt.JsonPrimitive((Number) pair.getFirst()), JsonElementKt.JsonPrimitive((Number) pair.getSecond())})));
            }
            encoder.encodeSerializableValue(JsonArray.INSTANCE.serializer(), new JsonArray(arrayList));
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00040\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J \u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/sdk/growthbook/utils/RangeSerializer$GBBucketRangeSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/Pair;", BuildConfig.FLAVOR, "Lcom/sdk/growthbook/utils/GBBucketRange;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class GBBucketRangeSerializer implements KSerializer<Pair<? extends Float, ? extends Float>> {
        public static final GBBucketRangeSerializer INSTANCE = new GBBucketRangeSerializer();
        private static final SerialDescriptor descriptor;

        static {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            descriptor = BuiltinSerializersKt.PairSerializer(BuiltinSerializersKt.serializer(floatCompanionObject), BuiltinSerializersKt.serializer(floatCompanionObject)).getDescriptor();
        }

        private GBBucketRangeSerializer() {
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public Pair<Float, Float> deserialize(Decoder decoder) {
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            JsonArray jsonArray = (JsonArray) decoder.decodeSerializableValue(JsonArray.INSTANCE.serializer());
            Float floatOrNull = JsonElementKt.getFloatOrNull(JsonElementKt.getJsonPrimitive(jsonArray.get(0)));
            Float floatOrNull2 = JsonElementKt.getFloatOrNull(JsonElementKt.getJsonPrimitive(jsonArray.get(1)));
            if (floatOrNull != null && floatOrNull2 != null) {
                return TuplesKt.to(floatOrNull, floatOrNull2);
            }
            throw new IllegalArgumentException("Invalid range format");
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder, Pair<Float, Float> value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            encoder.encodeSerializableValue(JsonArray.INSTANCE.serializer(), new JsonArray(CollectionsKt.listOf((Object[]) new JsonPrimitive[]{JsonElementKt.JsonPrimitive(value.getFirst()), JsonElementKt.JsonPrimitive(value.getSecond())})));
        }
    }

    private RangeSerializer() {
    }
}
