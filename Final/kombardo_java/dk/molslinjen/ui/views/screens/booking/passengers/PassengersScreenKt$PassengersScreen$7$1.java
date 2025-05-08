package dk.molslinjen.ui.views.screens.booking.passengers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class PassengersScreenKt$PassengersScreen$7$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PassengersScreenKt$PassengersScreen$7$1(Object obj) {
        super(0, obj, PassengersViewModel.class, "showAgeGroupError", "showAgeGroupError()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((PassengersViewModel) this.receiver).showAgeGroupError();
    }
}
