package dk.molslinjen.domain.managers.agreement.commuter.bornholm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.commuter.bornholm.BornholmCommuterManager", f = "BornholmCommuterManager.kt", l = {118}, m = "getConfigurationTransports")
/* loaded from: classes2.dex */
public final class BornholmCommuterManager$getConfigurationTransports$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BornholmCommuterManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BornholmCommuterManager$getConfigurationTransports$1(BornholmCommuterManager bornholmCommuterManager, Continuation<? super BornholmCommuterManager$getConfigurationTransports$1> continuation) {
        super(continuation);
        this.this$0 = bornholmCommuterManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object configurationTransports;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        configurationTransports = this.this$0.getConfigurationTransports(this);
        return configurationTransports;
    }
}
