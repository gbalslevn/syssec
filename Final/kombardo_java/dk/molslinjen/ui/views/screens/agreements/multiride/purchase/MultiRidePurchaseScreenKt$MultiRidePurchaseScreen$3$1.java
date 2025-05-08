package dk.molslinjen.ui.views.screens.agreements.multiride.purchase;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class MultiRidePurchaseScreenKt$MultiRidePurchaseScreen$3$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiRidePurchaseScreenKt$MultiRidePurchaseScreen$3$1(Object obj) {
        super(1, obj, MultiRidePurchaseViewModel.class, "updateChargeCount", "updateChargeCount(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i5) {
        ((MultiRidePurchaseViewModel) this.receiver).updateChargeCount(i5);
    }
}
