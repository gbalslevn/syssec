package kotlin.reflect.jvm;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\"\"\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/reflect/KType;", "Lkotlin/reflect/KClass;", "getJvmErasure", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "getJvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "jvmErasure", "Lkotlin/reflect/KClassifier;", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "kotlin-reflection"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class KTypesJvm {
    public static final KClass<?> getJvmErasure(KType kType) {
        KClass<?> jvmErasure;
        Intrinsics.checkNotNullParameter(kType, "<this>");
        KClassifier classifier = kType.getClassifier();
        if (classifier != null && (jvmErasure = getJvmErasure(classifier)) != null) {
            return jvmErasure;
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final KClass<?> getJvmErasure(KClassifier kClassifier) {
        ClassDescriptor classDescriptor;
        KClass<?> jvmErasure;
        Intrinsics.checkNotNullParameter(kClassifier, "<this>");
        if (kClassifier instanceof KClass) {
            return (KClass) kClassifier;
        }
        if (kClassifier instanceof KTypeParameter) {
            List<KType> upperBounds = ((KTypeParameter) kClassifier).getUpperBounds();
            Iterator<T> it = upperBounds.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                KType kType = (KType) next;
                Intrinsics.checkNotNull(kType, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                ClassifierDescriptor mo3718getDeclarationDescriptor = ((KTypeImpl) kType).getType().getConstructor().mo3718getDeclarationDescriptor();
                classDescriptor = mo3718getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo3718getDeclarationDescriptor : null;
                if (classDescriptor != null && classDescriptor.getKind() != ClassKind.INTERFACE && classDescriptor.getKind() != ClassKind.ANNOTATION_CLASS) {
                    classDescriptor = next;
                    break;
                }
            }
            KType kType2 = (KType) classDescriptor;
            if (kType2 == null) {
                kType2 = (KType) CollectionsKt.firstOrNull((List) upperBounds);
            }
            return (kType2 == null || (jvmErasure = getJvmErasure(kType2)) == null) ? Reflection.getOrCreateKotlinClass(Object.class) : jvmErasure;
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kClassifier);
    }
}
