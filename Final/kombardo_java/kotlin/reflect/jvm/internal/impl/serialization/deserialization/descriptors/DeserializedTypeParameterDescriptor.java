package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* loaded from: classes3.dex */
public final class DeserializedTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    private final DeserializedAnnotations annotations;

    /* renamed from: c, reason: collision with root package name */
    private final DeserializationContext f6174c;
    private final ProtoBuf$TypeParameter proto;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DeserializedTypeParameterDescriptor(DeserializationContext c5, ProtoBuf$TypeParameter proto, int i5) {
        super(r2, r3, r4, r5, r0.variance(r1), proto.getReified(), i5, SourceElement.NO_SOURCE, SupertypeLoopChecker.EMPTY.INSTANCE);
        Intrinsics.checkNotNullParameter(c5, "c");
        Intrinsics.checkNotNullParameter(proto, "proto");
        StorageManager storageManager = c5.getStorageManager();
        DeclarationDescriptor containingDeclaration = c5.getContainingDeclaration();
        Annotations empty = Annotations.Companion.getEMPTY();
        Name name = NameResolverUtilKt.getName(c5.getNameResolver(), proto.getName());
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        ProtoBuf$TypeParameter.Variance variance = proto.getVariance();
        Intrinsics.checkNotNullExpressionValue(variance, "getVariance(...)");
        this.f6174c = c5;
        this.proto = proto;
        this.annotations = new DeserializedAnnotations(c5.getStorageManager(), new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor$$Lambda$0
            private final DeserializedTypeParameterDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List annotations$lambda$0;
                annotations$lambda$0 = DeserializedTypeParameterDescriptor.annotations$lambda$0(this.arg$0);
                return annotations$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List annotations$lambda$0(DeserializedTypeParameterDescriptor deserializedTypeParameterDescriptor) {
        return CollectionsKt.toList(deserializedTypeParameterDescriptor.f6174c.getComponents().getAnnotationAndConstantLoader().loadTypeParameterAnnotations(deserializedTypeParameterDescriptor.proto, deserializedTypeParameterDescriptor.f6174c.getNameResolver()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    protected List<KotlinType> resolveUpperBounds() {
        List<ProtoBuf$Type> upperBounds = ProtoTypeTableUtilKt.upperBounds(this.proto, this.f6174c.getTypeTable());
        if (upperBounds.isEmpty()) {
            return CollectionsKt.listOf(DescriptorUtilsKt.getBuiltIns(this).getDefaultBound());
        }
        List<ProtoBuf$Type> list = upperBounds;
        TypeDeserializer typeDeserializer = this.f6174c.getTypeDeserializer();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(typeDeserializer.type((ProtoBuf$Type) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public DeserializedAnnotations getAnnotations() {
        return this.annotations;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    /* renamed from: reportSupertypeLoopError, reason: merged with bridge method [inline-methods] */
    public Void mo3721reportSupertypeLoopError(KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        throw new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }
}
