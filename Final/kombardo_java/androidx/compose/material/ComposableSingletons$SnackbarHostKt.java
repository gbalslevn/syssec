package androidx.compose.material;

import android.support.v4.media.session.a;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposableSingletons$SnackbarHostKt {
    public static final ComposableSingletons$SnackbarHostKt INSTANCE = new ComposableSingletons$SnackbarHostKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<SnackbarData, Composer, Integer, Unit> f15lambda1 = ComposableLambdaKt.composableLambdaInstance(996639038, false, new Function3<SnackbarData, Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$SnackbarHostKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(SnackbarData snackbarData, Composer composer, Integer num) {
            a.a(snackbarData);
            invoke((SnackbarData) null, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(SnackbarData snackbarData, Composer composer, int i5) {
            int i6;
            if ((i5 & 6) == 0) {
                i6 = i5 | ((i5 & 8) == 0 ? composer.changed(snackbarData) : composer.changedInstance(snackbarData) ? 4 : 2);
            } else {
                i6 = i5;
            }
            if ((i6 & 19) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(996639038, i6, -1, "androidx.compose.material.ComposableSingletons$SnackbarHostKt.lambda-1.<anonymous> (SnackbarHost.kt:156)");
            }
            SnackbarKt.m725SnackbarsPrSdHI(snackbarData, null, false, null, 0L, 0L, 0L, 0.0f, composer, i6 & 14, 254);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$material_release, reason: not valid java name */
    public final Function3<SnackbarData, Composer, Integer, Unit> m684getLambda1$material_release() {
        return f15lambda1;
    }
}
