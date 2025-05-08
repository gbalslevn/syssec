package coil.disk;

import coil.content.FileSystems;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.ForwardingFileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0007*\u0001O\b\u0000\u0018\u0000 Q2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0004QRSTB7\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001b\u0010\u0013J\u000f\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u0013J#\u0010!\u001a\u00020\u00112\n\u0010\u001e\u001a\u00060\u001dR\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$J\u001b\u0010'\u001a\u00020\u001f2\n\u0010&\u001a\u00060%R\u00020\u0000H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0011H\u0002¢\u0006\u0004\b)\u0010\u0013J\u000f\u0010*\u001a\u00020\u0011H\u0002¢\u0006\u0004\b*\u0010\u0013J\u000f\u0010+\u001a\u00020\u001fH\u0002¢\u0006\u0004\b+\u0010$J\u000f\u0010,\u001a\u00020\u0011H\u0002¢\u0006\u0004\b,\u0010\u0013J\u000f\u0010-\u001a\u00020\u0011H\u0002¢\u0006\u0004\b-\u0010\u0013J\u0017\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0017H\u0002¢\u0006\u0004\b/\u0010\u001aJ\r\u00100\u001a\u00020\u0011¢\u0006\u0004\b0\u0010\u0013J\u001e\u00102\u001a\b\u0018\u000101R\u00020\u00002\u0006\u0010.\u001a\u00020\u0017H\u0086\u0002¢\u0006\u0004\b2\u00103J\u001b\u00104\u001a\b\u0018\u00010\u001dR\u00020\u00002\u0006\u0010.\u001a\u00020\u0017¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0011H\u0016¢\u0006\u0004\b6\u0010\u0013J\u000f\u00107\u001a\u00020\u0011H\u0016¢\u0006\u0004\b7\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00108R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00109R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010:R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010:R\u0014\u0010;\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00108R\u0014\u0010<\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00108R\u0014\u0010=\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00108R8\u0010@\u001a&\u0012\u0004\u0012\u00020\u0017\u0012\b\u0012\u00060%R\u00020\u00000>j\u0012\u0012\u0004\u0012\u00020\u0017\u0012\b\u0012\u00060%R\u00020\u0000`?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00109R\u0016\u0010F\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010:R\u0018\u0010G\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010JR\u0016\u0010L\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010JR\u0016\u0010M\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010JR\u0016\u0010N\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010JR\u0014\u0010\u0005\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010P¨\u0006U"}, d2 = {"Lcoil/disk/DiskLruCache;", "Ljava/io/Closeable;", "Lokio/Closeable;", "Ljava/io/Flushable;", "Lokio/FileSystem;", "fileSystem", "Lokio/Path;", "directory", "Lkotlinx/coroutines/CoroutineDispatcher;", "cleanupDispatcher", BuildConfig.FLAVOR, "maxSize", BuildConfig.FLAVOR, "appVersion", "valueCount", "<init>", "(Lokio/FileSystem;Lokio/Path;Lkotlinx/coroutines/CoroutineDispatcher;JII)V", BuildConfig.FLAVOR, "readJournal", "()V", "Lokio/BufferedSink;", "newJournalWriter", "()Lokio/BufferedSink;", BuildConfig.FLAVOR, "line", "readJournalLine", "(Ljava/lang/String;)V", "processJournal", "writeJournal", "Lcoil/disk/DiskLruCache$Editor;", "editor", BuildConfig.FLAVOR, "success", "completeEdit", "(Lcoil/disk/DiskLruCache$Editor;Z)V", "journalRewriteRequired", "()Z", "Lcoil/disk/DiskLruCache$Entry;", "entry", "removeEntry", "(Lcoil/disk/DiskLruCache$Entry;)Z", "checkNotClosed", "trimToSize", "removeOldestEntry", "delete", "launchCleanup", "key", "validateKey", "initialize", "Lcoil/disk/DiskLruCache$Snapshot;", "get", "(Ljava/lang/String;)Lcoil/disk/DiskLruCache$Snapshot;", "edit", "(Ljava/lang/String;)Lcoil/disk/DiskLruCache$Editor;", "close", "flush", "Lokio/Path;", "J", "I", "journalFile", "journalFileTmp", "journalFileBackup", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "lruEntries", "Ljava/util/LinkedHashMap;", "Lkotlinx/coroutines/CoroutineScope;", "cleanupScope", "Lkotlinx/coroutines/CoroutineScope;", "size", "operationsSinceRewrite", "journalWriter", "Lokio/BufferedSink;", "hasJournalErrors", "Z", "initialized", "closed", "mostRecentTrimFailed", "mostRecentRebuildFailed", "coil/disk/DiskLruCache$fileSystem$1", "Lcoil/disk/DiskLruCache$fileSystem$1;", "Companion", "Editor", "Entry", "Snapshot", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DiskLruCache implements Closeable, Flushable {
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    private final int appVersion;
    private final CoroutineScope cleanupScope;
    private boolean closed;
    private final Path directory;
    private final DiskLruCache$fileSystem$1 fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final Path journalFile;
    private final Path journalFileBackup;
    private final Path journalFileTmp;
    private BufferedSink journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private final long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private int operationsSinceRewrite;
    private long size;
    private final int valueCount;
    private static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\f\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0006\u0010\u0015\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcoil/disk/DiskLruCache$Editor;", BuildConfig.FLAVOR, "entry", "Lcoil/disk/DiskLruCache$Entry;", "Lcoil/disk/DiskLruCache;", "(Lcoil/disk/DiskLruCache;Lcoil/disk/DiskLruCache$Entry;)V", "closed", BuildConfig.FLAVOR, "getEntry", "()Lcoil/disk/DiskLruCache$Entry;", "written", BuildConfig.FLAVOR, "getWritten", "()[Z", "abort", BuildConfig.FLAVOR, "commit", "commitAndGet", "Lcoil/disk/DiskLruCache$Snapshot;", "complete", "success", "detach", "file", "Lokio/Path;", "index", BuildConfig.FLAVOR, "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class Editor {
        private boolean closed;
        private final Entry entry;
        private final boolean[] written;

        public Editor(Entry entry) {
            this.entry = entry;
            this.written = new boolean[DiskLruCache.this.valueCount];
        }

        private final void complete(boolean success) {
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                try {
                    if (this.closed) {
                        throw new IllegalStateException("editor is closed");
                    }
                    if (Intrinsics.areEqual(this.entry.getCurrentEditor(), this)) {
                        diskLruCache.completeEdit(this, success);
                    }
                    this.closed = true;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void abort() {
            complete(false);
        }

        public final void commit() {
            complete(true);
        }

        public final Snapshot commitAndGet() {
            Snapshot snapshot;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                commit();
                snapshot = diskLruCache.get(this.entry.getKey());
            }
            return snapshot;
        }

        public final void detach() {
            if (Intrinsics.areEqual(this.entry.getCurrentEditor(), this)) {
                this.entry.setZombie(true);
            }
        }

        public final Path file(int index) {
            Path path;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                if (this.closed) {
                    throw new IllegalStateException("editor is closed");
                }
                this.written[index] = true;
                Path path2 = this.entry.getDirtyFiles().get(index);
                FileSystems.createFile(diskLruCache.fileSystem, path2);
                path = path2;
            }
            return path;
        }

        public final Entry getEntry() {
            return this.entry;
        }

        public final boolean[] getWritten() {
            return this.written;
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030,J\f\u0010-\u001a\b\u0018\u00010.R\u00020\rJ\u000e\u0010/\u001a\u00020*2\u0006\u00100\u001a\u000201R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0018\u00010\fR\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R!\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%¨\u00062"}, d2 = {"Lcoil/disk/DiskLruCache$Entry;", BuildConfig.FLAVOR, "key", BuildConfig.FLAVOR, "(Lcoil/disk/DiskLruCache;Ljava/lang/String;)V", "cleanFiles", "Ljava/util/ArrayList;", "Lokio/Path;", "Lkotlin/collections/ArrayList;", "getCleanFiles", "()Ljava/util/ArrayList;", "currentEditor", "Lcoil/disk/DiskLruCache$Editor;", "Lcoil/disk/DiskLruCache;", "getCurrentEditor", "()Lcoil/disk/DiskLruCache$Editor;", "setCurrentEditor", "(Lcoil/disk/DiskLruCache$Editor;)V", "dirtyFiles", "getDirtyFiles", "getKey", "()Ljava/lang/String;", "lengths", BuildConfig.FLAVOR, "getLengths", "()[J", "lockingSnapshotCount", BuildConfig.FLAVOR, "getLockingSnapshotCount", "()I", "setLockingSnapshotCount", "(I)V", "readable", BuildConfig.FLAVOR, "getReadable", "()Z", "setReadable", "(Z)V", "zombie", "getZombie", "setZombie", "setLengths", BuildConfig.FLAVOR, "strings", BuildConfig.FLAVOR, "snapshot", "Lcoil/disk/DiskLruCache$Snapshot;", "writeLengths", "writer", "Lokio/BufferedSink;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class Entry {
        private final ArrayList<Path> cleanFiles;
        private Editor currentEditor;
        private final ArrayList<Path> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSnapshotCount;
        private boolean readable;
        private boolean zombie;

        public Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new ArrayList<>(DiskLruCache.this.valueCount);
            this.dirtyFiles = new ArrayList<>(DiskLruCache.this.valueCount);
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            int i5 = DiskLruCache.this.valueCount;
            for (int i6 = 0; i6 < i5; i6++) {
                sb.append(i6);
                this.cleanFiles.add(DiskLruCache.this.directory.resolve(sb.toString()));
                sb.append(".tmp");
                this.dirtyFiles.add(DiskLruCache.this.directory.resolve(sb.toString()));
                sb.setLength(length);
            }
        }

        public final ArrayList<Path> getCleanFiles() {
            return this.cleanFiles;
        }

        public final Editor getCurrentEditor() {
            return this.currentEditor;
        }

        public final ArrayList<Path> getDirtyFiles() {
            return this.dirtyFiles;
        }

        public final String getKey() {
            return this.key;
        }

        public final long[] getLengths() {
            return this.lengths;
        }

        public final int getLockingSnapshotCount() {
            return this.lockingSnapshotCount;
        }

        public final boolean getReadable() {
            return this.readable;
        }

        public final boolean getZombie() {
            return this.zombie;
        }

        public final void setCurrentEditor(Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths(List<String> strings) {
            if (strings.size() != DiskLruCache.this.valueCount) {
                throw new IOException("unexpected journal line: " + strings);
            }
            try {
                int size = strings.size();
                for (int i5 = 0; i5 < size; i5++) {
                    this.lengths[i5] = Long.parseLong(strings.get(i5));
                }
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + strings);
            }
        }

        public final void setLockingSnapshotCount(int i5) {
            this.lockingSnapshotCount = i5;
        }

        public final void setReadable(boolean z5) {
            this.readable = z5;
        }

        public final void setZombie(boolean z5) {
            this.zombie = z5;
        }

        public final Snapshot snapshot() {
            if (!this.readable || this.currentEditor != null || this.zombie) {
                return null;
            }
            ArrayList<Path> arrayList = this.cleanFiles;
            DiskLruCache diskLruCache = DiskLruCache.this;
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (!diskLruCache.fileSystem.exists(arrayList.get(i5))) {
                    try {
                        diskLruCache.removeEntry(this);
                    } catch (IOException unused) {
                    }
                    return null;
                }
            }
            this.lockingSnapshotCount++;
            return new Snapshot(this);
        }

        public final void writeLengths(BufferedSink writer) {
            for (long j5 : this.lengths) {
                writer.writeByte(32).writeDecimalLong(j5);
            }
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0005\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\b\u0018\u00010\u0010R\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0005\u001a\u00060\u0003R\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcoil/disk/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "Lokio/Closeable;", "Lcoil/disk/DiskLruCache$Entry;", "Lcoil/disk/DiskLruCache;", "entry", "<init>", "(Lcoil/disk/DiskLruCache;Lcoil/disk/DiskLruCache$Entry;)V", BuildConfig.FLAVOR, "index", "Lokio/Path;", "file", "(I)Lokio/Path;", BuildConfig.FLAVOR, "close", "()V", "Lcoil/disk/DiskLruCache$Editor;", "closeAndEdit", "()Lcoil/disk/DiskLruCache$Editor;", "Lcoil/disk/DiskLruCache$Entry;", "getEntry", "()Lcoil/disk/DiskLruCache$Entry;", BuildConfig.FLAVOR, "closed", "Z", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class Snapshot implements Closeable {
        private boolean closed;
        private final Entry entry;

        public Snapshot(Entry entry) {
            this.entry = entry;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                try {
                    this.entry.setLockingSnapshotCount(r1.getLockingSnapshotCount() - 1);
                    if (this.entry.getLockingSnapshotCount() == 0 && this.entry.getZombie()) {
                        diskLruCache.removeEntry(this.entry);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final Editor closeAndEdit() {
            Editor edit;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                close();
                edit = diskLruCache.edit(this.entry.getKey());
            }
            return edit;
        }

        public final Path file(int index) {
            if (this.closed) {
                throw new IllegalStateException("snapshot is closed");
            }
            return this.entry.getCleanFiles().get(index);
        }
    }

    /* JADX WARN: Type inference failed for: r4v9, types: [coil.disk.DiskLruCache$fileSystem$1] */
    public DiskLruCache(final FileSystem fileSystem, Path path, CoroutineDispatcher coroutineDispatcher, long j5, int i5, int i6) {
        this.directory = path;
        this.maxSize = j5;
        this.appVersion = i5;
        this.valueCount = i6;
        if (j5 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i6 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        this.journalFile = path.resolve("journal");
        this.journalFileTmp = path.resolve("journal.tmp");
        this.journalFileBackup = path.resolve("journal.bkp");
        this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
        this.cleanupScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(coroutineDispatcher.limitedParallelism(1)));
        this.fileSystem = new ForwardingFileSystem(fileSystem) { // from class: coil.disk.DiskLruCache$fileSystem$1
            @Override // okio.ForwardingFileSystem, okio.FileSystem
            public Sink sink(Path file, boolean mustCreate) {
                Path parent = file.parent();
                if (parent != null) {
                    createDirectories(parent);
                }
                return super.sink(file, mustCreate);
            }
        };
    }

    private final void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void completeEdit(Editor editor, boolean success) {
        Entry entry = editor.getEntry();
        if (!Intrinsics.areEqual(entry.getCurrentEditor(), editor)) {
            throw new IllegalStateException("Check failed.");
        }
        int i5 = 0;
        if (!success || entry.getZombie()) {
            int i6 = this.valueCount;
            while (i5 < i6) {
                delete(entry.getDirtyFiles().get(i5));
                i5++;
            }
        } else {
            int i7 = this.valueCount;
            for (int i8 = 0; i8 < i7; i8++) {
                if (editor.getWritten()[i8] && !exists(entry.getDirtyFiles().get(i8))) {
                    editor.abort();
                    return;
                }
            }
            int i9 = this.valueCount;
            while (i5 < i9) {
                Path path = entry.getDirtyFiles().get(i5);
                Path path2 = entry.getCleanFiles().get(i5);
                if (exists(path)) {
                    atomicMove(path, path2);
                } else {
                    FileSystems.createFile(this.fileSystem, entry.getCleanFiles().get(i5));
                }
                long j5 = entry.getLengths()[i5];
                Long size = metadata(path2).getSize();
                long longValue = size != null ? size.longValue() : 0L;
                entry.getLengths()[i5] = longValue;
                this.size = (this.size - j5) + longValue;
                i5++;
            }
        }
        entry.setCurrentEditor(null);
        if (entry.getZombie()) {
            removeEntry(entry);
            return;
        }
        this.operationsSinceRewrite++;
        BufferedSink bufferedSink = this.journalWriter;
        Intrinsics.checkNotNull(bufferedSink);
        if (!success && !entry.getReadable()) {
            this.lruEntries.remove(entry.getKey());
            bufferedSink.writeUtf8(REMOVE);
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(entry.getKey());
            bufferedSink.writeByte(10);
            bufferedSink.flush();
            if (this.size <= this.maxSize || journalRewriteRequired()) {
                launchCleanup();
            }
        }
        entry.setReadable(true);
        bufferedSink.writeUtf8(CLEAN);
        bufferedSink.writeByte(32);
        bufferedSink.writeUtf8(entry.getKey());
        entry.writeLengths(bufferedSink);
        bufferedSink.writeByte(10);
        bufferedSink.flush();
        if (this.size <= this.maxSize) {
        }
        launchCleanup();
    }

    private final void delete() {
        close();
        FileSystems.deleteContents(this.fileSystem, this.directory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean journalRewriteRequired() {
        return this.operationsSinceRewrite >= 2000;
    }

    private final void launchCleanup() {
        BuildersKt__Builders_commonKt.launch$default(this.cleanupScope, null, null, new DiskLruCache$launchCleanup$1(this, null), 3, null);
    }

    private final BufferedSink newJournalWriter() {
        return Okio.buffer(new FaultHidingSink(appendingSink(this.journalFile), new Function1<IOException, Unit>() { // from class: coil.disk.DiskLruCache$newJournalWriter$faultHidingSink$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IOException iOException) {
                invoke2(iOException);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IOException iOException) {
                DiskLruCache.this.hasJournalErrors = true;
            }
        }));
    }

    private final void processJournal() {
        Iterator<Entry> it = this.lruEntries.values().iterator();
        long j5 = 0;
        while (it.hasNext()) {
            Entry next = it.next();
            int i5 = 0;
            if (next.getCurrentEditor() == null) {
                int i6 = this.valueCount;
                while (i5 < i6) {
                    j5 += next.getLengths()[i5];
                    i5++;
                }
            } else {
                next.setCurrentEditor(null);
                int i7 = this.valueCount;
                while (i5 < i7) {
                    delete(next.getCleanFiles().get(i5));
                    delete(next.getDirtyFiles().get(i5));
                    i5++;
                }
                it.remove();
            }
        }
        this.size = j5;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void readJournal() {
        Unit unit;
        BufferedSource buffer = Okio.buffer(source(this.journalFile));
        Throwable th = null;
        try {
            String readUtf8LineStrict = buffer.readUtf8LineStrict();
            String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict3 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict4 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict5 = buffer.readUtf8LineStrict();
            if (!Intrinsics.areEqual("libcore.io.DiskLruCache", readUtf8LineStrict) || !Intrinsics.areEqual("1", readUtf8LineStrict2) || !Intrinsics.areEqual(String.valueOf(this.appVersion), readUtf8LineStrict3) || !Intrinsics.areEqual(String.valueOf(this.valueCount), readUtf8LineStrict4) || readUtf8LineStrict5.length() > 0) {
                throw new IOException("unexpected journal header: [" + readUtf8LineStrict + ", " + readUtf8LineStrict2 + ", " + readUtf8LineStrict3 + ", " + readUtf8LineStrict4 + ", " + readUtf8LineStrict5 + ']');
            }
            int i5 = 0;
            while (true) {
                try {
                    readJournalLine(buffer.readUtf8LineStrict());
                    i5++;
                } catch (EOFException unused) {
                    this.operationsSinceRewrite = i5 - this.lruEntries.size();
                    if (buffer.exhausted()) {
                        this.journalWriter = newJournalWriter();
                    } else {
                        writeJournal();
                    }
                    unit = Unit.INSTANCE;
                    if (buffer != null) {
                        try {
                            buffer.close();
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    if (th == null) {
                        throw th;
                    }
                    Intrinsics.checkNotNull(unit);
                    return;
                }
            }
        } catch (Throwable th3) {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th3, th4);
                }
            }
            th = th3;
            unit = null;
            if (th == null) {
            }
        }
    }

    private final void readJournalLine(String line) {
        String substring;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) line, ' ', 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            throw new IOException("unexpected journal line: " + line);
        }
        int i5 = indexOf$default + 1;
        int indexOf$default2 = StringsKt.indexOf$default((CharSequence) line, ' ', i5, false, 4, (Object) null);
        if (indexOf$default2 == -1) {
            substring = line.substring(i5);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            if (indexOf$default == 6 && StringsKt.startsWith$default(line, REMOVE, false, 2, (Object) null)) {
                this.lruEntries.remove(substring);
                return;
            }
        } else {
            substring = line.substring(i5, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        LinkedHashMap<String, Entry> linkedHashMap = this.lruEntries;
        Entry entry = linkedHashMap.get(substring);
        if (entry == null) {
            entry = new Entry(substring);
            linkedHashMap.put(substring, entry);
        }
        Entry entry2 = entry;
        if (indexOf$default2 != -1 && indexOf$default == 5 && StringsKt.startsWith$default(line, CLEAN, false, 2, (Object) null)) {
            String substring2 = line.substring(indexOf$default2 + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            List<String> split$default = StringsKt.split$default((CharSequence) substring2, new char[]{' '}, false, 0, 6, (Object) null);
            entry2.setReadable(true);
            entry2.setCurrentEditor(null);
            entry2.setLengths(split$default);
            return;
        }
        if (indexOf$default2 == -1 && indexOf$default == 5 && StringsKt.startsWith$default(line, DIRTY, false, 2, (Object) null)) {
            entry2.setCurrentEditor(new Editor(entry2));
            return;
        }
        if (indexOf$default2 == -1 && indexOf$default == 4 && StringsKt.startsWith$default(line, READ, false, 2, (Object) null)) {
            return;
        }
        throw new IOException("unexpected journal line: " + line);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeEntry(Entry entry) {
        BufferedSink bufferedSink;
        if (entry.getLockingSnapshotCount() > 0 && (bufferedSink = this.journalWriter) != null) {
            bufferedSink.writeUtf8(DIRTY);
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(entry.getKey());
            bufferedSink.writeByte(10);
            bufferedSink.flush();
        }
        if (entry.getLockingSnapshotCount() > 0 || entry.getCurrentEditor() != null) {
            entry.setZombie(true);
            return true;
        }
        int i5 = this.valueCount;
        for (int i6 = 0; i6 < i5; i6++) {
            delete(entry.getCleanFiles().get(i6));
            this.size -= entry.getLengths()[i6];
            entry.getLengths()[i6] = 0;
        }
        this.operationsSinceRewrite++;
        BufferedSink bufferedSink2 = this.journalWriter;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8(REMOVE);
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(entry.getKey());
            bufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey());
        if (journalRewriteRequired()) {
            launchCleanup();
        }
        return true;
    }

    private final boolean removeOldestEntry() {
        for (Entry entry : this.lruEntries.values()) {
            if (!entry.getZombie()) {
                removeEntry(entry);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trimToSize() {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    private final void validateKey(String key) {
        if (LEGAL_KEY_PATTERN.matches(key)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + key + '\"').toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void writeJournal() {
        Unit unit;
        try {
            BufferedSink bufferedSink = this.journalWriter;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            BufferedSink buffer = Okio.buffer(sink(this.journalFileTmp, false));
            Throwable th = null;
            try {
                buffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
                buffer.writeUtf8("1").writeByte(10);
                buffer.writeDecimalLong(this.appVersion).writeByte(10);
                buffer.writeDecimalLong(this.valueCount).writeByte(10);
                buffer.writeByte(10);
                for (Entry entry : this.lruEntries.values()) {
                    if (entry.getCurrentEditor() != null) {
                        buffer.writeUtf8(DIRTY);
                        buffer.writeByte(32);
                        buffer.writeUtf8(entry.getKey());
                        buffer.writeByte(10);
                    } else {
                        buffer.writeUtf8(CLEAN);
                        buffer.writeByte(32);
                        buffer.writeUtf8(entry.getKey());
                        entry.writeLengths(buffer);
                        buffer.writeByte(10);
                    }
                }
                unit = Unit.INSTANCE;
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.addSuppressed(th3, th4);
                    }
                }
                unit = null;
                th = th3;
            }
            if (th != null) {
                throw th;
            }
            Intrinsics.checkNotNull(unit);
            if (exists(this.journalFile)) {
                atomicMove(this.journalFile, this.journalFileBackup);
                atomicMove(this.journalFileTmp, this.journalFile);
                delete(this.journalFileBackup);
            } else {
                atomicMove(this.journalFileTmp, this.journalFile);
            }
            this.journalWriter = newJournalWriter();
            this.operationsSinceRewrite = 0;
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } catch (Throwable th5) {
            throw th5;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.initialized && !this.closed) {
                for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[0])) {
                    Editor currentEditor = entry.getCurrentEditor();
                    if (currentEditor != null) {
                        currentEditor.detach();
                    }
                }
                trimToSize();
                CoroutineScopeKt.cancel$default(this.cleanupScope, null, 1, null);
                BufferedSink bufferedSink = this.journalWriter;
                Intrinsics.checkNotNull(bufferedSink);
                bufferedSink.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            this.closed = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized Editor edit(String key) {
        checkNotClosed();
        validateKey(key);
        initialize();
        Entry entry = this.lruEntries.get(key);
        if ((entry != null ? entry.getCurrentEditor() : null) != null) {
            return null;
        }
        if (entry != null && entry.getLockingSnapshotCount() != 0) {
            return null;
        }
        if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.writeUtf8(DIRTY);
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(key);
            bufferedSink.writeByte(10);
            bufferedSink.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(key);
                this.lruEntries.put(key, entry);
            }
            Editor editor = new Editor(entry);
            entry.setCurrentEditor(editor);
            return editor;
        }
        launchCleanup();
        return null;
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.flush();
        }
    }

    public final synchronized Snapshot get(String key) {
        Snapshot snapshot;
        checkNotClosed();
        validateKey(key);
        initialize();
        Entry entry = this.lruEntries.get(key);
        if (entry != null && (snapshot = entry.snapshot()) != null) {
            this.operationsSinceRewrite++;
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.writeUtf8(READ);
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(key);
            bufferedSink.writeByte(10);
            if (journalRewriteRequired()) {
                launchCleanup();
            }
            return snapshot;
        }
        return null;
    }

    public final synchronized void initialize() {
        try {
            if (this.initialized) {
                return;
            }
            delete(this.journalFileTmp);
            if (exists(this.journalFileBackup)) {
                if (exists(this.journalFile)) {
                    delete(this.journalFileBackup);
                } else {
                    atomicMove(this.journalFileBackup, this.journalFile);
                }
            }
            if (exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException unused) {
                    try {
                        delete();
                        this.closed = false;
                    } catch (Throwable th) {
                        this.closed = false;
                        throw th;
                    }
                }
            }
            writeJournal();
            this.initialized = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
