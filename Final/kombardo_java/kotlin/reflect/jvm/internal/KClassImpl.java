package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMappingUtilsKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u00052\u00020\u0006:\u0001HB\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b$\u0010\"J\u000f\u0010%\u001a\u00020\u001bH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R \u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010*\u001a\u0004\b+\u0010,R'\u0010/\u001a\u0012\u0012\u000e\u0012\f0.R\b\u0012\u0004\u0012\u00028\u00000\u00000-8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001a\u00106\u001a\b\u0012\u0004\u0012\u0002030\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0016\u00108\u001a\u0004\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010)R\u0016\u0010:\u001a\u0004\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010)R\u0014\u0010;\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0014\u0010?\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010\f\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010E\u001a\u00020B8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010G\u001a\u00020B8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010D¨\u0006I"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl;", BuildConfig.FLAVOR, "T", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "Ljava/lang/Class;", "jClass", "<init>", "(Ljava/lang/Class;)V", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "classId", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "createSyntheticClassOrFail", "(Lkotlin/reflect/jvm/internal/impl/name/ClassId;Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;)Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "createSyntheticClass", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "name", BuildConfig.FLAVOR, "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getProperties", "(Lkotlin/reflect/jvm/internal/impl/name/Name;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getFunctions", BuildConfig.FLAVOR, "index", "getLocalProperty", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "value", BuildConfig.FLAVOR, "isInstance", "(Ljava/lang/Object;)Z", "other", "equals", "hashCode", "()I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "data", "Lkotlin/Lazy;", "getData", "()Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructorDescriptors", "getSimpleName", "simpleName", "getQualifiedName", "qualifiedName", "isValue", "()Z", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "memberScope", "getStaticScope$kotlin_reflection", "staticScope", "Data", "kotlin-reflection"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KClassImpl<T> extends KDeclarationContainerImpl implements KClass<T>, KClassifierImpl, KTypeParameterOwnerImpl {
    private final Lazy<KClassImpl<T>.Data> data;
    private final Class<T> jClass;

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u000b\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u0018R-\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e0\u001d8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\f\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010!R%\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\f\u001a\u0004\b'\u0010!R#\u0010.\u001a\u0004\u0018\u00018\u00008FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b)\u0010*\u0012\u0004\b-\u0010#\u001a\u0004\b+\u0010,R!\u00102\u001a\b\u0012\u0004\u0012\u00020/0\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\f\u001a\u0004\b1\u0010\u0014R!\u00106\u001a\b\u0012\u0004\u0012\u0002030\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\f\u001a\u0004\b5\u0010\u0014R)\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000%0\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\f\u001a\u0004\b8\u0010\u0014R%\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\f\u001a\u0004\b<\u0010!R%\u0010@\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\f\u001a\u0004\b?\u0010!R%\u0010C\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\f\u001a\u0004\bB\u0010!R%\u0010F\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\f\u001a\u0004\bE\u0010!R%\u0010I\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\f\u001a\u0004\bH\u0010!R%\u0010L\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\f\u001a\u0004\bK\u0010!R%\u0010O\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\f\u001a\u0004\bN\u0010!R%\u0010R\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\f\u001a\u0004\bQ\u0010!¨\u0006S"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "<init>", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "Ljava/lang/Class;", "jClass", BuildConfig.FLAVOR, "calculateLocalClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "annotations$delegate", "getAnnotations", "()Ljava/util/List;", "annotations", "simpleName$delegate", "getSimpleName", "()Ljava/lang/String;", "simpleName", "qualifiedName$delegate", "getQualifiedName", "qualifiedName", BuildConfig.FLAVOR, "Lkotlin/reflect/KFunction;", "constructors$delegate", "getConstructors", "()Ljava/util/Collection;", "getConstructors$annotations", "()V", "constructors", "Lkotlin/reflect/KClass;", "nestedClasses$delegate", "getNestedClasses", "nestedClasses", "objectInstance$delegate", "Lkotlin/Lazy;", "getObjectInstance", "()Ljava/lang/Object;", "getObjectInstance$annotations", "objectInstance", "Lkotlin/reflect/KTypeParameter;", "typeParameters$delegate", "getTypeParameters", "typeParameters", "Lkotlin/reflect/KType;", "supertypes$delegate", "getSupertypes", "supertypes", "sealedSubclasses$delegate", "getSealedSubclasses", "sealedSubclasses", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "declaredNonStaticMembers$delegate", "getDeclaredNonStaticMembers", "declaredNonStaticMembers", "declaredStaticMembers$delegate", "getDeclaredStaticMembers", "declaredStaticMembers", "inheritedNonStaticMembers$delegate", "getInheritedNonStaticMembers", "inheritedNonStaticMembers", "inheritedStaticMembers$delegate", "getInheritedStaticMembers", "inheritedStaticMembers", "allNonStaticMembers$delegate", "getAllNonStaticMembers", "allNonStaticMembers", "allStaticMembers$delegate", "getAllStaticMembers", "allStaticMembers", "declaredMembers$delegate", "getDeclaredMembers", "declaredMembers", "allMembers$delegate", "getAllMembers", "allMembers", "kotlin-reflection"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class Data extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Data.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "annotations", "getAnnotations()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "simpleName", "getSimpleName()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "qualifiedName", "getQualifiedName()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "constructors", "getConstructors()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "nestedClasses", "getNestedClasses()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "typeParameters", "getTypeParameters()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "supertypes", "getSupertypes()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "allMembers", "getAllMembers()Ljava/util/Collection;", 0))};

        /* renamed from: allMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal allMembers;

        /* renamed from: allNonStaticMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal allNonStaticMembers;

        /* renamed from: allStaticMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal allStaticMembers;

        /* renamed from: annotations$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal annotations;

        /* renamed from: constructors$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal constructors;

        /* renamed from: declaredMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal declaredMembers;

        /* renamed from: declaredNonStaticMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal declaredNonStaticMembers;

        /* renamed from: declaredStaticMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal declaredStaticMembers;

        /* renamed from: descriptor$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal descriptor;

        /* renamed from: inheritedNonStaticMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal inheritedNonStaticMembers;

        /* renamed from: inheritedStaticMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal inheritedStaticMembers;

        /* renamed from: nestedClasses$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal nestedClasses;

        /* renamed from: objectInstance$delegate, reason: from kotlin metadata */
        private final Lazy objectInstance;

        /* renamed from: qualifiedName$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal qualifiedName;

        /* renamed from: sealedSubclasses$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal sealedSubclasses;

        /* renamed from: simpleName$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal simpleName;

        /* renamed from: supertypes$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal supertypes;

        /* renamed from: typeParameters$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal typeParameters;

        public Data() {
            super();
            this.descriptor = ReflectProperties.lazySoft(new Function0(KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$0
                private final KClassImpl arg$0;

                {
                    this.arg$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    ClassDescriptor descriptor_delegate$lambda$0;
                    descriptor_delegate$lambda$0 = KClassImpl.Data.descriptor_delegate$lambda$0(this.arg$0);
                    return descriptor_delegate$lambda$0;
                }
            });
            this.annotations = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$1
                private final KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List annotations_delegate$lambda$1;
                    annotations_delegate$lambda$1 = KClassImpl.Data.annotations_delegate$lambda$1(this.arg$0);
                    return annotations_delegate$lambda$1;
                }
            });
            this.simpleName = ReflectProperties.lazySoft(new Function0(KClassImpl.this, this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$2
                private final KClassImpl arg$0;
                private final KClassImpl.Data arg$1;

                {
                    this.arg$0 = r1;
                    this.arg$1 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    String simpleName_delegate$lambda$2;
                    simpleName_delegate$lambda$2 = KClassImpl.Data.simpleName_delegate$lambda$2(this.arg$0, this.arg$1);
                    return simpleName_delegate$lambda$2;
                }
            });
            this.qualifiedName = ReflectProperties.lazySoft(new Function0(KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$3
                private final KClassImpl arg$0;

                {
                    this.arg$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    String qualifiedName_delegate$lambda$3;
                    qualifiedName_delegate$lambda$3 = KClassImpl.Data.qualifiedName_delegate$lambda$3(this.arg$0);
                    return qualifiedName_delegate$lambda$3;
                }
            });
            this.constructors = ReflectProperties.lazySoft(new Function0(KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$4
                private final KClassImpl arg$0;

                {
                    this.arg$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List constructors_delegate$lambda$7;
                    constructors_delegate$lambda$7 = KClassImpl.Data.constructors_delegate$lambda$7(this.arg$0);
                    return constructors_delegate$lambda$7;
                }
            });
            this.nestedClasses = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$5
                private final KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List nestedClasses_delegate$lambda$10;
                    nestedClasses_delegate$lambda$10 = KClassImpl.Data.nestedClasses_delegate$lambda$10(this.arg$0);
                    return nestedClasses_delegate$lambda$10;
                }
            });
            this.objectInstance = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this, KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$6
                private final KClassImpl.Data arg$0;
                private final KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = r2;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Object objectInstance_delegate$lambda$11;
                    objectInstance_delegate$lambda$11 = KClassImpl.Data.objectInstance_delegate$lambda$11(this.arg$0, this.arg$1);
                    return objectInstance_delegate$lambda$11;
                }
            });
            this.typeParameters = ReflectProperties.lazySoft(new Function0(this, KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$7
                private final KClassImpl.Data arg$0;
                private final KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = r2;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List typeParameters_delegate$lambda$13;
                    typeParameters_delegate$lambda$13 = KClassImpl.Data.typeParameters_delegate$lambda$13(this.arg$0, this.arg$1);
                    return typeParameters_delegate$lambda$13;
                }
            });
            this.supertypes = ReflectProperties.lazySoft(new Function0(this, KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$8
                private final KClassImpl.Data arg$0;
                private final KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = r2;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List supertypes_delegate$lambda$18;
                    supertypes_delegate$lambda$18 = KClassImpl.Data.supertypes_delegate$lambda$18(this.arg$0, this.arg$1);
                    return supertypes_delegate$lambda$18;
                }
            });
            this.sealedSubclasses = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$9
                private final KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List sealedSubclasses_delegate$lambda$21;
                    sealedSubclasses_delegate$lambda$21 = KClassImpl.Data.sealedSubclasses_delegate$lambda$21(this.arg$0);
                    return sealedSubclasses_delegate$lambda$21;
                }
            });
            this.declaredNonStaticMembers = ReflectProperties.lazySoft(new Function0(KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$10
                private final KClassImpl arg$0;

                {
                    this.arg$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Collection declaredNonStaticMembers_delegate$lambda$22;
                    declaredNonStaticMembers_delegate$lambda$22 = KClassImpl.Data.declaredNonStaticMembers_delegate$lambda$22(this.arg$0);
                    return declaredNonStaticMembers_delegate$lambda$22;
                }
            });
            this.declaredStaticMembers = ReflectProperties.lazySoft(new Function0(KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$11
                private final KClassImpl arg$0;

                {
                    this.arg$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Collection declaredStaticMembers_delegate$lambda$23;
                    declaredStaticMembers_delegate$lambda$23 = KClassImpl.Data.declaredStaticMembers_delegate$lambda$23(this.arg$0);
                    return declaredStaticMembers_delegate$lambda$23;
                }
            });
            this.inheritedNonStaticMembers = ReflectProperties.lazySoft(new Function0(KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$12
                private final KClassImpl arg$0;

                {
                    this.arg$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Collection inheritedNonStaticMembers_delegate$lambda$24;
                    inheritedNonStaticMembers_delegate$lambda$24 = KClassImpl.Data.inheritedNonStaticMembers_delegate$lambda$24(this.arg$0);
                    return inheritedNonStaticMembers_delegate$lambda$24;
                }
            });
            this.inheritedStaticMembers = ReflectProperties.lazySoft(new Function0(KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$13
                private final KClassImpl arg$0;

                {
                    this.arg$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Collection inheritedStaticMembers_delegate$lambda$25;
                    inheritedStaticMembers_delegate$lambda$25 = KClassImpl.Data.inheritedStaticMembers_delegate$lambda$25(this.arg$0);
                    return inheritedStaticMembers_delegate$lambda$25;
                }
            });
            this.allNonStaticMembers = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$14
                private final KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List allNonStaticMembers_delegate$lambda$26;
                    allNonStaticMembers_delegate$lambda$26 = KClassImpl.Data.allNonStaticMembers_delegate$lambda$26(this.arg$0);
                    return allNonStaticMembers_delegate$lambda$26;
                }
            });
            this.allStaticMembers = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$15
                private final KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List allStaticMembers_delegate$lambda$27;
                    allStaticMembers_delegate$lambda$27 = KClassImpl.Data.allStaticMembers_delegate$lambda$27(this.arg$0);
                    return allStaticMembers_delegate$lambda$27;
                }
            });
            this.declaredMembers = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$16
                private final KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List declaredMembers_delegate$lambda$28;
                    declaredMembers_delegate$lambda$28 = KClassImpl.Data.declaredMembers_delegate$lambda$28(this.arg$0);
                    return declaredMembers_delegate$lambda$28;
                }
            });
            this.allMembers = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$17
                private final KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List allMembers_delegate$lambda$29;
                    allMembers_delegate$lambda$29 = KClassImpl.Data.allMembers_delegate$lambda$29(this.arg$0);
                    return allMembers_delegate$lambda$29;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List allMembers_delegate$lambda$29(Data data) {
            return CollectionsKt.plus((Collection) data.getAllNonStaticMembers(), (Iterable) data.getAllStaticMembers());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List allNonStaticMembers_delegate$lambda$26(Data data) {
            return CollectionsKt.plus((Collection) data.getDeclaredNonStaticMembers(), (Iterable) data.getInheritedNonStaticMembers());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List allStaticMembers_delegate$lambda$27(Data data) {
            return CollectionsKt.plus((Collection) data.getDeclaredStaticMembers(), (Iterable) data.getInheritedStaticMembers());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List annotations_delegate$lambda$1(Data data) {
            return UtilKt.computeAnnotations(data.getDescriptor());
        }

        private final String calculateLocalClassName(Class<?> jClass) {
            String simpleName = jClass.getSimpleName();
            Method enclosingMethod = jClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                Intrinsics.checkNotNull(simpleName);
                return StringsKt.substringAfter$default(simpleName, enclosingMethod.getName() + '$', (String) null, 2, (Object) null);
            }
            Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
            if (enclosingConstructor == null) {
                Intrinsics.checkNotNull(simpleName);
                return StringsKt.substringAfter$default(simpleName, '$', (String) null, 2, (Object) null);
            }
            Intrinsics.checkNotNull(simpleName);
            return StringsKt.substringAfter$default(simpleName, enclosingConstructor.getName() + '$', (String) null, 2, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List constructors_delegate$lambda$7(KClassImpl kClassImpl) {
            Collection<ConstructorDescriptor> constructorDescriptors = kClassImpl.getConstructorDescriptors();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(constructorDescriptors, 10));
            Iterator<T> it = constructorDescriptors.iterator();
            while (it.hasNext()) {
                arrayList.add(new KFunctionImpl(kClassImpl, (ConstructorDescriptor) it.next()));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List declaredMembers_delegate$lambda$28(Data data) {
            return CollectionsKt.plus((Collection) data.getDeclaredNonStaticMembers(), (Iterable) data.getDeclaredStaticMembers());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection declaredNonStaticMembers_delegate$lambda$22(KClassImpl kClassImpl) {
            return kClassImpl.getMembers(kClassImpl.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection declaredStaticMembers_delegate$lambda$23(KClassImpl kClassImpl) {
            return kClassImpl.getMembers(kClassImpl.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ClassDescriptor descriptor_delegate$lambda$0(KClassImpl kClassImpl) {
            ClassId classId = kClassImpl.getClassId();
            RuntimeModuleData moduleData = kClassImpl.getData().getValue().getModuleData();
            ClassDescriptor deserializeClass = (classId.isLocal() && kClassImpl.getJClass().isAnnotationPresent(Metadata.class)) ? moduleData.getDeserialization().deserializeClass(classId) : FindClassInModuleKt.findClassAcrossModuleDependencies(moduleData.getModule(), classId);
            return deserializeClass == null ? kClassImpl.createSyntheticClassOrFail(classId, moduleData) : deserializeClass;
        }

        private final Collection<KCallableImpl<?>> getDeclaredStaticMembers() {
            T value = this.declaredStaticMembers.getValue(this, $$delegatedProperties[10]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        private final Collection<KCallableImpl<?>> getInheritedNonStaticMembers() {
            T value = this.inheritedNonStaticMembers.getValue(this, $$delegatedProperties[11]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        private final Collection<KCallableImpl<?>> getInheritedStaticMembers() {
            T value = this.inheritedStaticMembers.getValue(this, $$delegatedProperties[12]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection inheritedNonStaticMembers_delegate$lambda$24(KClassImpl kClassImpl) {
            return kClassImpl.getMembers(kClassImpl.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection inheritedStaticMembers_delegate$lambda$25(KClassImpl kClassImpl) {
            return kClassImpl.getMembers(kClassImpl.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List nestedClasses_delegate$lambda$10(Data data) {
            Collection contributedDescriptors$default = ResolutionScope.DefaultImpls.getContributedDescriptors$default(data.getDescriptor().getUnsubstitutedInnerClassesScope(), null, null, 3, null);
            ArrayList<DeclarationDescriptor> arrayList = new ArrayList();
            for (T t5 : contributedDescriptors$default) {
                if (!DescriptorUtils.isEnumEntry((DeclarationDescriptor) t5)) {
                    arrayList.add(t5);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (DeclarationDescriptor declarationDescriptor : arrayList) {
                ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
                Class<?> javaClass = classDescriptor != null ? UtilKt.toJavaClass(classDescriptor) : null;
                KClassImpl kClassImpl = javaClass != null ? new KClassImpl(javaClass) : null;
                if (kClassImpl != null) {
                    arrayList2.add(kClassImpl);
                }
            }
            return arrayList2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object objectInstance_delegate$lambda$11(Data data, KClassImpl kClassImpl) {
            ClassDescriptor descriptor = data.getDescriptor();
            if (descriptor.getKind() != ClassKind.OBJECT) {
                return null;
            }
            Object obj = ((!descriptor.isCompanionObject() || CompanionObjectMappingUtilsKt.isMappedIntrinsicCompanionObject(CompanionObjectMapping.INSTANCE, descriptor)) ? kClassImpl.getJClass().getDeclaredField("INSTANCE") : kClassImpl.getJClass().getEnclosingClass().getDeclaredField(descriptor.getName().asString())).get(null);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
            return obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String qualifiedName_delegate$lambda$3(KClassImpl kClassImpl) {
            if (kClassImpl.getJClass().isAnonymousClass()) {
                return null;
            }
            ClassId classId = kClassImpl.getClassId();
            if (classId.isLocal()) {
                return null;
            }
            return classId.asSingleFqName().asString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List sealedSubclasses_delegate$lambda$21(Data data) {
            Collection<ClassDescriptor> sealedSubclasses = data.getDescriptor().getSealedSubclasses();
            Intrinsics.checkNotNullExpressionValue(sealedSubclasses, "getSealedSubclasses(...)");
            ArrayList arrayList = new ArrayList();
            for (ClassDescriptor classDescriptor : sealedSubclasses) {
                Intrinsics.checkNotNull(classDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                Class<?> javaClass = UtilKt.toJavaClass(classDescriptor);
                KClassImpl kClassImpl = javaClass != null ? new KClassImpl(javaClass) : null;
                if (kClassImpl != null) {
                    arrayList.add(kClassImpl);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String simpleName_delegate$lambda$2(KClassImpl kClassImpl, Data data) {
            if (kClassImpl.getJClass().isAnonymousClass()) {
                return null;
            }
            ClassId classId = kClassImpl.getClassId();
            if (classId.isLocal()) {
                return data.calculateLocalClassName(kClassImpl.getJClass());
            }
            String asString = classId.getShortClassName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
            return asString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List supertypes_delegate$lambda$18(final Data data, final KClassImpl kClassImpl) {
            Collection<KotlinType> mo3719getSupertypes = data.getDescriptor().getTypeConstructor().mo3719getSupertypes();
            Intrinsics.checkNotNullExpressionValue(mo3719getSupertypes, "getSupertypes(...)");
            ArrayList arrayList = new ArrayList(mo3719getSupertypes.size());
            for (final KotlinType kotlinType : mo3719getSupertypes) {
                Intrinsics.checkNotNull(kotlinType);
                arrayList.add(new KTypeImpl(kotlinType, new Function0(kotlinType, data, kClassImpl) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$18
                    private final KotlinType arg$0;
                    private final KClassImpl.Data arg$1;
                    private final KClassImpl arg$2;

                    {
                        this.arg$0 = kotlinType;
                        this.arg$1 = data;
                        this.arg$2 = kClassImpl;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        Type supertypes_delegate$lambda$18$lambda$15$lambda$14;
                        supertypes_delegate$lambda$18$lambda$15$lambda$14 = KClassImpl.Data.supertypes_delegate$lambda$18$lambda$15$lambda$14(this.arg$0, this.arg$1, this.arg$2);
                        return supertypes_delegate$lambda$18$lambda$15$lambda$14;
                    }
                }));
            }
            if (!KotlinBuiltIns.isSpecialClassWithNoSupertypes(data.getDescriptor())) {
                if (!arrayList.isEmpty()) {
                    Iterator<T> it = arrayList.iterator();
                    while (it.hasNext()) {
                        ClassKind kind = DescriptorUtils.getClassDescriptorForType(((KTypeImpl) it.next()).getType()).getKind();
                        Intrinsics.checkNotNullExpressionValue(kind, "getKind(...)");
                        if (kind != ClassKind.INTERFACE && kind != ClassKind.ANNOTATION_CLASS) {
                            break;
                        }
                    }
                }
                SimpleType anyType = DescriptorUtilsKt.getBuiltIns(data.getDescriptor()).getAnyType();
                Intrinsics.checkNotNullExpressionValue(anyType, "getAnyType(...)");
                arrayList.add(new KTypeImpl(anyType, new Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$19
                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        Type supertypes_delegate$lambda$18$lambda$17;
                        supertypes_delegate$lambda$18$lambda$17 = KClassImpl.Data.supertypes_delegate$lambda$18$lambda$17();
                        return supertypes_delegate$lambda$18$lambda$17;
                    }
                }));
            }
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Type supertypes_delegate$lambda$18$lambda$15$lambda$14(KotlinType kotlinType, Data data, KClassImpl kClassImpl) {
            ClassifierDescriptor mo3718getDeclarationDescriptor = kotlinType.getConstructor().mo3718getDeclarationDescriptor();
            if (!(mo3718getDeclarationDescriptor instanceof ClassDescriptor)) {
                throw new KotlinReflectionInternalError("Supertype not a class: " + mo3718getDeclarationDescriptor);
            }
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) mo3718getDeclarationDescriptor);
            if (javaClass == null) {
                throw new KotlinReflectionInternalError("Unsupported superclass of " + data + ": " + mo3718getDeclarationDescriptor);
            }
            if (Intrinsics.areEqual(kClassImpl.getJClass().getSuperclass(), javaClass)) {
                Type genericSuperclass = kClassImpl.getJClass().getGenericSuperclass();
                Intrinsics.checkNotNull(genericSuperclass);
                return genericSuperclass;
            }
            Class<?>[] interfaces = kClassImpl.getJClass().getInterfaces();
            Intrinsics.checkNotNullExpressionValue(interfaces, "getInterfaces(...)");
            int indexOf = ArraysKt.indexOf(interfaces, javaClass);
            if (indexOf >= 0) {
                Type type = kClassImpl.getJClass().getGenericInterfaces()[indexOf];
                Intrinsics.checkNotNull(type);
                return type;
            }
            throw new KotlinReflectionInternalError("No superclass of " + data + " in Java reflection for " + mo3718getDeclarationDescriptor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Type supertypes_delegate$lambda$18$lambda$17() {
            return Object.class;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List typeParameters_delegate$lambda$13(Data data, KClassImpl kClassImpl) {
            List<TypeParameterDescriptor> declaredTypeParameters = data.getDescriptor().getDeclaredTypeParameters();
            Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
            List<TypeParameterDescriptor> list = declaredTypeParameters;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (TypeParameterDescriptor typeParameterDescriptor : list) {
                Intrinsics.checkNotNull(typeParameterDescriptor);
                arrayList.add(new KTypeParameterImpl(kClassImpl, typeParameterDescriptor));
            }
            return arrayList;
        }

        public final Collection<KCallableImpl<?>> getAllNonStaticMembers() {
            T value = this.allNonStaticMembers.getValue(this, $$delegatedProperties[13]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        public final Collection<KCallableImpl<?>> getAllStaticMembers() {
            T value = this.allStaticMembers.getValue(this, $$delegatedProperties[14]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        public final Collection<KCallableImpl<?>> getDeclaredNonStaticMembers() {
            T value = this.declaredNonStaticMembers.getValue(this, $$delegatedProperties[9]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Collection) value;
        }

        public final ClassDescriptor getDescriptor() {
            T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (ClassDescriptor) value;
        }

        public final String getQualifiedName() {
            return (String) this.qualifiedName.getValue(this, $$delegatedProperties[3]);
        }

        public final String getSimpleName() {
            return (String) this.simpleName.getValue(this, $$delegatedProperties[2]);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            try {
                iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KotlinClassHeader.Kind.SYNTHETIC_CLASS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[KotlinClassHeader.Kind.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[KotlinClassHeader.Kind.CLASS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public KClassImpl(Class<T> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.jClass = jClass;
        this.data = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$$Lambda$0
            private final KClassImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                KClassImpl.Data data$lambda$0;
                data$lambda$0 = KClassImpl.data$lambda$0(this.arg$0);
                return data$lambda$0;
            }
        });
    }

    private final ClassDescriptor createSyntheticClass(ClassId classId, RuntimeModuleData moduleData) {
        final ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(new EmptyPackageFragmentDescriptor(moduleData.getModule(), classId.getPackageFqName()), classId.getShortClassName(), Modality.FINAL, ClassKind.CLASS, CollectionsKt.listOf(moduleData.getModule().getBuiltIns().getAny().getDefaultType()), SourceElement.NO_SOURCE, false, moduleData.getDeserialization().getStorageManager());
        final StorageManager storageManager = moduleData.getDeserialization().getStorageManager();
        classDescriptorImpl.initialize(new GivenFunctionsMemberScope(classDescriptorImpl, storageManager) { // from class: kotlin.reflect.jvm.internal.KClassImpl$createSyntheticClass$1$1
            @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
            protected List<FunctionDescriptor> computeDeclaredFunctions() {
                return CollectionsKt.emptyList();
            }
        }, SetsKt.emptySet(), null);
        return classDescriptorImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassDescriptor createSyntheticClassOrFail(ClassId classId, RuntimeModuleData moduleData) {
        KotlinClassHeader classHeader;
        if (getJClass().isSynthetic()) {
            return createSyntheticClass(classId, moduleData);
        }
        ReflectKotlinClass create = ReflectKotlinClass.Factory.create(getJClass());
        KotlinClassHeader.Kind kind = (create == null || (classHeader = create.getClassHeader()) == null) ? null : classHeader.getKind();
        switch (kind == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
            case -1:
            case 6:
                throw new KotlinReflectionInternalError("Unresolved class: " + getJClass() + " (kind = " + kind + ')');
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
            case 2:
            case 3:
            case 4:
                return createSyntheticClass(classId, moduleData);
            case 5:
                throw new KotlinReflectionInternalError("Unknown class: " + getJClass() + " (kind = " + kind + ')');
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Data data$lambda$0(KClassImpl kClassImpl) {
        return new Data();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassId getClassId() {
        return RuntimeTypeMapper.INSTANCE.mapJvmClassToKotlinClassId(getJClass());
    }

    public boolean equals(Object other) {
        return (other instanceof KClassImpl) && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) other));
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        ClassDescriptor descriptor = getDescriptor();
        if (descriptor.getKind() == ClassKind.INTERFACE || descriptor.getKind() == ClassKind.OBJECT) {
            return CollectionsKt.emptyList();
        }
        Collection<ClassConstructorDescriptor> constructors = descriptor.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "getConstructors(...)");
        return constructors;
    }

    public final Lazy<KClassImpl<T>.Data> getData() {
        return this.data;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        MemberScope memberScope$kotlin_reflection = getMemberScope$kotlin_reflection();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        return CollectionsKt.plus((Collection) memberScope$kotlin_reflection.getContributedFunctions(name, noLookupLocation), (Iterable) getStaticScope$kotlin_reflection().getContributedFunctions(name, noLookupLocation));
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<T> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int index) {
        Class<?> declaringClass;
        if (Intrinsics.areEqual(getJClass().getSimpleName(), "DefaultImpls") && (declaringClass = getJClass().getDeclaringClass()) != null && declaringClass.isInterface()) {
            KClass kotlinClass = JvmClassMappingKt.getKotlinClass(declaringClass);
            Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((KClassImpl) kotlinClass).getLocalProperty(index);
        }
        ClassDescriptor descriptor = getDescriptor();
        DeserializedClassDescriptor deserializedClassDescriptor = descriptor instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) descriptor : null;
        if (deserializedClassDescriptor == null) {
            return null;
        }
        ProtoBuf$Class classProto = deserializedClassDescriptor.getClassProto();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Class, List<ProtoBuf$Property>> classLocalVariable = JvmProtoBuf.classLocalVariable;
        Intrinsics.checkNotNullExpressionValue(classLocalVariable, "classLocalVariable");
        ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) ProtoBufUtilKt.getExtensionOrNull(classProto, classLocalVariable, index);
        if (protoBuf$Property != null) {
            return (PropertyDescriptor) UtilKt.deserializeToDescriptor(getJClass(), protoBuf$Property, deserializedClassDescriptor.getC().getNameResolver(), deserializedClassDescriptor.getC().getTypeTable(), deserializedClassDescriptor.getMetadataVersion(), KClassImpl$getLocalProperty$2$1$1.INSTANCE);
        }
        return null;
    }

    public final MemberScope getMemberScope$kotlin_reflection() {
        return getDescriptor().getDefaultType().getMemberScope();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        MemberScope memberScope$kotlin_reflection = getMemberScope$kotlin_reflection();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        return CollectionsKt.plus((Collection) memberScope$kotlin_reflection.getContributedVariables(name, noLookupLocation), (Iterable) getStaticScope$kotlin_reflection().getContributedVariables(name, noLookupLocation));
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        return this.data.getValue().getQualifiedName();
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        return this.data.getValue().getSimpleName();
    }

    public final MemberScope getStaticScope$kotlin_reflection() {
        MemberScope staticScope = getDescriptor().getStaticScope();
        Intrinsics.checkNotNullExpressionValue(staticScope, "getStaticScope(...)");
        return staticScope;
    }

    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(Object value) {
        Integer functionClassArity = ReflectClassUtilKt.getFunctionClassArity(getJClass());
        if (functionClassArity != null) {
            return TypeIntrinsics.isFunctionOfArity(value, functionClassArity.intValue());
        }
        Class wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        if (wrapperByPrimitive == null) {
            wrapperByPrimitive = getJClass();
        }
        return wrapperByPrimitive.isInstance(value);
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        return getDescriptor().isValue();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("class ");
        ClassId classId = getClassId();
        FqName packageFqName = classId.getPackageFqName();
        if (packageFqName.isRoot()) {
            str = BuildConfig.FLAVOR;
        } else {
            str = packageFqName.asString() + '.';
        }
        sb.append(str + StringsKt.replace$default(classId.getRelativeClassName().asString(), '.', '$', false, 4, (Object) null));
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public ClassDescriptor getDescriptor() {
        return this.data.getValue().getDescriptor();
    }
}
