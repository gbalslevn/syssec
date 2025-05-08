package dk.molslinjen.ui.views.screens.booking.departures.rows.departure;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import dk.molslinjen.core.Environment;
import dk.molslinjen.core.Feature;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.booking.CheapestTicketType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.Ferry;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.extensions.LayoutCoordinatesExtensionsKt;
import dk.molslinjen.extensions.domain.TicketCategoryExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.AutoShrinkTextKt;
import dk.molslinjen.ui.views.reusable.VerticalDividerKt;
import dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureRowViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001aS\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001aK\u0010\u0012\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0085\u0001\u0010\u001f\u001a\u00020\b2\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00142\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00142\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00142\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00142\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\rH\u0003¢\u0006\u0004\b\u001f\u0010 \u001a]\u0010$\u001a\u00020\b*\u00020!2\u0006\u0010\u0010\u001a\u00020\u00042\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\rH\u0003¢\u0006\u0004\b$\u0010%\u001a\u0013\u0010'\u001a\u00020\b*\u00020&H\u0003¢\u0006\u0004\b'\u0010(\u001a\u0017\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020)H\u0003¢\u0006\u0004\b+\u0010,\u001a\u0013\u0010-\u001a\u00020\b*\u00020&H\u0003¢\u0006\u0004\b-\u0010(¨\u0006."}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Ldk/molslinjen/domain/model/booking/Departure;", "departure", BuildConfig.FLAVOR, "selected", "enabled", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onSelected", "inSelectForSaleOnBoardMode", "DepartureRowView", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/booking/Departure;ZZLkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/MutableState;", BuildConfig.FLAVOR, "height", "showDisabled", "customRouteInfoBoxHeight", "DepartureContentView", "(Landroidx/compose/runtime/MutableState;Ldk/molslinjen/domain/model/booking/Departure;ZZLandroidx/compose/runtime/MutableState;ZLandroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "departureTextCoordinates", "detailsContainerCoordinates", "priceBoxCoordinates", "fewTicketsBannerCoordinates", "cheapestTicketTypeBannerCoordinates", "showFewTicketLeftBanner", "showCheapestTicketTypeBanner", BuildConfig.FLAVOR, "spacerHeight", "CalculateSpacerHeight", "(Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Ldk/molslinjen/domain/model/booking/Departure;Landroidx/compose/runtime/State;ZZLandroidx/compose/runtime/MutableState;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/layout/RowScope;", "Ldk/molslinjen/domain/model/booking/CheapestTicketType;", "cheapestTicketType", "RightDepartureSection", "(Landroidx/compose/foundation/layout/RowScope;ZLandroidx/compose/runtime/MutableState;ZLdk/molslinjen/domain/model/booking/Departure;ZLdk/molslinjen/domain/model/booking/CheapestTicketType;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/layout/BoxScope;", "SelectForSaleOnBoardIcon", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "text", "CustomRouteInfoBox", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "FewTicketsAvailableBanner", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DepartureRowViewKt {
    private static final void CalculateSpacerHeight(final State<? extends LayoutCoordinates> state, final State<? extends LayoutCoordinates> state2, final State<? extends LayoutCoordinates> state3, final State<? extends LayoutCoordinates> state4, final Departure departure, final State<? extends LayoutCoordinates> state5, final boolean z5, final boolean z6, final MutableState<Float> mutableState, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-521203836);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(state) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(state2) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(state3) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(state4) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(departure) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(state5) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i6 |= startRestartGroup.changed(mutableState) ? 67108864 : 33554432;
        }
        if ((i6 & 38347923) == 38347922 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-521203836, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.departure.CalculateSpacerHeight (DepartureRowView.kt:242)");
            }
            LayoutCoordinates value = state.getValue();
            Rect safeBoundsInWindow = value != null ? LayoutCoordinatesExtensionsKt.safeBoundsInWindow(value) : null;
            LayoutCoordinates value2 = state2.getValue();
            Rect safeBoundsInWindow2 = value2 != null ? LayoutCoordinatesExtensionsKt.safeBoundsInWindow(value2) : null;
            LayoutCoordinates value3 = state4.getValue();
            Rect safeBoundsInWindow3 = value3 != null ? LayoutCoordinatesExtensionsKt.safeBoundsInWindow(value3) : null;
            LayoutCoordinates value4 = state5.getValue();
            Rect safeBoundsInWindow4 = value4 != null ? LayoutCoordinatesExtensionsKt.safeBoundsInWindow(value4) : null;
            LayoutCoordinates value5 = state3.getValue();
            Rect safeBoundsInWindow5 = value5 != null ? LayoutCoordinatesExtensionsKt.safeBoundsInWindow(value5) : null;
            Ferry ferry = departure.getFerry();
            String name = ferry != null ? ferry.getName() : null;
            CheapestTicketType cheapestTicketType = departure.getCheapestTicketType();
            Object[] objArr = {safeBoundsInWindow, safeBoundsInWindow5, safeBoundsInWindow3, name, cheapestTicketType != null ? cheapestTicketType.getTicketTypeName() : null};
            startRestartGroup.startReplaceGroup(1664204757);
            boolean changed = ((i6 & 3670016) == 1048576) | startRestartGroup.changed(safeBoundsInWindow) | startRestartGroup.changed(safeBoundsInWindow2) | startRestartGroup.changed(safeBoundsInWindow5) | startRestartGroup.changed(safeBoundsInWindow3) | startRestartGroup.changed(safeBoundsInWindow4) | ((29360128 & i6) == 8388608) | ((i6 & 234881024) == 67108864);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new DepartureRowViewKt$CalculateSpacerHeight$1$1(safeBoundsInWindow, safeBoundsInWindow2, safeBoundsInWindow5, safeBoundsInWindow3, safeBoundsInWindow4, z5, z6, mutableState, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(objArr, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: N2.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CalculateSpacerHeight$lambda$27;
                    CalculateSpacerHeight$lambda$27 = DepartureRowViewKt.CalculateSpacerHeight$lambda$27(State.this, state2, state3, state4, departure, state5, z5, z6, mutableState, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CalculateSpacerHeight$lambda$27;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CalculateSpacerHeight$lambda$27(State state, State state2, State state3, State state4, Departure departure, State state5, boolean z5, boolean z6, MutableState mutableState, int i5, Composer composer, int i6) {
        CalculateSpacerHeight(state, state2, state3, state4, departure, state5, z5, z6, mutableState, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void CustomRouteInfoBox(final String str, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-2089119059);
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
                ComposerKt.traceEventStart(-2089119059, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.departure.CustomRouteInfoBox (DepartureRowView.kt:398)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            AppColor appColor = AppColor.INSTANCE;
            float f5 = 8;
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m103backgroundbw27NRU(companion, appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getSmall()), Dp.m2599constructorimpl(16), Dp.m2599constructorimpl(f5));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
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
            if (Environment.INSTANCE.isKombardo()) {
                startRestartGroup.startReplaceGroup(1804965781);
                Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_bus, startRestartGroup, 6);
                Accessibility accessibility = Accessibility.INSTANCE;
                IconKt.m857Iconww6aTOc(painterResource, accessibility.getSkip(), (Modifier) null, appColor.m3266getGrey30d7_KjU(), startRestartGroup, 3072, 4);
                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_bus, startRestartGroup, 6), accessibility.getSkip(), PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(3), 0.0f, 0.0f, 0.0f, 14, null), appColor.m3266getGrey30d7_KjU(), startRestartGroup, 3456, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1805422008);
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_clock, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), null, null, null, 0.0f, null, startRestartGroup, 0, 124);
                startRestartGroup.endReplaceGroup();
            }
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(str, PaddingKt.m315paddingqDBjuR0$default(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, i6 & 14, 1572864, 65532);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: N2.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CustomRouteInfoBox$lambda$39;
                    CustomRouteInfoBox$lambda$39 = DepartureRowViewKt.CustomRouteInfoBox$lambda$39(str, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CustomRouteInfoBox$lambda$39;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomRouteInfoBox$lambda$39(String str, int i5, Composer composer, int i6) {
        CustomRouteInfoBox(str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DepartureContentView(final MutableState<Integer> mutableState, final Departure departure, final boolean z5, final boolean z6, final MutableState<Integer> mutableState2, final boolean z7, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-726363013);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(mutableState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(departure) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(mutableState2) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(z7) ? 131072 : 65536;
        }
        int i7 = i6;
        if ((74899 & i7) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-726363013, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureContentView (DepartureRowView.kt:137)");
            }
            boolean z8 = (!departure.getLimitedAvailability() || z6 || z7) ? false : true;
            CheapestTicketType cheapestTicketType = departure.getCheapestTicketType();
            boolean z9 = (!Feature.MultipleTicketTypes.isEnabled() || cheapestTicketType == null || z7 || z8) ? false : true;
            startRestartGroup.startReplaceGroup(-1509127943);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1509124999);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1509122311);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState5 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1509119367);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState6 = (MutableState) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1509116167);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            MutableState mutableState7 = (MutableState) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1509113720);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            MutableFloatState mutableFloatState = (MutableFloatState) rememberedValue6;
            startRestartGroup.endReplaceGroup();
            int i8 = (i7 << 9) & 57344;
            CalculateSpacerHeight(mutableState3, mutableState4, mutableState5, mutableState6, departure, mutableState7, z8, z9, mutableFloatState, startRestartGroup, i8 | 100863414);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion4.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(232894276);
            boolean z10 = (i7 & 14) == 4;
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (z10 || rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = new Function1() { // from class: N2.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DepartureContentView$lambda$24$lambda$9$lambda$8;
                        DepartureContentView$lambda$24$lambda$9$lambda$8 = DepartureRowViewKt.DepartureContentView$lambda$24$lambda$9$lambda$8(MutableState.this, (LayoutCoordinates) obj);
                        return DepartureContentView$lambda$24$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue7);
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned);
            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier height = IntrinsicKt.height(companion2, IntrinsicSize.Max);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, height);
            Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            float f5 = 16;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(RowScope.weight$default(rowScopeInstance, companion2, 3.0f, false, 2, null), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(12), 0.0f, Dp.m2599constructorimpl(10), 4, null);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor4 = companion4.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl4, columnMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion4.getSetModifier());
            startRestartGroup.startReplaceGroup(-1765237921);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = new Function1() { // from class: N2.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DepartureContentView$lambda$24$lambda$20$lambda$15$lambda$14$lambda$11$lambda$10;
                        DepartureContentView$lambda$24$lambda$20$lambda$15$lambda$14$lambda$11$lambda$10 = DepartureRowViewKt.DepartureContentView$lambda$24$lambda$20$lambda$15$lambda$14$lambda$11$lambda$10(MutableState.this, (LayoutCoordinates) obj);
                        return DepartureContentView$lambda$24$lambda$20$lambda$15$lambda$14$lambda$11$lambda$10;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            Function1 function1 = (Function1) rememberedValue8;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1765231742);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == companion.getEmpty()) {
                rememberedValue9 = new Function1() { // from class: N2.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DepartureContentView$lambda$24$lambda$20$lambda$15$lambda$14$lambda$13$lambda$12;
                        DepartureContentView$lambda$24$lambda$20$lambda$15$lambda$14$lambda$13$lambda$12 = DepartureRowViewKt.DepartureContentView$lambda$24$lambda$20$lambda$15$lambda$14$lambda$13$lambda$12(MutableState.this, (LayoutCoordinates) obj);
                        return DepartureContentView$lambda$24$lambda$20$lambda$15$lambda$14$lambda$13$lambda$12;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            Function1 function12 = (Function1) rememberedValue9;
            startRestartGroup.endReplaceGroup();
            int i9 = i7 << 3;
            DepartureInfoSectionViewKt.DepartureInfoSection(function1, function12, departure, z5, false, startRestartGroup, (i9 & 7168) | (i9 & 896) | 54, 16);
            startRestartGroup.endNode();
            float f6 = 8;
            boolean z11 = true;
            VerticalDividerKt.m3394VerticalDividertZIQpXc(SizeKt.fillMaxHeight$default(PaddingKt.m314paddingqDBjuR0(companion2, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6)), 0.0f, 1, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(2)), startRestartGroup, 3072, 6);
            RightDepartureSection(rowScopeInstance, z5, mutableState5, z7, departure, z9, cheapestTicketType, mutableState7, startRestartGroup, ((i7 >> 3) & 112) | 12583302 | ((i7 >> 6) & 7168) | i8);
            startRestartGroup.endNode();
            composer2 = startRestartGroup;
            BoxKt.Box(SizeKt.m325height3ABfNKs(companion2, ComposeExtensionsKt.pxToDp(mutableFloatState.getFloatValue(), composer2, 0)), composer2, 0);
            String customRouteTypeText = departure.getCustomRouteTypeText();
            composer2.startReplaceGroup(1093282803);
            if (customRouteTypeText != null) {
                composer2.startReplaceGroup(1471842996);
                if ((i7 & 57344) != 16384) {
                    z11 = false;
                }
                Object rememberedValue10 = composer2.rememberedValue();
                if (z11 || rememberedValue10 == companion.getEmpty()) {
                    rememberedValue10 = new Function1() { // from class: N2.q
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit DepartureContentView$lambda$24$lambda$20$lambda$19$lambda$17$lambda$16;
                            DepartureContentView$lambda$24$lambda$20$lambda$19$lambda$17$lambda$16 = DepartureRowViewKt.DepartureContentView$lambda$24$lambda$20$lambda$19$lambda$17$lambda$16(MutableState.this, (LayoutCoordinates) obj);
                            return DepartureContentView$lambda$24$lambda$20$lambda$19$lambda$17$lambda$16;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue10);
                }
                composer2.endReplaceGroup();
                Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue10), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6));
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer2, m312paddingVpY3zN4);
                Function0<ComposeUiNode> constructor5 = companion4.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor5);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl5 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl5, maybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl5, currentCompositionLocalMap5, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl5.getInserting() || !Intrinsics.areEqual(m1226constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    m1226constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    m1226constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                }
                Updater.m1227setimpl(m1226constructorimpl5, materializeModifier5, companion4.getSetModifier());
                CustomRouteInfoBox(customRouteTypeText, composer2, 0);
                composer2.endNode();
                Unit unit = Unit.INSTANCE;
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            composer2.startReplaceGroup(232966131);
            if (z8) {
                composer2.startReplaceGroup(232967612);
                float pxToDp = mutableState2.getValue().intValue() > 0 ? ComposeExtensionsKt.pxToDp(mutableState2.getValue().intValue(), composer2, 0) : Dp.m2599constructorimpl(f6);
                composer2.endReplaceGroup();
                Alignment bottomEnd = companion3.getBottomEnd();
                Modifier align = boxScopeInstance.align(PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), pxToDp, 3, null), companion3.getBottomEnd());
                composer2.startReplaceGroup(232979005);
                Object rememberedValue11 = composer2.rememberedValue();
                if (rememberedValue11 == companion.getEmpty()) {
                    rememberedValue11 = new Function1() { // from class: N2.r
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit DepartureContentView$lambda$24$lambda$22$lambda$21;
                            DepartureContentView$lambda$24$lambda$22$lambda$21 = DepartureRowViewKt.DepartureContentView$lambda$24$lambda$22$lambda$21(MutableState.this, (LayoutCoordinates) obj);
                            return DepartureContentView$lambda$24$lambda$22$lambda$21;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue11);
                }
                composer2.endReplaceGroup();
                Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(align, (Function1) rememberedValue11);
                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(bottomEnd, false);
                int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(composer2, onGloballyPositioned2);
                Function0<ComposeUiNode> constructor6 = companion4.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor6);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl6 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl6, maybeCachedBoxMeasurePolicy3, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl6, currentCompositionLocalMap6, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl6.getInserting() || !Intrinsics.areEqual(m1226constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                    m1226constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                    m1226constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                }
                Updater.m1227setimpl(m1226constructorimpl6, materializeModifier6, companion4.getSetModifier());
                FewTicketsAvailableBanner(boxScopeInstance, composer2, 6);
                composer2.endNode();
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: N2.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DepartureContentView$lambda$25;
                    DepartureContentView$lambda$25 = DepartureRowViewKt.DepartureContentView$lambda$25(MutableState.this, departure, z5, z6, mutableState2, z7, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DepartureContentView$lambda$25;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureContentView$lambda$24$lambda$20$lambda$15$lambda$14$lambda$11$lambda$10(MutableState mutableState, LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
        mutableState.setValue(layoutCoordinates);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureContentView$lambda$24$lambda$20$lambda$15$lambda$14$lambda$13$lambda$12(MutableState mutableState, LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
        mutableState.setValue(layoutCoordinates);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureContentView$lambda$24$lambda$20$lambda$19$lambda$17$lambda$16(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureContentView$lambda$24$lambda$22$lambda$21(MutableState mutableState, LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
        mutableState.setValue(layoutCoordinates);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureContentView$lambda$24$lambda$9$lambda$8(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureContentView$lambda$25(MutableState mutableState, Departure departure, boolean z5, boolean z6, MutableState mutableState2, boolean z7, int i5, Composer composer, int i6) {
        DepartureContentView(mutableState, departure, z5, z6, mutableState2, z7, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DepartureRowView(Modifier modifier, final Departure departure, boolean z5, boolean z6, final Function1<? super Departure, Unit> onSelected, boolean z7, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        boolean z8;
        int i8;
        boolean z9;
        int i9;
        boolean z10;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        final boolean z11;
        final Modifier modifier3;
        final boolean z12;
        final boolean z13;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(onSelected, "onSelected");
        Composer startRestartGroup = composer.startRestartGroup(294088644);
        int i10 = i6 & 1;
        if (i10 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(departure) ? 32 : 16;
        }
        int i11 = i6 & 4;
        if (i11 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            z8 = z5;
            i7 |= startRestartGroup.changed(z8) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                z9 = z6;
                i7 |= startRestartGroup.changed(z9) ? 2048 : 1024;
                if ((i6 & 16) != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    i7 |= startRestartGroup.changedInstance(onSelected) ? 16384 : 8192;
                }
                i9 = i6 & 32;
                if (i9 != 0) {
                    i7 |= 196608;
                } else if ((196608 & i5) == 0) {
                    z10 = z7;
                    i7 |= startRestartGroup.changed(z10) ? 131072 : 65536;
                    if ((74899 & i7) == 74898 || !startRestartGroup.getSkipping()) {
                        Modifier modifier4 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                        boolean z14 = i11 == 0 ? false : z8;
                        boolean z15 = i8 == 0 ? true : z9;
                        if (i9 != 0) {
                            z10 = false;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(294088644, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureRowView (DepartureRowView.kt:75)");
                        }
                        startRestartGroup.startReplaceGroup(-267252224);
                        rememberedValue = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (rememberedValue == companion.getEmpty()) {
                            rememberedValue = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        Animatable animatable = (Animatable) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                            startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            rememberedValue2 = compositionScopedCoroutineScopeCanceller;
                        }
                        CompositionLocalKt.CompositionLocalProvider(RippleKt.getLocalRippleConfiguration().provides(null), ComposableLambdaKt.rememberComposableLambda(-1678916860, true, new DepartureRowViewKt$DepartureRowView$1(modifier4, z10 && (departure.getSoldOut() || departure.getCancelled() || !z15), ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope(), animatable, onSelected, departure, z14, z10), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z11 = z10;
                        modifier3 = modifier4;
                        z12 = z14;
                        z13 = z15;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z12 = z8;
                        z13 = z9;
                        z11 = z10;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: N2.n
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit DepartureRowView$lambda$1;
                                DepartureRowView$lambda$1 = DepartureRowViewKt.DepartureRowView$lambda$1(Modifier.this, departure, z12, z13, onSelected, z11, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                return DepartureRowView$lambda$1;
                            }
                        });
                        return;
                    }
                    return;
                }
                z10 = z7;
                if ((74899 & i7) == 74898) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(-267252224);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                }
                Animatable animatable2 = (Animatable) rememberedValue;
                startRestartGroup.endReplaceGroup();
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                }
                CompositionLocalKt.CompositionLocalProvider(RippleKt.getLocalRippleConfiguration().provides(null), ComposableLambdaKt.rememberComposableLambda(-1678916860, true, new DepartureRowViewKt$DepartureRowView$1(modifier4, z10 && (departure.getSoldOut() || departure.getCancelled() || !z15), ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope(), animatable2, onSelected, departure, z14, z10), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                }
                z11 = z10;
                modifier3 = modifier4;
                z12 = z14;
                z13 = z15;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z9 = z6;
            if ((i6 & 16) != 0) {
            }
            i9 = i6 & 32;
            if (i9 != 0) {
            }
            z10 = z7;
            if ((74899 & i7) == 74898) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-267252224);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            Animatable animatable22 = (Animatable) rememberedValue;
            startRestartGroup.endReplaceGroup();
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
            }
            CompositionLocalKt.CompositionLocalProvider(RippleKt.getLocalRippleConfiguration().provides(null), ComposableLambdaKt.rememberComposableLambda(-1678916860, true, new DepartureRowViewKt$DepartureRowView$1(modifier4, z10 && (departure.getSoldOut() || departure.getCancelled() || !z15), ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope(), animatable22, onSelected, departure, z14, z10), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
            }
            z11 = z10;
            modifier3 = modifier4;
            z12 = z14;
            z13 = z15;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        z8 = z5;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z9 = z6;
        if ((i6 & 16) != 0) {
        }
        i9 = i6 & 32;
        if (i9 != 0) {
        }
        z10 = z7;
        if ((74899 & i7) == 74898) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-267252224);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        Animatable animatable222 = (Animatable) rememberedValue;
        startRestartGroup.endReplaceGroup();
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        CompositionLocalKt.CompositionLocalProvider(RippleKt.getLocalRippleConfiguration().provides(null), ComposableLambdaKt.rememberComposableLambda(-1678916860, true, new DepartureRowViewKt$DepartureRowView$1(modifier4, z10 && (departure.getSoldOut() || departure.getCancelled() || !z15), ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope(), animatable222, onSelected, departure, z14, z10), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
        }
        z11 = z10;
        modifier3 = modifier4;
        z12 = z14;
        z13 = z15;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureRowView$lambda$1(Modifier modifier, Departure departure, boolean z5, boolean z6, Function1 function1, boolean z7, int i5, int i6, Composer composer, int i7) {
        DepartureRowView(modifier, departure, z5, z6, function1, z7, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    private static final void FewTicketsAvailableBanner(final BoxScope boxScope, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1030209946);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(boxScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1030209946, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.departure.FewTicketsAvailableBanner (DepartureRowView.kt:434)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(companion, AppColor.INSTANCE.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getSmall());
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Modifier align = boxScope.align(m103backgroundbw27NRU, companion2.getBottomEnd());
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, align);
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.departure_fewTicketsToPrice, startRestartGroup, 6), PaddingKt.m312paddingVpY3zN4(companion, Dp.m2599constructorimpl(8), Dp.m2599constructorimpl(4)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmallBold(), composer2, 48, 1572864, 65532);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: N2.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FewTicketsAvailableBanner$lambda$41;
                    FewTicketsAvailableBanner$lambda$41 = DepartureRowViewKt.FewTicketsAvailableBanner$lambda$41(BoxScope.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FewTicketsAvailableBanner$lambda$41;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FewTicketsAvailableBanner$lambda$41(BoxScope boxScope, int i5, Composer composer, int i6) {
        FewTicketsAvailableBanner(boxScope, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void RightDepartureSection(final RowScope rowScope, final boolean z5, final MutableState<LayoutCoordinates> mutableState, final boolean z6, final Departure departure, final boolean z7, final CheapestTicketType cheapestTicketType, final MutableState<LayoutCoordinates> mutableState2, Composer composer, final int i5) {
        int i6;
        int i7;
        Modifier.Companion companion;
        int i8;
        boolean z8;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1610891851);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(mutableState) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(departure) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(z7) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(cheapestTicketType) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changed(mutableState2) ? 8388608 : 4194304;
        }
        int i9 = i6;
        if ((4793491 & i9) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1610891851, i9, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.departure.RightDepartureSection (DepartureRowView.kt:323)");
            }
            boolean z9 = z5 || z6;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(RowScope.weight$default(rowScope, companion2, 1.0f, false, 2, null), 0.0f, 1, null);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(z9 ? companion3.getCenter() : companion3.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxHeight$default);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion4.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(1449802076);
            boolean z10 = (i9 & 896) == 256;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z10 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: N2.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit RightDepartureSection$lambda$34$lambda$29$lambda$28;
                        RightDepartureSection$lambda$34$lambda$29$lambda$28 = DepartureRowViewKt.RightDepartureSection$lambda$34$lambda$29$lambda$28(MutableState.this, (LayoutCoordinates) obj);
                        return RightDepartureSection$lambda$34$lambda$29$lambda$28;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue);
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(z9 ? Alignment.INSTANCE.getCenter() : Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned);
            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            if (z6) {
                startRestartGroup.startReplaceGroup(1049926039);
                SelectForSaleOnBoardIcon(boxScopeInstance, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
                i7 = i9;
                companion = companion2;
                i8 = 8388608;
                z8 = true;
            } else {
                startRestartGroup.startReplaceGroup(1049998703);
                Price fromPrice = departure.getFromPrice();
                CheapestTicketType cheapestTicketType2 = departure.getCheapestTicketType();
                i7 = i9;
                companion = companion2;
                i8 = 8388608;
                z8 = true;
                DeparturePriceSectionViewKt.DeparturePriceSection(fromPrice, cheapestTicketType2 != null ? cheapestTicketType2.getPriceIndicator() : null, departure.getSoldOut(), departure.getCancelled(), z5, startRestartGroup, 57344 & (i9 << 9));
                startRestartGroup.endReplaceGroup();
            }
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(1449825080);
            if (!z7 || cheapestTicketType == null) {
                composer2 = startRestartGroup;
            } else {
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(8), 7, null);
                Alignment.Companion companion5 = Alignment.INSTANCE;
                Modifier align = boxScopeInstance.align(m315paddingqDBjuR0$default, companion5.getBottomStart());
                startRestartGroup.startReplaceGroup(1449832372);
                boolean z11 = (i7 & 29360128) == i8 ? z8 : false;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z11 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: N2.k
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit RightDepartureSection$lambda$34$lambda$32$lambda$31;
                            RightDepartureSection$lambda$34$lambda$32$lambda$31 = DepartureRowViewKt.RightDepartureSection$lambda$34$lambda$32$lambda$31(MutableState.this, (LayoutCoordinates) obj);
                            return RightDepartureSection$lambda$34$lambda$32$lambda$31;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(align, (Function1) rememberedValue2);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), companion5.getCenterVertically(), startRestartGroup, 48);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned2);
                Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Modifier.Companion companion6 = companion;
                BoxKt.Box(BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(SizeKt.m331size3ABfNKs(companion6, Dp.m2599constructorimpl(10)), RoundedCornerShapeKt.getCircleShape()), TicketCategoryExtensionsKt.getColor(cheapestTicketType.getTicketType()), null, 2, null), startRestartGroup, 0);
                composer2 = startRestartGroup;
                AutoShrinkTextKt.m3384AutoShrinkTextwoKQQc(cheapestTicketType.getTicketTypeName(), RowScope.weight$default(rowScopeInstance, PaddingKt.m315paddingqDBjuR0$default(companion6, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null), false, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, TypographyKt.getSubSmallBold(), composer2, 0, 196608, 32764);
                composer2.endNode();
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: N2.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RightDepartureSection$lambda$35;
                    RightDepartureSection$lambda$35 = DepartureRowViewKt.RightDepartureSection$lambda$35(RowScope.this, z5, mutableState, z6, departure, z7, cheapestTicketType, mutableState2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return RightDepartureSection$lambda$35;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RightDepartureSection$lambda$34$lambda$29$lambda$28(MutableState mutableState, LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
        mutableState.setValue(layoutCoordinates);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RightDepartureSection$lambda$34$lambda$32$lambda$31(MutableState mutableState, LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
        mutableState.setValue(layoutCoordinates);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RightDepartureSection$lambda$35(RowScope rowScope, boolean z5, MutableState mutableState, boolean z6, Departure departure, boolean z7, CheapestTicketType cheapestTicketType, MutableState mutableState2, int i5, Composer composer, int i6) {
        RightDepartureSection(rowScope, z5, mutableState, z6, departure, z7, cheapestTicketType, mutableState2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void SelectForSaleOnBoardIcon(final BoxScope boxScope, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-99582290);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(boxScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-99582290, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.departure.SelectForSaleOnBoardIcon (DepartureRowView.kt:380)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Modifier align = boxScope.align(companion, companion2.getCenter());
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, align);
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
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_food_blue, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(24)), Color.INSTANCE.m1501getUnspecified0d7_KjU(), startRestartGroup, 3456, 0);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.saleOnBoard_selectedDeparture_order, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 13, null), AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmallBold(), composer2, 432, 1572864, 65528);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: N2.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectForSaleOnBoardIcon$lambda$37;
                    SelectForSaleOnBoardIcon$lambda$37 = DepartureRowViewKt.SelectForSaleOnBoardIcon$lambda$37(BoxScope.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectForSaleOnBoardIcon$lambda$37;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectForSaleOnBoardIcon$lambda$37(BoxScope boxScope, int i5, Composer composer, int i6) {
        SelectForSaleOnBoardIcon(boxScope, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
