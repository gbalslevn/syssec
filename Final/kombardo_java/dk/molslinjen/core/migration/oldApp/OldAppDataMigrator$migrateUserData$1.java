package dk.molslinjen.core.migration.oldApp;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.core.migration.oldApp.OldAppDataMigrator", f = "OldAppDataMigrator.kt", l = {89, 93}, m = "migrateUserData")
/* loaded from: classes2.dex */
public final class OldAppDataMigrator$migrateUserData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OldAppDataMigrator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldAppDataMigrator$migrateUserData$1(OldAppDataMigrator oldAppDataMigrator, Continuation<? super OldAppDataMigrator$migrateUserData$1> continuation) {
        super(continuation);
        this.this$0 = oldAppDataMigrator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object migrateUserData;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        migrateUserData = this.this$0.migrateUserData(null, this);
        return migrateUserData;
    }
}
