package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\u000b\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0003¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\"\u001e\u0010\u0015\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\"\u001e\u0010\u0015\u001a\u00020\u0003*\u00020\t8BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0011\u0010\u0016¨\u0006\u0018"}, d2 = {"Lkotlin/reflect/KType;", BuildConfig.FLAVOR, "forceWrapper", "Ljava/lang/reflect/Type;", "computeJavaType", "(Lkotlin/reflect/KType;Z)Ljava/lang/reflect/Type;", "Ljava/lang/Class;", "jClass", BuildConfig.FLAVOR, "Lkotlin/reflect/KTypeProjection;", "arguments", "createPossiblyInnerType", "(Ljava/lang/Class;Ljava/util/List;)Ljava/lang/reflect/Type;", "type", BuildConfig.FLAVOR, "typeToString", "(Ljava/lang/reflect/Type;)Ljava/lang/String;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "javaType", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "(Lkotlin/reflect/KTypeProjection;)V", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TypesJVMKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type computeJavaType(KType kType, boolean z5) {
        KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KTypeParameter) {
            return new TypeVariableImpl((KTypeParameter) classifier);
        }
        if (!(classifier instanceof KClass)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
        }
        KClass kClass = (KClass) classifier;
        Class javaObjectType = z5 ? JvmClassMappingKt.getJavaObjectType(kClass) : JvmClassMappingKt.getJavaClass(kClass);
        List<KTypeProjection> arguments = kType.getArguments();
        if (arguments.isEmpty()) {
            return javaObjectType;
        }
        if (!javaObjectType.isArray()) {
            return createPossiblyInnerType(javaObjectType, arguments);
        }
        if (javaObjectType.getComponentType().isPrimitive()) {
            return javaObjectType;
        }
        KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.singleOrNull((List) arguments);
        if (kTypeProjection == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
        }
        KVariance variance = kTypeProjection.getVariance();
        KType type = kTypeProjection.getType();
        int i5 = variance == null ? -1 : WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i5 == -1 || i5 == 1) {
            return javaObjectType;
        }
        if (i5 != 2 && i5 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNull(type);
        Type computeJavaType$default = computeJavaType$default(type, false, 1, null);
        return computeJavaType$default instanceof Class ? javaObjectType : new GenericArrayTypeImpl(computeJavaType$default);
    }

    static /* synthetic */ Type computeJavaType$default(KType kType, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        return computeJavaType(kType, z5);
    }

    private static final Type createPossiblyInnerType(Class<?> cls, List<KTypeProjection> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List<KTypeProjection> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(getJavaType((KTypeProjection) it.next()));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            List<KTypeProjection> list3 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(getJavaType((KTypeProjection) it2.next()));
            }
            return new ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type createPossiblyInnerType = createPossiblyInnerType(declaringClass, list.subList(length, list.size()));
        List<KTypeProjection> subList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(subList, 10));
        Iterator<T> it3 = subList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(getJavaType((KTypeProjection) it3.next()));
        }
        return new ParameterizedTypeImpl(cls, createPossiblyInnerType, arrayList3);
    }

    public static final Type getJavaType(KType kType) {
        Type javaType;
        Intrinsics.checkNotNullParameter(kType, "<this>");
        return (!(kType instanceof KTypeBase) || (javaType = ((KTypeBase) kType).getJavaType()) == null) ? computeJavaType$default(kType, false, 1, null) : javaType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String typeToString(Type type) {
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (!cls.isArray()) {
            String name = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return name;
        }
        Sequence generateSequence = SequencesKt.generateSequence(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
        return ((Class) SequencesKt.last(generateSequence)).getName() + StringsKt.repeat("[]", SequencesKt.count(generateSequence));
    }

    private static final Type getJavaType(KTypeProjection kTypeProjection) {
        KVariance variance = kTypeProjection.getVariance();
        if (variance == null) {
            return WildcardTypeImpl.Companion.getSTAR();
        }
        KType type = kTypeProjection.getType();
        Intrinsics.checkNotNull(type);
        int i5 = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i5 == 1) {
            return new WildcardTypeImpl(null, computeJavaType(type, true));
        }
        if (i5 == 2) {
            return computeJavaType(type, true);
        }
        if (i5 == 3) {
            return new WildcardTypeImpl(computeJavaType(type, true), null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
