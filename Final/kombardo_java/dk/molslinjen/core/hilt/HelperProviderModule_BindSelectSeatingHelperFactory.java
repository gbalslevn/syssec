package dk.molslinjen.core.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import uniffi.molslinjen_shared.SelectSeatingHelperInterface;

/* loaded from: classes2.dex */
public abstract class HelperProviderModule_BindSelectSeatingHelperFactory implements Provider {
    public static SelectSeatingHelperInterface bindSelectSeatingHelper() {
        return (SelectSeatingHelperInterface) Preconditions.checkNotNullFromProvides(HelperProviderModule.INSTANCE.bindSelectSeatingHelper());
    }
}
