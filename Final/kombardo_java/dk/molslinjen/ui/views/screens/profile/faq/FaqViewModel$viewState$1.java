package dk.molslinjen.ui.views.screens.profile.faq;

import dk.molslinjen.domain.managers.faq.FaqManagerState;
import dk.molslinjen.ui.views.screens.profile.faq.FaqViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class FaqViewModel$viewState$1 extends FunctionReferenceImpl implements Function3<FaqViewModel.ViewState, FaqManagerState, Continuation<? super FaqViewModel.ViewState>, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FaqViewModel$viewState$1(Object obj) {
        super(3, obj, FaqViewModel.class, "mapData", "mapData(Ldk/molslinjen/ui/views/screens/profile/faq/FaqViewModel$ViewState;Ldk/molslinjen/domain/managers/faq/FaqManagerState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FaqViewModel.ViewState viewState, FaqManagerState faqManagerState, Continuation<? super FaqViewModel.ViewState> continuation) {
        Object mapData;
        mapData = ((FaqViewModel) this.receiver).mapData(viewState, faqManagerState, continuation);
        return mapData;
    }
}
