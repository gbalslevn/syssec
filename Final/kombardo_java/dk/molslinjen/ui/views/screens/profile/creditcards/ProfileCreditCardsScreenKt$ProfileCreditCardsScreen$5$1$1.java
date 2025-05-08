package dk.molslinjen.ui.views.screens.profile.creditcards;

import dk.molslinjen.domain.model.account.CreditCard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class ProfileCreditCardsScreenKt$ProfileCreditCardsScreen$5$1$1 extends FunctionReferenceImpl implements Function1<CreditCard, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfileCreditCardsScreenKt$ProfileCreditCardsScreen$5$1$1(Object obj) {
        super(1, obj, ProfileCreditCardsViewModel.class, "triggerDeleteFlow", "triggerDeleteFlow(Ldk/molslinjen/domain/model/account/CreditCard;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CreditCard creditCard) {
        invoke2(creditCard);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CreditCard p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((ProfileCreditCardsViewModel) this.receiver).triggerDeleteFlow(p02);
    }
}
