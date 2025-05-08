package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* loaded from: classes3.dex */
public final class RawSubstitution extends TypeSubstitution {
    public static final Companion Companion = new Companion(null);
    private static final JavaTypeAttributes lowerTypeAttr;
    private static final JavaTypeAttributes upperTypeAttr;
    private final RawProjectionComputer projectionComputer;
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        TypeUsage typeUsage = TypeUsage.COMMON;
        lowerTypeAttr = JavaTypeAttributesKt.toAttributes$default(typeUsage, false, true, null, 5, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
        upperTypeAttr = JavaTypeAttributesKt.toAttributes$default(typeUsage, false, true, null, 5, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    }

    public RawSubstitution(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser) {
        RawProjectionComputer rawProjectionComputer = new RawProjectionComputer();
        this.projectionComputer = rawProjectionComputer;
        this.typeParameterUpperBoundEraser = typeParameterUpperBoundEraser == null ? new TypeParameterUpperBoundEraser(rawProjectionComputer, null, 2, null) : typeParameterUpperBoundEraser;
    }

    private final Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor(final SimpleType simpleType, final ClassDescriptor classDescriptor, final JavaTypeAttributes javaTypeAttributes) {
        if (simpleType.getConstructor().getParameters().isEmpty()) {
            return TuplesKt.to(simpleType, Boolean.FALSE);
        }
        if (KotlinBuiltIns.isArray(simpleType)) {
            TypeProjection typeProjection = simpleType.getArguments().get(0);
            Variance projectionKind = typeProjection.getProjectionKind();
            KotlinType type = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            return TuplesKt.to(KotlinTypeFactory.simpleType$default(simpleType.getAttributes(), simpleType.getConstructor(), CollectionsKt.listOf(new TypeProjectionImpl(projectionKind, eraseType(type, javaTypeAttributes))), simpleType.isMarkedNullable(), null, 16, null), Boolean.FALSE);
        }
        if (KotlinTypeKt.isError(simpleType)) {
            return TuplesKt.to(ErrorUtils.createErrorType(ErrorTypeKind.ERROR_RAW_TYPE, simpleType.getConstructor().toString()), Boolean.FALSE);
        }
        MemberScope memberScope = classDescriptor.getMemberScope(this);
        Intrinsics.checkNotNullExpressionValue(memberScope, "getMemberScope(...)");
        TypeAttributes attributes = simpleType.getAttributes();
        TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        List<TypeParameterDescriptor> parameters = classDescriptor.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
        List<TypeParameterDescriptor> list = parameters;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (TypeParameterDescriptor typeParameterDescriptor : list) {
            RawProjectionComputer rawProjectionComputer = this.projectionComputer;
            Intrinsics.checkNotNull(typeParameterDescriptor);
            arrayList.add(ErasureProjectionComputer.computeProjection$default(rawProjectionComputer, typeParameterDescriptor, javaTypeAttributes, this.typeParameterUpperBoundEraser, null, 8, null));
        }
        return TuplesKt.to(KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(attributes, typeConstructor, arrayList, simpleType.isMarkedNullable(), memberScope, new Function1(classDescriptor, this, simpleType, javaTypeAttributes) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution$$Lambda$0
            private final ClassDescriptor arg$0;
            private final RawSubstitution arg$1;
            private final SimpleType arg$2;
            private final JavaTypeAttributes arg$3;

            {
                this.arg$0 = classDescriptor;
                this.arg$1 = this;
                this.arg$2 = simpleType;
                this.arg$3 = javaTypeAttributes;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                SimpleType eraseInflexibleBasedOnClassDescriptor$lambda$2;
                eraseInflexibleBasedOnClassDescriptor$lambda$2 = RawSubstitution.eraseInflexibleBasedOnClassDescriptor$lambda$2(this.arg$0, this.arg$1, this.arg$2, this.arg$3, (KotlinTypeRefiner) obj);
                return eraseInflexibleBasedOnClassDescriptor$lambda$2;
            }
        }), Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleType eraseInflexibleBasedOnClassDescriptor$lambda$2(ClassDescriptor classDescriptor, RawSubstitution rawSubstitution, SimpleType simpleType, JavaTypeAttributes javaTypeAttributes, KotlinTypeRefiner kotlinTypeRefiner) {
        ClassDescriptor findClassAcrossModuleDependencies;
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        ClassId classId = DescriptorUtilsKt.getClassId(classDescriptor);
        if (classId == null || (findClassAcrossModuleDependencies = kotlinTypeRefiner.findClassAcrossModuleDependencies(classId)) == null || Intrinsics.areEqual(findClassAcrossModuleDependencies, classDescriptor)) {
            return null;
        }
        return rawSubstitution.eraseInflexibleBasedOnClassDescriptor(simpleType, findClassAcrossModuleDependencies, javaTypeAttributes).getFirst();
    }

    private final KotlinType eraseType(KotlinType kotlinType, JavaTypeAttributes javaTypeAttributes) {
        ClassifierDescriptor mo3718getDeclarationDescriptor = kotlinType.getConstructor().mo3718getDeclarationDescriptor();
        if (mo3718getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            return eraseType(this.typeParameterUpperBoundEraser.getErasedUpperBound((TypeParameterDescriptor) mo3718getDeclarationDescriptor, javaTypeAttributes.markIsRaw(true)), javaTypeAttributes);
        }
        if (!(mo3718getDeclarationDescriptor instanceof ClassDescriptor)) {
            throw new IllegalStateException(("Unexpected declaration kind: " + mo3718getDeclarationDescriptor).toString());
        }
        ClassifierDescriptor mo3718getDeclarationDescriptor2 = FlexibleTypesKt.upperIfFlexible(kotlinType).getConstructor().mo3718getDeclarationDescriptor();
        if (mo3718getDeclarationDescriptor2 instanceof ClassDescriptor) {
            Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.lowerIfFlexible(kotlinType), (ClassDescriptor) mo3718getDeclarationDescriptor, lowerTypeAttr);
            SimpleType component1 = eraseInflexibleBasedOnClassDescriptor.component1();
            boolean booleanValue = eraseInflexibleBasedOnClassDescriptor.component2().booleanValue();
            Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor2 = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.upperIfFlexible(kotlinType), (ClassDescriptor) mo3718getDeclarationDescriptor2, upperTypeAttr);
            SimpleType component12 = eraseInflexibleBasedOnClassDescriptor2.component1();
            return (booleanValue || eraseInflexibleBasedOnClassDescriptor2.component2().booleanValue()) ? new RawTypeImpl(component1, component12) : KotlinTypeFactory.flexibleType(component1, component12);
        }
        throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + mo3718getDeclarationDescriptor2 + "\" while for lower it's \"" + mo3718getDeclarationDescriptor + '\"').toString());
    }

    static /* synthetic */ KotlinType eraseType$default(RawSubstitution rawSubstitution, KotlinType kotlinType, JavaTypeAttributes javaTypeAttributes, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            javaTypeAttributes = new JavaTypeAttributes(TypeUsage.COMMON, null, false, false, null, null, 62, null);
        }
        return rawSubstitution.eraseType(kotlinType, javaTypeAttributes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* renamed from: get */
    public TypeProjectionImpl mo3723get(KotlinType key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new TypeProjectionImpl(eraseType$default(this, key, null, 2, null));
    }

    public /* synthetic */ RawSubstitution(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : typeParameterUpperBoundEraser);
    }
}
