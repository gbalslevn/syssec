package dk.molslinjen.domain.localstorage.base;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00018\u0000H\u0084@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00018\u0000H\u0084@¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/domain/localstorage/base/FileObjectRepository;", "T", "Ldk/molslinjen/domain/localstorage/base/FileCollectionRepository;", "appContext", "Landroid/content/Context;", "fileName", BuildConfig.FLAVOR, "serializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lkotlinx/serialization/KSerializer;)V", "saveItem", BuildConfig.FLAVOR, "data", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItem", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FileObjectRepository<T> extends FileCollectionRepository<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileObjectRepository(Context appContext, String fileName, KSerializer<T> serializer) {
        super(appContext, fileName, serializer);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getItem(Continuation<? super T> continuation) {
        FileObjectRepository$getItem$1 fileObjectRepository$getItem$1;
        int i5;
        if (continuation instanceof FileObjectRepository$getItem$1) {
            fileObjectRepository$getItem$1 = (FileObjectRepository$getItem$1) continuation;
            int i6 = fileObjectRepository$getItem$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                fileObjectRepository$getItem$1.label = i6 - Integer.MIN_VALUE;
                Object obj = fileObjectRepository$getItem$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = fileObjectRepository$getItem$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    fileObjectRepository$getItem$1.label = 1;
                    obj = get(fileObjectRepository$getItem$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return CollectionsKt.firstOrNull((List) obj);
            }
        }
        fileObjectRepository$getItem$1 = new FileObjectRepository$getItem$1(this, continuation);
        Object obj2 = fileObjectRepository$getItem$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = fileObjectRepository$getItem$1.label;
        if (i5 != 0) {
        }
        return CollectionsKt.firstOrNull((List) obj2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object saveItem(T t5, Continuation<? super Boolean> continuation) {
        return save(t5 == null ? null : CollectionsKt.listOf(t5), continuation);
    }
}
