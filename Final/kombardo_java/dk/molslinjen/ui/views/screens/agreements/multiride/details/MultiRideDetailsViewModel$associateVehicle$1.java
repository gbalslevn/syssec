package dk.molslinjen.ui.views.screens.agreements.multiride.details;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideAssociatedVehicle;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import java.util.Collection;
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
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$associateVehicle$1", f = "MultiRideDetailsViewModel.kt", l = {83, 87}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class MultiRideDetailsViewModel$associateVehicle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ UserVehicle $vehicle;
    int label;
    final /* synthetic */ MultiRideDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideDetailsViewModel$associateVehicle$1(MultiRideDetailsViewModel multiRideDetailsViewModel, String str, UserVehicle userVehicle, Continuation<? super MultiRideDetailsViewModel$associateVehicle$1> continuation) {
        super(2, continuation);
        this.this$0 = multiRideDetailsViewModel;
        this.$id = str;
        this.$vehicle = userVehicle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiRideDetailsViewModel$associateVehicle$1(this.this$0, this.$id, this.$vehicle, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISnackbarService iSnackbarService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            List<MultiRideAssociatedVehicle> associatedVehicles = this.this$0.getViewState().getValue().getAssociatedVehicles();
            if (associatedVehicles != null) {
                List<MultiRideAssociatedVehicle> list = associatedVehicles;
                UserVehicle userVehicle = this.$vehicle;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(((MultiRideAssociatedVehicle) it.next()).getLicensePlate(), userVehicle.getLicensePlate())) {
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
            IMultiRideManager iMultiRideManager = this.this$0.multiRideManager;
            String str = this.$id;
            String licensePlate = this.$vehicle.getLicensePlate();
            String name = this.$vehicle.getName();
            this.label = 1;
            obj = iMultiRideManager.associateVehicle(str, licensePlate, name, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.loadVehicles();
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        iSnackbarService = this.this$0.snackbarService;
        this.label = 2;
        if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.loadVehicles();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MultiRideDetailsViewModel$associateVehicle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
