package dk.molslinjen.api.extensions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.extensions.ApiResultExtensionsKt", f = "ApiResultExtensions.kt", l = {12}, m = "mapOnSuccess")
/* loaded from: classes2.dex */
public final class ApiResultExtensionsKt$mapOnSuccess$1<T, R> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ApiResultExtensionsKt$mapOnSuccess$1(Continuation<? super ApiResultExtensionsKt$mapOnSuccess$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ApiResultExtensionsKt.mapOnSuccess(null, null, this);
    }
}
