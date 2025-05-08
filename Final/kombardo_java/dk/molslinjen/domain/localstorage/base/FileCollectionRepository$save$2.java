package dk.molslinjen.domain.localstorage.base;

import dk.molslinjen.core.log.Logger;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.localstorage.base.FileCollectionRepository$save$2", f = "FileCollectionRepository.kt", l = {48}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class FileCollectionRepository$save$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<T> $data;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FileCollectionRepository<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.localstorage.base.FileCollectionRepository$save$2$1", f = "FileCollectionRepository.kt", l = {94, 41}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.localstorage.base.FileCollectionRepository$save$2$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ List<T> $data;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ FileCollectionRepository<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(FileCollectionRepository<T> fileCollectionRepository, List<? extends T> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = fileCollectionRepository;
            this.$data = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$data, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            Collection collection;
            FileCollectionRepository fileCollectionRepository;
            KSerializer kSerializer;
            String encodeToString;
            Mutex mutex2;
            Throwable th;
            Exception e5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = ((FileCollectionRepository) this.this$0).mutex;
                collection = this.$data;
                fileCollectionRepository = this.this$0;
                this.L$0 = mutex;
                this.L$1 = collection;
                this.L$2 = fileCollectionRepository;
                this.label = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) this.L$0;
                    try {
                        try {
                            ResultKt.throwOnFailure(obj);
                            Boolean boxBoolean = Boxing.boxBoolean(true);
                            mutex2.unlock(null);
                            return boxBoolean;
                        } catch (Exception e6) {
                            e5 = e6;
                            Logger.INSTANCE.logError(e5);
                            Boolean boxBoolean2 = Boxing.boxBoolean(false);
                            mutex2.unlock(null);
                            return boxBoolean2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                fileCollectionRepository = (FileCollectionRepository) this.L$2;
                collection = (List) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
            }
            if (collection == null) {
                encodeToString = BuildConfig.FLAVOR;
            } else {
                try {
                    Json.Companion companion = Json.INSTANCE;
                    kSerializer = fileCollectionRepository.listSerializer;
                    encodeToString = companion.encodeToString(kSerializer, collection);
                } catch (Exception e7) {
                    mutex2 = mutex;
                    e5 = e7;
                    Logger.INSTANCE.logError(e5);
                    Boolean boxBoolean22 = Boxing.boxBoolean(false);
                    mutex2.unlock(null);
                    return boxBoolean22;
                } catch (Throwable th3) {
                    mutex2 = mutex;
                    th = th3;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            this.L$0 = mutex;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (fileCollectionRepository.writeFile(encodeToString, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex2 = mutex;
            Boolean boxBoolean3 = Boxing.boxBoolean(true);
            mutex2.unlock(null);
            return boxBoolean3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileCollectionRepository$save$2(FileCollectionRepository<T> fileCollectionRepository, List<? extends T> list, Continuation<? super FileCollectionRepository$save$2> continuation) {
        super(2, continuation);
        this.this$0 = fileCollectionRepository;
        this.$data = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FileCollectionRepository$save$2 fileCollectionRepository$save$2 = new FileCollectionRepository$save$2(this.this$0, this.$data, continuation);
        fileCollectionRepository$save$2.L$0 = obj;
        return fileCollectionRepository$save$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Deferred async$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            async$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.this$0, this.$data, null), 3, null);
            this.label = 1;
            obj = async$default.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((FileCollectionRepository$save$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
