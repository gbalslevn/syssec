package dk.molslinjen.ui.views.screens.agreements;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class AgreementsScreenKt$AgreementsScreen$1$1 extends FunctionReferenceImpl implements Function1<AgreementTab, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AgreementsScreenKt$AgreementsScreen$1$1(Object obj) {
        super(1, obj, AgreementsViewModel.class, "updateSelectedTab", "updateSelectedTab(Ldk/molslinjen/ui/views/screens/agreements/AgreementTab;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AgreementTab agreementTab) {
        invoke2(agreementTab);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AgreementTab p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((AgreementsViewModel) this.receiver).updateSelectedTab(p02);
    }
}
