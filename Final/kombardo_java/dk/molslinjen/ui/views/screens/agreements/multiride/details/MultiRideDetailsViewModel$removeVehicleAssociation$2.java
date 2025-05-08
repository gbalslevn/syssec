package dk.molslinjen.ui.views.screens.agreements.multiride.details;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideAssociatedVehicle;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel;
import java.util.ArrayList;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$removeVehicleAssociation$2", f = "MultiRideDetailsViewModel.kt", l = {112, 113, 114}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class MultiRideDetailsViewModel$removeVehicleAssociation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MultiRideAssociatedVehicle $vehicle;
    int label;
    final /* synthetic */ MultiRideDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$removeVehicleAssociation$2$1", f = "MultiRideDetailsViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$removeVehicleAssociation$2$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        final /* synthetic */ MultiRideAssociatedVehicle $vehicle;
        int label;
        final /* synthetic */ MultiRideDetailsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MultiRideDetailsViewModel multiRideDetailsViewModel, MultiRideAssociatedVehicle multiRideAssociatedVehicle, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = multiRideDetailsViewModel;
            this.$vehicle = multiRideAssociatedVehicle;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$vehicle, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object value;
            MultiRideDetailsViewModel.ViewState viewState;
            ArrayList arrayList;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MutableStateFlow mutableStateFlow = this.this$0._viewState;
            MultiRideAssociatedVehicle multiRideAssociatedVehicle = this.$vehicle;
            do {
                value = mutableStateFlow.getValue();
                viewState = (MultiRideDetailsViewModel.ViewState) value;
                List<MultiRideAssociatedVehicle> associatedVehicles = viewState.getAssociatedVehicles();
                if (associatedVehicles != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : associatedVehicles) {
                        if (!Intrinsics.areEqual(((MultiRideAssociatedVehicle) obj2).getLicensePlate(), multiRideAssociatedVehicle.getLicensePlate())) {
                            arrayList2.add(obj2);
                        }
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = null;
                }
            } while (!mutableStateFlow.compareAndSet(value, MultiRideDetailsViewModel.ViewState.copy$default(viewState, null, null, false, arrayList, false, null, false, null, 247, null)));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideDetailsViewModel$removeVehicleAssociation$2(MultiRideDetailsViewModel multiRideDetailsViewModel, MultiRideAssociatedVehicle multiRideAssociatedVehicle, Continuation<? super MultiRideDetailsViewModel$removeVehicleAssociation$2> continuation) {
        super(2, continuation);
        this.this$0 = multiRideDetailsViewModel;
        this.$vehicle = multiRideAssociatedVehicle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiRideDetailsViewModel$removeVehicleAssociation$2(this.this$0, this.$vehicle, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ISnackbarService iSnackbarService;
        AnonymousClass1 anonymousClass1;
        MutableStateFlow mutableStateFlow;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            IMultiRideManager iMultiRideManager = this.this$0.multiRideManager;
            String multiRideId = this.this$0.getMultiRideId();
            String licensePlate = this.$vehicle.getLicensePlate();
            this.label = 1;
            obj = iMultiRideManager.removeVehicleAssociation(multiRideId, licensePlate, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    mutableStateFlow = this.this$0._viewState;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, MultiRideDetailsViewModel.ViewState.copy$default((MultiRideDetailsViewModel.ViewState) value, null, null, false, null, false, null, false, null, 207, null)));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                anonymousClass1 = new AnonymousClass1(this.this$0, this.$vehicle, null);
                this.label = 3;
                if (ManagerResultExtensionsKt.onSuccess((ManagerResult) obj, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, MultiRideDetailsViewModel.ViewState.copy$default((MultiRideDetailsViewModel.ViewState) value, null, null, false, null, false, null, false, null, 207, null)));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        iSnackbarService = this.this$0.snackbarService;
        this.label = 2;
        obj = dk.molslinjen.extensions.ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        anonymousClass1 = new AnonymousClass1(this.this$0, this.$vehicle, null);
        this.label = 3;
        if (ManagerResultExtensionsKt.onSuccess((ManagerResult) obj, anonymousClass1, this) == coroutine_suspended) {
        }
        mutableStateFlow = this.this$0._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, MultiRideDetailsViewModel.ViewState.copy$default((MultiRideDetailsViewModel.ViewState) value, null, null, false, null, false, null, false, null, 207, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MultiRideDetailsViewModel$removeVehicleAssociation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
