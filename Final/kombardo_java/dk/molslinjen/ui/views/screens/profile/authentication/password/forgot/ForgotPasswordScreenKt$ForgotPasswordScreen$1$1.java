package dk.molslinjen.ui.views.screens.profile.authentication.password.forgot;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class ForgotPasswordScreenKt$ForgotPasswordScreen$1$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ForgotPasswordScreenKt$ForgotPasswordScreen$1$1(Object obj) {
        super(1, obj, ForgotPasswordViewModel.class, "updateEmail", "updateEmail(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((ForgotPasswordViewModel) this.receiver).updateEmail(p02);
    }
}
