package dk.molslinjen.ui.views.screens.booking.simpleChange;

import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.payment.PaymentType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class SimpleChangeSummaryScreenKt$SimpleChangeSummaryScreen$2$1$1 extends FunctionReferenceImpl implements Function2<PaymentType, CreditCard, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleChangeSummaryScreenKt$SimpleChangeSummaryScreen$2$1$1(Object obj) {
        super(2, obj, SimpleChangeSummaryViewModel.class, "paymentMethodSelected", "paymentMethodSelected(Ldk/molslinjen/domain/model/payment/PaymentType;Ldk/molslinjen/domain/model/account/CreditCard;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(PaymentType paymentType, CreditCard creditCard) {
        invoke2(paymentType, creditCard);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PaymentType p02, CreditCard creditCard) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((SimpleChangeSummaryViewModel) this.receiver).paymentMethodSelected(p02, creditCard);
    }
}
