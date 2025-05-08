package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a.\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"T", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlin/Result;", "result", BuildConfig.FLAVOR, "completeWith", "(Lkotlinx/coroutines/CompletableDeferred;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/Job;", "parent", "CompletableDeferred", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/CompletableDeferred;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class CompletableDeferredKt {
    public static final <T> CompletableDeferred<T> CompletableDeferred(Job job) {
        return new CompletableDeferredImpl(job);
    }

    public static /* synthetic */ CompletableDeferred CompletableDeferred$default(Job job, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            job = null;
        }
        return CompletableDeferred(job);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean completeWith(CompletableDeferred<T> completableDeferred, Object obj) {
        Throwable m3570exceptionOrNullimpl = Result.m3570exceptionOrNullimpl(obj);
        return m3570exceptionOrNullimpl == null ? completableDeferred.complete(obj) : completableDeferred.completeExceptionally(m3570exceptionOrNullimpl);
    }
}
