package com.kizitonwose.calendar.compose;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class CalendarMonthsKt$CalendarMonths$2$2$1$1$1$1$1$1$1 extends FunctionReferenceImpl implements Function1<LayoutCoordinates, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarMonthsKt$CalendarMonths$2$2$1$1$1$1$1$1$1(Object obj) {
        super(1, obj, ItemCoordinatesStore.class, "onFirstDayPlaced", "onFirstDayPlaced(Landroidx/compose/ui/layout/LayoutCoordinates;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
        invoke2(layoutCoordinates);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LayoutCoordinates p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((ItemCoordinatesStore) this.receiver).onFirstDayPlaced(p02);
    }
}
