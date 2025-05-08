package dk.molslinjen.ui.views.screens.profile.permissions.rows;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import dk.molslinjen.core.Environment;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.profile.permissions.rows.MarketingPushNotificationsPermissionRowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a3\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {BuildConfig.FLAVOR, "isPushNotificationsEnabled", "isMarketingPushNotificationsEnabled", "Lkotlin/Function1;", BuildConfig.FLAVOR, "toggle", "MarketingPushNotificationPermissionRow", "(ZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MarketingPushNotificationsPermissionRowKt {
    public static final void MarketingPushNotificationPermissionRow(final boolean z5, final boolean z6, final Function1<? super Boolean, Unit> toggle, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(toggle, "toggle");
        Composer startRestartGroup = composer.startRestartGroup(-419282583);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(toggle) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-419282583, i6, -1, "dk.molslinjen.ui.views.screens.profile.permissions.rows.MarketingPushNotificationPermissionRow (MarketingPushNotificationsPermissionRow.kt:11)");
            }
            BasePermissionRowKt.BasePermissionRow(R.string.permission_marketing_notification_title, Environment.INSTANCE.isKombardo() ? R.string.permission_marketing_notification_description_KE : R.string.permission_marketing_notification_description_ML, z5 && z6, toggle, startRestartGroup, ((i6 << 3) & 7168) | 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: V3.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MarketingPushNotificationPermissionRow$lambda$0;
                    MarketingPushNotificationPermissionRow$lambda$0 = MarketingPushNotificationsPermissionRowKt.MarketingPushNotificationPermissionRow$lambda$0(z5, z6, toggle, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MarketingPushNotificationPermissionRow$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MarketingPushNotificationPermissionRow$lambda$0(boolean z5, boolean z6, Function1 function1, int i5, Composer composer, int i6) {
        MarketingPushNotificationPermissionRow(z5, z6, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
