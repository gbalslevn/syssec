package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Landroidx/datastore/core/Data;", "T", "locked", BuildConfig.FLAVOR}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2", f = "DataStoreImpl.kt", l = {370, 371}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataStoreImpl$readDataOrHandleCorruption$2<T> extends SuspendLambda implements Function2<Boolean, Continuation<? super Data<T>>, Object> {
    final /* synthetic */ int $preLockVersion;
    Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataOrHandleCorruption$2(DataStoreImpl<T> dataStoreImpl, int i5, Continuation<? super DataStoreImpl$readDataOrHandleCorruption$2> continuation) {
        super(2, continuation);
        this.this$0 = dataStoreImpl;
        this.$preLockVersion = i5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DataStoreImpl$readDataOrHandleCorruption$2 dataStoreImpl$readDataOrHandleCorruption$2 = new DataStoreImpl$readDataOrHandleCorruption$2(this.this$0, this.$preLockVersion, continuation);
        dataStoreImpl$readDataOrHandleCorruption$2.Z$0 = ((Boolean) obj).booleanValue();
        return dataStoreImpl$readDataOrHandleCorruption$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Object obj) {
        return invoke(bool.booleanValue(), (Continuation) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0059  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean z5;
        Object obj2;
        int i5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            z5 = this.Z$0;
            DataStoreImpl<T> dataStoreImpl = this.this$0;
            this.Z$0 = z5;
            this.label = 1;
            obj = dataStoreImpl.readDataFromFileOrDefault(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                if (i6 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj2 = this.L$0;
                ResultKt.throwOnFailure(obj);
                i5 = ((Number) obj).intValue();
                return new Data(obj2, obj2 != null ? obj2.hashCode() : 0, i5);
            }
            z5 = this.Z$0;
            ResultKt.throwOnFailure(obj);
        }
        if (!z5) {
            obj2 = obj;
            i5 = this.$preLockVersion;
            return new Data(obj2, obj2 != null ? obj2.hashCode() : 0, i5);
        }
        InterProcessCoordinator coordinator = this.this$0.getCoordinator();
        this.L$0 = obj;
        this.label = 2;
        Object version = coordinator.getVersion(this);
        if (version == coroutine_suspended) {
            return coroutine_suspended;
        }
        obj2 = obj;
        obj = version;
        i5 = ((Number) obj).intValue();
        return new Data(obj2, obj2 != null ? obj2.hashCode() : 0, i5);
    }

    public final Object invoke(boolean z5, Continuation<? super Data<T>> continuation) {
        return ((DataStoreImpl$readDataOrHandleCorruption$2) create(Boolean.valueOf(z5), continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
