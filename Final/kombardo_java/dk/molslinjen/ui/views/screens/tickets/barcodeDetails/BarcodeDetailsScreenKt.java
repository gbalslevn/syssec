package dk.molslinjen.ui.views.screens.tickets.barcodeDetails;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.barcode.BarcodeViewKt;
import dk.molslinjen.ui.views.reusable.barcode.BarcodeViewType;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeDetailsScreenKt;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeDetailsViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\r²\u0006\u000e\u0010\f\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeDetailsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "BarcodeDetailsScreen", "(Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeDetailsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeDetailsViewModel$ViewState;", "state", "BarcodeDetailsContent", "(Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeDetailsViewModel$ViewState;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "containerWidth", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BarcodeDetailsScreenKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BarcodeViewType.values().length];
            try {
                iArr[BarcodeViewType.QR_CODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BarcodeDetailsContent(final BarcodeDetailsViewModel.ViewState viewState, Composer composer, final int i5) {
        int i6;
        float f5;
        Modifier.Companion companion;
        float f6;
        Composer composer2;
        Composer composer3;
        Composer startRestartGroup = composer.startRestartGroup(-77628119);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-77628119, i6, -1, "dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeDetailsContent (BarcodeDetailsScreen.kt:56)");
            }
            startRestartGroup.startReplaceGroup(311201496);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (rememberedValue == companion2.getEmpty()) {
                rememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableIntState mutableIntState = (MutableIntState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            float pxToDp = ComposeExtensionsKt.pxToDp(mutableIntState.getIntValue(), startRestartGroup, 0);
            float m2599constructorimpl = WhenMappings.$EnumSwitchMapping$0[viewState.getBarcodeType().ordinal()] == 1 ? pxToDp : Dp.m2599constructorimpl(152);
            Modifier.Companion companion3 = Modifier.INSTANCE;
            float f7 = 16;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), 0.0f, Dp.m2599constructorimpl(f7), 1, null);
            startRestartGroup.startReplaceGroup(311212149);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion2.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: o4.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit BarcodeDetailsContent$lambda$6$lambda$5;
                        BarcodeDetailsContent$lambda$6$lambda$5 = BarcodeDetailsScreenKt.BarcodeDetailsContent$lambda$6$lambda$5(MutableIntState.this, (LayoutCoordinates) obj);
                        return BarcodeDetailsContent$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(m313paddingVpY3zN4$default, (Function1) rememberedValue2);
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion4.getCenterHorizontally(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion5.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion5.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion5.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            String description = viewState.getDescription();
            startRestartGroup.startReplaceGroup(639759461);
            if (description == null) {
                composer2 = startRestartGroup;
                f5 = f7;
                companion = companion3;
                f6 = m2599constructorimpl;
            } else {
                f5 = f7;
                companion = companion3;
                f6 = m2599constructorimpl;
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(description, PaddingKt.m313paddingVpY3zN4$default(PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(40), 7, null), Dp.m2599constructorimpl(f7), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer2, 48, 1572864, 65532);
            }
            composer2.endReplaceGroup();
            Modifier.Companion companion6 = companion;
            float f8 = f6;
            BarcodeViewKt.m3395BarcodeViewYlGCr2M(SizeKt.m325height3ABfNKs(PaddingKt.m313paddingVpY3zN4$default(columnScopeInstance.align(companion6, companion4.getCenterHorizontally()), Dp.m2599constructorimpl(f5), 0.0f, 2, null), f8), false, 0, pxToDp, f8, viewState.getBarcodeType(), viewState.getBarcode(), composer2, 0, 6);
            Composer composer4 = composer2;
            composer4.startReplaceGroup(639777786);
            if (viewState.getBarcodeType() != BarcodeViewType.QR_CODE) {
                composer3 = composer4;
                TextKt.m940Text4IGK_g(viewState.getBarcode(), PaddingKt.m313paddingVpY3zN4$default(PaddingKt.m315paddingqDBjuR0$default(companion6, 0.0f, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 13, null), Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer3, 48, 1572864, 65532);
            } else {
                composer3 = composer4;
            }
            composer3.endReplaceGroup();
            BarcodeValidityViewKt.BarcodeValidityView(true, viewState.getBarcodeValidity(), composer3, 6, 0);
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: o4.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BarcodeDetailsContent$lambda$9;
                    BarcodeDetailsContent$lambda$9 = BarcodeDetailsScreenKt.BarcodeDetailsContent$lambda$9(BarcodeDetailsViewModel.ViewState.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return BarcodeDetailsContent$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BarcodeDetailsContent$lambda$6$lambda$5(MutableIntState mutableIntState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableIntState.setIntValue(IntSize.m2661getWidthimpl(it.mo1948getSizeYbymL2g()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BarcodeDetailsContent$lambda$9(BarcodeDetailsViewModel.ViewState viewState, int i5, Composer composer, int i6) {
        BarcodeDetailsContent(viewState, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void BarcodeDetailsScreen(final BarcodeDetailsViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-994736328);
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
                ComposerKt.traceEventStart(-994736328, i6, -1, "dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeDetailsScreen (BarcodeDetailsScreen.kt:43)");
            }
            final BarcodeDetailsViewModel.ViewState viewState = (BarcodeDetailsViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(442908389);
            boolean z5 = (i6 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new BarcodeDetailsScreenKt$BarcodeDetailsScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1296617083, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeDetailsScreenKt$BarcodeDetailsScreen$2
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
                        ComposerKt.traceEventStart(-1296617083, i7, -1, "dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeDetailsScreen.<anonymous> (BarcodeDetailsScreen.kt:51)");
                    }
                    BarcodeDetailsScreenKt.BarcodeDetailsContent(BarcodeDetailsViewModel.ViewState.this, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(fillMaxSize$default, 0.0f, null, null, 0L, null, (Function0) rememberedValue, null, null, rememberComposableLambda, startRestartGroup, 805306758, 442);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: o4.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BarcodeDetailsScreen$lambda$1;
                    BarcodeDetailsScreen$lambda$1 = BarcodeDetailsScreenKt.BarcodeDetailsScreen$lambda$1(BarcodeDetailsViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return BarcodeDetailsScreen$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BarcodeDetailsScreen$lambda$1(BarcodeDetailsViewModel barcodeDetailsViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        BarcodeDetailsScreen(barcodeDetailsViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
