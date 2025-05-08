package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;

/* loaded from: classes3.dex */
public final class DefinitelyNotNullType extends DelegatingSimpleType implements CustomTypeParameter, DefinitelyNotNullTypeMarker {
    public static final Companion Companion = new Companion(null);
    private final SimpleType original;
    private final boolean useCorrectedNullabilityForTypeParameters;

    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean canHaveUndefinedNullability(UnwrappedType unwrappedType) {
            unwrappedType.getConstructor();
            return (unwrappedType.getConstructor().mo3718getDeclarationDescriptor() instanceof TypeParameterDescriptor) || (unwrappedType instanceof NewCapturedType);
        }

        public static /* synthetic */ DefinitelyNotNullType makeDefinitelyNotNull$default(Companion companion, UnwrappedType unwrappedType, boolean z5, boolean z6, int i5, Object obj) {
            if ((i5 & 2) != 0) {
                z5 = false;
            }
            if ((i5 & 4) != 0) {
                z6 = false;
            }
            return companion.makeDefinitelyNotNull(unwrappedType, z5, z6);
        }

        private final boolean makesSenseToBeDefinitelyNotNull(UnwrappedType unwrappedType, boolean z5) {
            if (!canHaveUndefinedNullability(unwrappedType)) {
                return false;
            }
            ClassifierDescriptor mo3718getDeclarationDescriptor = unwrappedType.getConstructor().mo3718getDeclarationDescriptor();
            TypeParameterDescriptorImpl typeParameterDescriptorImpl = mo3718getDeclarationDescriptor instanceof TypeParameterDescriptorImpl ? (TypeParameterDescriptorImpl) mo3718getDeclarationDescriptor : null;
            if (typeParameterDescriptorImpl == null || typeParameterDescriptorImpl.isInitialized()) {
                return (z5 && (unwrappedType.getConstructor().mo3718getDeclarationDescriptor() instanceof TypeParameterDescriptor)) ? TypeUtils.isNullableType(unwrappedType) : !NullabilityChecker.INSTANCE.isSubtypeOfAny(unwrappedType);
            }
            return true;
        }

        public final DefinitelyNotNullType makeDefinitelyNotNull(UnwrappedType type, boolean z5, boolean z6) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (type instanceof DefinitelyNotNullType) {
                return (DefinitelyNotNullType) type;
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (!z6 && !makesSenseToBeDefinitelyNotNull(type, z5)) {
                return null;
            }
            if (type instanceof FlexibleType) {
                FlexibleType flexibleType = (FlexibleType) type;
                Intrinsics.areEqual(flexibleType.getLowerBound().getConstructor(), flexibleType.getUpperBound().getConstructor());
            }
            return new DefinitelyNotNullType(FlexibleTypesKt.lowerIfFlexible(type).makeNullableAsSpecified(false), z5, defaultConstructorMarker);
        }

        private Companion() {
        }
    }

    public /* synthetic */ DefinitelyNotNullType(SimpleType simpleType, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(simpleType, z5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    protected SimpleType getDelegate() {
        return this.original;
    }

    public final SimpleType getOriginal() {
        return this.original;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public boolean isTypeParameter() {
        getDelegate().getConstructor();
        return getDelegate().getConstructor().mo3718getDeclarationDescriptor() instanceof TypeParameterDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public KotlinType substitutionResult(KotlinType replacement) {
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull(replacement.unwrap(), this.useCorrectedNullabilityForTypeParameters);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public String toString() {
        return getDelegate() + " & Any";
    }

    private DefinitelyNotNullType(SimpleType simpleType, boolean z5) {
        this.original = simpleType;
        this.useCorrectedNullabilityForTypeParameters = z5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean z5) {
        return z5 ? getDelegate().makeNullableAsSpecified(z5) : this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAttributes(TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new DefinitelyNotNullType(getDelegate().replaceAttributes(newAttributes), this.useCorrectedNullabilityForTypeParameters);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public DefinitelyNotNullType replaceDelegate(SimpleType delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new DefinitelyNotNullType(delegate, this.useCorrectedNullabilityForTypeParameters);
    }
}
