package dk.molslinjen.ui.views.screens.booking.addons.seating;

import androidx.compose.ui.unit.IntSize;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.FerryFloorSectionsScreenDestination;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.seating.ISelectSeatingManager;
import dk.molslinjen.domain.model.booking.DepartureDirection;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerryFloorPlan;
import uniffi.molslinjen_shared.FerrySeatingSection;
import uniffi.molslinjen_shared.FerrySeatingSectionOverview;
import uniffi.molslinjen_shared.Point;
import uniffi.molslinjen_shared.SelectSeatingHelperInterface;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001%B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0015\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/seating/FerryFloorSectionViewModel;", "Landroidx/lifecycle/ViewModel;", "seatReservationManager", "Ldk/molslinjen/domain/managers/seating/ISelectSeatingManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "selectSeatingHelper", "Luniffi/molslinjen_shared/SelectSeatingHelperInterface;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Ldk/molslinjen/domain/managers/seating/ISelectSeatingManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Luniffi/molslinjen_shared/SelectSeatingHelperInterface;Landroidx/lifecycle/SavedStateHandle;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/booking/addons/seating/FerryFloorSectionsScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/addons/seating/FerryFloorSectionViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "_imageSize", "Landroidx/compose/ui/unit/IntSize;", "loadFerryData", BuildConfig.FLAVOR, "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "setupFerryDataListener", "updateForImageSize", "size", "updateForImageSize-ozmzZPI", "(J)V", "isSectionEnabled", BuildConfig.FLAVOR, "section", "Luniffi/molslinjen_shared/FerrySeatingSectionOverview;", "disabledSectionPressed", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FerryFloorSectionViewModel extends ViewModel {
    private final MutableStateFlow<IntSize> _imageSize;
    private final MutableStateFlow<ViewState> _viewState;
    private final FerryFloorSectionsScreenNavArgs navArgs;
    private final ISelectSeatingManager seatReservationManager;
    private final SelectSeatingHelperInterface selectSeatingHelper;
    private final ISnackbarService snackbarService;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel$1", f = "FerryFloorSectionViewModel.kt", l = {62}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatingSectionOverview;", "Luniffi/molslinjen_shared/Point;", "imageSize", "Landroidx/compose/ui/unit/IntSize;", "floorPlan", "Luniffi/molslinjen_shared/FerryFloorPlan;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel$1$1", f = "FerryFloorSectionViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00521 extends SuspendLambda implements Function3<IntSize, FerryFloorPlan, Continuation<? super Pair<? extends List<? extends FerrySeatingSectionOverview>, ? extends Point>>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;
            final /* synthetic */ FerryFloorSectionViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00521(FerryFloorSectionViewModel ferryFloorSectionViewModel, Continuation<? super C00521> continuation) {
                super(3, continuation);
                this.this$0 = ferryFloorSectionViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            /* renamed from: invoke-2eTSAmc, reason: not valid java name and merged with bridge method [inline-methods] */
            public final Object invoke(IntSize intSize, FerryFloorPlan ferryFloorPlan, Continuation<? super Pair<? extends List<FerrySeatingSectionOverview>, Point>> continuation) {
                C00521 c00521 = new C00521(this.this$0, continuation);
                c00521.L$0 = intSize;
                c00521.L$1 = ferryFloorPlan;
                return c00521.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                List<FerrySeatingSection> sections;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                IntSize intSize = (IntSize) this.L$0;
                FerryFloorPlan ferryFloorPlan = (FerryFloorPlan) this.L$1;
                if (intSize == null) {
                    return null;
                }
                FerryFloorSectionViewModel ferryFloorSectionViewModel = this.this$0;
                intSize.getPackedValue();
                if (ferryFloorPlan == null || (sections = ferryFloorPlan.getSections()) == null) {
                    return null;
                }
                return new Pair(ferryFloorSectionViewModel.selectSeatingHelper.toOverview(sections, IntSize.m2661getWidthimpl(intSize.getPackedValue()), IntSize.m2660getHeightimpl(intSize.getPackedValue())), ferryFloorPlan.getFocusPoint());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "floorData", "Lkotlin/Pair;", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatingSectionOverview;", "Luniffi/molslinjen_shared/Point;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel$1$3", f = "FerryFloorSectionViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel$1$3, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<Pair<? extends List<? extends FerrySeatingSectionOverview>, ? extends Point>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ FerryFloorSectionViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(FerryFloorSectionViewModel ferryFloorSectionViewModel, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = ferryFloorSectionViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Pair<? extends List<? extends FerrySeatingSectionOverview>, ? extends Point> pair, Continuation<? super Unit> continuation) {
                return invoke2((Pair<? extends List<FerrySeatingSectionOverview>, Point>) pair, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object value;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) this.L$0;
                MutableStateFlow mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, false, null, (List) pair.getFirst(), (Point) pair.getSecond(), null, 19, null)));
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Pair<? extends List<FerrySeatingSectionOverview>, Point> pair, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                final Flow combine = FlowKt.combine(FerryFloorSectionViewModel.this._imageSize, FerryFloorSectionViewModel.this.seatReservationManager.getSelectedFloorPlan(), new C00521(FerryFloorSectionViewModel.this, null));
                Flow<Pair<? extends List<? extends FerrySeatingSectionOverview>, ? extends Point>> flow = new Flow<Pair<? extends List<? extends FerrySeatingSectionOverview>, ? extends Point>>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel$1$invokeSuspend$$inlined$mapNotNull$1

                    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
                    /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel$1$invokeSuspend$$inlined$mapNotNull$1$2, reason: invalid class name */
                    /* loaded from: classes2.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel$1$invokeSuspend$$inlined$mapNotNull$1$2", f = "FerryFloorSectionViewModel.kt", l = {225}, m = "emit")
                        /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel$1$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
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
                                        Pair pair = (Pair) obj;
                                        if (pair != null) {
                                            anonymousClass1.label = 1;
                                            if (flowCollector.emit(pair, anonymousClass1) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
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
                    public Object collect(FlowCollector<? super Pair<? extends List<? extends FerrySeatingSectionOverview>, ? extends Point>> flowCollector, Continuation continuation) {
                        Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }
                };
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(FerryFloorSectionViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(flow, anonymousClass3, this) == coroutine_suspended) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public FerryFloorSectionViewModel(ISelectSeatingManager seatReservationManager, ISnackbarService snackbarService, SelectSeatingHelperInterface selectSeatingHelper, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(seatReservationManager, "seatReservationManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(selectSeatingHelper, "selectSeatingHelper");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.seatReservationManager = seatReservationManager;
        this.snackbarService = snackbarService;
        this.selectSeatingHelper = selectSeatingHelper;
        FerryFloorSectionsScreenNavArgs argsFrom = FerryFloorSectionsScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, null, null, null, argsFrom.getDirection(), 15, null));
        this._viewState = MutableStateFlow;
        this.viewState = FlowKt.asStateFlow(MutableStateFlow);
        this._imageSize = StateFlowKt.MutableStateFlow(null);
        setupFerryDataListener();
        loadFerryData(argsFrom.getDirection());
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    private final void loadFerryData(DepartureDirection departureDirection) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FerryFloorSectionViewModel$loadFerryData$1(this, departureDirection, null), 3, null);
    }

    private final void setupFerryDataListener() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FerryFloorSectionViewModel$setupFerryDataListener$1(this, null), 3, null);
    }

    public final void disabledSectionPressed() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FerryFloorSectionViewModel$disabledSectionPressed$1(this, null), 3, null);
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final boolean isSectionEnabled(FerrySeatingSectionOverview section) {
        Intrinsics.checkNotNullParameter(section, "section");
        return section.getAvailableSeats() > this.seatReservationManager.getState().getValue().getSeatsToBeSelected();
    }

    /* renamed from: updateForImageSize-ozmzZPI, reason: not valid java name */
    public final void m3438updateForImageSizeozmzZPI(long size) {
        MutableStateFlow<IntSize> mutableStateFlow = this._imageSize;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), IntSize.m2656boximpl(size)));
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJN\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u0003\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u0012R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/seating/FerryFloorSectionViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "selectedFloorImageUrl", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatingSectionOverview;", "ferrySections", "Luniffi/molslinjen_shared/Point;", "focusPoint", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "direction", "<init>", "(ZLjava/lang/String;Ljava/util/List;Luniffi/molslinjen_shared/Point;Ldk/molslinjen/domain/model/booking/DepartureDirection;)V", "copy", "(ZLjava/lang/String;Ljava/util/List;Luniffi/molslinjen_shared/Point;Ldk/molslinjen/domain/model/booking/DepartureDirection;)Ldk/molslinjen/ui/views/screens/booking/addons/seating/FerryFloorSectionViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ljava/lang/String;", "getSelectedFloorImageUrl", "Ljava/util/List;", "getFerrySections", "()Ljava/util/List;", "Luniffi/molslinjen_shared/Point;", "getFocusPoint", "()Luniffi/molslinjen_shared/Point;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getDirection", "()Ldk/molslinjen/domain/model/booking/DepartureDirection;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final DepartureDirection direction;
        private final List<FerrySeatingSectionOverview> ferrySections;
        private final Point focusPoint;
        private final boolean isLoading;
        private final String selectedFloorImageUrl;

        public ViewState(boolean z5, String str, List<FerrySeatingSectionOverview> list, Point point, DepartureDirection direction) {
            Intrinsics.checkNotNullParameter(direction, "direction");
            this.isLoading = z5;
            this.selectedFloorImageUrl = str;
            this.ferrySections = list;
            this.focusPoint = point;
            this.direction = direction;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, String str, List list, Point point, DepartureDirection departureDirection, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 2) != 0) {
                str = viewState.selectedFloorImageUrl;
            }
            String str2 = str;
            if ((i5 & 4) != 0) {
                list = viewState.ferrySections;
            }
            List list2 = list;
            if ((i5 & 8) != 0) {
                point = viewState.focusPoint;
            }
            Point point2 = point;
            if ((i5 & 16) != 0) {
                departureDirection = viewState.direction;
            }
            return viewState.copy(z5, str2, list2, point2, departureDirection);
        }

        public final ViewState copy(boolean isLoading, String selectedFloorImageUrl, List<FerrySeatingSectionOverview> ferrySections, Point focusPoint, DepartureDirection direction) {
            Intrinsics.checkNotNullParameter(direction, "direction");
            return new ViewState(isLoading, selectedFloorImageUrl, ferrySections, focusPoint, direction);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.selectedFloorImageUrl, viewState.selectedFloorImageUrl) && Intrinsics.areEqual(this.ferrySections, viewState.ferrySections) && Intrinsics.areEqual(this.focusPoint, viewState.focusPoint) && this.direction == viewState.direction;
        }

        public final DepartureDirection getDirection() {
            return this.direction;
        }

        public final List<FerrySeatingSectionOverview> getFerrySections() {
            return this.ferrySections;
        }

        public final Point getFocusPoint() {
            return this.focusPoint;
        }

        public final String getSelectedFloorImageUrl() {
            return this.selectedFloorImageUrl;
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.isLoading) * 31;
            String str = this.selectedFloorImageUrl;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            List<FerrySeatingSectionOverview> list = this.ferrySections;
            int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
            Point point = this.focusPoint;
            return ((hashCode3 + (point != null ? point.hashCode() : 0)) * 31) + this.direction.hashCode();
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", selectedFloorImageUrl=" + this.selectedFloorImageUrl + ", ferrySections=" + this.ferrySections + ", focusPoint=" + this.focusPoint + ", direction=" + this.direction + ")";
        }

        public /* synthetic */ ViewState(boolean z5, String str, List list, Point point, DepartureDirection departureDirection, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? true : z5, (i5 & 2) != 0 ? null : str, (i5 & 4) != 0 ? null : list, (i5 & 8) != 0 ? null : point, departureDirection);
        }
    }
}
