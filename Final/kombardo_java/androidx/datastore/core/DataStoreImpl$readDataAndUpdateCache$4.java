package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Landroidx/datastore/core/State;", "T", BuildConfig.FLAVOR, "locked"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4", f = "DataStoreImpl.kt", l = {306, 309}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataStoreImpl$readDataAndUpdateCache$4<T> extends SuspendLambda implements Function2<Boolean, Continuation<? super Pair<? extends State<T>, ? extends Boolean>>, Object> {
    final /* synthetic */ int $cachedVersion;
    Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataAndUpdateCache$4(DataStoreImpl<T> dataStoreImpl, int i5, Continuation<? super DataStoreImpl$readDataAndUpdateCache$4> continuation) {
        super(2, continuation);
        this.this$0 = dataStoreImpl;
        this.$cachedVersion = i5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DataStoreImpl$readDataAndUpdateCache$4 dataStoreImpl$readDataAndUpdateCache$4 = new DataStoreImpl$readDataAndUpdateCache$4(this.this$0, this.$cachedVersion, continuation);
        dataStoreImpl$readDataAndUpdateCache$4.Z$0 = ((Boolean) obj).booleanValue();
        return dataStoreImpl$readDataAndUpdateCache$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Object obj) {
        return invoke(bool.booleanValue(), (Continuation) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        int i5;
        boolean z5;
        State state;
        boolean z6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z7 = this.label;
        try {
        } catch (Throwable th2) {
            if (z7 != 0) {
                InterProcessCoordinator coordinator = this.this$0.getCoordinator();
                this.L$0 = th2;
                this.Z$0 = z7;
                this.label = 2;
                Object version = coordinator.getVersion(this);
                if (version == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z5 = z7;
                th = th2;
                obj = version;
            } else {
                boolean z8 = z7;
                th = th2;
                i5 = this.$cachedVersion;
                z5 = z8;
            }
        }
        if (z7 == 0) {
            ResultKt.throwOnFailure(obj);
            boolean z9 = this.Z$0;
            DataStoreImpl<T> dataStoreImpl = this.this$0;
            this.Z$0 = z9;
            this.label = 1;
            obj = dataStoreImpl.readDataOrHandleCorruption(z9, this);
            z7 = z9;
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (z7 != 1) {
                if (z7 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z5 = this.Z$0;
                th = (Throwable) this.L$0;
                ResultKt.throwOnFailure(obj);
                i5 = ((Number) obj).intValue();
                ReadException readException = new ReadException(th, i5);
                z6 = z5;
                state = readException;
                return TuplesKt.to(state, Boxing.boxBoolean(z6));
            }
            boolean z10 = this.Z$0;
            ResultKt.throwOnFailure(obj);
            z7 = z10;
        }
        state = (State) obj;
        z6 = z7;
        return TuplesKt.to(state, Boxing.boxBoolean(z6));
    }

    public final Object invoke(boolean z5, Continuation<? super Pair<? extends State<T>, Boolean>> continuation) {
        return ((DataStoreImpl$readDataAndUpdateCache$4) create(Boolean.valueOf(z5), continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
