package dk.molslinjen.ui.views.screens.agreements.multiride.purchase;

import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePriceStep;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class MultiRidePurchaseScreenKt$MultiRidePurchaseScreen$2$1 extends FunctionReferenceImpl implements Function1<MultiRidePriceStep, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiRidePurchaseScreenKt$MultiRidePurchaseScreen$2$1(Object obj) {
        super(1, obj, MultiRidePurchaseViewModel.class, "updateSelectedPriceStep", "updateSelectedPriceStep(Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MultiRidePriceStep multiRidePriceStep) {
        invoke2(multiRidePriceStep);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MultiRidePriceStep p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((MultiRidePurchaseViewModel) this.receiver).updateSelectedPriceStep(p02);
    }
}
