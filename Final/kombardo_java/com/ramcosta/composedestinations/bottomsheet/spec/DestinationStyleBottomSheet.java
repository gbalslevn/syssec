package com.ramcosta.composedestinations.bottomsheet.spec;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.navigation.NavGraphBuilderKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import com.ramcosta.composedestinations.manualcomposablecalls.DestinationLambda;
import com.ramcosta.composedestinations.manualcomposablecalls.ManualComposableCalls;
import com.ramcosta.composedestinations.manualcomposablecalls.ManualComposableCallsKt;
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JO\u0010\u0010\u001a\u00020\f\"\u0004\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/ramcosta/composedestinations/bottomsheet/spec/DestinationStyleBottomSheet;", "Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "<init>", "()V", "T", "Landroidx/navigation/NavGraphBuilder;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "destination", "Landroidx/navigation/NavHostController;", "navController", "Lkotlin/Function1;", "Lcom/ramcosta/composedestinations/navigation/DependenciesContainerBuilder;", BuildConfig.FLAVOR, "dependenciesContainerBuilder", "Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;", "manualComposableCalls", "addComposable", "(Landroidx/navigation/NavGraphBuilder;Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;Landroidx/navigation/NavHostController;Lkotlin/jvm/functions/Function3;Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;)V", "compose-destinations-bottom-sheet_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DestinationStyleBottomSheet extends DestinationStyle {
    public static final DestinationStyleBottomSheet INSTANCE = new DestinationStyleBottomSheet();

    private DestinationStyleBottomSheet() {
    }

    @Override // com.ramcosta.composedestinations.spec.DestinationStyle
    public <T> void addComposable(NavGraphBuilder navGraphBuilder, final TypedDestinationSpec<T> destination, final NavHostController navController, final Function3<? super DependenciesContainerBuilder<?>, ? super Composer, ? super Integer, Unit> dependenciesContainerBuilder, ManualComposableCalls manualComposableCalls) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
        Intrinsics.checkNotNullParameter(manualComposableCalls, "manualComposableCalls");
        manualComposableCalls.get(destination.getRoute());
        final DestinationLambda destinationLambda = null;
        NavGraphBuilderKt.bottomSheet(navGraphBuilder, destination.getRoute(), destination.getArguments(), ManualComposableCallsKt.allDeepLinks(destination, manualComposableCalls), ComposableLambdaKt.composableLambdaInstance(-351163257, true, new Function4<ColumnScope, NavBackStackEntry, Composer, Integer, Unit>(destination, navController, dependenciesContainerBuilder, destinationLambda) { // from class: com.ramcosta.composedestinations.bottomsheet.spec.DestinationStyleBottomSheet$addComposable$1
            final /* synthetic */ Function3<DependenciesContainerBuilder<?>, Composer, Integer, Unit> $dependenciesContainerBuilder;
            final /* synthetic */ TypedDestinationSpec<T> $destination;
            final /* synthetic */ NavHostController $navController;

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                invoke(columnScope, navBackStackEntry, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope bottomSheet, NavBackStackEntry navBackStackEntry, Composer composer, int i5) {
                Intrinsics.checkNotNullParameter(bottomSheet, "$this$bottomSheet");
                Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-351163257, i5, -1, "com.ramcosta.composedestinations.bottomsheet.spec.DestinationStyleBottomSheet.addComposable.<anonymous> (DestinationStyleBottomSheet.kt:52)");
                }
                DestinationStyleBottomSheetKt.access$CallComposable(bottomSheet, this.$destination, this.$navController, navBackStackEntry, this.$dependenciesContainerBuilder, null, composer, ((i5 << 6) & 7168) | (i5 & 14) | (DestinationLambda.$stable << 15));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }
}
