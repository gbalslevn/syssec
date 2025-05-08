package dk.molslinjen.ui.views.screens.booking.departures;

import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$switchToStartFromNearestHarbor$3", f = "DeparturesViewModel.kt", l = {173}, m = "emit")
/* loaded from: classes2.dex */
public final class DeparturesViewModel$switchToStartFromNearestHarbor$3$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeparturesViewModel$switchToStartFromNearestHarbor$3<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DeparturesViewModel$switchToStartFromNearestHarbor$3$emit$1(DeparturesViewModel$switchToStartFromNearestHarbor$3<? super T> departuresViewModel$switchToStartFromNearestHarbor$3, Continuation<? super DeparturesViewModel$switchToStartFromNearestHarbor$3$emit$1> continuation) {
        super(continuation);
        this.this$0 = departuresViewModel$switchToStartFromNearestHarbor$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Pair<RouteSharedSelectedState, RouteSelectedState>) null, (Continuation<? super Unit>) this);
    }
}
