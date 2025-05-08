package dk.molslinjen.domain.extensions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.extensions.ManagerResultExtensionsKt", f = "ManagerResultExtensions.kt", l = {26}, m = "onSuccess")
/* loaded from: classes2.dex */
public final class ManagerResultExtensionsKt$onSuccess$1<Value> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ManagerResultExtensionsKt$onSuccess$1(Continuation<? super ManagerResultExtensionsKt$onSuccess$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ManagerResultExtensionsKt.onSuccess(null, null, this);
    }
}
