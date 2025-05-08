package com.kizitonwose.calendar.compose;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnPlacedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import com.kizitonwose.calendar.compose.CalendarMonthsKt;
import com.kizitonwose.calendar.core.CalendarDay;
import com.kizitonwose.calendar.core.CalendarMonth;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001aí\u0001\u0010\u0017\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b2\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2&\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\u0003H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\"2\u0010\u0019\u001a \u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\u0004\u0012\u00020\u000b0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\"2\u0010\u001b\u001a \u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\u0004\u0012\u00020\u000b0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a¨\u0006\u001d²\u0006\u0018\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\u00038\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListScope;", BuildConfig.FLAVOR, "monthCount", "Lkotlin/Function1;", "Lcom/kizitonwose/calendar/core/CalendarMonth;", "monthData", "Lcom/kizitonwose/calendar/compose/ContentHeightMode;", "contentHeightMode", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/BoxScope;", "Lcom/kizitonwose/calendar/core/CalendarDay;", BuildConfig.FLAVOR, "dayContent", "Landroidx/compose/foundation/layout/ColumnScope;", "monthHeader", "Lkotlin/Function3;", "Lkotlin/Function0;", "monthBody", "monthFooter", "Landroidx/compose/foundation/lazy/LazyItemScope;", "monthContainer", "Lcom/kizitonwose/calendar/compose/ItemCoordinates;", "onItemPlaced", "CalendarMonths", "(Landroidx/compose/foundation/lazy/LazyListScope;ILkotlin/jvm/functions/Function1;Lcom/kizitonwose/calendar/compose/ContentHeightMode;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function1;)V", "defaultMonthContainer", "Lkotlin/jvm/functions/Function5;", "defaultMonthBody", "currentOnItemPlaced", "compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CalendarMonthsKt {
    private static final Function5<ColumnScope, CalendarMonth, Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> defaultMonthBody;
    private static final Function5<LazyItemScope, CalendarMonth, Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> defaultMonthContainer;

    static {
        ComposableSingletons$CalendarMonthsKt composableSingletons$CalendarMonthsKt = ComposableSingletons$CalendarMonthsKt.INSTANCE;
        defaultMonthContainer = composableSingletons$CalendarMonthsKt.m3030getLambda1$compose_release();
        defaultMonthBody = composableSingletons$CalendarMonthsKt.m3031getLambda2$compose_release();
    }

    public static final void CalendarMonths(LazyListScope lazyListScope, int i5, final Function1<? super Integer, CalendarMonth> monthData, final ContentHeightMode contentHeightMode, final Function4<? super BoxScope, ? super CalendarDay, ? super Composer, ? super Integer, Unit> dayContent, final Function4<? super ColumnScope, ? super CalendarMonth, ? super Composer, ? super Integer, Unit> function4, final Function5<? super ColumnScope, ? super CalendarMonth, ? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function5, final Function4<? super ColumnScope, ? super CalendarMonth, ? super Composer, ? super Integer, Unit> function42, final Function5<? super LazyItemScope, ? super CalendarMonth, ? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function52, final Function1<? super ItemCoordinates, Unit> onItemPlaced) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(monthData, "monthData");
        Intrinsics.checkNotNullParameter(contentHeightMode, "contentHeightMode");
        Intrinsics.checkNotNullParameter(dayContent, "dayContent");
        Intrinsics.checkNotNullParameter(onItemPlaced, "onItemPlaced");
        LazyListScope.items$default(lazyListScope, i5, new Function1() { // from class: c1.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object CalendarMonths$lambda$0;
                CalendarMonths$lambda$0 = CalendarMonthsKt.CalendarMonths$lambda$0(Function1.this, ((Integer) obj).intValue());
                return CalendarMonths$lambda$0;
            }
        }, null, ComposableLambdaKt.composableLambdaInstance(-868131948, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.kizitonwose.calendar.compose.CalendarMonthsKt$CalendarMonths$2

            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ContentHeightMode.values().length];
                    try {
                        iArr[ContentHeightMode.Wrap.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ContentHeightMode.Fill.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            private static final Function1<ItemCoordinates, Unit> invoke$lambda$0(State<? extends Function1<? super ItemCoordinates, Unit>> state) {
                return (Function1) state.getValue();
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final LazyItemScope items, int i6, Composer composer, int i7) {
                int i8;
                final boolean z5;
                Function5<LazyItemScope, CalendarMonth, Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function53;
                Intrinsics.checkNotNullParameter(items, "$this$items");
                if ((i7 & 6) == 0) {
                    i8 = i7 | (composer.changed(items) ? 4 : 2);
                } else {
                    i8 = i7;
                }
                if ((i7 & 48) == 0) {
                    i8 |= composer.changed(i6) ? 32 : 16;
                }
                int i9 = i8;
                if ((i9 & 147) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-868131948, i9, -1, "com.kizitonwose.calendar.compose.CalendarMonths.<anonymous> (CalendarMonths.kt:40)");
                }
                final CalendarMonth invoke = monthData.invoke(Integer.valueOf(i6));
                int i10 = WhenMappings.$EnumSwitchMapping$0[contentHeightMode.ordinal()];
                if (i10 == 1) {
                    z5 = false;
                } else {
                    if (i10 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    z5 = true;
                }
                final boolean z6 = function52 != null;
                State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onItemPlaced, composer, 0);
                Object yearMonth = invoke.getYearMonth();
                composer.startReplaceGroup(-1063054196);
                boolean changed = composer.changed(yearMonth);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new ItemCoordinatesStore(invoke$lambda$0(rememberUpdatedState));
                    composer.updateRememberedValue(rememberedValue);
                }
                final ItemCoordinatesStore itemCoordinatesStore = (ItemCoordinatesStore) rememberedValue;
                composer.endReplaceGroup();
                Modifier.Companion companion = Modifier.INSTANCE;
                composer.startReplaceGroup(-1063050345);
                boolean changed2 = composer.changed(itemCoordinatesStore);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new CalendarMonthsKt$CalendarMonths$2$1$1(itemCoordinatesStore);
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                Modifier onPlaced = OnPlacedModifierKt.onPlaced(companion, (Function1) ((KFunction) rememberedValue2));
                Function5<LazyItemScope, CalendarMonth, Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function54 = function52;
                final Function4<ColumnScope, CalendarMonth, Composer, Integer, Unit> function43 = function4;
                final Function5<ColumnScope, CalendarMonth, Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function55 = function5;
                final Function4<ColumnScope, CalendarMonth, Composer, Integer, Unit> function44 = function42;
                final Function4<BoxScope, CalendarDay, Composer, Integer, Unit> function45 = dayContent;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, onPlaced);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                function53 = CalendarMonthsKt.defaultMonthContainer;
                if (function54 != null) {
                    function53 = function54;
                }
                function53.invoke(items, invoke, ComposableLambdaKt.rememberComposableLambda(791318209, true, new Function2<Composer, Integer, Unit>() { // from class: com.kizitonwose.calendar.compose.CalendarMonthsKt$CalendarMonths$2$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11) {
                        Modifier fillParentMaxWidth$default;
                        Modifier wrapContentHeight$default;
                        Function5<ColumnScope, CalendarMonth, Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function56;
                        if ((i11 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(791318209, i11, -1, "com.kizitonwose.calendar.compose.CalendarMonths.<anonymous>.<anonymous>.<anonymous> (CalendarMonths.kt:52)");
                        }
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        if (z6) {
                            fillParentMaxWidth$default = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
                        } else {
                            fillParentMaxWidth$default = LazyItemScope.fillParentMaxWidth$default(items, companion3, 0.0f, 1, null);
                        }
                        Modifier then = companion3.then(fillParentMaxWidth$default);
                        if (z5) {
                            if (z6) {
                                wrapContentHeight$default = SizeKt.fillMaxHeight$default(companion3, 0.0f, 1, null);
                            } else {
                                wrapContentHeight$default = LazyItemScope.fillParentMaxHeight$default(items, companion3, 0.0f, 1, null);
                            }
                        } else {
                            wrapContentHeight$default = SizeKt.wrapContentHeight$default(companion3, null, false, 3, null);
                        }
                        Modifier then2 = then.then(wrapContentHeight$default);
                        Function4<ColumnScope, CalendarMonth, Composer, Integer, Unit> function46 = function43;
                        final CalendarMonth calendarMonth = invoke;
                        Function5<ColumnScope, CalendarMonth, Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function57 = function55;
                        Function4<ColumnScope, CalendarMonth, Composer, Integer, Unit> function47 = function44;
                        final boolean z7 = z5;
                        final ItemCoordinatesStore itemCoordinatesStore2 = itemCoordinatesStore;
                        final Function4<BoxScope, CalendarDay, Composer, Integer, Unit> function48 = function45;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, then2);
                        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
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
                        Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                        final ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        composer2.startReplaceGroup(1578463201);
                        if (function46 != null) {
                            function46.invoke(columnScopeInstance, calendarMonth, composer2, 6);
                        }
                        composer2.endReplaceGroup();
                        function56 = CalendarMonthsKt.defaultMonthBody;
                        if (function57 != null) {
                            function56 = function57;
                        }
                        function56.invoke(columnScopeInstance, calendarMonth, ComposableLambdaKt.rememberComposableLambda(-912247458, true, new Function2<Composer, Integer, Unit>() { // from class: com.kizitonwose.calendar.compose.CalendarMonthsKt$CalendarMonths$2$2$1$1$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i12) {
                                Modifier wrapContentHeight$default2;
                                int i13;
                                Modifier wrapContentHeight$default3;
                                if ((i12 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-912247458, i12, -1, "com.kizitonwose.calendar.compose.CalendarMonths.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CalendarMonths.kt:75)");
                                }
                                Modifier.Companion companion5 = Modifier.INSTANCE;
                                float f5 = 0.0f;
                                int i14 = 1;
                                Alignment.Vertical vertical = null;
                                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion5, 0.0f, 1, null);
                                if (z7) {
                                    wrapContentHeight$default2 = ColumnScope.weight$default(columnScopeInstance, companion5, 1.0f, false, 2, null);
                                } else {
                                    wrapContentHeight$default2 = SizeKt.wrapContentHeight$default(companion5, null, false, 3, null);
                                }
                                Modifier then3 = fillMaxWidth$default.then(wrapContentHeight$default2);
                                CalendarMonth calendarMonth2 = calendarMonth;
                                boolean z8 = z7;
                                ItemCoordinatesStore itemCoordinatesStore3 = itemCoordinatesStore2;
                                Function4<BoxScope, CalendarDay, Composer, Integer, Unit> function49 = function48;
                                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, then3);
                                ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor3 = companion6.getConstructor();
                                if (composer3.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor3);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer3);
                                Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion6.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion6.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion6.getSetCompositeKeyHash();
                                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion6.getSetModifier());
                                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                composer3.startReplaceGroup(-1870834429);
                                Iterator<T> it = calendarMonth2.getWeekDays().iterator();
                                int i15 = 0;
                                while (it.hasNext()) {
                                    int i16 = i15 + 1;
                                    List list = (List) it.next();
                                    Modifier.Companion companion7 = Modifier.INSTANCE;
                                    Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion7, f5, i14, vertical);
                                    if (z8) {
                                        wrapContentHeight$default3 = ColumnScope.weight$default(columnScopeInstance2, companion7, 1.0f, false, 2, null);
                                        i13 = 0;
                                    } else {
                                        i13 = 0;
                                        wrapContentHeight$default3 = SizeKt.wrapContentHeight$default(companion7, vertical, false, 3, vertical);
                                    }
                                    Modifier then4 = fillMaxWidth$default2.then(wrapContentHeight$default3);
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer3, i13);
                                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, i13);
                                    CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer3, then4);
                                    ComposeUiNode.Companion companion8 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor4 = companion8.getConstructor();
                                    if (composer3.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor4);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer3);
                                    Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy, companion8.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion8.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion8.getSetCompositeKeyHash();
                                    if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                        m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                        m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion8.getSetModifier());
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    composer3.startReplaceGroup(-1472109146);
                                    Iterator it2 = list.iterator();
                                    int i17 = 0;
                                    while (it2.hasNext()) {
                                        int i18 = i17 + 1;
                                        CalendarDay calendarDay = (CalendarDay) it2.next();
                                        Modifier clipToBounds = ClipKt.clipToBounds(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null));
                                        composer3.startReplaceGroup(-1472092239);
                                        boolean changed3 = composer3.changed(itemCoordinatesStore3);
                                        Object rememberedValue3 = composer3.rememberedValue();
                                        if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = new CalendarMonthsKt$CalendarMonths$2$2$1$1$1$1$1$1$1(itemCoordinatesStore3);
                                            composer3.updateRememberedValue(rememberedValue3);
                                        }
                                        composer3.endReplaceGroup();
                                        Function1 function1 = (Function1) ((KFunction) rememberedValue3);
                                        if (i15 == 0 && i17 == 0) {
                                            clipToBounds = OnPlacedModifierKt.onPlaced(clipToBounds, function1);
                                        }
                                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap5 = composer3.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer3, clipToBounds);
                                        ComposeUiNode.Companion companion9 = ComposeUiNode.INSTANCE;
                                        RowScopeInstance rowScopeInstance2 = rowScopeInstance;
                                        Function0<ComposeUiNode> constructor5 = companion9.getConstructor();
                                        if (composer3.getApplier() == null) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor5);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m1226constructorimpl5 = Updater.m1226constructorimpl(composer3);
                                        Iterator it3 = it2;
                                        Updater.m1227setimpl(m1226constructorimpl5, maybeCachedBoxMeasurePolicy2, companion9.getSetMeasurePolicy());
                                        Updater.m1227setimpl(m1226constructorimpl5, currentCompositionLocalMap5, companion9.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = companion9.getSetCompositeKeyHash();
                                        if (m1226constructorimpl5.getInserting() || !Intrinsics.areEqual(m1226constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                                            m1226constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                                            m1226constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                                        }
                                        Updater.m1227setimpl(m1226constructorimpl5, materializeModifier5, companion9.getSetModifier());
                                        function49.invoke(BoxScopeInstance.INSTANCE, calendarDay, composer3, 6);
                                        composer3.endNode();
                                        i17 = i18;
                                        rowScopeInstance = rowScopeInstance2;
                                        it2 = it3;
                                    }
                                    composer3.endReplaceGroup();
                                    composer3.endNode();
                                    i15 = i16;
                                    f5 = 0.0f;
                                    i14 = 1;
                                    vertical = null;
                                }
                                composer3.endReplaceGroup();
                                composer3.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, 390);
                        composer2.startReplaceGroup(1578535073);
                        if (function47 != null) {
                            function47.invoke(columnScopeInstance, calendarMonth, composer2, 6);
                        }
                        composer2.endReplaceGroup();
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer, 54), composer, Integer.valueOf((i9 & 14) | 384));
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object CalendarMonths$lambda$0(Function1 function1, int i5) {
        return ((CalendarMonth) function1.invoke(Integer.valueOf(i5))).getYearMonth();
    }
}
