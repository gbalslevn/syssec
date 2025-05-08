package dk.molslinjen.ui.views.screens.booking.departures.calendar;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.kizitonwose.calendar.core.CalendarDay;
import com.kizitonwose.calendar.core.DayPosition;
import dk.molslinjen.core.extensions.AccessibilityKt;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarDayViewKt;
import java.time.format.TextStyle;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\f\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0007¢\u0006\u0004\b\f\u0010\r\u001aC\u0010\u0010\u001a\u00020\n*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/kizitonwose/calendar/core/CalendarDay;", "day", BuildConfig.FLAVOR, "selected", "disabled", "marked", "Ljava/util/Locale;", "locale", "Lkotlin/Function1;", "Lorg/threeten/bp/LocalDate;", BuildConfig.FLAVOR, "onDatePressed", "CalendarDayView", "(Lcom/kizitonwose/calendar/core/CalendarDay;ZZZLjava/util/Locale;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/layout/BoxScope;", "isInCurrentMonth", "DayViewContent", "(Landroidx/compose/foundation/layout/BoxScope;ZLcom/kizitonwose/calendar/core/CalendarDay;ZZLjava/util/Locale;ZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CalendarDayViewKt {
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0129, code lost:
    
        if (r31.getDate().getDayOfMonth() == 1) goto L87;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x019f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CalendarDayView(final CalendarDay day, final boolean z5, final boolean z6, final boolean z7, final Locale locale, final Function1<? super LocalDate, Unit> onDatePressed, Composer composer, final int i5) {
        int i6;
        boolean z8;
        float f5;
        boolean z9;
        Object rememberedValue;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(onDatePressed, "onDatePressed");
        Composer startRestartGroup = composer.startRestartGroup(88593120);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(day) ? 4 : 2) | i5;
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
            i6 |= startRestartGroup.changedInstance(locale) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(onDatePressed) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(88593120, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarDayView (CalendarDayView.kt:49)");
            }
            LocalDate ofEpochDay = LocalDate.ofEpochDay(day.getDate().toEpochDay());
            float pxToDp = ComposeExtensionsKt.pxToDp(1, startRestartGroup, 6);
            boolean z10 = ofEpochDay.getDayOfWeek() == DayOfWeek.MONDAY;
            boolean z11 = ofEpochDay.getDayOfWeek().getValue() >= ofEpochDay.getDayOfMonth();
            DayPosition position = day.getPosition();
            DayPosition dayPosition = DayPosition.MonthDate;
            boolean z12 = position == dayPosition;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            AppColor appColor = AppColor.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(fillMaxSize$default, appColor.m3268getGrey50d7_KjU(), null, 2, null);
            DayPosition position2 = day.getPosition();
            DayPosition dayPosition2 = DayPosition.OutDate;
            float m2599constructorimpl = (position2 != dayPosition2 && (day.getPosition() == DayPosition.InDate || z11)) ? Dp.m2599constructorimpl(0) : pxToDp;
            if (day.getPosition() == dayPosition2) {
                z8 = true;
            } else {
                z8 = true;
            }
            if (day.getPosition() == DayPosition.InDate || day.getPosition() == dayPosition2 || z10) {
                f5 = Dp.m2599constructorimpl(0);
                Modifier m104backgroundbw27NRU$default2 = BackgroundKt.m104backgroundbw27NRU$default(PaddingKt.m315paddingqDBjuR0$default(m104backgroundbw27NRU$default, f5, m2599constructorimpl, 0.0f, 0.0f, 12, null), !z5 ? appColor.m3255getBrandBlue10d7_KjU() : z6 ? appColor.m3269getGrey60d7_KjU() : day.getPosition() != dayPosition ? appColor.m3269getGrey60d7_KjU() : appColor.m3281getWhite0d7_KjU(), null, 2, null);
                boolean z13 = (z6 && z12) ? z8 : false;
                startRestartGroup.startReplaceGroup(-485544344);
                boolean z14 = (i6 & 458752) != 131072 ? z8 : false;
                if ((i6 & 14) != 4) {
                    z8 = false;
                }
                z9 = z14 | z8;
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z9 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: K2.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CalendarDayView$lambda$1$lambda$0;
                            CalendarDayView$lambda$1$lambda$0 = CalendarDayViewKt.CalendarDayView$lambda$1$lambda$0(Function1.this, day);
                            return CalendarDayView$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(m104backgroundbw27NRU$default2, z13, null, null, (Function0) rememberedValue, 6, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                int i7 = i6 << 3;
                int i8 = ((i6 << 6) & 896) | 6 | (i7 & 7168);
                int i9 = i6 << 9;
                DayViewContent(BoxScopeInstance.INSTANCE, z12, day, z6, z5, locale, z7, startRestartGroup, i8 | (57344 & i9) | (i7 & 458752) | (i9 & 3670016));
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            f5 = pxToDp;
            Modifier m104backgroundbw27NRU$default22 = BackgroundKt.m104backgroundbw27NRU$default(PaddingKt.m315paddingqDBjuR0$default(m104backgroundbw27NRU$default, f5, m2599constructorimpl, 0.0f, 0.0f, 12, null), !z5 ? appColor.m3255getBrandBlue10d7_KjU() : z6 ? appColor.m3269getGrey60d7_KjU() : day.getPosition() != dayPosition ? appColor.m3269getGrey60d7_KjU() : appColor.m3281getWhite0d7_KjU(), null, 2, null);
            if (z6) {
            }
            startRestartGroup.startReplaceGroup(-485544344);
            if ((i6 & 458752) != 131072) {
            }
            if ((i6 & 14) != 4) {
            }
            z9 = z14 | z8;
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z9) {
            }
            rememberedValue = new Function0() { // from class: K2.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit CalendarDayView$lambda$1$lambda$0;
                    CalendarDayView$lambda$1$lambda$0 = CalendarDayViewKt.CalendarDayView$lambda$1$lambda$0(Function1.this, day);
                    return CalendarDayView$lambda$1$lambda$0;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            Modifier m122clickableXHw0xAI$default2 = ClickableKt.m122clickableXHw0xAI$default(m104backgroundbw27NRU$default22, z13, null, null, (Function0) rememberedValue, 6, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default2);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion2.getSetModifier());
            int i72 = i6 << 3;
            int i82 = ((i6 << 6) & 896) | 6 | (i72 & 7168);
            int i92 = i6 << 9;
            DayViewContent(BoxScopeInstance.INSTANCE, z12, day, z6, z5, locale, z7, startRestartGroup, i82 | (57344 & i92) | (i72 & 458752) | (i92 & 3670016));
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: K2.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CalendarDayView$lambda$3;
                    CalendarDayView$lambda$3 = CalendarDayViewKt.CalendarDayView$lambda$3(CalendarDay.this, z5, z6, z7, locale, onDatePressed, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CalendarDayView$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CalendarDayView$lambda$1$lambda$0(Function1 function1, CalendarDay calendarDay) {
        LocalDate ofEpochDay = LocalDate.ofEpochDay(calendarDay.getDate().toEpochDay());
        Intrinsics.checkNotNullExpressionValue(ofEpochDay, "ofEpochDay(...)");
        function1.invoke(ofEpochDay);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CalendarDayView$lambda$3(CalendarDay calendarDay, boolean z5, boolean z6, boolean z7, Locale locale, Function1 function1, int i5, Composer composer, int i6) {
        CalendarDayView(calendarDay, z5, z6, z7, locale, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void DayViewContent(final BoxScope boxScope, final boolean z5, final CalendarDay calendarDay, final boolean z6, final boolean z7, final Locale locale, final boolean z8, Composer composer, final int i5) {
        int i6;
        String take;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(3811765);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(boxScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(calendarDay) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(z7) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(locale) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changed(z8) ? 1048576 : 524288;
        }
        if ((599187 & i6) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(3811765, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.calendar.DayViewContent (CalendarDayView.kt:104)");
            }
            boolean isEqual = java.time.LocalDate.now().isEqual(calendarDay.getDate());
            String accessibilityReadableDate = AccessibilityKt.toAccessibilityReadableDate(calendarDay.getDate(), locale);
            startRestartGroup.startReplaceGroup(2091595220);
            String stringResource = isEqual ? StringResources_androidKt.stringResource(R.string.calendar_today, startRestartGroup, 6) : BuildConfig.FLAVOR;
            startRestartGroup.endReplaceGroup();
            final String str = accessibilityReadableDate + " " + stringResource;
            Modifier.Companion companion = Modifier.INSTANCE;
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Modifier alpha = AlphaKt.alpha(boxScope.align(companion, companion2.getCenter()), z5 ? 1.0f : 0.0f);
            startRestartGroup.startReplaceGroup(2091606307);
            boolean changed = startRestartGroup.changed(str);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: K2.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DayViewContent$lambda$5$lambda$4;
                        DayViewContent$lambda$5$lambda$4 = CalendarDayViewKt.DayViewContent$lambda$5$lambda$4(str, (SemanticsPropertyReceiver) obj);
                        return DayViewContent$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(alpha, (Function1) rememberedValue);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getCenterHorizontally(), startRestartGroup, 48);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            float f5 = 28;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            TextKt.m940Text4IGK_g(String.valueOf(calendarDay.getDate().getDayOfMonth()), null, z6 ? AppColor.INSTANCE.m3266getGrey30d7_KjU() : z7 ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : AppColor.INSTANCE.m3253getBrandBlack10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH2Bold(), startRestartGroup, 0, 1572864, 65530);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(4)), startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(1621635989);
            if (isEqual) {
                take = StringResources_androidKt.stringResource(R.string.calendar_today, startRestartGroup, 6);
            } else {
                String displayName = calendarDay.getDate().getMonth().getDisplayName(TextStyle.FULL, locale);
                Intrinsics.checkNotNullExpressionValue(displayName, "getDisplayName(...)");
                take = StringsKt.take(StringExtensionsKt.uppercaseFirstLetter(displayName), 3);
            }
            startRestartGroup.endReplaceGroup();
            androidx.compose.ui.text.TextStyle subSmall = TypographyKt.getSubSmall();
            long m3281getWhite0d7_KjU = z7 ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : isEqual ? AppColor.INSTANCE.m3255getBrandBlue10d7_KjU() : z6 ? AppColor.INSTANCE.m3266getGrey30d7_KjU() : AppColor.INSTANCE.m3264getGrey10d7_KjU();
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(take, null, m3281getWhite0d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, subSmall, composer2, 0, 1572864, 65530);
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer2, 6);
            composer2.startReplaceGroup(-1472609492);
            if (z8 && !z6) {
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(boxScopeInstance.align(companion, companion2.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(8), 7, null);
                float m2599constructorimpl = Dp.m2599constructorimpl(1);
                AppColor appColor = AppColor.INSTANCE;
                BoxKt.Box(BackgroundKt.m103backgroundbw27NRU(SizeKt.m331size3ABfNKs(BorderKt.m108borderxT4_qwU(m315paddingqDBjuR0$default, m2599constructorimpl, appColor.m3265getGrey20d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(12)), appColor.m3279getTagYellow0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), composer2, 0);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: K2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DayViewContent$lambda$8;
                    DayViewContent$lambda$8 = CalendarDayViewKt.DayViewContent$lambda$8(BoxScope.this, z5, calendarDay, z6, z7, locale, z8, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DayViewContent$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DayViewContent$lambda$5$lambda$4(String str, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DayViewContent$lambda$8(BoxScope boxScope, boolean z5, CalendarDay calendarDay, boolean z6, boolean z7, Locale locale, boolean z8, int i5, Composer composer, int i6) {
        DayViewContent(boxScope, z5, calendarDay, z6, z7, locale, z8, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
