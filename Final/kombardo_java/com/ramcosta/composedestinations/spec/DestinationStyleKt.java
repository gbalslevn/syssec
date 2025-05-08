package com.ramcosta.composedestinations.spec;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import com.ramcosta.composedestinations.manualcomposablecalls.DestinationLambda;
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder;
import com.ramcosta.composedestinations.scope.AnimatedDestinationScopeImpl;
import com.ramcosta.composedestinations.spec.DestinationStyleKt;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a_\u0010\u000e\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\n0\b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fH\u0003¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"T", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "destination", "Landroidx/navigation/NavHostController;", "navController", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "Lkotlin/Function1;", "Lcom/ramcosta/composedestinations/navigation/DependenciesContainerBuilder;", BuildConfig.FLAVOR, "dependenciesContainerBuilder", "Lcom/ramcosta/composedestinations/manualcomposablecalls/DestinationLambda;", "contentWrapper", "CallComposable", "(Landroidx/compose/animation/AnimatedVisibilityScope;Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;Landroidx/navigation/NavHostController;Landroidx/navigation/NavBackStackEntry;Lkotlin/jvm/functions/Function3;Lcom/ramcosta/composedestinations/manualcomposablecalls/DestinationLambda;Landroidx/compose/runtime/Composer;I)V", "compose-destinations_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DestinationStyleKt {
    public static final <T> void CallComposable(AnimatedVisibilityScope animatedVisibilityScope, TypedDestinationSpec<T> typedDestinationSpec, NavHostController navHostController, NavBackStackEntry navBackStackEntry, Function3<? super DependenciesContainerBuilder<?>, ? super Composer, ? super Integer, Unit> function3, DestinationLambda<T> destinationLambda, Composer composer, int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(670974915);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(animatedVisibilityScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= (i5 & 64) == 0 ? startRestartGroup.changed(typedDestinationSpec) : startRestartGroup.changedInstance(typedDestinationSpec) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navHostController) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(navBackStackEntry) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(destinationLambda) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(670974915, i6, -1, "com.ramcosta.composedestinations.spec.CallComposable (DestinationStyle.kt:249)");
            }
            startRestartGroup.startReplaceGroup(1535670589);
            boolean changed = ((i6 & 112) == 32 || ((i6 & 64) != 0 && startRestartGroup.changed(typedDestinationSpec))) | startRestartGroup.changed(navBackStackEntry) | startRestartGroup.changed(navHostController) | startRestartGroup.changed(animatedVisibilityScope) | ((i6 & 57344) == 16384);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                AnimatedDestinationScopeImpl animatedDestinationScopeImpl = new AnimatedDestinationScopeImpl(typedDestinationSpec, navBackStackEntry, navHostController, animatedVisibilityScope, function3);
                startRestartGroup.updateRememberedValue(animatedDestinationScopeImpl);
                rememberedValue = animatedDestinationScopeImpl;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(361461105);
            typedDestinationSpec.Content((AnimatedDestinationScopeImpl) rememberedValue, startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2(typedDestinationSpec, navHostController, navBackStackEntry, function3, destinationLambda, i5) { // from class: j1.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ TypedDestinationSpec f5996b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ NavHostController f5997c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ NavBackStackEntry f5998d;

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ Function3 f5999e;

                /* renamed from: f, reason: collision with root package name */
                public final /* synthetic */ int f6000f;

                {
                    this.f6000f = i5;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CallComposable$lambda$5;
                    CallComposable$lambda$5 = DestinationStyleKt.CallComposable$lambda$5(AnimatedVisibilityScope.this, this.f5996b, this.f5997c, this.f5998d, this.f5999e, null, this.f6000f, (Composer) obj, ((Integer) obj2).intValue());
                    return CallComposable$lambda$5;
                }
            });
        }
    }

    public static final Unit CallComposable$lambda$5(AnimatedVisibilityScope animatedVisibilityScope, TypedDestinationSpec typedDestinationSpec, NavHostController navHostController, NavBackStackEntry navBackStackEntry, Function3 function3, DestinationLambda destinationLambda, int i5, Composer composer, int i6) {
        CallComposable(animatedVisibilityScope, typedDestinationSpec, navHostController, navBackStackEntry, function3, destinationLambda, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$CallComposable(AnimatedVisibilityScope animatedVisibilityScope, TypedDestinationSpec typedDestinationSpec, NavHostController navHostController, NavBackStackEntry navBackStackEntry, Function3 function3, DestinationLambda destinationLambda, Composer composer, int i5) {
        CallComposable(animatedVisibilityScope, typedDestinationSpec, navHostController, navBackStackEntry, function3, destinationLambda, composer, i5);
    }
}
