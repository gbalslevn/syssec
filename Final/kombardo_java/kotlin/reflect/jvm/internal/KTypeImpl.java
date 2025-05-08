package kotlin.reflect.jvm.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u001d\u0010\u001f\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b\u001d\u0010\u001eR!\u0010%\u001a\b\u0012\u0004\u0012\u00020!0 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010$R\u0016\u0010(\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,²\u0006\u0012\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050 8\nX\u008a\u0084\u0002"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/jvm/internal/KTypeBase;", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "type", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "computeJavaType", "<init>", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "Lkotlin/reflect/KClassifier;", "convert", "(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/KClassifier;", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier$delegate", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier", BuildConfig.FLAVOR, "Lkotlin/reflect/KTypeProjection;", "arguments$delegate", "getArguments", "()Ljava/util/List;", "arguments", "getJavaType", "()Ljava/lang/reflect/Type;", "javaType", "isMarkedNullable", "()Z", "parameterizedTypeArguments", "kotlin-reflection"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KTypeImpl implements KTypeBase {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(KTypeImpl.class, "classifier", "getClassifier()Lkotlin/reflect/KClassifier;", 0)), Reflection.property1(new PropertyReference1Impl(KTypeImpl.class, "arguments", "getArguments()Ljava/util/List;", 0))};

    /* renamed from: arguments$delegate, reason: from kotlin metadata */
    private final ReflectProperties.LazySoftVal arguments;

    /* renamed from: classifier$delegate, reason: from kotlin metadata */
    private final ReflectProperties.LazySoftVal classifier;
    private final ReflectProperties.LazySoftVal<Type> computeJavaType;
    private final KotlinType type;

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

    public KTypeImpl(KotlinType type, final Function0<? extends Type> function0) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        ReflectProperties.LazySoftVal<Type> lazySoftVal = null;
        ReflectProperties.LazySoftVal<Type> lazySoftVal2 = function0 instanceof ReflectProperties.LazySoftVal ? (ReflectProperties.LazySoftVal) function0 : null;
        if (lazySoftVal2 != null) {
            lazySoftVal = lazySoftVal2;
        } else if (function0 != null) {
            lazySoftVal = ReflectProperties.lazySoft(function0);
        }
        this.computeJavaType = lazySoftVal;
        this.classifier = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$0
            private final KTypeImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                KClassifier classifier_delegate$lambda$0;
                classifier_delegate$lambda$0 = KTypeImpl.classifier_delegate$lambda$0(this.arg$0);
                return classifier_delegate$lambda$0;
            }
        });
        this.arguments = ReflectProperties.lazySoft(new Function0(this, function0) { // from class: kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$1
            private final KTypeImpl arg$0;
            private final Function0 arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = function0;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List arguments_delegate$lambda$5;
                arguments_delegate$lambda$5 = KTypeImpl.arguments_delegate$lambda$5(this.arg$0, this.arg$1);
                return arguments_delegate$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List arguments_delegate$lambda$5(final KTypeImpl kTypeImpl, Function0 function0) {
        KTypeProjection invariant;
        List<TypeProjection> arguments = kTypeImpl.type.getArguments();
        if (arguments.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(kTypeImpl) { // from class: kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$2
            private final KTypeImpl arg$0;

            {
                this.arg$0 = kTypeImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List arguments_delegate$lambda$5$lambda$1;
                arguments_delegate$lambda$5$lambda$1 = KTypeImpl.arguments_delegate$lambda$5$lambda$1(this.arg$0);
                return arguments_delegate$lambda$5$lambda$1;
            }
        });
        List<TypeProjection> list = arguments;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        final int i5 = 0;
        for (Object obj : list) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            if (typeProjection.isStarProjection()) {
                invariant = KTypeProjection.INSTANCE.getSTAR();
            } else {
                KotlinType type = typeProjection.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                KTypeImpl kTypeImpl2 = new KTypeImpl(type, function0 == null ? null : new Function0(kTypeImpl, i5, lazy) { // from class: kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$3
                    private final KTypeImpl arg$0;
                    private final int arg$1;
                    private final Lazy arg$2;

                    {
                        this.arg$0 = kTypeImpl;
                        this.arg$1 = i5;
                        this.arg$2 = lazy;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        Type arguments_delegate$lambda$5$lambda$4$lambda$3;
                        arguments_delegate$lambda$5$lambda$4$lambda$3 = KTypeImpl.arguments_delegate$lambda$5$lambda$4$lambda$3(this.arg$0, this.arg$1, this.arg$2);
                        return arguments_delegate$lambda$5$lambda$4$lambda$3;
                    }
                });
                int i7 = WhenMappings.$EnumSwitchMapping$0[typeProjection.getProjectionKind().ordinal()];
                if (i7 == 1) {
                    invariant = KTypeProjection.INSTANCE.invariant(kTypeImpl2);
                } else if (i7 == 2) {
                    invariant = KTypeProjection.INSTANCE.contravariant(kTypeImpl2);
                } else {
                    if (i7 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    invariant = KTypeProjection.INSTANCE.covariant(kTypeImpl2);
                }
            }
            arrayList.add(invariant);
            i5 = i6;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List arguments_delegate$lambda$5$lambda$1(KTypeImpl kTypeImpl) {
        Type javaType = kTypeImpl.getJavaType();
        Intrinsics.checkNotNull(javaType);
        return ReflectClassUtilKt.getParameterizedTypeArguments(javaType);
    }

    private static final List<Type> arguments_delegate$lambda$5$lambda$2(Lazy<? extends List<? extends Type>> lazy) {
        return (List) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type arguments_delegate$lambda$5$lambda$4$lambda$3(KTypeImpl kTypeImpl, int i5, Lazy<? extends List<? extends Type>> lazy) {
        Type type;
        Type javaType = kTypeImpl.getJavaType();
        if (javaType instanceof Class) {
            Class cls = (Class) javaType;
            Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            Intrinsics.checkNotNull(componentType);
            return componentType;
        }
        if (javaType instanceof GenericArrayType) {
            if (i5 == 0) {
                Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
                Intrinsics.checkNotNull(genericComponentType);
                return genericComponentType;
            }
            throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + kTypeImpl);
        }
        if (!(javaType instanceof ParameterizedType)) {
            throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + kTypeImpl);
        }
        Type type2 = arguments_delegate$lambda$5$lambda$2(lazy).get(i5);
        if (!(type2 instanceof WildcardType)) {
            return type2;
        }
        WildcardType wildcardType = (WildcardType) type2;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        Intrinsics.checkNotNullExpressionValue(lowerBounds, "getLowerBounds(...)");
        Type type3 = (Type) ArraysKt.firstOrNull(lowerBounds);
        if (type3 == null) {
            Type[] upperBounds = wildcardType.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
            type = (Type) ArraysKt.first(upperBounds);
        } else {
            type = type3;
        }
        Intrinsics.checkNotNull(type);
        return type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KClassifier classifier_delegate$lambda$0(KTypeImpl kTypeImpl) {
        return kTypeImpl.convert(kTypeImpl.type);
    }

    private final KClassifier convert(KotlinType type) {
        KotlinType type2;
        ClassifierDescriptor mo3718getDeclarationDescriptor = type.getConstructor().mo3718getDeclarationDescriptor();
        if (!(mo3718getDeclarationDescriptor instanceof ClassDescriptor)) {
            if (mo3718getDeclarationDescriptor instanceof TypeParameterDescriptor) {
                return new KTypeParameterImpl(null, (TypeParameterDescriptor) mo3718getDeclarationDescriptor);
            }
            if (!(mo3718getDeclarationDescriptor instanceof TypeAliasDescriptor)) {
                return null;
            }
            throw new NotImplementedError("An operation is not implemented: Type alias classifiers are not yet supported");
        }
        Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) mo3718getDeclarationDescriptor);
        if (javaClass == null) {
            return null;
        }
        if (!javaClass.isArray()) {
            if (TypeUtils.isNullableType(type)) {
                return new KClassImpl(javaClass);
            }
            Class<?> primitiveByWrapper = ReflectClassUtilKt.getPrimitiveByWrapper(javaClass);
            if (primitiveByWrapper != null) {
                javaClass = primitiveByWrapper;
            }
            return new KClassImpl(javaClass);
        }
        TypeProjection typeProjection = (TypeProjection) CollectionsKt.singleOrNull((List) type.getArguments());
        if (typeProjection == null || (type2 = typeProjection.getType()) == null) {
            return new KClassImpl(javaClass);
        }
        KClassifier convert = convert(type2);
        if (convert != null) {
            return new KClassImpl(UtilKt.createArrayType(JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(convert))));
        }
        throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
    }

    public boolean equals(Object other) {
        if (other instanceof KTypeImpl) {
            KTypeImpl kTypeImpl = (KTypeImpl) other;
            if (Intrinsics.areEqual(this.type, kTypeImpl.type) && Intrinsics.areEqual(getClassifier(), kTypeImpl.getClassifier()) && Intrinsics.areEqual(getArguments(), kTypeImpl.getArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> getArguments() {
        T value = this.arguments.getValue(this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (List) value;
    }

    @Override // kotlin.reflect.KType
    public KClassifier getClassifier() {
        return (KClassifier) this.classifier.getValue(this, $$delegatedProperties[0]);
    }

    @Override // kotlin.jvm.internal.KTypeBase
    public Type getJavaType() {
        ReflectProperties.LazySoftVal<Type> lazySoftVal = this.computeJavaType;
        if (lazySoftVal != null) {
            return lazySoftVal.invoke();
        }
        return null;
    }

    public final KotlinType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        KClassifier classifier = getClassifier();
        return ((hashCode + (classifier != null ? classifier.hashCode() : 0)) * 31) + getArguments().hashCode();
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return this.type.isMarkedNullable();
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderType(this.type);
    }

    public /* synthetic */ KTypeImpl(KotlinType kotlinType, Function0 function0, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(kotlinType, (i5 & 2) != 0 ? null : function0);
    }
}
