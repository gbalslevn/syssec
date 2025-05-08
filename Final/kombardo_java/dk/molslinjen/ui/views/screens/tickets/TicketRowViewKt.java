package dk.molslinjen.ui.views.screens.tickets;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.Feature;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.booking.BookingHeader;
import dk.molslinjen.domain.model.booking.RouteType;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.AddressViewKt;
import dk.molslinjen.ui.views.screens.tickets.TicketRowViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u001ac\u0010\r\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a=\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\bH\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a5\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0003¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingHeader;", "bookingHeader", BuildConfig.FLAVOR, "address", "Lkotlin/Function0;", BuildConfig.FLAVOR, "showDetails", "startEarlyCheckIn", "Lkotlin/Function1;", "showOnMap", BuildConfig.FLAVOR, "isHistory", "isWalkingForEarlyCheckIn", "TicketRowView", "(Ldk/molslinjen/domain/model/booking/BookingHeader;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;ZZLandroidx/compose/runtime/Composer;II)V", "DepartingAddressInfo", "(ZLjava/lang/String;Ldk/molslinjen/domain/model/booking/BookingHeader;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "earlyCheckInPossible", "isCheckedIn", "isWalking", "EarlyCheckInSection", "(ZZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketRowViewKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RouteType.values().length];
            try {
                iArr[RouteType.Shuttle.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DepartingAddressInfo(final boolean z5, final String str, final BookingHeader bookingHeader, final Function1<? super String, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        String stringResource;
        boolean z6;
        Composer startRestartGroup = composer.startRestartGroup(246029005);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(bookingHeader) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(246029005, i6, -1, "dk.molslinjen.ui.views.screens.tickets.DepartingAddressInfo (TicketRowView.kt:200)");
            }
            if (!Feature.OnlyWalkingPassengers.isEnabled() || z5 || !bookingHeader.departureDateTime().isBefore(LocalDateTime.now().plusDays(1L)) || str == null) {
                composer2 = startRestartGroup;
            } else {
                Modifier.Companion companion = Modifier.INSTANCE;
                float f5 = 16;
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), 2, null);
                AppColor appColor = AppColor.INSTANCE;
                int i7 = i6;
                Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(m315paddingqDBjuR0$default, appColor.m3269getGrey60d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(1), appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5));
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
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
                RouteType routeType = bookingHeader.getRouteType();
                if ((routeType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[routeType.ordinal()]) == 1) {
                    startRestartGroup.startReplaceGroup(1153080606);
                    stringResource = StringResources_androidKt.stringResource(R.string.ticketDetails_shuttle, startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                    z6 = false;
                } else {
                    startRestartGroup.startReplaceGroup(1153238582);
                    stringResource = StringResources_androidKt.stringResource(R.string.ticketDetails_departingFrom, new Object[]{bookingHeader.getDepartureHarborName()}, startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                    z6 = true;
                }
                TextKt.m940Text4IGK_g(stringResource, PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(8), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 48, 0, 131068);
                startRestartGroup.startReplaceGroup(-516969671);
                int i8 = i7 & 112;
                boolean z7 = ((i7 & 7168) == 2048) | (i8 == 32);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z7 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: m4.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit DepartingAddressInfo$lambda$4$lambda$3$lambda$2;
                            DepartingAddressInfo$lambda$4$lambda$3$lambda$2 = TicketRowViewKt.DepartingAddressInfo$lambda$4$lambda$3$lambda$2(Function1.this, str, (String) obj);
                            return DepartingAddressInfo$lambda$4$lambda$3$lambda$2;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                AddressViewKt.AddressView(null, str, true, true, true, z6, (Function1) rememberedValue, startRestartGroup, i8 | 28032, 1);
                composer2.endNode();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m4.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DepartingAddressInfo$lambda$5;
                    DepartingAddressInfo$lambda$5 = TicketRowViewKt.DepartingAddressInfo$lambda$5(z5, str, bookingHeader, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DepartingAddressInfo$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartingAddressInfo$lambda$4$lambda$3$lambda$2(Function1 function1, String str, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartingAddressInfo$lambda$5(boolean z5, String str, BookingHeader bookingHeader, Function1 function1, int i5, Composer composer, int i6) {
        DepartingAddressInfo(z5, str, bookingHeader, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EarlyCheckInSection(final boolean z5, final boolean z6, final boolean z7, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(216969340);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z7) ? 256 : 128;
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
                ComposerKt.traceEventStart(216969340, i7, -1, "dk.molslinjen.ui.views.screens.tickets.EarlyCheckInSection (TicketRowView.kt:250)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 16;
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(SizeKt.fillMaxWidth$default(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f5), 5, null), 0.0f, 1, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(2)), startRestartGroup, 3078, 6);
            if (z6) {
                startRestartGroup.startReplaceGroup(-236666373);
                Alignment.Companion companion2 = Alignment.INSTANCE;
                Alignment.Vertical centerVertically = companion2.getCenterVertically();
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_checkmark_tick_small, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(22)), Color.INSTANCE.m1501getUnspecified0d7_KjU(), startRestartGroup, 3456, 0);
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(12)), startRestartGroup, 6);
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
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.tickets_earlyCheckIn_checkedIn, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 0, 1572864, 65534);
                startRestartGroup.startReplaceGroup(-2145670981);
                if (!z7) {
                    TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.tickets_earlyCheckIn_checkedIn_details, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 13, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), startRestartGroup, 432, 1572864, 65528);
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
            } else if (z5) {
                startRestartGroup.startReplaceGroup(-235609459);
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
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
                Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                PrimaryButtonKt.PrimaryButton(null, StringResources_androidKt.stringResource(R.string.tickets_earlyCheckIn_checkIn, startRestartGroup, 6), function0, null, null, false, false, false, startRestartGroup, (i7 >> 3) & 896, 249);
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null);
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.tickets_earlyCheckIn_checkIn_details, composer2, 6), m315paddingqDBjuR0$default, AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 432, 1572864, 65528);
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(-235074957);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m4.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit EarlyCheckInSection$lambda$9;
                    EarlyCheckInSection$lambda$9 = TicketRowViewKt.EarlyCheckInSection$lambda$9(z5, z6, z7, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return EarlyCheckInSection$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInSection$lambda$9(boolean z5, boolean z6, boolean z7, Function0 function0, int i5, Composer composer, int i6) {
        EarlyCheckInSection(z5, z6, z7, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TicketRowView(final BookingHeader bookingHeader, final String str, final Function0<Unit> showDetails, final Function0<Unit> startEarlyCheckIn, final Function1<? super String, Unit> showOnMap, boolean z5, final boolean z6, Composer composer, final int i5, final int i6) {
        int i7;
        boolean z7;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        Composer composer2;
        final boolean z8;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(bookingHeader, "bookingHeader");
        Intrinsics.checkNotNullParameter(showDetails, "showDetails");
        Intrinsics.checkNotNullParameter(startEarlyCheckIn, "startEarlyCheckIn");
        Intrinsics.checkNotNullParameter(showOnMap, "showOnMap");
        Composer startRestartGroup = composer.startRestartGroup(306976514);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(bookingHeader) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(showDetails) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(startEarlyCheckIn) ? 2048 : 1024;
        }
        if ((i6 & 16) != 0) {
            i7 |= 24576;
        } else if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(showOnMap) ? 16384 : 8192;
        }
        int i8 = i6 & 32;
        if (i8 != 0) {
            i7 |= 196608;
        } else if ((196608 & i5) == 0) {
            z7 = z5;
            i7 |= startRestartGroup.changed(z7) ? 131072 : 65536;
            if ((i6 & 64) == 0) {
                i7 |= 1572864;
            } else if ((i5 & 1572864) == 0) {
                i7 |= startRestartGroup.changed(z6) ? 1048576 : 524288;
            }
            if ((599187 & i7) == 599186 || !startRestartGroup.getSkipping()) {
                boolean z9 = i8 == 0 ? false : z7;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(306976514, i7, -1, "dk.molslinjen.ui.views.screens.tickets.TicketRowView (TicketRowView.kt:59)");
                }
                startRestartGroup.startReplaceGroup(1092823874);
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
                composer2 = startRestartGroup;
                CompositionLocalKt.CompositionLocalProvider(RippleKt.getLocalRippleConfiguration().provides(null), ComposableLambdaKt.rememberComposableLambda(2044508738, true, new TicketRowViewKt$TicketRowView$1(true, ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope(), animatable, showDetails, bookingHeader, z9, str, showOnMap, z6, startEarlyCheckIn), composer2, 54), composer2, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z8 = z9;
            } else {
                startRestartGroup.skipToGroupEnd();
                z8 = z7;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: m4.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit TicketRowView$lambda$1;
                        TicketRowView$lambda$1 = TicketRowViewKt.TicketRowView$lambda$1(BookingHeader.this, str, showDetails, startEarlyCheckIn, showOnMap, z8, z6, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return TicketRowView$lambda$1;
                    }
                });
                return;
            }
            return;
        }
        z7 = z5;
        if ((i6 & 64) == 0) {
        }
        if ((599187 & i7) == 599186) {
        }
        if (i8 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(1092823874);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        Animatable animatable2 = (Animatable) rememberedValue;
        startRestartGroup.endReplaceGroup();
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        composer2 = startRestartGroup;
        CompositionLocalKt.CompositionLocalProvider(RippleKt.getLocalRippleConfiguration().provides(null), ComposableLambdaKt.rememberComposableLambda(2044508738, true, new TicketRowViewKt$TicketRowView$1(true, ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope(), animatable2, showDetails, bookingHeader, z9, str, showOnMap, z6, startEarlyCheckIn), composer2, 54), composer2, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
        }
        z8 = z9;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketRowView$lambda$1(BookingHeader bookingHeader, String str, Function0 function0, Function0 function02, Function1 function1, boolean z5, boolean z6, int i5, int i6, Composer composer, int i7) {
        TicketRowView(bookingHeader, str, function0, function02, function1, z5, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
