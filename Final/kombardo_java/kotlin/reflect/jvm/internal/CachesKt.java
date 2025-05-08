package kotlin.reflect.jvm.internal;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.full.KClassifiers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\b\u0010\t\u001a=\u0010\u0010\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a=\u0010\u0012\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011\"*\u0010\u0015\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0014*\u0004\u0018\u00010\u00000\u00000\u00040\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016\"\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016\"\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016\"<\u0010\u001e\u001a*\u0012&\u0012$\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\r0\u001cj\u0002`\u001d\u0012\u0004\u0012\u00020\u000f0\u001b0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016*0\b\u0002\u0010\u001f\"\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\r0\u001c2\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\r0\u001c¨\u0006 "}, d2 = {BuildConfig.FLAVOR, "T", "Ljava/lang/Class;", "jClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "getOrCreateKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/jvm/internal/KClassImpl;", "Lkotlin/reflect/KDeclarationContainer;", "getOrCreateKotlinPackage", "(Ljava/lang/Class;)Lkotlin/reflect/KDeclarationContainer;", BuildConfig.FLAVOR, "Lkotlin/reflect/KTypeProjection;", "arguments", BuildConfig.FLAVOR, "isMarkedNullable", "Lkotlin/reflect/KType;", "getOrCreateKType", "(Ljava/lang/Class;Ljava/util/List;Z)Lkotlin/reflect/KType;", "getOrCreateKTypeWithTypeArguments", "Lkotlin/reflect/jvm/internal/CacheByClass;", "kotlin.jvm.PlatformType", "K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/CacheByClass;", "Lkotlin/reflect/jvm/internal/KPackageImpl;", "K_PACKAGE_CACHE", "CACHE_FOR_BASE_CLASSIFIERS", "CACHE_FOR_NULLABLE_BASE_CLASSIFIERS", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Pair;", "Lkotlin/reflect/jvm/internal/Key;", "CACHE_FOR_GENERIC_CLASSIFIERS", "Key", "kotlin-reflection"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class CachesKt {
    private static final CacheByClass<KClassImpl<? extends Object>> K_CLASS_CACHE = CacheByClassKt.createCache(new Function1() { // from class: kotlin.reflect.jvm.internal.CachesKt$$Lambda$0
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            KClassImpl K_CLASS_CACHE$lambda$0;
            K_CLASS_CACHE$lambda$0 = CachesKt.K_CLASS_CACHE$lambda$0((Class) obj);
            return K_CLASS_CACHE$lambda$0;
        }
    });
    private static final CacheByClass<KPackageImpl> K_PACKAGE_CACHE = CacheByClassKt.createCache(new Function1() { // from class: kotlin.reflect.jvm.internal.CachesKt$$Lambda$1
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            KPackageImpl K_PACKAGE_CACHE$lambda$1;
            K_PACKAGE_CACHE$lambda$1 = CachesKt.K_PACKAGE_CACHE$lambda$1((Class) obj);
            return K_PACKAGE_CACHE$lambda$1;
        }
    });
    private static final CacheByClass<KType> CACHE_FOR_BASE_CLASSIFIERS = CacheByClassKt.createCache(new Function1() { // from class: kotlin.reflect.jvm.internal.CachesKt$$Lambda$2
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            KType CACHE_FOR_BASE_CLASSIFIERS$lambda$2;
            CACHE_FOR_BASE_CLASSIFIERS$lambda$2 = CachesKt.CACHE_FOR_BASE_CLASSIFIERS$lambda$2((Class) obj);
            return CACHE_FOR_BASE_CLASSIFIERS$lambda$2;
        }
    });
    private static final CacheByClass<KType> CACHE_FOR_NULLABLE_BASE_CLASSIFIERS = CacheByClassKt.createCache(new Function1() { // from class: kotlin.reflect.jvm.internal.CachesKt$$Lambda$3
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            KType CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$lambda$3;
            CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$lambda$3 = CachesKt.CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$lambda$3((Class) obj);
            return CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$lambda$3;
        }
    });
    private static final CacheByClass<ConcurrentHashMap<Pair<List<KTypeProjection>, Boolean>, KType>> CACHE_FOR_GENERIC_CLASSIFIERS = CacheByClassKt.createCache(new Function1() { // from class: kotlin.reflect.jvm.internal.CachesKt$$Lambda$4
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            ConcurrentHashMap CACHE_FOR_GENERIC_CLASSIFIERS$lambda$4;
            CACHE_FOR_GENERIC_CLASSIFIERS$lambda$4 = CachesKt.CACHE_FOR_GENERIC_CLASSIFIERS$lambda$4((Class) obj);
            return CACHE_FOR_GENERIC_CLASSIFIERS$lambda$4;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final KType CACHE_FOR_BASE_CLASSIFIERS$lambda$2(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return KClassifiers.createType(getOrCreateKotlinClass(it), CollectionsKt.emptyList(), false, CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap CACHE_FOR_GENERIC_CLASSIFIERS$lambda$4(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KType CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$lambda$3(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return KClassifiers.createType(getOrCreateKotlinClass(it), CollectionsKt.emptyList(), true, CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KClassImpl K_CLASS_CACHE$lambda$0(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new KClassImpl(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KPackageImpl K_PACKAGE_CACHE$lambda$1(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new KPackageImpl(it);
    }

    public static final <T> KType getOrCreateKType(Class<T> jClass, List<KTypeProjection> arguments, boolean z5) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        return arguments.isEmpty() ? z5 ? CACHE_FOR_NULLABLE_BASE_CLASSIFIERS.get(jClass) : CACHE_FOR_BASE_CLASSIFIERS.get(jClass) : getOrCreateKTypeWithTypeArguments(jClass, arguments, z5);
    }

    private static final <T> KType getOrCreateKTypeWithTypeArguments(Class<T> cls, List<KTypeProjection> list, boolean z5) {
        ConcurrentHashMap<Pair<List<KTypeProjection>, Boolean>, KType> concurrentHashMap = CACHE_FOR_GENERIC_CLASSIFIERS.get(cls);
        Pair<List<KTypeProjection>, Boolean> pair = TuplesKt.to(list, Boolean.valueOf(z5));
        KType kType = concurrentHashMap.get(pair);
        if (kType == null) {
            KType createType = KClassifiers.createType(getOrCreateKotlinClass(cls), list, z5, CollectionsKt.emptyList());
            KType putIfAbsent = concurrentHashMap.putIfAbsent(pair, createType);
            kType = putIfAbsent == null ? createType : putIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(kType, "getOrPut(...)");
        return kType;
    }

    public static final <T> KClassImpl<T> getOrCreateKotlinClass(Class<T> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        KClass kClass = K_CLASS_CACHE.get(jClass);
        Intrinsics.checkNotNull(kClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T of kotlin.reflect.jvm.internal.CachesKt.getOrCreateKotlinClass>");
        return (KClassImpl) kClass;
    }

    public static final <T> KDeclarationContainer getOrCreateKotlinPackage(Class<T> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        return K_PACKAGE_CACHE.get(jClass);
    }
}
