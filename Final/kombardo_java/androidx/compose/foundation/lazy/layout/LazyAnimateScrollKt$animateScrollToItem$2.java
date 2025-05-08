package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2", f = "LazyAnimateScroll.kt", l = {174, 272}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class LazyAnimateScrollKt$animateScrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Density $density;
    final /* synthetic */ int $index;
    final /* synthetic */ int $numOfItemsForTeleport;
    final /* synthetic */ int $scrollOffset;
    final /* synthetic */ LazyLayoutAnimateScrollScope $this_animateScrollToItem;
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyAnimateScrollKt$animateScrollToItem$2(int i5, Density density, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i6, int i7, Continuation<? super LazyAnimateScrollKt$animateScrollToItem$2> continuation) {
        super(2, continuation);
        this.$index = i5;
        this.$density = density;
        this.$this_animateScrollToItem = lazyLayoutAnimateScrollScope;
        this.$scrollOffset = i6;
        this.$numOfItemsForTeleport = i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$isOvershot(boolean z5, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i5, int i6) {
        if (z5) {
            if (lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() <= i5 && (lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() != i5 || lazyLayoutAnimateScrollScope.getFirstVisibleItemScrollOffset() <= i6)) {
                return false;
            }
        } else if (lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() >= i5 && (lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() != i5 || lazyLayoutAnimateScrollScope.getFirstVisibleItemScrollOffset() >= i6)) {
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LazyAnimateScrollKt$animateScrollToItem$2 lazyAnimateScrollKt$animateScrollToItem$2 = new LazyAnimateScrollKt$animateScrollToItem$2(this.$index, this.$density, this.$this_animateScrollToItem, this.$scrollOffset, this.$numOfItemsForTeleport, continuation);
        lazyAnimateScrollKt$animateScrollToItem$2.L$0 = obj;
        return lazyAnimateScrollKt$animateScrollToItem$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((LazyAnimateScrollKt$animateScrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ce A[Catch: ItemFoundInScroll -> 0x01bb, TryCatch #4 {ItemFoundInScroll -> 0x01bb, blocks: (B:20:0x00ca, B:22:0x00ce, B:24:0x00d6, B:29:0x0105, B:32:0x0141, B:35:0x014e), top: B:19:0x00ca }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0199 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x023a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v27, types: [androidx.compose.animation.core.AnimationState, T] */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.compose.animation.core.AnimationState, T] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x019a -> B:16:0x01a2). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        ItemFoundInScroll itemFoundInScroll;
        final ScrollScope scrollScope;
        float f5;
        float mo212toPx0680j_4;
        float f6;
        float mo212toPx0680j_42;
        float f7;
        float mo212toPx0680j_43;
        Ref$BooleanRef ref$BooleanRef;
        Ref$ObjectRef ref$ObjectRef;
        float f8;
        float f9;
        ScrollScope scrollScope2;
        float f10;
        int i5;
        Ref$IntRef ref$IntRef;
        AnimationState copy$default;
        Float boxFloat;
        boolean z5;
        boolean z6;
        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1;
        ScrollScope scrollScope3;
        float max;
        final float f11;
        AnimationState animationState;
        Float boxFloat2;
        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function12;
        Object obj3;
        boolean z7;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        float f12 = 0.0f;
        boolean z8 = true;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            ScrollScope scrollScope4 = (ScrollScope) this.L$0;
            int i7 = this.$index;
            if (!(((float) i7) >= 0.0f)) {
                throw new IllegalArgumentException(("Index should be non-negative (" + i7 + ')').toString());
            }
            try {
                Density density = this.$density;
                f5 = LazyAnimateScrollKt.TargetDistance;
                mo212toPx0680j_4 = density.mo212toPx0680j_4(f5);
                Density density2 = this.$density;
                f6 = LazyAnimateScrollKt.BoundDistance;
                mo212toPx0680j_42 = density2.mo212toPx0680j_4(f6);
                Density density3 = this.$density;
                f7 = LazyAnimateScrollKt.MinimumDistance;
                mo212toPx0680j_43 = density3.mo212toPx0680j_4(f7);
                ref$BooleanRef = new Ref$BooleanRef();
                ref$BooleanRef.element = true;
                ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = AnimationStateKt.AnimationState$default(0.0f, 0.0f, 0L, 0L, false, 30, null);
            } catch (ItemFoundInScroll e5) {
                e = e5;
                obj2 = coroutine_suspended;
            }
            if (!LazyAnimateScrollKt.isItemVisible(this.$this_animateScrollToItem, this.$index)) {
                int i8 = this.$index > this.$this_animateScrollToItem.getFirstVisibleItemIndex() ? 1 : 0;
                Ref$IntRef ref$IntRef2 = new Ref$IntRef();
                ref$IntRef2.element = 1;
                f8 = mo212toPx0680j_42;
                f9 = mo212toPx0680j_43;
                scrollScope2 = scrollScope4;
                f10 = mo212toPx0680j_4;
                i5 = i8;
                ref$IntRef = ref$IntRef2;
                if (ref$BooleanRef.element) {
                }
                return Unit.INSTANCE;
            }
            obj2 = coroutine_suspended;
            try {
                throw new ItemFoundInScroll(MathKt.roundToInt(this.$this_animateScrollToItem.calculateDistanceTo(this.$index)), (AnimationState) ref$ObjectRef.element);
            } catch (ItemFoundInScroll e6) {
                e = e6;
                itemFoundInScroll = e;
                scrollScope = scrollScope4;
                copy$default = AnimationStateKt.copy$default((AnimationState) itemFoundInScroll.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                final float itemOffset = itemFoundInScroll.getItemOffset() + this.$scrollOffset;
                final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
                boxFloat = Boxing.boxFloat(itemOffset);
                if (((Number) copy$default.getVelocity()).floatValue() == 0.0f) {
                }
                function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                        invoke2(animationScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                        float f13 = itemOffset;
                        float f14 = 0.0f;
                        if (f13 > 0.0f) {
                            f14 = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset);
                        } else if (f13 < 0.0f) {
                            f14 = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset);
                        }
                        float f15 = f14 - ref$FloatRef.element;
                        if (f15 != scrollScope.scrollBy(f15) || f14 != animationScope.getValue().floatValue()) {
                            animationScope.cancelAnimation();
                        }
                        ref$FloatRef.element += f15;
                    }
                };
                this.L$0 = scrollScope;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 2;
                if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, z5 ^ z6, function1, this, 2, null) == obj2) {
                }
                this.$this_animateScrollToItem.snapToItem(scrollScope, this.$index, this.$scrollOffset);
                return Unit.INSTANCE;
            }
        }
        if (i6 != 1) {
            if (i6 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            scrollScope = (ScrollScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.$this_animateScrollToItem.snapToItem(scrollScope, this.$index, this.$scrollOffset);
            return Unit.INSTANCE;
        }
        i5 = this.I$0;
        float f13 = this.F$2;
        float f14 = this.F$1;
        float f15 = this.F$0;
        Ref$IntRef ref$IntRef3 = (Ref$IntRef) this.L$3;
        ref$ObjectRef = (Ref$ObjectRef) this.L$2;
        Ref$BooleanRef ref$BooleanRef2 = (Ref$BooleanRef) this.L$1;
        ScrollScope scrollScope5 = (ScrollScope) this.L$0;
        try {
            ResultKt.throwOnFailure(obj);
            f9 = f13;
            f8 = f14;
            obj2 = coroutine_suspended;
            f10 = f15;
            scrollScope2 = scrollScope5;
            ref$IntRef = ref$IntRef3;
            ref$BooleanRef = ref$BooleanRef2;
            try {
                try {
                    ref$IntRef.element++;
                    if (ref$BooleanRef.element && this.$this_animateScrollToItem.getItemCount() > 0) {
                        try {
                            try {
                                float calculateDistanceTo = this.$this_animateScrollToItem.calculateDistanceTo(this.$index) + this.$scrollOffset;
                                if (Math.abs(calculateDistanceTo) < f10) {
                                    if (i5 != 0) {
                                        f11 = f10;
                                        ref$ObjectRef.element = AnimationStateKt.copy$default((AnimationState) ref$ObjectRef.element, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                                        final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
                                        animationState = (AnimationState) ref$ObjectRef.element;
                                        boxFloat2 = Boxing.boxFloat(f11);
                                        boolean z9 = ((Number) ((AnimationState) ref$ObjectRef.element).getVelocity()).floatValue() != f12 ? false : z8;
                                        final LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope = this.$this_animateScrollToItem;
                                        final int i9 = this.$index;
                                        final boolean z10 = i5 == 0 ? z8 : false;
                                        final int i10 = this.$numOfItemsForTeleport;
                                        obj3 = coroutine_suspended;
                                        final int i11 = this.$scrollOffset;
                                        final ScrollScope scrollScope6 = scrollScope2;
                                        final Ref$BooleanRef ref$BooleanRef3 = ref$BooleanRef;
                                        final float f16 = f8;
                                        final Ref$IntRef ref$IntRef4 = ref$IntRef;
                                        final Ref$ObjectRef ref$ObjectRef2 = ref$ObjectRef;
                                        function12 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                                invoke2(animationScope);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                                float coerceAtLeast;
                                                if (!LazyAnimateScrollKt.isItemVisible(LazyLayoutAnimateScrollScope.this, i9)) {
                                                    if (f11 > 0.0f) {
                                                        coerceAtLeast = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), f11);
                                                    } else {
                                                        coerceAtLeast = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), f11);
                                                    }
                                                    float f17 = coerceAtLeast - ref$FloatRef2.element;
                                                    float scrollBy = scrollScope6.scrollBy(f17);
                                                    if (!LazyAnimateScrollKt.isItemVisible(LazyLayoutAnimateScrollScope.this, i9) && !LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend$isOvershot(z10, LazyLayoutAnimateScrollScope.this, i9, i11)) {
                                                        if (f17 == scrollBy) {
                                                            ref$FloatRef2.element += f17;
                                                            if (z10) {
                                                                if (animationScope.getValue().floatValue() > f16) {
                                                                    animationScope.cancelAnimation();
                                                                }
                                                            } else if (animationScope.getValue().floatValue() < (-f16)) {
                                                                animationScope.cancelAnimation();
                                                            }
                                                            if (z10) {
                                                                if (ref$IntRef4.element >= 2) {
                                                                    int lastVisibleItemIndex = i9 - LazyLayoutAnimateScrollScope.this.getLastVisibleItemIndex();
                                                                    int i12 = i10;
                                                                    if (lastVisibleItemIndex > i12) {
                                                                        LazyLayoutAnimateScrollScope.this.snapToItem(scrollScope6, i9 - i12, 0);
                                                                    }
                                                                }
                                                            } else if (ref$IntRef4.element >= 2) {
                                                                int firstVisibleItemIndex = LazyLayoutAnimateScrollScope.this.getFirstVisibleItemIndex();
                                                                int i13 = i9;
                                                                int i14 = firstVisibleItemIndex - i13;
                                                                int i15 = i10;
                                                                if (i14 > i15) {
                                                                    LazyLayoutAnimateScrollScope.this.snapToItem(scrollScope6, i13 + i15, 0);
                                                                }
                                                            }
                                                        } else {
                                                            animationScope.cancelAnimation();
                                                            ref$BooleanRef3.element = false;
                                                            return;
                                                        }
                                                    }
                                                }
                                                if (LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend$isOvershot(z10, LazyLayoutAnimateScrollScope.this, i9, i11)) {
                                                    LazyLayoutAnimateScrollScope.this.snapToItem(scrollScope6, i9, i11);
                                                    ref$BooleanRef3.element = false;
                                                    animationScope.cancelAnimation();
                                                    return;
                                                }
                                                if (LazyAnimateScrollKt.isItemVisible(LazyLayoutAnimateScrollScope.this, i9)) {
                                                    throw new ItemFoundInScroll(MathKt.roundToInt(LazyLayoutAnimateScrollScope.this.calculateDistanceTo(i9)), ref$ObjectRef2.element);
                                                }
                                            }
                                        };
                                        this.L$0 = scrollScope2;
                                        this.L$1 = ref$BooleanRef;
                                        this.L$2 = ref$ObjectRef;
                                        this.L$3 = ref$IntRef;
                                        this.F$0 = f10;
                                        this.F$1 = f8;
                                        this.F$2 = f9;
                                        this.I$0 = i5;
                                        this.label = 1;
                                        scrollScope3 = scrollScope2;
                                        Ref$BooleanRef ref$BooleanRef4 = ref$BooleanRef;
                                        z7 = z9;
                                        Ref$ObjectRef ref$ObjectRef3 = ref$ObjectRef;
                                        Ref$IntRef ref$IntRef5 = ref$IntRef;
                                        float f17 = f10;
                                        float f18 = f8;
                                        obj2 = obj3;
                                        if (SuspendAnimationKt.animateTo$default(animationState, boxFloat2, null, z7, function12, this, 2, null) != obj2) {
                                            return obj2;
                                        }
                                        ref$BooleanRef = ref$BooleanRef4;
                                        f8 = f18;
                                        ref$ObjectRef = ref$ObjectRef3;
                                        scrollScope2 = scrollScope3;
                                        ref$IntRef = ref$IntRef5;
                                        f10 = f17;
                                        ref$IntRef.element++;
                                        coroutine_suspended = obj2;
                                        f12 = 0.0f;
                                        z8 = true;
                                        if (ref$BooleanRef.element) {
                                            float calculateDistanceTo2 = this.$this_animateScrollToItem.calculateDistanceTo(this.$index) + this.$scrollOffset;
                                            if (Math.abs(calculateDistanceTo2) < f10) {
                                                try {
                                                    max = Math.max(Math.abs(calculateDistanceTo2), f9);
                                                    if (i5 == 0) {
                                                        max = -max;
                                                    }
                                                } catch (ItemFoundInScroll e7) {
                                                    itemFoundInScroll = e7;
                                                    scrollScope = scrollScope2;
                                                    obj2 = coroutine_suspended;
                                                    copy$default = AnimationStateKt.copy$default((AnimationState) itemFoundInScroll.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                                                    final float itemOffset2 = itemFoundInScroll.getItemOffset() + this.$scrollOffset;
                                                    final Ref$FloatRef ref$FloatRef3 = new Ref$FloatRef();
                                                    boxFloat = Boxing.boxFloat(itemOffset2);
                                                    if (((Number) copy$default.getVelocity()).floatValue() == 0.0f) {
                                                        z5 = true;
                                                        z6 = true;
                                                    } else {
                                                        z5 = true;
                                                        z6 = false;
                                                    }
                                                    function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.5
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                                            invoke2(animationScope);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                                            float f132 = itemOffset2;
                                                            float f142 = 0.0f;
                                                            if (f132 > 0.0f) {
                                                                f142 = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset2);
                                                            } else if (f132 < 0.0f) {
                                                                f142 = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset2);
                                                            }
                                                            float f152 = f142 - ref$FloatRef3.element;
                                                            if (f152 != scrollScope.scrollBy(f152) || f142 != animationScope.getValue().floatValue()) {
                                                                animationScope.cancelAnimation();
                                                            }
                                                            ref$FloatRef3.element += f152;
                                                        }
                                                    };
                                                    this.L$0 = scrollScope;
                                                    this.L$1 = null;
                                                    this.L$2 = null;
                                                    this.L$3 = null;
                                                    this.label = 2;
                                                    if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, z5 ^ z6, function1, this, 2, null) == obj2) {
                                                        return obj2;
                                                    }
                                                    this.$this_animateScrollToItem.snapToItem(scrollScope, this.$index, this.$scrollOffset);
                                                    return Unit.INSTANCE;
                                                }
                                            }
                                        }
                                    } else {
                                        max = -f10;
                                    }
                                }
                                f11 = max;
                                ref$ObjectRef.element = AnimationStateKt.copy$default((AnimationState) ref$ObjectRef.element, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                                final Ref$FloatRef ref$FloatRef22 = new Ref$FloatRef();
                                animationState = (AnimationState) ref$ObjectRef.element;
                                boxFloat2 = Boxing.boxFloat(f11);
                                if (((Number) ((AnimationState) ref$ObjectRef.element).getVelocity()).floatValue() != f12) {
                                }
                                final LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope2 = this.$this_animateScrollToItem;
                                final int i92 = this.$index;
                                if (i5 == 0) {
                                }
                                final int i102 = this.$numOfItemsForTeleport;
                                final int i112 = this.$scrollOffset;
                                final ScrollScope scrollScope62 = scrollScope2;
                                final Ref$BooleanRef ref$BooleanRef32 = ref$BooleanRef;
                                final float f162 = f8;
                                final Ref$IntRef ref$IntRef42 = ref$IntRef;
                                final Ref$ObjectRef<AnimationState<Float, AnimationVector1D>> ref$ObjectRef22 = ref$ObjectRef;
                                function12 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                        invoke2(animationScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                        float coerceAtLeast;
                                        if (!LazyAnimateScrollKt.isItemVisible(LazyLayoutAnimateScrollScope.this, i92)) {
                                            if (f11 > 0.0f) {
                                                coerceAtLeast = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), f11);
                                            } else {
                                                coerceAtLeast = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), f11);
                                            }
                                            float f172 = coerceAtLeast - ref$FloatRef22.element;
                                            float scrollBy = scrollScope62.scrollBy(f172);
                                            if (!LazyAnimateScrollKt.isItemVisible(LazyLayoutAnimateScrollScope.this, i92) && !LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend$isOvershot(z10, LazyLayoutAnimateScrollScope.this, i92, i112)) {
                                                if (f172 == scrollBy) {
                                                    ref$FloatRef22.element += f172;
                                                    if (z10) {
                                                        if (animationScope.getValue().floatValue() > f162) {
                                                            animationScope.cancelAnimation();
                                                        }
                                                    } else if (animationScope.getValue().floatValue() < (-f162)) {
                                                        animationScope.cancelAnimation();
                                                    }
                                                    if (z10) {
                                                        if (ref$IntRef42.element >= 2) {
                                                            int lastVisibleItemIndex = i92 - LazyLayoutAnimateScrollScope.this.getLastVisibleItemIndex();
                                                            int i12 = i102;
                                                            if (lastVisibleItemIndex > i12) {
                                                                LazyLayoutAnimateScrollScope.this.snapToItem(scrollScope62, i92 - i12, 0);
                                                            }
                                                        }
                                                    } else if (ref$IntRef42.element >= 2) {
                                                        int firstVisibleItemIndex = LazyLayoutAnimateScrollScope.this.getFirstVisibleItemIndex();
                                                        int i13 = i92;
                                                        int i14 = firstVisibleItemIndex - i13;
                                                        int i15 = i102;
                                                        if (i14 > i15) {
                                                            LazyLayoutAnimateScrollScope.this.snapToItem(scrollScope62, i13 + i15, 0);
                                                        }
                                                    }
                                                } else {
                                                    animationScope.cancelAnimation();
                                                    ref$BooleanRef32.element = false;
                                                    return;
                                                }
                                            }
                                        }
                                        if (LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend$isOvershot(z10, LazyLayoutAnimateScrollScope.this, i92, i112)) {
                                            LazyLayoutAnimateScrollScope.this.snapToItem(scrollScope62, i92, i112);
                                            ref$BooleanRef32.element = false;
                                            animationScope.cancelAnimation();
                                            return;
                                        }
                                        if (LazyAnimateScrollKt.isItemVisible(LazyLayoutAnimateScrollScope.this, i92)) {
                                            throw new ItemFoundInScroll(MathKt.roundToInt(LazyLayoutAnimateScrollScope.this.calculateDistanceTo(i92)), ref$ObjectRef22.element);
                                        }
                                    }
                                };
                                this.L$0 = scrollScope2;
                                this.L$1 = ref$BooleanRef;
                                this.L$2 = ref$ObjectRef;
                                this.L$3 = ref$IntRef;
                                this.F$0 = f10;
                                this.F$1 = f8;
                                this.F$2 = f9;
                                this.I$0 = i5;
                                this.label = 1;
                                obj2 = obj3;
                                if (SuspendAnimationKt.animateTo$default(animationState, boxFloat2, null, z7, function12, this, 2, null) != obj2) {
                                }
                            } catch (ItemFoundInScroll e8) {
                                e = e8;
                                scrollScope3 = scrollScope2;
                            }
                            obj3 = coroutine_suspended;
                        } catch (ItemFoundInScroll e9) {
                            e = e9;
                            obj2 = obj3;
                            itemFoundInScroll = e;
                            scrollScope = scrollScope3;
                            copy$default = AnimationStateKt.copy$default((AnimationState) itemFoundInScroll.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                            final float itemOffset22 = itemFoundInScroll.getItemOffset() + this.$scrollOffset;
                            final Ref$FloatRef ref$FloatRef32 = new Ref$FloatRef();
                            boxFloat = Boxing.boxFloat(itemOffset22);
                            if (((Number) copy$default.getVelocity()).floatValue() == 0.0f) {
                            }
                            function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    invoke2(animationScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    float f132 = itemOffset22;
                                    float f142 = 0.0f;
                                    if (f132 > 0.0f) {
                                        f142 = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset22);
                                    } else if (f132 < 0.0f) {
                                        f142 = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset22);
                                    }
                                    float f152 = f142 - ref$FloatRef32.element;
                                    if (f152 != scrollScope.scrollBy(f152) || f142 != animationScope.getValue().floatValue()) {
                                        animationScope.cancelAnimation();
                                    }
                                    ref$FloatRef32.element += f152;
                                }
                            };
                            this.L$0 = scrollScope;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 2;
                            if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, z5 ^ z6, function1, this, 2, null) == obj2) {
                            }
                            this.$this_animateScrollToItem.snapToItem(scrollScope, this.$index, this.$scrollOffset);
                            return Unit.INSTANCE;
                        }
                        scrollScope3 = scrollScope2;
                        Ref$BooleanRef ref$BooleanRef42 = ref$BooleanRef;
                        z7 = z9;
                        Ref$ObjectRef ref$ObjectRef32 = ref$ObjectRef;
                        Ref$IntRef ref$IntRef52 = ref$IntRef;
                        float f172 = f10;
                        float f182 = f8;
                    }
                } catch (ItemFoundInScroll e10) {
                    itemFoundInScroll = e10;
                    scrollScope = scrollScope2;
                    copy$default = AnimationStateKt.copy$default((AnimationState) itemFoundInScroll.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                    final float itemOffset222 = itemFoundInScroll.getItemOffset() + this.$scrollOffset;
                    final Ref$FloatRef ref$FloatRef322 = new Ref$FloatRef();
                    boxFloat = Boxing.boxFloat(itemOffset222);
                    if (((Number) copy$default.getVelocity()).floatValue() == 0.0f) {
                    }
                    function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            invoke2(animationScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                            float f132 = itemOffset222;
                            float f142 = 0.0f;
                            if (f132 > 0.0f) {
                                f142 = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset222);
                            } else if (f132 < 0.0f) {
                                f142 = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset222);
                            }
                            float f152 = f142 - ref$FloatRef322.element;
                            if (f152 != scrollScope.scrollBy(f152) || f142 != animationScope.getValue().floatValue()) {
                                animationScope.cancelAnimation();
                            }
                            ref$FloatRef322.element += f152;
                        }
                    };
                    this.L$0 = scrollScope;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 2;
                    if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, z5 ^ z6, function1, this, 2, null) == obj2) {
                    }
                    this.$this_animateScrollToItem.snapToItem(scrollScope, this.$index, this.$scrollOffset);
                    return Unit.INSTANCE;
                }
            } catch (ItemFoundInScroll e11) {
                e = e11;
                scrollScope3 = scrollScope2;
                obj2 = coroutine_suspended;
            }
            coroutine_suspended = obj2;
            f12 = 0.0f;
            z8 = true;
        } catch (ItemFoundInScroll e12) {
            itemFoundInScroll = e12;
            scrollScope = scrollScope5;
            obj2 = coroutine_suspended;
            copy$default = AnimationStateKt.copy$default((AnimationState) itemFoundInScroll.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
            final float itemOffset2222 = itemFoundInScroll.getItemOffset() + this.$scrollOffset;
            final Ref$FloatRef ref$FloatRef3222 = new Ref$FloatRef();
            boxFloat = Boxing.boxFloat(itemOffset2222);
            if (((Number) copy$default.getVelocity()).floatValue() == 0.0f) {
            }
            function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                    invoke2(animationScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                    float f132 = itemOffset2222;
                    float f142 = 0.0f;
                    if (f132 > 0.0f) {
                        f142 = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset2222);
                    } else if (f132 < 0.0f) {
                        f142 = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset2222);
                    }
                    float f152 = f142 - ref$FloatRef3222.element;
                    if (f152 != scrollScope.scrollBy(f152) || f142 != animationScope.getValue().floatValue()) {
                        animationScope.cancelAnimation();
                    }
                    ref$FloatRef3222.element += f152;
                }
            };
            this.L$0 = scrollScope;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 2;
            if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, z5 ^ z6, function1, this, 2, null) == obj2) {
            }
            this.$this_animateScrollToItem.snapToItem(scrollScope, this.$index, this.$scrollOffset);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
