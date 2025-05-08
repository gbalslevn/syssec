package androidx.compose.foundation;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidOverscroll_androidKt {
    public static final OverscrollEffect rememberOverscrollEffect(Composer composer, int i5) {
        OverscrollEffect overscrollEffect;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1476348564, i5, -1, "androidx.compose.foundation.rememberOverscrollEffect (AndroidOverscroll.android.kt:63)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) composer.consume(OverscrollConfiguration_androidKt.getLocalOverscrollConfiguration());
        if (overscrollConfiguration != null) {
            composer.startReplaceGroup(1586021609);
            boolean changed = composer.changed(context) | composer.changed(overscrollConfiguration);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new AndroidEdgeEffectOverscrollEffect(context, overscrollConfiguration);
                composer.updateRememberedValue(rememberedValue);
            }
            overscrollEffect = (AndroidEdgeEffectOverscrollEffect) rememberedValue;
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1586120933);
            composer.endReplaceGroup();
            overscrollEffect = NoOpOverscrollEffect.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return overscrollEffect;
    }
}
