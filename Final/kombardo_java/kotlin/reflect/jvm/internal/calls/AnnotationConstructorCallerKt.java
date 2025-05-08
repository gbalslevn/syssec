package kotlin.reflect.jvm.internal.calls;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001a$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001aI\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0000¢\u0006\u0002\u0010\u0013¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u0007X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"transformKotlinToJvm", BuildConfig.FLAVOR, "expectedType", "Ljava/lang/Class;", "throwIllegalArgumentType", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "expectedJvmType", "createAnnotationInstance", "T", "annotationClass", "values", BuildConfig.FLAVOR, "methods", BuildConfig.FLAVOR, "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "kotlin-reflection", "hashCode", "toString"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AnnotationConstructorCallerKt {
    public static final <T> T createAnnotationInstance(Class<T> annotationClass, Map<String, ? extends Object> values, List<Method> methods) {
        Intrinsics.checkNotNullParameter(annotationClass, "annotationClass");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(methods, "methods");
        Lazy lazy = LazyKt.lazy(new Function0(values) { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$0
            private final Map arg$0;

            {
                this.arg$0 = values;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                int createAnnotationInstance$lambda$3;
                createAnnotationInstance$lambda$3 = AnnotationConstructorCallerKt.createAnnotationInstance$lambda$3(this.arg$0);
                return Integer.valueOf(createAnnotationInstance$lambda$3);
            }
        });
        T t5 = (T) Proxy.newProxyInstance(annotationClass.getClassLoader(), new Class[]{annotationClass}, new InvocationHandler(annotationClass, values, LazyKt.lazy(new Function0(annotationClass, values) { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$1
            private final Class arg$0;
            private final Map arg$1;

            {
                this.arg$0 = annotationClass;
                this.arg$1 = values;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                String createAnnotationInstance$lambda$7;
                createAnnotationInstance$lambda$7 = AnnotationConstructorCallerKt.createAnnotationInstance$lambda$7(this.arg$0, this.arg$1);
                return createAnnotationInstance$lambda$7;
            }
        }), lazy, methods) { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$2
            private final Class arg$0;
            private final Map arg$1;
            private final Lazy arg$2;
            private final Lazy arg$3;
            private final List arg$4;

            {
                this.arg$0 = annotationClass;
                this.arg$1 = values;
                this.arg$2 = r3;
                this.arg$3 = lazy;
                this.arg$4 = methods;
            }

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                Object createAnnotationInstance$lambda$9;
                createAnnotationInstance$lambda$9 = AnnotationConstructorCallerKt.createAnnotationInstance$lambda$9(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4, obj, method, objArr);
                return createAnnotationInstance$lambda$9;
            }
        });
        Intrinsics.checkNotNull(t5, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return t5;
    }

    public static /* synthetic */ Object createAnnotationInstance$default(Class cls, Map map, List list, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            Set keySet = map.keySet();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(keySet, 10));
            Iterator it = keySet.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), null));
            }
            list = arrayList;
        }
        return createAnnotationInstance(cls, map, list);
    }

    private static final <T> boolean createAnnotationInstance$equals(Class<T> cls, List<Method> list, Map<String, ? extends Object> map, Object obj) {
        boolean areEqual;
        boolean z5;
        KClass annotationClass;
        Annotation annotation = obj instanceof Annotation ? (Annotation) obj : null;
        if (!Intrinsics.areEqual((annotation == null || (annotationClass = JvmClassMappingKt.getAnnotationClass(annotation)) == null) ? null : JvmClassMappingKt.getJavaClass(annotationClass), cls)) {
            return false;
        }
        List<Method> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            for (Method method : list2) {
                Object obj2 = map.get(method.getName());
                Object invoke = method.invoke(obj, null);
                if (obj2 instanceof boolean[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.BooleanArray");
                    areEqual = Arrays.equals((boolean[]) obj2, (boolean[]) invoke);
                } else if (obj2 instanceof char[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.CharArray");
                    areEqual = Arrays.equals((char[]) obj2, (char[]) invoke);
                } else if (obj2 instanceof byte[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.ByteArray");
                    areEqual = Arrays.equals((byte[]) obj2, (byte[]) invoke);
                } else if (obj2 instanceof short[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.ShortArray");
                    areEqual = Arrays.equals((short[]) obj2, (short[]) invoke);
                } else if (obj2 instanceof int[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.IntArray");
                    areEqual = Arrays.equals((int[]) obj2, (int[]) invoke);
                } else if (obj2 instanceof float[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.FloatArray");
                    areEqual = Arrays.equals((float[]) obj2, (float[]) invoke);
                } else if (obj2 instanceof long[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.LongArray");
                    areEqual = Arrays.equals((long[]) obj2, (long[]) invoke);
                } else if (obj2 instanceof double[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.DoubleArray");
                    areEqual = Arrays.equals((double[]) obj2, (double[]) invoke);
                } else if (obj2 instanceof Object[]) {
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
                    areEqual = Arrays.equals((Object[]) obj2, (Object[]) invoke);
                } else {
                    areEqual = Intrinsics.areEqual(obj2, invoke);
                }
                if (!areEqual) {
                    z5 = false;
                    break;
                }
            }
        }
        z5 = true;
        return z5;
    }

    public static final int createAnnotationInstance$lambda$3(Map map) {
        int i5 = 0;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            i5 += (value instanceof boolean[] ? Arrays.hashCode((boolean[]) value) : value instanceof char[] ? Arrays.hashCode((char[]) value) : value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value instanceof short[] ? Arrays.hashCode((short[]) value) : value instanceof int[] ? Arrays.hashCode((int[]) value) : value instanceof float[] ? Arrays.hashCode((float[]) value) : value instanceof long[] ? Arrays.hashCode((long[]) value) : value instanceof double[] ? Arrays.hashCode((double[]) value) : value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode()) ^ (str.hashCode() * 127);
        }
        return i5;
    }

    private static final int createAnnotationInstance$lambda$4(Lazy<Integer> lazy) {
        return lazy.getValue().intValue();
    }

    public static final String createAnnotationInstance$lambda$7(Class cls, Map map) {
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        sb.append(cls.getCanonicalName());
        CollectionsKt.joinTo$default(map.entrySet(), sb, ", ", "(", ")", 0, null, new Function1() { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$3
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                CharSequence createAnnotationInstance$lambda$7$lambda$6$lambda$5;
                createAnnotationInstance$lambda$7$lambda$6$lambda$5 = AnnotationConstructorCallerKt.createAnnotationInstance$lambda$7$lambda$6$lambda$5((Map.Entry) obj);
                return createAnnotationInstance$lambda$7$lambda$6$lambda$5;
            }
        }, 48, null);
        return sb.toString();
    }

    public static final CharSequence createAnnotationInstance$lambda$7$lambda$6$lambda$5(Map.Entry entry) {
        String obj;
        Intrinsics.checkNotNullParameter(entry, "entry");
        String str = (String) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof boolean[]) {
            obj = Arrays.toString((boolean[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(...)");
        } else if (value instanceof char[]) {
            obj = Arrays.toString((char[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(...)");
        } else if (value instanceof byte[]) {
            obj = Arrays.toString((byte[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(...)");
        } else if (value instanceof short[]) {
            obj = Arrays.toString((short[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(...)");
        } else if (value instanceof int[]) {
            obj = Arrays.toString((int[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(...)");
        } else if (value instanceof float[]) {
            obj = Arrays.toString((float[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(...)");
        } else if (value instanceof long[]) {
            obj = Arrays.toString((long[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(...)");
        } else if (value instanceof double[]) {
            obj = Arrays.toString((double[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(...)");
        } else if (value instanceof Object[]) {
            obj = Arrays.toString((Object[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(...)");
        } else {
            obj = value.toString();
        }
        return str + '=' + obj;
    }

    private static final String createAnnotationInstance$lambda$8(Lazy<String> lazy) {
        return lazy.getValue();
    }

    public static final Object createAnnotationInstance$lambda$9(Class cls, Map map, Lazy lazy, Lazy lazy2, List list, Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if (name != null) {
            int hashCode = name.hashCode();
            if (hashCode != -1776922004) {
                if (hashCode != 147696667) {
                    if (hashCode == 1444986633 && name.equals("annotationType")) {
                        return cls;
                    }
                } else if (name.equals("hashCode")) {
                    return Integer.valueOf(createAnnotationInstance$lambda$4(lazy2));
                }
            } else if (name.equals("toString")) {
                return createAnnotationInstance$lambda$8(lazy);
            }
        }
        if (Intrinsics.areEqual(name, "equals") && objArr != null && objArr.length == 1) {
            return Boolean.valueOf(createAnnotationInstance$equals(cls, list, map, ArraysKt.single(objArr)));
        }
        if (map.containsKey(name)) {
            return map.get(name);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Method is not supported: ");
        sb.append(method);
        sb.append(" (args: ");
        if (objArr == null) {
            objArr = new Object[0];
        }
        sb.append(ArraysKt.toList(objArr));
        sb.append(')');
        throw new KotlinReflectionInternalError(sb.toString());
    }

    public static final Void throwIllegalArgumentType(int i5, String str, Class<?> cls) {
        String qualifiedName;
        KClass orCreateKotlinClass = Intrinsics.areEqual(cls, Class.class) ? Reflection.getOrCreateKotlinClass(KClass.class) : (cls.isArray() && Intrinsics.areEqual(cls.getComponentType(), Class.class)) ? Reflection.getOrCreateKotlinClass(KClass[].class) : JvmClassMappingKt.getKotlinClass(cls);
        if (Intrinsics.areEqual(orCreateKotlinClass.getQualifiedName(), Reflection.getOrCreateKotlinClass(Object[].class).getQualifiedName())) {
            StringBuilder sb = new StringBuilder();
            sb.append(orCreateKotlinClass.getQualifiedName());
            sb.append('<');
            Class<?> componentType = JvmClassMappingKt.getJavaClass(orCreateKotlinClass).getComponentType();
            Intrinsics.checkNotNullExpressionValue(componentType, "getComponentType(...)");
            sb.append(JvmClassMappingKt.getKotlinClass(componentType).getQualifiedName());
            sb.append('>');
            qualifiedName = sb.toString();
        } else {
            qualifiedName = orCreateKotlinClass.getQualifiedName();
        }
        throw new IllegalArgumentException("Argument #" + i5 + ' ' + str + " is not of the required type " + qualifiedName);
    }

    public static final Object transformKotlinToJvm(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof KClass) {
            obj = JvmClassMappingKt.getJavaClass((KClass) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof KClass[]) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                KClass[] kClassArr = (KClass[]) obj;
                ArrayList arrayList = new ArrayList(kClassArr.length);
                for (KClass kClass : kClassArr) {
                    arrayList.add(JvmClassMappingKt.getJavaClass(kClass));
                }
                obj = arrayList.toArray(new Class[0]);
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }
}
