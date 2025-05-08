package androidx.compose.foundation.pager;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.PagerSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\b\u0003\u0010\r\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/pager/PagerDefaults;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/foundation/pager/PagerState;", "state", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "pagerSnapDistance", "Landroidx/compose/animation/core/DecayAnimationSpec;", BuildConfig.FLAVOR, "decayAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "snapAnimationSpec", "snapPositionalThreshold", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "flingBehavior", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/pager/PagerSnapDistance;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;FLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "pageNestedScrollConnection", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerDefaults {
    public static final PagerDefaults INSTANCE = new PagerDefaults();

    private PagerDefaults() {
    }

    public final TargetedFlingBehavior flingBehavior(final PagerState pagerState, PagerSnapDistance pagerSnapDistance, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, final float f5, Composer composer, int i5, int i6) {
        boolean z5 = true;
        if ((i6 & 2) != 0) {
            pagerSnapDistance = PagerSnapDistance.INSTANCE.atMost(1);
        }
        if ((i6 & 4) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0);
        }
        if ((i6 & 8) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, Float.valueOf(VisibilityThresholdsKt.getVisibilityThreshold(IntCompanionObject.INSTANCE)), 1, null);
        }
        if ((i6 & 16) != 0) {
            f5 = 0.5f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1559769181, i5, -1, "androidx.compose.foundation.pager.PagerDefaults.flingBehavior (Pager.kt:301)");
        }
        if (0.0f > f5 || f5 > 1.0f) {
            throw new IllegalArgumentException(("snapPositionalThreshold should be a number between 0 and 1. You've specified " + f5).toString());
        }
        Object obj = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        final LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        boolean changed = ((((i5 & 14) ^ 6) > 4 && composer.changed(pagerState)) || (i5 & 6) == 4) | composer.changed(decayAnimationSpec) | composer.changed(animationSpec);
        if ((((i5 & 112) ^ 48) <= 32 || !composer.changed(pagerSnapDistance)) && (i5 & 48) != 32) {
            z5 = false;
        }
        boolean changed2 = changed | z5 | composer.changed(obj) | composer.changed(layoutDirection);
        Object rememberedValue = composer.rememberedValue();
        if (changed2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapFlingBehaviorKt.snapFlingBehavior(PagerSnapLayoutInfoProviderKt.SnapLayoutInfoProvider(pagerState, pagerSnapDistance, new Function3<Float, Float, Float, Float>() { // from class: androidx.compose.foundation.pager.PagerDefaults$flingBehavior$2$snapLayoutInfoProvider$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Float invoke(Float f6, Float f7, Float f8) {
                    return invoke(f6.floatValue(), f7.floatValue(), f8.floatValue());
                }

                public final Float invoke(float f6, float f7, float f8) {
                    return Float.valueOf(PagerSnapLayoutInfoProviderKt.calculateFinalSnappingBound(PagerState.this, layoutDirection, f5, f6, f7, f8));
                }
            }), decayAnimationSpec, animationSpec);
            composer.updateRememberedValue(rememberedValue);
        }
        TargetedFlingBehavior targetedFlingBehavior = (TargetedFlingBehavior) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return targetedFlingBehavior;
    }

    public final NestedScrollConnection pageNestedScrollConnection(PagerState pagerState, Orientation orientation, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(877583120, i5, -1, "androidx.compose.foundation.pager.PagerDefaults.pageNestedScrollConnection (Pager.kt:350)");
        }
        boolean z5 = ((((i5 & 14) ^ 6) > 4 && composer.changed(pagerState)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && composer.changed(orientation)) || (i5 & 48) == 32);
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new DefaultPagerNestedScrollConnection(pagerState, orientation);
            composer.updateRememberedValue(rememberedValue);
        }
        DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection = (DefaultPagerNestedScrollConnection) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultPagerNestedScrollConnection;
    }
}
