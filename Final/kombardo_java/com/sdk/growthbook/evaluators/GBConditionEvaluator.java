package com.sdk.growthbook.evaluators;

import com.sdk.growthbook.utils.GBUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\n\u0010\u000f\u001a\u00060\u0006j\u0002`\u00102\b\u0010\b\u001a\u0004\u0018\u00010\tJ\"\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tJ*\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tJ\"\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0015J\u0010\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0006¨\u0006\u001f"}, d2 = {"Lcom/sdk/growthbook/evaluators/GBConditionEvaluator;", BuildConfig.FLAVOR, "()V", "elemMatch", BuildConfig.FLAVOR, "attributeValue", "Lkotlinx/serialization/json/JsonElement;", "condition", "savedGroups", "Lkotlinx/serialization/json/JsonObject;", "evalAnd", "attributes", "conditionObjs", "Lkotlinx/serialization/json/JsonArray;", "evalCondition", "conditionObj", "Lcom/sdk/growthbook/utils/GBCondition;", "evalConditionValue", "conditionValue", "evalOperatorCondition", "operator", BuildConfig.FLAVOR, "evalOr", "getPath", "obj", "key", "getType", "Lcom/sdk/growthbook/evaluators/GBAttributeType;", "isIn", "actualValue", "isOperatorObject", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GBConditionEvaluator {
    private final boolean elemMatch(JsonElement attributeValue, JsonElement condition, JsonObject savedGroups) {
        if (!(attributeValue instanceof JsonArray)) {
            return false;
        }
        Iterator<JsonElement> it = ((JsonArray) attributeValue).iterator();
        while (it.hasNext()) {
            JsonElement next = it.next();
            if (isOperatorObject(condition)) {
                if (evalConditionValue(condition, next, savedGroups)) {
                    return true;
                }
            } else if (evalCondition(next, condition, savedGroups)) {
                return true;
            }
        }
        return false;
    }

    private final boolean evalAnd(JsonElement attributes, JsonArray conditionObjs, JsonObject savedGroups) {
        Iterator<JsonElement> it = conditionObjs.iterator();
        while (it.hasNext()) {
            if (!evalCondition(attributes, it.next(), savedGroups)) {
                return false;
            }
        }
        return true;
    }

    private final boolean evalOr(JsonElement attributes, JsonArray conditionObjs, JsonObject savedGroups) {
        if (conditionObjs.isEmpty()) {
            return true;
        }
        Iterator<JsonElement> it = conditionObjs.iterator();
        while (it.hasNext()) {
            if (evalCondition(attributes, it.next(), savedGroups)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean isIn(JsonElement actualValue, JsonArray conditionValue) {
        if (!(actualValue instanceof JsonArray)) {
            return conditionValue.contains((Object) actualValue);
        }
        if (((JsonArray) actualValue).size() == 0) {
            return false;
        }
        for (JsonElement jsonElement : (Iterable) actualValue) {
            if (getType(jsonElement) == GBAttributeType.GbString || getType(jsonElement) == GBAttributeType.GbBoolean || getType(jsonElement) == GBAttributeType.GbNumber) {
                if (conditionValue.contains((Object) jsonElement)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0039. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x001c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean evalCondition(JsonElement attributes, JsonElement conditionObj, JsonObject savedGroups) {
        JsonArray jsonArray;
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(conditionObj, "conditionObj");
        if (conditionObj instanceof JsonArray) {
            return false;
        }
        for (Map.Entry<String, JsonElement> entry : JsonElementKt.getJsonObject(conditionObj).entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            switch (key.hashCode()) {
                case 38151:
                    if (key.equals("$or")) {
                        Object obj = JsonElementKt.getJsonObject(conditionObj).get((Object) key);
                        jsonArray = obj instanceof JsonArray ? (JsonArray) obj : null;
                        if (jsonArray != null && !evalOr(attributes, jsonArray, savedGroups)) {
                            return false;
                        }
                    } else if (!evalConditionValue(value, getPath(attributes, key), savedGroups)) {
                        return false;
                    }
                    break;
                case 1169203:
                    if (key.equals("$and")) {
                        Object obj2 = JsonElementKt.getJsonObject(conditionObj).get((Object) key);
                        jsonArray = obj2 instanceof JsonArray ? (JsonArray) obj2 : null;
                        if (jsonArray != null && !evalAnd(attributes, jsonArray, savedGroups)) {
                            return false;
                        }
                    } else if (!evalConditionValue(value, getPath(attributes, key), savedGroups)) {
                    }
                    break;
                case 1181741:
                    if (key.equals("$nor")) {
                        Object obj3 = JsonElementKt.getJsonObject(conditionObj).get((Object) key);
                        jsonArray = obj3 instanceof JsonArray ? (JsonArray) obj3 : null;
                        if (jsonArray != null && evalOr(attributes, jsonArray, savedGroups)) {
                            return false;
                        }
                    } else if (!evalConditionValue(value, getPath(attributes, key), savedGroups)) {
                    }
                    break;
                case 1181743:
                    if (key.equals("$not")) {
                        JsonElement jsonElement = (JsonElement) JsonElementKt.getJsonObject(conditionObj).get((Object) key);
                        if (jsonElement != null && evalCondition(attributes, jsonElement, savedGroups)) {
                            return false;
                        }
                    } else if (!evalConditionValue(value, getPath(attributes, key), savedGroups)) {
                    }
                    break;
                default:
                    if (!evalConditionValue(value, getPath(attributes, key), savedGroups)) {
                    }
                    break;
            }
        }
        return true;
    }

    public final boolean evalConditionValue(JsonElement conditionValue, JsonElement attributeValue, JsonObject savedGroups) {
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(conditionValue, "conditionValue");
        boolean z5 = conditionValue instanceof JsonPrimitive;
        if (z5 && ((attributeValue instanceof JsonPrimitive) || attributeValue == null)) {
            return Intrinsics.areEqual(JsonElementKt.getContentOrNull(JsonElementKt.getJsonPrimitive(conditionValue)), (attributeValue == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(attributeValue)) == null) ? null : JsonElementKt.getContentOrNull(jsonPrimitive));
        }
        if (z5 && attributeValue == null) {
            return false;
        }
        if (conditionValue instanceof JsonArray) {
            if (!(attributeValue instanceof JsonArray) || ((JsonArray) conditionValue).size() != ((JsonArray) attributeValue).size()) {
                return false;
            }
            Json.Companion companion = Json.INSTANCE;
            JsonElement.Companion companion2 = JsonElement.INSTANCE;
            return Intrinsics.areEqual((List) companion.decodeFromJsonElement(BuiltinSerializersKt.ListSerializer(companion2.serializer()), conditionValue), (List) companion.decodeFromJsonElement(BuiltinSerializersKt.ListSerializer(companion2.serializer()), attributeValue));
        }
        if (!(conditionValue instanceof JsonObject)) {
            return true;
        }
        if (!isOperatorObject(conditionValue)) {
            if (attributeValue != null) {
                return Intrinsics.areEqual(conditionValue, attributeValue);
            }
            return false;
        }
        JsonObject jsonObject = (JsonObject) conditionValue;
        for (String str : jsonObject.keySet()) {
            Object obj = jsonObject.get((Object) str);
            Intrinsics.checkNotNull(obj);
            if (!evalOperatorCondition(str, attributeValue, (JsonElement) obj, savedGroups)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean evalOperatorCondition(String operator, JsonElement attributeValue, JsonElement conditionValue, JsonObject savedGroups) {
        Double doubleOrNull;
        JsonArray jsonArray;
        JsonElement jsonElement;
        JsonArray jsonArray2;
        JsonElement jsonElement2;
        Intrinsics.checkNotNullParameter(operator, "operator");
        Intrinsics.checkNotNullParameter(conditionValue, "conditionValue");
        if (Intrinsics.areEqual(operator, "$type")) {
            return Intrinsics.areEqual(getType(attributeValue).toString(), JsonElementKt.getJsonPrimitive(conditionValue).getContent());
        }
        if (Intrinsics.areEqual(operator, "$not")) {
            return !evalConditionValue(conditionValue, attributeValue, savedGroups);
        }
        if (Intrinsics.areEqual(operator, "$exists")) {
            String content = JsonElementKt.getJsonPrimitive(conditionValue).getContent();
            if (Intrinsics.areEqual(content, "false") && attributeValue == null) {
                return true;
            }
            if (Intrinsics.areEqual(content, "true") && attributeValue != null) {
                return true;
            }
        }
        if (!(conditionValue instanceof JsonArray)) {
            if (!(attributeValue instanceof JsonArray)) {
                if ((attributeValue == null ? true : attributeValue instanceof JsonPrimitive) && (conditionValue instanceof JsonPrimitive)) {
                    JsonPrimitive jsonPrimitive = (JsonPrimitive) conditionValue;
                    String content2 = jsonPrimitive.getContent();
                    JsonPrimitive jsonPrimitive2 = (JsonPrimitive) attributeValue;
                    String content3 = jsonPrimitive2 != null ? jsonPrimitive2.getContent() : null;
                    GBUtils.Companion companion = GBUtils.INSTANCE;
                    String paddedVersionString = companion.paddedVersionString(content2);
                    String paddedVersionString2 = companion.paddedVersionString(content3 == null ? "0" : content3);
                    switch (operator.hashCode()) {
                        case 37840:
                            if (operator.equals("$eq")) {
                                return Intrinsics.areEqual(content3, content2);
                            }
                            break;
                        case 37905:
                            if (operator.equals("$gt")) {
                                if ((jsonPrimitive2 != null ? JsonElementKt.getDoubleOrNull(jsonPrimitive2) : null) == null || JsonElementKt.getDoubleOrNull(jsonPrimitive) == null) {
                                    if (content3 == null) {
                                        if (0.0d > Double.parseDouble(content2)) {
                                            return true;
                                        }
                                    } else if (content3.compareTo(content2) > 0) {
                                        return true;
                                    }
                                    return false;
                                }
                                doubleOrNull = jsonPrimitive2 != null ? JsonElementKt.getDoubleOrNull(jsonPrimitive2) : null;
                                Intrinsics.checkNotNull(doubleOrNull);
                                double doubleValue = doubleOrNull.doubleValue();
                                Double doubleOrNull2 = JsonElementKt.getDoubleOrNull(jsonPrimitive);
                                Intrinsics.checkNotNull(doubleOrNull2);
                                return doubleValue > doubleOrNull2.doubleValue();
                            }
                            break;
                        case 38060:
                            if (operator.equals("$lt")) {
                                if ((jsonPrimitive2 != null ? JsonElementKt.getDoubleOrNull(jsonPrimitive2) : null) == null || JsonElementKt.getDoubleOrNull(jsonPrimitive) == null) {
                                    if (content3 == null) {
                                        if (0.0d < Double.parseDouble(content2)) {
                                            return true;
                                        }
                                    } else if (content3.compareTo(content2) < 0) {
                                        return true;
                                    }
                                    return false;
                                }
                                doubleOrNull = jsonPrimitive2 != null ? JsonElementKt.getDoubleOrNull(jsonPrimitive2) : null;
                                Intrinsics.checkNotNull(doubleOrNull);
                                double doubleValue2 = doubleOrNull.doubleValue();
                                Double doubleOrNull3 = JsonElementKt.getDoubleOrNull(jsonPrimitive);
                                Intrinsics.checkNotNull(doubleOrNull3);
                                return doubleValue2 < doubleOrNull3.doubleValue();
                            }
                            break;
                        case 38107:
                            if (operator.equals("$ne")) {
                                return !Intrinsics.areEqual(content3, content2);
                            }
                            break;
                        case 1175156:
                            if (operator.equals("$gte")) {
                                if ((jsonPrimitive2 != null ? JsonElementKt.getDoubleOrNull(jsonPrimitive2) : null) == null || JsonElementKt.getDoubleOrNull(jsonPrimitive) == null) {
                                    if (content3 == null) {
                                        if (0.0d >= Double.parseDouble(content2)) {
                                            return true;
                                        }
                                    } else if (content3.compareTo(content2) >= 0) {
                                        return true;
                                    }
                                    return false;
                                }
                                doubleOrNull = jsonPrimitive2 != null ? JsonElementKt.getDoubleOrNull(jsonPrimitive2) : null;
                                Intrinsics.checkNotNull(doubleOrNull);
                                double doubleValue3 = doubleOrNull.doubleValue();
                                Double doubleOrNull4 = JsonElementKt.getDoubleOrNull(jsonPrimitive);
                                Intrinsics.checkNotNull(doubleOrNull4);
                                return doubleValue3 >= doubleOrNull4.doubleValue();
                            }
                            break;
                        case 1179961:
                            if (operator.equals("$lte")) {
                                if ((jsonPrimitive2 != null ? JsonElementKt.getDoubleOrNull(jsonPrimitive2) : null) == null || JsonElementKt.getDoubleOrNull(jsonPrimitive) == null) {
                                    if (content3 == null) {
                                        if (0.0d <= Double.parseDouble(content2)) {
                                            return true;
                                        }
                                    } else if (content3.compareTo(content2) <= 0) {
                                        return true;
                                    }
                                    return false;
                                }
                                doubleOrNull = jsonPrimitive2 != null ? JsonElementKt.getDoubleOrNull(jsonPrimitive2) : null;
                                Intrinsics.checkNotNull(doubleOrNull);
                                double doubleValue4 = doubleOrNull.doubleValue();
                                Double doubleOrNull5 = JsonElementKt.getDoubleOrNull(jsonPrimitive);
                                Intrinsics.checkNotNull(doubleOrNull5);
                                return doubleValue4 <= doubleOrNull5.doubleValue();
                            }
                            break;
                        case 1189118:
                            if (operator.equals("$veq")) {
                                return Intrinsics.areEqual(paddedVersionString2, paddedVersionString);
                            }
                            break;
                        case 1189183:
                            return operator.equals("$vgt") && paddedVersionString2.compareTo(paddedVersionString) > 0;
                        case 1189338:
                            return operator.equals("$vlt") && paddedVersionString2.compareTo(paddedVersionString) < 0;
                        case 1189385:
                            if (operator.equals("$vne")) {
                                return !Intrinsics.areEqual(paddedVersionString2, paddedVersionString);
                            }
                            break;
                        case 36864774:
                            return operator.equals("$vgte") && paddedVersionString2.compareTo(paddedVersionString) >= 0;
                        case 36869579:
                            return operator.equals("$vlte") && paddedVersionString2.compareTo(paddedVersionString) <= 0;
                        case 233551798:
                            if (operator.equals("$inGroup") && attributeValue != null) {
                                if (savedGroups == null || (jsonElement = (JsonElement) savedGroups.get((Object) jsonPrimitive.getContent())) == null || (jsonArray = JsonElementKt.getJsonArray(jsonElement)) == null) {
                                    jsonArray = new JsonArray(CollectionsKt.emptyList());
                                }
                                return isIn(attributeValue, jsonArray);
                            }
                            break;
                        case 417740075:
                            if (operator.equals("$notInGroup") && attributeValue != null) {
                                if (savedGroups == null || (jsonElement2 = (JsonElement) savedGroups.get((Object) jsonPrimitive.getContent())) == null || (jsonArray2 = JsonElementKt.getJsonArray(jsonElement2)) == null) {
                                    jsonArray2 = new JsonArray(CollectionsKt.emptyList());
                                }
                                return !isIn(attributeValue, jsonArray2);
                            }
                            break;
                        case 1139041955:
                            if (operator.equals("$regex")) {
                                try {
                                    Regex regex = new Regex(content2);
                                    if (content3 == null) {
                                        content3 = "0";
                                    }
                                    return regex.containsMatchIn(content3);
                                } catch (Throwable unused) {
                                    return false;
                                }
                            }
                            break;
                    }
                }
            } else {
                if (Intrinsics.areEqual(operator, "$elemMatch")) {
                    return elemMatch(attributeValue, conditionValue, savedGroups);
                }
                if (Intrinsics.areEqual(operator, "$size")) {
                    return evalConditionValue(conditionValue, JsonElementKt.JsonPrimitive(Integer.valueOf(((JsonArray) attributeValue).size())), savedGroups);
                }
            }
        } else {
            int hashCode = operator.hashCode();
            if (hashCode != 37961) {
                if (hashCode == 1169149) {
                    if (!operator.equals("$all") || !(attributeValue instanceof JsonArray)) {
                        return false;
                    }
                    Iterator<JsonElement> it = ((JsonArray) conditionValue).iterator();
                    while (it.hasNext()) {
                        JsonElement next = it.next();
                        Iterator<JsonElement> it2 = ((JsonArray) attributeValue).iterator();
                        boolean z5 = false;
                        while (it2.hasNext()) {
                            if (evalConditionValue(next, it2.next(), savedGroups)) {
                                z5 = true;
                            }
                        }
                        if (!z5) {
                            return false;
                        }
                    }
                    return true;
                }
                if (hashCode == 1181551 && operator.equals("$nin")) {
                    if (attributeValue instanceof JsonArray) {
                        if (!isIn(attributeValue, (JsonArray) conditionValue)) {
                            return true;
                        }
                    } else if (!CollectionsKt.contains((Iterable) conditionValue, attributeValue)) {
                        return true;
                    }
                    return false;
                }
            } else if (operator.equals("$in")) {
                return attributeValue instanceof JsonArray ? isIn(attributeValue, (JsonArray) conditionValue) : CollectionsKt.contains((Iterable) conditionValue, attributeValue);
            }
        }
        return false;
    }

    public final JsonElement getPath(JsonElement obj, String key) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(key, "key");
        if (StringsKt.contains$default((CharSequence) key, (CharSequence) ".", false, 2, (Object) null)) {
            List split$default = StringsKt.split$default((CharSequence) key, new String[]{"."}, false, 0, 6, (Object) null);
            Intrinsics.checkNotNull(split$default, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
            arrayList = (ArrayList) split$default;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(key);
            arrayList = arrayList2;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (obj == null || (obj instanceof JsonArray) || !(obj instanceof JsonObject)) {
                return null;
            }
            obj = (JsonElement) ((JsonObject) obj).get((Object) str);
        }
        return obj;
    }

    public final GBAttributeType getType(JsonElement obj) {
        if (Intrinsics.areEqual(obj, JsonNull.INSTANCE)) {
            return GBAttributeType.GbNull;
        }
        if (!(obj instanceof JsonPrimitive)) {
            return obj instanceof JsonArray ? GBAttributeType.GbArray : obj instanceof JsonObject ? GBAttributeType.GbObject : GBAttributeType.GbUnknown;
        }
        JsonPrimitive jsonPrimitive = JsonElementKt.getJsonPrimitive(obj);
        return jsonPrimitive.getIsString() ? GBAttributeType.GbString : (Intrinsics.areEqual(jsonPrimitive.getContent(), "true") || Intrinsics.areEqual(jsonPrimitive.getContent(), "false")) ? GBAttributeType.GbBoolean : GBAttributeType.GbNumber;
    }

    public final boolean isOperatorObject(JsonElement obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (!(obj instanceof JsonObject)) {
            return false;
        }
        JsonObject jsonObject = (JsonObject) obj;
        if (jsonObject.keySet().isEmpty()) {
            return false;
        }
        Iterator<String> it = jsonObject.keySet().iterator();
        while (it.hasNext()) {
            if (!StringsKt.startsWith$default(it.next(), "$", false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }
}
