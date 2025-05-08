package kotlinx.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.CachingKt;
import kotlinx.serialization.internal.ParametrizedSerializerCache;
import kotlinx.serialization.internal.SerializerCache;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a/\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aC\u0010\f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00050\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\f\u0010\r\"\"\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000e8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0011\u0010\u0012\"\"\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u0012\u0004\b\u0014\u0010\u0012\"\"\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00158\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u0018\u0010\u0012\"\"\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00158\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u0012\u0004\b\u001a\u0010\u0012¨\u0006\u001b"}, d2 = {"Lkotlin/reflect/KClass;", BuildConfig.FLAVOR, "clazz", BuildConfig.FLAVOR, "isNullable", "Lkotlinx/serialization/KSerializer;", "findCachedSerializer", "(Lkotlin/reflect/KClass;Z)Lkotlinx/serialization/KSerializer;", BuildConfig.FLAVOR, "Lkotlin/reflect/KType;", "types", "Lkotlin/Result;", "findParametrizedCachedSerializer", "(Lkotlin/reflect/KClass;Ljava/util/List;Z)Ljava/lang/Object;", "Lkotlinx/serialization/internal/SerializerCache;", "SERIALIZERS_CACHE", "Lkotlinx/serialization/internal/SerializerCache;", "getSERIALIZERS_CACHE$annotations", "()V", "SERIALIZERS_CACHE_NULLABLE", "getSERIALIZERS_CACHE_NULLABLE$annotations", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "PARAMETRIZED_SERIALIZERS_CACHE", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "getPARAMETRIZED_SERIALIZERS_CACHE$annotations", "PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE", "getPARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$annotations", "kotlinx-serialization-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SerializersCacheKt {
    private static final SerializerCache<? extends Object> SERIALIZERS_CACHE = CachingKt.createCache(new Function1<KClass<?>, KSerializer<? extends Object>>() { // from class: kotlinx.serialization.SerializersCacheKt$SERIALIZERS_CACHE$1
        @Override // kotlin.jvm.functions.Function1
        public final KSerializer<? extends Object> invoke(KClass<?> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return SerializersKt.serializerOrNull(it);
        }
    });
    private static final SerializerCache<Object> SERIALIZERS_CACHE_NULLABLE = CachingKt.createCache(new Function1<KClass<?>, KSerializer<Object>>() { // from class: kotlinx.serialization.SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1
        @Override // kotlin.jvm.functions.Function1
        public final KSerializer<Object> invoke(KClass<?> it) {
            KSerializer<Object> nullable;
            Intrinsics.checkNotNullParameter(it, "it");
            KSerializer serializerOrNull = SerializersKt.serializerOrNull(it);
            if (serializerOrNull == null || (nullable = BuiltinSerializersKt.getNullable(serializerOrNull)) == null) {
                return null;
            }
            return nullable;
        }
    });
    private static final ParametrizedSerializerCache<? extends Object> PARAMETRIZED_SERIALIZERS_CACHE = CachingKt.createParametrizedCache(new Function2<KClass<Object>, List<? extends KType>, KSerializer<? extends Object>>() { // from class: kotlinx.serialization.SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1
        @Override // kotlin.jvm.functions.Function2
        public final KSerializer<? extends Object> invoke(KClass<Object> clazz, final List<? extends KType> types) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(types, "types");
            List<KSerializer<Object>> serializersForParameters = SerializersKt.serializersForParameters(SerializersModuleBuildersKt.EmptySerializersModule(), types, true);
            Intrinsics.checkNotNull(serializersForParameters);
            return SerializersKt.parametrizedSerializerOrNull(clazz, serializersForParameters, new Function0<KClassifier>() { // from class: kotlinx.serialization.SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final KClassifier invoke() {
                    return types.get(0).getClassifier();
                }
            });
        }
    });
    private static final ParametrizedSerializerCache<Object> PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE = CachingKt.createParametrizedCache(new Function2<KClass<Object>, List<? extends KType>, KSerializer<Object>>() { // from class: kotlinx.serialization.SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1
        @Override // kotlin.jvm.functions.Function2
        public final KSerializer<Object> invoke(KClass<Object> clazz, final List<? extends KType> types) {
            KSerializer<Object> nullable;
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(types, "types");
            List<KSerializer<Object>> serializersForParameters = SerializersKt.serializersForParameters(SerializersModuleBuildersKt.EmptySerializersModule(), types, true);
            Intrinsics.checkNotNull(serializersForParameters);
            KSerializer<? extends Object> parametrizedSerializerOrNull = SerializersKt.parametrizedSerializerOrNull(clazz, serializersForParameters, new Function0<KClassifier>() { // from class: kotlinx.serialization.SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final KClassifier invoke() {
                    return types.get(0).getClassifier();
                }
            });
            if (parametrizedSerializerOrNull == null || (nullable = BuiltinSerializersKt.getNullable(parametrizedSerializerOrNull)) == null) {
                return null;
            }
            return nullable;
        }
    });

    public static final KSerializer<Object> findCachedSerializer(KClass<Object> clazz, boolean z5) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (z5) {
            return SERIALIZERS_CACHE_NULLABLE.get(clazz);
        }
        KSerializer<? extends Object> kSerializer = SERIALIZERS_CACHE.get(clazz);
        if (kSerializer != null) {
            return kSerializer;
        }
        return null;
    }

    public static final Object findParametrizedCachedSerializer(KClass<Object> clazz, List<? extends KType> types, boolean z5) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(types, "types");
        return !z5 ? PARAMETRIZED_SERIALIZERS_CACHE.mo3793getgIAlus(clazz, types) : PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE.mo3793getgIAlus(clazz, types);
    }
}
