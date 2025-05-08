package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001aA\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"unsupportedDirection", BuildConfig.FLAVOR, "lazyLayoutBeyondBoundsModifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "reverseLayout", BuildConfig.FLAVOR, "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;ZLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LazyLayoutBeyondBoundsModifierLocalKt {
    public static final Modifier lazyLayoutBeyondBoundsModifier(Modifier modifier, LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsState, LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo, boolean z5, LayoutDirection layoutDirection, Orientation orientation, boolean z6, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1331498025, i5, -1, "androidx.compose.foundation.lazy.layout.lazyLayoutBeyondBoundsModifier (LazyLayoutBeyondBoundsModifierLocal.kt:51)");
        }
        if (z6) {
            composer.startReplaceGroup(-1890632411);
            boolean z7 = ((((i5 & 112) ^ 48) > 32 && composer.changed(lazyLayoutBeyondBoundsState)) || (i5 & 48) == 32) | ((((i5 & 896) ^ 384) > 256 && composer.changed(lazyLayoutBeyondBoundsInfo)) || (i5 & 384) == 256) | ((((i5 & 7168) ^ 3072) > 2048 && composer.changed(z5)) || (i5 & 3072) == 2048) | ((((57344 & i5) ^ 24576) > 16384 && composer.changed(layoutDirection)) || (i5 & 24576) == 16384) | ((((458752 & i5) ^ 196608) > 131072 && composer.changed(orientation)) || (i5 & 196608) == 131072);
            Object rememberedValue = composer.rememberedValue();
            if (z7 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new LazyLayoutBeyondBoundsModifierLocal(lazyLayoutBeyondBoundsState, lazyLayoutBeyondBoundsInfo, z5, layoutDirection, orientation);
                composer.updateRememberedValue(rememberedValue);
            }
            modifier = modifier.then((LazyLayoutBeyondBoundsModifierLocal) rememberedValue);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1890658823);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void unsupportedDirection() {
        throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction");
    }
}
