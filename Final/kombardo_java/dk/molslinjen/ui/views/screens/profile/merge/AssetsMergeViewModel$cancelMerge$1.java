package dk.molslinjen.ui.views.screens.profile.merge;

import dk.molslinjen.domain.managers.user.IUserManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeViewModel$cancelMerge$1", f = "AssetsMergeViewModel.kt", l = {72}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class AssetsMergeViewModel$cancelMerge$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $dismiss;
    int label;
    final /* synthetic */ AssetsMergeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetsMergeViewModel$cancelMerge$1(AssetsMergeViewModel assetsMergeViewModel, Function0<Unit> function0, Continuation<? super AssetsMergeViewModel$cancelMerge$1> continuation) {
        super(2, continuation);
        this.this$0 = assetsMergeViewModel;
        this.$dismiss = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AssetsMergeViewModel$cancelMerge$1(this.this$0, this.$dismiss, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IUserManager iUserManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iUserManager = this.this$0.userManager;
            this.label = 1;
            if (iUserManager.cancelMerge(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$dismiss.invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AssetsMergeViewModel$cancelMerge$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
