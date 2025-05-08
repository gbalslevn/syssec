package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* loaded from: classes3.dex */
public abstract class TypeEnhancementUtilsKt {
    public static final JavaTypeQualifiers computeQualifiersForOverride(JavaTypeQualifiers javaTypeQualifiers, Collection<JavaTypeQualifiers> superQualifiers, boolean z5, boolean z6, boolean z7) {
        NullabilityQualifier nullabilityQualifier;
        boolean z8;
        Intrinsics.checkNotNullParameter(javaTypeQualifiers, "<this>");
        Intrinsics.checkNotNullParameter(superQualifiers, "superQualifiers");
        Collection<JavaTypeQualifiers> collection = superQualifiers;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            NullabilityQualifier nullabilityForErrors = getNullabilityForErrors((JavaTypeQualifiers) it.next());
            if (nullabilityForErrors != null) {
                arrayList.add(nullabilityForErrors);
            }
        }
        NullabilityQualifier select = select(CollectionsKt.toSet(arrayList), getNullabilityForErrors(javaTypeQualifiers), z5);
        if (select == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = collection.iterator();
            while (it2.hasNext()) {
                NullabilityQualifier nullability = ((JavaTypeQualifiers) it2.next()).getNullability();
                if (nullability != null) {
                    arrayList2.add(nullability);
                }
            }
            nullabilityQualifier = select(CollectionsKt.toSet(arrayList2), javaTypeQualifiers.getNullability(), z5);
        } else {
            nullabilityQualifier = select;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it3 = collection.iterator();
        while (it3.hasNext()) {
            MutabilityQualifier mutability = ((JavaTypeQualifiers) it3.next()).getMutability();
            if (mutability != null) {
                arrayList3.add(mutability);
            }
        }
        MutabilityQualifier mutabilityQualifier = (MutabilityQualifier) select(CollectionsKt.toSet(arrayList3), MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, javaTypeQualifiers.getMutability(), z5);
        NullabilityQualifier nullabilityQualifier2 = null;
        if (nullabilityQualifier != null && !z7 && (!z6 || nullabilityQualifier != NullabilityQualifier.NULLABLE)) {
            nullabilityQualifier2 = nullabilityQualifier;
        }
        boolean z9 = false;
        if (nullabilityQualifier2 == NullabilityQualifier.NOT_NULL) {
            if (!javaTypeQualifiers.getDefinitelyNotNull()) {
                if (!collection.isEmpty()) {
                    Iterator<T> it4 = collection.iterator();
                    while (it4.hasNext()) {
                        if (((JavaTypeQualifiers) it4.next()).getDefinitelyNotNull()) {
                        }
                    }
                }
            }
            z8 = true;
            if (nullabilityQualifier2 != null && select != nullabilityQualifier) {
                z9 = true;
            }
            return new JavaTypeQualifiers(nullabilityQualifier2, mutabilityQualifier, z8, z9);
        }
        z8 = false;
        if (nullabilityQualifier2 != null) {
            z9 = true;
        }
        return new JavaTypeQualifiers(nullabilityQualifier2, mutabilityQualifier, z8, z9);
    }

    private static final NullabilityQualifier getNullabilityForErrors(JavaTypeQualifiers javaTypeQualifiers) {
        if (javaTypeQualifiers.isNullabilityQualifierForWarning()) {
            return null;
        }
        return javaTypeQualifiers.getNullability();
    }

    public static final boolean hasEnhancedNullability(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker type) {
        Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        FqName ENHANCED_NULLABILITY_ANNOTATION = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        return typeSystemCommonBackendContext.hasAnnotation(type, ENHANCED_NULLABILITY_ANNOTATION);
    }

    private static final <T> T select(Set<? extends T> set, T t5, T t6, T t7, boolean z5) {
        Set<? extends T> set2;
        if (z5) {
            T t8 = set.contains(t5) ? t5 : set.contains(t6) ? t6 : null;
            if (Intrinsics.areEqual(t8, t5) && Intrinsics.areEqual(t7, t6)) {
                return null;
            }
            return t7 == null ? t8 : t7;
        }
        if (t7 != null && (set2 = CollectionsKt.toSet(SetsKt.plus(set, t7))) != null) {
            set = set2;
        }
        return (T) CollectionsKt.singleOrNull(set);
    }

    private static final NullabilityQualifier select(Set<? extends NullabilityQualifier> set, NullabilityQualifier nullabilityQualifier, boolean z5) {
        NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.FORCE_FLEXIBILITY;
        return nullabilityQualifier == nullabilityQualifier2 ? nullabilityQualifier2 : (NullabilityQualifier) select(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z5);
    }
}
