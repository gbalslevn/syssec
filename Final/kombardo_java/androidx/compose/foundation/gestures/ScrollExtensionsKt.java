package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Ref$FloatRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a,\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableState;", BuildConfig.FLAVOR, "value", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "animateScrollBy", "(Landroidx/compose/foundation/gestures/ScrollableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollBy", "(Landroidx/compose/foundation/gestures/ScrollableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ScrollExtensionsKt {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object animateScrollBy(ScrollableState scrollableState, float f5, AnimationSpec<Float> animationSpec, Continuation<? super Float> continuation) {
        ScrollExtensionsKt$animateScrollBy$1 scrollExtensionsKt$animateScrollBy$1;
        int i5;
        Ref$FloatRef ref$FloatRef;
        if (continuation instanceof ScrollExtensionsKt$animateScrollBy$1) {
            scrollExtensionsKt$animateScrollBy$1 = (ScrollExtensionsKt$animateScrollBy$1) continuation;
            int i6 = scrollExtensionsKt$animateScrollBy$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                scrollExtensionsKt$animateScrollBy$1.label = i6 - Integer.MIN_VALUE;
                ScrollExtensionsKt$animateScrollBy$1 scrollExtensionsKt$animateScrollBy$12 = scrollExtensionsKt$animateScrollBy$1;
                Object obj = scrollExtensionsKt$animateScrollBy$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = scrollExtensionsKt$animateScrollBy$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
                    ScrollExtensionsKt$animateScrollBy$2 scrollExtensionsKt$animateScrollBy$2 = new ScrollExtensionsKt$animateScrollBy$2(f5, animationSpec, ref$FloatRef2, null);
                    scrollExtensionsKt$animateScrollBy$12.L$0 = ref$FloatRef2;
                    scrollExtensionsKt$animateScrollBy$12.label = 1;
                    if (ScrollableState.scroll$default(scrollableState, null, scrollExtensionsKt$animateScrollBy$2, scrollExtensionsKt$animateScrollBy$12, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ref$FloatRef = ref$FloatRef2;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ref$FloatRef = (Ref$FloatRef) scrollExtensionsKt$animateScrollBy$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxFloat(ref$FloatRef.element);
            }
        }
        scrollExtensionsKt$animateScrollBy$1 = new ScrollExtensionsKt$animateScrollBy$1(continuation);
        ScrollExtensionsKt$animateScrollBy$1 scrollExtensionsKt$animateScrollBy$122 = scrollExtensionsKt$animateScrollBy$1;
        Object obj2 = scrollExtensionsKt$animateScrollBy$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = scrollExtensionsKt$animateScrollBy$122.label;
        if (i5 != 0) {
        }
        return Boxing.boxFloat(ref$FloatRef.element);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object scrollBy(ScrollableState scrollableState, float f5, Continuation<? super Float> continuation) {
        ScrollExtensionsKt$scrollBy$1 scrollExtensionsKt$scrollBy$1;
        int i5;
        Ref$FloatRef ref$FloatRef;
        if (continuation instanceof ScrollExtensionsKt$scrollBy$1) {
            scrollExtensionsKt$scrollBy$1 = (ScrollExtensionsKt$scrollBy$1) continuation;
            int i6 = scrollExtensionsKt$scrollBy$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                scrollExtensionsKt$scrollBy$1.label = i6 - Integer.MIN_VALUE;
                ScrollExtensionsKt$scrollBy$1 scrollExtensionsKt$scrollBy$12 = scrollExtensionsKt$scrollBy$1;
                Object obj = scrollExtensionsKt$scrollBy$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = scrollExtensionsKt$scrollBy$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
                    ScrollExtensionsKt$scrollBy$2 scrollExtensionsKt$scrollBy$2 = new ScrollExtensionsKt$scrollBy$2(ref$FloatRef2, f5, null);
                    scrollExtensionsKt$scrollBy$12.L$0 = ref$FloatRef2;
                    scrollExtensionsKt$scrollBy$12.label = 1;
                    if (ScrollableState.scroll$default(scrollableState, null, scrollExtensionsKt$scrollBy$2, scrollExtensionsKt$scrollBy$12, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ref$FloatRef = ref$FloatRef2;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ref$FloatRef = (Ref$FloatRef) scrollExtensionsKt$scrollBy$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxFloat(ref$FloatRef.element);
            }
        }
        scrollExtensionsKt$scrollBy$1 = new ScrollExtensionsKt$scrollBy$1(continuation);
        ScrollExtensionsKt$scrollBy$1 scrollExtensionsKt$scrollBy$122 = scrollExtensionsKt$scrollBy$1;
        Object obj2 = scrollExtensionsKt$scrollBy$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = scrollExtensionsKt$scrollBy$122.label;
        if (i5 != 0) {
        }
        return Boxing.boxFloat(ref$FloatRef.element);
    }
}
