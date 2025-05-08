package dagger.hilt.android.internal.modules;

import android.content.Context;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* loaded from: classes2.dex */
public abstract class ApplicationContextModule_ProvideContextFactory implements Provider {
    public static Context provideContext(ApplicationContextModule applicationContextModule) {
        return (Context) Preconditions.checkNotNullFromProvides(applicationContextModule.provideContext());
    }
}
