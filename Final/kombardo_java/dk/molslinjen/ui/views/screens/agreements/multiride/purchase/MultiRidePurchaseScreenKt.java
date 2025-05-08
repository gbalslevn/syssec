package dk.molslinjen.ui.views.screens.agreements.multiride.purchase;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.generated.destinations.MultiRideCardPurchaseSummaryScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePriceStep;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePurchaseInfo;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseScreenKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aw\u0010\u0015\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001ac\u0010\u0019\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0003¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "MultiRidePurchaseScreen", "(Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager$CheckoutState;", "checkoutState", "Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseViewModel$ViewState;", "viewState", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePurchaseInfo;", "onPurchaseInfoSelected", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;", "onPriceStepSelected", BuildConfig.FLAVOR, "onChargeCountUpdated", "Lkotlin/Function0;", "dismiss", "proceed", "MultiRidePurchaseContent", "(Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager$CheckoutState;Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseViewModel$ViewState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/ScrollState;", "scrollState", "Content", "(Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseViewModel$ViewState;Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager$CheckoutState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "termString", "TermsLine", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MultiRidePurchaseScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Content(final MultiRidePurchaseViewModel.ViewState viewState, final IMultiRideCardCheckoutManager.CheckoutState checkoutState, final Function1<? super MultiRidePurchaseInfo, Unit> function1, final Function1<? super MultiRidePriceStep, Unit> function12, final Function1<? super Integer, Unit> function13, final ScrollState scrollState, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-75712119);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(checkoutState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function13) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(scrollState) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-75712119, i6, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.Content (MultiRidePurchaseScreen.kt:124)");
            }
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, viewState.getIsLoading(), 0, false, null, ComposableLambdaKt.rememberComposableLambda(2039004605, true, new MultiRidePurchaseScreenKt$Content$1(scrollState, checkoutState, function1, function12, function13), startRestartGroup, 54), startRestartGroup, 1572870, 58);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: B2.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$9;
                    Content$lambda$9 = MultiRidePurchaseScreenKt.Content$lambda$9(MultiRidePurchaseViewModel.ViewState.this, checkoutState, function1, function12, function13, scrollState, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$9(MultiRidePurchaseViewModel.ViewState viewState, IMultiRideCardCheckoutManager.CheckoutState checkoutState, Function1 function1, Function1 function12, Function1 function13, ScrollState scrollState, int i5, Composer composer, int i6) {
        Content(viewState, checkoutState, function1, function12, function13, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void MultiRidePurchaseContent(final IMultiRideCardCheckoutManager.CheckoutState checkoutState, final MultiRidePurchaseViewModel.ViewState viewState, final Function1<? super MultiRidePurchaseInfo, Unit> function1, final Function1<? super MultiRidePriceStep, Unit> function12, final Function1<? super Integer, Unit> function13, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(79488691);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(checkoutState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(viewState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function13) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 1048576 : 524288;
        }
        int i7 = i6;
        if ((599187 & i7) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(79488691, i7, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseContent (MultiRidePurchaseScreen.kt:86)");
            }
            final ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            final boolean z5 = checkoutState.getNumberOfCharges() > 0;
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, StringResources_androidKt.stringResource(R.string.multiRide_purchase_title, startRestartGroup, 6), null, 0L, null, function0, rememberScrollState, ComposableLambdaKt.rememberComposableLambda(371857777, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseScreenKt$MultiRidePurchaseContent$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i8) {
                    if ((i8 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(371857777, i8, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseContent.<anonymous> (MultiRidePurchaseScreen.kt:97)");
                    }
                    BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(StringResources_androidKt.stringResource(R.string.button_continue, composer3, 6), IMultiRideCardCheckoutManager.CheckoutState.this.getTotalPrice(), z5, false, false, 0L, null, function02, composer3, 0, 120);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1236820160, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseScreenKt$MultiRidePurchaseContent$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i8) {
                    Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                    if ((i8 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1236820160, i8, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseContent.<anonymous> (MultiRidePurchaseScreen.kt:105)");
                    }
                    MultiRidePurchaseScreenKt.Content(MultiRidePurchaseViewModel.ViewState.this, checkoutState, function1, function12, function13, rememberScrollState, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, ((i7 << 3) & 3670016) | 905969670, 58);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: B2.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MultiRidePurchaseContent$lambda$8;
                    MultiRidePurchaseContent$lambda$8 = MultiRidePurchaseScreenKt.MultiRidePurchaseContent$lambda$8(IMultiRideCardCheckoutManager.CheckoutState.this, viewState, function1, function12, function13, function0, function02, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MultiRidePurchaseContent$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRidePurchaseContent$lambda$8(IMultiRideCardCheckoutManager.CheckoutState checkoutState, MultiRidePurchaseViewModel.ViewState viewState, Function1 function1, Function1 function12, Function1 function13, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        MultiRidePurchaseContent(checkoutState, viewState, function1, function12, function13, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void MultiRidePurchaseScreen(final MultiRidePurchaseViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(1296319340);
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
                ComposerKt.traceEventStart(1296319340, i6, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseScreen (MultiRidePurchaseScreen.kt:62)");
            }
            IMultiRideCardCheckoutManager.CheckoutState checkoutState = (IMultiRideCardCheckoutManager.CheckoutState) SnapshotStateKt.collectAsState(viewModel.getCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            MultiRidePurchaseViewModel.ViewState viewState = (MultiRidePurchaseViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(-39681741);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MultiRidePurchaseScreenKt$MultiRidePurchaseScreen$1$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue);
            startRestartGroup.startReplaceGroup(-39679536);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new MultiRidePurchaseScreenKt$MultiRidePurchaseScreen$2$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function12 = (Function1) ((KFunction) rememberedValue2);
            startRestartGroup.startReplaceGroup(-39677398);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new MultiRidePurchaseScreenKt$MultiRidePurchaseScreen$3$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function13 = (Function1) ((KFunction) rememberedValue3);
            startRestartGroup.startReplaceGroup(-39675867);
            int i7 = i6 & 112;
            boolean z5 = i7 == 32;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new MultiRidePurchaseScreenKt$MultiRidePurchaseScreen$4$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function0 function0 = (Function0) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-39674423);
            boolean changedInstance4 = startRestartGroup.changedInstance(viewModel) | (i7 == 32);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: B2.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MultiRidePurchaseScreen$lambda$6$lambda$5;
                        MultiRidePurchaseScreen$lambda$6$lambda$5 = MultiRidePurchaseScreenKt.MultiRidePurchaseScreen$lambda$6$lambda$5(MultiRidePurchaseViewModel.this, navigator);
                        return MultiRidePurchaseScreen$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            MultiRidePurchaseContent(checkoutState, viewState, function1, function12, function13, function0, (Function0) rememberedValue5, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: B2.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MultiRidePurchaseScreen$lambda$7;
                    MultiRidePurchaseScreen$lambda$7 = MultiRidePurchaseScreenKt.MultiRidePurchaseScreen$lambda$7(MultiRidePurchaseViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MultiRidePurchaseScreen$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRidePurchaseScreen$lambda$6$lambda$5(MultiRidePurchaseViewModel multiRidePurchaseViewModel, final DestinationsNavigator destinationsNavigator) {
        multiRidePurchaseViewModel.proceed(new Function0() { // from class: B2.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit MultiRidePurchaseScreen$lambda$6$lambda$5$lambda$4;
                MultiRidePurchaseScreen$lambda$6$lambda$5$lambda$4 = MultiRidePurchaseScreenKt.MultiRidePurchaseScreen$lambda$6$lambda$5$lambda$4(DestinationsNavigator.this);
                return MultiRidePurchaseScreen$lambda$6$lambda$5$lambda$4;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRidePurchaseScreen$lambda$6$lambda$5$lambda$4(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, MultiRideCardPurchaseSummaryScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRidePurchaseScreen$lambda$7(MultiRidePurchaseViewModel multiRidePurchaseViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        MultiRidePurchaseScreen(multiRidePurchaseViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TermsLine(final String str, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-277885912);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-277885912, i6, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.TermsLine (MultiRidePurchaseScreen.kt:181)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_checkmark_circle, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(16)), AppColor.INSTANCE.m3266getGrey30d7_KjU(), startRestartGroup, 3456, 0);
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(8)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(str, RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, i6 & 14, 1572864, 65532);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: B2.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TermsLine$lambda$11;
                    TermsLine$lambda$11 = MultiRidePurchaseScreenKt.TermsLine$lambda$11(str, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TermsLine$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TermsLine$lambda$11(String str, int i5, Composer composer, int i6) {
        TermsLine(str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
