package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class EventStoreModule_DbNameFactory implements Factory<String> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final EventStoreModule_DbNameFactory INSTANCE = new EventStoreModule_DbNameFactory();
    }

    public static EventStoreModule_DbNameFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String dbName() {
        return (String) Preconditions.checkNotNullFromProvides(EventStoreModule.dbName());
    }

    @Override // javax.inject.Provider
    public String get() {
        return dbName();
    }
}
