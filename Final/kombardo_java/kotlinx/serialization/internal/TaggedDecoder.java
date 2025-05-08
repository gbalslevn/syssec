package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b,\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\n\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0007\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\u00028\u0000*\u00020\f2\u0006\u0010\u000e\u001a\u00020\rH$¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020%2\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020(2\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010+\u001a\u00020\fH\u0014¢\u0006\u0004\b,\u0010-J\u001f\u0010/\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010.\u001a\u00020\fH\u0014¢\u0006\u0004\b/\u00100J-\u00105\u001a\u00028\u0001\"\u0004\b\u0001\u001012\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u0001022\b\u00104\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u00020\fH\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010;\u001a\u0004\u0018\u00010:¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\u0011¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\u0014¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\u0017¢\u0006\u0004\bA\u0010BJ\r\u0010C\u001a\u00020\r¢\u0006\u0004\bC\u0010DJ\r\u0010E\u001a\u00020\u001c¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020\u001f¢\u0006\u0004\bG\u0010HJ\r\u0010I\u001a\u00020\"¢\u0006\u0004\bI\u0010JJ\r\u0010K\u001a\u00020%¢\u0006\u0004\bK\u0010LJ\r\u0010M\u001a\u00020(¢\u0006\u0004\bM\u0010NJ\u0015\u0010O\u001a\u00020\r2\u0006\u0010+\u001a\u00020\f¢\u0006\u0004\bO\u0010PJ\u001d\u0010Q\u001a\u00020\u00112\u0006\u00107\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bQ\u0010RJ\u001d\u0010S\u001a\u00020\u00142\u0006\u00107\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bS\u0010TJ\u001d\u0010U\u001a\u00020\u00172\u0006\u00107\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bU\u0010VJ\u001d\u0010W\u001a\u00020\r2\u0006\u00107\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bW\u0010XJ\u001d\u0010Y\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bY\u0010ZJ\u001d\u0010[\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b[\u0010\\J\u001d\u0010]\u001a\u00020\"2\u0006\u00107\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b]\u0010^J\u001d\u0010_\u001a\u00020%2\u0006\u00107\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b_\u0010`J\u001d\u0010a\u001a\u00020(2\u0006\u00107\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\ba\u0010bJ\u001d\u0010c\u001a\u00020\u00022\u0006\u00107\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bc\u0010dJ;\u0010e\u001a\u00028\u0001\"\u0004\b\u0001\u001012\u0006\u00107\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u0001022\b\u00104\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\be\u0010fJC\u0010h\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u00101*\u00020g2\u0006\u00107\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u0001022\b\u00104\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\bh\u0010fJ\u0017\u0010k\u001a\u00020j2\u0006\u0010i\u001a\u00028\u0000H\u0004¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00028\u0000H\u0004¢\u0006\u0004\bm\u0010nR$\u0010q\u001a\u0012\u0012\u0004\u0012\u00028\u00000oj\b\u0012\u0004\u0012\u00028\u0000`p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010s\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010v\u001a\u0004\u0018\u00018\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bu\u0010n¨\u0006w"}, d2 = {"Lkotlinx/serialization/internal/TaggedDecoder;", "Tag", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "<init>", "()V", "E", "tag", "Lkotlin/Function0;", "block", "tagBlock", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", BuildConfig.FLAVOR, "index", "getTag", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", BuildConfig.FLAVOR, "decodeTaggedBoolean", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "decodeTaggedByte", "(Ljava/lang/Object;)B", BuildConfig.FLAVOR, "decodeTaggedShort", "(Ljava/lang/Object;)S", "decodeTaggedInt", "(Ljava/lang/Object;)I", BuildConfig.FLAVOR, "decodeTaggedLong", "(Ljava/lang/Object;)J", BuildConfig.FLAVOR, "decodeTaggedFloat", "(Ljava/lang/Object;)F", BuildConfig.FLAVOR, "decodeTaggedDouble", "(Ljava/lang/Object;)D", BuildConfig.FLAVOR, "decodeTaggedChar", "(Ljava/lang/Object;)C", BuildConfig.FLAVOR, "decodeTaggedString", "(Ljava/lang/Object;)Ljava/lang/String;", "enumDescriptor", "decodeTaggedEnum", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "inlineDescriptor", "decodeTaggedInline", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "T", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "previousValue", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "descriptor", "decodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", BuildConfig.FLAVOR, "decodeNull", "()Ljava/lang/Void;", "decodeBoolean", "()Z", "decodeByte", "()B", "decodeShort", "()S", "decodeInt", "()I", "decodeLong", "()J", "decodeFloat", "()F", "decodeDouble", "()D", "decodeChar", "()C", "decodeString", "()Ljava/lang/String;", "decodeEnum", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeBooleanElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "decodeByteElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)B", "decodeShortElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)S", "decodeIntElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)I", "decodeLongElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)J", "decodeFloatElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)F", "decodeDoubleElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)D", "decodeCharElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)C", "decodeStringElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "decodeInlineElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/Decoder;", "decodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", BuildConfig.FLAVOR, "decodeNullableSerializableElement", "name", BuildConfig.FLAVOR, "pushTag", "(Ljava/lang/Object;)V", "popTag", "()Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tagStack", "Ljava/util/ArrayList;", "flag", "Z", "getCurrentTagOrNull", "currentTagOrNull", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class TaggedDecoder<Tag> implements Decoder, CompositeDecoder {
    private boolean flag;
    private final ArrayList<Tag> tagStack = new ArrayList<>();

    private final <E> E tagBlock(Tag tag, Function0<? extends E> block) {
        pushTag(tag);
        E invoke = block.invoke();
        if (!this.flag) {
            popTag();
        }
        this.flag = false;
        return invoke;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final boolean decodeBoolean() {
        return decodeTaggedBoolean(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final boolean decodeBooleanElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedBoolean(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        return decodeTaggedByte(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final byte decodeByteElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedByte(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final char decodeChar() {
        return decodeTaggedChar(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final char decodeCharElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedChar(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeCollectionSize(SerialDescriptor serialDescriptor) {
        return CompositeDecoder.DefaultImpls.decodeCollectionSize(this, serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final double decodeDouble() {
        return decodeTaggedDouble(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final double decodeDoubleElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedDouble(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeEnum(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return decodeTaggedEnum(popTag(), enumDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final float decodeFloat() {
        return decodeTaggedFloat(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final float decodeFloatElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedFloat(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedInline(popTag(), descriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Decoder decodeInlineElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedInline(getTag(descriptor, index), descriptor.getElementDescriptor(index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        return decodeTaggedInt(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeIntElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedInt(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        return decodeTaggedLong(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final long decodeLongElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedLong(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final Void decodeNull() {
        return null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final <T> T decodeNullableSerializableElement(SerialDescriptor descriptor, int index, final DeserializationStrategy<? extends T> deserializer, final T previousValue) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) tagBlock(getTag(descriptor, index), new Function0<T>(this) { // from class: kotlinx.serialization.internal.TaggedDecoder$decodeNullableSerializableElement$1
            final /* synthetic */ TaggedDecoder<Tag> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                TaggedDecoder<Tag> taggedDecoder = this.this$0;
                DeserializationStrategy<T> deserializationStrategy = deserializer;
                return (deserializationStrategy.getDescriptor().isNullable() || taggedDecoder.decodeNotNullMark()) ? (T) taggedDecoder.decodeSerializableValue(deserializationStrategy, previousValue) : (T) taggedDecoder.decodeNull();
            }
        });
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public boolean decodeSequentially() {
        return CompositeDecoder.DefaultImpls.decodeSequentially(this);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final <T> T decodeSerializableElement(SerialDescriptor descriptor, int index, final DeserializationStrategy<? extends T> deserializer, final T previousValue) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) tagBlock(getTag(descriptor, index), new Function0<T>(this) { // from class: kotlinx.serialization.internal.TaggedDecoder$decodeSerializableElement$1
            final /* synthetic */ TaggedDecoder<Tag> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                return (T) this.this$0.decodeSerializableValue(deserializer, previousValue);
            }
        });
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializationStrategy);

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializer, T previousValue) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) decodeSerializableValue(deserializer);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        return decodeTaggedShort(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final short decodeShortElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedShort(getTag(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final String decodeString() {
        return decodeTaggedString(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final String decodeStringElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeTaggedString(getTag(descriptor, index));
    }

    protected abstract boolean decodeTaggedBoolean(Tag tag);

    protected abstract byte decodeTaggedByte(Tag tag);

    protected abstract char decodeTaggedChar(Tag tag);

    protected abstract double decodeTaggedDouble(Tag tag);

    protected abstract int decodeTaggedEnum(Tag tag, SerialDescriptor enumDescriptor);

    protected abstract float decodeTaggedFloat(Tag tag);

    /* JADX INFO: Access modifiers changed from: protected */
    public Decoder decodeTaggedInline(Tag tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        pushTag(tag);
        return this;
    }

    protected abstract int decodeTaggedInt(Tag tag);

    protected abstract long decodeTaggedLong(Tag tag);

    protected abstract short decodeTaggedShort(Tag tag);

    protected abstract String decodeTaggedString(Tag tag);

    /* JADX INFO: Access modifiers changed from: protected */
    public final Tag getCurrentTagOrNull() {
        return (Tag) CollectionsKt.lastOrNull((List) this.tagStack);
    }

    protected abstract Tag getTag(SerialDescriptor serialDescriptor, int i5);

    protected final Tag popTag() {
        ArrayList<Tag> arrayList = this.tagStack;
        Tag remove = arrayList.remove(CollectionsKt.getLastIndex(arrayList));
        this.flag = true;
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void pushTag(Tag name) {
        this.tagStack.add(name);
    }
}
