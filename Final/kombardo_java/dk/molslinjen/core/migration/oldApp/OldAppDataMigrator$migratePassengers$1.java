package dk.molslinjen.core.migration.oldApp;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.core.migration.oldApp.OldAppDataMigrator", f = "OldAppDataMigrator.kt", l = {161}, m = "migratePassengers")
/* loaded from: classes2.dex */
public final class OldAppDataMigrator$migratePassengers$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OldAppDataMigrator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldAppDataMigrator$migratePassengers$1(OldAppDataMigrator oldAppDataMigrator, Continuation<? super OldAppDataMigrator$migratePassengers$1> continuation) {
        super(continuation);
        this.this$0 = oldAppDataMigrator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object migratePassengers;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        migratePassengers = this.this$0.migratePassengers(null, null, this);
        return migratePassengers;
    }
}
