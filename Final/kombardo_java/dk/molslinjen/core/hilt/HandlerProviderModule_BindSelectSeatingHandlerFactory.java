package dk.molslinjen.core.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import uniffi.molslinjen_shared.SelectSeatingHandlerInterface;

/* loaded from: classes2.dex */
public abstract class HandlerProviderModule_BindSelectSeatingHandlerFactory implements Provider {
    public static SelectSeatingHandlerInterface bindSelectSeatingHandler() {
        return (SelectSeatingHandlerInterface) Preconditions.checkNotNullFromProvides(HandlerProviderModule.INSTANCE.bindSelectSeatingHandler());
    }
}
