package dk.molslinjen.core.hilt;

import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager;
import dk.molslinjen.domain.managers.user.merge.IAssetsMerger;
import dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager;
import dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/core/hilt/AccountMergeModule;", BuildConfig.FLAVOR, "<init>", "()V", "providesAssetsMerger", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/user/merge/IAssetsMerger;", "userPassengerManager", "Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;", "userVehiclesManager", "Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;", "userCreditCardsManager", "Ldk/molslinjen/domain/managers/user/creditcards/IUserCreditCardsManager;", "ticketsManager", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "multiRideManager", "Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;", "(Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;Ldk/molslinjen/domain/managers/user/creditcards/IUserCreditCardsManager;Ldk/molslinjen/domain/managers/ticket/ITicketsManager;Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;)[Ldk/molslinjen/domain/managers/user/merge/IAssetsMerger;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AccountMergeModule {
    public static final AccountMergeModule INSTANCE = new AccountMergeModule();

    private AccountMergeModule() {
    }

    public final IAssetsMerger[] providesAssetsMerger(IUserPassengerManager userPassengerManager, IUserVehiclesManager userVehiclesManager, IUserCreditCardsManager userCreditCardsManager, ITicketsManager ticketsManager, IMultiRideManager multiRideManager) {
        Intrinsics.checkNotNullParameter(userPassengerManager, "userPassengerManager");
        Intrinsics.checkNotNullParameter(userVehiclesManager, "userVehiclesManager");
        Intrinsics.checkNotNullParameter(userCreditCardsManager, "userCreditCardsManager");
        Intrinsics.checkNotNullParameter(ticketsManager, "ticketsManager");
        Intrinsics.checkNotNullParameter(multiRideManager, "multiRideManager");
        return new IAssetsMerger[]{userPassengerManager, userVehiclesManager, userCreditCardsManager, ticketsManager, multiRideManager};
    }
}
