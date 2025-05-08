package dk.molslinjen.ui.views.screens.booking.departures.calendar;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.YearMonth;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class CalendarScreenKt$CalendarScreen$1$1 extends FunctionReferenceImpl implements Function1<YearMonth, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarScreenKt$CalendarScreen$1$1(Object obj) {
        super(1, obj, CalendarViewModel.class, "onMonthChange", "onMonthChange(Lorg/threeten/bp/YearMonth;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(YearMonth yearMonth) {
        invoke2(yearMonth);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(YearMonth p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((CalendarViewModel) this.receiver).onMonthChange(p02);
    }
}
