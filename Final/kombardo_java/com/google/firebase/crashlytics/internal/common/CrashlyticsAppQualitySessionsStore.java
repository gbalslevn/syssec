package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
class CrashlyticsAppQualitySessionsStore {
    private static final String AQS_SESSION_ID_FILENAME_PREFIX = "aqs.";
    private static final FilenameFilter AQS_SESSION_ID_FILE_FILTER = new FilenameFilter() { // from class: com.google.firebase.crashlytics.internal.common.a
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            boolean lambda$static$0;
            lambda$static$0 = CrashlyticsAppQualitySessionsStore.lambda$static$0(file, str);
            return lambda$static$0;
        }
    };
    private static final Comparator<File> FILE_RECENCY_COMPARATOR = new Comparator() { // from class: com.google.firebase.crashlytics.internal.common.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int lambda$static$1;
            lambda$static$1 = CrashlyticsAppQualitySessionsStore.lambda$static$1((File) obj, (File) obj2);
            return lambda$static$1;
        }
    };
    private final FileStore fileStore;
    private String sessionId = null;
    private String appQualitySessionId = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CrashlyticsAppQualitySessionsStore(FileStore fileStore) {
        this.fileStore = fileStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(File file, String str) {
        return str.startsWith(AQS_SESSION_ID_FILENAME_PREFIX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$1(File file, File file2) {
        return Long.compare(file2.lastModified(), file.lastModified());
    }

    private static void persist(FileStore fileStore, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            fileStore.getSessionFile(str, AQS_SESSION_ID_FILENAME_PREFIX + str2).createNewFile();
        } catch (IOException e5) {
            Logger.getLogger().w("Failed to persist App Quality Sessions session id.", e5);
        }
    }

    static String readAqsSessionIdFile(FileStore fileStore, String str) {
        List<File> sessionFiles = fileStore.getSessionFiles(str, AQS_SESSION_ID_FILE_FILTER);
        if (!sessionFiles.isEmpty()) {
            return ((File) Collections.min(sessionFiles, FILE_RECENCY_COMPARATOR)).getName().substring(4);
        }
        Logger.getLogger().w("Unable to read App Quality Sessions session id.");
        return null;
    }

    public synchronized String getAppQualitySessionId(String str) {
        if (Objects.equals(this.sessionId, str)) {
            return this.appQualitySessionId;
        }
        return readAqsSessionIdFile(this.fileStore, str);
    }

    public synchronized void rotateAppQualitySessionId(String str) {
        if (!Objects.equals(this.appQualitySessionId, str)) {
            persist(this.fileStore, this.sessionId, str);
            this.appQualitySessionId = str;
        }
    }

    public synchronized void rotateSessionId(String str) {
        if (!Objects.equals(this.sessionId, str)) {
            persist(this.fileStore, str, this.appQualitySessionId);
            this.sessionId = str;
        }
    }
}
