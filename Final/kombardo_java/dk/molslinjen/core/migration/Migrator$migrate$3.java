package dk.molslinjen.core.migration;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.core.migration.Migrator", f = "Migrator.kt", l = {60, 61}, m = "migrate")
/* loaded from: classes2.dex */
public final class Migrator$migrate$3 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Migrator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Migrator$migrate$3(Migrator migrator, Continuation<? super Migrator$migrate$3> continuation) {
        super(continuation);
        this.this$0 = migrator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object migrate;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        migrate = this.this$0.migrate(0, 0, null, this);
        return migrate;
    }
}
