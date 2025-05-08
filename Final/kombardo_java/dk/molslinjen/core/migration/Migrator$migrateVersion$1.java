package dk.molslinjen.core.migration;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.core.migration.Migrator", f = "Migrator.kt", l = {69, 73, 76}, m = "migrateVersion")
/* loaded from: classes2.dex */
public final class Migrator$migrateVersion$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Migrator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Migrator$migrateVersion$1(Migrator migrator, Continuation<? super Migrator$migrateVersion$1> continuation) {
        super(continuation);
        this.this$0 = migrator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object migrateVersion;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        migrateVersion = this.this$0.migrateVersion(0, null, this);
        return migrateVersion;
    }
}
