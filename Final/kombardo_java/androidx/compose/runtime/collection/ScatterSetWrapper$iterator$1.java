package androidx.compose.runtime.collection;

import androidx.collection.ScatterSet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "T", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.collection.ScatterSetWrapper$iterator$1", f = "ScatterSetWrapper.kt", l = {34}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class ScatterSetWrapper$iterator$1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ScatterSetWrapper<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScatterSetWrapper$iterator$1(ScatterSetWrapper<T> scatterSetWrapper, Continuation<? super ScatterSetWrapper$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = scatterSetWrapper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScatterSetWrapper$iterator$1 scatterSetWrapper$iterator$1 = new ScatterSetWrapper$iterator$1(this.this$0, continuation);
        scatterSetWrapper$iterator$1.L$0 = obj;
        return scatterSetWrapper$iterator$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x006d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0091 -> B:5:0x0094). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0058 -> B:15:0x009d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005a -> B:6:0x006b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0074 -> B:5:0x0094). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        Object[] objArr;
        long[] jArr;
        int length;
        int i5;
        long j5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
            ScatterSet<T> set$runtime_release = this.this$0.getSet$runtime_release();
            objArr = set$runtime_release.elements;
            jArr = set$runtime_release.metadata;
            length = jArr.length - 2;
            if (length >= 0) {
                i5 = 0;
                j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                }
                if (i5 != length) {
                }
            }
            return Unit.INSTANCE;
        }
        if (i6 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i7 = this.I$3;
        int i8 = this.I$2;
        long j6 = this.J$0;
        i5 = this.I$1;
        int i9 = this.I$0;
        long[] jArr2 = (long[]) this.L$2;
        Object[] objArr2 = (Object[]) this.L$1;
        SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(obj);
        SequenceScope sequenceScope3 = sequenceScope2;
        j6 >>= 8;
        i7++;
        SequenceScope sequenceScope4 = sequenceScope3;
        if (i7 < i8) {
            if (i8 == 8) {
                length = i9;
                jArr = jArr2;
                objArr = objArr2;
                sequenceScope = sequenceScope4;
                if (i5 != length) {
                    i5++;
                    j5 = jArr[i5];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        sequenceScope4 = sequenceScope;
                        i7 = 0;
                        jArr2 = jArr;
                        i9 = length;
                        i8 = 8 - ((~(i5 - length)) >>> 31);
                        objArr2 = objArr;
                        j6 = j5;
                        if (i7 < i8) {
                            sequenceScope3 = sequenceScope4;
                            if ((255 & j6) < 128) {
                                Object obj2 = objArr2[(i5 << 3) + i7];
                                this.L$0 = sequenceScope4;
                                this.L$1 = objArr2;
                                this.L$2 = jArr2;
                                this.I$0 = i9;
                                this.I$1 = i5;
                                this.J$0 = j6;
                                this.I$2 = i8;
                                this.I$3 = i7;
                                this.label = 1;
                                Object yield = sequenceScope4.yield(obj2, this);
                                sequenceScope3 = sequenceScope4;
                                if (yield == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            j6 >>= 8;
                            i7++;
                            SequenceScope sequenceScope42 = sequenceScope3;
                            if (i7 < i8) {
                            }
                        }
                    }
                    if (i5 != length) {
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super T> sequenceScope, Continuation<? super Unit> continuation) {
        return ((ScatterSetWrapper$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
