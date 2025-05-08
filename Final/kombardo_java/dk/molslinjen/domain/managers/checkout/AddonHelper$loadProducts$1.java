package dk.molslinjen.domain.managers.checkout;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.AddonHelper", f = "AddonHelper.kt", l = {43, 53, 93}, m = "loadProducts")
/* loaded from: classes2.dex */
public final class AddonHelper$loadProducts$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AddonHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddonHelper$loadProducts$1(AddonHelper addonHelper, Continuation<? super AddonHelper$loadProducts$1> continuation) {
        super(continuation);
        this.this$0 = addonHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadProducts(null, null, null, 0, null, null, null, null, null, this);
    }
}
