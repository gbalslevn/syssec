package dk.molslinjen.ui.views.screens.agreements.multiride.purchase;

import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePurchaseInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class MultiRidePurchaseScreenKt$MultiRidePurchaseScreen$1$1 extends FunctionReferenceImpl implements Function1<MultiRidePurchaseInfo, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiRidePurchaseScreenKt$MultiRidePurchaseScreen$1$1(Object obj) {
        super(1, obj, MultiRidePurchaseViewModel.class, "updateSelectedPurchaseInfo", "updateSelectedPurchaseInfo(Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePurchaseInfo;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MultiRidePurchaseInfo multiRidePurchaseInfo) {
        invoke2(multiRidePurchaseInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MultiRidePurchaseInfo p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((MultiRidePurchaseViewModel) this.receiver).updateSelectedPurchaseInfo(p02);
    }
}
