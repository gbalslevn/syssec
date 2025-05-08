package dk.molslinjen.core.migration;

import android.content.Context;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.core.migration.oldApp.IOldAppDataMigrator;
import dk.molslinjen.core.migration.oldModels.OldV2Configuration;
import dk.molslinjen.core.migration.oldModels.OldV2ConfigurationRepository;
import dk.molslinjen.core.migration.oldModels.V3ConfigurationMigrationHelper;
import dk.molslinjen.domain.localstorage.IConfigurationRepository;
import dk.molslinjen.domain.model.config.Configuration;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import dk.molslinjen.domain.model.shared.CurrencyType;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u000e\u0010\u001c\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Ldk/molslinjen/core/migration/Migrator;", "Ldk/molslinjen/core/migration/IMigrator;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "oldAppDataMigrator", "Ldk/molslinjen/core/migration/oldApp/IOldAppDataMigrator;", "configurationRepository", "Ldk/molslinjen/domain/localstorage/IConfigurationRepository;", "<init>", "(Ldk/molslinjen/domain/model/settings/ISettings;Ldk/molslinjen/core/migration/oldApp/IOldAppDataMigrator;Ldk/molslinjen/domain/localstorage/IConfigurationRepository;)V", "migrationState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/core/migration/Migrator$MigrationState;", "getMigrationState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "migrate", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentVersion", BuildConfig.FLAVOR, "latestVersion", "(IILandroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migrateVersion", "fromVersion", "(ILandroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearMigrationErrors", "setDefaultCurrencyFromLanguage", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "MigrationState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Migrator implements IMigrator {
    private static final int latestVersion = 3;
    private final IConfigurationRepository configurationRepository;
    private final MutableStateFlow<MigrationState> migrationState;
    private final IOldAppDataMigrator oldAppDataMigrator;
    private final ISettings settings;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public Migrator(ISettings settings, IOldAppDataMigrator oldAppDataMigrator, IConfigurationRepository configurationRepository) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(oldAppDataMigrator, "oldAppDataMigrator");
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        this.settings = settings;
        this.oldAppDataMigrator = oldAppDataMigrator;
        this.configurationRepository = configurationRepository;
        this.migrationState = StateFlowKt.MutableStateFlow(new MigrationState(null, 1, 0 == true ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object migrateVersion(int i5, Context context, Continuation<? super Unit> continuation) {
        Migrator$migrateVersion$1 migrator$migrateVersion$1;
        int i6;
        Migrator migrator;
        OldV2Configuration oldV2Configuration;
        if (continuation instanceof Migrator$migrateVersion$1) {
            migrator$migrateVersion$1 = (Migrator$migrateVersion$1) continuation;
            int i7 = migrator$migrateVersion$1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                migrator$migrateVersion$1.label = i7 - Integer.MIN_VALUE;
                Object obj = migrator$migrateVersion$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i6 = migrator$migrateVersion$1.label;
                if (i6 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (i5 == 1) {
                        migrator$migrateVersion$1.label = 1;
                        if (setDefaultCurrencyFromLanguage(migrator$migrateVersion$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    if (i5 != 2) {
                        return Unit.INSTANCE;
                    }
                    OldV2ConfigurationRepository oldV2ConfigurationRepository = new OldV2ConfigurationRepository(context);
                    migrator$migrateVersion$1.L$0 = this;
                    migrator$migrateVersion$1.label = 2;
                    obj = oldV2ConfigurationRepository.getConfiguration(migrator$migrateVersion$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    migrator = this;
                    oldV2Configuration = (OldV2Configuration) obj;
                    if (oldV2Configuration != null) {
                    }
                } else {
                    if (i6 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    if (i6 == 2) {
                        migrator = (Migrator) migrator$migrateVersion$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        oldV2Configuration = (OldV2Configuration) obj;
                        if (oldV2Configuration != null) {
                            return Unit.INSTANCE;
                        }
                        Configuration mapV2ToV3Configuration = new V3ConfigurationMigrationHelper().mapV2ToV3Configuration(oldV2Configuration);
                        IConfigurationRepository iConfigurationRepository = migrator.configurationRepository;
                        migrator$migrateVersion$1.L$0 = null;
                        migrator$migrateVersion$1.label = 3;
                        if (iConfigurationRepository.save(mapV2ToV3Configuration, migrator$migrateVersion$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i6 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                }
                return Unit.INSTANCE;
            }
        }
        migrator$migrateVersion$1 = new Migrator$migrateVersion$1(this, continuation);
        Object obj2 = migrator$migrateVersion$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i6 = migrator$migrateVersion$1.label;
        if (i6 != 0) {
        }
        return Unit.INSTANCE;
    }

    private final Object setDefaultCurrencyFromLanguage(Continuation<? super Unit> continuation) {
        Object update = this.settings.update(SettingsProperty.Checkout.SelectedCurrency.INSTANCE, Intrinsics.areEqual(Locale.getDefault().getLanguage(), "sv") ? CurrencyType.SEK : CurrencyType.DKK, continuation);
        return update == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? update : Unit.INSTANCE;
    }

    @Override // dk.molslinjen.core.migration.IMigrator
    public void clearMigrationErrors() {
        MigrationState value;
        MutableStateFlow<MigrationState> migrationState = getMigrationState();
        do {
            value = migrationState.getValue();
        } while (!migrationState.compareAndSet(value, value.copy(CollectionsKt.emptyList())));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00da A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    @Override // dk.molslinjen.core.migration.IMigrator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object migrate(Context context, Continuation<? super Unit> continuation) {
        Migrator$migrate$1 migrator$migrate$1;
        Object coroutine_suspended;
        int i5;
        int intValue;
        Migrator migrator;
        int i6;
        Migrator migrator2;
        Context context2;
        int i7;
        List<String> list;
        MutableStateFlow<MigrationState> migrationState;
        MigrationState value;
        int i8;
        Context context3;
        int i9;
        Migrator migrator3;
        Context context4 = context;
        if (continuation instanceof Migrator$migrate$1) {
            migrator$migrate$1 = (Migrator$migrate$1) continuation;
            int i10 = migrator$migrate$1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                migrator$migrate$1.label = i10 - Integer.MIN_VALUE;
                Object obj = migrator$migrate$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = migrator$migrate$1.label;
                int i11 = 3;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    intValue = ((Number) this.settings.latestValueFor(SettingsProperty.CurrentDataVersion.INSTANCE)).intValue();
                    Logger.log$default(Logger.INSTANCE, "Current DATA version: " + intValue, "Migrator", 0, 4, null);
                    if (intValue == 0) {
                        IOldAppDataMigrator iOldAppDataMigrator = this.oldAppDataMigrator;
                        migrator$migrate$1.L$0 = this;
                        migrator$migrate$1.L$1 = context4;
                        migrator$migrate$1.I$0 = intValue;
                        migrator$migrate$1.label = 1;
                        Object migrate = iOldAppDataMigrator.migrate(context4, migrator$migrate$1);
                        if (migrate == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        migrator2 = this;
                        context2 = context4;
                        i7 = intValue;
                        obj = migrate;
                    } else {
                        migrator = this;
                        i6 = intValue;
                        if (i6 < 3) {
                        }
                    }
                } else if (i5 == 1) {
                    int i12 = migrator$migrate$1.I$0;
                    Context context5 = (Context) migrator$migrate$1.L$1;
                    Migrator migrator4 = (Migrator) migrator$migrate$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    migrator2 = migrator4;
                    context2 = context5;
                    i7 = i12;
                } else {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        i9 = migrator$migrate$1.I$0;
                        migrator3 = (Migrator) migrator$migrate$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        intValue = i9;
                        migrator = migrator3;
                        if (intValue == i11) {
                            return Unit.INSTANCE;
                        }
                        Logger.log$default(Logger.INSTANCE, "DATA migrated to version " + i11, "Migrator", 0, 4, null);
                        ISettings iSettings = migrator.settings;
                        SettingsProperty.CurrentDataVersion currentDataVersion = SettingsProperty.CurrentDataVersion.INSTANCE;
                        Integer boxInt = Boxing.boxInt(i11);
                        migrator$migrate$1.L$0 = null;
                        migrator$migrate$1.L$1 = null;
                        migrator$migrate$1.label = 4;
                        if (iSettings.update(currentDataVersion, boxInt, migrator$migrate$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    i8 = migrator$migrate$1.I$0;
                    context3 = (Context) migrator$migrate$1.L$1;
                    migrator = (Migrator) migrator$migrate$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    intValue = i8;
                    context4 = context3;
                    i6 = 3;
                    if (i6 < 3) {
                        Logger.log$default(Logger.INSTANCE, "Migrating DATA from version " + i6 + " to 3", "Migrator", 0, 4, null);
                        migrator$migrate$1.L$0 = migrator;
                        migrator$migrate$1.L$1 = null;
                        migrator$migrate$1.I$0 = intValue;
                        migrator$migrate$1.label = 3;
                        if (migrator.migrate(i6, 3, context4, migrator$migrate$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i9 = intValue;
                        migrator3 = migrator;
                        intValue = i9;
                        migrator = migrator3;
                        if (intValue == i11) {
                        }
                    } else {
                        Logger.log$default(Logger.INSTANCE, "No DATA upgrade necessary", "Migrator", 0, 4, null);
                        i11 = i6;
                        if (intValue == i11) {
                        }
                    }
                }
                list = (List) obj;
                migrationState = migrator2.getMigrationState();
                do {
                    value = migrationState.getValue();
                } while (!migrationState.compareAndSet(value, value.copy(list)));
                migrator$migrate$1.L$0 = migrator2;
                migrator$migrate$1.L$1 = context2;
                migrator$migrate$1.I$0 = i7;
                migrator$migrate$1.label = 2;
                if (migrator2.setDefaultCurrencyFromLanguage(migrator$migrate$1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                i8 = i7;
                context3 = context2;
                migrator = migrator2;
                intValue = i8;
                context4 = context3;
                i6 = 3;
                if (i6 < 3) {
                }
            }
        }
        migrator$migrate$1 = new Migrator$migrate$1(this, continuation);
        Object obj2 = migrator$migrate$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = migrator$migrate$1.label;
        int i112 = 3;
        if (i5 != 0) {
        }
        list = (List) obj2;
        migrationState = migrator2.getMigrationState();
        do {
            value = migrationState.getValue();
        } while (!migrationState.compareAndSet(value, value.copy(list)));
        migrator$migrate$1.L$0 = migrator2;
        migrator$migrate$1.L$1 = context2;
        migrator$migrate$1.I$0 = i7;
        migrator$migrate$1.label = 2;
        if (migrator2.setDefaultCurrencyFromLanguage(migrator$migrate$1) != coroutine_suspended) {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/core/migration/Migrator$MigrationState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "migrationErrors", "<init>", "(Ljava/util/List;)V", "copy", "(Ljava/util/List;)Ldk/molslinjen/core/migration/Migrator$MigrationState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getMigrationErrors", "()Ljava/util/List;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class MigrationState {
        private final List<String> migrationErrors;

        public MigrationState(List<String> migrationErrors) {
            Intrinsics.checkNotNullParameter(migrationErrors, "migrationErrors");
            this.migrationErrors = migrationErrors;
        }

        public final MigrationState copy(List<String> migrationErrors) {
            Intrinsics.checkNotNullParameter(migrationErrors, "migrationErrors");
            return new MigrationState(migrationErrors);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MigrationState) && Intrinsics.areEqual(this.migrationErrors, ((MigrationState) other).migrationErrors);
        }

        public final List<String> getMigrationErrors() {
            return this.migrationErrors;
        }

        public int hashCode() {
            return this.migrationErrors.hashCode();
        }

        public String toString() {
            return "MigrationState(migrationErrors=" + this.migrationErrors + ")";
        }

        public /* synthetic */ MigrationState(List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? CollectionsKt.emptyList() : list);
        }
    }

    @Override // dk.molslinjen.core.migration.IMigrator
    public MutableStateFlow<MigrationState> getMigrationState() {
        return this.migrationState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object migrate(int i5, int i6, Context context, Continuation<? super Unit> continuation) {
        Migrator$migrate$3 migrator$migrate$3;
        Object coroutine_suspended;
        int i7;
        Migrator migrator;
        if (continuation instanceof Migrator$migrate$3) {
            migrator$migrate$3 = (Migrator$migrate$3) continuation;
            int i8 = migrator$migrate$3.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                migrator$migrate$3.label = i8 - Integer.MIN_VALUE;
                Object obj = migrator$migrate$3.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i7 = migrator$migrate$3.label;
                if (i7 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (i5 == i6) {
                        return Unit.INSTANCE;
                    }
                    migrator$migrate$3.L$0 = this;
                    migrator$migrate$3.L$1 = context;
                    migrator$migrate$3.I$0 = i5;
                    migrator$migrate$3.I$1 = i6;
                    migrator$migrate$3.label = 1;
                    if (migrateVersion(i5, context, migrator$migrate$3) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    migrator = this;
                } else {
                    if (i7 != 1) {
                        if (i7 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    i6 = migrator$migrate$3.I$1;
                    i5 = migrator$migrate$3.I$0;
                    context = (Context) migrator$migrate$3.L$1;
                    migrator = (Migrator) migrator$migrate$3.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                migrator$migrate$3.L$0 = null;
                migrator$migrate$3.L$1 = null;
                migrator$migrate$3.label = 2;
                if (migrator.migrate(i5 + 1, i6, context, migrator$migrate$3) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        migrator$migrate$3 = new Migrator$migrate$3(this, continuation);
        Object obj2 = migrator$migrate$3.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i7 = migrator$migrate$3.label;
        if (i7 != 0) {
        }
        migrator$migrate$3.L$0 = null;
        migrator$migrate$3.L$1 = null;
        migrator$migrate$3.label = 2;
        if (migrator.migrate(i5 + 1, i6, context, migrator$migrate$3) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
