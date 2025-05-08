package dk.molslinjen.ui.views.screens.profile.authentication.register;

import androidx.compose.foundation.pager.PagerState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.authentication.register.SignupScreenKt$SignupScreen$1$backAction$1$1$1", f = "SignupScreen.kt", l = {143}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SignupScreenKt$SignupScreen$1$backAction$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SignupScreenPage $currentPage;
    final /* synthetic */ PagerState $pagerState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignupScreenKt$SignupScreen$1$backAction$1$1$1(PagerState pagerState, SignupScreenPage signupScreenPage, Continuation<? super SignupScreenKt$SignupScreen$1$backAction$1$1$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$currentPage = signupScreenPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SignupScreenKt$SignupScreen$1$backAction$1$1$1(this.$pagerState, this.$currentPage, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            PagerState pagerState = this.$pagerState;
            int max = Math.max(this.$currentPage.getIndex() - 1, 0);
            this.label = 1;
            if (PagerState.animateScrollToPage$default(pagerState, max, 0.0f, null, this, 6, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SignupScreenKt$SignupScreen$1$backAction$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
