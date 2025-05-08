package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class JavaTypeEnhancement {
    private final JavaResolverSettings javaResolverSettings;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Result {
        private final int subtreeSize;
        private final KotlinType type;

        public Result(KotlinType kotlinType, int i5) {
            this.type = kotlinType;
            this.subtreeSize = i5;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final KotlinType getType() {
            return this.type;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class SimpleResult {
        private final boolean forWarnings;
        private final int subtreeSize;
        private final SimpleType type;

        public SimpleResult(SimpleType simpleType, int i5, boolean z5) {
            this.type = simpleType;
            this.subtreeSize = i5;
            this.forWarnings = z5;
        }

        public final boolean getForWarnings() {
            return this.forWarnings;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final SimpleType getType() {
            return this.type;
        }
    }

    public JavaTypeEnhancement(JavaResolverSettings javaResolverSettings) {
        Intrinsics.checkNotNullParameter(javaResolverSettings, "javaResolverSettings");
        this.javaResolverSettings = javaResolverSettings;
    }

    private final SimpleResult enhanceInflexible(SimpleType simpleType, Function1<? super Integer, JavaTypeQualifiers> function1, int i5, TypeComponentPosition typeComponentPosition, boolean z5, boolean z6) {
        ClassifierDescriptor mo3718getDeclarationDescriptor;
        ClassifierDescriptor enhanceMutability;
        Boolean enhancedNullability;
        TypeConstructor constructor;
        EnhancedTypeAnnotations enhancedTypeAnnotations;
        Annotations compositeAnnotationsOrSingle;
        boolean z7;
        Result result;
        TypeProjection makeStarProjection;
        Function1<? super Integer, JavaTypeQualifiers> function12 = function1;
        boolean shouldEnhance = TypeComponentPositionKt.shouldEnhance(typeComponentPosition);
        boolean z8 = (z6 && z5) ? false : true;
        KotlinType kotlinType = null;
        if ((shouldEnhance || !simpleType.getArguments().isEmpty()) && (mo3718getDeclarationDescriptor = simpleType.getConstructor().mo3718getDeclarationDescriptor()) != null) {
            JavaTypeQualifiers invoke = function12.invoke(Integer.valueOf(i5));
            enhanceMutability = TypeEnhancementKt.enhanceMutability(mo3718getDeclarationDescriptor, invoke, typeComponentPosition);
            enhancedNullability = TypeEnhancementKt.getEnhancedNullability(invoke, typeComponentPosition);
            if (enhanceMutability == null || (constructor = enhanceMutability.getTypeConstructor()) == null) {
                constructor = simpleType.getConstructor();
            }
            TypeConstructor typeConstructor = constructor;
            int i6 = i5 + 1;
            List<TypeProjection> arguments = simpleType.getArguments();
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            List<TypeParameterDescriptor> list = parameters;
            Iterator<T> it = arguments.iterator();
            Iterator<T> it2 = list.iterator();
            ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(arguments, 10), CollectionsKt.collectionSizeOrDefault(list, 10)));
            while (it.hasNext() && it2.hasNext()) {
                Object next = it.next();
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) it2.next();
                TypeProjection typeProjection = (TypeProjection) next;
                if (z8) {
                    z7 = z8;
                    if (!typeProjection.isStarProjection()) {
                        result = enhancePossiblyFlexible(typeProjection.getType().unwrap(), function12, i6, z6);
                    } else if (function12.invoke(Integer.valueOf(i6)).getNullability() == NullabilityQualifier.FORCE_FLEXIBILITY) {
                        UnwrappedType unwrap = typeProjection.getType().unwrap();
                        result = new Result(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(unwrap).makeNullableAsSpecified(false), FlexibleTypesKt.upperIfFlexible(unwrap).makeNullableAsSpecified(true)), 1);
                    } else {
                        result = new Result(null, 1);
                    }
                } else {
                    z7 = z8;
                    result = new Result(kotlinType, 0);
                }
                i6 += result.getSubtreeSize();
                if (result.getType() != null) {
                    KotlinType type = result.getType();
                    Variance projectionKind = typeProjection.getProjectionKind();
                    Intrinsics.checkNotNullExpressionValue(projectionKind, "getProjectionKind(...)");
                    makeStarProjection = TypeUtilsKt.createProjection(type, projectionKind, typeParameterDescriptor);
                } else if (enhanceMutability == null || typeProjection.isStarProjection()) {
                    makeStarProjection = enhanceMutability != null ? TypeUtils.makeStarProjection(typeParameterDescriptor) : null;
                } else {
                    KotlinType type2 = typeProjection.getType();
                    Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                    Variance projectionKind2 = typeProjection.getProjectionKind();
                    Intrinsics.checkNotNullExpressionValue(projectionKind2, "getProjectionKind(...)");
                    makeStarProjection = TypeUtilsKt.createProjection(type2, projectionKind2, typeParameterDescriptor);
                }
                arrayList.add(makeStarProjection);
                function12 = function1;
                z8 = z7;
                kotlinType = null;
            }
            int i7 = i6 - i5;
            if (enhanceMutability == null && enhancedNullability == null) {
                if (!arrayList.isEmpty()) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        if (((TypeProjection) it3.next()) == null) {
                        }
                    }
                }
                return new SimpleResult(null, i7, false);
            }
            Annotations annotations = simpleType.getAnnotations();
            enhancedTypeAnnotations = TypeEnhancementKt.ENHANCED_MUTABILITY_ANNOTATIONS;
            if (enhanceMutability == null) {
                enhancedTypeAnnotations = null;
            }
            boolean z9 = false;
            compositeAnnotationsOrSingle = TypeEnhancementKt.compositeAnnotationsOrSingle(CollectionsKt.listOfNotNull((Object[]) new Annotations[]{annotations, enhancedTypeAnnotations, enhancedNullability != null ? TypeEnhancementKt.getENHANCED_NULLABILITY_ANNOTATIONS() : null}));
            TypeAttributes defaultAttributes = TypeAttributesKt.toDefaultAttributes(compositeAnnotationsOrSingle);
            List<TypeProjection> arguments2 = simpleType.getArguments();
            Iterator it4 = arrayList.iterator();
            Iterator<T> it5 = arguments2.iterator();
            ArrayList arrayList2 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(arrayList, 10), CollectionsKt.collectionSizeOrDefault(arguments2, 10)));
            while (it4.hasNext() && it5.hasNext()) {
                Object next2 = it4.next();
                TypeProjection typeProjection2 = (TypeProjection) it5.next();
                TypeProjection typeProjection3 = (TypeProjection) next2;
                if (typeProjection3 != null) {
                    typeProjection2 = typeProjection3;
                }
                arrayList2.add(typeProjection2);
            }
            SimpleType simpleType$default = KotlinTypeFactory.simpleType$default(defaultAttributes, typeConstructor, arrayList2, enhancedNullability != null ? enhancedNullability.booleanValue() : simpleType.isMarkedNullable(), null, 16, null);
            if (invoke.getDefinitelyNotNull()) {
                simpleType$default = notNullTypeParameter(simpleType$default);
            }
            if (enhancedNullability != null && invoke.isNullabilityQualifierForWarning()) {
                z9 = true;
            }
            return new SimpleResult(simpleType$default, i7, z9);
        }
        return new SimpleResult(null, 1, false);
    }

    static /* synthetic */ SimpleResult enhanceInflexible$default(JavaTypeEnhancement javaTypeEnhancement, SimpleType simpleType, Function1 function1, int i5, TypeComponentPosition typeComponentPosition, boolean z5, boolean z6, int i6, Object obj) {
        return javaTypeEnhancement.enhanceInflexible(simpleType, function1, i5, typeComponentPosition, (i6 & 8) != 0 ? false : z5, (i6 & 16) != 0 ? false : z6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0096, code lost:
    
        if (r13 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Result enhancePossiblyFlexible(UnwrappedType unwrappedType, Function1<? super Integer, JavaTypeQualifiers> function1, int i5, boolean z5) {
        KotlinType type;
        KotlinType kotlinType = null;
        if (KotlinTypeKt.isError(unwrappedType)) {
            return new Result(null, 1);
        }
        if (!(unwrappedType instanceof FlexibleType)) {
            if (!(unwrappedType instanceof SimpleType)) {
                throw new NoWhenBranchMatchedException();
            }
            SimpleResult enhanceInflexible$default = enhanceInflexible$default(this, (SimpleType) unwrappedType, function1, i5, TypeComponentPosition.INFLEXIBLE, false, z5, 8, null);
            return new Result(enhanceInflexible$default.getForWarnings() ? TypeWithEnhancementKt.wrapEnhancement(unwrappedType, enhanceInflexible$default.getType()) : enhanceInflexible$default.getType(), enhanceInflexible$default.getSubtreeSize());
        }
        boolean z6 = unwrappedType instanceof RawType;
        FlexibleType flexibleType = (FlexibleType) unwrappedType;
        SimpleResult enhanceInflexible = enhanceInflexible(flexibleType.getLowerBound(), function1, i5, TypeComponentPosition.FLEXIBLE_LOWER, z6, z5);
        SimpleResult enhanceInflexible2 = enhanceInflexible(flexibleType.getUpperBound(), function1, i5, TypeComponentPosition.FLEXIBLE_UPPER, z6, z5);
        enhanceInflexible.getSubtreeSize();
        enhanceInflexible2.getSubtreeSize();
        if (enhanceInflexible.getType() != null || enhanceInflexible2.getType() != null) {
            if (enhanceInflexible.getForWarnings() || enhanceInflexible2.getForWarnings()) {
                SimpleType type2 = enhanceInflexible2.getType();
                if (type2 != null) {
                    SimpleType type3 = enhanceInflexible.getType();
                    if (type3 == null) {
                        type3 = type2;
                    }
                    type = KotlinTypeFactory.flexibleType(type3, type2);
                }
                type = enhanceInflexible.getType();
                Intrinsics.checkNotNull(type);
                kotlinType = TypeWithEnhancementKt.wrapEnhancement(unwrappedType, type);
            } else if (z6) {
                SimpleType type4 = enhanceInflexible.getType();
                if (type4 == null) {
                    type4 = flexibleType.getLowerBound();
                }
                SimpleType type5 = enhanceInflexible2.getType();
                if (type5 == null) {
                    type5 = flexibleType.getUpperBound();
                }
                kotlinType = new RawTypeImpl(type4, type5);
            } else {
                SimpleType type6 = enhanceInflexible.getType();
                if (type6 == null) {
                    type6 = flexibleType.getLowerBound();
                }
                SimpleType type7 = enhanceInflexible2.getType();
                if (type7 == null) {
                    type7 = flexibleType.getUpperBound();
                }
                kotlinType = KotlinTypeFactory.flexibleType(type6, type7);
            }
        }
        return new Result(kotlinType, enhanceInflexible.getSubtreeSize());
    }

    private final SimpleType notNullTypeParameter(SimpleType simpleType) {
        return this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter() ? SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, true) : new NotNullTypeParameterImpl(simpleType);
    }

    public final KotlinType enhance(KotlinType kotlinType, Function1<? super Integer, JavaTypeQualifiers> qualifiers, boolean z5) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(qualifiers, "qualifiers");
        return enhancePossiblyFlexible(kotlinType.unwrap(), qualifiers, 0, z5).getType();
    }
}
