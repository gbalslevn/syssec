package dk.molslinjen.ui.views.screens.booking.departures.calendar;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.extensions.YearMonthExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarMonthPickerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.YearMonth;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a7\u0010\b\u001a\u00020\u00012\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"CalendarMonthPicker", BuildConfig.FLAVOR, "monthToShow", "Lorg/threeten/bp/YearMonth;", "minMonth", "onMonthChange", "Lkotlin/Function1;", "(Lorg/threeten/bp/YearMonth;Lorg/threeten/bp/YearMonth;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "MonthPickerButton", "icon", BuildConfig.FLAVOR, "enabled", BuildConfig.FLAVOR, "contentDescription", BuildConfig.FLAVOR, "Lkotlin/Function0;", "(IZLjava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CalendarMonthPickerKt {
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008b, code lost:
    
        if ((r39 & 2) != 0) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CalendarMonthPicker(final YearMonth monthToShow, YearMonth yearMonth, final Function1<? super YearMonth, Unit> onMonthChange, Composer composer, final int i5, final int i6) {
        int i7;
        YearMonth yearMonth2;
        YearMonth yearMonth3;
        int i8;
        Intrinsics.checkNotNullParameter(monthToShow, "monthToShow");
        Intrinsics.checkNotNullParameter(onMonthChange, "onMonthChange");
        Composer startRestartGroup = composer.startRestartGroup(-1781275168);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(monthToShow) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            if ((i6 & 2) == 0) {
                yearMonth2 = yearMonth;
                if (startRestartGroup.changedInstance(yearMonth2)) {
                    i8 = 32;
                    i7 |= i8;
                }
            } else {
                yearMonth2 = yearMonth;
            }
            i8 = 16;
            i7 |= i8;
        } else {
            yearMonth2 = yearMonth;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(onMonthChange) ? 256 : 128;
        }
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            yearMonth3 = yearMonth2;
        } else {
            startRestartGroup.startDefaults();
            if ((i5 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i6 & 2) != 0) {
                    yearMonth2 = YearMonth.now();
                    i7 &= -113;
                }
                YearMonth yearMonth4 = yearMonth2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1781275168, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarMonthPicker (CalendarMonthPicker.kt:30)");
                }
                String fullMonthWithYear = YearMonthExtensionsKt.toFullMonthWithYear(monthToShow);
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(28), 0.0f, 2, null);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
                String stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_previousMonth, startRestartGroup, 6);
                boolean z5 = monthToShow.minusMonths(1L).compareTo(yearMonth4) >= 0;
                startRestartGroup.startReplaceGroup(2001178709);
                int i9 = i7 & 896;
                boolean changedInstance = (i9 == 256) | startRestartGroup.changedInstance(monthToShow);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: K2.e
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CalendarMonthPicker$lambda$4$lambda$1$lambda$0;
                            CalendarMonthPicker$lambda$4$lambda$1$lambda$0 = CalendarMonthPickerKt.CalendarMonthPicker$lambda$4$lambda$1$lambda$0(Function1.this, monthToShow);
                            return CalendarMonthPicker$lambda$4$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                MonthPickerButton(R.drawable.icon_chevron_back, z5, stringResource, (Function0) rememberedValue, startRestartGroup, 6, 0);
                yearMonth3 = yearMonth4;
                TextKt.m940Text4IGK_g(fullMonthWithYear, RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 0, 1572864, 65020);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.accessibilityLabel_nextMonth, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(2001192116);
                boolean changedInstance2 = startRestartGroup.changedInstance(monthToShow) | (i9 == 256);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: K2.f
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CalendarMonthPicker$lambda$4$lambda$3$lambda$2;
                            CalendarMonthPicker$lambda$4$lambda$3$lambda$2 = CalendarMonthPickerKt.CalendarMonthPicker$lambda$4$lambda$3$lambda$2(Function1.this, monthToShow);
                            return CalendarMonthPicker$lambda$4$lambda$3$lambda$2;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                MonthPickerButton(R.drawable.icon_chevron_right, false, stringResource2, (Function0) rememberedValue2, startRestartGroup, 6, 2);
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final YearMonth yearMonth5 = yearMonth3;
            endRestartGroup.updateScope(new Function2() { // from class: K2.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CalendarMonthPicker$lambda$5;
                    CalendarMonthPicker$lambda$5 = CalendarMonthPickerKt.CalendarMonthPicker$lambda$5(YearMonth.this, yearMonth5, onMonthChange, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return CalendarMonthPicker$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CalendarMonthPicker$lambda$4$lambda$1$lambda$0(Function1 function1, YearMonth yearMonth) {
        YearMonth minusMonths = yearMonth.minusMonths(1L);
        Intrinsics.checkNotNullExpressionValue(minusMonths, "minusMonths(...)");
        function1.invoke(minusMonths);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CalendarMonthPicker$lambda$4$lambda$3$lambda$2(Function1 function1, YearMonth yearMonth) {
        YearMonth plusMonths = yearMonth.plusMonths(1L);
        Intrinsics.checkNotNullExpressionValue(plusMonths, "plusMonths(...)");
        function1.invoke(plusMonths);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CalendarMonthPicker$lambda$5(YearMonth yearMonth, YearMonth yearMonth2, Function1 function1, int i5, int i6, Composer composer, int i7) {
        CalendarMonthPicker(yearMonth, yearMonth2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void MonthPickerButton(final int i5, boolean z5, final String str, final Function0<Unit> function0, Composer composer, final int i6, final int i7) {
        int i8;
        boolean z6;
        boolean z7;
        Object rememberedValue;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1743452877);
        if ((i7 & 1) != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i8 = (startRestartGroup.changed(i5) ? 4 : 2) | i6;
        } else {
            i8 = i6;
        }
        int i9 = i7 & 2;
        if (i9 != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            z6 = z5;
            i8 |= startRestartGroup.changed(z6) ? 32 : 16;
            if ((i7 & 4) == 0) {
                i8 |= 384;
            } else if ((i6 & 384) == 0) {
                i8 |= startRestartGroup.changed(str) ? 256 : 128;
            }
            if ((i7 & 8) == 0) {
                i8 |= 3072;
            } else if ((i6 & 3072) == 0) {
                i8 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
            }
            if ((i8 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                z7 = i9 == 0 ? true : z6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1743452877, i8, -1, "dk.molslinjen.ui.views.screens.booking.departures.calendar.MonthPickerButton (CalendarMonthPicker.kt:68)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                startRestartGroup.startReplaceGroup(542515039);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: K2.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Modifier MonthPickerButton$lambda$7$lambda$6;
                            MonthPickerButton$lambda$7$lambda$6 = CalendarMonthPickerKt.MonthPickerButton$lambda$7$lambda$6((Modifier) obj);
                            return MonthPickerButton$lambda$7$lambda$6;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier applyIf = ModifierExtensionsKt.applyIf(companion, z7, (Function1) rememberedValue);
                AppColor appColor = AppColor.INSTANCE;
                Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(ClipKt.clip(SizeKt.m331size3ABfNKs(BackgroundKt.m103backgroundbw27NRU(applyIf, !z7 ? appColor.m3281getWhite0d7_KjU() : appColor.m3269getGrey60d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(40)), RoundedCornerShapeKt.getCircleShape()), z7, null, null, function0, 6, null);
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default);
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
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                Modifier align = BoxScopeInstance.INSTANCE.align(SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(16)), companion2.getCenter());
                Painter painterResource = PainterResources_androidKt.painterResource(i5, startRestartGroup, i8 & 14);
                AppColor appColor2 = AppColor.INSTANCE;
                IconKt.m857Iconww6aTOc(painterResource, str, align, !z7 ? appColor2.m3253getBrandBlack10d7_KjU() : appColor2.m3267getGrey40d7_KjU(), startRestartGroup, (i8 >> 3) & 112, 0);
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                z7 = z6;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final boolean z8 = z7;
                endRestartGroup.updateScope(new Function2() { // from class: K2.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit MonthPickerButton$lambda$9;
                        MonthPickerButton$lambda$9 = CalendarMonthPickerKt.MonthPickerButton$lambda$9(i5, z8, str, function0, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                        return MonthPickerButton$lambda$9;
                    }
                });
                return;
            }
            return;
        }
        z6 = z5;
        if ((i7 & 4) == 0) {
        }
        if ((i7 & 8) == 0) {
        }
        if ((i8 & 1171) == 1170) {
        }
        if (i9 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier.Companion companion4 = Modifier.INSTANCE;
        startRestartGroup.startReplaceGroup(542515039);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier applyIf2 = ModifierExtensionsKt.applyIf(companion4, z7, (Function1) rememberedValue);
        AppColor appColor3 = AppColor.INSTANCE;
        Modifier m122clickableXHw0xAI$default2 = ClickableKt.m122clickableXHw0xAI$default(ClipKt.clip(SizeKt.m331size3ABfNKs(BackgroundKt.m103backgroundbw27NRU(applyIf2, !z7 ? appColor3.m3281getWhite0d7_KjU() : appColor3.m3269getGrey60d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(40)), RoundedCornerShapeKt.getCircleShape()), z7, null, null, function0, 6, null);
        Alignment.Companion companion22 = Alignment.INSTANCE;
        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion22.getTopStart(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default2);
        ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion32.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2, companion32.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion32.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion32.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion32.getSetModifier());
        Modifier align2 = BoxScopeInstance.INSTANCE.align(SizeKt.m331size3ABfNKs(companion4, Dp.m2599constructorimpl(16)), companion22.getCenter());
        Painter painterResource2 = PainterResources_androidKt.painterResource(i5, startRestartGroup, i8 & 14);
        AppColor appColor22 = AppColor.INSTANCE;
        IconKt.m857Iconww6aTOc(painterResource2, str, align2, !z7 ? appColor22.m3253getBrandBlack10d7_KjU() : appColor22.m3267getGrey40d7_KjU(), startRestartGroup, (i8 >> 3) & 112, 0);
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier MonthPickerButton$lambda$7$lambda$6(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ModifierExtensionsKt.defaultShadow(applyIf, RoundedCornerShapeKt.getCircleShape());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MonthPickerButton$lambda$9(int i5, boolean z5, String str, Function0 function0, int i6, int i7, Composer composer, int i8) {
        MonthPickerButton(i5, z5, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }
}
