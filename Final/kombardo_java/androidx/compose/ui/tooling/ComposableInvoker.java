package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.tooling.PreviewLogger;
import com.adjust.sdk.Constants;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Deprecated
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\t\u001a\u00020\b2\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00042\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ=\u0010\u000f\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\r\u001a\u00020\f2\u001a\u0010\u000e\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004\"\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u0012\u001a\u0004\u0018\u00010\u000b*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\r\u001a\u00020\f2\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u0019\u001a\u0004\u0018\u00010\u0001*\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0018\u001a\u00020\u00172\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b \u0010!J?\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010'¨\u0006)"}, d2 = {"Landroidx/compose/ui/tooling/ComposableInvoker;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "Ljava/lang/Class;", "composableMethodTypes", "previewParameterTypes", BuildConfig.FLAVOR, "areParameterTypesCompatible", "([Ljava/lang/Class;[Ljava/lang/Class;)Z", "Ljava/lang/reflect/Method;", BuildConfig.FLAVOR, "methodName", "args", "findCompatibleComposeMethod", "([Ljava/lang/reflect/Method;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "previewParamArgs", "findComposableMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/reflect/Method;", "getDefaultValue", "(Ljava/lang/Class;)Ljava/lang/Object;", "instance", "Landroidx/compose/runtime/Composer;", "composer", "invokeComposableMethod", "(Ljava/lang/reflect/Method;Ljava/lang/Object;Landroidx/compose/runtime/Composer;[Ljava/lang/Object;)Ljava/lang/Object;", BuildConfig.FLAVOR, "realValueParams", "thisParams", "changedParamCount", "(II)I", "defaultParamCount", "(I)I", "className", BuildConfig.FLAVOR, "invokeComposable", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;[Ljava/lang/Object;)V", "SLOTS_PER_INT", "I", "BITS_PER_INT", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposableInvoker {
    private static final int BITS_PER_INT = 31;
    public static final ComposableInvoker INSTANCE = new ComposableInvoker();
    private static final int SLOTS_PER_INT = 10;

    private ComposableInvoker() {
    }

    private final boolean areParameterTypesCompatible(Class<?>[] composableMethodTypes, Class<?>[] previewParameterTypes) {
        if (composableMethodTypes.length != previewParameterTypes.length) {
            return false;
        }
        ArrayList arrayList = new ArrayList(composableMethodTypes.length);
        int length = composableMethodTypes.length;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z5 = true;
            if (i5 >= length) {
                break;
            }
            Class<?> cls = composableMethodTypes[i5];
            int i7 = i6 + 1;
            Class<?> cls2 = previewParameterTypes[i6];
            if (!Intrinsics.areEqual(JvmClassMappingKt.getKotlinClass(cls), JvmClassMappingKt.getKotlinClass(cls2)) && !cls.isAssignableFrom(cls2)) {
                z5 = false;
            }
            arrayList.add(Boolean.valueOf(z5));
            i5++;
            i6 = i7;
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((Boolean) it.next()).booleanValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    private final int changedParamCount(int realValueParams, int thisParams) {
        if (realValueParams == 0) {
            return 1;
        }
        return (int) Math.ceil((realValueParams + thisParams) / 10.0d);
    }

    private final int defaultParamCount(int realValueParams) {
        return (int) Math.ceil(realValueParams / 31.0d);
    }

    private final Method findCompatibleComposeMethod(Method[] methodArr, String str, Class<?>... clsArr) {
        Method method;
        int length = methodArr.length;
        int i5 = 0;
        while (true) {
            method = null;
            if (i5 >= length) {
                break;
            }
            Method method2 = methodArr[i5];
            if (!Intrinsics.areEqual(str, method2.getName())) {
                if (!StringsKt.startsWith$default(method2.getName(), str + '-', false, 2, (Object) null)) {
                    continue;
                    i5++;
                }
            }
            if (INSTANCE.areParameterTypesCompatible(method2.getParameterTypes(), (Class[]) Arrays.copyOf(clsArr, clsArr.length))) {
                method = method2;
                break;
            }
            i5++;
        }
        if (method != null) {
            return method;
        }
        throw new NoSuchMethodException(str + " not found");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Method findComposableMethod(Class<?> cls, String str, Object... objArr) {
        Class<?> cls2;
        ArrayList arrayList = new ArrayList();
        int length = objArr.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            }
            Object obj = objArr[i5];
            cls2 = obj != null ? obj.getClass() : null;
            if (cls2 != null) {
                arrayList.add(cls2);
            }
            i5++;
        }
        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        try {
            try {
                int changedParamCount = changedParamCount(clsArr.length, 0);
                Class cls3 = Integer.TYPE;
                IntRange until = RangesKt.until(0, changedParamCount);
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    ((IntIterator) it).nextInt();
                    arrayList2.add(cls3);
                }
                Class[] clsArr2 = (Class[]) arrayList2.toArray(new Class[0]);
                Method[] declaredMethods = cls.getDeclaredMethods();
                SpreadBuilder spreadBuilder = new SpreadBuilder(3);
                spreadBuilder.addSpread(clsArr);
                spreadBuilder.add(Composer.class);
                spreadBuilder.addSpread(clsArr2);
                return findCompatibleComposeMethod(declaredMethods, str, (Class[]) spreadBuilder.toArray(new Class[spreadBuilder.size()]));
            } catch (ReflectiveOperationException unused) {
                return cls2;
            }
        } catch (ReflectiveOperationException unused2) {
            for (Method method : cls.getDeclaredMethods()) {
                if (!Intrinsics.areEqual(method.getName(), str)) {
                    if (!StringsKt.startsWith$default(method.getName(), str + '-', false, 2, (Object) null)) {
                    }
                }
                cls2 = method;
                break;
            }
            return cls2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final Object getDefaultValue(Class<?> cls) {
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    return Double.valueOf(0.0d);
                }
                return null;
            case 104431:
                if (name.equals("int")) {
                    return 0;
                }
                return null;
            case 3039496:
                if (name.equals("byte")) {
                    return (byte) 0;
                }
                return null;
            case 3052374:
                if (name.equals("char")) {
                    return (char) 0;
                }
                return null;
            case 3327612:
                if (name.equals(Constants.LONG)) {
                    return 0L;
                }
                return null;
            case 64711720:
                if (name.equals("boolean")) {
                    return Boolean.FALSE;
                }
                return null;
            case 97526364:
                if (name.equals("float")) {
                    return Float.valueOf(0.0f);
                }
                return null;
            case 109413500:
                if (name.equals("short")) {
                    return (short) 0;
                }
                return null;
            default:
                return null;
        }
    }

    private final Object invokeComposableMethod(Method method, Object obj, Composer composer, Object... objArr) {
        Object obj2;
        Class<?>[] parameterTypes = method.getParameterTypes();
        int i5 = -1;
        int length = parameterTypes.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (Intrinsics.areEqual(parameterTypes[length], Composer.class)) {
                    i5 = length;
                    break;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        int i7 = i5 + 1;
        int changedParamCount = changedParamCount(i5, obj != null ? 1 : 0) + i7;
        int length2 = method.getParameterTypes().length;
        if ((length2 != changedParamCount ? defaultParamCount(i5) : 0) + changedParamCount != length2) {
            throw new IllegalStateException("params don't add up to total params");
        }
        Object[] objArr2 = new Object[length2];
        int i8 = 0;
        while (i8 < length2) {
            if (i8 >= 0 && i8 < i5) {
                obj2 = (i8 < 0 || i8 > ArraysKt.getLastIndex(objArr)) ? INSTANCE.getDefaultValue(method.getParameterTypes()[i8]) : objArr[i8];
            } else if (i8 == i5) {
                obj2 = composer;
            } else if (i7 <= i8 && i8 < changedParamCount) {
                obj2 = 0;
            } else {
                if (changedParamCount > i8 || i8 >= length2) {
                    throw new IllegalStateException("Unexpected index");
                }
                obj2 = 2097151;
            }
            objArr2[i8] = obj2;
            i8++;
        }
        return method.invoke(obj, Arrays.copyOf(objArr2, length2));
    }

    public final void invokeComposable(String className, String methodName, Composer composer, Object... args) {
        try {
            Class<?> cls = Class.forName(className);
            Method findComposableMethod = findComposableMethod(cls, methodName, Arrays.copyOf(args, args.length));
            if (findComposableMethod != null) {
                findComposableMethod.setAccessible(true);
                if (Modifier.isStatic(findComposableMethod.getModifiers())) {
                    invokeComposableMethod(findComposableMethod, null, composer, Arrays.copyOf(args, args.length));
                    return;
                } else {
                    invokeComposableMethod(findComposableMethod, cls.getConstructor(null).newInstance(null), composer, Arrays.copyOf(args, args.length));
                    return;
                }
            }
            throw new NoSuchMethodException("Composable " + className + '.' + methodName + " not found");
        } catch (Exception e5) {
            PreviewLogger.Companion.logWarning$ui_tooling_release$default(PreviewLogger.INSTANCE, "Failed to invoke Composable Method '" + className + '.' + methodName + '\'', null, 2, null);
            throw e5;
        }
    }
}
