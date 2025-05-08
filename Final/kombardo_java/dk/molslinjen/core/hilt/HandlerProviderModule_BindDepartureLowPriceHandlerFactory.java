package dk.molslinjen.core.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import uniffi.molslinjen_shared.DepartureLowPriceHandlerInterface;

/* loaded from: classes2.dex */
public abstract class HandlerProviderModule_BindDepartureLowPriceHandlerFactory implements Provider {
    public static DepartureLowPriceHandlerInterface bindDepartureLowPriceHandler() {
        return (DepartureLowPriceHandlerInterface) Preconditions.checkNotNullFromProvides(HandlerProviderModule.INSTANCE.bindDepartureLowPriceHandler());
    }
}
