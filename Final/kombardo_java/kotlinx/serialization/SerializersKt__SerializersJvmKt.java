package kotlinx.serialization;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.modules.SerializersModule;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0006\u001a-\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a/\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003*\u00020\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001aI\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\"\b\b\u0000\u0010\u0011*\u00020\u0004*\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0014\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a+\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0017\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u0001H\u0002¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lkotlinx/serialization/modules/SerializersModule;", "Ljava/lang/reflect/Type;", "type", "Lkotlinx/serialization/KSerializer;", BuildConfig.FLAVOR, "serializer", "(Lkotlinx/serialization/modules/SerializersModule;Ljava/lang/reflect/Type;)Lkotlinx/serialization/KSerializer;", "serializerOrNull", BuildConfig.FLAVOR, "failOnMissingTypeArgSerializer", "serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt", "(Lkotlinx/serialization/modules/SerializersModule;Ljava/lang/reflect/Type;Z)Lkotlinx/serialization/KSerializer;", "serializerByJavaTypeImpl", "Ljava/lang/Class;", "typeSerializer$SerializersKt__SerializersJvmKt", "(Lkotlinx/serialization/modules/SerializersModule;Ljava/lang/Class;Z)Lkotlinx/serialization/KSerializer;", "typeSerializer", "T", "jClass", BuildConfig.FLAVOR, "typeArgumentsSerializers", "reflectiveOrContextual$SerializersKt__SerializersJvmKt", "(Lkotlinx/serialization/modules/SerializersModule;Ljava/lang/Class;Ljava/util/List;)Lkotlinx/serialization/KSerializer;", "reflectiveOrContextual", "Ljava/lang/reflect/GenericArrayType;", "genericArraySerializer$SerializersKt__SerializersJvmKt", "(Lkotlinx/serialization/modules/SerializersModule;Ljava/lang/reflect/GenericArrayType;Z)Lkotlinx/serialization/KSerializer;", "genericArraySerializer", "prettyClass$SerializersKt__SerializersJvmKt", "(Ljava/lang/reflect/Type;)Ljava/lang/Class;", "prettyClass", "kotlinx-serialization-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/serialization/SerializersKt")
/* loaded from: classes3.dex */
public abstract /* synthetic */ class SerializersKt__SerializersJvmKt {
    private static final KSerializer<Object> genericArraySerializer$SerializersKt__SerializersJvmKt(SerializersModule serializersModule, GenericArrayType genericArrayType, boolean z5) {
        KSerializer<Object> serializerOrNull;
        KClass kClass;
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (genericComponentType instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) genericComponentType).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
            genericComponentType = (Type) ArraysKt.first(upperBounds);
        }
        Intrinsics.checkNotNull(genericComponentType);
        if (z5) {
            serializerOrNull = SerializersKt.serializer(serializersModule, genericComponentType);
        } else {
            serializerOrNull = SerializersKt.serializerOrNull(serializersModule, genericComponentType);
            if (serializerOrNull == null) {
                return null;
            }
        }
        if (genericComponentType instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) genericComponentType).getRawType();
            Intrinsics.checkNotNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            kClass = JvmClassMappingKt.getKotlinClass((Class) rawType);
        } else {
            if (!(genericComponentType instanceof KClass)) {
                throw new IllegalStateException("unsupported type in GenericArray: " + Reflection.getOrCreateKotlinClass(genericComponentType.getClass()));
            }
            kClass = (KClass) genericComponentType;
        }
        Intrinsics.checkNotNull(kClass, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        KSerializer<Object> ArraySerializer = BuiltinSerializersKt.ArraySerializer(kClass, serializerOrNull);
        Intrinsics.checkNotNull(ArraySerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
        return ArraySerializer;
    }

    private static final Class<?> prettyClass$SerializersKt__SerializersJvmKt(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            Intrinsics.checkNotNullExpressionValue(rawType, "getRawType(...)");
            return prettyClass$SerializersKt__SerializersJvmKt(rawType);
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
            Object first = ArraysKt.first(upperBounds);
            Intrinsics.checkNotNullExpressionValue(first, "first(...)");
            return prettyClass$SerializersKt__SerializersJvmKt((Type) first);
        }
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            Intrinsics.checkNotNullExpressionValue(genericComponentType, "getGenericComponentType(...)");
            return prettyClass$SerializersKt__SerializersJvmKt(genericComponentType);
        }
        throw new IllegalArgumentException("type should be an instance of Class<?>, GenericArrayType, ParametrizedType or WildcardType, but actual argument " + type + " has type " + Reflection.getOrCreateKotlinClass(type.getClass()));
    }

    private static final <T> KSerializer<T> reflectiveOrContextual$SerializersKt__SerializersJvmKt(SerializersModule serializersModule, Class<T> cls, List<? extends KSerializer<Object>> list) {
        KSerializer[] kSerializerArr = (KSerializer[]) list.toArray(new KSerializer[0]);
        KSerializer<T> constructSerializerForGivenTypeArgs = PlatformKt.constructSerializerForGivenTypeArgs(cls, (KSerializer<Object>[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
        if (constructSerializerForGivenTypeArgs != null) {
            return constructSerializerForGivenTypeArgs;
        }
        KClass<T> kotlinClass = JvmClassMappingKt.getKotlinClass(cls);
        KSerializer<T> builtinSerializerOrNull = PrimitivesKt.builtinSerializerOrNull(kotlinClass);
        return builtinSerializerOrNull == null ? serializersModule.getContextual(kotlinClass, list) : builtinSerializerOrNull;
    }

    public static final KSerializer<Object> serializer(SerializersModule serializersModule, Type type) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        KSerializer<Object> serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt = serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(serializersModule, type, true);
        if (serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt != null) {
            return serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt;
        }
        PlatformKt.serializerNotRegistered(prettyClass$SerializersKt__SerializersJvmKt(type));
        throw new KotlinNothingValueException();
    }

    private static final KSerializer<Object> serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(SerializersModule serializersModule, Type type, boolean z5) {
        ArrayList<KSerializer> arrayList;
        if (type instanceof GenericArrayType) {
            return genericArraySerializer$SerializersKt__SerializersJvmKt(serializersModule, (GenericArrayType) type, z5);
        }
        if (type instanceof Class) {
            return typeSerializer$SerializersKt__SerializersJvmKt(serializersModule, (Class) type, z5);
        }
        if (!(type instanceof ParameterizedType)) {
            if (type instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type).getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                Object first = ArraysKt.first(upperBounds);
                Intrinsics.checkNotNullExpressionValue(first, "first(...)");
                return serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt$default(serializersModule, (Type) first, false, 2, null);
            }
            throw new IllegalArgumentException("type should be an instance of Class<?>, GenericArrayType, ParametrizedType or WildcardType, but actual argument " + type + " has type " + Reflection.getOrCreateKotlinClass(type.getClass()));
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type rawType = parameterizedType.getRawType();
        Intrinsics.checkNotNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
        Class cls = (Class) rawType;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics.checkNotNull(actualTypeArguments);
        if (z5) {
            arrayList = new ArrayList(actualTypeArguments.length);
            for (Type type2 : actualTypeArguments) {
                Intrinsics.checkNotNull(type2);
                arrayList.add(SerializersKt.serializer(serializersModule, type2));
            }
        } else {
            arrayList = new ArrayList(actualTypeArguments.length);
            for (Type type3 : actualTypeArguments) {
                Intrinsics.checkNotNull(type3);
                KSerializer<Object> serializerOrNull = SerializersKt.serializerOrNull(serializersModule, type3);
                if (serializerOrNull == null) {
                    return null;
                }
                arrayList.add(serializerOrNull);
            }
        }
        if (Set.class.isAssignableFrom(cls)) {
            KSerializer<Object> SetSerializer = BuiltinSerializersKt.SetSerializer((KSerializer) arrayList.get(0));
            Intrinsics.checkNotNull(SetSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return SetSerializer;
        }
        if (List.class.isAssignableFrom(cls) || Collection.class.isAssignableFrom(cls)) {
            KSerializer<Object> ListSerializer = BuiltinSerializersKt.ListSerializer((KSerializer) arrayList.get(0));
            Intrinsics.checkNotNull(ListSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return ListSerializer;
        }
        if (Map.class.isAssignableFrom(cls)) {
            KSerializer<Object> MapSerializer = BuiltinSerializersKt.MapSerializer((KSerializer) arrayList.get(0), (KSerializer) arrayList.get(1));
            Intrinsics.checkNotNull(MapSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return MapSerializer;
        }
        if (Map.Entry.class.isAssignableFrom(cls)) {
            KSerializer<Object> MapEntrySerializer = BuiltinSerializersKt.MapEntrySerializer((KSerializer) arrayList.get(0), (KSerializer) arrayList.get(1));
            Intrinsics.checkNotNull(MapEntrySerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return MapEntrySerializer;
        }
        if (Pair.class.isAssignableFrom(cls)) {
            KSerializer<Object> PairSerializer = BuiltinSerializersKt.PairSerializer((KSerializer) arrayList.get(0), (KSerializer) arrayList.get(1));
            Intrinsics.checkNotNull(PairSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return PairSerializer;
        }
        if (Triple.class.isAssignableFrom(cls)) {
            KSerializer<Object> TripleSerializer = BuiltinSerializersKt.TripleSerializer((KSerializer) arrayList.get(0), (KSerializer) arrayList.get(1), (KSerializer) arrayList.get(2));
            Intrinsics.checkNotNull(TripleSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return TripleSerializer;
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (KSerializer kSerializer : arrayList) {
            Intrinsics.checkNotNull(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            arrayList2.add(kSerializer);
        }
        return reflectiveOrContextual$SerializersKt__SerializersJvmKt(serializersModule, cls, arrayList2);
    }

    static /* synthetic */ KSerializer serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt$default(SerializersModule serializersModule, Type type, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = true;
        }
        return serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(serializersModule, type, z5);
    }

    public static final KSerializer<Object> serializerOrNull(SerializersModule serializersModule, Type type) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(serializersModule, type, false);
    }

    private static final KSerializer<Object> typeSerializer$SerializersKt__SerializersJvmKt(SerializersModule serializersModule, Class<?> cls, boolean z5) {
        KSerializer<Object> serializerOrNull;
        if (!cls.isArray() || cls.getComponentType().isPrimitive()) {
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            return reflectiveOrContextual$SerializersKt__SerializersJvmKt(serializersModule, cls, CollectionsKt.emptyList());
        }
        Class<?> componentType = cls.getComponentType();
        Intrinsics.checkNotNullExpressionValue(componentType, "getComponentType(...)");
        if (z5) {
            serializerOrNull = SerializersKt.serializer(serializersModule, componentType);
        } else {
            serializerOrNull = SerializersKt.serializerOrNull(serializersModule, componentType);
            if (serializerOrNull == null) {
                return null;
            }
        }
        KClass kotlinClass = JvmClassMappingKt.getKotlinClass(componentType);
        Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        KSerializer<Object> ArraySerializer = BuiltinSerializersKt.ArraySerializer(kotlinClass, serializerOrNull);
        Intrinsics.checkNotNull(ArraySerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
        return ArraySerializer;
    }
}
