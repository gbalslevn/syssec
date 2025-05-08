package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.auto.value.AutoValue;

/* JADX INFO: Access modifiers changed from: package-private */
@AutoValue
/* loaded from: classes.dex */
public abstract class EventStoreConfig {
    private static final long MAX_DB_STORAGE_SIZE_IN_BYTES = 10485760;
    private static final int LOAD_BATCH_SIZE = 200;
    private static final int LOCK_TIME_OUT_MS = 10000;
    private static final long DURATION_ONE_WEEK_MS = 604800000;
    private static final int MAX_BLOB_BYTE_SIZE_PER_ROW = 81920;
    static final EventStoreConfig DEFAULT = builder().setMaxStorageSizeInBytes(MAX_DB_STORAGE_SIZE_IN_BYTES).setLoadBatchSize(LOAD_BATCH_SIZE).setCriticalSectionEnterTimeoutMs(LOCK_TIME_OUT_MS).setEventCleanUpAge(DURATION_ONE_WEEK_MS).setMaxBlobByteSizePerRow(MAX_BLOB_BYTE_SIZE_PER_ROW).build();

    /* JADX INFO: Access modifiers changed from: package-private */
    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class Builder {
        abstract EventStoreConfig build();

        abstract Builder setCriticalSectionEnterTimeoutMs(int i5);

        abstract Builder setEventCleanUpAge(long j5);

        abstract Builder setLoadBatchSize(int i5);

        abstract Builder setMaxBlobByteSizePerRow(int i5);

        abstract Builder setMaxStorageSizeInBytes(long j5);
    }

    static Builder builder() {
        return new AutoValue_EventStoreConfig.Builder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getCriticalSectionEnterTimeoutMs();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long getEventCleanUpAge();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getLoadBatchSize();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getMaxBlobByteSizePerRow();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long getMaxStorageSizeInBytes();
}
