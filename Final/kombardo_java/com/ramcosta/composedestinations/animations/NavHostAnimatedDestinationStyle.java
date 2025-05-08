package com.ramcosta.composedestinations.animations;

import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.navigation.NavBackStackEntry;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR&\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u000b0\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\tR&\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\tR&\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u000b0\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/ramcosta/composedestinations/animations/NavHostAnimatedDestinationStyle;", "Lcom/ramcosta/composedestinations/spec/DestinationStyle$Animated;", "<init>", "()V", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/EnterTransition;", "getEnterTransition", "()Lkotlin/jvm/functions/Function1;", "enterTransition", "Landroidx/compose/animation/ExitTransition;", "getExitTransition", "exitTransition", "getPopEnterTransition", "popEnterTransition", "getPopExitTransition", "popExitTransition", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class NavHostAnimatedDestinationStyle extends DestinationStyle.Animated {
    @Override // com.ramcosta.composedestinations.spec.DestinationStyle.Animated
    public abstract Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> getEnterTransition();

    @Override // com.ramcosta.composedestinations.spec.DestinationStyle.Animated
    public abstract Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> getExitTransition();

    @Override // com.ramcosta.composedestinations.spec.DestinationStyle.Animated
    public abstract Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> getPopEnterTransition();

    @Override // com.ramcosta.composedestinations.spec.DestinationStyle.Animated
    public abstract Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> getPopExitTransition();
}
