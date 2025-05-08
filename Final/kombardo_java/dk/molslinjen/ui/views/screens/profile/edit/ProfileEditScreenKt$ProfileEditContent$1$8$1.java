package dk.molslinjen.ui.views.screens.profile.edit;

import dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.threeten.bp.LocalDate;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class ProfileEditScreenKt$ProfileEditContent$1$8$1 extends FunctionReferenceImpl implements Function1<LocalDate, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfileEditScreenKt$ProfileEditContent$1$8$1(Object obj) {
        super(1, obj, IUserInfoInputHandler.class, "updateBirthdate", "updateBirthdate(Lorg/threeten/bp/LocalDate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LocalDate localDate) {
        invoke2(localDate);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LocalDate localDate) {
        ((IUserInfoInputHandler) this.receiver).updateBirthdate(localDate);
    }
}
