package androidx.datastore.core.okio;

import androidx.datastore.core.WriteScope;
import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.FileHandle;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/datastore/core/okio/OkioWriteScope;", "T", "Landroidx/datastore/core/okio/OkioReadScope;", "Landroidx/datastore/core/WriteScope;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;)V", "writeData", BuildConfig.FLAVOR, "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OkioWriteScope<T> extends OkioReadScope<T> implements WriteScope<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioWriteScope(FileSystem fileSystem, Path path, OkioSerializer<T> serializer) {
        super(fileSystem, path, serializer);
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(8:5|6|7|(1:(3:10|11|12)(2:42|43))(6:44|45|46|47|48|(1:50)(1:51))|13|(2:29|30)|15|(3:17|(2:24|25)|(2:20|21)(1:23))(1:28)))|66|6|7|(0)(0)|13|(0)|15|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0090, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0091, code lost:
    
        r10 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0097 A[Catch: all -> 0x0090, TRY_LEAVE, TryCatch #0 {all -> 0x0090, blocks: (B:17:0x0097, B:28:0x00a4, B:41:0x008c, B:38:0x0087), top: B:7:0x0022, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a4 A[Catch: all -> 0x0090, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0090, blocks: (B:17:0x0097, B:28:0x00a4, B:41:0x008c, B:38:0x0087), top: B:7:0x0022, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.coroutines.Continuation, androidx.datastore.core.okio.OkioWriteScope$writeData$1] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.datastore.core.okio.OkioSerializer] */
    @Override // androidx.datastore.core.WriteScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object writeData(T t5, Continuation<? super Unit> continuation) {
        ?? r02;
        int i5;
        Unit unit;
        Throwable th;
        Closeable closeable;
        FileHandle fileHandle;
        Throwable th2;
        Unit unit2;
        if (continuation instanceof OkioWriteScope$writeData$1) {
            OkioWriteScope$writeData$1 okioWriteScope$writeData$1 = (OkioWriteScope$writeData$1) continuation;
            int i6 = okioWriteScope$writeData$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                okioWriteScope$writeData$1.label = i6 - Integer.MIN_VALUE;
                r02 = okioWriteScope$writeData$1;
                Object obj = r02.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = r02.label;
                Throwable th3 = null;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    checkClose();
                    FileHandle fileHandle2 = getFileSystem().openReadWrite(getPath());
                    try {
                        BufferedSink buffer = Okio.buffer(FileHandle.sink$default(fileHandle2, 0L, 1, null));
                        try {
                            OkioSerializer<T> serializer = getSerializer();
                            r02.L$0 = fileHandle2;
                            r02.L$1 = fileHandle2;
                            r02.L$2 = buffer;
                            r02.label = 1;
                            if (serializer.writeTo(t5, buffer, r02) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            FileHandle fileHandle3 = fileHandle2;
                            fileHandle = fileHandle3;
                            closeable = buffer;
                            r02 = fileHandle3;
                        } catch (Throwable th4) {
                            r02 = fileHandle2;
                            th = th4;
                            closeable = buffer;
                            if (closeable != null) {
                                try {
                                    closeable.close();
                                } catch (Throwable th5) {
                                    ExceptionsKt.addSuppressed(th, th5);
                                }
                            }
                            th2 = th;
                            unit2 = null;
                            if (th2 == null) {
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        if (fileHandle2 != null) {
                            try {
                                fileHandle2.close();
                            } catch (Throwable th7) {
                                ExceptionsKt.addSuppressed(th, th7);
                            }
                        }
                        th3 = th;
                        unit = null;
                        if (th3 == null) {
                        }
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    closeable = (Closeable) r02.L$2;
                    fileHandle = (FileHandle) r02.L$1;
                    r02 = (Closeable) r02.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        r02 = r02;
                    } catch (Throwable th8) {
                        th = th8;
                        if (closeable != null) {
                        }
                        th2 = th;
                        unit2 = null;
                        if (th2 == null) {
                        }
                    }
                }
                fileHandle.flush();
                unit2 = Unit.INSTANCE;
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (Throwable th9) {
                        th2 = th9;
                    }
                }
                th2 = null;
                if (th2 == null) {
                    throw th2;
                }
                Intrinsics.checkNotNull(unit2);
                unit = Unit.INSTANCE;
                if (r02 != 0) {
                    try {
                        r02.close();
                    } catch (Throwable th10) {
                        th3 = th10;
                    }
                }
                if (th3 == null) {
                    throw th3;
                }
                Intrinsics.checkNotNull(unit);
                return Unit.INSTANCE;
            }
        }
        r02 = new OkioWriteScope$writeData$1(this, continuation);
        Object obj2 = r02.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = r02.label;
        Throwable th32 = null;
        if (i5 != 0) {
        }
        fileHandle.flush();
        unit2 = Unit.INSTANCE;
        if (closeable != null) {
        }
        th2 = null;
        if (th2 == null) {
        }
    }
}
