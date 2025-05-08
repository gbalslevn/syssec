package dk.molslinjen.ui.views.screens.main;

import androidx.lifecycle.ViewModel;
import dk.molslinjen.core.migration.IMigrator;
import dk.molslinjen.core.migration.Migrator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Ldk/molslinjen/ui/views/screens/main/MigrationErrorViewModel;", "Landroidx/lifecycle/ViewModel;", "migrator", "Ldk/molslinjen/core/migration/IMigrator;", "<init>", "(Ldk/molslinjen/core/migration/IMigrator;)V", "migrationState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/core/migration/Migrator$MigrationState;", "getMigrationState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearMigrationErrors", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MigrationErrorViewModel extends ViewModel {
    private final StateFlow<Migrator.MigrationState> migrationState;
    private final IMigrator migrator;

    public MigrationErrorViewModel(IMigrator migrator) {
        Intrinsics.checkNotNullParameter(migrator, "migrator");
        this.migrator = migrator;
        this.migrationState = migrator.getMigrationState();
    }

    public final void clearMigrationErrors() {
        this.migrator.clearMigrationErrors();
    }

    public final StateFlow<Migrator.MigrationState> getMigrationState() {
        return this.migrationState;
    }
}
