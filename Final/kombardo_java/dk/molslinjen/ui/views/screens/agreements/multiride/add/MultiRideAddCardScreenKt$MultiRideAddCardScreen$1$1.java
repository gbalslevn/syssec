package dk.molslinjen.ui.views.screens.agreements.multiride.add;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class MultiRideAddCardScreenKt$MultiRideAddCardScreen$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiRideAddCardScreenKt$MultiRideAddCardScreen$1$1(Object obj) {
        super(0, obj, MultiRideAddCardViewModel.class, "hideErrorDialog", "hideErrorDialog()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((MultiRideAddCardViewModel) this.receiver).hideErrorDialog();
    }
}
