package dk.molslinjen.ui.views.screens.booking.ticketType;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.google.accompanist.pager.PagerIndicatorKt;
import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.CheapestTicketPriceIndicator;
import dk.molslinjen.domain.model.booking.CheapestTicketType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.booking.Ferry;
import dk.molslinjen.domain.model.booking.RouteType;
import dk.molslinjen.domain.model.booking.TicketCategory;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.extensions.domain.CheapestTicketPriceIndicatorExtensionsKt;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.extensions.domain.RouteTypeExtensionsKt;
import dk.molslinjen.extensions.domain.TicketCategoryExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.TertiaryButtonKt;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeMolslinjenScreenKt;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeMolslinjenViewModel;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import dk.molslinjen.ui.views.shared.infoBanner.InfoBannerViewKt;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a?\u0010\t\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0005H\u0007¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\u0011\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u000eH\u0003¢\u0006\u0004\b\u0011\u0010\u0012\u001aE\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u000eH\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0003¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010 \u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0003¢\u0006\u0004\b \u0010!\u001aE\u0010&\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u000eH\u0003¢\u0006\u0004\b$\u0010%\u001a+\u0010+\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010'H\u0003¢\u0006\u0004\b)\u0010*¨\u0006,"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeMolslinjenViewModel;", "viewModel", "Lkotlin/Function0;", BuildConfig.FLAVOR, "dismiss", "Lkotlin/Function2;", "Lcom/ramcosta/composedestinations/spec/Direction;", BuildConfig.FLAVOR, "proceed", "TicketTypeMolslinjenScreen", "(Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeMolslinjenViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/layout/ColumnScope;", "Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeMolslinjenViewModel$ViewState;", "state", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "onSelected", "TicketTypeContent", "(Landroidx/compose/foundation/layout/ColumnScope;Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeMolslinjenViewModel$ViewState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ticket", "Ldk/molslinjen/domain/model/booking/CheapestTicketType;", "cheapestTicketType", "selected", "fewTicketsAvailable", "TicketTypeView", "(Ldk/molslinjen/domain/model/booking/DepartureTicket;Ldk/molslinjen/domain/model/booking/CheapestTicketType;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/booking/Departure;", "departure", "DepartureBanner", "(Ldk/molslinjen/domain/model/booking/Departure;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "modifier", "FewTicketsAvailableBanner", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/unit/Dp;", "width", "TicketTypeDetailsView--jt2gSs", "(Ldk/molslinjen/domain/model/booking/DepartureTicket;Ldk/molslinjen/domain/model/booking/CheapestTicketType;ZFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "TicketTypeDetailsView", "Landroidx/compose/ui/graphics/Color;", "highlightColor", "PriceRow-gKt5lHk", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/booking/DepartureTicket;Landroidx/compose/ui/graphics/Color;Landroidx/compose/runtime/Composer;II)V", "PriceRow", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketTypeMolslinjenScreenKt {
    private static final void DepartureBanner(final Departure departure, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1678788007);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(departure) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1678788007, i6, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.DepartureBanner (TicketTypeMolslinjenScreen.kt:341)");
            }
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, startRestartGroup, 0, 15);
            final String stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_departureLocation, new Object[]{departure.getDepartureHarborName(), departure.getArrivalHarborName()}, startRestartGroup, 6);
            final String stringResource2 = StringResources_androidKt.stringResource(R.string.accessibilityLabel_departureTimes, new Object[]{LocalDateTimeExtensionsKt.toFormatTime(departure.getDepartureTime()), LocalDateTimeExtensionsKt.toFormatTime(departure.getArrivalTime())}, startRestartGroup, 6);
            Alignment.Companion companion = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion.getCenterVertically();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(74)), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null), Dp.m2599constructorimpl(32), 0.0f, 2, null);
            startRestartGroup.startReplaceGroup(-1192948848);
            boolean changed = startRestartGroup.changed(stringResource) | startRestartGroup.changed(stringResource2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: i3.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DepartureBanner$lambda$30$lambda$29;
                        DepartureBanner$lambda$30$lambda$29 = TicketTypeMolslinjenScreenKt.DepartureBanner$lambda$30$lambda$29(stringResource, stringResource2, (SemanticsPropertyReceiver) obj);
                        return DepartureBanner$lambda$30$lambda$29;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(m313paddingVpY3zN4$default, (Function1) rememberedValue);
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics);
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
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
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
            TextKt.m940Text4IGK_g(departure.getDepartureHarborName(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), startRestartGroup, 0, 1572864, 65534);
            float f5 = 2;
            TextKt.m940Text4IGK_g(LocalDateTimeExtensionsKt.toFormatTime(departure.getDepartureTime()), PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH3Bold(), startRestartGroup, 48, 1572864, 65532);
            startRestartGroup.endNode();
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_forward_arrows, startRestartGroup, 6);
            Accessibility accessibility = Accessibility.INSTANCE;
            ImageKt.Image(painterResource, accessibility.getSkip(), null, null, null, 0.0f, null, startRestartGroup, 0, 124);
            RouteType routeType = RouteType.Ferry;
            Ferry ferry = departure.getFerry();
            ImageKt.Image(PainterResources_androidKt.painterResource(RouteTypeExtensionsKt.icon(routeType, ferry != null ? ferry.getType() : null), startRestartGroup, 0), accessibility.getSkip(), PaddingKt.m313paddingVpY3zN4$default(companion2, Dp.m2599constructorimpl(4), 0.0f, 2, null), null, null, 0.0f, null, startRestartGroup, 384, 120);
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_forward_arrows, startRestartGroup, 6), accessibility.getSkip(), null, null, null, 0.0f, null, startRestartGroup, 0, 124);
            Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default2);
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
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
            String arrivalHarborName = departure.getArrivalHarborName();
            TextStyle subSmall = TypographyKt.getSubSmall();
            TextAlign.Companion companion4 = TextAlign.INSTANCE;
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(arrivalHarborName, fillMaxWidth$default, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2529getEnde0LSkKk()), 0L, 0, false, 0, 0, null, subSmall, composer2, 48, 1572864, 65020);
            TextKt.m940Text4IGK_g(LocalDateTimeExtensionsKt.toFormatTime(departure.getArrivalTime()), PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2529getEnde0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getH3Bold(), composer2, 48, 1572864, 65020);
            composer2.endNode();
            composer2.endNode();
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer2, 0, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: i3.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DepartureBanner$lambda$34;
                    DepartureBanner$lambda$34 = TicketTypeMolslinjenScreenKt.DepartureBanner$lambda$34(Departure.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DepartureBanner$lambda$34;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureBanner$lambda$30$lambda$29(String str, String str2, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, str + " " + str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureBanner$lambda$34(Departure departure, int i5, Composer composer, int i6) {
        DepartureBanner(departure, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void FewTicketsAvailableBanner(Modifier modifier, Composer composer, final int i5, final int i6) {
        final Modifier modifier2;
        int i7;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1441425026);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i7 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            Modifier modifier3 = i8 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1441425026, i7, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.FewTicketsAvailableBanner (TicketTypeMolslinjenScreen.kt:408)");
            }
            float f5 = 16;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(modifier3, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
            AppColor appColor = AppColor.INSTANCE;
            Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(m315paddingqDBjuR0$default, appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getSmall());
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m103backgroundbw27NRU);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f6 = 8;
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_alert_warning, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion2, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 0.0f, 14, null), Dp.m2599constructorimpl(f5)), appColor.m3266getGrey30d7_KjU(), startRestartGroup, 3456, 0);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.departure_fewTicketsToPrice, startRestartGroup, 6), PaddingKt.m312paddingVpY3zN4(companion2, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(4)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 48, 1572864, 65532);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: i3.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FewTicketsAvailableBanner$lambda$36;
                    FewTicketsAvailableBanner$lambda$36 = TicketTypeMolslinjenScreenKt.FewTicketsAvailableBanner$lambda$36(Modifier.this, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return FewTicketsAvailableBanner$lambda$36;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FewTicketsAvailableBanner$lambda$36(Modifier modifier, int i5, int i6, Composer composer, int i7) {
        FewTicketsAvailableBanner(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* renamed from: PriceRow-gKt5lHk, reason: not valid java name */
    private static final void m3474PriceRowgKt5lHk(Modifier modifier, final DepartureTicket departureTicket, final Color color, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        Modifier modifier3;
        Composer startRestartGroup = composer.startRestartGroup(-348180986);
        int i8 = i6 & 1;
        if (i8 != 0) {
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
            i7 |= startRestartGroup.changedInstance(departureTicket) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(color) ? 256 : 128;
        }
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i8 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-348180986, i7, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.PriceRow (TicketTypeMolslinjenScreen.kt:509)");
            }
            Alignment.Companion companion = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
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
            Modifier.Companion companion3 = Modifier.INSTANCE;
            modifier3 = modifier4;
            TextKt.m940Text4IGK_g(departureTicket.getCategory().getName(), RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH3Bold(), startRestartGroup, 0, 1572864, 65532);
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m103backgroundbw27NRU(companion3, color != null ? color.getValue() : Color.INSTANCE.m1501getUnspecified0d7_KjU(), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(32))), Dp.m2599constructorimpl(8), Dp.m2599constructorimpl(3));
            startRestartGroup.startReplaceGroup(2038817302);
            boolean changedInstance = startRestartGroup.changedInstance(departureTicket) | startRestartGroup.changedInstance(context);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: i3.A
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PriceRow_gKt5lHk$lambda$49$lambda$47$lambda$46;
                        PriceRow_gKt5lHk$lambda$49$lambda$47$lambda$46 = TicketTypeMolslinjenScreenKt.PriceRow_gKt5lHk$lambda$49$lambda$47$lambda$46(DepartureTicket.this, context, (SemanticsPropertyReceiver) obj);
                        return PriceRow_gKt5lHk$lambda$49$lambda$47$lambda$46;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(m312paddingVpY3zN4, (Function1) rememberedValue);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics);
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
            PriceTextKt.m3557PriceText1y9Plug(departureTicket.getPrice(), rowScopeInstance.alignByBaseline(companion3), PriceViewType.PriceOnly, false, TypographyKt.getH3Bold(), (TextAlign) null, 0, 0L, startRestartGroup, 24960, 232);
            PriceTextKt.m3557PriceText1y9Plug(departureTicket.getPrice(), PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance.alignByBaseline(companion3), Dp.m2599constructorimpl(2), 0.0f, 0.0f, 0.0f, 14, null), PriceViewType.CurrencyOnly, false, TypographyKt.getSub(), (TextAlign) null, 0, 0L, startRestartGroup, 24960, 232);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: i3.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PriceRow_gKt5lHk$lambda$50;
                    PriceRow_gKt5lHk$lambda$50 = TicketTypeMolslinjenScreenKt.PriceRow_gKt5lHk$lambda$50(Modifier.this, departureTicket, color, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return PriceRow_gKt5lHk$lambda$50;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriceRow_gKt5lHk$lambda$49$lambda$47$lambda$46(DepartureTicket departureTicket, Context context, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, PriceFormatExtensionsKt.formatted(departureTicket.getPrice(), context));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriceRow_gKt5lHk$lambda$50(Modifier modifier, DepartureTicket departureTicket, Color color, int i5, int i6, Composer composer, int i7) {
        m3474PriceRowgKt5lHk(modifier, departureTicket, color, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02e1  */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object, androidx.compose.ui.Modifier] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TicketTypeContent(final ColumnScope columnScope, final TicketTypeMolslinjenViewModel.ViewState viewState, final Function1<? super DepartureTicket, Unit> function1, Composer composer, final int i5) {
        Modifier.Companion companion;
        MutableState mutableState;
        ?? r7;
        MutableState mutableState2;
        final String str;
        Composer composer2;
        Object obj;
        TicketCategory category;
        Composer startRestartGroup = composer.startRestartGroup(922661089);
        int i6 = (i5 & 6) == 0 ? (startRestartGroup.changed(columnScope) ? 4 : 2) | i5 : i5;
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(viewState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i7 = i6;
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(922661089, i7, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeContent (TicketTypeMolslinjenScreen.kt:141)");
            }
            final Departure departure = viewState.getDeparture();
            if (departure == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: i3.m
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit TicketTypeContent$lambda$1;
                            TicketTypeContent$lambda$1 = TicketTypeMolslinjenScreenKt.TicketTypeContent$lambda$1(ColumnScope.this, viewState, function1, i5, (Composer) obj2, ((Integer) obj3).intValue());
                            return TicketTypeContent$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            final boolean z5 = departure.getTickets().size() > 1;
            startRestartGroup.startReplaceGroup(1885588767);
            boolean changedInstance = startRestartGroup.changedInstance(departure);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: i3.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        int TicketTypeContent$lambda$3$lambda$2;
                        TicketTypeContent$lambda$3$lambda$2 = TicketTypeMolslinjenScreenKt.TicketTypeContent$lambda$3$lambda$2(Departure.this);
                        return Integer.valueOf(TicketTypeContent$lambda$3$lambda$2);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            PagerState rememberPagerState = PagerStateKt.rememberPagerState(0, 0.0f, (Function0) rememberedValue, startRestartGroup, 0, 3);
            final float m2599constructorimpl = Dp.m2599constructorimpl(((Configuration) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenWidthDp);
            final Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            Object[] objArr = new Object[0];
            startRestartGroup.startReplaceGroup(1885594453);
            boolean changed = startRestartGroup.changed(z5);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: i3.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState TicketTypeContent$lambda$5$lambda$4;
                        TicketTypeContent$lambda$5$lambda$4 = TicketTypeMolslinjenScreenKt.TicketTypeContent$lambda$5$lambda$4(z5);
                        return TicketTypeContent$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            MutableState mutableState3 = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue2, startRestartGroup, 0, 6);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier weight = columnScope.weight(ScrollKt.verticalScroll$default(companion2, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null), 1.0f, false);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, weight);
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
            DepartureBanner(departure, startRestartGroup, 0);
            boolean z6 = viewState.getSite() == Site.Fanoe;
            startRestartGroup.startReplaceGroup(-756256523);
            if (z6) {
                float f5 = 24;
                float m2599constructorimpl2 = Dp.m2599constructorimpl(f5);
                float m2599constructorimpl3 = Dp.m2599constructorimpl(f5);
                companion = companion2;
                mutableState = mutableState3;
                InfoBannerViewKt.InfoBannerView(PaddingKt.m315paddingqDBjuR0$default(companion2, m2599constructorimpl2, Dp.m2599constructorimpl(16), m2599constructorimpl3, 0.0f, 8, null), R.drawable.icon_checkmark_circle, StringResources_androidKt.stringResource(R.string.ticketType_fanoe_validOnAllDepartures, startRestartGroup, 6), startRestartGroup, 48, 0);
            } else {
                companion = companion2;
                mutableState = mutableState3;
            }
            startRestartGroup.endReplaceGroup();
            float f6 = 24;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-756244649);
            if (z5) {
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f6), 0.0f, 2, null), 0.0f, 1, null);
                String stringResource = StringResources_androidKt.stringResource(((Boolean) mutableState.getValue()).booleanValue() ? R.string.ticketType_hideDetails : R.string.ticketType_showDetails, startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(-756234094);
                final MutableState mutableState4 = mutableState;
                boolean changed2 = startRestartGroup.changed(mutableState4);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: i3.p
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit TicketTypeContent$lambda$17$lambda$7$lambda$6;
                            TicketTypeContent$lambda$17$lambda$7$lambda$6 = TicketTypeMolslinjenScreenKt.TicketTypeContent$lambda$17$lambda$7$lambda$6(MutableState.this);
                            return TicketTypeContent$lambda$17$lambda$7$lambda$6;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                mutableState2 = mutableState4;
                r7 = 0;
                TertiaryButtonKt.TertiaryButton(fillMaxWidth$default, stringResource, (Function0) rememberedValue3, null, null, startRestartGroup, 6, 24);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
            } else {
                r7 = 0;
                mutableState2 = mutableState;
            }
            startRestartGroup.endReplaceGroup();
            if (departure.getLimitedAvailability()) {
                Iterator<T> it = departure.getTickets().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (!((DepartureTicket) obj).getSoldOut()) {
                            break;
                        }
                    } else {
                        obj = r7;
                        break;
                    }
                }
                DepartureTicket departureTicket = (DepartureTicket) obj;
                if (departureTicket != null && (category = departureTicket.getCategory()) != null) {
                    str = category.getId();
                    if (((Boolean) mutableState2.getValue()).booleanValue()) {
                        startRestartGroup.startReplaceGroup(-1965819129);
                        Composer composer3 = startRestartGroup;
                        for (DepartureTicket departureTicket2 : departure.getTickets()) {
                            TicketTypeView(departureTicket2, departure.getCheapestTicketType(), Intrinsics.areEqual(viewState.getSelectedTicket(), departureTicket2), Intrinsics.areEqual(str, departureTicket2.getCategory().getId()), function1, composer3, 57344 & (i7 << 6));
                            departure = departure;
                            i7 = i7;
                            composer3 = composer3;
                        }
                        composer2 = composer3;
                        composer2.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(-1967999018);
                        startRestartGroup.startReplaceGroup(-756221755);
                        Object rememberedValue4 = startRestartGroup.rememberedValue();
                        Composer.Companion companion4 = Composer.INSTANCE;
                        if (rememberedValue4 == companion4.getEmpty()) {
                            rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m2597boximpl(Dp.m2599constructorimpl(0)), r7, 2, r7);
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                        }
                        final MutableState mutableState5 = (MutableState) rememberedValue4;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-756218781);
                        boolean changedInstance2 = startRestartGroup.changedInstance(departure) | startRestartGroup.changed(str) | startRestartGroup.changed(m2599constructorimpl) | startRestartGroup.changed(density);
                        Object rememberedValue5 = startRestartGroup.rememberedValue();
                        if (changedInstance2 || rememberedValue5 == companion4.getEmpty()) {
                            final String str2 = str;
                            rememberedValue5 = new Function2() { // from class: i3.q
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    MeasureResult TicketTypeContent$lambda$17$lambda$16$lambda$15;
                                    TicketTypeContent$lambda$17$lambda$16$lambda$15 = TicketTypeMolslinjenScreenKt.TicketTypeContent$lambda$17$lambda$16$lambda$15(Departure.this, density, str2, m2599constructorimpl, mutableState5, (SubcomposeMeasureScope) obj2, (Constraints) obj3);
                                    return TicketTypeContent$lambda$17$lambda$16$lambda$15;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue5);
                        }
                        startRestartGroup.endReplaceGroup();
                        SubcomposeLayoutKt.SubcomposeLayout(r7, (Function2) rememberedValue5, startRestartGroup, 0, 1);
                        Modifier.Companion companion5 = Modifier.INSTANCE;
                        PagerKt.m438HorizontalPageroI3XNZo(rememberPagerState, SizeKt.m325height3ABfNKs(SizeKt.fillMaxWidth$default(companion5, 0.0f, 1, r7), ((Dp) mutableState5.getValue()).getValue()), PaddingKt.m308PaddingValuesYgX7TsA$default(Dp.m2599constructorimpl(0.1f * m2599constructorimpl), 0.0f, 2, r7), null, 0, Dp.m2599constructorimpl(16), Alignment.INSTANCE.getTop(), null, false, false, null, null, null, ComposableLambdaKt.rememberComposableLambda(-358080180, true, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeMolslinjenScreenKt$TicketTypeContent$1$3
                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer4, Integer num2) {
                                invoke(pagerScope, num.intValue(), composer4, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(PagerScope HorizontalPager, int i8, Composer composer4, int i9) {
                                Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-358080180, i9, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeContent.<anonymous>.<anonymous> (TicketTypeMolslinjenScreen.kt:219)");
                                }
                                DepartureTicket departureTicket3 = Departure.this.getTickets().get(i8);
                                TicketTypeMolslinjenScreenKt.m3475TicketTypeDetailsViewjt2gSs(departureTicket3, Departure.this.getCheapestTicketType(), Intrinsics.areEqual(str, departureTicket3.getCategory().getId()), Dp.m2599constructorimpl(m2599constructorimpl * 0.8f), function1, composer4, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), startRestartGroup, 1769472, 3072, 8088);
                        if (z5) {
                            int pageCount = rememberPagerState.getPageCount();
                            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion5, 0.0f, Dp.m2599constructorimpl(f6), 1, r7);
                            AppColor appColor = AppColor.INSTANCE;
                            PagerIndicatorKt.m2902HorizontalPagerIndicatorK_mkGiw(rememberPagerState, pageCount, m313paddingVpY3zN4$default, (Function1<? super Integer, Integer>) null, appColor.m3255getBrandBlue10d7_KjU(), appColor.m3267getGrey40d7_KjU(), 0.0f, 0.0f, 0.0f, (Shape) null, startRestartGroup, 221568, 968);
                        }
                        startRestartGroup.endReplaceGroup();
                        composer2 = startRestartGroup;
                    }
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            str = r7;
            if (((Boolean) mutableState2.getValue()).booleanValue()) {
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: i3.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit TicketTypeContent$lambda$18;
                    TicketTypeContent$lambda$18 = TicketTypeMolslinjenScreenKt.TicketTypeContent$lambda$18(ColumnScope.this, viewState, function1, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return TicketTypeContent$lambda$18;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeContent$lambda$1(ColumnScope columnScope, TicketTypeMolslinjenViewModel.ViewState viewState, Function1 function1, int i5, Composer composer, int i6) {
        TicketTypeContent(columnScope, viewState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult TicketTypeContent$lambda$17$lambda$16$lambda$15(Departure departure, Density density, String str, float f5, MutableState mutableState, SubcomposeMeasureScope SubcomposeLayout, Constraints constraints) {
        Integer num;
        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
        for (DepartureTicket departureTicket : departure.getTickets()) {
            Iterator<T> it = SubcomposeLayout.subcompose(departureTicket, ComposableLambdaKt.composableLambdaInstance(-1967347945, true, new TicketTypeMolslinjenScreenKt$TicketTypeContent$1$2$1$1$sub$1(departureTicket, departure, str, f5))).iterator();
            if (it.hasNext()) {
                Integer valueOf = Integer.valueOf(((Measurable) it.next()).mo1946measureBRTryo0(ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null)).getHeight());
                while (it.hasNext()) {
                    Integer valueOf2 = Integer.valueOf(((Measurable) it.next()).mo1946measureBRTryo0(ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null)).getHeight());
                    if (valueOf.compareTo(valueOf2) < 0) {
                        valueOf = valueOf2;
                    }
                }
                num = valueOf;
            } else {
                num = null;
            }
            if (num != null) {
                float mo209toDpu2uoSUM = density.mo209toDpu2uoSUM(num.intValue());
                if (Dp.m2598compareTo0680j_4(mo209toDpu2uoSUM, ((Dp) mutableState.getValue()).getValue()) > 0) {
                    mutableState.setValue(Dp.m2597boximpl(mo209toDpu2uoSUM));
                }
            }
        }
        return MeasureScope.layout$default(SubcomposeLayout, 0, 0, null, new Function1() { // from class: i3.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit TicketTypeContent$lambda$17$lambda$16$lambda$15$lambda$14;
                TicketTypeContent$lambda$17$lambda$16$lambda$15$lambda$14 = TicketTypeMolslinjenScreenKt.TicketTypeContent$lambda$17$lambda$16$lambda$15$lambda$14((Placeable.PlacementScope) obj);
                return TicketTypeContent$lambda$17$lambda$16$lambda$15$lambda$14;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeContent$lambda$17$lambda$16$lambda$15$lambda$14(Placeable.PlacementScope layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeContent$lambda$17$lambda$7$lambda$6(MutableState mutableState) {
        mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeContent$lambda$18(ColumnScope columnScope, TicketTypeMolslinjenViewModel.ViewState viewState, Function1 function1, int i5, Composer composer, int i6) {
        TicketTypeContent(columnScope, viewState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int TicketTypeContent$lambda$3$lambda$2(Departure departure) {
        return departure.getTickets().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState TicketTypeContent$lambda$5$lambda$4(boolean z5) {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(!z5), null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* renamed from: TicketTypeDetailsView--jt2gSs, reason: not valid java name */
    public static final void m3475TicketTypeDetailsViewjt2gSs(final DepartureTicket departureTicket, final CheapestTicketType cheapestTicketType, final boolean z5, final float f5, final Function1<? super DepartureTicket, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        ?? r32;
        final DepartureTicket departureTicket2;
        boolean z6;
        CheapestTicketPriceIndicator priceIndicator;
        Composer startRestartGroup = composer.startRestartGroup(963359238);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(departureTicket) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(cheapestTicketType) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(f5) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        int i7 = i6;
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(963359238, i7, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeDetailsView (TicketTypeMolslinjenScreen.kt:438)");
            }
            Color highlightColor = (departureTicket.getCategory().getType() != (cheapestTicketType != null ? cheapestTicketType.getTicketType() : null) || cheapestTicketType == null || (priceIndicator = cheapestTicketType.getPriceIndicator()) == null) ? null : CheapestTicketPriceIndicatorExtensionsKt.getHighlightColor(priceIndicator);
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier clip = ClipKt.clip(SizeKt.m336width3ABfNKs(companion, f5), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getMedium());
            startRestartGroup.startReplaceGroup(-235120555);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (rememberedValue == companion2.getEmpty()) {
                rememberedValue = new Function1() { // from class: i3.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TicketTypeDetailsView__jt2gSs$lambda$38$lambda$37;
                        TicketTypeDetailsView__jt2gSs$lambda$38$lambda$37 = TicketTypeMolslinjenScreenKt.TicketTypeDetailsView__jt2gSs$lambda$38$lambda$37((SemanticsPropertyReceiver) obj);
                        return TicketTypeDetailsView__jt2gSs$lambda$38$lambda$37;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier semantics = SemanticsModifierKt.semantics(clip, true, (Function1) rememberedValue);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, semantics);
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
            Modifier m108borderxT4_qwU = BorderKt.m108borderxT4_qwU(SizeKt.fillMaxHeight$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, 1, null), Dp.m2599constructorimpl(1), AppColor.INSTANCE.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium());
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m108borderxT4_qwU);
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
            float f6 = 6;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
            float f7 = 24;
            float m2599constructorimpl = Dp.m2599constructorimpl(f7);
            float f8 = 16;
            Color color = highlightColor;
            m3474PriceRowgKt5lHk(PaddingKt.m314paddingqDBjuR0(companion, Dp.m2599constructorimpl(f7), Dp.m2599constructorimpl(10), m2599constructorimpl, Dp.m2599constructorimpl(f8)), departureTicket, highlightColor, startRestartGroup, (i7 << 3) & 112, 0);
            composer2 = startRestartGroup;
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer2, 0, 15);
            composer2.startReplaceGroup(-80686385);
            if (z5) {
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f7), 0.0f, 0.0f, 0.0f, 14, null);
                r32 = 0;
                FewTicketsAvailableBanner(m315paddingqDBjuR0$default, composer2, 6, 0);
            } else {
                r32 = 0;
            }
            composer2.endReplaceGroup();
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(28), Dp.m2599constructorimpl(f8), Dp.m2599constructorimpl(f8), 0.0f, 8, null);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(f8)), companion3.getStart(), composer2, 6);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, r32);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, m315paddingqDBjuR0$default2);
            Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
            TicketTermsListKt.m3473TicketTermsListbMFp3s(departureTicket.getCategory().getDescriptionItems(), color, composer2, r32);
            composer2.endNode();
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion, 1.0f, false, 2, null), composer2, r32);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m311padding3ABfNKs(companion, Dp.m2599constructorimpl(f7)), 0.0f, 1, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.ticketType_continueWith, new Object[]{departureTicket.getCategory().getName()}, composer2, 6);
            ButtonConfig buttonConfig = ButtonConfig.Large;
            composer2.startReplaceGroup(-80657817);
            if ((57344 & i7) == 16384) {
                z6 = true;
                departureTicket2 = departureTicket;
            } else {
                departureTicket2 = departureTicket;
                z6 = r32;
            }
            boolean changedInstance = composer2.changedInstance(departureTicket2) | z6;
            Object rememberedValue2 = composer2.rememberedValue();
            if (changedInstance || rememberedValue2 == companion2.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: i3.u
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TicketTypeDetailsView__jt2gSs$lambda$44$lambda$42$lambda$41$lambda$40;
                        TicketTypeDetailsView__jt2gSs$lambda$44$lambda$42$lambda$41$lambda$40 = TicketTypeMolslinjenScreenKt.TicketTypeDetailsView__jt2gSs$lambda$44$lambda$42$lambda$41$lambda$40(Function1.this, departureTicket2);
                        return TicketTypeDetailsView__jt2gSs$lambda$44$lambda$42$lambda$41$lambda$40;
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer2.endReplaceGroup();
            PrimaryButtonKt.PrimaryButton(fillMaxWidth$default, stringResource, (Function0) rememberedValue2, null, buttonConfig, false, false, false, composer2, 24582, 232);
            composer2.endNode();
            BoxKt.Box(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), 0.0f, 1, null), color != null ? color.getValue() : TicketCategoryExtensionsKt.getColor(departureTicket.getCategory()), null, 2, null), composer2, r32);
            composer2.startReplaceGroup(-1183781516);
            if (color != null) {
                color.getValue();
                BoxKt.Box(boxScopeInstance.align(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), 0.0f, 1, null), color.getValue(), null, 2, null), companion3.getBottomStart()), composer2, r32);
                Unit unit = Unit.INSTANCE;
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: i3.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketTypeDetailsView__jt2gSs$lambda$45;
                    TicketTypeDetailsView__jt2gSs$lambda$45 = TicketTypeMolslinjenScreenKt.TicketTypeDetailsView__jt2gSs$lambda$45(DepartureTicket.this, cheapestTicketType, z5, f5, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketTypeDetailsView__jt2gSs$lambda$45;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeDetailsView__jt2gSs$lambda$38$lambda$37(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeDetailsView__jt2gSs$lambda$44$lambda$42$lambda$41$lambda$40(Function1 function1, DepartureTicket departureTicket) {
        function1.invoke(departureTicket);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeDetailsView__jt2gSs$lambda$45(DepartureTicket departureTicket, CheapestTicketType cheapestTicketType, boolean z5, float f5, Function1 function1, int i5, Composer composer, int i6) {
        m3475TicketTypeDetailsViewjt2gSs(departureTicket, cheapestTicketType, z5, f5, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void TicketTypeMolslinjenScreen(final TicketTypeMolslinjenViewModel viewModel, final Function0<Unit> dismiss, final Function2<? super Direction, ? super Boolean, Unit> proceed, Composer composer, final int i5) {
        int i6;
        String stringResource;
        AnnotatedString annotatedString;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        Composer startRestartGroup = composer.startRestartGroup(1908271339);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(dismiss) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(proceed) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1908271339, i6, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeMolslinjenScreen (TicketTypeMolslinjenScreen.kt:101)");
            }
            TicketTypeMolslinjenViewModel.ViewState viewState = (TicketTypeMolslinjenViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            if (viewState.getBookingType() == BookingType.Single) {
                startRestartGroup.startReplaceGroup(-1351303139);
                annotatedString = new AnnotatedString(StringResources_androidKt.stringResource(R.string.ticketType_molslinjen_title, startRestartGroup, 6), null, null, 6, null);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1351187757);
                if (viewState.getDepartureDirection() == DepartureDirection.Outbound) {
                    startRestartGroup.startReplaceGroup(-1351113977);
                    stringResource = StringResources_androidKt.stringResource(R.string.departures_return_outbound, startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-1351028727);
                    stringResource = StringResources_androidKt.stringResource(R.string.departures_return_return, startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                }
                String lowerCase = stringResource.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String stringResource2 = StringResources_androidKt.stringResource(R.string.ticketType_molslinjen_twoWay_title, new Object[]{lowerCase}, startRestartGroup, 6);
                int indexOf$default = StringsKt.indexOf$default((CharSequence) stringResource2, lowerCase, 0, false, 6, (Object) null);
                annotatedString = new AnnotatedString(stringResource2, CollectionsKt.mutableListOf(new AnnotatedString.Range(new SpanStyle(AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 65534, null), indexOf$default, lowerCase.length() + indexOf$default)), null, 4, null);
                startRestartGroup.endReplaceGroup();
            }
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3398BottomSheetContainer8Un_QVk(null, 0.0f, 0L, annotatedString, null, null, dismiss, null, null, ComposableLambdaKt.rememberComposableLambda(637110200, true, new TicketTypeMolslinjenScreenKt$TicketTypeMolslinjenScreen$1(viewState, viewModel, proceed), startRestartGroup, 54), startRestartGroup, ((i6 << 15) & 3670016) | 805306368, 439);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: i3.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketTypeMolslinjenScreen$lambda$0;
                    TicketTypeMolslinjenScreen$lambda$0 = TicketTypeMolslinjenScreenKt.TicketTypeMolslinjenScreen$lambda$0(TicketTypeMolslinjenViewModel.this, dismiss, proceed, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketTypeMolslinjenScreen$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeMolslinjenScreen$lambda$0(TicketTypeMolslinjenViewModel ticketTypeMolslinjenViewModel, Function0 function0, Function2 function2, int i5, Composer composer, int i6) {
        TicketTypeMolslinjenScreen(ticketTypeMolslinjenViewModel, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void TicketTypeView(final DepartureTicket departureTicket, final CheapestTicketType cheapestTicketType, final boolean z5, final boolean z6, final Function1<? super DepartureTicket, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        CheapestTicketPriceIndicator priceIndicator;
        Composer startRestartGroup = composer.startRestartGroup(1466571512);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(departureTicket) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(cheapestTicketType) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1466571512, i6, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeView (TicketTypeMolslinjenScreen.kt:260)");
            }
            Color highlightColor = (departureTicket.getCategory().getType() != (cheapestTicketType != null ? cheapestTicketType.getTicketType() : null) || cheapestTicketType == null || (priceIndicator = cheapestTicketType.getPriceIndicator()) == null) ? null : CheapestTicketPriceIndicatorExtensionsKt.getHighlightColor(priceIndicator);
            startRestartGroup.startReplaceGroup(1965995703);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f5 = 24;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), 2, null);
            AppColor appColor = AppColor.INSTANCE;
            Modifier clip = ClipKt.clip(BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(m315paddingqDBjuR0$default, appColor.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), z5 ? Dp.m2599constructorimpl(2) : Dp.m2599constructorimpl(1), z5 ? appColor.m3255getBrandBlue10d7_KjU() : appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), ThemeShapesKt.getThemeShapes().getMedium());
            startRestartGroup.startReplaceGroup(1966009839);
            boolean changedInstance = ((57344 & i6) == 16384) | startRestartGroup.changedInstance(departureTicket);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: i3.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TicketTypeView$lambda$21$lambda$20;
                        TicketTypeView$lambda$21$lambda$20 = TicketTypeMolslinjenScreenKt.TicketTypeView$lambda$21$lambda$20(Function1.this, departureTicket);
                        return TicketTypeView$lambda$21$lambda$20;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(clip, false, null, null, (Function0) rememberedValue2, 7, null);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default);
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
            Modifier m336width3ABfNKs = SizeKt.m336width3ABfNKs(companion2, Dp.m2599constructorimpl(6));
            startRestartGroup.startReplaceGroup(-894474536);
            float pxToDp = ComposeExtensionsKt.pxToDp(((Number) mutableState.getValue()).intValue(), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            BoxKt.Box(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.m335sizeInqDBjuR0$default(m336width3ABfNKs, 0.0f, pxToDp, 0.0f, 0.0f, 13, null), highlightColor != null ? highlightColor.getValue() : TicketCategoryExtensionsKt.getColor(departureTicket.getCategory()), null, 2, null), startRestartGroup, 0);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-894466858);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: i3.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TicketTypeView$lambda$27$lambda$24$lambda$23;
                        TicketTypeView$lambda$27$lambda$24$lambda$23 = TicketTypeMolslinjenScreenKt.TicketTypeView$lambda$27$lambda$24$lambda$23(MutableState.this, (LayoutCoordinates) obj);
                        return TicketTypeView$lambda$27$lambda$24$lambda$23;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(fillMaxWidth$default, (Function1) rememberedValue3);
            Alignment.Vertical centerVertically = companion3.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            float f6 = 16;
            Modifier weight$default = RowScope.weight$default(RowScopeInstance.INSTANCE, PaddingKt.m315paddingqDBjuR0$default(companion2, Dp.m2599constructorimpl(22), Dp.m2599constructorimpl(f6), 0.0f, Dp.m2599constructorimpl(f6), 4, null), 1.0f, false, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
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
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            m3474PriceRowgKt5lHk(PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, 0.0f, Dp.m2599constructorimpl(32), Dp.m2599constructorimpl(8), 3, null), departureTicket, highlightColor, startRestartGroup, (i6 << 3) & 112, 0);
            composer2 = startRestartGroup;
            FlowLayoutKt.FlowRow(null, null, null, 0, 0, null, ComposableLambdaKt.rememberComposableLambda(547555645, true, new Function3<FlowRowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeMolslinjenScreenKt$TicketTypeView$2$3$1$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(FlowRowScope flowRowScope, Composer composer3, Integer num) {
                    invoke(flowRowScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(FlowRowScope FlowRow, Composer composer3, int i7) {
                    Composer composer4 = composer3;
                    Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
                    int i8 = 2;
                    int i9 = 4;
                    int i10 = (i7 & 6) == 0 ? i7 | (composer4.changed(FlowRow) ? 4 : 2) : i7;
                    if ((i10 & 19) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(547555645, i10, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TicketTypeMolslinjenScreen.kt:307)");
                    }
                    int i11 = 0;
                    int i12 = 0;
                    for (Object obj : DepartureTicket.this.getCategory().getShortDescriptionItems()) {
                        int i13 = i12 + 1;
                        if (i12 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        String str = (String) obj;
                        composer4.startReplaceGroup(-1918538921);
                        if (i12 > 0) {
                            BoxKt.Box(BackgroundKt.m103backgroundbw27NRU(SizeKt.m331size3ABfNKs(PaddingKt.m313paddingVpY3zN4$default(FlowRow.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterVertically()), Dp.m2599constructorimpl(8), 0.0f, i8, null), Dp.m2599constructorimpl(i9)), AppColor.INSTANCE.m3264getGrey10d7_KjU(), RoundedCornerShapeKt.getCircleShape()), composer4, i11);
                        }
                        composer3.endReplaceGroup();
                        TextKt.m940Text4IGK_g(str, null, AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer3, 384, 1572864, 65530);
                        composer4 = composer3;
                        i12 = i13;
                        i11 = i11;
                        i8 = i8;
                        i9 = i9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, 1572864, 63);
            composer2.startReplaceGroup(-1455067598);
            if (z6) {
                FewTicketsAvailableBanner(null, composer2, 0, 1);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_forward_arrow, composer2, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 11, null), Dp.m2599constructorimpl(f6)), appColor.m3253getBrandBlack10d7_KjU(), composer2, 3456, 0);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: i3.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketTypeView$lambda$28;
                    TicketTypeView$lambda$28 = TicketTypeMolslinjenScreenKt.TicketTypeView$lambda$28(DepartureTicket.this, cheapestTicketType, z5, z6, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketTypeView$lambda$28;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeView$lambda$21$lambda$20(Function1 function1, DepartureTicket departureTicket) {
        function1.invoke(departureTicket);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeView$lambda$27$lambda$24$lambda$23(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g()) > ((Number) mutableState.getValue()).intValue()) {
            mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeView$lambda$28(DepartureTicket departureTicket, CheapestTicketType cheapestTicketType, boolean z5, boolean z6, Function1 function1, int i5, Composer composer, int i6) {
        TicketTypeView(departureTicket, cheapestTicketType, z5, z6, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
