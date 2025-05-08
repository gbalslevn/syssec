package dk.molslinjen.domain.managers.saleOnBoard;

import dk.molslinjen.api.services.saleOnBoard.response.TimeSlotsResponseDTO;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStoreTimeSlots;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStoreTimeSlots;", "it", "Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager$loadTimeSlots$2", f = "SaleOnBoardCheckoutManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardCheckoutManager$loadTimeSlots$2 extends SuspendLambda implements Function2<TimeSlotsResponseDTO, Continuation<? super List<? extends SaleOnBoardStoreTimeSlots>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardCheckoutManager$loadTimeSlots$2(Continuation<? super SaleOnBoardCheckoutManager$loadTimeSlots$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SaleOnBoardCheckoutManager$loadTimeSlots$2 saleOnBoardCheckoutManager$loadTimeSlots$2 = new SaleOnBoardCheckoutManager$loadTimeSlots$2(continuation);
        saleOnBoardCheckoutManager$loadTimeSlots$2.L$0 = obj;
        return saleOnBoardCheckoutManager$loadTimeSlots$2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(TimeSlotsResponseDTO timeSlotsResponseDTO, Continuation<? super List<SaleOnBoardStoreTimeSlots>> continuation) {
        return ((SaleOnBoardCheckoutManager$loadTimeSlots$2) create(timeSlotsResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<TimeSlotsResponseDTO.StoreTimeSlotsResponseDTO> stores = ((TimeSlotsResponseDTO) this.L$0).getStores();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(stores, 10));
        Iterator<T> it = stores.iterator();
        while (it.hasNext()) {
            arrayList.add(new SaleOnBoardStoreTimeSlots((TimeSlotsResponseDTO.StoreTimeSlotsResponseDTO) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(TimeSlotsResponseDTO timeSlotsResponseDTO, Continuation<? super List<? extends SaleOnBoardStoreTimeSlots>> continuation) {
        return invoke2(timeSlotsResponseDTO, (Continuation<? super List<SaleOnBoardStoreTimeSlots>>) continuation);
    }
}
