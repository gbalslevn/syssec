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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
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
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntSize;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.image.ImageHelper;
import dk.molslinjen.domain.model.booking.LineItem;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.barcode.BarcodeViewKt;
import dk.molslinjen.ui.views.reusable.barcode.BarcodeViewType;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.FoodBarcodeDetailsScreenKt;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.FoodBarcodeDetailsViewModel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/FoodBarcodeDetailsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "FoodBarcodeDetailsScreen", "(Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/FoodBarcodeDetailsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/FoodBarcodeDetailsViewModel$ViewState;", "state", "FoodBarcodeDetailsContent", "(Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/FoodBarcodeDetailsViewModel$ViewState;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/booking/LineItem;", "lineItem", "ItemRow", "(Ldk/molslinjen/domain/model/booking/LineItem;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FoodBarcodeDetailsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void FoodBarcodeDetailsContent(final FoodBarcodeDetailsViewModel.ViewState viewState, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1747702355);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1747702355, i6, -1, "dk.molslinjen.ui.views.screens.tickets.barcodeDetails.FoodBarcodeDetailsContent (FoodBarcodeDetailsScreen.kt:83)");
            }
            startRestartGroup.startReplaceGroup(-1495354694);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableIntState mutableIntState = (MutableIntState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m311padding3ABfNKs(companion2, Dp.m2599constructorimpl(16)), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null);
            startRestartGroup.startReplaceGroup(-1495348712);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: o4.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit FoodBarcodeDetailsContent$lambda$4$lambda$3;
                        FoodBarcodeDetailsContent$lambda$4$lambda$3 = FoodBarcodeDetailsScreenKt.FoodBarcodeDetailsContent$lambda$4$lambda$3(MutableIntState.this, (LayoutCoordinates) obj);
                        return FoodBarcodeDetailsContent$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(verticalScroll$default, (Function1) rememberedValue2);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            float f5 = 152;
            BarcodeViewKt.m3395BarcodeViewYlGCr2M(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), false, 0, ComposeExtensionsKt.pxToDp(mutableIntState.getValue().intValue(), startRestartGroup, 0), Dp.m2599constructorimpl(f5), BarcodeViewType.CODE_128, viewState.getBarcode(), startRestartGroup, 221190, 6);
            TextKt.m940Text4IGK_g(viewState.getBarcode(), PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), startRestartGroup, 48, 1572864, 65532);
            composer2 = startRestartGroup;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(24)), composer2, 6);
            composer2.startReplaceGroup(-1903844114);
            Iterator<T> it = viewState.getLineItems().iterator();
            while (it.hasNext()) {
                ItemRow((LineItem) it.next(), composer2, 0);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: o4.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FoodBarcodeDetailsContent$lambda$7;
                    FoodBarcodeDetailsContent$lambda$7 = FoodBarcodeDetailsScreenKt.FoodBarcodeDetailsContent$lambda$7(FoodBarcodeDetailsViewModel.ViewState.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FoodBarcodeDetailsContent$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FoodBarcodeDetailsContent$lambda$4$lambda$3(MutableIntState mutableIntState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableIntState.setValue(IntSize.m2661getWidthimpl(it.mo1948getSizeYbymL2g()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FoodBarcodeDetailsContent$lambda$7(FoodBarcodeDetailsViewModel.ViewState viewState, int i5, Composer composer, int i6) {
        FoodBarcodeDetailsContent(viewState, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void FoodBarcodeDetailsScreen(final FoodBarcodeDetailsViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-1415354694);
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
                ComposerKt.traceEventStart(-1415354694, i6, -1, "dk.molslinjen.ui.views.screens.tickets.barcodeDetails.FoodBarcodeDetailsScreen (FoodBarcodeDetailsScreen.kt:70)");
            }
            final FoodBarcodeDetailsViewModel.ViewState viewState = (FoodBarcodeDetailsViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.ticketDetails_foodFromBooking, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-723706141);
            boolean z5 = (i6 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new FoodBarcodeDetailsScreenKt$FoodBarcodeDetailsScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1608451463, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.barcodeDetails.FoodBarcodeDetailsScreenKt$FoodBarcodeDetailsScreen$2
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
                        ComposerKt.traceEventStart(1608451463, i7, -1, "dk.molslinjen.ui.views.screens.tickets.barcodeDetails.FoodBarcodeDetailsScreen.<anonymous> (FoodBarcodeDetailsScreen.kt:78)");
                    }
                    FoodBarcodeDetailsScreenKt.FoodBarcodeDetailsContent(FoodBarcodeDetailsViewModel.ViewState.this, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(fillMaxHeight$default, 0.0f, stringResource, null, 0L, null, (Function0) rememberedValue, null, null, rememberComposableLambda, startRestartGroup, 805306374, 442);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: o4.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FoodBarcodeDetailsScreen$lambda$1;
                    FoodBarcodeDetailsScreen$lambda$1 = FoodBarcodeDetailsScreenKt.FoodBarcodeDetailsScreen$lambda$1(FoodBarcodeDetailsViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FoodBarcodeDetailsScreen$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FoodBarcodeDetailsScreen$lambda$1(FoodBarcodeDetailsViewModel foodBarcodeDetailsViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        FoodBarcodeDetailsScreen(foodBarcodeDetailsViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void ItemRow(final LineItem lineItem, Composer composer, final int i5) {
        int i6;
        float f5;
        int i7;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1628095540);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(lineItem) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1628095540, i6, -1, "dk.molslinjen.ui.views.screens.tickets.barcodeDetails.ItemRow (FoodBarcodeDetailsScreen.kt:114)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f6 = 8;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m2599constructorimpl(f6), 1, null);
            AppColor appColor = AppColor.INSTANCE;
            float f7 = 16;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(m313paddingVpY3zN4$default, appColor.m3269getGrey60d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(1), appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f7));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(1214500840);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue == companion4.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            float f8 = 124;
            String m3193buildImageUrlC8IHX40 = ImageHelper.INSTANCE.m3193buildImageUrlC8IHX40(lineItem.getImageUrl(), Dp.m2597boximpl(Dp.m2599constructorimpl(f8)), Dp.m2597boximpl(Dp.m2599constructorimpl(f8)), startRestartGroup, 3504, 0);
            long m2610DpSizeYgX7TsA = DpKt.m2610DpSizeYgX7TsA(Dp.m2599constructorimpl(88), Dp.m2599constructorimpl(116));
            if (m3193buildImageUrlC8IHX40 == null || ((Boolean) mutableState.getValue()).booleanValue()) {
                f5 = f6;
                i7 = 6;
                startRestartGroup.startReplaceGroup(-1004331865);
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_food_image_missing, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(SizeKt.m332size6HolHcs(companion, m2610DpSizeYgX7TsA), ThemeShapesKt.getThemeShapes().getSmall()), appColor.m3268getGrey50d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f7)), null, ContentScale.INSTANCE.getFit(), 0.0f, null, startRestartGroup, 24576, 104);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1004822254);
                Modifier clip = ClipKt.clip(SizeKt.m332size6HolHcs(companion, m2610DpSizeYgX7TsA), ThemeShapesKt.getThemeShapes().getSmall());
                startRestartGroup.startReplaceGroup(1214520309);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion4.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: o4.i
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ItemRow$lambda$17$lambda$10$lambda$9;
                            ItemRow$lambda$17$lambda$10$lambda$9 = FoodBarcodeDetailsScreenKt.ItemRow$lambda$17$lambda$10$lambda$9(MutableState.this, (AsyncImagePainter.State.Error) obj);
                            return ItemRow$lambda$17$lambda$10$lambda$9;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                f5 = f6;
                i7 = 6;
                ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(m3193buildImageUrlC8IHX40, null, null, null, null, null, (Function1) rememberedValue2, null, 0, startRestartGroup, 1572864, 446), Accessibility.INSTANCE.getSkip(), clip, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, startRestartGroup, 24576, 104);
                startRestartGroup.endReplaceGroup();
            }
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f7)), startRestartGroup, i7);
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            int pushStyle = builder.pushStyle(new SpanStyle(0L, 0L, TypographyKt.getParagraphBold().getFontWeight(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 65531, null));
            try {
                builder.pop(pushStyle);
                builder.append(lineItem.getName());
                AnnotatedString annotatedString = builder.toAnnotatedString();
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), startRestartGroup, 0);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
                Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
                TextKt.m940Text4IGK_g(lineItem.getQuantity() + "x ", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), startRestartGroup, 0, 1572864, 65534);
                TextKt.m941TextIbK3jfQ(annotatedString, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, TypographyKt.getParagraphSmall(), startRestartGroup, 0, 12582912, 131070);
                startRestartGroup.endNode();
                String cateringLocationText = lineItem.getCateringLocationText();
                startRestartGroup.startReplaceGroup(856038124);
                if (cateringLocationText == null) {
                    composer2 = startRestartGroup;
                } else {
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, i7);
                    Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m103backgroundbw27NRU(companion, appColor.m3268getGrey50d7_KjU(), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(4))), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(i7));
                    MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), startRestartGroup, 48);
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
                    Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor4);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Composer m1226constructorimpl4 = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy3, companion3.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion3.getSetCompositeKeyHash();
                    if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion3.getSetModifier());
                    IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_pin, startRestartGroup, i7), Accessibility.INSTANCE.getSkip(), (Modifier) null, appColor.m3266getGrey30d7_KjU(), startRestartGroup, 3072, 4);
                    SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, i7);
                    composer2 = startRestartGroup;
                    TextKt.m940Text4IGK_g(cateringLocationText, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65534);
                    composer2.endNode();
                    Unit unit = Unit.INSTANCE;
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } catch (Throwable th) {
                builder.pop(pushStyle);
                throw th;
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: o4.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ItemRow$lambda$18;
                    ItemRow$lambda$18 = FoodBarcodeDetailsScreenKt.ItemRow$lambda$18(LineItem.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ItemRow$lambda$18;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemRow$lambda$17$lambda$10$lambda$9(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemRow$lambda$18(LineItem lineItem, int i5, Composer composer, int i6) {
        ItemRow(lineItem, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
