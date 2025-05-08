package dk.molslinjen.ui.views.screens.profile.merge;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.merge.AssetsMergeMethod;
import dk.molslinjen.domain.model.account.MergeResult;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeViewModel$merge$1", f = "AssetsMergeViewModel.kt", l = {53, 57}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class AssetsMergeViewModel$merge$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AssetsMergeMethod $method;
    int label;
    final /* synthetic */ AssetsMergeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetsMergeViewModel$merge$1(AssetsMergeViewModel assetsMergeViewModel, AssetsMergeMethod assetsMergeMethod, Continuation<? super AssetsMergeViewModel$merge$1> continuation) {
        super(2, continuation);
        this.this$0 = assetsMergeViewModel;
        this.$method = assetsMergeMethod;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AssetsMergeViewModel$merge$1(this.this$0, this.$method, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        IUserManager iUserManager;
        ISnackbarService iSnackbarService;
        AssetsMergeViewModel.MergeState mergingError;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ((AssetsMergeViewModel.ViewState) value).copy(AssetsMergeViewModel.MergeState.Loading.INSTANCE)));
            iUserManager = this.this$0.userManager;
            AssetsMergeMethod assetsMergeMethod = this.$method;
            this.label = 1;
            obj = iUserManager.mergeAssets(assetsMergeMethod, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                mergingError = AssetsMergeViewModel.MergeState.Success.INSTANCE;
                mutableStateFlow2 = this.this$0._viewState;
                do {
                    value2 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value2, ((AssetsMergeViewModel.ViewState) value2).copy(mergingError)));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ManagerResult managerResult = (ManagerResult) obj;
        if (managerResult instanceof ManagerResult.Error) {
            mergingError = new AssetsMergeViewModel.MergeState.MergingError((ManagerResult.Error) managerResult);
            mutableStateFlow2 = this.this$0._viewState;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, ((AssetsMergeViewModel.ViewState) value2).copy(mergingError)));
            return Unit.INSTANCE;
        }
        if (!(managerResult instanceof ManagerResult.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        if (((MergeResult) ((ManagerResult.Success) managerResult).getData()).getHasError()) {
            iSnackbarService = this.this$0.snackbarService;
            SnackbarEvent.Information information = new SnackbarEvent.Information(new SnackbarText.ResourceText(R.string.merge_partialFailed), null, false, 2, null);
            this.label = 2;
            if (iSnackbarService.publishEvent(information, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        mergingError = AssetsMergeViewModel.MergeState.Success.INSTANCE;
        mutableStateFlow2 = this.this$0._viewState;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, ((AssetsMergeViewModel.ViewState) value2).copy(mergingError)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AssetsMergeViewModel$merge$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
