package dk.molslinjen.ui.views.global.navigation.transitions;

import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.navigation.NavBackStackEntry;
import com.ramcosta.composedestinations.animations.NavHostAnimatedDestinationStyle;
import dk.molslinjen.ui.views.global.navigation.transitions.HorizontalScreenTransitions;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R,\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR,\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\f0\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR&\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR&\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\f0\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/ui/views/global/navigation/transitions/HorizontalScreenTransitions;", "Lcom/ramcosta/composedestinations/animations/NavHostAnimatedDestinationStyle;", "<init>", "()V", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/EnterTransition;", "enterTransition", "Lkotlin/jvm/functions/Function1;", "getEnterTransition", "()Lkotlin/jvm/functions/Function1;", "Landroidx/compose/animation/ExitTransition;", "exitTransition", "getExitTransition", "getPopEnterTransition", "popEnterTransition", "getPopExitTransition", "popExitTransition", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HorizontalScreenTransitions extends NavHostAnimatedDestinationStyle {
    public static final HorizontalScreenTransitions INSTANCE = new HorizontalScreenTransitions();
    private static final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition = new Function1() { // from class: T1.a
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            EnterTransition enterTransition$lambda$1;
            enterTransition$lambda$1 = HorizontalScreenTransitions.enterTransition$lambda$1((AnimatedContentTransitionScope) obj);
            return enterTransition$lambda$1;
        }
    };
    private static final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition = new Function1() { // from class: T1.b
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            ExitTransition exitTransition$lambda$3;
            exitTransition$lambda$3 = HorizontalScreenTransitions.exitTransition$lambda$3((AnimatedContentTransitionScope) obj);
            return exitTransition$lambda$3;
        }
    };

    private HorizontalScreenTransitions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition _get_popEnterTransition_$lambda$5(AnimatedContentTransitionScope animatedContentTransitionScope) {
        Intrinsics.checkNotNullParameter(animatedContentTransitionScope, "<this>");
        return EnterExitTransitionKt.slideInHorizontally(new TweenSpec(300, 0, EasingKt.getFastOutSlowInEasing()), new Function1() { // from class: T1.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int _get_popEnterTransition_$lambda$5$lambda$4;
                _get_popEnterTransition_$lambda$5$lambda$4 = HorizontalScreenTransitions._get_popEnterTransition_$lambda$5$lambda$4(((Integer) obj).intValue());
                return Integer.valueOf(_get_popEnterTransition_$lambda$5$lambda$4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _get_popEnterTransition_$lambda$5$lambda$4(int i5) {
        return -i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition _get_popExitTransition_$lambda$7(AnimatedContentTransitionScope animatedContentTransitionScope) {
        Intrinsics.checkNotNullParameter(animatedContentTransitionScope, "<this>");
        return EnterExitTransitionKt.slideOutHorizontally(new TweenSpec(300, 0, EasingKt.getFastOutSlowInEasing()), new Function1() { // from class: T1.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int _get_popExitTransition_$lambda$7$lambda$6;
                _get_popExitTransition_$lambda$7$lambda$6 = HorizontalScreenTransitions._get_popExitTransition_$lambda$7$lambda$6(((Integer) obj).intValue());
                return Integer.valueOf(_get_popExitTransition_$lambda$7$lambda$6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _get_popExitTransition_$lambda$7$lambda$6(int i5) {
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition enterTransition$lambda$1(AnimatedContentTransitionScope animatedContentTransitionScope) {
        Intrinsics.checkNotNullParameter(animatedContentTransitionScope, "<this>");
        return EnterExitTransitionKt.slideInHorizontally(new TweenSpec(300, 0, EasingKt.getFastOutSlowInEasing()), new Function1() { // from class: T1.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int enterTransition$lambda$1$lambda$0;
                enterTransition$lambda$1$lambda$0 = HorizontalScreenTransitions.enterTransition$lambda$1$lambda$0(((Integer) obj).intValue());
                return Integer.valueOf(enterTransition$lambda$1$lambda$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int enterTransition$lambda$1$lambda$0(int i5) {
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition exitTransition$lambda$3(AnimatedContentTransitionScope animatedContentTransitionScope) {
        Intrinsics.checkNotNullParameter(animatedContentTransitionScope, "<this>");
        return EnterExitTransitionKt.slideOutHorizontally(new TweenSpec(300, 0, EasingKt.getFastOutSlowInEasing()), new Function1() { // from class: T1.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int exitTransition$lambda$3$lambda$2;
                exitTransition$lambda$3$lambda$2 = HorizontalScreenTransitions.exitTransition$lambda$3$lambda$2(((Integer) obj).intValue());
                return Integer.valueOf(exitTransition$lambda$3$lambda$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int exitTransition$lambda$3$lambda$2(int i5) {
        return -i5;
    }

    @Override // com.ramcosta.composedestinations.animations.NavHostAnimatedDestinationStyle, com.ramcosta.composedestinations.spec.DestinationStyle.Animated
    public Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> getEnterTransition() {
        return enterTransition;
    }

    @Override // com.ramcosta.composedestinations.animations.NavHostAnimatedDestinationStyle, com.ramcosta.composedestinations.spec.DestinationStyle.Animated
    public Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> getExitTransition() {
        return exitTransition;
    }

    @Override // com.ramcosta.composedestinations.animations.NavHostAnimatedDestinationStyle, com.ramcosta.composedestinations.spec.DestinationStyle.Animated
    public Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> getPopEnterTransition() {
        return new Function1() { // from class: T1.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                EnterTransition _get_popEnterTransition_$lambda$5;
                _get_popEnterTransition_$lambda$5 = HorizontalScreenTransitions._get_popEnterTransition_$lambda$5((AnimatedContentTransitionScope) obj);
                return _get_popEnterTransition_$lambda$5;
            }
        };
    }

    @Override // com.ramcosta.composedestinations.animations.NavHostAnimatedDestinationStyle, com.ramcosta.composedestinations.spec.DestinationStyle.Animated
    public Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> getPopExitTransition() {
        return new Function1() { // from class: T1.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ExitTransition _get_popExitTransition_$lambda$7;
                _get_popExitTransition_$lambda$7 = HorizontalScreenTransitions._get_popExitTransition_$lambda$7((AnimatedContentTransitionScope) obj);
                return _get_popExitTransition_$lambda$7;
            }
        };
    }
}
