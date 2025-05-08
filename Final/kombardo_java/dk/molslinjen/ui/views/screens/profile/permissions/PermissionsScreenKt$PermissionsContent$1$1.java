package dk.molslinjen.ui.views.screens.profile.permissions;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.profile.permissions.rows.BasePermissionRowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class PermissionsScreenKt$PermissionsContent$1$1 implements Function4<Boolean, Function1<? super Boolean, ? extends Unit>, Composer, Integer, Unit> {
    final /* synthetic */ int $locationDescriptionRes;
    final /* synthetic */ Function1<Boolean, Unit> $onLocationPermissionToggled;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public PermissionsScreenKt$PermissionsContent$1$1(int i5, Function1<? super Boolean, Unit> function1) {
        this.$locationDescriptionRes = i5;
        this.$onLocationPermissionToggled = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function1 function1, Function1 function12, boolean z5) {
        function1.invoke(Boolean.valueOf(z5));
        function12.invoke(Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Function1<? super Boolean, ? extends Unit> function1, Composer composer, Integer num) {
        invoke(bool.booleanValue(), (Function1<? super Boolean, Unit>) function1, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z5, final Function1<? super Boolean, Unit> onToggle, Composer composer, int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(onToggle, "onToggle");
        if ((i5 & 6) == 0) {
            i6 = (composer.changed(z5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= composer.changedInstance(onToggle) ? 32 : 16;
        }
        if ((i6 & 147) == 146 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-419288193, i6, -1, "dk.molslinjen.ui.views.screens.profile.permissions.PermissionsContent.<anonymous>.<anonymous> (PermissionsScreen.kt:117)");
        }
        int i7 = this.$locationDescriptionRes;
        composer.startReplaceGroup(-21996357);
        boolean changed = ((i6 & 112) == 32) | composer.changed(this.$onLocationPermissionToggled);
        final Function1<Boolean, Unit> function1 = this.$onLocationPermissionToggled;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.permissions.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = PermissionsScreenKt$PermissionsContent$1$1.invoke$lambda$1$lambda$0(Function1.this, function1, ((Boolean) obj).booleanValue());
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        BasePermissionRowKt.BasePermissionRow(R.string.permission_location_title, i7, z5, (Function1) rememberedValue, composer, ((i6 << 6) & 896) | 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
