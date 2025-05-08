package dk.molslinjen.ui.views.screens.profile.permissions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class PermissionsScreenKt$PermissionsScreen$5$4$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PermissionsScreenKt$PermissionsScreen$5$4$1(Object obj) {
        super(1, obj, PermissionsViewModel.class, "onLocationPermissionToggled", "onLocationPermissionToggled(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z5) {
        ((PermissionsViewModel) this.receiver).onLocationPermissionToggled(z5);
    }
}
