package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;

/* loaded from: classes3.dex */
public abstract class DescriptorUtilKt {
    public static final ClassifierDescriptor getTopLevelContainingClassifier(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        if (containingDeclaration == null || (declarationDescriptor instanceof PackageFragmentDescriptor)) {
            return null;
        }
        if (!isTopLevelInPackage(containingDeclaration)) {
            return getTopLevelContainingClassifier(containingDeclaration);
        }
        if (containingDeclaration instanceof ClassifierDescriptor) {
            return (ClassifierDescriptor) containingDeclaration;
        }
        return null;
    }

    public static final boolean isTopLevelInPackage(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return declarationDescriptor.getContainingDeclaration() instanceof PackageFragmentDescriptor;
    }

    public static final boolean isTypedEqualsInValueClass(FunctionDescriptor functionDescriptor) {
        SimpleType defaultType;
        KotlinType replaceArgumentsWithStarProjections;
        KotlinType returnType;
        Intrinsics.checkNotNullParameter(functionDescriptor, "<this>");
        DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null) {
            return false;
        }
        ClassDescriptor classDescriptor2 = InlineClassesUtilsKt.isValueClass(classDescriptor) ? classDescriptor : null;
        if (classDescriptor2 == null || (defaultType = classDescriptor2.getDefaultType()) == null || (replaceArgumentsWithStarProjections = TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType)) == null || (returnType = functionDescriptor.getReturnType()) == null || !Intrinsics.areEqual(functionDescriptor.getName(), OperatorNameConventions.EQUALS)) {
            return false;
        }
        if ((!TypeUtilsKt.isBoolean(returnType) && !TypeUtilsKt.isNothing(returnType)) || functionDescriptor.getValueParameters().size() != 1) {
            return false;
        }
        KotlinType type = functionDescriptor.getValueParameters().get(0).getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return Intrinsics.areEqual(TypeUtilsKt.replaceArgumentsWithStarProjections(type), replaceArgumentsWithStarProjections) && functionDescriptor.getContextReceiverParameters().isEmpty() && functionDescriptor.getExtensionReceiverParameter() == null;
    }

    public static final ClassDescriptor resolveClassByFqName(ModuleDescriptor moduleDescriptor, FqName fqName, LookupLocation lookupLocation) {
        MemberScope unsubstitutedInnerClassesScope;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(lookupLocation, "lookupLocation");
        if (fqName.isRoot()) {
            return null;
        }
        ClassifierDescriptor mo3720getContributedClassifier = moduleDescriptor.getPackage(fqName.parent()).getMemberScope().mo3720getContributedClassifier(fqName.shortName(), lookupLocation);
        ClassDescriptor classDescriptor = mo3720getContributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) mo3720getContributedClassifier : null;
        if (classDescriptor != null) {
            return classDescriptor;
        }
        ClassDescriptor resolveClassByFqName = resolveClassByFqName(moduleDescriptor, fqName.parent(), lookupLocation);
        ClassifierDescriptor mo3720getContributedClassifier2 = (resolveClassByFqName == null || (unsubstitutedInnerClassesScope = resolveClassByFqName.getUnsubstitutedInnerClassesScope()) == null) ? null : unsubstitutedInnerClassesScope.mo3720getContributedClassifier(fqName.shortName(), lookupLocation);
        if (mo3720getContributedClassifier2 instanceof ClassDescriptor) {
            return (ClassDescriptor) mo3720getContributedClassifier2;
        }
        return null;
    }
}
