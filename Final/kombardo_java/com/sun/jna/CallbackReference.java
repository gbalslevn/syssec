package com.sun.jna;

import com.sun.jna.Library;
import com.sun.jna.Structure;
import com.sun.jna.internal.Cleaner;
import com.sun.jna.win32.DLLCallback;
import java.io.Closeable;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class CallbackReference extends WeakReference<Callback> implements Closeable {
    private static final Class<?> DLL_CALLBACK_CLASS;
    private static final Method PROXY_CALLBACK_METHOD;
    private static final Map<Callback, CallbackThreadInitializer> initializers;
    int callingConvention;
    Pointer cbstruct;
    Cleaner.Cleanable cleanable;
    Method method;
    CallbackProxy proxy;
    Pointer trampoline;
    static final Map<Callback, CallbackReference> callbackMap = new WeakHashMap();
    static final Map<Callback, CallbackReference> directCallbackMap = new WeakHashMap();
    static final Map<Pointer, Reference<Callback>[]> pointerCallbackMap = new WeakHashMap();
    static final Map<Object, Object> allocations = Collections.synchronizedMap(new WeakHashMap());
    private static final Map<Long, Reference<CallbackReference>> allocatedMemory = new ConcurrentHashMap();

    /* loaded from: classes2.dex */
    static class AttachOptions extends Structure {
        public static final List<String> FIELDS = Structure.createFieldsOrder("daemon", "detach", "name");
        public boolean daemon;
        public boolean detach;
        public String name;

        AttachOptions() {
            setStringEncoding("utf8");
        }

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return FIELDS;
        }
    }

    /* loaded from: classes2.dex */
    private static final class CallbackReferenceDisposer implements Runnable {
        private Pointer cbstruct;

        public CallbackReferenceDisposer(Pointer pointer) {
            this.cbstruct = pointer;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
                Pointer pointer = this.cbstruct;
                if (pointer != null) {
                    try {
                        Native.freeNativeCallback(pointer.peer);
                        CallbackReference.allocatedMemory.remove(Long.valueOf(this.cbstruct.peer));
                        this.cbstruct.peer = 0L;
                        this.cbstruct = null;
                    } catch (Throwable th) {
                        CallbackReference.allocatedMemory.remove(Long.valueOf(this.cbstruct.peer));
                        this.cbstruct.peer = 0L;
                        this.cbstruct = null;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* loaded from: classes2.dex */
    private class DefaultCallbackProxy implements CallbackProxy {
        private final Method callbackMethod;
        private final String encoding;
        private final FromNativeConverter[] fromNative;
        private ToNativeConverter toNative;

        public DefaultCallbackProxy(Method method, TypeMapper typeMapper, String str) {
            this.callbackMethod = method;
            this.encoding = str;
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> returnType = method.getReturnType();
            this.fromNative = new FromNativeConverter[parameterTypes.length];
            if (NativeMapped.class.isAssignableFrom(returnType)) {
                this.toNative = NativeMappedConverter.getInstance(returnType);
            } else if (typeMapper != null) {
                this.toNative = typeMapper.getToNativeConverter(returnType);
            }
            for (int i5 = 0; i5 < this.fromNative.length; i5++) {
                if (NativeMapped.class.isAssignableFrom(parameterTypes[i5])) {
                    this.fromNative[i5] = new NativeMappedConverter(parameterTypes[i5]);
                } else if (typeMapper != null) {
                    this.fromNative[i5] = typeMapper.getFromNativeConverter(parameterTypes[i5]);
                }
            }
            if (method.isAccessible()) {
                return;
            }
            try {
                method.setAccessible(true);
            } catch (SecurityException unused) {
                throw new IllegalArgumentException("Callback method is inaccessible, make sure the interface is public: " + method);
            }
        }

        private Object convertArgument(Object obj, Class<?> cls) {
            Object obj2;
            if (!(obj instanceof Pointer)) {
                if ((Boolean.TYPE == cls || Boolean.class == cls) && (obj instanceof Number)) {
                    return Function.valueOf(((Number) obj).intValue() != 0);
                }
                return obj;
            }
            if (cls == String.class) {
                return ((Pointer) obj).getString(0L, this.encoding);
            }
            if (cls == WString.class) {
                obj2 = new WString(((Pointer) obj).getWideString(0L));
            } else {
                if (cls == String[].class) {
                    return ((Pointer) obj).getStringArray(0L, this.encoding);
                }
                if (cls == WString[].class) {
                    return ((Pointer) obj).getWideStringArray(0L);
                }
                if (Callback.class.isAssignableFrom(cls)) {
                    return CallbackReference.getCallback(cls, (Pointer) obj);
                }
                if (!Structure.class.isAssignableFrom(cls)) {
                    return obj;
                }
                if (!Structure.ByValue.class.isAssignableFrom(cls)) {
                    Structure newInstance = Structure.newInstance((Class<Structure>) cls, (Pointer) obj);
                    newInstance.conditionalAutoRead();
                    return newInstance;
                }
                Structure newInstance2 = Structure.newInstance(cls);
                int size = newInstance2.size();
                byte[] bArr = new byte[size];
                ((Pointer) obj).read(0L, bArr, 0, size);
                newInstance2.getPointer().write(0L, bArr, 0, size);
                newInstance2.read();
                obj2 = newInstance2;
            }
            return obj2;
        }

        private Object convertResult(Object obj) {
            ToNativeConverter toNativeConverter = this.toNative;
            if (toNativeConverter != null) {
                obj = toNativeConverter.toNative(obj, new CallbackResultContext(this.callbackMethod));
            }
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (Structure.class.isAssignableFrom(cls)) {
                return Structure.ByValue.class.isAssignableFrom(cls) ? obj : ((Structure) obj).getPointer();
            }
            if (cls == Boolean.TYPE || cls == Boolean.class) {
                return Boolean.TRUE.equals(obj) ? Function.INTEGER_TRUE : Function.INTEGER_FALSE;
            }
            if (cls == String.class || cls == WString.class) {
                return CallbackReference.getNativeString(obj, cls == WString.class);
            }
            if (cls != String[].class && cls != WString[].class) {
                return Callback.class.isAssignableFrom(cls) ? CallbackReference.getFunctionPointer((Callback) obj) : obj;
            }
            StringArray stringArray = cls == String[].class ? new StringArray((String[]) obj, this.encoding) : new StringArray((WString[]) obj);
            CallbackReference.allocations.put(obj, stringArray);
            return stringArray;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private Object invokeCallback(Object[] objArr) {
            Object convertResult;
            Class<?>[] parameterTypes = this.callbackMethod.getParameterTypes();
            int length = objArr.length;
            Object[] objArr2 = new Object[length];
            for (int i5 = 0; i5 < objArr.length; i5++) {
                Class<?> cls = parameterTypes[i5];
                Object obj = objArr[i5];
                if (this.fromNative[i5] != null) {
                    objArr2[i5] = this.fromNative[i5].fromNative(obj, new CallbackParameterContext(cls, this.callbackMethod, objArr, i5));
                } else {
                    objArr2[i5] = convertArgument(obj, cls);
                }
            }
            Callback callback = getCallback();
            if (callback != null) {
                try {
                    convertResult = convertResult(this.callbackMethod.invoke(callback, objArr2));
                } catch (IllegalAccessException e5) {
                    e = e5;
                    Native.getCallbackExceptionHandler().uncaughtException(callback, e);
                    convertResult = null;
                    while (r3 < length) {
                    }
                    return convertResult;
                } catch (IllegalArgumentException e6) {
                    e = e6;
                    Native.getCallbackExceptionHandler().uncaughtException(callback, e);
                    convertResult = null;
                    while (r3 < length) {
                    }
                    return convertResult;
                } catch (InvocationTargetException e7) {
                    Native.getCallbackExceptionHandler().uncaughtException(callback, e7.getTargetException());
                }
                for (int i6 = 0; i6 < length; i6++) {
                    Object obj2 = objArr2[i6];
                    if ((obj2 instanceof Structure) && !(obj2 instanceof Structure.ByValue)) {
                        ((Structure) obj2).autoWrite();
                    }
                }
                return convertResult;
            }
            convertResult = null;
            while (i6 < length) {
            }
            return convertResult;
        }

        @Override // com.sun.jna.CallbackProxy
        public Object callback(Object[] objArr) {
            try {
                return invokeCallback(objArr);
            } catch (Throwable th) {
                Native.getCallbackExceptionHandler().uncaughtException(getCallback(), th);
                return null;
            }
        }

        public Callback getCallback() {
            return CallbackReference.this.getCallback();
        }

        @Override // com.sun.jna.CallbackProxy
        public Class<?>[] getParameterTypes() {
            return this.callbackMethod.getParameterTypes();
        }

        @Override // com.sun.jna.CallbackProxy
        public Class<?> getReturnType() {
            return this.callbackMethod.getReturnType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class NativeFunctionHandler implements InvocationHandler {
        private final Function function;
        private final Map<String, ?> options;

        public NativeFunctionHandler(Pointer pointer, int i5, Map<String, ?> map) {
            this.options = map;
            this.function = new Function(pointer, i5, (String) map.get(Library.OPTION_STRING_ENCODING));
        }

        public Pointer getPointer() {
            return this.function;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (Library.Handler.OBJECT_TOSTRING.equals(method)) {
                return ("Proxy interface to " + this.function) + " (" + CallbackReference.findCallbackClass(((Method) this.options.get("invoking-method")).getDeclaringClass()).getName() + ")";
            }
            if (Library.Handler.OBJECT_HASHCODE.equals(method)) {
                return Integer.valueOf(hashCode());
            }
            if (!Library.Handler.OBJECT_EQUALS.equals(method)) {
                if (Function.isVarArgs(method)) {
                    objArr = Function.concatenateVarArgs(objArr);
                }
                return this.function.invoke(method.getReturnType(), objArr, this.options);
            }
            Object obj2 = objArr[0];
            if (obj2 == null || !Proxy.isProxyClass(obj2.getClass())) {
                return Boolean.FALSE;
            }
            return Function.valueOf(Proxy.getInvocationHandler(obj2) == this);
        }
    }

    static {
        try {
            PROXY_CALLBACK_METHOD = CallbackProxy.class.getMethod(Callback.METHOD_NAME, Object[].class);
            if (Platform.isWindows()) {
                try {
                    DLL_CALLBACK_CLASS = DLLCallback.class;
                } catch (ClassNotFoundException e5) {
                    throw new Error("Error loading DLLCallback class", e5);
                }
            } else {
                DLL_CALLBACK_CLASS = null;
            }
            initializers = new WeakHashMap();
        } catch (Exception unused) {
            throw new Error("Error looking up CallbackProxy.callback() method");
        }
    }

    private CallbackReference(Callback callback, int i5, boolean z5) {
        super(callback);
        long createNativeCallback;
        Class<?> cls;
        TypeMapper typeMapper = Native.getTypeMapper(callback.getClass());
        this.callingConvention = i5;
        boolean isPPC = Platform.isPPC();
        int i6 = 0;
        if (z5) {
            Method callbackMethod = getCallbackMethod(callback);
            Class<?>[] parameterTypes = callbackMethod.getParameterTypes();
            for (int i7 = 0; i7 < parameterTypes.length; i7++) {
                if ((isPPC && ((cls = parameterTypes[i7]) == Float.TYPE || cls == Double.TYPE)) || (typeMapper != null && typeMapper.getFromNativeConverter(parameterTypes[i7]) != null)) {
                    z5 = false;
                    break;
                }
            }
            if (typeMapper != null && typeMapper.getToNativeConverter(callbackMethod.getReturnType()) != null) {
                z5 = false;
            }
        }
        String stringEncoding = Native.getStringEncoding(callback.getClass());
        if (z5) {
            Method callbackMethod2 = getCallbackMethod(callback);
            this.method = callbackMethod2;
            Class<?>[] parameterTypes2 = callbackMethod2.getParameterTypes();
            Class<?> returnType = this.method.getReturnType();
            Class<?> cls2 = DLL_CALLBACK_CLASS;
            createNativeCallback = Native.createNativeCallback(callback, this.method, parameterTypes2, returnType, i5, (cls2 == null || !cls2.isInstance(callback)) ? 1 : 3, stringEncoding);
        } else {
            if (callback instanceof CallbackProxy) {
                this.proxy = (CallbackProxy) callback;
            } else {
                this.proxy = new DefaultCallbackProxy(getCallbackMethod(callback), typeMapper, stringEncoding);
            }
            Class<?>[] parameterTypes3 = this.proxy.getParameterTypes();
            Class<?> returnType2 = this.proxy.getReturnType();
            if (typeMapper != null) {
                for (int i8 = 0; i8 < parameterTypes3.length; i8++) {
                    FromNativeConverter fromNativeConverter = typeMapper.getFromNativeConverter(parameterTypes3[i8]);
                    if (fromNativeConverter != null) {
                        parameterTypes3[i8] = fromNativeConverter.nativeType();
                    }
                }
                ToNativeConverter toNativeConverter = typeMapper.getToNativeConverter(returnType2);
                if (toNativeConverter != null) {
                    returnType2 = toNativeConverter.nativeType();
                }
            }
            for (int i9 = 0; i9 < parameterTypes3.length; i9++) {
                Class<?> nativeType = getNativeType(parameterTypes3[i9]);
                parameterTypes3[i9] = nativeType;
                if (!isAllowableNativeType(nativeType)) {
                    throw new IllegalArgumentException("Callback argument " + parameterTypes3[i9] + " requires custom type conversion");
                }
            }
            Class<?> nativeType2 = getNativeType(returnType2);
            if (!isAllowableNativeType(nativeType2)) {
                throw new IllegalArgumentException("Callback return type " + nativeType2 + " requires custom type conversion");
            }
            Class<?> cls3 = DLL_CALLBACK_CLASS;
            if (cls3 != null && cls3.isInstance(callback)) {
                i6 = 2;
            }
            createNativeCallback = Native.createNativeCallback(this.proxy, PROXY_CALLBACK_METHOD, parameterTypes3, nativeType2, i5, i6, stringEncoding);
        }
        this.cbstruct = createNativeCallback != 0 ? new Pointer(createNativeCallback) : null;
        if (createNativeCallback != 0) {
            allocatedMemory.put(Long.valueOf(createNativeCallback), new WeakReference(this));
            this.cleanable = Cleaner.getCleaner().register(this, new CallbackReferenceDisposer(this.cbstruct));
        }
    }

    private static Reference<Callback>[] addCallbackToArray(Callback callback, Reference<Callback>[] referenceArr) {
        int i5 = 0;
        int i6 = 1;
        if (referenceArr != null) {
            for (int i7 = 0; i7 < referenceArr.length; i7++) {
                if (referenceArr[i7].get() == null) {
                    referenceArr[i7] = null;
                } else {
                    i6++;
                }
            }
        }
        Reference<Callback>[] referenceArr2 = new Reference[i6];
        if (referenceArr != null) {
            int i8 = 0;
            while (i5 < referenceArr.length) {
                Reference<Callback> reference = referenceArr[i5];
                if (reference != null) {
                    referenceArr2[i8] = reference;
                    i8++;
                }
                i5++;
            }
            i5 = i8;
        }
        referenceArr2[i5] = new WeakReference(callback);
        return referenceArr2;
    }

    private static Method checkMethod(Method method) {
        if (method.getParameterTypes().length <= 256) {
            return method;
        }
        throw new UnsupportedOperationException("Method signature exceeds the maximum parameter count: " + method);
    }

    private static Callback createCallback(Class<?> cls, Pointer pointer) {
        int i5 = AltCallingConvention.class.isAssignableFrom(cls) ? 63 : 0;
        HashMap hashMap = new HashMap(Native.getLibraryOptions(cls));
        hashMap.put("invoking-method", getCallbackMethod(cls));
        return (Callback) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new NativeFunctionHandler(pointer, i5, hashMap));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void disposeAll() {
        Iterator it = new LinkedList(allocatedMemory.values()).iterator();
        while (it.hasNext()) {
            CallbackReference callbackReference = (CallbackReference) ((Reference) it.next()).get();
            if (callbackReference != null) {
                callbackReference.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> findCallbackClass(Class<?> cls) {
        if (!Callback.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException(cls.getName() + " is not derived from com.sun.jna.Callback");
        }
        if (!cls.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int i5 = 0;
            while (true) {
                if (i5 >= interfaces.length) {
                    break;
                }
                if (Callback.class.isAssignableFrom(interfaces[i5])) {
                    try {
                        getCallbackMethod(interfaces[i5]);
                        return interfaces[i5];
                    } catch (IllegalArgumentException unused) {
                        return Callback.class.isAssignableFrom(cls.getSuperclass()) ? findCallbackClass(cls.getSuperclass()) : cls;
                    }
                }
                i5++;
            }
        } else {
            return cls;
        }
    }

    public static Callback getCallback(Class<?> cls, Pointer pointer) {
        return getCallback(cls, pointer, false);
    }

    private static Method getCallbackMethod(Callback callback) {
        return getCallbackMethod(findCallbackClass(callback.getClass()));
    }

    public static Pointer getFunctionPointer(Callback callback) {
        return getFunctionPointer(callback, false);
    }

    private static Pointer getNativeFunctionPointer(Callback callback) {
        if (!Proxy.isProxyClass(callback.getClass())) {
            return null;
        }
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(callback);
        if (invocationHandler instanceof NativeFunctionHandler) {
            return ((NativeFunctionHandler) invocationHandler).getPointer();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Pointer getNativeString(Object obj, boolean z5) {
        if (obj == null) {
            return null;
        }
        NativeString nativeString = new NativeString(obj.toString(), z5);
        allocations.put(obj, nativeString);
        return nativeString.getPointer();
    }

    private Class<?> getNativeType(Class<?> cls) {
        if (Structure.class.isAssignableFrom(cls)) {
            Structure.validate(cls);
            if (!Structure.ByValue.class.isAssignableFrom(cls)) {
                return Pointer.class;
            }
        } else {
            if (NativeMapped.class.isAssignableFrom(cls)) {
                return NativeMappedConverter.getInstance(cls).nativeType();
            }
            if (cls == String.class || cls == WString.class || cls == String[].class || cls == WString[].class || Callback.class.isAssignableFrom(cls)) {
                return Pointer.class;
            }
        }
        return cls;
    }

    private static Callback getTypeAssignableCallback(Class<?> cls, Reference<Callback>[] referenceArr) {
        if (referenceArr == null) {
            return null;
        }
        for (Reference<Callback> reference : referenceArr) {
            Callback callback = reference.get();
            if (callback != null && cls.isAssignableFrom(callback.getClass())) {
                return callback;
            }
        }
        return null;
    }

    private static ThreadGroup initializeThread(Callback callback, AttachOptions attachOptions) {
        CallbackThreadInitializer callbackThreadInitializer;
        if (callback instanceof DefaultCallbackProxy) {
            callback = ((DefaultCallbackProxy) callback).getCallback();
        }
        Map<Callback, CallbackThreadInitializer> map = initializers;
        synchronized (map) {
            callbackThreadInitializer = map.get(callback);
        }
        if (callbackThreadInitializer == null) {
            return null;
        }
        ThreadGroup threadGroup = callbackThreadInitializer.getThreadGroup(callback);
        attachOptions.name = callbackThreadInitializer.getName(callback);
        attachOptions.daemon = callbackThreadInitializer.isDaemon(callback);
        attachOptions.detach = callbackThreadInitializer.detach(callback);
        attachOptions.write();
        return threadGroup;
    }

    private static boolean isAllowableNativeType(Class<?> cls) {
        return cls == Void.TYPE || cls == Void.class || cls == Boolean.TYPE || cls == Boolean.class || cls == Byte.TYPE || cls == Byte.class || cls == Short.TYPE || cls == Short.class || cls == Character.TYPE || cls == Character.class || cls == Integer.TYPE || cls == Integer.class || cls == Long.TYPE || cls == Long.class || cls == Float.TYPE || cls == Float.class || cls == Double.TYPE || cls == Double.class || (Structure.ByValue.class.isAssignableFrom(cls) && Structure.class.isAssignableFrom(cls)) || Pointer.class.isAssignableFrom(cls);
    }

    private void setCallbackOptions(int i5) {
        this.cbstruct.setInt(Native.POINTER_SIZE, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CallbackThreadInitializer setCallbackThreadInitializer(Callback callback, CallbackThreadInitializer callbackThreadInitializer) {
        Map<Callback, CallbackThreadInitializer> map = initializers;
        synchronized (map) {
            try {
                if (callbackThreadInitializer != null) {
                    return map.put(callback, callbackThreadInitializer);
                }
                return map.remove(callback);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Cleaner.Cleanable cleanable = this.cleanable;
        if (cleanable != null) {
            cleanable.clean();
        }
        this.cbstruct = null;
    }

    @Deprecated
    protected void dispose() {
        close();
    }

    public Pointer getTrampoline() {
        if (this.trampoline == null) {
            this.trampoline = this.cbstruct.getPointer(0L);
        }
        return this.trampoline;
    }

    private static Callback getCallback(Class<?> cls, Pointer pointer, boolean z5) {
        if (pointer == null) {
            return null;
        }
        if (cls.isInterface()) {
            Map<Callback, CallbackReference> map = z5 ? directCallbackMap : callbackMap;
            Map<Pointer, Reference<Callback>[]> map2 = pointerCallbackMap;
            synchronized (map2) {
                try {
                    Reference<Callback>[] referenceArr = map2.get(pointer);
                    Callback typeAssignableCallback = getTypeAssignableCallback(cls, referenceArr);
                    if (typeAssignableCallback != null) {
                        return typeAssignableCallback;
                    }
                    Callback createCallback = createCallback(cls, pointer);
                    map2.put(pointer, addCallbackToArray(createCallback, referenceArr));
                    map.remove(createCallback);
                    return createCallback;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        throw new IllegalArgumentException("Callback type must be an interface");
    }

    private static Method getCallbackMethod(Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        Method[] methods = cls.getMethods();
        HashSet hashSet = new HashSet(Arrays.asList(declaredMethods));
        hashSet.retainAll(Arrays.asList(methods));
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (Callback.FORBIDDEN_NAMES.contains(((Method) it.next()).getName())) {
                it.remove();
            }
        }
        Method[] methodArr = (Method[]) hashSet.toArray(new Method[0]);
        if (methodArr.length == 1) {
            return checkMethod(methodArr[0]);
        }
        for (Method method : methodArr) {
            if (Callback.METHOD_NAME.equals(method.getName())) {
                return checkMethod(method);
            }
        }
        throw new IllegalArgumentException("Callback must implement a single public method, or one public method named 'callback'");
    }

    private static Pointer getFunctionPointer(Callback callback, boolean z5) {
        int intValue;
        Pointer trampoline;
        if (callback == null) {
            return null;
        }
        Pointer nativeFunctionPointer = getNativeFunctionPointer(callback);
        if (nativeFunctionPointer != null) {
            return nativeFunctionPointer;
        }
        Map<String, Object> libraryOptions = Native.getLibraryOptions(callback.getClass());
        if (callback instanceof AltCallingConvention) {
            intValue = 63;
        } else {
            intValue = (libraryOptions == null || !libraryOptions.containsKey(Library.OPTION_CALLING_CONVENTION)) ? 0 : ((Integer) libraryOptions.get(Library.OPTION_CALLING_CONVENTION)).intValue();
        }
        Map<Callback, CallbackReference> map = z5 ? directCallbackMap : callbackMap;
        Map<Pointer, Reference<Callback>[]> map2 = pointerCallbackMap;
        synchronized (map2) {
            try {
                CallbackReference callbackReference = map.get(callback);
                if (callbackReference == null) {
                    callbackReference = new CallbackReference(callback, intValue, z5);
                    map.put(callback, callbackReference);
                    map2.put(callbackReference.getTrampoline(), addCallbackToArray(callback, null));
                    if (initializers.containsKey(callback)) {
                        callbackReference.setCallbackOptions(1);
                    }
                }
                trampoline = callbackReference.getTrampoline();
            } catch (Throwable th) {
                throw th;
            }
        }
        return trampoline;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Callback getCallback() {
        return get();
    }
}
