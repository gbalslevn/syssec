package dk.molslinjen.ui.views.screens.tickets.barcodeDetails;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.SaleOnBoardBarcodeDetailsScreenKt;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.SaleOnBoardBarcodeDetailsViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/SaleOnBoardBarcodeDetailsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "SaleOnBoardBarcodeDetailsScreen", "(Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/SaleOnBoardBarcodeDetailsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/SaleOnBoardBarcodeDetailsViewModel$ViewState;", "state", "SaleOnBoardBarcodeDetailsContent", "(Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/SaleOnBoardBarcodeDetailsViewModel$ViewState;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardBarcodeDetailsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void SaleOnBoardBarcodeDetailsContent(final SaleOnBoardBarcodeDetailsViewModel.ViewState viewState, Composer composer, final int i5) {
        Object obj;
        char c5;
        float f5;
        ColumnScopeInstance columnScopeInstance;
        int i6;
        Composer composer2;
        Modifier.Companion companion;
        Composer composer3;
        char c6;
        float f6;
        Composer composer4;
        Composer startRestartGroup = composer.startRestartGroup(311804685);
        int i7 = (i5 & 6) == 0 ? (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5 : i5;
        if ((i7 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(311804685, i7, -1, "dk.molslinjen.ui.views.screens.tickets.barcodeDetails.SaleOnBoardBarcodeDetailsContent (SaleOnBoardBarcodeDetailsScreen.kt:53)");
            }
            SaleOnBoardOrder order = viewState.getOrder();
            if (order == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: o4.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit SaleOnBoardBarcodeDetailsContent$lambda$2;
                            SaleOnBoardBarcodeDetailsContent$lambda$2 = SaleOnBoardBarcodeDetailsScreenKt.SaleOnBoardBarcodeDetailsContent$lambda$2(SaleOnBoardBarcodeDetailsViewModel.ViewState.this, i5, (Composer) obj2, ((Integer) obj3).intValue());
                            return SaleOnBoardBarcodeDetailsContent$lambda$2;
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.startReplaceGroup(2106644405);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (rememberedValue == companion2.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            float f7 = 24;
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m311padding3ABfNKs(companion3, Dp.m2599constructorimpl(f7)), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null);
            startRestartGroup.startReplaceGroup(2106650294);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion2.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: o4.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit SaleOnBoardBarcodeDetailsContent$lambda$5$lambda$4;
                        SaleOnBoardBarcodeDetailsContent$lambda$5$lambda$4 = SaleOnBoardBarcodeDetailsScreenKt.SaleOnBoardBarcodeDetailsContent$lambda$5$lambda$4(MutableState.this, (LayoutCoordinates) obj2);
                        return SaleOnBoardBarcodeDetailsContent$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(verticalScroll$default, (Function1) rememberedValue2);
            Alignment.Companion companion4 = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion4.getCenterHorizontally();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, startRestartGroup, 48);
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
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            float m2599constructorimpl = Dp.m2599constructorimpl(1);
            AppColor appColor = AppColor.INSTANCE;
            Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(BorderKt.m108borderxT4_qwU(companion3, m2599constructorimpl, appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), appColor.m3269getGrey60d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium());
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion4.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m103backgroundbw27NRU);
            Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion5.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion5.getSetModifier());
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion3, Dp.m2599constructorimpl(f7)), startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-1440446121);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion2.getEmpty()) {
                obj = null;
                c5 = 2;
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            } else {
                obj = null;
                c5 = 2;
            }
            final MutableState mutableState2 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1440443990);
            if (((Boolean) mutableState2.getValue()).booleanValue()) {
                f5 = f7;
                columnScopeInstance = columnScopeInstance2;
                i6 = 6;
                composer2 = startRestartGroup;
                companion = companion3;
            } else {
                Modifier align = columnScopeInstance2.align(SizeKt.m325height3ABfNKs(companion3, Dp.m2599constructorimpl(64)), companion4.getCenterHorizontally());
                String shopImageUrl = order.getShopImageUrl();
                startRestartGroup.startReplaceGroup(-1440433552);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion2.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: o4.q
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit SaleOnBoardBarcodeDetailsContent$lambda$17$lambda$16$lambda$8$lambda$7;
                            SaleOnBoardBarcodeDetailsContent$lambda$17$lambda$16$lambda$8$lambda$7 = SaleOnBoardBarcodeDetailsScreenKt.SaleOnBoardBarcodeDetailsContent$lambda$17$lambda$16$lambda$8$lambda$7(MutableState.this, (AsyncImagePainter.State.Error) obj2);
                            return SaleOnBoardBarcodeDetailsContent$lambda$17$lambda$16$lambda$8$lambda$7;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                f5 = f7;
                columnScopeInstance = columnScopeInstance2;
                ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(shopImageUrl, null, null, null, null, null, (Function1) rememberedValue4, null, 0, startRestartGroup, 1572864, 446), Accessibility.INSTANCE.getSkip(), align, null, ContentScale.INSTANCE.getFit(), 0.0f, null, startRestartGroup, 24576, 104);
                companion = companion3;
                composer2 = startRestartGroup;
                i6 = 6;
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(8)), composer2, 6);
            }
            composer2.endReplaceGroup();
            Composer composer5 = composer2;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.saleOnBoard_ticketDetails_pickupAt, new Object[]{order.getShopLocation()}, composer2, i6), columnScopeInstance.align(companion, companion4.getCenterHorizontally()), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer5, 0, 1572864, 65532);
            Modifier m325height3ABfNKs = SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5));
            Composer composer6 = composer5;
            SpacerKt.Spacer(m325height3ABfNKs, composer6, 6);
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer6, 0, 15);
            composer6.startReplaceGroup(-1440409899);
            int i8 = 0;
            for (SaleOnBoardLineItem saleOnBoardLineItem : order.getLineItems()) {
                int i9 = i8 + 1;
                composer6.startReplaceGroup(-1440410113);
                if (i8 > 0) {
                    HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer6, 0, 15);
                }
                composer6.endReplaceGroup();
                Modifier.Companion companion6 = Modifier.INSTANCE;
                float f8 = 16;
                Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(companion6, Dp.m2599constructorimpl(f8));
                Arrangement arrangement2 = Arrangement.INSTANCE;
                Arrangement.Horizontal start = arrangement2.getStart();
                Alignment.Companion companion7 = Alignment.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion7.getTop(), composer6, 0);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer6.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer6, m311padding3ABfNKs);
                ComposeUiNode.Companion companion8 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor3 = companion8.getConstructor();
                if (composer6.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer6.startReusableNode();
                if (composer6.getInserting()) {
                    composer6.createNode(constructor3);
                } else {
                    composer6.useNode();
                }
                Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer6);
                Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy, companion8.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion8.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion8.getSetCompositeKeyHash();
                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion8.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                composer6.startReplaceGroup(1054160534);
                Object rememberedValue5 = composer6.rememberedValue();
                Composer.Companion companion9 = Composer.INSTANCE;
                if (rememberedValue5 == companion9.getEmpty()) {
                    c6 = 2;
                    rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer6.updateRememberedValue(rememberedValue5);
                } else {
                    c6 = 2;
                }
                final MutableState mutableState3 = (MutableState) rememberedValue5;
                composer6.endReplaceGroup();
                if (((Boolean) mutableState3.getValue()).booleanValue()) {
                    f6 = f8;
                    composer6.startReplaceGroup(-1679984363);
                    ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_food_image_missing, composer6, 6), Accessibility.INSTANCE.getSkip(), PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(SizeKt.m331size3ABfNKs(companion6, Dp.m2599constructorimpl(124)), ThemeShapesKt.getThemeShapes().getSmall()), AppColor.INSTANCE.m3268getGrey50d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f6)), null, null, 0.0f, null, composer6, 0, 120);
                    composer6.endReplaceGroup();
                } else {
                    composer6.startReplaceGroup(-1680656567);
                    Modifier clip = ClipKt.clip(SizeKt.m331size3ABfNKs(companion6, Dp.m2599constructorimpl(124)), ThemeShapesKt.getThemeShapes().getSmall());
                    String squareImageUrl = saleOnBoardLineItem.getProduct().getSquareImageUrl();
                    composer6.startReplaceGroup(1054175035);
                    Object rememberedValue6 = composer6.rememberedValue();
                    if (rememberedValue6 == companion9.getEmpty()) {
                        rememberedValue6 = new Function1() { // from class: o4.r
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                Unit SaleOnBoardBarcodeDetailsContent$lambda$17$lambda$16$lambda$15$lambda$11$lambda$10;
                                SaleOnBoardBarcodeDetailsContent$lambda$17$lambda$16$lambda$15$lambda$11$lambda$10 = SaleOnBoardBarcodeDetailsScreenKt.SaleOnBoardBarcodeDetailsContent$lambda$17$lambda$16$lambda$15$lambda$11$lambda$10(MutableState.this, (AsyncImagePainter.State.Error) obj2);
                                return SaleOnBoardBarcodeDetailsContent$lambda$17$lambda$16$lambda$15$lambda$11$lambda$10;
                            }
                        };
                        composer6.updateRememberedValue(rememberedValue6);
                    }
                    composer6.endReplaceGroup();
                    f6 = f8;
                    Composer composer7 = composer6;
                    ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(squareImageUrl, null, null, null, null, null, (Function1) rememberedValue6, null, 0, composer6, 1572864, 446), Accessibility.INSTANCE.getSkip(), clip, null, ContentScale.INSTANCE.getFit(), 0.0f, null, composer7, 24576, 104);
                    composer7.endReplaceGroup();
                    composer6 = composer7;
                    companion6 = companion6;
                }
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion6, Dp.m2599constructorimpl(f6)), composer6, 6);
                MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement2.getTop(), companion7.getStart(), composer6, 0);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer6.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer6, companion6);
                Function0<ComposeUiNode> constructor4 = companion8.getConstructor();
                if (composer6.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer6.startReusableNode();
                if (composer6.getInserting()) {
                    composer6.createNode(constructor4);
                } else {
                    composer6.useNode();
                }
                Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer6);
                Updater.m1227setimpl(m1226constructorimpl4, columnMeasurePolicy3, companion8.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion8.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion8.getSetCompositeKeyHash();
                if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion8.getSetModifier());
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                int pushStyle = builder.pushStyle(new SpanStyle(0L, 0L, TypographyKt.getParagraphBold().getFontWeight(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 65531, null));
                try {
                    builder.append(saleOnBoardLineItem.getQuantity() + "x ");
                    Unit unit = Unit.INSTANCE;
                    builder.pop(pushStyle);
                    builder.append(saleOnBoardLineItem.getProduct().getName());
                    Modifier.Companion companion10 = companion6;
                    Composer composer8 = composer6;
                    TextKt.m941TextIbK3jfQ(builder.toAnnotatedString(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, TypographyKt.getParagraph(), composer8, 0, 12582912, 131070);
                    String description = saleOnBoardLineItem.description();
                    String takeFirstSentence = description != null ? StringExtensionsKt.takeFirstSentence(description) : null;
                    composer8.startReplaceGroup(-1127779700);
                    if (takeFirstSentence != null) {
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion10, Dp.m2599constructorimpl(8)), composer8, 6);
                        composer4 = composer8;
                        TextKt.m940Text4IGK_g(takeFirstSentence, null, AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer4, 384, 1572864, 65530);
                    } else {
                        composer4 = composer8;
                    }
                    composer4.endReplaceGroup();
                    composer4.endNode();
                    composer4.endNode();
                    composer6 = composer4;
                    i8 = i9;
                } catch (Throwable th) {
                    builder.pop(pushStyle);
                    throw th;
                }
            }
            composer3 = composer6;
            composer3.endReplaceGroup();
            composer3.endNode();
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer3.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: o4.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit SaleOnBoardBarcodeDetailsContent$lambda$18;
                    SaleOnBoardBarcodeDetailsContent$lambda$18 = SaleOnBoardBarcodeDetailsScreenKt.SaleOnBoardBarcodeDetailsContent$lambda$18(SaleOnBoardBarcodeDetailsViewModel.ViewState.this, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return SaleOnBoardBarcodeDetailsContent$lambda$18;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBarcodeDetailsContent$lambda$17$lambda$16$lambda$15$lambda$11$lambda$10(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBarcodeDetailsContent$lambda$17$lambda$16$lambda$8$lambda$7(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBarcodeDetailsContent$lambda$18(SaleOnBoardBarcodeDetailsViewModel.ViewState viewState, int i5, Composer composer, int i6) {
        SaleOnBoardBarcodeDetailsContent(viewState, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBarcodeDetailsContent$lambda$2(SaleOnBoardBarcodeDetailsViewModel.ViewState viewState, int i5, Composer composer, int i6) {
        SaleOnBoardBarcodeDetailsContent(viewState, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBarcodeDetailsContent$lambda$5$lambda$4(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2661getWidthimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    public static final void SaleOnBoardBarcodeDetailsScreen(final SaleOnBoardBarcodeDetailsViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        String str;
        Composer composer2;
        String shopLocation;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-300046746);
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
                ComposerKt.traceEventStart(-300046746, i6, -1, "dk.molslinjen.ui.views.screens.tickets.barcodeDetails.SaleOnBoardBarcodeDetailsScreen (SaleOnBoardBarcodeDetailsScreen.kt:40)");
            }
            final SaleOnBoardBarcodeDetailsViewModel.ViewState viewState = (SaleOnBoardBarcodeDetailsViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
            SaleOnBoardOrder order = viewState.getOrder();
            if (order == null || (shopLocation = order.getShopLocation()) == null || (str = StringExtensionsKt.uppercaseFirstLetter(shopLocation)) == null) {
                str = BuildConfig.FLAVOR;
            }
            startRestartGroup.startReplaceGroup(-884649371);
            boolean z5 = (i6 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SaleOnBoardBarcodeDetailsScreenKt$SaleOnBoardBarcodeDetailsScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-16303687, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.barcodeDetails.SaleOnBoardBarcodeDetailsScreenKt$SaleOnBoardBarcodeDetailsScreen$2
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
                        ComposerKt.traceEventStart(-16303687, i7, -1, "dk.molslinjen.ui.views.screens.tickets.barcodeDetails.SaleOnBoardBarcodeDetailsScreen.<anonymous> (SaleOnBoardBarcodeDetailsScreen.kt:48)");
                    }
                    SaleOnBoardBarcodeDetailsScreenKt.SaleOnBoardBarcodeDetailsContent(SaleOnBoardBarcodeDetailsViewModel.ViewState.this, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(fillMaxHeight$default, 0.0f, str, null, 0L, null, (Function0) rememberedValue, null, null, rememberComposableLambda, startRestartGroup, 805306374, 442);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: o4.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardBarcodeDetailsScreen$lambda$1;
                    SaleOnBoardBarcodeDetailsScreen$lambda$1 = SaleOnBoardBarcodeDetailsScreenKt.SaleOnBoardBarcodeDetailsScreen$lambda$1(SaleOnBoardBarcodeDetailsViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardBarcodeDetailsScreen$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBarcodeDetailsScreen$lambda$1(SaleOnBoardBarcodeDetailsViewModel saleOnBoardBarcodeDetailsViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        SaleOnBoardBarcodeDetailsScreen(saleOnBoardBarcodeDetailsViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
