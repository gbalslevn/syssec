package dk.molslinjen.core.migration;

import android.content.Context;
import dk.molslinjen.core.migration.Migrator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\bH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Ldk/molslinjen/core/migration/IMigrator;", BuildConfig.FLAVOR, "migrationState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/core/migration/Migrator$MigrationState;", "getMigrationState", "()Lkotlinx/coroutines/flow/StateFlow;", "migrate", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearMigrationErrors", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IMigrator {
    void clearMigrationErrors();

    StateFlow<Migrator.MigrationState> getMigrationState();

    Object migrate(Context context, Continuation<? super Unit> continuation);
}
