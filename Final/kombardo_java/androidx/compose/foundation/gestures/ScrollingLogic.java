package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001M\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u0011*\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0017\u001a\u00020\u0011*\u00020\u0011ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u001a\u001a\u00020\u0010*\u00020\u0011ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u00020\u0010*\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u001b\u001a\u00020\u0011*\u00020\u0011ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0016J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0016J\u001b\u0010&\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0086@ø\u0001\u0001¢\u0006\u0004\b$\u0010%J\u001b\u0010)\u001a\u00020!2\u0006\u0010'\u001a\u00020!H\u0086@ø\u0001\u0001¢\u0006\u0004\b(\u0010%J\r\u0010*\u001a\u00020\n¢\u0006\u0004\b*\u0010+J>\u0010\u001e\u001a\u00020#2\b\b\u0002\u0010-\u001a\u00020,2\"\u00101\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u00020#00\u0012\u0006\u0012\u0004\u0018\u00010\u00010.H\u0086@¢\u0006\u0004\b\u001e\u00102J?\u00103\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\n¢\u0006\u0004\b5\u0010+J\u0016\u0010\u001a\u001a\u00020\u0010*\u00020!H\u0002ø\u0001\u0001¢\u0006\u0004\b6\u0010\u0019J\u0016\u00108\u001a\u00020!*\u00020!H\u0002ø\u0001\u0001¢\u0006\u0004\b7\u0010\u0016J\u001e\u00103\u001a\u00020!*\u00020!2\u0006\u00109\u001a\u00020\u0010H\u0002ø\u0001\u0001¢\u0006\u0004\b:\u0010;J&\u0010B\u001a\u00020\u0011*\u00020<2\u0006\u0010=\u001a\u00020\u00112\u0006\u0010?\u001a\u00020>H\u0002ø\u0001\u0001¢\u0006\u0004\b@\u0010AR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010CR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010DR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010ER\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010FR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010GR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010HR\u001c\u0010I\u001a\u00020>8\u0002@\u0002X\u0082\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR \u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010+\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006U"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", BuildConfig.FLAVOR, "Landroidx/compose/foundation/gestures/ScrollableState;", "scrollableState", "Landroidx/compose/foundation/OverscrollEffect;", "overscrollEffect", "Landroidx/compose/foundation/gestures/FlingBehavior;", "flingBehavior", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", BuildConfig.FLAVOR, "reverseDirection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "nestedScrollDispatcher", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", BuildConfig.FLAVOR, "Landroidx/compose/ui/geometry/Offset;", "toOffset-tuRUvjQ", "(F)J", "toOffset", "singleAxisOffset-MK-Hz9U", "(J)J", "singleAxisOffset", "toFloat-k-4lQ0M", "(J)F", "toFloat", "reverseIfNeeded", "(F)F", "reverseIfNeeded-MK-Hz9U", "scroll", "performRawScroll-MK-Hz9U", "performRawScroll", "Landroidx/compose/ui/unit/Velocity;", "initialVelocity", BuildConfig.FLAVOR, "onDragStopped-sF-c-tU", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "available", "doFlingAnimation-QWom1Mo", "doFlingAnimation", "shouldScrollImmediately", "()Z", "Landroidx/compose/foundation/MutatePriority;", "scrollPriority", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/coroutines/Continuation;", "block", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/OverscrollEffect;ZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)Z", "isVertical", "toFloat-TH1AsA0", "singleAxisVelocity-AH228Gc", "singleAxisVelocity", "newValue", "update-QWom1Mo", "(JF)J", "Landroidx/compose/foundation/gestures/ScrollScope;", "delta", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "source", "performScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "performScroll", "Landroidx/compose/foundation/gestures/ScrollableState;", "Landroidx/compose/foundation/OverscrollEffect;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "Landroidx/compose/foundation/gestures/Orientation;", "Z", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "latestScrollSource", "I", "outerStateScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "androidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1", "nestedScrollScope", "Landroidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1;", "Lkotlin/Function1;", "performScrollForOverscroll", "Lkotlin/jvm/functions/Function1;", "getShouldDispatchOverscroll", "shouldDispatchOverscroll", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollingLogic {
    private FlingBehavior flingBehavior;
    private NestedScrollDispatcher nestedScrollDispatcher;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    private boolean reverseDirection;
    private ScrollableState scrollableState;
    private int latestScrollSource = NestedScrollSource.INSTANCE.m1842getUserInputWNlRxjI();
    private ScrollScope outerStateScope = ScrollableKt.access$getNoOpScrollScope$p();
    private final ScrollingLogic$nestedScrollScope$1 nestedScrollScope = new NestedScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1
        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        /* renamed from: scrollBy-OzD1aCk */
        public long mo204scrollByOzD1aCk(long offset, int source) {
            ScrollScope scrollScope;
            long m225performScroll3eAAhYA;
            scrollScope = ScrollingLogic.this.outerStateScope;
            m225performScroll3eAAhYA = ScrollingLogic.this.m225performScroll3eAAhYA(scrollScope, offset, source);
            return m225performScroll3eAAhYA;
        }

        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        /* renamed from: scrollByWithOverscroll-OzD1aCk */
        public long mo205scrollByWithOverscrollOzD1aCk(long offset, int source) {
            OverscrollEffect overscrollEffect;
            ScrollScope scrollScope;
            long m225performScroll3eAAhYA;
            boolean shouldDispatchOverscroll;
            int i5;
            Function1<? super Offset, Offset> function1;
            ScrollingLogic.this.latestScrollSource = source;
            overscrollEffect = ScrollingLogic.this.overscrollEffect;
            if (overscrollEffect != null) {
                shouldDispatchOverscroll = ScrollingLogic.this.getShouldDispatchOverscroll();
                if (shouldDispatchOverscroll) {
                    i5 = ScrollingLogic.this.latestScrollSource;
                    function1 = ScrollingLogic.this.performScrollForOverscroll;
                    return overscrollEffect.mo100applyToScrollRhakbz0(offset, i5, function1);
                }
            }
            scrollScope = ScrollingLogic.this.outerStateScope;
            m225performScroll3eAAhYA = ScrollingLogic.this.m225performScroll3eAAhYA(scrollScope, offset, source);
            return m225performScroll3eAAhYA;
        }
    };
    private final Function1<Offset, Offset> performScrollForOverscroll = new Function1<Offset, Offset>() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$performScrollForOverscroll$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Offset invoke(Offset offset) {
            return Offset.m1328boximpl(m237invokeMKHz9U(offset.getPackedValue()));
        }

        /* renamed from: invoke-MK-Hz9U, reason: not valid java name */
        public final long m237invokeMKHz9U(long j5) {
            ScrollScope scrollScope;
            int i5;
            long m225performScroll3eAAhYA;
            scrollScope = ScrollingLogic.this.outerStateScope;
            ScrollingLogic scrollingLogic = ScrollingLogic.this;
            i5 = scrollingLogic.latestScrollSource;
            m225performScroll3eAAhYA = scrollingLogic.m225performScroll3eAAhYA(scrollScope, j5, i5);
            return m225performScroll3eAAhYA;
        }
    };

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1] */
    public ScrollingLogic(ScrollableState scrollableState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, Orientation orientation, boolean z5, NestedScrollDispatcher nestedScrollDispatcher) {
        this.scrollableState = scrollableState;
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        this.orientation = orientation;
        this.reverseDirection = z5;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performScroll-3eAAhYA, reason: not valid java name */
    public final long m225performScroll3eAAhYA(ScrollScope scrollScope, long j5, int i5) {
        long m1838dispatchPreScrollOzD1aCk = this.nestedScrollDispatcher.m1838dispatchPreScrollOzD1aCk(j5, i5);
        long m1341minusMKHz9U = Offset.m1341minusMKHz9U(j5, m1838dispatchPreScrollOzD1aCk);
        long m232reverseIfNeededMKHz9U = m232reverseIfNeededMKHz9U(m235toOffsettuRUvjQ(scrollScope.scrollBy(m234toFloatk4lQ0M(m232reverseIfNeededMKHz9U(m233singleAxisOffsetMKHz9U(m1341minusMKHz9U))))));
        return Offset.m1342plusMKHz9U(Offset.m1342plusMKHz9U(m1838dispatchPreScrollOzD1aCk, m232reverseIfNeededMKHz9U), this.nestedScrollDispatcher.m1836dispatchPostScrollDzOQY0M(m232reverseIfNeededMKHz9U, Offset.m1341minusMKHz9U(m1341minusMKHz9U, m232reverseIfNeededMKHz9U), i5));
    }

    /* renamed from: singleAxisVelocity-AH228Gc, reason: not valid java name */
    private final long m226singleAxisVelocityAH228Gc(long j5) {
        return this.orientation == Orientation.Horizontal ? Velocity.m2698copyOhffZ5M$default(j5, 0.0f, 0.0f, 1, null) : Velocity.m2698copyOhffZ5M$default(j5, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m227toFloatTH1AsA0(long j5) {
        return this.orientation == Orientation.Horizontal ? Velocity.m2701getXimpl(j5) : Velocity.m2702getYimpl(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m228updateQWom1Mo(long j5, float f5) {
        return this.orientation == Orientation.Horizontal ? Velocity.m2698copyOhffZ5M$default(j5, f5, 0.0f, 2, null) : Velocity.m2698copyOhffZ5M$default(j5, 0.0f, f5, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m229doFlingAnimationQWom1Mo(long j5, Continuation<? super Velocity> continuation) {
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$1;
        int i5;
        Ref$LongRef ref$LongRef;
        if (continuation instanceof ScrollingLogic$doFlingAnimation$1) {
            scrollingLogic$doFlingAnimation$1 = (ScrollingLogic$doFlingAnimation$1) continuation;
            int i6 = scrollingLogic$doFlingAnimation$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                scrollingLogic$doFlingAnimation$1.label = i6 - Integer.MIN_VALUE;
                Object obj = scrollingLogic$doFlingAnimation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = scrollingLogic$doFlingAnimation$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref$LongRef ref$LongRef2 = new Ref$LongRef();
                    ref$LongRef2.element = j5;
                    MutatePriority mutatePriority = MutatePriority.Default;
                    Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> scrollingLogic$doFlingAnimation$2 = new ScrollingLogic$doFlingAnimation$2(this, ref$LongRef2, j5, null);
                    scrollingLogic$doFlingAnimation$1.L$0 = ref$LongRef2;
                    scrollingLogic$doFlingAnimation$1.label = 1;
                    if (scroll(mutatePriority, scrollingLogic$doFlingAnimation$2, scrollingLogic$doFlingAnimation$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ref$LongRef = ref$LongRef2;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ref$LongRef = (Ref$LongRef) scrollingLogic$doFlingAnimation$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Velocity.m2695boximpl(ref$LongRef.element);
            }
        }
        scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuation);
        Object obj2 = scrollingLogic$doFlingAnimation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = scrollingLogic$doFlingAnimation$1.label;
        if (i5 != 0) {
        }
        return Velocity.m2695boximpl(ref$LongRef.element);
    }

    public final boolean isVertical() {
        return this.orientation == Orientation.Vertical;
    }

    /* renamed from: onDragStopped-sF-c-tU, reason: not valid java name */
    public final Object m230onDragStoppedsFctU(long j5, Continuation<? super Unit> continuation) {
        long m226singleAxisVelocityAH228Gc = m226singleAxisVelocityAH228Gc(j5);
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this, null);
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        if (overscrollEffect == null || !getShouldDispatchOverscroll()) {
            Object invoke = scrollingLogic$onDragStopped$performFling$1.invoke(Velocity.m2695boximpl(m226singleAxisVelocityAH228Gc), continuation);
            return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
        }
        Object mo99applyToFlingBMRW4eQ = overscrollEffect.mo99applyToFlingBMRW4eQ(m226singleAxisVelocityAH228Gc, scrollingLogic$onDragStopped$performFling$1, continuation);
        return mo99applyToFlingBMRW4eQ == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo99applyToFlingBMRW4eQ : Unit.INSTANCE;
    }

    /* renamed from: performRawScroll-MK-Hz9U, reason: not valid java name */
    public final long m231performRawScrollMKHz9U(long scroll) {
        return this.scrollableState.isScrollInProgress() ? Offset.INSTANCE.m1349getZeroF1C5BW0() : m235toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m234toFloatk4lQ0M(scroll)))));
    }

    public final float reverseIfNeeded(float f5) {
        return this.reverseDirection ? f5 * (-1) : f5;
    }

    /* renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m232reverseIfNeededMKHz9U(long j5) {
        return this.reverseDirection ? Offset.m1343timestuRUvjQ(j5, -1.0f) : j5;
    }

    public final Object scroll(MutatePriority mutatePriority, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll = this.scrollableState.scroll(mutatePriority, new ScrollingLogic$scroll$2(this, function2, null), continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    public final boolean shouldScrollImmediately() {
        if (!this.scrollableState.isScrollInProgress()) {
            OverscrollEffect overscrollEffect = this.overscrollEffect;
            if (!(overscrollEffect != null ? overscrollEffect.isInProgress() : false)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: singleAxisOffset-MK-Hz9U, reason: not valid java name */
    public final long m233singleAxisOffsetMKHz9U(long j5) {
        return this.orientation == Orientation.Horizontal ? Offset.m1331copydBAh8RU$default(j5, 0.0f, 0.0f, 1, null) : Offset.m1331copydBAh8RU$default(j5, 0.0f, 0.0f, 2, null);
    }

    /* renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m234toFloatk4lQ0M(long j5) {
        return this.orientation == Orientation.Horizontal ? Offset.m1337getXimpl(j5) : Offset.m1338getYimpl(j5);
    }

    /* renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m235toOffsettuRUvjQ(float f5) {
        return f5 == 0.0f ? Offset.INSTANCE.m1349getZeroF1C5BW0() : this.orientation == Orientation.Horizontal ? OffsetKt.Offset(f5, 0.0f) : OffsetKt.Offset(0.0f, f5);
    }

    public final boolean update(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean reverseDirection, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        boolean z5;
        boolean z6 = true;
        if (Intrinsics.areEqual(this.scrollableState, scrollableState)) {
            z5 = false;
        } else {
            this.scrollableState = scrollableState;
            z5 = true;
        }
        this.overscrollEffect = overscrollEffect;
        if (this.orientation != orientation) {
            this.orientation = orientation;
            z5 = true;
        }
        if (this.reverseDirection != reverseDirection) {
            this.reverseDirection = reverseDirection;
        } else {
            z6 = z5;
        }
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        return z6;
    }
}
