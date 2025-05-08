package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class EventStoreModule_StoreConfigFactory implements Factory<EventStoreConfig> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final EventStoreModule_StoreConfigFactory INSTANCE = new EventStoreModule_StoreConfigFactory();
    }

    public static EventStoreModule_StoreConfigFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static EventStoreConfig storeConfig() {
        return (EventStoreConfig) Preconditions.checkNotNullFromProvides(EventStoreModule.storeConfig());
    }

    @Override // javax.inject.Provider
    public EventStoreConfig get() {
        return storeConfig();
    }
}
