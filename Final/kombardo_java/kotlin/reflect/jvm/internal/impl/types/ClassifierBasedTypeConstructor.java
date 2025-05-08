package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* loaded from: classes3.dex */
public abstract class ClassifierBasedTypeConstructor implements TypeConstructor {
    private int hashCode;

    private final boolean hasMeaningfulFqName(ClassifierDescriptor classifierDescriptor) {
        return (ErrorUtils.isError(classifierDescriptor) || DescriptorUtils.isLocal(classifierDescriptor)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean areFqNamesEqual(ClassifierDescriptor first, ClassifierDescriptor second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        if (!Intrinsics.areEqual(first.getName(), second.getName())) {
            return false;
        }
        DeclarationDescriptor containingDeclaration = first.getContainingDeclaration();
        for (DeclarationDescriptor containingDeclaration2 = second.getContainingDeclaration(); containingDeclaration != null && containingDeclaration2 != null; containingDeclaration2 = containingDeclaration2.getContainingDeclaration()) {
            if (containingDeclaration instanceof ModuleDescriptor) {
                return containingDeclaration2 instanceof ModuleDescriptor;
            }
            if (containingDeclaration2 instanceof ModuleDescriptor) {
                return false;
            }
            if (containingDeclaration instanceof PackageFragmentDescriptor) {
                return (containingDeclaration2 instanceof PackageFragmentDescriptor) && Intrinsics.areEqual(((PackageFragmentDescriptor) containingDeclaration).getFqName(), ((PackageFragmentDescriptor) containingDeclaration2).getFqName());
            }
            if ((containingDeclaration2 instanceof PackageFragmentDescriptor) || !Intrinsics.areEqual(containingDeclaration.getName(), containingDeclaration2.getName())) {
                return false;
            }
            containingDeclaration = containingDeclaration.getContainingDeclaration();
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeConstructor) || obj.hashCode() != hashCode()) {
            return false;
        }
        TypeConstructor typeConstructor = (TypeConstructor) obj;
        if (typeConstructor.getParameters().size() != getParameters().size()) {
            return false;
        }
        ClassifierDescriptor mo3718getDeclarationDescriptor = mo3718getDeclarationDescriptor();
        ClassifierDescriptor mo3718getDeclarationDescriptor2 = typeConstructor.mo3718getDeclarationDescriptor();
        if (mo3718getDeclarationDescriptor2 != null && hasMeaningfulFqName(mo3718getDeclarationDescriptor) && hasMeaningfulFqName(mo3718getDeclarationDescriptor2)) {
            return isSameClassifier(mo3718getDeclarationDescriptor2);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getDeclarationDescriptor */
    public abstract ClassifierDescriptor mo3718getDeclarationDescriptor();

    public int hashCode() {
        int i5 = this.hashCode;
        if (i5 != 0) {
            return i5;
        }
        ClassifierDescriptor mo3718getDeclarationDescriptor = mo3718getDeclarationDescriptor();
        int hashCode = hasMeaningfulFqName(mo3718getDeclarationDescriptor) ? DescriptorUtils.getFqName(mo3718getDeclarationDescriptor).hashCode() : System.identityHashCode(this);
        this.hashCode = hashCode;
        return hashCode;
    }

    protected abstract boolean isSameClassifier(ClassifierDescriptor classifierDescriptor);
}
