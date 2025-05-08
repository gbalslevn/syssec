package dk.molslinjen.core.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager;
import dk.molslinjen.domain.managers.user.merge.IAssetsMerger;
import dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager;
import dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager;

/* loaded from: classes2.dex */
public abstract class AccountMergeModule_ProvidesAssetsMergerFactory implements Provider {
    public static IAssetsMerger[] providesAssetsMerger(IUserPassengerManager iUserPassengerManager, IUserVehiclesManager iUserVehiclesManager, IUserCreditCardsManager iUserCreditCardsManager, ITicketsManager iTicketsManager, IMultiRideManager iMultiRideManager) {
        return (IAssetsMerger[]) Preconditions.checkNotNullFromProvides(AccountMergeModule.INSTANCE.providesAssetsMerger(iUserPassengerManager, iUserVehiclesManager, iUserCreditCardsManager, iTicketsManager, iMultiRideManager));
    }
}
