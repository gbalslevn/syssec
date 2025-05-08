package dk.molslinjen.domain.managers.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.api.ForceUpdateManager", f = "ForceUpdateManager.kt", l = {13}, m = "getForceUpdateVersion")
/* loaded from: classes2.dex */
public final class ForceUpdateManager$getForceUpdateVersion$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ForceUpdateManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForceUpdateManager$getForceUpdateVersion$1(ForceUpdateManager forceUpdateManager, Continuation<? super ForceUpdateManager$getForceUpdateVersion$1> continuation) {
        super(continuation);
        this.this$0 = forceUpdateManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getForceUpdateVersion(this);
    }
}
