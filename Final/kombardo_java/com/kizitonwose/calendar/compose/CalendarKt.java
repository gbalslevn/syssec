package com.kizitonwose.calendar.compose;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.kizitonwose.calendar.compose.CalendarKt;
import com.kizitonwose.calendar.compose.CalendarState;
import com.kizitonwose.calendar.core.CalendarDay;
import com.kizitonwose.calendar.core.CalendarMonth;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aÿ\u0001\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f2\u001c\b\u0002\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f2(\b\u0002\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0015\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142\u001c\b\u0002\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f2(\b\u0002\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0015\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0014H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001añ\u0001\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f2&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0015\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f2&\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0015\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0014H\u0003¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcom/kizitonwose/calendar/compose/CalendarState;", "state", BuildConfig.FLAVOR, "calendarScrollPaged", "userScrollEnabled", "reverseLayout", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", "Lcom/kizitonwose/calendar/compose/ContentHeightMode;", "contentHeightMode", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/BoxScope;", "Lcom/kizitonwose/calendar/core/CalendarDay;", BuildConfig.FLAVOR, "dayContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lcom/kizitonwose/calendar/core/CalendarMonth;", "monthHeader", "Lkotlin/Function3;", "Lkotlin/Function0;", "monthBody", "monthFooter", "Landroidx/compose/foundation/lazy/LazyItemScope;", "monthContainer", "HorizontalCalendar", "(Landroidx/compose/ui/Modifier;Lcom/kizitonwose/calendar/compose/CalendarState;ZZZLandroidx/compose/foundation/layout/PaddingValues;Lcom/kizitonwose/calendar/compose/ContentHeightMode;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function5;Landroidx/compose/runtime/Composer;III)V", "isHorizontal", "Calendar", "(Landroidx/compose/ui/Modifier;Lcom/kizitonwose/calendar/compose/CalendarState;ZZZZLandroidx/compose/foundation/layout/PaddingValues;Lcom/kizitonwose/calendar/compose/ContentHeightMode;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function5;Landroidx/compose/runtime/Composer;II)V", "compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CalendarKt {
    private static final void Calendar(final Modifier modifier, final CalendarState calendarState, final boolean z5, final boolean z6, final boolean z7, final boolean z8, final PaddingValues paddingValues, final ContentHeightMode contentHeightMode, final Function4<? super BoxScope, ? super CalendarDay, ? super Composer, ? super Integer, Unit> function4, final Function4<? super ColumnScope, ? super CalendarMonth, ? super Composer, ? super Integer, Unit> function42, final Function5<? super ColumnScope, ? super CalendarMonth, ? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function5, final Function4<? super ColumnScope, ? super CalendarMonth, ? super Composer, ? super Integer, Unit> function43, final Function5<? super LazyItemScope, ? super CalendarMonth, ? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function52, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1694050184);
        if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(calendarState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changed(z7) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i7 |= startRestartGroup.changed(z8) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i7 |= startRestartGroup.changed(paddingValues) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i7 |= startRestartGroup.changed(contentHeightMode) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i7 |= startRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i7 |= startRestartGroup.changedInstance(function42) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i8 = i6 | (startRestartGroup.changedInstance(function5) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(function43) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changedInstance(function52) ? 256 : 128;
        }
        int i9 = i8;
        if ((i7 & 306783379) == 306783378 && (i9 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1694050184, i7, i9, "com.kizitonwose.calendar.compose.Calendar (Calendar.kt:177)");
            }
            if (z7) {
                startRestartGroup.startReplaceGroup(424352655);
                LazyListState listState = calendarState.getListState();
                int i10 = i7 >> 6;
                FlingBehavior flingBehavior = CalendarDefaults.INSTANCE.flingBehavior(z5, calendarState.getListState(), startRestartGroup, (i10 & 14) | 384);
                startRestartGroup.startReplaceGroup(-263395986);
                boolean z9 = ((i7 & 112) == 32) | ((i7 & 29360128) == 8388608) | ((234881024 & i7) == 67108864) | ((1879048192 & i7) == 536870912) | ((i9 & 14) == 4) | ((i9 & 112) == 32) | ((i9 & 896) == 256);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z9 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: c1.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit Calendar$lambda$3$lambda$2;
                            Calendar$lambda$3$lambda$2 = CalendarKt.Calendar$lambda$3$lambda$2(CalendarState.this, contentHeightMode, function4, function42, function5, function43, function52, (LazyListScope) obj);
                            return Calendar$lambda$3$lambda$2;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                LazyDslKt.LazyRow(modifier, listState, paddingValues, z8, null, null, flingBehavior, z6, (Function1) rememberedValue, startRestartGroup, (i7 & 14) | ((i7 >> 12) & 896) | (i10 & 7168) | ((i7 << 12) & 29360128), 48);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(425172140);
                LazyListState listState2 = calendarState.getListState();
                int i11 = i7 >> 6;
                FlingBehavior flingBehavior2 = CalendarDefaults.INSTANCE.flingBehavior(z5, calendarState.getListState(), startRestartGroup, (i11 & 14) | 384);
                startRestartGroup.startReplaceGroup(-263369458);
                boolean z10 = ((i7 & 112) == 32) | ((i7 & 29360128) == 8388608) | ((234881024 & i7) == 67108864) | ((1879048192 & i7) == 536870912) | ((i9 & 14) == 4) | ((i9 & 112) == 32) | ((i9 & 896) == 256);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z10 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: c1.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit Calendar$lambda$5$lambda$4;
                            Calendar$lambda$5$lambda$4 = CalendarKt.Calendar$lambda$5$lambda$4(CalendarState.this, contentHeightMode, function4, function42, function5, function43, function52, (LazyListScope) obj);
                            return Calendar$lambda$5$lambda$4;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                LazyDslKt.LazyColumn(modifier, listState2, paddingValues, z8, null, null, flingBehavior2, z6, (Function1) rememberedValue2, startRestartGroup, (i7 & 14) | ((i7 >> 12) & 896) | (i11 & 7168) | ((i7 << 12) & 29360128), 48);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: c1.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Calendar$lambda$6;
                    Calendar$lambda$6 = CalendarKt.Calendar$lambda$6(Modifier.this, calendarState, z5, z6, z7, z8, paddingValues, contentHeightMode, function4, function42, function5, function43, function52, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return Calendar$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Calendar$lambda$3$lambda$2(CalendarState calendarState, ContentHeightMode contentHeightMode, Function4 function4, Function4 function42, Function5 function5, Function4 function43, Function5 function52, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        CalendarMonthsKt.CalendarMonths(LazyRow, calendarState.getCalendarInfo$compose_release().getIndexCount(), new CalendarKt$Calendar$1$1$1(calendarState.getStore$compose_release()), contentHeightMode, function4, function42, function5, function43, function52, new CalendarKt$Calendar$1$1$2(calendarState.getPlacementInfo()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Calendar$lambda$5$lambda$4(CalendarState calendarState, ContentHeightMode contentHeightMode, Function4 function4, Function4 function42, Function5 function5, Function4 function43, Function5 function52, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        CalendarMonthsKt.CalendarMonths(LazyColumn, calendarState.getCalendarInfo$compose_release().getIndexCount(), new CalendarKt$Calendar$2$1$1(calendarState.getStore$compose_release()), contentHeightMode, function4, function42, function5, function43, function52, new CalendarKt$Calendar$2$1$2(calendarState.getPlacementInfo()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Calendar$lambda$6(Modifier modifier, CalendarState calendarState, boolean z5, boolean z6, boolean z7, boolean z8, PaddingValues paddingValues, ContentHeightMode contentHeightMode, Function4 function4, Function4 function42, Function5 function5, Function4 function43, Function5 function52, int i5, int i6, Composer composer, int i7) {
        Calendar(modifier, calendarState, z5, z6, z7, z8, paddingValues, contentHeightMode, function4, function42, function5, function43, function52, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x025d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void HorizontalCalendar(Modifier modifier, CalendarState calendarState, boolean z5, boolean z6, boolean z7, PaddingValues paddingValues, ContentHeightMode contentHeightMode, final Function4<? super BoxScope, ? super CalendarDay, ? super Composer, ? super Integer, Unit> dayContent, Function4<? super ColumnScope, ? super CalendarMonth, ? super Composer, ? super Integer, Unit> function4, Function5<? super ColumnScope, ? super CalendarMonth, ? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function5, Function4<? super ColumnScope, ? super CalendarMonth, ? super Composer, ? super Integer, Unit> function42, Function5<? super LazyItemScope, ? super CalendarMonth, ? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function52, Composer composer, final int i5, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        CalendarState calendarState2;
        boolean z8;
        int i9;
        int i10;
        boolean z9;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        Modifier modifier3;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        CalendarState calendarState3;
        Modifier modifier4;
        Function5<? super LazyItemScope, ? super CalendarMonth, ? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function53;
        CalendarState calendarState4;
        boolean z10;
        boolean z11;
        PaddingValues paddingValues2;
        ContentHeightMode contentHeightMode2;
        Function5<? super ColumnScope, ? super CalendarMonth, ? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function54;
        Function4<? super ColumnScope, ? super CalendarMonth, ? super Composer, ? super Integer, Unit> function43;
        boolean z12;
        int i26;
        Function4<? super ColumnScope, ? super CalendarMonth, ? super Composer, ? super Integer, Unit> function44;
        Composer composer2;
        final Modifier modifier5;
        final CalendarState calendarState5;
        final boolean z13;
        final boolean z14;
        final boolean z15;
        final PaddingValues paddingValues3;
        final ContentHeightMode contentHeightMode3;
        final Function4<? super ColumnScope, ? super CalendarMonth, ? super Composer, ? super Integer, Unit> function45;
        final Function5<? super ColumnScope, ? super CalendarMonth, ? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function55;
        final Function4<? super ColumnScope, ? super CalendarMonth, ? super Composer, ? super Integer, Unit> function46;
        final Function5<? super LazyItemScope, ? super CalendarMonth, ? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function56;
        ScopeUpdateScope endRestartGroup;
        int i27;
        Intrinsics.checkNotNullParameter(dayContent, "dayContent");
        Composer startRestartGroup = composer.startRestartGroup(-70790120);
        int i28 = i7 & 1;
        if (i28 != 0) {
            i8 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i8 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i8 = i5;
        }
        if ((i5 & 48) == 0) {
            if ((i7 & 2) == 0) {
                calendarState2 = calendarState;
                if (startRestartGroup.changed(calendarState2)) {
                    i27 = 32;
                    i8 |= i27;
                }
            } else {
                calendarState2 = calendarState;
            }
            i27 = 16;
            i8 |= i27;
        } else {
            calendarState2 = calendarState;
        }
        int i29 = i7 & 4;
        if (i29 != 0) {
            i8 |= 384;
        } else if ((i5 & 384) == 0) {
            z8 = z5;
            i8 |= startRestartGroup.changed(z8) ? 256 : 128;
            i9 = i7 & 8;
            if (i9 == 0) {
                i8 |= 3072;
            } else if ((i5 & 3072) == 0) {
                i8 |= startRestartGroup.changed(z6) ? 2048 : 1024;
                i10 = i7 & 16;
                if (i10 != 0) {
                    i8 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    z9 = z7;
                    i8 |= startRestartGroup.changed(z9) ? 16384 : 8192;
                    i11 = i7 & 32;
                    if (i11 == 0) {
                        i8 |= 196608;
                    } else if ((i5 & 196608) == 0) {
                        i8 |= startRestartGroup.changed(paddingValues) ? 131072 : 65536;
                    }
                    i12 = i7 & 64;
                    if (i12 == 0) {
                        i8 |= 1572864;
                    } else if ((i5 & 1572864) == 0) {
                        i8 |= startRestartGroup.changed(contentHeightMode) ? 1048576 : 524288;
                    }
                    if ((i7 & 128) == 0) {
                        i8 |= 12582912;
                    } else if ((i5 & 12582912) == 0) {
                        i8 |= startRestartGroup.changedInstance(dayContent) ? 8388608 : 4194304;
                    }
                    i13 = i7 & 256;
                    if (i13 == 0) {
                        i8 |= 100663296;
                    } else if ((i5 & 100663296) == 0) {
                        i8 |= startRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
                    }
                    i14 = i7 & 512;
                    if (i14 == 0) {
                        i16 = i8 | 805306368;
                        i15 = i14;
                    } else {
                        if ((i5 & 805306368) == 0) {
                            i15 = i14;
                            i8 |= startRestartGroup.changedInstance(function5) ? 536870912 : 268435456;
                        } else {
                            i15 = i14;
                        }
                        i16 = i8;
                    }
                    i17 = i7 & 1024;
                    if (i17 == 0) {
                        i18 = i6 | 6;
                    } else if ((i6 & 6) == 0) {
                        i18 = i6 | (startRestartGroup.changedInstance(function42) ? 4 : 2);
                    } else {
                        i18 = i6;
                    }
                    i19 = i7 & 2048;
                    if (i19 == 0) {
                        i18 |= 48;
                        i20 = i19;
                    } else if ((i6 & 48) == 0) {
                        i20 = i19;
                        i18 |= startRestartGroup.changedInstance(function52) ? 32 : 16;
                    } else {
                        i20 = i19;
                    }
                    int i30 = i18;
                    if ((i16 & 306783379) != 306783378 && (i30 & 19) == 18 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        contentHeightMode3 = contentHeightMode;
                        function45 = function4;
                        function46 = function42;
                        z15 = z9;
                        modifier5 = modifier2;
                        calendarState5 = calendarState2;
                        z13 = z8;
                        composer2 = startRestartGroup;
                        z14 = z6;
                        paddingValues3 = paddingValues;
                        function55 = function5;
                        function56 = function52;
                    } else {
                        startRestartGroup.startDefaults();
                        if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier6 = i28 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i7 & 2) == 0) {
                                i21 = i17;
                                i22 = i13;
                                modifier3 = modifier6;
                                i23 = i30;
                                i24 = i15;
                                i25 = i20;
                                calendarState3 = CalendarStateKt.rememberCalendarState(null, null, null, null, null, startRestartGroup, 0, 31);
                                i16 &= -113;
                            } else {
                                modifier3 = modifier6;
                                i21 = i17;
                                i22 = i13;
                                i23 = i30;
                                i24 = i15;
                                i25 = i20;
                                calendarState3 = calendarState2;
                            }
                            if (i29 != 0) {
                                z8 = true;
                            }
                            boolean z16 = i9 == 0 ? z6 : true;
                            boolean z17 = i10 == 0 ? false : z7;
                            PaddingValues m306PaddingValues0680j_4 = i11 == 0 ? PaddingKt.m306PaddingValues0680j_4(Dp.m2599constructorimpl(0)) : paddingValues;
                            ContentHeightMode contentHeightMode4 = i12 == 0 ? ContentHeightMode.Wrap : contentHeightMode;
                            Function4<? super ColumnScope, ? super CalendarMonth, ? super Composer, ? super Integer, Unit> function47 = i22 == 0 ? null : function4;
                            Function5<? super ColumnScope, ? super CalendarMonth, ? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function57 = i24 == 0 ? null : function5;
                            Function4<? super ColumnScope, ? super CalendarMonth, ? super Composer, ? super Integer, Unit> function48 = i21 == 0 ? null : function42;
                            modifier4 = modifier3;
                            if (i25 == 0) {
                                calendarState4 = calendarState3;
                                z10 = z16;
                                z11 = z17;
                                paddingValues2 = m306PaddingValues0680j_4;
                                contentHeightMode2 = contentHeightMode4;
                                function53 = null;
                            } else {
                                function53 = function52;
                                calendarState4 = calendarState3;
                                z10 = z16;
                                z11 = z17;
                                paddingValues2 = m306PaddingValues0680j_4;
                                contentHeightMode2 = contentHeightMode4;
                            }
                            function54 = function57;
                            function43 = function48;
                            z12 = z8;
                            i26 = i16;
                            function44 = function47;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i7 & 2) != 0) {
                                i16 &= -113;
                            }
                            z10 = z6;
                            paddingValues2 = paddingValues;
                            contentHeightMode2 = contentHeightMode;
                            function54 = function5;
                            function43 = function42;
                            function53 = function52;
                            z11 = z9;
                            modifier4 = modifier2;
                            calendarState4 = calendarState2;
                            i23 = i30;
                            z12 = z8;
                            i26 = i16;
                            function44 = function4;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-70790120, i26, i23, "com.kizitonwose.calendar.compose.HorizontalCalendar (Calendar.kt:83)");
                        }
                        int i31 = i26 << 3;
                        int i32 = i23 << 3;
                        composer2 = startRestartGroup;
                        Calendar(modifier4, calendarState4, z12, z10, true, z11, paddingValues2, contentHeightMode2, dayContent, function44, function54, function43, function53, composer2, (i26 & 14) | 24576 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (458752 & i31) | (3670016 & i31) | (29360128 & i31) | (234881024 & i31) | (i31 & 1879048192), ((i26 >> 27) & 14) | (i32 & 112) | (i32 & 896));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        calendarState5 = calendarState4;
                        z13 = z12;
                        z14 = z10;
                        z15 = z11;
                        paddingValues3 = paddingValues2;
                        contentHeightMode3 = contentHeightMode2;
                        function45 = function44;
                        function55 = function54;
                        function46 = function43;
                        function56 = function53;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: c1.a
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit HorizontalCalendar$lambda$0;
                                HorizontalCalendar$lambda$0 = CalendarKt.HorizontalCalendar$lambda$0(Modifier.this, calendarState5, z13, z14, z15, paddingValues3, contentHeightMode3, dayContent, function45, function55, function46, function56, i5, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                return HorizontalCalendar$lambda$0;
                            }
                        });
                        return;
                    }
                    return;
                }
                z9 = z7;
                i11 = i7 & 32;
                if (i11 == 0) {
                }
                i12 = i7 & 64;
                if (i12 == 0) {
                }
                if ((i7 & 128) == 0) {
                }
                i13 = i7 & 256;
                if (i13 == 0) {
                }
                i14 = i7 & 512;
                if (i14 == 0) {
                }
                i17 = i7 & 1024;
                if (i17 == 0) {
                }
                i19 = i7 & 2048;
                if (i19 == 0) {
                }
                int i302 = i18;
                if ((i16 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i28 == 0) {
                }
                if ((i7 & 2) == 0) {
                }
                if (i29 != 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i12 == 0) {
                }
                if (i22 == 0) {
                }
                if (i24 == 0) {
                }
                if (i21 == 0) {
                }
                modifier4 = modifier3;
                if (i25 == 0) {
                }
                function54 = function57;
                function43 = function48;
                z12 = z8;
                i26 = i16;
                function44 = function47;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i312 = i26 << 3;
                int i322 = i23 << 3;
                composer2 = startRestartGroup;
                Calendar(modifier4, calendarState4, z12, z10, true, z11, paddingValues2, contentHeightMode2, dayContent, function44, function54, function43, function53, composer2, (i26 & 14) | 24576 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (458752 & i312) | (3670016 & i312) | (29360128 & i312) | (234881024 & i312) | (i312 & 1879048192), ((i26 >> 27) & 14) | (i322 & 112) | (i322 & 896));
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier5 = modifier4;
                calendarState5 = calendarState4;
                z13 = z12;
                z14 = z10;
                z15 = z11;
                paddingValues3 = paddingValues2;
                contentHeightMode3 = contentHeightMode2;
                function45 = function44;
                function55 = function54;
                function46 = function43;
                function56 = function53;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i10 = i7 & 16;
            if (i10 != 0) {
            }
            z9 = z7;
            i11 = i7 & 32;
            if (i11 == 0) {
            }
            i12 = i7 & 64;
            if (i12 == 0) {
            }
            if ((i7 & 128) == 0) {
            }
            i13 = i7 & 256;
            if (i13 == 0) {
            }
            i14 = i7 & 512;
            if (i14 == 0) {
            }
            i17 = i7 & 1024;
            if (i17 == 0) {
            }
            i19 = i7 & 2048;
            if (i19 == 0) {
            }
            int i3022 = i18;
            if ((i16 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i28 == 0) {
            }
            if ((i7 & 2) == 0) {
            }
            if (i29 != 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (i12 == 0) {
            }
            if (i22 == 0) {
            }
            if (i24 == 0) {
            }
            if (i21 == 0) {
            }
            modifier4 = modifier3;
            if (i25 == 0) {
            }
            function54 = function57;
            function43 = function48;
            z12 = z8;
            i26 = i16;
            function44 = function47;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i3122 = i26 << 3;
            int i3222 = i23 << 3;
            composer2 = startRestartGroup;
            Calendar(modifier4, calendarState4, z12, z10, true, z11, paddingValues2, contentHeightMode2, dayContent, function44, function54, function43, function53, composer2, (i26 & 14) | 24576 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (458752 & i3122) | (3670016 & i3122) | (29360128 & i3122) | (234881024 & i3122) | (i3122 & 1879048192), ((i26 >> 27) & 14) | (i3222 & 112) | (i3222 & 896));
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier5 = modifier4;
            calendarState5 = calendarState4;
            z13 = z12;
            z14 = z10;
            z15 = z11;
            paddingValues3 = paddingValues2;
            contentHeightMode3 = contentHeightMode2;
            function45 = function44;
            function55 = function54;
            function46 = function43;
            function56 = function53;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        z8 = z5;
        i9 = i7 & 8;
        if (i9 == 0) {
        }
        i10 = i7 & 16;
        if (i10 != 0) {
        }
        z9 = z7;
        i11 = i7 & 32;
        if (i11 == 0) {
        }
        i12 = i7 & 64;
        if (i12 == 0) {
        }
        if ((i7 & 128) == 0) {
        }
        i13 = i7 & 256;
        if (i13 == 0) {
        }
        i14 = i7 & 512;
        if (i14 == 0) {
        }
        i17 = i7 & 1024;
        if (i17 == 0) {
        }
        i19 = i7 & 2048;
        if (i19 == 0) {
        }
        int i30222 = i18;
        if ((i16 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i28 == 0) {
        }
        if ((i7 & 2) == 0) {
        }
        if (i29 != 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (i12 == 0) {
        }
        if (i22 == 0) {
        }
        if (i24 == 0) {
        }
        if (i21 == 0) {
        }
        modifier4 = modifier3;
        if (i25 == 0) {
        }
        function54 = function57;
        function43 = function48;
        z12 = z8;
        i26 = i16;
        function44 = function47;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i31222 = i26 << 3;
        int i32222 = i23 << 3;
        composer2 = startRestartGroup;
        Calendar(modifier4, calendarState4, z12, z10, true, z11, paddingValues2, contentHeightMode2, dayContent, function44, function54, function43, function53, composer2, (i26 & 14) | 24576 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (458752 & i31222) | (3670016 & i31222) | (29360128 & i31222) | (234881024 & i31222) | (i31222 & 1879048192), ((i26 >> 27) & 14) | (i32222 & 112) | (i32222 & 896));
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier5 = modifier4;
        calendarState5 = calendarState4;
        z13 = z12;
        z14 = z10;
        z15 = z11;
        paddingValues3 = paddingValues2;
        contentHeightMode3 = contentHeightMode2;
        function45 = function44;
        function55 = function54;
        function46 = function43;
        function56 = function53;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalCalendar$lambda$0(Modifier modifier, CalendarState calendarState, boolean z5, boolean z6, boolean z7, PaddingValues paddingValues, ContentHeightMode contentHeightMode, Function4 function4, Function4 function42, Function5 function5, Function4 function43, Function5 function52, int i5, int i6, int i7, Composer composer, int i8) {
        HorizontalCalendar(modifier, calendarState, z5, z6, z7, paddingValues, contentHeightMode, function4, function42, function5, function43, function52, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
        return Unit.INSTANCE;
    }
}
