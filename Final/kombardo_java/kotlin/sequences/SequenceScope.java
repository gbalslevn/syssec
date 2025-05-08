package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\t\b\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H¦@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/sequences/SequenceScope;", "T", BuildConfig.FLAVOR, "<init>", "()V", "value", BuildConfig.FLAVOR, "yield", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SequenceScope<T> {
    public abstract Object yield(T t5, Continuation<? super Unit> continuation);
}
