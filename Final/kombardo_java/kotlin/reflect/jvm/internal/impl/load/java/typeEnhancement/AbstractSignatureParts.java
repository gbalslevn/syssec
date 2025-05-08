package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* loaded from: classes3.dex */
public abstract class AbstractSignatureParts<TAnnotation> {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class TypeAndDefaultQualifiers {
        private final JavaTypeQualifiersByElementType defaultQualifiers;
        private final KotlinTypeMarker type;
        private final TypeParameterMarker typeParameterForArgument;

        public TypeAndDefaultQualifiers(KotlinTypeMarker kotlinTypeMarker, JavaTypeQualifiersByElementType javaTypeQualifiersByElementType, TypeParameterMarker typeParameterMarker) {
            this.type = kotlinTypeMarker;
            this.defaultQualifiers = javaTypeQualifiersByElementType;
            this.typeParameterForArgument = typeParameterMarker;
        }

        public final JavaTypeQualifiersByElementType getDefaultQualifiers() {
            return this.defaultQualifiers;
        }

        public final KotlinTypeMarker getType() {
            return this.type;
        }

        public final TypeParameterMarker getTypeParameterForArgument() {
            return this.typeParameterForArgument;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JavaTypeQualifiers computeIndexedQualifiers$lambda$18(TypeEnhancementInfo typeEnhancementInfo, JavaTypeQualifiers[] javaTypeQualifiersArr, int i5) {
        Map<Integer, JavaTypeQualifiers> map;
        JavaTypeQualifiers javaTypeQualifiers;
        return (typeEnhancementInfo == null || (map = typeEnhancementInfo.getMap()) == null || (javaTypeQualifiers = map.get(Integer.valueOf(i5))) == null) ? (i5 < 0 || i5 >= javaTypeQualifiersArr.length) ? JavaTypeQualifiers.Companion.getNONE() : javaTypeQualifiersArr[i5] : javaTypeQualifiers;
    }

    private final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(KotlinTypeMarker kotlinTypeMarker, JavaTypeQualifiersByElementType javaTypeQualifiersByElementType) {
        return getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers(javaTypeQualifiersByElementType, getAnnotations(kotlinTypeMarker));
    }

    private final JavaTypeQualifiers extractQualifiers(KotlinTypeMarker kotlinTypeMarker) {
        NullabilityQualifier nullabilityQualifier;
        NullabilityQualifier nullabilityQualifier2 = getNullabilityQualifier(kotlinTypeMarker);
        MutabilityQualifier mutabilityQualifier = null;
        if (nullabilityQualifier2 == null) {
            KotlinTypeMarker enhancedForWarnings = getEnhancedForWarnings(kotlinTypeMarker);
            nullabilityQualifier = enhancedForWarnings != null ? getNullabilityQualifier(enhancedForWarnings) : null;
        } else {
            nullabilityQualifier = nullabilityQualifier2;
        }
        TypeSystemContext typeSystem = getTypeSystem();
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        if (javaToKotlinClassMap.isReadOnly(getFqNameUnsafe(typeSystem.lowerBoundIfFlexible(kotlinTypeMarker)))) {
            mutabilityQualifier = MutabilityQualifier.READ_ONLY;
        } else if (javaToKotlinClassMap.isMutable(getFqNameUnsafe(typeSystem.upperBoundIfFlexible(kotlinTypeMarker)))) {
            mutabilityQualifier = MutabilityQualifier.MUTABLE;
        }
        return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, getTypeSystem().isDefinitelyNotNullType(kotlinTypeMarker) || isNotNullTypeParameterCompat(kotlinTypeMarker), nullabilityQualifier != nullabilityQualifier2);
    }

    private final JavaTypeQualifiers extractQualifiersFromAnnotations(final TypeAndDefaultQualifiers typeAndDefaultQualifiers) {
        List emptyList;
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus;
        KotlinTypeMarker type;
        TypeConstructorMarker typeConstructor;
        if (typeAndDefaultQualifiers.getType() == null) {
            TypeSystemContext typeSystem = getTypeSystem();
            TypeParameterMarker typeParameterForArgument = typeAndDefaultQualifiers.getTypeParameterForArgument();
            if ((typeParameterForArgument != null ? typeSystem.getVariance(typeParameterForArgument) : null) == TypeVariance.IN) {
                return JavaTypeQualifiers.Companion.getNONE();
            }
        }
        boolean z5 = false;
        boolean z6 = typeAndDefaultQualifiers.getTypeParameterForArgument() == null;
        KotlinTypeMarker type2 = typeAndDefaultQualifiers.getType();
        if (type2 == null || (emptyList = getAnnotations(type2)) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        TypeSystemContext typeSystem2 = getTypeSystem();
        KotlinTypeMarker type3 = typeAndDefaultQualifiers.getType();
        TypeParameterMarker typeParameterClassifier = (type3 == null || (typeConstructor = typeSystem2.typeConstructor(type3)) == null) ? null : typeSystem2.getTypeParameterClassifier(typeConstructor);
        boolean z7 = getContainerApplicabilityType() == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
        if (z6) {
            if (z7 || !getEnableImprovementsInStrictMode() || (type = typeAndDefaultQualifiers.getType()) == null || !isArrayOrPrimitiveArray(type)) {
                emptyList = CollectionsKt.plus((Iterable) getContainerAnnotations(), (Iterable) emptyList);
            } else {
                Iterable<TAnnotation> containerAnnotations = getContainerAnnotations();
                ArrayList arrayList = new ArrayList();
                for (TAnnotation tannotation : containerAnnotations) {
                    if (!getAnnotationTypeQualifierResolver().isTypeUseAnnotation(tannotation)) {
                        arrayList.add(tannotation);
                    }
                }
                emptyList = CollectionsKt.plus((Collection) arrayList, (Iterable) emptyList);
            }
        }
        MutabilityQualifier extractMutability = getAnnotationTypeQualifierResolver().extractMutability(emptyList);
        NullabilityQualifierWithMigrationStatus extractNullability = getAnnotationTypeQualifierResolver().extractNullability((Iterable) emptyList, (Function1) new Function1(this, typeAndDefaultQualifiers) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$$Lambda$0
            private final AbstractSignatureParts arg$0;
            private final AbstractSignatureParts.TypeAndDefaultQualifiers arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = typeAndDefaultQualifiers;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                boolean extractQualifiersFromAnnotations$lambda$6;
                extractQualifiersFromAnnotations$lambda$6 = AbstractSignatureParts.extractQualifiersFromAnnotations$lambda$6(this.arg$0, this.arg$1, obj);
                return Boolean.valueOf(extractQualifiersFromAnnotations$lambda$6);
            }
        });
        if (extractNullability != null) {
            NullabilityQualifier qualifier = extractNullability.getQualifier();
            if (extractNullability.getQualifier() == NullabilityQualifier.NOT_NULL && typeParameterClassifier != null) {
                z5 = true;
            }
            return new JavaTypeQualifiers(qualifier, extractMutability, z5, extractNullability.isForWarningOnly());
        }
        AnnotationQualifierApplicabilityType containerApplicabilityType = (z6 || z7) ? getContainerApplicabilityType() : AnnotationQualifierApplicabilityType.TYPE_USE;
        JavaTypeQualifiersByElementType defaultQualifiers = typeAndDefaultQualifiers.getDefaultQualifiers();
        JavaDefaultQualifiers javaDefaultQualifiers = defaultQualifiers != null ? defaultQualifiers.get(containerApplicabilityType) : null;
        NullabilityQualifierWithMigrationStatus boundsNullability = typeParameterClassifier != null ? getBoundsNullability(typeParameterClassifier) : null;
        NullabilityQualifierWithMigrationStatus defaultNullability = getDefaultNullability(boundsNullability, javaDefaultQualifiers);
        boolean z8 = (boundsNullability != null ? boundsNullability.getQualifier() : null) == NullabilityQualifier.NOT_NULL || !(typeParameterClassifier == null || javaDefaultQualifiers == null || !javaDefaultQualifiers.getDefinitelyNotNull());
        TypeParameterMarker typeParameterForArgument2 = typeAndDefaultQualifiers.getTypeParameterForArgument();
        if (typeParameterForArgument2 == null || (nullabilityQualifierWithMigrationStatus = getBoundsNullability(typeParameterForArgument2)) == null) {
            nullabilityQualifierWithMigrationStatus = null;
        } else if (nullabilityQualifierWithMigrationStatus.getQualifier() == NullabilityQualifier.NULLABLE) {
            nullabilityQualifierWithMigrationStatus = NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatus, NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null);
        }
        NullabilityQualifierWithMigrationStatus mostSpecific = mostSpecific(nullabilityQualifierWithMigrationStatus, defaultNullability);
        NullabilityQualifier qualifier2 = mostSpecific != null ? mostSpecific.getQualifier() : null;
        if (mostSpecific != null && mostSpecific.isForWarningOnly()) {
            z5 = true;
        }
        return new JavaTypeQualifiers(qualifier2, extractMutability, z8, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean extractQualifiersFromAnnotations$lambda$6(AbstractSignatureParts abstractSignatureParts, TypeAndDefaultQualifiers typeAndDefaultQualifiers, Object extractNullability) {
        Intrinsics.checkNotNullParameter(extractNullability, "$this$extractNullability");
        return abstractSignatureParts.forceWarning(extractNullability, typeAndDefaultQualifiers.getType());
    }

    private final <T> void flattenTree(T t5, List<T> list, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        list.add(t5);
        Iterable<? extends T> invoke = function1.invoke(t5);
        if (invoke != null) {
            Iterator<? extends T> it = invoke.iterator();
            while (it.hasNext()) {
                flattenTree(it.next(), list, function1);
            }
        }
    }

    private final NullabilityQualifierWithMigrationStatus getBoundsNullability(TypeParameterMarker typeParameterMarker) {
        List<KotlinTypeMarker> list;
        NullabilityQualifier nullabilityQualifier;
        TypeSystemContext typeSystem = getTypeSystem();
        if (!isFromJava(typeParameterMarker)) {
            return null;
        }
        List<KotlinTypeMarker> upperBounds = typeSystem.getUpperBounds(typeParameterMarker);
        List<KotlinTypeMarker> list2 = upperBounds;
        boolean z5 = list2 instanceof Collection;
        if (!z5 || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!typeSystem.isError((KotlinTypeMarker) it.next())) {
                    if (!z5 || !list2.isEmpty()) {
                        Iterator<T> it2 = list2.iterator();
                        while (it2.hasNext()) {
                            if (getNullabilityQualifier((KotlinTypeMarker) it2.next()) != null) {
                                list = upperBounds;
                                break;
                            }
                        }
                    }
                    if (!z5 || !list2.isEmpty()) {
                        Iterator<T> it3 = list2.iterator();
                        while (it3.hasNext()) {
                            if (getEnhancedForWarnings((KotlinTypeMarker) it3.next()) != null) {
                                list = new ArrayList<>();
                                Iterator<T> it4 = list2.iterator();
                                while (it4.hasNext()) {
                                    KotlinTypeMarker enhancedForWarnings = getEnhancedForWarnings((KotlinTypeMarker) it4.next());
                                    if (enhancedForWarnings != null) {
                                        list.add(enhancedForWarnings);
                                    }
                                }
                                List<KotlinTypeMarker> list3 = list;
                                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                                    Iterator<T> it5 = list3.iterator();
                                    while (it5.hasNext()) {
                                        if (!typeSystem.isNullableType((KotlinTypeMarker) it5.next())) {
                                            nullabilityQualifier = NullabilityQualifier.NOT_NULL;
                                            break;
                                        }
                                    }
                                }
                                nullabilityQualifier = NullabilityQualifier.NULLABLE;
                                return new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, list != upperBounds);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private final NullabilityQualifier getNullabilityQualifier(KotlinTypeMarker kotlinTypeMarker) {
        TypeSystemContext typeSystem = getTypeSystem();
        if (typeSystem.isMarkedNullable(typeSystem.lowerBoundIfFlexible(kotlinTypeMarker))) {
            return NullabilityQualifier.NULLABLE;
        }
        if (typeSystem.isMarkedNullable(typeSystem.upperBoundIfFlexible(kotlinTypeMarker))) {
            return null;
        }
        return NullabilityQualifier.NOT_NULL;
    }

    private final NullabilityQualifierWithMigrationStatus mostSpecific(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2) {
        return nullabilityQualifierWithMigrationStatus == null ? nullabilityQualifierWithMigrationStatus2 : nullabilityQualifierWithMigrationStatus2 == null ? nullabilityQualifierWithMigrationStatus : (!nullabilityQualifierWithMigrationStatus.isForWarningOnly() || nullabilityQualifierWithMigrationStatus2.isForWarningOnly()) ? (nullabilityQualifierWithMigrationStatus.isForWarningOnly() || !nullabilityQualifierWithMigrationStatus2.isForWarningOnly()) ? (nullabilityQualifierWithMigrationStatus.getQualifier().compareTo(nullabilityQualifierWithMigrationStatus2.getQualifier()) >= 0 && nullabilityQualifierWithMigrationStatus.getQualifier().compareTo(nullabilityQualifierWithMigrationStatus2.getQualifier()) > 0) ? nullabilityQualifierWithMigrationStatus : nullabilityQualifierWithMigrationStatus2 : nullabilityQualifierWithMigrationStatus : nullabilityQualifierWithMigrationStatus2;
    }

    private final List<TypeAndDefaultQualifiers> toIndexed(KotlinTypeMarker kotlinTypeMarker) {
        final TypeSystemContext typeSystem = getTypeSystem();
        return flattenTree(new TypeAndDefaultQualifiers(kotlinTypeMarker, extractAndMergeDefaultQualifiers(kotlinTypeMarker, getContainerDefaultTypeQualifiers()), null), new Function1(this, typeSystem) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$$Lambda$2
            private final AbstractSignatureParts arg$0;
            private final TypeSystemContext arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = typeSystem;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Iterable indexed$lambda$23$lambda$22;
                indexed$lambda$23$lambda$22 = AbstractSignatureParts.toIndexed$lambda$23$lambda$22(this.arg$0, this.arg$1, (AbstractSignatureParts.TypeAndDefaultQualifiers) obj);
                return indexed$lambda$23$lambda$22;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable toIndexed$lambda$23$lambda$22(AbstractSignatureParts abstractSignatureParts, TypeSystemContext typeSystemContext, TypeAndDefaultQualifiers it) {
        KotlinTypeMarker type;
        TypeConstructorMarker typeConstructor;
        List<TypeParameterMarker> parameters;
        KotlinTypeMarker type2;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((abstractSignatureParts.getSkipRawTypeArguments() && (type2 = it.getType()) != null && typeSystemContext.isRawType(type2)) || (type = it.getType()) == null || (typeConstructor = typeSystemContext.typeConstructor(type)) == null || (parameters = typeSystemContext.getParameters(typeConstructor)) == null) {
            return null;
        }
        List<TypeParameterMarker> list = parameters;
        List<TypeArgumentMarker> arguments = typeSystemContext.getArguments(it.getType());
        Iterator<T> it2 = list.iterator();
        Iterator<T> it3 = arguments.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(list, 10), CollectionsKt.collectionSizeOrDefault(arguments, 10)));
        while (it2.hasNext() && it3.hasNext()) {
            TypeParameterMarker typeParameterMarker = (TypeParameterMarker) it2.next();
            KotlinTypeMarker type3 = typeSystemContext.getType((TypeArgumentMarker) it3.next());
            arrayList.add(type3 == null ? new TypeAndDefaultQualifiers(null, it.getDefaultQualifiers(), typeParameterMarker) : new TypeAndDefaultQualifiers(type3, abstractSignatureParts.extractAndMergeDefaultQualifiers(type3, it.getDefaultQualifiers()), typeParameterMarker));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Function1<Integer, JavaTypeQualifiers> computeIndexedQualifiers(KotlinTypeMarker kotlinTypeMarker, Iterable<? extends KotlinTypeMarker> overrides, final TypeEnhancementInfo typeEnhancementInfo, boolean z5) {
        int i5;
        int i6;
        KotlinTypeMarker type;
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        List<TypeAndDefaultQualifiers> indexed = toIndexed(kotlinTypeMarker);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(overrides, 10));
        Iterator<? extends KotlinTypeMarker> it = overrides.iterator();
        while (it.hasNext()) {
            arrayList.add(toIndexed(it.next()));
        }
        if (!getForceOnlyHeadTypeConstructor()) {
            if (isCovariant() && (!(overrides instanceof Collection) || !((Collection) overrides).isEmpty())) {
                Iterator<? extends KotlinTypeMarker> it2 = overrides.iterator();
                while (it2.hasNext()) {
                    if (!isEqual(kotlinTypeMarker, it2.next())) {
                    }
                }
            }
            i5 = indexed.size();
            final JavaTypeQualifiers[] javaTypeQualifiersArr = new JavaTypeQualifiers[i5];
            i6 = 0;
            while (i6 < i5) {
                JavaTypeQualifiers extractQualifiersFromAnnotations = extractQualifiersFromAnnotations(indexed.get(i6));
                ArrayList arrayList2 = new ArrayList();
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    TypeAndDefaultQualifiers typeAndDefaultQualifiers = (TypeAndDefaultQualifiers) CollectionsKt.getOrNull((List) it3.next(), i6);
                    JavaTypeQualifiers extractQualifiers = (typeAndDefaultQualifiers == null || (type = typeAndDefaultQualifiers.getType()) == null) ? null : extractQualifiers(type);
                    if (extractQualifiers != null) {
                        arrayList2.add(extractQualifiers);
                    }
                }
                javaTypeQualifiersArr[i6] = TypeEnhancementUtilsKt.computeQualifiersForOverride(extractQualifiersFromAnnotations, arrayList2, i6 == 0 && isCovariant(), i6 == 0 && getContainerIsVarargParameter(), z5);
                i6++;
            }
            return new Function1(typeEnhancementInfo, javaTypeQualifiersArr) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$$Lambda$1
                private final TypeEnhancementInfo arg$0;
                private final JavaTypeQualifiers[] arg$1;

                {
                    this.arg$0 = typeEnhancementInfo;
                    this.arg$1 = javaTypeQualifiersArr;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    JavaTypeQualifiers computeIndexedQualifiers$lambda$18;
                    computeIndexedQualifiers$lambda$18 = AbstractSignatureParts.computeIndexedQualifiers$lambda$18(this.arg$0, this.arg$1, ((Number) obj).intValue());
                    return computeIndexedQualifiers$lambda$18;
                }
            };
        }
        i5 = 1;
        final JavaTypeQualifiers[] javaTypeQualifiersArr2 = new JavaTypeQualifiers[i5];
        i6 = 0;
        while (i6 < i5) {
        }
        return new Function1(typeEnhancementInfo, javaTypeQualifiersArr2) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$$Lambda$1
            private final TypeEnhancementInfo arg$0;
            private final JavaTypeQualifiers[] arg$1;

            {
                this.arg$0 = typeEnhancementInfo;
                this.arg$1 = javaTypeQualifiersArr2;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                JavaTypeQualifiers computeIndexedQualifiers$lambda$18;
                computeIndexedQualifiers$lambda$18 = AbstractSignatureParts.computeIndexedQualifiers$lambda$18(this.arg$0, this.arg$1, ((Number) obj).intValue());
                return computeIndexedQualifiers$lambda$18;
            }
        };
    }

    public abstract boolean forceWarning(TAnnotation tannotation, KotlinTypeMarker kotlinTypeMarker);

    public abstract AbstractAnnotationTypeQualifierResolver<TAnnotation> getAnnotationTypeQualifierResolver();

    public abstract Iterable<TAnnotation> getAnnotations(KotlinTypeMarker kotlinTypeMarker);

    public abstract Iterable<TAnnotation> getContainerAnnotations();

    public abstract AnnotationQualifierApplicabilityType getContainerApplicabilityType();

    public abstract JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers();

    public abstract boolean getContainerIsVarargParameter();

    protected abstract NullabilityQualifierWithMigrationStatus getDefaultNullability(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, JavaDefaultQualifiers javaDefaultQualifiers);

    public abstract boolean getEnableImprovementsInStrictMode();

    public abstract KotlinTypeMarker getEnhancedForWarnings(KotlinTypeMarker kotlinTypeMarker);

    public boolean getForceOnlyHeadTypeConstructor() {
        return false;
    }

    public abstract FqNameUnsafe getFqNameUnsafe(KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean getSkipRawTypeArguments();

    public abstract TypeSystemContext getTypeSystem();

    public abstract boolean isArrayOrPrimitiveArray(KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean isCovariant();

    public abstract boolean isEqual(KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2);

    public abstract boolean isFromJava(TypeParameterMarker typeParameterMarker);

    public abstract boolean isNotNullTypeParameterCompat(KotlinTypeMarker kotlinTypeMarker);

    private final <T> List<T> flattenTree(T t5, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        ArrayList arrayList = new ArrayList(1);
        flattenTree(t5, arrayList, function1);
        return arrayList;
    }
}
