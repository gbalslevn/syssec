package androidx.compose.foundation.gestures;

import android.content.Context;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\"&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008GX\u0087\u0004¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005\" \u0010\b\u001a\u00020\u00018\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "LocalBringIntoViewSpec", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalBringIntoViewSpec", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalBringIntoViewSpec$annotations", "()V", "PivotBringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "getPivotBringIntoViewSpec", "()Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "getPivotBringIntoViewSpec$annotations", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BringIntoViewSpec_androidKt {
    private static final ProvidableCompositionLocal<BringIntoViewSpec> LocalBringIntoViewSpec = CompositionLocalKt.compositionLocalWithComputedDefaultOf(new Function1<CompositionLocalAccessorScope, BringIntoViewSpec>() { // from class: androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt$LocalBringIntoViewSpec$1
        @Override // kotlin.jvm.functions.Function1
        public final BringIntoViewSpec invoke(CompositionLocalAccessorScope compositionLocalAccessorScope) {
            if (!((Context) compositionLocalAccessorScope.getCurrentValue(AndroidCompositionLocals_androidKt.getLocalContext())).getPackageManager().hasSystemFeature("android.software.leanback")) {
                return BringIntoViewSpec.INSTANCE.getDefaultBringIntoViewSpec$foundation_release();
            }
            return BringIntoViewSpec_androidKt.getPivotBringIntoViewSpec();
        }
    });
    private static final BringIntoViewSpec PivotBringIntoViewSpec = new BringIntoViewSpec() { // from class: androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt$PivotBringIntoViewSpec$1
        private final float childFraction;
        private final float parentFraction = 0.3f;
        private final AnimationSpec<Float> scrollAnimationSpec = AnimationSpecKt.tween$default(125, 0, new CubicBezierEasing(0.25f, 0.1f, 0.25f, 1.0f), 2, null);

        @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
        public float calculateScrollDistance(float offset, float size, float containerSize) {
            float abs = Math.abs((size + offset) - offset);
            boolean z5 = abs <= containerSize;
            float f5 = (this.parentFraction * containerSize) - (this.childFraction * abs);
            float f6 = containerSize - f5;
            if (z5 && f6 < abs) {
                f5 = containerSize - abs;
            }
            return offset - f5;
        }

        @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
        public AnimationSpec<Float> getScrollAnimationSpec() {
            return this.scrollAnimationSpec;
        }
    };

    public static final ProvidableCompositionLocal<BringIntoViewSpec> getLocalBringIntoViewSpec() {
        return LocalBringIntoViewSpec;
    }

    public static final BringIntoViewSpec getPivotBringIntoViewSpec() {
        return PivotBringIntoViewSpec;
    }
}
