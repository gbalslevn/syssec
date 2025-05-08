package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.saleOnBoard.SaleOnBoardApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindCateringApi$api_kombardoProdFactory implements Provider {
    public static SaleOnBoardApi bindCateringApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (SaleOnBoardApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindCateringApi$api_kombardoProd(iNetworkManager));
    }
}
