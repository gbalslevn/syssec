package dk.molslinjen.ui.views.screens.profile.passengers.shared;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class ProfilePassengerInputContentKt$ProfilePassengerInputContent$3$3$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfilePassengerInputContentKt$ProfilePassengerInputContent$3$3$1(Object obj) {
        super(1, obj, IPassengerInputHandler.class, "updateLastName", "updateLastName(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((IPassengerInputHandler) this.receiver).updateLastName(p02);
    }
}
