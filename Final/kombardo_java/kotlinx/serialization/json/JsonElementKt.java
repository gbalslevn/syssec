package kotlinx.serialization.json;

import com.adjust.sdk.Constants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.InlineClassDescriptorKt;
import kotlinx.serialization.json.internal.JsonDecodingException;
import kotlinx.serialization.json.internal.StringJsonLexer;
import kotlinx.serialization.json.internal.StringOpsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000`\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0003\u0010\b\u001a\u001b\u0010\f\u001a\u00020\u000b*\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\r\"\u001a\u0010\u000f\u001a\u00020\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0015\u0010\u0015\u001a\u00020\u0002*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0019\u001a\u00020\u0016*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u0015\u0010\u001d\u001a\u00020\u001a*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0015\u0010!\u001a\u00020\u001e*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u0017\u0010$\u001a\u0004\u0018\u00010\u001e*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0015\u0010(\u001a\u00020%*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b&\u0010'\"\u0017\u0010+\u001a\u0004\u0018\u00010%*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b)\u0010*\"\u0015\u0010/\u001a\u00020,*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u0017\u00102\u001a\u0004\u0018\u00010,*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b0\u00101\"\u0015\u00106\u001a\u000203*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b4\u00105\"\u0017\u00109\u001a\u0004\u0018\u000103*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b7\u00108\"\u0017\u0010<\u001a\u0004\u0018\u00010\u0000*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b:\u0010;\"\u0017\u0010?\u001a\u0004\u0018\u00010\u0007*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006@"}, d2 = {BuildConfig.FLAVOR, "value", "Lkotlinx/serialization/json/JsonPrimitive;", "JsonPrimitive", "(Ljava/lang/Boolean;)Lkotlinx/serialization/json/JsonPrimitive;", BuildConfig.FLAVOR, "(Ljava/lang/Number;)Lkotlinx/serialization/json/JsonPrimitive;", BuildConfig.FLAVOR, "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonPrimitive;", "Lkotlinx/serialization/json/JsonElement;", "element", BuildConfig.FLAVOR, "error", "(Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;)Ljava/lang/Void;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "jsonUnquotedLiteralDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getJsonUnquotedLiteralDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getJsonPrimitive", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonPrimitive;", "jsonPrimitive", "Lkotlinx/serialization/json/JsonObject;", "getJsonObject", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonObject;", "jsonObject", "Lkotlinx/serialization/json/JsonArray;", "getJsonArray", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonArray;", "jsonArray", BuildConfig.FLAVOR, "getInt", "(Lkotlinx/serialization/json/JsonPrimitive;)I", "int", "getIntOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Integer;", "intOrNull", BuildConfig.FLAVOR, "getLong", "(Lkotlinx/serialization/json/JsonPrimitive;)J", Constants.LONG, "getLongOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Long;", "longOrNull", BuildConfig.FLAVOR, "getDouble", "(Lkotlinx/serialization/json/JsonPrimitive;)D", "double", "getDoubleOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Double;", "doubleOrNull", BuildConfig.FLAVOR, "getFloat", "(Lkotlinx/serialization/json/JsonPrimitive;)F", "float", "getFloatOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Float;", "floatOrNull", "getBooleanOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Boolean;", "booleanOrNull", "getContentOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/String;", "contentOrNull", "kotlinx-serialization-json"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class JsonElementKt {
    private static final SerialDescriptor jsonUnquotedLiteralDescriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("kotlinx.serialization.json.JsonUnquotedLiteral", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));

    public static final JsonPrimitive JsonPrimitive(Boolean bool) {
        if (bool == null) {
            return JsonNull.INSTANCE;
        }
        return new JsonLiteral(bool, false, null, 4, null);
    }

    private static final Void error(JsonElement jsonElement, String str) {
        throw new IllegalArgumentException("Element " + Reflection.getOrCreateKotlinClass(jsonElement.getClass()) + " is not a " + str);
    }

    public static final Boolean getBooleanOrNull(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        return StringOpsKt.toBooleanStrictOrNull(jsonPrimitive.getContent());
    }

    public static final String getContentOrNull(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        if (jsonPrimitive instanceof JsonNull) {
            return null;
        }
        return jsonPrimitive.getContent();
    }

    public static final double getDouble(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        return Double.parseDouble(jsonPrimitive.getContent());
    }

    public static final Double getDoubleOrNull(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        return StringsKt.toDoubleOrNull(jsonPrimitive.getContent());
    }

    public static final float getFloat(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        return Float.parseFloat(jsonPrimitive.getContent());
    }

    public static final Float getFloatOrNull(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        return StringsKt.toFloatOrNull(jsonPrimitive.getContent());
    }

    public static final int getInt(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        try {
            long consumeNumericLiteral = new StringJsonLexer(jsonPrimitive.getContent()).consumeNumericLiteral();
            if (-2147483648L <= consumeNumericLiteral && consumeNumericLiteral <= 2147483647L) {
                return (int) consumeNumericLiteral;
            }
            throw new NumberFormatException(jsonPrimitive.getContent() + " is not an Int");
        } catch (JsonDecodingException e5) {
            throw new NumberFormatException(e5.getMessage());
        }
    }

    public static final Integer getIntOrNull(JsonPrimitive jsonPrimitive) {
        Long l5;
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        try {
            l5 = Long.valueOf(new StringJsonLexer(jsonPrimitive.getContent()).consumeNumericLiteral());
        } catch (JsonDecodingException unused) {
            l5 = null;
        }
        if (l5 != null) {
            long longValue = l5.longValue();
            if (-2147483648L <= longValue && longValue <= 2147483647L) {
                return Integer.valueOf((int) longValue);
            }
        }
        return null;
    }

    public static final JsonArray getJsonArray(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        JsonArray jsonArray = jsonElement instanceof JsonArray ? (JsonArray) jsonElement : null;
        if (jsonArray != null) {
            return jsonArray;
        }
        error(jsonElement, "JsonArray");
        throw new KotlinNothingValueException();
    }

    public static final JsonObject getJsonObject(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        JsonObject jsonObject = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
        if (jsonObject != null) {
            return jsonObject;
        }
        error(jsonElement, "JsonObject");
        throw new KotlinNothingValueException();
    }

    public static final JsonPrimitive getJsonPrimitive(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        error(jsonElement, "JsonPrimitive");
        throw new KotlinNothingValueException();
    }

    public static final SerialDescriptor getJsonUnquotedLiteralDescriptor() {
        return jsonUnquotedLiteralDescriptor;
    }

    public static final long getLong(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        try {
            return new StringJsonLexer(jsonPrimitive.getContent()).consumeNumericLiteral();
        } catch (JsonDecodingException e5) {
            throw new NumberFormatException(e5.getMessage());
        }
    }

    public static final Long getLongOrNull(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        try {
            return Long.valueOf(new StringJsonLexer(jsonPrimitive.getContent()).consumeNumericLiteral());
        } catch (JsonDecodingException unused) {
            return null;
        }
    }

    public static final JsonPrimitive JsonPrimitive(Number number) {
        if (number == null) {
            return JsonNull.INSTANCE;
        }
        return new JsonLiteral(number, false, null, 4, null);
    }

    public static final JsonPrimitive JsonPrimitive(String str) {
        if (str == null) {
            return JsonNull.INSTANCE;
        }
        return new JsonLiteral(str, true, null, 4, null);
    }
}
