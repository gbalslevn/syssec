package dk.molslinjen.domain.localstorage.base;

import android.content.Context;
import android.content.res.AssetManager;
import dk.molslinjen.core.log.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.localstorage.base.FileRepository$preloadStorageFileIfNecessary$2", f = "FileRepository.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class FileRepository$preloadStorageFileIfNecessary$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $appContext;
    int label;
    final /* synthetic */ FileRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileRepository$preloadStorageFileIfNecessary$2(FileRepository fileRepository, Context context, Continuation<? super FileRepository$preloadStorageFileIfNecessary$2> continuation) {
        super(2, continuation);
        this.this$0 = fileRepository;
        this.$appContext = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileRepository$preloadStorageFileIfNecessary$2(this.this$0, this.$appContext, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        File file;
        File file2;
        String str;
        String str2;
        String str3;
        InputStream fileInputStream;
        String str4;
        String str5;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        file = this.this$0.fileDirectory;
        file.mkdir();
        file2 = this.this$0.fileDirectory;
        str = this.this$0.fileName;
        File file3 = new File(file2, str);
        if (file3.exists()) {
            return Unit.INSTANCE;
        }
        try {
            Logger logger = Logger.INSTANCE;
            str3 = this.this$0.fileName;
            Logger.log$default(logger, "Will preload (copy or generate asset file): " + str3, "FileRepository", 0, 4, null);
            String[] list = this.$appContext.getAssets().list(BuildConfig.FLAVOR);
            if (list != null) {
                FileRepository fileRepository = this.this$0;
                for (String str6 : list) {
                    str4 = fileRepository.fileName;
                    if (Intrinsics.areEqual(str6, str4)) {
                        AssetManager assets = this.$appContext.getAssets();
                        str5 = this.this$0.fileName;
                        fileInputStream = assets.open(str5);
                        break;
                    }
                }
            }
            fileInputStream = new FileInputStream(File.createTempFile("temp", "json"));
            Intrinsics.checkNotNull(fileInputStream);
            FileRepository fileRepository2 = this.this$0;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                try {
                    fileRepository2.copyFile(fileInputStream, fileOutputStream);
                    fileOutputStream.flush();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(fileInputStream, null);
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileInputStream, th);
                    throw th2;
                }
            }
        } catch (IOException e5) {
            Logger logger2 = Logger.INSTANCE;
            str2 = this.this$0.fileName;
            Logger.log$default(logger2, "Failed to copy asset file: " + str2, "FileRepository", 0, 4, null);
            logger2.logError(e5);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FileRepository$preloadStorageFileIfNecessary$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
