package dk.molslinjen.ui.views.screens.booking.departures.selectTrailers;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.image.ImageHelper;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.domain.model.booking.product.presentation.ImageProductPresentation;
import dk.molslinjen.domain.model.booking.product.presentation.ProductPresentation;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.LabelCardKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a5\u0010\u0006\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0003¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "selectedTrailer", "Lkotlin/Function0;", BuildConfig.FLAVOR, "showTrailerSelector", "removeSelectedTrailer", "TrailerSelectorView", "(Ldk/molslinjen/domain/model/booking/product/TrailerProduct;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AddView", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TrailerSelectorViewKt {
    private static final void AddView(final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1482110018);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1482110018, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.AddView (TrailerSelectorView.kt:50)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 8;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 1, null);
            startRestartGroup.startReplaceGroup(-1863245954);
            boolean z5 = (i6 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: Q2.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AddView$lambda$5$lambda$4;
                        AddView$lambda$5$lambda$4 = TrailerSelectorViewKt.AddView$lambda$5$lambda$4(Function0.this);
                        return AddView$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(m313paddingVpY3zN4$default, false, null, null, (Function0) rememberedValue, 7, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default);
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
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_plus_button, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), null, null, null, 0.0f, null, startRestartGroup, 0, 124);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.transportProducts_addTrailer_headline, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), AppColor.INSTANCE.m3281getWhite0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, 432, 1572864, 65528);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Q2.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AddView$lambda$7;
                    AddView$lambda$7 = TrailerSelectorViewKt.AddView$lambda$7(Function0.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AddView$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddView$lambda$5$lambda$4(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddView$lambda$7(Function0 function0, int i5, Composer composer, int i6) {
        AddView(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void TrailerSelectorView(final TrailerProduct trailerProduct, final Function0<Unit> showTrailerSelector, Function0<Unit> removeSelectedTrailer, Composer composer, final int i5) {
        int i6;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(showTrailerSelector, "showTrailerSelector");
        Intrinsics.checkNotNullParameter(removeSelectedTrailer, "removeSelectedTrailer");
        Composer startRestartGroup = composer.startRestartGroup(1859133545);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(trailerProduct) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(showTrailerSelector) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(removeSelectedTrailer) ? 256 : 128;
        }
        int i7 = i6;
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            function0 = removeSelectedTrailer;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1859133545, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorView (TrailerSelectorView.kt:25)");
            }
            if (trailerProduct != null) {
                startRestartGroup.startReplaceGroup(-429343427);
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
                String stringResource = StringResources_androidKt.stringResource(R.string.trailer_headline, startRestartGroup, 6);
                String name = trailerProduct.getName();
                ImageHelper imageHelper = ImageHelper.INSTANCE;
                ProductPresentation presentation = trailerProduct.getPresentation();
                ImageProductPresentation imageProductPresentation = presentation instanceof ImageProductPresentation ? (ImageProductPresentation) presentation : null;
                float f5 = 24;
                function0 = removeSelectedTrailer;
                LabelCardKt.m3391LabelCardTek12BE(stringResource, name, RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), null, imageHelper.m3193buildImageUrlC8IHX40(imageProductPresentation != null ? imageProductPresentation.getImageUrl() : null, null, Dp.m2597boximpl(Dp.m2599constructorimpl(f5)), startRestartGroup, 3456, 2), null, false, 0L, 0.0f, showTrailerSelector, startRestartGroup, (i7 << 24) & 1879048192, 488);
                Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_minus_button, startRestartGroup, 6);
                String skip = Accessibility.INSTANCE.getSkip();
                float f6 = 16;
                Modifier m331size3ABfNKs = SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6), 0.0f, Dp.m2599constructorimpl(f6), 4, null), Dp.m2599constructorimpl(f5));
                startRestartGroup.startReplaceGroup(1490889076);
                boolean z5 = (i7 & 896) == 256;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: Q2.l
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit TrailerSelectorView$lambda$2$lambda$1$lambda$0;
                            TrailerSelectorView$lambda$2$lambda$1$lambda$0 = TrailerSelectorViewKt.TrailerSelectorView$lambda$2$lambda$1$lambda$0(Function0.this);
                            return TrailerSelectorView$lambda$2$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                ImageKt.Image(painterResource, skip, ClickableKt.m122clickableXHw0xAI$default(m331size3ABfNKs, false, null, null, (Function0) rememberedValue, 7, null), null, null, 0.0f, null, startRestartGroup, 0, 120);
                startRestartGroup.endNode();
                startRestartGroup.endReplaceGroup();
            } else {
                function0 = removeSelectedTrailer;
                startRestartGroup.startReplaceGroup(-428525306);
                AddView(showTrailerSelector, startRestartGroup, (i7 >> 3) & 14);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Function0<Unit> function02 = function0;
            endRestartGroup.updateScope(new Function2() { // from class: Q2.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TrailerSelectorView$lambda$3;
                    TrailerSelectorView$lambda$3 = TrailerSelectorViewKt.TrailerSelectorView$lambda$3(TrailerProduct.this, showTrailerSelector, function02, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TrailerSelectorView$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrailerSelectorView$lambda$2$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrailerSelectorView$lambda$3(TrailerProduct trailerProduct, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        TrailerSelectorView(trailerProduct, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
