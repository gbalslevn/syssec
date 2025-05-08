package dk.molslinjen.domain.localstorage.base;

import android.content.Context;
import dk.molslinjen.domain.localstorage.base.FileCollectionRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fH\u0084@¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0084@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0017R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/domain/localstorage/base/FileCollectionRepository;", "T", "Ldk/molslinjen/domain/localstorage/base/FileRepository;", "appContext", "Landroid/content/Context;", "fileName", BuildConfig.FLAVOR, "serializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lkotlinx/serialization/KSerializer;)V", "listSerializer", BuildConfig.FLAVOR, "mutex", "Lkotlinx/coroutines/sync/Mutex;", "cache", "save", BuildConfig.FLAVOR, "data", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "jsonDeserializer", "Lkotlinx/serialization/json/Json;", "get", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FileCollectionRepository<T> extends FileRepository {
    private List<? extends T> cache;
    private final Json jsonDeserializer;
    private final KSerializer<List<T>> listSerializer;
    private Mutex mutex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCollectionRepository(Context appContext, String fileName, KSerializer<T> serializer) {
        super(appContext, fileName);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.listSerializer = BuiltinSerializersKt.ListSerializer(serializer);
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.jsonDeserializer = JsonKt.Json$default(null, new Function1() { // from class: y1.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit jsonDeserializer$lambda$0;
                jsonDeserializer$lambda$0 = FileCollectionRepository.jsonDeserializer$lambda$0((JsonBuilder) obj);
                return jsonDeserializer$lambda$0;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit jsonDeserializer$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }

    public final Object clear(Continuation<? super Boolean> continuation) {
        return save(null, continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(Continuation<? super List<? extends T>> continuation) {
        FileCollectionRepository$get$1 fileCollectionRepository$get$1;
        int i5;
        if (continuation instanceof FileCollectionRepository$get$1) {
            fileCollectionRepository$get$1 = (FileCollectionRepository$get$1) continuation;
            int i6 = fileCollectionRepository$get$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                fileCollectionRepository$get$1.label = i6 - Integer.MIN_VALUE;
                Object obj = fileCollectionRepository$get$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = fileCollectionRepository$get$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    List<? extends T> list = this.cache;
                    if (list != null) {
                        return CollectionsKt.toList(list);
                    }
                    CoroutineContext plus = fileCollectionRepository$get$1.getContext().plus(Dispatchers.getIO());
                    FileCollectionRepository$get$result$1 fileCollectionRepository$get$result$1 = new FileCollectionRepository$get$result$1(this, null);
                    fileCollectionRepository$get$1.label = 1;
                    obj = BuildersKt.withContext(plus, fileCollectionRepository$get$result$1, fileCollectionRepository$get$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return (List) obj;
            }
        }
        fileCollectionRepository$get$1 = new FileCollectionRepository$get$1(this, continuation);
        Object obj2 = fileCollectionRepository$get$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = fileCollectionRepository$get$1.label;
        if (i5 != 0) {
        }
        return (List) obj2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object save(List<? extends T> list, Continuation<? super Boolean> continuation) {
        this.cache = list;
        return BuildersKt.withContext(continuation.getContext().plus(Dispatchers.getIO()), new FileCollectionRepository$save$2(this, list, null), continuation);
    }
}
