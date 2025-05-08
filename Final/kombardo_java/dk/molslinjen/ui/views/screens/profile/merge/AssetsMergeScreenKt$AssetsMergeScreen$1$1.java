package dk.molslinjen.ui.views.screens.profile.merge;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.LoginResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeScreenKt$AssetsMergeScreen$1$1", f = "AssetsMergeScreen.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class AssetsMergeScreenKt$AssetsMergeScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super ManagerResult<? extends LoginResult>>, Object> $action;
    final /* synthetic */ Function2<ManagerResult.Error, Continuation<? super ManagerResult.Error>, Object> $failure;
    final /* synthetic */ AssetsMergeViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AssetsMergeScreenKt$AssetsMergeScreen$1$1(AssetsMergeViewModel assetsMergeViewModel, Function1<? super Continuation<? super ManagerResult<? extends LoginResult>>, ? extends Object> function1, Function2<? super ManagerResult.Error, ? super Continuation<? super ManagerResult.Error>, ? extends Object> function2, Continuation<? super AssetsMergeScreenKt$AssetsMergeScreen$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = assetsMergeViewModel;
        this.$action = function1;
        this.$failure = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AssetsMergeScreenKt$AssetsMergeScreen$1$1(this.$viewModel, this.$action, this.$failure, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$viewModel.perform(this.$action, this.$failure);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AssetsMergeScreenKt$AssetsMergeScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
