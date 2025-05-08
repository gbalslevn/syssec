package dk.molslinjen.ui.views.screens.profile.merge;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.LoginResult;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeViewModel$perform$1", f = "AssetsMergeViewModel.kt", l = {32, 35}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class AssetsMergeViewModel$perform$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super ManagerResult<? extends LoginResult>>, Object> $action;
    final /* synthetic */ Function2<ManagerResult.Error, Continuation<? super ManagerResult.Error>, Object> $failure;
    int label;
    final /* synthetic */ AssetsMergeViewModel this$0;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginResult.values().length];
            try {
                iArr[LoginResult.Success.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoginResult.MergePending.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AssetsMergeViewModel$perform$1(AssetsMergeViewModel assetsMergeViewModel, Function1<? super Continuation<? super ManagerResult<? extends LoginResult>>, ? extends Object> function1, Function2<? super ManagerResult.Error, ? super Continuation<? super ManagerResult.Error>, ? extends Object> function2, Continuation<? super AssetsMergeViewModel$perform$1> continuation) {
        super(2, continuation);
        this.this$0 = assetsMergeViewModel;
        this.$action = function1;
        this.$failure = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AssetsMergeViewModel$perform$1(this.this$0, this.$action, this.$failure, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        AssetsMergeViewModel.MergeState mergeState;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        ManagerResult.Error error;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ((AssetsMergeViewModel.ViewState) value).copy(AssetsMergeViewModel.MergeState.Loading.INSTANCE)));
            Function1<Continuation<? super ManagerResult<? extends LoginResult>>, Object> function1 = this.$action;
            this.label = 1;
            obj = function1.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                error = (ManagerResult.Error) obj;
                if (error != null) {
                    new AssetsMergeViewModel.MergeState.ActionError(error);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ManagerResult managerResult = (ManagerResult) obj;
        if (managerResult instanceof ManagerResult.Error) {
            Function2<ManagerResult.Error, Continuation<? super ManagerResult.Error>, Object> function2 = this.$failure;
            this.label = 2;
            obj = function2.invoke(managerResult, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            error = (ManagerResult.Error) obj;
            if (error != null) {
            }
            return Unit.INSTANCE;
        }
        if (!(managerResult instanceof ManagerResult.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        int i6 = WhenMappings.$EnumSwitchMapping$0[((LoginResult) ((ManagerResult.Success) managerResult).getData()).ordinal()];
        if (i6 == 1) {
            mergeState = AssetsMergeViewModel.MergeState.Success.INSTANCE;
        } else {
            if (i6 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            mergeState = AssetsMergeViewModel.MergeState.Merge.INSTANCE;
        }
        mutableStateFlow2 = this.this$0._viewState;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, ((AssetsMergeViewModel.ViewState) value2).copy(mergeState)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AssetsMergeViewModel$perform$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
