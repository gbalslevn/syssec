package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\u001aG\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002*\b\u0001\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0007¢\u0006\u0004\b\b\u0010\t\u001aG\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u00002*\b\u0001\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0007¢\u0006\u0004\b\u000b\u0010\f\"\u0018\u0010\u000f\u001a\u00060\rj\u0002`\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u0018\u0010\u0011\u001a\u00060\rj\u0002`\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010\"\u0018\u0010\u0012\u001a\u00060\rj\u0002`\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010\"\u0018\u0010\u0013\u001a\u00060\rj\u0002`\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010\"\u0018\u0010\u0014\u001a\u00060\rj\u0002`\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010\"\u0018\u0010\u0015\u001a\u00060\rj\u0002`\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010*\f\b\u0002\u0010\u0016\"\u00020\r2\u00020\r¨\u0006\u0017"}, d2 = {"T", "Lkotlin/Function2;", "Lkotlin/sequences/SequenceScope;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "block", "Lkotlin/sequences/Sequence;", "sequence", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", BuildConfig.FLAVOR, "iterator", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", BuildConfig.FLAVOR, "Lkotlin/sequences/State;", "State_NotReady", "I", "State_ManyNotReady", "State_ManyReady", "State_Ready", "State_Done", "State_Failed", "State", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes3.dex */
public abstract class SequencesKt__SequenceBuilderKt {
    private static final int State_Done = 4;
    private static final int State_Failed = 5;
    private static final int State_ManyNotReady = 1;
    private static final int State_ManyReady = 2;
    private static final int State_NotReady = 0;
    private static final int State_Ready = 3;

    public static <T> Iterator<T> iterator(Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SequenceBuilderIterator sequenceBuilderIterator = new SequenceBuilderIterator();
        sequenceBuilderIterator.setNextStep(IntrinsicsKt.createCoroutineUnintercepted(block, sequenceBuilderIterator, sequenceBuilderIterator));
        return sequenceBuilderIterator;
    }

    public static <T> Sequence<T> sequence(final Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return SequencesKt.iterator(Function2.this);
            }
        };
    }
}
