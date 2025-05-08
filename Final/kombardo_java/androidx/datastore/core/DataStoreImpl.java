package androidx.datastore.core;

import androidx.datastore.core.Message;
import androidx.datastore.core.UpdatingDataContextElement;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 ]*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0002]^Ba\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00120\b\u0002\u0010\u000b\u001a*\u0012&\u0012$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00060\u0005\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J4\u0010\u0013\u001a\u00028\u00002\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0080@¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u001e\u0010\u001dJ\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010\u001f\u001a\u00020\u0016H\u0082@¢\u0006\u0004\b!\u0010\"J\u001e\u0010%\u001a\u00020\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0082@¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\tH\u0082@¢\u0006\u0004\b'\u0010\u001dJ\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010\u001f\u001a\u00020\u0016H\u0082@¢\u0006\u0004\b(\u0010\"J\u0010\u0010)\u001a\u00028\u0000H\u0082@¢\u0006\u0004\b)\u0010\u001dJ<\u0010,\u001a\u00028\u00002\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00062\u0006\u0010+\u001a\u00020*H\u0082@¢\u0006\u0004\b,\u0010-J\u001e\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/2\u0006\u0010.\u001a\u00020\u0016H\u0082@¢\u0006\u0004\b0\u0010\"JI\u00104\u001a\u00028\u0001\"\u0004\b\u0001\u001012\u0006\u0010.\u001a\u00020\u00162\u001c\u00103\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\n02H\u0082@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b4\u00105R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00106R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u00107R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u00108R \u0010:\u001a\b\u0012\u0004\u0012\u00028\u0000098\u0016X\u0096\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001e\u0010J\u001a\f0IR\b\u0012\u0004\u0012\u00028\u00000\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR \u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000M0L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001b\u0010T\u001a\u00020P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010O\u001a\u0004\bR\u0010SR \u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR!\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000M8@X\u0080\u0084\u0002¢\u0006\f\u001a\u0004\bX\u0010Y*\u0004\bZ\u0010[¨\u0006_"}, d2 = {"Landroidx/datastore/core/DataStoreImpl;", "T", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/core/Storage;", "storage", BuildConfig.FLAVOR, "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "initTasksList", "Landroidx/datastore/core/CorruptionHandler;", "corruptionHandler", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Landroidx/datastore/core/Storage;Ljava/util/List;Landroidx/datastore/core/CorruptionHandler;Lkotlinx/coroutines/CoroutineScope;)V", "transform", "updateData", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newData", BuildConfig.FLAVOR, "updateCache", BuildConfig.FLAVOR, "writeData$datastore_core_release", "(Ljava/lang/Object;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeData", "incrementCollector", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decrementCollector", "requireLock", "Landroidx/datastore/core/State;", "readState", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/datastore/core/Message$Update;", "update", "handleUpdate", "(Landroidx/datastore/core/Message$Update;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAndInitOrPropagateAndThrowFailure", "readDataAndUpdateCache", "readDataFromFileOrDefault", "Lkotlin/coroutines/CoroutineContext;", "callerContext", "transformAndWrite", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasWriteFileLock", "Landroidx/datastore/core/Data;", "readDataOrHandleCorruption", "R", "Lkotlin/Function1;", "block", "doWithWriteFileLock", "(ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/datastore/core/Storage;", "Landroidx/datastore/core/CorruptionHandler;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/Flow;", "data", "Lkotlinx/coroutines/flow/Flow;", "getData", "()Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/sync/Mutex;", "collectorMutex", "Lkotlinx/coroutines/sync/Mutex;", "collectorCounter", "I", "Lkotlinx/coroutines/Job;", "collectorJob", "Lkotlinx/coroutines/Job;", "Landroidx/datastore/core/DataStoreInMemoryCache;", "inMemoryCache", "Landroidx/datastore/core/DataStoreInMemoryCache;", "Landroidx/datastore/core/DataStoreImpl$InitDataStore;", "readAndInit", "Landroidx/datastore/core/DataStoreImpl$InitDataStore;", "Lkotlin/Lazy;", "Landroidx/datastore/core/StorageConnection;", "storageConnectionDelegate", "Lkotlin/Lazy;", "Landroidx/datastore/core/InterProcessCoordinator;", "coordinator$delegate", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "coordinator", "Landroidx/datastore/core/SimpleActor;", "writeActor", "Landroidx/datastore/core/SimpleActor;", "getStorageConnection$datastore_core_release", "()Landroidx/datastore/core/StorageConnection;", "getStorageConnection$datastore_core_release$delegate", "(Landroidx/datastore/core/DataStoreImpl;)Ljava/lang/Object;", "storageConnection", "Companion", "InitDataStore", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DataStoreImpl<T> implements DataStore<T> {
    private static final String BUG_MESSAGE = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542";
    private int collectorCounter;
    private Job collectorJob;
    private final Mutex collectorMutex;

    /* renamed from: coordinator$delegate, reason: from kotlin metadata */
    private final Lazy coordinator;
    private final CorruptionHandler<T> corruptionHandler;
    private final Flow<T> data;
    private final DataStoreInMemoryCache<T> inMemoryCache;
    private final DataStoreImpl<T>.InitDataStore readAndInit;
    private final CoroutineScope scope;
    private final Storage<T> storage;
    private final Lazy<StorageConnection<T>> storageConnectionDelegate;
    private final SimpleActor<Message.Update<T>> writeActor;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B7\u0012.\u0010\b\u001a*\u0012&\u0012$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00030\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0006H\u0094@¢\u0006\u0004\b\u000b\u0010\fR@\u0010\r\u001a,\u0012&\u0012$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/datastore/core/DataStoreImpl$InitDataStore;", "Landroidx/datastore/core/RunOnce;", BuildConfig.FLAVOR, "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "initTasksList", "<init>", "(Landroidx/datastore/core/DataStoreImpl;Ljava/util/List;)V", "doRun", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initTasks", "Ljava/util/List;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class InitDataStore extends RunOnce {
        private List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasks;
        final /* synthetic */ DataStoreImpl<T> this$0;

        public InitDataStore(DataStoreImpl dataStoreImpl, List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasksList) {
            Intrinsics.checkNotNullParameter(initTasksList, "initTasksList");
            this.this$0 = dataStoreImpl;
            this.initTasks = CollectionsKt.toList(initTasksList);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        @Override // androidx.datastore.core.RunOnce
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object doRun(Continuation<? super Unit> continuation) {
            DataStoreImpl$InitDataStore$doRun$1 dataStoreImpl$InitDataStore$doRun$1;
            int i5;
            InitDataStore initDataStore;
            Data data;
            if (continuation instanceof DataStoreImpl$InitDataStore$doRun$1) {
                dataStoreImpl$InitDataStore$doRun$1 = (DataStoreImpl$InitDataStore$doRun$1) continuation;
                int i6 = dataStoreImpl$InitDataStore$doRun$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    dataStoreImpl$InitDataStore$doRun$1.label = i6 - Integer.MIN_VALUE;
                    Object obj = dataStoreImpl$InitDataStore$doRun$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = dataStoreImpl$InitDataStore$doRun$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> list = this.initTasks;
                        if (list != null) {
                            Intrinsics.checkNotNull(list);
                            if (!list.isEmpty()) {
                                InterProcessCoordinator coordinator = this.this$0.getCoordinator();
                                DataStoreImpl$InitDataStore$doRun$initData$1 dataStoreImpl$InitDataStore$doRun$initData$1 = new DataStoreImpl$InitDataStore$doRun$initData$1(this.this$0, this, null);
                                dataStoreImpl$InitDataStore$doRun$1.L$0 = this;
                                dataStoreImpl$InitDataStore$doRun$1.label = 2;
                                obj = coordinator.lock(dataStoreImpl$InitDataStore$doRun$initData$1, dataStoreImpl$InitDataStore$doRun$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                initDataStore = this;
                                data = (Data) obj;
                            }
                        }
                        DataStoreImpl<T> dataStoreImpl = this.this$0;
                        dataStoreImpl$InitDataStore$doRun$1.L$0 = this;
                        dataStoreImpl$InitDataStore$doRun$1.label = 1;
                        obj = dataStoreImpl.readDataOrHandleCorruption(false, dataStoreImpl$InitDataStore$doRun$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        initDataStore = this;
                        data = (Data) obj;
                    } else if (i5 == 1) {
                        initDataStore = (InitDataStore) dataStoreImpl$InitDataStore$doRun$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        data = (Data) obj;
                    } else {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        initDataStore = (InitDataStore) dataStoreImpl$InitDataStore$doRun$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        data = (Data) obj;
                    }
                    ((DataStoreImpl) initDataStore.this$0).inMemoryCache.tryUpdate(data);
                    return Unit.INSTANCE;
                }
            }
            dataStoreImpl$InitDataStore$doRun$1 = new DataStoreImpl$InitDataStore$doRun$1(this, continuation);
            Object obj2 = dataStoreImpl$InitDataStore$doRun$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i5 = dataStoreImpl$InitDataStore$doRun$1.label;
            if (i5 != 0) {
            }
            ((DataStoreImpl) initDataStore.this$0).inMemoryCache.tryUpdate(data);
            return Unit.INSTANCE;
        }
    }

    public DataStoreImpl(Storage<T> storage, List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasksList, CorruptionHandler<T> corruptionHandler, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(initTasksList, "initTasksList");
        Intrinsics.checkNotNullParameter(corruptionHandler, "corruptionHandler");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.storage = storage;
        this.corruptionHandler = corruptionHandler;
        this.scope = scope;
        this.data = FlowKt.flow(new DataStoreImpl$data$1(this, null));
        this.collectorMutex = MutexKt.Mutex$default(false, 1, null);
        this.inMemoryCache = new DataStoreInMemoryCache<>();
        this.readAndInit = new InitDataStore(this, initTasksList);
        this.storageConnectionDelegate = LazyKt.lazy(new Function0<StorageConnection<T>>(this) { // from class: androidx.datastore.core.DataStoreImpl$storageConnectionDelegate$1
            final /* synthetic */ DataStoreImpl<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final StorageConnection<T> invoke() {
                Storage storage2;
                storage2 = ((DataStoreImpl) this.this$0).storage;
                return storage2.createConnection();
            }
        });
        this.coordinator = LazyKt.lazy(new Function0<InterProcessCoordinator>(this) { // from class: androidx.datastore.core.DataStoreImpl$coordinator$2
            final /* synthetic */ DataStoreImpl<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InterProcessCoordinator invoke() {
                return this.this$0.getStorageConnection$datastore_core_release().getCoordinator();
            }
        });
        this.writeActor = new SimpleActor<>(scope, new Function1<Throwable, Unit>(this) { // from class: androidx.datastore.core.DataStoreImpl$writeActor$1
            final /* synthetic */ DataStoreImpl<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                if (th != null) {
                    ((DataStoreImpl) this.this$0).inMemoryCache.tryUpdate(new Final(th));
                }
                lazy = ((DataStoreImpl) this.this$0).storageConnectionDelegate;
                if (lazy.isInitialized()) {
                    this.this$0.getStorageConnection$datastore_core_release().close();
                }
            }
        }, new Function2<Message.Update<T>, Throwable, Unit>() { // from class: androidx.datastore.core.DataStoreImpl$writeActor$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Throwable th) {
                invoke((Message.Update) obj, th);
                return Unit.INSTANCE;
            }

            public final void invoke(Message.Update<T> msg, Throwable th) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                CompletableDeferred<T> ack = msg.getAck();
                if (th == null) {
                    th = new CancellationException("DataStore scope was cancelled before updateData could complete");
                }
                ack.completeExceptionally(th);
            }
        }, new DataStoreImpl$writeActor$3(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056 A[Catch: all -> 0x005e, TryCatch #0 {all -> 0x005e, blocks: (B:11:0x004e, B:13:0x0056, B:15:0x005a, B:16:0x0060, B:17:0x0062), top: B:10:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object decrementCollector(Continuation<? super Unit> continuation) {
        DataStoreImpl$decrementCollector$1 dataStoreImpl$decrementCollector$1;
        int i5;
        DataStoreImpl<T> dataStoreImpl;
        Mutex mutex;
        int i6;
        try {
            if (continuation instanceof DataStoreImpl$decrementCollector$1) {
                dataStoreImpl$decrementCollector$1 = (DataStoreImpl$decrementCollector$1) continuation;
                int i7 = dataStoreImpl$decrementCollector$1.label;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    dataStoreImpl$decrementCollector$1.label = i7 - Integer.MIN_VALUE;
                    Object obj = dataStoreImpl$decrementCollector$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = dataStoreImpl$decrementCollector$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex2 = this.collectorMutex;
                        dataStoreImpl$decrementCollector$1.L$0 = this;
                        dataStoreImpl$decrementCollector$1.L$1 = mutex2;
                        dataStoreImpl$decrementCollector$1.label = 1;
                        if (mutex2.lock(null, dataStoreImpl$decrementCollector$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dataStoreImpl = this;
                        mutex = mutex2;
                    } else {
                        if (i5 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutex = (Mutex) dataStoreImpl$decrementCollector$1.L$1;
                        dataStoreImpl = (DataStoreImpl) dataStoreImpl$decrementCollector$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    i6 = dataStoreImpl.collectorCounter - 1;
                    dataStoreImpl.collectorCounter = i6;
                    if (i6 == 0) {
                        Job job = dataStoreImpl.collectorJob;
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, null, 1, null);
                        }
                        dataStoreImpl.collectorJob = null;
                    }
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock(null);
                    return Unit.INSTANCE;
                }
            }
            i6 = dataStoreImpl.collectorCounter - 1;
            dataStoreImpl.collectorCounter = i6;
            if (i6 == 0) {
            }
            Unit unit2 = Unit.INSTANCE;
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
        dataStoreImpl$decrementCollector$1 = new DataStoreImpl$decrementCollector$1(this, continuation);
        Object obj2 = dataStoreImpl$decrementCollector$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = dataStoreImpl$decrementCollector$1.label;
        if (i5 != 0) {
        }
    }

    private final <R> Object doWithWriteFileLock(boolean z5, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        return z5 ? function1.invoke(continuation) : getCoordinator().lock(new DataStoreImpl$doWithWriteFileLock$3(function1, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterProcessCoordinator getCoordinator() {
        return (InterProcessCoordinator) this.coordinator.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(10:5|6|7|(5:(1:(1:(1:12)(2:19|20))(3:21|22|23))(1:28)|13|14|15|16)(4:29|30|31|(6:33|(1:35)|26|14|15|16)(3:36|(1:38)(1:54)|(2:40|(2:42|(1:44)(1:45))(2:46|47))(2:48|(2:50|51)(2:52|53))))|24|(1:27)|26|14|15|16))|59|6|7|(0)(0)|24|(0)|26|14|15|16|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0034, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.datastore.core.DataStoreImpl, java.lang.Object, androidx.datastore.core.DataStoreImpl<T>] */
    /* JADX WARN: Type inference failed for: r9v21, types: [kotlinx.coroutines.CompletableDeferred] */
    /* JADX WARN: Type inference failed for: r9v3, types: [kotlinx.coroutines.CompletableDeferred] */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleUpdate(Message.Update<T> update, Continuation<? super Unit> continuation) {
        DataStoreImpl$handleUpdate$1 dataStoreImpl$handleUpdate$1;
        Object coroutine_suspended;
        int i5;
        Object m3567constructorimpl;
        ?? r9;
        CompletableDeferred<T> ack;
        State<T> currentState;
        DataStoreImpl dataStoreImpl;
        Object transformAndWrite;
        Message.Update<T> update2;
        Message.Update<T> update3;
        if (continuation instanceof DataStoreImpl$handleUpdate$1) {
            dataStoreImpl$handleUpdate$1 = (DataStoreImpl$handleUpdate$1) continuation;
            int i6 = dataStoreImpl$handleUpdate$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                dataStoreImpl$handleUpdate$1.label = i6 - Integer.MIN_VALUE;
                Object obj = dataStoreImpl$handleUpdate$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = dataStoreImpl$handleUpdate$1.label;
                boolean z5 = true;
                if (i5 == 0) {
                    if (i5 == 1) {
                        update3 = (CompletableDeferred) dataStoreImpl$handleUpdate$1.L$0;
                    } else if (i5 == 2) {
                        CompletableDeferred<T> completableDeferred = (CompletableDeferred) dataStoreImpl$handleUpdate$1.L$2;
                        dataStoreImpl = (DataStoreImpl) dataStoreImpl$handleUpdate$1.L$1;
                        Message.Update<T> update4 = (Message.Update) dataStoreImpl$handleUpdate$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        ack = completableDeferred;
                        update2 = update4;
                    } else {
                        if (i5 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        update3 = (Message.Update<T>) ((CompletableDeferred) dataStoreImpl$handleUpdate$1.L$0);
                    }
                    ResultKt.throwOnFailure(obj);
                    update = update3;
                    m3567constructorimpl = Result.m3567constructorimpl(obj);
                    r9 = update;
                    CompletableDeferredKt.completeWith(r9, m3567constructorimpl);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                ack = update.getAck();
                try {
                    Result.Companion companion = Result.INSTANCE;
                    currentState = this.inMemoryCache.getCurrentState();
                } catch (Throwable th) {
                    th = th;
                    update = ack;
                    Result.Companion companion2 = Result.INSTANCE;
                    m3567constructorimpl = Result.m3567constructorimpl(ResultKt.createFailure(th));
                    r9 = update;
                    CompletableDeferredKt.completeWith(r9, m3567constructorimpl);
                    return Unit.INSTANCE;
                }
                if (currentState instanceof Data) {
                    Function2<T, Continuation<? super T>, Object> transform = update.getTransform();
                    CoroutineContext callerContext = update.getCallerContext();
                    dataStoreImpl$handleUpdate$1.L$0 = ack;
                    dataStoreImpl$handleUpdate$1.label = 1;
                    transformAndWrite = transformAndWrite(transform, callerContext, dataStoreImpl$handleUpdate$1);
                    if (transformAndWrite == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Message.Update<T> update5 = ack;
                    obj = transformAndWrite;
                    update = update5;
                    m3567constructorimpl = Result.m3567constructorimpl(obj);
                    r9 = update;
                    CompletableDeferredKt.completeWith(r9, m3567constructorimpl);
                    return Unit.INSTANCE;
                }
                if (!(currentState instanceof ReadException)) {
                    z5 = currentState instanceof UnInitialized;
                }
                if (!z5) {
                    if (currentState instanceof Final) {
                        throw ((Final) currentState).getFinalException();
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (currentState != update.getLastState()) {
                    Intrinsics.checkNotNull(currentState, "null cannot be cast to non-null type androidx.datastore.core.ReadException<T of androidx.datastore.core.DataStoreImpl.handleUpdate$lambda$2>");
                    throw ((ReadException) currentState).getReadException();
                }
                dataStoreImpl$handleUpdate$1.L$0 = update;
                dataStoreImpl$handleUpdate$1.L$1 = this;
                dataStoreImpl$handleUpdate$1.L$2 = ack;
                dataStoreImpl$handleUpdate$1.label = 2;
                if (readAndInitOrPropagateAndThrowFailure(dataStoreImpl$handleUpdate$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dataStoreImpl = this;
                update2 = update;
                Function2<T, Continuation<? super T>, Object> transform2 = update2.getTransform();
                CoroutineContext callerContext2 = update2.getCallerContext();
                dataStoreImpl$handleUpdate$1.L$0 = ack;
                dataStoreImpl$handleUpdate$1.L$1 = null;
                dataStoreImpl$handleUpdate$1.L$2 = null;
                dataStoreImpl$handleUpdate$1.label = 3;
                transformAndWrite = dataStoreImpl.transformAndWrite(transform2, callerContext2, dataStoreImpl$handleUpdate$1);
                if (transformAndWrite == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Message.Update<T> update52 = ack;
                obj = transformAndWrite;
                update = update52;
                m3567constructorimpl = Result.m3567constructorimpl(obj);
                r9 = update;
                CompletableDeferredKt.completeWith(r9, m3567constructorimpl);
                return Unit.INSTANCE;
            }
        }
        dataStoreImpl$handleUpdate$1 = new DataStoreImpl$handleUpdate$1(this, continuation);
        Object obj2 = dataStoreImpl$handleUpdate$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = dataStoreImpl$handleUpdate$1.label;
        boolean z52 = true;
        if (i5 == 0) {
        }
        Function2<T, Continuation<? super T>, Object> transform22 = update2.getTransform();
        CoroutineContext callerContext22 = update2.getCallerContext();
        dataStoreImpl$handleUpdate$1.L$0 = ack;
        dataStoreImpl$handleUpdate$1.L$1 = null;
        dataStoreImpl$handleUpdate$1.L$2 = null;
        dataStoreImpl$handleUpdate$1.label = 3;
        transformAndWrite = dataStoreImpl.transformAndWrite(transform22, callerContext22, dataStoreImpl$handleUpdate$1);
        if (transformAndWrite == coroutine_suspended) {
        }
        Message.Update<T> update522 = ack;
        obj2 = transformAndWrite;
        update = update522;
        m3567constructorimpl = Result.m3567constructorimpl(obj2);
        r9 = update;
        CompletableDeferredKt.completeWith(r9, m3567constructorimpl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0055 A[Catch: all -> 0x0067, TryCatch #0 {all -> 0x0067, blocks: (B:11:0x004e, B:13:0x0055, B:14:0x0069), top: B:10:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object incrementCollector(Continuation<? super Unit> continuation) {
        DataStoreImpl$incrementCollector$1 dataStoreImpl$incrementCollector$1;
        int i5;
        DataStoreImpl<T> dataStoreImpl;
        Mutex mutex;
        int i6;
        Job launch$default;
        try {
            if (continuation instanceof DataStoreImpl$incrementCollector$1) {
                dataStoreImpl$incrementCollector$1 = (DataStoreImpl$incrementCollector$1) continuation;
                int i7 = dataStoreImpl$incrementCollector$1.label;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    dataStoreImpl$incrementCollector$1.label = i7 - Integer.MIN_VALUE;
                    Object obj = dataStoreImpl$incrementCollector$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = dataStoreImpl$incrementCollector$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex2 = this.collectorMutex;
                        dataStoreImpl$incrementCollector$1.L$0 = this;
                        dataStoreImpl$incrementCollector$1.L$1 = mutex2;
                        dataStoreImpl$incrementCollector$1.label = 1;
                        if (mutex2.lock(null, dataStoreImpl$incrementCollector$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dataStoreImpl = this;
                        mutex = mutex2;
                    } else {
                        if (i5 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutex = (Mutex) dataStoreImpl$incrementCollector$1.L$1;
                        dataStoreImpl = (DataStoreImpl) dataStoreImpl$incrementCollector$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    i6 = dataStoreImpl.collectorCounter + 1;
                    dataStoreImpl.collectorCounter = i6;
                    if (i6 == 1) {
                        launch$default = BuildersKt__Builders_commonKt.launch$default(dataStoreImpl.scope, null, null, new DataStoreImpl$incrementCollector$2$1(dataStoreImpl, null), 3, null);
                        dataStoreImpl.collectorJob = launch$default;
                    }
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock(null);
                    return Unit.INSTANCE;
                }
            }
            i6 = dataStoreImpl.collectorCounter + 1;
            dataStoreImpl.collectorCounter = i6;
            if (i6 == 1) {
            }
            Unit unit2 = Unit.INSTANCE;
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
        dataStoreImpl$incrementCollector$1 = new DataStoreImpl$incrementCollector$1(this, continuation);
        Object obj2 = dataStoreImpl$incrementCollector$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = dataStoreImpl$incrementCollector$1.label;
        if (i5 != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readAndInitOrPropagateAndThrowFailure(Continuation<? super Unit> continuation) {
        DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1;
        Object coroutine_suspended;
        int i5;
        DataStoreImpl<T> dataStoreImpl;
        int intValue;
        int i6;
        Throwable th;
        DataStoreImpl<T> dataStoreImpl2;
        DataStoreImpl<T>.InitDataStore initDataStore;
        try {
            if (continuation instanceof DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1) {
                dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 = (DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1) continuation;
                int i7 = dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.label;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.label = i7 - Integer.MIN_VALUE;
                    Object obj = dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        InterProcessCoordinator coordinator = getCoordinator();
                        dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.L$0 = this;
                        dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.label = 1;
                        obj = coordinator.getVersion(dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dataStoreImpl = this;
                    } else {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            i6 = dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.I$0;
                            dataStoreImpl2 = (DataStoreImpl) dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            } catch (Throwable th2) {
                                th = th2;
                                dataStoreImpl2.inMemoryCache.tryUpdate(new ReadException(th, i6));
                                throw th;
                            }
                        }
                        dataStoreImpl = (DataStoreImpl) dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    intValue = ((Number) obj).intValue();
                    initDataStore = dataStoreImpl.readAndInit;
                    dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.L$0 = dataStoreImpl;
                    dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.I$0 = intValue;
                    dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.label = 2;
                    if (initDataStore.runIfNeeded(dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            }
            initDataStore = dataStoreImpl.readAndInit;
            dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.L$0 = dataStoreImpl;
            dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.I$0 = intValue;
            dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.label = 2;
            if (initDataStore.runIfNeeded(dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1) == coroutine_suspended) {
            }
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            i6 = intValue;
            th = th3;
            dataStoreImpl2 = dataStoreImpl;
            dataStoreImpl2.inMemoryCache.tryUpdate(new ReadException(th, i6));
            throw th;
        }
        dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 = new DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1(this, continuation);
        Object obj2 = dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = dataStoreImpl$readAndInitOrPropagateAndThrowFailure$1.label;
        if (i5 != 0) {
        }
        intValue = ((Number) obj2).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readDataAndUpdateCache(boolean z5, Continuation<? super State<T>> continuation) {
        DataStoreImpl$readDataAndUpdateCache$1 dataStoreImpl$readDataAndUpdateCache$1;
        int i5;
        State<T> state;
        Object obj;
        boolean z6;
        DataStoreImpl<T> dataStoreImpl;
        boolean z7;
        Pair pair;
        if (continuation instanceof DataStoreImpl$readDataAndUpdateCache$1) {
            dataStoreImpl$readDataAndUpdateCache$1 = (DataStoreImpl$readDataAndUpdateCache$1) continuation;
            int i6 = dataStoreImpl$readDataAndUpdateCache$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                dataStoreImpl$readDataAndUpdateCache$1.label = i6 - Integer.MIN_VALUE;
                Object obj2 = dataStoreImpl$readDataAndUpdateCache$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = dataStoreImpl$readDataAndUpdateCache$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    State<T> currentState = this.inMemoryCache.getCurrentState();
                    if (currentState instanceof UnInitialized) {
                        throw new IllegalStateException(BUG_MESSAGE);
                    }
                    InterProcessCoordinator coordinator = getCoordinator();
                    dataStoreImpl$readDataAndUpdateCache$1.L$0 = this;
                    dataStoreImpl$readDataAndUpdateCache$1.L$1 = currentState;
                    dataStoreImpl$readDataAndUpdateCache$1.Z$0 = z5;
                    dataStoreImpl$readDataAndUpdateCache$1.label = 1;
                    Object version = coordinator.getVersion(dataStoreImpl$readDataAndUpdateCache$1);
                    if (version == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    state = currentState;
                    obj = version;
                    z6 = z5;
                    dataStoreImpl = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            dataStoreImpl = (DataStoreImpl) dataStoreImpl$readDataAndUpdateCache$1.L$0;
                            ResultKt.throwOnFailure(obj2);
                            pair = (Pair) obj2;
                            State<T> state2 = (State) pair.component1();
                            if (((Boolean) pair.component2()).booleanValue()) {
                            }
                            return state2;
                        }
                        if (i5 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        dataStoreImpl = (DataStoreImpl) dataStoreImpl$readDataAndUpdateCache$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        pair = (Pair) obj2;
                        State<T> state22 = (State) pair.component1();
                        if (((Boolean) pair.component2()).booleanValue()) {
                            dataStoreImpl.inMemoryCache.tryUpdate(state22);
                        }
                        return state22;
                    }
                    boolean z8 = dataStoreImpl$readDataAndUpdateCache$1.Z$0;
                    State<T> state3 = (State) dataStoreImpl$readDataAndUpdateCache$1.L$1;
                    DataStoreImpl<T> dataStoreImpl2 = (DataStoreImpl) dataStoreImpl$readDataAndUpdateCache$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    z6 = z8;
                    dataStoreImpl = dataStoreImpl2;
                    state = state3;
                    obj = obj2;
                }
                int intValue = ((Number) obj).intValue();
                z7 = state instanceof Data;
                int version2 = !z7 ? state.getVersion() : -1;
                if (!z7 && intValue == version2) {
                    return state;
                }
                if (z6) {
                    InterProcessCoordinator coordinator2 = dataStoreImpl.getCoordinator();
                    DataStoreImpl$readDataAndUpdateCache$4 dataStoreImpl$readDataAndUpdateCache$4 = new DataStoreImpl$readDataAndUpdateCache$4(dataStoreImpl, version2, null);
                    dataStoreImpl$readDataAndUpdateCache$1.L$0 = dataStoreImpl;
                    dataStoreImpl$readDataAndUpdateCache$1.L$1 = null;
                    dataStoreImpl$readDataAndUpdateCache$1.label = 3;
                    obj2 = coordinator2.tryLock(dataStoreImpl$readDataAndUpdateCache$4, dataStoreImpl$readDataAndUpdateCache$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pair = (Pair) obj2;
                    State<T> state222 = (State) pair.component1();
                    if (((Boolean) pair.component2()).booleanValue()) {
                    }
                    return state222;
                }
                InterProcessCoordinator coordinator3 = dataStoreImpl.getCoordinator();
                DataStoreImpl$readDataAndUpdateCache$3 dataStoreImpl$readDataAndUpdateCache$3 = new DataStoreImpl$readDataAndUpdateCache$3(dataStoreImpl, null);
                dataStoreImpl$readDataAndUpdateCache$1.L$0 = dataStoreImpl;
                dataStoreImpl$readDataAndUpdateCache$1.L$1 = null;
                dataStoreImpl$readDataAndUpdateCache$1.label = 2;
                obj2 = coordinator3.lock(dataStoreImpl$readDataAndUpdateCache$3, dataStoreImpl$readDataAndUpdateCache$1);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pair = (Pair) obj2;
                State<T> state2222 = (State) pair.component1();
                if (((Boolean) pair.component2()).booleanValue()) {
                }
                return state2222;
            }
        }
        dataStoreImpl$readDataAndUpdateCache$1 = new DataStoreImpl$readDataAndUpdateCache$1(this, continuation);
        Object obj22 = dataStoreImpl$readDataAndUpdateCache$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = dataStoreImpl$readDataAndUpdateCache$1.label;
        if (i5 != 0) {
        }
        int intValue2 = ((Number) obj).intValue();
        z7 = state instanceof Data;
        if (!z7) {
        }
        if (!z7) {
        }
        if (z6) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readDataFromFileOrDefault(Continuation<? super T> continuation) {
        return StorageConnectionKt.readData(getStorageConnection$datastore_core_release(), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|85|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0067, code lost:
    
        r12 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0068, code lost:
    
        r7 = r2;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0023. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x014b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readDataOrHandleCorruption(boolean z5, Continuation<? super Data<T>> continuation) {
        DataStoreImpl$readDataOrHandleCorruption$1 dataStoreImpl$readDataOrHandleCorruption$1;
        ?? r22;
        DataStoreImpl<T> dataStoreImpl;
        Ref$ObjectRef ref$ObjectRef;
        Object handleCorruption;
        CorruptionException corruptionException;
        Ref$ObjectRef ref$ObjectRef2;
        CorruptionException corruptionException2;
        DataStoreImpl$readDataOrHandleCorruption$3 dataStoreImpl$readDataOrHandleCorruption$3;
        Ref$IntRef ref$IntRef;
        Ref$ObjectRef ref$ObjectRef3;
        DataStoreImpl<T> dataStoreImpl2;
        DataStoreImpl<T> dataStoreImpl3;
        int hashCode;
        Object version;
        boolean z6;
        int i5;
        Object obj;
        if (continuation instanceof DataStoreImpl$readDataOrHandleCorruption$1) {
            dataStoreImpl$readDataOrHandleCorruption$1 = (DataStoreImpl$readDataOrHandleCorruption$1) continuation;
            int i6 = dataStoreImpl$readDataOrHandleCorruption$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                dataStoreImpl$readDataOrHandleCorruption$1.label = i6 - Integer.MIN_VALUE;
                Object obj2 = (T) dataStoreImpl$readDataOrHandleCorruption$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                r22 = dataStoreImpl$readDataOrHandleCorruption$1.label;
                switch (r22) {
                    case 0:
                        ResultKt.throwOnFailure(obj2);
                        try {
                            if (!z5) {
                                InterProcessCoordinator coordinator = getCoordinator();
                                dataStoreImpl$readDataOrHandleCorruption$1.L$0 = this;
                                dataStoreImpl$readDataOrHandleCorruption$1.Z$0 = z5;
                                dataStoreImpl$readDataOrHandleCorruption$1.label = 3;
                                obj2 = (T) coordinator.getVersion(dataStoreImpl$readDataOrHandleCorruption$1);
                                if (obj2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                dataStoreImpl2 = this;
                                int intValue = ((Number) obj2).intValue();
                                InterProcessCoordinator coordinator2 = dataStoreImpl2.getCoordinator();
                                DataStoreImpl$readDataOrHandleCorruption$2 dataStoreImpl$readDataOrHandleCorruption$2 = new DataStoreImpl$readDataOrHandleCorruption$2(dataStoreImpl2, intValue, null);
                                dataStoreImpl$readDataOrHandleCorruption$1.L$0 = dataStoreImpl2;
                                dataStoreImpl$readDataOrHandleCorruption$1.Z$0 = z5;
                                dataStoreImpl$readDataOrHandleCorruption$1.label = 4;
                                obj2 = (T) coordinator2.tryLock(dataStoreImpl$readDataOrHandleCorruption$2, dataStoreImpl$readDataOrHandleCorruption$1);
                                if (obj2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return (Data) obj2;
                            }
                            dataStoreImpl$readDataOrHandleCorruption$1.L$0 = this;
                            dataStoreImpl$readDataOrHandleCorruption$1.Z$0 = z5;
                            dataStoreImpl$readDataOrHandleCorruption$1.label = 1;
                            obj2 = (T) readDataFromFileOrDefault(dataStoreImpl$readDataOrHandleCorruption$1);
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            dataStoreImpl3 = this;
                            if (obj2 == null) {
                                try {
                                    hashCode = obj2.hashCode();
                                } catch (CorruptionException e5) {
                                    e = e5;
                                    dataStoreImpl = dataStoreImpl3;
                                    ref$ObjectRef = new Ref$ObjectRef();
                                    CorruptionHandler<T> corruptionHandler = dataStoreImpl.corruptionHandler;
                                    dataStoreImpl$readDataOrHandleCorruption$1.L$0 = dataStoreImpl;
                                    dataStoreImpl$readDataOrHandleCorruption$1.L$1 = e;
                                    dataStoreImpl$readDataOrHandleCorruption$1.L$2 = ref$ObjectRef;
                                    dataStoreImpl$readDataOrHandleCorruption$1.L$3 = ref$ObjectRef;
                                    dataStoreImpl$readDataOrHandleCorruption$1.Z$0 = z5;
                                    dataStoreImpl$readDataOrHandleCorruption$1.label = 5;
                                    handleCorruption = corruptionHandler.handleCorruption(e, dataStoreImpl$readDataOrHandleCorruption$1);
                                    if (handleCorruption == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    corruptionException = e;
                                    obj2 = (T) handleCorruption;
                                    ref$ObjectRef2 = ref$ObjectRef;
                                    ref$ObjectRef2.element = (T) obj2;
                                    Ref$IntRef ref$IntRef2 = new Ref$IntRef();
                                    try {
                                        dataStoreImpl$readDataOrHandleCorruption$3 = new DataStoreImpl$readDataOrHandleCorruption$3(ref$ObjectRef, dataStoreImpl, ref$IntRef2, null);
                                        dataStoreImpl$readDataOrHandleCorruption$1.L$0 = corruptionException;
                                        dataStoreImpl$readDataOrHandleCorruption$1.L$1 = ref$ObjectRef;
                                        dataStoreImpl$readDataOrHandleCorruption$1.L$2 = ref$IntRef2;
                                        dataStoreImpl$readDataOrHandleCorruption$1.L$3 = null;
                                        dataStoreImpl$readDataOrHandleCorruption$1.label = 6;
                                        if (dataStoreImpl.doWithWriteFileLock(z5, dataStoreImpl$readDataOrHandleCorruption$3, dataStoreImpl$readDataOrHandleCorruption$1) != coroutine_suspended) {
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        corruptionException2 = corruptionException;
                                        ExceptionsKt.addSuppressed(corruptionException2, th);
                                        throw corruptionException2;
                                    }
                                }
                            } else {
                                hashCode = 0;
                            }
                            InterProcessCoordinator coordinator3 = dataStoreImpl3.getCoordinator();
                            dataStoreImpl$readDataOrHandleCorruption$1.L$0 = dataStoreImpl3;
                            dataStoreImpl$readDataOrHandleCorruption$1.L$1 = obj2;
                            dataStoreImpl$readDataOrHandleCorruption$1.Z$0 = z5;
                            dataStoreImpl$readDataOrHandleCorruption$1.I$0 = hashCode;
                            dataStoreImpl$readDataOrHandleCorruption$1.label = 2;
                            version = coordinator3.getVersion(dataStoreImpl$readDataOrHandleCorruption$1);
                            if (version != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            int i7 = hashCode;
                            z6 = z5;
                            i5 = i7;
                            obj = obj2;
                            obj2 = (T) version;
                            return new Data(obj, i5, ((Number) obj2).intValue());
                        } catch (CorruptionException e6) {
                            e = e6;
                            dataStoreImpl = this;
                            ref$ObjectRef = new Ref$ObjectRef();
                            CorruptionHandler<T> corruptionHandler2 = dataStoreImpl.corruptionHandler;
                            dataStoreImpl$readDataOrHandleCorruption$1.L$0 = dataStoreImpl;
                            dataStoreImpl$readDataOrHandleCorruption$1.L$1 = e;
                            dataStoreImpl$readDataOrHandleCorruption$1.L$2 = ref$ObjectRef;
                            dataStoreImpl$readDataOrHandleCorruption$1.L$3 = ref$ObjectRef;
                            dataStoreImpl$readDataOrHandleCorruption$1.Z$0 = z5;
                            dataStoreImpl$readDataOrHandleCorruption$1.label = 5;
                            handleCorruption = corruptionHandler2.handleCorruption(e, dataStoreImpl$readDataOrHandleCorruption$1);
                            if (handleCorruption == coroutine_suspended) {
                            }
                        }
                        break;
                    case 1:
                        z5 = dataStoreImpl$readDataOrHandleCorruption$1.Z$0;
                        DataStoreImpl<T> dataStoreImpl4 = (DataStoreImpl) dataStoreImpl$readDataOrHandleCorruption$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        dataStoreImpl3 = dataStoreImpl4;
                        if (obj2 == null) {
                        }
                        InterProcessCoordinator coordinator32 = dataStoreImpl3.getCoordinator();
                        dataStoreImpl$readDataOrHandleCorruption$1.L$0 = dataStoreImpl3;
                        dataStoreImpl$readDataOrHandleCorruption$1.L$1 = obj2;
                        dataStoreImpl$readDataOrHandleCorruption$1.Z$0 = z5;
                        dataStoreImpl$readDataOrHandleCorruption$1.I$0 = hashCode;
                        dataStoreImpl$readDataOrHandleCorruption$1.label = 2;
                        version = coordinator32.getVersion(dataStoreImpl$readDataOrHandleCorruption$1);
                        if (version != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        i5 = dataStoreImpl$readDataOrHandleCorruption$1.I$0;
                        z6 = dataStoreImpl$readDataOrHandleCorruption$1.Z$0;
                        obj = dataStoreImpl$readDataOrHandleCorruption$1.L$1;
                        dataStoreImpl3 = (DataStoreImpl) dataStoreImpl$readDataOrHandleCorruption$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            return new Data(obj, i5, ((Number) obj2).intValue());
                        } catch (CorruptionException e7) {
                            e = e7;
                            z5 = z6;
                            dataStoreImpl = dataStoreImpl3;
                            ref$ObjectRef = new Ref$ObjectRef();
                            CorruptionHandler<T> corruptionHandler22 = dataStoreImpl.corruptionHandler;
                            dataStoreImpl$readDataOrHandleCorruption$1.L$0 = dataStoreImpl;
                            dataStoreImpl$readDataOrHandleCorruption$1.L$1 = e;
                            dataStoreImpl$readDataOrHandleCorruption$1.L$2 = ref$ObjectRef;
                            dataStoreImpl$readDataOrHandleCorruption$1.L$3 = ref$ObjectRef;
                            dataStoreImpl$readDataOrHandleCorruption$1.Z$0 = z5;
                            dataStoreImpl$readDataOrHandleCorruption$1.label = 5;
                            handleCorruption = corruptionHandler22.handleCorruption(e, dataStoreImpl$readDataOrHandleCorruption$1);
                            if (handleCorruption == coroutine_suspended) {
                            }
                        }
                        break;
                    case 3:
                        z5 = dataStoreImpl$readDataOrHandleCorruption$1.Z$0;
                        dataStoreImpl2 = (DataStoreImpl) dataStoreImpl$readDataOrHandleCorruption$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        int intValue2 = ((Number) obj2).intValue();
                        InterProcessCoordinator coordinator22 = dataStoreImpl2.getCoordinator();
                        DataStoreImpl$readDataOrHandleCorruption$2 dataStoreImpl$readDataOrHandleCorruption$22 = new DataStoreImpl$readDataOrHandleCorruption$2(dataStoreImpl2, intValue2, null);
                        dataStoreImpl$readDataOrHandleCorruption$1.L$0 = dataStoreImpl2;
                        dataStoreImpl$readDataOrHandleCorruption$1.Z$0 = z5;
                        dataStoreImpl$readDataOrHandleCorruption$1.label = 4;
                        obj2 = (T) coordinator22.tryLock(dataStoreImpl$readDataOrHandleCorruption$22, dataStoreImpl$readDataOrHandleCorruption$1);
                        if (obj2 == coroutine_suspended) {
                        }
                        return (Data) obj2;
                    case 4:
                        boolean z7 = dataStoreImpl$readDataOrHandleCorruption$1.Z$0;
                        ResultKt.throwOnFailure(obj2);
                        return (Data) obj2;
                    case 5:
                        z5 = dataStoreImpl$readDataOrHandleCorruption$1.Z$0;
                        Ref$ObjectRef ref$ObjectRef4 = (Ref$ObjectRef) dataStoreImpl$readDataOrHandleCorruption$1.L$3;
                        Ref$ObjectRef ref$ObjectRef5 = (Ref$ObjectRef) dataStoreImpl$readDataOrHandleCorruption$1.L$2;
                        corruptionException = (CorruptionException) dataStoreImpl$readDataOrHandleCorruption$1.L$1;
                        dataStoreImpl = (DataStoreImpl) dataStoreImpl$readDataOrHandleCorruption$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        ref$ObjectRef2 = ref$ObjectRef4;
                        ref$ObjectRef = ref$ObjectRef5;
                        ref$ObjectRef2.element = (T) obj2;
                        Ref$IntRef ref$IntRef22 = new Ref$IntRef();
                        dataStoreImpl$readDataOrHandleCorruption$3 = new DataStoreImpl$readDataOrHandleCorruption$3(ref$ObjectRef, dataStoreImpl, ref$IntRef22, null);
                        dataStoreImpl$readDataOrHandleCorruption$1.L$0 = corruptionException;
                        dataStoreImpl$readDataOrHandleCorruption$1.L$1 = ref$ObjectRef;
                        dataStoreImpl$readDataOrHandleCorruption$1.L$2 = ref$IntRef22;
                        dataStoreImpl$readDataOrHandleCorruption$1.L$3 = null;
                        dataStoreImpl$readDataOrHandleCorruption$1.label = 6;
                        if (dataStoreImpl.doWithWriteFileLock(z5, dataStoreImpl$readDataOrHandleCorruption$3, dataStoreImpl$readDataOrHandleCorruption$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ref$IntRef = ref$IntRef22;
                        ref$ObjectRef3 = ref$ObjectRef;
                        T t5 = ref$ObjectRef3.element;
                        return new Data(t5, t5 != null ? t5.hashCode() : 0, ref$IntRef.element);
                    case 6:
                        ref$IntRef = (Ref$IntRef) dataStoreImpl$readDataOrHandleCorruption$1.L$2;
                        ref$ObjectRef3 = (Ref$ObjectRef) dataStoreImpl$readDataOrHandleCorruption$1.L$1;
                        corruptionException2 = (CorruptionException) dataStoreImpl$readDataOrHandleCorruption$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            T t52 = ref$ObjectRef3.element;
                            return new Data(t52, t52 != null ? t52.hashCode() : 0, ref$IntRef.element);
                        } catch (Throwable th2) {
                            th = th2;
                            ExceptionsKt.addSuppressed(corruptionException2, th);
                            throw corruptionException2;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dataStoreImpl$readDataOrHandleCorruption$1 = new DataStoreImpl$readDataOrHandleCorruption$1(this, continuation);
        Object obj22 = (T) dataStoreImpl$readDataOrHandleCorruption$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r22 = dataStoreImpl$readDataOrHandleCorruption$1.label;
        switch (r22) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readState(boolean z5, Continuation<? super State<T>> continuation) {
        return BuildersKt.withContext(this.scope.getCoroutineContext(), new DataStoreImpl$readState$2(this, z5, null), continuation);
    }

    private final Object transformAndWrite(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        return getCoordinator().lock(new DataStoreImpl$transformAndWrite$2(this, coroutineContext, function2, null), continuation);
    }

    @Override // androidx.datastore.core.DataStore
    public Flow<T> getData() {
        return this.data;
    }

    public final StorageConnection<T> getStorageConnection$datastore_core_release() {
        return this.storageConnectionDelegate.getValue();
    }

    @Override // androidx.datastore.core.DataStore
    public Object updateData(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        UpdatingDataContextElement updatingDataContextElement = (UpdatingDataContextElement) continuation.getContext().get(UpdatingDataContextElement.Companion.Key.INSTANCE);
        if (updatingDataContextElement != null) {
            updatingDataContextElement.checkNotUpdating(this);
        }
        return BuildersKt.withContext(new UpdatingDataContextElement(updatingDataContextElement, this), new DataStoreImpl$updateData$2(this, function2, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeData$datastore_core_release(T t5, boolean z5, Continuation<? super Integer> continuation) {
        DataStoreImpl$writeData$1 dataStoreImpl$writeData$1;
        int i5;
        Ref$IntRef ref$IntRef;
        if (continuation instanceof DataStoreImpl$writeData$1) {
            dataStoreImpl$writeData$1 = (DataStoreImpl$writeData$1) continuation;
            int i6 = dataStoreImpl$writeData$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                dataStoreImpl$writeData$1.label = i6 - Integer.MIN_VALUE;
                Object obj = dataStoreImpl$writeData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = dataStoreImpl$writeData$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref$IntRef ref$IntRef2 = new Ref$IntRef();
                    StorageConnection<T> storageConnection$datastore_core_release = getStorageConnection$datastore_core_release();
                    DataStoreImpl$writeData$2 dataStoreImpl$writeData$2 = new DataStoreImpl$writeData$2(ref$IntRef2, this, t5, z5, null);
                    dataStoreImpl$writeData$1.L$0 = ref$IntRef2;
                    dataStoreImpl$writeData$1.label = 1;
                    if (storageConnection$datastore_core_release.writeScope(dataStoreImpl$writeData$2, dataStoreImpl$writeData$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ref$IntRef = ref$IntRef2;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ref$IntRef = (Ref$IntRef) dataStoreImpl$writeData$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxInt(ref$IntRef.element);
            }
        }
        dataStoreImpl$writeData$1 = new DataStoreImpl$writeData$1(this, continuation);
        Object obj2 = dataStoreImpl$writeData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = dataStoreImpl$writeData$1.label;
        if (i5 != 0) {
        }
        return Boxing.boxInt(ref$IntRef.element);
    }
}
