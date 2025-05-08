package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes3.dex */
public final class CompositeAnnotations implements Annotations {
    private final List<Annotations> delegates;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeAnnotations(List<? extends Annotations> delegates) {
        Intrinsics.checkNotNullParameter(delegates, "delegates");
        this.delegates = delegates;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotationDescriptor findAnnotation$lambda$2(FqName fqName, Annotations it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.mo3685findAnnotation(fqName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Sequence iterator$lambda$4(Annotations it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.asSequence(it);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* renamed from: findAnnotation */
    public AnnotationDescriptor mo3685findAnnotation(final FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return (AnnotationDescriptor) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.delegates), new Function1(fqName) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations$$Lambda$0
            private final FqName arg$0;

            {
                this.arg$0 = fqName;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                AnnotationDescriptor findAnnotation$lambda$2;
                findAnnotation$lambda$2 = CompositeAnnotations.findAnnotation$lambda$2(this.arg$0, (Annotations) obj);
                return findAnnotation$lambda$2;
            }
        }));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Iterator it = CollectionsKt.asSequence(this.delegates).iterator();
        while (it.hasNext()) {
            if (((Annotations) it.next()).hasAnnotation(fqName)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        List<Annotations> list = this.delegates;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((Annotations) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt.flatMap(CollectionsKt.asSequence(this.delegates), new Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Sequence iterator$lambda$4;
                iterator$lambda$4 = CompositeAnnotations.iterator$lambda$4((Annotations) obj);
                return iterator$lambda$4;
            }
        }).iterator();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompositeAnnotations(Annotations... delegates) {
        this((List<? extends Annotations>) ArraysKt.toList(delegates));
        Intrinsics.checkNotNullParameter(delegates, "delegates");
    }
}
