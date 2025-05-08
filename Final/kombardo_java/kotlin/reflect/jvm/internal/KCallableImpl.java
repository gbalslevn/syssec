package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\u00028\u00002\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0013\"\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R.\u0010\u001b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0019 \u001a*\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00180\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cRD\u0010\u001f\u001a2\u0012.\u0012,\u0012\u0004\u0012\u00020\u0006 \u001a*\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u0006`\u001e0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\"\u0010!\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010 0 0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001cR.\u0010#\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\" \u001a*\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00180\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001cR2\u0010$\u001a \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r \u001a*\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00130\u00130\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001cR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0006\u0012\u0002\b\u00030)8&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001a\u0010.\u001a\b\u0012\u0002\b\u0003\u0018\u00010)8&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010+R\u0014\u00102\u001a\u00020/8&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00103\u001a\u00020&8&X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00108\u001a\u00020&8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b8\u00104R\u0014\u0010<\u001a\u0002098&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006="}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "<init>", "()V", "Lkotlin/reflect/KParameter;", "parameter", BuildConfig.FLAVOR, "getParameterTypeSize", "(Lkotlin/reflect/KParameter;)I", "Lkotlin/reflect/KType;", "type", BuildConfig.FLAVOR, "defaultEmptyArray", "(Lkotlin/reflect/KType;)Ljava/lang/Object;", "Ljava/lang/reflect/Type;", "extractContinuationArgument", "()Ljava/lang/reflect/Type;", BuildConfig.FLAVOR, "args", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "kotlin.jvm.PlatformType", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "_parameters", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "_typeParameters", "_absentArguments", "Lkotlin/Lazy;", BuildConfig.FLAVOR, "parametersNeedMFVCFlattening", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", "getDefaultCaller", "defaultCaller", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "isBound", "()Z", "getParameters", "()Ljava/util/List;", "parameters", "isAnnotationConstructor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "descriptor", "kotlin-reflection"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class KCallableImpl<R> implements KCallable<R>, KTypeParameterOwnerImpl {
    private final ReflectProperties.LazySoftVal<Object[]> _absentArguments;
    private final ReflectProperties.LazySoftVal<List<Annotation>> _annotations;
    private final ReflectProperties.LazySoftVal<ArrayList<KParameter>> _parameters;
    private final ReflectProperties.LazySoftVal<KTypeImpl> _returnType;
    private final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> _typeParameters;
    private final Lazy<Boolean> parametersNeedMFVCFlattening;

    public KCallableImpl() {
        ReflectProperties.LazySoftVal<List<Annotation>> lazySoft = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$0
            private final KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List _annotations$lambda$0;
                _annotations$lambda$0 = KCallableImpl._annotations$lambda$0(this.arg$0);
                return _annotations$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft, "lazySoft(...)");
        this._annotations = lazySoft;
        ReflectProperties.LazySoftVal<ArrayList<KParameter>> lazySoft2 = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$1
            private final KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                ArrayList _parameters$lambda$5;
                _parameters$lambda$5 = KCallableImpl._parameters$lambda$5(this.arg$0);
                return _parameters$lambda$5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft2, "lazySoft(...)");
        this._parameters = lazySoft2;
        ReflectProperties.LazySoftVal<KTypeImpl> lazySoft3 = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$2
            private final KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                KTypeImpl _returnType$lambda$7;
                _returnType$lambda$7 = KCallableImpl._returnType$lambda$7(this.arg$0);
                return _returnType$lambda$7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft3, "lazySoft(...)");
        this._returnType = lazySoft3;
        ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> lazySoft4 = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$3
            private final KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List _typeParameters$lambda$9;
                _typeParameters$lambda$9 = KCallableImpl._typeParameters$lambda$9(this.arg$0);
                return _typeParameters$lambda$9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft4, "lazySoft(...)");
        this._typeParameters = lazySoft4;
        ReflectProperties.LazySoftVal<Object[]> lazySoft5 = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$4
            private final KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Object[] _absentArguments$lambda$14;
                _absentArguments$lambda$14 = KCallableImpl._absentArguments$lambda$14(this.arg$0);
                return _absentArguments$lambda$14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft5, "lazySoft(...)");
        this._absentArguments = lazySoft5;
        this.parametersNeedMFVCFlattening = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$5
            private final KCallableImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                boolean parametersNeedMFVCFlattening$lambda$20;
                parametersNeedMFVCFlattening$lambda$20 = KCallableImpl.parametersNeedMFVCFlattening$lambda$20(this.arg$0);
                return Boolean.valueOf(parametersNeedMFVCFlattening$lambda$20);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] _absentArguments$lambda$14(KCallableImpl kCallableImpl) {
        int i5;
        List<KParameter> parameters = kCallableImpl.getParameters();
        int size = parameters.size() + (kCallableImpl.isSuspend() ? 1 : 0);
        if (kCallableImpl.parametersNeedMFVCFlattening.getValue().booleanValue()) {
            i5 = 0;
            for (KParameter kParameter : parameters) {
                i5 += kParameter.getKind() == KParameter.Kind.VALUE ? kCallableImpl.getParameterTypeSize(kParameter) : 0;
            }
        } else {
            List<KParameter> list = parameters;
            if ((list instanceof Collection) && list.isEmpty()) {
                i5 = 0;
            } else {
                Iterator<T> it = list.iterator();
                i5 = 0;
                while (it.hasNext()) {
                    if (((KParameter) it.next()).getKind() == KParameter.Kind.VALUE && (i5 = i5 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
        }
        int i6 = (i5 + 31) / 32;
        Object[] objArr = new Object[size + i6 + 1];
        for (KParameter kParameter2 : parameters) {
            if (kParameter2.isOptional() && !UtilKt.isInlineClassType(kParameter2.getType())) {
                objArr[kParameter2.getIndex()] = UtilKt.defaultPrimitiveValue(ReflectJvmMapping.getJavaType(kParameter2.getType()));
            } else if (kParameter2.isVararg()) {
                objArr[kParameter2.getIndex()] = kCallableImpl.defaultEmptyArray(kParameter2.getType());
            }
        }
        for (int i7 = 0; i7 < i6; i7++) {
            objArr[size + i7] = 0;
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _annotations$lambda$0(KCallableImpl kCallableImpl) {
        return UtilKt.computeAnnotations(kCallableImpl.getDescriptor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList _parameters$lambda$5(KCallableImpl kCallableImpl) {
        int i5;
        final CallableMemberDescriptor descriptor = kCallableImpl.getDescriptor();
        ArrayList arrayList = new ArrayList();
        final int i6 = 0;
        if (kCallableImpl.isBound()) {
            i5 = 0;
        } else {
            final ReceiverParameterDescriptor instanceReceiverParameter = UtilKt.getInstanceReceiverParameter(descriptor);
            if (instanceReceiverParameter != null) {
                arrayList.add(new KParameterImpl(kCallableImpl, 0, KParameter.Kind.INSTANCE, new Function0(instanceReceiverParameter) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$6
                    private final ReceiverParameterDescriptor arg$0;

                    {
                        this.arg$0 = instanceReceiverParameter;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        ParameterDescriptor _parameters$lambda$5$lambda$1;
                        _parameters$lambda$5$lambda$1 = KCallableImpl._parameters$lambda$5$lambda$1(this.arg$0);
                        return _parameters$lambda$5$lambda$1;
                    }
                }));
                i5 = 1;
            } else {
                i5 = 0;
            }
            final ReceiverParameterDescriptor extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
            if (extensionReceiverParameter != null) {
                arrayList.add(new KParameterImpl(kCallableImpl, i5, KParameter.Kind.EXTENSION_RECEIVER, new Function0(extensionReceiverParameter) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$7
                    private final ReceiverParameterDescriptor arg$0;

                    {
                        this.arg$0 = extensionReceiverParameter;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        ParameterDescriptor _parameters$lambda$5$lambda$2;
                        _parameters$lambda$5$lambda$2 = KCallableImpl._parameters$lambda$5$lambda$2(this.arg$0);
                        return _parameters$lambda$5$lambda$2;
                    }
                }));
                i5++;
            }
        }
        int size = descriptor.getValueParameters().size();
        while (i6 < size) {
            arrayList.add(new KParameterImpl(kCallableImpl, i5, KParameter.Kind.VALUE, new Function0(descriptor, i6) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$8
                private final CallableMemberDescriptor arg$0;
                private final int arg$1;

                {
                    this.arg$0 = descriptor;
                    this.arg$1 = i6;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    ParameterDescriptor _parameters$lambda$5$lambda$3;
                    _parameters$lambda$5$lambda$3 = KCallableImpl._parameters$lambda$5$lambda$3(this.arg$0, this.arg$1);
                    return _parameters$lambda$5$lambda$3;
                }
            }));
            i6++;
            i5++;
        }
        if (kCallableImpl.isAnnotationConstructor() && (descriptor instanceof JavaCallableMemberDescriptor) && arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$lambda$5$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t5, T t6) {
                    return ComparisonsKt.compareValues(((KParameter) t5).getName(), ((KParameter) t6).getName());
                }
            });
        }
        arrayList.trimToSize();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParameterDescriptor _parameters$lambda$5$lambda$1(ReceiverParameterDescriptor receiverParameterDescriptor) {
        return receiverParameterDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParameterDescriptor _parameters$lambda$5$lambda$2(ReceiverParameterDescriptor receiverParameterDescriptor) {
        return receiverParameterDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParameterDescriptor _parameters$lambda$5$lambda$3(CallableMemberDescriptor callableMemberDescriptor, int i5) {
        ValueParameterDescriptor valueParameterDescriptor = callableMemberDescriptor.getValueParameters().get(i5);
        Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "get(...)");
        return valueParameterDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KTypeImpl _returnType$lambda$7(final KCallableImpl kCallableImpl) {
        KotlinType returnType = kCallableImpl.getDescriptor().getReturnType();
        Intrinsics.checkNotNull(returnType);
        return new KTypeImpl(returnType, new Function0(kCallableImpl) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$$Lambda$9
            private final KCallableImpl arg$0;

            {
                this.arg$0 = kCallableImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Type _returnType$lambda$7$lambda$6;
                _returnType$lambda$7$lambda$6 = KCallableImpl._returnType$lambda$7$lambda$6(this.arg$0);
                return _returnType$lambda$7$lambda$6;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type _returnType$lambda$7$lambda$6(KCallableImpl kCallableImpl) {
        Type extractContinuationArgument = kCallableImpl.extractContinuationArgument();
        return extractContinuationArgument == null ? kCallableImpl.getCaller().getReturnType() : extractContinuationArgument;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _typeParameters$lambda$9(KCallableImpl kCallableImpl) {
        List<TypeParameterDescriptor> typeParameters = kCallableImpl.getDescriptor().getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
        List<TypeParameterDescriptor> list = typeParameters;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (TypeParameterDescriptor typeParameterDescriptor : list) {
            Intrinsics.checkNotNull(typeParameterDescriptor);
            arrayList.add(new KTypeParameterImpl(kCallableImpl, typeParameterDescriptor));
        }
        return arrayList;
    }

    private final Object defaultEmptyArray(KType type) {
        Class javaClass = JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(type));
        if (javaClass.isArray()) {
            Object newInstance = Array.newInstance(javaClass.getComponentType(), 0);
            Intrinsics.checkNotNullExpressionValue(newInstance, "run(...)");
            return newInstance;
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + javaClass.getSimpleName() + ", because it is not an array type");
    }

    private final Type extractContinuationArgument() {
        Type[] lowerBounds;
        if (!isSuspend()) {
            return null;
        }
        Object lastOrNull = CollectionsKt.lastOrNull((List<? extends Object>) getCaller().getParameterTypes());
        ParameterizedType parameterizedType = lastOrNull instanceof ParameterizedType ? (ParameterizedType) lastOrNull : null;
        if (!Intrinsics.areEqual(parameterizedType != null ? parameterizedType.getRawType() : null, Continuation.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "getActualTypeArguments(...)");
        Object single = ArraysKt.single(actualTypeArguments);
        WildcardType wildcardType = single instanceof WildcardType ? (WildcardType) single : null;
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) ArraysKt.first(lowerBounds);
    }

    private final int getParameterTypeSize(KParameter parameter) {
        if (!this.parametersNeedMFVCFlattening.getValue().booleanValue()) {
            throw new IllegalArgumentException("Check if parametersNeedMFVCFlattening is true before");
        }
        if (!UtilKt.getNeedsMultiFieldValueClassFlattening(parameter.getType())) {
            return 1;
        }
        KType type = parameter.getType();
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        List<Method> mfvcUnboxMethods = ValueClassAwareCallerKt.getMfvcUnboxMethods(TypeSubstitutionKt.asSimpleType(((KTypeImpl) type).getType()));
        Intrinsics.checkNotNull(mfvcUnboxMethods);
        return mfvcUnboxMethods.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parametersNeedMFVCFlattening$lambda$20(KCallableImpl kCallableImpl) {
        List<KParameter> parameters = kCallableImpl.getParameters();
        if ((parameters instanceof Collection) && parameters.isEmpty()) {
            return false;
        }
        Iterator<T> it = parameters.iterator();
        while (it.hasNext()) {
            if (UtilKt.getNeedsMultiFieldValueClassFlattening(((KParameter) it.next()).getType())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KCallable
    public R call(Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            return (R) getCaller().call(args);
        } catch (IllegalAccessException e5) {
            throw new IllegalCallableAccessException(e5);
        }
    }

    public abstract Caller<?> getCaller();

    public abstract KDeclarationContainerImpl getContainer();

    public abstract Caller<?> getDefaultCaller();

    public abstract CallableMemberDescriptor getDescriptor();

    public List<KParameter> getParameters() {
        ArrayList<KParameter> invoke = this._parameters.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return invoke;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isAnnotationConstructor() {
        return Intrinsics.areEqual(getName(), "<init>") && getContainer().getJClass().isAnnotation();
    }

    public abstract boolean isBound();
}
