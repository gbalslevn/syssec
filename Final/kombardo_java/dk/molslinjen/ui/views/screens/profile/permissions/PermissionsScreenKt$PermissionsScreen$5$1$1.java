package dk.molslinjen.ui.views.screens.profile.permissions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class PermissionsScreenKt$PermissionsScreen$5$1$1 extends FunctionReferenceImpl implements Function2<AppPermission, Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PermissionsScreenKt$PermissionsScreen$5$1$1(Object obj) {
        super(2, obj, PermissionsViewModel.class, "showSettingsDialog", "showSettingsDialog(Ldk/molslinjen/ui/views/screens/profile/permissions/AppPermission;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(AppPermission appPermission, Boolean bool) {
        invoke(appPermission, bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AppPermission p02, boolean z5) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((PermissionsViewModel) this.receiver).showSettingsDialog(p02, z5);
    }
}
