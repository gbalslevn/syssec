package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.checker.IntersectionTypeKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class TypeParameterUpperBoundEraser {
    public static final Companion Companion = new Companion(null);
    private final Lazy erroneousErasedBound$delegate;
    private final MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> getErasedUpperBound;
    private final TypeParameterErasureOptions options;
    private final ErasureProjectionComputer projectionComputer;
    private final LockBasedStorageManager storage;

    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KotlinType replaceArgumentsOfUpperBound(KotlinType kotlinType, TypeSubstitutor substitutor, Set<? extends TypeParameterDescriptor> set, boolean z5) {
            UnwrappedType unwrappedType;
            KotlinType type;
            KotlinType type2;
            KotlinType type3;
            Intrinsics.checkNotNullParameter(kotlinType, "<this>");
            Intrinsics.checkNotNullParameter(substitutor, "substitutor");
            UnwrappedType unwrap = kotlinType.unwrap();
            if (unwrap instanceof FlexibleType) {
                FlexibleType flexibleType = (FlexibleType) unwrap;
                SimpleType lowerBound = flexibleType.getLowerBound();
                if (!lowerBound.getConstructor().getParameters().isEmpty() && lowerBound.getConstructor().mo3718getDeclarationDescriptor() != null) {
                    List<TypeParameterDescriptor> parameters = lowerBound.getConstructor().getParameters();
                    Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
                    List<TypeParameterDescriptor> list = parameters;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (TypeParameterDescriptor typeParameterDescriptor : list) {
                        TypeProjection typeProjection = (TypeProjection) CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor.getIndex());
                        if (!z5 || typeProjection == null || (type3 = typeProjection.getType()) == null || TypeUtilsKt.containsTypeParameter(type3)) {
                            boolean z6 = set != null && set.contains(typeParameterDescriptor);
                            if (typeProjection != null && !z6) {
                                TypeSubstitution substitution = substitutor.getSubstitution();
                                KotlinType type4 = typeProjection.getType();
                                Intrinsics.checkNotNullExpressionValue(type4, "getType(...)");
                                if (substitution.mo3723get(type4) != null) {
                                }
                            }
                            typeProjection = new StarProjectionImpl(typeParameterDescriptor);
                        }
                        arrayList.add(typeProjection);
                    }
                    lowerBound = TypeSubstitutionKt.replace$default(lowerBound, arrayList, null, 2, null);
                }
                SimpleType upperBound = flexibleType.getUpperBound();
                if (!upperBound.getConstructor().getParameters().isEmpty() && upperBound.getConstructor().mo3718getDeclarationDescriptor() != null) {
                    List<TypeParameterDescriptor> parameters2 = upperBound.getConstructor().getParameters();
                    Intrinsics.checkNotNullExpressionValue(parameters2, "getParameters(...)");
                    List<TypeParameterDescriptor> list2 = parameters2;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (TypeParameterDescriptor typeParameterDescriptor2 : list2) {
                        TypeProjection typeProjection2 = (TypeProjection) CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor2.getIndex());
                        if (!z5 || typeProjection2 == null || (type2 = typeProjection2.getType()) == null || TypeUtilsKt.containsTypeParameter(type2)) {
                            boolean z7 = set != null && set.contains(typeParameterDescriptor2);
                            if (typeProjection2 != null && !z7) {
                                TypeSubstitution substitution2 = substitutor.getSubstitution();
                                KotlinType type5 = typeProjection2.getType();
                                Intrinsics.checkNotNullExpressionValue(type5, "getType(...)");
                                if (substitution2.mo3723get(type5) != null) {
                                }
                            }
                            typeProjection2 = new StarProjectionImpl(typeParameterDescriptor2);
                        }
                        arrayList2.add(typeProjection2);
                    }
                    upperBound = TypeSubstitutionKt.replace$default(upperBound, arrayList2, null, 2, null);
                }
                unwrappedType = KotlinTypeFactory.flexibleType(lowerBound, upperBound);
            } else {
                if (!(unwrap instanceof SimpleType)) {
                    throw new NoWhenBranchMatchedException();
                }
                SimpleType simpleType = (SimpleType) unwrap;
                if (simpleType.getConstructor().getParameters().isEmpty() || simpleType.getConstructor().mo3718getDeclarationDescriptor() == null) {
                    unwrappedType = simpleType;
                } else {
                    List<TypeParameterDescriptor> parameters3 = simpleType.getConstructor().getParameters();
                    Intrinsics.checkNotNullExpressionValue(parameters3, "getParameters(...)");
                    List<TypeParameterDescriptor> list3 = parameters3;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                    for (TypeParameterDescriptor typeParameterDescriptor3 : list3) {
                        TypeProjection typeProjection3 = (TypeProjection) CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor3.getIndex());
                        if (!z5 || typeProjection3 == null || (type = typeProjection3.getType()) == null || TypeUtilsKt.containsTypeParameter(type)) {
                            boolean z8 = set != null && set.contains(typeParameterDescriptor3);
                            if (typeProjection3 != null && !z8) {
                                TypeSubstitution substitution3 = substitutor.getSubstitution();
                                KotlinType type6 = typeProjection3.getType();
                                Intrinsics.checkNotNullExpressionValue(type6, "getType(...)");
                                if (substitution3.mo3723get(type6) != null) {
                                }
                            }
                            typeProjection3 = new StarProjectionImpl(typeParameterDescriptor3);
                        }
                        arrayList3.add(typeProjection3);
                    }
                    unwrappedType = TypeSubstitutionKt.replace$default(simpleType, arrayList3, null, 2, null);
                }
            }
            KotlinType safeSubstitute = substitutor.safeSubstitute(TypeWithEnhancementKt.inheritEnhancement(unwrappedType, unwrap), Variance.OUT_VARIANCE);
            Intrinsics.checkNotNullExpressionValue(safeSubstitute, "safeSubstitute(...)");
            return safeSubstitute;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class DataToEraseUpperBound {
        private final ErasureTypeAttributes typeAttr;
        private final TypeParameterDescriptor typeParameter;

        public DataToEraseUpperBound(TypeParameterDescriptor typeParameter, ErasureTypeAttributes typeAttr) {
            Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
            Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
            this.typeParameter = typeParameter;
            this.typeAttr = typeAttr;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof DataToEraseUpperBound)) {
                return false;
            }
            DataToEraseUpperBound dataToEraseUpperBound = (DataToEraseUpperBound) obj;
            return Intrinsics.areEqual(dataToEraseUpperBound.typeParameter, this.typeParameter) && Intrinsics.areEqual(dataToEraseUpperBound.typeAttr, this.typeAttr);
        }

        public final ErasureTypeAttributes getTypeAttr() {
            return this.typeAttr;
        }

        public final TypeParameterDescriptor getTypeParameter() {
            return this.typeParameter;
        }

        public int hashCode() {
            int hashCode = this.typeParameter.hashCode();
            return hashCode + (hashCode * 31) + this.typeAttr.hashCode();
        }

        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.typeParameter + ", typeAttr=" + this.typeAttr + ')';
        }
    }

    public TypeParameterUpperBoundEraser(ErasureProjectionComputer projectionComputer, TypeParameterErasureOptions options) {
        Intrinsics.checkNotNullParameter(projectionComputer, "projectionComputer");
        Intrinsics.checkNotNullParameter(options, "options");
        this.projectionComputer = projectionComputer;
        this.options = options;
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Type parameter upper bound erasure results");
        this.storage = lockBasedStorageManager;
        this.erroneousErasedBound$delegate = LazyKt.lazy(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser$$Lambda$0
            private final TypeParameterUpperBoundEraser arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                ErrorType erroneousErasedBound_delegate$lambda$0;
                erroneousErasedBound_delegate$lambda$0 = TypeParameterUpperBoundEraser.erroneousErasedBound_delegate$lambda$0(this.arg$0);
                return erroneousErasedBound_delegate$lambda$0;
            }
        });
        MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> createMemoizedFunction = lockBasedStorageManager.createMemoizedFunction(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser$$Lambda$1
            private final TypeParameterUpperBoundEraser arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                KotlinType erasedUpperBound$lambda$2;
                erasedUpperBound$lambda$2 = TypeParameterUpperBoundEraser.getErasedUpperBound$lambda$2(this.arg$0, (TypeParameterUpperBoundEraser.DataToEraseUpperBound) obj);
                return erasedUpperBound$lambda$2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(createMemoizedFunction, "createMemoizedFunction(...)");
        this.getErasedUpperBound = createMemoizedFunction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ErrorType erroneousErasedBound_delegate$lambda$0(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser) {
        return ErrorUtils.createErrorType(ErrorTypeKind.CANNOT_COMPUTE_ERASED_BOUND, typeParameterUpperBoundEraser.toString());
    }

    private final KotlinType getDefaultType(ErasureTypeAttributes erasureTypeAttributes) {
        KotlinType replaceArgumentsWithStarProjections;
        SimpleType defaultType = erasureTypeAttributes.getDefaultType();
        return (defaultType == null || (replaceArgumentsWithStarProjections = TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType)) == null) ? getErroneousErasedBound() : replaceArgumentsWithStarProjections;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType getErasedUpperBound$lambda$2(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, DataToEraseUpperBound dataToEraseUpperBound) {
        return typeParameterUpperBoundEraser.getErasedUpperBoundInternal(dataToEraseUpperBound.getTypeParameter(), dataToEraseUpperBound.getTypeAttr());
    }

    private final KotlinType getErasedUpperBoundInternal(TypeParameterDescriptor typeParameterDescriptor, ErasureTypeAttributes erasureTypeAttributes) {
        TypeProjection computeProjection;
        Set<TypeParameterDescriptor> visitedTypeParameters = erasureTypeAttributes.getVisitedTypeParameters();
        if (visitedTypeParameters != null && visitedTypeParameters.contains(typeParameterDescriptor.getOriginal())) {
            return getDefaultType(erasureTypeAttributes);
        }
        SimpleType defaultType = typeParameterDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
        Set<TypeParameterDescriptor> extractTypeParametersFromUpperBounds = TypeUtilsKt.extractTypeParametersFromUpperBounds(defaultType, visitedTypeParameters);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(extractTypeParametersFromUpperBounds, 10)), 16));
        for (TypeParameterDescriptor typeParameterDescriptor2 : extractTypeParametersFromUpperBounds) {
            if (visitedTypeParameters == null || !visitedTypeParameters.contains(typeParameterDescriptor2)) {
                computeProjection = this.projectionComputer.computeProjection(typeParameterDescriptor2, erasureTypeAttributes, this, getErasedUpperBound(typeParameterDescriptor2, erasureTypeAttributes.withNewVisitedTypeParameter(typeParameterDescriptor)));
            } else {
                computeProjection = TypeUtils.makeStarProjection(typeParameterDescriptor2, erasureTypeAttributes);
                Intrinsics.checkNotNullExpressionValue(computeProjection, "makeStarProjection(...)");
            }
            Pair pair = TuplesKt.to(typeParameterDescriptor2.getTypeConstructor(), computeProjection);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        TypeSubstitutor create = TypeSubstitutor.create(TypeConstructorSubstitution.Companion.createByConstructorsMap$default(TypeConstructorSubstitution.Companion, linkedHashMap, false, 2, null));
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
        Set<KotlinType> substituteErasedUpperBounds = substituteErasedUpperBounds(create, upperBounds, erasureTypeAttributes);
        if (substituteErasedUpperBounds.isEmpty()) {
            return getDefaultType(erasureTypeAttributes);
        }
        if (!this.options.getIntersectUpperBounds()) {
            if (substituteErasedUpperBounds.size() == 1) {
                return (KotlinType) CollectionsKt.single(substituteErasedUpperBounds);
            }
            throw new IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds");
        }
        List list = CollectionsKt.toList(substituteErasedUpperBounds);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((KotlinType) it.next()).unwrap());
        }
        return IntersectionTypeKt.intersectTypes(arrayList);
    }

    private final ErrorType getErroneousErasedBound() {
        return (ErrorType) this.erroneousErasedBound$delegate.getValue();
    }

    private final Set<KotlinType> substituteErasedUpperBounds(TypeSubstitutor typeSubstitutor, List<? extends KotlinType> list, ErasureTypeAttributes erasureTypeAttributes) {
        Set createSetBuilder = SetsKt.createSetBuilder();
        for (KotlinType kotlinType : list) {
            ClassifierDescriptor mo3718getDeclarationDescriptor = kotlinType.getConstructor().mo3718getDeclarationDescriptor();
            if (mo3718getDeclarationDescriptor instanceof ClassDescriptor) {
                createSetBuilder.add(Companion.replaceArgumentsOfUpperBound(kotlinType, typeSubstitutor, erasureTypeAttributes.getVisitedTypeParameters(), this.options.getLeaveNonTypeParameterTypes()));
            } else if (mo3718getDeclarationDescriptor instanceof TypeParameterDescriptor) {
                Set<TypeParameterDescriptor> visitedTypeParameters = erasureTypeAttributes.getVisitedTypeParameters();
                if (visitedTypeParameters == null || !visitedTypeParameters.contains(mo3718getDeclarationDescriptor)) {
                    List<KotlinType> upperBounds = ((TypeParameterDescriptor) mo3718getDeclarationDescriptor).getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                    createSetBuilder.addAll(substituteErasedUpperBounds(typeSubstitutor, upperBounds, erasureTypeAttributes));
                } else {
                    createSetBuilder.add(getDefaultType(erasureTypeAttributes));
                }
            }
            if (!this.options.getIntersectUpperBounds()) {
                break;
            }
        }
        return SetsKt.build(createSetBuilder);
    }

    public final KotlinType getErasedUpperBound(TypeParameterDescriptor typeParameter, ErasureTypeAttributes typeAttr) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
        KotlinType invoke = this.getErasedUpperBound.invoke(new DataToEraseUpperBound(typeParameter, typeAttr));
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return invoke;
    }

    public /* synthetic */ TypeParameterUpperBoundEraser(ErasureProjectionComputer erasureProjectionComputer, TypeParameterErasureOptions typeParameterErasureOptions, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(erasureProjectionComputer, (i5 & 2) != 0 ? new TypeParameterErasureOptions(false, false) : typeParameterErasureOptions);
    }
}
