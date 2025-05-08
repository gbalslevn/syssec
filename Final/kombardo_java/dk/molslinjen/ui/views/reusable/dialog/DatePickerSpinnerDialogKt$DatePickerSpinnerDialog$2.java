package dk.molslinjen.ui.views.reusable.dialog;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDate;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DatePickerSpinnerDialogKt$DatePickerSpinnerDialog$2 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ LocalDate $maxDate;
    final /* synthetic */ LocalDate $minDate;
    final /* synthetic */ MutableState<LocalDate> $selectedValue$delegate;
    final /* synthetic */ String $title;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DatePickerSpinnerDialogKt$DatePickerSpinnerDialog$2(String str, LocalDate localDate, LocalDate localDate2, MutableState<LocalDate> mutableState) {
        this.$title = str;
        this.$maxDate = localDate;
        this.$minDate = localDate2;
        this.$selectedValue$delegate = mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.m2183setLiveRegionhR3wRGc(semantics, LiveRegionMode.INSTANCE.m2162getPolite0phEisY());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(MutableState mutableState, LocalDate it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope CustomDialog, Composer composer, int i5) {
        LocalDate DatePickerSpinnerDialog$lambda$1;
        Intrinsics.checkNotNullParameter(CustomDialog, "$this$CustomDialog");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1201054955, i5, -1, "dk.molslinjen.ui.views.reusable.dialog.DatePickerSpinnerDialog.<anonymous> (DatePickerSpinnerDialog.kt:52)");
        }
        TextStyle paragraphBold = TypographyKt.getParagraphBold();
        int m2528getCentere0LSkKk = TextAlign.INSTANCE.m2528getCentere0LSkKk();
        Modifier.Companion companion = Modifier.INSTANCE;
        composer.startReplaceGroup(-188889051);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion2 = Composer.INSTANCE;
        if (rememberedValue == companion2.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.reusable.dialog.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = DatePickerSpinnerDialogKt$DatePickerSpinnerDialog$2.invoke$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        TextKt.m940Text4IGK_g(this.$title, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(m2528getCentere0LSkKk), 0L, 0, false, 0, 0, null, paragraphBold, composer, 0, 1572864, 65020);
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(16)), composer, 6);
        DatePickerSpinnerDialog$lambda$1 = DatePickerSpinnerDialogKt.DatePickerSpinnerDialog$lambda$1(this.$selectedValue$delegate);
        Intrinsics.checkNotNullExpressionValue(DatePickerSpinnerDialog$lambda$1, "access$DatePickerSpinnerDialog$lambda$1(...)");
        LocalDate localDate = this.$maxDate;
        LocalDate localDate2 = this.$minDate;
        composer.startReplaceGroup(-188879883);
        final MutableState<LocalDate> mutableState = this.$selectedValue$delegate;
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion2.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.dialog.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = DatePickerSpinnerDialogKt$DatePickerSpinnerDialog$2.invoke$lambda$3$lambda$2(MutableState.this, (LocalDate) obj);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        DatePickerSpinnerDialogKt.DatePickerSpinner(DatePickerSpinnerDialog$lambda$1, localDate, localDate2, (Function1) rememberedValue2, composer, 3072, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
