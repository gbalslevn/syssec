package dk.molslinjen.ui.views.screens.profile.permissions.rows;

import android.os.Build;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.profile.permissions.AppPermission;
import dk.molslinjen.ui.views.screens.profile.permissions.rows.PushNotificationsPermissionRowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aE\u0010\b\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0005H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {BuildConfig.FLAVOR, "isPushNotificationsEnabled", "Lkotlin/Function1;", BuildConfig.FLAVOR, "toggle", "Lkotlin/Function2;", "Ldk/molslinjen/ui/views/screens/profile/permissions/AppPermission;", "showDialog", "PushNotificationPermissionRow", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PushNotificationsPermissionRowKt {
    public static final void PushNotificationPermissionRow(final boolean z5, final Function1<? super Boolean, Unit> toggle, final Function2<? super AppPermission, ? super Boolean, Unit> showDialog, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(toggle, "toggle");
        Intrinsics.checkNotNullParameter(showDialog, "showDialog");
        Composer startRestartGroup = composer.startRestartGroup(902314433);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(toggle) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(showDialog) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(902314433, i6, -1, "dk.molslinjen.ui.views.screens.profile.permissions.rows.PushNotificationPermissionRow (PushNotificationsPermissionRow.kt:12)");
            }
            int i7 = Build.VERSION.SDK_INT;
            final int i8 = R.string.permission_notification_title;
            final int i9 = R.string.permission_notification_description;
            if (i7 >= 33) {
                startRestartGroup.startReplaceGroup(716252718);
                GenericPermissionRowKt.GenericPermissionRow(showDialog, AppPermission.Notifications, toggle, ComposableLambdaKt.rememberComposableLambda(1693147009, true, new Function4<Boolean, Function1<? super Boolean, ? extends Unit>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.permissions.rows.PushNotificationsPermissionRowKt$PushNotificationPermissionRow$1
                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Function1<? super Boolean, ? extends Unit> function1, Composer composer2, Integer num) {
                        invoke(bool.booleanValue(), (Function1<? super Boolean, Unit>) function1, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z6, Function1<? super Boolean, Unit> onToggle, Composer composer2, int i10) {
                        int i11;
                        Intrinsics.checkNotNullParameter(onToggle, "onToggle");
                        if ((i10 & 6) == 0) {
                            i11 = (composer2.changed(z6) ? 4 : 2) | i10;
                        } else {
                            i11 = i10;
                        }
                        if ((i10 & 48) == 0) {
                            i11 |= composer2.changedInstance(onToggle) ? 32 : 16;
                        }
                        if ((i11 & 147) == 146 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1693147009, i11, -1, "dk.molslinjen.ui.views.screens.profile.permissions.rows.PushNotificationPermissionRow.<anonymous> (PushNotificationsPermissionRow.kt:22)");
                        }
                        int i12 = i11 << 6;
                        BasePermissionRowKt.BasePermissionRow(i8, i9, z6, onToggle, composer2, (i12 & 896) | 54 | (i12 & 7168));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, ((i6 >> 6) & 14) | 3120 | ((i6 << 3) & 896), 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(716709875);
                int i10 = i6 << 6;
                BasePermissionRowKt.BasePermissionRow(R.string.permission_notification_title, R.string.permission_notification_description, z5, toggle, startRestartGroup, (i10 & 896) | 54 | (i10 & 7168));
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: V3.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PushNotificationPermissionRow$lambda$0;
                    PushNotificationPermissionRow$lambda$0 = PushNotificationsPermissionRowKt.PushNotificationPermissionRow$lambda$0(z5, toggle, showDialog, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PushNotificationPermissionRow$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PushNotificationPermissionRow$lambda$0(boolean z5, Function1 function1, Function2 function2, int i5, Composer composer, int i6) {
        PushNotificationPermissionRow(z5, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
