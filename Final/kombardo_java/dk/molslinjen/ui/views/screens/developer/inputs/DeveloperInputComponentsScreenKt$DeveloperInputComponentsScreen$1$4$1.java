package dk.molslinjen.ui.views.screens.developer.inputs;

import dk.molslinjen.core.snackbar.SnackbarEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class DeveloperInputComponentsScreenKt$DeveloperInputComponentsScreen$1$4$1 extends FunctionReferenceImpl implements Function1<SnackbarEvent, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DeveloperInputComponentsScreenKt$DeveloperInputComponentsScreen$1$4$1(Object obj) {
        super(1, obj, DeveloperInputComponentsViewModel.class, "showSnackbar", "showSnackbar(Ldk/molslinjen/core/snackbar/SnackbarEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SnackbarEvent snackbarEvent) {
        invoke2(snackbarEvent);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SnackbarEvent p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((DeveloperInputComponentsViewModel) this.receiver).showSnackbar(p02);
    }
}
