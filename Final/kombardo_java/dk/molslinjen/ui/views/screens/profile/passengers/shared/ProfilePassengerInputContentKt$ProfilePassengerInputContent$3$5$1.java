package dk.molslinjen.ui.views.screens.profile.passengers.shared;

import dk.molslinjen.domain.model.account.Gender;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class ProfilePassengerInputContentKt$ProfilePassengerInputContent$3$5$1 extends FunctionReferenceImpl implements Function1<Gender, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfilePassengerInputContentKt$ProfilePassengerInputContent$3$5$1(Object obj) {
        super(1, obj, IPassengerInputHandler.class, "updateGender", "updateGender(Ldk/molslinjen/domain/model/account/Gender;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Gender gender) {
        invoke2(gender);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Gender gender) {
        ((IPassengerInputHandler) this.receiver).updateGender(gender);
    }
}
