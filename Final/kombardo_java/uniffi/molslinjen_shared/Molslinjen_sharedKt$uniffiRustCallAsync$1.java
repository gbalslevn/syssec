package uniffi.molslinjen_shared;

import java.lang.Exception;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "uniffi.molslinjen_shared.Molslinjen_sharedKt", f = "molslinjen_shared.kt", l = {6624}, m = "uniffiRustCallAsync")
/* loaded from: classes3.dex */
public final class Molslinjen_sharedKt$uniffiRustCallAsync$1<T, F, E extends Exception> extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Molslinjen_sharedKt$uniffiRustCallAsync$1(Continuation<? super Molslinjen_sharedKt$uniffiRustCallAsync$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Molslinjen_sharedKt.uniffiRustCallAsync(0L, null, null, null, null, null, this);
    }
}
