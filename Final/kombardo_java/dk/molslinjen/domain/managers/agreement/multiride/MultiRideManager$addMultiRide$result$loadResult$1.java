package dk.molslinjen.domain.managers.agreement.multiride;

import dk.molslinjen.domain.managers.ManagerResult;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$addMultiRide$result$loadResult$1", f = "MultiRideManager.kt", l = {77}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class MultiRideManager$addMultiRide$result$loadResult$1 extends SuspendLambda implements Function2<Unit, Continuation<? super ManagerResult<? extends Unit>>, Object> {
    int label;
    final /* synthetic */ MultiRideManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideManager$addMultiRide$result$loadResult$1(MultiRideManager multiRideManager, Continuation<? super MultiRideManager$addMultiRide$result$loadResult$1> continuation) {
        super(2, continuation);
        this.this$0 = multiRideManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiRideManager$addMultiRide$result$loadResult$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Unit unit, Continuation<? super ManagerResult<? extends Unit>> continuation) {
        return invoke2(unit, (Continuation<? super ManagerResult<Unit>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            MultiRideManager multiRideManager = this.this$0;
            this.label = 1;
            obj = multiRideManager.loadMultiRides(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Unit unit, Continuation<? super ManagerResult<Unit>> continuation) {
        return ((MultiRideManager$addMultiRide$result$loadResult$1) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
