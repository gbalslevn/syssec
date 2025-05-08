package dk.molslinjen.ui.views.shared.routeSelector;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel", f = "RouteSelectorKombardoViewModel.kt", l = {229}, m = "loadTimeToPickupPoint")
/* loaded from: classes2.dex */
public final class RouteSelectorKombardoViewModel$loadTimeToPickupPoint$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RouteSelectorKombardoViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteSelectorKombardoViewModel$loadTimeToPickupPoint$1(RouteSelectorKombardoViewModel routeSelectorKombardoViewModel, Continuation<? super RouteSelectorKombardoViewModel$loadTimeToPickupPoint$1> continuation) {
        super(continuation);
        this.this$0 = routeSelectorKombardoViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadTimeToPickupPoint(null, this);
    }
}
