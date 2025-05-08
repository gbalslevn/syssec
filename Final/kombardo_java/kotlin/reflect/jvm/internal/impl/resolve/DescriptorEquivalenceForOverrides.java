package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* loaded from: classes3.dex */
public final class DescriptorEquivalenceForOverrides {
    public static final DescriptorEquivalenceForOverrides INSTANCE = new DescriptorEquivalenceForOverrides();

    private DescriptorEquivalenceForOverrides() {
    }

    public static /* synthetic */ boolean areCallableDescriptorsEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z5, boolean z6, boolean z7, KotlinTypeRefiner kotlinTypeRefiner, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            z6 = true;
        }
        boolean z8 = z6;
        if ((i5 & 16) != 0) {
            z7 = false;
        }
        return descriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent(callableDescriptor, callableDescriptor2, z5, z8, z7, kotlinTypeRefiner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean areCallableDescriptorsEquivalent$lambda$1(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean areCallableDescriptorsEquivalent$lambda$3(boolean z5, final CallableDescriptor callableDescriptor, final CallableDescriptor callableDescriptor2, TypeConstructor c12, TypeConstructor c22) {
        Intrinsics.checkNotNullParameter(c12, "c1");
        Intrinsics.checkNotNullParameter(c22, "c2");
        if (Intrinsics.areEqual(c12, c22)) {
            return true;
        }
        ClassifierDescriptor mo3718getDeclarationDescriptor = c12.mo3718getDeclarationDescriptor();
        ClassifierDescriptor mo3718getDeclarationDescriptor2 = c22.mo3718getDeclarationDescriptor();
        if ((mo3718getDeclarationDescriptor instanceof TypeParameterDescriptor) && (mo3718getDeclarationDescriptor2 instanceof TypeParameterDescriptor)) {
            return INSTANCE.areTypeParametersEquivalent((TypeParameterDescriptor) mo3718getDeclarationDescriptor, (TypeParameterDescriptor) mo3718getDeclarationDescriptor2, z5, new Function2(callableDescriptor, callableDescriptor2) { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$$Lambda$3
                private final CallableDescriptor arg$0;
                private final CallableDescriptor arg$1;

                {
                    this.arg$0 = callableDescriptor;
                    this.arg$1 = callableDescriptor2;
                }

                @Override // kotlin.jvm.functions.Function2
                public Object invoke(Object obj, Object obj2) {
                    boolean areCallableDescriptorsEquivalent$lambda$3$lambda$2;
                    areCallableDescriptorsEquivalent$lambda$3$lambda$2 = DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent$lambda$3$lambda$2(this.arg$0, this.arg$1, (DeclarationDescriptor) obj, (DeclarationDescriptor) obj2);
                    return Boolean.valueOf(areCallableDescriptorsEquivalent$lambda$3$lambda$2);
                }
            });
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean areCallableDescriptorsEquivalent$lambda$3$lambda$2(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        return Intrinsics.areEqual(declarationDescriptor, callableDescriptor) && Intrinsics.areEqual(declarationDescriptor2, callableDescriptor2);
    }

    private final boolean areClassesEquivalent(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        return Intrinsics.areEqual(classDescriptor.getTypeConstructor(), classDescriptor2.getTypeConstructor());
    }

    public static /* synthetic */ boolean areEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean z5, boolean z6, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            z6 = true;
        }
        return descriptorEquivalenceForOverrides.areEquivalent(declarationDescriptor, declarationDescriptor2, z5, z6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean areTypeParametersEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z5, Function2 function2, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            function2 = new Function2() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$$Lambda$0
                @Override // kotlin.jvm.functions.Function2
                public Object invoke(Object obj2, Object obj3) {
                    boolean areTypeParametersEquivalent$lambda$0;
                    areTypeParametersEquivalent$lambda$0 = DescriptorEquivalenceForOverrides.areTypeParametersEquivalent$lambda$0((DeclarationDescriptor) obj2, (DeclarationDescriptor) obj3);
                    return Boolean.valueOf(areTypeParametersEquivalent$lambda$0);
                }
            };
        }
        return descriptorEquivalenceForOverrides.areTypeParametersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, z5, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean areTypeParametersEquivalent$lambda$0(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        return false;
    }

    private final boolean ownersEquivalent(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2, boolean z5) {
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        DeclarationDescriptor containingDeclaration2 = declarationDescriptor2.getContainingDeclaration();
        return ((containingDeclaration instanceof CallableMemberDescriptor) || (containingDeclaration2 instanceof CallableMemberDescriptor)) ? function2.invoke(containingDeclaration, containingDeclaration2).booleanValue() : areEquivalent$default(this, containingDeclaration, containingDeclaration2, z5, false, 8, null);
    }

    private final SourceElement singleSource(CallableDescriptor callableDescriptor) {
        while (callableDescriptor instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) callableDescriptor;
            if (callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
            callableDescriptor = (CallableMemberDescriptor) CollectionsKt.singleOrNull(overriddenDescriptors);
            if (callableDescriptor == null) {
                return null;
            }
        }
        return callableDescriptor.getSource();
    }

    public final boolean areCallableDescriptorsEquivalent(final CallableDescriptor a5, final CallableDescriptor b5, final boolean z5, boolean z6, boolean z7, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(a5, "a");
        Intrinsics.checkNotNullParameter(b5, "b");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (Intrinsics.areEqual(a5, b5)) {
            return true;
        }
        if (!Intrinsics.areEqual(a5.getName(), b5.getName())) {
            return false;
        }
        if (z6 && (a5 instanceof MemberDescriptor) && (b5 instanceof MemberDescriptor) && ((MemberDescriptor) a5).isExpect() != ((MemberDescriptor) b5).isExpect()) {
            return false;
        }
        if ((Intrinsics.areEqual(a5.getContainingDeclaration(), b5.getContainingDeclaration()) && (!z5 || !Intrinsics.areEqual(singleSource(a5), singleSource(b5)))) || DescriptorUtils.isLocal(a5) || DescriptorUtils.isLocal(b5) || !ownersEquivalent(a5, b5, new Function2() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$$Lambda$1
            @Override // kotlin.jvm.functions.Function2
            public Object invoke(Object obj, Object obj2) {
                boolean areCallableDescriptorsEquivalent$lambda$1;
                areCallableDescriptorsEquivalent$lambda$1 = DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent$lambda$1((DeclarationDescriptor) obj, (DeclarationDescriptor) obj2);
                return Boolean.valueOf(areCallableDescriptorsEquivalent$lambda$1);
            }
        }, z5)) {
            return false;
        }
        OverridingUtil create = OverridingUtil.create(kotlinTypeRefiner, new KotlinTypeChecker.TypeConstructorEquality(z5, a5, b5) { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$$Lambda$2
            private final boolean arg$0;
            private final CallableDescriptor arg$1;
            private final CallableDescriptor arg$2;

            {
                this.arg$0 = z5;
                this.arg$1 = a5;
                this.arg$2 = b5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
            public boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
                boolean areCallableDescriptorsEquivalent$lambda$3;
                areCallableDescriptorsEquivalent$lambda$3 = DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent$lambda$3(this.arg$0, this.arg$1, this.arg$2, typeConstructor, typeConstructor2);
                return areCallableDescriptorsEquivalent$lambda$3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        OverridingUtil.OverrideCompatibilityInfo.Result result = create.isOverridableBy(a5, b5, null, !z7).getResult();
        OverridingUtil.OverrideCompatibilityInfo.Result result2 = OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
        return result == result2 && create.isOverridableBy(b5, a5, null, z7 ^ true).getResult() == result2;
    }

    public final boolean areEquivalent(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean z5, boolean z6) {
        return ((declarationDescriptor instanceof ClassDescriptor) && (declarationDescriptor2 instanceof ClassDescriptor)) ? areClassesEquivalent((ClassDescriptor) declarationDescriptor, (ClassDescriptor) declarationDescriptor2) : ((declarationDescriptor instanceof TypeParameterDescriptor) && (declarationDescriptor2 instanceof TypeParameterDescriptor)) ? areTypeParametersEquivalent$default(this, (TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, z5, null, 8, null) : ((declarationDescriptor instanceof CallableDescriptor) && (declarationDescriptor2 instanceof CallableDescriptor)) ? areCallableDescriptorsEquivalent$default(this, (CallableDescriptor) declarationDescriptor, (CallableDescriptor) declarationDescriptor2, z5, z6, false, KotlinTypeRefiner.Default.INSTANCE, 16, null) : ((declarationDescriptor instanceof PackageFragmentDescriptor) && (declarationDescriptor2 instanceof PackageFragmentDescriptor)) ? Intrinsics.areEqual(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), ((PackageFragmentDescriptor) declarationDescriptor2).getFqName()) : Intrinsics.areEqual(declarationDescriptor, declarationDescriptor2);
    }

    public final boolean areTypeParametersEquivalent(TypeParameterDescriptor a5, TypeParameterDescriptor b5, boolean z5) {
        Intrinsics.checkNotNullParameter(a5, "a");
        Intrinsics.checkNotNullParameter(b5, "b");
        return areTypeParametersEquivalent$default(this, a5, b5, z5, null, 8, null);
    }

    public final boolean areTypeParametersEquivalent(TypeParameterDescriptor a5, TypeParameterDescriptor b5, boolean z5, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> equivalentCallables) {
        Intrinsics.checkNotNullParameter(a5, "a");
        Intrinsics.checkNotNullParameter(b5, "b");
        Intrinsics.checkNotNullParameter(equivalentCallables, "equivalentCallables");
        if (Intrinsics.areEqual(a5, b5)) {
            return true;
        }
        return !Intrinsics.areEqual(a5.getContainingDeclaration(), b5.getContainingDeclaration()) && ownersEquivalent(a5, b5, equivalentCallables, z5) && a5.getIndex() == b5.getIndex();
    }
}
