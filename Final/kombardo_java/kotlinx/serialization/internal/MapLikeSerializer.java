package kotlinx.serialization.internal;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0014\b\u0003\u0010\u0005*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006B%\b\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00028\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b#\u0010\"R\u0014\u0010'\u001a\u00020$8&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&\u0082\u0001\u0002()¨\u0006*"}, d2 = {"Lkotlinx/serialization/internal/MapLikeSerializer;", "Key", "Value", "Collection", BuildConfig.FLAVOR, "Builder", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decoder", "builder", BuildConfig.FLAVOR, "startIndex", "size", BuildConfig.FLAVOR, "readAll", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/util/Map;II)V", "index", BuildConfig.FLAVOR, "checkIndex", "readElement", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/util/Map;Z)V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/KSerializer;", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/internal/HashMapSerializer;", "Lkotlinx/serialization/internal/LinkedHashMapSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class MapLikeSerializer<Key, Value, Collection, Builder extends Map<Key, Value>> extends AbstractCollectionSerializer<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {
    private final KSerializer<Key> keySerializer;
    private final KSerializer<Value> valueSerializer;

    public /* synthetic */ MapLikeSerializer(KSerializer kSerializer, KSerializer kSerializer2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer, kSerializer2);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public abstract SerialDescriptor getDescriptor();

    public final KSerializer<Key> getKeySerializer() {
        return this.keySerializer;
    }

    public final KSerializer<Value> getValueSerializer() {
        return this.valueSerializer;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Collection value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int collectionSize = collectionSize(value);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder beginCollection = encoder.beginCollection(descriptor, collectionSize);
        Iterator<Map.Entry<? extends Key, ? extends Value>> collectionIterator = collectionIterator(value);
        int i5 = 0;
        while (collectionIterator.hasNext()) {
            Map.Entry<? extends Key, ? extends Value> next = collectionIterator.next();
            Key key = next.getKey();
            Value value2 = next.getValue();
            int i6 = i5 + 1;
            beginCollection.encodeSerializableElement(getDescriptor(), i5, getKeySerializer(), key);
            i5 += 2;
            beginCollection.encodeSerializableElement(getDescriptor(), i6, getValueSerializer(), value2);
        }
        beginCollection.endStructure(descriptor);
    }

    private MapLikeSerializer(KSerializer<Key> kSerializer, KSerializer<Value> kSerializer2) {
        super(null);
        this.keySerializer = kSerializer;
        this.valueSerializer = kSerializer2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readAll(CompositeDecoder decoder, Builder builder, int startIndex, int size) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (size >= 0) {
            IntProgression step = RangesKt.step(RangesKt.until(0, size * 2), 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 <= 0 || first > last) && (step2 >= 0 || last > first)) {
                return;
            }
            while (true) {
                readElement(decoder, startIndex + first, (int) builder, false);
                if (first == last) {
                    return;
                } else {
                    first += step2;
                }
            }
        } else {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder decoder, int index, Builder builder, boolean checkIndex) {
        int i5;
        Object decodeSerializableElement$default;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Object decodeSerializableElement$default2 = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(decoder, getDescriptor(), index, this.keySerializer, null, 8, null);
        if (checkIndex) {
            i5 = decoder.decodeElementIndex(getDescriptor());
            if (i5 != index + 1) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + index + ", returned index for value: " + i5).toString());
            }
        } else {
            i5 = index + 1;
        }
        int i6 = i5;
        if (builder.containsKey(decodeSerializableElement$default2) && !(this.valueSerializer.getDescriptor().getKind() instanceof PrimitiveKind)) {
            decodeSerializableElement$default = decoder.decodeSerializableElement(getDescriptor(), i6, this.valueSerializer, MapsKt.getValue(builder, decodeSerializableElement$default2));
        } else {
            decodeSerializableElement$default = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(decoder, getDescriptor(), i6, this.valueSerializer, null, 8, null);
        }
        builder.put(decodeSerializableElement$default2, decodeSerializableElement$default);
    }
}
