package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.FunctionWithAllInvokes;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.CallerKt;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.InlineClassManglingRulesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001e\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B7\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u0011B+\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u0013J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001c2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\"\u0010!J5\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030#0%2\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030#2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0018H\u0002¢\u0006\u0004\b&\u0010'J\u001a\u0010)\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\bH\u0016¢\u0006\u0004\b.\u0010/R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u00100\u001a\u0004\b1\u00102R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u00103R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u00104R\u001b\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001f\u0010=\u001a\u0006\u0012\u0002\b\u00030\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R!\u0010@\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b>\u0010:\u001a\u0004\b?\u0010<R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010\t\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010/R\u0014\u0010G\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010-R\u0014\u0010H\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010D¨\u0006I"}, d2 = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", BuildConfig.FLAVOR, "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", BuildConfig.FLAVOR, "name", "signature", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "descriptorInitialValue", "rawBoundReceiver", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "descriptor", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getFunctionWithDefaultParametersForValueClassOverride", "(Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "Ljava/lang/reflect/Method;", "member", BuildConfig.FLAVOR, "useBoxedBoundReceiver", "(Ljava/lang/reflect/Method;)Z", "isCallByToValueClassMangledMethod", "Lkotlin/reflect/jvm/internal/calls/Caller;", "createStaticMethodCaller", "(Ljava/lang/reflect/Method;Z)Lkotlin/reflect/jvm/internal/calls/Caller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "createJvmStaticInObjectCaller", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "createInstanceMethodCaller", "Ljava/lang/reflect/Constructor;", "isDefault", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "createConstructorCaller", "(Ljava/lang/reflect/Constructor;Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;Z)Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "toString", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Ljava/lang/String;", "Ljava/lang/Object;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "caller$delegate", "Lkotlin/Lazy;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", "defaultCaller$delegate", "getDefaultCaller", "defaultCaller", "getBoundReceiver", "()Ljava/lang/Object;", "isBound", "()Z", "getName", "getArity", "arity", "isSuspend", "kotlin-reflection"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KFunctionImpl extends KCallableImpl<Object> implements FunctionBase<Object>, KFunction<Object>, FunctionWithAllInvokes {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(KFunctionImpl.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", 0))};

    /* renamed from: caller$delegate, reason: from kotlin metadata */
    private final Lazy caller;
    private final KDeclarationContainerImpl container;

    /* renamed from: defaultCaller$delegate, reason: from kotlin metadata */
    private final Lazy defaultCaller;

    /* renamed from: descriptor$delegate, reason: from kotlin metadata */
    private final ReflectProperties.LazySoftVal descriptor;
    private final Object rawBoundReceiver;
    private final String signature;

    /* synthetic */ KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, FunctionDescriptor functionDescriptor, Object obj, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(kDeclarationContainerImpl, str, str2, functionDescriptor, (i5 & 16) != 0 ? CallableReference.NO_RECEIVER : obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Caller caller_delegate$lambda$4(KFunctionImpl kFunctionImpl) {
        Object constructor;
        Caller<?> createInstanceMethodCaller;
        JvmFunctionSignature mapSignature = RuntimeTypeMapper.INSTANCE.mapSignature(kFunctionImpl.getDescriptor());
        if (mapSignature instanceof JvmFunctionSignature.KotlinConstructor) {
            if (kFunctionImpl.isAnnotationConstructor()) {
                Class<?> jClass = kFunctionImpl.getContainer().getJClass();
                List<KParameter> parameters = kFunctionImpl.getParameters();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    String name = ((KParameter) it.next()).getName();
                    Intrinsics.checkNotNull(name);
                    arrayList.add(name);
                }
                return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            constructor = kFunctionImpl.getContainer().findConstructorBySignature(((JvmFunctionSignature.KotlinConstructor) mapSignature).getConstructorDesc());
        } else if (mapSignature instanceof JvmFunctionSignature.KotlinFunction) {
            FunctionDescriptor descriptor = kFunctionImpl.getDescriptor();
            DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (InlineClassesUtilsKt.isMultiFieldValueClass(containingDeclaration) && (descriptor instanceof ConstructorDescriptor) && ((ConstructorDescriptor) descriptor).isPrimary()) {
                FunctionDescriptor descriptor2 = kFunctionImpl.getDescriptor();
                KDeclarationContainerImpl container = kFunctionImpl.getContainer();
                String methodDesc = ((JvmFunctionSignature.KotlinFunction) mapSignature).getMethodDesc();
                List<ValueParameterDescriptor> valueParameters = kFunctionImpl.getDescriptor().getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                return new ValueClassAwareCaller.MultiFieldValueClassPrimaryConstructorCaller(descriptor2, container, methodDesc, valueParameters);
            }
            JvmFunctionSignature.KotlinFunction kotlinFunction = (JvmFunctionSignature.KotlinFunction) mapSignature;
            constructor = kFunctionImpl.getContainer().findMethodBySignature(kotlinFunction.getMethodName(), kotlinFunction.getMethodDesc());
        } else if (mapSignature instanceof JvmFunctionSignature.JavaMethod) {
            constructor = ((JvmFunctionSignature.JavaMethod) mapSignature).getMethod();
            Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type java.lang.reflect.Member");
        } else {
            if (!(mapSignature instanceof JvmFunctionSignature.JavaConstructor)) {
                if (!(mapSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor)) {
                    throw new NoWhenBranchMatchedException();
                }
                List<Method> methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) mapSignature).getMethods();
                Class<?> jClass2 = kFunctionImpl.getContainer().getJClass();
                List<Method> list = methods;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((Method) it2.next()).getName());
                }
                return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.JAVA, methods);
            }
            constructor = ((JvmFunctionSignature.JavaConstructor) mapSignature).getConstructor();
            Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type java.lang.reflect.Member");
        }
        if (constructor instanceof Constructor) {
            createInstanceMethodCaller = kFunctionImpl.createConstructorCaller((Constructor) constructor, kFunctionImpl.getDescriptor(), false);
        } else {
            if (!(constructor instanceof Method)) {
                throw new KotlinReflectionInternalError("Could not compute caller for function: " + kFunctionImpl.getDescriptor() + " (member = " + constructor + ')');
            }
            Method method = (Method) constructor;
            createInstanceMethodCaller = !Modifier.isStatic(method.getModifiers()) ? kFunctionImpl.createInstanceMethodCaller(method) : kFunctionImpl.getDescriptor().getAnnotations().mo3685findAnnotation(UtilKt.getJVM_STATIC()) != null ? kFunctionImpl.createJvmStaticInObjectCaller(method) : kFunctionImpl.createStaticMethodCaller(method, false);
        }
        return ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded$default(createInstanceMethodCaller, kFunctionImpl.getDescriptor(), false, 2, null);
    }

    private final CallerImpl<Constructor<?>> createConstructorCaller(Constructor<?> member, FunctionDescriptor descriptor, boolean isDefault) {
        return (isDefault || !InlineClassManglingRulesKt.shouldHideConstructorDueToValueClassTypeValueParameters(descriptor)) ? isBound() ? new CallerImpl.BoundConstructor(member, getBoundReceiver()) : new CallerImpl.Constructor(member) : isBound() ? new CallerImpl.AccessorForHiddenBoundConstructor(member, getBoundReceiver()) : new CallerImpl.AccessorForHiddenConstructor(member);
    }

    private final CallerImpl.Method createInstanceMethodCaller(Method member) {
        return isBound() ? new CallerImpl.Method.BoundInstance(member, getBoundReceiver()) : new CallerImpl.Method.Instance(member);
    }

    private final CallerImpl.Method createJvmStaticInObjectCaller(Method member) {
        return isBound() ? new CallerImpl.Method.BoundJvmStaticInObject(member) : new CallerImpl.Method.JvmStaticInObject(member);
    }

    private final Caller<?> createStaticMethodCaller(Method member, boolean isCallByToValueClassMangledMethod) {
        if (isBound()) {
            return new CallerImpl.Method.BoundStatic(member, isCallByToValueClassMangledMethod, useBoxedBoundReceiver(member) ? this.rawBoundReceiver : getBoundReceiver());
        }
        return new CallerImpl.Method.Static(member);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.reflect.Member, java.lang.Object] */
    public static final Caller defaultCaller_delegate$lambda$10(KFunctionImpl kFunctionImpl) {
        GenericDeclaration genericDeclaration;
        Caller<?> caller;
        RuntimeTypeMapper runtimeTypeMapper = RuntimeTypeMapper.INSTANCE;
        JvmFunctionSignature mapSignature = runtimeTypeMapper.mapSignature(kFunctionImpl.getDescriptor());
        if (mapSignature instanceof JvmFunctionSignature.KotlinFunction) {
            FunctionDescriptor descriptor = kFunctionImpl.getDescriptor();
            DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (InlineClassesUtilsKt.isMultiFieldValueClass(containingDeclaration) && (descriptor instanceof ConstructorDescriptor) && ((ConstructorDescriptor) descriptor).isPrimary()) {
                throw new KotlinReflectionInternalError(kFunctionImpl.getDescriptor().getContainingDeclaration() + " cannot have default arguments");
            }
            FunctionDescriptor functionWithDefaultParametersForValueClassOverride = kFunctionImpl.getFunctionWithDefaultParametersForValueClassOverride(kFunctionImpl.getDescriptor());
            if (functionWithDefaultParametersForValueClassOverride != null) {
                JvmFunctionSignature mapSignature2 = runtimeTypeMapper.mapSignature(functionWithDefaultParametersForValueClassOverride);
                Intrinsics.checkNotNull(mapSignature2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction");
                JvmFunctionSignature.KotlinFunction kotlinFunction = (JvmFunctionSignature.KotlinFunction) mapSignature2;
                genericDeclaration = kFunctionImpl.getContainer().findDefaultMethod(kotlinFunction.getMethodName(), kotlinFunction.getMethodDesc(), true);
            } else {
                KDeclarationContainerImpl container = kFunctionImpl.getContainer();
                JvmFunctionSignature.KotlinFunction kotlinFunction2 = (JvmFunctionSignature.KotlinFunction) mapSignature;
                String methodName = kotlinFunction2.getMethodName();
                String methodDesc = kotlinFunction2.getMethodDesc();
                Intrinsics.checkNotNull(kFunctionImpl.getCaller().mo3682getMember());
                genericDeclaration = container.findDefaultMethod(methodName, methodDesc, !Modifier.isStatic(r5.getModifiers()));
            }
        } else if (mapSignature instanceof JvmFunctionSignature.KotlinConstructor) {
            if (kFunctionImpl.isAnnotationConstructor()) {
                Class<?> jClass = kFunctionImpl.getContainer().getJClass();
                List<KParameter> parameters = kFunctionImpl.getParameters();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    String name = ((KParameter) it.next()).getName();
                    Intrinsics.checkNotNull(name);
                    arrayList.add(name);
                }
                return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            genericDeclaration = kFunctionImpl.getContainer().findDefaultConstructor(((JvmFunctionSignature.KotlinConstructor) mapSignature).getConstructorDesc());
        } else {
            if (mapSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
                List<Method> methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) mapSignature).getMethods();
                Class<?> jClass2 = kFunctionImpl.getContainer().getJClass();
                List<Method> list = methods;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((Method) it2.next()).getName());
                }
                return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.JAVA, methods);
            }
            genericDeclaration = null;
        }
        if (genericDeclaration instanceof Constructor) {
            caller = kFunctionImpl.createConstructorCaller((Constructor) genericDeclaration, kFunctionImpl.getDescriptor(), true);
        } else if (genericDeclaration instanceof Method) {
            if (kFunctionImpl.getDescriptor().getAnnotations().mo3685findAnnotation(UtilKt.getJVM_STATIC()) != null) {
                DeclarationDescriptor containingDeclaration2 = kFunctionImpl.getDescriptor().getContainingDeclaration();
                Intrinsics.checkNotNull(containingDeclaration2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (!((ClassDescriptor) containingDeclaration2).isCompanionObject()) {
                    caller = kFunctionImpl.createJvmStaticInObjectCaller((Method) genericDeclaration);
                }
            }
            caller = kFunctionImpl.createStaticMethodCaller((Method) genericDeclaration, kFunctionImpl.getCaller().isBoundInstanceCallWithValueClasses());
        } else {
            caller = null;
        }
        if (caller != null) {
            return ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded(caller, kFunctionImpl.getDescriptor(), true);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FunctionDescriptor descriptor_delegate$lambda$0(KFunctionImpl kFunctionImpl, String str) {
        return kFunctionImpl.getContainer().findFunctionDescriptor(str, kFunctionImpl.signature);
    }

    private final Object getBoundReceiver() {
        return ValueClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, getDescriptor());
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.reflect.Member, java.lang.Object] */
    private final FunctionDescriptor getFunctionWithDefaultParametersForValueClassOverride(FunctionDescriptor descriptor) {
        CallableMemberDescriptor callableMemberDescriptor;
        List<ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        List<ValueParameterDescriptor> list = valueParameters;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((ValueParameterDescriptor) it.next()).declaresDefaultValue()) {
                    return null;
                }
            }
        }
        DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
        if (!InlineClassesUtilsKt.isValueClass(containingDeclaration)) {
            return null;
        }
        ?? mo3682getMember = getCaller().mo3682getMember();
        Intrinsics.checkNotNull(mo3682getMember);
        if (!Modifier.isStatic(mo3682getMember.getModifiers())) {
            return null;
        }
        Iterator<CallableMemberDescriptor> it2 = DescriptorUtilsKt.overriddenTreeAsSequence(descriptor, false).iterator();
        loop0: while (true) {
            if (!it2.hasNext()) {
                callableMemberDescriptor = null;
                break;
            }
            callableMemberDescriptor = it2.next();
            List<ValueParameterDescriptor> valueParameters2 = callableMemberDescriptor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
            List<ValueParameterDescriptor> list2 = valueParameters2;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it3 = list2.iterator();
                while (it3.hasNext()) {
                    if (((ValueParameterDescriptor) it3.next()).declaresDefaultValue()) {
                        break loop0;
                    }
                }
            }
        }
        if (callableMemberDescriptor instanceof FunctionDescriptor) {
            return (FunctionDescriptor) callableMemberDescriptor;
        }
        return null;
    }

    private final boolean useBoxedBoundReceiver(Method member) {
        KotlinType type;
        ReceiverParameterDescriptor dispatchReceiverParameter = getDescriptor().getDispatchReceiverParameter();
        if (dispatchReceiverParameter != null && (type = dispatchReceiverParameter.getType()) != null && InlineClassesUtilsKt.isInlineClassType(type)) {
            Class<?>[] parameterTypes = member.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
            Class cls = (Class) ArraysKt.firstOrNull(parameterTypes);
            if (cls != null && cls.isInterface()) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object other) {
        KFunctionImpl asKFunctionImpl = UtilKt.asKFunctionImpl(other);
        return asKFunctionImpl != null && Intrinsics.areEqual(getContainer(), asKFunctionImpl.getContainer()) && Intrinsics.areEqual(getName(), asKFunctionImpl.getName()) && Intrinsics.areEqual(this.signature, asKFunctionImpl.signature) && Intrinsics.areEqual(this.rawBoundReceiver, asKFunctionImpl.rawBoundReceiver);
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return CallerKt.getArity(getCaller());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getCaller() {
        return (Caller) this.caller.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getDefaultCaller() {
        return (Caller) this.defaultCaller.getValue();
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        String asString = getDescriptor().getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return asString;
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean isBound() {
        return this.rawBoundReceiver != CallableReference.NO_RECEIVER;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return getDescriptor().isSuspend();
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderFunction(getDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public FunctionDescriptor getDescriptor() {
        T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (FunctionDescriptor) value;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj);
    }

    private KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, final String str, String str2, FunctionDescriptor functionDescriptor, Object obj) {
        this.container = kDeclarationContainerImpl;
        this.signature = str2;
        this.rawBoundReceiver = obj;
        this.descriptor = ReflectProperties.lazySoft(functionDescriptor, new Function0(this, str) { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$$Lambda$0
            private final KFunctionImpl arg$0;
            private final String arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                FunctionDescriptor descriptor_delegate$lambda$0;
                descriptor_delegate$lambda$0 = KFunctionImpl.descriptor_delegate$lambda$0(this.arg$0, this.arg$1);
                return descriptor_delegate$lambda$0;
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.caller = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$$Lambda$1
            private final KFunctionImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Caller caller_delegate$lambda$4;
                caller_delegate$lambda$4 = KFunctionImpl.caller_delegate$lambda$4(this.arg$0);
                return caller_delegate$lambda$4;
            }
        });
        this.defaultCaller = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$$Lambda$2
            private final KFunctionImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Caller defaultCaller_delegate$lambda$10;
                defaultCaller_delegate$lambda$10 = KFunctionImpl.defaultCaller_delegate$lambda$10(this.arg$0);
                return defaultCaller_delegate$lambda$10;
            }
        });
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object obj, Object obj2) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function3
    public Object invoke(Object obj, Object obj2, Object obj3) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3);
    }

    @Override // kotlin.jvm.functions.Function4
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4);
    }

    @Override // kotlin.jvm.functions.Function5
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5);
    }

    @Override // kotlin.jvm.functions.Function6
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KFunctionImpl(KDeclarationContainerImpl container, String name, String signature, Object obj) {
        this(container, name, signature, null, obj);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public KFunctionImpl(KDeclarationContainerImpl container, FunctionDescriptor descriptor) {
        this(container, r3, RuntimeTypeMapper.INSTANCE.mapSignature(descriptor).get_signature(), descriptor, null, 16, null);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        String asString = descriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
    }
}
