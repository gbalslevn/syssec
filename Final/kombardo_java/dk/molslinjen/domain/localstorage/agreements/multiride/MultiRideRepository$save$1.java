package dk.molslinjen.domain.localstorage.agreements.multiride;

import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.localstorage.agreements.multiride.MultiRideRepository", f = "MultiRideRepository.kt", l = {19, 19}, m = "save")
/* loaded from: classes2.dex */
public final class MultiRideRepository$save$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiRideRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideRepository$save$1(MultiRideRepository multiRideRepository, Continuation<? super MultiRideRepository$save$1> continuation) {
        super(continuation);
        this.this$0 = multiRideRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.save((MultiRideCard) null, this);
    }
}
