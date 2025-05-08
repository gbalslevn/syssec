package dk.molslinjen.domain.managers.saleOnBoard;

import dk.molslinjen.api.extensions.ApiResultExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.saleOnBoard.ISaleOnBoardService;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.localstorage.saleOnBoardOrders.ISaleOnBoardOrdersRepository;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001!B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c2\u0006\u0010\u001d\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J(\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00170\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017H\u0096@¢\u0006\u0002\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardManager;", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;", "saleOnBoardService", "Ldk/molslinjen/api/services/saleOnBoard/ISaleOnBoardService;", "saleOnBoardOrdersRepository", "Ldk/molslinjen/domain/localstorage/saleOnBoardOrders/ISaleOnBoardOrdersRepository;", "<init>", "(Ldk/molslinjen/api/services/saleOnBoard/ISaleOnBoardService;Ldk/molslinjen/domain/localstorage/saleOnBoardOrders/ISaleOnBoardOrdersRepository;)V", "saleOnBoardState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardManager$SaleOnBoardState;", "getSaleOnBoardState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "addOrder", BuildConfig.FLAVOR, "order", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOrdersInState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSaleOnBoardOrders", BuildConfig.FLAVOR, "timeTableId", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelOrder", "Ldk/molslinjen/domain/managers/ManagerResult;", "saleOnBoardOrder", "updateStatusForOrders", "orders", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SaleOnBoardState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardManager implements ISaleOnBoardManager {
    private final CoroutineScope coroutineScope;
    private final ISaleOnBoardOrdersRepository saleOnBoardOrdersRepository;
    private final ISaleOnBoardService saleOnBoardService;
    private final MutableStateFlow<SaleOnBoardState> saleOnBoardState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager$1", f = "SaleOnBoardManager.kt", l = {27}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x004d A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x004b -> B:5:0x004e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 1
                if (r1 == 0) goto L25
                if (r1 != r2) goto L1d
                java.lang.Object r1 = r7.L$3
                dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager$SaleOnBoardState r1 = (dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager.SaleOnBoardState) r1
                java.lang.Object r3 = r7.L$2
                java.lang.Object r4 = r7.L$1
                dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager r4 = (dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager) r4
                java.lang.Object r5 = r7.L$0
                kotlinx.coroutines.flow.MutableStateFlow r5 = (kotlinx.coroutines.flow.MutableStateFlow) r5
                kotlin.ResultKt.throwOnFailure(r8)
                goto L4e
            L1d:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L25:
                kotlin.ResultKt.throwOnFailure(r8)
                dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager r8 = dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager.this
                kotlinx.coroutines.flow.MutableStateFlow r8 = r8.getSaleOnBoardState()
                dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager r1 = dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager.this
                r5 = r8
                r4 = r1
            L32:
                java.lang.Object r3 = r5.getValue()
                r1 = r3
                dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager$SaleOnBoardState r1 = (dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager.SaleOnBoardState) r1
                dk.molslinjen.domain.localstorage.saleOnBoardOrders.ISaleOnBoardOrdersRepository r8 = dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager.access$getSaleOnBoardOrdersRepository$p(r4)
                r7.L$0 = r5
                r7.L$1 = r4
                r7.L$2 = r3
                r7.L$3 = r1
                r7.label = r2
                java.lang.Object r8 = r8.getOrders(r7)
                if (r8 != r0) goto L4e
                return r0
            L4e:
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager$1$invokeSuspend$lambda$1$$inlined$sortedBy$1 r6 = new dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager$1$invokeSuspend$lambda$1$$inlined$sortedBy$1
                r6.<init>()
                java.util.List r8 = kotlin.collections.CollectionsKt.sortedWith(r8, r6)
                dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager$SaleOnBoardState r8 = r1.copy(r8)
                boolean r8 = r5.compareAndSet(r3, r8)
                if (r8 == 0) goto L32
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SaleOnBoardManager(ISaleOnBoardService saleOnBoardService, ISaleOnBoardOrdersRepository saleOnBoardOrdersRepository) {
        Intrinsics.checkNotNullParameter(saleOnBoardService, "saleOnBoardService");
        Intrinsics.checkNotNullParameter(saleOnBoardOrdersRepository, "saleOnBoardOrdersRepository");
        this.saleOnBoardService = saleOnBoardService;
        this.saleOnBoardOrdersRepository = saleOnBoardOrdersRepository;
        this.saleOnBoardState = StateFlowKt.MutableStateFlow(new SaleOnBoardState(null, 1, 0 == true ? 1 : 0));
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.coroutineScope = CoroutineScope;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateOrdersInState(Continuation<? super Unit> continuation) {
        SaleOnBoardManager$updateOrdersInState$1 saleOnBoardManager$updateOrdersInState$1;
        int i5;
        SaleOnBoardManager saleOnBoardManager;
        List<SaleOnBoardOrder> list;
        MutableStateFlow<SaleOnBoardState> saleOnBoardState;
        SaleOnBoardState value;
        if (continuation instanceof SaleOnBoardManager$updateOrdersInState$1) {
            saleOnBoardManager$updateOrdersInState$1 = (SaleOnBoardManager$updateOrdersInState$1) continuation;
            int i6 = saleOnBoardManager$updateOrdersInState$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                saleOnBoardManager$updateOrdersInState$1.label = i6 - Integer.MIN_VALUE;
                Object obj = saleOnBoardManager$updateOrdersInState$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = saleOnBoardManager$updateOrdersInState$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ISaleOnBoardOrdersRepository iSaleOnBoardOrdersRepository = this.saleOnBoardOrdersRepository;
                    saleOnBoardManager$updateOrdersInState$1.L$0 = this;
                    saleOnBoardManager$updateOrdersInState$1.label = 1;
                    obj = iSaleOnBoardOrdersRepository.getOrders(saleOnBoardManager$updateOrdersInState$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    saleOnBoardManager = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    saleOnBoardManager = (SaleOnBoardManager) saleOnBoardManager$updateOrdersInState$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                list = (List) obj;
                saleOnBoardState = saleOnBoardManager.getSaleOnBoardState();
                do {
                    value = saleOnBoardState.getValue();
                } while (!saleOnBoardState.compareAndSet(value, value.copy(list)));
                return Unit.INSTANCE;
            }
        }
        saleOnBoardManager$updateOrdersInState$1 = new SaleOnBoardManager$updateOrdersInState$1(this, continuation);
        Object obj2 = saleOnBoardManager$updateOrdersInState$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = saleOnBoardManager$updateOrdersInState$1.label;
        if (i5 != 0) {
        }
        list = (List) obj2;
        saleOnBoardState = saleOnBoardManager.getSaleOnBoardState();
        do {
            value = saleOnBoardState.getValue();
        } while (!saleOnBoardState.compareAndSet(value, value.copy(list)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object addOrder(SaleOnBoardOrder saleOnBoardOrder, Continuation<? super Unit> continuation) {
        SaleOnBoardManager$addOrder$1 saleOnBoardManager$addOrder$1;
        Object coroutine_suspended;
        int i5;
        SaleOnBoardManager saleOnBoardManager;
        if (continuation instanceof SaleOnBoardManager$addOrder$1) {
            saleOnBoardManager$addOrder$1 = (SaleOnBoardManager$addOrder$1) continuation;
            int i6 = saleOnBoardManager$addOrder$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                saleOnBoardManager$addOrder$1.label = i6 - Integer.MIN_VALUE;
                Object obj = saleOnBoardManager$addOrder$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = saleOnBoardManager$addOrder$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ISaleOnBoardOrdersRepository iSaleOnBoardOrdersRepository = this.saleOnBoardOrdersRepository;
                    saleOnBoardManager$addOrder$1.L$0 = this;
                    saleOnBoardManager$addOrder$1.label = 1;
                    if (iSaleOnBoardOrdersRepository.add(saleOnBoardOrder, saleOnBoardManager$addOrder$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    saleOnBoardManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    saleOnBoardManager = (SaleOnBoardManager) saleOnBoardManager$addOrder$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                saleOnBoardManager$addOrder$1.L$0 = null;
                saleOnBoardManager$addOrder$1.label = 2;
                if (saleOnBoardManager.updateOrdersInState(saleOnBoardManager$addOrder$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        saleOnBoardManager$addOrder$1 = new SaleOnBoardManager$addOrder$1(this, continuation);
        Object obj2 = saleOnBoardManager$addOrder$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = saleOnBoardManager$addOrder$1.label;
        if (i5 != 0) {
        }
        saleOnBoardManager$addOrder$1.L$0 = null;
        saleOnBoardManager$addOrder$1.label = 2;
        if (saleOnBoardManager.updateOrdersInState(saleOnBoardManager$addOrder$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object cancelOrder(SaleOnBoardOrder saleOnBoardOrder, Continuation<? super ManagerResult<Unit>> continuation) {
        SaleOnBoardManager$cancelOrder$1 saleOnBoardManager$cancelOrder$1;
        Object coroutine_suspended;
        int i5;
        SaleOnBoardManager saleOnBoardManager;
        ApiResult apiResult;
        SaleOnBoardManager$cancelOrder$2 saleOnBoardManager$cancelOrder$2;
        ApiResult apiResult2;
        if (continuation instanceof SaleOnBoardManager$cancelOrder$1) {
            saleOnBoardManager$cancelOrder$1 = (SaleOnBoardManager$cancelOrder$1) continuation;
            int i6 = saleOnBoardManager$cancelOrder$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                saleOnBoardManager$cancelOrder$1.label = i6 - Integer.MIN_VALUE;
                Object obj = saleOnBoardManager$cancelOrder$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = saleOnBoardManager$cancelOrder$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ISaleOnBoardService iSaleOnBoardService = this.saleOnBoardService;
                    String orderNumber = saleOnBoardOrder.getOrderNumber();
                    saleOnBoardManager$cancelOrder$1.L$0 = this;
                    saleOnBoardManager$cancelOrder$1.L$1 = saleOnBoardOrder;
                    saleOnBoardManager$cancelOrder$1.label = 1;
                    obj = iSaleOnBoardService.cancelOrder(orderNumber, saleOnBoardManager$cancelOrder$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    saleOnBoardManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        apiResult2 = (ApiResult) saleOnBoardManager$cancelOrder$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return ManagerResultExtensionsKt.toManagerResult(apiResult2);
                    }
                    saleOnBoardOrder = (SaleOnBoardOrder) saleOnBoardManager$cancelOrder$1.L$1;
                    saleOnBoardManager = (SaleOnBoardManager) saleOnBoardManager$cancelOrder$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                apiResult = (ApiResult) obj;
                saleOnBoardManager$cancelOrder$2 = new SaleOnBoardManager$cancelOrder$2(saleOnBoardManager, saleOnBoardOrder, null);
                saleOnBoardManager$cancelOrder$1.L$0 = apiResult;
                saleOnBoardManager$cancelOrder$1.L$1 = null;
                saleOnBoardManager$cancelOrder$1.label = 2;
                if (ApiResultExtensionsKt.onSuccess(apiResult, saleOnBoardManager$cancelOrder$2, saleOnBoardManager$cancelOrder$1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiResult2 = apiResult;
                return ManagerResultExtensionsKt.toManagerResult(apiResult2);
            }
        }
        saleOnBoardManager$cancelOrder$1 = new SaleOnBoardManager$cancelOrder$1(this, continuation);
        Object obj2 = saleOnBoardManager$cancelOrder$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = saleOnBoardManager$cancelOrder$1.label;
        if (i5 != 0) {
        }
        apiResult = (ApiResult) obj2;
        saleOnBoardManager$cancelOrder$2 = new SaleOnBoardManager$cancelOrder$2(saleOnBoardManager, saleOnBoardOrder, null);
        saleOnBoardManager$cancelOrder$1.L$0 = apiResult;
        saleOnBoardManager$cancelOrder$1.L$1 = null;
        saleOnBoardManager$cancelOrder$1.label = 2;
        if (ApiResultExtensionsKt.onSuccess(apiResult, saleOnBoardManager$cancelOrder$2, saleOnBoardManager$cancelOrder$1) != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getSaleOnBoardOrders(String str, Continuation<? super List<SaleOnBoardOrder>> continuation) {
        SaleOnBoardManager$getSaleOnBoardOrders$1 saleOnBoardManager$getSaleOnBoardOrders$1;
        int i5;
        if (continuation instanceof SaleOnBoardManager$getSaleOnBoardOrders$1) {
            saleOnBoardManager$getSaleOnBoardOrders$1 = (SaleOnBoardManager$getSaleOnBoardOrders$1) continuation;
            int i6 = saleOnBoardManager$getSaleOnBoardOrders$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                saleOnBoardManager$getSaleOnBoardOrders$1.label = i6 - Integer.MIN_VALUE;
                Object obj = saleOnBoardManager$getSaleOnBoardOrders$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = saleOnBoardManager$getSaleOnBoardOrders$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ISaleOnBoardOrdersRepository iSaleOnBoardOrdersRepository = this.saleOnBoardOrdersRepository;
                    saleOnBoardManager$getSaleOnBoardOrders$1.L$0 = str;
                    saleOnBoardManager$getSaleOnBoardOrders$1.label = 1;
                    obj = iSaleOnBoardOrdersRepository.getOrders(saleOnBoardManager$getSaleOnBoardOrders$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) saleOnBoardManager$getSaleOnBoardOrders$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : (Iterable) obj) {
                    if (Intrinsics.areEqual(((SaleOnBoardOrder) obj2).getDeparture().getTimeTableId(), str)) {
                        arrayList.add(obj2);
                    }
                }
                return arrayList;
            }
        }
        saleOnBoardManager$getSaleOnBoardOrders$1 = new SaleOnBoardManager$getSaleOnBoardOrders$1(this, continuation);
        Object obj3 = saleOnBoardManager$getSaleOnBoardOrders$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = saleOnBoardManager$getSaleOnBoardOrders$1.label;
        if (i5 != 0) {
        }
        ArrayList arrayList2 = new ArrayList();
        while (r6.hasNext()) {
        }
        return arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00b1 -> B:18:0x0070). Please report as a decompilation issue!!! */
    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateStatusForOrders(List<SaleOnBoardOrder> list, Continuation<? super ManagerResult<? extends List<SaleOnBoardOrder>>> continuation) {
        SaleOnBoardManager$updateStatusForOrders$1 saleOnBoardManager$updateStatusForOrders$1;
        int i5;
        ArrayList arrayList;
        Iterator<SaleOnBoardOrder> it;
        SaleOnBoardManager saleOnBoardManager;
        SaleOnBoardOrder saleOnBoardOrder;
        SaleOnBoardManager saleOnBoardManager2;
        ArrayList arrayList2;
        Iterator<SaleOnBoardOrder> it2;
        SaleOnBoardManager$updateStatusForOrders$2 saleOnBoardManager$updateStatusForOrders$2;
        List list2;
        if (continuation instanceof SaleOnBoardManager$updateStatusForOrders$1) {
            saleOnBoardManager$updateStatusForOrders$1 = (SaleOnBoardManager$updateStatusForOrders$1) continuation;
            int i6 = saleOnBoardManager$updateStatusForOrders$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                saleOnBoardManager$updateStatusForOrders$1.label = i6 - Integer.MIN_VALUE;
                Object obj = saleOnBoardManager$updateStatusForOrders$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = saleOnBoardManager$updateStatusForOrders$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    arrayList = new ArrayList();
                    it = list.iterator();
                    saleOnBoardManager = this;
                } else if (i5 == 1) {
                    saleOnBoardOrder = (SaleOnBoardOrder) saleOnBoardManager$updateStatusForOrders$1.L$3;
                    it2 = (Iterator) saleOnBoardManager$updateStatusForOrders$1.L$2;
                    ?? r7 = (List) saleOnBoardManager$updateStatusForOrders$1.L$1;
                    saleOnBoardManager2 = (SaleOnBoardManager) saleOnBoardManager$updateStatusForOrders$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    arrayList2 = r7;
                    saleOnBoardManager$updateStatusForOrders$2 = new SaleOnBoardManager$updateStatusForOrders$2(saleOnBoardOrder, arrayList2, saleOnBoardManager2, null);
                    saleOnBoardManager$updateStatusForOrders$1.L$0 = saleOnBoardManager2;
                    saleOnBoardManager$updateStatusForOrders$1.L$1 = arrayList2;
                    saleOnBoardManager$updateStatusForOrders$1.L$2 = it2;
                    saleOnBoardManager$updateStatusForOrders$1.L$3 = null;
                    saleOnBoardManager$updateStatusForOrders$1.label = 2;
                    if (ApiResultExtensionsKt.onSuccess((ApiResult) obj, saleOnBoardManager$updateStatusForOrders$2, saleOnBoardManager$updateStatusForOrders$1) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it = it2;
                    arrayList = arrayList2;
                    saleOnBoardManager = saleOnBoardManager2;
                } else {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        list2 = (List) saleOnBoardManager$updateStatusForOrders$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return new ManagerResult.Success(list2);
                    }
                    it = (Iterator) saleOnBoardManager$updateStatusForOrders$1.L$2;
                    ?? r22 = (List) saleOnBoardManager$updateStatusForOrders$1.L$1;
                    SaleOnBoardManager saleOnBoardManager3 = (SaleOnBoardManager) saleOnBoardManager$updateStatusForOrders$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    arrayList = r22;
                    saleOnBoardManager = saleOnBoardManager3;
                }
                if (it.hasNext()) {
                    saleOnBoardManager$updateStatusForOrders$1.L$0 = arrayList;
                    saleOnBoardManager$updateStatusForOrders$1.L$1 = null;
                    saleOnBoardManager$updateStatusForOrders$1.L$2 = null;
                    saleOnBoardManager$updateStatusForOrders$1.label = 3;
                    if (saleOnBoardManager.updateOrdersInState(saleOnBoardManager$updateStatusForOrders$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list2 = arrayList;
                    return new ManagerResult.Success(list2);
                }
                SaleOnBoardOrder next = it.next();
                ISaleOnBoardService iSaleOnBoardService = saleOnBoardManager.saleOnBoardService;
                String orderNumber = next.getOrderNumber();
                saleOnBoardManager$updateStatusForOrders$1.L$0 = saleOnBoardManager;
                saleOnBoardManager$updateStatusForOrders$1.L$1 = arrayList;
                saleOnBoardManager$updateStatusForOrders$1.L$2 = it;
                saleOnBoardManager$updateStatusForOrders$1.L$3 = next;
                saleOnBoardManager$updateStatusForOrders$1.label = 1;
                Object orderStatus = iSaleOnBoardService.getOrderStatus(orderNumber, saleOnBoardManager$updateStatusForOrders$1);
                if (orderStatus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                SaleOnBoardManager saleOnBoardManager4 = saleOnBoardManager;
                it2 = it;
                saleOnBoardOrder = next;
                arrayList2 = arrayList;
                obj = orderStatus;
                saleOnBoardManager2 = saleOnBoardManager4;
                saleOnBoardManager$updateStatusForOrders$2 = new SaleOnBoardManager$updateStatusForOrders$2(saleOnBoardOrder, arrayList2, saleOnBoardManager2, null);
                saleOnBoardManager$updateStatusForOrders$1.L$0 = saleOnBoardManager2;
                saleOnBoardManager$updateStatusForOrders$1.L$1 = arrayList2;
                saleOnBoardManager$updateStatusForOrders$1.L$2 = it2;
                saleOnBoardManager$updateStatusForOrders$1.L$3 = null;
                saleOnBoardManager$updateStatusForOrders$1.label = 2;
                if (ApiResultExtensionsKt.onSuccess((ApiResult) obj, saleOnBoardManager$updateStatusForOrders$2, saleOnBoardManager$updateStatusForOrders$1) != coroutine_suspended) {
                }
            }
        }
        saleOnBoardManager$updateStatusForOrders$1 = new SaleOnBoardManager$updateStatusForOrders$1(this, continuation);
        Object obj2 = saleOnBoardManager$updateStatusForOrders$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = saleOnBoardManager$updateStatusForOrders$1.label;
        if (i5 != 0) {
        }
        if (it.hasNext()) {
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardManager$SaleOnBoardState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "orders", "<init>", "(Ljava/util/List;)V", "copy", "(Ljava/util/List;)Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardManager$SaleOnBoardState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getOrders", "()Ljava/util/List;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SaleOnBoardState {
        private final List<SaleOnBoardOrder> orders;

        public SaleOnBoardState(List<SaleOnBoardOrder> orders) {
            Intrinsics.checkNotNullParameter(orders, "orders");
            this.orders = orders;
        }

        public final SaleOnBoardState copy(List<SaleOnBoardOrder> orders) {
            Intrinsics.checkNotNullParameter(orders, "orders");
            return new SaleOnBoardState(orders);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SaleOnBoardState) && Intrinsics.areEqual(this.orders, ((SaleOnBoardState) other).orders);
        }

        public final List<SaleOnBoardOrder> getOrders() {
            return this.orders;
        }

        public int hashCode() {
            return this.orders.hashCode();
        }

        public String toString() {
            return "SaleOnBoardState(orders=" + this.orders + ")";
        }

        public /* synthetic */ SaleOnBoardState(List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? CollectionsKt.emptyList() : list);
        }
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardManager
    public MutableStateFlow<SaleOnBoardState> getSaleOnBoardState() {
        return this.saleOnBoardState;
    }
}
