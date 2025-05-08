package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"rememberLazyListBeyondBoundsState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "beyondBoundsItemCount", BuildConfig.FLAVOR, "(Landroidx/compose/foundation/lazy/LazyListState;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LazyListBeyondBoundsModifierKt {
    public static final LazyLayoutBeyondBoundsState rememberLazyListBeyondBoundsState(LazyListState lazyListState, int i5, Composer composer, int i6) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1877443446, i6, -1, "androidx.compose.foundation.lazy.rememberLazyListBeyondBoundsState (LazyListBeyondBoundsModifier.kt:26)");
        }
        boolean z5 = ((((i6 & 14) ^ 6) > 4 && composer.changed(lazyListState)) || (i6 & 6) == 4) | ((((i6 & 112) ^ 48) > 32 && composer.changed(i5)) || (i6 & 48) == 32);
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LazyListBeyondBoundsState(lazyListState, i5);
            composer.updateRememberedValue(rememberedValue);
        }
        LazyListBeyondBoundsState lazyListBeyondBoundsState = (LazyListBeyondBoundsState) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return lazyListBeyondBoundsState;
    }
}
