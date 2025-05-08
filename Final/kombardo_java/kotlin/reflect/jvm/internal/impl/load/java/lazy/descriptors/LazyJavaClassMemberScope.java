package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.PropertiesConventionUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaForKotlinOverridePropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* loaded from: classes3.dex */
public final class LazyJavaClassMemberScope extends LazyJavaScope {
    private final NotNullLazyValue<List<ClassConstructorDescriptor>> constructors;
    private final NotNullLazyValue<Map<Name, JavaField>> enumEntryIndex;
    private final NotNullLazyValue<Set<Name>> generatedNestedClassNames;
    private final JavaClass jClass;
    private final NotNullLazyValue<Set<Name>> nestedClassIndex;
    private final MemoizedFunctionToNullable<Name, ClassDescriptor> nestedClasses;
    private final ClassDescriptor ownerDescriptor;
    private final boolean skipRefinement;

    public /* synthetic */ LazyJavaClassMemberScope(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, JavaClass javaClass, boolean z5, LazyJavaClassMemberScope lazyJavaClassMemberScope, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, classDescriptor, javaClass, z5, (i5 & 16) != 0 ? null : lazyJavaClassMemberScope);
    }

    private final void addAnnotationValueParameter(List<ValueParameterDescriptor> list, ConstructorDescriptor constructorDescriptor, int i5, JavaMethod javaMethod, KotlinType kotlinType, KotlinType kotlinType2) {
        Annotations empty = Annotations.Companion.getEMPTY();
        Name name = javaMethod.getName();
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(...)");
        list.add(new ValueParameterDescriptorImpl(constructorDescriptor, null, i5, empty, name, makeNotNullable, javaMethod.getHasAnnotationParameterDefaultValue(), false, false, kotlinType2 != null ? TypeUtils.makeNotNullable(kotlinType2) : null, getC().getComponents().getSourceElementFactory().source(javaMethod)));
    }

    private final void addFunctionFromSupertypes(Collection<SimpleFunctionDescriptor> collection, Name name, Collection<? extends SimpleFunctionDescriptor> collection2, boolean z5) {
        Collection<? extends SimpleFunctionDescriptor> resolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, collection2, collection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(...)");
        if (!z5) {
            collection.addAll(resolveOverridesForNonStaticMembers);
            return;
        }
        Collection<? extends SimpleFunctionDescriptor> collection3 = resolveOverridesForNonStaticMembers;
        List plus = CollectionsKt.plus((Collection) collection, (Iterable) collection3);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection3, 10));
        for (SimpleFunctionDescriptor simpleFunctionDescriptor : collection3) {
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenSpecialBuiltin(simpleFunctionDescriptor);
            if (simpleFunctionDescriptor2 == null) {
                Intrinsics.checkNotNull(simpleFunctionDescriptor);
            } else {
                Intrinsics.checkNotNull(simpleFunctionDescriptor);
                simpleFunctionDescriptor = createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(simpleFunctionDescriptor, simpleFunctionDescriptor2, plus);
            }
            arrayList.add(simpleFunctionDescriptor);
        }
        collection.addAll(arrayList);
    }

    private final void addOverriddenSpecialMethods(Name name, Collection<? extends SimpleFunctionDescriptor> collection, Collection<? extends SimpleFunctionDescriptor> collection2, Collection<SimpleFunctionDescriptor> collection3, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        for (SimpleFunctionDescriptor simpleFunctionDescriptor : collection2) {
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection3, obtainOverrideForBuiltinWithDifferentJvmName(simpleFunctionDescriptor, function1, name, collection));
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection3, obtainOverrideForBuiltInWithErasedValueParametersInJava(simpleFunctionDescriptor, function1, collection));
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection3, obtainOverrideForSuspend(simpleFunctionDescriptor, function1));
        }
    }

    private final void addPropertyOverrideByMethod(Set<? extends PropertyDescriptor> set, Collection<PropertyDescriptor> collection, Set<PropertyDescriptor> set2, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        for (PropertyDescriptor propertyDescriptor : set) {
            JavaPropertyDescriptor createPropertyDescriptorByMethods = createPropertyDescriptorByMethods(propertyDescriptor, function1);
            if (createPropertyDescriptorByMethods != null) {
                collection.add(createPropertyDescriptorByMethods);
                if (set2 != null) {
                    set2.add(propertyDescriptor);
                    return;
                }
                return;
            }
        }
    }

    private final void computeAnnotationProperties(Name name, Collection<PropertyDescriptor> collection) {
        JavaMethod javaMethod = (JavaMethod) CollectionsKt.singleOrNull(getDeclaredMemberIndex().invoke().findMethodsByName(name));
        if (javaMethod == null) {
            return;
        }
        collection.add(createPropertyDescriptorWithDefaultGetter$default(this, javaMethod, null, Modality.FINAL, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean computeMemberIndex$lambda$0(JavaMember it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !it.isStatic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection computeNonDeclaredProperties$lambda$36(LazyJavaClassMemberScope lazyJavaClassMemberScope, Name it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return lazyJavaClassMemberScope.searchMethodsByNameWithoutBuiltinMagic(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection computeNonDeclaredProperties$lambda$37(LazyJavaClassMemberScope lazyJavaClassMemberScope, Name it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return lazyJavaClassMemberScope.searchMethodsInSupertypesWithoutBuiltinMagic(it);
    }

    private final Collection<KotlinType> computeSupertypes() {
        if (!this.skipRefinement) {
            return getC().getComponents().getKotlinTypeChecker().getKotlinTypeRefiner().refineSupertypes(getOwnerDescriptor());
        }
        Collection<KotlinType> mo3719getSupertypes = getOwnerDescriptor().getTypeConstructor().mo3719getSupertypes();
        Intrinsics.checkNotNullExpressionValue(mo3719getSupertypes, "getSupertypes(...)");
        return mo3719getSupertypes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.Collection] */
    public static final List constructors$lambda$5(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        Collection<JavaConstructor> constructors = lazyJavaClassMemberScope.jClass.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        Iterator<JavaConstructor> it = constructors.iterator();
        while (it.hasNext()) {
            arrayList.add(lazyJavaClassMemberScope.resolveConstructor(it.next()));
        }
        if (lazyJavaClassMemberScope.jClass.isRecord()) {
            ClassConstructorDescriptor createDefaultRecordConstructor = lazyJavaClassMemberScope.createDefaultRecordConstructor();
            String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(createDefaultRecordConstructor, false, false, 2, null);
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default((ClassConstructorDescriptor) it2.next(), false, false, 2, null), computeJvmDescriptor$default)) {
                        break;
                    }
                }
            }
            arrayList.add(createDefaultRecordConstructor);
            lazyJavaResolverContext.getComponents().getJavaResolverCache().recordConstructor(lazyJavaClassMemberScope.jClass, createDefaultRecordConstructor);
        }
        lazyJavaResolverContext.getComponents().getSyntheticPartsProvider().generateConstructors(lazyJavaClassMemberScope.getOwnerDescriptor(), arrayList, lazyJavaResolverContext);
        SignatureEnhancement signatureEnhancement = lazyJavaResolverContext.getComponents().getSignatureEnhancement();
        boolean isEmpty = arrayList.isEmpty();
        ArrayList arrayList2 = arrayList;
        if (isEmpty) {
            arrayList2 = CollectionsKt.listOfNotNull(lazyJavaClassMemberScope.createDefaultConstructor());
        }
        return CollectionsKt.toList(signatureEnhancement.enhanceSignatures(lazyJavaResolverContext, arrayList2));
    }

    private final List<ValueParameterDescriptor> createAnnotationConstructorParameters(ClassConstructorDescriptorImpl classConstructorDescriptorImpl) {
        Pair pair;
        Collection<JavaMethod> methods = this.jClass.getMethods();
        ArrayList arrayList = new ArrayList(methods.size());
        JavaTypeAttributes attributes$default = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, true, false, null, 6, null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : methods) {
            if (Intrinsics.areEqual(((JavaMethod) obj).getName(), JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        Pair pair2 = new Pair(arrayList2, arrayList3);
        List list = (List) pair2.component1();
        List<JavaMethod> list2 = (List) pair2.component2();
        list.size();
        JavaMethod javaMethod = (JavaMethod) CollectionsKt.firstOrNull(list);
        if (javaMethod != null) {
            JavaType returnType = javaMethod.getReturnType();
            if (returnType instanceof JavaArrayType) {
                JavaArrayType javaArrayType = (JavaArrayType) returnType;
                pair = new Pair(getC().getTypeResolver().transformArrayType(javaArrayType, attributes$default, true), getC().getTypeResolver().transformJavaType(javaArrayType.getComponentType(), attributes$default));
            } else {
                pair = new Pair(getC().getTypeResolver().transformJavaType(returnType, attributes$default), null);
            }
            addAnnotationValueParameter(arrayList, classConstructorDescriptorImpl, 0, javaMethod, (KotlinType) pair.component1(), (KotlinType) pair.component2());
        }
        int i5 = 0;
        int i6 = javaMethod == null ? 0 : 1;
        for (JavaMethod javaMethod2 : list2) {
            addAnnotationValueParameter(arrayList, classConstructorDescriptorImpl, i5 + i6, javaMethod2, getC().getTypeResolver().transformJavaType(javaMethod2.getReturnType(), attributes$default), null);
            i5++;
        }
        return arrayList;
    }

    private final ClassConstructorDescriptor createDefaultConstructor() {
        boolean isAnnotationType = this.jClass.isAnnotationType();
        if ((this.jClass.isInterface() || !this.jClass.hasDefaultConstructor()) && !isAnnotationType) {
            return null;
        }
        ClassDescriptor ownerDescriptor = getOwnerDescriptor();
        JavaClassConstructorDescriptor createJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(ownerDescriptor, Annotations.Companion.getEMPTY(), true, getC().getComponents().getSourceElementFactory().source(this.jClass));
        Intrinsics.checkNotNullExpressionValue(createJavaConstructor, "createJavaConstructor(...)");
        List<ValueParameterDescriptor> createAnnotationConstructorParameters = isAnnotationType ? createAnnotationConstructorParameters(createJavaConstructor) : Collections.emptyList();
        createJavaConstructor.setHasSynthesizedParameterNames(false);
        createJavaConstructor.initialize(createAnnotationConstructorParameters, getConstructorVisibility(ownerDescriptor));
        createJavaConstructor.setHasStableParameterNames(true);
        createJavaConstructor.setReturnType(ownerDescriptor.getDefaultType());
        getC().getComponents().getJavaResolverCache().recordConstructor(this.jClass, createJavaConstructor);
        return createJavaConstructor;
    }

    private final ClassConstructorDescriptor createDefaultRecordConstructor() {
        ClassDescriptor ownerDescriptor = getOwnerDescriptor();
        JavaClassConstructorDescriptor createJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(ownerDescriptor, Annotations.Companion.getEMPTY(), true, getC().getComponents().getSourceElementFactory().source(this.jClass));
        Intrinsics.checkNotNullExpressionValue(createJavaConstructor, "createJavaConstructor(...)");
        List<ValueParameterDescriptor> createRecordConstructorParameters = createRecordConstructorParameters(createJavaConstructor);
        createJavaConstructor.setHasSynthesizedParameterNames(false);
        createJavaConstructor.initialize(createRecordConstructorParameters, getConstructorVisibility(ownerDescriptor));
        createJavaConstructor.setHasStableParameterNames(false);
        createJavaConstructor.setReturnType(ownerDescriptor.getDefaultType());
        return createJavaConstructor;
    }

    private final SimpleFunctionDescriptor createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(SimpleFunctionDescriptor simpleFunctionDescriptor, CallableDescriptor callableDescriptor, Collection<? extends SimpleFunctionDescriptor> collection) {
        Collection<? extends SimpleFunctionDescriptor> collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return simpleFunctionDescriptor;
        }
        for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : collection2) {
            if (!Intrinsics.areEqual(simpleFunctionDescriptor, simpleFunctionDescriptor2) && simpleFunctionDescriptor2.getInitialSignatureDescriptor() == null && doesOverride(simpleFunctionDescriptor2, callableDescriptor)) {
                SimpleFunctionDescriptor build = simpleFunctionDescriptor.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
                Intrinsics.checkNotNull(build);
                return build;
            }
        }
        return simpleFunctionDescriptor;
    }

    private final SimpleFunctionDescriptor createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(FunctionDescriptor functionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        Object obj;
        Name name = functionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Iterator<T> it = function1.invoke(name).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (hasSameJvmDescriptorButDoesNotOverride((SimpleFunctionDescriptor) obj, functionDescriptor)) {
                break;
            }
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        List<ValueParameterDescriptor> list = valueParameters;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((ValueParameterDescriptor) it2.next()).getType());
        }
        List<ValueParameterDescriptor> valueParameters2 = simpleFunctionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
        newCopyBuilder.setValueParameters(UtilKt.copyValueParameters(arrayList, valueParameters2, functionDescriptor));
        newCopyBuilder.setSignatureChange();
        newCopyBuilder.setPreserveSourceElement();
        newCopyBuilder.putUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS, Boolean.TRUE);
        return newCopyBuilder.build();
    }

    private final JavaPropertyDescriptor createPropertyDescriptorByMethods(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl = null;
        if (!doesClassOverridesProperty(propertyDescriptor, function1)) {
            return null;
        }
        SimpleFunctionDescriptor findGetterOverride = findGetterOverride(propertyDescriptor, function1);
        Intrinsics.checkNotNull(findGetterOverride);
        if (propertyDescriptor.isVar()) {
            simpleFunctionDescriptor = findSetterOverride(propertyDescriptor, function1);
            Intrinsics.checkNotNull(simpleFunctionDescriptor);
        } else {
            simpleFunctionDescriptor = null;
        }
        if (simpleFunctionDescriptor != null) {
            simpleFunctionDescriptor.getModality();
            findGetterOverride.getModality();
        }
        JavaForKotlinOverridePropertyDescriptor javaForKotlinOverridePropertyDescriptor = new JavaForKotlinOverridePropertyDescriptor(getOwnerDescriptor(), findGetterOverride, simpleFunctionDescriptor, propertyDescriptor);
        KotlinType returnType = findGetterOverride.getReturnType();
        Intrinsics.checkNotNull(returnType);
        javaForKotlinOverridePropertyDescriptor.setType(returnType, CollectionsKt.emptyList(), getDispatchReceiverParameter(), null, CollectionsKt.emptyList());
        PropertyGetterDescriptorImpl createGetter = DescriptorFactory.createGetter(javaForKotlinOverridePropertyDescriptor, findGetterOverride.getAnnotations(), false, false, false, findGetterOverride.getSource());
        createGetter.setInitialSignatureDescriptor(findGetterOverride);
        createGetter.initialize(javaForKotlinOverridePropertyDescriptor.getType());
        Intrinsics.checkNotNullExpressionValue(createGetter, "apply(...)");
        if (simpleFunctionDescriptor != null) {
            List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) CollectionsKt.firstOrNull((List) valueParameters);
            if (valueParameterDescriptor == null) {
                throw new AssertionError("No parameter found for " + simpleFunctionDescriptor);
            }
            propertySetterDescriptorImpl = DescriptorFactory.createSetter(javaForKotlinOverridePropertyDescriptor, simpleFunctionDescriptor.getAnnotations(), valueParameterDescriptor.getAnnotations(), false, false, false, simpleFunctionDescriptor.getVisibility(), simpleFunctionDescriptor.getSource());
            propertySetterDescriptorImpl.setInitialSignatureDescriptor(simpleFunctionDescriptor);
        }
        javaForKotlinOverridePropertyDescriptor.initialize(createGetter, propertySetterDescriptorImpl);
        return javaForKotlinOverridePropertyDescriptor;
    }

    private final JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter(JavaMethod javaMethod, KotlinType kotlinType, Modality modality) {
        JavaPropertyDescriptor create = JavaPropertyDescriptor.create(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(getC(), javaMethod), modality, UtilsKt.toDescriptorVisibility(javaMethod.getVisibility()), false, javaMethod.getName(), getC().getComponents().getSourceElementFactory().source(javaMethod), false);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        PropertyGetterDescriptorImpl createDefaultGetter = DescriptorFactory.createDefaultGetter(create, Annotations.Companion.getEMPTY());
        Intrinsics.checkNotNullExpressionValue(createDefaultGetter, "createDefaultGetter(...)");
        create.initialize(createDefaultGetter, null);
        KotlinType computeMethodReturnType = kotlinType == null ? computeMethodReturnType(javaMethod, ContextKt.childForMethod$default(getC(), create, javaMethod, 0, 4, null)) : kotlinType;
        create.setType(computeMethodReturnType, CollectionsKt.emptyList(), getDispatchReceiverParameter(), null, CollectionsKt.emptyList());
        createDefaultGetter.initialize(computeMethodReturnType);
        return create;
    }

    static /* synthetic */ JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter$default(LazyJavaClassMemberScope lazyJavaClassMemberScope, JavaMethod javaMethod, KotlinType kotlinType, Modality modality, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            kotlinType = null;
        }
        return lazyJavaClassMemberScope.createPropertyDescriptorWithDefaultGetter(javaMethod, kotlinType, modality);
    }

    private final List<ValueParameterDescriptor> createRecordConstructorParameters(ClassConstructorDescriptorImpl classConstructorDescriptorImpl) {
        Collection<JavaRecordComponent> recordComponents = this.jClass.getRecordComponents();
        ArrayList arrayList = new ArrayList(recordComponents.size());
        JavaTypeAttributes attributes$default = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 6, null);
        Iterator<T> it = recordComponents.iterator();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (!it.hasNext()) {
                return arrayList;
            }
            i5 = i6 + 1;
            JavaRecordComponent javaRecordComponent = (JavaRecordComponent) it.next();
            KotlinType transformJavaType = getC().getTypeResolver().transformJavaType(javaRecordComponent.getType(), attributes$default);
            arrayList.add(new ValueParameterDescriptorImpl(classConstructorDescriptorImpl, null, i6, Annotations.Companion.getEMPTY(), javaRecordComponent.getName(), transformJavaType, false, false, false, javaRecordComponent.isVararg() ? getC().getComponents().getModule().getBuiltIns().getArrayElementType(transformJavaType) : null, getC().getComponents().getSourceElementFactory().source(javaRecordComponent)));
        }
    }

    private final SimpleFunctionDescriptor createRenamedCopy(SimpleFunctionDescriptor simpleFunctionDescriptor, Name name) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        newCopyBuilder.setName(name);
        newCopyBuilder.setSignatureChange();
        newCopyBuilder.setPreserveSourceElement();
        SimpleFunctionDescriptor build = newCopyBuilder.build();
        Intrinsics.checkNotNull(build);
        return build;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final SimpleFunctionDescriptor createSuspendView(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        FqName fqName;
        FqNameUnsafe fqNameUnsafe;
        List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) CollectionsKt.lastOrNull((List) valueParameters);
        if (valueParameterDescriptor != null) {
            ClassifierDescriptor mo3718getDeclarationDescriptor = valueParameterDescriptor.getType().getConstructor().mo3718getDeclarationDescriptor();
            if (mo3718getDeclarationDescriptor != null && (fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(mo3718getDeclarationDescriptor)) != null) {
                if (!fqNameUnsafe.isSafe()) {
                    fqNameUnsafe = null;
                }
                if (fqNameUnsafe != null) {
                    fqName = fqNameUnsafe.toSafe();
                    if (!Intrinsics.areEqual(fqName, StandardNames.CONTINUATION_INTERFACE_FQ_NAME)) {
                        valueParameterDescriptor = null;
                    }
                    if (valueParameterDescriptor != null) {
                        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
                        List<ValueParameterDescriptor> valueParameters2 = simpleFunctionDescriptor.getValueParameters();
                        Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
                        SimpleFunctionDescriptor build = newCopyBuilder.setValueParameters(CollectionsKt.dropLast(valueParameters2, 1)).setReturnType(valueParameterDescriptor.getType().getArguments().get(0).getType()).build();
                        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImpl = (SimpleFunctionDescriptorImpl) build;
                        if (simpleFunctionDescriptorImpl != null) {
                            simpleFunctionDescriptorImpl.setSuspend(true);
                        }
                        return build;
                    }
                }
            }
            fqName = null;
            if (!Intrinsics.areEqual(fqName, StandardNames.CONTINUATION_INTERFACE_FQ_NAME)) {
            }
            if (valueParameterDescriptor != null) {
            }
        }
        return null;
    }

    private final boolean doesClassOverridesProperty(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (JavaDescriptorUtilKt.isJavaField(propertyDescriptor)) {
            return false;
        }
        SimpleFunctionDescriptor findGetterOverride = findGetterOverride(propertyDescriptor, function1);
        SimpleFunctionDescriptor findSetterOverride = findSetterOverride(propertyDescriptor, function1);
        if (findGetterOverride == null) {
            return false;
        }
        if (propertyDescriptor.isVar()) {
            return findSetterOverride != null && findSetterOverride.getModality() == findGetterOverride.getModality();
        }
        return true;
    }

    private final boolean doesOverride(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverridingUtil.OverrideCompatibilityInfo.Result result = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(callableDescriptor2, callableDescriptor, true).getResult();
        Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
        return result == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE && !JavaIncompatibilityRulesOverridabilityCondition.Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(callableDescriptor2, callableDescriptor);
    }

    private final boolean doesOverrideRenamedBuiltins(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        SpecialGenericSignatures.Companion companion = SpecialGenericSignatures.Companion;
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Name builtinFunctionNamesByJvmName = companion.getBuiltinFunctionNamesByJvmName(name);
        if (builtinFunctionNamesByJvmName == null) {
            return false;
        }
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(builtinFunctionNamesByJvmName);
        ArrayList arrayList = new ArrayList();
        for (Object obj : functionsFromSupertypes) {
            if (SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName((SimpleFunctionDescriptor) obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        SimpleFunctionDescriptor createRenamedCopy = createRenamedCopy(simpleFunctionDescriptor, builtinFunctionNamesByJvmName);
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (doesOverrideRenamedDescriptor((SimpleFunctionDescriptor) it.next(), createRenamedCopy)) {
                return true;
            }
        }
        return false;
    }

    private final boolean doesOverrideRenamedDescriptor(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        if (BuiltinMethodsWithDifferentJvmName.INSTANCE.isRemoveAtByIndex(simpleFunctionDescriptor)) {
            functionDescriptor = functionDescriptor.getOriginal();
        }
        Intrinsics.checkNotNull(functionDescriptor);
        return doesOverride(functionDescriptor, simpleFunctionDescriptor);
    }

    private final boolean doesOverrideSuspendFunction(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        SimpleFunctionDescriptor createSuspendView = createSuspendView(simpleFunctionDescriptor);
        if (createSuspendView == null) {
            return false;
        }
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name);
        if ((functionsFromSupertypes instanceof Collection) && functionsFromSupertypes.isEmpty()) {
            return false;
        }
        for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : functionsFromSupertypes) {
            if (simpleFunctionDescriptor2.isSuspend() && doesOverride(createSuspendView, simpleFunctionDescriptor2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map enumEntryIndex$lambda$53(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        Collection<JavaField> fields = lazyJavaClassMemberScope.jClass.getFields();
        ArrayList arrayList = new ArrayList();
        for (Object obj : fields) {
            if (((JavaField) obj).isEnumEntry()) {
                arrayList.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj2 : arrayList) {
            linkedHashMap.put(((JavaField) obj2).getName(), obj2);
        }
        return linkedHashMap;
    }

    private final SimpleFunctionDescriptor findGetterByName(PropertyDescriptor propertyDescriptor, String str, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        Name identifier = Name.identifier(str);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        Iterator<T> it = function1.invoke(identifier).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 0) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                KotlinType returnType = simpleFunctionDescriptor2.getReturnType();
                if (returnType == null ? false : kotlinTypeChecker.isSubtypeOf(returnType, propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private final SimpleFunctionDescriptor findGetterOverride(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        PropertyGetterDescriptor propertyGetterDescriptor = getter != null ? (PropertyGetterDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(getter) : null;
        String builtinSpecialPropertyGetterName = propertyGetterDescriptor != null ? ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(propertyGetterDescriptor) : null;
        if (builtinSpecialPropertyGetterName != null && !SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(getOwnerDescriptor(), propertyGetterDescriptor)) {
            return findGetterByName(propertyDescriptor, builtinSpecialPropertyGetterName, function1);
        }
        String asString = propertyDescriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return findGetterByName(propertyDescriptor, JvmAbi.getterName(asString), function1);
    }

    private final SimpleFunctionDescriptor findSetterOverride(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        KotlinType returnType;
        String asString = propertyDescriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        Name identifier = Name.identifier(JvmAbi.setterName(asString));
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        Iterator<T> it = function1.invoke(identifier).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 1 && (returnType = simpleFunctionDescriptor2.getReturnType()) != null && KotlinBuiltIns.isUnit(returnType)) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor2.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                if (kotlinTypeChecker.equalTypes(((ValueParameterDescriptor) CollectionsKt.single((List) valueParameters)).getType(), propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set generatedNestedClassNames$lambda$50(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        return CollectionsKt.toSet(lazyJavaResolverContext.getComponents().getSyntheticPartsProvider().getNestedClassNames(lazyJavaClassMemberScope.getOwnerDescriptor(), lazyJavaResolverContext));
    }

    private final DescriptorVisibility getConstructorVisibility(ClassDescriptor classDescriptor) {
        DescriptorVisibility visibility = classDescriptor.getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
        if (!Intrinsics.areEqual(visibility, JavaDescriptorVisibilities.PROTECTED_STATIC_VISIBILITY)) {
            return visibility;
        }
        DescriptorVisibility PROTECTED_AND_PACKAGE = JavaDescriptorVisibilities.PROTECTED_AND_PACKAGE;
        Intrinsics.checkNotNullExpressionValue(PROTECTED_AND_PACKAGE, "PROTECTED_AND_PACKAGE");
        return PROTECTED_AND_PACKAGE;
    }

    private final Set<SimpleFunctionDescriptor> getFunctionsFromSupertypes(Name name) {
        Collection<KotlinType> computeSupertypes = computeSupertypes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = computeSupertypes.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(linkedHashSet, ((KotlinType) it.next()).getMemberScope().getContributedFunctions(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    private final Set<PropertyDescriptor> getPropertiesFromSupertypes(Name name) {
        Collection<KotlinType> computeSupertypes = computeSupertypes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = computeSupertypes.iterator();
        while (it.hasNext()) {
            Collection<? extends PropertyDescriptor> contributedVariables = ((KotlinType) it.next()).getMemberScope().getContributedVariables(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(contributedVariables, 10));
            Iterator<T> it2 = contributedVariables.iterator();
            while (it2.hasNext()) {
                arrayList2.add((PropertyDescriptor) it2.next());
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        return CollectionsKt.toSet(arrayList);
    }

    private final boolean hasSameJvmDescriptorButDoesNotOverride(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 2, null);
        FunctionDescriptor original = functionDescriptor.getOriginal();
        Intrinsics.checkNotNullExpressionValue(original, "getOriginal(...)");
        return Intrinsics.areEqual(computeJvmDescriptor$default, MethodSignatureMappingKt.computeJvmDescriptor$default(original, false, false, 2, null)) && !doesOverride(simpleFunctionDescriptor, functionDescriptor);
    }

    private final boolean isVisibleAsFunctionInCurrentClass(final SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        List<Name> propertyNamesCandidatesByAccessorName = PropertiesConventionUtilKt.getPropertyNamesCandidatesByAccessorName(name);
        if (!(propertyNamesCandidatesByAccessorName instanceof Collection) || !propertyNamesCandidatesByAccessorName.isEmpty()) {
            Iterator<T> it = propertyNamesCandidatesByAccessorName.iterator();
            while (it.hasNext()) {
                Set<PropertyDescriptor> propertiesFromSupertypes = getPropertiesFromSupertypes((Name) it.next());
                if (!(propertiesFromSupertypes instanceof Collection) || !propertiesFromSupertypes.isEmpty()) {
                    for (PropertyDescriptor propertyDescriptor : propertiesFromSupertypes) {
                        if (doesClassOverridesProperty(propertyDescriptor, new Function1(simpleFunctionDescriptor, this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$6
                            private final SimpleFunctionDescriptor arg$0;
                            private final LazyJavaClassMemberScope arg$1;

                            {
                                this.arg$0 = simpleFunctionDescriptor;
                                this.arg$1 = this;
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public Object invoke(Object obj) {
                                Collection isVisibleAsFunctionInCurrentClass$lambda$8$lambda$7$lambda$6;
                                isVisibleAsFunctionInCurrentClass$lambda$8$lambda$7$lambda$6 = LazyJavaClassMemberScope.isVisibleAsFunctionInCurrentClass$lambda$8$lambda$7$lambda$6(this.arg$0, this.arg$1, (Name) obj);
                                return isVisibleAsFunctionInCurrentClass$lambda$8$lambda$7$lambda$6;
                            }
                        })) {
                            if (!propertyDescriptor.isVar()) {
                                String asString = simpleFunctionDescriptor.getName().asString();
                                Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
                                if (!JvmAbi.isSetterName(asString)) {
                                }
                            }
                            return false;
                        }
                    }
                }
            }
        }
        return (doesOverrideRenamedBuiltins(simpleFunctionDescriptor) || shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(simpleFunctionDescriptor) || doesOverrideSuspendFunction(simpleFunctionDescriptor)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection isVisibleAsFunctionInCurrentClass$lambda$8$lambda$7$lambda$6(SimpleFunctionDescriptor simpleFunctionDescriptor, LazyJavaClassMemberScope lazyJavaClassMemberScope, Name accessorName) {
        Intrinsics.checkNotNullParameter(accessorName, "accessorName");
        return Intrinsics.areEqual(simpleFunctionDescriptor.getName(), accessorName) ? CollectionsKt.listOf(simpleFunctionDescriptor) : CollectionsKt.plus((Collection) lazyJavaClassMemberScope.searchMethodsByNameWithoutBuiltinMagic(accessorName), (Iterable) lazyJavaClassMemberScope.searchMethodsInSupertypesWithoutBuiltinMagic(accessorName));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set nestedClassIndex$lambda$49(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        return CollectionsKt.toSet(lazyJavaClassMemberScope.jClass.getInnerClassNames());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClassDescriptor nestedClasses$lambda$59(final LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext, Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (lazyJavaClassMemberScope.nestedClassIndex.invoke().contains(name)) {
            JavaClassFinder finder = lazyJavaResolverContext.getComponents().getFinder();
            ClassId classId = DescriptorUtilsKt.getClassId(lazyJavaClassMemberScope.getOwnerDescriptor());
            Intrinsics.checkNotNull(classId);
            JavaClass findClass = finder.findClass(new JavaClassFinder.Request(classId.createNestedClassId(name), null, lazyJavaClassMemberScope.jClass, 2, null));
            if (findClass == null) {
                return null;
            }
            LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(lazyJavaResolverContext, lazyJavaClassMemberScope.getOwnerDescriptor(), findClass, null, 8, null);
            lazyJavaResolverContext.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
            return lazyJavaClassDescriptor;
        }
        if (!lazyJavaClassMemberScope.generatedNestedClassNames.invoke().contains(name)) {
            JavaField javaField = lazyJavaClassMemberScope.enumEntryIndex.invoke().get(name);
            if (javaField == null) {
                return null;
            }
            return EnumEntrySyntheticClassDescriptor.create(lazyJavaResolverContext.getStorageManager(), lazyJavaClassMemberScope.getOwnerDescriptor(), name, lazyJavaResolverContext.getStorageManager().createLazyValue(new Function0(lazyJavaClassMemberScope) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$9
                private final LazyJavaClassMemberScope arg$0;

                {
                    this.arg$0 = lazyJavaClassMemberScope;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Set nestedClasses$lambda$59$lambda$58;
                    nestedClasses$lambda$59$lambda$58 = LazyJavaClassMemberScope.nestedClasses$lambda$59$lambda$58(this.arg$0);
                    return nestedClasses$lambda$59$lambda$58;
                }
            }), LazyJavaAnnotationsKt.resolveAnnotations(lazyJavaResolverContext, javaField), lazyJavaResolverContext.getComponents().getSourceElementFactory().source(javaField));
        }
        List<ClassDescriptor> createListBuilder = CollectionsKt.createListBuilder();
        lazyJavaResolverContext.getComponents().getSyntheticPartsProvider().generateNestedClass(lazyJavaClassMemberScope.getOwnerDescriptor(), name, createListBuilder, lazyJavaResolverContext);
        List build = CollectionsKt.build(createListBuilder);
        int size = build.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return (ClassDescriptor) CollectionsKt.single(build);
        }
        throw new IllegalStateException(("Multiple classes with same name are generated: " + build).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set nestedClasses$lambda$59$lambda$58(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        return SetsKt.plus((Set) lazyJavaClassMemberScope.getFunctionNames(), (Iterable) lazyJavaClassMemberScope.getVariableNames());
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltInWithErasedValueParametersInJava(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1, Collection<? extends SimpleFunctionDescriptor> collection) {
        SimpleFunctionDescriptor createOverrideForBuiltinFunctionWithErasedParameterIfNeeded;
        FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor);
        if (overriddenBuiltinFunctionWithErasedValueParametersInJava == null || (createOverrideForBuiltinFunctionWithErasedParameterIfNeeded = createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(overriddenBuiltinFunctionWithErasedValueParametersInJava, function1)) == null) {
            return null;
        }
        if (!isVisibleAsFunctionInCurrentClass(createOverrideForBuiltinFunctionWithErasedParameterIfNeeded)) {
            createOverrideForBuiltinFunctionWithErasedParameterIfNeeded = null;
        }
        if (createOverrideForBuiltinFunctionWithErasedParameterIfNeeded != null) {
            return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(createOverrideForBuiltinFunctionWithErasedParameterIfNeeded, overriddenBuiltinFunctionWithErasedValueParametersInJava, collection);
        }
        return null;
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltinWithDifferentJvmName(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1, Name name, Collection<? extends SimpleFunctionDescriptor> collection) {
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(simpleFunctionDescriptor);
        if (simpleFunctionDescriptor2 == null) {
            return null;
        }
        String jvmMethodNameIfSpecial = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(simpleFunctionDescriptor2);
        Intrinsics.checkNotNull(jvmMethodNameIfSpecial);
        Name identifier = Name.identifier(jvmMethodNameIfSpecial);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        Iterator<? extends SimpleFunctionDescriptor> it = function1.invoke(identifier).iterator();
        while (it.hasNext()) {
            SimpleFunctionDescriptor createRenamedCopy = createRenamedCopy(it.next(), name);
            if (doesOverrideRenamedDescriptor(simpleFunctionDescriptor2, createRenamedCopy)) {
                return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(createRenamedCopy, simpleFunctionDescriptor2, collection);
            }
        }
        return null;
    }

    private final SimpleFunctionDescriptor obtainOverrideForSuspend(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (!simpleFunctionDescriptor.isSuspend()) {
            return null;
        }
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Iterator<T> it = function1.invoke(name).iterator();
        while (it.hasNext()) {
            SimpleFunctionDescriptor createSuspendView = createSuspendView((SimpleFunctionDescriptor) it.next());
            if (createSuspendView == null || !doesOverride(createSuspendView, simpleFunctionDescriptor)) {
                createSuspendView = null;
            }
            if (createSuspendView != null) {
                return createSuspendView;
            }
        }
        return null;
    }

    private final JavaClassConstructorDescriptor resolveConstructor(JavaConstructor javaConstructor) {
        ClassDescriptor ownerDescriptor = getOwnerDescriptor();
        JavaClassConstructorDescriptor createJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(ownerDescriptor, LazyJavaAnnotationsKt.resolveAnnotations(getC(), javaConstructor), false, getC().getComponents().getSourceElementFactory().source(javaConstructor));
        Intrinsics.checkNotNullExpressionValue(createJavaConstructor, "createJavaConstructor(...)");
        LazyJavaResolverContext childForMethod = ContextKt.childForMethod(getC(), createJavaConstructor, javaConstructor, ownerDescriptor.getDeclaredTypeParameters().size());
        LazyJavaScope.ResolvedValueParameters resolveValueParameters = resolveValueParameters(childForMethod, createJavaConstructor, javaConstructor.getValueParameters());
        List<TypeParameterDescriptor> declaredTypeParameters = ownerDescriptor.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
        List<TypeParameterDescriptor> list = declaredTypeParameters;
        List<JavaTypeParameter> typeParameters = javaConstructor.getTypeParameters();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            TypeParameterDescriptor resolveTypeParameter = childForMethod.getTypeParameterResolver().resolveTypeParameter((JavaTypeParameter) it.next());
            Intrinsics.checkNotNull(resolveTypeParameter);
            arrayList.add(resolveTypeParameter);
        }
        createJavaConstructor.initialize(resolveValueParameters.getDescriptors(), UtilsKt.toDescriptorVisibility(javaConstructor.getVisibility()), CollectionsKt.plus((Collection) list, (Iterable) arrayList));
        createJavaConstructor.setHasStableParameterNames(false);
        createJavaConstructor.setHasSynthesizedParameterNames(resolveValueParameters.getHasSynthesizedNames());
        createJavaConstructor.setReturnType(ownerDescriptor.getDefaultType());
        childForMethod.getComponents().getJavaResolverCache().recordConstructor(javaConstructor, createJavaConstructor);
        return createJavaConstructor;
    }

    private final JavaMethodDescriptor resolveRecordComponentToFunctionDescriptor(JavaRecordComponent javaRecordComponent) {
        JavaMethodDescriptor createJavaMethod = JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(getC(), javaRecordComponent), javaRecordComponent.getName(), getC().getComponents().getSourceElementFactory().source(javaRecordComponent), true);
        Intrinsics.checkNotNullExpressionValue(createJavaMethod, "createJavaMethod(...)");
        createJavaMethod.initialize(null, getDispatchReceiverParameter(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), getC().getTypeResolver().transformJavaType(javaRecordComponent.getType(), JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 6, null)), Modality.Companion.convertFromFlags(false, false, true), DescriptorVisibilities.PUBLIC, null);
        createJavaMethod.setParameterNamesStatus(false, false);
        getC().getComponents().getJavaResolverCache().recordMethod(javaRecordComponent, createJavaMethod);
        return createJavaMethod;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<SimpleFunctionDescriptor> searchMethodsByNameWithoutBuiltinMagic(Name name) {
        Collection<JavaMethod> findMethodsByName = getDeclaredMemberIndex().invoke().findMethodsByName(name);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(findMethodsByName, 10));
        Iterator<T> it = findMethodsByName.iterator();
        while (it.hasNext()) {
            arrayList.add(resolveMethodToFunctionDescriptor((JavaMethod) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<SimpleFunctionDescriptor> searchMethodsInSupertypesWithoutBuiltinMagic(Name name) {
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name);
        ArrayList arrayList = new ArrayList();
        for (Object obj : functionsFromSupertypes) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
            if (!SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(simpleFunctionDescriptor) && BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor) == null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final boolean shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (!builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return false;
        }
        Name name2 = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name2);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = functionsFromSupertypes.iterator();
        while (it.hasNext()) {
            FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((SimpleFunctionDescriptor) it.next());
            if (overriddenBuiltinFunctionWithErasedValueParametersInJava != null) {
                arrayList.add(overriddenBuiltinFunctionWithErasedValueParametersInJava);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (hasSameJvmDescriptorButDoesNotOverride(simpleFunctionDescriptor, (FunctionDescriptor) it2.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computeClassNames(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        return SetsKt.plus((Set) this.nestedClassIndex.invoke(), (Iterable) this.enumEntryIndex.invoke().keySet());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ Set computeFunctionNames(DescriptorKindFilter descriptorKindFilter, Function1 function1) {
        return computeFunctionNames(descriptorKindFilter, (Function1<? super Name, Boolean>) function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> result, Name name) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.jClass.isRecord() && getDeclaredMemberIndex().invoke().findRecordComponentByName(name) != null) {
            Collection<SimpleFunctionDescriptor> collection = result;
            if (!collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (it.hasNext()) {
                    if (((SimpleFunctionDescriptor) it.next()).getValueParameters().isEmpty()) {
                        break;
                    }
                }
            }
            JavaRecordComponent findRecordComponentByName = getDeclaredMemberIndex().invoke().findRecordComponentByName(name);
            Intrinsics.checkNotNull(findRecordComponentByName);
            result.add(resolveRecordComponentToFunctionDescriptor(findRecordComponentByName));
        }
        getC().getComponents().getSyntheticPartsProvider().generateMethods(getOwnerDescriptor(), name, result, getC());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> result, Name name) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(name, "name");
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name);
        if (!SpecialGenericSignatures.Companion.getSameAsRenamedInJvmBuiltin(name) && !BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            Set<SimpleFunctionDescriptor> set = functionsFromSupertypes;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    if (((FunctionDescriptor) it.next()).isSuspend()) {
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : set) {
                if (isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor) obj)) {
                    arrayList.add(obj);
                }
            }
            addFunctionFromSupertypes(result, name, arrayList, false);
            return;
        }
        SmartSet create = SmartSet.Companion.create();
        Collection<? extends SimpleFunctionDescriptor> resolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, functionsFromSupertypes, CollectionsKt.emptyList(), getOwnerDescriptor(), ErrorReporter.DO_NOTHING, getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(...)");
        addOverriddenSpecialMethods(name, result, resolveOverridesForNonStaticMembers, result, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$3(this));
        addOverriddenSpecialMethods(name, result, resolveOverridesForNonStaticMembers, create, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$4(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : functionsFromSupertypes) {
            if (isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor) obj2)) {
                arrayList2.add(obj2);
            }
        }
        addFunctionFromSupertypes(result, name, CollectionsKt.plus((Collection) arrayList2, (Iterable) create), true);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredProperties(Name name, Collection<PropertyDescriptor> result) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.jClass.isAnnotationType()) {
            computeAnnotationProperties(name, result);
        }
        Set<PropertyDescriptor> propertiesFromSupertypes = getPropertiesFromSupertypes(name);
        if (propertiesFromSupertypes.isEmpty()) {
            return;
        }
        SmartSet.Companion companion = SmartSet.Companion;
        SmartSet create = companion.create();
        SmartSet create2 = companion.create();
        addPropertyOverrideByMethod(propertiesFromSupertypes, result, create, new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$7
            private final LazyJavaClassMemberScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Collection computeNonDeclaredProperties$lambda$36;
                computeNonDeclaredProperties$lambda$36 = LazyJavaClassMemberScope.computeNonDeclaredProperties$lambda$36(this.arg$0, (Name) obj);
                return computeNonDeclaredProperties$lambda$36;
            }
        });
        addPropertyOverrideByMethod(SetsKt.minus((Set) propertiesFromSupertypes, (Iterable) create), create2, null, new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$8
            private final LazyJavaClassMemberScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Collection computeNonDeclaredProperties$lambda$37;
                computeNonDeclaredProperties$lambda$37 = LazyJavaClassMemberScope.computeNonDeclaredProperties$lambda$37(this.arg$0, (Name) obj);
                return computeNonDeclaredProperties$lambda$37;
            }
        });
        Collection<? extends PropertyDescriptor> resolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, SetsKt.plus((Set) propertiesFromSupertypes, (Iterable) create2), result, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(...)");
        result.addAll(resolveOverridesForNonStaticMembers);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computePropertyNames(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        if (this.jClass.isAnnotationType()) {
            return getFunctionNames();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(getDeclaredMemberIndex().invoke().getFieldNames());
        Collection<KotlinType> mo3719getSupertypes = getOwnerDescriptor().getTypeConstructor().mo3719getSupertypes();
        Intrinsics.checkNotNullExpressionValue(mo3719getSupertypes, "getSupertypes(...)");
        Iterator<T> it = mo3719getSupertypes.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(linkedHashSet, ((KotlinType) it.next()).getMemberScope().getVariableNames());
        }
        return linkedHashSet;
    }

    public final NotNullLazyValue<List<ClassConstructorDescriptor>> getConstructors$descriptors_jvm() {
        return this.constructors;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo3720getContributedClassifier(Name name, LookupLocation location) {
        MemoizedFunctionToNullable<Name, ClassDescriptor> memoizedFunctionToNullable;
        ClassDescriptor invoke;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        recordLookup(name, location);
        LazyJavaClassMemberScope lazyJavaClassMemberScope = (LazyJavaClassMemberScope) getMainScope();
        return (lazyJavaClassMemberScope == null || (memoizedFunctionToNullable = lazyJavaClassMemberScope.nestedClasses) == null || (invoke = memoizedFunctionToNullable.invoke(name)) == null) ? this.nestedClasses.invoke(name) : invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        recordLookup(name, location);
        return super.getContributedFunctions(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        recordLookup(name, location);
        return super.getContributedVariables(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return DescriptorUtils.getDispatchReceiverParameterIfNeeded(getOwnerDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected boolean isVisibleAsFunction(JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics.checkNotNullParameter(javaMethodDescriptor, "<this>");
        if (this.jClass.isAnnotationType()) {
            return false;
        }
        return isVisibleAsFunctionInCurrentClass(javaMethodDescriptor);
    }

    public void recordLookup(Name name, LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        kotlin.reflect.jvm.internal.impl.incremental.UtilsKt.record(getC().getComponents().getLookupTracker(), location, getOwnerDescriptor(), name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected LazyJavaScope.MethodSignatureData resolveMethodSignature(JavaMethod method, List<? extends TypeParameterDescriptor> methodTypeParameters, KotlinType returnType, List<? extends ValueParameterDescriptor> valueParameters) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(methodTypeParameters, "methodTypeParameters");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(valueParameters, "valueParameters");
        SignaturePropagator.PropagatedSignature resolvePropagatedSignature = getC().getComponents().getSignaturePropagator().resolvePropagatedSignature(method, getOwnerDescriptor(), returnType, null, valueParameters, methodTypeParameters);
        Intrinsics.checkNotNullExpressionValue(resolvePropagatedSignature, "resolvePropagatedSignature(...)");
        KotlinType returnType2 = resolvePropagatedSignature.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType2, "getReturnType(...)");
        KotlinType receiverType = resolvePropagatedSignature.getReceiverType();
        List<ValueParameterDescriptor> valueParameters2 = resolvePropagatedSignature.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
        List<TypeParameterDescriptor> typeParameters = resolvePropagatedSignature.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
        boolean hasStableParameterNames = resolvePropagatedSignature.hasStableParameterNames();
        List<String> errors = resolvePropagatedSignature.getErrors();
        Intrinsics.checkNotNullExpressionValue(errors, "getErrors(...)");
        return new LazyJavaScope.MethodSignatureData(returnType2, receiverType, valueParameters2, typeParameters, hasStableParameterNames, errors);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public String toString() {
        return "Lazy Java member scope for " + this.jClass.getFqName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope(final LazyJavaResolverContext c5, ClassDescriptor ownerDescriptor, JavaClass jClass, boolean z5, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(c5, lazyJavaClassMemberScope);
        Intrinsics.checkNotNullParameter(c5, "c");
        Intrinsics.checkNotNullParameter(ownerDescriptor, "ownerDescriptor");
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.ownerDescriptor = ownerDescriptor;
        this.jClass = jClass;
        this.skipRefinement = z5;
        this.constructors = c5.getStorageManager().createLazyValue(new Function0(this, c5) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$0
            private final LazyJavaClassMemberScope arg$0;
            private final LazyJavaResolverContext arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = c5;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List constructors$lambda$5;
                constructors$lambda$5 = LazyJavaClassMemberScope.constructors$lambda$5(this.arg$0, this.arg$1);
                return constructors$lambda$5;
            }
        });
        this.nestedClassIndex = c5.getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$1
            private final LazyJavaClassMemberScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Set nestedClassIndex$lambda$49;
                nestedClassIndex$lambda$49 = LazyJavaClassMemberScope.nestedClassIndex$lambda$49(this.arg$0);
                return nestedClassIndex$lambda$49;
            }
        });
        this.generatedNestedClassNames = c5.getStorageManager().createLazyValue(new Function0(c5, this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$2
            private final LazyJavaResolverContext arg$0;
            private final LazyJavaClassMemberScope arg$1;

            {
                this.arg$0 = c5;
                this.arg$1 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Set generatedNestedClassNames$lambda$50;
                generatedNestedClassNames$lambda$50 = LazyJavaClassMemberScope.generatedNestedClassNames$lambda$50(this.arg$0, this.arg$1);
                return generatedNestedClassNames$lambda$50;
            }
        });
        this.enumEntryIndex = c5.getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$3
            private final LazyJavaClassMemberScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Map enumEntryIndex$lambda$53;
                enumEntryIndex$lambda$53 = LazyJavaClassMemberScope.enumEntryIndex$lambda$53(this.arg$0);
                return enumEntryIndex$lambda$53;
            }
        });
        this.nestedClasses = c5.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1(this, c5) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$4
            private final LazyJavaClassMemberScope arg$0;
            private final LazyJavaResolverContext arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = c5;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                ClassDescriptor nestedClasses$lambda$59;
                nestedClasses$lambda$59 = LazyJavaClassMemberScope.nestedClasses$lambda$59(this.arg$0, this.arg$1, (Name) obj);
                return nestedClasses$lambda$59;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected LinkedHashSet<Name> computeFunctionNames(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Collection<KotlinType> mo3719getSupertypes = getOwnerDescriptor().getTypeConstructor().mo3719getSupertypes();
        Intrinsics.checkNotNullExpressionValue(mo3719getSupertypes, "getSupertypes(...)");
        LinkedHashSet<Name> linkedHashSet = new LinkedHashSet<>();
        Iterator<T> it = mo3719getSupertypes.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(linkedHashSet, ((KotlinType) it.next()).getMemberScope().getFunctionNames());
        }
        linkedHashSet.addAll(getDeclaredMemberIndex().invoke().getMethodNames());
        linkedHashSet.addAll(getDeclaredMemberIndex().invoke().getRecordComponentNames());
        linkedHashSet.addAll(computeClassNames(kindFilter, function1));
        linkedHashSet.addAll(getC().getComponents().getSyntheticPartsProvider().getMethodNames(getOwnerDescriptor(), getC()));
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$$Lambda$5
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                boolean computeMemberIndex$lambda$0;
                computeMemberIndex$lambda$0 = LazyJavaClassMemberScope.computeMemberIndex$lambda$0((JavaMember) obj);
                return Boolean.valueOf(computeMemberIndex$lambda$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public ClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }
}
