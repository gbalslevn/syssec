package dk.molslinjen.domain.model.settings;

import android.content.Context;
import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class Settings_Factory implements Provider {
    private final Provider<Context> contextProvider;

    public Settings_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static Settings_Factory create(javax.inject.Provider<Context> provider) {
        return new Settings_Factory(Providers.asDaggerProvider(provider));
    }

    public static Settings newInstance(Context context) {
        return new Settings(context);
    }

    public static Settings_Factory create(Provider<Context> provider) {
        return new Settings_Factory(provider);
    }

    @Override // javax.inject.Provider
    public Settings get() {
        return newInstance(this.contextProvider.get());
    }
}
