package dk.molslinjen.ui.views.screens.profile.faq;

import dk.molslinjen.domain.managers.faq.FaqManagerState;
import dk.molslinjen.domain.model.faq.FaqPopularQuestion;
import dk.molslinjen.domain.model.faq.SiteFaq;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.ui.views.screens.profile.faq.FaqViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/ui/views/screens/profile/faq/FaqViewModel$ViewState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.faq.FaqViewModel$mapData$2", f = "FaqViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class FaqViewModel$mapData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FaqViewModel.ViewState>, Object> {
    final /* synthetic */ FaqManagerState $faqState;
    final /* synthetic */ FaqViewModel.ViewState $viewState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaqViewModel$mapData$2(FaqManagerState faqManagerState, FaqViewModel.ViewState viewState, Continuation<? super FaqViewModel$mapData$2> continuation) {
        super(2, continuation);
        this.$faqState = faqManagerState;
        this.$viewState = viewState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FaqViewModel$mapData$2(this.$faqState, this.$viewState, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        SiteFaq siteFaq = this.$faqState.getSiteFaq();
        SiteInfo siteInfo = siteFaq != null ? siteFaq.getSiteInfo() : null;
        List<SiteInfo> availableSites = this.$faqState.getAvailableSites();
        SiteFaq siteFaq2 = this.$faqState.getSiteFaq();
        List<FaqPopularQuestion> popularQuestions = siteFaq2 != null ? siteFaq2.getPopularQuestions() : null;
        SiteFaq siteFaq3 = this.$faqState.getSiteFaq();
        return this.$viewState.copy(this.$viewState.getIsLoading() && (this.$faqState.getSiteFaq() == null || this.$faqState.getAvailableSites() == null), siteInfo, availableSites, popularQuestions, siteFaq3 != null ? siteFaq3.getSubjects() : null);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FaqViewModel.ViewState> continuation) {
        return ((FaqViewModel$mapData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
