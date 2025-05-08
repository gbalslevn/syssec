package dk.molslinjen.domain.managers.saleOnBoard;

import dk.molslinjen.api.services.saleOnBoard.response.ShopAndProductsResponseDTO;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStore;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStore;", "it", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager$loadShopsAndProducts$2", f = "SaleOnBoardCheckoutManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardCheckoutManager$loadShopsAndProducts$2 extends SuspendLambda implements Function2<ShopAndProductsResponseDTO, Continuation<? super List<? extends SaleOnBoardStore>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SaleOnBoardCheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardCheckoutManager$loadShopsAndProducts$2(SaleOnBoardCheckoutManager saleOnBoardCheckoutManager, Continuation<? super SaleOnBoardCheckoutManager$loadShopsAndProducts$2> continuation) {
        super(2, continuation);
        this.this$0 = saleOnBoardCheckoutManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SaleOnBoardCheckoutManager$loadShopsAndProducts$2 saleOnBoardCheckoutManager$loadShopsAndProducts$2 = new SaleOnBoardCheckoutManager$loadShopsAndProducts$2(this.this$0, continuation);
        saleOnBoardCheckoutManager$loadShopsAndProducts$2.L$0 = obj;
        return saleOnBoardCheckoutManager$loadShopsAndProducts$2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ShopAndProductsResponseDTO shopAndProductsResponseDTO, Continuation<? super List<SaleOnBoardStore>> continuation) {
        return ((SaleOnBoardCheckoutManager$loadShopsAndProducts$2) create(shopAndProductsResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<ShopAndProductsResponseDTO.StoreResponseDTO> stores = ((ShopAndProductsResponseDTO) this.L$0).getStores();
        SaleOnBoardCheckoutManager saleOnBoardCheckoutManager = this.this$0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(stores, 10));
        Iterator<T> it = stores.iterator();
        while (it.hasNext()) {
            arrayList.add(new SaleOnBoardStore((ShopAndProductsResponseDTO.StoreResponseDTO) it.next(), saleOnBoardCheckoutManager.getSaleOnBoardCheckoutState().getValue().getCurrencyType()));
        }
        return arrayList;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ShopAndProductsResponseDTO shopAndProductsResponseDTO, Continuation<? super List<? extends SaleOnBoardStore>> continuation) {
        return invoke2(shopAndProductsResponseDTO, (Continuation<? super List<SaleOnBoardStore>>) continuation);
    }
}
