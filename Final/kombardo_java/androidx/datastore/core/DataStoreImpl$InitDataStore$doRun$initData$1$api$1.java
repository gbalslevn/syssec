package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.sync.Mutex;
import org.conscrypt.BuildConfig;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J4\u0010\u0006\u001a\u00028\u00002\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0096@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"androidx/datastore/core/DataStoreImpl$InitDataStore$doRun$initData$1$api$1", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "transform", "updateData", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DataStoreImpl$InitDataStore$doRun$initData$1$api$1<T> implements InitializerApi<T> {
    final /* synthetic */ Ref$ObjectRef<T> $currentData;
    final /* synthetic */ Ref$BooleanRef $initializationComplete;
    final /* synthetic */ Mutex $updateLock;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataStoreImpl$InitDataStore$doRun$initData$1$api$1(Mutex mutex, Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef<T> ref$ObjectRef, DataStoreImpl<T> dataStoreImpl) {
        this.$updateLock = mutex;
        this.$initializationComplete = ref$BooleanRef;
        this.$currentData = ref$ObjectRef;
        this.this$0 = dataStoreImpl;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:27:0x0052, B:28:0x00b2, B:30:0x00ba), top: B:26:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009a A[Catch: all -> 0x00d8, TRY_LEAVE, TryCatch #1 {all -> 0x00d8, blocks: (B:40:0x0096, B:42:0x009a, B:46:0x00db, B:47:0x00e2), top: B:39:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00db A[Catch: all -> 0x00d8, TRY_ENTER, TryCatch #1 {all -> 0x00d8, blocks: (B:40:0x0096, B:42:0x009a, B:46:0x00db, B:47:0x00e2), top: B:39:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // androidx.datastore.core.InitializerApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateData(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1;
        int i5;
        Mutex mutex;
        DataStoreImpl dataStoreImpl;
        Ref$BooleanRef ref$BooleanRef;
        Ref$ObjectRef<T> ref$ObjectRef;
        Mutex mutex2;
        Mutex mutex3;
        DataStoreImpl dataStoreImpl2;
        T t5;
        Ref$ObjectRef<T> ref$ObjectRef2;
        try {
            if (continuation instanceof DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) {
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 = (DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) continuation;
                int i6 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = i6 - Integer.MIN_VALUE;
                    Object obj = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.$updateLock;
                        Ref$BooleanRef ref$BooleanRef2 = this.$initializationComplete;
                        Ref$ObjectRef<T> ref$ObjectRef3 = this.$currentData;
                        dataStoreImpl = this.this$0;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = function2;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = mutex;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = ref$BooleanRef2;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$3 = ref$ObjectRef3;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$4 = dataStoreImpl;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 1;
                        if (mutex.lock(null, dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ref$BooleanRef = ref$BooleanRef2;
                        ref$ObjectRef = ref$ObjectRef3;
                    } else {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                if (i5 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                t5 = (T) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2;
                                ref$ObjectRef2 = (Ref$ObjectRef) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1;
                                mutex2 = (Mutex) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    ref$ObjectRef2.element = t5;
                                    ref$ObjectRef = ref$ObjectRef2;
                                    T t6 = ref$ObjectRef.element;
                                    mutex2.unlock(null);
                                    return t6;
                                } catch (Throwable th) {
                                    th = th;
                                    mutex2.unlock(null);
                                    throw th;
                                }
                            }
                            DataStoreImpl dataStoreImpl3 = (DataStoreImpl) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2;
                            ref$ObjectRef = (Ref$ObjectRef) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1;
                            mutex3 = (Mutex) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                dataStoreImpl2 = dataStoreImpl3;
                                if (!Intrinsics.areEqual(obj, ref$ObjectRef.element)) {
                                    mutex2 = mutex3;
                                    T t62 = ref$ObjectRef.element;
                                    mutex2.unlock(null);
                                    return t62;
                                }
                                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = mutex3;
                                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = ref$ObjectRef;
                                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = obj;
                                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 3;
                                if (dataStoreImpl2.writeData$datastore_core_release(obj, false, dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                t5 = (T) obj;
                                ref$ObjectRef2 = ref$ObjectRef;
                                mutex2 = mutex3;
                                ref$ObjectRef2.element = t5;
                                ref$ObjectRef = ref$ObjectRef2;
                                T t622 = ref$ObjectRef.element;
                                mutex2.unlock(null);
                                return t622;
                            } catch (Throwable th2) {
                                th = th2;
                                mutex2 = mutex3;
                                mutex2.unlock(null);
                                throw th;
                            }
                        }
                        DataStoreImpl dataStoreImpl4 = (DataStoreImpl) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$4;
                        ref$ObjectRef = (Ref$ObjectRef) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$3;
                        ref$BooleanRef = (Ref$BooleanRef) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2;
                        Mutex mutex4 = (Mutex) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1;
                        Function2<? super T, ? super Continuation<? super T>, ? extends Object> function22 = (Function2) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex4;
                        dataStoreImpl = dataStoreImpl4;
                        function2 = function22;
                    }
                    if (!ref$BooleanRef.element) {
                        throw new IllegalStateException("InitializerApi.updateData should not be called after initialization is complete.");
                    }
                    T t7 = ref$ObjectRef.element;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = mutex;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = ref$ObjectRef;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = dataStoreImpl;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$3 = null;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$4 = null;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 2;
                    Object invoke = function2.invoke(t7, dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutex3 = mutex;
                    obj = invoke;
                    dataStoreImpl2 = dataStoreImpl;
                    if (!Intrinsics.areEqual(obj, ref$ObjectRef.element)) {
                    }
                }
            }
            if (!ref$BooleanRef.element) {
            }
        } catch (Throwable th3) {
            th = th3;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 = new DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1(this, continuation);
        Object obj2 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label;
        if (i5 != 0) {
        }
    }
}
