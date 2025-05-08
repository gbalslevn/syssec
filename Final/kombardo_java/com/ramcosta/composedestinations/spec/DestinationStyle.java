package com.ramcosta.composedestinations.spec;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SizeTransform;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.ramcosta.composedestinations.manualcomposablecalls.DestinationLambda;
import com.ramcosta.composedestinations.manualcomposablecalls.ManualComposableCalls;
import com.ramcosta.composedestinations.manualcomposablecalls.ManualComposableCallsKt;
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JO\u0010\u0010\u001a\u00020\f\"\u0004\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/ramcosta/composedestinations/spec/DestinationStyle;", BuildConfig.FLAVOR, "<init>", "()V", "T", "Landroidx/navigation/NavGraphBuilder;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "destination", "Landroidx/navigation/NavHostController;", "navController", "Lkotlin/Function1;", "Lcom/ramcosta/composedestinations/navigation/DependenciesContainerBuilder;", BuildConfig.FLAVOR, "dependenciesContainerBuilder", "Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;", "manualComposableCalls", "addComposable", "(Landroidx/navigation/NavGraphBuilder;Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;Landroidx/navigation/NavHostController;Lkotlin/jvm/functions/Function3;Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;)V", "Default", "Animated", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DestinationStyle {
    public static final int $stable = 0;

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JM\u0010\u0010\u001a\u00020\f\"\u0004\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0017\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R*\u0010\u001a\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R*\u0010\u001c\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R*\u0010\u001e\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016R*\u0010!\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0016¨\u0006\""}, d2 = {"Lcom/ramcosta/composedestinations/spec/DestinationStyle$Animated;", "Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "<init>", "()V", "T", "Landroidx/navigation/NavGraphBuilder;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "destination", "Landroidx/navigation/NavHostController;", "navController", "Lkotlin/Function1;", "Lcom/ramcosta/composedestinations/navigation/DependenciesContainerBuilder;", BuildConfig.FLAVOR, "dependenciesContainerBuilder", "Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;", "manualComposableCalls", "addComposable", "(Landroidx/navigation/NavGraphBuilder;Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;Landroidx/navigation/NavHostController;Lkotlin/jvm/functions/Function3;Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;)V", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/EnterTransition;", "getEnterTransition", "()Lkotlin/jvm/functions/Function1;", "enterTransition", "Landroidx/compose/animation/ExitTransition;", "getExitTransition", "exitTransition", "getPopEnterTransition", "popEnterTransition", "getPopExitTransition", "popExitTransition", "Landroidx/compose/animation/SizeTransform;", "getSizeTransform", "sizeTransform", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class Animated extends DestinationStyle {
        @Override // com.ramcosta.composedestinations.spec.DestinationStyle
        public final <T> void addComposable(NavGraphBuilder navGraphBuilder, final TypedDestinationSpec<T> destination, final NavHostController navController, final Function3<? super DependenciesContainerBuilder<?>, ? super Composer, ? super Integer, Unit> dependenciesContainerBuilder, final ManualComposableCalls manualComposableCalls) {
            Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(navController, "navController");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            Intrinsics.checkNotNullParameter(manualComposableCalls, "manualComposableCalls");
            NavGraphBuilderKt.composable(navGraphBuilder, destination.getRoute(), destination.getArguments(), ManualComposableCallsKt.allDeepLinks(destination, manualComposableCalls), getEnterTransition(), getExitTransition(), getPopEnterTransition(), getPopExitTransition(), getSizeTransform(), ComposableLambdaKt.composableLambdaInstance(-233887114, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.ramcosta.composedestinations.spec.DestinationStyle$Animated$addComposable$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                    invoke(animatedContentScope, navBackStackEntry, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedContentScope composable, NavBackStackEntry navBackStackEntry, Composer composer, int i5) {
                    Intrinsics.checkNotNullParameter(composable, "$this$composable");
                    Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-233887114, i5, -1, "com.ramcosta.composedestinations.spec.DestinationStyle.Animated.addComposable.<anonymous> (DestinationStyle.kt:118)");
                    }
                    ManualComposableCalls.this.get(destination.getRoute());
                    DestinationStyleKt.access$CallComposable(composable, destination, navController, navBackStackEntry, dependenciesContainerBuilder, null, composer, (i5 & 14) | ((i5 << 6) & 7168));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
        }

        public abstract Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> getEnterTransition();

        public abstract Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> getExitTransition();

        public abstract Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> getPopEnterTransition();

        public abstract Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> getPopExitTransition();

        public Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> getSizeTransform() {
            return null;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JO\u0010\u0010\u001a\u00020\f\"\u0004\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/ramcosta/composedestinations/spec/DestinationStyle$Default;", "Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "<init>", "()V", "T", "Landroidx/navigation/NavGraphBuilder;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "destination", "Landroidx/navigation/NavHostController;", "navController", "Lkotlin/Function1;", "Lcom/ramcosta/composedestinations/navigation/DependenciesContainerBuilder;", BuildConfig.FLAVOR, "dependenciesContainerBuilder", "Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;", "manualComposableCalls", "addComposable", "(Landroidx/navigation/NavGraphBuilder;Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;Landroidx/navigation/NavHostController;Lkotlin/jvm/functions/Function3;Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;)V", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Default extends DestinationStyle {
        public static final Default INSTANCE = new Default();

        private Default() {
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
            NavGraphBuilderKt.composable$default(navGraphBuilder, destination.getRoute(), destination.getArguments(), ManualComposableCallsKt.allDeepLinks(destination, manualComposableCalls), null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(1155782858, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>(destination, navController, dependenciesContainerBuilder, destinationLambda) { // from class: com.ramcosta.composedestinations.spec.DestinationStyle$Default$addComposable$1
                final /* synthetic */ Function3<DependenciesContainerBuilder<?>, Composer, Integer, Unit> $dependenciesContainerBuilder;
                final /* synthetic */ TypedDestinationSpec<T> $destination;
                final /* synthetic */ NavHostController $navController;

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                    invoke(animatedContentScope, navBackStackEntry, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedContentScope composable, NavBackStackEntry navBackStackEntry, Composer composer, int i5) {
                    Intrinsics.checkNotNullParameter(composable, "$this$composable");
                    Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1155782858, i5, -1, "com.ramcosta.composedestinations.spec.DestinationStyle.Default.addComposable.<anonymous> (DestinationStyle.kt:61)");
                    }
                    DestinationStyleKt.access$CallComposable(composable, this.$destination, this.$navController, navBackStackEntry, this.$dependenciesContainerBuilder, null, composer, (i5 & 14) | ((i5 << 6) & 7168));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 248, null);
        }
    }

    public abstract <T> void addComposable(NavGraphBuilder navGraphBuilder, TypedDestinationSpec<T> typedDestinationSpec, NavHostController navHostController, Function3<? super DependenciesContainerBuilder<?>, ? super Composer, ? super Integer, Unit> function3, ManualComposableCalls manualComposableCalls);
}
