package dk.molslinjen.ui.views.screens.saleOnBoard.receipt;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardOrderDetailsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.booking.receipt.ReceiptViewKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.receipt.SaleOnBoardReceiptScreenKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.receipt.SaleOnBoardReceiptViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000bH\u0003¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/receipt/SaleOnBoardReceiptViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "SaleOnBoardReceiptScreen", "(Ldk/molslinjen/ui/views/screens/saleOnBoard/receipt/SaleOnBoardReceiptViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "saleOnBoardCheckoutState", "Lkotlin/Function0;", "dismiss", "Lkotlin/Function1;", BuildConfig.FLAVOR, "showOrder", "SaleOnBoardReceiptContent", "(Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardReceiptScreenKt {
    private static final void SaleOnBoardReceiptContent(final SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, final Function0<Unit> function0, final Function1<? super String, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-231132272);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(saleOnBoardCheckoutState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-231132272, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.receipt.SaleOnBoardReceiptContent (SaleOnBoardReceiptScreen.kt:36)");
            }
            String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_receipt_thanksForYourOrder, startRestartGroup, 6);
            String orderNumber = saleOnBoardCheckoutState.getOrderNumber();
            if (orderNumber == null) {
                orderNumber = "-";
            }
            AnnotatedString annotatedString = new AnnotatedString(StringResources_androidKt.stringResource(R.string.saleOnBoard_receipt_orderNumber, new Object[]{orderNumber}, startRestartGroup, 6), null, null, 6, null);
            startRestartGroup.startReplaceGroup(-821597318);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: k4.k
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
            ReceiptViewKt.ReceiptView(stringResource, annotatedString, null, function0, (Function0) rememberedValue, null, ComposableLambdaKt.rememberComposableLambda(71423004, true, new SaleOnBoardReceiptScreenKt$SaleOnBoardReceiptContent$2(saleOnBoardCheckoutState, function1), startRestartGroup, 54), startRestartGroup, ((i6 << 6) & 7168) | 1794432);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: k4.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardReceiptContent$lambda$6;
                    SaleOnBoardReceiptContent$lambda$6 = SaleOnBoardReceiptScreenKt.SaleOnBoardReceiptContent$lambda$6(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState.this, function0, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardReceiptContent$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardReceiptContent$lambda$6(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, Function0 function0, Function1 function1, int i5, Composer composer, int i6) {
        SaleOnBoardReceiptContent(saleOnBoardCheckoutState, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void SaleOnBoardReceiptScreen(final SaleOnBoardReceiptViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(1849098477);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1849098477, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.receipt.SaleOnBoardReceiptScreen (SaleOnBoardReceiptScreen.kt:19)");
            }
            SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState = (SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState) SnapshotStateKt.collectAsState(viewModel.getSaleOnBoardCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(-1256227036);
            int i7 = i6 & 112;
            boolean z5 = i7 == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SaleOnBoardReceiptScreenKt$SaleOnBoardReceiptScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1256225493);
            boolean z6 = i7 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: k4.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SaleOnBoardReceiptScreen$lambda$2$lambda$1;
                        SaleOnBoardReceiptScreen$lambda$2$lambda$1 = SaleOnBoardReceiptScreenKt.SaleOnBoardReceiptScreen$lambda$2$lambda$1(DestinationsNavigator.this, (String) obj);
                        return SaleOnBoardReceiptScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            SaleOnBoardReceiptContent(saleOnBoardCheckoutState, function0, (Function1) rememberedValue2, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: k4.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardReceiptScreen$lambda$3;
                    SaleOnBoardReceiptScreen$lambda$3 = SaleOnBoardReceiptScreenKt.SaleOnBoardReceiptScreen$lambda$3(SaleOnBoardReceiptViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardReceiptScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardReceiptScreen$lambda$2$lambda$1(DestinationsNavigator destinationsNavigator, String orderNumber) {
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SaleOnBoardOrderDetailsScreenDestination.INSTANCE.invoke(orderNumber), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardReceiptScreen$lambda$3(SaleOnBoardReceiptViewModel saleOnBoardReceiptViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        SaleOnBoardReceiptScreen(saleOnBoardReceiptViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
