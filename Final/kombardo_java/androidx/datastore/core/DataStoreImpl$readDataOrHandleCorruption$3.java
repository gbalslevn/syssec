package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "T"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3", f = "DataStoreImpl.kt", l = {387, 388, 390}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataStoreImpl$readDataOrHandleCorruption$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref$ObjectRef<T> $newData;
    final /* synthetic */ Ref$IntRef $version;
    Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataOrHandleCorruption$3(Ref$ObjectRef<T> ref$ObjectRef, DataStoreImpl<T> dataStoreImpl, Ref$IntRef ref$IntRef, Continuation<? super DataStoreImpl$readDataOrHandleCorruption$3> continuation) {
        super(1, continuation);
        this.$newData = ref$ObjectRef;
        this.this$0 = dataStoreImpl;
        this.$version = ref$IntRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new DataStoreImpl$readDataOrHandleCorruption$3(this.$newData, this.this$0, this.$version, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref$IntRef ref$IntRef;
        Object obj2;
        Ref$ObjectRef ref$ObjectRef;
        Object readDataFromFileOrDefault;
        T t5;
        Ref$IntRef ref$IntRef2;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        try {
        } catch (CorruptionException unused) {
            Ref$IntRef ref$IntRef3 = this.$version;
            DataStoreImpl<T> dataStoreImpl = this.this$0;
            T t6 = this.$newData.element;
            this.L$0 = ref$IntRef3;
            this.label = 3;
            Object writeData$datastore_core_release = dataStoreImpl.writeData$datastore_core_release(t6, true, this);
            if (writeData$datastore_core_release == coroutine_suspended) {
                return coroutine_suspended;
            }
            ref$IntRef = ref$IntRef3;
            obj2 = writeData$datastore_core_release;
        }
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            ref$ObjectRef = this.$newData;
            DataStoreImpl<T> dataStoreImpl2 = this.this$0;
            this.L$0 = ref$ObjectRef;
            this.label = 1;
            readDataFromFileOrDefault = dataStoreImpl2.readDataFromFileOrDefault(this);
            t5 = readDataFromFileOrDefault;
            if (readDataFromFileOrDefault == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 == 2) {
                    ref$IntRef2 = (Ref$IntRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    obj3 = obj;
                    ref$IntRef2.element = ((Number) obj3).intValue();
                    return Unit.INSTANCE;
                }
                if (i5 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ref$IntRef = (Ref$IntRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
                ref$IntRef.element = ((Number) obj2).intValue();
                return Unit.INSTANCE;
            }
            ref$ObjectRef = (Ref$ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
            t5 = obj;
        }
        ref$ObjectRef.element = t5;
        ref$IntRef2 = this.$version;
        InterProcessCoordinator coordinator = this.this$0.getCoordinator();
        this.L$0 = ref$IntRef2;
        this.label = 2;
        Object version = coordinator.getVersion(this);
        obj3 = version;
        if (version == coroutine_suspended) {
            return coroutine_suspended;
        }
        ref$IntRef2.element = ((Number) obj3).intValue();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((DataStoreImpl$readDataOrHandleCorruption$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
