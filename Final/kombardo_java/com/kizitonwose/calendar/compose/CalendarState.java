package com.kizitonwose.calendar.compose;

import android.util.Log;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import com.kizitonwose.calendar.compose.CalendarState;
import com.kizitonwose.calendar.core.CalendarMonth;
import com.kizitonwose.calendar.core.OutDateStyle;
import com.kizitonwose.calendar.data.DataStore;
import com.kizitonwose.calendar.data.MonthDataKt;
import com.kizitonwose.calendar.data.UtilsKt;
import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 d2\u00020\u0001:\u0001dB;\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J<\u0010 \u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\"\u0010\u001f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001bH\u0096@¢\u0006\u0004\b \u0010!R+\u0010)\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R+\u0010-\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R+\u00103\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010$\u001a\u0004\b/\u00100\"\u0004\b1\u00102R+\u00109\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010$\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001b\u0010\u0007\u001a\u00020:8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001b\u0010A\u001a\u00020:8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010<\u001a\u0004\b@\u0010>R\u001a\u0010C\u001a\u00020B8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001a\u0010H\u001a\u00020G8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR+\u0010R\u001a\u00020L2\u0006\u0010\"\u001a\u00020L8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bM\u0010$\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR \u0010T\u001a\b\u0012\u0004\u0012\u00020:0S8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010X\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bY\u0010&\"\u0004\bZ\u0010(R$\u0010\u0004\u001a\u00020\u00022\u0006\u0010X\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010&\"\u0004\b\\\u0010(R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u00100\"\u0004\b^\u00102R$\u0010\t\u001a\u00020\b2\u0006\u0010X\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b_\u00106\"\u0004\b`\u00108R\u0014\u0010b\u001a\u00020a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010c¨\u0006e"}, d2 = {"Lcom/kizitonwose/calendar/compose/CalendarState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "Ljava/time/YearMonth;", "startMonth", "endMonth", "Ljava/time/DayOfWeek;", "firstDayOfWeek", "firstVisibleMonth", "Lcom/kizitonwose/calendar/core/OutDateStyle;", "outDateStyle", "Lcom/kizitonwose/calendar/compose/VisibleItemState;", "visibleItemState", "<init>", "(Ljava/time/YearMonth;Ljava/time/YearMonth;Ljava/time/DayOfWeek;Ljava/time/YearMonth;Lcom/kizitonwose/calendar/core/OutDateStyle;Lcom/kizitonwose/calendar/compose/VisibleItemState;)V", BuildConfig.FLAVOR, "monthDataChanged", "()V", "month", BuildConfig.FLAVOR, "getScrollIndex", "(Ljava/time/YearMonth;)Ljava/lang/Integer;", BuildConfig.FLAVOR, "delta", "dispatchRawDelta", "(F)F", "Landroidx/compose/foundation/MutatePriority;", "scrollPriority", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "block", "scroll", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<set-?>", "_startMonth$delegate", "Landroidx/compose/runtime/MutableState;", "get_startMonth", "()Ljava/time/YearMonth;", "set_startMonth", "(Ljava/time/YearMonth;)V", "_startMonth", "_endMonth$delegate", "get_endMonth", "set_endMonth", "_endMonth", "_firstDayOfWeek$delegate", "get_firstDayOfWeek", "()Ljava/time/DayOfWeek;", "set_firstDayOfWeek", "(Ljava/time/DayOfWeek;)V", "_firstDayOfWeek", "_outDateStyle$delegate", "get_outDateStyle", "()Lcom/kizitonwose/calendar/core/OutDateStyle;", "set_outDateStyle", "(Lcom/kizitonwose/calendar/core/OutDateStyle;)V", "_outDateStyle", "Lcom/kizitonwose/calendar/core/CalendarMonth;", "firstVisibleMonth$delegate", "Landroidx/compose/runtime/State;", "getFirstVisibleMonth", "()Lcom/kizitonwose/calendar/core/CalendarMonth;", "lastVisibleMonth$delegate", "getLastVisibleMonth", "lastVisibleMonth", "Landroidx/compose/foundation/lazy/LazyListState;", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "getListState$compose_release", "()Landroidx/compose/foundation/lazy/LazyListState;", "Lcom/kizitonwose/calendar/compose/ItemPlacementInfo;", "placementInfo", "Lcom/kizitonwose/calendar/compose/ItemPlacementInfo;", "getPlacementInfo$compose_release", "()Lcom/kizitonwose/calendar/compose/ItemPlacementInfo;", "Lcom/kizitonwose/calendar/compose/CalendarInfo;", "calendarInfo$delegate", "getCalendarInfo$compose_release", "()Lcom/kizitonwose/calendar/compose/CalendarInfo;", "setCalendarInfo$compose_release", "(Lcom/kizitonwose/calendar/compose/CalendarInfo;)V", "calendarInfo", "Lcom/kizitonwose/calendar/data/DataStore;", "store", "Lcom/kizitonwose/calendar/data/DataStore;", "getStore$compose_release", "()Lcom/kizitonwose/calendar/data/DataStore;", "value", "getStartMonth", "setStartMonth", "getEndMonth", "setEndMonth", "getFirstDayOfWeek", "setFirstDayOfWeek", "getOutDateStyle", "setOutDateStyle", BuildConfig.FLAVOR, "isScrollInProgress", "()Z", "Companion", "compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CalendarState implements ScrollableState {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<CalendarState, Object> Saver = ListSaverKt.listSaver(new Function2() { // from class: c1.f
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            List Saver$lambda$5;
            Saver$lambda$5 = CalendarState.Saver$lambda$5((SaverScope) obj, (CalendarState) obj2);
            return Saver$lambda$5;
        }
    }, new Function1() { // from class: c1.g
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            CalendarState Saver$lambda$6;
            Saver$lambda$6 = CalendarState.Saver$lambda$6((List) obj);
            return Saver$lambda$6;
        }
    });

    /* renamed from: _endMonth$delegate, reason: from kotlin metadata */
    private final MutableState _endMonth;

    /* renamed from: _firstDayOfWeek$delegate, reason: from kotlin metadata */
    private final MutableState _firstDayOfWeek;

    /* renamed from: _outDateStyle$delegate, reason: from kotlin metadata */
    private final MutableState _outDateStyle;

    /* renamed from: _startMonth$delegate, reason: from kotlin metadata */
    private final MutableState _startMonth;

    /* renamed from: calendarInfo$delegate, reason: from kotlin metadata */
    private final MutableState calendarInfo;

    /* renamed from: firstVisibleMonth$delegate, reason: from kotlin metadata */
    private final State firstVisibleMonth;

    /* renamed from: lastVisibleMonth$delegate, reason: from kotlin metadata */
    private final State lastVisibleMonth;
    private final LazyListState listState;
    private final ItemPlacementInfo placementInfo;
    private final DataStore<CalendarMonth> store;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/kizitonwose/calendar/compose/CalendarState$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Lcom/kizitonwose/calendar/compose/CalendarState;", "getSaver$compose_release", "()Landroidx/compose/runtime/saveable/Saver;", "compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver<CalendarState, Object> getSaver$compose_release() {
            return CalendarState.Saver;
        }

        private Companion() {
        }
    }

    public CalendarState(YearMonth startMonth, YearMonth endMonth, DayOfWeek firstDayOfWeek, YearMonth firstVisibleMonth, OutDateStyle outDateStyle, VisibleItemState visibleItemState) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        int intValue;
        MutableState mutableStateOf$default5;
        Intrinsics.checkNotNullParameter(startMonth, "startMonth");
        Intrinsics.checkNotNullParameter(endMonth, "endMonth");
        Intrinsics.checkNotNullParameter(firstDayOfWeek, "firstDayOfWeek");
        Intrinsics.checkNotNullParameter(firstVisibleMonth, "firstVisibleMonth");
        Intrinsics.checkNotNullParameter(outDateStyle, "outDateStyle");
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(startMonth, null, 2, null);
        this._startMonth = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(endMonth, null, 2, null);
        this._endMonth = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(firstDayOfWeek, null, 2, null);
        this._firstDayOfWeek = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(outDateStyle, null, 2, null);
        this._outDateStyle = mutableStateOf$default4;
        this.firstVisibleMonth = SnapshotStateKt.derivedStateOf(new Function0() { // from class: c1.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                CalendarMonth firstVisibleMonth_delegate$lambda$0;
                firstVisibleMonth_delegate$lambda$0 = CalendarState.firstVisibleMonth_delegate$lambda$0(CalendarState.this);
                return firstVisibleMonth_delegate$lambda$0;
            }
        });
        this.lastVisibleMonth = SnapshotStateKt.derivedStateOf(new Function0() { // from class: c1.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                CalendarMonth lastVisibleMonth_delegate$lambda$1;
                lastVisibleMonth_delegate$lambda$1 = CalendarState.lastVisibleMonth_delegate$lambda$1(CalendarState.this);
                return lastVisibleMonth_delegate$lambda$1;
            }
        });
        if (visibleItemState != null) {
            intValue = visibleItemState.getFirstVisibleItemIndex();
        } else {
            Integer scrollIndex = getScrollIndex(firstVisibleMonth);
            intValue = scrollIndex != null ? scrollIndex.intValue() : 0;
        }
        this.listState = new LazyListState(intValue, visibleItemState != null ? visibleItemState.getFirstVisibleItemScrollOffset() : 0);
        this.placementInfo = new ItemPlacementInfo();
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CalendarInfo(0, null, null, 6, null), null, 2, null);
        this.calendarInfo = mutableStateOf$default5;
        this.store = new DataStore<>(null, new Function1() { // from class: c1.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CalendarMonth store$lambda$3;
                store$lambda$3 = CalendarState.store$lambda$3(CalendarState.this, ((Integer) obj).intValue());
                return store$lambda$3;
            }
        }, 1, null);
        monthDataChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Saver$lambda$5(SaverScope listSaver, CalendarState it) {
        Intrinsics.checkNotNullParameter(listSaver, "$this$listSaver");
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.listOf(it.getStartMonth(), it.getEndMonth(), it.getFirstVisibleMonth().getYearMonth(), it.getFirstDayOfWeek(), it.getOutDateStyle(), Integer.valueOf(it.listState.getFirstVisibleItemIndex()), Integer.valueOf(it.listState.getFirstVisibleItemScrollOffset()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CalendarState Saver$lambda$6(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object obj = it.get(0);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.time.YearMonth");
        YearMonth yearMonth = (YearMonth) obj;
        Object obj2 = it.get(1);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.time.YearMonth");
        YearMonth yearMonth2 = (YearMonth) obj2;
        Object obj3 = it.get(2);
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type java.time.YearMonth");
        YearMonth yearMonth3 = (YearMonth) obj3;
        Object obj4 = it.get(3);
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type java.time.DayOfWeek");
        DayOfWeek dayOfWeek = (DayOfWeek) obj4;
        Object obj5 = it.get(4);
        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type com.kizitonwose.calendar.core.OutDateStyle");
        OutDateStyle outDateStyle = (OutDateStyle) obj5;
        Object obj6 = it.get(5);
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj6).intValue();
        Object obj7 = it.get(6);
        Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Int");
        return new CalendarState(yearMonth, yearMonth2, dayOfWeek, yearMonth3, outDateStyle, new VisibleItemState(intValue, ((Integer) obj7).intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CalendarMonth firstVisibleMonth_delegate$lambda$0(CalendarState calendarState) {
        return calendarState.store.get(Integer.valueOf(calendarState.listState.getFirstVisibleItemIndex()));
    }

    private final Integer getScrollIndex(YearMonth month) {
        YearMonth startMonth = getStartMonth();
        if (month.compareTo(getEndMonth()) <= 0 && month.compareTo(startMonth) >= 0) {
            return Integer.valueOf(MonthDataKt.getMonthIndex(getStartMonth(), month));
        }
        Log.d("CalendarState", "Attempting to scroll out of range: " + month);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final YearMonth get_endMonth() {
        return (YearMonth) this._endMonth.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DayOfWeek get_firstDayOfWeek() {
        return (DayOfWeek) this._firstDayOfWeek.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final OutDateStyle get_outDateStyle() {
        return (OutDateStyle) this._outDateStyle.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final YearMonth get_startMonth() {
        return (YearMonth) this._startMonth.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CalendarMonth lastVisibleMonth_delegate$lambda$1(CalendarState calendarState) {
        DataStore<CalendarMonth> dataStore = calendarState.store;
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.lastOrNull((List) calendarState.listState.getLayoutInfo().getVisibleItemsInfo());
        return dataStore.get(Integer.valueOf(lazyListItemInfo != null ? lazyListItemInfo.getIndex() : 0));
    }

    private final void monthDataChanged() {
        this.store.clear();
        UtilsKt.checkRange(getStartMonth(), getEndMonth());
        setCalendarInfo$compose_release(new CalendarInfo(MonthDataKt.getMonthIndicesCount(getStartMonth(), getEndMonth()), getFirstDayOfWeek(), getOutDateStyle()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CalendarMonth store$lambda$3(CalendarState calendarState, int i5) {
        return MonthDataKt.getCalendarMonthData(calendarState.getStartMonth(), i5, calendarState.getFirstDayOfWeek(), calendarState.getOutDateStyle()).getCalendarMonth();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.listState.dispatchRawDelta(delta);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CalendarInfo getCalendarInfo$compose_release() {
        return (CalendarInfo) this.calendarInfo.getValue();
    }

    public final YearMonth getEndMonth() {
        return get_endMonth();
    }

    public final DayOfWeek getFirstDayOfWeek() {
        return get_firstDayOfWeek();
    }

    public final CalendarMonth getFirstVisibleMonth() {
        return (CalendarMonth) this.firstVisibleMonth.getValue();
    }

    /* renamed from: getListState$compose_release, reason: from getter */
    public final LazyListState getListState() {
        return this.listState;
    }

    public final OutDateStyle getOutDateStyle() {
        return get_outDateStyle();
    }

    /* renamed from: getPlacementInfo$compose_release, reason: from getter */
    public final ItemPlacementInfo getPlacementInfo() {
        return this.placementInfo;
    }

    public final YearMonth getStartMonth() {
        return get_startMonth();
    }

    public final DataStore<CalendarMonth> getStore$compose_release() {
        return this.store;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.listState.isScrollInProgress();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll = this.listState.scroll(mutatePriority, function2, continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    public final void setCalendarInfo$compose_release(CalendarInfo calendarInfo) {
        Intrinsics.checkNotNullParameter(calendarInfo, "<set-?>");
        this.calendarInfo.setValue(calendarInfo);
    }
}
