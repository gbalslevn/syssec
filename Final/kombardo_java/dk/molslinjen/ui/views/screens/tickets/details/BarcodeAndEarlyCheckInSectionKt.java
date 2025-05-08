package dk.molslinjen.ui.views.screens.tickets.details;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.Feature;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.barcode.BarcodeViewType;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.TravelDetailsState;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidity;
import dk.molslinjen.ui.views.screens.tickets.details.BarcodeAndEarlyCheckInSectionKt;
import dk.molslinjen.ui.views.shared.components.BarcodeWidgetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0095\u0001\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2*\u0010\u000f\u001a&\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\nj\u0002`\u000e2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a%\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0012H\u0003¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {BuildConfig.FLAVOR, "barcode", BuildConfig.FLAVOR, "routeWithEarlyCheck", "earlyCheckInPossible", "hideBarcodeDescription", "isCheckedIn", "isWalking", "Ldk/molslinjen/ui/views/screens/booking/shared/kombardoTravelDetails/IKombardoTravelDetailsHandler$TravelDetailsState;", "travelDetailsState", "Lkotlin/Function4;", "Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/shared/components/ExpandBarcodeCallback;", "expandBarcode", "Lkotlin/Function1;", "showOnMap", "Lkotlin/Function0;", "startEarlyCheckIn", "BarcodeAndEarlyCheckInSection", "(Ljava/lang/String;ZZZZZLdk/molslinjen/ui/views/screens/booking/shared/kombardoTravelDetails/IKombardoTravelDetailsHandler$TravelDetailsState;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "EarlyCheckedInSection", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BarcodeAndEarlyCheckInSectionKt {
    public static final void BarcodeAndEarlyCheckInSection(final String barcode, final boolean z5, final boolean z6, final boolean z7, final boolean z8, final boolean z9, final TravelDetailsState travelDetailsState, final Function4<? super String, ? super String, ? super BarcodeViewType, ? super BarcodeValidity, Unit> expandBarcode, final Function1<? super String, Unit> showOnMap, final Function0<Unit> startEarlyCheckIn, Composer composer, final int i5) {
        int i6;
        final String stringResource;
        Composer composer2;
        TravelDetailsState travelDetailsState2;
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        Intrinsics.checkNotNullParameter(travelDetailsState, "travelDetailsState");
        Intrinsics.checkNotNullParameter(expandBarcode, "expandBarcode");
        Intrinsics.checkNotNullParameter(showOnMap, "showOnMap");
        Intrinsics.checkNotNullParameter(startEarlyCheckIn, "startEarlyCheckIn");
        Composer startRestartGroup = composer.startRestartGroup(739952189);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(barcode) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(z7) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(z8) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(z9) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(travelDetailsState) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(expandBarcode) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(showOnMap) ? 67108864 : 33554432;
        }
        if ((805306368 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(startEarlyCheckIn) ? 536870912 : 268435456;
        }
        int i7 = i6;
        if ((306783379 & i7) == 306783378 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(739952189, i7, -1, "dk.molslinjen.ui.views.screens.tickets.details.BarcodeAndEarlyCheckInSection (BarcodeAndEarlyCheckInSection.kt:47)");
            }
            if (z7) {
                startRestartGroup.startReplaceGroup(1976003729);
                startRestartGroup.endReplaceGroup();
                stringResource = null;
            } else if (Feature.OnlyWalkingPassengers.isEnabled()) {
                startRestartGroup.startReplaceGroup(340838639);
                stringResource = StringResources_androidKt.stringResource(R.string.ticketDetails_scanAtTerminal_kombardo, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(340841329);
                stringResource = StringResources_androidKt.stringResource(R.string.ticketDetails_scanAtTerminal_molslinjen, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            final BarcodeValidity barcodeValidity = BarcodeValidity.Valid;
            if (z8) {
                startRestartGroup.startReplaceGroup(1976290232);
                startRestartGroup.startReplaceGroup(340848922);
                boolean changed = ((29360128 & i7) == 8388608) | ((i7 & 14) == 4) | startRestartGroup.changed(stringResource);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: p4.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit BarcodeAndEarlyCheckInSection$lambda$1$lambda$0;
                            BarcodeAndEarlyCheckInSection$lambda$1$lambda$0 = BarcodeAndEarlyCheckInSectionKt.BarcodeAndEarlyCheckInSection$lambda$1$lambda$0(Function4.this, barcode, stringResource, barcodeValidity);
                            return BarcodeAndEarlyCheckInSection$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                EarlyCheckedInSection(z9, (Function0) rememberedValue, startRestartGroup, (i7 >> 15) & 14);
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
            } else {
                startRestartGroup.startReplaceGroup(1976550725);
                Modifier.Companion companion = Modifier.INSTANCE;
                float f5 = 16;
                Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(ModifierExtensionsKt.defaultShadow$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), null, 1, null), AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f5));
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                String str = stringResource;
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
                BarcodeWidgetKt.BarcodeWidget(barcode, str, null, expandBarcode, barcodeValidity, startRestartGroup, (i7 & 14) | 24576 | ((i7 >> 12) & 7168), 4);
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(703732331);
                if (z5) {
                    Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
                    travelDetailsState2 = travelDetailsState;
                    PrimaryButtonKt.PrimaryButton(m315paddingqDBjuR0$default, StringResources_androidKt.stringResource(z6 ? R.string.tickets_earlyCheckIn_checkIn : R.string.tickets_earlyCheckIn_checkIn_notOpened, composer2, 0), startEarlyCheckIn, null, null, z6, false, false, composer2, ((i7 >> 21) & 896) | 6 | ((i7 << 9) & 458752), 216);
                } else {
                    travelDetailsState2 = travelDetailsState;
                }
                composer2.endReplaceGroup();
                composer2.startReplaceGroup(703752840);
                if (Feature.OnlyWalkingPassengers.isEnabled()) {
                    TicketDetailsTravelDetailsSectionKt.TicketDetailsTravelDetailsSection(travelDetailsState2, showOnMap, composer2, ((i7 >> 18) & 14) | ((i7 >> 21) & 112));
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: p4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BarcodeAndEarlyCheckInSection$lambda$3;
                    BarcodeAndEarlyCheckInSection$lambda$3 = BarcodeAndEarlyCheckInSectionKt.BarcodeAndEarlyCheckInSection$lambda$3(barcode, z5, z6, z7, z8, z9, travelDetailsState, expandBarcode, showOnMap, startEarlyCheckIn, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return BarcodeAndEarlyCheckInSection$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BarcodeAndEarlyCheckInSection$lambda$1$lambda$0(Function4 function4, String str, String str2, BarcodeValidity barcodeValidity) {
        function4.invoke(str, str2, BarcodeViewType.CODE_128, barcodeValidity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BarcodeAndEarlyCheckInSection$lambda$3(String str, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, TravelDetailsState travelDetailsState, Function4 function4, Function1 function1, Function0 function0, int i5, Composer composer, int i6) {
        BarcodeAndEarlyCheckInSection(str, z5, z6, z7, z8, z9, travelDetailsState, function4, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void EarlyCheckedInSection(final boolean z5, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        int i7;
        Composer composer3;
        Composer startRestartGroup = composer.startRestartGroup(460279816);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i8 = i6;
        if ((i8 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(460279816, i8, -1, "dk.molslinjen.ui.views.screens.tickets.details.EarlyCheckedInSection (BarcodeAndEarlyCheckInSection.kt:105)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier defaultShadow = ModifierExtensionsKt.defaultShadow(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), ThemeShapesKt.getThemeShapes().getLarge());
            AppColor appColor = AppColor.INSTANCE;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(defaultShadow, appColor.m3268getGrey50d7_KjU(), null, 2, null), Dp.m2599constructorimpl(24));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
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
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_checkmark_tick_small, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(32)), Color.INSTANCE.m1501getUnspecified0d7_KjU(), startRestartGroup, 3456, 0);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.tickets_earlyCheckIn_checkedIn, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), startRestartGroup, 48, 1572864, 65532);
            startRestartGroup.startReplaceGroup(-1075111599);
            if (z5) {
                composer2 = startRestartGroup;
                i7 = 8;
            } else {
                composer2 = startRestartGroup;
                i7 = 8;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.tickets_earlyCheckIn_checkedIn_details, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 432, 1572864, 65016);
            }
            composer2.endReplaceGroup();
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(i7), 0.0f, 0.0f, 13, null);
            composer3 = composer2;
            composer3.startReplaceGroup(-1075097674);
            boolean z6 = (i8 & 112) == 32;
            Object rememberedValue = composer3.rememberedValue();
            if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: p4.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit EarlyCheckedInSection$lambda$6$lambda$5$lambda$4;
                        EarlyCheckedInSection$lambda$6$lambda$5$lambda$4 = BarcodeAndEarlyCheckInSectionKt.EarlyCheckedInSection$lambda$6$lambda$5$lambda$4(Function0.this);
                        return EarlyCheckedInSection$lambda$6$lambda$5$lambda$4;
                    }
                };
                composer3.updateRememberedValue(rememberedValue);
            }
            composer3.endReplaceGroup();
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.tickets_earlyCheckIn_checkedIn_cta, composer3, 6), ClickableKt.m122clickableXHw0xAI$default(m315paddingqDBjuR0$default, false, null, null, (Function0) rememberedValue, 7, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer3, 100663680, 1572864, 65272);
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: p4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit EarlyCheckedInSection$lambda$7;
                    EarlyCheckedInSection$lambda$7 = BarcodeAndEarlyCheckInSectionKt.EarlyCheckedInSection$lambda$7(z5, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return EarlyCheckedInSection$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckedInSection$lambda$6$lambda$5$lambda$4(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckedInSection$lambda$7(boolean z5, Function0 function0, int i5, Composer composer, int i6) {
        EarlyCheckedInSection(z5, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
