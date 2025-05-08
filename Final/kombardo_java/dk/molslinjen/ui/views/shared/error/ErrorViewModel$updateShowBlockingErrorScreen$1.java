package dk.molslinjen.ui.views.shared.error;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.shared.error.ErrorViewModel", f = "ErrorViewModel.kt", l = {28}, m = "updateShowBlockingErrorScreen")
/* loaded from: classes2.dex */
public final class ErrorViewModel$updateShowBlockingErrorScreen$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ErrorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorViewModel$updateShowBlockingErrorScreen$1(ErrorViewModel errorViewModel, Continuation<? super ErrorViewModel$updateShowBlockingErrorScreen$1> continuation) {
        super(continuation);
        this.this$0 = errorViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateShowBlockingErrorScreen(this);
    }
}
