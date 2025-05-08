package androidx.compose.ui.tooling;

import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposableSingletons$PreviewActivity_androidKt {
    public static final ComposableSingletons$PreviewActivity_androidKt INSTANCE = new ComposableSingletons$PreviewActivity_androidKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f45lambda1 = ComposableLambdaKt.composableLambdaInstance(-426398407, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposableSingletons$PreviewActivity_androidKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i5) {
            if ((i5 & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-426398407, i5, -1, "androidx.compose.ui.tooling.ComposableSingletons$PreviewActivity_androidKt.lambda-1.<anonymous> (PreviewActivity.android.kt:124)");
            }
            TextKt.m747TextfLXpl1I("Next", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer, 6, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$ui_tooling_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2566getLambda1$ui_tooling_release() {
        return f45lambda1;
    }
}
