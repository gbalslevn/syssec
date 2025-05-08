package androidx.compose.foundation.lazy.layout;

import android.os.Build;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0001\u0010\u0002\"\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "rememberDefaultPrefetchScheduler", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "androidx/compose/foundation/lazy/layout/PrefetchScheduler_androidKt$RobolectricImpl$1", "RobolectricImpl", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler_androidKt$RobolectricImpl$1;", "getRobolectricImpl$annotations", "()V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PrefetchScheduler_androidKt {
    private static final PrefetchScheduler_androidKt$RobolectricImpl$1 RobolectricImpl;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.compose.foundation.lazy.layout.PrefetchScheduler_androidKt$RobolectricImpl$1] */
    static {
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        RobolectricImpl = Intrinsics.areEqual(lowerCase, "robolectric") ? new PrefetchScheduler() { // from class: androidx.compose.foundation.lazy.layout.PrefetchScheduler_androidKt$RobolectricImpl$1
            @Override // androidx.compose.foundation.lazy.layout.PrefetchScheduler
            public void schedulePrefetch(PrefetchRequest prefetchRequest) {
            }
        } : null;
    }

    public static final PrefetchScheduler rememberDefaultPrefetchScheduler(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1141871251, i5, -1, "androidx.compose.foundation.lazy.layout.rememberDefaultPrefetchScheduler (PrefetchScheduler.android.kt:32)");
        }
        PrefetchScheduler prefetchScheduler = RobolectricImpl;
        if (prefetchScheduler != null) {
            composer.startReplaceGroup(1213893039);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1213931944);
            View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
            boolean changed = composer.changed(view);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new AndroidPrefetchScheduler(view);
                composer.updateRememberedValue(rememberedValue);
            }
            prefetchScheduler = (AndroidPrefetchScheduler) rememberedValue;
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return prefetchScheduler;
    }
}
