package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u00018B1\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010(\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R!\u0010.\u001a\b\u0012\u0004\u0012\u00020*0)8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b,\u0010-R\u0016\u00100\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u001bR\u0014\u00104\u001a\u0002018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00105\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00106¨\u00069"}, d2 = {"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "callable", BuildConfig.FLAVOR, "index", "Lkotlin/reflect/KParameter$Kind;", "kind", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "computeDescriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", BuildConfig.FLAVOR, "Ljava/lang/reflect/Type;", "types", "compoundType", "([Ljava/lang/reflect/Type;)Ljava/lang/reflect/Type;", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "I", "getIndex", "Lkotlin/reflect/KParameter$Kind;", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "annotations$delegate", "getAnnotations", "()Ljava/util/List;", "annotations", "getName", "name", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "type", "isOptional", "()Z", "isVararg", "CompoundTypeImpl", "kotlin-reflection"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KParameterImpl implements KParameter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(KParameterImpl.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", 0)), Reflection.property1(new PropertyReference1Impl(KParameterImpl.class, "annotations", "getAnnotations()Ljava/util/List;", 0))};

    /* renamed from: annotations$delegate, reason: from kotlin metadata */
    private final ReflectProperties.LazySoftVal annotations;
    private final KCallableImpl<?> callable;

    /* renamed from: descriptor$delegate, reason: from kotlin metadata */
    private final ReflectProperties.LazySoftVal descriptor;
    private final int index;
    private final KParameter.Kind kind;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/KParameterImpl$CompoundTypeImpl;", "Ljava/lang/reflect/Type;", "types", BuildConfig.FLAVOR, "<init>", "([Ljava/lang/reflect/Type;)V", "getTypes", "()[Ljava/lang/reflect/Type;", "[Ljava/lang/reflect/Type;", "hashCode", BuildConfig.FLAVOR, "getTypeName", BuildConfig.FLAVOR, "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "toString", "kotlin-reflection"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class CompoundTypeImpl implements Type {
        private final int hashCode;
        private final Type[] types;

        public CompoundTypeImpl(Type[] types) {
            Intrinsics.checkNotNullParameter(types, "types");
            this.types = types;
            this.hashCode = Arrays.hashCode(types);
        }

        public boolean equals(Object other) {
            return (other instanceof CompoundTypeImpl) && Arrays.equals(this.types, ((CompoundTypeImpl) other).types);
        }

        @Override // java.lang.reflect.Type
        public String getTypeName() {
            return ArraysKt.joinToString$default(this.types, ", ", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
        }

        /* renamed from: hashCode, reason: from getter */
        public int getHashCode() {
            return this.hashCode;
        }

        public String toString() {
            return getTypeName();
        }
    }

    public KParameterImpl(KCallableImpl<?> callable, int i5, KParameter.Kind kind, Function0<? extends ParameterDescriptor> computeDescriptor) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(computeDescriptor, "computeDescriptor");
        this.callable = callable;
        this.index = i5;
        this.kind = kind;
        this.descriptor = ReflectProperties.lazySoft(computeDescriptor);
        this.annotations = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KParameterImpl$$Lambda$0
            private final KParameterImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List annotations_delegate$lambda$0;
                annotations_delegate$lambda$0 = KParameterImpl.annotations_delegate$lambda$0(this.arg$0);
                return annotations_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type _get_type_$lambda$1(KParameterImpl kParameterImpl) {
        List slice;
        ParameterDescriptor descriptor = kParameterImpl.getDescriptor();
        if ((descriptor instanceof ReceiverParameterDescriptor) && Intrinsics.areEqual(UtilKt.getInstanceReceiverParameter(kParameterImpl.callable.getDescriptor()), descriptor) && kParameterImpl.callable.getDescriptor().getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            DeclarationDescriptor containingDeclaration = kParameterImpl.callable.getDescriptor().getContainingDeclaration();
            Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) containingDeclaration);
            if (javaClass != null) {
                return javaClass;
            }
            throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + descriptor);
        }
        Caller<?> caller = kParameterImpl.callable.getCaller();
        if (!(caller instanceof ValueClassAwareCaller)) {
            if (!(caller instanceof ValueClassAwareCaller.MultiFieldValueClassPrimaryConstructorCaller)) {
                return caller.getParameterTypes().get(kParameterImpl.getIndex());
            }
            Class[] clsArr = (Class[]) ((ValueClassAwareCaller.MultiFieldValueClassPrimaryConstructorCaller) caller).getOriginalParametersGroups().get(kParameterImpl.getIndex()).toArray(new Class[0]);
            return kParameterImpl.compoundType((Type[]) Arrays.copyOf(clsArr, clsArr.length));
        }
        if (kParameterImpl.callable.isBound()) {
            ValueClassAwareCaller valueClassAwareCaller = (ValueClassAwareCaller) caller;
            IntRange realSlicesOfParameters = valueClassAwareCaller.getRealSlicesOfParameters(kParameterImpl.getIndex() + 1);
            int last = valueClassAwareCaller.getRealSlicesOfParameters(0).getLast() + 1;
            slice = CollectionsKt.slice(valueClassAwareCaller.getParameterTypes(), new IntRange(realSlicesOfParameters.getFirst() - last, realSlicesOfParameters.getLast() - last));
        } else {
            ValueClassAwareCaller valueClassAwareCaller2 = (ValueClassAwareCaller) caller;
            slice = CollectionsKt.slice(valueClassAwareCaller2.getParameterTypes(), valueClassAwareCaller2.getRealSlicesOfParameters(kParameterImpl.getIndex()));
        }
        Type[] typeArr = (Type[]) slice.toArray(new Type[0]);
        return kParameterImpl.compoundType((Type[]) Arrays.copyOf(typeArr, typeArr.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List annotations_delegate$lambda$0(KParameterImpl kParameterImpl) {
        return UtilKt.computeAnnotations(kParameterImpl.getDescriptor());
    }

    private final Type compoundType(Type... types) {
        int length = types.length;
        if (length != 0) {
            return length != 1 ? new CompoundTypeImpl(types) : (Type) ArraysKt.single(types);
        }
        throw new KotlinReflectionNotSupportedError("Expected at least 1 type for compound type");
    }

    private final ParameterDescriptor getDescriptor() {
        T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ParameterDescriptor) value;
    }

    public boolean equals(Object other) {
        if (other instanceof KParameterImpl) {
            KParameterImpl kParameterImpl = (KParameterImpl) other;
            if (Intrinsics.areEqual(this.callable, kParameterImpl.callable) && getIndex() == kParameterImpl.getIndex()) {
                return true;
            }
        }
        return false;
    }

    public final KCallableImpl<?> getCallable() {
        return this.callable;
    }

    @Override // kotlin.reflect.KParameter
    public int getIndex() {
        return this.index;
    }

    @Override // kotlin.reflect.KParameter
    public KParameter.Kind getKind() {
        return this.kind;
    }

    @Override // kotlin.reflect.KParameter
    public String getName() {
        ParameterDescriptor descriptor = getDescriptor();
        ValueParameterDescriptor valueParameterDescriptor = descriptor instanceof ValueParameterDescriptor ? (ValueParameterDescriptor) descriptor : null;
        if (valueParameterDescriptor == null || valueParameterDescriptor.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        Name name = valueParameterDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (name.isSpecial()) {
            return null;
        }
        return name.asString();
    }

    @Override // kotlin.reflect.KParameter
    public KType getType() {
        KotlinType type = getDescriptor().getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return new KTypeImpl(type, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KParameterImpl$$Lambda$1
            private final KParameterImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Type _get_type_$lambda$1;
                _get_type_$lambda$1 = KParameterImpl._get_type_$lambda$1(this.arg$0);
                return _get_type_$lambda$1;
            }
        });
    }

    public int hashCode() {
        return (this.callable.hashCode() * 31) + Integer.hashCode(getIndex());
    }

    @Override // kotlin.reflect.KParameter
    public boolean isOptional() {
        ParameterDescriptor descriptor = getDescriptor();
        ValueParameterDescriptor valueParameterDescriptor = descriptor instanceof ValueParameterDescriptor ? (ValueParameterDescriptor) descriptor : null;
        if (valueParameterDescriptor != null) {
            return DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor);
        }
        return false;
    }

    @Override // kotlin.reflect.KParameter
    public boolean isVararg() {
        ParameterDescriptor descriptor = getDescriptor();
        return (descriptor instanceof ValueParameterDescriptor) && ((ValueParameterDescriptor) descriptor).getVarargElementType() != null;
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderParameter(this);
    }
}
