package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00028\u0000*\u00020\u00062\u0006\u0010\t\u001a\u00020\bH$¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u001dH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020 H\u0014¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\nH\u0014¢\u0006\u0004\b#\u0010$J\u001f\u0010&\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020%H\u0014¢\u0006\u0004\b&\u0010'J\u001f\u0010)\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020(H\u0014¢\u0006\u0004\b)\u0010*J'\u0010-\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\bH\u0014¢\u0006\u0004\b-\u0010.J\u001f\u00100\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010/\u001a\u00020\u0006H\u0014¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b5\u00106J\u0015\u00107\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0014¢\u0006\u0004\b7\u00108J\u0015\u00109\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0017¢\u0006\u0004\b9\u0010:J\u0015\u0010;\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b;\u0010<J\u0015\u0010=\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u001a¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u001d¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020 ¢\u0006\u0004\bA\u0010BJ\u0015\u0010C\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020%¢\u0006\u0004\bC\u0010DJ\u0015\u0010E\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020(¢\u0006\u0004\bE\u0010FJ\u001d\u0010G\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\bG\u0010HJ\u0015\u0010I\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0006¢\u0006\u0004\bI\u0010JJ\u0017\u0010K\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0006H\u0014¢\u0006\u0004\bK\u0010JJ%\u0010L\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\bL\u0010MJ%\u0010N\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0014¢\u0006\u0004\bN\u0010OJ%\u0010P\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0017¢\u0006\u0004\bP\u0010QJ%\u0010R\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\bR\u0010SJ%\u0010T\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u001a¢\u0006\u0004\bT\u0010UJ%\u0010V\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u001d¢\u0006\u0004\bV\u0010WJ%\u0010X\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020 ¢\u0006\u0004\bX\u0010YJ%\u0010Z\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020%¢\u0006\u0004\bZ\u0010[J%\u0010\\\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020(¢\u0006\u0004\b\\\u0010]J\u001d\u0010^\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b^\u0010_J;\u0010c\u001a\u00020\u0011\"\u0004\b\u0001\u0010`2\u0006\u00102\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010b\u001a\b\u0012\u0004\u0012\u00028\u00010a2\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\bc\u0010dJA\u0010f\u001a\u00020\u0011\"\b\b\u0001\u0010`*\u00020e2\u0006\u00102\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010b\u001a\b\u0012\u0004\u0012\u00028\u00010a2\b\u0010\u0010\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0004\bf\u0010dJ\u0017\u0010h\u001a\u00020\u00112\u0006\u0010g\u001a\u00028\u0000H\u0004¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u00028\u0000H\u0004¢\u0006\u0004\bj\u0010kR$\u0010n\u001a\u0012\u0012\u0004\u0012\u00028\u00000lj\b\u0012\u0004\u0012\u00028\u0000`m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010q\u001a\u00028\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bp\u0010kR\u0016\u0010s\u001a\u0004\u0018\u00018\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\br\u0010k¨\u0006t"}, d2 = {"Lkotlinx/serialization/internal/TaggedEncoder;", "Tag", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "<init>", "()V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "desc", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "encodeElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "getTag", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "tag", "value", BuildConfig.FLAVOR, "encodeTaggedInt", "(Ljava/lang/Object;I)V", BuildConfig.FLAVOR, "encodeTaggedByte", "(Ljava/lang/Object;B)V", BuildConfig.FLAVOR, "encodeTaggedShort", "(Ljava/lang/Object;S)V", BuildConfig.FLAVOR, "encodeTaggedLong", "(Ljava/lang/Object;J)V", BuildConfig.FLAVOR, "encodeTaggedFloat", "(Ljava/lang/Object;F)V", BuildConfig.FLAVOR, "encodeTaggedDouble", "(Ljava/lang/Object;D)V", "encodeTaggedBoolean", "(Ljava/lang/Object;Z)V", BuildConfig.FLAVOR, "encodeTaggedChar", "(Ljava/lang/Object;C)V", BuildConfig.FLAVOR, "encodeTaggedString", "(Ljava/lang/Object;Ljava/lang/String;)V", "enumDescriptor", "ordinal", "encodeTaggedEnum", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "inlineDescriptor", "encodeTaggedInline", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "descriptor", "encodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "encodeBoolean", "(Z)V", "encodeByte", "(B)V", "encodeShort", "(S)V", "encodeInt", "(I)V", "encodeLong", "(J)V", "encodeFloat", "(F)V", "encodeDouble", "(D)V", "encodeChar", "(C)V", "encodeString", "(Ljava/lang/String;)V", "encodeEnum", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "endEncode", "encodeBooleanElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IZ)V", "encodeByteElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IB)V", "encodeShortElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IS)V", "encodeIntElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;II)V", "encodeLongElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IJ)V", "encodeFloatElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IF)V", "encodeDoubleElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ID)V", "encodeCharElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IC)V", "encodeStringElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILjava/lang/String;)V", "encodeInlineElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/Encoder;", "T", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "encodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", BuildConfig.FLAVOR, "encodeNullableSerializableElement", "name", "pushTag", "(Ljava/lang/Object;)V", "popTag", "()Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tagStack", "Ljava/util/ArrayList;", "getCurrentTag", "currentTag", "getCurrentTagOrNull", "currentTagOrNull", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class TaggedEncoder<Tag> implements Encoder, CompositeEncoder {
    private final ArrayList<Tag> tagStack = new ArrayList<>();

    private final boolean encodeElement(SerialDescriptor desc, int index) {
        pushTag(getTag(desc, index));
        return true;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginCollection(SerialDescriptor serialDescriptor, int i5) {
        return Encoder.DefaultImpls.beginCollection(this, serialDescriptor, i5);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeBoolean(boolean value) {
        encodeTaggedBoolean(popTag(), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeBooleanElement(SerialDescriptor descriptor, int index, boolean value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedBoolean(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeByte(byte value) {
        encodeTaggedByte(popTag(), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeByteElement(SerialDescriptor descriptor, int index, byte value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedByte(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeChar(char value) {
        encodeTaggedChar(popTag(), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeCharElement(SerialDescriptor descriptor, int index, char value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedChar(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeDouble(double value) {
        encodeTaggedDouble(popTag(), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeDoubleElement(SerialDescriptor descriptor, int index, double value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedDouble(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeEnum(SerialDescriptor enumDescriptor, int index) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        encodeTaggedEnum(popTag(), enumDescriptor, index);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeFloat(float value) {
        encodeTaggedFloat(popTag(), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeFloatElement(SerialDescriptor descriptor, int index, float value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedFloat(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return encodeTaggedInline(popTag(), descriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final Encoder encodeInlineElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return encodeTaggedInline(getTag(descriptor, index), descriptor.getElementDescriptor(index));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeInt(int value) {
        encodeTaggedInt(popTag(), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeIntElement(SerialDescriptor descriptor, int index, int value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedInt(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeLong(long value) {
        encodeTaggedLong(popTag(), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeLongElement(SerialDescriptor descriptor, int index, long value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedLong(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public <T> void encodeNullableSerializableElement(SerialDescriptor descriptor, int index, SerializationStrategy<? super T> serializer, T value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (encodeElement(descriptor, index)) {
            encodeNullableSerializableValue(serializer, value);
        }
    }

    public <T> void encodeNullableSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t5) {
        Encoder.DefaultImpls.encodeNullableSerializableValue(this, serializationStrategy, t5);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public <T> void encodeSerializableElement(SerialDescriptor descriptor, int index, SerializationStrategy<? super T> serializer, T value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (encodeElement(descriptor, index)) {
            encodeSerializableValue(serializer, value);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract <T> void encodeSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t5);

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeShort(short value) {
        encodeTaggedShort(popTag(), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeShortElement(SerialDescriptor descriptor, int index, short value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedShort(getTag(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        encodeTaggedString(popTag(), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeStringElement(SerialDescriptor descriptor, int index, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        encodeTaggedString(getTag(descriptor, index), value);
    }

    protected abstract void encodeTaggedBoolean(Tag tag, boolean value);

    protected abstract void encodeTaggedByte(Tag tag, byte value);

    protected abstract void encodeTaggedChar(Tag tag, char value);

    protected abstract void encodeTaggedDouble(Tag tag, double value);

    protected abstract void encodeTaggedEnum(Tag tag, SerialDescriptor enumDescriptor, int ordinal);

    protected abstract void encodeTaggedFloat(Tag tag, float value);

    /* JADX INFO: Access modifiers changed from: protected */
    public Encoder encodeTaggedInline(Tag tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        pushTag(tag);
        return this;
    }

    protected abstract void encodeTaggedInt(Tag tag, int value);

    protected abstract void encodeTaggedLong(Tag tag, long value);

    protected abstract void encodeTaggedShort(Tag tag, short value);

    protected abstract void encodeTaggedString(Tag tag, String value);

    protected abstract void endEncode(SerialDescriptor descriptor);

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (!this.tagStack.isEmpty()) {
            popTag();
        }
        endEncode(descriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Tag getCurrentTag() {
        return (Tag) CollectionsKt.last((List) this.tagStack);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Tag getCurrentTagOrNull() {
        return (Tag) CollectionsKt.lastOrNull((List) this.tagStack);
    }

    protected abstract Tag getTag(SerialDescriptor serialDescriptor, int i5);

    protected final Tag popTag() {
        if (this.tagStack.isEmpty()) {
            throw new SerializationException("No tag in stack for requested element");
        }
        ArrayList<Tag> arrayList = this.tagStack;
        return arrayList.remove(CollectionsKt.getLastIndex(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void pushTag(Tag name) {
        this.tagStack.add(name);
    }
}
