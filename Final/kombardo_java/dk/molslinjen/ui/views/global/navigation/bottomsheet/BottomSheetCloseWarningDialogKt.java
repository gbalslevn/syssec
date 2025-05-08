package dk.molslinjen.ui.views.global.navigation.bottomsheet;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetCloseWarningDialogKt;
import dk.molslinjen.ui.views.reusable.dialog.CustomDialogKt;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a;\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "closeButtonText", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClose", "onCancel", "BottomSheetCloseWarningDialog", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BottomSheetCloseWarningDialogKt {
    public static final void BottomSheetCloseWarningDialog(final String title, final String closeButtonText, final Function0<Unit> onClose, final Function0<Unit> onCancel, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(closeButtonText, "closeButtonText");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Composer startRestartGroup = composer.startRestartGroup(-726109455);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(title) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(closeButtonText) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(onClose) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(onCancel) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-726109455, i6, -1, "dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetCloseWarningDialog (BottomSheetCloseWarningDialog.kt:21)");
            }
            SimpleButtonData simpleButtonData = new SimpleButtonData(closeButtonText, false, false, onClose, 6, null);
            SimpleButtonData simpleButtonData2 = new SimpleButtonData(StringResources_androidKt.stringResource(R.string.button_cancel, startRestartGroup, 6), false, false, onCancel, 6, null);
            startRestartGroup.startReplaceGroup(1333720123);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: S1.a
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
            composer2 = startRestartGroup;
            CustomDialogKt.CustomDialog(null, simpleButtonData, simpleButtonData2, (Function0) rememberedValue, false, ComposableLambdaKt.rememberComposableLambda(1179621868, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetCloseWarningDialogKt$BottomSheetCloseWarningDialog$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope CustomDialog, Composer composer3, int i7) {
                    Intrinsics.checkNotNullParameter(CustomDialog, "$this$CustomDialog");
                    if ((i7 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1179621868, i7, -1, "dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetCloseWarningDialog.<anonymous> (BottomSheetCloseWarningDialog.kt:27)");
                    }
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    int m2528getCentere0LSkKk = TextAlign.INSTANCE.m2528getCentere0LSkKk();
                    TextKt.m940Text4IGK_g(title, fillMaxWidth$default, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(m2528getCentere0LSkKk), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer3, 48, 1572864, 65020);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, 199680, 17);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: S1.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BottomSheetCloseWarningDialog$lambda$2;
                    BottomSheetCloseWarningDialog$lambda$2 = BottomSheetCloseWarningDialogKt.BottomSheetCloseWarningDialog$lambda$2(title, closeButtonText, onClose, onCancel, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return BottomSheetCloseWarningDialog$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetCloseWarningDialog$lambda$2(String str, String str2, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        BottomSheetCloseWarningDialog(str, str2, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
