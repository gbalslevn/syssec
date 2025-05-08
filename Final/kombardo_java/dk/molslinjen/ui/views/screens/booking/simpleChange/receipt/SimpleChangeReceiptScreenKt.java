package dk.molslinjen.ui.views.screens.booking.simpleChange.receipt;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.booking.receipt.ReceiptViewKt;
import dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeTicketSummaryViewKt;
import dk.molslinjen.ui.views.screens.booking.simpleChange.receipt.SimpleChangeReceiptScreenKt;
import dk.molslinjen.ui.views.screens.booking.simpleChange.receipt.SimpleChangeReceiptViewModel;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a%\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a%\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0003¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/simpleChange/receipt/SimpleChangeReceiptViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", BuildConfig.FLAVOR, "resultNavigator", BuildConfig.FLAVOR, "SimpleChangeReceiptScreen", "(Ldk/molslinjen/ui/views/screens/booking/simpleChange/receipt/SimpleChangeReceiptViewModel;Lcom/ramcosta/composedestinations/result/ResultBackNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager$SimpleChangeCheckoutState;", "simpleChangeCheckoutState", "Lkotlin/Function0;", "showTicket", "SimpleChangeReceiptContent", "(Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager$SimpleChangeCheckoutState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "isWalking", "EarlyCheckInBanner", "(ZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SimpleChangeReceiptScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void EarlyCheckInBanner(final boolean z5, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1708493386);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1708493386, i6, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.receipt.EarlyCheckInBanner (SimpleChangeReceiptScreen.kt:78)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            AppColor appColor = AppColor.INSTANCE;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(fillMaxWidth$default, appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(24));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.earlyCheckIn_receipt_checkedIn, startRestartGroup, 6), null, appColor.m3254getBrandBlack20d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), startRestartGroup, 384, 1572864, 65530);
            startRestartGroup.startReplaceGroup(-548693226);
            if (z5) {
                composer2 = startRestartGroup;
            } else {
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(8)), startRestartGroup, 6);
                String stringResource = StringResources_androidKt.stringResource(R.string.earlyCheckIn_receipt_details, startRestartGroup, 6);
                TextStyle paragraphSmall = TypographyKt.getParagraphSmall();
                long m3254getBrandBlack20d7_KjU = appColor.m3254getBrandBlack20d7_KjU();
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(stringResource, null, m3254getBrandBlack20d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, paragraphSmall, composer2, 384, 1572864, 65530);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: g3.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit EarlyCheckInBanner$lambda$6;
                    EarlyCheckInBanner$lambda$6 = SimpleChangeReceiptScreenKt.EarlyCheckInBanner$lambda$6(z5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return EarlyCheckInBanner$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInBanner$lambda$6(boolean z5, int i5, Composer composer, int i6) {
        EarlyCheckInBanner(z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SimpleChangeReceiptContent(final SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-637296836);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(simpleChangeCheckoutState) ? 4 : 2) | i5;
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
                ComposerKt.traceEventStart(-637296836, i6, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.receipt.SimpleChangeReceiptContent (SimpleChangeReceiptScreen.kt:43)");
            }
            final Booking existingBooking = simpleChangeCheckoutState.getExistingBooking();
            if (existingBooking == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: g3.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SimpleChangeReceiptContent$lambda$2;
                            SimpleChangeReceiptContent$lambda$2 = SimpleChangeReceiptScreenKt.SimpleChangeReceiptContent$lambda$2(SimpleChangeCheckoutManager.SimpleChangeCheckoutState.this, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return SimpleChangeReceiptContent$lambda$2;
                        }
                    });
                    return;
                }
                return;
            }
            AnnotatedString buildReceiptDescription = ReceiptViewKt.buildReceiptDescription(R.string.receipt_simpleChange_orderCompletedDescription, existingBooking.getCustomerInfo().getEmail(), startRestartGroup, 6);
            final PriceWithCurrency totalPrice = simpleChangeCheckoutState.getTotalPrice();
            if (totalPrice == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
                if (endRestartGroup2 != null) {
                    endRestartGroup2.updateScope(new Function2() { // from class: g3.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SimpleChangeReceiptContent$lambda$3;
                            SimpleChangeReceiptContent$lambda$3 = SimpleChangeReceiptScreenKt.SimpleChangeReceiptContent$lambda$3(SimpleChangeCheckoutManager.SimpleChangeCheckoutState.this, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return SimpleChangeReceiptContent$lambda$3;
                        }
                    });
                    return;
                }
                return;
            }
            String stringResource = StringResources_androidKt.stringResource(!simpleChangeCheckoutState.getAddons().isEmpty() ? R.string.receipt_simpleChange_addonsTitle : R.string.receipt_simpleChange_foodTitle, startRestartGroup, 0);
            String stringResource2 = StringResources_androidKt.stringResource(R.string.receipt_showTicket, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(1767133563);
            ComposableLambda rememberComposableLambda = Intrinsics.areEqual(simpleChangeCheckoutState.getEarlyCheckIn(), Boolean.TRUE) ? ComposableLambdaKt.rememberComposableLambda(1526612462, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.simpleChange.receipt.SimpleChangeReceiptScreenKt$SimpleChangeReceiptContent$1
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
                        ComposerKt.traceEventStart(1526612462, i7, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.receipt.SimpleChangeReceiptContent.<anonymous> (SimpleChangeReceiptScreen.kt:64)");
                    }
                    SimpleChangeReceiptScreenKt.EarlyCheckInBanner(Booking.this.getTicket().getTransport().isWalking(), composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54) : null;
            startRestartGroup.endReplaceGroup();
            ReceiptViewKt.ReceiptView(stringResource, buildReceiptDescription, stringResource2, function0, function0, rememberComposableLambda, ComposableLambdaKt.rememberComposableLambda(-1939452728, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.simpleChange.receipt.SimpleChangeReceiptScreenKt$SimpleChangeReceiptContent$2
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
                        ComposerKt.traceEventStart(-1939452728, i7, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.receipt.SimpleChangeReceiptContent.<anonymous> (SimpleChangeReceiptScreen.kt:69)");
                    }
                    SimpleChangeTicketSummaryViewKt.SimpleChangeTicketSummaryView(CollectionsKt.plus((Collection) SimpleChangeCheckoutManager.SimpleChangeCheckoutState.this.getAddons(), (Iterable) SimpleChangeCheckoutManager.SimpleChangeCheckoutState.this.getFood()), totalPrice, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ((i6 << 6) & 7168) | 1572864 | ((i6 << 9) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup3 = startRestartGroup.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.updateScope(new Function2() { // from class: g3.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SimpleChangeReceiptContent$lambda$4;
                    SimpleChangeReceiptContent$lambda$4 = SimpleChangeReceiptScreenKt.SimpleChangeReceiptContent$lambda$4(SimpleChangeCheckoutManager.SimpleChangeCheckoutState.this, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SimpleChangeReceiptContent$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleChangeReceiptContent$lambda$2(SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, Function0 function0, int i5, Composer composer, int i6) {
        SimpleChangeReceiptContent(simpleChangeCheckoutState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleChangeReceiptContent$lambda$3(SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, Function0 function0, int i5, Composer composer, int i6) {
        SimpleChangeReceiptContent(simpleChangeCheckoutState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleChangeReceiptContent$lambda$4(SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, Function0 function0, int i5, Composer composer, int i6) {
        SimpleChangeReceiptContent(simpleChangeCheckoutState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void SimpleChangeReceiptScreen(final SimpleChangeReceiptViewModel viewModel, final ResultBackNavigator<Boolean> resultNavigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(resultNavigator, "resultNavigator");
        Composer startRestartGroup = composer.startRestartGroup(327041009);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(resultNavigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(327041009, i6, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.receipt.SimpleChangeReceiptScreen (SimpleChangeReceiptScreen.kt:27)");
            }
            SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState = (SimpleChangeCheckoutManager.SimpleChangeCheckoutState) SnapshotStateKt.collectAsState(viewModel.getSimpleChangeCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            if (simpleChangeCheckoutState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: g3.b
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SimpleChangeReceiptScreen$lambda$0;
                            SimpleChangeReceiptScreen$lambda$0 = SimpleChangeReceiptScreenKt.SimpleChangeReceiptScreen$lambda$0(SimpleChangeReceiptViewModel.this, resultNavigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return SimpleChangeReceiptScreen$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1608896644, true, new SimpleChangeReceiptScreenKt$SimpleChangeReceiptScreen$1(simpleChangeCheckoutState, resultNavigator), startRestartGroup, 54);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(null, 0.0f, null, null, 0L, null, null, null, null, rememberComposableLambda, startRestartGroup, 805306752, 507);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: g3.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SimpleChangeReceiptScreen$lambda$1;
                    SimpleChangeReceiptScreen$lambda$1 = SimpleChangeReceiptScreenKt.SimpleChangeReceiptScreen$lambda$1(SimpleChangeReceiptViewModel.this, resultNavigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SimpleChangeReceiptScreen$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleChangeReceiptScreen$lambda$0(SimpleChangeReceiptViewModel simpleChangeReceiptViewModel, ResultBackNavigator resultBackNavigator, int i5, Composer composer, int i6) {
        SimpleChangeReceiptScreen(simpleChangeReceiptViewModel, resultBackNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleChangeReceiptScreen$lambda$1(SimpleChangeReceiptViewModel simpleChangeReceiptViewModel, ResultBackNavigator resultBackNavigator, int i5, Composer composer, int i6) {
        SimpleChangeReceiptScreen(simpleChangeReceiptViewModel, resultBackNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
