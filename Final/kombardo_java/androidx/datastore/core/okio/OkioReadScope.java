package androidx.datastore.core.okio;

import androidx.datastore.core.ReadScope;
import java.io.Closeable;
import java.io.FileNotFoundException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0004J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0015\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Landroidx/datastore/core/okio/OkioReadScope;", "T", "Landroidx/datastore/core/ReadScope;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;)V", "closed", "Landroidx/datastore/core/okio/AtomicBoolean;", "getFileSystem", "()Lokio/FileSystem;", "getPath", "()Lokio/Path;", "getSerializer", "()Landroidx/datastore/core/okio/OkioSerializer;", "checkClose", BuildConfig.FLAVOR, "close", "readData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class OkioReadScope<T> implements ReadScope<T> {
    private final AtomicBoolean closed;
    private final FileSystem fileSystem;
    private final Path path;
    private final OkioSerializer<T> serializer;

    public OkioReadScope(FileSystem fileSystem, Path path, OkioSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.fileSystem = fileSystem;
        this.path = path;
        this.serializer = serializer;
        this.closed = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0082 A[Catch: FileNotFoundException -> 0x0086, TRY_ENTER, TryCatch #4 {FileNotFoundException -> 0x0086, blocks: (B:15:0x0082, B:18:0x008a, B:44:0x0042), top: B:43:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a A[Catch: FileNotFoundException -> 0x0086, TRY_LEAVE, TryCatch #4 {FileNotFoundException -> 0x0086, blocks: (B:15:0x0082, B:18:0x008a, B:44:0x0042), top: B:43:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ <T> Object readData$suspendImpl(OkioReadScope<T> okioReadScope, Continuation<? super T> continuation) {
        OkioReadScope$readData$1 okioReadScope$readData$1;
        int i5;
        Throwable th;
        OkioReadScope<T> okioReadScope2;
        FileNotFoundException e5;
        Closeable closeable;
        Throwable th2;
        if (continuation instanceof OkioReadScope$readData$1) {
            okioReadScope$readData$1 = (OkioReadScope$readData$1) continuation;
            int i6 = okioReadScope$readData$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                okioReadScope$readData$1.label = i6 - Integer.MIN_VALUE;
                Object obj = okioReadScope$readData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = okioReadScope$readData$1.label;
                th = null;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    okioReadScope.checkClose();
                    try {
                        BufferedSource buffer = Okio.buffer(((OkioReadScope) okioReadScope).fileSystem.source(((OkioReadScope) okioReadScope).path));
                        try {
                            OkioSerializer<T> okioSerializer = ((OkioReadScope) okioReadScope).serializer;
                            okioReadScope$readData$1.L$0 = okioReadScope;
                            okioReadScope$readData$1.L$1 = buffer;
                            okioReadScope$readData$1.label = 1;
                            Object readFrom = okioSerializer.readFrom(buffer, okioReadScope$readData$1);
                            if (readFrom == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            okioReadScope2 = okioReadScope;
                            closeable = buffer;
                            obj = readFrom;
                        } catch (Throwable th3) {
                            okioReadScope2 = okioReadScope;
                            closeable = buffer;
                            th2 = th3;
                            if (closeable != null) {
                            }
                            th = th2;
                            obj = null;
                            if (th == null) {
                            }
                        }
                    } catch (FileNotFoundException e6) {
                        okioReadScope2 = okioReadScope;
                        e5 = e6;
                        if (((OkioReadScope) okioReadScope2).fileSystem.exists(((OkioReadScope) okioReadScope2).path)) {
                            return ((OkioReadScope) okioReadScope2).serializer.getDefaultValue();
                        }
                        throw e5;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    closeable = (Closeable) okioReadScope$readData$1.L$1;
                    okioReadScope2 = (OkioReadScope) okioReadScope$readData$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (closeable != null) {
                            try {
                                closeable.close();
                            } catch (Throwable th5) {
                                try {
                                    ExceptionsKt.addSuppressed(th2, th5);
                                } catch (FileNotFoundException e7) {
                                    e5 = e7;
                                    if (((OkioReadScope) okioReadScope2).fileSystem.exists(((OkioReadScope) okioReadScope2).path)) {
                                    }
                                }
                            }
                        }
                        th = th2;
                        obj = null;
                        if (th == null) {
                        }
                    }
                }
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (Throwable th6) {
                        th = th6;
                    }
                }
                if (th == null) {
                    throw th;
                }
                Intrinsics.checkNotNull(obj);
                return obj;
            }
        }
        okioReadScope$readData$1 = new OkioReadScope$readData$1(okioReadScope, continuation);
        Object obj2 = okioReadScope$readData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = okioReadScope$readData$1.label;
        th = null;
        if (i5 != 0) {
        }
        if (closeable != null) {
        }
        if (th == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkClose() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Path getPath() {
        return this.path;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final OkioSerializer<T> getSerializer() {
        return this.serializer;
    }

    @Override // androidx.datastore.core.ReadScope
    public Object readData(Continuation<? super T> continuation) {
        return readData$suspendImpl(this, continuation);
    }
}
