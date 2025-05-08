package com.kizitonwose.calendar.compose;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.kizitonwose.calendar.core.CalendarMonth;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$CalendarMonthsKt {
    public static final ComposableSingletons$CalendarMonthsKt INSTANCE = new ComposableSingletons$CalendarMonthsKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function5<LazyItemScope, CalendarMonth, Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> f50lambda1 = ComposableLambdaKt.composableLambdaInstance(-1282818314, false, new Function5<LazyItemScope, CalendarMonth, Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: com.kizitonwose.calendar.compose.ComposableSingletons$CalendarMonthsKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, CalendarMonth calendarMonth, Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer, Integer num) {
            invoke(lazyItemScope, calendarMonth, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope lazyItemScope, CalendarMonth unused$var$, Function2<? super Composer, ? super Integer, Unit> container, Composer composer, int i5) {
            Intrinsics.checkNotNullParameter(lazyItemScope, "<this>");
            Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
            Intrinsics.checkNotNullParameter(container, "container");
            if ((i5 & 384) == 0) {
                i5 |= composer.changedInstance(container) ? 256 : 128;
            }
            if ((i5 & 1153) == 1152 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1282818314, i5, -1, "com.kizitonwose.calendar.compose.ComposableSingletons$CalendarMonthsKt.lambda-1.<anonymous> (CalendarMonths.kt:162)");
            }
            container.invoke(composer, Integer.valueOf((i5 >> 6) & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function5<ColumnScope, CalendarMonth, Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> f51lambda2 = ComposableLambdaKt.composableLambdaInstance(-2145794324, false, new Function5<ColumnScope, CalendarMonth, Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: com.kizitonwose.calendar.compose.ComposableSingletons$CalendarMonthsKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, CalendarMonth calendarMonth, Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer, Integer num) {
            invoke(columnScope, calendarMonth, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope columnScope, CalendarMonth unused$var$, Function2<? super Composer, ? super Integer, Unit> content, Composer composer, int i5) {
            Intrinsics.checkNotNullParameter(columnScope, "<this>");
            Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
            Intrinsics.checkNotNullParameter(content, "content");
            if ((i5 & 384) == 0) {
                i5 |= composer.changedInstance(content) ? 256 : 128;
            }
            if ((i5 & 1153) == 1152 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2145794324, i5, -1, "com.kizitonwose.calendar.compose.ComposableSingletons$CalendarMonthsKt.lambda-2.<anonymous> (CalendarMonths.kt:165)");
            }
            content.invoke(composer, Integer.valueOf((i5 >> 6) & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$compose_release, reason: not valid java name */
    public final Function5<LazyItemScope, CalendarMonth, Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> m3030getLambda1$compose_release() {
        return f50lambda1;
    }

    /* renamed from: getLambda-2$compose_release, reason: not valid java name */
    public final Function5<ColumnScope, CalendarMonth, Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> m3031getLambda2$compose_release() {
        return f51lambda2;
    }
}
