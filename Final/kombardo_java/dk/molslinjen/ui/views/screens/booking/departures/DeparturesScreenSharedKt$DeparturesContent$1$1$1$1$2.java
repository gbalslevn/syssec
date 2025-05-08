package dk.molslinjen.ui.views.screens.booking.departures;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.managers.checkout.EditManager;
import dk.molslinjen.domain.managers.departure.DepartureState;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingTicket;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.EditInfo;
import dk.molslinjen.ui.theme.AppColor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDate;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeparturesScreenSharedKt$DeparturesContent$1$1$1$1$2 implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ DepartureState $departureState;
    final /* synthetic */ EditManager.EditState $editState;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ Function0<Unit> $onOpenedDatePicker;
    final /* synthetic */ Departure $outboundDeparture;
    final /* synthetic */ RouteSelectedState $routeSelectedState;
    final /* synthetic */ DepartureDirection $selectedTripDirection;
    final /* synthetic */ Function3<LocalDate, LocalDate, LocalDate, Unit> $showCalendar;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.DeparturesScreenSharedKt$DeparturesContent$1$1$1$1$2$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ DepartureState $departureState;
        final /* synthetic */ EditManager.EditState $editState;
        final /* synthetic */ Function0<Unit> $onOpenedDatePicker;
        final /* synthetic */ Departure $outboundDeparture;
        final /* synthetic */ RouteSelectedState $routeSelectedState;
        final /* synthetic */ DepartureDirection $selectedTripDirection;
        final /* synthetic */ Function3<LocalDate, LocalDate, LocalDate, Unit> $showCalendar;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(DepartureState departureState, Function3<? super LocalDate, ? super LocalDate, ? super LocalDate, Unit> function3, RouteSelectedState routeSelectedState, DepartureDirection departureDirection, Departure departure, EditManager.EditState editState, Function0<Unit> function0) {
            this.$departureState = departureState;
            this.$showCalendar = function3;
            this.$routeSelectedState = routeSelectedState;
            this.$selectedTripDirection = departureDirection;
            this.$outboundDeparture = departure;
            this.$editState = editState;
            this.$onOpenedDatePicker = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(Function3 function3, RouteSelectedState routeSelectedState, DepartureDirection departureDirection, Departure departure, EditManager.EditState editState) {
            LocalDate now;
            BookingTicket ticket;
            EditInfo editInfo;
            BookingTicket ticket2;
            EditInfo editInfo2;
            LocalDate selectedStartDate = routeSelectedState.getSelectedStartDate();
            if (departureDirection != DepartureDirection.Return || departure == null) {
                Booking booking = editState.getBooking();
                if (booking == null || (ticket = booking.getTicket()) == null || (editInfo = ticket.getEditInfo()) == null || (now = editInfo.getCanChangeFrom()) == null) {
                    now = LocalDate.now();
                }
            } else {
                now = departure.getDate();
            }
            Intrinsics.checkNotNull(now);
            Booking booking2 = editState.getBooking();
            function3.invoke(selectedStartDate, now, (booking2 == null || (ticket2 = booking2.getTicket()) == null || (editInfo2 = ticket2.getEditInfo()) == null) ? null : editInfo2.getCanChangeUntil());
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v9 ??, still in use, count: 1, list:
              (r0v9 ?? I:java.lang.Object) from 0x006b: INVOKE (r8v0 ?? I:androidx.compose.runtime.Composer), (r0v9 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:10)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
            	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:34)
            */
        public final void invoke(
        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v9 ??, still in use, count: 1, list:
              (r0v9 ?? I:java.lang.Object) from 0x006b: INVOKE (r8v0 ?? I:androidx.compose.runtime.Composer), (r0v9 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:10)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
            */
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r8v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:237)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            */
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DeparturesScreenSharedKt$DeparturesContent$1$1$1$1$2(RouteSelectedState routeSelectedState, LazyListState lazyListState, DepartureState departureState, Function3<? super LocalDate, ? super LocalDate, ? super LocalDate, Unit> function3, DepartureDirection departureDirection, Departure departure, EditManager.EditState editState, Function0<Unit> function0) {
        this.$routeSelectedState = routeSelectedState;
        this.$listState = lazyListState;
        this.$departureState = departureState;
        this.$showCalendar = function3;
        this.$selectedTripDirection = departureDirection;
        this.$outboundDeparture = departure;
        this.$editState = editState;
        this.$onOpenedDatePicker = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$1$lambda$0(LazyListState lazyListState, int i5) {
        return lazyListState.getFirstVisibleItemIndex() >= i5;
    }

    private static final boolean invoke$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope stickyHeaderIndexed, final int i5, Composer composer, int i6) {
        int i7;
        Intrinsics.checkNotNullParameter(stickyHeaderIndexed, "$this$stickyHeaderIndexed");
        if ((i6 & 48) == 0) {
            i7 = i6 | (composer.changed(i5) ? 32 : 16);
        } else {
            i7 = i6;
        }
        if ((i7 & 145) == 144 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1213265747, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.DeparturesContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DeparturesScreenShared.kt:406)");
        }
        if (this.$routeSelectedState != null) {
            composer.startReplaceGroup(-1609172216);
            final LazyListState lazyListState = this.$listState;
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.departures.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean invoke$lambda$1$lambda$0;
                        invoke$lambda$1$lambda$0 = DeparturesScreenSharedKt$DeparturesContent$1$1$1$1$2.invoke$lambda$1$lambda$0(LazyListState.this, i5);
                        return Boolean.valueOf(invoke$lambda$1$lambda$0);
                    }
                });
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            SurfaceKt.m900SurfaceT9BRK9s(null, null, AppColor.INSTANCE.m3270getShadowColor0d7_KjU(), 0L, 0.0f, Dp.m2599constructorimpl(invoke$lambda$2((State) rememberedValue) ? 6 : 0), null, ComposableLambdaKt.rememberComposableLambda(-367531043, true, new AnonymousClass1(this.$departureState, this.$showCalendar, this.$routeSelectedState, this.$selectedTripDirection, this.$outboundDeparture, this.$editState, this.$onOpenedDatePicker), composer, 54), composer, 12583296, 91);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
