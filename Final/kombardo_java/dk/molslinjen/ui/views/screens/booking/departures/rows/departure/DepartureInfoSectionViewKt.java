package dk.molslinjen.ui.views.screens.booking.departures.rows.departure;

import android.content.Context;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.Feature;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.booking.Ferry;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.booking.RouteType;
import dk.molslinjen.extensions.domain.DepartureExtensionsKt;
import dk.molslinjen.extensions.domain.RouteTypeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HighlightedTextKt;
import dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureInfoSectionViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u001aU\u0010\n\u001a\u00020\u00022\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", BuildConfig.FLAVOR, "onDepartureTextCoordinatesCaptured", "onDetailsContainerCoordinatesCaptured", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "departure", BuildConfig.FLAVOR, "showDisabled", "showDetailsLine", "DepartureInfoSection", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/domain/model/booking/IDepartureInfo;ZZLandroidx/compose/runtime/Composer;II)V", BuildConfig.FLAVOR, "routeId", "departingHarbor", "isHighlightedHarbor", "(Ljava/lang/String;Z)Z", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DepartureInfoSectionViewKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0671  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x067c  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0455  */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v27, types: [java.lang.Number] */
    /* JADX WARN: Type inference failed for: r14v37 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DepartureInfoSection(Function1<? super LayoutCoordinates, Unit> function1, Function1<? super LayoutCoordinates, Unit> function12, final IDepartureInfo departure, final boolean z5, boolean z6, Composer composer, final int i5, final int i6) {
        Function1<? super LayoutCoordinates, Unit> function13;
        int i7;
        Function1<? super LayoutCoordinates, Unit> function14;
        boolean z7;
        final Function1<? super LayoutCoordinates, Unit> function15;
        final Function1<? super LayoutCoordinates, Unit> function16;
        boolean z8;
        boolean changed;
        Object rememberedValue;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        boolean changed2;
        Object rememberedValue2;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        Composer composer2;
        RouteType routeType;
        Integer num;
        String str;
        int i8;
        final boolean z9;
        final Function1<? super LayoutCoordinates, Unit> function17;
        String str2;
        String name;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(departure, "departure");
        Composer startRestartGroup = composer.startRestartGroup(2014268136);
        int i9 = i6 & 1;
        if (i9 != 0) {
            i7 = i5 | 6;
            function13 = function1;
        } else if ((i5 & 6) == 0) {
            function13 = function1;
            i7 = (startRestartGroup.changedInstance(function13) ? 4 : 2) | i5;
        } else {
            function13 = function1;
            i7 = i5;
        }
        int i10 = i6 & 2;
        if (i10 != 0) {
            i7 |= 48;
            function14 = function12;
        } else {
            function14 = function12;
            if ((i5 & 48) == 0) {
                i7 |= startRestartGroup.changedInstance(function14) ? 32 : 16;
            }
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(departure) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 2048 : 1024;
        }
        int i11 = i6 & 16;
        if (i11 != 0) {
            i7 |= 24576;
        } else if ((i5 & 24576) == 0) {
            z7 = z6;
            i7 |= startRestartGroup.changed(z7) ? 16384 : 8192;
            if ((i7 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                if (i9 == 0) {
                    startRestartGroup.startReplaceGroup(1695006943);
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new Function1() { // from class: N2.a
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit DepartureInfoSection$lambda$1$lambda$0;
                                DepartureInfoSection$lambda$1$lambda$0 = DepartureInfoSectionViewKt.DepartureInfoSection$lambda$1$lambda$0((LayoutCoordinates) obj);
                                return DepartureInfoSection$lambda$1$lambda$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    function15 = (Function1) rememberedValue3;
                    startRestartGroup.endReplaceGroup();
                } else {
                    function15 = function13;
                }
                if (i10 == 0) {
                    startRestartGroup.startReplaceGroup(1695009407);
                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                    if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new Function1() { // from class: N2.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit DepartureInfoSection$lambda$3$lambda$2;
                                DepartureInfoSection$lambda$3$lambda$2 = DepartureInfoSectionViewKt.DepartureInfoSection$lambda$3$lambda$2((LayoutCoordinates) obj);
                                return DepartureInfoSection$lambda$3$lambda$2;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    function16 = (Function1) rememberedValue4;
                    startRestartGroup.endReplaceGroup();
                } else {
                    function16 = function14;
                }
                z8 = i11 == 0 ? true : z7;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2014268136, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureInfoSection (DepartureInfoSectionView.kt:47)");
                }
                AppColor appColor = AppColor.INSTANCE;
                final long m3266getGrey30d7_KjU = !z5 ? appColor.m3266getGrey30d7_KjU() : appColor.m3253getBrandBlack10d7_KjU();
                AppColor appColor2 = AppColor.INSTANCE;
                long m3266getGrey30d7_KjU2 = !z5 ? appColor2.m3266getGrey30d7_KjU() : appColor2.m3264getGrey10d7_KjU();
                boolean isHighlightedHarbor = isHighlightedHarbor(departure.getRouteId(), true);
                boolean isHighlightedHarbor2 = isHighlightedHarbor(departure.getRouteId(), false);
                final String stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_departureLocation, new Object[]{departure.getDepartureHarborName(), departure.getArrivalHarborName()}, startRestartGroup, 6);
                Alignment.Companion companion = Alignment.INSTANCE;
                Alignment.Vertical centerVertically = companion.getCenterVertically();
                Modifier.Companion companion2 = Modifier.INSTANCE;
                startRestartGroup.startReplaceGroup(1695034419);
                changed = startRestartGroup.changed(stringResource);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: N2.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit DepartureInfoSection$lambda$5$lambda$4;
                            DepartureInfoSection$lambda$5$lambda$4 = DepartureInfoSectionViewKt.DepartureInfoSection$lambda$5$lambda$4(stringResource, (SemanticsPropertyReceiver) obj);
                            return DepartureInfoSection$lambda$5$lambda$4;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion2, (Function1) rememberedValue);
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor);
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                int i12 = i7;
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                final RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                AppColor appColor3 = AppColor.INSTANCE;
                HighlightedTextKt.m3387HighlightedTextRuGn9fw(null, isHighlightedHarbor, appColor3.m3274getTagBlue0d7_KjU(), null, null, ComposableLambdaKt.rememberComposableLambda(-1402632972, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureInfoSectionViewKt$DepartureInfoSection$4$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num2) {
                        invoke(composer3, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i13) {
                        if ((i13 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1402632972, i13, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureInfoSection.<anonymous>.<anonymous> (DepartureInfoSectionView.kt:69)");
                        }
                        Modifier weight$default = RowScope.weight$default(RowScope.this, Modifier.INSTANCE, 1.0f, false, 2, null);
                        TextKt.m940Text4IGK_g(departure.getDepartureHarborName(), weight$default, m3266getGrey30d7_KjU, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2533getStarte0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer3, 0, 1572864, 65016);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, 196992, 25);
                HighlightedTextKt.m3387HighlightedTextRuGn9fw(null, isHighlightedHarbor2, appColor3.m3274getTagBlue0d7_KjU(), null, null, ComposableLambdaKt.rememberComposableLambda(1239834589, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureInfoSectionViewKt$DepartureInfoSection$4$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num2) {
                        invoke(composer3, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i13) {
                        if ((i13 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1239834589, i13, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureInfoSection.<anonymous>.<anonymous> (DepartureInfoSectionView.kt:82)");
                        }
                        Modifier weight$default = RowScope.weight$default(RowScope.this, Modifier.INSTANCE, 1.0f, false, 2, null);
                        TextKt.m940Text4IGK_g(departure.getArrivalHarborName(), weight$default, m3266getGrey30d7_KjU, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2529getEnde0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer3, 0, 1572864, 65016);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, 196992, 25);
                startRestartGroup.endNode();
                final String stringResource2 = StringResources_androidKt.stringResource(R.string.accessibilityLabel_departureTimes, new Object[]{LocalDateTimeExtensionsKt.toFormatTime(departure.getDepartureTime()), LocalDateTimeExtensionsKt.toFormatTime(departure.getArrivalTime())}, startRestartGroup, 6);
                Modifier m327heightInVpY3zN4$default = SizeKt.m327heightInVpY3zN4$default(companion2, Dp.m2599constructorimpl(32), 0.0f, 2, null);
                startRestartGroup.startReplaceGroup(1695076087);
                changed2 = startRestartGroup.changed(stringResource2);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: N2.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit DepartureInfoSection$lambda$8$lambda$7;
                            DepartureInfoSection$lambda$8$lambda$7 = DepartureInfoSectionViewKt.DepartureInfoSection$lambda$8$lambda$7(stringResource2, (SemanticsPropertyReceiver) obj);
                            return DepartureInfoSection$lambda$8$lambda$7;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                Modifier clearAndSetSemantics2 = SemanticsModifierKt.clearAndSetSemantics(m327heightInVpY3zN4$default, (Function1) rememberedValue2);
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getCenterVertically(), startRestartGroup, 48);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics2);
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor2);
                }
                m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(LocalDateTimeExtensionsKt.toFormatTime(departure.getDepartureTime()), RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), m3266getGrey30d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH3Bold(), composer2, 0, 1572864, 65528);
                routeType = departure.getRouteType();
                if (routeType == null) {
                    Ferry ferry = departure.getFerry();
                    num = Integer.valueOf(RouteTypeExtensionsKt.icon(routeType, ferry != null ? ferry.getType() : null));
                } else {
                    num = null;
                }
                composer2.startReplaceGroup(959013898);
                if (num != null) {
                    str = null;
                    i8 = 0;
                } else {
                    int intValue = num.intValue();
                    Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_forward_arrows, composer2, 6);
                    Accessibility accessibility = Accessibility.INSTANCE;
                    ImageKt.Image(painterResource, accessibility.getSkip(), null, null, null, 0.0f, null, composer2, 0, 124);
                    str = null;
                    i8 = 0;
                    ImageKt.Image(PainterResources_androidKt.painterResource(intValue, composer2, 0), accessibility.getSkip(), PaddingKt.m313paddingVpY3zN4$default(companion2, Dp.m2599constructorimpl(4), 0.0f, 2, null), null, null, 0.0f, null, composer2, 384, 120);
                    ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_forward_arrows, composer2, 6), accessibility.getSkip(), null, null, null, 0.0f, null, composer2, 0, 124);
                    Unit unit = Unit.INSTANCE;
                }
                composer2.endReplaceGroup();
                Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null);
                String formatTime = LocalDateTimeExtensionsKt.toFormatTime(departure.getArrivalTime());
                TextStyle h3Bold = TypographyKt.getH3Bold();
                TextAlign.Companion companion4 = TextAlign.INSTANCE;
                TextKt.m940Text4IGK_g(formatTime, weight$default, m3266getGrey30d7_KjU, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2529getEnde0LSkKk()), 0L, 0, false, 0, 0, null, h3Bold, composer2, 0, 1572864, 65016);
                composer2.endNode();
                if (z8) {
                    Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null);
                    composer2.startReplaceGroup(1695119506);
                    int i13 = (i12 & 112) == 32 ? 1 : i8;
                    Object rememberedValue5 = composer2.rememberedValue();
                    if (i13 != 0 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new Function1() { // from class: N2.e
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit DepartureInfoSection$lambda$12$lambda$11;
                                DepartureInfoSection$lambda$12$lambda$11 = DepartureInfoSectionViewKt.DepartureInfoSection$lambda$12$lambda$11(Function1.this, (LayoutCoordinates) obj);
                                return DepartureInfoSection$lambda$12$lambda$11;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue5);
                    }
                    composer2.endReplaceGroup();
                    Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(m315paddingqDBjuR0$default, (Function1) rememberedValue5);
                    MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), composer2, i8);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, i8);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, onGloballyPositioned);
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
                    Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy3, companion3.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
                    if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
                    Feature feature = Feature.MultipleRouteTypes;
                    if (feature.isEnabled()) {
                        composer2.startReplaceGroup(-334231114);
                        RouteType routeType2 = departure.getRouteType();
                        ?? supplementaryDescription = routeType2 != null ? RouteTypeExtensionsKt.supplementaryDescription(routeType2) : str;
                        String stringResource3 = supplementaryDescription == 0 ? str : StringResources_androidKt.stringResource(supplementaryDescription.intValue(), composer2, i8);
                        composer2.endReplaceGroup();
                        str2 = stringResource3;
                    } else {
                        composer2.startReplaceGroup(-334114864);
                        String travelTimeFormatted = DepartureExtensionsKt.getTravelTimeFormatted(departure, (Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
                        composer2.endReplaceGroup();
                        str2 = travelTimeFormatted;
                    }
                    if (departure.getRouteType() != RouteType.BusOnly) {
                        if (feature.isEnabled()) {
                            Ferry ferry2 = departure.getFerry();
                            if (ferry2 != null) {
                                name = ferry2.timeFormatted();
                                str = name;
                            }
                        } else {
                            Ferry ferry3 = departure.getFerry();
                            if (ferry3 != null) {
                                name = ferry3.getName();
                                str = name;
                            }
                        }
                    }
                    if (str2 != null) {
                        composer2.startReplaceGroup(-333746429);
                        TextKt.m940Text4IGK_g(str2, RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), m3266getGrey30d7_KjU2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer2, 0, 1572864, 65528);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-333520160);
                        SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), composer2, i8);
                        composer2.endReplaceGroup();
                    }
                    composer2.startReplaceGroup(959075694);
                    if (str != null) {
                        Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null);
                        composer2.startReplaceGroup(959080606);
                        int i14 = (i12 & 14) == 4 ? 1 : i8;
                        Object rememberedValue6 = composer2.rememberedValue();
                        if (i14 != 0 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue6 = new Function1() { // from class: N2.f
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit DepartureInfoSection$lambda$16$lambda$15$lambda$14;
                                    DepartureInfoSection$lambda$16$lambda$15$lambda$14 = DepartureInfoSectionViewKt.DepartureInfoSection$lambda$16$lambda$15$lambda$14(Function1.this, (LayoutCoordinates) obj);
                                    return DepartureInfoSection$lambda$16$lambda$15$lambda$14;
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue6);
                        }
                        composer2.endReplaceGroup();
                        TextKt.m940Text4IGK_g(str, OnGloballyPositionedModifierKt.onGloballyPositioned(weight$default2, (Function1) rememberedValue6), m3266getGrey30d7_KjU2, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer2, 0, 1572864, 65016);
                    }
                    composer2.endReplaceGroup();
                    SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), composer2, i8);
                    composer2.endNode();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z9 = z8;
                function17 = function15;
            } else {
                startRestartGroup.skipToGroupEnd();
                function17 = function13;
                z9 = z7;
                function16 = function14;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: N2.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit DepartureInfoSection$lambda$17;
                        DepartureInfoSection$lambda$17 = DepartureInfoSectionViewKt.DepartureInfoSection$lambda$17(Function1.this, function16, departure, z5, z9, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return DepartureInfoSection$lambda$17;
                    }
                });
                return;
            }
            return;
        }
        z7 = z6;
        if ((i7 & 9363) == 9362) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        AppColor appColor4 = AppColor.INSTANCE;
        final long m3266getGrey30d7_KjU3 = !z5 ? appColor4.m3266getGrey30d7_KjU() : appColor4.m3253getBrandBlack10d7_KjU();
        AppColor appColor22 = AppColor.INSTANCE;
        long m3266getGrey30d7_KjU22 = !z5 ? appColor22.m3266getGrey30d7_KjU() : appColor22.m3264getGrey10d7_KjU();
        boolean isHighlightedHarbor3 = isHighlightedHarbor(departure.getRouteId(), true);
        boolean isHighlightedHarbor22 = isHighlightedHarbor(departure.getRouteId(), false);
        final String stringResource4 = StringResources_androidKt.stringResource(R.string.accessibilityLabel_departureLocation, new Object[]{departure.getDepartureHarborName(), departure.getArrivalHarborName()}, startRestartGroup, 6);
        Alignment.Companion companion5 = Alignment.INSTANCE;
        Alignment.Vertical centerVertically2 = companion5.getCenterVertically();
        Modifier.Companion companion22 = Modifier.INSTANCE;
        startRestartGroup.startReplaceGroup(1695034419);
        changed = startRestartGroup.changed(stringResource4);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new Function1() { // from class: N2.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit DepartureInfoSection$lambda$5$lambda$4;
                DepartureInfoSection$lambda$5$lambda$4 = DepartureInfoSectionViewKt.DepartureInfoSection$lambda$5$lambda$4(stringResource4, (SemanticsPropertyReceiver) obj);
                return DepartureInfoSection$lambda$5$lambda$4;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        Modifier clearAndSetSemantics3 = SemanticsModifierKt.clearAndSetSemantics(companion22, (Function1) rememberedValue);
        Arrangement arrangement2 = Arrangement.INSTANCE;
        MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(arrangement2.getStart(), centerVertically2, startRestartGroup, 48);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics3);
        ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor4 = companion32.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        int i122 = i7;
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy4, companion32.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap4, companion32.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion32.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier4, companion32.getSetModifier());
        final RowScope rowScopeInstance2 = RowScopeInstance.INSTANCE;
        AppColor appColor32 = AppColor.INSTANCE;
        HighlightedTextKt.m3387HighlightedTextRuGn9fw(null, isHighlightedHarbor3, appColor32.m3274getTagBlue0d7_KjU(), null, null, ComposableLambdaKt.rememberComposableLambda(-1402632972, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureInfoSectionViewKt$DepartureInfoSection$4$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num2) {
                invoke(composer3, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i132) {
                if ((i132 & 3) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1402632972, i132, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureInfoSection.<anonymous>.<anonymous> (DepartureInfoSectionView.kt:69)");
                }
                Modifier weight$default3 = RowScope.weight$default(RowScope.this, Modifier.INSTANCE, 1.0f, false, 2, null);
                TextKt.m940Text4IGK_g(departure.getDepartureHarborName(), weight$default3, m3266getGrey30d7_KjU3, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2533getStarte0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer3, 0, 1572864, 65016);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, 196992, 25);
        HighlightedTextKt.m3387HighlightedTextRuGn9fw(null, isHighlightedHarbor22, appColor32.m3274getTagBlue0d7_KjU(), null, null, ComposableLambdaKt.rememberComposableLambda(1239834589, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureInfoSectionViewKt$DepartureInfoSection$4$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num2) {
                invoke(composer3, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i132) {
                if ((i132 & 3) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1239834589, i132, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureInfoSection.<anonymous>.<anonymous> (DepartureInfoSectionView.kt:82)");
                }
                Modifier weight$default3 = RowScope.weight$default(RowScope.this, Modifier.INSTANCE, 1.0f, false, 2, null);
                TextKt.m940Text4IGK_g(departure.getArrivalHarborName(), weight$default3, m3266getGrey30d7_KjU3, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2529getEnde0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer3, 0, 1572864, 65016);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, 196992, 25);
        startRestartGroup.endNode();
        final String stringResource22 = StringResources_androidKt.stringResource(R.string.accessibilityLabel_departureTimes, new Object[]{LocalDateTimeExtensionsKt.toFormatTime(departure.getDepartureTime()), LocalDateTimeExtensionsKt.toFormatTime(departure.getArrivalTime())}, startRestartGroup, 6);
        Modifier m327heightInVpY3zN4$default2 = SizeKt.m327heightInVpY3zN4$default(companion22, Dp.m2599constructorimpl(32), 0.0f, 2, null);
        startRestartGroup.startReplaceGroup(1695076087);
        changed2 = startRestartGroup.changed(stringResource22);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue2 = new Function1() { // from class: N2.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit DepartureInfoSection$lambda$8$lambda$7;
                DepartureInfoSection$lambda$8$lambda$7 = DepartureInfoSectionViewKt.DepartureInfoSection$lambda$8$lambda$7(stringResource22, (SemanticsPropertyReceiver) obj);
                return DepartureInfoSection$lambda$8$lambda$7;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceGroup();
        Modifier clearAndSetSemantics22 = SemanticsModifierKt.clearAndSetSemantics(m327heightInVpY3zN4$default2, (Function1) rememberedValue2);
        MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion5.getCenterVertically(), startRestartGroup, 48);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics22);
        Function0<ComposeUiNode> constructor22 = companion32.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy22, companion32.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion32.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion32.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion32.getSetModifier());
        composer2 = startRestartGroup;
        TextKt.m940Text4IGK_g(LocalDateTimeExtensionsKt.toFormatTime(departure.getDepartureTime()), RowScope.weight$default(rowScopeInstance2, companion22, 1.0f, false, 2, null), m3266getGrey30d7_KjU3, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH3Bold(), composer2, 0, 1572864, 65528);
        routeType = departure.getRouteType();
        if (routeType == null) {
        }
        composer2.startReplaceGroup(959013898);
        if (num != null) {
        }
        composer2.endReplaceGroup();
        Modifier weight$default3 = RowScope.weight$default(rowScopeInstance2, companion22, 1.0f, false, 2, null);
        String formatTime2 = LocalDateTimeExtensionsKt.toFormatTime(departure.getArrivalTime());
        TextStyle h3Bold2 = TypographyKt.getH3Bold();
        TextAlign.Companion companion42 = TextAlign.INSTANCE;
        TextKt.m940Text4IGK_g(formatTime2, weight$default3, m3266getGrey30d7_KjU3, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion42.m2529getEnde0LSkKk()), 0L, 0, false, 0, 0, null, h3Bold2, composer2, 0, 1572864, 65016);
        composer2.endNode();
        if (z8) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        z9 = z8;
        function17 = function15;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureInfoSection$lambda$1$lambda$0(LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureInfoSection$lambda$12$lambda$11(Function1 function1, LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
        function1.invoke(layoutCoordinates);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureInfoSection$lambda$16$lambda$15$lambda$14(Function1 function1, LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
        function1.invoke(layoutCoordinates);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureInfoSection$lambda$17(Function1 function1, Function1 function12, IDepartureInfo iDepartureInfo, boolean z5, boolean z6, int i5, int i6, Composer composer, int i7) {
        DepartureInfoSection(function1, function12, iDepartureInfo, z5, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureInfoSection$lambda$3$lambda$2(LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureInfoSection$lambda$5$lambda$4(String str, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureInfoSection$lambda$8$lambda$7(String str, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, str);
        return Unit.INSTANCE;
    }

    private static final boolean isHighlightedHarbor(String str, boolean z5) {
        return (Intrinsics.areEqual(str, "JYL2") && z5) || (Intrinsics.areEqual(str, "SJÆ2") && !z5);
    }
}
