package androidx.collection;

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

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "E", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1", f = "ScatterSet.kt", l = {1057}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1<E> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super E>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MutableScatterSet<E> this$0;
    final /* synthetic */ MutableScatterSet$MutableSetWrapper$iterator$1 this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(MutableScatterSet mutableScatterSet, MutableScatterSet$MutableSetWrapper$iterator$1 mutableScatterSet$MutableSetWrapper$iterator$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mutableScatterSet;
        this.this$1 = mutableScatterSet$MutableSetWrapper$iterator$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1 mutableScatterSet$MutableSetWrapper$iterator$1$iterator$1 = new MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(this.this$0, this.this$1, continuation);
        mutableScatterSet$MutableSetWrapper$iterator$1$iterator$1.L$0 = obj;
        return mutableScatterSet$MutableSetWrapper$iterator$1$iterator$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0071  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x009c -> B:5:0x009f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0057 -> B:15:0x00ad). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0059 -> B:6:0x006f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0078 -> B:5:0x009f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        MutableScatterSet<E> mutableScatterSet;
        MutableScatterSet$MutableSetWrapper$iterator$1 mutableScatterSet$MutableSetWrapper$iterator$1;
        long[] jArr;
        int length;
        int i5;
        long j5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
            mutableScatterSet = this.this$0;
            mutableScatterSet$MutableSetWrapper$iterator$1 = this.this$1;
            jArr = mutableScatterSet.metadata;
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
        int i9 = this.I$1;
        int i10 = this.I$0;
        long[] jArr2 = (long[]) this.L$3;
        MutableScatterSet<E> mutableScatterSet2 = (MutableScatterSet) this.L$2;
        MutableScatterSet$MutableSetWrapper$iterator$1 mutableScatterSet$MutableSetWrapper$iterator$12 = (MutableScatterSet$MutableSetWrapper$iterator$1) this.L$1;
        SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(obj);
        j6 >>= 8;
        i7++;
        if (i7 < i8) {
            if (i8 == 8) {
                jArr = jArr2;
                mutableScatterSet = mutableScatterSet2;
                mutableScatterSet$MutableSetWrapper$iterator$1 = mutableScatterSet$MutableSetWrapper$iterator$12;
                sequenceScope = sequenceScope2;
                int i11 = i10;
                i5 = i9;
                length = i11;
                if (i5 != length) {
                    i5++;
                    j5 = jArr[i5];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        sequenceScope2 = sequenceScope;
                        i7 = 0;
                        mutableScatterSet2 = mutableScatterSet;
                        jArr2 = jArr;
                        i8 = 8 - ((~(i5 - length)) >>> 31);
                        mutableScatterSet$MutableSetWrapper$iterator$12 = mutableScatterSet$MutableSetWrapper$iterator$1;
                        j6 = j5;
                        int i12 = i5;
                        i10 = length;
                        i9 = i12;
                        if (i7 < i8) {
                            if ((255 & j6) < 128) {
                                int i13 = (i9 << 3) + i7;
                                mutableScatterSet$MutableSetWrapper$iterator$12.setCurrent(i13);
                                Object obj2 = mutableScatterSet2.elements[i13];
                                this.L$0 = sequenceScope2;
                                this.L$1 = mutableScatterSet$MutableSetWrapper$iterator$12;
                                this.L$2 = mutableScatterSet2;
                                this.L$3 = jArr2;
                                this.I$0 = i10;
                                this.I$1 = i9;
                                this.J$0 = j6;
                                this.I$2 = i8;
                                this.I$3 = i7;
                                this.label = 1;
                                if (sequenceScope2.yield(obj2, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            j6 >>= 8;
                            i7++;
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
    public final Object invoke(SequenceScope<? super E> sequenceScope, Continuation<? super Unit> continuation) {
        return ((MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
