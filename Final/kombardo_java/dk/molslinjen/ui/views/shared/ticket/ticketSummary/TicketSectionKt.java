package dk.molslinjen.ui.views.shared.ticket.ticketSummary;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.booking.Ferry;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.RouteType;
import dk.molslinjen.domain.model.booking.TicketCategory;
import dk.molslinjen.domain.model.booking.TicketSurcharge;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.domain.model.booking.product.ISummaryProduct;
import dk.molslinjen.domain.model.config.Subline;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.extensions.domain.RouteTypeExtensionsKt;
import dk.molslinjen.extensions.domain.TicketCategoryExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.LineIconViewKt;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSectionKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0083\u0001\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0017\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0001\u001a\u00020\u0000H\u0003¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "departure", "Ldk/molslinjen/domain/model/booking/TicketCategory;", "category", "Ldk/molslinjen/domain/model/config/Transportation;", "transportation", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", "Ldk/molslinjen/domain/model/booking/product/ISummaryProduct;", "trailer", BuildConfig.FLAVOR, "transportProducts", BuildConfig.FLAVOR, "showDetails", "Ldk/molslinjen/domain/model/shared/Price;", "ticketPrice", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "cargoInfo", "Ldk/molslinjen/domain/model/booking/TicketSurcharge;", "surcharges", "Ldk/molslinjen/domain/model/config/Subline;", "subline", BuildConfig.FLAVOR, "lineLogoUrl", BuildConfig.FLAVOR, "TicketSection", "(Ldk/molslinjen/domain/model/booking/IDepartureInfo;Ldk/molslinjen/domain/model/booking/TicketCategory;Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/booking/PassengerInfo;Ldk/molslinjen/domain/model/booking/product/ISummaryProduct;Ljava/util/List;ZLdk/molslinjen/domain/model/shared/Price;Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;Ljava/util/List;Ldk/molslinjen/domain/model/config/Subline;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "DepartureInfoView", "(Ldk/molslinjen/domain/model/booking/IDepartureInfo;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketSectionKt {
    private static final void DepartureInfoView(final IDepartureInfo iDepartureInfo, Composer composer, final int i5) {
        int i6;
        Integer num;
        Modifier.Companion companion;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(812917966);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(iDepartureInfo) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(812917966, i6, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.DepartureInfoView (TicketSection.kt:166)");
            }
            final String stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_departureLocation, new Object[]{iDepartureInfo.getDepartureHarborName(), iDepartureInfo.getArrivalHarborName()}, startRestartGroup, 6);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f5 = 16;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion2, Dp.m2599constructorimpl(f5), 0.0f, 2, null);
            startRestartGroup.startReplaceGroup(305359573);
            boolean changed = startRestartGroup.changed(stringResource);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: C4.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DepartureInfoView$lambda$6$lambda$5;
                        DepartureInfoView$lambda$6$lambda$5 = TicketSectionKt.DepartureInfoView$lambda$6$lambda$5(stringResource, (SemanticsPropertyReceiver) obj);
                        return DepartureInfoView$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(m313paddingVpY3zN4$default, (Function1) rememberedValue);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion3.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics);
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null);
            String departureHarborName = iDepartureInfo.getDepartureHarborName();
            TextStyle sub = TypographyKt.getSub();
            TextAlign.Companion companion5 = TextAlign.INSTANCE;
            TextKt.m940Text4IGK_g(departureHarborName, weight$default, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion5.m2533getStarte0LSkKk()), 0L, 0, false, 0, 0, null, sub, startRestartGroup, 0, 1572864, 65020);
            TextKt.m940Text4IGK_g(iDepartureInfo.getArrivalHarborName(), RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion5.m2529getEnde0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 0, 1572864, 65020);
            startRestartGroup.endNode();
            final String stringResource2 = StringResources_androidKt.stringResource(R.string.accessibilityLabel_departureTimes, new Object[]{LocalDateTimeExtensionsKt.toFormatTime(iDepartureInfo.getDepartureTime()), LocalDateTimeExtensionsKt.toFormatTime(iDepartureInfo.getArrivalTime())}, startRestartGroup, 6);
            Modifier m313paddingVpY3zN4$default2 = PaddingKt.m313paddingVpY3zN4$default(SizeKt.m327heightInVpY3zN4$default(companion2, Dp.m2599constructorimpl(32), 0.0f, 2, null), Dp.m2599constructorimpl(f5), 0.0f, 2, null);
            startRestartGroup.startReplaceGroup(305387953);
            boolean changed2 = startRestartGroup.changed(stringResource2);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: C4.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DepartureInfoView$lambda$9$lambda$8;
                        DepartureInfoView$lambda$9$lambda$8 = TicketSectionKt.DepartureInfoView$lambda$9$lambda$8(stringResource2, (SemanticsPropertyReceiver) obj);
                        return DepartureInfoView$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier clearAndSetSemantics2 = SemanticsModifierKt.clearAndSetSemantics(m313paddingVpY3zN4$default2, (Function1) rememberedValue2);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics2);
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            TextKt.m940Text4IGK_g(LocalDateTimeExtensionsKt.toFormatTime(iDepartureInfo.getDepartureTime()), RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 0, 1572864, 65532);
            RouteType routeType = iDepartureInfo.getRouteType();
            if (routeType != null) {
                Ferry ferry = iDepartureInfo.getFerry();
                num = Integer.valueOf(RouteTypeExtensionsKt.icon(routeType, ferry != null ? ferry.getType() : null));
            } else {
                num = null;
            }
            startRestartGroup.startReplaceGroup(1973948886);
            if (num == null) {
                companion = companion2;
            } else {
                int intValue = num.intValue();
                Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_forward_arrows_three, startRestartGroup, 6);
                Accessibility accessibility = Accessibility.INSTANCE;
                ImageKt.Image(painterResource, accessibility.getSkip(), null, null, null, 0.0f, null, startRestartGroup, 0, 124);
                companion = companion2;
                ImageKt.Image(PainterResources_androidKt.painterResource(intValue, startRestartGroup, 0), accessibility.getSkip(), PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(12), 0.0f, 2, null), null, null, 0.0f, null, startRestartGroup, 384, 120);
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_forward_arrows_three, startRestartGroup, 6), accessibility.getSkip(), null, null, null, 0.0f, null, startRestartGroup, 0, 124);
            }
            startRestartGroup.endReplaceGroup();
            Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(LocalDateTimeExtensionsKt.toFormatTime(iDepartureInfo.getArrivalTime()), weight$default2, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion5.m2529getEnde0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer2, 0, 1572864, 65020);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: C4.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DepartureInfoView$lambda$12;
                    DepartureInfoView$lambda$12 = TicketSectionKt.DepartureInfoView$lambda$12(IDepartureInfo.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DepartureInfoView$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureInfoView$lambda$12(IDepartureInfo iDepartureInfo, int i5, Composer composer, int i6) {
        DepartureInfoView(iDepartureInfo, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureInfoView$lambda$6$lambda$5(String str, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureInfoView$lambda$9$lambda$8(String str, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, str);
        return Unit.INSTANCE;
    }

    public static final void TicketSection(final IDepartureInfo departure, final TicketCategory category, final Transportation transportation, final PassengerInfo passengerInfo, final ISummaryProduct iSummaryProduct, final List<? extends ISummaryProduct> transportProducts, final boolean z5, final Price ticketPrice, final TransportationCargoInfo transportationCargoInfo, final List<TicketSurcharge> surcharges, final Subline subline, final String str, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Composer composer2;
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(transportation, "transportation");
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(transportProducts, "transportProducts");
        Intrinsics.checkNotNullParameter(ticketPrice, "ticketPrice");
        Intrinsics.checkNotNullParameter(surcharges, "surcharges");
        Composer startRestartGroup = composer.startRestartGroup(2040130156);
        if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(departure) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(category) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(transportation) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(passengerInfo) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(iSummaryProduct) ? 16384 : 8192;
        }
        if ((i5 & 196608) == 0) {
            i7 |= startRestartGroup.changedInstance(transportProducts) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i7 |= startRestartGroup.changedInstance(ticketPrice) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i7 |= startRestartGroup.changedInstance(transportationCargoInfo) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i7 |= startRestartGroup.changedInstance(surcharges) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i8 = i6 | (startRestartGroup.changedInstance(subline) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        int i9 = i8;
        if ((i7 & 306783379) == 306783378 && (i9 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2040130156, i7, i9, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSection (TicketSection.kt:72)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z5, null, EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null), EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null), null, ComposableSingletons$TicketSectionKt.INSTANCE.m3559getLambda1$app_kombardoProd(), startRestartGroup, ((i7 >> 18) & 14) | 200064, 18);
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            AppColor appColor = AppColor.INSTANCE;
            int i10 = i7;
            Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(fillMaxWidth$default, appColor.m3269getGrey60d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium());
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m103backgroundbw27NRU);
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
            float f5 = 12;
            float f6 = 16;
            LineIconViewKt.LineIconView(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6), 0.0f, 8, null), subline, str, startRestartGroup, (i9 << 3) & 1008, 0);
            Modifier m314paddingqDBjuR0 = PaddingKt.m314paddingqDBjuR0(companion, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(14));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m314paddingqDBjuR0);
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
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
            String formatWithFullMonth = LocalDateTimeExtensionsKt.toFormatWithFullMonth(departure.getDate());
            TextStyle sub = TypographyKt.getSub();
            TextAlign.Companion companion4 = TextAlign.INSTANCE;
            TextKt.m940Text4IGK_g(formatWithFullMonth, weight$default, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2533getStarte0LSkKk()), 0L, 0, false, 0, 0, null, sub, startRestartGroup, 0, 1572864, 65020);
            float f7 = 8;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(BackgroundKt.m103backgroundbw27NRU(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(24)), appColor.m3268getGrey50d7_KjU(), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(f5))), Dp.m2599constructorimpl(f7), 0.0f, 2, null);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
            BoxKt.Box(BackgroundKt.m103backgroundbw27NRU(SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(10)), TicketCategoryExtensionsKt.getColor(category), RoundedCornerShapeKt.getCircleShape()), startRestartGroup, 0);
            TextKt.m940Text4IGK_g(category.getName(), PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2529getEnde0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmallBold(), startRestartGroup, 48, 1572864, 65020);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            DepartureInfoView(departure, startRestartGroup, i10 & 14);
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
            float f8 = (float) 0.5d;
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(m315paddingqDBjuR0$default, 0L, Dp.m2599constructorimpl(f8), null, startRestartGroup, 390, 10);
            int i11 = i10 >> 9;
            TransportationInfoViewKt.TransportationInfoView(transportation, passengerInfo, iSummaryProduct, transportProducts, z5, transportationCargoInfo, surcharges, startRestartGroup, ((i10 >> 6) & 65534) | (458752 & i11) | (i11 & 3670016));
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, Dp.m2599constructorimpl(f8), null, startRestartGroup, 384, 11);
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(companion, Dp.m2599constructorimpl(f6));
            composer2 = startRestartGroup;
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composer2, 48);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, m311padding3ABfNKs);
            Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor4);
            } else {
                composer2.useNode();
            }
            Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer2);
            Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion3.getSetModifier());
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.ticketInfo_ticketPrice, composer2, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65534);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), composer2, 0);
            PriceTextKt.m3557PriceText1y9Plug(ticketPrice, PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f7), 0.0f, 0.0f, 0.0f, 14, null), (PriceViewType) null, false, TypographyKt.getSubBold(), (TextAlign) null, 0, 0L, composer2, ((i10 >> 21) & 14) | 24624, 236);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: C4.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketSection$lambda$4;
                    TicketSection$lambda$4 = TicketSectionKt.TicketSection$lambda$4(IDepartureInfo.this, category, transportation, passengerInfo, iSummaryProduct, transportProducts, z5, ticketPrice, transportationCargoInfo, surcharges, subline, str, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketSection$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketSection$lambda$4(IDepartureInfo iDepartureInfo, TicketCategory ticketCategory, Transportation transportation, PassengerInfo passengerInfo, ISummaryProduct iSummaryProduct, List list, boolean z5, Price price, TransportationCargoInfo transportationCargoInfo, List list2, Subline subline, String str, int i5, int i6, Composer composer, int i7) {
        TicketSection(iDepartureInfo, ticketCategory, transportation, passengerInfo, iSummaryProduct, list, z5, price, transportationCargoInfo, list2, subline, str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }
}
