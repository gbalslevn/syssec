package dk.molslinjen.domain.localstorage.passengers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.localstorage.passengers.PassengerRepository", f = "PassengerRepository.kt", l = {25, 28}, m = "updatePassenger")
/* loaded from: classes2.dex */
public final class PassengerRepository$updatePassenger$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PassengerRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PassengerRepository$updatePassenger$1(PassengerRepository passengerRepository, Continuation<? super PassengerRepository$updatePassenger$1> continuation) {
        super(continuation);
        this.this$0 = passengerRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updatePassenger(null, this);
    }
}
