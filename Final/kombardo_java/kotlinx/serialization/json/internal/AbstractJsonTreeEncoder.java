package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.NamedValueEncoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.internal.PolymorphicKt;
import kotlinx.serialization.modules.SerializersModule;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0002\r\u0012\b3\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0006H&¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0006H&¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010(J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0016H\u0014¢\u0006\u0004\b-\u0010.J\u001f\u00100\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020/H\u0014¢\u0006\u0004\b0\u00101J\u001f\u00103\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u000202H\u0014¢\u0006\u0004\b3\u00104J\u001f\u00106\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u000205H\u0014¢\u0006\u0004\b6\u00107J\u001f\u00109\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u000208H\u0014¢\u0006\u0004\b9\u0010:J+\u0010>\u001a\u00020\u0007\"\u0004\b\u0000\u0010;2\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000<2\u0006\u0010,\u001a\u00028\u0000H\u0016¢\u0006\u0004\b>\u0010?J\u001f\u0010A\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020@H\u0014¢\u0006\u0004\bA\u0010BJ\u001f\u0010C\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u001aH\u0014¢\u0006\u0004\bC\u0010DJ\u001f\u0010F\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020EH\u0014¢\u0006\u0004\bF\u0010GJ\u001f\u0010H\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bH\u0014¢\u0006\u0004\bH\u0010IJ'\u0010L\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u00102\u0006\u0010K\u001a\u00020\u0016H\u0014¢\u0006\u0004\bL\u0010MJ\u001f\u0010O\u001a\u00020N2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001a\u00020N2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\bQ\u0010RJ\u0017\u0010T\u001a\u00020S2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\bT\u0010UJ\u0017\u0010V\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0010H\u0014¢\u0006\u0004\bV\u0010WR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010X\u001a\u0004\bY\u0010ZR&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\b\u0010[\u001a\u0004\b\\\u0010]R\u0014\u0010_\u001a\u00020^8\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010a\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0011\u0010f\u001a\u00020c8F¢\u0006\u0006\u001a\u0004\bd\u0010e\u0082\u0001\u0003ghi¨\u0006j"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder;", "Lkotlinx/serialization/internal/NamedValueEncoder;", "Lkotlinx/serialization/json/JsonEncoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonElement;", BuildConfig.FLAVOR, "nodeConsumer", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "tag", "kotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1", "inlineUnsignedNumberEncoder", "(Ljava/lang/String;)Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "inlineDescriptor", "kotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1", "inlineUnquotedLiteralEncoder", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1;", "descriptor", BuildConfig.FLAVOR, "index", "elementName", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", BuildConfig.FLAVOR, "shouldEncodeElementDefault", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "parentName", "childName", "composeName", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "key", "element", "putElement", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;)V", "getCurrent", "()Lkotlinx/serialization/json/JsonElement;", "encodeNotNullMark", "()V", "encodeNull", "encodeTaggedNull", "(Ljava/lang/String;)V", "value", "encodeTaggedInt", "(Ljava/lang/String;I)V", BuildConfig.FLAVOR, "encodeTaggedByte", "(Ljava/lang/String;B)V", BuildConfig.FLAVOR, "encodeTaggedShort", "(Ljava/lang/String;S)V", BuildConfig.FLAVOR, "encodeTaggedLong", "(Ljava/lang/String;J)V", BuildConfig.FLAVOR, "encodeTaggedFloat", "(Ljava/lang/String;F)V", "T", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "encodeSerializableValue", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", BuildConfig.FLAVOR, "encodeTaggedDouble", "(Ljava/lang/String;D)V", "encodeTaggedBoolean", "(Ljava/lang/String;Z)V", BuildConfig.FLAVOR, "encodeTaggedChar", "(Ljava/lang/String;C)V", "encodeTaggedString", "(Ljava/lang/String;Ljava/lang/String;)V", "enumDescriptor", "ordinal", "encodeTaggedEnum", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "Lkotlinx/serialization/encoding/Encoder;", "encodeTaggedInline", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "encodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;", "endEncode", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "Lkotlin/jvm/functions/Function1;", "getNodeConsumer", "()Lkotlin/jvm/functions/Function1;", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "polymorphicDiscriminator", "Ljava/lang/String;", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "Lkotlinx/serialization/json/internal/JsonPrimitiveEncoder;", "Lkotlinx/serialization/json/internal/JsonTreeEncoder;", "Lkotlinx/serialization/json/internal/JsonTreeListEncoder;", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AbstractJsonTreeEncoder extends NamedValueEncoder implements JsonEncoder {
    protected final JsonConfiguration configuration;
    private final Json json;
    private final Function1<JsonElement, Unit> nodeConsumer;
    private String polymorphicDiscriminator;

    public /* synthetic */ AbstractJsonTreeEncoder(Json json, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, function1);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1] */
    private final AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1 inlineUnquotedLiteralEncoder(final String tag, final SerialDescriptor inlineDescriptor) {
        return new AbstractEncoder() { // from class: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1
            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void encodeString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                AbstractJsonTreeEncoder.this.putElement(tag, new JsonLiteral(value, false, inlineDescriptor));
            }

            @Override // kotlinx.serialization.encoding.Encoder
            public SerializersModule getSerializersModule() {
                return AbstractJsonTreeEncoder.this.getJson().getSerializersModule();
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1] */
    private final AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1 inlineUnsignedNumberEncoder(final String tag) {
        return new AbstractEncoder() { // from class: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1
            private final SerializersModule serializersModule;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.serializersModule = AbstractJsonTreeEncoder.this.getJson().getSerializersModule();
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void encodeByte(byte value) {
                putUnquotedString(UByte.m3580toStringimpl(UByte.m3577constructorimpl(value)));
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void encodeInt(int value) {
                putUnquotedString(Integer.toUnsignedString(UInt.m3599constructorimpl(value)));
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void encodeLong(long value) {
                putUnquotedString(Long.toUnsignedString(ULong.m3622constructorimpl(value)));
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void encodeShort(short value) {
                putUnquotedString(UShort.m3649toStringimpl(UShort.m3646constructorimpl(value)));
            }

            @Override // kotlinx.serialization.encoding.Encoder
            public SerializersModule getSerializersModule() {
                return this.serializersModule;
            }

            public final void putUnquotedString(String s5) {
                Intrinsics.checkNotNullParameter(s5, "s");
                AbstractJsonTreeEncoder.this.putElement(tag, new JsonLiteral(s5, false, null, 4, null));
            }
        };
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        AbstractJsonTreeEncoder jsonTreeEncoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Function1<JsonElement, Unit> function1 = getCurrentTagOrNull() == null ? this.nodeConsumer : new Function1<JsonElement, Unit>() { // from class: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$beginStructure$consumer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonElement jsonElement) {
                invoke2(jsonElement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonElement node) {
                String currentTag;
                Intrinsics.checkNotNullParameter(node, "node");
                AbstractJsonTreeEncoder abstractJsonTreeEncoder = AbstractJsonTreeEncoder.this;
                currentTag = abstractJsonTreeEncoder.getCurrentTag();
                abstractJsonTreeEncoder.putElement(currentTag, node);
            }
        };
        SerialKind kind = descriptor.getKind();
        if (Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE) ? true : kind instanceof PolymorphicKind) {
            jsonTreeEncoder = new JsonTreeListEncoder(this.json, function1);
        } else if (Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE)) {
            Json json = this.json;
            SerialDescriptor carrierDescriptor = WriteModeKt.carrierDescriptor(descriptor.getElementDescriptor(0), json.getSerializersModule());
            SerialKind kind2 = carrierDescriptor.getKind();
            if ((kind2 instanceof PrimitiveKind) || Intrinsics.areEqual(kind2, SerialKind.ENUM.INSTANCE)) {
                jsonTreeEncoder = new JsonTreeMapEncoder(this.json, function1);
            } else {
                if (!json.getConfiguration().getAllowStructuredMapKeys()) {
                    throw JsonExceptionsKt.InvalidKeyKindException(carrierDescriptor);
                }
                jsonTreeEncoder = new JsonTreeListEncoder(this.json, function1);
            }
        } else {
            jsonTreeEncoder = new JsonTreeEncoder(this.json, function1);
        }
        String str = this.polymorphicDiscriminator;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            jsonTreeEncoder.putElement(str, JsonElementKt.JsonPrimitive(descriptor.getSerialName()));
            this.polymorphicDiscriminator = null;
        }
        return jsonTreeEncoder;
    }

    @Override // kotlinx.serialization.internal.NamedValueEncoder
    protected String composeName(String parentName, String childName) {
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(childName, "childName");
        return childName;
    }

    @Override // kotlinx.serialization.internal.NamedValueEncoder
    protected String elementName(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return JsonNamesMapKt.getJsonElementName(descriptor, this.json, index);
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return getCurrentTagOrNull() != null ? super.encodeInline(descriptor) : new JsonPrimitiveEncoder(this.json, this.nodeConsumer).encodeInline(descriptor);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeNotNullMark() {
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        String currentTagOrNull = getCurrentTagOrNull();
        if (currentTagOrNull == null) {
            this.nodeConsumer.invoke(JsonNull.INSTANCE);
        } else {
            encodeTaggedNull(currentTagOrNull);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        if (getJson().getConfiguration().getClassDiscriminatorMode() != kotlinx.serialization.json.ClassDiscriminatorMode.NONE) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0087, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1, kotlinx.serialization.descriptors.StructureKind.OBJECT.INSTANCE) == false) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializer, T value) {
        String classDiscriminator;
        boolean requiresTopLevelTag;
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (getCurrentTagOrNull() == null) {
            requiresTopLevelTag = TreeJsonEncoderKt.getRequiresTopLevelTag(WriteModeKt.carrierDescriptor(serializer.getDescriptor(), getSerializersModule()));
            if (requiresTopLevelTag) {
                new JsonPrimitiveEncoder(this.json, this.nodeConsumer).encodeSerializableValue(serializer, value);
                return;
            }
        }
        if (getJson().getConfiguration().getUseArrayPolymorphism()) {
            serializer.serialize(this, value);
            return;
        }
        boolean z5 = serializer instanceof AbstractPolymorphicSerializer;
        if (!z5) {
            int i5 = PolymorphicKt.WhenMappings.$EnumSwitchMapping$0[getJson().getConfiguration().getClassDiscriminatorMode().ordinal()];
            if (i5 != 1 && i5 != 2) {
                if (i5 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                SerialKind kind = serializer.getDescriptor().getKind();
                if (!Intrinsics.areEqual(kind, StructureKind.CLASS.INSTANCE)) {
                }
                classDiscriminator = PolymorphicKt.classDiscriminator(serializer.getDescriptor(), getJson());
            }
            classDiscriminator = null;
        }
        if (z5) {
            AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) serializer;
            if (value == 0) {
                throw new IllegalArgumentException(("Value for serializer " + serializer.getDescriptor() + " should always be non-null. Please report issue to the kotlinx.serialization tracker.").toString());
            }
            SerializationStrategy<? super T> findPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer(abstractPolymorphicSerializer, this, value);
            if (classDiscriminator != null) {
                PolymorphicKt.access$validateIfSealed(serializer, findPolymorphicSerializer, classDiscriminator);
            }
            PolymorphicKt.checkKind(findPolymorphicSerializer.getDescriptor().getKind());
            Intrinsics.checkNotNull(findPolymorphicSerializer, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.encodePolymorphically>");
            serializer = findPolymorphicSerializer;
        }
        if (classDiscriminator != null) {
            this.polymorphicDiscriminator = classDiscriminator;
        }
        serializer.serialize(this, value);
    }

    protected void encodeTaggedNull(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonNull.INSTANCE);
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    protected void endEncode(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.nodeConsumer.invoke(getCurrent());
    }

    public abstract JsonElement getCurrent();

    @Override // kotlinx.serialization.json.JsonEncoder
    public final Json getJson() {
        return this.json;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Function1<JsonElement, Unit> getNodeConsumer() {
        return this.nodeConsumer;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final SerializersModule getSerializersModule() {
        return this.json.getSerializersModule();
    }

    public abstract void putElement(String key, JsonElement element);

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.configuration.getEncodeDefaults();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AbstractJsonTreeEncoder(Json json, Function1<? super JsonElement, Unit> function1) {
        this.json = json;
        this.nodeConsumer = function1;
        this.configuration = json.getConfiguration();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedBoolean(String tag, boolean value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Boolean.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedByte(String tag, byte value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Byte.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedChar(String tag, char value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(String.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedDouble(String tag, double value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Double.valueOf(value)));
        if (this.configuration.getAllowSpecialFloatingPointValues()) {
            return;
        }
        if (Double.isInfinite(value) || Double.isNaN(value)) {
            throw JsonExceptionsKt.InvalidFloatingPointEncoded(Double.valueOf(value), tag, getCurrent().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedEnum(String tag, SerialDescriptor enumDescriptor, int ordinal) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        putElement(tag, JsonElementKt.JsonPrimitive(enumDescriptor.getElementName(ordinal)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedFloat(String tag, float value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Float.valueOf(value)));
        if (this.configuration.getAllowSpecialFloatingPointValues()) {
            return;
        }
        if (Float.isInfinite(value) || Float.isNaN(value)) {
            throw JsonExceptionsKt.InvalidFloatingPointEncoded(Float.valueOf(value), tag, getCurrent().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public Encoder encodeTaggedInline(String tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        return StreamingJsonEncoderKt.isUnsignedNumber(inlineDescriptor) ? inlineUnsignedNumberEncoder(tag) : StreamingJsonEncoderKt.isUnquotedLiteral(inlineDescriptor) ? inlineUnquotedLiteralEncoder(tag, inlineDescriptor) : super.encodeTaggedInline((AbstractJsonTreeEncoder) tag, inlineDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedInt(String tag, int value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Integer.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedLong(String tag, long value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Long.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedShort(String tag, short value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Short.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedString(String tag, String value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(value, "value");
        putElement(tag, JsonElementKt.JsonPrimitive(value));
    }
}
