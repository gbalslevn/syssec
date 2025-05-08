package dk.molslinjen.domain.localstorage.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.localstorage.base.FileCollectionRepository", f = "FileCollectionRepository.kt", l = {61}, m = "get")
/* loaded from: classes2.dex */
public final class FileCollectionRepository$get$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileCollectionRepository<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCollectionRepository$get$1(FileCollectionRepository<T> fileCollectionRepository, Continuation<? super FileCollectionRepository$get$1> continuation) {
        super(continuation);
        this.this$0 = fileCollectionRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.get(this);
    }
}
