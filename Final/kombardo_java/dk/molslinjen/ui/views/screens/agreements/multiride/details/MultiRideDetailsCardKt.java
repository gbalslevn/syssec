package dk.molslinjen.ui.views.screens.agreements.multiride.details;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.Feature;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideTransport;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.extensions.DoubleExtensionsKt;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.barcode.BarcodeViewType;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideCardInfoViewKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideExpireInfoBoxKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsCardKt;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidity;
import dk.molslinjen.ui.views.shared.components.BarcodeWidgetKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001ak\u0010\f\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u00022*\u0010\u000b\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0007j\u0002`\nH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0003¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "multiRideCard", "Lkotlin/Function1;", BuildConfig.FLAVOR, "navigateToOrderTicket", BuildConfig.FLAVOR, "navigateToRefillMultiRide", "Lkotlin/Function4;", "Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;", "Ldk/molslinjen/ui/views/shared/components/ExpandBarcodeCallback;", "expandBarcode", "MultiRideDetailsCard", "(Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideTransport;", "transport", BuildConfig.FLAVOR, "showAsExpired", "TransportInfo", "(Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideTransport;ZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MultiRideDetailsCardKt {
    public static final void MultiRideDetailsCard(final MultiRideCard multiRideCard, final Function1<? super MultiRideCard, Unit> navigateToOrderTicket, final Function1<? super String, Unit> navigateToRefillMultiRide, final Function4<? super String, ? super String, ? super BarcodeViewType, ? super BarcodeValidity, Unit> expandBarcode, Composer composer, final int i5) {
        int i6;
        float f5;
        int i7;
        int i8;
        Object obj;
        Composer composer2;
        float f6;
        int i9;
        int i10;
        String stringResource;
        Intrinsics.checkNotNullParameter(multiRideCard, "multiRideCard");
        Intrinsics.checkNotNullParameter(navigateToOrderTicket, "navigateToOrderTicket");
        Intrinsics.checkNotNullParameter(navigateToRefillMultiRide, "navigateToRefillMultiRide");
        Intrinsics.checkNotNullParameter(expandBarcode, "expandBarcode");
        Composer startRestartGroup = composer.startRestartGroup(886365956);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(multiRideCard) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToOrderTicket) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToRefillMultiRide) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(expandBarcode) ? 2048 : 1024;
        }
        int i11 = i6;
        if ((i11 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(886365956, i11, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsCard (MultiRideDetailsCard.kt:48)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f7 = 16;
            float f8 = 24;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(ModifierExtensionsKt.defaultShadow(companion, ThemeShapesKt.getThemeShapes().getMedium()), 0.0f, 1, null), AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f7), 0.0f, 2, null), 0.0f, Dp.m2599constructorimpl(8), 0.0f, Dp.m2599constructorimpl(f8), 5, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            MultiRideCardInfoViewKt.MultiRideCardInfoView(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), multiRideCard, startRestartGroup, ((i11 << 3) & 112) | 6, 0);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(20)), startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(7977989);
            Iterator<T> it = multiRideCard.getEnabledTransportations().iterator();
            while (it.hasNext()) {
                TransportInfo((MultiRideTransport) it.next(), multiRideCard.isExpired(), startRestartGroup, 0);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(f7)), startRestartGroup, 6);
            }
            startRestartGroup.endReplaceGroup();
            MultiRideExpireInfoBoxKt.MultiRideExpireInfoBox(multiRideCard, startRestartGroup, i11 & 14);
            startRestartGroup.startReplaceGroup(7985891);
            if (multiRideCard.isExpired() || multiRideCard.getRemainingCharges() <= 0) {
                f5 = f7;
                i7 = i11;
                i8 = 0;
                obj = null;
                composer2 = startRestartGroup;
                f6 = 0.0f;
                i9 = 6;
                i10 = 1;
            } else {
                Modifier.Companion companion3 = Modifier.INSTANCE;
                f5 = f7;
                i8 = 0;
                obj = null;
                HorizontalDividerKt.m3388HorizontalDividertZIQpXc(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(2)), startRestartGroup, 3078, 6);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion3, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(7994680);
                if (multiRideCard.getTicketType() == TicketCategoryType.BlueClass) {
                    if (Feature.OnlyWalkingPassengers.isEnabled()) {
                        startRestartGroup.startReplaceGroup(247968878);
                        stringResource = StringResources_androidKt.stringResource(R.string.ticketDetails_scanAtTerminal_kombardo, startRestartGroup, 6);
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(248081036);
                        stringResource = StringResources_androidKt.stringResource(R.string.ticketDetails_scanAtTerminal_molslinjen, startRestartGroup, 6);
                        startRestartGroup.endReplaceGroup();
                    }
                    BarcodeWidgetKt.BarcodeWidget(multiRideCard.getId(), stringResource, null, expandBarcode, null, startRestartGroup, i11 & 7168, 20);
                    i9 = 6;
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion3, Dp.m2599constructorimpl(f8)), startRestartGroup, 6);
                } else {
                    i9 = 6;
                }
                startRestartGroup.endReplaceGroup();
                f6 = 0.0f;
                i10 = 1;
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
                ButtonConfig buttonConfig = ButtonConfig.Large;
                String stringResource2 = StringResources_androidKt.stringResource(R.string.button_orderTicket, startRestartGroup, i9);
                startRestartGroup.startReplaceGroup(8022385);
                boolean changedInstance = ((i11 & 112) == 32) | startRestartGroup.changedInstance(multiRideCard);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: y2.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit MultiRideDetailsCard$lambda$5$lambda$2$lambda$1;
                            MultiRideDetailsCard$lambda$5$lambda$2$lambda$1 = MultiRideDetailsCardKt.MultiRideDetailsCard$lambda$5$lambda$2$lambda$1(Function1.this, multiRideCard);
                            return MultiRideDetailsCard$lambda$5$lambda$2$lambda$1;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                i7 = i11;
                composer2 = startRestartGroup;
                PrimaryButtonKt.PrimaryButton(fillMaxWidth$default, stringResource2, (Function0) rememberedValue, null, buttonConfig, false, false, false, composer2, 24582, 232);
            }
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(8025072);
            if (multiRideCard.getEnableForRefill()) {
                Modifier.Companion companion4 = Modifier.INSTANCE;
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion4, Dp.m2599constructorimpl(f5)), composer2, i9);
                Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion4, f6, i10, obj);
                ButtonConfig buttonConfig2 = ButtonConfig.Large;
                String stringResource3 = StringResources_androidKt.stringResource(R.string.multiRide_refill, composer2, i9);
                composer2.startReplaceGroup(8034968);
                if ((i7 & 896) != 256) {
                    i10 = i8;
                }
                int i12 = (composer2.changedInstance(multiRideCard) ? 1 : 0) | i10;
                Object rememberedValue2 = composer2.rememberedValue();
                if (i12 != 0 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: y2.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit MultiRideDetailsCard$lambda$5$lambda$4$lambda$3;
                            MultiRideDetailsCard$lambda$5$lambda$4$lambda$3 = MultiRideDetailsCardKt.MultiRideDetailsCard$lambda$5$lambda$4$lambda$3(Function1.this, multiRideCard);
                            return MultiRideDetailsCard$lambda$5$lambda$4$lambda$3;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                }
                composer2.endReplaceGroup();
                SecondaryButtonKt.m3406SecondaryButtonbZJ32A(fillMaxWidth$default2, stringResource3, (Function0) rememberedValue2, null, false, buttonConfig2, false, null, null, 0L, false, composer2, 196614, 0, 2008);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: y2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit MultiRideDetailsCard$lambda$6;
                    MultiRideDetailsCard$lambda$6 = MultiRideDetailsCardKt.MultiRideDetailsCard$lambda$6(MultiRideCard.this, navigateToOrderTicket, navigateToRefillMultiRide, expandBarcode, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return MultiRideDetailsCard$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideDetailsCard$lambda$5$lambda$2$lambda$1(Function1 function1, MultiRideCard multiRideCard) {
        function1.invoke(multiRideCard);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideDetailsCard$lambda$5$lambda$4$lambda$3(Function1 function1, MultiRideCard multiRideCard) {
        function1.invoke(multiRideCard.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideDetailsCard$lambda$6(MultiRideCard multiRideCard, Function1 function1, Function1 function12, Function4 function4, int i5, Composer composer, int i6) {
        MultiRideDetailsCard(multiRideCard, function1, function12, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void TransportInfo(final MultiRideTransport multiRideTransport, final boolean z5, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1498391771);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(multiRideTransport) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1498391771, i6, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.details.TransportInfo (MultiRideDetailsCard.kt:113)");
            }
            AppColor appColor = AppColor.INSTANCE;
            long m3266getGrey30d7_KjU = z5 ? appColor.m3266getGrey30d7_KjU() : appColor.m3264getGrey10d7_KjU();
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
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
            Modifier m331size3ABfNKs = SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(24));
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_car, startRestartGroup, 6);
            String skip = Accessibility.INSTANCE.getSkip();
            AppColor appColor2 = AppColor.INSTANCE;
            IconKt.m857Iconww6aTOc(painterResource, skip, m331size3ABfNKs, z5 ? appColor2.m3267getGrey40d7_KjU() : appColor2.m3266getGrey30d7_KjU(), startRestartGroup, 384, 0);
            float f5 = 16;
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            String name = multiRideTransport.getName();
            TextStyle paragraph = TypographyKt.getParagraph();
            AppColor appColor3 = AppColor.INSTANCE;
            TextKt.m940Text4IGK_g(name, null, z5 ? appColor3.m3266getGrey30d7_KjU() : appColor3.m3253getBrandBlack10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, paragraph, startRestartGroup, 0, 1572864, 65530);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), startRestartGroup, 0);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_vehicles_row_vehicleHeight, new Object[]{DoubleExtensionsKt.format(multiRideTransport.getMaxHeightInMeters(), 2)}, startRestartGroup, 6), null, m3266getGrey30d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 0, 1572864, 65530);
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_vehicles_row_vehicleLength, new Object[]{DoubleExtensionsKt.format(multiRideTransport.getMaxLengthInMeters(), 2)}, startRestartGroup, 6), null, m3266getGrey30d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65530);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: y2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TransportInfo$lambda$8;
                    TransportInfo$lambda$8 = MultiRideDetailsCardKt.TransportInfo$lambda$8(MultiRideTransport.this, z5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TransportInfo$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportInfo$lambda$8(MultiRideTransport multiRideTransport, boolean z5, int i5, Composer composer, int i6) {
        TransportInfo(multiRideTransport, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
