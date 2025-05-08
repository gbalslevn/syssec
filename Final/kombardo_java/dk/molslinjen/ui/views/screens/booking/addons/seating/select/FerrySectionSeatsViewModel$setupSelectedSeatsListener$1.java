package dk.molslinjen.ui.views.screens.booking.addons.seating.select;

import androidx.compose.ui.geometry.Offset;
import dk.molslinjen.domain.extensions.domain.FerrySeatingGroupTypeExtensionsKt;
import dk.molslinjen.domain.managers.seating.ISelectSeatingManager;
import dk.molslinjen.extensions.domain.seating.PointExtensionsKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeat;
import uniffi.molslinjen_shared.FerrySeatId;
import uniffi.molslinjen_shared.FerrySeatingGroup;
import uniffi.molslinjen_shared.FerrySeatingSectionDetails;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupSelectedSeatsListener$1", f = "FerrySectionSeatsViewModel.kt", l = {142}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class FerrySectionSeatsViewModel$setupSelectedSeatsListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FerrySectionSeatsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Luniffi/molslinjen_shared/FerrySeatingSectionDetails;", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatId;", "sectionDetails", "selectedSeats"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupSelectedSeatsListener$1$3", f = "FerrySectionSeatsViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupSelectedSeatsListener$1$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<FerrySeatingSectionDetails, List<? extends FerrySeatId>, Continuation<? super Pair<? extends FerrySeatingSectionDetails, ? extends List<? extends FerrySeatId>>>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(FerrySeatingSectionDetails ferrySeatingSectionDetails, List<? extends FerrySeatId> list, Continuation<? super Pair<? extends FerrySeatingSectionDetails, ? extends List<? extends FerrySeatId>>> continuation) {
            return invoke2(ferrySeatingSectionDetails, (List<FerrySeatId>) list, (Continuation<? super Pair<FerrySeatingSectionDetails, ? extends List<FerrySeatId>>>) continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new Pair((FerrySeatingSectionDetails) this.L$0, (List) this.L$1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FerrySeatingSectionDetails ferrySeatingSectionDetails, List<FerrySeatId> list, Continuation<? super Pair<FerrySeatingSectionDetails, ? extends List<FerrySeatId>>> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.L$0 = ferrySeatingSectionDetails;
            anonymousClass3.L$1 = list;
            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "<destruct>", "Lkotlin/Pair;", "Luniffi/molslinjen_shared/FerrySeatingSectionDetails;", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatId;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupSelectedSeatsListener$1$4", f = "FerrySectionSeatsViewModel.kt", l = {143}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupSelectedSeatsListener$1$4, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<Pair<? extends FerrySeatingSectionDetails, ? extends List<? extends FerrySeatId>>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ FerrySectionSeatsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(FerrySectionSeatsViewModel ferrySectionSeatsViewModel, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.this$0 = ferrySectionSeatsViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.this$0, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Pair<? extends FerrySeatingSectionDetails, ? extends List<? extends FerrySeatId>> pair, Continuation<? super Unit> continuation) {
            return invoke2((Pair<FerrySeatingSectionDetails, ? extends List<FerrySeatId>>) pair, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ISelectSeatingManager iSelectSeatingManager;
            Object seats;
            List<FerrySeatId> list;
            FerrySeatingSectionDetails ferrySeatingSectionDetails;
            MutableStateFlow mutableStateFlow;
            Object value;
            Object obj2;
            MutableStateFlow mutableStateFlow2;
            Object value2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) this.L$0;
                FerrySeatingSectionDetails ferrySeatingSectionDetails2 = (FerrySeatingSectionDetails) pair.component1();
                List<FerrySeatId> list2 = (List) pair.component2();
                iSelectSeatingManager = this.this$0.seatReservationManager;
                this.L$0 = ferrySeatingSectionDetails2;
                this.L$1 = list2;
                this.label = 1;
                seats = iSelectSeatingManager.getSeats(list2, this);
                if (seats == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = list2;
                ferrySeatingSectionDetails = ferrySeatingSectionDetails2;
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$1;
                ferrySeatingSectionDetails = (FerrySeatingSectionDetails) this.L$0;
                ResultKt.throwOnFailure(obj);
                seats = obj;
            }
            List list3 = (List) seats;
            if (this.this$0.getViewState().getValue().getInitialFocusPoint() == null && ferrySeatingSectionDetails != null) {
                Iterator<T> it = ferrySeatingSectionDetails.getSeatGroups().iterator();
                while (true) {
                    obj2 = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    Iterator<T> it2 = FerrySeatingGroupTypeExtensionsKt.getSeats(((FerrySeatingGroup) next).getGroupType()).iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object next2 = it2.next();
                        if (list.contains(((FerrySeat) next2).getId())) {
                            obj2 = next2;
                            break;
                        }
                    }
                    if (obj2 != null) {
                        obj2 = next;
                        break;
                    }
                }
                FerrySeatingGroup ferrySeatingGroup = (FerrySeatingGroup) obj2;
                if (ferrySeatingGroup != null) {
                    mutableStateFlow2 = this.this$0._viewState;
                    do {
                        value2 = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value2, FerrySectionSeatsViewModel.ViewState.m3453copyBn6Y4c$default((FerrySectionSeatsViewModel.ViewState) value2, false, null, null, null, null, false, null, false, false, Offset.m1328boximpl(PointExtensionsKt.toOffset(ferrySeatingGroup.getOrigin())), null, 1535, null)));
                }
            }
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, FerrySectionSeatsViewModel.ViewState.m3453copyBn6Y4c$default((FerrySectionSeatsViewModel.ViewState) value, false, null, null, null, list3, false, null, false, false, null, null, 2031, null)));
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Pair<FerrySeatingSectionDetails, ? extends List<FerrySeatId>> pair, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FerrySectionSeatsViewModel$setupSelectedSeatsListener$1(FerrySectionSeatsViewModel ferrySectionSeatsViewModel, Continuation<? super FerrySectionSeatsViewModel$setupSelectedSeatsListener$1> continuation) {
        super(2, continuation);
        this.this$0 = ferrySectionSeatsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FerrySectionSeatsViewModel$setupSelectedSeatsListener$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISelectSeatingManager iSelectSeatingManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            final MutableStateFlow<FerrySectionSeatsViewModel.ViewState> viewState = this.this$0.getViewState();
            Flow<FerrySeatingSectionDetails> flow = new Flow<FerrySeatingSectionDetails>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupSelectedSeatsListener$1$invokeSuspend$$inlined$map$1

                @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
                /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupSelectedSeatsListener$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupSelectedSeatsListener$1$invokeSuspend$$inlined$map$1$2", f = "FerrySectionSeatsViewModel.kt", l = {223}, m = "emit")
                    /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupSelectedSeatsListener$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    /* loaded from: classes2.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        int i5;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            int i6 = anonymousClass1.label;
                            if ((i6 & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i6 - Integer.MIN_VALUE;
                                Object obj2 = anonymousClass1.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                i5 = anonymousClass1.label;
                                if (i5 != 0) {
                                    ResultKt.throwOnFailure(obj2);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    FerrySeatingSectionDetails sectionDetails = ((FerrySectionSeatsViewModel.ViewState) obj).getSectionDetails();
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(sectionDetails, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i5 != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj2);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        anonymousClass1 = new AnonymousClass1(continuation);
                        Object obj22 = anonymousClass1.result;
                        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i5 = anonymousClass1.label;
                        if (i5 != 0) {
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super FerrySeatingSectionDetails> flowCollector, Continuation continuation) {
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }
            };
            iSelectSeatingManager = this.this$0.seatReservationManager;
            final StateFlow<ISelectSeatingManager.SeatReservationState> state = iSelectSeatingManager.getState();
            Flow combine = FlowKt.combine(flow, new Flow<List<? extends FerrySeatId>>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupSelectedSeatsListener$1$invokeSuspend$$inlined$map$2

                @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
                /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupSelectedSeatsListener$1$invokeSuspend$$inlined$map$2$2, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupSelectedSeatsListener$1$invokeSuspend$$inlined$map$2$2", f = "FerrySectionSeatsViewModel.kt", l = {223}, m = "emit")
                    /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupSelectedSeatsListener$1$invokeSuspend$$inlined$map$2$2$1, reason: invalid class name */
                    /* loaded from: classes2.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        int i5;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            int i6 = anonymousClass1.label;
                            if ((i6 & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i6 - Integer.MIN_VALUE;
                                Object obj2 = anonymousClass1.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                i5 = anonymousClass1.label;
                                if (i5 != 0) {
                                    ResultKt.throwOnFailure(obj2);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    List<FerrySeatId> selectedSeats = ((ISelectSeatingManager.SeatReservationState) obj).getSelectedSeats();
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(selectedSeats, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i5 != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj2);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        anonymousClass1 = new AnonymousClass1(continuation);
                        Object obj22 = anonymousClass1.result;
                        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i5 = anonymousClass1.label;
                        if (i5 != 0) {
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super List<? extends FerrySeatId>> flowCollector, Continuation continuation) {
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }
            }, new AnonymousClass3(null));
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.this$0, null);
            this.label = 1;
            if (FlowKt.collectLatest(combine, anonymousClass4, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FerrySectionSeatsViewModel$setupSelectedSeatsListener$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
