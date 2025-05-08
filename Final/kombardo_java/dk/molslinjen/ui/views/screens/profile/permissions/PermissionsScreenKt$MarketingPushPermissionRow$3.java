package dk.molslinjen.ui.views.screens.profile.permissions;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.ui.views.screens.profile.permissions.rows.MarketingPushNotificationsPermissionRowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class PermissionsScreenKt$MarketingPushPermissionRow$3 implements Function4<Boolean, Function1<? super Boolean, ? extends Unit>, Composer, Integer, Unit> {
    final /* synthetic */ boolean $isMarketingPushNotificationEnabled;
    final /* synthetic */ boolean $isPushNotificationEnabled;
    final /* synthetic */ Function1<Boolean, Unit> $toggleMarketingPushNotifications;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public PermissionsScreenKt$MarketingPushPermissionRow$3(boolean z5, boolean z6, Function1<? super Boolean, Unit> function1) {
        this.$isPushNotificationEnabled = z5;
        this.$isMarketingPushNotificationEnabled = z6;
        this.$toggleMarketingPushNotifications = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(boolean z5, Function1 function1, Function1 function12, boolean z6) {
        if (z5) {
            function1.invoke(Boolean.valueOf(z6));
        } else {
            function1.invoke(Boolean.TRUE);
            function12.invoke(Boolean.FALSE);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Function1<? super Boolean, ? extends Unit> function1, Composer composer, Integer num) {
        invoke(bool.booleanValue(), (Function1<? super Boolean, Unit>) function1, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z5, final Function1<? super Boolean, Unit> onToggle, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(onToggle, "onToggle");
        if ((i5 & 48) == 0) {
            i5 |= composer.changedInstance(onToggle) ? 32 : 16;
        }
        if ((i5 & 145) == 144 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1904727395, i5, -1, "dk.molslinjen.ui.views.screens.profile.permissions.MarketingPushPermissionRow.<anonymous> (PermissionsScreen.kt:151)");
        }
        boolean z6 = this.$isPushNotificationEnabled;
        boolean z7 = this.$isMarketingPushNotificationEnabled;
        composer.startReplaceGroup(258888762);
        boolean changed = ((i5 & 112) == 32) | composer.changed(this.$isPushNotificationEnabled) | composer.changed(this.$toggleMarketingPushNotifications);
        final boolean z8 = this.$isPushNotificationEnabled;
        final Function1<Boolean, Unit> function1 = this.$toggleMarketingPushNotifications;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.permissions.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = PermissionsScreenKt$MarketingPushPermissionRow$3.invoke$lambda$1$lambda$0(z8, function1, onToggle, ((Boolean) obj).booleanValue());
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        MarketingPushNotificationsPermissionRowKt.MarketingPushNotificationPermissionRow(z6, z7, (Function1) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
