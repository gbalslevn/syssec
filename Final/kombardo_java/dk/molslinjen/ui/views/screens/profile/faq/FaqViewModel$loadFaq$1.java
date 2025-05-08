package dk.molslinjen.ui.views.screens.profile.faq;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.ManagerResultKt;
import dk.molslinjen.domain.managers.faq.IFaqManager;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.screens.profile.faq.FaqViewModel;
import kotlin.Metadata;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.faq.FaqViewModel$loadFaq$1", f = "FaqViewModel.kt", l = {59, 62}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class FaqViewModel$loadFaq$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SiteInfo $site;
    int label;
    final /* synthetic */ FaqViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaqViewModel$loadFaq$1(FaqViewModel faqViewModel, SiteInfo siteInfo, Continuation<? super FaqViewModel$loadFaq$1> continuation) {
        super(2, continuation);
        this.this$0 = faqViewModel;
        this.$site = siteInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FaqViewModel$loadFaq$1(this.this$0, this.$site, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        IFaqManager iFaqManager;
        ISnackbarService iSnackbarService;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._viewState;
            SiteInfo siteInfo = this.$site;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, FaqViewModel.ViewState.copy$default((FaqViewModel.ViewState) value, true, siteInfo, null, null, null, 28, null)));
            iFaqManager = this.this$0.faqManager;
            SiteInfo siteInfo2 = this.$site;
            this.label = 1;
            obj = iFaqManager.loadFaq(siteInfo2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                mutableStateFlow2 = this.this$0._viewState;
                do {
                    value2 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value2, FaqViewModel.ViewState.copy$default((FaqViewModel.ViewState) value2, false, null, null, null, null, 30, null)));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ManagerResult managerResult = (ManagerResult) obj;
        if ((managerResult instanceof ManagerResult.Error) && !ManagerResultKt.isNotFound((ManagerResult.Error) managerResult)) {
            iSnackbarService = this.this$0.snackbarService;
            this.label = 2;
            if (ManagerResultExtensionsKt.handlePotentialError(managerResult, iSnackbarService, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        mutableStateFlow2 = this.this$0._viewState;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, FaqViewModel.ViewState.copy$default((FaqViewModel.ViewState) value2, false, null, null, null, null, 30, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FaqViewModel$loadFaq$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
