package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\"\u00028\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\t\u0010\n\u001a)\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0002¢\u0006\u0004\b\u000b\u0010\f\u001aE\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0012\u0010\f\u001a-\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0000*\u00020\u00132\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014¢\u0006\u0004\b\u0016\u0010\u0017\u001a?\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0000*\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00018\u00002\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000eH\u0007¢\u0006\u0004\b\u0016\u0010\u0019¨\u0006\u001a"}, d2 = {"T", BuildConfig.FLAVOR, "Lkotlin/sequences/Sequence;", "asSequence", "(Ljava/util/Iterator;)Lkotlin/sequences/Sequence;", BuildConfig.FLAVOR, "elements", "sequenceOf", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "emptySequence", "()Lkotlin/sequences/Sequence;", "flatten", "(Lkotlin/sequences/Sequence;)Lkotlin/sequences/Sequence;", "R", "Lkotlin/Function1;", "iterator", "flatten$SequencesKt__SequencesKt", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "constrainOnce", BuildConfig.FLAVOR, "Lkotlin/Function0;", "nextFunction", "generateSequence", "(Lkotlin/jvm/functions/Function0;)Lkotlin/sequences/Sequence;", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes3.dex */
public abstract class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt {
    public static <T> Sequence<T> asSequence(final Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, "<this>");
        return constrainOnce(new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return it;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Sequence<T> constrainOnce(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return sequence instanceof ConstrainedOnceSequence ? sequence : new ConstrainedOnceSequence(sequence);
    }

    public static <T> Sequence<T> emptySequence() {
        return EmptySequence.INSTANCE;
    }

    public static final <T> Sequence<T> flatten(Sequence<? extends Sequence<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return flatten$SequencesKt__SequencesKt(sequence, new Function1() { // from class: kotlin.sequences.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Iterator flatten$lambda$1$SequencesKt__SequencesKt;
                flatten$lambda$1$SequencesKt__SequencesKt = SequencesKt__SequencesKt.flatten$lambda$1$SequencesKt__SequencesKt((Sequence) obj);
                return flatten$lambda$1$SequencesKt__SequencesKt;
            }
        });
    }

    private static final <T, R> Sequence<R> flatten$SequencesKt__SequencesKt(Sequence<? extends T> sequence, Function1<? super T, ? extends Iterator<? extends R>> function1) {
        return sequence instanceof TransformingSequence ? ((TransformingSequence) sequence).flatten$kotlin_stdlib(function1) : new FlatteningSequence(sequence, new Function1() { // from class: kotlin.sequences.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object flatten$lambda$3$SequencesKt__SequencesKt;
                flatten$lambda$3$SequencesKt__SequencesKt = SequencesKt__SequencesKt.flatten$lambda$3$SequencesKt__SequencesKt(obj);
                return flatten$lambda$3$SequencesKt__SequencesKt;
            }
        }, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator flatten$lambda$1$SequencesKt__SequencesKt(Sequence it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object flatten$lambda$3$SequencesKt__SequencesKt(Object obj) {
        return obj;
    }

    public static <T> Sequence<T> generateSequence(final Function0<? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return constrainOnce(new GeneratorSequence(nextFunction, new Function1() { // from class: kotlin.sequences.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object generateSequence$lambda$4$SequencesKt__SequencesKt;
                generateSequence$lambda$4$SequencesKt__SequencesKt = SequencesKt__SequencesKt.generateSequence$lambda$4$SequencesKt__SequencesKt(Function0.this, obj);
                return generateSequence$lambda$4$SequencesKt__SequencesKt;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object generateSequence$lambda$4$SequencesKt__SequencesKt(Function0 function0, Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object generateSequence$lambda$5$SequencesKt__SequencesKt(Object obj) {
        return obj;
    }

    public static <T> Sequence<T> sequenceOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt.asSequence(elements);
    }

    public static <T> Sequence<T> generateSequence(final T t5, Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        if (t5 == null) {
            return EmptySequence.INSTANCE;
        }
        return new GeneratorSequence(new Function0() { // from class: kotlin.sequences.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object generateSequence$lambda$5$SequencesKt__SequencesKt;
                generateSequence$lambda$5$SequencesKt__SequencesKt = SequencesKt__SequencesKt.generateSequence$lambda$5$SequencesKt__SequencesKt(t5);
                return generateSequence$lambda$5$SequencesKt__SequencesKt;
            }
        }, nextFunction);
    }
}
