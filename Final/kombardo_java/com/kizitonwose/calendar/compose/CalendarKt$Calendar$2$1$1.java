package com.kizitonwose.calendar.compose;

import com.kizitonwose.calendar.core.CalendarMonth;
import com.kizitonwose.calendar.data.DataStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class CalendarKt$Calendar$2$1$1 extends FunctionReferenceImpl implements Function1<Integer, CalendarMonth> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarKt$Calendar$2$1$1(Object obj) {
        super(1, obj, DataStore.class, "get", "get(I)Ljava/lang/Object;", 0);
    }

    public final CalendarMonth invoke(int i5) {
        return (CalendarMonth) ((DataStore) this.receiver).get(Integer.valueOf(i5));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CalendarMonth invoke(Integer num) {
        return invoke(num.intValue());
    }
}
