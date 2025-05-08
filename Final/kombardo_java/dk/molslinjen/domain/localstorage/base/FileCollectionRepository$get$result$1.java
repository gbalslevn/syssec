package dk.molslinjen.domain.localstorage.base;

import dk.molslinjen.core.log.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.localstorage.base.FileCollectionRepository$get$result$1", f = "FileCollectionRepository.kt", l = {94, 68}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class FileCollectionRepository$get$result$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends T>>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FileCollectionRepository<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCollectionRepository$get$result$1(FileCollectionRepository<T> fileCollectionRepository, Continuation<? super FileCollectionRepository$get$result$1> continuation) {
        super(2, continuation);
        this.this$0 = fileCollectionRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileCollectionRepository$get$result$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0077 A[Catch: all -> 0x001b, Exception -> 0x001e, TryCatch #0 {Exception -> 0x001e, blocks: (B:7:0x0017, B:8:0x006f, B:10:0x0077, B:11:0x0088, B:13:0x008e, B:19:0x0096), top: B:6:0x0017 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        FileCollectionRepository<T> fileCollectionRepository;
        Mutex mutex2;
        Throwable th;
        List list;
        Exception e5;
        Object readFile;
        FileCollectionRepository<T> fileCollectionRepository2;
        List list2;
        List emptyList;
        String str;
        List list3;
        Json json;
        KSerializer kSerializer;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        try {
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = ((FileCollectionRepository) this.this$0).mutex;
                fileCollectionRepository = this.this$0;
                this.L$0 = mutex;
                this.L$1 = fileCollectionRepository;
                this.label = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    fileCollectionRepository2 = (FileCollectionRepository) this.L$1;
                    mutex2 = (Mutex) this.L$0;
                    try {
                        try {
                            ResultKt.throwOnFailure(obj);
                            str = (String) obj;
                            if (str.length() > 2) {
                                json = ((FileCollectionRepository) fileCollectionRepository2).jsonDeserializer;
                                kSerializer = ((FileCollectionRepository) fileCollectionRepository2).listSerializer;
                                ((FileCollectionRepository) fileCollectionRepository2).cache = (List) json.decodeFromString(kSerializer, str);
                            }
                            list3 = ((FileCollectionRepository) fileCollectionRepository2).cache;
                            if (list3 != null || (emptyList = CollectionsKt.toList(list3)) == null) {
                                emptyList = CollectionsKt.emptyList();
                            }
                        } catch (Exception e6) {
                            e5 = e6;
                            Logger.INSTANCE.logError(e5);
                            emptyList = CollectionsKt.emptyList();
                            list2 = emptyList;
                            mutex = mutex2;
                            mutex.unlock(null);
                            return list2;
                        }
                        list2 = emptyList;
                        mutex = mutex2;
                        mutex.unlock(null);
                        return list2;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                fileCollectionRepository = (FileCollectionRepository) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
            }
            list = ((FileCollectionRepository) fileCollectionRepository).cache;
            if (list != null) {
                list2 = CollectionsKt.toList(list);
                mutex.unlock(null);
                return list2;
            }
            try {
                this.L$0 = mutex;
                this.L$1 = fileCollectionRepository;
                this.label = 2;
                readFile = fileCollectionRepository.readFile(this);
            } catch (Exception e7) {
                mutex2 = mutex;
                e5 = e7;
                Logger.INSTANCE.logError(e5);
                emptyList = CollectionsKt.emptyList();
                list2 = emptyList;
                mutex = mutex2;
                mutex.unlock(null);
                return list2;
            }
            if (readFile == coroutine_suspended) {
                return coroutine_suspended;
            }
            fileCollectionRepository2 = fileCollectionRepository;
            mutex2 = mutex;
            obj = readFile;
            str = (String) obj;
            if (str.length() > 2) {
            }
            list3 = ((FileCollectionRepository) fileCollectionRepository2).cache;
            if (list3 != null) {
            }
            emptyList = CollectionsKt.emptyList();
            list2 = emptyList;
            mutex = mutex2;
            mutex.unlock(null);
            return list2;
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock(null);
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends T>> continuation) {
        return ((FileCollectionRepository$get$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
