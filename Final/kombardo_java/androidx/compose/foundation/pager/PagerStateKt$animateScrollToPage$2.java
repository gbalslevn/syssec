package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.pager.PagerStateKt$animateScrollToPage$2", f = "PagerState.kt", l = {953}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PagerStateKt$animateScrollToPage$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ int $targetPage;
    final /* synthetic */ float $targetPageOffsetToSnappedPosition;
    final /* synthetic */ LazyLayoutAnimateScrollScope $this_animateScrollToPage;
    final /* synthetic */ Function2<ScrollScope, Integer, Unit> $updateTargetPage;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PagerStateKt$animateScrollToPage$2(Function2<? super ScrollScope, ? super Integer, Unit> function2, int i5, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, float f5, AnimationSpec<Float> animationSpec, Continuation<? super PagerStateKt$animateScrollToPage$2> continuation) {
        super(2, continuation);
        this.$updateTargetPage = function2;
        this.$targetPage = i5;
        this.$this_animateScrollToPage = lazyLayoutAnimateScrollScope;
        this.$targetPageOffsetToSnappedPosition = f5;
        this.$animationSpec = animationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PagerStateKt$animateScrollToPage$2 pagerStateKt$animateScrollToPage$2 = new PagerStateKt$animateScrollToPage$2(this.$updateTargetPage, this.$targetPage, this.$this_animateScrollToPage, this.$targetPageOffsetToSnappedPosition, this.$animationSpec, continuation);
        pagerStateKt$animateScrollToPage$2.L$0 = obj;
        return pagerStateKt$animateScrollToPage$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((PagerStateKt$animateScrollToPage$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            final ScrollScope scrollScope = (ScrollScope) this.L$0;
            this.$updateTargetPage.invoke(scrollScope, Boxing.boxInt(this.$targetPage));
            boolean z5 = this.$targetPage > this.$this_animateScrollToPage.getFirstVisibleItemIndex();
            int lastVisibleItemIndex = (this.$this_animateScrollToPage.getLastVisibleItemIndex() - this.$this_animateScrollToPage.getFirstVisibleItemIndex()) + 1;
            if (((z5 && this.$targetPage > this.$this_animateScrollToPage.getLastVisibleItemIndex()) || (!z5 && this.$targetPage < this.$this_animateScrollToPage.getFirstVisibleItemIndex())) && Math.abs(this.$targetPage - this.$this_animateScrollToPage.getFirstVisibleItemIndex()) >= 3) {
                this.$this_animateScrollToPage.snapToItem(scrollScope, z5 ? RangesKt.coerceAtLeast(this.$targetPage - lastVisibleItemIndex, this.$this_animateScrollToPage.getFirstVisibleItemIndex()) : RangesKt.coerceAtMost(this.$targetPage + lastVisibleItemIndex, this.$this_animateScrollToPage.getFirstVisibleItemIndex()), 0);
            }
            float calculateDistanceTo = this.$this_animateScrollToPage.calculateDistanceTo(this.$targetPage) + this.$targetPageOffsetToSnappedPosition;
            final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
            AnimationSpec<Float> animationSpec = this.$animationSpec;
            Function2<Float, Float, Unit> function2 = new Function2<Float, Float, Unit>() { // from class: androidx.compose.foundation.pager.PagerStateKt$animateScrollToPage$2.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Float f5, Float f6) {
                    invoke(f5.floatValue(), f6.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f5, float f6) {
                    Ref$FloatRef.this.element += scrollScope.scrollBy(f5 - Ref$FloatRef.this.element);
                }
            };
            this.label = 1;
            if (SuspendAnimationKt.animate$default(0.0f, calculateDistanceTo, 0.0f, animationSpec, function2, this, 4, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
