package com.ramcosta.composedestinations.scope;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import com.ramcosta.composedestinations.result.ResultCommonsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"R", "Lcom/ramcosta/composedestinations/scope/DestinationScopeWithNoDependencies;", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", "resultNavType", "Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", "resultBackNavigator", "(Lcom/ramcosta/composedestinations/scope/DestinationScopeWithNoDependencies;Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;Landroidx/compose/runtime/Composer;I)Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", "compose-destinations_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DestinationScopeKt {
    public static final <R> ResultBackNavigator<R> resultBackNavigator(DestinationScopeWithNoDependencies<?> destinationScopeWithNoDependencies, DestinationsNavType<? super R> resultNavType, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScopeWithNoDependencies, "<this>");
        Intrinsics.checkNotNullParameter(resultNavType, "resultNavType");
        composer.startReplaceGroup(-1303963696);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1303963696, i5, -1, "com.ramcosta.composedestinations.scope.resultBackNavigator (DestinationScope.kt:83)");
        }
        ResultBackNavigator<R> resultBackNavigator = ResultCommonsKt.resultBackNavigator(destinationScopeWithNoDependencies.getDestination(), resultNavType, destinationScopeWithNoDependencies.getNavController(), destinationScopeWithNoDependencies.getNavBackStackEntry(), composer, i5 & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return resultBackNavigator;
    }
}
