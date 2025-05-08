package dk.molslinjen.core.migration.oldApp;

import android.content.Context;
import android.content.SharedPreferences;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.localstorage.agreements.multiride.IMultiRideRepository;
import dk.molslinjen.domain.localstorage.creditcard.ICreditCardsRepository;
import dk.molslinjen.domain.localstorage.passengers.IPassengerRepository;
import dk.molslinjen.domain.localstorage.saleOnBoardOrders.ISaleOnBoardOrdersRepository;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.UserInfoInput;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.kombardo.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001'BK\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010\"J\u001e\u0010$\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010\"J\u001e\u0010%\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010\"J\u001e\u0010&\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006("}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppDataMigrator;", "Ldk/molslinjen/core/migration/oldApp/IOldAppDataMigrator;", "context", "Landroid/content/Context;", "saleOnBoardOrdersRepository", "Ldk/molslinjen/domain/localstorage/saleOnBoardOrders/ISaleOnBoardOrdersRepository;", "passengerRepository", "Ldk/molslinjen/domain/localstorage/passengers/IPassengerRepository;", "ticketsManager", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "creditCardsRepository", "Ldk/molslinjen/domain/localstorage/creditcard/ICreditCardsRepository;", "multiRideRepository", "Ldk/molslinjen/domain/localstorage/agreements/multiride/IMultiRideRepository;", "multiRideManager", "Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "<init>", "(Landroid/content/Context;Ldk/molslinjen/domain/localstorage/saleOnBoardOrders/ISaleOnBoardOrdersRepository;Ldk/molslinjen/domain/localstorage/passengers/IPassengerRepository;Ldk/molslinjen/domain/managers/ticket/ITicketsManager;Ldk/molslinjen/domain/localstorage/creditcard/ICreditCardsRepository;Ldk/molslinjen/domain/localstorage/agreements/multiride/IMultiRideRepository;Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;Ldk/molslinjen/domain/managers/user/IUserManager;)V", "oldAppSharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "Landroid/content/SharedPreferences;", "migrate", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migrateSaleOnBoardOrders", "Ldk/molslinjen/core/migration/oldApp/OldAppDataMigrator$MigrationResult;", "migrateUserData", "migrateUserInfo", "oldAppUser", "Ldk/molslinjen/core/migration/oldApp/OldAppUser;", "(Ldk/molslinjen/core/migration/oldApp/OldAppUser;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migrateAgreements", "migratePassengers", "migrateBookings", "migrateCreditCards", "MigrationResult", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OldAppDataMigrator implements IOldAppDataMigrator {
    private final ICreditCardsRepository creditCardsRepository;
    private final IMultiRideManager multiRideManager;
    private final IMultiRideRepository multiRideRepository;
    private final SharedPreferences oldAppSharedPreferences;
    private final IPassengerRepository passengerRepository;
    private final ISaleOnBoardOrdersRepository saleOnBoardOrdersRepository;
    private final ITicketsManager ticketsManager;
    private final IUserManager userManager;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppDataMigrator$MigrationResult;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "resultMessage", BuildConfig.FLAVOR, "failed", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getResultMessage", "Ljava/util/List;", "getFailed", "()Ljava/util/List;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class MigrationResult {
        private final List<String> failed;
        private final String resultMessage;

        public MigrationResult(String resultMessage, List<String> failed) {
            Intrinsics.checkNotNullParameter(resultMessage, "resultMessage");
            Intrinsics.checkNotNullParameter(failed, "failed");
            this.resultMessage = resultMessage;
            this.failed = failed;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MigrationResult)) {
                return false;
            }
            MigrationResult migrationResult = (MigrationResult) other;
            return Intrinsics.areEqual(this.resultMessage, migrationResult.resultMessage) && Intrinsics.areEqual(this.failed, migrationResult.failed);
        }

        public final List<String> getFailed() {
            return this.failed;
        }

        public final String getResultMessage() {
            return this.resultMessage;
        }

        public int hashCode() {
            return (this.resultMessage.hashCode() * 31) + this.failed.hashCode();
        }

        public String toString() {
            return "MigrationResult(resultMessage=" + this.resultMessage + ", failed=" + this.failed + ")";
        }
    }

    public OldAppDataMigrator(Context context, ISaleOnBoardOrdersRepository saleOnBoardOrdersRepository, IPassengerRepository passengerRepository, ITicketsManager ticketsManager, ICreditCardsRepository creditCardsRepository, IMultiRideRepository multiRideRepository, IMultiRideManager multiRideManager, IUserManager userManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(saleOnBoardOrdersRepository, "saleOnBoardOrdersRepository");
        Intrinsics.checkNotNullParameter(passengerRepository, "passengerRepository");
        Intrinsics.checkNotNullParameter(ticketsManager, "ticketsManager");
        Intrinsics.checkNotNullParameter(creditCardsRepository, "creditCardsRepository");
        Intrinsics.checkNotNullParameter(multiRideRepository, "multiRideRepository");
        Intrinsics.checkNotNullParameter(multiRideManager, "multiRideManager");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        this.saleOnBoardOrdersRepository = saleOnBoardOrdersRepository;
        this.passengerRepository = passengerRepository;
        this.ticketsManager = ticketsManager;
        this.creditCardsRepository = creditCardsRepository;
        this.multiRideRepository = multiRideRepository;
        this.multiRideManager = multiRideManager;
        this.userManager = userManager;
        this.oldAppSharedPreferences = context.getSharedPreferences("SharedPreferences", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085 A[Catch: Exception -> 0x0140, TRY_LEAVE, TryCatch #0 {Exception -> 0x0140, blocks: (B:15:0x007f, B:17:0x0085, B:37:0x010f, B:50:0x006e), top: B:49:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b7 A[Catch: Exception -> 0x0068, TryCatch #1 {Exception -> 0x0068, blocks: (B:22:0x00b1, B:24:0x00b7, B:25:0x00d4, B:27:0x00d8, B:31:0x0109, B:32:0x010e, B:47:0x0064), top: B:46:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d4 A[Catch: Exception -> 0x0068, TryCatch #1 {Exception -> 0x0068, blocks: (B:22:0x00b1, B:24:0x00b7, B:25:0x00d4, B:27:0x00d8, B:31:0x0109, B:32:0x010e, B:47:0x0064), top: B:46:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010f A[Catch: Exception -> 0x0140, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0140, blocks: (B:15:0x007f, B:17:0x0085, B:37:0x010f, B:50:0x006e), top: B:49:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00b7 -> B:15:0x007f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00f8 -> B:13:0x00fd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object migrateAgreements(OldAppUser oldAppUser, Context context, Continuation<? super MigrationResult> continuation) {
        OldAppDataMigrator$migrateAgreements$1 oldAppDataMigrator$migrateAgreements$1;
        int i5;
        ArrayList arrayList;
        List<OldAppAgreement> agreements;
        Iterator it;
        OldAppDataMigrator oldAppDataMigrator;
        Context context2;
        Iterator it2;
        OldAppAgreement oldAppAgreement;
        OldAppDataMigrator oldAppDataMigrator2;
        ArrayList arrayList2;
        List<OldAppAgreement> list;
        ManagerResult managerResult;
        if (continuation instanceof OldAppDataMigrator$migrateAgreements$1) {
            oldAppDataMigrator$migrateAgreements$1 = (OldAppDataMigrator$migrateAgreements$1) continuation;
            int i6 = oldAppDataMigrator$migrateAgreements$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                oldAppDataMigrator$migrateAgreements$1.label = i6 - Integer.MIN_VALUE;
                Object obj = oldAppDataMigrator$migrateAgreements$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = oldAppDataMigrator$migrateAgreements$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        arrayList = new ArrayList();
                        agreements = oldAppUser.getAgreements();
                        it = agreements.iterator();
                        oldAppDataMigrator = this;
                        if (!it.hasNext()) {
                        }
                    } catch (Exception unused) {
                        return new MigrationResult("Failed to migrated agreements.", CollectionsKt.listOf(context.getString(R.string.migration_agreements)));
                    }
                } else if (i5 == 1) {
                    oldAppAgreement = (OldAppAgreement) oldAppDataMigrator$migrateAgreements$1.L$5;
                    it2 = (Iterator) oldAppDataMigrator$migrateAgreements$1.L$4;
                    list = (List) oldAppDataMigrator$migrateAgreements$1.L$3;
                    ?? r5 = (List) oldAppDataMigrator$migrateAgreements$1.L$2;
                    context2 = (Context) oldAppDataMigrator$migrateAgreements$1.L$1;
                    oldAppDataMigrator2 = (OldAppDataMigrator) oldAppDataMigrator$migrateAgreements$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        arrayList2 = r5;
                        managerResult = (ManagerResult) obj;
                        if (managerResult instanceof ManagerResult.Error) {
                        }
                    } catch (Exception unused2) {
                        context = context2;
                        return new MigrationResult("Failed to migrated agreements.", CollectionsKt.listOf(context.getString(R.string.migration_agreements)));
                    }
                } else {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Iterator it3 = (Iterator) oldAppDataMigrator$migrateAgreements$1.L$4;
                    List<OldAppAgreement> list2 = (List) oldAppDataMigrator$migrateAgreements$1.L$3;
                    ?? r22 = (List) oldAppDataMigrator$migrateAgreements$1.L$2;
                    Context context3 = (Context) oldAppDataMigrator$migrateAgreements$1.L$1;
                    OldAppDataMigrator oldAppDataMigrator3 = (OldAppDataMigrator) oldAppDataMigrator$migrateAgreements$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        ArrayList arrayList3 = r22;
                        ((Boolean) obj).booleanValue();
                        arrayList = arrayList3;
                        it = it3;
                        agreements = list2;
                        context = context3;
                        oldAppDataMigrator = oldAppDataMigrator3;
                        if (!it.hasNext()) {
                            OldAppAgreement oldAppAgreement2 = (OldAppAgreement) it.next();
                            IMultiRideManager iMultiRideManager = oldAppDataMigrator.multiRideManager;
                            String number = oldAppAgreement2.getNumber();
                            Site site = Site.Mols;
                            oldAppDataMigrator$migrateAgreements$1.L$0 = oldAppDataMigrator;
                            oldAppDataMigrator$migrateAgreements$1.L$1 = context;
                            oldAppDataMigrator$migrateAgreements$1.L$2 = arrayList;
                            oldAppDataMigrator$migrateAgreements$1.L$3 = agreements;
                            oldAppDataMigrator$migrateAgreements$1.L$4 = it;
                            oldAppDataMigrator$migrateAgreements$1.L$5 = oldAppAgreement2;
                            oldAppDataMigrator$migrateAgreements$1.label = 1;
                            Object multiRide = iMultiRideManager.getMultiRide(number, site, oldAppDataMigrator$migrateAgreements$1);
                            if (multiRide == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Iterator it4 = it;
                            list = agreements;
                            oldAppAgreement = oldAppAgreement2;
                            context2 = context;
                            it2 = it4;
                            OldAppDataMigrator oldAppDataMigrator4 = oldAppDataMigrator;
                            arrayList2 = arrayList;
                            obj = multiRide;
                            oldAppDataMigrator2 = oldAppDataMigrator4;
                            managerResult = (ManagerResult) obj;
                            if (managerResult instanceof ManagerResult.Error) {
                                String string = context2.getString(R.string.migration_agreements_specific, oldAppAgreement.getNumber());
                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                arrayList2.add(string);
                                agreements = list;
                                arrayList = arrayList2;
                                oldAppDataMigrator = oldAppDataMigrator2;
                                it = it2;
                                context = context2;
                                if (!it.hasNext()) {
                                }
                            } else {
                                if (!(managerResult instanceof ManagerResult.Success)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                IMultiRideRepository iMultiRideRepository = oldAppDataMigrator2.multiRideRepository;
                                MultiRideCard multiRideCard = (MultiRideCard) ((ManagerResult.Success) managerResult).getData();
                                oldAppDataMigrator$migrateAgreements$1.L$0 = oldAppDataMigrator2;
                                oldAppDataMigrator$migrateAgreements$1.L$1 = context2;
                                oldAppDataMigrator$migrateAgreements$1.L$2 = arrayList2;
                                oldAppDataMigrator$migrateAgreements$1.L$3 = list;
                                oldAppDataMigrator$migrateAgreements$1.L$4 = it2;
                                oldAppDataMigrator$migrateAgreements$1.L$5 = null;
                                oldAppDataMigrator$migrateAgreements$1.label = 2;
                                obj = iMultiRideRepository.save(multiRideCard, oldAppDataMigrator$migrateAgreements$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                it3 = it2;
                                list2 = list;
                                arrayList3 = arrayList2;
                                context3 = context2;
                                oldAppDataMigrator3 = oldAppDataMigrator2;
                                ((Boolean) obj).booleanValue();
                                arrayList = arrayList3;
                                it = it3;
                                agreements = list2;
                                context = context3;
                                oldAppDataMigrator = oldAppDataMigrator3;
                                if (!it.hasNext()) {
                                    return new MigrationResult("Migrated " + (agreements.size() - arrayList.size()) + " of " + agreements.size() + " agreements.", arrayList);
                                }
                            }
                        }
                    } catch (Exception unused3) {
                        context = context3;
                        return new MigrationResult("Failed to migrated agreements.", CollectionsKt.listOf(context.getString(R.string.migration_agreements)));
                    }
                }
            }
        }
        oldAppDataMigrator$migrateAgreements$1 = new OldAppDataMigrator$migrateAgreements$1(this, continuation);
        Object obj2 = oldAppDataMigrator$migrateAgreements$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = oldAppDataMigrator$migrateAgreements$1.label;
        if (i5 != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|(3:(1:(4:10|11|12|13)(2:34|35))(6:36|37|38|39|22|(1:24)(1:25))|30|31)(4:42|43|44|45)|14|15|(2:17|(1:19)(3:21|22|(0)(0)))(2:26|28)))|48|6|(0)(0)|14|15|(0)(0)) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009a A[Catch: Exception -> 0x0127, TryCatch #2 {Exception -> 0x0127, blocks: (B:15:0x0094, B:17:0x009a, B:22:0x00d0, B:26:0x00f4), top: B:14:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ec A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f4 A[Catch: Exception -> 0x0127, TRY_LEAVE, TryCatch #2 {Exception -> 0x0127, blocks: (B:15:0x0094, B:17:0x009a, B:22:0x00d0, B:26:0x00f4), top: B:14:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00ed -> B:14:0x0094). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object migrateBookings(OldAppUser oldAppUser, Context context, Continuation<? super MigrationResult> continuation) {
        OldAppDataMigrator$migrateBookings$1 oldAppDataMigrator$migrateBookings$1;
        OldAppDataMigrator oldAppDataMigrator;
        int i5;
        Context context2;
        OldAppDataMigrator oldAppDataMigrator2;
        Iterator it;
        List<OldAppBooking> list;
        OldAppDataMigrator$migrateBookings$1 oldAppDataMigrator$migrateBookings$12;
        ArrayList arrayList;
        Object obj;
        OldAppDataMigrator oldAppDataMigrator3;
        ArrayList arrayList2;
        List<OldAppBooking> list2;
        Iterator it2;
        OldAppBooking oldAppBooking;
        OldAppDataMigrator$migrateBookings$2$1 oldAppDataMigrator$migrateBookings$2$1;
        if (continuation instanceof OldAppDataMigrator$migrateBookings$1) {
            oldAppDataMigrator$migrateBookings$1 = (OldAppDataMigrator$migrateBookings$1) continuation;
            int i6 = oldAppDataMigrator$migrateBookings$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                oldAppDataMigrator$migrateBookings$1.label = i6 - Integer.MIN_VALUE;
                oldAppDataMigrator = this;
                Object obj2 = oldAppDataMigrator$migrateBookings$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = oldAppDataMigrator$migrateBookings$1.label;
                if (i5 == 0) {
                    if (i5 == 1) {
                        oldAppBooking = (OldAppBooking) oldAppDataMigrator$migrateBookings$1.L$5;
                        it2 = (Iterator) oldAppDataMigrator$migrateBookings$1.L$4;
                        list2 = (List) oldAppDataMigrator$migrateBookings$1.L$3;
                        ?? r9 = (List) oldAppDataMigrator$migrateBookings$1.L$2;
                        Context context3 = (Context) oldAppDataMigrator$migrateBookings$1.L$1;
                        OldAppDataMigrator oldAppDataMigrator4 = (OldAppDataMigrator) oldAppDataMigrator$migrateBookings$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            obj = obj2;
                            context2 = context3;
                            oldAppDataMigrator3 = oldAppDataMigrator4;
                            arrayList2 = r9;
                            oldAppDataMigrator$migrateBookings$2$1 = new OldAppDataMigrator$migrateBookings$2$1(arrayList2, context2, oldAppBooking, null);
                            oldAppDataMigrator$migrateBookings$1.L$0 = oldAppDataMigrator3;
                            oldAppDataMigrator$migrateBookings$1.L$1 = context2;
                            oldAppDataMigrator$migrateBookings$1.L$2 = arrayList2;
                            oldAppDataMigrator$migrateBookings$1.L$3 = list2;
                            oldAppDataMigrator$migrateBookings$1.L$4 = it2;
                            oldAppDataMigrator$migrateBookings$1.L$5 = null;
                            oldAppDataMigrator$migrateBookings$1.label = 2;
                            if (ManagerResultExtensionsKt.onFailure((ManagerResult) obj, oldAppDataMigrator$migrateBookings$2$1, oldAppDataMigrator$migrateBookings$1) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            oldAppDataMigrator$migrateBookings$12 = oldAppDataMigrator$migrateBookings$1;
                            arrayList = arrayList2;
                            oldAppDataMigrator2 = oldAppDataMigrator3;
                            List<OldAppBooking> list3 = list2;
                            it = it2;
                            list = list3;
                        } catch (Exception unused) {
                            context2 = context3;
                        }
                    } else {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Iterator it3 = (Iterator) oldAppDataMigrator$migrateBookings$1.L$4;
                        list = (List) oldAppDataMigrator$migrateBookings$1.L$3;
                        ?? r8 = (List) oldAppDataMigrator$migrateBookings$1.L$2;
                        Context context4 = (Context) oldAppDataMigrator$migrateBookings$1.L$1;
                        OldAppDataMigrator oldAppDataMigrator5 = (OldAppDataMigrator) oldAppDataMigrator$migrateBookings$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            context2 = context4;
                            oldAppDataMigrator2 = oldAppDataMigrator5;
                            oldAppDataMigrator$migrateBookings$12 = oldAppDataMigrator$migrateBookings$1;
                            arrayList = r8;
                            it = it3;
                        } catch (Exception unused2) {
                            context2 = context4;
                        }
                    }
                    return new MigrationResult("Failed to migrated bookings.", CollectionsKt.listOf(context2.getString(R.string.migration_bookings)));
                }
                ResultKt.throwOnFailure(obj2);
                try {
                    ArrayList arrayList3 = new ArrayList();
                    List<OldAppBooking> activeBookings = oldAppUser.getActiveBookings();
                    oldAppDataMigrator2 = oldAppDataMigrator;
                    it = activeBookings.iterator();
                    list = activeBookings;
                    oldAppDataMigrator$migrateBookings$12 = oldAppDataMigrator$migrateBookings$1;
                    arrayList = arrayList3;
                    context2 = context;
                } catch (Exception unused3) {
                    context2 = context;
                }
                if (it.hasNext()) {
                    return new MigrationResult("Migrated " + (list.size() - arrayList.size()) + " of " + list.size() + " bookings.", arrayList);
                }
                OldAppBooking oldAppBooking2 = (OldAppBooking) it.next();
                ITicketsManager iTicketsManager = oldAppDataMigrator2.ticketsManager;
                PhoneNumber phoneNumber = new PhoneNumber(BuildConfig.FLAVOR, oldAppBooking2.getPhoneNumber());
                String reservationNumber = oldAppBooking2.getReservationNumber();
                oldAppDataMigrator$migrateBookings$12.L$0 = oldAppDataMigrator2;
                oldAppDataMigrator$migrateBookings$12.L$1 = context2;
                oldAppDataMigrator$migrateBookings$12.L$2 = arrayList;
                oldAppDataMigrator$migrateBookings$12.L$3 = list;
                oldAppDataMigrator$migrateBookings$12.L$4 = it;
                oldAppDataMigrator$migrateBookings$12.L$5 = oldAppBooking2;
                oldAppDataMigrator$migrateBookings$12.label = 1;
                obj = iTicketsManager.addTicket(phoneNumber, reservationNumber, oldAppDataMigrator$migrateBookings$12);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                OldAppDataMigrator oldAppDataMigrator6 = oldAppDataMigrator2;
                arrayList2 = arrayList;
                oldAppDataMigrator$migrateBookings$1 = oldAppDataMigrator$migrateBookings$12;
                oldAppBooking = oldAppBooking2;
                oldAppDataMigrator3 = oldAppDataMigrator6;
                Iterator it4 = it;
                list2 = list;
                it2 = it4;
                oldAppDataMigrator$migrateBookings$2$1 = new OldAppDataMigrator$migrateBookings$2$1(arrayList2, context2, oldAppBooking, null);
                oldAppDataMigrator$migrateBookings$1.L$0 = oldAppDataMigrator3;
                oldAppDataMigrator$migrateBookings$1.L$1 = context2;
                oldAppDataMigrator$migrateBookings$1.L$2 = arrayList2;
                oldAppDataMigrator$migrateBookings$1.L$3 = list2;
                oldAppDataMigrator$migrateBookings$1.L$4 = it2;
                oldAppDataMigrator$migrateBookings$1.L$5 = null;
                oldAppDataMigrator$migrateBookings$1.label = 2;
                if (ManagerResultExtensionsKt.onFailure((ManagerResult) obj, oldAppDataMigrator$migrateBookings$2$1, oldAppDataMigrator$migrateBookings$1) != coroutine_suspended) {
                }
            }
        }
        oldAppDataMigrator = this;
        oldAppDataMigrator$migrateBookings$1 = new OldAppDataMigrator$migrateBookings$1(oldAppDataMigrator, continuation);
        Object obj22 = oldAppDataMigrator$migrateBookings$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = oldAppDataMigrator$migrateBookings$1.label;
        if (i5 == 0) {
        }
        if (it.hasNext()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007f A[Catch: Exception -> 0x0098, TryCatch #2 {Exception -> 0x0098, blocks: (B:15:0x0079, B:17:0x007f, B:24:0x009a), top: B:14:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object migrateCreditCards(OldAppUser oldAppUser, Context context, Continuation<? super MigrationResult> continuation) {
        OldAppDataMigrator$migrateCreditCards$1 oldAppDataMigrator$migrateCreditCards$1;
        Object coroutine_suspended;
        int i5;
        Iterator it;
        OldAppDataMigrator oldAppDataMigrator;
        Context context2;
        List list;
        CreditCard creditCard;
        ICreditCardsRepository iCreditCardsRepository;
        if (continuation instanceof OldAppDataMigrator$migrateCreditCards$1) {
            oldAppDataMigrator$migrateCreditCards$1 = (OldAppDataMigrator$migrateCreditCards$1) continuation;
            int i6 = oldAppDataMigrator$migrateCreditCards$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                oldAppDataMigrator$migrateCreditCards$1.label = i6 - Integer.MIN_VALUE;
                Object obj = oldAppDataMigrator$migrateCreditCards$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = oldAppDataMigrator$migrateCreditCards$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        List<OldAppCreditCard> creditCards = oldAppUser.getCreditCards();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(creditCards, 10));
                        Iterator<T> it2 = creditCards.iterator();
                        while (it2.hasNext()) {
                            arrayList.add(((OldAppCreditCard) it2.next()).toCreditCard());
                        }
                        it = arrayList.iterator();
                        oldAppDataMigrator = this;
                        context2 = context;
                        list = arrayList;
                    } catch (Exception unused) {
                        return new MigrationResult("Failed to migrated credit cards.", CollectionsKt.listOf(context.getString(R.string.migration_creditCards)));
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) oldAppDataMigrator$migrateCreditCards$1.L$3;
                    list = (List) oldAppDataMigrator$migrateCreditCards$1.L$2;
                    Context context3 = (Context) oldAppDataMigrator$migrateCreditCards$1.L$1;
                    oldAppDataMigrator = (OldAppDataMigrator) oldAppDataMigrator$migrateCreditCards$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        context2 = context3;
                    } catch (Exception unused2) {
                        context = context3;
                        return new MigrationResult("Failed to migrated credit cards.", CollectionsKt.listOf(context.getString(R.string.migration_creditCards)));
                    }
                }
                do {
                    try {
                        if (it.hasNext()) {
                            return new MigrationResult("Migrated " + list.size() + " credit cards.", CollectionsKt.emptyList());
                        }
                        creditCard = (CreditCard) it.next();
                        iCreditCardsRepository = oldAppDataMigrator.creditCardsRepository;
                        oldAppDataMigrator$migrateCreditCards$1.L$0 = oldAppDataMigrator;
                        oldAppDataMigrator$migrateCreditCards$1.L$1 = context2;
                        oldAppDataMigrator$migrateCreditCards$1.L$2 = list;
                        oldAppDataMigrator$migrateCreditCards$1.L$3 = it;
                        oldAppDataMigrator$migrateCreditCards$1.label = 1;
                    } catch (Exception unused3) {
                        context = context2;
                        return new MigrationResult("Failed to migrated credit cards.", CollectionsKt.listOf(context.getString(R.string.migration_creditCards)));
                    }
                } while (iCreditCardsRepository.save(creditCard, oldAppDataMigrator$migrateCreditCards$1) != coroutine_suspended);
                return coroutine_suspended;
            }
        }
        oldAppDataMigrator$migrateCreditCards$1 = new OldAppDataMigrator$migrateCreditCards$1(this, continuation);
        Object obj2 = oldAppDataMigrator$migrateCreditCards$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = oldAppDataMigrator$migrateCreditCards$1.label;
        if (i5 != 0) {
        }
        do {
            if (it.hasNext()) {
            }
        } while (iCreditCardsRepository.save(creditCard, oldAppDataMigrator$migrateCreditCards$1) != coroutine_suspended);
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007f A[Catch: Exception -> 0x0098, TryCatch #2 {Exception -> 0x0098, blocks: (B:15:0x0079, B:17:0x007f, B:24:0x009a), top: B:14:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object migratePassengers(OldAppUser oldAppUser, Context context, Continuation<? super MigrationResult> continuation) {
        OldAppDataMigrator$migratePassengers$1 oldAppDataMigrator$migratePassengers$1;
        Object coroutine_suspended;
        int i5;
        Iterator it;
        OldAppDataMigrator oldAppDataMigrator;
        Context context2;
        List list;
        UserPassenger userPassenger;
        IPassengerRepository iPassengerRepository;
        if (continuation instanceof OldAppDataMigrator$migratePassengers$1) {
            oldAppDataMigrator$migratePassengers$1 = (OldAppDataMigrator$migratePassengers$1) continuation;
            int i6 = oldAppDataMigrator$migratePassengers$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                oldAppDataMigrator$migratePassengers$1.label = i6 - Integer.MIN_VALUE;
                Object obj = oldAppDataMigrator$migratePassengers$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = oldAppDataMigrator$migratePassengers$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        List<OldAppPassenger> passengers = oldAppUser.getPassengers();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(passengers, 10));
                        Iterator<T> it2 = passengers.iterator();
                        while (it2.hasNext()) {
                            arrayList.add(((OldAppPassenger) it2.next()).toPassenger());
                        }
                        it = arrayList.iterator();
                        oldAppDataMigrator = this;
                        context2 = context;
                        list = arrayList;
                    } catch (Exception unused) {
                        return new MigrationResult("Failed to migrated passengers.", CollectionsKt.listOf(context.getString(R.string.migration_passengers)));
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) oldAppDataMigrator$migratePassengers$1.L$3;
                    list = (List) oldAppDataMigrator$migratePassengers$1.L$2;
                    Context context3 = (Context) oldAppDataMigrator$migratePassengers$1.L$1;
                    oldAppDataMigrator = (OldAppDataMigrator) oldAppDataMigrator$migratePassengers$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        context2 = context3;
                    } catch (Exception unused2) {
                        context = context3;
                        return new MigrationResult("Failed to migrated passengers.", CollectionsKt.listOf(context.getString(R.string.migration_passengers)));
                    }
                }
                do {
                    try {
                        if (it.hasNext()) {
                            return new MigrationResult("Migrated " + list.size() + " passengers.", CollectionsKt.emptyList());
                        }
                        userPassenger = (UserPassenger) it.next();
                        iPassengerRepository = oldAppDataMigrator.passengerRepository;
                        oldAppDataMigrator$migratePassengers$1.L$0 = oldAppDataMigrator;
                        oldAppDataMigrator$migratePassengers$1.L$1 = context2;
                        oldAppDataMigrator$migratePassengers$1.L$2 = list;
                        oldAppDataMigrator$migratePassengers$1.L$3 = it;
                        oldAppDataMigrator$migratePassengers$1.label = 1;
                    } catch (Exception unused3) {
                        context = context2;
                        return new MigrationResult("Failed to migrated passengers.", CollectionsKt.listOf(context.getString(R.string.migration_passengers)));
                    }
                } while (iPassengerRepository.save(userPassenger, oldAppDataMigrator$migratePassengers$1) != coroutine_suspended);
                return coroutine_suspended;
            }
        }
        oldAppDataMigrator$migratePassengers$1 = new OldAppDataMigrator$migratePassengers$1(this, continuation);
        Object obj2 = oldAppDataMigrator$migratePassengers$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = oldAppDataMigrator$migratePassengers$1.label;
        if (i5 != 0) {
        }
        do {
            if (it.hasNext()) {
            }
        } while (iPassengerRepository.save(userPassenger, oldAppDataMigrator$migratePassengers$1) != coroutine_suspended);
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a0 A[Catch: Exception -> 0x00b9, TryCatch #2 {Exception -> 0x00b9, blocks: (B:17:0x009a, B:19:0x00a0, B:26:0x00bb), top: B:16:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0083 A[Catch: Exception -> 0x00df, LOOP:1: B:39:0x007d->B:41:0x0083, LOOP_END, TryCatch #0 {Exception -> 0x00df, blocks: (B:37:0x0050, B:38:0x006a, B:39:0x007d, B:41:0x0083, B:43:0x0091, B:47:0x0057), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object migrateSaleOnBoardOrders(Context context, Continuation<? super MigrationResult> continuation) {
        OldAppDataMigrator$migrateSaleOnBoardOrders$1 oldAppDataMigrator$migrateSaleOnBoardOrders$1;
        Object coroutine_suspended;
        int i5;
        OldAppDataMigrator oldAppDataMigrator;
        Iterator it;
        OldAppDataMigrator oldAppDataMigrator2;
        List list;
        Context context2;
        Iterator it2;
        SaleOnBoardOrder saleOnBoardOrder;
        ISaleOnBoardOrdersRepository iSaleOnBoardOrdersRepository;
        try {
            if (continuation instanceof OldAppDataMigrator$migrateSaleOnBoardOrders$1) {
                oldAppDataMigrator$migrateSaleOnBoardOrders$1 = (OldAppDataMigrator$migrateSaleOnBoardOrders$1) continuation;
                int i6 = oldAppDataMigrator$migrateSaleOnBoardOrders$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    oldAppDataMigrator$migrateSaleOnBoardOrders$1.label = i6 - Integer.MIN_VALUE;
                    Object obj = oldAppDataMigrator$migrateSaleOnBoardOrders$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = oldAppDataMigrator$migrateSaleOnBoardOrders$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        OldAppSaleOnBoardRepository oldAppSaleOnBoardRepository = new OldAppSaleOnBoardRepository(context);
                        oldAppDataMigrator$migrateSaleOnBoardOrders$1.L$0 = this;
                        oldAppDataMigrator$migrateSaleOnBoardOrders$1.L$1 = context;
                        oldAppDataMigrator$migrateSaleOnBoardOrders$1.label = 1;
                        obj = oldAppSaleOnBoardRepository.getOrders(oldAppDataMigrator$migrateSaleOnBoardOrders$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        oldAppDataMigrator = this;
                    } else {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            it2 = (Iterator) oldAppDataMigrator$migrateSaleOnBoardOrders$1.L$3;
                            list = (List) oldAppDataMigrator$migrateSaleOnBoardOrders$1.L$2;
                            Context context3 = (Context) oldAppDataMigrator$migrateSaleOnBoardOrders$1.L$1;
                            oldAppDataMigrator2 = (OldAppDataMigrator) oldAppDataMigrator$migrateSaleOnBoardOrders$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                context2 = context3;
                                do {
                                    try {
                                        if (!it2.hasNext()) {
                                            return new MigrationResult("Migrated " + list.size() + " sale on board orders.", CollectionsKt.emptyList());
                                        }
                                        saleOnBoardOrder = (SaleOnBoardOrder) it2.next();
                                        iSaleOnBoardOrdersRepository = oldAppDataMigrator2.saleOnBoardOrdersRepository;
                                        oldAppDataMigrator$migrateSaleOnBoardOrders$1.L$0 = oldAppDataMigrator2;
                                        oldAppDataMigrator$migrateSaleOnBoardOrders$1.L$1 = context2;
                                        oldAppDataMigrator$migrateSaleOnBoardOrders$1.L$2 = list;
                                        oldAppDataMigrator$migrateSaleOnBoardOrders$1.L$3 = it2;
                                        oldAppDataMigrator$migrateSaleOnBoardOrders$1.label = 2;
                                    } catch (Exception unused) {
                                        context = context2;
                                        return new MigrationResult("Failed to migrated sale on board orders.", CollectionsKt.listOf(context.getString(R.string.migration_saleOnBoardOrders)));
                                    }
                                } while (iSaleOnBoardOrdersRepository.add(saleOnBoardOrder, oldAppDataMigrator$migrateSaleOnBoardOrders$1) != coroutine_suspended);
                                return coroutine_suspended;
                            } catch (Exception unused2) {
                                context = context3;
                                return new MigrationResult("Failed to migrated sale on board orders.", CollectionsKt.listOf(context.getString(R.string.migration_saleOnBoardOrders)));
                            }
                        }
                        context = (Context) oldAppDataMigrator$migrateSaleOnBoardOrders$1.L$1;
                        oldAppDataMigrator = (OldAppDataMigrator) oldAppDataMigrator$migrateSaleOnBoardOrders$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    List list2 = (List) obj;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((OldAppSaleOnBoardOrder) it.next()).toSaleOnBoardOrder());
                    }
                    oldAppDataMigrator2 = oldAppDataMigrator;
                    list = arrayList;
                    context2 = context;
                    it2 = arrayList.iterator();
                    do {
                        if (!it2.hasNext()) {
                        }
                    } while (iSaleOnBoardOrdersRepository.add(saleOnBoardOrder, oldAppDataMigrator$migrateSaleOnBoardOrders$1) != coroutine_suspended);
                    return coroutine_suspended;
                }
            }
            if (i5 != 0) {
            }
            List list22 = (List) obj;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list22, 10));
            it = list22.iterator();
            while (it.hasNext()) {
            }
            oldAppDataMigrator2 = oldAppDataMigrator;
            list = arrayList2;
            context2 = context;
            it2 = arrayList2.iterator();
            do {
                if (!it2.hasNext()) {
                }
            } while (iSaleOnBoardOrdersRepository.add(saleOnBoardOrder, oldAppDataMigrator$migrateSaleOnBoardOrders$1) != coroutine_suspended);
            return coroutine_suspended;
        } catch (Exception unused3) {
        }
        oldAppDataMigrator$migrateSaleOnBoardOrders$1 = new OldAppDataMigrator$migrateSaleOnBoardOrders$1(this, continuation);
        Object obj2 = oldAppDataMigrator$migrateSaleOnBoardOrders$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = oldAppDataMigrator$migrateSaleOnBoardOrders$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073 A[Catch: Exception -> 0x0099, TryCatch #0 {Exception -> 0x0099, blocks: (B:23:0x0047, B:25:0x006e, B:27:0x0073, B:29:0x0078, B:35:0x004f), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0078 A[Catch: Exception -> 0x0099, TRY_LEAVE, TryCatch #0 {Exception -> 0x0099, blocks: (B:23:0x0047, B:25:0x006e, B:27:0x0073, B:29:0x0078, B:35:0x004f), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object migrateUserData(Context context, Continuation<? super List<MigrationResult>> continuation) {
        OldAppDataMigrator$migrateUserData$1 oldAppDataMigrator$migrateUserData$1;
        int i5;
        OldAppDataMigrator oldAppDataMigrator;
        OldAppUser oldAppUser;
        try {
            if (continuation instanceof OldAppDataMigrator$migrateUserData$1) {
                oldAppDataMigrator$migrateUserData$1 = (OldAppDataMigrator$migrateUserData$1) continuation;
                int i6 = oldAppDataMigrator$migrateUserData$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    oldAppDataMigrator$migrateUserData$1.label = i6 - Integer.MIN_VALUE;
                    Object obj = oldAppDataMigrator$migrateUserData$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = oldAppDataMigrator$migrateUserData$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        OldAppUserRepository oldAppUserRepository = new OldAppUserRepository(context);
                        Logger.log$default(Logger.INSTANCE, "Starting old app user migration", "OldAppDataMigrator", 0, 4, null);
                        oldAppDataMigrator$migrateUserData$1.L$0 = this;
                        oldAppDataMigrator$migrateUserData$1.L$1 = context;
                        oldAppDataMigrator$migrateUserData$1.label = 1;
                        obj = oldAppUserRepository.getUser(oldAppDataMigrator$migrateUserData$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        oldAppDataMigrator = this;
                    } else {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            List list = (List) oldAppDataMigrator$migrateUserData$1.L$1;
                            Context context2 = (Context) oldAppDataMigrator$migrateUserData$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                return list;
                            } catch (Exception unused) {
                                context = context2;
                                return CollectionsKt.listOf(new MigrationResult("Failed to migrated user data.", CollectionsKt.listOf(context.getString(R.string.migration_userData))));
                            }
                        }
                        context = (Context) oldAppDataMigrator$migrateUserData$1.L$1;
                        OldAppDataMigrator oldAppDataMigrator2 = (OldAppDataMigrator) oldAppDataMigrator$migrateUserData$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        oldAppDataMigrator = oldAppDataMigrator2;
                    }
                    oldAppUser = (OldAppUser) obj;
                    if (oldAppUser != null) {
                        return CollectionsKt.emptyList();
                    }
                    ArrayList arrayList = new ArrayList();
                    CoroutineDispatcher io2 = Dispatchers.getIO();
                    OldAppDataMigrator$migrateUserData$2 oldAppDataMigrator$migrateUserData$2 = new OldAppDataMigrator$migrateUserData$2(arrayList, oldAppDataMigrator, oldAppUser, context, null);
                    oldAppDataMigrator$migrateUserData$1.L$0 = context;
                    oldAppDataMigrator$migrateUserData$1.L$1 = arrayList;
                    oldAppDataMigrator$migrateUserData$1.label = 2;
                    return BuildersKt.withContext(io2, oldAppDataMigrator$migrateUserData$2, oldAppDataMigrator$migrateUserData$1) == coroutine_suspended ? coroutine_suspended : arrayList;
                }
            }
            if (i5 != 0) {
            }
            oldAppUser = (OldAppUser) obj;
            if (oldAppUser != null) {
            }
        } catch (Exception unused2) {
        }
        oldAppDataMigrator$migrateUserData$1 = new OldAppDataMigrator$migrateUserData$1(this, continuation);
        Object obj2 = oldAppDataMigrator$migrateUserData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = oldAppDataMigrator$migrateUserData$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object migrateUserInfo(OldAppUser oldAppUser, Context context, Continuation<? super MigrationResult> continuation) {
        OldAppDataMigrator$migrateUserInfo$1 oldAppDataMigrator$migrateUserInfo$1;
        int i5;
        try {
            if (continuation instanceof OldAppDataMigrator$migrateUserInfo$1) {
                oldAppDataMigrator$migrateUserInfo$1 = (OldAppDataMigrator$migrateUserInfo$1) continuation;
                int i6 = oldAppDataMigrator$migrateUserInfo$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    oldAppDataMigrator$migrateUserInfo$1.label = i6 - Integer.MIN_VALUE;
                    Object obj = oldAppDataMigrator$migrateUserInfo$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = oldAppDataMigrator$migrateUserInfo$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        UserInfoInput userInput = oldAppUser.toUserInput();
                        IUserManager iUserManager = this.userManager;
                        oldAppDataMigrator$migrateUserInfo$1.L$0 = context;
                        oldAppDataMigrator$migrateUserInfo$1.label = 1;
                        if (iUserManager.updateUser(userInput, oldAppDataMigrator$migrateUserInfo$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i5 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        context = (Context) oldAppDataMigrator$migrateUserInfo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    return new MigrationResult("Migrated user info.", CollectionsKt.emptyList());
                }
            }
            if (i5 != 0) {
            }
            return new MigrationResult("Migrated user info.", CollectionsKt.emptyList());
        } catch (Exception unused) {
            return new MigrationResult("Failed to migrated user info.", CollectionsKt.listOf(context.getString(R.string.migration_userData)));
        }
        oldAppDataMigrator$migrateUserInfo$1 = new OldAppDataMigrator$migrateUserInfo$1(this, continuation);
        Object obj2 = oldAppDataMigrator$migrateUserInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = oldAppDataMigrator$migrateUserInfo$1.label;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0147 A[LOOP:2: B:22:0x0141->B:24:0x0147, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.util.List] */
    @Override // dk.molslinjen.core.migration.oldApp.IOldAppDataMigrator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object migrate(Context context, Continuation<? super List<String>> continuation) {
        OldAppDataMigrator$migrate$1 oldAppDataMigrator$migrate$1;
        int i5;
        int i6;
        int i7;
        ArrayList arrayList;
        Object migrateSaleOnBoardOrders;
        OldAppDataMigrator oldAppDataMigrator;
        List list;
        int i8;
        Iterator it;
        ArrayList arrayList2;
        Context context2 = context;
        if (continuation instanceof OldAppDataMigrator$migrate$1) {
            oldAppDataMigrator$migrate$1 = (OldAppDataMigrator$migrate$1) continuation;
            int i9 = oldAppDataMigrator$migrate$1.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                oldAppDataMigrator$migrate$1.label = i9 - Integer.MIN_VALUE;
                Object obj = oldAppDataMigrator$migrate$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = oldAppDataMigrator$migrate$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    i6 = this.oldAppSharedPreferences.getInt(Constants.SettingKeys.CurrentDataVersion, -1);
                    if (i6 == -1) {
                        Logger.log$default(Logger.INSTANCE, "No old app data to migrate", "OldAppDataMigrator", 0, 4, null);
                        return CollectionsKt.emptyList();
                    }
                    i7 = this.oldAppSharedPreferences.getString(Constants.SettingKeys.AuthToken, null) != null ? 1 : 0;
                    arrayList = new ArrayList();
                    oldAppDataMigrator$migrate$1.L$0 = this;
                    oldAppDataMigrator$migrate$1.L$1 = context2;
                    oldAppDataMigrator$migrate$1.L$2 = arrayList;
                    oldAppDataMigrator$migrate$1.I$0 = i6;
                    oldAppDataMigrator$migrate$1.I$1 = i7;
                    oldAppDataMigrator$migrate$1.label = 1;
                    migrateSaleOnBoardOrders = migrateSaleOnBoardOrders(context2, oldAppDataMigrator$migrate$1);
                    if (migrateSaleOnBoardOrders == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    oldAppDataMigrator = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i8 = oldAppDataMigrator$migrate$1.I$0;
                        list = (List) oldAppDataMigrator$migrate$1.L$1;
                        ?? r32 = (List) oldAppDataMigrator$migrate$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        arrayList2 = r32;
                        list.addAll(CollectionsKt.filterNotNull((Iterable) obj));
                        i6 = i8;
                        arrayList = arrayList2;
                        Logger.log$default(Logger.INSTANCE, "Old app data data version: " + i6, "OldAppDataMigrator", 0, 4, null);
                        ArrayList<MigrationResult> arrayList3 = arrayList;
                        for (MigrationResult migrationResult : arrayList3) {
                            Logger.log$default(Logger.INSTANCE, migrationResult.getResultMessage(), "OldAppDataMigrator", 0, 4, null);
                            for (String str : migrationResult.getFailed()) {
                                Logger logger = Logger.INSTANCE;
                                logger.logCritical(new CriticalLog(str));
                                Logger.log$default(logger, str, "OldAppDataMigrator", 0, 4, null);
                            }
                        }
                        ArrayList arrayList4 = new ArrayList();
                        it = arrayList3.iterator();
                        while (it.hasNext()) {
                            CollectionsKt.addAll(arrayList4, ((MigrationResult) it.next()).getFailed());
                        }
                        return arrayList4;
                    }
                    int i10 = oldAppDataMigrator$migrate$1.I$1;
                    int i11 = oldAppDataMigrator$migrate$1.I$0;
                    ?? r8 = (List) oldAppDataMigrator$migrate$1.L$2;
                    Context context3 = (Context) oldAppDataMigrator$migrate$1.L$1;
                    oldAppDataMigrator = (OldAppDataMigrator) oldAppDataMigrator$migrate$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    i7 = i10;
                    context2 = context3;
                    arrayList = r8;
                    migrateSaleOnBoardOrders = obj;
                    i6 = i11;
                }
                arrayList.add((MigrationResult) migrateSaleOnBoardOrders);
                if (i7 == 0) {
                    oldAppDataMigrator$migrate$1.L$0 = arrayList;
                    oldAppDataMigrator$migrate$1.L$1 = arrayList;
                    oldAppDataMigrator$migrate$1.L$2 = null;
                    oldAppDataMigrator$migrate$1.I$0 = i6;
                    oldAppDataMigrator$migrate$1.label = 2;
                    Object migrateUserData = oldAppDataMigrator.migrateUserData(context2, oldAppDataMigrator$migrate$1);
                    if (migrateUserData == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ArrayList arrayList5 = arrayList;
                    list = arrayList5;
                    int i12 = i6;
                    obj = migrateUserData;
                    i8 = i12;
                    arrayList2 = arrayList5;
                    list.addAll(CollectionsKt.filterNotNull((Iterable) obj));
                    i6 = i8;
                    arrayList = arrayList2;
                }
                Logger.log$default(Logger.INSTANCE, "Old app data data version: " + i6, "OldAppDataMigrator", 0, 4, null);
                ArrayList<MigrationResult> arrayList32 = arrayList;
                while (r1.hasNext()) {
                }
                ArrayList arrayList42 = new ArrayList();
                it = arrayList32.iterator();
                while (it.hasNext()) {
                }
                return arrayList42;
            }
        }
        oldAppDataMigrator$migrate$1 = new OldAppDataMigrator$migrate$1(this, continuation);
        Object obj2 = oldAppDataMigrator$migrate$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = oldAppDataMigrator$migrate$1.label;
        if (i5 != 0) {
        }
        arrayList.add((MigrationResult) migrateSaleOnBoardOrders);
        if (i7 == 0) {
        }
        Logger.log$default(Logger.INSTANCE, "Old app data data version: " + i6, "OldAppDataMigrator", 0, 4, null);
        ArrayList<MigrationResult> arrayList322 = arrayList;
        while (r1.hasNext()) {
        }
        ArrayList arrayList422 = new ArrayList();
        it = arrayList322.iterator();
        while (it.hasNext()) {
        }
        return arrayList422;
    }
}
