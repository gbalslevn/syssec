package com.ramcosta.composedestinations;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$DestinationsNavHostKt {
    public static final ComposableSingletons$DestinationsNavHostKt INSTANCE = new ComposableSingletons$DestinationsNavHostKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<DependenciesContainerBuilder<?>, Composer, Integer, Unit> f52lambda1 = ComposableLambdaKt.composableLambdaInstance(-1084890578, false, new Function3<DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: com.ramcosta.composedestinations.ComposableSingletons$DestinationsNavHostKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "<this>");
            if ((i5 & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1084890578, i5, -1, "com.ramcosta.composedestinations.ComposableSingletons$DestinationsNavHostKt.lambda-1.<anonymous> (DestinationsNavHost.kt:70)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$compose_destinations_release, reason: not valid java name */
    public final Function3<DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3032getLambda1$compose_destinations_release() {
        return f52lambda1;
    }
}
