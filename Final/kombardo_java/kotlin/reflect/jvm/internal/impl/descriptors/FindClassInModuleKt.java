package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt;
import kotlin.sequences.SequencesKt;

/* loaded from: classes3.dex */
public abstract class FindClassInModuleKt {
    public static final ClassDescriptor findClassAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassifierAcrossModuleDependencies instanceof ClassDescriptor) {
            return (ClassDescriptor) findClassifierAcrossModuleDependencies;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        ClassifierDescriptor mo3720getContributedClassifier;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ModuleDescriptor resolutionAnchorIfAny = ResolutionAnchorProviderKt.getResolutionAnchorIfAny(moduleDescriptor);
        if (resolutionAnchorIfAny == null) {
            PackageViewDescriptor packageViewDescriptor = moduleDescriptor.getPackage(classId.getPackageFqName());
            List<Name> pathSegments = classId.getRelativeClassName().pathSegments();
            mo3720getContributedClassifier = packageViewDescriptor.getMemberScope().mo3720getContributedClassifier((Name) CollectionsKt.first((List) pathSegments), NoLookupLocation.FROM_DESERIALIZATION);
            if (mo3720getContributedClassifier == null) {
                return null;
            }
            for (Name name : pathSegments.subList(1, pathSegments.size())) {
                if (!(mo3720getContributedClassifier instanceof ClassDescriptor)) {
                    return null;
                }
                ClassifierDescriptor mo3720getContributedClassifier2 = ((ClassDescriptor) mo3720getContributedClassifier).getUnsubstitutedInnerClassesScope().mo3720getContributedClassifier(name, NoLookupLocation.FROM_DESERIALIZATION);
                mo3720getContributedClassifier = mo3720getContributedClassifier2 instanceof ClassDescriptor ? (ClassDescriptor) mo3720getContributedClassifier2 : null;
                if (mo3720getContributedClassifier == null) {
                    return null;
                }
            }
        } else {
            PackageViewDescriptor packageViewDescriptor2 = resolutionAnchorIfAny.getPackage(classId.getPackageFqName());
            List<Name> pathSegments2 = classId.getRelativeClassName().pathSegments();
            ClassifierDescriptor mo3720getContributedClassifier3 = packageViewDescriptor2.getMemberScope().mo3720getContributedClassifier((Name) CollectionsKt.first((List) pathSegments2), NoLookupLocation.FROM_DESERIALIZATION);
            if (mo3720getContributedClassifier3 != null) {
                for (Name name2 : pathSegments2.subList(1, pathSegments2.size())) {
                    if (mo3720getContributedClassifier3 instanceof ClassDescriptor) {
                        ClassifierDescriptor mo3720getContributedClassifier4 = ((ClassDescriptor) mo3720getContributedClassifier3).getUnsubstitutedInnerClassesScope().mo3720getContributedClassifier(name2, NoLookupLocation.FROM_DESERIALIZATION);
                        mo3720getContributedClassifier3 = mo3720getContributedClassifier4 instanceof ClassDescriptor ? (ClassDescriptor) mo3720getContributedClassifier4 : null;
                        if (mo3720getContributedClassifier3 != null) {
                        }
                    }
                }
                if (mo3720getContributedClassifier3 == null) {
                    return mo3720getContributedClassifier3;
                }
                PackageViewDescriptor packageViewDescriptor3 = moduleDescriptor.getPackage(classId.getPackageFqName());
                List<Name> pathSegments3 = classId.getRelativeClassName().pathSegments();
                mo3720getContributedClassifier = packageViewDescriptor3.getMemberScope().mo3720getContributedClassifier((Name) CollectionsKt.first((List) pathSegments3), NoLookupLocation.FROM_DESERIALIZATION);
                if (mo3720getContributedClassifier == null) {
                    return null;
                }
                for (Name name3 : pathSegments3.subList(1, pathSegments3.size())) {
                    if (!(mo3720getContributedClassifier instanceof ClassDescriptor)) {
                        return null;
                    }
                    ClassifierDescriptor mo3720getContributedClassifier5 = ((ClassDescriptor) mo3720getContributedClassifier).getUnsubstitutedInnerClassesScope().mo3720getContributedClassifier(name3, NoLookupLocation.FROM_DESERIALIZATION);
                    mo3720getContributedClassifier = mo3720getContributedClassifier5 instanceof ClassDescriptor ? (ClassDescriptor) mo3720getContributedClassifier5 : null;
                    if (mo3720getContributedClassifier == null) {
                        return null;
                    }
                }
            }
            mo3720getContributedClassifier3 = null;
            if (mo3720getContributedClassifier3 == null) {
            }
        }
        return mo3720getContributedClassifier;
    }

    public static final ClassDescriptor findNonGenericClassAcrossDependencies(ModuleDescriptor moduleDescriptor, ClassId classId, NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        ClassDescriptor findClassAcrossModuleDependencies = findClassAcrossModuleDependencies(moduleDescriptor, classId);
        return findClassAcrossModuleDependencies != null ? findClassAcrossModuleDependencies : notFoundClasses.getClass(classId, SequencesKt.toList(SequencesKt.map(SequencesKt.generateSequence(classId, new PropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ClassId) obj).getOuterClassId();
            }
        }), new Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                int findNonGenericClassAcrossDependencies$lambda$1;
                findNonGenericClassAcrossDependencies$lambda$1 = FindClassInModuleKt.findNonGenericClassAcrossDependencies$lambda$1((ClassId) obj);
                return Integer.valueOf(findNonGenericClassAcrossDependencies$lambda$1);
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findNonGenericClassAcrossDependencies$lambda$1(ClassId it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return 0;
    }

    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) findClassifierAcrossModuleDependencies;
        }
        return null;
    }
}
