package dk.molslinjen.ui.views.screens.profile.authentication.register;

import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class SignupScreenKt$SignupContent$3$3$1 extends FunctionReferenceImpl implements Function1<Gender, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SignupScreenKt$SignupContent$3$3$1(Object obj) {
        super(1, obj, IUserInfoInputHandler.class, "updateGender", "updateGender(Ldk/molslinjen/domain/model/account/Gender;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Gender gender) {
        invoke2(gender);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Gender gender) {
        ((IUserInfoInputHandler) this.receiver).updateGender(gender);
    }
}
