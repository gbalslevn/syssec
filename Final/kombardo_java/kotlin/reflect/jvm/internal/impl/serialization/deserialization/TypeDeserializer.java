package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.SequencesKt;
import org.conscrypt.BuildConfig;

/* loaded from: classes3.dex */
public final class TypeDeserializer {

    /* renamed from: c, reason: collision with root package name */
    private final DeserializationContext f6171c;
    private final Function1<Integer, ClassifierDescriptor> classifierDescriptors;
    private final String containerPresentableName;
    private final String debugName;
    private final TypeDeserializer parent;
    private final Function1<Integer, ClassifierDescriptor> typeAliasDescriptors;
    private final Map<Integer, TypeParameterDescriptor> typeParameterDescriptors;

    public TypeDeserializer(DeserializationContext c5, TypeDeserializer typeDeserializer, List<ProtoBuf$TypeParameter> typeParameterProtos, String debugName, String containerPresentableName) {
        Map<Integer, TypeParameterDescriptor> linkedHashMap;
        Intrinsics.checkNotNullParameter(c5, "c");
        Intrinsics.checkNotNullParameter(typeParameterProtos, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(debugName, "debugName");
        Intrinsics.checkNotNullParameter(containerPresentableName, "containerPresentableName");
        this.f6171c = c5;
        this.parent = typeDeserializer;
        this.debugName = debugName;
        this.containerPresentableName = containerPresentableName;
        this.classifierDescriptors = c5.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$0
            private final TypeDeserializer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                ClassifierDescriptor computeClassifierDescriptor;
                computeClassifierDescriptor = this.arg$0.computeClassifierDescriptor(((Number) obj).intValue());
                return computeClassifierDescriptor;
            }
        });
        this.typeAliasDescriptors = c5.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$1
            private final TypeDeserializer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                ClassifierDescriptor computeTypeAliasDescriptor;
                computeTypeAliasDescriptor = this.arg$0.computeTypeAliasDescriptor(((Number) obj).intValue());
                return computeTypeAliasDescriptor;
            }
        });
        if (typeParameterProtos.isEmpty()) {
            linkedHashMap = MapsKt.emptyMap();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i5 = 0;
            for (ProtoBuf$TypeParameter protoBuf$TypeParameter : typeParameterProtos) {
                linkedHashMap.put(Integer.valueOf(protoBuf$TypeParameter.getId()), new DeserializedTypeParameterDescriptor(this.f6171c, protoBuf$TypeParameter, i5));
                i5++;
            }
        }
        this.typeParameterDescriptors = linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassifierDescriptor computeClassifierDescriptor(int i5) {
        ClassId classId = NameResolverUtilKt.getClassId(this.f6171c.getNameResolver(), i5);
        return classId.isLocal() ? this.f6171c.getComponents().deserializeClass(classId) : FindClassInModuleKt.findClassifierAcrossModuleDependencies(this.f6171c.getComponents().getModuleDescriptor(), classId);
    }

    private final SimpleType computeLocalClassifierReplacementType(int i5) {
        if (NameResolverUtilKt.getClassId(this.f6171c.getNameResolver(), i5).isLocal()) {
            return this.f6171c.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassifierDescriptor computeTypeAliasDescriptor(int i5) {
        ClassId classId = NameResolverUtilKt.getClassId(this.f6171c.getNameResolver(), i5);
        if (classId.isLocal()) {
            return null;
        }
        return FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(this.f6171c.getComponents().getModuleDescriptor(), classId);
    }

    private final SimpleType createSimpleSuspendFunctionType(KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinBuiltIns builtIns = TypeUtilsKt.getBuiltIns(kotlinType);
        Annotations annotations = kotlinType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        List<KotlinType> contextReceiverTypesFromFunctionType = FunctionTypesKt.getContextReceiverTypesFromFunctionType(kotlinType);
        List dropLast = CollectionsKt.dropLast(FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType), 1);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(dropLast, 10));
        Iterator it = dropLast.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeProjection) it.next()).getType());
        }
        return FunctionTypesKt.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, contextReceiverTypesFromFunctionType, arrayList, null, kotlinType2, true).makeNullableAsSpecified(kotlinType.isMarkedNullable());
    }

    private final SimpleType createSuspendFunctionType(TypeAttributes typeAttributes, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z5) {
        SimpleType createSuspendFunctionTypeForBasicCase;
        int size;
        int size2 = typeConstructor.getParameters().size() - list.size();
        if (size2 != 0) {
            createSuspendFunctionTypeForBasicCase = null;
            if (size2 == 1 && (size = list.size() - 1) >= 0) {
                TypeConstructor typeConstructor2 = typeConstructor.getBuiltIns().getSuspendFunction(size).getTypeConstructor();
                Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
                createSuspendFunctionTypeForBasicCase = KotlinTypeFactory.simpleType$default(typeAttributes, typeConstructor2, list, z5, null, 16, null);
            }
        } else {
            createSuspendFunctionTypeForBasicCase = createSuspendFunctionTypeForBasicCase(typeAttributes, typeConstructor, list, z5);
        }
        return createSuspendFunctionTypeForBasicCase == null ? ErrorUtils.INSTANCE.createErrorTypeWithArguments(ErrorTypeKind.INCONSISTENT_SUSPEND_FUNCTION, list, typeConstructor, new String[0]) : createSuspendFunctionTypeForBasicCase;
    }

    private final SimpleType createSuspendFunctionTypeForBasicCase(TypeAttributes typeAttributes, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z5) {
        SimpleType simpleType$default = KotlinTypeFactory.simpleType$default(typeAttributes, typeConstructor, list, z5, null, 16, null);
        if (FunctionTypesKt.isFunctionType(simpleType$default)) {
            return transformRuntimeFunctionTypeToSuspendFunction(simpleType$default);
        }
        return null;
    }

    private final TypeParameterDescriptor loadTypeParameter(int i5) {
        TypeParameterDescriptor typeParameterDescriptor = this.typeParameterDescriptors.get(Integer.valueOf(i5));
        if (typeParameterDescriptor != null) {
            return typeParameterDescriptor;
        }
        TypeDeserializer typeDeserializer = this.parent;
        if (typeDeserializer != null) {
            return typeDeserializer.loadTypeParameter(i5);
        }
        return null;
    }

    private static final List<ProtoBuf$Type.Argument> simpleType$collectAllArguments(ProtoBuf$Type protoBuf$Type, TypeDeserializer typeDeserializer) {
        List<ProtoBuf$Type.Argument> argumentList = protoBuf$Type.getArgumentList();
        Intrinsics.checkNotNullExpressionValue(argumentList, "getArgumentList(...)");
        List<ProtoBuf$Type.Argument> list = argumentList;
        ProtoBuf$Type outerType = ProtoTypeTableUtilKt.outerType(protoBuf$Type, typeDeserializer.f6171c.getTypeTable());
        List<ProtoBuf$Type.Argument> simpleType$collectAllArguments = outerType != null ? simpleType$collectAllArguments(outerType, typeDeserializer) : null;
        if (simpleType$collectAllArguments == null) {
            simpleType$collectAllArguments = CollectionsKt.emptyList();
        }
        return CollectionsKt.plus((Collection) list, (Iterable) simpleType$collectAllArguments);
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeDeserializer typeDeserializer, ProtoBuf$Type protoBuf$Type, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = true;
        }
        return typeDeserializer.simpleType(protoBuf$Type, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List simpleType$lambda$3(TypeDeserializer typeDeserializer, ProtoBuf$Type protoBuf$Type) {
        return typeDeserializer.f6171c.getComponents().getAnnotationAndConstantLoader().loadTypeAnnotations(protoBuf$Type, typeDeserializer.f6171c.getNameResolver());
    }

    private final TypeAttributes toAttributes(List<? extends TypeAttributeTranslator> list, Annotations annotations, TypeConstructor typeConstructor, DeclarationDescriptor declarationDescriptor) {
        List<? extends TypeAttributeTranslator> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeAttributeTranslator) it.next()).toAttributes(annotations, typeConstructor, declarationDescriptor));
        }
        return TypeAttributes.Companion.create(CollectionsKt.flatten(arrayList));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final SimpleType transformRuntimeFunctionTypeToSuspendFunction(KotlinType kotlinType) {
        KotlinType type;
        FqName fqName;
        TypeProjection typeProjection = (TypeProjection) CollectionsKt.lastOrNull((List) FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType));
        if (typeProjection == null || (type = typeProjection.getType()) == null) {
            return null;
        }
        ClassifierDescriptor mo3718getDeclarationDescriptor = type.getConstructor().mo3718getDeclarationDescriptor();
        FqName fqNameSafe = mo3718getDeclarationDescriptor != null ? DescriptorUtilsKt.getFqNameSafe(mo3718getDeclarationDescriptor) : null;
        if (type.getArguments().size() == 1) {
            if (!Intrinsics.areEqual(fqNameSafe, StandardNames.CONTINUATION_INTERFACE_FQ_NAME)) {
                fqName = TypeDeserializerKt.EXPERIMENTAL_CONTINUATION_FQ_NAME;
            }
            KotlinType type2 = ((TypeProjection) CollectionsKt.single((List) type.getArguments())).getType();
            Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
            DeclarationDescriptor containingDeclaration = this.f6171c.getContainingDeclaration();
            CallableDescriptor callableDescriptor = containingDeclaration instanceof CallableDescriptor ? (CallableDescriptor) containingDeclaration : null;
            return Intrinsics.areEqual(callableDescriptor != null ? DescriptorUtilsKt.fqNameOrNull(callableDescriptor) : null, SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME) ? createSimpleSuspendFunctionType(kotlinType, type2) : createSimpleSuspendFunctionType(kotlinType, type2);
        }
        return (SimpleType) kotlinType;
    }

    private final TypeProjection typeArgument(TypeParameterDescriptor typeParameterDescriptor, ProtoBuf$Type.Argument argument) {
        if (argument.getProjection() == ProtoBuf$Type.Argument.Projection.STAR) {
            return typeParameterDescriptor == null ? new StarProjectionForAbsentTypeParameter(this.f6171c.getComponents().getModuleDescriptor().getBuiltIns()) : new StarProjectionImpl(typeParameterDescriptor);
        }
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        ProtoBuf$Type.Argument.Projection projection = argument.getProjection();
        Intrinsics.checkNotNullExpressionValue(projection, "getProjection(...)");
        Variance variance = protoEnumFlags.variance(projection);
        ProtoBuf$Type type = ProtoTypeTableUtilKt.type(argument, this.f6171c.getTypeTable());
        return type == null ? new TypeProjectionImpl(ErrorUtils.createErrorType(ErrorTypeKind.NO_RECORDED_TYPE, argument.toString())) : new TypeProjectionImpl(variance, type(type));
    }

    private final TypeConstructor typeConstructor(ProtoBuf$Type protoBuf$Type) {
        ClassifierDescriptor invoke;
        Object obj;
        if (protoBuf$Type.hasClassName()) {
            invoke = this.classifierDescriptors.invoke(Integer.valueOf(protoBuf$Type.getClassName()));
            if (invoke == null) {
                invoke = typeConstructor$notFoundClass(this, protoBuf$Type, protoBuf$Type.getClassName());
            }
        } else if (protoBuf$Type.hasTypeParameter()) {
            invoke = loadTypeParameter(protoBuf$Type.getTypeParameter());
            if (invoke == null) {
                return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER, String.valueOf(protoBuf$Type.getTypeParameter()), this.containerPresentableName);
            }
        } else if (protoBuf$Type.hasTypeParameterName()) {
            String string = this.f6171c.getNameResolver().getString(protoBuf$Type.getTypeParameterName());
            Iterator<T> it = getOwnTypeParameters().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((TypeParameterDescriptor) obj).getName().asString(), string)) {
                    break;
                }
            }
            invoke = (TypeParameterDescriptor) obj;
            if (invoke == null) {
                return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME, string, this.f6171c.getContainingDeclaration().toString());
            }
        } else {
            if (!protoBuf$Type.hasTypeAliasName()) {
                return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.UNKNOWN_TYPE, new String[0]);
            }
            invoke = this.typeAliasDescriptors.invoke(Integer.valueOf(protoBuf$Type.getTypeAliasName()));
            if (invoke == null) {
                invoke = typeConstructor$notFoundClass(this, protoBuf$Type, protoBuf$Type.getTypeAliasName());
            }
        }
        TypeConstructor typeConstructor = invoke.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return typeConstructor;
    }

    private static final ClassDescriptor typeConstructor$notFoundClass(final TypeDeserializer typeDeserializer, ProtoBuf$Type protoBuf$Type, int i5) {
        ClassId classId = NameResolverUtilKt.getClassId(typeDeserializer.f6171c.getNameResolver(), i5);
        List<Integer> mutableList = SequencesKt.toMutableList(SequencesKt.map(SequencesKt.generateSequence(protoBuf$Type, new Function1(typeDeserializer) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$3
            private final TypeDeserializer arg$0;

            {
                this.arg$0 = typeDeserializer;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                ProtoBuf$Type typeConstructor$notFoundClass$lambda$8;
                typeConstructor$notFoundClass$lambda$8 = TypeDeserializer.typeConstructor$notFoundClass$lambda$8(this.arg$0, (ProtoBuf$Type) obj);
                return typeConstructor$notFoundClass$lambda$8;
            }
        }), new Function1() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$4
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                int typeConstructor$notFoundClass$lambda$9;
                typeConstructor$notFoundClass$lambda$9 = TypeDeserializer.typeConstructor$notFoundClass$lambda$9((ProtoBuf$Type) obj);
                return Integer.valueOf(typeConstructor$notFoundClass$lambda$9);
            }
        }));
        int count = SequencesKt.count(SequencesKt.generateSequence(classId, new PropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeConstructor$notFoundClass$classNestingLevel$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ClassId) obj).getOuterClassId();
            }
        }));
        while (mutableList.size() < count) {
            mutableList.add(0);
        }
        return typeDeserializer.f6171c.getComponents().getNotFoundClasses().getClass(classId, mutableList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProtoBuf$Type typeConstructor$notFoundClass$lambda$8(TypeDeserializer typeDeserializer, ProtoBuf$Type it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ProtoTypeTableUtilKt.outerType(it, typeDeserializer.f6171c.getTypeTable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int typeConstructor$notFoundClass$lambda$9(ProtoBuf$Type it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getArgumentCount();
    }

    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        return CollectionsKt.toList(this.typeParameterDescriptors.values());
    }

    public final SimpleType simpleType(final ProtoBuf$Type proto, boolean z5) {
        SimpleType simpleType$default;
        SimpleType withAbbreviation;
        Intrinsics.checkNotNullParameter(proto, "proto");
        SimpleType computeLocalClassifierReplacementType = proto.hasClassName() ? computeLocalClassifierReplacementType(proto.getClassName()) : proto.hasTypeAliasName() ? computeLocalClassifierReplacementType(proto.getTypeAliasName()) : null;
        if (computeLocalClassifierReplacementType != null) {
            return computeLocalClassifierReplacementType;
        }
        TypeConstructor typeConstructor = typeConstructor(proto);
        if (ErrorUtils.isError(typeConstructor.mo3718getDeclarationDescriptor())) {
            return ErrorUtils.INSTANCE.createErrorType(ErrorTypeKind.TYPE_FOR_ERROR_TYPE_CONSTRUCTOR, typeConstructor, typeConstructor.toString());
        }
        DeserializedAnnotations deserializedAnnotations = new DeserializedAnnotations(this.f6171c.getStorageManager(), new Function0(this, proto) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$2
            private final TypeDeserializer arg$0;
            private final ProtoBuf$Type arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = proto;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List simpleType$lambda$3;
                simpleType$lambda$3 = TypeDeserializer.simpleType$lambda$3(this.arg$0, this.arg$1);
                return simpleType$lambda$3;
            }
        });
        TypeAttributes attributes = toAttributes(this.f6171c.getComponents().getTypeAttributeTranslators(), deserializedAnnotations, typeConstructor, this.f6171c.getContainingDeclaration());
        List<ProtoBuf$Type.Argument> simpleType$collectAllArguments = simpleType$collectAllArguments(proto, this);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(simpleType$collectAllArguments, 10));
        int i5 = 0;
        for (Object obj : simpleType$collectAllArguments) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            arrayList.add(typeArgument((TypeParameterDescriptor) CollectionsKt.getOrNull(parameters, i5), (ProtoBuf$Type.Argument) obj));
            i5 = i6;
        }
        List<? extends TypeProjection> list = CollectionsKt.toList(arrayList);
        ClassifierDescriptor mo3718getDeclarationDescriptor = typeConstructor.mo3718getDeclarationDescriptor();
        if (z5 && (mo3718getDeclarationDescriptor instanceof TypeAliasDescriptor)) {
            SimpleType computeExpandedType = KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor) mo3718getDeclarationDescriptor, list);
            simpleType$default = computeExpandedType.makeNullableAsSpecified(KotlinTypeKt.isNullable(computeExpandedType) || proto.getNullable()).replaceAttributes(toAttributes(this.f6171c.getComponents().getTypeAttributeTranslators(), Annotations.Companion.create(CollectionsKt.plus((Iterable) deserializedAnnotations, (Iterable) computeExpandedType.getAnnotations())), typeConstructor, this.f6171c.getContainingDeclaration()));
        } else if (Flags.SUSPEND_TYPE.get(proto.getFlags()).booleanValue()) {
            simpleType$default = createSuspendFunctionType(attributes, typeConstructor, list, proto.getNullable());
        } else {
            simpleType$default = KotlinTypeFactory.simpleType$default(attributes, typeConstructor, list, proto.getNullable(), null, 16, null);
            if (Flags.DEFINITELY_NOT_NULL_TYPE.get(proto.getFlags()).booleanValue()) {
                DefinitelyNotNullType makeDefinitelyNotNull$default = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, simpleType$default, true, false, 4, null);
                if (makeDefinitelyNotNull$default == null) {
                    throw new IllegalStateException(("null DefinitelyNotNullType for '" + simpleType$default + '\'').toString());
                }
                simpleType$default = makeDefinitelyNotNull$default;
            }
        }
        ProtoBuf$Type abbreviatedType = ProtoTypeTableUtilKt.abbreviatedType(proto, this.f6171c.getTypeTable());
        return (abbreviatedType == null || (withAbbreviation = SpecialTypesKt.withAbbreviation(simpleType$default, simpleType(abbreviatedType, false))) == null) ? simpleType$default : withAbbreviation;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.debugName);
        if (this.parent == null) {
            str = BuildConfig.FLAVOR;
        } else {
            str = ". Child of " + this.parent.debugName;
        }
        sb.append(str);
        return sb.toString();
    }

    public final KotlinType type(ProtoBuf$Type proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        if (!proto.hasFlexibleTypeCapabilitiesId()) {
            return simpleType(proto, true);
        }
        String string = this.f6171c.getNameResolver().getString(proto.getFlexibleTypeCapabilitiesId());
        SimpleType simpleType$default = simpleType$default(this, proto, false, 2, null);
        ProtoBuf$Type flexibleUpperBound = ProtoTypeTableUtilKt.flexibleUpperBound(proto, this.f6171c.getTypeTable());
        Intrinsics.checkNotNull(flexibleUpperBound);
        return this.f6171c.getComponents().getFlexibleTypeDeserializer().create(proto, string, simpleType$default, simpleType$default(this, flexibleUpperBound, false, 2, null));
    }
}
