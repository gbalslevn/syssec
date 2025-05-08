package dk.molslinjen.ui.views.screens.booking.addons.seating.select;

import androidx.compose.ui.geometry.Offset;
import dk.molslinjen.domain.managers.seating.ISelectSeatingManager;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerryFloorPlan;
import uniffi.molslinjen_shared.FerrySeatingSection;
import uniffi.molslinjen_shared.FerrySeatingSectionDetails;
import uniffi.molslinjen_shared.FerrySeatingSectionId;
import uniffi.molslinjen_shared.SelectSeatingHelperInterface;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupFerryDataListener$1", f = "FerrySectionSeatsViewModel.kt", l = {81}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class FerrySectionSeatsViewModel$setupFerryDataListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FerrySectionSeatsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "selectedFloor", "Luniffi/molslinjen_shared/FerryFloorPlan;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupFerryDataListener$1$1", f = "FerrySectionSeatsViewModel.kt", l = {82}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupFerryDataListener$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<FerryFloorPlan, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FerrySectionSeatsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FerrySectionSeatsViewModel ferrySectionSeatsViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = ferrySectionSeatsViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x004f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            FerryFloorPlan ferryFloorPlan;
            FerrySeatingSectionId ferrySeatingSectionId;
            ISelectSeatingManager iSelectSeatingManager;
            Object activeSection;
            FerryFloorPlan ferryFloorPlan2;
            FerrySeatingSectionDetails ferrySeatingSectionDetails;
            Offset m3449getFocusPointx9fifI;
            MutableStateFlow mutableStateFlow;
            Object value;
            FerrySeatingSection ferrySeatingSection;
            SelectSeatingHelperInterface selectSeatingHelperInterface;
            float f5;
            List<FerrySeatingSection> sections;
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                ferryFloorPlan = (FerryFloorPlan) this.L$0;
                ferrySeatingSectionId = this.this$0.navSectionId;
                if (ferrySeatingSectionId == null) {
                    iSelectSeatingManager = this.this$0.seatReservationManager;
                    this.L$0 = ferryFloorPlan;
                    this.label = 1;
                    activeSection = iSelectSeatingManager.activeSection(this);
                    if (activeSection == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ferryFloorPlan2 = ferryFloorPlan;
                }
                if (ferrySeatingSectionId != null) {
                    FerrySectionSeatsViewModel ferrySectionSeatsViewModel = this.this$0;
                    if (ferryFloorPlan == null || (sections = ferryFloorPlan.getSections()) == null) {
                        ferrySeatingSection = null;
                    } else {
                        Iterator<T> it = sections.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            if (Intrinsics.areEqual(((FerrySeatingSection) obj2).getId(), ferrySeatingSectionId)) {
                                break;
                            }
                        }
                        ferrySeatingSection = (FerrySeatingSection) obj2;
                    }
                    if (ferrySeatingSection != null) {
                        selectSeatingHelperInterface = ferrySectionSeatsViewModel.selectSeatingHelper;
                        double m3451getSeatSizeD9Ej5fM = FerrySectionSeatsViewModel.INSTANCE.m3451getSeatSizeD9Ej5fM();
                        f5 = ferrySectionSeatsViewModel.dpScaling;
                        ferrySeatingSectionDetails = selectSeatingHelperInterface.toDetails(ferrySeatingSection, m3451getSeatSizeD9Ej5fM * f5);
                        m3449getFocusPointx9fifI = this.this$0.m3449getFocusPointx9fifI(ferrySeatingSectionDetails != null ? ferrySeatingSectionDetails.getSize() : null);
                        mutableStateFlow = this.this$0._viewState;
                        do {
                            value = mutableStateFlow.getValue();
                        } while (!mutableStateFlow.compareAndSet(value, FerrySectionSeatsViewModel.ViewState.m3453copyBn6Y4c$default((FerrySectionSeatsViewModel.ViewState) value, false, null, ferrySeatingSectionDetails, null, null, false, null, false, false, m3449getFocusPointx9fifI, null, 1531, null)));
                        return Unit.INSTANCE;
                    }
                }
                ferrySeatingSectionDetails = null;
                m3449getFocusPointx9fifI = this.this$0.m3449getFocusPointx9fifI(ferrySeatingSectionDetails != null ? ferrySeatingSectionDetails.getSize() : null);
                mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, FerrySectionSeatsViewModel.ViewState.m3453copyBn6Y4c$default((FerrySectionSeatsViewModel.ViewState) value, false, null, ferrySeatingSectionDetails, null, null, false, null, false, false, m3449getFocusPointx9fifI, null, 1531, null)));
                return Unit.INSTANCE;
            }
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ferryFloorPlan2 = (FerryFloorPlan) this.L$0;
            ResultKt.throwOnFailure(obj);
            activeSection = obj;
            FerrySeatingSection ferrySeatingSection2 = (FerrySeatingSection) activeSection;
            if (ferrySeatingSection2 != null) {
                ferrySeatingSectionId = ferrySeatingSection2.getId();
                ferryFloorPlan = ferryFloorPlan2;
            } else {
                ferryFloorPlan = ferryFloorPlan2;
                ferrySeatingSectionId = null;
            }
            if (ferrySeatingSectionId != null) {
            }
            ferrySeatingSectionDetails = null;
            m3449getFocusPointx9fifI = this.this$0.m3449getFocusPointx9fifI(ferrySeatingSectionDetails != null ? ferrySeatingSectionDetails.getSize() : null);
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, FerrySectionSeatsViewModel.ViewState.m3453copyBn6Y4c$default((FerrySectionSeatsViewModel.ViewState) value, false, null, ferrySeatingSectionDetails, null, null, false, null, false, false, m3449getFocusPointx9fifI, null, 1531, null)));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FerryFloorPlan ferryFloorPlan, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(ferryFloorPlan, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FerrySectionSeatsViewModel$setupFerryDataListener$1(FerrySectionSeatsViewModel ferrySectionSeatsViewModel, Continuation<? super FerrySectionSeatsViewModel$setupFerryDataListener$1> continuation) {
        super(2, continuation);
        this.this$0 = ferrySectionSeatsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FerrySectionSeatsViewModel$setupFerryDataListener$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISelectSeatingManager iSelectSeatingManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iSelectSeatingManager = this.this$0.seatReservationManager;
            StateFlow<FerryFloorPlan> selectedFloorPlan = iSelectSeatingManager.getSelectedFloorPlan();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (FlowKt.collectLatest(selectedFloorPlan, anonymousClass1, this) == coroutine_suspended) {
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
        return ((FerrySectionSeatsViewModel$setupFerryDataListener$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
