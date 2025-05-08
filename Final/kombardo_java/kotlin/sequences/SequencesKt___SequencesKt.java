package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001f\u0010\u0002\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u0003\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a7\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\r\u001a7\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000e\u0010\r\u001a)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u000f*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a7\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0012\u0010\r\u001a?\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0015\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0013j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0014¢\u0006\u0004\b\u0016\u0010\u0017\u001a7\u0010\u001b\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0018*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001a\u001a\u00028\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a#\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a#\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 \"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b!\u0010\u001f\u001aE\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\"*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010#0\tH\u0007¢\u0006\u0004\b%\u0010\r\u001aC\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\"*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\t¢\u0006\u0004\b&\u0010\r\u001a=\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\"*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b'\u0010\r\u001aC\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\"*\u00020\u000f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\t¢\u0006\u0004\b(\u0010\r\u001a#\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b)\u0010\u0011\u001a=\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010**\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b,\u0010\r\u001a\u001d\u0010-\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b-\u0010.\u001a.\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010/\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b0\u00101\u001a4\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0086\u0002¢\u0006\u0004\b0\u00103\u001a4\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b0\u00104\u001a}\u0010?\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\f\b\u0001\u00107*\u000605j\u0002`6*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u00108\u001a\u00028\u00012\b\b\u0002\u0010:\u001a\u0002092\b\b\u0002\u0010;\u001a\u0002092\b\b\u0002\u0010<\u001a\u0002092\b\b\u0002\u0010=\u001a\u00020\u00052\b\b\u0002\u0010>\u001a\u0002092\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u000209\u0018\u00010\t¢\u0006\u0004\b?\u0010@\u001ag\u0010B\u001a\u00020A\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010:\u001a\u0002092\b\b\u0002\u0010;\u001a\u0002092\b\b\u0002\u0010<\u001a\u0002092\b\b\u0002\u0010=\u001a\u00020\u00052\b\b\u0002\u0010>\u001a\u0002092\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u000209\u0018\u00010\t¢\u0006\u0004\bB\u0010C\u001a#\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000#\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bD\u0010E¨\u0006F"}, d2 = {"T", "Lkotlin/sequences/Sequence;", "firstOrNull", "(Lkotlin/sequences/Sequence;)Ljava/lang/Object;", "last", BuildConfig.FLAVOR, "n", "drop", "(Lkotlin/sequences/Sequence;I)Lkotlin/sequences/Sequence;", "Lkotlin/Function1;", BuildConfig.FLAVOR, "predicate", "filter", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "filterNot", BuildConfig.FLAVOR, "filterNotNull", "(Lkotlin/sequences/Sequence;)Lkotlin/sequences/Sequence;", "takeWhile", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "sortedWith", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Lkotlin/sequences/Sequence;", BuildConfig.FLAVOR, "C", "destination", "toCollection", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;)Ljava/util/Collection;", BuildConfig.FLAVOR, "toList", "(Lkotlin/sequences/Sequence;)Ljava/util/List;", BuildConfig.FLAVOR, "toMutableList", "R", BuildConfig.FLAVOR, "transform", "flatMapIterable", "flatMap", "map", "mapNotNull", "distinct", "K", "selector", "distinctBy", "count", "(Lkotlin/sequences/Sequence;)I", "element", "plus", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "elements", "(Lkotlin/sequences/Sequence;Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;Lkotlin/sequences/Sequence;)Lkotlin/sequences/Sequence;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "A", "buffer", BuildConfig.FLAVOR, "separator", "prefix", "postfix", "limit", "truncated", "joinTo", "(Lkotlin/sequences/Sequence;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", BuildConfig.FLAVOR, "joinToString", "(Lkotlin/sequences/Sequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "asIterable", "(Lkotlin/sequences/Sequence;)Ljava/lang/Iterable;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes3.dex */
public abstract class SequencesKt___SequencesKt extends SequencesKt___SequencesJvmKt {
    public static <T> Iterable<T> asIterable(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(sequence);
    }

    public static <T> int count(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            it.next();
            i5++;
            if (i5 < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return i5;
    }

    public static <T> Sequence<T> distinct(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return distinctBy(sequence, new Function1() { // from class: kotlin.sequences.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object distinct$lambda$13$SequencesKt___SequencesKt;
                distinct$lambda$13$SequencesKt___SequencesKt = SequencesKt___SequencesKt.distinct$lambda$13$SequencesKt___SequencesKt(obj);
                return distinct$lambda$13$SequencesKt___SequencesKt;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object distinct$lambda$13$SequencesKt___SequencesKt(Object obj) {
        return obj;
    }

    public static final <T, K> Sequence<T> distinctBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new DistinctSequence(sequence, selector);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Sequence<T> drop(Sequence<? extends T> sequence, int i5) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (i5 >= 0) {
            return i5 == 0 ? sequence : sequence instanceof DropTakeSequence ? ((DropTakeSequence) sequence).drop(i5) : new DropSequence(sequence, i5);
        }
        throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
    }

    public static <T> Sequence<T> filter(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new FilteringSequence(sequence, true, predicate);
    }

    public static <T> Sequence<T> filterNot(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new FilteringSequence(sequence, false, predicate);
    }

    public static <T> Sequence<T> filterNotNull(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Sequence<T> filterNot = SequencesKt.filterNot(sequence, new Function1() { // from class: kotlin.sequences.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean filterNotNull$lambda$5$SequencesKt___SequencesKt;
                filterNotNull$lambda$5$SequencesKt___SequencesKt = SequencesKt___SequencesKt.filterNotNull$lambda$5$SequencesKt___SequencesKt(obj);
                return Boolean.valueOf(filterNotNull$lambda$5$SequencesKt___SequencesKt);
            }
        });
        Intrinsics.checkNotNull(filterNot, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return filterNot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean filterNotNull$lambda$5$SequencesKt___SequencesKt(Object obj) {
        return obj == null;
    }

    public static <T> T firstOrNull(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static <T, R> Sequence<R> flatMap(Sequence<? extends T> sequence, Function1<? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new FlatteningSequence(sequence, transform, SequencesKt___SequencesKt$flatMap$2.INSTANCE);
    }

    public static <T, R> Sequence<R> flatMapIterable(Sequence<? extends T> sequence, Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new FlatteningSequence(sequence, transform, SequencesKt___SequencesKt$flatMap$1.INSTANCE);
    }

    public static final <T, A extends Appendable> A joinTo(Sequence<? extends T> sequence, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i6 = 0;
        for (T t5 : sequence) {
            i6++;
            if (i6 > 1) {
                buffer.append(separator);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            StringsKt.appendElement(buffer, t5, function1);
        }
        if (i5 >= 0 && i6 > i5) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> String joinToString(Sequence<? extends T> sequence, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(sequence, new StringBuilder(), separator, prefix, postfix, i5, truncated, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, Function1 function1, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        int i7 = i6 & 2;
        CharSequence charSequence5 = BuildConfig.FLAVOR;
        CharSequence charSequence6 = i7 != 0 ? BuildConfig.FLAVOR : charSequence2;
        if ((i6 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        int i8 = i5;
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i6 & 32) != 0) {
            function1 = null;
        }
        return joinToString(sequence, charSequence, charSequence6, charSequence5, i8, charSequence7, function1);
    }

    public static <T> T last(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T, R> Sequence<R> map(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new TransformingSequence(sequence, transform);
    }

    public static <T, R> Sequence<R> mapNotNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return SequencesKt.filterNotNull(new TransformingSequence(sequence, transform));
    }

    public static <T> Sequence<T> plus(Sequence<? extends T> sequence, T t5) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SequencesKt__SequencesKt.flatten(SequencesKt.sequenceOf(sequence, SequencesKt.sequenceOf(t5)));
    }

    public static <T> Sequence<T> sortedWith(final Sequence<? extends T> sequence, final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$sortedWith$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                List mutableList = SequencesKt.toMutableList(sequence);
                CollectionsKt.sortWith(mutableList, comparator);
                return mutableList.iterator();
            }
        };
    }

    public static <T> Sequence<T> takeWhile(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new TakeWhileSequence(sequence, predicate);
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Sequence<? extends T> sequence, C destination) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static <T> List<T> toList(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return CollectionsKt.emptyList();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return CollectionsKt.listOf(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static <T> List<T> toMutableList(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return (List) toCollection(sequence, new ArrayList());
    }

    public static <T> Sequence<T> plus(Sequence<? extends T> sequence, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return SequencesKt__SequencesKt.flatten(SequencesKt.sequenceOf(sequence, CollectionsKt.asSequence(elements)));
    }

    public static <T> Sequence<T> plus(Sequence<? extends T> sequence, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return SequencesKt__SequencesKt.flatten(SequencesKt.sequenceOf(sequence, elements));
    }
}
