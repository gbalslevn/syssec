package androidx.datastore.core;

import androidx.datastore.core.DataStoreImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$incrementCollector$2$1", f = "DataStoreImpl.kt", l = {134, 135}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataStoreImpl$incrementCollector$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$incrementCollector$2$1(DataStoreImpl<T> dataStoreImpl, Continuation<? super DataStoreImpl$incrementCollector$2$1> continuation) {
        super(2, continuation);
        this.this$0 = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataStoreImpl$incrementCollector$2$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DataStoreImpl.InitDataStore initDataStore;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            initDataStore = ((DataStoreImpl) this.this$0).readAndInit;
            this.label = 1;
            if (initDataStore.awaitComplete(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        Flow conflate = FlowKt.conflate(this.this$0.getCoordinator().getUpdateNotifications());
        final DataStoreImpl<T> dataStoreImpl = this.this$0;
        FlowCollector flowCollector = new FlowCollector() { // from class: androidx.datastore.core.DataStoreImpl$incrementCollector$2$1.1
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                return emit((Unit) obj2, (Continuation<? super Unit>) continuation);
            }

            public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                Object readDataAndUpdateCache;
                if (!(((DataStoreImpl) dataStoreImpl).inMemoryCache.getCurrentState() instanceof Final)) {
                    readDataAndUpdateCache = dataStoreImpl.readDataAndUpdateCache(true, continuation);
                    return readDataAndUpdateCache == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readDataAndUpdateCache : Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        };
        this.label = 2;
        if (conflate.collect(flowCollector, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DataStoreImpl$incrementCollector$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
