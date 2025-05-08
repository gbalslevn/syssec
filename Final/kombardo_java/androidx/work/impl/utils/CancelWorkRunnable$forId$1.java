package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CancelWorkRunnable$forId$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UUID $id;
    final /* synthetic */ WorkManagerImpl $workManagerImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CancelWorkRunnable$forId$1(WorkManagerImpl workManagerImpl, UUID uuid) {
        super(0);
        this.$workManagerImpl = workManagerImpl;
        this.$id = uuid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(WorkManagerImpl workManagerImpl, UUID uuid) {
        String uuid2 = uuid.toString();
        Intrinsics.checkNotNullExpressionValue(uuid2, "id.toString()");
        CancelWorkRunnable.cancel(workManagerImpl, uuid2);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WorkDatabase workDatabase = this.$workManagerImpl.getWorkDatabase();
        Intrinsics.checkNotNullExpressionValue(workDatabase, "workManagerImpl.workDatabase");
        final WorkManagerImpl workManagerImpl = this.$workManagerImpl;
        final UUID uuid = this.$id;
        workDatabase.runInTransaction(new Runnable() { // from class: androidx.work.impl.utils.a
            @Override // java.lang.Runnable
            public final void run() {
                CancelWorkRunnable$forId$1.invoke$lambda$0(WorkManagerImpl.this, uuid);
            }
        });
        CancelWorkRunnable.reschedulePendingWorkers(this.$workManagerImpl);
    }
}
