package dk.molslinjen.domain.managers.checkout;

import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.SummaryAddonHelper", f = "SummaryAddonHelper.kt", l = {40, 50, Function.THROW_LAST_ERROR}, m = "loadSummaryProducts")
/* loaded from: classes2.dex */
public final class SummaryAddonHelper$loadSummaryProducts$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SummaryAddonHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SummaryAddonHelper$loadSummaryProducts$1(SummaryAddonHelper summaryAddonHelper, Continuation<? super SummaryAddonHelper$loadSummaryProducts$1> continuation) {
        super(continuation);
        this.this$0 = summaryAddonHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadSummaryProducts(null, null, 0, null, null, null, false, null, null, this);
    }
}
