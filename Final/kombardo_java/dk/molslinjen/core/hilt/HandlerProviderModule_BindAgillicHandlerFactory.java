package dk.molslinjen.core.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import uniffi.molslinjen_shared.AgillicHandlerInterface;

/* loaded from: classes2.dex */
public abstract class HandlerProviderModule_BindAgillicHandlerFactory implements Provider {
    public static AgillicHandlerInterface bindAgillicHandler() {
        return (AgillicHandlerInterface) Preconditions.checkNotNullFromProvides(HandlerProviderModule.INSTANCE.bindAgillicHandler());
    }
}
