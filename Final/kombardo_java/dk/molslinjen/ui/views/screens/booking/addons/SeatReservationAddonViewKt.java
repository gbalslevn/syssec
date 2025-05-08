package dk.molslinjen.ui.views.screens.booking.addons;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.extensions.domain.FerrySeatExtenstionsKt;
import dk.molslinjen.domain.model.booking.product.ExtraProduct;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.LoadingViewKt;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel;
import dk.molslinjen.ui.views.screens.booking.addons.SeatReservationAddonViewKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeat;

@Metadata(d1 = {"\u00008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u001a]\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001ac\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u001a-\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a+\u0010\u001a\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0003¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0017H\u0003¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {BuildConfig.FLAVOR, "showBorder", "Ldk/molslinjen/domain/model/booking/product/Product;", "product", BuildConfig.FLAVOR, "numberOfPassengers", "Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState;", "seatsState", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onStartSeatSelection", "onStartSeatsEdit", "retrySeatSync", "SeatReservationAddonView", "(ZLdk/molslinjen/domain/model/booking/product/Product;ILdk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/Modifier;", "modifier", "isRecommended", "Content", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/booking/product/Product;ZILdk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ReserveButtonView", "(Ldk/molslinjen/domain/model/booking/product/Product;ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeat;", "seats", "editSelection", "ReservedSeatsView", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "seat", "SeatRow", "(Luniffi/molslinjen_shared/FerrySeat;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SeatReservationAddonViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Content(final Modifier modifier, final Product product, final boolean z5, final int i5, final AddonsViewModel.ViewState.SeatsState seatsState, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int i6) {
        int i7;
        Composer composer2;
        Composer composer3;
        Composer startRestartGroup = composer.startRestartGroup(-1241262678);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(product) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i7 |= startRestartGroup.changed(i5) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i7 |= startRestartGroup.changed(seatsState) ? 16384 : 8192;
        }
        if ((196608 & i6) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & i6) == 0) {
            i7 |= startRestartGroup.changedInstance(function02) ? 1048576 : 524288;
        }
        if ((12582912 & i6) == 0) {
            i7 |= startRestartGroup.changedInstance(function03) ? 8388608 : 4194304;
        }
        if ((4793491 & i7) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1241262678, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.Content (SeatReservationAddonView.kt:91)");
            }
            float f5 = 8;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), Dp.m2599constructorimpl(f5));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), startRestartGroup, 0);
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
            startRestartGroup.startReplaceGroup(-1033567301);
            if (z5) {
                RecommendedProductImageViewKt.RecommendedProductImageView(product, startRestartGroup, (i7 >> 3) & 14);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            }
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion3);
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
            int i8 = i7;
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            TextKt.m940Text4IGK_g(product.getName(), PaddingKt.m315paddingqDBjuR0$default(companion3, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), 0.0f, 8, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 0, 1572864, 65532);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null), startRestartGroup, 0);
            boolean z6 = seatsState instanceof AddonsViewModel.ViewState.SeatsState.Reserved;
            if (z6) {
                startRestartGroup.startReplaceGroup(-834817931);
                ProductPriceViewKt.ProductPriceView(FerrySeatExtenstionsKt.totalPrice(((AddonsViewModel.ViewState.SeatsState.Reserved) seatsState).getSeats()), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else if (z5) {
                startRestartGroup.startReplaceGroup(-834533940);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-834703076);
                ProductTagViewKt.ProductTagView(PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 11, null), product, startRestartGroup, 6, 0);
                startRestartGroup.endReplaceGroup();
            }
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(-1033542430);
            if (product instanceof ExtraProduct) {
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(((ExtraProduct) product).getDescription(), PaddingKt.m315paddingqDBjuR0$default(companion3, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), 0.0f, 8, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 384, 1572864, 65528);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            Composer composer4 = composer2;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion3, Dp.m2599constructorimpl(f5)), composer4, 6);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getCenterVertically(), composer4, 48);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer4, fillMaxWidth$default);
            Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
            if (composer4.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor3);
            } else {
                composer4.useNode();
            }
            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer4);
            Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion2.getSetModifier());
            if (Intrinsics.areEqual(seatsState, AddonsViewModel.ViewState.SeatsState.Empty.INSTANCE)) {
                composer4.startReplaceGroup(-303996898);
                ReserveButtonView(product, i5, function0, composer4, ((i8 >> 3) & 14) | ((i8 >> 6) & 112) | ((i8 >> 9) & 896));
                composer4.endReplaceGroup();
                composer3 = composer4;
            } else if (Intrinsics.areEqual(seatsState, AddonsViewModel.ViewState.SeatsState.Error.INSTANCE)) {
                composer4.startReplaceGroup(-303988494);
                String stringResource = StringResources_androidKt.stringResource(R.string.error_general, composer4, 6);
                composer4.startReplaceGroup(-303984823);
                boolean z7 = (29360128 & i8) == 8388608;
                Object rememberedValue = composer4.rememberedValue();
                if (z7 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: D2.i0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit Content$lambda$5$lambda$4$lambda$3$lambda$2;
                            Content$lambda$5$lambda$4$lambda$3$lambda$2 = SeatReservationAddonViewKt.Content$lambda$5$lambda$4$lambda$3$lambda$2(Function0.this);
                            return Content$lambda$5$lambda$4$lambda$3$lambda$2;
                        }
                    };
                    composer4.updateRememberedValue(rememberedValue);
                }
                composer4.endReplaceGroup();
                composer3 = composer4;
                SecondaryButtonKt.m3406SecondaryButtonbZJ32A(null, stringResource, (Function0) rememberedValue, null, false, null, false, null, null, 0L, false, composer3, 0, 0, 2041);
                composer3.endReplaceGroup();
            } else {
                composer3 = composer4;
                if (z6) {
                    composer3.startReplaceGroup(-303981283);
                    ReservedSeatsView(((AddonsViewModel.ViewState.SeatsState.Reserved) seatsState).getSeats(), function02, composer3, (i8 >> 15) & 112);
                    composer3.endReplaceGroup();
                } else {
                    if (!Intrinsics.areEqual(seatsState, AddonsViewModel.ViewState.SeatsState.Loading.INSTANCE) && seatsState != null) {
                        composer3.startReplaceGroup(-303998900);
                        composer3.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer3.startReplaceGroup(-303974269);
                    LoadingViewKt.m3393LoadingVieworJrPs(0.0f, 0, composer3, 0, 3);
                    composer3.endReplaceGroup();
                }
            }
            composer3.endNode();
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.j0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$6;
                    Content$lambda$6 = SeatReservationAddonViewKt.Content$lambda$6(Modifier.this, product, z5, i5, seatsState, function0, function02, function03, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$5$lambda$4$lambda$3$lambda$2(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$6(Modifier modifier, Product product, boolean z5, int i5, AddonsViewModel.ViewState.SeatsState seatsState, Function0 function0, Function0 function02, Function0 function03, int i6, Composer composer, int i7) {
        Content(modifier, product, z5, i5, seatsState, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }

    private static final void ReserveButtonView(final Product product, final int i5, final Function0<Unit> function0, Composer composer, final int i6) {
        int i7;
        String stringResource;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1841181144);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(product) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changed(i5) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1841181144, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.ReserveButtonView (SeatReservationAddonView.kt:156)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(companion, Dp.m2599constructorimpl(8));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Horizontal start = arrangement.getStart();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion2.getTop(), startRestartGroup, 0);
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
            if (i5 == 1) {
                startRestartGroup.startReplaceGroup(1637868458);
                stringResource = StringResources_androidKt.stringResource(R.string.button_selectSeat, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1637944873);
                stringResource = StringResources_androidKt.stringResource(R.string.button_selectSeats, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            SecondaryButtonKt.m3406SecondaryButtonbZJ32A(null, stringResource, function0, null, false, null, false, null, null, 0L, false, startRestartGroup, i7 & 896, 0, 2041);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), startRestartGroup, 0);
            Modifier align = rowScopeInstance.align(companion, companion2.getBottom());
            startRestartGroup.startReplaceGroup(1853962227);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: D2.k0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ReserveButtonView$lambda$10$lambda$8$lambda$7;
                        ReserveButtonView$lambda$10$lambda$8$lambda$7 = SeatReservationAddonViewKt.ReserveButtonView$lambda$10$lambda$8$lambda$7((SemanticsPropertyReceiver) obj);
                        return ReserveButtonView$lambda$10$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier semantics = SemanticsModifierKt.semantics(align, true, (Function1) rememberedValue);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics);
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.common_from, startRestartGroup, 6), rowScopeInstance.alignByBaseline(companion), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), startRestartGroup, 0, 1572864, 65532);
            composer2 = startRestartGroup;
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(2)), composer2, 6);
            ProductPriceViewKt.ProductPriceView(product.getPrice(), composer2, 0);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ReserveButtonView$lambda$11;
                    ReserveButtonView$lambda$11 = SeatReservationAddonViewKt.ReserveButtonView$lambda$11(Product.this, i5, function0, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return ReserveButtonView$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReserveButtonView$lambda$10$lambda$8$lambda$7(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReserveButtonView$lambda$11(Product product, int i5, Function0 function0, int i6, Composer composer, int i7) {
        ReserveButtonView(product, i5, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }

    private static final void ReservedSeatsView(final List<FerrySeat> list, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-49614750);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(list) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-49614750, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.ReservedSeatsView (SeatReservationAddonView.kt:183)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 16;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f5));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            TextKt.m940Text4IGK_g(StringResources_androidKt.pluralStringResource(R.plurals.selectSeat_xSeatsReserved, list.size(), new Object[]{Integer.valueOf(list.size())}, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 0, 1572864, 65534);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), startRestartGroup, 0);
            composer2 = startRestartGroup;
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_edit_circle_transparent, startRestartGroup, 6), StringResources_androidKt.stringResource(R.string.accessibilityLabel_edit, startRestartGroup, 6), ClickableKt.m122clickableXHw0xAI$default(ClipKt.clip(SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(32)), RoundedCornerShapeKt.getCircleShape()), false, null, null, function0, 7, null), null, null, 0.0f, null, composer2, 0, 120);
            composer2.endNode();
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(24)), composer2, 6);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(f5)), companion2.getStart(), composer2, 6);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, companion);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            composer2.startReplaceGroup(559745986);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                SeatRow((FerrySeat) it.next(), composer2, 0);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.m0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ReservedSeatsView$lambda$16;
                    ReservedSeatsView$lambda$16 = SeatReservationAddonViewKt.ReservedSeatsView$lambda$16(list, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ReservedSeatsView$lambda$16;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReservedSeatsView$lambda$16(List list, Function0 function0, int i5, Composer composer, int i6) {
        ReservedSeatsView(list, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void SeatReservationAddonView(boolean z5, final Product product, final int i5, final AddonsViewModel.ViewState.SeatsState seatsState, final Function0<Unit> onStartSeatSelection, final Function0<Unit> onStartSeatsEdit, final Function0<Unit> retrySeatSync, Composer composer, final int i6, final int i7) {
        boolean z6;
        int i8;
        final boolean z7;
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(onStartSeatSelection, "onStartSeatSelection");
        Intrinsics.checkNotNullParameter(onStartSeatsEdit, "onStartSeatsEdit");
        Intrinsics.checkNotNullParameter(retrySeatSync, "retrySeatSync");
        Composer startRestartGroup = composer.startRestartGroup(-1934314450);
        int i9 = i7 & 1;
        if (i9 != 0) {
            i8 = i6 | 6;
            z6 = z5;
        } else if ((i6 & 6) == 0) {
            z6 = z5;
            i8 = (startRestartGroup.changed(z6) ? 4 : 2) | i6;
        } else {
            z6 = z5;
            i8 = i6;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(product) ? 32 : 16;
        }
        if ((i7 & 4) != 0) {
            i8 |= 384;
        } else if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changed(i5) ? 256 : 128;
        }
        if ((i7 & 8) != 0) {
            i8 |= 3072;
        } else if ((i6 & 3072) == 0) {
            i8 |= startRestartGroup.changed(seatsState) ? 2048 : 1024;
        }
        if ((i7 & 16) != 0) {
            i8 |= 24576;
        } else if ((i6 & 24576) == 0) {
            i8 |= startRestartGroup.changedInstance(onStartSeatSelection) ? 16384 : 8192;
        }
        if ((i7 & 32) != 0) {
            i8 |= 196608;
        } else if ((i6 & 196608) == 0) {
            i8 |= startRestartGroup.changedInstance(onStartSeatsEdit) ? 131072 : 65536;
        }
        if ((i7 & 64) != 0) {
            i8 |= 1572864;
        } else if ((i6 & 1572864) == 0) {
            i8 |= startRestartGroup.changedInstance(retrySeatSync) ? 1048576 : 524288;
        }
        if ((599187 & i8) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            z7 = z6;
        } else {
            boolean z8 = i9 != 0 ? false : z6;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1934314450, i8, -1, "dk.molslinjen.ui.views.screens.booking.addons.SeatReservationAddonView (SeatReservationAddonView.kt:53)");
            }
            final boolean recommended = product.getRecommended();
            startRestartGroup.startReplaceGroup(1928563217);
            final Modifier m103backgroundbw27NRU = (z8 || recommended) ? BackgroundKt.m103backgroundbw27NRU(Modifier.INSTANCE, AppColor.INSTANCE.m3281getWhite0d7_KjU(), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getMedium()) : BackgroundKt.m104backgroundbw27NRU$default(Modifier.INSTANCE, AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null);
            startRestartGroup.endReplaceGroup();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1469171537, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.SeatReservationAddonViewKt$SeatReservationAddonView$content$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i10) {
                    if ((i10 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1469171537, i10, -1, "dk.molslinjen.ui.views.screens.booking.addons.SeatReservationAddonView.<anonymous> (SeatReservationAddonView.kt:62)");
                    }
                    SeatReservationAddonViewKt.Content(Modifier.this, product, recommended, i5, seatsState, onStartSeatSelection, onStartSeatsEdit, retrySeatSync, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            if (recommended) {
                startRestartGroup.startReplaceGroup(-343477140);
                RecommendedFrameViewKt.RecommendedFrameView(null, rememberComposableLambda, startRestartGroup, 48, 1);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-343417558);
                rememberComposableLambda.invoke(startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z7 = z8;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.h0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SeatReservationAddonView$lambda$0;
                    SeatReservationAddonView$lambda$0 = SeatReservationAddonViewKt.SeatReservationAddonView$lambda$0(z7, product, i5, seatsState, onStartSeatSelection, onStartSeatsEdit, retrySeatSync, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return SeatReservationAddonView$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeatReservationAddonView$lambda$0(boolean z5, Product product, int i5, AddonsViewModel.ViewState.SeatsState seatsState, Function0 function0, Function0 function02, Function0 function03, int i6, int i7, Composer composer, int i8) {
        SeatReservationAddonView(z5, product, i5, seatsState, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    private static final void SeatRow(final FerrySeat ferrySeat, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1942806005);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(ferrySeat) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1942806005, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.SeatRow (SeatReservationAddonView.kt:218)");
            }
            Alignment.Companion companion = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion.getCenterVertically();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
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
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.seat_selected_checmark_small, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), null, null, null, 0.0f, null, startRestartGroup, 0, 124);
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion2, Dp.m2599constructorimpl(16)), startRestartGroup, 6);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
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
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.selectSeat_seatTitle, new Object[]{ferrySeat.getName()}, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), startRestartGroup, 0, 1572864, 65534);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(4)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(ferrySeat.getSection(), null, AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 384, 1572864, 65530);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.n0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SeatRow$lambda$19;
                    SeatRow$lambda$19 = SeatReservationAddonViewKt.SeatRow$lambda$19(FerrySeat.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SeatRow$lambda$19;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeatRow$lambda$19(FerrySeat ferrySeat, int i5, Composer composer, int i6) {
        SeatRow(ferrySeat, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
