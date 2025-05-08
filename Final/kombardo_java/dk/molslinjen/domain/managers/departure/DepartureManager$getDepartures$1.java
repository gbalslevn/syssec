package dk.molslinjen.domain.managers.departure;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.departure.DepartureManager", f = "DepartureManager.kt", l = {198}, m = "getDepartures")
/* loaded from: classes2.dex */
public final class DepartureManager$getDepartures$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DepartureManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DepartureManager$getDepartures$1(DepartureManager departureManager, Continuation<? super DepartureManager$getDepartures$1> continuation) {
        super(continuation);
        this.this$0 = departureManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object departures;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        departures = this.this$0.getDepartures(null, null, null, null, null, null, null, null, null, null, this);
        return departures;
    }
}
