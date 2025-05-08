package dk.molslinjen.ui.views.screens.booking.shared.expiration;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.reusable.dialog.TextDialogKt;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.ExpirationDialogKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a%\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {BuildConfig.FLAVOR, "showInCheckoutTexts", "Lkotlin/Function0;", BuildConfig.FLAVOR, "popAndReloadDepartures", "ExpirationDialog", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ExpirationDialogKt {
    public static final void ExpirationDialog(final boolean z5, final Function0<Unit> popAndReloadDepartures, Composer composer, final int i5) {
        int i6;
        String stringResource;
        String stringResource2;
        String stringResource3;
        Intrinsics.checkNotNullParameter(popAndReloadDepartures, "popAndReloadDepartures");
        Composer startRestartGroup = composer.startRestartGroup(-918037204);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(popAndReloadDepartures) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-918037204, i6, -1, "dk.molslinjen.ui.views.screens.booking.shared.expiration.ExpirationDialog (ExpirationDialog.kt:10)");
            }
            if (z5) {
                startRestartGroup.startReplaceGroup(608659654);
                stringResource = StringResources_androidKt.stringResource(R.string.checkout_expiration_inCheckout_title, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(608749585);
                stringResource = StringResources_androidKt.stringResource(R.string.checkout_expiration_title, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            if (z5) {
                startRestartGroup.startReplaceGroup(608872128);
                stringResource2 = StringResources_androidKt.stringResource(R.string.checkout_expiration_inCheckout_description, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(608968011);
                stringResource2 = StringResources_androidKt.stringResource(R.string.checkout_expiration_description, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            if (z5) {
                startRestartGroup.startReplaceGroup(609163869);
                stringResource3 = StringResources_androidKt.stringResource(R.string.checkout_expiration_inCheckout_button, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(609262728);
                stringResource3 = StringResources_androidKt.stringResource(R.string.checkout_expiration_button, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            SimpleButtonData simpleButtonData = new SimpleButtonData(stringResource3, false, false, popAndReloadDepartures, 6, null);
            startRestartGroup.startReplaceGroup(1820774249);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: b3.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            TextDialogKt.TextDialog(stringResource, stringResource2, simpleButtonData, null, null, false, (Function0) rememberedValue, startRestartGroup, 1769472, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: b3.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ExpirationDialog$lambda$2;
                    ExpirationDialog$lambda$2 = ExpirationDialogKt.ExpirationDialog$lambda$2(z5, popAndReloadDepartures, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ExpirationDialog$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpirationDialog$lambda$2(boolean z5, Function0 function0, int i5, Composer composer, int i6) {
        ExpirationDialog(z5, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
