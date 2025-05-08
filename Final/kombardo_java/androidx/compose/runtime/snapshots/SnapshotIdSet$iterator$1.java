package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlin/sequences/SequenceScope;", BuildConfig.FLAVOR}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", l = {295, 300, 307}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class SnapshotIdSet$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SnapshotIdSet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotIdSet$iterator$1(SnapshotIdSet snapshotIdSet, Continuation<? super SnapshotIdSet$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = snapshotIdSet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotIdSet$iterator$1 snapshotIdSet$iterator$1 = new SnapshotIdSet$iterator$1(this.this$0, continuation);
        snapshotIdSet$iterator$1.L$0 = obj;
        return snapshotIdSet$iterator$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0082  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x00ca -> B:8:0x00ea). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00e8 -> B:7:0x00e9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0092 -> B:22:0x00ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ab -> B:22:0x00ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0072 -> B:34:0x0075). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        SequenceScope sequenceScope2;
        int length;
        int[] iArr;
        int i5;
        SequenceScope sequenceScope3;
        int i6;
        SequenceScope sequenceScope4;
        int i7;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
            int[] iArr2 = this.this$0.belowBound;
            if (iArr2 != null) {
                sequenceScope2 = sequenceScope;
                length = iArr2.length;
                iArr = iArr2;
                i5 = 0;
                if (i5 < length) {
                }
            }
            if (this.this$0.lowerSet != 0) {
            }
            if (this.this$0.upperSet != 0) {
            }
            return Unit.INSTANCE;
        }
        if (i8 == 1) {
            length = this.I$1;
            i5 = this.I$0;
            iArr = (int[]) this.L$1;
            sequenceScope2 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i5++;
            if (i5 < length) {
                Integer boxInt = Boxing.boxInt(iArr[i5]);
                this.L$0 = sequenceScope2;
                this.L$1 = iArr;
                this.I$0 = i5;
                this.I$1 = length;
                this.label = 1;
                if (sequenceScope2.yield(boxInt, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i5++;
                if (i5 < length) {
                    sequenceScope = sequenceScope2;
                    if (this.this$0.lowerSet != 0) {
                        sequenceScope3 = sequenceScope;
                        i6 = 0;
                        if (i6 >= 64) {
                        }
                    }
                    if (this.this$0.upperSet != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }
        } else {
            if (i8 != 2) {
                if (i8 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i9 = this.I$0;
                sequenceScope4 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                i7 = i9;
                i7++;
                if (i7 < 64) {
                    if ((this.this$0.upperSet & (1 << i7)) != 0) {
                        Integer boxInt2 = Boxing.boxInt(i7 + 64 + this.this$0.lowerBound);
                        this.L$0 = sequenceScope4;
                        this.L$1 = null;
                        this.I$0 = i7;
                        this.label = 3;
                        if (sequenceScope4.yield(boxInt2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i9 = i7;
                        i7 = i9;
                    }
                    i7++;
                    if (i7 < 64) {
                    }
                }
                return Unit.INSTANCE;
            }
            i6 = this.I$0;
            sequenceScope3 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i6++;
            if (i6 >= 64) {
                sequenceScope = sequenceScope3;
                if (this.this$0.upperSet != 0) {
                    sequenceScope4 = sequenceScope;
                    i7 = 0;
                    if (i7 < 64) {
                    }
                }
                return Unit.INSTANCE;
            }
            if ((this.this$0.lowerSet & (1 << i6)) != 0) {
                Integer boxInt3 = Boxing.boxInt(this.this$0.lowerBound + i6);
                this.L$0 = sequenceScope3;
                this.L$1 = null;
                this.I$0 = i6;
                this.label = 2;
                if (sequenceScope3.yield(boxInt3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            i6++;
            if (i6 >= 64) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Integer> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SnapshotIdSet$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
