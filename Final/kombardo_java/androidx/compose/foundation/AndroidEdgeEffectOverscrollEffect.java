package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.support.v4.media.session.a;
import android.widget.EdgeEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016J\u001a\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0016J6\u0010$\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0 H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J?\u0010-\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%2\"\u0010*\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0(\u0012\u0006\u0012\u0004\u0018\u00010)0'H\u0096@ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001a\u00102\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.H\u0000ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0015\u00105\u001a\u00020\u000eH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u000f\u00107\u001a\u00020\u000bH\u0000¢\u0006\u0004\b6\u0010\rR\u001e\u00108\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R \u0010>\u001a\b\u0012\u0004\u0012\u00020\u000b0=8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR(\u0010B\u001a\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bB\u0010C\u0012\u0004\bG\u0010\r\u001a\u0004\bD\u0010\n\"\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010CR\u001c\u0010I\u001a\u00020.8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bI\u0010JR\u001e\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bL\u0010MR\u001a\u0010O\u001a\u00020N8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006T"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "Landroid/content/Context;", "context", "Landroidx/compose/foundation/OverscrollConfiguration;", "overscrollConfig", "<init>", "(Landroid/content/Context;Landroidx/compose/foundation/OverscrollConfiguration;)V", BuildConfig.FLAVOR, "stopOverscrollAnimation", "()Z", BuildConfig.FLAVOR, "animateToRelease", "()V", "Landroidx/compose/ui/geometry/Offset;", "delta", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "releaseOppositeOverscroll", "scroll", BuildConfig.FLAVOR, "pullTop-k-4lQ0M", "(J)F", "pullTop", "pullBottom-k-4lQ0M", "pullBottom", "pullLeft-k-4lQ0M", "pullLeft", "pullRight-k-4lQ0M", "pullRight", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "source", "Lkotlin/Function1;", "performScroll", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "applyToScroll", "Landroidx/compose/ui/unit/Velocity;", "velocity", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "performFling", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyToFling", "Landroidx/compose/ui/geometry/Size;", "size", "updateSize-uvyYCjk$foundation_release", "(J)V", "updateSize", "displacement-F1C5BW0$foundation_release", "()J", "displacement", "invalidateOverscroll$foundation_release", "invalidateOverscroll", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/EdgeEffectWrapper;", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "Landroidx/compose/runtime/MutableState;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "getRedrawSignal$foundation_release", "()Landroidx/compose/runtime/MutableState;", "invalidationEnabled", "Z", "getInvalidationEnabled$foundation_release", "setInvalidationEnabled$foundation_release", "(Z)V", "getInvalidationEnabled$foundation_release$annotations", "scrollCycleInProgress", "containerSize", "J", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "Landroidx/compose/ui/Modifier;", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "isInProgress", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    private long containerSize;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final Modifier effectModifier;
    private boolean invalidationEnabled;
    private PointerId pointerId;
    private Offset pointerPosition;
    private final MutableState<Unit> redrawSignal;
    private boolean scrollCycleInProgress;

    public AndroidEdgeEffectOverscrollEffect(Context context, OverscrollConfiguration overscrollConfiguration) {
        Modifier drawGlowOverscrollModifier;
        EdgeEffectWrapper edgeEffectWrapper = new EdgeEffectWrapper(context, ColorKt.m1508toArgb8_81llA(overscrollConfiguration.getGlowColor()));
        this.edgeEffectWrapper = edgeEffectWrapper;
        Unit unit = Unit.INSTANCE;
        this.redrawSignal = SnapshotStateKt.mutableStateOf(unit, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.INSTANCE.m1384getZeroNHjbRc();
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, unit, new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, null));
        if (Build.VERSION.SDK_INT >= 31) {
            drawGlowOverscrollModifier = new DrawStretchOverscrollModifier(this, edgeEffectWrapper, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    a.a(inspectorInfo);
                    invoke2((InspectorInfo) null);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InspectorInfo inspectorInfo) {
                    throw null;
                }
            } : InspectableValueKt.getNoInspectorInfo());
        } else {
            drawGlowOverscrollModifier = new DrawGlowOverscrollModifier(this, edgeEffectWrapper, overscrollConfiguration, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    a.a(inspectorInfo);
                    invoke2((InspectorInfo) null);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InspectorInfo inspectorInfo) {
                    throw null;
                }
            } : InspectableValueKt.getNoInspectorInfo());
        }
        this.effectModifier = pointerInput.then(drawGlowOverscrollModifier);
    }

    private final void animateToRelease() {
        EdgeEffect edgeEffect;
        boolean z5;
        EdgeEffect edgeEffect2;
        EdgeEffect edgeEffect3;
        EdgeEffect edgeEffect4;
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        edgeEffect = edgeEffectWrapper.topEffect;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z5 = edgeEffect.isFinished();
        } else {
            z5 = false;
        }
        edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z5 = edgeEffect2.isFinished() || z5;
        }
        edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z5 = edgeEffect3.isFinished() || z5;
        }
        edgeEffect4 = edgeEffectWrapper.rightEffect;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z5 = edgeEffect4.isFinished() || z5;
        }
        if (z5) {
            invalidateOverscroll$foundation_release();
        }
    }

    /* renamed from: pullBottom-k-4lQ0M, reason: not valid java name */
    private final float m94pullBottomk4lQ0M(long scroll) {
        float m1337getXimpl = Offset.m1337getXimpl(m101displacementF1C5BW0$foundation_release());
        float m1338getYimpl = Offset.m1338getYimpl(scroll) / Size.m1375getHeightimpl(this.containerSize);
        EdgeEffect orCreateBottomEffect = this.edgeEffectWrapper.getOrCreateBottomEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateBottomEffect) == 0.0f ? (-edgeEffectCompat.onPullDistanceCompat(orCreateBottomEffect, -m1338getYimpl, 1 - m1337getXimpl)) * Size.m1375getHeightimpl(this.containerSize) : Offset.m1338getYimpl(scroll);
    }

    /* renamed from: pullLeft-k-4lQ0M, reason: not valid java name */
    private final float m95pullLeftk4lQ0M(long scroll) {
        float m1338getYimpl = Offset.m1338getYimpl(m101displacementF1C5BW0$foundation_release());
        float m1337getXimpl = Offset.m1337getXimpl(scroll) / Size.m1377getWidthimpl(this.containerSize);
        EdgeEffect orCreateLeftEffect = this.edgeEffectWrapper.getOrCreateLeftEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateLeftEffect) == 0.0f ? edgeEffectCompat.onPullDistanceCompat(orCreateLeftEffect, m1337getXimpl, 1 - m1338getYimpl) * Size.m1377getWidthimpl(this.containerSize) : Offset.m1337getXimpl(scroll);
    }

    /* renamed from: pullRight-k-4lQ0M, reason: not valid java name */
    private final float m96pullRightk4lQ0M(long scroll) {
        float m1338getYimpl = Offset.m1338getYimpl(m101displacementF1C5BW0$foundation_release());
        float m1337getXimpl = Offset.m1337getXimpl(scroll) / Size.m1377getWidthimpl(this.containerSize);
        EdgeEffect orCreateRightEffect = this.edgeEffectWrapper.getOrCreateRightEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateRightEffect) == 0.0f ? (-edgeEffectCompat.onPullDistanceCompat(orCreateRightEffect, -m1337getXimpl, m1338getYimpl)) * Size.m1377getWidthimpl(this.containerSize) : Offset.m1337getXimpl(scroll);
    }

    /* renamed from: pullTop-k-4lQ0M, reason: not valid java name */
    private final float m97pullTopk4lQ0M(long scroll) {
        float m1337getXimpl = Offset.m1337getXimpl(m101displacementF1C5BW0$foundation_release());
        float m1338getYimpl = Offset.m1338getYimpl(scroll) / Size.m1375getHeightimpl(this.containerSize);
        EdgeEffect orCreateTopEffect = this.edgeEffectWrapper.getOrCreateTopEffect();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(orCreateTopEffect) == 0.0f ? edgeEffectCompat.onPullDistanceCompat(orCreateTopEffect, m1338getYimpl, m1337getXimpl) * Size.m1375getHeightimpl(this.containerSize) : Offset.m1338getYimpl(scroll);
    }

    /* renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    private final boolean m98releaseOppositeOverscrollk4lQ0M(long delta) {
        boolean z5;
        boolean z6 = true;
        if (!this.edgeEffectWrapper.isLeftAnimating() || Offset.m1337getXimpl(delta) >= 0.0f) {
            z5 = false;
        } else {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateLeftEffect(), Offset.m1337getXimpl(delta));
            z5 = !this.edgeEffectWrapper.isLeftAnimating();
        }
        if (this.edgeEffectWrapper.isRightAnimating() && Offset.m1337getXimpl(delta) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateRightEffect(), Offset.m1337getXimpl(delta));
            z5 = z5 || !this.edgeEffectWrapper.isRightAnimating();
        }
        if (this.edgeEffectWrapper.isTopAnimating() && Offset.m1338getYimpl(delta) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateTopEffect(), Offset.m1338getYimpl(delta));
            z5 = z5 || !this.edgeEffectWrapper.isTopAnimating();
        }
        if (!this.edgeEffectWrapper.isBottomAnimating() || Offset.m1338getYimpl(delta) <= 0.0f) {
            return z5;
        }
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateBottomEffect(), Offset.m1338getYimpl(delta));
        if (!z5 && this.edgeEffectWrapper.isBottomAnimating()) {
            z6 = false;
        }
        return z6;
    }

    private final boolean stopOverscrollAnimation() {
        boolean z5;
        if (this.edgeEffectWrapper.isLeftStretched()) {
            m95pullLeftk4lQ0M(Offset.INSTANCE.m1349getZeroF1C5BW0());
            z5 = true;
        } else {
            z5 = false;
        }
        if (this.edgeEffectWrapper.isRightStretched()) {
            m96pullRightk4lQ0M(Offset.INSTANCE.m1349getZeroF1C5BW0());
            z5 = true;
        }
        if (this.edgeEffectWrapper.isTopStretched()) {
            m97pullTopk4lQ0M(Offset.INSTANCE.m1349getZeroF1C5BW0());
            z5 = true;
        }
        if (!this.edgeEffectWrapper.isBottomStretched()) {
            return z5;
        }
        m94pullBottomk4lQ0M(Offset.INSTANCE.m1349getZeroF1C5BW0());
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo99applyToFlingBMRW4eQ(long j5, Function2<? super Velocity, ? super Continuation<? super Velocity>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        AndroidEdgeEffectOverscrollEffect$applyToFling$1 androidEdgeEffectOverscrollEffect$applyToFling$1;
        int i5;
        float f5;
        float f6;
        long m2704minusAH228Gc;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect;
        long m2704minusAH228Gc2;
        if (continuation instanceof AndroidEdgeEffectOverscrollEffect$applyToFling$1) {
            androidEdgeEffectOverscrollEffect$applyToFling$1 = (AndroidEdgeEffectOverscrollEffect$applyToFling$1) continuation;
            int i6 = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                androidEdgeEffectOverscrollEffect$applyToFling$1.label = i6 - Integer.MIN_VALUE;
                Object obj = androidEdgeEffectOverscrollEffect$applyToFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
                if (i5 == 0) {
                    if (i5 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    m2704minusAH228Gc = androidEdgeEffectOverscrollEffect$applyToFling$1.J$0;
                    androidEdgeEffectOverscrollEffect = (AndroidEdgeEffectOverscrollEffect) androidEdgeEffectOverscrollEffect$applyToFling$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    m2704minusAH228Gc2 = Velocity.m2704minusAH228Gc(m2704minusAH228Gc, ((Velocity) obj).getPackedValue());
                    androidEdgeEffectOverscrollEffect.scrollCycleInProgress = false;
                    if (Velocity.m2701getXimpl(m2704minusAH228Gc2) <= 0.0f) {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateLeftEffect(), MathKt.roundToInt(Velocity.m2701getXimpl(m2704minusAH228Gc2)));
                    } else if (Velocity.m2701getXimpl(m2704minusAH228Gc2) < 0.0f) {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateRightEffect(), -MathKt.roundToInt(Velocity.m2701getXimpl(m2704minusAH228Gc2)));
                    }
                    if (Velocity.m2702getYimpl(m2704minusAH228Gc2) <= 0.0f) {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateTopEffect(), MathKt.roundToInt(Velocity.m2702getYimpl(m2704minusAH228Gc2)));
                    } else if (Velocity.m2702getYimpl(m2704minusAH228Gc2) < 0.0f) {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.edgeEffectWrapper.getOrCreateBottomEffect(), -MathKt.roundToInt(Velocity.m2702getYimpl(m2704minusAH228Gc2)));
                    }
                    if (!Velocity.m2700equalsimpl0(m2704minusAH228Gc2, Velocity.INSTANCE.m2709getZero9UxMQ8M())) {
                        androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation_release();
                    }
                    androidEdgeEffectOverscrollEffect.animateToRelease();
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                if (Size.m1379isEmptyimpl(this.containerSize)) {
                    Velocity m2695boximpl = Velocity.m2695boximpl(j5);
                    androidEdgeEffectOverscrollEffect$applyToFling$1.label = 1;
                    if (function2.invoke(m2695boximpl, androidEdgeEffectOverscrollEffect$applyToFling$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                if (Velocity.m2701getXimpl(j5) > 0.0f && this.edgeEffectWrapper.isLeftStretched()) {
                    EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateLeftEffect(), MathKt.roundToInt(Velocity.m2701getXimpl(j5)));
                    f5 = Velocity.m2701getXimpl(j5);
                } else if (Velocity.m2701getXimpl(j5) >= 0.0f || !this.edgeEffectWrapper.isRightStretched()) {
                    f5 = 0.0f;
                } else {
                    EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateRightEffect(), -MathKt.roundToInt(Velocity.m2701getXimpl(j5)));
                    f5 = Velocity.m2701getXimpl(j5);
                }
                if (Velocity.m2702getYimpl(j5) > 0.0f && this.edgeEffectWrapper.isTopStretched()) {
                    EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateTopEffect(), MathKt.roundToInt(Velocity.m2702getYimpl(j5)));
                    f6 = Velocity.m2702getYimpl(j5);
                } else if (Velocity.m2702getYimpl(j5) >= 0.0f || !this.edgeEffectWrapper.isBottomStretched()) {
                    f6 = 0.0f;
                } else {
                    EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateBottomEffect(), -MathKt.roundToInt(Velocity.m2702getYimpl(j5)));
                    f6 = Velocity.m2702getYimpl(j5);
                }
                long Velocity = VelocityKt.Velocity(f5, f6);
                if (!Velocity.m2700equalsimpl0(Velocity, Velocity.INSTANCE.m2709getZero9UxMQ8M())) {
                    invalidateOverscroll$foundation_release();
                }
                m2704minusAH228Gc = Velocity.m2704minusAH228Gc(j5, Velocity);
                Velocity m2695boximpl2 = Velocity.m2695boximpl(m2704minusAH228Gc);
                androidEdgeEffectOverscrollEffect$applyToFling$1.L$0 = this;
                androidEdgeEffectOverscrollEffect$applyToFling$1.J$0 = m2704minusAH228Gc;
                androidEdgeEffectOverscrollEffect$applyToFling$1.label = 2;
                obj = function2.invoke(m2695boximpl2, androidEdgeEffectOverscrollEffect$applyToFling$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                androidEdgeEffectOverscrollEffect = this;
                m2704minusAH228Gc2 = Velocity.m2704minusAH228Gc(m2704minusAH228Gc, ((Velocity) obj).getPackedValue());
                androidEdgeEffectOverscrollEffect.scrollCycleInProgress = false;
                if (Velocity.m2701getXimpl(m2704minusAH228Gc2) <= 0.0f) {
                }
                if (Velocity.m2702getYimpl(m2704minusAH228Gc2) <= 0.0f) {
                }
                if (!Velocity.m2700equalsimpl0(m2704minusAH228Gc2, Velocity.INSTANCE.m2709getZero9UxMQ8M())) {
                }
                androidEdgeEffectOverscrollEffect.animateToRelease();
                return Unit.INSTANCE;
            }
        }
        androidEdgeEffectOverscrollEffect$applyToFling$1 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, continuation);
        Object obj2 = androidEdgeEffectOverscrollEffect$applyToFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
        if (i5 == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010c  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToScroll-Rhakbz0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long mo100applyToScrollRhakbz0(long delta, int source, Function1<? super Offset, Offset> performScroll) {
        float m94pullBottomk4lQ0M;
        long Offset;
        boolean z5;
        boolean z6;
        if (Size.m1379isEmptyimpl(this.containerSize)) {
            return performScroll.invoke(Offset.m1328boximpl(delta)).getPackedValue();
        }
        boolean z7 = true;
        if (!this.scrollCycleInProgress) {
            stopOverscrollAnimation();
            this.scrollCycleInProgress = true;
        }
        float f5 = 0.0f;
        if (Offset.m1338getYimpl(delta) != 0.0f) {
            if (this.edgeEffectWrapper.isTopStretched()) {
                m94pullBottomk4lQ0M = m97pullTopk4lQ0M(delta);
                if (!this.edgeEffectWrapper.isTopStretched()) {
                    this.edgeEffectWrapper.getOrCreateTopEffect().onRelease();
                }
            } else if (this.edgeEffectWrapper.isBottomStretched()) {
                m94pullBottomk4lQ0M = m94pullBottomk4lQ0M(delta);
                if (!this.edgeEffectWrapper.isBottomStretched()) {
                    this.edgeEffectWrapper.getOrCreateBottomEffect().onRelease();
                }
            }
            if (Offset.m1337getXimpl(delta) != 0.0f) {
                if (this.edgeEffectWrapper.isLeftStretched()) {
                    f5 = m95pullLeftk4lQ0M(delta);
                    if (!this.edgeEffectWrapper.isLeftStretched()) {
                        this.edgeEffectWrapper.getOrCreateLeftEffect().onRelease();
                    }
                } else if (this.edgeEffectWrapper.isRightStretched()) {
                    f5 = m96pullRightk4lQ0M(delta);
                    if (!this.edgeEffectWrapper.isRightStretched()) {
                        this.edgeEffectWrapper.getOrCreateRightEffect().onRelease();
                    }
                }
            }
            Offset = OffsetKt.Offset(f5, m94pullBottomk4lQ0M);
            if (!Offset.m1334equalsimpl0(Offset, Offset.INSTANCE.m1349getZeroF1C5BW0())) {
                invalidateOverscroll$foundation_release();
            }
            long m1341minusMKHz9U = Offset.m1341minusMKHz9U(delta, Offset);
            long packedValue = performScroll.invoke(Offset.m1328boximpl(m1341minusMKHz9U)).getPackedValue();
            long m1341minusMKHz9U2 = Offset.m1341minusMKHz9U(m1341minusMKHz9U, packedValue);
            boolean z8 = false;
            if (NestedScrollSource.m1840equalsimpl0(source, NestedScrollSource.INSTANCE.m1842getUserInputWNlRxjI())) {
                if (Offset.m1337getXimpl(m1341minusMKHz9U2) > 0.5f) {
                    m95pullLeftk4lQ0M(m1341minusMKHz9U2);
                } else if (Offset.m1337getXimpl(m1341minusMKHz9U2) < -0.5f) {
                    m96pullRightk4lQ0M(m1341minusMKHz9U2);
                } else {
                    z5 = false;
                    if (Offset.m1338getYimpl(m1341minusMKHz9U2) <= 0.5f) {
                        m97pullTopk4lQ0M(m1341minusMKHz9U2);
                    } else if (Offset.m1338getYimpl(m1341minusMKHz9U2) < -0.5f) {
                        m94pullBottomk4lQ0M(m1341minusMKHz9U2);
                    } else {
                        z6 = false;
                        if (!z5 && !z6) {
                            z7 = false;
                        }
                        z8 = z7;
                    }
                    z6 = true;
                    if (!z5) {
                        z7 = false;
                    }
                    z8 = z7;
                }
                z5 = true;
                if (Offset.m1338getYimpl(m1341minusMKHz9U2) <= 0.5f) {
                }
                z6 = true;
                if (!z5) {
                }
                z8 = z7;
            }
            if (!m98releaseOppositeOverscrollk4lQ0M(delta) || z8) {
                invalidateOverscroll$foundation_release();
            }
            return Offset.m1342plusMKHz9U(Offset, packedValue);
        }
        m94pullBottomk4lQ0M = 0.0f;
        if (Offset.m1337getXimpl(delta) != 0.0f) {
        }
        Offset = OffsetKt.Offset(f5, m94pullBottomk4lQ0M);
        if (!Offset.m1334equalsimpl0(Offset, Offset.INSTANCE.m1349getZeroF1C5BW0())) {
        }
        long m1341minusMKHz9U3 = Offset.m1341minusMKHz9U(delta, Offset);
        long packedValue2 = performScroll.invoke(Offset.m1328boximpl(m1341minusMKHz9U3)).getPackedValue();
        long m1341minusMKHz9U22 = Offset.m1341minusMKHz9U(m1341minusMKHz9U3, packedValue2);
        boolean z82 = false;
        if (NestedScrollSource.m1840equalsimpl0(source, NestedScrollSource.INSTANCE.m1842getUserInputWNlRxjI())) {
        }
        if (!m98releaseOppositeOverscrollk4lQ0M(delta)) {
        }
        invalidateOverscroll$foundation_release();
        return Offset.m1342plusMKHz9U(Offset, packedValue2);
    }

    /* renamed from: displacement-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m101displacementF1C5BW0$foundation_release() {
        Offset offset = this.pointerPosition;
        long packedValue = offset != null ? offset.getPackedValue() : SizeKt.m1385getCenteruvyYCjk(this.containerSize);
        return OffsetKt.Offset(Offset.m1337getXimpl(packedValue) / Size.m1377getWidthimpl(this.containerSize), Offset.m1338getYimpl(packedValue) / Size.m1375getHeightimpl(this.containerSize));
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final MutableState<Unit> getRedrawSignal$foundation_release() {
        return this.redrawSignal;
    }

    public final void invalidateOverscroll$foundation_release() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        EdgeEffect edgeEffect;
        EdgeEffect edgeEffect2;
        EdgeEffect edgeEffect3;
        EdgeEffect edgeEffect4;
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        edgeEffect = edgeEffectWrapper.topEffect;
        if (edgeEffect != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect) != 0.0f) {
            return true;
        }
        edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect2) != 0.0f) {
            return true;
        }
        edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect3) != 0.0f) {
            return true;
        }
        edgeEffect4 = edgeEffectWrapper.rightEffect;
        return (edgeEffect4 == null || EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect4) == 0.0f) ? false : true;
    }

    /* renamed from: updateSize-uvyYCjk$foundation_release, reason: not valid java name */
    public final void m102updateSizeuvyYCjk$foundation_release(long size) {
        boolean m1374equalsimpl0 = Size.m1374equalsimpl0(this.containerSize, Size.INSTANCE.m1384getZeroNHjbRc());
        boolean m1374equalsimpl02 = Size.m1374equalsimpl0(size, this.containerSize);
        this.containerSize = size;
        if (!m1374equalsimpl02) {
            this.edgeEffectWrapper.m138setSizeozmzZPI(IntSizeKt.IntSize(MathKt.roundToInt(Size.m1377getWidthimpl(size)), MathKt.roundToInt(Size.m1375getHeightimpl(size))));
        }
        if (m1374equalsimpl0 || m1374equalsimpl02) {
            return;
        }
        invalidateOverscroll$foundation_release();
        animateToRelease();
    }
}
