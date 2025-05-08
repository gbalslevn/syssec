package com.sdk.growthbook.network;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0000¨\u0006\u0004"}, d2 = {"toJsonElement", "Lkotlinx/serialization/json/JsonElement;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "NetworkDispatcherOkHttp_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GBNetworkDispatcherOkHttpKt {
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
}
