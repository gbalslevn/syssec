package dk.molslinjen.domain.managers.user;

import dk.molslinjen.domain.managers.user.merge.AssetsMergeContext;
import dk.molslinjen.domain.model.account.MergeResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/domain/model/account/MergeResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.UserManager$mergeAssets$2", f = "UserManager.kt", l = {545}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class UserManager$mergeAssets$2 extends SuspendLambda implements Function2<MergeResult, Continuation<? super Unit>, Object> {
    final /* synthetic */ AssetsMergeContext $context;
    int label;
    final /* synthetic */ UserManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserManager$mergeAssets$2(AssetsMergeContext assetsMergeContext, UserManager userManager, Continuation<? super UserManager$mergeAssets$2> continuation) {
        super(2, continuation);
        this.$context = assetsMergeContext;
        this.this$0 = userManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserManager$mergeAssets$2(this.$context, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MergeResult mergeResult, Continuation<? super Unit> continuation) {
        return ((UserManager$mergeAssets$2) create(mergeResult, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m3202handleValidAuthTokenzHhnIQY;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            String authToken = this.$context.getAuthToken();
            this.this$0.assetsMergeContext = null;
            UserManager userManager = this.this$0;
            this.label = 1;
            m3202handleValidAuthTokenzHhnIQY = userManager.m3202handleValidAuthTokenzHhnIQY(authToken, null, true, this);
            if (m3202handleValidAuthTokenzHhnIQY == coroutine_suspended) {
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
}
