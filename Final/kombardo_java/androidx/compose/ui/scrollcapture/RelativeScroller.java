package androidx.compose.ui.scrollcapture;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0013R\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR,\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/scrollcapture/RelativeScroller;", BuildConfig.FLAVOR, "viewportSize", BuildConfig.FLAVOR, "scrollBy", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Lkotlin/coroutines/Continuation;", "(ILkotlin/jvm/functions/Function2;)V", "<set-?>", "scrollAmount", "getScrollAmount", "()F", "Lkotlin/jvm/functions/Function2;", "mapOffsetToViewport", "offset", "reset", BuildConfig.FLAVOR, "delta", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollRangeIntoView", "min", "max", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollTo", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RelativeScroller {
    private float scrollAmount;
    private final Function2<Float, Continuation<? super Float>, Object> scrollBy;
    private final int viewportSize;

    /* JADX WARN: Multi-variable type inference failed */
    public RelativeScroller(int i5, Function2<? super Float, ? super Continuation<? super Float>, ? extends Object> function2) {
        this.viewportSize = i5;
        this.scrollBy = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object scrollBy(float f5, Continuation<? super Unit> continuation) {
        RelativeScroller$scrollBy$1 relativeScroller$scrollBy$1;
        int i5;
        RelativeScroller relativeScroller;
        if (continuation instanceof RelativeScroller$scrollBy$1) {
            relativeScroller$scrollBy$1 = (RelativeScroller$scrollBy$1) continuation;
            int i6 = relativeScroller$scrollBy$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                relativeScroller$scrollBy$1.label = i6 - Integer.MIN_VALUE;
                Object obj = relativeScroller$scrollBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = relativeScroller$scrollBy$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2<Float, Continuation<? super Float>, Object> function2 = this.scrollBy;
                    Float boxFloat = Boxing.boxFloat(f5);
                    relativeScroller$scrollBy$1.L$0 = this;
                    relativeScroller$scrollBy$1.label = 1;
                    obj = function2.invoke(boxFloat, relativeScroller$scrollBy$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    relativeScroller = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    relativeScroller = (RelativeScroller) relativeScroller$scrollBy$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                relativeScroller.scrollAmount += ((Number) obj).floatValue();
                return Unit.INSTANCE;
            }
        }
        relativeScroller$scrollBy$1 = new RelativeScroller$scrollBy$1(this, continuation);
        Object obj2 = relativeScroller$scrollBy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = relativeScroller$scrollBy$1.label;
        if (i5 != 0) {
        }
        relativeScroller.scrollAmount += ((Number) obj2).floatValue();
        return Unit.INSTANCE;
    }

    public final float getScrollAmount() {
        return this.scrollAmount;
    }

    public final int mapOffsetToViewport(int offset) {
        return RangesKt.coerceIn(offset - MathKt.roundToInt(this.scrollAmount), 0, this.viewportSize);
    }

    public final void reset() {
        this.scrollAmount = 0.0f;
    }

    public final Object scrollRangeIntoView(int i5, int i6, Continuation<? super Unit> continuation) {
        if (i5 > i6) {
            throw new IllegalArgumentException(("Expected min=" + i5 + " ≤ max=" + i6).toString());
        }
        int i7 = i6 - i5;
        int i8 = this.viewportSize;
        if (i7 > i8) {
            throw new IllegalArgumentException(("Expected range (" + i7 + ") to be ≤ viewportSize=" + this.viewportSize).toString());
        }
        float f5 = i5;
        float f6 = this.scrollAmount;
        if (f5 >= f6 && i6 <= i8 + f6) {
            return Unit.INSTANCE;
        }
        if (f5 >= f6) {
            i5 = i6 - i8;
        }
        Object scrollTo = scrollTo(i5, continuation);
        return scrollTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollTo : Unit.INSTANCE;
    }

    public final Object scrollTo(float f5, Continuation<? super Unit> continuation) {
        Object scrollBy = scrollBy(f5 - this.scrollAmount, continuation);
        return scrollBy == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollBy : Unit.INSTANCE;
    }
}
