package dk.molslinjen.ui.views.reusable.input;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt$StyledTextField$2$1$5$1$1", f = "StyledTextField.kt", l = {139, 140}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class StyledTextFieldKt$StyledTextField$2$1$5$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StyledTextFieldKt$StyledTextField$2$1$5$1$1(BringIntoViewRequester bringIntoViewRequester, Continuation<? super StyledTextFieldKt$StyledTextField$2$1$5$1$1> continuation) {
        super(2, continuation);
        this.$bringIntoViewRequester = bringIntoViewRequester;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StyledTextFieldKt$StyledTextField$2$1$5$1$1(this.$bringIntoViewRequester, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(150L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        BringIntoViewRequester bringIntoViewRequester = this.$bringIntoViewRequester;
        this.label = 2;
        if (BringIntoViewRequester.bringIntoView$default(bringIntoViewRequester, null, this, 1, null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StyledTextFieldKt$StyledTextField$2$1$5$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
