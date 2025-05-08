package dk.molslinjen.ui.views.screens.profile.passengers.shared;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.InitialsViewKt;
import dk.molslinjen.ui.views.reusable.InitialsViewSize;
import dk.molslinjen.ui.views.reusable.dialog.CustomDialogKt;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.ProfilePassengerDeleteDialogKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a;\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/account/UserPassenger;", "passenger", BuildConfig.FLAVOR, "isLoading", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onDelete", "onDismiss", "ProfilePassengerDeleteDialog", "(Ldk/molslinjen/domain/model/account/UserPassenger;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfilePassengerDeleteDialogKt {
    public static final void ProfilePassengerDeleteDialog(final UserPassenger passenger, final boolean z5, final Function0<Unit> onDelete, final Function0<Unit> onDismiss, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(passenger, "passenger");
        Intrinsics.checkNotNullParameter(onDelete, "onDelete");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(-1641945519);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(passenger) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(onDelete) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(onDismiss) ? 2048 : 1024;
        }
        int i7 = i6;
        if ((i7 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1641945519, i7, -1, "dk.molslinjen.ui.views.screens.profile.passengers.shared.ProfilePassengerDeleteDialog (ProfilePassengerDeleteDialog.kt:26)");
            }
            composer2 = startRestartGroup;
            CustomDialogKt.CustomDialog(null, new SimpleButtonData(StringResources_androidKt.stringResource(R.string.button_delete, startRestartGroup, 6), z5, false, onDelete, 4, null), new SimpleButtonData(StringResources_androidKt.stringResource(R.string.button_cancel, startRestartGroup, 6), false, !z5, onDismiss, 2, null), onDismiss, false, ComposableLambdaKt.rememberComposableLambda(767348620, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.passengers.shared.ProfilePassengerDeleteDialogKt$ProfilePassengerDeleteDialog$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope CustomDialog, Composer composer3, int i8) {
                    Intrinsics.checkNotNullParameter(CustomDialog, "$this$CustomDialog");
                    if ((i8 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(767348620, i8, -1, "dk.molslinjen.ui.views.screens.profile.passengers.shared.ProfilePassengerDeleteDialog.<anonymous> (ProfilePassengerDeleteDialog.kt:40)");
                    }
                    InitialsViewKt.m3389InitialsViewgPmlwdY(null, InitialsViewSize.Medium, null, null, UserPassenger.this.getInitials(), false, false, false, composer3, 48, 237);
                    Modifier.Companion companion = Modifier.INSTANCE;
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(8)), composer3, 6);
                    String fullName = UserPassenger.this.getFullName();
                    TextStyle paragraphSmall = TypographyKt.getParagraphSmall();
                    TextAlign.Companion companion2 = TextAlign.INSTANCE;
                    TextKt.m940Text4IGK_g(fullName, null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion2.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraphSmall, composer3, 0, 1572864, 65022);
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(24)), composer3, 6);
                    TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_passenger_deleteDialog_title, composer3, 6), null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion2.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer3, 0, 1572864, 65022);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, (i7 & 7168) | 196608, 17);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: T3.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfilePassengerDeleteDialog$lambda$0;
                    ProfilePassengerDeleteDialog$lambda$0 = ProfilePassengerDeleteDialogKt.ProfilePassengerDeleteDialog$lambda$0(UserPassenger.this, z5, onDelete, onDismiss, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfilePassengerDeleteDialog$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfilePassengerDeleteDialog$lambda$0(UserPassenger userPassenger, boolean z5, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        ProfilePassengerDeleteDialog(userPassenger, z5, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
