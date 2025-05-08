package kotlinx.serialization.json.internal;

import com.adjust.sdk.Constants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.NamedValueDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0011\u001a\u00020\u0010*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J#\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020$2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\tH\u0004¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\tH$¢\u0006\u0004\b-\u0010.J\u001f\u00101\u001a\u0002002\u0006\u0010*\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u001fH\u0014¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020'2\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u0002052\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u0002082\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u0002002\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020=2\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020@2\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020C2\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020F2\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\bI\u0010JJ\u001f\u0010M\u001a\u00020L2\u0006\u0010*\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u001fH\u0014¢\u0006\u0004\bM\u0010NJ\u0017\u0010O\u001a\u00020L2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\bO\u0010PR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010Q\u001a\u0004\bR\u0010SR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010T\u001a\u0004\bU\u0010\u0014R\u0014\u0010W\u001a\u00020V8\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010\\\u001a\u00020Y8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[\u0082\u0001\u0003]^_¨\u0006`"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/JsonElement;", "value", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;)V", BuildConfig.FLAVOR, "primitive", BuildConfig.FLAVOR, "unparsedPrimitive", "(Ljava/lang/String;)Ljava/lang/Void;", "Lkotlinx/serialization/json/JsonPrimitive;", "type", "Lkotlinx/serialization/json/JsonLiteral;", "asLiteral", "(Lkotlinx/serialization/json/JsonPrimitive;Ljava/lang/String;)Lkotlinx/serialization/json/JsonLiteral;", "currentObject", "()Lkotlinx/serialization/json/JsonElement;", "decodeJsonElement", "T", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "parentName", "childName", "composeName", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/encoding/CompositeDecoder;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;", BuildConfig.FLAVOR, "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", BuildConfig.FLAVOR, "decodeNotNullMark", "()Z", "tag", "getPrimitiveValue", "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonPrimitive;", "currentElement", "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonElement;", "enumDescriptor", BuildConfig.FLAVOR, "decodeTaggedEnum", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeTaggedBoolean", "(Ljava/lang/String;)Z", BuildConfig.FLAVOR, "decodeTaggedByte", "(Ljava/lang/String;)B", BuildConfig.FLAVOR, "decodeTaggedShort", "(Ljava/lang/String;)S", "decodeTaggedInt", "(Ljava/lang/String;)I", BuildConfig.FLAVOR, "decodeTaggedLong", "(Ljava/lang/String;)J", BuildConfig.FLAVOR, "decodeTaggedFloat", "(Ljava/lang/String;)F", BuildConfig.FLAVOR, "decodeTaggedDouble", "(Ljava/lang/String;)D", BuildConfig.FLAVOR, "decodeTaggedChar", "(Ljava/lang/String;)C", "decodeTaggedString", "(Ljava/lang/String;)Ljava/lang/String;", "inlineDescriptor", "Lkotlinx/serialization/encoding/Decoder;", "decodeTaggedInline", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "decodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/json/JsonElement;", "getValue", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "Lkotlinx/serialization/json/internal/JsonPrimitiveDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeListDecoder;", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AbstractJsonTreeDecoder extends NamedValueDecoder implements JsonDecoder {
    protected final JsonConfiguration configuration;
    private final Json json;
    private final JsonElement value;

    public /* synthetic */ AbstractJsonTreeDecoder(Json json, JsonElement jsonElement, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonElement);
    }

    private final JsonLiteral asLiteral(JsonPrimitive jsonPrimitive, String str) {
        JsonLiteral jsonLiteral = jsonPrimitive instanceof JsonLiteral ? (JsonLiteral) jsonPrimitive : null;
        if (jsonLiteral != null) {
            return jsonLiteral;
        }
        throw JsonExceptionsKt.JsonDecodingException(-1, "Unexpected 'null' literal when non-nullable " + str + " was expected");
    }

    private final Void unparsedPrimitive(String primitive) {
        throw JsonExceptionsKt.JsonDecodingException(-1, "Failed to parse literal as '" + primitive + "' value", currentObject().toString());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        JsonElement currentObject = currentObject();
        SerialKind kind = descriptor.getKind();
        if (Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE) ? true : kind instanceof PolymorphicKind) {
            Json json = getJson();
            if (currentObject instanceof JsonArray) {
                return new JsonTreeListDecoder(json, (JsonArray) currentObject);
            }
            throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonArray.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
        }
        if (!Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE)) {
            Json json2 = getJson();
            if (currentObject instanceof JsonObject) {
                return new JsonTreeDecoder(json2, (JsonObject) currentObject, null, null, 12, null);
            }
            throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
        }
        Json json3 = getJson();
        SerialDescriptor carrierDescriptor = WriteModeKt.carrierDescriptor(descriptor.getElementDescriptor(0), json3.getSerializersModule());
        SerialKind kind2 = carrierDescriptor.getKind();
        if ((kind2 instanceof PrimitiveKind) || Intrinsics.areEqual(kind2, SerialKind.ENUM.INSTANCE)) {
            Json json4 = getJson();
            if (currentObject instanceof JsonObject) {
                return new JsonTreeMapDecoder(json4, (JsonObject) currentObject);
            }
            throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
        }
        if (!json3.getConfiguration().getAllowStructuredMapKeys()) {
            throw JsonExceptionsKt.InvalidKeyKindException(carrierDescriptor);
        }
        Json json5 = getJson();
        if (currentObject instanceof JsonArray) {
            return new JsonTreeListDecoder(json5, (JsonArray) currentObject);
        }
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonArray.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
    }

    @Override // kotlinx.serialization.internal.NamedValueDecoder
    protected String composeName(String parentName, String childName) {
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(childName, "childName");
        return childName;
    }

    protected abstract JsonElement currentElement(String tag);

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonElement currentObject() {
        JsonElement currentElement;
        String currentTagOrNull = getCurrentTagOrNull();
        return (currentTagOrNull == null || (currentElement = currentElement(currentTagOrNull)) == null) ? getValue() : currentElement;
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return getCurrentTagOrNull() != null ? super.decodeInline(descriptor) : new JsonPrimitiveDecoder(getJson(), getValue()).decodeInline(descriptor);
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public JsonElement decodeJsonElement() {
        return currentObject();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return !(currentObject() instanceof JsonNull);
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) PolymorphicKt.decodeSerializableValuePolymorphic(this, deserializer);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public Json getJson() {
        return this.json;
    }

    protected final JsonPrimitive getPrimitiveValue(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement currentElement = currentElement(tag);
        JsonPrimitive jsonPrimitive = currentElement instanceof JsonPrimitive ? (JsonPrimitive) currentElement : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected JsonPrimitive at " + tag + ", found " + currentElement, currentObject().toString());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule getSerializersModule() {
        return getJson().getSerializersModule();
    }

    public abstract JsonElement getValue();

    private AbstractJsonTreeDecoder(Json json, JsonElement jsonElement) {
        this.json = json;
        this.value = jsonElement;
        this.configuration = getJson().getConfiguration();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public boolean decodeTaggedBoolean(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            Boolean booleanOrNull = JsonElementKt.getBooleanOrNull(getPrimitiveValue(tag));
            if (booleanOrNull != null) {
                return booleanOrNull.booleanValue();
            }
            unparsedPrimitive("boolean");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("boolean");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public byte decodeTaggedByte(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            int i5 = JsonElementKt.getInt(getPrimitiveValue(tag));
            Byte valueOf = (-128 > i5 || i5 > 127) ? null : Byte.valueOf((byte) i5);
            if (valueOf != null) {
                return valueOf.byteValue();
            }
            unparsedPrimitive("byte");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("byte");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public char decodeTaggedChar(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            return StringsKt.single(getPrimitiveValue(tag).getContent());
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("char");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public double decodeTaggedDouble(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            double d5 = JsonElementKt.getDouble(getPrimitiveValue(tag));
            if (getJson().getConfiguration().getAllowSpecialFloatingPointValues() || !(Double.isInfinite(d5) || Double.isNaN(d5))) {
                return d5;
            }
            throw JsonExceptionsKt.InvalidFloatingPointDecoded(Double.valueOf(d5), tag, currentObject().toString());
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("double");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public int decodeTaggedEnum(String tag, SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return JsonNamesMapKt.getJsonNameIndexOrThrow$default(enumDescriptor, getJson(), getPrimitiveValue(tag).getContent(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public float decodeTaggedFloat(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            float f5 = JsonElementKt.getFloat(getPrimitiveValue(tag));
            if (getJson().getConfiguration().getAllowSpecialFloatingPointValues() || !(Float.isInfinite(f5) || Float.isNaN(f5))) {
                return f5;
            }
            throw JsonExceptionsKt.InvalidFloatingPointDecoded(Float.valueOf(f5), tag, currentObject().toString());
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("float");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public Decoder decodeTaggedInline(String tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        return StreamingJsonEncoderKt.isUnsignedNumber(inlineDescriptor) ? new JsonDecoderForUnsignedTypes(new StringJsonLexer(getPrimitiveValue(tag).getContent()), getJson()) : super.decodeTaggedInline((AbstractJsonTreeDecoder) tag, inlineDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public int decodeTaggedInt(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            return JsonElementKt.getInt(getPrimitiveValue(tag));
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("int");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public long decodeTaggedLong(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            return JsonElementKt.getLong(getPrimitiveValue(tag));
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(Constants.LONG);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public short decodeTaggedShort(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            int i5 = JsonElementKt.getInt(getPrimitiveValue(tag));
            Short valueOf = (-32768 > i5 || i5 > 32767) ? null : Short.valueOf((short) i5);
            if (valueOf != null) {
                return valueOf.shortValue();
            }
            unparsedPrimitive("short");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive("short");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public String decodeTaggedString(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive primitiveValue = getPrimitiveValue(tag);
        if (!getJson().getConfiguration().getIsLenient() && !asLiteral(primitiveValue, "string").getIsString()) {
            throw JsonExceptionsKt.JsonDecodingException(-1, "String literal for key '" + tag + "' should be quoted.\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON.", currentObject().toString());
        }
        if (!(primitiveValue instanceof JsonNull)) {
            return primitiveValue.getContent();
        }
        throw JsonExceptionsKt.JsonDecodingException(-1, "Unexpected 'null' value instead of string literal", currentObject().toString());
    }
}
