package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import android.support.v4.media.session.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes3.dex */
public abstract class DescriptorUtilsKt {
    private static final Name RETENTION_PARAMETER_NAME;

    static {
        Name identifier = Name.identifier("value");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        RETENTION_PARAMETER_NAME = identifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeclarationDescriptor _get_parentsWithSelf_$lambda$8(DeclarationDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getContainingDeclaration();
    }

    public static final boolean declaresOrInheritsDefaultValue(ValueParameterDescriptor valueParameterDescriptor) {
        Intrinsics.checkNotNullParameter(valueParameterDescriptor, "<this>");
        Boolean ifAny = DFS.ifAny(CollectionsKt.listOf(valueParameterDescriptor), new DFS.Neighbors() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$$Lambda$0
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public Iterable getNeighbors(Object obj) {
                Iterable declaresOrInheritsDefaultValue$lambda$5;
                declaresOrInheritsDefaultValue$lambda$5 = DescriptorUtilsKt.declaresOrInheritsDefaultValue$lambda$5((ValueParameterDescriptor) obj);
                return declaresOrInheritsDefaultValue$lambda$5;
            }
        }, DescriptorUtilsKt$declaresOrInheritsDefaultValue$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(ifAny, "ifAny(...)");
        return ifAny.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable declaresOrInheritsDefaultValue$lambda$5(ValueParameterDescriptor valueParameterDescriptor) {
        Collection<ValueParameterDescriptor> overriddenDescriptors = valueParameterDescriptor.getOverriddenDescriptors();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(overriddenDescriptors, 10));
        Iterator<T> it = overriddenDescriptors.iterator();
        while (it.hasNext()) {
            arrayList.add(((ValueParameterDescriptor) it.next()).getOriginal());
        }
        return arrayList;
    }

    public static final CallableMemberDescriptor firstOverridden(CallableMemberDescriptor callableMemberDescriptor, final boolean z5, final Function1<? super CallableMemberDescriptor, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        return (CallableMemberDescriptor) DFS.dfs(CollectionsKt.listOf(callableMemberDescriptor), new DFS.Neighbors(z5) { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$$Lambda$2
            private final boolean arg$0;

            {
                this.arg$0 = z5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public Iterable getNeighbors(Object obj) {
                Iterable firstOverridden$lambda$10;
                firstOverridden$lambda$10 = DescriptorUtilsKt.firstOverridden$lambda$10(this.arg$0, (CallableMemberDescriptor) obj);
                return firstOverridden$lambda$10;
            }
        }, new DFS.AbstractNodeHandler<CallableMemberDescriptor, CallableMemberDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$firstOverridden$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public void afterChildren(CallableMemberDescriptor current) {
                Intrinsics.checkNotNullParameter(current, "current");
                if (ref$ObjectRef.element == null && predicate.invoke(current).booleanValue()) {
                    ref$ObjectRef.element = current;
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(CallableMemberDescriptor current) {
                Intrinsics.checkNotNullParameter(current, "current");
                return ref$ObjectRef.element == null;
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public CallableMemberDescriptor result() {
                return ref$ObjectRef.element;
            }
        });
    }

    public static /* synthetic */ CallableMemberDescriptor firstOverridden$default(CallableMemberDescriptor callableMemberDescriptor, boolean z5, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        return firstOverridden(callableMemberDescriptor, z5, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable firstOverridden$lambda$10(boolean z5, CallableMemberDescriptor callableMemberDescriptor) {
        Collection<? extends CallableMemberDescriptor> emptyList;
        if (z5) {
            callableMemberDescriptor = callableMemberDescriptor != null ? callableMemberDescriptor.getOriginal() : null;
        }
        if (callableMemberDescriptor == null || (emptyList = callableMemberDescriptor.getOverriddenDescriptors()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        return emptyList;
    }

    public static final FqName fqNameOrNull(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        FqNameUnsafe fqNameUnsafe = getFqNameUnsafe(declarationDescriptor);
        if (!fqNameUnsafe.isSafe()) {
            fqNameUnsafe = null;
        }
        if (fqNameUnsafe != null) {
            return fqNameUnsafe.toSafe();
        }
        return null;
    }

    public static final ClassDescriptor getAnnotationClass(AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        ClassifierDescriptor mo3718getDeclarationDescriptor = annotationDescriptor.getType().getConstructor().mo3718getDeclarationDescriptor();
        if (mo3718getDeclarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) mo3718getDeclarationDescriptor;
        }
        return null;
    }

    public static final KotlinBuiltIns getBuiltIns(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return getModule(declarationDescriptor).getBuiltIns();
    }

    public static final ClassId getClassId(ClassifierDescriptor classifierDescriptor) {
        DeclarationDescriptor containingDeclaration;
        ClassId classId;
        if (classifierDescriptor == null || (containingDeclaration = classifierDescriptor.getContainingDeclaration()) == null) {
            return null;
        }
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            FqName fqName = ((PackageFragmentDescriptor) containingDeclaration).getFqName();
            Name name = classifierDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return new ClassId(fqName, name);
        }
        if (!(containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) || (classId = getClassId((ClassifierDescriptor) containingDeclaration)) == null) {
            return null;
        }
        Name name2 = classifierDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        return classId.createNestedClassId(name2);
    }

    public static final FqName getFqNameSafe(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        FqName fqNameSafe = DescriptorUtils.getFqNameSafe(declarationDescriptor);
        Intrinsics.checkNotNullExpressionValue(fqNameSafe, "getFqNameSafe(...)");
        return fqNameSafe;
    }

    public static final FqNameUnsafe getFqNameUnsafe(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        FqNameUnsafe fqName = DescriptorUtils.getFqName(declarationDescriptor);
        Intrinsics.checkNotNullExpressionValue(fqName, "getFqName(...)");
        return fqName;
    }

    public static final InlineClassRepresentation<SimpleType> getInlineClassRepresentation(ClassDescriptor classDescriptor) {
        ValueClassRepresentation<SimpleType> valueClassRepresentation = classDescriptor != null ? classDescriptor.getValueClassRepresentation() : null;
        if (valueClassRepresentation instanceof InlineClassRepresentation) {
            return (InlineClassRepresentation) valueClassRepresentation;
        }
        return null;
    }

    public static final KotlinTypeRefiner getKotlinTypeRefiner(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        a.a(moduleDescriptor.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY()));
        return KotlinTypeRefiner.Default.INSTANCE;
    }

    public static final ModuleDescriptor getModule(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        ModuleDescriptor containingModule = DescriptorUtils.getContainingModule(declarationDescriptor);
        Intrinsics.checkNotNullExpressionValue(containingModule, "getContainingModule(...)");
        return containingModule;
    }

    public static final MultiFieldValueClassRepresentation<SimpleType> getMultiFieldValueClassRepresentation(ClassDescriptor classDescriptor) {
        ValueClassRepresentation<SimpleType> valueClassRepresentation = classDescriptor != null ? classDescriptor.getValueClassRepresentation() : null;
        if (valueClassRepresentation instanceof MultiFieldValueClassRepresentation) {
            return (MultiFieldValueClassRepresentation) valueClassRepresentation;
        }
        return null;
    }

    public static final Sequence<DeclarationDescriptor> getParents(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return SequencesKt.drop(getParentsWithSelf(declarationDescriptor), 1);
    }

    public static final Sequence<DeclarationDescriptor> getParentsWithSelf(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return SequencesKt.generateSequence(declarationDescriptor, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                DeclarationDescriptor _get_parentsWithSelf_$lambda$8;
                _get_parentsWithSelf_$lambda$8 = DescriptorUtilsKt._get_parentsWithSelf_$lambda$8((DeclarationDescriptor) obj);
                return _get_parentsWithSelf_$lambda$8;
            }
        });
    }

    public static final CallableMemberDescriptor getPropertyIfAccessor(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        if (!(callableMemberDescriptor instanceof PropertyAccessorDescriptor)) {
            return callableMemberDescriptor;
        }
        PropertyDescriptor correspondingProperty = ((PropertyAccessorDescriptor) callableMemberDescriptor).getCorrespondingProperty();
        Intrinsics.checkNotNullExpressionValue(correspondingProperty, "getCorrespondingProperty(...)");
        return correspondingProperty;
    }

    public static final ClassDescriptor getSuperClassNotAny(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        for (KotlinType kotlinType : classDescriptor.getDefaultType().getConstructor().mo3719getSupertypes()) {
            if (!KotlinBuiltIns.isAnyOrNullableAny(kotlinType)) {
                ClassifierDescriptor mo3718getDeclarationDescriptor = kotlinType.getConstructor().mo3718getDeclarationDescriptor();
                if (DescriptorUtils.isClassOrEnumClass(mo3718getDeclarationDescriptor)) {
                    Intrinsics.checkNotNull(mo3718getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (ClassDescriptor) mo3718getDeclarationDescriptor;
                }
            }
        }
        return null;
    }

    public static final boolean isTypeRefinementEnabled(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        a.a(moduleDescriptor.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY()));
        return false;
    }

    public static final Sequence<CallableMemberDescriptor> overriddenTreeAsSequence(CallableMemberDescriptor callableMemberDescriptor, final boolean z5) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        if (z5) {
            callableMemberDescriptor = callableMemberDescriptor.getOriginal();
        }
        Sequence sequenceOf = SequencesKt.sequenceOf(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
        return SequencesKt.plus(sequenceOf, SequencesKt.flatMap(CollectionsKt.asSequence(overriddenDescriptors), new Function1(z5) { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$$Lambda$3
            private final boolean arg$0;

            {
                this.arg$0 = z5;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Sequence overriddenTreeAsSequence$lambda$12$lambda$11;
                overriddenTreeAsSequence$lambda$12$lambda$11 = DescriptorUtilsKt.overriddenTreeAsSequence$lambda$12$lambda$11(this.arg$0, (CallableMemberDescriptor) obj);
                return overriddenTreeAsSequence$lambda$12$lambda$11;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Sequence overriddenTreeAsSequence$lambda$12$lambda$11(boolean z5, CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNull(callableMemberDescriptor);
        return overriddenTreeAsSequence(callableMemberDescriptor, z5);
    }

    public static final ClassDescriptor resolveTopLevelClass(ModuleDescriptor moduleDescriptor, FqName topLevelClassFqName, LookupLocation location) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(topLevelClassFqName, "topLevelClassFqName");
        Intrinsics.checkNotNullParameter(location, "location");
        topLevelClassFqName.isRoot();
        ClassifierDescriptor mo3720getContributedClassifier = moduleDescriptor.getPackage(topLevelClassFqName.parent()).getMemberScope().mo3720getContributedClassifier(topLevelClassFqName.shortName(), location);
        if (mo3720getContributedClassifier instanceof ClassDescriptor) {
            return (ClassDescriptor) mo3720getContributedClassifier;
        }
        return null;
    }
}
