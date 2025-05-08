package dk.molslinjen.domain.managers.notification;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.notification.MarketingNotificationManager", f = "MarketingNotificationManager.kt", l = {111, 114}, m = "withdrawConsent")
/* loaded from: classes2.dex */
public final class MarketingNotificationManager$withdrawConsent$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MarketingNotificationManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketingNotificationManager$withdrawConsent$1(MarketingNotificationManager marketingNotificationManager, Continuation<? super MarketingNotificationManager$withdrawConsent$1> continuation) {
        super(continuation);
        this.this$0 = marketingNotificationManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.withdrawConsent(this);
    }
}
