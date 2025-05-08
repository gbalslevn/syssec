package dk.molslinjen.ui.views.shared.routeSelector;

import android.content.Context;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.booking.HarborTravelTime;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.config.Subline;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.IndexHolder;
import dk.molslinjen.ui.views.reusable.ItemIndexedKt;
import dk.molslinjen.ui.views.reusable.LabelCardKt;
import dk.molslinjen.ui.views.screens.booking.departures.rows.TimeToLocationViewKt;
import dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewKt;
import dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a%\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aM\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a?\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tH\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001aW\u0010!\u001a\u00020\u0003*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\tH\u0002¢\u0006\u0004\b!\u0010\"\u001a%\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00172\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0003¢\u0006\u0004\b$\u0010%\u001a1\u0010&\u001a\u00020\u0003*\u00020\u00162\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b&\u0010'¨\u0006*²\u0006\f\u0010)\u001a\u00020(8\nX\u008a\u0084\u0002"}, d2 = {"Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel;", "viewModel", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onRouteSelected", "RouteSelectorKombardoView", "(Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState;", "viewState", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "focusDirection", "Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState$CityRow;", "onSelectedCity", "locationPermissionGranted", "RouteSelectorContent", "(Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "focusedDirection", "selectedFromCity", "selectedToCity", "DestinationsLabelCards", "(Ldk/molslinjen/domain/model/booking/RouteDirection;Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState$CityRow;Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState$CityRow;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/lazy/LazyListScope;", BuildConfig.FLAVOR, "sectionTitle", BuildConfig.FLAVOR, "cityRows", "Ldk/molslinjen/ui/views/reusable/IndexHolder;", "indexCounter", "Landroidx/compose/foundation/lazy/LazyListState;", "listState", "Ldk/molslinjen/domain/model/config/Subline;", "subline", "citiesListSection", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/lang/String;Ljava/util/List;Ldk/molslinjen/ui/views/reusable/IndexHolder;Landroidx/compose/foundation/lazy/LazyListState;Ldk/molslinjen/domain/model/config/Subline;Lkotlin/jvm/functions/Function1;)V", "name", "CityRow", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "timeToHarborView", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState;Lkotlin/jvm/functions/Function0;Ldk/molslinjen/ui/views/reusable/IndexHolder;)V", BuildConfig.FLAVOR, "isSticky", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class RouteSelectorKombardoViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void CityRow(final String str, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1661349523);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i7 = i6;
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1661349523, i7, -1, "dk.molslinjen.ui.views.shared.routeSelector.CityRow (RouteSelectorKombardoView.kt:240)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(56)), 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(1508412590);
            boolean z5 = (i7 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: A4.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CityRow$lambda$19$lambda$18;
                        CityRow$lambda$19$lambda$18 = RouteSelectorKombardoViewKt.CityRow$lambda$19$lambda$18(Function0.this);
                        return CityRow$lambda$19$lambda$18;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(fillMaxWidth$default, false, null, null, (Function0) rememberedValue, 7, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
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
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_pin, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(24), 0.0f, Dp.m2599constructorimpl(8), 0.0f, 10, null), null, null, 0.0f, null, startRestartGroup, 384, 120);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer2, i7 & 14, 1572864, 65534);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: A4.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CityRow$lambda$21;
                    CityRow$lambda$21 = RouteSelectorKombardoViewKt.CityRow$lambda$21(str, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CityRow$lambda$21;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CityRow$lambda$19$lambda$18(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CityRow$lambda$21(String str, Function0 function0, int i5, Composer composer, int i6) {
        CityRow(str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void DestinationsLabelCards(final RouteDirection routeDirection, final RouteSelectorKombardoViewModel.ViewState.CityRow cityRow, final RouteSelectorKombardoViewModel.ViewState.CityRow cityRow2, final Function1<? super RouteDirection, Unit> function1, Composer composer, final int i5) {
        int i6;
        String str;
        String str2;
        boolean z5;
        float m2599constructorimpl;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1202228290);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(routeDirection) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(cityRow) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(cityRow2) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1202228290, i6, -1, "dk.molslinjen.ui.views.shared.routeSelector.DestinationsLabelCards (RouteSelectorKombardoView.kt:143)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 24;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), 2, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(25)), Alignment.INSTANCE.getTop(), startRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            boolean z6 = routeDirection == RouteDirection.Outbound;
            String stringResource = StringResources_androidKt.stringResource(R.string.common_from, startRestartGroup, 6);
            if (cityRow == null || (str = cityRow.getName()) == null) {
                str = BuildConfig.FLAVOR;
            }
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
            long m3255getBrandBlue10d7_KjU = z6 ? AppColor.INSTANCE.m3255getBrandBlue10d7_KjU() : cityRow != null ? AppColor.INSTANCE.m3253getBrandBlack10d7_KjU() : AppColor.INSTANCE.m3267getGrey40d7_KjU();
            float m2599constructorimpl2 = Dp.m2599constructorimpl(z6 ? 2 : 1);
            startRestartGroup.startReplaceGroup(-1199720049);
            int i7 = i6 & 7168;
            boolean z7 = i7 == 2048;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: A4.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DestinationsLabelCards$lambda$16$lambda$13$lambda$12;
                        DestinationsLabelCards$lambda$16$lambda$13$lambda$12 = RouteSelectorKombardoViewKt.DestinationsLabelCards$lambda$16$lambda$13$lambda$12(Function1.this);
                        return DestinationsLabelCards$lambda$16$lambda$13$lambda$12;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            LabelCardKt.m3391LabelCardTek12BE(stringResource, str, weight$default, null, null, null, true, m3255getBrandBlue10d7_KjU, m2599constructorimpl2, (Function0) rememberedValue, startRestartGroup, 1572864, 56);
            boolean z8 = routeDirection == RouteDirection.Return;
            String stringResource2 = StringResources_androidKt.stringResource(R.string.common_to, startRestartGroup, 6);
            if (cityRow2 == null || (str2 = cityRow2.getName()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
            long m3255getBrandBlue10d7_KjU2 = z8 ? AppColor.INSTANCE.m3255getBrandBlue10d7_KjU() : cityRow2 != null ? AppColor.INSTANCE.m3253getBrandBlack10d7_KjU() : AppColor.INSTANCE.m3267getGrey40d7_KjU();
            if (z8) {
                m2599constructorimpl = Dp.m2599constructorimpl(2);
                z5 = true;
            } else {
                z5 = true;
                m2599constructorimpl = Dp.m2599constructorimpl(1);
            }
            startRestartGroup.startReplaceGroup(-1199700275);
            boolean z9 = i7 == 2048 ? z5 : false;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: A4.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DestinationsLabelCards$lambda$16$lambda$15$lambda$14;
                        DestinationsLabelCards$lambda$16$lambda$15$lambda$14 = RouteSelectorKombardoViewKt.DestinationsLabelCards$lambda$16$lambda$15$lambda$14(Function1.this);
                        return DestinationsLabelCards$lambda$16$lambda$15$lambda$14;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LabelCardKt.m3391LabelCardTek12BE(stringResource2, str2, weight$default2, null, null, null, true, m3255getBrandBlue10d7_KjU2, m2599constructorimpl, (Function0) rememberedValue2, composer2, 1572864, 56);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: A4.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DestinationsLabelCards$lambda$17;
                    DestinationsLabelCards$lambda$17 = RouteSelectorKombardoViewKt.DestinationsLabelCards$lambda$17(RouteDirection.this, cityRow, cityRow2, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DestinationsLabelCards$lambda$17;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DestinationsLabelCards$lambda$16$lambda$13$lambda$12(Function1 function1) {
        function1.invoke(RouteDirection.Outbound);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DestinationsLabelCards$lambda$16$lambda$15$lambda$14(Function1 function1) {
        function1.invoke(RouteDirection.Return);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DestinationsLabelCards$lambda$17(RouteDirection routeDirection, RouteSelectorKombardoViewModel.ViewState.CityRow cityRow, RouteSelectorKombardoViewModel.ViewState.CityRow cityRow2, Function1 function1, int i5, Composer composer, int i6) {
        DestinationsLabelCards(routeDirection, cityRow, cityRow2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void RouteSelectorContent(final RouteSelectorKombardoViewModel.ViewState viewState, final Function1<? super RouteDirection, Unit> function1, final Function1<? super RouteSelectorKombardoViewModel.ViewState.CityRow, Unit> function12, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        LazyListState lazyListState;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-793434808);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        int i7 = i6;
        if ((i7 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-793434808, i7, -1, "dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorContent (RouteSelectorKombardoView.kt:64)");
            }
            DestinationsLabelCards(viewState.getFocusedDirection(), viewState.getSelectedFromCity(), viewState.getSelectedToCity(), function1, startRestartGroup, (i7 << 6) & 7168);
            final String stringResource = StringResources_androidKt.stringResource(R.string.departures_routeSelector_allCities, startRestartGroup, 6);
            final String stringResource2 = StringResources_androidKt.stringResource(R.string.departures_routeSelector_frequentlyUsedCities, startRestartGroup, 6);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            final LazyListState lazyListState2 = new LazyListState(0, 0, 3, null);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            PaddingValues m310PaddingValuesa9UjIt4$default = PaddingKt.m310PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(24), 7, null);
            startRestartGroup.startReplaceGroup(594948602);
            boolean changedInstance = startRestartGroup.changedInstance(viewState) | ((i7 & 7168) == 2048) | startRestartGroup.changed(stringResource2) | startRestartGroup.changed(lazyListState2) | startRestartGroup.changedInstance(coroutineScope) | ((i7 & 896) == 256) | startRestartGroup.changed(stringResource);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                lazyListState = lazyListState2;
                Function1 function13 = new Function1() { // from class: A4.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit RouteSelectorContent$lambda$10$lambda$9;
                        RouteSelectorContent$lambda$10$lambda$9 = RouteSelectorKombardoViewKt.RouteSelectorContent$lambda$10$lambda$9(RouteSelectorKombardoViewModel.ViewState.this, function0, stringResource2, lazyListState2, stringResource, coroutineScope, function12, (LazyListScope) obj);
                        return RouteSelectorContent$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(function13);
                rememberedValue2 = function13;
            } else {
                lazyListState = lazyListState2;
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LazyDslKt.LazyColumn(fillMaxWidth$default, lazyListState, m310PaddingValuesa9UjIt4$default, false, null, null, null, false, (Function1) rememberedValue2, composer2, 390, 248);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: A4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RouteSelectorContent$lambda$11;
                    RouteSelectorContent$lambda$11 = RouteSelectorKombardoViewKt.RouteSelectorContent$lambda$11(RouteSelectorKombardoViewModel.ViewState.this, function1, function12, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return RouteSelectorContent$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorContent$lambda$10$lambda$9(RouteSelectorKombardoViewModel.ViewState viewState, Function0 function0, String str, final LazyListState lazyListState, String str2, final CoroutineScope coroutineScope, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        IndexHolder indexHolder = new IndexHolder(0, 1, null);
        timeToHarborView(LazyColumn, viewState, function0, indexHolder);
        if (!viewState.getFrequentlyUsedCityRows().isEmpty()) {
            citiesListSection(LazyColumn, str, viewState.getFrequentlyUsedCityRows(), indexHolder, lazyListState, null, new Function1() { // from class: A4.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit RouteSelectorContent$lambda$10$lambda$9$lambda$6;
                    RouteSelectorContent$lambda$10$lambda$9$lambda$6 = RouteSelectorKombardoViewKt.RouteSelectorContent$lambda$10$lambda$9$lambda$6(CoroutineScope.this, function1, lazyListState, (RouteSelectorKombardoViewModel.ViewState.CityRow) obj);
                    return RouteSelectorContent$lambda$10$lambda$9$lambda$6;
                }
            });
        }
        List<RouteSelectorKombardoViewModel.ViewState.AreaGroup> areaGroups = viewState.getAreaGroups();
        if (areaGroups != null) {
            for (RouteSelectorKombardoViewModel.ViewState.AreaGroup areaGroup : areaGroups) {
                citiesListSection(LazyColumn, areaGroup.getName(), areaGroup.getCityRows(), indexHolder, lazyListState, areaGroup.getSubline(), new Function1() { // from class: A4.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit RouteSelectorContent$lambda$10$lambda$9$lambda$7;
                        RouteSelectorContent$lambda$10$lambda$9$lambda$7 = RouteSelectorKombardoViewKt.RouteSelectorContent$lambda$10$lambda$9$lambda$7(CoroutineScope.this, function1, lazyListState, (RouteSelectorKombardoViewModel.ViewState.CityRow) obj);
                        return RouteSelectorContent$lambda$10$lambda$9$lambda$7;
                    }
                });
            }
        } else {
            citiesListSection(LazyColumn, str2, viewState.getCityRows(), indexHolder, lazyListState, null, new Function1() { // from class: A4.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit RouteSelectorContent$lambda$10$lambda$9$lambda$8;
                    RouteSelectorContent$lambda$10$lambda$9$lambda$8 = RouteSelectorKombardoViewKt.RouteSelectorContent$lambda$10$lambda$9$lambda$8(CoroutineScope.this, function1, lazyListState, (RouteSelectorKombardoViewModel.ViewState.CityRow) obj);
                    return RouteSelectorContent$lambda$10$lambda$9$lambda$8;
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorContent$lambda$10$lambda$9$lambda$6(CoroutineScope coroutineScope, Function1 function1, LazyListState lazyListState, RouteSelectorKombardoViewModel.ViewState.CityRow it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new RouteSelectorKombardoViewKt$RouteSelectorContent$1$1$1$1(lazyListState, null), 3, null);
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorContent$lambda$10$lambda$9$lambda$7(CoroutineScope coroutineScope, Function1 function1, LazyListState lazyListState, RouteSelectorKombardoViewModel.ViewState.CityRow it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new RouteSelectorKombardoViewKt$RouteSelectorContent$1$1$2$1(lazyListState, null), 3, null);
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorContent$lambda$10$lambda$9$lambda$8(CoroutineScope coroutineScope, Function1 function1, LazyListState lazyListState, RouteSelectorKombardoViewModel.ViewState.CityRow it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new RouteSelectorKombardoViewKt$RouteSelectorContent$1$1$3$1(lazyListState, null), 3, null);
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorContent$lambda$11(RouteSelectorKombardoViewModel.ViewState viewState, Function1 function1, Function1 function12, Function0 function0, int i5, Composer composer, int i6) {
        RouteSelectorContent(viewState, function1, function12, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void RouteSelectorKombardoView(final RouteSelectorKombardoViewModel viewModel, final Function0<Unit> onRouteSelected, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onRouteSelected, "onRouteSelected");
        Composer startRestartGroup = composer.startRestartGroup(549165898);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(onRouteSelected) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(549165898, i6, -1, "dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoView (RouteSelectorKombardoView.kt:42)");
            }
            RouteSelectorKombardoViewModel.ViewState viewState = (RouteSelectorKombardoViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            startRestartGroup.startReplaceGroup(1950003242);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new RouteSelectorKombardoViewKt$RouteSelectorKombardoView$1$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue);
            startRestartGroup.startReplaceGroup(1950004948);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | ((i6 & 112) == 32);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: A4.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit RouteSelectorKombardoView$lambda$2$lambda$1;
                        RouteSelectorKombardoView$lambda$2$lambda$1 = RouteSelectorKombardoViewKt.RouteSelectorKombardoView$lambda$2$lambda$1(RouteSelectorKombardoViewModel.this, onRouteSelected, (RouteSelectorKombardoViewModel.ViewState.CityRow) obj);
                        return RouteSelectorKombardoView$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function1 function12 = (Function1) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1950008319);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changedInstance(context);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: A4.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit RouteSelectorKombardoView$lambda$4$lambda$3;
                        RouteSelectorKombardoView$lambda$4$lambda$3 = RouteSelectorKombardoViewKt.RouteSelectorKombardoView$lambda$4$lambda$3(RouteSelectorKombardoViewModel.this, context);
                        return RouteSelectorKombardoView$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            RouteSelectorContent(viewState, function1, function12, (Function0) rememberedValue3, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: A4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RouteSelectorKombardoView$lambda$5;
                    RouteSelectorKombardoView$lambda$5 = RouteSelectorKombardoViewKt.RouteSelectorKombardoView$lambda$5(RouteSelectorKombardoViewModel.this, onRouteSelected, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return RouteSelectorKombardoView$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorKombardoView$lambda$2$lambda$1(RouteSelectorKombardoViewModel routeSelectorKombardoViewModel, Function0 function0, RouteSelectorKombardoViewModel.ViewState.CityRow it) {
        Intrinsics.checkNotNullParameter(it, "it");
        routeSelectorKombardoViewModel.selectedCity(it, function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorKombardoView$lambda$4$lambda$3(RouteSelectorKombardoViewModel routeSelectorKombardoViewModel, Context context) {
        routeSelectorKombardoViewModel.locationPermissionGranted(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorKombardoView$lambda$5(RouteSelectorKombardoViewModel routeSelectorKombardoViewModel, Function0 function0, int i5, Composer composer, int i6) {
        RouteSelectorKombardoView(routeSelectorKombardoViewModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void citiesListSection(LazyListScope lazyListScope, String str, List<RouteSelectorKombardoViewModel.ViewState.CityRow> list, IndexHolder indexHolder, LazyListState lazyListState, Subline subline, Function1<? super RouteSelectorKombardoViewModel.ViewState.CityRow, Unit> function1) {
        ItemIndexedKt.stickyHeaderIndexed$default(lazyListScope, indexHolder, null, null, ComposableLambdaKt.composableLambdaInstance(-1167240995, true, new RouteSelectorKombardoViewKt$citiesListSection$1(lazyListState, str, subline)), 6, null);
        Iterator<T> it = list.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            ItemIndexedKt.itemIndexed$default(lazyListScope, indexHolder, null, null, ComposableLambdaKt.composableLambdaInstance(-1499815562, true, new RouteSelectorKombardoViewKt$citiesListSection$2((RouteSelectorKombardoViewModel.ViewState.CityRow) it.next(), function1, i5, list)), 6, null);
            i5++;
        }
    }

    private static final void timeToHarborView(LazyListScope lazyListScope, final RouteSelectorKombardoViewModel.ViewState viewState, final Function0<Unit> function0, IndexHolder indexHolder) {
        ItemIndexedKt.itemIndexed$default(lazyListScope, indexHolder, null, null, ComposableLambdaKt.composableLambdaInstance(1323881316, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewKt$timeToHarborView$1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope itemIndexed, int i5, Composer composer, int i6) {
                Intrinsics.checkNotNullParameter(itemIndexed, "$this$itemIndexed");
                if ((i6 & 129) == 128 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1323881316, i6, -1, "dk.molslinjen.ui.views.shared.routeSelector.timeToHarborView.<anonymous> (RouteSelectorKombardoView.kt:269)");
                }
                float f5 = 24;
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(16), 2, null);
                HarborTravelTime harborTravelTime = RouteSelectorKombardoViewModel.ViewState.this.getHarborTravelTime();
                String publicTransportationTime = harborTravelTime != null ? harborTravelTime.getPublicTransportationTime() : null;
                HarborTravelTime harborTravelTime2 = RouteSelectorKombardoViewModel.ViewState.this.getHarborTravelTime();
                String walkingTime = harborTravelTime2 != null ? harborTravelTime2.getWalkingTime() : null;
                HarborTravelTime harborTravelTime3 = RouteSelectorKombardoViewModel.ViewState.this.getHarborTravelTime();
                TimeToLocationViewKt.NearestLocationView(m315paddingqDBjuR0$default, publicTransportationTime, walkingTime, harborTravelTime3 != null ? harborTravelTime3.getNearestCity() : null, function0, composer, 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
    }
}
