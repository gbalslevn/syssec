package dk.molslinjen.ui.views.shared.routeSelector;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.image.ImageHelper;
import dk.molslinjen.domain.model.config.Subline;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class RouteSelectorKombardoViewKt$citiesListSection$1 implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ String $sectionTitle;
    final /* synthetic */ Subline $subline;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RouteSelectorKombardoViewKt$citiesListSection$1(LazyListState lazyListState, String str, Subline subline) {
        this.$listState = lazyListState;
        this.$sectionTitle = str;
        this.$subline = subline;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$1$lambda$0(LazyListState lazyListState, int i5) {
        return lazyListState.getFirstVisibleItemIndex() >= i5;
    }

    private static final boolean invoke$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope stickyHeaderIndexed, final int i5, Composer composer, int i6) {
        int i7;
        Intrinsics.checkNotNullParameter(stickyHeaderIndexed, "$this$stickyHeaderIndexed");
        if ((i6 & 48) == 0) {
            i7 = i6 | (composer.changed(i5) ? 32 : 16);
        } else {
            i7 = i6;
        }
        if ((i7 & 145) == 144 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1167240995, i7, -1, "dk.molslinjen.ui.views.shared.routeSelector.citiesListSection.<anonymous> (RouteSelectorKombardoView.kt:189)");
        }
        composer.startReplaceGroup(-750209196);
        final LazyListState lazyListState = this.$listState;
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: dk.molslinjen.ui.views.shared.routeSelector.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = RouteSelectorKombardoViewKt$citiesListSection$1.invoke$lambda$1$lambda$0(LazyListState.this, i5);
                    return Boolean.valueOf(invoke$lambda$1$lambda$0);
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        float m2599constructorimpl = Dp.m2599constructorimpl(invoke$lambda$2((State) rememberedValue) ? 6 : 0);
        long m3270getShadowColor0d7_KjU = AppColor.INSTANCE.m3270getShadowColor0d7_KjU();
        final String str = this.$sectionTitle;
        final Subline subline = this.$subline;
        SurfaceKt.m900SurfaceT9BRK9s(null, null, m3270getShadowColor0d7_KjU, 0L, 0.0f, m2599constructorimpl, null, ComposableLambdaKt.rememberComposableLambda(-38415262, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewKt$citiesListSection$1.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i8) {
                if ((i8 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-38415262, i8, -1, "dk.molslinjen.ui.views.shared.routeSelector.citiesListSection.<anonymous>.<anonymous> (RouteSelectorKombardoView.kt:194)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(56)), 0.0f, 1, null);
                AppColor appColor = AppColor.INSTANCE;
                Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(fillMaxWidth$default, appColor.m3269getGrey60d7_KjU(), null, 2, null);
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                String str2 = str;
                Subline subline2 = subline;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m104backgroundbw27NRU$default);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                float f5 = 24;
                TextKt.m940Text4IGK_g(str2, RowScope.weight$default(RowScopeInstance.INSTANCE, PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, 0, 1572864, 65532);
                composer2.startReplaceGroup(1138576412);
                if (subline2 != null) {
                    float f6 = 13;
                    ImageKt.Image(SingletonAsyncImagePainterKt.m2744rememberAsyncImagePainter19ie5dc(ImageHelper.INSTANCE.m3193buildImageUrlC8IHX40(subline2.getIconUrl(), null, Dp.m2597boximpl(Dp.m2599constructorimpl(f6)), composer2, 3456, 2), null, null, null, 0, composer2, 0, 30), subline2.getName(), PaddingKt.m315paddingqDBjuR0$default(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 11, null), null, null, 0.0f, ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, appColor.m3255getBrandBlue10d7_KjU(), 0, 2, null), composer2, 1573248, 56);
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, 12583296, 91);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
