package com.kizitonwose.calendar.compose;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class CalendarKt$Calendar$2$1$2 extends FunctionReferenceImpl implements Function1<ItemCoordinates, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarKt$Calendar$2$1$2(Object obj) {
        super(1, obj, ItemPlacementInfo.class, "onItemPlaced", "onItemPlaced(Lcom/kizitonwose/calendar/compose/ItemCoordinates;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ItemCoordinates itemCoordinates) {
        invoke2(itemCoordinates);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ItemCoordinates p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((ItemPlacementInfo) this.receiver).onItemPlaced(p02);
    }
}
