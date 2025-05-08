package dk.molslinjen.ui.views.screens.profile.authentication.password.reset;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.authentication.password.reset.ResetPasswordViewModel", f = "ResetPasswordViewModel.kt", l = {56}, m = "resetPasswordFailure")
/* loaded from: classes2.dex */
public final class ResetPasswordViewModel$resetPasswordFailure$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResetPasswordViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetPasswordViewModel$resetPasswordFailure$1(ResetPasswordViewModel resetPasswordViewModel, Continuation<? super ResetPasswordViewModel$resetPasswordFailure$1> continuation) {
        super(continuation);
        this.this$0 = resetPasswordViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.resetPasswordFailure(null, this);
    }
}
