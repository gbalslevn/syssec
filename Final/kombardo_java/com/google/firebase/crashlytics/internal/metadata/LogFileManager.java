package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;

/* loaded from: classes2.dex */
public class LogFileManager {
    private static final String LOGFILE_NAME = "userlog";
    private static final NoopLogStore NOOP_LOG_STORE = new NoopLogStore();
    private FileLogStore currentLog;
    private final FileStore fileStore;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class NoopLogStore implements FileLogStore {
        private NoopLogStore() {
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public void closeLogFile() {
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public void deleteLogFile() {
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public byte[] getLogAsBytes() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public String getLogAsString() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public void writeToLog(long j5, String str) {
        }
    }

    public LogFileManager(FileStore fileStore) {
        this.fileStore = fileStore;
        this.currentLog = NOOP_LOG_STORE;
    }

    private File getWorkingFileForSession(String str) {
        return this.fileStore.getSessionFile(str, LOGFILE_NAME);
    }

    public void clearLog() {
        this.currentLog.deleteLogFile();
    }

    public byte[] getBytesForLog() {
        return this.currentLog.getLogAsBytes();
    }

    public String getLogString() {
        return this.currentLog.getLogAsString();
    }

    public final void setCurrentSession(String str) {
        this.currentLog.closeLogFile();
        this.currentLog = NOOP_LOG_STORE;
        if (str == null) {
            return;
        }
        setLogFile(getWorkingFileForSession(str), 65536);
    }

    void setLogFile(File file, int i5) {
        this.currentLog = new QueueFileLogStore(file, i5);
    }

    public void writeToLog(long j5, String str) {
        this.currentLog.writeToLog(j5, str);
    }

    public LogFileManager(FileStore fileStore, String str) {
        this(fileStore);
        setCurrentSession(str);
    }
}
