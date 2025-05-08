package dk.molslinjen.ui.views.screens.agreements.multiride.purchase;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class MultiRideCardPurchaseSummaryScreenKt$MultiRideCardPurchaseSummaryScreen$4$6$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiRideCardPurchaseSummaryScreenKt$MultiRideCardPurchaseSummaryScreen$4$6$1(Object obj) {
        super(1, obj, MultiRidePurchaseSummaryViewModel.class, "onTermsAcceptUpdated", "onTermsAcceptUpdated(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z5) {
        ((MultiRidePurchaseSummaryViewModel) this.receiver).onTermsAcceptUpdated(z5);
    }
}
