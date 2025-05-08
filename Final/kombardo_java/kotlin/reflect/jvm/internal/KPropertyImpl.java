package kotlin.reflect.jvm.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.jvm.KCallablesJvm;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.DescriptorsJvmAbiUtil;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b \u0018\u0000 G*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0004HIJGB5\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u0010B+\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b(\u0010#R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b)\u0010#R\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010*R\u001c\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00101\u001a\u0010\u0012\f\u0012\n 0*\u0004\u0018\u00010\t0\t0/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0013\u00109\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\b7\u00108R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000:8&X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0018\u0010A\u001a\u0006\u0012\u0002\b\u00030>8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001a\u0010C\u001a\b\u0012\u0002\b\u0003\u0018\u00010>8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010@R\u0014\u0010D\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u00106R\u0014\u0010\u000f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006K"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "V", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", BuildConfig.FLAVOR, "name", "signature", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "descriptorInitialValue", BuildConfig.FLAVOR, "rawBoundReceiver", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "descriptor", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Ljava/lang/reflect/Member;", "computeDelegateSource", "()Ljava/lang/reflect/Member;", "fieldOrMethod", "receiver1", "receiver2", "getDelegateImpl", "(Ljava/lang/reflect/Member;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "toString", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Ljava/lang/String;", "getName", "getSignature", "Ljava/lang/Object;", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "_javaField", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getBoundReceiver", "()Ljava/lang/Object;", "isBound", "()Z", "getJavaField", "()Ljava/lang/reflect/Field;", "javaField", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getter", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", "getDefaultCaller", "defaultCaller", "isSuspend", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "Companion", "Accessor", "Getter", "Setter", "kotlin-reflection"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class KPropertyImpl<V> extends KCallableImpl<V> implements KProperty<V> {
    private static final Object EXTENSION_PROPERTY_DELEGATE = new Object();
    private final ReflectProperties.LazySoftVal<PropertyDescriptor> _descriptor;
    private final Lazy<Field> _javaField;
    private final KDeclarationContainerImpl container;
    private final String name;
    private final Object rawBoundReceiver;
    private final String signature;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u00042\b\u0012\u0004\u0012\u00028\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "<init>", "()V", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "property", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "defaultCaller", BuildConfig.FLAVOR, "isBound", "()Z", "isSuspend", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "descriptor", "kotlin-reflection"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class Accessor<PropertyType, ReturnType> extends KCallableImpl<ReturnType> implements KFunction<ReturnType>, KProperty.Accessor<PropertyType> {
        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public KDeclarationContainerImpl getContainer() {
            return getProperty().getContainer();
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public Caller<?> getDefaultCaller() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public abstract PropertyAccessorDescriptor getDescriptor();

        public abstract KPropertyImpl<PropertyType> getProperty();

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public boolean isBound() {
            return getProperty().isBound();
        }

        @Override // kotlin.reflect.KCallable
        public boolean isSuspend() {
            return getDescriptor().isSuspend();
        }
    }

    private KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, PropertyDescriptor propertyDescriptor, Object obj) {
        this.container = kDeclarationContainerImpl;
        this.name = str;
        this.signature = str2;
        this.rawBoundReceiver = obj;
        this._javaField = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$$Lambda$0
            private final KPropertyImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Field _javaField$lambda$2;
                _javaField$lambda$2 = KPropertyImpl._javaField$lambda$2(this.arg$0);
                return _javaField$lambda$2;
            }
        });
        ReflectProperties.LazySoftVal<PropertyDescriptor> lazySoft = ReflectProperties.lazySoft(propertyDescriptor, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$$Lambda$1
            private final KPropertyImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                PropertyDescriptor _descriptor$lambda$5;
                _descriptor$lambda$5 = KPropertyImpl._descriptor$lambda$5(this.arg$0);
                return _descriptor$lambda$5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft, "lazySoft(...)");
        this._descriptor = lazySoft;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PropertyDescriptor _descriptor$lambda$5(KPropertyImpl kPropertyImpl) {
        return kPropertyImpl.getContainer().findPropertyDescriptor(kPropertyImpl.getName(), kPropertyImpl.signature);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Field _javaField$lambda$2(KPropertyImpl kPropertyImpl) {
        Class<?> enclosingClass;
        JvmPropertySignature mapPropertySignature = RuntimeTypeMapper.INSTANCE.mapPropertySignature(kPropertyImpl.getDescriptor());
        if (!(mapPropertySignature instanceof JvmPropertySignature.KotlinProperty)) {
            if (mapPropertySignature instanceof JvmPropertySignature.JavaField) {
                return ((JvmPropertySignature.JavaField) mapPropertySignature).getField();
            }
            if ((mapPropertySignature instanceof JvmPropertySignature.JavaMethodProperty) || (mapPropertySignature instanceof JvmPropertySignature.MappedKotlinProperty)) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        JvmPropertySignature.KotlinProperty kotlinProperty = (JvmPropertySignature.KotlinProperty) mapPropertySignature;
        PropertyDescriptor descriptor = kotlinProperty.getDescriptor();
        JvmMemberSignature.Field jvmFieldSignature$default = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, kotlinProperty.getProto(), kotlinProperty.getNameResolver(), kotlinProperty.getTypeTable(), false, 8, null);
        if (jvmFieldSignature$default == null) {
            return null;
        }
        if (DescriptorsJvmAbiUtil.isPropertyWithBackingFieldInOuterClass(descriptor) || JvmProtoBufUtil.isMovedFromInterfaceCompanion(kotlinProperty.getProto())) {
            enclosingClass = kPropertyImpl.getContainer().getJClass().getEnclosingClass();
        } else {
            DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
            enclosingClass = containingDeclaration instanceof ClassDescriptor ? UtilKt.toJavaClass((ClassDescriptor) containingDeclaration) : kPropertyImpl.getContainer().getJClass();
        }
        if (enclosingClass == null) {
            return null;
        }
        try {
            return enclosingClass.getDeclaredField(jvmFieldSignature$default.getName());
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Member computeDelegateSource() {
        if (!getDescriptor().isDelegated()) {
            return null;
        }
        JvmPropertySignature mapPropertySignature = RuntimeTypeMapper.INSTANCE.mapPropertySignature(getDescriptor());
        if (mapPropertySignature instanceof JvmPropertySignature.KotlinProperty) {
            JvmPropertySignature.KotlinProperty kotlinProperty = (JvmPropertySignature.KotlinProperty) mapPropertySignature;
            if (kotlinProperty.getSignature().hasDelegateMethod()) {
                JvmProtoBuf.JvmMethodSignature delegateMethod = kotlinProperty.getSignature().getDelegateMethod();
                if (!delegateMethod.hasName() || !delegateMethod.hasDesc()) {
                    return null;
                }
                return getContainer().findMethodBySignature(kotlinProperty.getNameResolver().getString(delegateMethod.getName()), kotlinProperty.getNameResolver().getString(delegateMethod.getDesc()));
            }
        }
        return getJavaField();
    }

    public boolean equals(Object other) {
        KPropertyImpl<?> asKPropertyImpl = UtilKt.asKPropertyImpl(other);
        return asKPropertyImpl != null && Intrinsics.areEqual(getContainer(), asKPropertyImpl.getContainer()) && Intrinsics.areEqual(getName(), asKPropertyImpl.getName()) && Intrinsics.areEqual(this.signature, asKPropertyImpl.signature) && Intrinsics.areEqual(this.rawBoundReceiver, asKPropertyImpl.rawBoundReceiver);
    }

    public final Object getBoundReceiver() {
        return ValueClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, getDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getCaller() {
        return getGetter().getCaller();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getDefaultCaller() {
        return getGetter().getDefaultCaller();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object getDelegateImpl(Member fieldOrMethod, Object receiver1, Object receiver2) {
        try {
            Object obj = EXTENSION_PROPERTY_DELEGATE;
            if ((receiver1 == obj || receiver2 == obj) && getDescriptor().getExtensionReceiverParameter() == null) {
                throw new RuntimeException('\'' + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
            Object boundReceiver = isBound() ? getBoundReceiver() : receiver1;
            if (boundReceiver == obj) {
                boundReceiver = null;
            }
            if (!isBound()) {
                receiver1 = receiver2;
            }
            if (receiver1 == obj) {
                receiver1 = null;
            }
            AccessibleObject accessibleObject = fieldOrMethod instanceof AccessibleObject ? (AccessibleObject) fieldOrMethod : null;
            if (accessibleObject != null) {
                accessibleObject.setAccessible(KCallablesJvm.isAccessible(this));
            }
            if (fieldOrMethod == 0) {
                return null;
            }
            if (fieldOrMethod instanceof Field) {
                return ((Field) fieldOrMethod).get(boundReceiver);
            }
            if (!(fieldOrMethod instanceof Method)) {
                throw new AssertionError("delegate field/method " + fieldOrMethod + " neither field nor method");
            }
            int length = ((Method) fieldOrMethod).getParameterTypes().length;
            if (length == 0) {
                return ((Method) fieldOrMethod).invoke(null, null);
            }
            if (length == 1) {
                Method method = (Method) fieldOrMethod;
                if (boundReceiver == null) {
                    Class<?> cls = ((Method) fieldOrMethod).getParameterTypes()[0];
                    Intrinsics.checkNotNullExpressionValue(cls, "get(...)");
                    boundReceiver = UtilKt.defaultPrimitiveValue(cls);
                }
                return method.invoke(null, boundReceiver);
            }
            if (length != 2) {
                throw new AssertionError("delegate method " + fieldOrMethod + " should take 0, 1, or 2 parameters");
            }
            Method method2 = (Method) fieldOrMethod;
            if (receiver1 == null) {
                Class<?> cls2 = ((Method) fieldOrMethod).getParameterTypes()[1];
                Intrinsics.checkNotNullExpressionValue(cls2, "get(...)");
                receiver1 = UtilKt.defaultPrimitiveValue(cls2);
            }
            return method2.invoke(null, boundReceiver, receiver1);
        } catch (IllegalAccessException e5) {
            throw new IllegalPropertyDelegateAccessException(e5);
        }
    }

    public abstract Getter<V> getGetter();

    public final Field getJavaField() {
        return this._javaField.getValue();
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return this.name;
    }

    public final String getSignature() {
        return this.signature;
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean isBound() {
        return this.rawBoundReceiver != CallableReference.NO_RECEIVER;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return false;
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderProperty(getDescriptor());
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "<init>", "()V", "name", BuildConfig.FLAVOR, "getName", "()Ljava/lang/String;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/Lazy;", "toString", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "kotlin-reflection"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class Getter<V> extends Accessor<V, V> implements KProperty.Getter<V> {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Getter.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", 0))};

        /* renamed from: descriptor$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal descriptor = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$Getter$$Lambda$0
            private final KPropertyImpl.Getter arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                PropertyGetterDescriptor descriptor_delegate$lambda$0;
                descriptor_delegate$lambda$0 = KPropertyImpl.Getter.descriptor_delegate$lambda$0(this.arg$0);
                return descriptor_delegate$lambda$0;
            }
        });

        /* renamed from: caller$delegate, reason: from kotlin metadata */
        private final Lazy caller = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$Getter$$Lambda$1
            private final KPropertyImpl.Getter arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Caller access$computeCallerForAccessor;
                access$computeCallerForAccessor = KPropertyImplKt.access$computeCallerForAccessor(this.arg$0, true);
                return access$computeCallerForAccessor;
            }
        });

        /* JADX INFO: Access modifiers changed from: private */
        public static final PropertyGetterDescriptor descriptor_delegate$lambda$0(Getter getter) {
            PropertyGetterDescriptor getter2 = getter.getProperty().getDescriptor().getGetter();
            if (getter2 != null) {
                return getter2;
            }
            PropertyGetterDescriptorImpl createDefaultGetter = DescriptorFactory.createDefaultGetter(getter.getProperty().getDescriptor(), Annotations.Companion.getEMPTY());
            Intrinsics.checkNotNullExpressionValue(createDefaultGetter, "createDefaultGetter(...)");
            return createDefaultGetter;
        }

        public boolean equals(Object other) {
            return (other instanceof Getter) && Intrinsics.areEqual(getProperty(), ((Getter) other).getProperty());
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public Caller<?> getCaller() {
            return (Caller) this.caller.getValue();
        }

        @Override // kotlin.reflect.KCallable
        public String getName() {
            return "<get-" + getProperty().getName() + '>';
        }

        public int hashCode() {
            return getProperty().hashCode();
        }

        public String toString() {
            return "getter of " + getProperty();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        public PropertyGetterDescriptor getDescriptor() {
            T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (PropertyGetterDescriptor) value;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0017\u001a\u00020\bH\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", BuildConfig.FLAVOR, "Lkotlin/reflect/KMutableProperty$Setter;", "<init>", "()V", "name", BuildConfig.FLAVOR, "getName", "()Ljava/lang/String;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/Lazy;", "toString", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "kotlin-reflection"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class Setter<V> extends Accessor<V, Unit> implements KMutableProperty.Setter<V> {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Setter.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", 0))};

        /* renamed from: descriptor$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal descriptor = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$Setter$$Lambda$0
            private final KPropertyImpl.Setter arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                PropertySetterDescriptor descriptor_delegate$lambda$0;
                descriptor_delegate$lambda$0 = KPropertyImpl.Setter.descriptor_delegate$lambda$0(this.arg$0);
                return descriptor_delegate$lambda$0;
            }
        });

        /* renamed from: caller$delegate, reason: from kotlin metadata */
        private final Lazy caller = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$Setter$$Lambda$1
            private final KPropertyImpl.Setter arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Caller access$computeCallerForAccessor;
                access$computeCallerForAccessor = KPropertyImplKt.access$computeCallerForAccessor(this.arg$0, false);
                return access$computeCallerForAccessor;
            }
        });

        /* JADX INFO: Access modifiers changed from: private */
        public static final PropertySetterDescriptor descriptor_delegate$lambda$0(Setter setter) {
            PropertySetterDescriptor setter2 = setter.getProperty().getDescriptor().getSetter();
            if (setter2 != null) {
                return setter2;
            }
            PropertyDescriptor descriptor = setter.getProperty().getDescriptor();
            Annotations.Companion companion = Annotations.Companion;
            PropertySetterDescriptorImpl createDefaultSetter = DescriptorFactory.createDefaultSetter(descriptor, companion.getEMPTY(), companion.getEMPTY());
            Intrinsics.checkNotNullExpressionValue(createDefaultSetter, "createDefaultSetter(...)");
            return createDefaultSetter;
        }

        public boolean equals(Object other) {
            return (other instanceof Setter) && Intrinsics.areEqual(getProperty(), ((Setter) other).getProperty());
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public Caller<?> getCaller() {
            return (Caller) this.caller.getValue();
        }

        @Override // kotlin.reflect.KCallable
        public String getName() {
            return "<set-" + getProperty().getName() + '>';
        }

        public int hashCode() {
            return getProperty().hashCode();
        }

        public String toString() {
            return "setter of " + getProperty();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        public PropertySetterDescriptor getDescriptor() {
            T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (PropertySetterDescriptor) value;
        }
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public PropertyDescriptor getDescriptor() {
        PropertyDescriptor invoke = this._descriptor.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return invoke;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl(KDeclarationContainerImpl container, String name, String signature, Object obj) {
        this(container, name, signature, null, obj);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public KPropertyImpl(KDeclarationContainerImpl container, PropertyDescriptor descriptor) {
        this(container, r3, RuntimeTypeMapper.INSTANCE.mapPropertySignature(descriptor).getString(), descriptor, CallableReference.NO_RECEIVER);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        String asString = descriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
    }
}
