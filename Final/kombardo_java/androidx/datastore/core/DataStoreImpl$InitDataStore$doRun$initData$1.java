package androidx.datastore.core;

import androidx.datastore.core.DataStoreImpl;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroidx/datastore/core/Data;", "T"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1", f = "DataStoreImpl.kt", l = {437, 458, 546, 468}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataStoreImpl$InitDataStore$doRun$initData$1<T> extends SuspendLambda implements Function1<Continuation<? super Data<T>>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;
    final /* synthetic */ DataStoreImpl<T>.InitDataStore this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$InitDataStore$doRun$initData$1(DataStoreImpl<T> dataStoreImpl, DataStoreImpl<T>.InitDataStore initDataStore, Continuation<? super DataStoreImpl$InitDataStore$doRun$initData$1> continuation) {
        super(1, continuation);
        this.this$0 = dataStoreImpl;
        this.this$1 = initDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new DataStoreImpl$InitDataStore$doRun$initData$1(this.this$0, this.this$1, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x010d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e7  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Mutex Mutex$default;
        Ref$BooleanRef ref$BooleanRef;
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        List list;
        Ref$BooleanRef ref$BooleanRef2;
        Mutex mutex;
        Iterator<T> it;
        Mutex mutex2;
        Ref$BooleanRef ref$BooleanRef3;
        Ref$ObjectRef ref$ObjectRef3;
        DataStoreImpl$InitDataStore$doRun$initData$1$api$1 dataStoreImpl$InitDataStore$doRun$initData$1$api$1;
        Ref$ObjectRef ref$ObjectRef4;
        Object obj2;
        int i5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex$default = MutexKt.Mutex$default(false, 1, null);
            ref$BooleanRef = new Ref$BooleanRef();
            ref$ObjectRef = new Ref$ObjectRef();
            DataStoreImpl<T> dataStoreImpl = this.this$0;
            this.L$0 = Mutex$default;
            this.L$1 = ref$BooleanRef;
            this.L$2 = ref$ObjectRef;
            this.L$3 = ref$ObjectRef;
            this.label = 1;
            obj = dataStoreImpl.readDataOrHandleCorruption(true, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            ref$ObjectRef2 = ref$ObjectRef;
        } else if (i6 == 1) {
            ref$ObjectRef = (Ref$ObjectRef) this.L$3;
            ref$ObjectRef2 = (Ref$ObjectRef) this.L$2;
            ref$BooleanRef = (Ref$BooleanRef) this.L$1;
            Mutex$default = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i5 = this.I$0;
                    obj2 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return new Data(obj2, i5, ((Number) obj).intValue());
                }
                mutex = (Mutex) this.L$2;
                ref$ObjectRef4 = (Ref$ObjectRef) this.L$1;
                ref$BooleanRef2 = (Ref$BooleanRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                try {
                    ref$BooleanRef2.element = true;
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock(null);
                    obj2 = ref$ObjectRef4.element;
                    int hashCode = obj2 != null ? obj2.hashCode() : 0;
                    InterProcessCoordinator coordinator = this.this$0.getCoordinator();
                    this.L$0 = obj2;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.I$0 = hashCode;
                    this.label = 4;
                    obj = coordinator.getVersion(this);
                    if (obj != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i5 = hashCode;
                    return new Data(obj2, i5, ((Number) obj).intValue());
                } catch (Throwable th) {
                    mutex.unlock(null);
                    throw th;
                }
            }
            it = (Iterator) this.L$4;
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1 = (DataStoreImpl$InitDataStore$doRun$initData$1$api$1) this.L$3;
            ref$ObjectRef3 = (Ref$ObjectRef) this.L$2;
            ref$BooleanRef3 = (Ref$BooleanRef) this.L$1;
            mutex2 = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
            while (it.hasNext()) {
                Function2 function2 = (Function2) it.next();
                this.L$0 = mutex2;
                this.L$1 = ref$BooleanRef3;
                this.L$2 = ref$ObjectRef3;
                this.L$3 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1;
                this.L$4 = it;
                this.label = 2;
                if (function2.invoke(dataStoreImpl$InitDataStore$doRun$initData$1$api$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            ref$ObjectRef2 = ref$ObjectRef3;
            ref$BooleanRef2 = ref$BooleanRef3;
            mutex = mutex2;
            ((DataStoreImpl.InitDataStore) this.this$1).initTasks = null;
            this.L$0 = ref$BooleanRef2;
            this.L$1 = ref$ObjectRef2;
            this.L$2 = mutex;
            this.L$3 = null;
            this.L$4 = null;
            this.label = 3;
            if (mutex.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            ref$ObjectRef4 = ref$ObjectRef2;
            ref$BooleanRef2.element = true;
            Unit unit2 = Unit.INSTANCE;
            mutex.unlock(null);
            obj2 = ref$ObjectRef4.element;
            if (obj2 != null) {
            }
            InterProcessCoordinator coordinator2 = this.this$0.getCoordinator();
            this.L$0 = obj2;
            this.L$1 = null;
            this.L$2 = null;
            this.I$0 = hashCode;
            this.label = 4;
            obj = coordinator2.getVersion(this);
            if (obj != coroutine_suspended) {
            }
        }
        ref$ObjectRef.element = (T) ((Data) obj).getValue();
        DataStoreImpl$InitDataStore$doRun$initData$1$api$1 dataStoreImpl$InitDataStore$doRun$initData$1$api$12 = new DataStoreImpl$InitDataStore$doRun$initData$1$api$1(Mutex$default, ref$BooleanRef, ref$ObjectRef2, this.this$0);
        list = ((DataStoreImpl.InitDataStore) this.this$1).initTasks;
        if (list != null) {
            it = list.iterator();
            mutex2 = Mutex$default;
            ref$BooleanRef3 = ref$BooleanRef;
            ref$ObjectRef3 = ref$ObjectRef2;
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1 = dataStoreImpl$InitDataStore$doRun$initData$1$api$12;
            while (it.hasNext()) {
            }
            ref$ObjectRef2 = ref$ObjectRef3;
            ref$BooleanRef2 = ref$BooleanRef3;
            mutex = mutex2;
            ((DataStoreImpl.InitDataStore) this.this$1).initTasks = null;
            this.L$0 = ref$BooleanRef2;
            this.L$1 = ref$ObjectRef2;
            this.L$2 = mutex;
            this.L$3 = null;
            this.L$4 = null;
            this.label = 3;
            if (mutex.lock(null, this) == coroutine_suspended) {
            }
        } else {
            ref$BooleanRef2 = ref$BooleanRef;
            mutex = Mutex$default;
            ((DataStoreImpl.InitDataStore) this.this$1).initTasks = null;
            this.L$0 = ref$BooleanRef2;
            this.L$1 = ref$ObjectRef2;
            this.L$2 = mutex;
            this.L$3 = null;
            this.L$4 = null;
            this.label = 3;
            if (mutex.lock(null, this) == coroutine_suspended) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Data<T>> continuation) {
        return ((DataStoreImpl$InitDataStore$doRun$initData$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
