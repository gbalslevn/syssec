package dk.molslinjen.domain.localstorage.saleOnBoardOrders;

import android.content.Context;
import dk.molslinjen.domain.localstorage.base.FileCollectionRepository;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/domain/localstorage/saleOnBoardOrders/SaleOnBoardOrdersRepository;", "Ldk/molslinjen/domain/localstorage/saleOnBoardOrders/ISaleOnBoardOrdersRepository;", "Ldk/molslinjen/domain/localstorage/base/FileCollectionRepository;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getOrders", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "add", BuildConfig.FLAVOR, "order", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardOrdersRepository extends FileCollectionRepository<SaleOnBoardOrder> implements ISaleOnBoardOrdersRepository {
    private Mutex mutex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardOrdersRepository(Context appContext) {
        super(appContext, "sale_on_board_orders_v2.json", SaleOnBoardOrder.INSTANCE.serializer());
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0071 A[PHI: r7
      0x0071: PHI (r7v9 java.lang.Object) = (r7v8 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x006e, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.localstorage.saleOnBoardOrders.ISaleOnBoardOrdersRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object add(SaleOnBoardOrder saleOnBoardOrder, Continuation<? super Boolean> continuation) {
        SaleOnBoardOrdersRepository$add$1 saleOnBoardOrdersRepository$add$1;
        int i5;
        SaleOnBoardOrder saleOnBoardOrder2;
        SaleOnBoardOrdersRepository saleOnBoardOrdersRepository;
        if (continuation instanceof SaleOnBoardOrdersRepository$add$1) {
            saleOnBoardOrdersRepository$add$1 = (SaleOnBoardOrdersRepository$add$1) continuation;
            int i6 = saleOnBoardOrdersRepository$add$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                saleOnBoardOrdersRepository$add$1.label = i6 - Integer.MIN_VALUE;
                Object obj = saleOnBoardOrdersRepository$add$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = saleOnBoardOrdersRepository$add$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    saleOnBoardOrdersRepository$add$1.L$0 = saleOnBoardOrder;
                    saleOnBoardOrdersRepository$add$1.L$1 = this;
                    saleOnBoardOrdersRepository$add$1.label = 1;
                    obj = getOrders(saleOnBoardOrdersRepository$add$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    saleOnBoardOrder2 = saleOnBoardOrder;
                    saleOnBoardOrdersRepository = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    saleOnBoardOrdersRepository = (SaleOnBoardOrdersRepository) saleOnBoardOrdersRepository$add$1.L$1;
                    saleOnBoardOrder2 = (SaleOnBoardOrder) saleOnBoardOrdersRepository$add$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                List sortedWith = CollectionsKt.sortedWith(CollectionsKt.plus((Collection<? extends SaleOnBoardOrder>) obj, saleOnBoardOrder2), new Comparator() { // from class: dk.molslinjen.domain.localstorage.saleOnBoardOrders.SaleOnBoardOrdersRepository$add$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t5, T t6) {
                        return ComparisonsKt.compareValues(((SaleOnBoardOrder) t5).getStartDateTime(), ((SaleOnBoardOrder) t6).getStartDateTime());
                    }
                });
                saleOnBoardOrdersRepository$add$1.L$0 = null;
                saleOnBoardOrdersRepository$add$1.L$1 = null;
                saleOnBoardOrdersRepository$add$1.label = 2;
                obj = saleOnBoardOrdersRepository.save(sortedWith, saleOnBoardOrdersRepository$add$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        saleOnBoardOrdersRepository$add$1 = new SaleOnBoardOrdersRepository$add$1(this, continuation);
        Object obj2 = saleOnBoardOrdersRepository$add$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = saleOnBoardOrdersRepository$add$1.label;
        if (i5 != 0) {
        }
        List sortedWith2 = CollectionsKt.sortedWith(CollectionsKt.plus((Collection<? extends SaleOnBoardOrder>) obj2, saleOnBoardOrder2), new Comparator() { // from class: dk.molslinjen.domain.localstorage.saleOnBoardOrders.SaleOnBoardOrdersRepository$add$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                return ComparisonsKt.compareValues(((SaleOnBoardOrder) t5).getStartDateTime(), ((SaleOnBoardOrder) t6).getStartDateTime());
            }
        });
        saleOnBoardOrdersRepository$add$1.L$0 = null;
        saleOnBoardOrdersRepository$add$1.L$1 = null;
        saleOnBoardOrdersRepository$add$1.label = 2;
        obj2 = saleOnBoardOrdersRepository.save(sortedWith2, saleOnBoardOrdersRepository$add$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    @Override // dk.molslinjen.domain.localstorage.saleOnBoardOrders.ISaleOnBoardOrdersRepository
    public Object getOrders(Continuation<? super List<SaleOnBoardOrder>> continuation) {
        return get(continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009d A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x0030, B:14:0x00ca, B:22:0x004c, B:23:0x008b, B:24:0x0096, B:26:0x009d, B:33:0x00b8, B:28:0x00b2), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b8 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x0030, B:14:0x00ca, B:22:0x004c, B:23:0x008b, B:24:0x0096, B:26:0x009d, B:33:0x00b8, B:28:0x00b2), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r14v0, types: [dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v8, types: [kotlinx.coroutines.sync.Mutex] */
    @Override // dk.molslinjen.domain.localstorage.saleOnBoardOrders.ISaleOnBoardOrdersRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object update(SaleOnBoardOrder saleOnBoardOrder, Continuation<? super Unit> continuation) {
        SaleOnBoardOrdersRepository$update$1 saleOnBoardOrdersRepository$update$1;
        Object coroutine_suspended;
        int i5;
        Mutex mutex;
        SaleOnBoardOrdersRepository saleOnBoardOrdersRepository;
        SaleOnBoardOrder saleOnBoardOrder2;
        Object orders;
        SaleOnBoardOrdersRepository saleOnBoardOrdersRepository2;
        SaleOnBoardOrder saleOnBoardOrder3;
        Mutex mutex2;
        Iterator it;
        int i6;
        try {
            try {
                if (continuation instanceof SaleOnBoardOrdersRepository$update$1) {
                    saleOnBoardOrdersRepository$update$1 = (SaleOnBoardOrdersRepository$update$1) continuation;
                    int i7 = saleOnBoardOrdersRepository$update$1.label;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        saleOnBoardOrdersRepository$update$1.label = i7 - Integer.MIN_VALUE;
                        Object obj = saleOnBoardOrdersRepository$update$1.result;
                        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i5 = saleOnBoardOrdersRepository$update$1.label;
                        if (i5 != 0) {
                            ResultKt.throwOnFailure(obj);
                            mutex = this.mutex;
                            saleOnBoardOrdersRepository$update$1.L$0 = this;
                            saleOnBoardOrdersRepository$update$1.L$1 = saleOnBoardOrder;
                            saleOnBoardOrdersRepository$update$1.L$2 = mutex;
                            saleOnBoardOrdersRepository$update$1.label = 1;
                            if (mutex.lock(null, saleOnBoardOrdersRepository$update$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            saleOnBoardOrdersRepository = this;
                            saleOnBoardOrder2 = saleOnBoardOrder;
                        } else {
                            if (i5 != 1) {
                                if (i5 != 2) {
                                    if (i5 != 3) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    Mutex mutex3 = (Mutex) saleOnBoardOrdersRepository$update$1.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    saleOnBoardOrder = mutex3;
                                    Unit unit = Unit.INSTANCE;
                                    saleOnBoardOrder.unlock(null);
                                    return Unit.INSTANCE;
                                }
                                Mutex mutex4 = (Mutex) saleOnBoardOrdersRepository$update$1.L$2;
                                saleOnBoardOrder3 = (SaleOnBoardOrder) saleOnBoardOrdersRepository$update$1.L$1;
                                saleOnBoardOrdersRepository2 = (SaleOnBoardOrdersRepository) saleOnBoardOrdersRepository$update$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                mutex2 = mutex4;
                                List mutableList = CollectionsKt.toMutableList((Collection) obj);
                                it = mutableList.iterator();
                                i6 = 0;
                                while (true) {
                                    if (it.hasNext()) {
                                        i6 = -1;
                                        break;
                                    }
                                    if (Intrinsics.areEqual(((SaleOnBoardOrder) it.next()).getOrderNumber(), saleOnBoardOrder3.getOrderNumber())) {
                                        break;
                                    }
                                    i6++;
                                }
                                if (i6 != -1) {
                                    saleOnBoardOrder = mutex2;
                                } else {
                                    mutableList.set(i6, saleOnBoardOrder3);
                                    saleOnBoardOrdersRepository$update$1.L$0 = mutex2;
                                    saleOnBoardOrdersRepository$update$1.L$1 = null;
                                    saleOnBoardOrdersRepository$update$1.L$2 = null;
                                    saleOnBoardOrdersRepository$update$1.label = 3;
                                    saleOnBoardOrder = mutex2;
                                    if (saleOnBoardOrdersRepository2.save(mutableList, saleOnBoardOrdersRepository$update$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                Unit unit2 = Unit.INSTANCE;
                                saleOnBoardOrder.unlock(null);
                                return Unit.INSTANCE;
                            }
                            Mutex mutex5 = (Mutex) saleOnBoardOrdersRepository$update$1.L$2;
                            SaleOnBoardOrder saleOnBoardOrder4 = (SaleOnBoardOrder) saleOnBoardOrdersRepository$update$1.L$1;
                            saleOnBoardOrdersRepository = (SaleOnBoardOrdersRepository) saleOnBoardOrdersRepository$update$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            mutex = mutex5;
                            saleOnBoardOrder2 = saleOnBoardOrder4;
                        }
                        saleOnBoardOrdersRepository$update$1.L$0 = saleOnBoardOrdersRepository;
                        saleOnBoardOrdersRepository$update$1.L$1 = saleOnBoardOrder2;
                        saleOnBoardOrdersRepository$update$1.L$2 = mutex;
                        saleOnBoardOrdersRepository$update$1.label = 2;
                        orders = saleOnBoardOrdersRepository.getOrders(saleOnBoardOrdersRepository$update$1);
                        if (orders != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        saleOnBoardOrdersRepository2 = saleOnBoardOrdersRepository;
                        saleOnBoardOrder3 = saleOnBoardOrder2;
                        mutex2 = mutex;
                        obj = orders;
                        List mutableList2 = CollectionsKt.toMutableList((Collection) obj);
                        it = mutableList2.iterator();
                        i6 = 0;
                        while (true) {
                            if (it.hasNext()) {
                            }
                            i6++;
                        }
                        if (i6 != -1) {
                        }
                        Unit unit22 = Unit.INSTANCE;
                        saleOnBoardOrder.unlock(null);
                        return Unit.INSTANCE;
                    }
                }
                saleOnBoardOrdersRepository$update$1.L$0 = saleOnBoardOrdersRepository;
                saleOnBoardOrdersRepository$update$1.L$1 = saleOnBoardOrder2;
                saleOnBoardOrdersRepository$update$1.L$2 = mutex;
                saleOnBoardOrdersRepository$update$1.label = 2;
                orders = saleOnBoardOrdersRepository.getOrders(saleOnBoardOrdersRepository$update$1);
                if (orders != coroutine_suspended) {
                }
            } catch (Throwable th) {
                Mutex mutex6 = mutex;
                th = th;
                saleOnBoardOrder = mutex6;
                saleOnBoardOrder.unlock(null);
                throw th;
            }
            if (i5 != 0) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        saleOnBoardOrdersRepository$update$1 = new SaleOnBoardOrdersRepository$update$1(this, continuation);
        Object obj2 = saleOnBoardOrdersRepository$update$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = saleOnBoardOrdersRepository$update$1.label;
    }
}
