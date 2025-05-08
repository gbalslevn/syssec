package dk.molslinjen.ui.views.screens.main.push;

import dk.molslinjen.domain.model.push.PushMessage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class PushDialogViewKt$PushDialogView$1$1 extends FunctionReferenceImpl implements Function1<PushMessage, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PushDialogViewKt$PushDialogView$1$1(Object obj) {
        super(1, obj, PushDialogViewModel.class, "setAsShown", "setAsShown(Ldk/molslinjen/domain/model/push/PushMessage;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PushMessage pushMessage) {
        invoke2(pushMessage);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PushMessage p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((PushDialogViewModel) this.receiver).setAsShown(p02);
    }
}
