package dk.molslinjen.ui.views.screens.booking.departures.infoAlert;

import dk.molslinjen.domain.model.info.InfoAlert;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class InfoAlertViewKt$InfoAlertView$1$1 extends FunctionReferenceImpl implements Function1<InfoAlert, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public InfoAlertViewKt$InfoAlertView$1$1(Object obj) {
        super(1, obj, InfoAlertViewModel.class, "setAsShown", "setAsShown(Ldk/molslinjen/domain/model/info/InfoAlert;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InfoAlert infoAlert) {
        invoke2(infoAlert);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InfoAlert p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((InfoAlertViewModel) this.receiver).setAsShown(p02);
    }
}
