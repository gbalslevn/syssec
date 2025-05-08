package com.ramcosta.composedestinations;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import com.ramcosta.composedestinations.spec.NavHostEngine;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"rememberNavHostEngine", "Lcom/ramcosta/composedestinations/spec/NavHostEngine;", "navHostContentAlignment", "Landroidx/compose/ui/Alignment;", "(Landroidx/compose/ui/Alignment;Landroidx/compose/runtime/Composer;II)Lcom/ramcosta/composedestinations/spec/NavHostEngine;", "compose-destinations_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DefaultNavHostEngineKt {
    public static final NavHostEngine rememberNavHostEngine(Alignment alignment, Composer composer, int i5, int i6) {
        composer.startReplaceGroup(-34827970);
        boolean z5 = true;
        if ((i6 & 1) != 0) {
            alignment = Alignment.INSTANCE.getCenter();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-34827970, i5, -1, "com.ramcosta.composedestinations.rememberNavHostEngine (DefaultNavHostEngine.kt:29)");
        }
        composer.startReplaceGroup(-522660770);
        if ((((i5 & 14) ^ 6) <= 4 || !composer.changed(alignment)) && (i5 & 6) != 4) {
            z5 = false;
        }
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new DefaultNavHostEngine(alignment);
            composer.updateRememberedValue(rememberedValue);
        }
        DefaultNavHostEngine defaultNavHostEngine = (DefaultNavHostEngine) rememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return defaultNavHostEngine;
    }
}
