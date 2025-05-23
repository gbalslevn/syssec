package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilterKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(JvmBuiltInsCustomizer.class, "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;", 0)), Reflection.property1(new PropertyReference1Impl(JvmBuiltInsCustomizer.class, "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;", 0)), Reflection.property1(new PropertyReference1Impl(JvmBuiltInsCustomizer.class, "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;", 0))};
    private final NotNullLazyValue cloneableType$delegate;
    private final MemoizedFunctionToNotNull<Pair<String, String>, Annotations> deprecationForSomeOfTheListMethods;
    private final JavaToKotlinClassMapper j2kClassMapper;
    private final CacheWithNotNullValues<FqName, ClassDescriptor> javaAnalogueClassesWithCustomSupertypeCache;
    private final KotlinType mockSerializableType;
    private final ModuleDescriptor moduleDescriptor;
    private final NotNullLazyValue notConsideredDeprecation$delegate;
    private final NotNullLazyValue settings$delegate;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes3.dex */
    public static final class JDKMemberStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ JDKMemberStatus[] $VALUES;
        public static final JDKMemberStatus HIDDEN = new JDKMemberStatus("HIDDEN", 0);
        public static final JDKMemberStatus VISIBLE = new JDKMemberStatus("VISIBLE", 1);
        public static final JDKMemberStatus DEPRECATED_LIST_METHODS = new JDKMemberStatus("DEPRECATED_LIST_METHODS", 2);
        public static final JDKMemberStatus NOT_CONSIDERED = new JDKMemberStatus("NOT_CONSIDERED", 3);
        public static final JDKMemberStatus DROP = new JDKMemberStatus("DROP", 4);

        private static final /* synthetic */ JDKMemberStatus[] $values() {
            return new JDKMemberStatus[]{HIDDEN, VISIBLE, DEPRECATED_LIST_METHODS, NOT_CONSIDERED, DROP};
        }

        static {
            JDKMemberStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private JDKMemberStatus(String str, int i5) {
        }

        public static JDKMemberStatus valueOf(String str) {
            return (JDKMemberStatus) Enum.valueOf(JDKMemberStatus.class, str);
        }

        public static JDKMemberStatus[] values() {
            return (JDKMemberStatus[]) $VALUES.clone();
        }
    }

    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JDKMemberStatus.values().length];
            try {
                iArr[JDKMemberStatus.HIDDEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JDKMemberStatus.DEPRECATED_LIST_METHODS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JDKMemberStatus.NOT_CONSIDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[JDKMemberStatus.DROP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[JDKMemberStatus.VISIBLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JvmBuiltInsCustomizer(ModuleDescriptor moduleDescriptor, final StorageManager storageManager, Function0<JvmBuiltIns.Settings> settingsComputation) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(settingsComputation, "settingsComputation");
        this.moduleDescriptor = moduleDescriptor;
        this.j2kClassMapper = JavaToKotlinClassMapper.INSTANCE;
        this.settings$delegate = storageManager.createLazyValue(settingsComputation);
        this.mockSerializableType = createMockJavaIoSerializableType(storageManager);
        this.cloneableType$delegate = storageManager.createLazyValue(new Function0(this, storageManager) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$0
            private final JvmBuiltInsCustomizer arg$0;
            private final StorageManager arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = storageManager;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                SimpleType cloneableType_delegate$lambda$0;
                cloneableType_delegate$lambda$0 = JvmBuiltInsCustomizer.cloneableType_delegate$lambda$0(this.arg$0, this.arg$1);
                return cloneableType_delegate$lambda$0;
            }
        });
        this.javaAnalogueClassesWithCustomSupertypeCache = storageManager.createCacheWithNotNullValues();
        this.notConsideredDeprecation$delegate = storageManager.createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$1
            private final JvmBuiltInsCustomizer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Annotations notConsideredDeprecation_delegate$lambda$1;
                notConsideredDeprecation_delegate$lambda$1 = JvmBuiltInsCustomizer.notConsideredDeprecation_delegate$lambda$1(this.arg$0);
                return notConsideredDeprecation_delegate$lambda$1;
            }
        });
        this.deprecationForSomeOfTheListMethods = storageManager.createMemoizedFunction(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$2
            private final JvmBuiltInsCustomizer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Annotations deprecationForSomeOfTheListMethods$lambda$2;
                deprecationForSomeOfTheListMethods$lambda$2 = JvmBuiltInsCustomizer.deprecationForSomeOfTheListMethods$lambda$2(this.arg$0, (Pair) obj);
                return deprecationForSomeOfTheListMethods$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleType cloneableType_delegate$lambda$0(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, StorageManager storageManager) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(jvmBuiltInsCustomizer.getSettings().getOwnerModuleDescriptor(), JvmBuiltInClassDescriptorFactory.Companion.getCLONEABLE_CLASS_ID(), new NotFoundClasses(storageManager, jvmBuiltInsCustomizer.getSettings().getOwnerModuleDescriptor())).getDefaultType();
    }

    private final SimpleFunctionDescriptor createCloneForArray(DeserializedClassDescriptor deserializedClassDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        newCopyBuilder.setOwner(deserializedClassDescriptor);
        newCopyBuilder.setVisibility(DescriptorVisibilities.PUBLIC);
        newCopyBuilder.setReturnType(deserializedClassDescriptor.getDefaultType());
        newCopyBuilder.setDispatchReceiverParameter(deserializedClassDescriptor.getThisAsReceiverParameter());
        SimpleFunctionDescriptor build = newCopyBuilder.build();
        Intrinsics.checkNotNull(build);
        return build;
    }

    private final KotlinType createMockJavaIoSerializableType(StorageManager storageManager) {
        final ModuleDescriptor moduleDescriptor = this.moduleDescriptor;
        final FqName fqName = new FqName("java.io");
        ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(new PackageFragmentDescriptorImpl(moduleDescriptor, fqName) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1
            @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
            public MemberScope.Empty getMemberScope() {
                return MemberScope.Empty.INSTANCE;
            }
        }, Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, CollectionsKt.listOf(new LazyWrappedType(storageManager, new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$3
            private final JvmBuiltInsCustomizer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                KotlinType createMockJavaIoSerializableType$lambda$3;
                createMockJavaIoSerializableType$lambda$3 = JvmBuiltInsCustomizer.createMockJavaIoSerializableType$lambda$3(this.arg$0);
                return createMockJavaIoSerializableType$lambda$3;
            }
        })), SourceElement.NO_SOURCE, false, storageManager);
        classDescriptorImpl.initialize(MemberScope.Empty.INSTANCE, SetsKt.emptySet(), null);
        SimpleType defaultType = classDescriptorImpl.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
        return defaultType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType createMockJavaIoSerializableType$lambda$3(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        SimpleType anyType = jvmBuiltInsCustomizer.moduleDescriptor.getBuiltIns().getAnyType();
        Intrinsics.checkNotNullExpressionValue(anyType, "getAnyType(...)");
        return anyType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Annotations deprecationForSomeOfTheListMethods$lambda$2(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        String str = (String) pair.component1();
        String str2 = (String) pair.component2();
        return Annotations.Companion.create(CollectionsKt.listOf(AnnotationUtilKt.createDeprecatedAnnotation(jvmBuiltInsCustomizer.moduleDescriptor.getBuiltIns(), '\'' + str + "()' member of List is redundant in Kotlin and might be removed soon. Please use '" + str2 + "()' stdlib extension instead", str2 + "()", "HIDDEN", false)));
    }

    private final Collection<SimpleFunctionDescriptor> getAdditionalFunctions(ClassDescriptor classDescriptor, Function1<? super MemberScope, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        final LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        if (javaAnalogue == null) {
            return CollectionsKt.emptyList();
        }
        Collection<ClassDescriptor> mapPlatformClass = this.j2kClassMapper.mapPlatformClass(DescriptorUtilsKt.getFqNameSafe(javaAnalogue), FallbackBuiltIns.Companion.getInstance());
        final ClassDescriptor classDescriptor2 = (ClassDescriptor) CollectionsKt.lastOrNull(mapPlatformClass);
        if (classDescriptor2 == null) {
            return CollectionsKt.emptyList();
        }
        SmartSet.Companion companion = SmartSet.Companion;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(mapPlatformClass, 10));
        Iterator<T> it = mapPlatformClass.iterator();
        while (it.hasNext()) {
            arrayList.add(DescriptorUtilsKt.getFqNameSafe((ClassDescriptor) it.next()));
        }
        SmartSet create = companion.create(arrayList);
        boolean isMutable = this.j2kClassMapper.isMutable(classDescriptor);
        MemberScope unsubstitutedMemberScope = this.javaAnalogueClassesWithCustomSupertypeCache.computeIfAbsent(DescriptorUtilsKt.getFqNameSafe(javaAnalogue), new Function0(javaAnalogue, classDescriptor2) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$5
            private final LazyJavaClassDescriptor arg$0;
            private final ClassDescriptor arg$1;

            {
                this.arg$0 = javaAnalogue;
                this.arg$1 = classDescriptor2;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                ClassDescriptor additionalFunctions$lambda$9;
                additionalFunctions$lambda$9 = JvmBuiltInsCustomizer.getAdditionalFunctions$lambda$9(this.arg$0, this.arg$1);
                return additionalFunctions$lambda$9;
            }
        }).getUnsubstitutedMemberScope();
        Intrinsics.checkNotNullExpressionValue(unsubstitutedMemberScope, "getUnsubstitutedMemberScope(...)");
        Collection<? extends SimpleFunctionDescriptor> invoke = function1.invoke(unsubstitutedMemberScope);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : invoke) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
            if (simpleFunctionDescriptor.getKind() == CallableMemberDescriptor.Kind.DECLARATION && simpleFunctionDescriptor.getVisibility().isPublicAPI() && !KotlinBuiltIns.isDeprecated(simpleFunctionDescriptor)) {
                Collection<? extends FunctionDescriptor> overriddenDescriptors = simpleFunctionDescriptor.getOverriddenDescriptors();
                Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
                Collection<? extends FunctionDescriptor> collection = overriddenDescriptors;
                if (!(collection instanceof Collection) || !collection.isEmpty()) {
                    Iterator<T> it2 = collection.iterator();
                    while (it2.hasNext()) {
                        DeclarationDescriptor containingDeclaration = ((FunctionDescriptor) it2.next()).getContainingDeclaration();
                        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
                        if (create.contains(DescriptorUtilsKt.getFqNameSafe(containingDeclaration))) {
                            break;
                        }
                    }
                }
                if (!isMutabilityViolation(simpleFunctionDescriptor, isMutable)) {
                    arrayList2.add(obj);
                }
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClassDescriptor getAdditionalFunctions$lambda$9(LazyJavaClassDescriptor lazyJavaClassDescriptor, ClassDescriptor classDescriptor) {
        JavaResolverCache EMPTY = JavaResolverCache.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        return lazyJavaClassDescriptor.copy$descriptors_jvm(EMPTY, classDescriptor);
    }

    private final SimpleType getCloneableType() {
        return (SimpleType) StorageKt.getValue(this.cloneableType$delegate, this, (KProperty<?>) $$delegatedProperties[1]);
    }

    private static final boolean getConstructors$isEffectivelyTheSameAs(ConstructorDescriptor constructorDescriptor, TypeSubstitutor typeSubstitutor, ConstructorDescriptor constructorDescriptor2) {
        return OverridingUtil.getBothWaysOverridability(constructorDescriptor, constructorDescriptor2.substitute(typeSubstitutor)) == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection getFunctions$lambda$5(Name name, MemberScope it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getContributedFunctions(name, NoLookupLocation.FROM_BUILTINS);
    }

    private final LazyJavaClassDescriptor getJavaAnalogue(ClassDescriptor classDescriptor) {
        ClassId mapKotlinToJava;
        FqName asSingleFqName;
        if (KotlinBuiltIns.isAny(classDescriptor) || !KotlinBuiltIns.isUnderKotlinPackage(classDescriptor)) {
            return null;
        }
        FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(classDescriptor);
        if (!fqNameUnsafe.isSafe() || (mapKotlinToJava = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqNameUnsafe)) == null || (asSingleFqName = mapKotlinToJava.asSingleFqName()) == null) {
            return null;
        }
        ClassDescriptor resolveClassByFqName = DescriptorUtilKt.resolveClassByFqName(getSettings().getOwnerModuleDescriptor(), asSingleFqName, NoLookupLocation.FROM_BUILTINS);
        if (resolveClassByFqName instanceof LazyJavaClassDescriptor) {
            return (LazyJavaClassDescriptor) resolveClassByFqName;
        }
        return null;
    }

    private final JDKMemberStatus getJdkMethodStatus(FunctionDescriptor functionDescriptor) {
        DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        final String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 3, null);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Object dfs = DFS.dfs(CollectionsKt.listOf((ClassDescriptor) containingDeclaration), new DFS.Neighbors(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$8
            private final JvmBuiltInsCustomizer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public Iterable getNeighbors(Object obj) {
                Iterable jdkMethodStatus$lambda$16;
                jdkMethodStatus$lambda$16 = JvmBuiltInsCustomizer.getJdkMethodStatus$lambda$16(this.arg$0, (ClassDescriptor) obj);
                return jdkMethodStatus$lambda$16;
            }
        }, new DFS.AbstractNodeHandler<ClassDescriptor, JDKMemberStatus>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getJdkMethodStatus$2
            /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
            /* JADX WARN: Type inference failed for: r0v5, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
            /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
            /* JADX WARN: Type inference failed for: r0v7, types: [kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus, T] */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(ClassDescriptor javaClassDescriptor) {
                Intrinsics.checkNotNullParameter(javaClassDescriptor, "javaClassDescriptor");
                String signature = MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, javaClassDescriptor, computeJvmDescriptor$default);
                JvmBuiltInsSignatures jvmBuiltInsSignatures = JvmBuiltInsSignatures.INSTANCE;
                if (jvmBuiltInsSignatures.getHIDDEN_METHOD_SIGNATURES().contains(signature)) {
                    ref$ObjectRef.element = JvmBuiltInsCustomizer.JDKMemberStatus.HIDDEN;
                } else if (jvmBuiltInsSignatures.getVISIBLE_METHOD_SIGNATURES().contains(signature)) {
                    ref$ObjectRef.element = JvmBuiltInsCustomizer.JDKMemberStatus.VISIBLE;
                } else if (jvmBuiltInsSignatures.getDEPRECATED_LIST_METHODS().contains(signature)) {
                    ref$ObjectRef.element = JvmBuiltInsCustomizer.JDKMemberStatus.DEPRECATED_LIST_METHODS;
                } else if (jvmBuiltInsSignatures.getDROP_LIST_METHOD_SIGNATURES().contains(signature)) {
                    ref$ObjectRef.element = JvmBuiltInsCustomizer.JDKMemberStatus.DROP;
                }
                return ref$ObjectRef.element == null;
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public JvmBuiltInsCustomizer.JDKMemberStatus result() {
                JvmBuiltInsCustomizer.JDKMemberStatus jDKMemberStatus = ref$ObjectRef.element;
                return jDKMemberStatus == null ? JvmBuiltInsCustomizer.JDKMemberStatus.NOT_CONSIDERED : jDKMemberStatus;
            }
        });
        Intrinsics.checkNotNullExpressionValue(dfs, "dfs(...)");
        return (JDKMemberStatus) dfs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable getJdkMethodStatus$lambda$16(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, ClassDescriptor classDescriptor) {
        Collection<KotlinType> mo3719getSupertypes = classDescriptor.getTypeConstructor().mo3719getSupertypes();
        Intrinsics.checkNotNullExpressionValue(mo3719getSupertypes, "getSupertypes(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = mo3719getSupertypes.iterator();
        while (it.hasNext()) {
            ClassifierDescriptor mo3718getDeclarationDescriptor = ((KotlinType) it.next()).getConstructor().mo3718getDeclarationDescriptor();
            LazyJavaClassDescriptor lazyJavaClassDescriptor = null;
            ClassifierDescriptor original = mo3718getDeclarationDescriptor != null ? mo3718getDeclarationDescriptor.getOriginal() : null;
            ClassDescriptor classDescriptor2 = original instanceof ClassDescriptor ? (ClassDescriptor) original : null;
            if (classDescriptor2 != null && (lazyJavaClassDescriptor = jvmBuiltInsCustomizer.getJavaAnalogue(classDescriptor2)) == null) {
                lazyJavaClassDescriptor = classDescriptor2;
            }
            if (lazyJavaClassDescriptor != null) {
                arrayList.add(lazyJavaClassDescriptor);
            }
        }
        return arrayList;
    }

    private final Annotations getNotConsideredDeprecation() {
        return (Annotations) StorageKt.getValue(this.notConsideredDeprecation$delegate, this, (KProperty<?>) $$delegatedProperties[2]);
    }

    private final JvmBuiltIns.Settings getSettings() {
        return (JvmBuiltIns.Settings) StorageKt.getValue(this.settings$delegate, this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final boolean isMutabilityViolation(SimpleFunctionDescriptor simpleFunctionDescriptor, boolean z5) {
        DeclarationDescriptor containingDeclaration = simpleFunctionDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, null);
        if (z5 ^ JvmBuiltInsSignatures.INSTANCE.getMUTABLE_METHOD_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, (ClassDescriptor) containingDeclaration, computeJvmDescriptor$default))) {
            return true;
        }
        Boolean ifAny = DFS.ifAny(CollectionsKt.listOf(simpleFunctionDescriptor), new DFS.Neighbors() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$6
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public Iterable getNeighbors(Object obj) {
                Iterable isMutabilityViolation$lambda$13;
                isMutabilityViolation$lambda$13 = JvmBuiltInsCustomizer.isMutabilityViolation$lambda$13((CallableMemberDescriptor) obj);
                return isMutabilityViolation$lambda$13;
            }
        }, new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$7
            private final JvmBuiltInsCustomizer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Boolean isMutabilityViolation$lambda$14;
                isMutabilityViolation$lambda$14 = JvmBuiltInsCustomizer.isMutabilityViolation$lambda$14(this.arg$0, (CallableMemberDescriptor) obj);
                return isMutabilityViolation$lambda$14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(ifAny, "ifAny(...)");
        return ifAny.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable isMutabilityViolation$lambda$13(CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor.getOriginal().getOverriddenDescriptors();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean isMutabilityViolation$lambda$14(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, CallableMemberDescriptor callableMemberDescriptor) {
        boolean z5;
        if (callableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.DECLARATION) {
            JavaToKotlinClassMapper javaToKotlinClassMapper = jvmBuiltInsCustomizer.j2kClassMapper;
            DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
            Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            if (javaToKotlinClassMapper.isMutable((ClassDescriptor) containingDeclaration)) {
                z5 = true;
                return Boolean.valueOf(z5);
            }
        }
        z5 = false;
        return Boolean.valueOf(z5);
    }

    private final boolean isTrivialCopyConstructorFor(ConstructorDescriptor constructorDescriptor, ClassDescriptor classDescriptor) {
        if (constructorDescriptor.getValueParameters().size() == 1) {
            List<ValueParameterDescriptor> valueParameters = constructorDescriptor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            ClassifierDescriptor mo3718getDeclarationDescriptor = ((ValueParameterDescriptor) CollectionsKt.single((List) valueParameters)).getType().getConstructor().mo3718getDeclarationDescriptor();
            if (Intrinsics.areEqual(mo3718getDeclarationDescriptor != null ? DescriptorUtilsKt.getFqNameUnsafe(mo3718getDeclarationDescriptor) : null, DescriptorUtilsKt.getFqNameUnsafe(classDescriptor))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Annotations notConsideredDeprecation_delegate$lambda$1(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        return Annotations.Companion.create(CollectionsKt.listOf(AnnotationUtilKt.createDeprecatedAnnotation$default(jvmBuiltInsCustomizer.moduleDescriptor.getBuiltIns(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, true, 6, null)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor classDescriptor) {
        ClassDescriptor mapJavaToKotlin$default;
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (classDescriptor.getKind() != ClassKind.CLASS || !getSettings().isAdditionalBuiltInsFeatureSupported()) {
            return CollectionsKt.emptyList();
        }
        LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        if (javaAnalogue != null && (mapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(this.j2kClassMapper, DescriptorUtilsKt.getFqNameSafe(javaAnalogue), FallbackBuiltIns.Companion.getInstance(), null, 4, null)) != null) {
            TypeSubstitutor buildSubstitutor = MappingUtilKt.createMappedTypeParametersSubstitution(mapJavaToKotlin$default, javaAnalogue).buildSubstitutor();
            List<ClassConstructorDescriptor> constructors = javaAnalogue.getConstructors();
            ArrayList<ClassConstructorDescriptor> arrayList = new ArrayList();
            for (Object obj : constructors) {
                ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) obj;
                if (classConstructorDescriptor.getVisibility().isPublicAPI()) {
                    Collection<ClassConstructorDescriptor> constructors2 = mapJavaToKotlin$default.getConstructors();
                    Intrinsics.checkNotNullExpressionValue(constructors2, "getConstructors(...)");
                    Collection<ClassConstructorDescriptor> collection = constructors2;
                    if (!(collection instanceof Collection) || !collection.isEmpty()) {
                        for (ClassConstructorDescriptor classConstructorDescriptor2 : collection) {
                            Intrinsics.checkNotNull(classConstructorDescriptor2);
                            if (getConstructors$isEffectivelyTheSameAs(classConstructorDescriptor2, buildSubstitutor, classConstructorDescriptor)) {
                                break;
                            }
                        }
                    }
                    if (!isTrivialCopyConstructorFor(classConstructorDescriptor, classDescriptor) && !KotlinBuiltIns.isDeprecated(classConstructorDescriptor) && !JvmBuiltInsSignatures.INSTANCE.getHIDDEN_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, javaAnalogue, MethodSignatureMappingKt.computeJvmDescriptor$default(classConstructorDescriptor, false, false, 3, null)))) {
                        arrayList.add(obj);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (ClassConstructorDescriptor classConstructorDescriptor3 : arrayList) {
                FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder = classConstructorDescriptor3.newCopyBuilder();
                newCopyBuilder.setOwner(classDescriptor);
                newCopyBuilder.setReturnType(classDescriptor.getDefaultType());
                newCopyBuilder.setPreserveSourceElement();
                newCopyBuilder.setSubstitution(buildSubstitutor.getSubstitution());
                if (!JvmBuiltInsSignatures.INSTANCE.getVISIBLE_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, javaAnalogue, MethodSignatureMappingKt.computeJvmDescriptor$default(classConstructorDescriptor3, false, false, 3, null)))) {
                    newCopyBuilder.setAdditionalAnnotations(getNotConsideredDeprecation());
                }
                FunctionDescriptor build = newCopyBuilder.build();
                Intrinsics.checkNotNull(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                arrayList2.add((ClassConstructorDescriptor) build);
            }
            return arrayList2;
        }
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x019f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b8 A[SYNTHETIC] */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<SimpleFunctionDescriptor> getFunctions(final Name name, ClassDescriptor classDescriptor) {
        Name name2;
        Name name3;
        Annotations invoke;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (Intrinsics.areEqual(name, CloneableClassScope.Companion.getCLONE_NAME()) && (classDescriptor instanceof DeserializedClassDescriptor) && KotlinBuiltIns.isArrayOrPrimitiveArray(classDescriptor)) {
            DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) classDescriptor;
            List<ProtoBuf$Function> functionList = deserializedClassDescriptor.getClassProto().getFunctionList();
            Intrinsics.checkNotNullExpressionValue(functionList, "getFunctionList(...)");
            List<ProtoBuf$Function> list = functionList;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(NameResolverUtilKt.getName(deserializedClassDescriptor.getC().getNameResolver(), ((ProtoBuf$Function) it.next()).getName()), CloneableClassScope.Companion.getCLONE_NAME())) {
                        return CollectionsKt.emptyList();
                    }
                }
            }
            return CollectionsKt.listOf(createCloneForArray(deserializedClassDescriptor, (SimpleFunctionDescriptor) CollectionsKt.single(getCloneableType().getMemberScope().getContributedFunctions(name, NoLookupLocation.FROM_BUILTINS))));
        }
        if (!getSettings().isAdditionalBuiltInsFeatureSupported()) {
            return CollectionsKt.emptyList();
        }
        Collection<SimpleFunctionDescriptor> additionalFunctions = getAdditionalFunctions(classDescriptor, new Function1(name) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$$Lambda$4
            private final Name arg$0;

            {
                this.arg$0 = name;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Collection functions$lambda$5;
                functions$lambda$5 = JvmBuiltInsCustomizer.getFunctions$lambda$5(this.arg$0, (MemberScope) obj);
                return functions$lambda$5;
            }
        });
        ArrayList arrayList = new ArrayList();
        for (SimpleFunctionDescriptor simpleFunctionDescriptor : additionalFunctions) {
            DeclarationDescriptor containingDeclaration = simpleFunctionDescriptor.getContainingDeclaration();
            Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            FunctionDescriptor substitute = simpleFunctionDescriptor.substitute(MappingUtilKt.createMappedTypeParametersSubstitution((ClassDescriptor) containingDeclaration, classDescriptor).buildSubstitutor());
            Intrinsics.checkNotNull(substitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
            FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = ((SimpleFunctionDescriptor) substitute).newCopyBuilder();
            newCopyBuilder.setOwner(classDescriptor);
            newCopyBuilder.setDispatchReceiverParameter(classDescriptor.getThisAsReceiverParameter());
            newCopyBuilder.setPreserveSourceElement();
            int i5 = WhenMappings.$EnumSwitchMapping$0[getJdkMethodStatus(simpleFunctionDescriptor).ordinal()];
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = null;
            if (i5 != 1) {
                if (i5 == 2) {
                    Name name4 = simpleFunctionDescriptor.getName();
                    name2 = JvmBuiltInsCustomizerKt.GET_FIRST_LIST_NAME;
                    if (Intrinsics.areEqual(name4, name2)) {
                        invoke = this.deprecationForSomeOfTheListMethods.invoke(TuplesKt.to(simpleFunctionDescriptor.getName().asString(), "first"));
                    } else {
                        name3 = JvmBuiltInsCustomizerKt.GET_LAST_LIST_NAME;
                        if (!Intrinsics.areEqual(name4, name3)) {
                            throw new IllegalStateException(("Unexpected name: " + simpleFunctionDescriptor.getName()).toString());
                        }
                        invoke = this.deprecationForSomeOfTheListMethods.invoke(TuplesKt.to(simpleFunctionDescriptor.getName().asString(), "last"));
                    }
                    newCopyBuilder.setAdditionalAnnotations(invoke);
                } else if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 != 5) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    if (simpleFunctionDescriptor2 != null) {
                        arrayList.add(simpleFunctionDescriptor2);
                    }
                } else {
                    newCopyBuilder.setAdditionalAnnotations(getNotConsideredDeprecation());
                }
                SimpleFunctionDescriptor build = newCopyBuilder.build();
                Intrinsics.checkNotNull(build);
                simpleFunctionDescriptor2 = build;
                if (simpleFunctionDescriptor2 != null) {
                }
            } else {
                if (!ModalityUtilsKt.isFinalClass(classDescriptor)) {
                    newCopyBuilder.setHiddenForResolutionEverywhereBesideSupercalls();
                    SimpleFunctionDescriptor build2 = newCopyBuilder.build();
                    Intrinsics.checkNotNull(build2);
                    simpleFunctionDescriptor2 = build2;
                }
                if (simpleFunctionDescriptor2 != null) {
                }
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(classDescriptor);
        JvmBuiltInsSignatures jvmBuiltInsSignatures = JvmBuiltInsSignatures.INSTANCE;
        return jvmBuiltInsSignatures.isArrayOrPrimitiveArray(fqNameUnsafe) ? CollectionsKt.listOf((Object[]) new KotlinType[]{getCloneableType(), this.mockSerializableType}) : jvmBuiltInsSignatures.isSerializableInJava(fqNameUnsafe) ? CollectionsKt.listOf(this.mockSerializableType) : CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
    public boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        if (javaAnalogue == null || !functionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME())) {
            return true;
        }
        if (!getSettings().isAdditionalBuiltInsFeatureSupported()) {
            return false;
        }
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 3, null);
        LazyJavaClassMemberScope unsubstitutedMemberScope = javaAnalogue.getUnsubstitutedMemberScope();
        Name name = functionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Collection<SimpleFunctionDescriptor> contributedFunctions = unsubstitutedMemberScope.getContributedFunctions(name, NoLookupLocation.FROM_BUILTINS);
        if (!(contributedFunctions instanceof Collection) || !contributedFunctions.isEmpty()) {
            Iterator<T> it = contributedFunctions.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default((SimpleFunctionDescriptor) it.next(), false, false, 3, null), computeJvmDescriptor$default)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Set<Name> getFunctionsNames(ClassDescriptor classDescriptor) {
        LazyJavaClassMemberScope unsubstitutedMemberScope;
        Set<Name> functionNames;
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (!getSettings().isAdditionalBuiltInsFeatureSupported()) {
            return SetsKt.emptySet();
        }
        LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        return (javaAnalogue == null || (unsubstitutedMemberScope = javaAnalogue.getUnsubstitutedMemberScope()) == null || (functionNames = unsubstitutedMemberScope.getFunctionNames()) == null) ? SetsKt.emptySet() : functionNames;
    }
}
