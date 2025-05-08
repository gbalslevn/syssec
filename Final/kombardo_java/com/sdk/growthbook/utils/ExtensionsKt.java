package com.sdk.growthbook.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004*\u00020\u0005H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\bH\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\tH\u0000\u001a\u0010\u0010\n\u001a\u0006\u0012\u0002\b\u00030\b*\u00020\u000bH\u0000¨\u0006\f"}, d2 = {"toHashMap", "Ljava/util/HashMap;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "Lkotlinx/serialization/json/JsonObject;", "toJsonElement", "Lkotlinx/serialization/json/JsonElement;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "toList", "Lkotlinx/serialization/json/JsonArray;", "GrowthBook_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExtensionsKt {
    public static final HashMap<String, Object> toHashMap(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        HashMap<String, Object> hashMap = new HashMap<>();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            if (value instanceof JsonObject) {
                hashMap.put(key, toHashMap((JsonObject) value));
            } else if (value instanceof JsonArray) {
                hashMap.put(key, toList((JsonArray) value));
            } else {
                hashMap.put(key, JsonElementKt.getJsonPrimitive(value).getContent());
            }
        }
        return hashMap;
    }

    public static final JsonElement toJsonElement(List<?> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj != null) {
                if (obj instanceof Map) {
                    arrayList.add(toJsonElement((Map<?, ?>) obj));
                } else if (obj instanceof List) {
                    arrayList.add(toJsonElement((List<?>) obj));
                } else if (obj instanceof Boolean) {
                    arrayList.add(JsonElementKt.JsonPrimitive((Boolean) obj));
                } else if (obj instanceof Number) {
                    arrayList.add(JsonElementKt.JsonPrimitive((Number) obj));
                } else {
                    arrayList.add(JsonElementKt.JsonPrimitive(obj.toString()));
                }
            }
        }
        return new JsonArray(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final List<?> toList(JsonArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "<this>");
        ArrayList arrayList = new ArrayList();
        for (JsonElement jsonElement : jsonArray) {
            if (jsonElement instanceof JsonObject) {
                arrayList.add(toHashMap((JsonObject) jsonElement));
            } else if (jsonElement instanceof List) {
                arrayList.add(CollectionsKt.toList((Iterable) jsonElement));
            } else {
                arrayList.add(JsonElementKt.getJsonPrimitive(jsonElement).getContent());
            }
        }
        return arrayList;
    }

    public static final JsonElement toJsonElement(Map<?, ?> map) {
        Object value;
        JsonElement JsonPrimitive;
        Intrinsics.checkNotNullParameter(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            String str = key instanceof String ? (String) key : null;
            if (str != null && (value = entry.getValue()) != null) {
                if (value instanceof Map) {
                    JsonPrimitive = toJsonElement((Map<?, ?>) value);
                } else if (value instanceof List) {
                    JsonPrimitive = toJsonElement((List<?>) value);
                } else if (value instanceof Boolean) {
                    JsonPrimitive = JsonElementKt.JsonPrimitive((Boolean) value);
                } else {
                    JsonPrimitive = value instanceof Number ? JsonElementKt.JsonPrimitive((Number) value) : JsonElementKt.JsonPrimitive(value.toString());
                }
                linkedHashMap.put(str, JsonPrimitive);
            }
        }
        return new JsonObject(linkedHashMap);
    }
}
