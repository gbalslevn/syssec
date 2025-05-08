package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeParameterReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n*\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e*\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR!\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010&R\u0014\u0010(\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u001bR\u0014\u0010,\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "toKClassImpl", "(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Lkotlin/reflect/jvm/internal/KClassImpl;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedMemberDescriptor;", "Ljava/lang/Class;", "getContainerClass", "(Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedMemberDescriptor;)Ljava/lang/Class;", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", BuildConfig.FLAVOR, "Lkotlin/reflect/KType;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getUpperBounds", "()Ljava/util/List;", "upperBounds", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "getName", "name", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "variance", "kotlin-reflection"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KTypeParameterImpl implements KTypeParameter, KClassifierImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(KTypeParameterImpl.class, "upperBounds", "getUpperBounds()Ljava/util/List;", 0))};
    private final KTypeParameterOwnerImpl container;
    private final TypeParameterDescriptor descriptor;

    /* renamed from: upperBounds$delegate, reason: from kotlin metadata */
    private final ReflectProperties.LazySoftVal upperBounds;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public KTypeParameterImpl(KTypeParameterOwnerImpl kTypeParameterOwnerImpl, TypeParameterDescriptor descriptor) {
        KClassImpl<?> kClassImpl;
        Object accept;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.descriptor = descriptor;
        this.upperBounds = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KTypeParameterImpl$$Lambda$0
            private final KTypeParameterImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List upperBounds_delegate$lambda$1;
                upperBounds_delegate$lambda$1 = KTypeParameterImpl.upperBounds_delegate$lambda$1(this.arg$0);
                return upperBounds_delegate$lambda$1;
            }
        });
        if (kTypeParameterOwnerImpl == null) {
            DeclarationDescriptor containingDeclaration = getDescriptor().getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (containingDeclaration instanceof ClassDescriptor) {
                accept = toKClassImpl((ClassDescriptor) containingDeclaration);
            } else {
                if (!(containingDeclaration instanceof CallableMemberDescriptor)) {
                    throw new KotlinReflectionInternalError("Unknown type parameter container: " + containingDeclaration);
                }
                DeclarationDescriptor containingDeclaration2 = ((CallableMemberDescriptor) containingDeclaration).getContainingDeclaration();
                Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
                if (containingDeclaration2 instanceof ClassDescriptor) {
                    kClassImpl = toKClassImpl((ClassDescriptor) containingDeclaration2);
                } else {
                    DeserializedMemberDescriptor deserializedMemberDescriptor = containingDeclaration instanceof DeserializedMemberDescriptor ? (DeserializedMemberDescriptor) containingDeclaration : null;
                    if (deserializedMemberDescriptor == null) {
                        throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + containingDeclaration);
                    }
                    KClass kotlinClass = JvmClassMappingKt.getKotlinClass(getContainerClass(deserializedMemberDescriptor));
                    Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                    kClassImpl = (KClassImpl) kotlinClass;
                }
                accept = containingDeclaration.accept(new CreateKCallableVisitor(kClassImpl), Unit.INSTANCE);
            }
            kTypeParameterOwnerImpl = (KTypeParameterOwnerImpl) accept;
        }
        this.container = kTypeParameterOwnerImpl;
    }

    private final Class<?> getContainerClass(DeserializedMemberDescriptor deserializedMemberDescriptor) {
        Class<?> klass;
        DeserializedContainerSource containerSource = deserializedMemberDescriptor.getContainerSource();
        JvmPackagePartSource jvmPackagePartSource = containerSource instanceof JvmPackagePartSource ? (JvmPackagePartSource) containerSource : null;
        Object knownJvmBinaryClass = jvmPackagePartSource != null ? jvmPackagePartSource.getKnownJvmBinaryClass() : null;
        ReflectKotlinClass reflectKotlinClass = knownJvmBinaryClass instanceof ReflectKotlinClass ? (ReflectKotlinClass) knownJvmBinaryClass : null;
        if (reflectKotlinClass != null && (klass = reflectKotlinClass.getKlass()) != null) {
            return klass;
        }
        throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + deserializedMemberDescriptor);
    }

    private final KClassImpl<?> toKClassImpl(ClassDescriptor classDescriptor) {
        Class<?> javaClass = UtilKt.toJavaClass(classDescriptor);
        KClassImpl<?> kClassImpl = (KClassImpl) (javaClass != null ? JvmClassMappingKt.getKotlinClass(javaClass) : null);
        if (kClassImpl != null) {
            return kClassImpl;
        }
        throw new KotlinReflectionInternalError("Type parameter container is not resolved: " + classDescriptor.getContainingDeclaration());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List upperBounds_delegate$lambda$1(KTypeParameterImpl kTypeParameterImpl) {
        List<KotlinType> upperBounds = kTypeParameterImpl.getDescriptor().getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
        List<KotlinType> list = upperBounds;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new KTypeImpl((KotlinType) it.next(), null, 2, null));
        }
        return arrayList;
    }

    public boolean equals(Object other) {
        if (other instanceof KTypeParameterImpl) {
            KTypeParameterImpl kTypeParameterImpl = (KTypeParameterImpl) other;
            if (Intrinsics.areEqual(this.container, kTypeParameterImpl.container) && Intrinsics.areEqual(getName(), kTypeParameterImpl.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KTypeParameter
    public String getName() {
        String asString = getDescriptor().getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return asString;
    }

    @Override // kotlin.reflect.KTypeParameter
    public List<KType> getUpperBounds() {
        T value = this.upperBounds.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (List) value;
    }

    @Override // kotlin.reflect.KTypeParameter
    public KVariance getVariance() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[getDescriptor().getVariance().ordinal()];
        if (i5 == 1) {
            return KVariance.INVARIANT;
        }
        if (i5 == 2) {
            return KVariance.IN;
        }
        if (i5 == 3) {
            return KVariance.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public int hashCode() {
        return (this.container.hashCode() * 31) + getName().hashCode();
    }

    public String toString() {
        return TypeParameterReference.INSTANCE.toString(this);
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public TypeParameterDescriptor getDescriptor() {
        return this.descriptor;
    }
}
