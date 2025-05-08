package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import e.AbstractC0321h;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class UserMetadata {
    private final CrashlyticsWorkers crashlyticsWorkers;
    private final MetaDataStore metaDataStore;
    private String sessionIdentifier;
    private final SerializeableKeysMap customKeys = new SerializeableKeysMap(false);
    private final SerializeableKeysMap internalKeys = new SerializeableKeysMap(true);
    private final RolloutAssignmentList rolloutsState = new RolloutAssignmentList(128);
    private final AtomicMarkableReference<String> userId = new AtomicMarkableReference<>(null, false);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class SerializeableKeysMap {
        private final boolean isInternal;
        final AtomicMarkableReference<KeysMap> map;
        private final AtomicReference<Runnable> queuedSerializer = new AtomicReference<>(null);

        public SerializeableKeysMap(boolean z5) {
            this.isInternal = z5;
            this.map = new AtomicMarkableReference<>(new KeysMap(64, z5 ? 8192 : 1024), false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$scheduleSerializationTaskIfNeeded$0() {
            this.queuedSerializer.set(null);
            serializeIfMarked();
        }

        private void scheduleSerializationTaskIfNeeded() {
            Runnable runnable = new Runnable() { // from class: com.google.firebase.crashlytics.internal.metadata.a
                @Override // java.lang.Runnable
                public final void run() {
                    UserMetadata.SerializeableKeysMap.this.lambda$scheduleSerializationTaskIfNeeded$0();
                }
            };
            if (AbstractC0321h.a(this.queuedSerializer, null, runnable)) {
                UserMetadata.this.crashlyticsWorkers.diskWrite.submit(runnable);
            }
        }

        private void serializeIfMarked() {
            Map<String, String> map;
            synchronized (this) {
                try {
                    if (this.map.isMarked()) {
                        map = this.map.getReference().getKeys();
                        AtomicMarkableReference<KeysMap> atomicMarkableReference = this.map;
                        atomicMarkableReference.set(atomicMarkableReference.getReference(), false);
                    } else {
                        map = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (map != null) {
                UserMetadata.this.metaDataStore.writeKeyData(UserMetadata.this.sessionIdentifier, map, this.isInternal);
            }
        }

        public Map<String, String> getKeys() {
            return this.map.getReference().getKeys();
        }

        public boolean setKey(String str, String str2) {
            synchronized (this) {
                try {
                    if (!this.map.getReference().setKey(str, str2)) {
                        return false;
                    }
                    AtomicMarkableReference<KeysMap> atomicMarkableReference = this.map;
                    atomicMarkableReference.set(atomicMarkableReference.getReference(), true);
                    scheduleSerializationTaskIfNeeded();
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public UserMetadata(String str, FileStore fileStore, CrashlyticsWorkers crashlyticsWorkers) {
        this.sessionIdentifier = str;
        this.metaDataStore = new MetaDataStore(fileStore);
        this.crashlyticsWorkers = crashlyticsWorkers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNewSession$0(String str, Map map, List list) {
        if (getUserId() != null) {
            this.metaDataStore.writeUserData(str, getUserId());
        }
        if (!map.isEmpty()) {
            this.metaDataStore.writeKeyData(str, map);
        }
        if (list.isEmpty()) {
            return;
        }
        this.metaDataStore.writeRolloutState(str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateRolloutsState$1(List list) {
        this.metaDataStore.writeRolloutState(this.sessionIdentifier, list);
    }

    public static UserMetadata loadFromExistingSession(String str, FileStore fileStore, CrashlyticsWorkers crashlyticsWorkers) {
        MetaDataStore metaDataStore = new MetaDataStore(fileStore);
        UserMetadata userMetadata = new UserMetadata(str, fileStore, crashlyticsWorkers);
        userMetadata.customKeys.map.getReference().setKeys(metaDataStore.readKeyData(str, false));
        userMetadata.internalKeys.map.getReference().setKeys(metaDataStore.readKeyData(str, true));
        userMetadata.userId.set(metaDataStore.readUserId(str), false);
        userMetadata.rolloutsState.updateRolloutAssignmentList(metaDataStore.readRolloutsState(str));
        return userMetadata;
    }

    public static String readUserId(String str, FileStore fileStore) {
        return new MetaDataStore(fileStore).readUserId(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serializeUserDataIfNeeded() {
        boolean z5;
        String str;
        synchronized (this.userId) {
            try {
                z5 = false;
                if (this.userId.isMarked()) {
                    str = getUserId();
                    this.userId.set(str, false);
                    z5 = true;
                } else {
                    str = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z5) {
            this.metaDataStore.writeUserData(this.sessionIdentifier, str);
        }
    }

    public Map<String, String> getCustomKeys(Map<String, String> map) {
        if (map.isEmpty()) {
            return this.customKeys.getKeys();
        }
        HashMap hashMap = new HashMap(this.customKeys.getKeys());
        int i5 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String sanitizeString = KeysMap.sanitizeString(entry.getKey(), 1024);
            if (hashMap.size() < 64 || hashMap.containsKey(sanitizeString)) {
                hashMap.put(sanitizeString, KeysMap.sanitizeString(entry.getValue(), 1024));
            } else {
                i5++;
            }
        }
        if (i5 > 0) {
            Logger.getLogger().w("Ignored " + i5 + " keys when adding event specific keys. Maximum allowable: 1024");
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public Map<String, String> getInternalKeys() {
        return this.internalKeys.getKeys();
    }

    public List<CrashlyticsReport.Session.Event.RolloutAssignment> getRolloutsState() {
        return this.rolloutsState.getReportRolloutsState();
    }

    public String getUserId() {
        return this.userId.getReference();
    }

    public boolean setCustomKey(String str, String str2) {
        return this.customKeys.setKey(str, str2);
    }

    public boolean setInternalKey(String str, String str2) {
        return this.internalKeys.setKey(str, str2);
    }

    public void setNewSession(final String str) {
        synchronized (this.sessionIdentifier) {
            this.sessionIdentifier = str;
            final Map<String, String> keys = this.customKeys.getKeys();
            final List<RolloutAssignment> rolloutAssignmentList = this.rolloutsState.getRolloutAssignmentList();
            this.crashlyticsWorkers.diskWrite.submit(new Runnable() { // from class: K0.a
                @Override // java.lang.Runnable
                public final void run() {
                    UserMetadata.this.lambda$setNewSession$0(str, keys, rolloutAssignmentList);
                }
            });
        }
    }

    public void setUserId(String str) {
        String sanitizeString = KeysMap.sanitizeString(str, 1024);
        synchronized (this.userId) {
            try {
                if (CommonUtils.nullSafeEquals(sanitizeString, this.userId.getReference())) {
                    return;
                }
                this.userId.set(sanitizeString, true);
                this.crashlyticsWorkers.diskWrite.submit(new Runnable() { // from class: K0.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        UserMetadata.this.serializeUserDataIfNeeded();
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean updateRolloutsState(List<RolloutAssignment> list) {
        synchronized (this.rolloutsState) {
            try {
                if (!this.rolloutsState.updateRolloutAssignmentList(list)) {
                    return false;
                }
                final List<RolloutAssignment> rolloutAssignmentList = this.rolloutsState.getRolloutAssignmentList();
                this.crashlyticsWorkers.diskWrite.submit(new Runnable() { // from class: K0.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        UserMetadata.this.lambda$updateRolloutsState$1(rolloutAssignmentList);
                    }
                });
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
