package kotlin.reflect.jvm.internal.impl.storage;

import androidx.appcompat.R$styleable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

/* loaded from: classes3.dex */
public class LockBasedStorageManager implements StorageManager {
    private final String debugText;
    private final ExceptionHandlingStrategy exceptionHandlingStrategy;
    protected final SimpleLock lock;
    private static final String PACKAGE_NAME = StringsKt.substringBeforeLast(LockBasedStorageManager.class.getCanonicalName(), ".", BuildConfig.FLAVOR);
    public static final StorageManager NO_LOCKS = new LockBasedStorageManager("NO_LOCKS", ExceptionHandlingStrategy.THROW, EmptySimpleLock.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.1
        private static /* synthetic */ void $$$reportNull$$$0(int i5) {
            String str = i5 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i5 != 1 ? 3 : 2];
            if (i5 != 1) {
                objArr[0] = "source";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            }
            if (i5 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            } else {
                objArr[1] = "recursionDetectedDefault";
            }
            if (i5 != 1) {
                objArr[2] = "recursionDetectedDefault";
            }
            String format = String.format(str, objArr);
            if (i5 == 1) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager
        protected <K, V> RecursionDetectedResult<V> recursionDetectedDefault(String str, K k5) {
            if (str == null) {
                $$$reportNull$$$0(0);
            }
            RecursionDetectedResult<V> fallThrough = RecursionDetectedResult.fallThrough();
            if (fallThrough == null) {
                $$$reportNull$$$0(1);
            }
            return fallThrough;
        }
    };

    /* loaded from: classes3.dex */
    private static class CacheWithNotNullValuesBasedOnMemoizedFunction<K, V> extends CacheWithNullableValuesBasedOnMemoizedFunction<K, V> implements CacheWithNotNullValues<K, V> {
        private static /* synthetic */ void $$$reportNull$$$0(int i5) {
            String str = i5 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i5 != 3 ? 3 : 2];
            if (i5 == 1) {
                objArr[0] = "map";
            } else if (i5 == 2) {
                objArr[0] = "computation";
            } else if (i5 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i5 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i5 == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i5 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i5 == 3) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction, kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues
        public V computeIfAbsent(K k5, Function0<? extends V> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(2);
            }
            V v5 = (V) super.computeIfAbsent(k5, function0);
            if (v5 == null) {
                $$$reportNull$$$0(3);
            }
            return v5;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private CacheWithNotNullValuesBasedOnMemoizedFunction(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<KeyWithComputation<K, V>, Object> concurrentMap) {
            super(concurrentMap);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class CacheWithNullableValuesBasedOnMemoizedFunction<K, V> extends MapBasedMemoizedFunction<KeyWithComputation<K, V>, V> implements CacheWithNullableValues<K, V> {
        private static /* synthetic */ void $$$reportNull$$$0(int i5) {
            Object[] objArr = new Object[3];
            if (i5 == 1) {
                objArr[0] = "map";
            } else if (i5 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i5 != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public V computeIfAbsent(K k5, Function0<? extends V> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(2);
            }
            return invoke(new KeyWithComputation(k5, function0));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private CacheWithNullableValuesBasedOnMemoizedFunction(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<KeyWithComputation<K, V>, Object> concurrentMap) {
            super(lockBasedStorageManager, concurrentMap, new Function1<KeyWithComputation<K, V>, V>() { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction.1
                @Override // kotlin.jvm.functions.Function1
                public V invoke(KeyWithComputation<K, V> keyWithComputation) {
                    return (V) ((KeyWithComputation) keyWithComputation).computation.invoke();
                }
            });
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy THROW = new ExceptionHandlingStrategy() { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy.1
            private static /* synthetic */ void $$$reportNull$$$0(int i5) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy
            public RuntimeException handleException(Throwable th) {
                if (th == null) {
                    $$$reportNull$$$0(0);
                }
                throw ExceptionUtilsKt.rethrow(th);
            }
        };

        RuntimeException handleException(Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class KeyWithComputation<K, V> {
        private final Function0<? extends V> computation;
        private final K key;

        public KeyWithComputation(K k5, Function0<? extends V> function0) {
            this.key = k5;
            this.computation = function0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.key.equals(((KeyWithComputation) obj).key);
        }

        public int hashCode() {
            return this.key.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class LockBasedLazyValue<T> implements NullableLazyValue<T> {
        private final Function0<? extends T> computable;
        private final LockBasedStorageManager storageManager;
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int i5) {
            String str = (i5 == 2 || i5 == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i5 == 2 || i5 == 3) ? 2 : 3];
            if (i5 == 1) {
                objArr[0] = "computable";
            } else if (i5 == 2 || i5 == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i5 == 2) {
                objArr[1] = "recursionDetected";
            } else if (i5 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i5 != 2 && i5 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i5 != 2 && i5 != 3) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        public LockBasedLazyValue(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
            this.value = NotValue.NOT_COMPUTED;
            this.storageManager = lockBasedStorageManager;
            this.computable = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public T invoke() {
            T invoke;
            Object obj = this.value;
            if (!(obj instanceof NotValue)) {
                return (T) WrappedValues.unescapeThrowable(obj);
            }
            this.storageManager.lock.lock();
            try {
                Object obj2 = this.value;
                if (obj2 instanceof NotValue) {
                    NotValue notValue = NotValue.COMPUTING;
                    if (obj2 == notValue) {
                        this.value = NotValue.RECURSION_WAS_DETECTED;
                        RecursionDetectedResult<T> recursionDetected = recursionDetected(true);
                        if (!recursionDetected.isFallThrough()) {
                            invoke = recursionDetected.getValue();
                        }
                    }
                    if (obj2 == NotValue.RECURSION_WAS_DETECTED) {
                        RecursionDetectedResult<T> recursionDetected2 = recursionDetected(false);
                        if (!recursionDetected2.isFallThrough()) {
                            invoke = recursionDetected2.getValue();
                        }
                    }
                    this.value = notValue;
                    try {
                        invoke = this.computable.invoke();
                        postCompute(invoke);
                        this.value = invoke;
                    } catch (Throwable th) {
                        if (ExceptionUtilsKt.isProcessCanceledException(th)) {
                            this.value = NotValue.NOT_COMPUTED;
                            throw th;
                        }
                        if (this.value == NotValue.COMPUTING) {
                            this.value = WrappedValues.escapeThrowable(th);
                        }
                        throw this.storageManager.exceptionHandlingStrategy.handleException(th);
                    }
                } else {
                    invoke = (T) WrappedValues.unescapeThrowable(obj2);
                }
                return invoke;
            } finally {
                this.storageManager.lock.unlock();
            }
        }

        public boolean isComputed() {
            return (this.value == NotValue.NOT_COMPUTED || this.value == NotValue.COMPUTING) ? false : true;
        }

        protected void postCompute(T t5) {
        }

        protected RecursionDetectedResult<T> recursionDetected(boolean z5) {
            RecursionDetectedResult<T> recursionDetectedDefault = this.storageManager.recursionDetectedDefault("in a lazy value", null);
            if (recursionDetectedDefault == null) {
                $$$reportNull$$$0(2);
            }
            return recursionDetectedDefault;
        }
    }

    /* loaded from: classes3.dex */
    private static abstract class LockBasedLazyValueWithPostCompute<T> extends LockBasedLazyValue<T> {
        private volatile SingleThreadValue<T> valuePostCompute;

        private static /* synthetic */ void $$$reportNull$$$0(int i5) {
            Object[] objArr = new Object[3];
            if (i5 != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedLazyValueWithPostCompute(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
            this.valuePostCompute = null;
        }

        protected abstract void doPostCompute(T t5);

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            SingleThreadValue<T> singleThreadValue = this.valuePostCompute;
            return (singleThreadValue == null || !singleThreadValue.hasValue()) ? (T) super.invoke() : singleThreadValue.getValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
        protected final void postCompute(T t5) {
            this.valuePostCompute = new SingleThreadValue<>(t5);
            try {
                doPostCompute(t5);
            } finally {
                this.valuePostCompute = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class LockBasedNotNullLazyValue<T> extends LockBasedLazyValue<T> implements NotNullLazyValue<T> {
        private static /* synthetic */ void $$$reportNull$$$0(int i5) {
            String str = i5 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i5 != 2 ? 3 : 2];
            if (i5 == 1) {
                objArr[0] = "computable";
            } else if (i5 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i5 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i5 != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i5 == 2) {
                throw new IllegalStateException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedNotNullLazyValue(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            T t5 = (T) super.invoke();
            if (t5 == null) {
                $$$reportNull$$$0(2);
            }
            return t5;
        }
    }

    /* loaded from: classes3.dex */
    private static abstract class LockBasedNotNullLazyValueWithPostCompute<T> extends LockBasedLazyValueWithPostCompute<T> implements NotNullLazyValue<T> {
        private static /* synthetic */ void $$$reportNull$$$0(int i5) {
            String str = i5 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i5 != 2 ? 3 : 2];
            if (i5 == 1) {
                objArr[0] = "computable";
            } else if (i5 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i5 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i5 != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i5 == 2) {
                throw new IllegalStateException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedNotNullLazyValueWithPostCompute(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (function0 == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            T t5 = (T) super.invoke();
            if (t5 == null) {
                $$$reportNull$$$0(2);
            }
            return t5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNullable<K, V> {
        private final ConcurrentMap<K, Object> cache;
        private final Function1<? super K, ? extends V> compute;
        private final LockBasedStorageManager storageManager;

        private static /* synthetic */ void $$$reportNull$$$0(int i5) {
            String str = (i5 == 3 || i5 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i5 == 3 || i5 == 4) ? 2 : 3];
            if (i5 == 1) {
                objArr[0] = "map";
            } else if (i5 == 2) {
                objArr[0] = "compute";
            } else if (i5 == 3 || i5 == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i5 == 3) {
                objArr[1] = "recursionDetected";
            } else if (i5 != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i5 != 3 && i5 != 4) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i5 != 3 && i5 != 4) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        public MapBasedMemoizedFunction(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
            if (function1 == null) {
                $$$reportNull$$$0(2);
            }
            this.storageManager = lockBasedStorageManager;
            this.cache = concurrentMap;
            this.compute = function1;
        }

        private AssertionError inconsistentComputingKey(K k5, Object obj) {
            return (AssertionError) LockBasedStorageManager.sanitizeStackTrace(new AssertionError("Inconsistent key detected. " + NotValue.COMPUTING + " is expected, was: " + obj + ", most probably race condition detected on input " + k5 + " under " + this.storageManager));
        }

        private AssertionError raceCondition(K k5, Object obj) {
            AssertionError assertionError = (AssertionError) LockBasedStorageManager.sanitizeStackTrace(new AssertionError("Race condition detected on input " + k5 + ". Old value is " + obj + " under " + this.storageManager));
            if (assertionError == null) {
                $$$reportNull$$$0(4);
            }
            return assertionError;
        }

        private AssertionError unableToRemoveKey(K k5, Throwable th) {
            return (AssertionError) LockBasedStorageManager.sanitizeStackTrace(new AssertionError("Unable to remove " + k5 + " under " + this.storageManager, th));
        }

        @Override // kotlin.jvm.functions.Function1
        public V invoke(K k5) {
            AssertionError unableToRemoveKey;
            AssertionError unableToRemoveKey2;
            V v5;
            Object obj = this.cache.get(k5);
            if (obj != null && obj != NotValue.COMPUTING) {
                return (V) WrappedValues.unescapeExceptionOrNull(obj);
            }
            this.storageManager.lock.lock();
            try {
                Object obj2 = this.cache.get(k5);
                NotValue notValue = NotValue.COMPUTING;
                if (obj2 == notValue) {
                    obj2 = NotValue.RECURSION_WAS_DETECTED;
                    RecursionDetectedResult<V> recursionDetected = recursionDetected(k5, true);
                    if (!recursionDetected.isFallThrough()) {
                        v5 = recursionDetected.getValue();
                        return v5;
                    }
                }
                if (obj2 == NotValue.RECURSION_WAS_DETECTED) {
                    RecursionDetectedResult<V> recursionDetected2 = recursionDetected(k5, false);
                    if (!recursionDetected2.isFallThrough()) {
                        v5 = recursionDetected2.getValue();
                        return v5;
                    }
                }
                if (obj2 != null) {
                    v5 = (V) WrappedValues.unescapeExceptionOrNull(obj2);
                    return v5;
                }
                AssertionError assertionError = null;
                try {
                    this.cache.put(k5, notValue);
                    V invoke = this.compute.invoke(k5);
                    Object put = this.cache.put(k5, WrappedValues.escapeNull(invoke));
                    if (put == notValue) {
                        return invoke;
                    }
                    assertionError = raceCondition(k5, put);
                    throw assertionError;
                } catch (Throwable th) {
                    if (ExceptionUtilsKt.isProcessCanceledException(th)) {
                        try {
                            Object remove = this.cache.remove(k5);
                            if (remove != NotValue.COMPUTING) {
                                throw inconsistentComputingKey(k5, remove);
                            }
                            throw th;
                        } finally {
                        }
                    }
                    if (th == assertionError) {
                        try {
                            this.cache.remove(k5);
                            throw this.storageManager.exceptionHandlingStrategy.handleException(th);
                        } finally {
                        }
                    }
                    Object put2 = this.cache.put(k5, WrappedValues.escapeThrowable(th));
                    if (put2 != NotValue.COMPUTING) {
                        throw raceCondition(k5, put2);
                    }
                    throw this.storageManager.exceptionHandlingStrategy.handleException(th);
                }
            } finally {
                this.storageManager.lock.unlock();
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable
        public boolean isComputed(K k5) {
            Object obj = this.cache.get(k5);
            return (obj == null || obj == NotValue.COMPUTING) ? false : true;
        }

        protected RecursionDetectedResult<V> recursionDetected(K k5, boolean z5) {
            RecursionDetectedResult<V> recursionDetectedDefault = this.storageManager.recursionDetectedDefault(BuildConfig.FLAVOR, k5);
            if (recursionDetectedDefault == null) {
                $$$reportNull$$$0(3);
            }
            return recursionDetectedDefault;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class MapBasedMemoizedFunctionToNotNull<K, V> extends MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNotNull<K, V> {
        private static /* synthetic */ void $$$reportNull$$$0(int i5) {
            String str = i5 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i5 != 3 ? 3 : 2];
            if (i5 == 1) {
                objArr[0] = "map";
            } else if (i5 == 2) {
                objArr[0] = "compute";
            } else if (i5 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i5 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i5 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i5 == 3) {
                throw new IllegalStateException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MapBasedMemoizedFunctionToNotNull(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
            super(lockBasedStorageManager, concurrentMap, function1);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
            if (function1 == null) {
                $$$reportNull$$$0(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunction, kotlin.jvm.functions.Function1
        public V invoke(K k5) {
            V v5 = (V) super.invoke(k5);
            if (v5 == null) {
                $$$reportNull$$$0(3);
            }
            return v5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum NotValue {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class RecursionDetectedResult<T> {
        private final boolean fallThrough;
        private final T value;

        private RecursionDetectedResult(T t5, boolean z5) {
            this.value = t5;
            this.fallThrough = z5;
        }

        public static <T> RecursionDetectedResult<T> fallThrough() {
            return new RecursionDetectedResult<>(null, true);
        }

        public static <T> RecursionDetectedResult<T> value(T t5) {
            return new RecursionDetectedResult<>(t5, false);
        }

        public T getValue() {
            return this.value;
        }

        public boolean isFallThrough() {
            return this.fallThrough;
        }

        public String toString() {
            return isFallThrough() ? "FALL_THROUGH" : String.valueOf(this.value);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i5) {
        String format;
        String str = (i5 == 10 || i5 == 13 || i5 == 20 || i5 == 37) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i5 == 10 || i5 == 13 || i5 == 20 || i5 == 37) ? 2 : 3];
        if (i5 != 1 && i5 != 3 && i5 != 5) {
            if (i5 != 6) {
                switch (i5) {
                    case 8:
                        break;
                    case 9:
                    case 11:
                    case 14:
                    case 16:
                    case 19:
                    case 21:
                        objArr[0] = "compute";
                        break;
                    case 10:
                    case 13:
                    case 20:
                    case 37:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                        break;
                    case 12:
                    case 17:
                    case 25:
                    case 27:
                        objArr[0] = "onRecursiveCall";
                        break;
                    case 15:
                    case 18:
                    case 22:
                        objArr[0] = "map";
                        break;
                    case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                    case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                    case 26:
                    case 28:
                    case 30:
                    case 31:
                    case 32:
                    case 34:
                        objArr[0] = "computable";
                        break;
                    case R$styleable.Toolbar_titleTextColor /* 29 */:
                    case 33:
                        objArr[0] = "postCompute";
                        break;
                    case 35:
                        objArr[0] = "source";
                        break;
                    case 36:
                        objArr[0] = "throwable";
                        break;
                    default:
                        objArr[0] = "debugText";
                        break;
                }
            } else {
                objArr[0] = "lock";
            }
            if (i5 != 10 || i5 == 13) {
                objArr[1] = "createMemoizedFunction";
            } else if (i5 == 20) {
                objArr[1] = "createMemoizedFunctionWithNullableValues";
            } else if (i5 != 37) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
            } else {
                objArr[1] = "sanitizeStackTrace";
            }
            switch (i5) {
                case 4:
                case 5:
                case 6:
                    objArr[2] = "<init>";
                    break;
                case 7:
                case 8:
                    objArr[2] = "replaceExceptionHandling";
                    break;
                case 9:
                case 11:
                case 12:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                    objArr[2] = "createMemoizedFunction";
                    break;
                case 10:
                case 13:
                case 20:
                case 37:
                    break;
                case 19:
                case 21:
                case 22:
                    objArr[2] = "createMemoizedFunctionWithNullableValues";
                    break;
                case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                case 25:
                    objArr[2] = "createLazyValue";
                    break;
                case 26:
                case 27:
                    objArr[2] = "createRecursionTolerantLazyValue";
                    break;
                case 28:
                case R$styleable.Toolbar_titleTextColor /* 29 */:
                    objArr[2] = "createLazyValueWithPostCompute";
                    break;
                case 30:
                    objArr[2] = "createNullableLazyValue";
                    break;
                case 31:
                    objArr[2] = "createRecursionTolerantNullableLazyValue";
                    break;
                case 32:
                case 33:
                    objArr[2] = "createNullableLazyValueWithPostCompute";
                    break;
                case 34:
                    objArr[2] = "compute";
                    break;
                case 35:
                    objArr[2] = "recursionDetectedDefault";
                    break;
                case 36:
                    objArr[2] = "sanitizeStackTrace";
                    break;
                default:
                    objArr[2] = "createWithExceptionHandling";
                    break;
            }
            format = String.format(str, objArr);
            if (i5 == 10 && i5 != 13 && i5 != 20 && i5 != 37) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }
        objArr[0] = "exceptionHandlingStrategy";
        if (i5 != 10) {
        }
        objArr[1] = "createMemoizedFunction";
        switch (i5) {
        }
        format = String.format(str, objArr);
        if (i5 == 10) {
        }
        throw new IllegalStateException(format);
    }

    private static <K> ConcurrentMap<K, Object> createConcurrentHashMap() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends Throwable> T sanitizeStackTrace(T t5) {
        if (t5 == null) {
            $$$reportNull$$$0(36);
        }
        StackTraceElement[] stackTrace = t5.getStackTrace();
        int length = stackTrace.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                i5 = -1;
                break;
            }
            if (!stackTrace[i5].getClassName().startsWith(PACKAGE_NAME)) {
                break;
            }
            i5++;
        }
        List subList = Arrays.asList(stackTrace).subList(i5, length);
        t5.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> T compute(Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(34);
        }
        this.lock.lock();
        try {
            return function0.invoke();
        } finally {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        return new CacheWithNotNullValuesBasedOnMemoizedFunction(createConcurrentHashMap());
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues() {
        return new CacheWithNullableValuesBasedOnMemoizedFunction(createConcurrentHashMap());
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createLazyValue(Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(23);
        }
        return new LockBasedNotNullLazyValue(this, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(Function0<? extends T> function0, final Function1<? super Boolean, ? extends T> function1, final Function1<? super T, Unit> function12) {
        if (function0 == null) {
            $$$reportNull$$$0(28);
        }
        if (function12 == null) {
            $$$reportNull$$$0(29);
        }
        return new LockBasedNotNullLazyValueWithPostCompute<T>(this, function0) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.5
            private static /* synthetic */ void $$$reportNull$$$0(int i5) {
                String str = i5 != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                Object[] objArr = new Object[i5 != 2 ? 2 : 3];
                if (i5 != 2) {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
                } else {
                    objArr[0] = "value";
                }
                if (i5 != 2) {
                    objArr[1] = "recursionDetected";
                } else {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
                }
                if (i5 == 2) {
                    objArr[2] = "doPostCompute";
                }
                String format = String.format(str, objArr);
                if (i5 == 2) {
                    throw new IllegalArgumentException(format);
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute
            protected void doPostCompute(T t5) {
                if (t5 == null) {
                    $$$reportNull$$$0(2);
                }
                function12.invoke(t5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
            protected RecursionDetectedResult<T> recursionDetected(boolean z5) {
                Function1 function13 = function1;
                if (function13 == null) {
                    RecursionDetectedResult<T> recursionDetected = super.recursionDetected(z5);
                    if (recursionDetected == null) {
                        $$$reportNull$$$0(0);
                    }
                    return recursionDetected;
                }
                RecursionDetectedResult<T> value = RecursionDetectedResult.value(function13.invoke(Boolean.valueOf(z5)));
                if (value == null) {
                    $$$reportNull$$$0(1);
                }
                return value;
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(9);
        }
        MemoizedFunctionToNotNull<K, V> createMemoizedFunction = createMemoizedFunction(function1, createConcurrentHashMap());
        if (createMemoizedFunction == null) {
            $$$reportNull$$$0(10);
        }
        return createMemoizedFunction;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(19);
        }
        MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues = createMemoizedFunctionWithNullableValues(function1, createConcurrentHashMap());
        if (createMemoizedFunctionWithNullableValues == null) {
            $$$reportNull$$$0(20);
        }
        return createMemoizedFunctionWithNullableValues;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NullableLazyValue<T> createNullableLazyValue(Function0<? extends T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(30);
        }
        return new LockBasedLazyValue(this, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(Function0<? extends T> function0, final T t5) {
        if (function0 == null) {
            $$$reportNull$$$0(26);
        }
        if (t5 == null) {
            $$$reportNull$$$0(27);
        }
        return new LockBasedNotNullLazyValue<T>(this, function0) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.4
            private static /* synthetic */ void $$$reportNull$$$0(int i5) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
            protected RecursionDetectedResult<T> recursionDetected(boolean z5) {
                RecursionDetectedResult<T> value = RecursionDetectedResult.value(t5);
                if (value == null) {
                    $$$reportNull$$$0(0);
                }
                return value;
            }
        };
    }

    protected <K, V> RecursionDetectedResult<V> recursionDetectedDefault(String str, K k5) {
        String str2;
        if (str == null) {
            $$$reportNull$$$0(35);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Recursion detected ");
        sb.append(str);
        if (k5 == null) {
            str2 = BuildConfig.FLAVOR;
        } else {
            str2 = "on input: " + k5;
        }
        sb.append(str2);
        sb.append(" under ");
        sb.append(this);
        throw ((AssertionError) sanitizeStackTrace(new AssertionError(sb.toString())));
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.debugText + ")";
    }

    private LockBasedStorageManager(String str, ExceptionHandlingStrategy exceptionHandlingStrategy, SimpleLock simpleLock) {
        if (str == null) {
            $$$reportNull$$$0(4);
        }
        if (exceptionHandlingStrategy == null) {
            $$$reportNull$$$0(5);
        }
        if (simpleLock == null) {
            $$$reportNull$$$0(6);
        }
        this.lock = simpleLock;
        this.exceptionHandlingStrategy = exceptionHandlingStrategy;
        this.debugText = str;
    }

    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1, ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            $$$reportNull$$$0(14);
        }
        if (concurrentMap == null) {
            $$$reportNull$$$0(15);
        }
        return new MapBasedMemoizedFunctionToNotNull(this, concurrentMap, function1);
    }

    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1, ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            $$$reportNull$$$0(21);
        }
        if (concurrentMap == null) {
            $$$reportNull$$$0(22);
        }
        return new MapBasedMemoizedFunction(this, concurrentMap, function1);
    }

    public LockBasedStorageManager(String str) {
        this(str, (Runnable) null, (Function1<InterruptedException, Unit>) null);
    }

    public LockBasedStorageManager(String str, Runnable runnable, Function1<InterruptedException, Unit> function1) {
        this(str, ExceptionHandlingStrategy.THROW, SimpleLock.Companion.simpleLock(runnable, function1));
    }
}
