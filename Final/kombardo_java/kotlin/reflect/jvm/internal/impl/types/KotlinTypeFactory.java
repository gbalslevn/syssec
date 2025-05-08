package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptorKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* loaded from: classes3.dex */
public final class KotlinTypeFactory {
    public static final KotlinTypeFactory INSTANCE = new KotlinTypeFactory();
    private static final Function1<KotlinTypeRefiner, SimpleType> EMPTY_REFINED_TYPE_FACTORY = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1
        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "<unused var>");
            return null;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ExpandedTypeOrRefinedConstructor {
        private final SimpleType expandedType;
        private final TypeConstructor refinedConstructor;

        public ExpandedTypeOrRefinedConstructor(SimpleType simpleType, TypeConstructor typeConstructor) {
            this.expandedType = simpleType;
            this.refinedConstructor = typeConstructor;
        }

        public final SimpleType getExpandedType() {
            return this.expandedType;
        }

        public final TypeConstructor getRefinedConstructor() {
            return this.refinedConstructor;
        }
    }

    private KotlinTypeFactory() {
    }

    public static final SimpleType computeExpandedType(TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> arguments) {
        Intrinsics.checkNotNullParameter(typeAliasDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        return new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false).expand(TypeAliasExpansion.Companion.create(null, typeAliasDescriptor, arguments), TypeAttributes.Companion.getEmpty());
    }

    private final MemberScope computeMemberScope(TypeConstructor typeConstructor, List<? extends TypeProjection> list, KotlinTypeRefiner kotlinTypeRefiner) {
        ClassifierDescriptor mo3718getDeclarationDescriptor = typeConstructor.mo3718getDeclarationDescriptor();
        if (mo3718getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            return ((TypeParameterDescriptor) mo3718getDeclarationDescriptor).getDefaultType().getMemberScope();
        }
        if (mo3718getDeclarationDescriptor instanceof ClassDescriptor) {
            if (kotlinTypeRefiner == null) {
                kotlinTypeRefiner = DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtilsKt.getModule(mo3718getDeclarationDescriptor));
            }
            return list.isEmpty() ? ModuleAwareClassDescriptorKt.getRefinedUnsubstitutedMemberScopeIfPossible((ClassDescriptor) mo3718getDeclarationDescriptor, kotlinTypeRefiner) : ModuleAwareClassDescriptorKt.getRefinedMemberScopeIfPossible((ClassDescriptor) mo3718getDeclarationDescriptor, TypeConstructorSubstitution.Companion.create(typeConstructor, list), kotlinTypeRefiner);
        }
        if (mo3718getDeclarationDescriptor instanceof TypeAliasDescriptor) {
            return ErrorUtils.createErrorScope(ErrorScopeKind.SCOPE_FOR_ABBREVIATION_TYPE, true, ((TypeAliasDescriptor) mo3718getDeclarationDescriptor).getName().toString());
        }
        if (typeConstructor instanceof IntersectionTypeConstructor) {
            return ((IntersectionTypeConstructor) typeConstructor).createScopeForKotlinType();
        }
        throw new IllegalStateException("Unsupported classifier: " + mo3718getDeclarationDescriptor + " for constructor: " + typeConstructor);
    }

    public static final UnwrappedType flexibleType(SimpleType lowerBound, SimpleType upperBound) {
        Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        Intrinsics.checkNotNullParameter(upperBound, "upperBound");
        return Intrinsics.areEqual(lowerBound, upperBound) ? lowerBound : new FlexibleTypeImpl(lowerBound, upperBound);
    }

    public static final SimpleType integerLiteralType(TypeAttributes attributes, IntegerLiteralTypeConstructor constructor, boolean z5) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        return simpleTypeWithNonTrivialMemberScope(attributes, constructor, CollectionsKt.emptyList(), z5, ErrorUtils.createErrorScope(ErrorScopeKind.INTEGER_LITERAL_TYPE_SCOPE, true, "unknown integer literal type"));
    }

    private final ExpandedTypeOrRefinedConstructor refineConstructor(TypeConstructor typeConstructor, KotlinTypeRefiner kotlinTypeRefiner, List<? extends TypeProjection> list) {
        ClassifierDescriptor refineDescriptor;
        ClassifierDescriptor mo3718getDeclarationDescriptor = typeConstructor.mo3718getDeclarationDescriptor();
        if (mo3718getDeclarationDescriptor == null || (refineDescriptor = kotlinTypeRefiner.refineDescriptor(mo3718getDeclarationDescriptor)) == null) {
            return null;
        }
        if (refineDescriptor instanceof TypeAliasDescriptor) {
            return new ExpandedTypeOrRefinedConstructor(computeExpandedType((TypeAliasDescriptor) refineDescriptor, list), null);
        }
        TypeConstructor refine = refineDescriptor.getTypeConstructor().refine(kotlinTypeRefiner);
        Intrinsics.checkNotNullExpressionValue(refine, "refine(...)");
        return new ExpandedTypeOrRefinedConstructor(null, refine);
    }

    public static final SimpleType simpleNotNullType(TypeAttributes attributes, ClassDescriptor descriptor, List<? extends TypeProjection> arguments) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        TypeConstructor typeConstructor = descriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return simpleType$default(attributes, typeConstructor, arguments, false, null, 16, null);
    }

    public static final SimpleType simpleType(TypeAttributes attributes, TypeConstructor constructor, List<? extends TypeProjection> arguments, boolean z5) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        return simpleType$default(attributes, constructor, arguments, z5, null, 16, null);
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeAttributes typeAttributes, TypeConstructor typeConstructor, List list, boolean z5, KotlinTypeRefiner kotlinTypeRefiner, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            kotlinTypeRefiner = null;
        }
        return simpleType(typeAttributes, typeConstructor, list, z5, kotlinTypeRefiner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleType simpleType$lambda$1(TypeConstructor typeConstructor, List list, TypeAttributes typeAttributes, boolean z5, KotlinTypeRefiner refiner) {
        Intrinsics.checkNotNullParameter(refiner, "refiner");
        ExpandedTypeOrRefinedConstructor refineConstructor = INSTANCE.refineConstructor(typeConstructor, refiner, list);
        if (refineConstructor == null) {
            return null;
        }
        SimpleType expandedType = refineConstructor.getExpandedType();
        if (expandedType != null) {
            return expandedType;
        }
        TypeConstructor refinedConstructor = refineConstructor.getRefinedConstructor();
        Intrinsics.checkNotNull(refinedConstructor);
        return simpleType(typeAttributes, refinedConstructor, list, z5, refiner);
    }

    public static final SimpleType simpleTypeWithNonTrivialMemberScope(final TypeAttributes attributes, final TypeConstructor constructor, final List<? extends TypeProjection> arguments, final boolean z5, final MemberScope memberScope) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        SimpleTypeImpl simpleTypeImpl = new SimpleTypeImpl(constructor, arguments, z5, memberScope, new Function1(constructor, arguments, attributes, z5, memberScope) { // from class: kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$$Lambda$1
            private final TypeConstructor arg$0;
            private final List arg$1;
            private final TypeAttributes arg$2;
            private final boolean arg$3;
            private final MemberScope arg$4;

            {
                this.arg$0 = constructor;
                this.arg$1 = arguments;
                this.arg$2 = attributes;
                this.arg$3 = z5;
                this.arg$4 = memberScope;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                SimpleType simpleTypeWithNonTrivialMemberScope$lambda$4;
                simpleTypeWithNonTrivialMemberScope$lambda$4 = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope$lambda$4(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4, (KotlinTypeRefiner) obj);
                return simpleTypeWithNonTrivialMemberScope$lambda$4;
            }
        });
        return attributes.isEmpty() ? simpleTypeImpl : new SimpleTypeWithAttributes(simpleTypeImpl, attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleType simpleTypeWithNonTrivialMemberScope$lambda$4(TypeConstructor typeConstructor, List list, TypeAttributes typeAttributes, boolean z5, MemberScope memberScope, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        ExpandedTypeOrRefinedConstructor refineConstructor = INSTANCE.refineConstructor(typeConstructor, kotlinTypeRefiner, list);
        if (refineConstructor == null) {
            return null;
        }
        SimpleType expandedType = refineConstructor.getExpandedType();
        if (expandedType != null) {
            return expandedType;
        }
        TypeConstructor refinedConstructor = refineConstructor.getRefinedConstructor();
        Intrinsics.checkNotNull(refinedConstructor);
        return simpleTypeWithNonTrivialMemberScope(typeAttributes, refinedConstructor, list, z5, memberScope);
    }

    public static final SimpleType simpleType(final TypeAttributes attributes, final TypeConstructor constructor, final List<? extends TypeProjection> arguments, final boolean z5, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (attributes.isEmpty() && arguments.isEmpty() && !z5 && constructor.mo3718getDeclarationDescriptor() != null) {
            ClassifierDescriptor mo3718getDeclarationDescriptor = constructor.mo3718getDeclarationDescriptor();
            Intrinsics.checkNotNull(mo3718getDeclarationDescriptor);
            SimpleType defaultType = mo3718getDeclarationDescriptor.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
            return defaultType;
        }
        return simpleTypeWithNonTrivialMemberScope(attributes, constructor, arguments, z5, INSTANCE.computeMemberScope(constructor, arguments, kotlinTypeRefiner), new Function1(constructor, arguments, attributes, z5) { // from class: kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$$Lambda$0
            private final TypeConstructor arg$0;
            private final List arg$1;
            private final TypeAttributes arg$2;
            private final boolean arg$3;

            {
                this.arg$0 = constructor;
                this.arg$1 = arguments;
                this.arg$2 = attributes;
                this.arg$3 = z5;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                SimpleType simpleType$lambda$1;
                simpleType$lambda$1 = KotlinTypeFactory.simpleType$lambda$1(this.arg$0, this.arg$1, this.arg$2, this.arg$3, (KotlinTypeRefiner) obj);
                return simpleType$lambda$1;
            }
        });
    }

    public static final SimpleType simpleTypeWithNonTrivialMemberScope(TypeAttributes attributes, TypeConstructor constructor, List<? extends TypeProjection> arguments, boolean z5, MemberScope memberScope, Function1<? super KotlinTypeRefiner, ? extends SimpleType> refinedTypeFactory) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        Intrinsics.checkNotNullParameter(refinedTypeFactory, "refinedTypeFactory");
        SimpleTypeImpl simpleTypeImpl = new SimpleTypeImpl(constructor, arguments, z5, memberScope, refinedTypeFactory);
        return attributes.isEmpty() ? simpleTypeImpl : new SimpleTypeWithAttributes(simpleTypeImpl, attributes);
    }
}
