package dk.molslinjen.ui.views.screens.tickets.details;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel", f = "TicketDetailsViewModel.kt", l = {131}, m = "buildKombardoRouteDetailsModel")
/* loaded from: classes2.dex */
public final class TicketDetailsViewModel$buildKombardoRouteDetailsModel$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TicketDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketDetailsViewModel$buildKombardoRouteDetailsModel$1(TicketDetailsViewModel ticketDetailsViewModel, Continuation<? super TicketDetailsViewModel$buildKombardoRouteDetailsModel$1> continuation) {
        super(continuation);
        this.this$0 = ticketDetailsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object buildKombardoRouteDetailsModel;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        buildKombardoRouteDetailsModel = this.this$0.buildKombardoRouteDetailsModel(null, null, this);
        return buildKombardoRouteDetailsModel;
    }
}
