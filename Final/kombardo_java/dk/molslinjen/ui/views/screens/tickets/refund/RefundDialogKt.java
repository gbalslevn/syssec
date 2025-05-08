package dk.molslinjen.ui.views.screens.tickets.refund;

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
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.dialog.CustomDialogKt;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.screens.tickets.refund.RefundDialogKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001aK\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "refundAmount", "handlingFee", BuildConfig.FLAVOR, "hasSaleOnBoardOrderForThisBooking", "isLoading", "Lkotlin/Function0;", BuildConfig.FLAVOR, "refund", "dismiss", "RefundDialog", "(Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class RefundDialogKt {
    public static final void RefundDialog(final PriceWithCurrency refundAmount, final PriceWithCurrency handlingFee, final boolean z5, final boolean z6, final Function0<Unit> refund, final Function0<Unit> dismiss, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(refundAmount, "refundAmount");
        Intrinsics.checkNotNullParameter(handlingFee, "handlingFee");
        Intrinsics.checkNotNullParameter(refund, "refund");
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        Composer startRestartGroup = composer.startRestartGroup(968631870);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(refundAmount) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(handlingFee) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(refund) ? 16384 : 8192;
        }
        if ((i5 & 196608) == 0) {
            i6 |= startRestartGroup.changedInstance(dismiss) ? 131072 : 65536;
        }
        int i7 = i6;
        if ((74899 & i7) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(968631870, i7, -1, "dk.molslinjen.ui.views.screens.tickets.refund.RefundDialog (RefundDialog.kt:28)");
            }
            composer2 = startRestartGroup;
            CustomDialogKt.CustomDialog(null, new SimpleButtonData(StringResources_androidKt.stringResource(R.string.refund_refundButton, startRestartGroup, 6), z6, false, refund, 4, null), new SimpleButtonData(StringResources_androidKt.stringResource(R.string.button_cancel, startRestartGroup, 6), false, !z6, dismiss, 2, null), dismiss, false, ComposableLambdaKt.rememberComposableLambda(-2020091613, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.refund.RefundDialogKt$RefundDialog$1
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
                        ComposerKt.traceEventStart(-2020091613, i8, -1, "dk.molslinjen.ui.views.screens.tickets.refund.RefundDialog.<anonymous> (RefundDialog.kt:42)");
                    }
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                    String stringResource = StringResources_androidKt.stringResource(R.string.refund_title, composer3, 6);
                    TextStyle paragraphBold = TypographyKt.getParagraphBold();
                    TextAlign.Companion companion2 = TextAlign.INSTANCE;
                    TextKt.m940Text4IGK_g(stringResource, fillMaxWidth$default, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion2.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraphBold, composer3, 48, 1572864, 65020);
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(16)), composer3, 6);
                    TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.refund_description, composer3, 6), SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion2.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer3, 48, 1572864, 65020);
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(24)), composer3, 6);
                    RefundAmountsViewKt.RefundAmountsView(PriceWithCurrency.this, handlingFee, false, composer3, 0, 4);
                    if (z5) {
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(12)), composer3, 6);
                        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.refund_foodOrderWillAlsoBeCancelled, composer3, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer3, 0, 1572864, 65534);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, ((i7 >> 6) & 7168) | 196608, 17);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: u4.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RefundDialog$lambda$0;
                    RefundDialog$lambda$0 = RefundDialogKt.RefundDialog$lambda$0(PriceWithCurrency.this, handlingFee, z5, z6, refund, dismiss, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return RefundDialog$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RefundDialog$lambda$0(PriceWithCurrency priceWithCurrency, PriceWithCurrency priceWithCurrency2, boolean z5, boolean z6, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        RefundDialog(priceWithCurrency, priceWithCurrency2, z5, z6, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
