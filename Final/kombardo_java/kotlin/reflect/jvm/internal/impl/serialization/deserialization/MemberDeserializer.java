package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* loaded from: classes3.dex */
public final class MemberDeserializer {
    private final AnnotationDeserializer annotationDeserializer;

    /* renamed from: c, reason: collision with root package name */
    private final DeserializationContext f6170c;

    public MemberDeserializer(DeserializationContext c5) {
        Intrinsics.checkNotNullParameter(c5, "c");
        this.f6170c = c5;
        this.annotationDeserializer = new AnnotationDeserializer(c5.getComponents().getModuleDescriptor(), c5.getComponents().getNotFoundClasses());
    }

    private final ProtoContainer asProtoContainer(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            return new ProtoContainer.Package(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), this.f6170c.getNameResolver(), this.f6170c.getTypeTable(), this.f6170c.getContainerSource());
        }
        if (declarationDescriptor instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) declarationDescriptor).getThisAsProtoContainer$deserialization();
        }
        return null;
    }

    private final Annotations getAnnotations(final MessageLite messageLite, int i5, final AnnotatedCallableKind annotatedCallableKind) {
        return !Flags.HAS_ANNOTATIONS.get(i5).booleanValue() ? Annotations.Companion.getEMPTY() : new NonEmptyDeserializedAnnotations(this.f6170c.getStorageManager(), new Function0(this, messageLite, annotatedCallableKind) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$2
            private final MemberDeserializer arg$0;
            private final MessageLite arg$1;
            private final AnnotatedCallableKind arg$2;

            {
                this.arg$0 = this;
                this.arg$1 = messageLite;
                this.arg$2 = annotatedCallableKind;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List annotations$lambda$11;
                annotations$lambda$11 = MemberDeserializer.getAnnotations$lambda$11(this.arg$0, this.arg$1, this.arg$2);
                return annotations$lambda$11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAnnotations$lambda$11(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        ProtoContainer asProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.f6170c.getContainingDeclaration());
        List list = asProtoContainer != null ? CollectionsKt.toList(memberDeserializer.f6170c.getComponents().getAnnotationAndConstantLoader().loadCallableAnnotations(asProtoContainer, messageLite, annotatedCallableKind)) : null;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    private final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        DeclarationDescriptor containingDeclaration = this.f6170c.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor != null) {
            return classDescriptor.getThisAsReceiverParameter();
        }
        return null;
    }

    private final Annotations getPropertyFieldAnnotations(final ProtoBuf$Property protoBuf$Property, final boolean z5) {
        return !Flags.HAS_ANNOTATIONS.get(protoBuf$Property.getFlags()).booleanValue() ? Annotations.Companion.getEMPTY() : new NonEmptyDeserializedAnnotations(this.f6170c.getStorageManager(), new Function0(this, z5, protoBuf$Property) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$3
            private final MemberDeserializer arg$0;
            private final boolean arg$1;
            private final ProtoBuf$Property arg$2;

            {
                this.arg$0 = this;
                this.arg$1 = z5;
                this.arg$2 = protoBuf$Property;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List propertyFieldAnnotations$lambda$13;
                propertyFieldAnnotations$lambda$13 = MemberDeserializer.getPropertyFieldAnnotations$lambda$13(this.arg$0, this.arg$1, this.arg$2);
                return propertyFieldAnnotations$lambda$13;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getPropertyFieldAnnotations$lambda$13(MemberDeserializer memberDeserializer, boolean z5, ProtoBuf$Property protoBuf$Property) {
        ProtoContainer asProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.f6170c.getContainingDeclaration());
        List list = asProtoContainer != null ? z5 ? CollectionsKt.toList(memberDeserializer.f6170c.getComponents().getAnnotationAndConstantLoader().loadPropertyDelegateFieldAnnotations(asProtoContainer, protoBuf$Property)) : CollectionsKt.toList(memberDeserializer.f6170c.getComponents().getAnnotationAndConstantLoader().loadPropertyBackingFieldAnnotations(asProtoContainer, protoBuf$Property)) : null;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    private final Annotations getReceiverParameterAnnotations(final MessageLite messageLite, final AnnotatedCallableKind annotatedCallableKind) {
        return new DeserializedAnnotations(this.f6170c.getStorageManager(), new Function0(this, messageLite, annotatedCallableKind) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$4
            private final MemberDeserializer arg$0;
            private final MessageLite arg$1;
            private final AnnotatedCallableKind arg$2;

            {
                this.arg$0 = this;
                this.arg$1 = messageLite;
                this.arg$2 = annotatedCallableKind;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List receiverParameterAnnotations$lambda$15;
                receiverParameterAnnotations$lambda$15 = MemberDeserializer.getReceiverParameterAnnotations$lambda$15(this.arg$0, this.arg$1, this.arg$2);
                return receiverParameterAnnotations$lambda$15;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getReceiverParameterAnnotations$lambda$15(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        ProtoContainer asProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.f6170c.getContainingDeclaration());
        List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations = asProtoContainer != null ? memberDeserializer.f6170c.getComponents().getAnnotationAndConstantLoader().loadExtensionReceiverParameterAnnotations(asProtoContainer, messageLite, annotatedCallableKind) : null;
        return loadExtensionReceiverParameterAnnotations == null ? CollectionsKt.emptyList() : loadExtensionReceiverParameterAnnotations;
    }

    private final void initializeWithCoroutinesExperimentalityStatus(DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends ReceiverParameterDescriptor> list, List<? extends TypeParameterDescriptor> list2, List<? extends ValueParameterDescriptor> list3, KotlinType kotlinType, Modality modality, DescriptorVisibility descriptorVisibility, Map<? extends CallableDescriptor.UserDataKey<?>, ?> map) {
        deserializedSimpleFunctionDescriptor.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, list3, kotlinType, modality, descriptorVisibility, map);
    }

    private final int loadOldFlags(int i5) {
        return (i5 & 63) + ((i5 >> 8) << 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NullableLazyValue loadProperty$lambda$3(final MemberDeserializer memberDeserializer, final ProtoBuf$Property protoBuf$Property, final DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        return memberDeserializer.f6170c.getStorageManager().createNullableLazyValue(new Function0(memberDeserializer, protoBuf$Property, deserializedPropertyDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$6
            private final MemberDeserializer arg$0;
            private final ProtoBuf$Property arg$1;
            private final DeserializedPropertyDescriptor arg$2;

            {
                this.arg$0 = memberDeserializer;
                this.arg$1 = protoBuf$Property;
                this.arg$2 = deserializedPropertyDescriptor;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                ConstantValue loadProperty$lambda$3$lambda$2;
                loadProperty$lambda$3$lambda$2 = MemberDeserializer.loadProperty$lambda$3$lambda$2(this.arg$0, this.arg$1, this.arg$2);
                return loadProperty$lambda$3$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstantValue loadProperty$lambda$3$lambda$2(MemberDeserializer memberDeserializer, ProtoBuf$Property protoBuf$Property, DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        ProtoContainer asProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.f6170c.getContainingDeclaration());
        Intrinsics.checkNotNull(asProtoContainer);
        AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = memberDeserializer.f6170c.getComponents().getAnnotationAndConstantLoader();
        KotlinType returnType = deserializedPropertyDescriptor.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
        return annotationAndConstantLoader.loadPropertyConstant(asProtoContainer, protoBuf$Property, returnType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NullableLazyValue loadProperty$lambda$5(final MemberDeserializer memberDeserializer, final ProtoBuf$Property protoBuf$Property, final DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        return memberDeserializer.f6170c.getStorageManager().createNullableLazyValue(new Function0(memberDeserializer, protoBuf$Property, deserializedPropertyDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$7
            private final MemberDeserializer arg$0;
            private final ProtoBuf$Property arg$1;
            private final DeserializedPropertyDescriptor arg$2;

            {
                this.arg$0 = memberDeserializer;
                this.arg$1 = protoBuf$Property;
                this.arg$2 = deserializedPropertyDescriptor;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                ConstantValue loadProperty$lambda$5$lambda$4;
                loadProperty$lambda$5$lambda$4 = MemberDeserializer.loadProperty$lambda$5$lambda$4(this.arg$0, this.arg$1, this.arg$2);
                return loadProperty$lambda$5$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstantValue loadProperty$lambda$5$lambda$4(MemberDeserializer memberDeserializer, ProtoBuf$Property protoBuf$Property, DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        ProtoContainer asProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.f6170c.getContainingDeclaration());
        Intrinsics.checkNotNull(asProtoContainer);
        AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = memberDeserializer.f6170c.getComponents().getAnnotationAndConstantLoader();
        KotlinType returnType = deserializedPropertyDescriptor.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
        return annotationAndConstantLoader.loadAnnotationDefaultValue(asProtoContainer, protoBuf$Property, returnType);
    }

    private final ReceiverParameterDescriptor toContextReceiver(ProtoBuf$Type protoBuf$Type, DeserializationContext deserializationContext, CallableDescriptor callableDescriptor, int i5) {
        return DescriptorFactory.createContextReceiverParameterForCallable(callableDescriptor, deserializationContext.getTypeDeserializer().type(protoBuf$Type), null, Annotations.Companion.getEMPTY(), i5);
    }

    private final List<ValueParameterDescriptor> valueParameters(List<ProtoBuf$ValueParameter> list, final MessageLite messageLite, final AnnotatedCallableKind annotatedCallableKind) {
        Annotations empty;
        DeclarationDescriptor containingDeclaration = this.f6170c.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        CallableDescriptor callableDescriptor = (CallableDescriptor) containingDeclaration;
        DeclarationDescriptor containingDeclaration2 = callableDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
        final ProtoContainer asProtoContainer = asProtoContainer(containingDeclaration2);
        List<ProtoBuf$ValueParameter> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        int i5 = 0;
        for (Object obj : list2) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final ProtoBuf$ValueParameter protoBuf$ValueParameter = (ProtoBuf$ValueParameter) obj;
            int flags = protoBuf$ValueParameter.hasFlags() ? protoBuf$ValueParameter.getFlags() : 0;
            if (asProtoContainer == null || !Flags.HAS_ANNOTATIONS.get(flags).booleanValue()) {
                empty = Annotations.Companion.getEMPTY();
            } else {
                final int i7 = i5;
                empty = new NonEmptyDeserializedAnnotations(this.f6170c.getStorageManager(), new Function0(this, asProtoContainer, messageLite, annotatedCallableKind, i7, protoBuf$ValueParameter) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$5
                    private final MemberDeserializer arg$0;
                    private final ProtoContainer arg$1;
                    private final MessageLite arg$2;
                    private final AnnotatedCallableKind arg$3;
                    private final int arg$4;
                    private final ProtoBuf$ValueParameter arg$5;

                    {
                        this.arg$0 = this;
                        this.arg$1 = asProtoContainer;
                        this.arg$2 = messageLite;
                        this.arg$3 = annotatedCallableKind;
                        this.arg$4 = i7;
                        this.arg$5 = protoBuf$ValueParameter;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        List valueParameters$lambda$18$lambda$16;
                        valueParameters$lambda$18$lambda$16 = MemberDeserializer.valueParameters$lambda$18$lambda$16(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4, this.arg$5);
                        return valueParameters$lambda$18$lambda$16;
                    }
                });
            }
            Name name = NameResolverUtilKt.getName(this.f6170c.getNameResolver(), protoBuf$ValueParameter.getName());
            KotlinType type = this.f6170c.getTypeDeserializer().type(ProtoTypeTableUtilKt.type(protoBuf$ValueParameter, this.f6170c.getTypeTable()));
            Boolean bool = Flags.DECLARES_DEFAULT_VALUE.get(flags);
            Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
            boolean booleanValue = bool.booleanValue();
            Boolean bool2 = Flags.IS_CROSSINLINE.get(flags);
            Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
            boolean booleanValue2 = bool2.booleanValue();
            Boolean bool3 = Flags.IS_NOINLINE.get(flags);
            Intrinsics.checkNotNullExpressionValue(bool3, "get(...)");
            boolean booleanValue3 = bool3.booleanValue();
            ProtoBuf$Type varargElementType = ProtoTypeTableUtilKt.varargElementType(protoBuf$ValueParameter, this.f6170c.getTypeTable());
            KotlinType type2 = varargElementType != null ? this.f6170c.getTypeDeserializer().type(varargElementType) : null;
            SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new ValueParameterDescriptorImpl(callableDescriptor, null, i5, empty, name, type, booleanValue, booleanValue2, booleanValue3, type2, NO_SOURCE));
            arrayList = arrayList2;
            i5 = i6;
        }
        return CollectionsKt.toList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List valueParameters$lambda$18$lambda$16(MemberDeserializer memberDeserializer, ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i5, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        return CollectionsKt.toList(memberDeserializer.f6170c.getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations(protoContainer, messageLite, annotatedCallableKind, i5, protoBuf$ValueParameter));
    }

    public final ClassConstructorDescriptor loadConstructor(ProtoBuf$Constructor proto, boolean z5) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        DeclarationDescriptor containingDeclaration = this.f6170c.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        int flags = proto.getFlags();
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor = new DeserializedClassConstructorDescriptor(classDescriptor, null, getAnnotations(proto, flags, annotatedCallableKind), z5, CallableMemberDescriptor.Kind.DECLARATION, proto, this.f6170c.getNameResolver(), this.f6170c.getTypeTable(), this.f6170c.getVersionRequirementTable(), this.f6170c.getContainerSource(), null, 1024, null);
        MemberDeserializer memberDeserializer = DeserializationContext.childContext$default(this.f6170c, deserializedClassConstructorDescriptor, CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer();
        List<ProtoBuf$ValueParameter> valueParameterList = proto.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
        deserializedClassConstructorDescriptor.initialize(memberDeserializer.valueParameters(valueParameterList, proto, annotatedCallableKind), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(proto.getFlags())));
        deserializedClassConstructorDescriptor.setReturnType(classDescriptor.getDefaultType());
        deserializedClassConstructorDescriptor.setExpect(classDescriptor.isExpect());
        deserializedClassConstructorDescriptor.setHasStableParameterNames(!Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.get(proto.getFlags()).booleanValue());
        return deserializedClassConstructorDescriptor;
    }

    public final SimpleFunctionDescriptor loadFunction(ProtoBuf$Function proto) {
        KotlinType type;
        Intrinsics.checkNotNullParameter(proto, "proto");
        int flags = proto.hasFlags() ? proto.getFlags() : loadOldFlags(proto.getOldFlags());
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        Annotations annotations = getAnnotations(proto, flags, annotatedCallableKind);
        Annotations receiverParameterAnnotations = ProtoTypeTableUtilKt.hasReceiver(proto) ? getReceiverParameterAnnotations(proto, annotatedCallableKind) : Annotations.Companion.getEMPTY();
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = new DeserializedSimpleFunctionDescriptor(this.f6170c.getContainingDeclaration(), null, annotations, NameResolverUtilKt.getName(this.f6170c.getNameResolver(), proto.getName()), ProtoEnumFlagsUtilsKt.memberKind(ProtoEnumFlags.INSTANCE, Flags.MEMBER_KIND.get(flags)), proto, this.f6170c.getNameResolver(), this.f6170c.getTypeTable(), Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(this.f6170c.getContainingDeclaration()).child(NameResolverUtilKt.getName(this.f6170c.getNameResolver(), proto.getName())), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME) ? VersionRequirementTable.Companion.getEMPTY() : this.f6170c.getVersionRequirementTable(), this.f6170c.getContainerSource(), null, 1024, null);
        DeserializationContext deserializationContext = this.f6170c;
        List<ProtoBuf$TypeParameter> typeParameterList = proto.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedSimpleFunctionDescriptor, typeParameterList, null, null, null, null, 60, null);
        ProtoBuf$Type receiverType = ProtoTypeTableUtilKt.receiverType(proto, this.f6170c.getTypeTable());
        ReceiverParameterDescriptor createExtensionReceiverParameterForCallable = (receiverType == null || (type = childContext$default.getTypeDeserializer().type(receiverType)) == null) ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedSimpleFunctionDescriptor, type, receiverParameterAnnotations);
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        List<ProtoBuf$Type> contextReceiverTypes = ProtoTypeTableUtilKt.contextReceiverTypes(proto, this.f6170c.getTypeTable());
        List<? extends ReceiverParameterDescriptor> arrayList = new ArrayList<>();
        int i5 = 0;
        for (Object obj : contextReceiverTypes) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ReceiverParameterDescriptor contextReceiver = toContextReceiver((ProtoBuf$Type) obj, childContext$default, deserializedSimpleFunctionDescriptor, i5);
            if (contextReceiver != null) {
                arrayList.add(contextReceiver);
            }
            i5 = i6;
        }
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.getTypeDeserializer().getOwnTypeParameters();
        MemberDeserializer memberDeserializer = childContext$default.getMemberDeserializer();
        List<ProtoBuf$ValueParameter> valueParameterList = proto.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
        List<ValueParameterDescriptor> valueParameters = memberDeserializer.valueParameters(valueParameterList, proto, AnnotatedCallableKind.FUNCTION);
        KotlinType type2 = childContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(proto, this.f6170c.getTypeTable()));
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        initializeWithCoroutinesExperimentalityStatus(deserializedSimpleFunctionDescriptor, createExtensionReceiverParameterForCallable, dispatchReceiverParameter, arrayList, ownTypeParameters, valueParameters, type2, protoEnumFlags.modality(Flags.MODALITY.get(flags)), ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags, Flags.VISIBILITY.get(flags)), MapsKt.emptyMap());
        deserializedSimpleFunctionDescriptor.setOperator(Flags.IS_OPERATOR.get(flags).booleanValue());
        deserializedSimpleFunctionDescriptor.setInfix(Flags.IS_INFIX.get(flags).booleanValue());
        deserializedSimpleFunctionDescriptor.setExternal(Flags.IS_EXTERNAL_FUNCTION.get(flags).booleanValue());
        deserializedSimpleFunctionDescriptor.setInline(Flags.IS_INLINE.get(flags).booleanValue());
        deserializedSimpleFunctionDescriptor.setTailrec(Flags.IS_TAILREC.get(flags).booleanValue());
        deserializedSimpleFunctionDescriptor.setSuspend(Flags.IS_SUSPEND.get(flags).booleanValue());
        deserializedSimpleFunctionDescriptor.setExpect(Flags.IS_EXPECT_FUNCTION.get(flags).booleanValue());
        deserializedSimpleFunctionDescriptor.setHasStableParameterNames(!Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.get(flags).booleanValue());
        Pair<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction = this.f6170c.getComponents().getContractDeserializer().deserializeContractFromFunction(proto, deserializedSimpleFunctionDescriptor, this.f6170c.getTypeTable(), childContext$default.getTypeDeserializer());
        if (deserializeContractFromFunction != null) {
            deserializedSimpleFunctionDescriptor.putInUserDataMap(deserializeContractFromFunction.getFirst(), deserializeContractFromFunction.getSecond());
        }
        return deserializedSimpleFunctionDescriptor;
    }

    public final PropertyDescriptor loadProperty(ProtoBuf$Property proto) {
        ProtoBuf$Property protoBuf$Property;
        Annotations empty;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        DeserializationContext deserializationContext;
        Flags.FlagField<ProtoBuf$Modality> flagField;
        Flags.FlagField<ProtoBuf$Visibility> flagField2;
        final DeserializedPropertyDescriptor deserializedPropertyDescriptor2;
        final ProtoBuf$Property protoBuf$Property2;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl3;
        KotlinType type;
        Intrinsics.checkNotNullParameter(proto, "proto");
        int flags = proto.hasFlags() ? proto.getFlags() : loadOldFlags(proto.getOldFlags());
        DeclarationDescriptor containingDeclaration = this.f6170c.getContainingDeclaration();
        Annotations annotations = getAnnotations(proto, flags, AnnotatedCallableKind.PROPERTY);
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        Modality modality = protoEnumFlags.modality(Flags.MODALITY.get(flags));
        DescriptorVisibility descriptorVisibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags, Flags.VISIBILITY.get(flags));
        Boolean bool = Flags.IS_VAR.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        boolean booleanValue = bool.booleanValue();
        Name name = NameResolverUtilKt.getName(this.f6170c.getNameResolver(), proto.getName());
        CallableMemberDescriptor.Kind memberKind = ProtoEnumFlagsUtilsKt.memberKind(protoEnumFlags, Flags.MEMBER_KIND.get(flags));
        Boolean bool2 = Flags.IS_LATEINIT.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
        boolean booleanValue2 = bool2.booleanValue();
        Boolean bool3 = Flags.IS_CONST.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool3, "get(...)");
        boolean booleanValue3 = bool3.booleanValue();
        Boolean bool4 = Flags.IS_EXTERNAL_PROPERTY.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool4, "get(...)");
        boolean booleanValue4 = bool4.booleanValue();
        Boolean bool5 = Flags.IS_DELEGATED.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool5, "get(...)");
        boolean booleanValue5 = bool5.booleanValue();
        Boolean bool6 = Flags.IS_EXPECT_PROPERTY.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool6, "get(...)");
        DeserializedPropertyDescriptor deserializedPropertyDescriptor3 = new DeserializedPropertyDescriptor(containingDeclaration, null, annotations, modality, descriptorVisibility, booleanValue, name, memberKind, booleanValue2, booleanValue3, booleanValue4, booleanValue5, bool6.booleanValue(), proto, this.f6170c.getNameResolver(), this.f6170c.getTypeTable(), this.f6170c.getVersionRequirementTable(), this.f6170c.getContainerSource());
        DeserializationContext deserializationContext2 = this.f6170c;
        List<ProtoBuf$TypeParameter> typeParameterList = proto.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext2, deserializedPropertyDescriptor3, typeParameterList, null, null, null, null, 60, null);
        Boolean bool7 = Flags.HAS_GETTER.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool7, "get(...)");
        boolean booleanValue6 = bool7.booleanValue();
        if (booleanValue6 && ProtoTypeTableUtilKt.hasReceiver(proto)) {
            protoBuf$Property = proto;
            empty = getReceiverParameterAnnotations(protoBuf$Property, AnnotatedCallableKind.PROPERTY_GETTER);
        } else {
            protoBuf$Property = proto;
            empty = Annotations.Companion.getEMPTY();
        }
        KotlinType type2 = childContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(protoBuf$Property, this.f6170c.getTypeTable()));
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.getTypeDeserializer().getOwnTypeParameters();
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        ProtoBuf$Type receiverType = ProtoTypeTableUtilKt.receiverType(protoBuf$Property, this.f6170c.getTypeTable());
        if (receiverType == null || (type = childContext$default.getTypeDeserializer().type(receiverType)) == null) {
            deserializedPropertyDescriptor = deserializedPropertyDescriptor3;
            receiverParameterDescriptor = null;
        } else {
            deserializedPropertyDescriptor = deserializedPropertyDescriptor3;
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedPropertyDescriptor, type, empty);
        }
        List<ProtoBuf$Type> contextReceiverTypes = ProtoTypeTableUtilKt.contextReceiverTypes(protoBuf$Property, this.f6170c.getTypeTable());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(contextReceiverTypes, 10));
        int i5 = 0;
        for (Object obj : contextReceiverTypes) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(toContextReceiver((ProtoBuf$Type) obj, childContext$default, deserializedPropertyDescriptor, i5));
            i5 = i6;
        }
        deserializedPropertyDescriptor.setType(type2, ownTypeParameters, dispatchReceiverParameter, receiverParameterDescriptor, arrayList);
        Boolean bool8 = Flags.HAS_ANNOTATIONS.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool8, "get(...)");
        boolean booleanValue7 = bool8.booleanValue();
        Flags.FlagField<ProtoBuf$Visibility> flagField3 = Flags.VISIBILITY;
        ProtoBuf$Visibility protoBuf$Visibility = flagField3.get(flags);
        Flags.FlagField<ProtoBuf$Modality> flagField4 = Flags.MODALITY;
        int accessorFlags = Flags.getAccessorFlags(booleanValue7, protoBuf$Visibility, flagField4.get(flags), false, false, false);
        if (booleanValue6) {
            int getterFlags = proto.hasGetterFlags() ? proto.getGetterFlags() : accessorFlags;
            Boolean bool9 = Flags.IS_NOT_DEFAULT.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(bool9, "get(...)");
            boolean booleanValue8 = bool9.booleanValue();
            Boolean bool10 = Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(bool10, "get(...)");
            boolean booleanValue9 = bool10.booleanValue();
            Boolean bool11 = Flags.IS_INLINE_ACCESSOR.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(bool11, "get(...)");
            boolean booleanValue10 = bool11.booleanValue();
            Annotations annotations2 = getAnnotations(protoBuf$Property, getterFlags, AnnotatedCallableKind.PROPERTY_GETTER);
            if (booleanValue8) {
                ProtoEnumFlags protoEnumFlags2 = ProtoEnumFlags.INSTANCE;
                flagField = flagField4;
                deserializationContext = childContext$default;
                deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
                flagField2 = flagField3;
                protoBuf$Property2 = protoBuf$Property;
                propertyGetterDescriptorImpl3 = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor, annotations2, protoEnumFlags2.modality(flagField4.get(getterFlags)), ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags2, flagField3.get(getterFlags)), !booleanValue8, booleanValue9, booleanValue10, deserializedPropertyDescriptor.getKind(), null, SourceElement.NO_SOURCE);
            } else {
                deserializationContext = childContext$default;
                flagField = flagField4;
                flagField2 = flagField3;
                deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
                protoBuf$Property2 = protoBuf$Property;
                PropertyGetterDescriptorImpl createDefaultGetter = DescriptorFactory.createDefaultGetter(deserializedPropertyDescriptor2, annotations2);
                Intrinsics.checkNotNull(createDefaultGetter);
                propertyGetterDescriptorImpl3 = createDefaultGetter;
            }
            propertyGetterDescriptorImpl3.initialize(deserializedPropertyDescriptor2.getReturnType());
            propertyGetterDescriptorImpl = propertyGetterDescriptorImpl3;
        } else {
            deserializationContext = childContext$default;
            flagField = flagField4;
            flagField2 = flagField3;
            deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
            protoBuf$Property2 = protoBuf$Property;
            propertyGetterDescriptorImpl = null;
        }
        if (Flags.HAS_SETTER.get(flags).booleanValue()) {
            if (proto.hasSetterFlags()) {
                accessorFlags = proto.getSetterFlags();
            }
            int i7 = accessorFlags;
            Boolean bool12 = Flags.IS_NOT_DEFAULT.get(i7);
            Intrinsics.checkNotNullExpressionValue(bool12, "get(...)");
            boolean booleanValue11 = bool12.booleanValue();
            Boolean bool13 = Flags.IS_EXTERNAL_ACCESSOR.get(i7);
            Intrinsics.checkNotNullExpressionValue(bool13, "get(...)");
            boolean booleanValue12 = bool13.booleanValue();
            Boolean bool14 = Flags.IS_INLINE_ACCESSOR.get(i7);
            Intrinsics.checkNotNullExpressionValue(bool14, "get(...)");
            boolean booleanValue13 = bool14.booleanValue();
            AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.PROPERTY_SETTER;
            Annotations annotations3 = getAnnotations(protoBuf$Property2, i7, annotatedCallableKind);
            if (booleanValue11) {
                ProtoEnumFlags protoEnumFlags3 = ProtoEnumFlags.INSTANCE;
                propertyGetterDescriptorImpl2 = propertyGetterDescriptorImpl;
                PropertySetterDescriptorImpl propertySetterDescriptorImpl2 = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor2, annotations3, protoEnumFlags3.modality(flagField.get(i7)), ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags3, flagField2.get(i7)), !booleanValue11, booleanValue12, booleanValue13, deserializedPropertyDescriptor2.getKind(), null, SourceElement.NO_SOURCE);
                propertySetterDescriptorImpl2.initialize((ValueParameterDescriptor) CollectionsKt.single((List) DeserializationContext.childContext$default(deserializationContext, propertySetterDescriptorImpl2, CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer().valueParameters(CollectionsKt.listOf(proto.getSetterValueParameter()), protoBuf$Property2, annotatedCallableKind)));
                propertySetterDescriptorImpl = propertySetterDescriptorImpl2;
            } else {
                propertyGetterDescriptorImpl2 = propertyGetterDescriptorImpl;
                propertySetterDescriptorImpl = DescriptorFactory.createDefaultSetter(deserializedPropertyDescriptor2, annotations3, Annotations.Companion.getEMPTY());
                Intrinsics.checkNotNull(propertySetterDescriptorImpl);
            }
        } else {
            propertyGetterDescriptorImpl2 = propertyGetterDescriptorImpl;
            propertySetterDescriptorImpl = null;
        }
        if (Flags.HAS_CONSTANT.get(flags).booleanValue()) {
            deserializedPropertyDescriptor2.setCompileTimeInitializerFactory(new Function0(this, protoBuf$Property2, deserializedPropertyDescriptor2) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$0
                private final MemberDeserializer arg$0;
                private final ProtoBuf$Property arg$1;
                private final DeserializedPropertyDescriptor arg$2;

                {
                    this.arg$0 = this;
                    this.arg$1 = protoBuf$Property2;
                    this.arg$2 = deserializedPropertyDescriptor2;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    NullableLazyValue loadProperty$lambda$3;
                    loadProperty$lambda$3 = MemberDeserializer.loadProperty$lambda$3(this.arg$0, this.arg$1, this.arg$2);
                    return loadProperty$lambda$3;
                }
            });
        }
        DeclarationDescriptor containingDeclaration2 = this.f6170c.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration2 instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration2 : null;
        if ((classDescriptor != null ? classDescriptor.getKind() : null) == ClassKind.ANNOTATION_CLASS) {
            deserializedPropertyDescriptor2.setCompileTimeInitializerFactory(new Function0(this, protoBuf$Property2, deserializedPropertyDescriptor2) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$1
                private final MemberDeserializer arg$0;
                private final ProtoBuf$Property arg$1;
                private final DeserializedPropertyDescriptor arg$2;

                {
                    this.arg$0 = this;
                    this.arg$1 = protoBuf$Property2;
                    this.arg$2 = deserializedPropertyDescriptor2;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    NullableLazyValue loadProperty$lambda$5;
                    loadProperty$lambda$5 = MemberDeserializer.loadProperty$lambda$5(this.arg$0, this.arg$1, this.arg$2);
                    return loadProperty$lambda$5;
                }
            });
        }
        deserializedPropertyDescriptor2.initialize(propertyGetterDescriptorImpl2, propertySetterDescriptorImpl, new FieldDescriptorImpl(getPropertyFieldAnnotations(protoBuf$Property2, false), deserializedPropertyDescriptor2), new FieldDescriptorImpl(getPropertyFieldAnnotations(protoBuf$Property2, true), deserializedPropertyDescriptor2));
        return deserializedPropertyDescriptor2;
    }

    public final TypeAliasDescriptor loadTypeAlias(ProtoBuf$TypeAlias proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Annotations.Companion companion = Annotations.Companion;
        List<ProtoBuf$Annotation> annotationList = proto.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
        List<ProtoBuf$Annotation> list = annotationList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            AnnotationDeserializer annotationDeserializer = this.annotationDeserializer;
            Intrinsics.checkNotNull(protoBuf$Annotation);
            arrayList.add(annotationDeserializer.deserializeAnnotation(protoBuf$Annotation, this.f6170c.getNameResolver()));
        }
        DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor = new DeserializedTypeAliasDescriptor(this.f6170c.getStorageManager(), this.f6170c.getContainingDeclaration(), companion.create(arrayList), NameResolverUtilKt.getName(this.f6170c.getNameResolver(), proto.getName()), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(proto.getFlags())), proto, this.f6170c.getNameResolver(), this.f6170c.getTypeTable(), this.f6170c.getVersionRequirementTable(), this.f6170c.getContainerSource());
        DeserializationContext deserializationContext = this.f6170c;
        List<ProtoBuf$TypeParameter> typeParameterList = proto.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedTypeAliasDescriptor, typeParameterList, null, null, null, null, 60, null);
        deserializedTypeAliasDescriptor.initialize(childContext$default.getTypeDeserializer().getOwnTypeParameters(), childContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.underlyingType(proto, this.f6170c.getTypeTable()), false), childContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.expandedType(proto, this.f6170c.getTypeTable()), false));
        return deserializedTypeAliasDescriptor;
    }
}
