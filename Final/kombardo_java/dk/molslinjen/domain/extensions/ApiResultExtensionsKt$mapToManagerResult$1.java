package dk.molslinjen.domain.extensions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.extensions.ApiResultExtensionsKt", f = "ApiResultExtensions.kt", l = {9}, m = "mapToManagerResult")
/* loaded from: classes2.dex */
public final class ApiResultExtensionsKt$mapToManagerResult$1<Incoming, Result> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ApiResultExtensionsKt$mapToManagerResult$1(Continuation<? super ApiResultExtensionsKt$mapToManagerResult$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ApiResultExtensionsKt.mapToManagerResult(null, null, this);
    }
}
