package dk.molslinjen.api.helpers.serializers;

import dk.molslinjen.api.helpers.serializers.SafeListSerializer;
import dk.molslinjen.core.log.Logger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0017\u0010\u001a\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001dR\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR'\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\n\u0010\bR\u001b\u0010\r\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/api/helpers/serializers/SafeListSerializer;", "T", "Lkotlinx/serialization/KSerializer;", BuildConfig.FLAVOR, "<init>", "()V", "itemSerializer", "getItemSerializer", "()Lkotlinx/serialization/KSerializer;", "listSerializer", "getListSerializer", "listSerializer$delegate", "Lkotlin/Lazy;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "readElement", "compositeDecoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "(Lkotlinx/serialization/encoding/CompositeDecoder;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SafeListSerializer<T> implements KSerializer<List<? extends T>> {

    /* renamed from: listSerializer$delegate, reason: from kotlin metadata */
    private final Lazy listSerializer = LazyKt.lazy(new Function0() { // from class: p1.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer listSerializer_delegate$lambda$0;
            listSerializer_delegate$lambda$0 = SafeListSerializer.listSerializer_delegate$lambda$0(SafeListSerializer.this);
            return listSerializer_delegate$lambda$0;
        }
    });

    /* renamed from: descriptor$delegate, reason: from kotlin metadata */
    private final Lazy descriptor = LazyKt.lazy(new Function0() { // from class: p1.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SerialDescriptor descriptor_delegate$lambda$1;
            descriptor_delegate$lambda$1 = SafeListSerializer.descriptor_delegate$lambda$1(SafeListSerializer.this);
            return descriptor_delegate$lambda$1;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor descriptor_delegate$lambda$1(SafeListSerializer safeListSerializer) {
        return safeListSerializer.getListSerializer().getDescriptor();
    }

    private final KSerializer<List<T>> getListSerializer() {
        return (KSerializer) this.listSerializer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer listSerializer_delegate$lambda$0(SafeListSerializer safeListSerializer) {
        return BuiltinSerializersKt.ListSerializer(safeListSerializer.getItemSerializer());
    }

    private final T readElement(CompositeDecoder compositeDecoder) {
        try {
            Intrinsics.checkNotNull(compositeDecoder, "null cannot be cast to non-null type kotlinx.serialization.json.JsonDecoder");
            JsonDecoder jsonDecoder = (JsonDecoder) compositeDecoder;
            return (T) jsonDecoder.getJson().decodeFromJsonElement(getItemSerializer(), jsonDecoder.decodeJsonElement());
        } catch (Exception e5) {
            Logger.INSTANCE.logError(e5);
            return null;
        }
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor.getValue();
    }

    protected abstract KSerializer<T> getItemSerializer();

    @Override // kotlinx.serialization.DeserializationStrategy
    public List<T> deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        ArrayList arrayList = new ArrayList();
        CompositeDecoder beginStructure = decoder.beginStructure(getDescriptor());
        while (beginStructure.decodeElementIndex(getDescriptor()) != -1) {
            arrayList.add(readElement(beginStructure));
        }
        beginStructure.endStructure(getDescriptor());
        return CollectionsKt.filterNotNull(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, List<? extends T> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        getListSerializer().serialize(encoder, value);
    }
}
