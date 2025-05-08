package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\r\u001a^\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007\u001aH\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007\u001a\u001f\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020 H\u0082@ø\u0001\u0000¢\u0006\u0004\b#\u0010$\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"CanDragCalculation", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", BuildConfig.FLAVOR, "DefaultScrollMotionDurationScale", "Landroidx/compose/ui/MotionDurationScale;", "getDefaultScrollMotionDurationScale", "()Landroidx/compose/ui/MotionDurationScale;", "DefaultScrollMotionDurationScaleFactor", BuildConfig.FLAVOR, "NoOpScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "UnityDensity", "androidx/compose/foundation/gestures/ScrollableKt$UnityDensity$1", "Landroidx/compose/foundation/gestures/ScrollableKt$UnityDensity$1;", "scrollable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "enabled", "reverseDirection", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "semanticsScrollBy", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "offset", "semanticsScrollBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/ScrollingLogic;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ScrollableKt {
    private static final float DefaultScrollMotionDurationScaleFactor = 1.0f;
    private static final Function1<PointerInputChange, Boolean> CanDragCalculation = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$CanDragCalculation$1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(PointerInputChange pointerInputChange) {
            return Boolean.valueOf(!PointerType.m1904equalsimpl0(pointerInputChange.getType(), PointerType.INSTANCE.m1908getMouseT8wyACA()));
        }
    };
    private static final ScrollScope NoOpScrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollableKt$NoOpScrollScope$1
        @Override // androidx.compose.foundation.gestures.ScrollScope
        public float scrollBy(float pixels) {
            return pixels;
        }
    };
    private static final MotionDurationScale DefaultScrollMotionDurationScale = new MotionDurationScale() { // from class: androidx.compose.foundation.gestures.ScrollableKt$DefaultScrollMotionDurationScale$1
        @Override // kotlin.coroutines.CoroutineContext
        public <R> R fold(R r5, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) MotionDurationScale.DefaultImpls.fold(this, r5, function2);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
            return (E) MotionDurationScale.DefaultImpls.get(this, key);
        }

        @Override // androidx.compose.ui.MotionDurationScale
        public float getScaleFactor() {
            return 1.0f;
        }

        @Override // kotlin.coroutines.CoroutineContext
        public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
            return MotionDurationScale.DefaultImpls.minusKey(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext
        public CoroutineContext plus(CoroutineContext coroutineContext) {
            return MotionDurationScale.DefaultImpls.plus(this, coroutineContext);
        }
    };
    private static final ScrollableKt$UnityDensity$1 UnityDensity = new Density() { // from class: androidx.compose.foundation.gestures.ScrollableKt$UnityDensity$1
        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return 1.0f;
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return 1.0f;
        }
    };

    public static final MotionDurationScale getDefaultScrollMotionDurationScale() {
        return DefaultScrollMotionDurationScale;
    }

    public static final Modifier scrollable(Modifier modifier, ScrollableState scrollableState, Orientation orientation, boolean z5, boolean z6, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource) {
        return scrollable$default(modifier, scrollableState, orientation, null, z5, z6, flingBehavior, mutableInteractionSource, null, 128, null);
    }

    public static /* synthetic */ Modifier scrollable$default(Modifier modifier, ScrollableState scrollableState, Orientation orientation, boolean z5, boolean z6, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z5 = true;
        }
        boolean z7 = z5;
        if ((i5 & 8) != 0) {
            z6 = false;
        }
        return scrollable(modifier, scrollableState, orientation, z7, z6, (i5 & 16) != 0 ? null : flingBehavior, (i5 & 32) != 0 ? null : mutableInteractionSource);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: semanticsScrollBy-d-4ec7I */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m217semanticsScrollByd4ec7I(ScrollingLogic scrollingLogic, long j5, Continuation<? super Offset> continuation) {
        ScrollableKt$semanticsScrollBy$1 scrollableKt$semanticsScrollBy$1;
        int i5;
        Ref$FloatRef ref$FloatRef;
        if (continuation instanceof ScrollableKt$semanticsScrollBy$1) {
            scrollableKt$semanticsScrollBy$1 = (ScrollableKt$semanticsScrollBy$1) continuation;
            int i6 = scrollableKt$semanticsScrollBy$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                scrollableKt$semanticsScrollBy$1.label = i6 - Integer.MIN_VALUE;
                Object obj = scrollableKt$semanticsScrollBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = scrollableKt$semanticsScrollBy$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ref$FloatRef = new Ref$FloatRef();
                    MutatePriority mutatePriority = MutatePriority.Default;
                    ScrollableKt$semanticsScrollBy$2 scrollableKt$semanticsScrollBy$2 = new ScrollableKt$semanticsScrollBy$2(scrollingLogic, j5, ref$FloatRef, null);
                    scrollableKt$semanticsScrollBy$1.L$0 = scrollingLogic;
                    scrollableKt$semanticsScrollBy$1.L$1 = ref$FloatRef;
                    scrollableKt$semanticsScrollBy$1.label = 1;
                    if (scrollingLogic.scroll(mutatePriority, scrollableKt$semanticsScrollBy$2, scrollableKt$semanticsScrollBy$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Ref$FloatRef ref$FloatRef2 = (Ref$FloatRef) scrollableKt$semanticsScrollBy$1.L$1;
                    ScrollingLogic scrollingLogic2 = (ScrollingLogic) scrollableKt$semanticsScrollBy$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    ref$FloatRef = ref$FloatRef2;
                    scrollingLogic = scrollingLogic2;
                }
                return Offset.m1328boximpl(scrollingLogic.m235toOffsettuRUvjQ(ref$FloatRef.element));
            }
        }
        scrollableKt$semanticsScrollBy$1 = new ScrollableKt$semanticsScrollBy$1(continuation);
        Object obj2 = scrollableKt$semanticsScrollBy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = scrollableKt$semanticsScrollBy$1.label;
        if (i5 != 0) {
        }
        return Offset.m1328boximpl(scrollingLogic.m235toOffsettuRUvjQ(ref$FloatRef.element));
    }

    public static final Modifier scrollable(Modifier modifier, ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z5, boolean z6, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        return modifier.then(new ScrollableElement(scrollableState, orientation, overscrollEffect, z5, z6, flingBehavior, mutableInteractionSource, bringIntoViewSpec));
    }

    public static /* synthetic */ Modifier scrollable$default(Modifier modifier, ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z5, boolean z6, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec, int i5, Object obj) {
        return scrollable(modifier, scrollableState, orientation, overscrollEffect, (i5 & 8) != 0 ? true : z5, (i5 & 16) != 0 ? false : z6, (i5 & 32) != 0 ? null : flingBehavior, (i5 & 64) != 0 ? null : mutableInteractionSource, (i5 & 128) != 0 ? null : bringIntoViewSpec);
    }
}
