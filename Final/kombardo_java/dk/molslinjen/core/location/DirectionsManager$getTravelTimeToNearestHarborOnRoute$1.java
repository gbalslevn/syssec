package dk.molslinjen.core.location;

import androidx.appcompat.R$styleable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.core.location.DirectionsManager", f = "DirectionsManager.kt", l = {R$styleable.Toolbar_titleMarginEnd, 25}, m = "getTravelTimeToNearestHarborOnRoute")
/* loaded from: classes2.dex */
public final class DirectionsManager$getTravelTimeToNearestHarborOnRoute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DirectionsManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectionsManager$getTravelTimeToNearestHarborOnRoute$1(DirectionsManager directionsManager, Continuation<? super DirectionsManager$getTravelTimeToNearestHarborOnRoute$1> continuation) {
        super(continuation);
        this.this$0 = directionsManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getTravelTimeToNearestHarborOnRoute(null, null, this);
    }
}
