package dk.molslinjen.ui.views.screens.tickets.addExisting;

import dk.molslinjen.domain.model.shared.PhoneNumber;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class AddExistingTicketScreenKt$AddExistingTicketScreen$3$1$1 extends FunctionReferenceImpl implements Function1<PhoneNumber, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AddExistingTicketScreenKt$AddExistingTicketScreen$3$1$1(Object obj) {
        super(1, obj, AddExistingTicketViewModel.class, "onPhoneNumberChange", "onPhoneNumberChange(Ldk/molslinjen/domain/model/shared/PhoneNumber;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PhoneNumber phoneNumber) {
        invoke2(phoneNumber);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PhoneNumber p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((AddExistingTicketViewModel) this.receiver).onPhoneNumberChange(p02);
    }
}
