package dk.molslinjen.domain.managers.agreement.multiride;

import dk.molslinjen.api.services.multiRide.response.MultiRideVehicleResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRideVehiclesResponseDTO;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideAssociatedVehicle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideAssociatedVehicle;", "it", "Ldk/molslinjen/api/services/multiRide/response/MultiRideVehiclesResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$getVehiclesForMultiRideCard$2", f = "MultiRideManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class MultiRideManager$getVehiclesForMultiRideCard$2 extends SuspendLambda implements Function2<MultiRideVehiclesResponseDTO, Continuation<? super List<? extends MultiRideAssociatedVehicle>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiRideManager$getVehiclesForMultiRideCard$2(Continuation<? super MultiRideManager$getVehiclesForMultiRideCard$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MultiRideManager$getVehiclesForMultiRideCard$2 multiRideManager$getVehiclesForMultiRideCard$2 = new MultiRideManager$getVehiclesForMultiRideCard$2(continuation);
        multiRideManager$getVehiclesForMultiRideCard$2.L$0 = obj;
        return multiRideManager$getVehiclesForMultiRideCard$2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(MultiRideVehiclesResponseDTO multiRideVehiclesResponseDTO, Continuation<? super List<MultiRideAssociatedVehicle>> continuation) {
        return ((MultiRideManager$getVehiclesForMultiRideCard$2) create(multiRideVehiclesResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<MultiRideVehicleResponseDTO> numberPlates = ((MultiRideVehiclesResponseDTO) this.L$0).getNumberPlates();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(numberPlates, 10));
        Iterator<T> it = numberPlates.iterator();
        while (it.hasNext()) {
            arrayList.add(new MultiRideAssociatedVehicle((MultiRideVehicleResponseDTO) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(MultiRideVehiclesResponseDTO multiRideVehiclesResponseDTO, Continuation<? super List<? extends MultiRideAssociatedVehicle>> continuation) {
        return invoke2(multiRideVehiclesResponseDTO, (Continuation<? super List<MultiRideAssociatedVehicle>>) continuation);
    }
}
