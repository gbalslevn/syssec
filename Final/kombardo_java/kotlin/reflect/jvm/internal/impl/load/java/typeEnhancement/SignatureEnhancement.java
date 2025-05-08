package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionNInfo;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DescriptorBasedDeprecationInfoKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class SignatureEnhancement {
    private final JavaTypeEnhancement typeEnhancement;

    public SignatureEnhancement(JavaTypeEnhancement typeEnhancement) {
        Intrinsics.checkNotNullParameter(typeEnhancement, "typeEnhancement");
        this.typeEnhancement = typeEnhancement;
    }

    private final boolean containsFunctionN(KotlinType kotlinType) {
        return TypeUtils.contains(kotlinType, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$4
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Boolean containsFunctionN$lambda$16;
                containsFunctionN$lambda$16 = SignatureEnhancement.containsFunctionN$lambda$16((UnwrappedType) obj);
                return containsFunctionN$lambda$16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean containsFunctionN$lambda$16(UnwrappedType unwrappedType) {
        ClassifierDescriptor mo3718getDeclarationDescriptor = unwrappedType.getConstructor().mo3718getDeclarationDescriptor();
        if (mo3718getDeclarationDescriptor == null) {
            return Boolean.FALSE;
        }
        Name name = mo3718getDeclarationDescriptor.getName();
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        return Boolean.valueOf(Intrinsics.areEqual(name, javaToKotlinClassMap.getFUNCTION_N_FQ_NAME().shortName()) && Intrinsics.areEqual(DescriptorUtilsKt.fqNameOrNull(mo3718getDeclarationDescriptor), javaToKotlinClassMap.getFUNCTION_N_FQ_NAME()));
    }

    private final KotlinType enhance(CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z5, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, TypeEnhancementInfo typeEnhancementInfo, boolean z6, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        SignatureParts signatureParts = new SignatureParts(annotated, z5, lazyJavaResolverContext, annotationQualifierApplicabilityType, false, 16, null);
        KotlinType invoke = function1.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
        Collection<? extends CallableMemberDescriptor> collection = overriddenDescriptors;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            Intrinsics.checkNotNull(callableMemberDescriptor2);
            arrayList.add(function1.invoke(callableMemberDescriptor2));
        }
        return enhance(signatureParts, invoke, arrayList, typeEnhancementInfo, z6);
    }

    static /* synthetic */ KotlinType enhance$default(SignatureEnhancement signatureEnhancement, CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z5, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, TypeEnhancementInfo typeEnhancementInfo, boolean z6, Function1 function1, int i5, Object obj) {
        return signatureEnhancement.enhance(callableMemberDescriptor, annotated, z5, lazyJavaResolverContext, annotationQualifierApplicabilityType, typeEnhancementInfo, (i5 & 32) != 0 ? false : z6, function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0223 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <D extends CallableMemberDescriptor> D enhanceSignature(D d5, LazyJavaResolverContext lazyJavaResolverContext) {
        D d6;
        KotlinType kotlinType;
        PredefinedFunctionEnhancementInfo predefinedFunctionEnhancementInfo;
        KotlinType enhance$default;
        KotlinType returnType;
        boolean z5;
        boolean z6;
        KotlinType type;
        List<TypeEnhancementInfo> parametersInfo;
        String errorsSinceLanguageVersion;
        PropertyDescriptorImpl propertyDescriptorImpl;
        PropertyGetterDescriptorImpl getter;
        if (!(d5 instanceof JavaCallableMemberDescriptor)) {
            return d5;
        }
        boolean z7 = true;
        if (d5.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && d5.getOriginal().getOverriddenDescriptors().size() == 1) {
            return d5;
        }
        LazyJavaResolverContext copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, getDefaultAnnotations(d5, lazyJavaResolverContext));
        if (!(d5 instanceof JavaPropertyDescriptor) || (getter = (propertyDescriptorImpl = (PropertyDescriptorImpl) d5).getGetter()) == null || getter.isDefault()) {
            d6 = d5;
        } else {
            PropertyGetterDescriptorImpl getter2 = propertyDescriptorImpl.getGetter();
            Intrinsics.checkNotNull(getter2);
            d6 = getter2;
        }
        TypeEnhancementInfo typeEnhancementInfo = null;
        if (d5.getExtensionReceiverParameter() != null) {
            FunctionDescriptor functionDescriptor = d6 instanceof FunctionDescriptor ? (FunctionDescriptor) d6 : null;
            kotlinType = enhanceValueParameter(d5, functionDescriptor != null ? (ValueParameterDescriptor) functionDescriptor.getUserData(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER) : null, copyWithNewDefaultTypeQualifiers, null, false, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    KotlinType enhanceSignature$lambda$2;
                    enhanceSignature$lambda$2 = SignatureEnhancement.enhanceSignature$lambda$2((CallableMemberDescriptor) obj);
                    return enhanceSignature$lambda$2;
                }
            });
        } else {
            kotlinType = null;
        }
        JavaMethodDescriptor javaMethodDescriptor = d5 instanceof JavaMethodDescriptor ? (JavaMethodDescriptor) d5 : null;
        if (javaMethodDescriptor != null) {
            SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
            DeclarationDescriptor containingDeclaration = javaMethodDescriptor.getContainingDeclaration();
            Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            String signature = MethodSignatureBuildingUtilsKt.signature(signatureBuildingComponents, (ClassDescriptor) containingDeclaration, MethodSignatureMappingKt.computeJvmDescriptor$default(javaMethodDescriptor, false, false, 3, null));
            if (signature != null) {
                PredefinedFunctionEnhancementInfo predefinedFunctionEnhancementInfo2 = PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(signature);
                if (predefinedFunctionEnhancementInfo2 == null) {
                    predefinedFunctionEnhancementInfo2 = null;
                } else {
                    if (predefinedFunctionEnhancementInfo2.getErrorsSinceLanguageVersion() != null && ((errorsSinceLanguageVersion = predefinedFunctionEnhancementInfo2.getErrorsSinceLanguageVersion()) == null || !StringsKt.startsWith$default(errorsSinceLanguageVersion, "2.", false, 2, (Object) null))) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (predefinedFunctionEnhancementInfo2.getErrorsSinceLanguageVersion() != null) {
                        predefinedFunctionEnhancementInfo2 = predefinedFunctionEnhancementInfo2.getWarningModeClone();
                    }
                }
                predefinedFunctionEnhancementInfo = predefinedFunctionEnhancementInfo2;
                if (predefinedFunctionEnhancementInfo != null) {
                    predefinedFunctionEnhancementInfo.getParametersInfo().size();
                    ((JavaMethodDescriptor) d5).getValueParameters().size();
                }
                boolean z8 = (!UtilsKt.isJspecifyEnabledInStrictMode(lazyJavaResolverContext.getComponents().getJavaTypeEnhancementState()) || copyWithNewDefaultTypeQualifiers.getComponents().getSettings().getIgnoreNullabilityForErasedValueParameters()) && UtilsKt.hasErasedValueParameters(d5);
                List<ValueParameterDescriptor> valueParameters = d6.getValueParameters();
                String str = "getValueParameters(...)";
                Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                List<ValueParameterDescriptor> list = valueParameters;
                char c5 = '\n';
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (final ValueParameterDescriptor valueParameterDescriptor : list) {
                    TypeEnhancementInfo typeEnhancementInfo2 = (predefinedFunctionEnhancementInfo == null || (parametersInfo = predefinedFunctionEnhancementInfo.getParametersInfo()) == null) ? typeEnhancementInfo : (TypeEnhancementInfo) CollectionsKt.getOrNull(parametersInfo, valueParameterDescriptor.getIndex());
                    ArrayList arrayList2 = arrayList;
                    arrayList2.add(enhanceValueParameter(d5, valueParameterDescriptor, copyWithNewDefaultTypeQualifiers, typeEnhancementInfo2, z8, new Function1(valueParameterDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$1
                        private final ValueParameterDescriptor arg$0;

                        {
                            this.arg$0 = valueParameterDescriptor;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public Object invoke(Object obj) {
                            KotlinType enhanceSignature$lambda$9$lambda$8;
                            enhanceSignature$lambda$9$lambda$8 = SignatureEnhancement.enhanceSignature$lambda$9$lambda$8(this.arg$0, (CallableMemberDescriptor) obj);
                            return enhanceSignature$lambda$9$lambda$8;
                        }
                    }));
                    arrayList = arrayList2;
                    str = str;
                    c5 = '\n';
                    typeEnhancementInfo = null;
                }
                ArrayList arrayList3 = arrayList;
                String str2 = str;
                PropertyDescriptor propertyDescriptor = !(d5 instanceof PropertyDescriptor) ? (PropertyDescriptor) d5 : null;
                enhance$default = enhance$default(this, d5, d6, true, copyWithNewDefaultTypeQualifiers, (propertyDescriptor == null && JavaDescriptorUtilKt.isJavaField(propertyDescriptor)) ? AnnotationQualifierApplicabilityType.FIELD : AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, predefinedFunctionEnhancementInfo == null ? predefinedFunctionEnhancementInfo.getReturnTypeInfo() : null, false, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$2
                    @Override // kotlin.jvm.functions.Function1
                    public Object invoke(Object obj) {
                        KotlinType enhanceSignature$lambda$10;
                        enhanceSignature$lambda$10 = SignatureEnhancement.enhanceSignature$lambda$10((CallableMemberDescriptor) obj);
                        return enhanceSignature$lambda$10;
                    }
                }, 32, null);
                returnType = d5.getReturnType();
                Intrinsics.checkNotNull(returnType);
                if (!containsFunctionN(returnType)) {
                    ReceiverParameterDescriptor extensionReceiverParameter = d5.getExtensionReceiverParameter();
                    if (!((extensionReceiverParameter == null || (type = extensionReceiverParameter.getType()) == null) ? false : containsFunctionN(type))) {
                        List<ValueParameterDescriptor> valueParameters2 = d5.getValueParameters();
                        Intrinsics.checkNotNullExpressionValue(valueParameters2, str2);
                        List<ValueParameterDescriptor> list2 = valueParameters2;
                        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                            Iterator<T> it = list2.iterator();
                            while (it.hasNext()) {
                                KotlinType type2 = ((ValueParameterDescriptor) it.next()).getType();
                                Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                                if (containsFunctionN(type2)) {
                                    z6 = true;
                                    break;
                                }
                            }
                        }
                        z6 = false;
                        if (!z6) {
                            z5 = false;
                            Pair<CallableDescriptor.UserDataKey<?>, ?> pair = z5 ? TuplesKt.to(DescriptorBasedDeprecationInfoKt.getDEPRECATED_FUNCTION_KEY(), new DeprecationCausedByFunctionNInfo(d5)) : null;
                            if (kotlinType == null && enhance$default == null) {
                                if (!arrayList3.isEmpty()) {
                                    Iterator it2 = arrayList3.iterator();
                                    while (it2.hasNext()) {
                                        if (((KotlinType) it2.next()) != null) {
                                            break;
                                        }
                                    }
                                }
                                z7 = false;
                                if (!z7 && pair == null) {
                                    return d5;
                                }
                            }
                            JavaCallableMemberDescriptor javaCallableMemberDescriptor = (JavaCallableMemberDescriptor) d5;
                            if (kotlinType == null) {
                                ReceiverParameterDescriptor extensionReceiverParameter2 = d5.getExtensionReceiverParameter();
                                kotlinType = extensionReceiverParameter2 != null ? extensionReceiverParameter2.getType() : null;
                            }
                            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                            int i5 = 0;
                            for (Object obj : arrayList3) {
                                int i6 = i5 + 1;
                                if (i5 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                KotlinType kotlinType2 = (KotlinType) obj;
                                if (kotlinType2 == null) {
                                    kotlinType2 = d5.getValueParameters().get(i5).getType();
                                    Intrinsics.checkNotNullExpressionValue(kotlinType2, "getType(...)");
                                }
                                arrayList4.add(kotlinType2);
                                i5 = i6;
                            }
                            if (enhance$default == null) {
                                enhance$default = d5.getReturnType();
                                Intrinsics.checkNotNull(enhance$default);
                            }
                            JavaCallableMemberDescriptor enhance = javaCallableMemberDescriptor.enhance(kotlinType, arrayList4, enhance$default, pair);
                            Intrinsics.checkNotNull(enhance, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
                            return enhance;
                        }
                    }
                }
                z5 = true;
                if (z5) {
                }
                if (kotlinType == null) {
                    if (!arrayList3.isEmpty()) {
                    }
                    z7 = false;
                    if (!z7) {
                        return d5;
                    }
                }
                JavaCallableMemberDescriptor javaCallableMemberDescriptor2 = (JavaCallableMemberDescriptor) d5;
                if (kotlinType == null) {
                }
                ArrayList arrayList42 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                int i52 = 0;
                while (r5.hasNext()) {
                }
                if (enhance$default == null) {
                }
                JavaCallableMemberDescriptor enhance2 = javaCallableMemberDescriptor2.enhance(kotlinType, arrayList42, enhance$default, pair);
                Intrinsics.checkNotNull(enhance2, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
                return enhance2;
            }
        }
        predefinedFunctionEnhancementInfo = null;
        if (predefinedFunctionEnhancementInfo != null) {
        }
        if (UtilsKt.isJspecifyEnabledInStrictMode(lazyJavaResolverContext.getComponents().getJavaTypeEnhancementState())) {
        }
        List<ValueParameterDescriptor> valueParameters3 = d6.getValueParameters();
        String str3 = "getValueParameters(...)";
        Intrinsics.checkNotNullExpressionValue(valueParameters3, "getValueParameters(...)");
        List<ValueParameterDescriptor> list3 = valueParameters3;
        char c52 = '\n';
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        while (r17.hasNext()) {
        }
        ArrayList arrayList32 = arrayList5;
        String str22 = str3;
        if (!(d5 instanceof PropertyDescriptor)) {
        }
        enhance$default = enhance$default(this, d5, d6, true, copyWithNewDefaultTypeQualifiers, (propertyDescriptor == null && JavaDescriptorUtilKt.isJavaField(propertyDescriptor)) ? AnnotationQualifierApplicabilityType.FIELD : AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, predefinedFunctionEnhancementInfo == null ? predefinedFunctionEnhancementInfo.getReturnTypeInfo() : null, false, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj2) {
                KotlinType enhanceSignature$lambda$10;
                enhanceSignature$lambda$10 = SignatureEnhancement.enhanceSignature$lambda$10((CallableMemberDescriptor) obj2);
                return enhanceSignature$lambda$10;
            }
        }, 32, null);
        returnType = d5.getReturnType();
        Intrinsics.checkNotNull(returnType);
        if (!containsFunctionN(returnType)) {
        }
        z5 = true;
        if (z5) {
        }
        if (kotlinType == null) {
        }
        JavaCallableMemberDescriptor javaCallableMemberDescriptor22 = (JavaCallableMemberDescriptor) d5;
        if (kotlinType == null) {
        }
        ArrayList arrayList422 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList32, 10));
        int i522 = 0;
        while (r5.hasNext()) {
        }
        if (enhance$default == null) {
        }
        JavaCallableMemberDescriptor enhance22 = javaCallableMemberDescriptor22.enhance(kotlinType, arrayList422, enhance$default, pair);
        Intrinsics.checkNotNull(enhance22, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
        return enhance22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType enhanceSignature$lambda$10(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KotlinType returnType = it.getReturnType();
        Intrinsics.checkNotNull(returnType);
        return returnType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType enhanceSignature$lambda$2(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ReceiverParameterDescriptor extensionReceiverParameter = it.getExtensionReceiverParameter();
        Intrinsics.checkNotNull(extensionReceiverParameter);
        KotlinType type = extensionReceiverParameter.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType enhanceSignature$lambda$9$lambda$8(ValueParameterDescriptor valueParameterDescriptor, CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KotlinType type = it.getValueParameters().get(valueParameterDescriptor.getIndex()).getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enhanceTypeParameterBounds$lambda$15$lambda$14(UnwrappedType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof RawType;
    }

    private final KotlinType enhanceValueParameter(CallableMemberDescriptor callableMemberDescriptor, ValueParameterDescriptor valueParameterDescriptor, LazyJavaResolverContext lazyJavaResolverContext, TypeEnhancementInfo typeEnhancementInfo, boolean z5, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        LazyJavaResolverContext copyWithNewDefaultTypeQualifiers;
        return enhance(callableMemberDescriptor, valueParameterDescriptor, false, (valueParameterDescriptor == null || (copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, valueParameterDescriptor.getAnnotations())) == null) ? lazyJavaResolverContext : copyWithNewDefaultTypeQualifiers, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, typeEnhancementInfo, z5, function1);
    }

    private final <D extends CallableMemberDescriptor> Annotations getDefaultAnnotations(D d5, LazyJavaResolverContext lazyJavaResolverContext) {
        ClassifierDescriptor topLevelContainingClassifier = DescriptorUtilKt.getTopLevelContainingClassifier(d5);
        if (topLevelContainingClassifier == null) {
            return d5.getAnnotations();
        }
        LazyJavaClassDescriptor lazyJavaClassDescriptor = topLevelContainingClassifier instanceof LazyJavaClassDescriptor ? (LazyJavaClassDescriptor) topLevelContainingClassifier : null;
        List<JavaAnnotation> moduleAnnotations = lazyJavaClassDescriptor != null ? lazyJavaClassDescriptor.getModuleAnnotations() : null;
        List<JavaAnnotation> list = moduleAnnotations;
        if (list == null || list.isEmpty()) {
            return d5.getAnnotations();
        }
        List<JavaAnnotation> list2 = moduleAnnotations;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new LazyJavaAnnotationDescriptor(lazyJavaResolverContext, (JavaAnnotation) it.next(), true));
        }
        return Annotations.Companion.create(CollectionsKt.plus((Iterable) d5.getAnnotations(), (Iterable) arrayList));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(LazyJavaResolverContext c5, Collection<? extends D> platformSignatures) {
        Intrinsics.checkNotNullParameter(c5, "c");
        Intrinsics.checkNotNullParameter(platformSignatures, "platformSignatures");
        Collection<? extends D> collection = platformSignatures;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(enhanceSignature((CallableMemberDescriptor) it.next(), c5));
        }
        return arrayList;
    }

    public final KotlinType enhanceSuperType(KotlinType type, LazyJavaResolverContext context) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(context, "context");
        KotlinType enhance$default = enhance$default(this, new SignatureParts(null, false, context, AnnotationQualifierApplicabilityType.TYPE_USE, true), type, CollectionsKt.emptyList(), null, false, 12, null);
        return enhance$default == null ? type : enhance$default;
    }

    public final List<KotlinType> enhanceTypeParameterBounds(TypeParameterDescriptor typeParameter, List<? extends KotlinType> bounds, LazyJavaResolverContext context) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(context, "context");
        List<? extends KotlinType> list = bounds;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (KotlinType kotlinType : list) {
            if (!TypeUtilsKt.contains(kotlinType, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$3
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    boolean enhanceTypeParameterBounds$lambda$15$lambda$14;
                    enhanceTypeParameterBounds$lambda$15$lambda$14 = SignatureEnhancement.enhanceTypeParameterBounds$lambda$15$lambda$14((UnwrappedType) obj);
                    return Boolean.valueOf(enhanceTypeParameterBounds$lambda$15$lambda$14);
                }
            })) {
                KotlinType enhance$default = enhance$default(this, new SignatureParts(typeParameter, false, context, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, false, 16, null), kotlinType, CollectionsKt.emptyList(), null, false, 12, null);
                if (enhance$default != null) {
                    kotlinType = enhance$default;
                }
            }
            arrayList.add(kotlinType);
        }
        return arrayList;
    }

    static /* synthetic */ KotlinType enhance$default(SignatureEnhancement signatureEnhancement, SignatureParts signatureParts, KotlinType kotlinType, List list, TypeEnhancementInfo typeEnhancementInfo, boolean z5, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            typeEnhancementInfo = null;
        }
        TypeEnhancementInfo typeEnhancementInfo2 = typeEnhancementInfo;
        if ((i5 & 8) != 0) {
            z5 = false;
        }
        return signatureEnhancement.enhance(signatureParts, kotlinType, list, typeEnhancementInfo2, z5);
    }

    private final KotlinType enhance(SignatureParts signatureParts, KotlinType kotlinType, List<? extends KotlinType> list, TypeEnhancementInfo typeEnhancementInfo, boolean z5) {
        return this.typeEnhancement.enhance(kotlinType, signatureParts.computeIndexedQualifiers(kotlinType, list, typeEnhancementInfo, z5), signatureParts.getSkipRawTypeArguments());
    }
}
