package dk.molslinjen.ui.views.screens.agreements.multiride.purchase;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideSummaryCardKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseReceiptScreenKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseReceiptViewModel;
import dk.molslinjen.ui.views.screens.booking.receipt.ReceiptViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0003¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseReceiptViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "MultiRidePurchaseReceiptScreen", "(Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseReceiptViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager$CheckoutState;", "checkoutState", "Lkotlin/Function0;", "showMultiRideCards", "ReceiptContent", "(Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager$CheckoutState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MultiRidePurchaseReceiptScreenKt {
    public static final void MultiRidePurchaseReceiptScreen(final MultiRidePurchaseReceiptViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-1756808890);
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
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1756808890, i6, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseReceiptScreen (MultiRidePurchaseReceiptScreen.kt:32)");
            }
            final IMultiRideCardCheckoutManager.CheckoutState checkoutState = (IMultiRideCardCheckoutManager.CheckoutState) SnapshotStateKt.collectAsState(viewModel.getCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            AppColor appColor = AppColor.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(fillMaxSize$default, appColor.m3269getGrey60d7_KjU(), null, 2, null);
            long m3269getGrey60d7_KjU = appColor.m3269getGrey60d7_KjU();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(667085593, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseReceiptScreenKt$MultiRidePurchaseReceiptScreen$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i7) {
                    Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                    if ((i7 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(667085593, i7, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseReceiptScreen.<anonymous> (MultiRidePurchaseReceiptScreen.kt:42)");
                    }
                    IMultiRideCardCheckoutManager.CheckoutState checkoutState2 = IMultiRideCardCheckoutManager.CheckoutState.this;
                    DestinationsNavigator destinationsNavigator = navigator;
                    composer3.startReplaceGroup(594054968);
                    boolean changed = composer3.changed(destinationsNavigator);
                    Object rememberedValue = composer3.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new MultiRidePurchaseReceiptScreenKt$MultiRidePurchaseReceiptScreen$1$1$1(destinationsNavigator);
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceGroup();
                    MultiRidePurchaseReceiptScreenKt.ReceiptContent(checkoutState2, (Function0) rememberedValue, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(m104backgroundbw27NRU$default, 0.0f, null, null, m3269getGrey60d7_KjU, null, null, null, null, rememberComposableLambda, startRestartGroup, 805331334, 490);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: B2.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MultiRidePurchaseReceiptScreen$lambda$0;
                    MultiRidePurchaseReceiptScreen$lambda$0 = MultiRidePurchaseReceiptScreenKt.MultiRidePurchaseReceiptScreen$lambda$0(MultiRidePurchaseReceiptViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MultiRidePurchaseReceiptScreen$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRidePurchaseReceiptScreen$lambda$0(MultiRidePurchaseReceiptViewModel multiRidePurchaseReceiptViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        MultiRidePurchaseReceiptScreen(multiRidePurchaseReceiptViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReceiptContent(final IMultiRideCardCheckoutManager.CheckoutState checkoutState, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1953550012);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(checkoutState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1953550012, i6, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.ReceiptContent (MultiRidePurchaseReceiptScreen.kt:50)");
            }
            ReceiptViewKt.ReceiptView(StringResources_androidKt.stringResource(R.string.receipt_thanksForYourOrder, startRestartGroup, 6), ReceiptViewKt.buildReceiptDescription(R.string.multiride_purchase_receipt_description, checkoutState.getPersonalInfo().getEmail(), startRestartGroup, 6), StringResources_androidKt.stringResource(R.string.multiride_purchase_receipt_showMultiRideCards, startRestartGroup, 6), function0, function0, ComposableSingletons$MultiRidePurchaseReceiptScreenKt.INSTANCE.m3437getLambda1$app_kombardoProd(), ComposableLambdaKt.rememberComposableLambda(-568170032, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseReceiptScreenKt$ReceiptContent$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    if ((i7 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-568170032, i7, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.ReceiptContent.<anonymous> (MultiRidePurchaseReceiptScreen.kt:59)");
                    }
                    MultiRideSummaryCardKt.MultiRideSummaryCard(IMultiRideCardCheckoutManager.CheckoutState.this.getSummaryCardInfo(), true, composer2, 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ((i6 << 6) & 7168) | 1769472 | ((i6 << 9) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: B2.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ReceiptContent$lambda$1;
                    ReceiptContent$lambda$1 = MultiRidePurchaseReceiptScreenKt.ReceiptContent$lambda$1(IMultiRideCardCheckoutManager.CheckoutState.this, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ReceiptContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptContent$lambda$1(IMultiRideCardCheckoutManager.CheckoutState checkoutState, Function0 function0, int i5, Composer composer, int i6) {
        ReceiptContent(checkoutState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
