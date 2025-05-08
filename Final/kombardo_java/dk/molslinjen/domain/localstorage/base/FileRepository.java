package dk.molslinjen.domain.localstorage.base;

import android.content.Context;
import dk.molslinjen.core.log.Logger;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\n\u001a\u00020\u0004H\u0084@¢\u0006\u0004\b\n\u0010\u0018J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0084@¢\u0006\u0004\b\u000e\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Ldk/molslinjen/domain/localstorage/base/FileRepository;", BuildConfig.FLAVOR, "Landroid/content/Context;", "appContext", BuildConfig.FLAVOR, "fileName", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Ljava/io/File;", "file", "readFile", "(Ljava/io/File;)Ljava/lang/String;", "data", BuildConfig.FLAVOR, "writeFile", "(Ljava/io/File;Ljava/lang/String;)V", "preloadStorageFileIfNecessary", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/InputStream;", "input", "Ljava/io/OutputStream;", "out", "copyFile", "(Ljava/io/InputStream;Ljava/io/OutputStream;)V", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/String;", "fileDirectory", "Ljava/io/File;", BuildConfig.FLAVOR, "bufferSize", "I", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FileRepository {
    private final int bufferSize;
    private final File fileDirectory;
    private final String fileName;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.localstorage.base.FileRepository$1", f = "FileRepository.kt", l = {21}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.localstorage.base.FileRepository$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $appContext;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$appContext = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$appContext, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                FileRepository fileRepository = FileRepository.this;
                Context context = this.$appContext;
                this.label = 1;
                if (fileRepository.preloadStorageFileIfNecessary(context, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FileRepository(Context appContext, String fileName) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.fileName = fileName;
        File filesDir = appContext.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        this.fileDirectory = filesDir;
        this.bufferSize = 1024;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(appContext, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void copyFile(InputStream input, OutputStream out) {
        byte[] bArr = new byte[this.bufferSize];
        int read = input.read(bArr);
        while (read != -1) {
            out.write(bArr, 0, read);
            read = input.read(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object preloadStorageFileIfNecessary(Context context, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(continuation.getContext().plus(Dispatchers.getIO()), new FileRepository$preloadStorageFileIfNecessary$2(this, context, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object readFile(Continuation<? super String> continuation) {
        return BuildersKt.withContext(continuation.getContext().plus(Dispatchers.getIO()), new FileRepository$readFile$2(this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object writeFile(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(continuation.getContext().plus(Dispatchers.getIO()), new FileRepository$writeFile$2(this, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String readFile(File file) {
        if (!file.exists()) {
            file.createNewFile();
        }
        return FilesKt.readText(file, Charsets.UTF_8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeFile(File file, String data) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintStream printStream = new PrintStream(file);
            try {
                printStream.println(data);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(printStream, null);
            } finally {
            }
        } catch (Exception e5) {
            Logger.INSTANCE.logError(e5);
        }
    }
}
