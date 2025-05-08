package dk.molslinjen.workers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.workers.ConfigUpdateWorker", f = "ConfigUpdateWorker.kt", l = {21}, m = "doWork")
/* loaded from: classes2.dex */
public final class ConfigUpdateWorker$doWork$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConfigUpdateWorker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigUpdateWorker$doWork$1(ConfigUpdateWorker configUpdateWorker, Continuation<? super ConfigUpdateWorker$doWork$1> continuation) {
        super(continuation);
        this.this$0 = configUpdateWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork(this);
    }
}
