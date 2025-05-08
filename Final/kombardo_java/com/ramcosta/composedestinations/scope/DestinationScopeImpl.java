package com.ramcosta.composedestinations.scope;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavBackStackEntry;
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainer;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainerImpl;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.scope.DestinationScopeImpl;
import com.ramcosta.composedestinations.utils.NavControllerExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0006\u0010\u0007R\u001b\u0010\f\u001a\u00028\u00008VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0016\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0012\u0012\u0004\u0012\u00020\u00130\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/ramcosta/composedestinations/scope/DestinationScopeImpl;", "T", "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "<init>", "()V", "Lcom/ramcosta/composedestinations/navigation/DestinationDependenciesContainer;", "buildDependencies", "(Landroidx/compose/runtime/Composer;I)Lcom/ramcosta/composedestinations/navigation/DestinationDependenciesContainer;", "navArgs$delegate", "Lkotlin/Lazy;", "getNavArgs", "()Ljava/lang/Object;", "navArgs", "Lkotlin/Function0;", BuildConfig.FLAVOR, "isCurrentNavBackStackEntryResumed", "Lkotlin/jvm/functions/Function0;", "Lkotlin/Function1;", "Lcom/ramcosta/composedestinations/navigation/DependenciesContainerBuilder;", BuildConfig.FLAVOR, "getDependenciesContainerBuilder", "()Lkotlin/jvm/functions/Function3;", "dependenciesContainerBuilder", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "getDestinationsNavigator", "()Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "destinationsNavigator", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DestinationScopeImpl<T> implements DestinationScope<T> {

    /* renamed from: navArgs$delegate, reason: from kotlin metadata */
    private final Lazy navArgs = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: i1.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Object navArgs_delegate$lambda$0;
            navArgs_delegate$lambda$0 = DestinationScopeImpl.navArgs_delegate$lambda$0(DestinationScopeImpl.this);
            return navArgs_delegate$lambda$0;
        }
    });
    private final Function0<Boolean> isCurrentNavBackStackEntryResumed = new Function0() { // from class: i1.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean isCurrentNavBackStackEntryResumed$lambda$3;
            isCurrentNavBackStackEntryResumed$lambda$3 = DestinationScopeImpl.isCurrentNavBackStackEntryResumed$lambda$3(DestinationScopeImpl.this);
            return Boolean.valueOf(isCurrentNavBackStackEntryResumed$lambda$3);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isCurrentNavBackStackEntryResumed$lambda$3(DestinationScopeImpl destinationScopeImpl) {
        return destinationScopeImpl.getNavBackStackEntry().getLifecycle().getState() == Lifecycle.State.RESUMED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object navArgs_delegate$lambda$0(DestinationScopeImpl destinationScopeImpl) {
        return destinationScopeImpl.getDestination().argsFrom(destinationScopeImpl.getNavBackStackEntry().getArguments());
    }

    @Override // com.ramcosta.composedestinations.scope.DestinationScope
    public DestinationDependenciesContainer buildDependencies(Composer composer, int i5) {
        composer.startReplaceGroup(-8387979);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-8387979, i5, -1, "com.ramcosta.composedestinations.scope.DestinationScopeImpl.buildDependencies (DestinationScopeInternals.kt:28)");
        }
        NavBackStackEntry navBackStackEntry = getNavBackStackEntry();
        composer.startReplaceGroup(-2079821547);
        boolean changed = composer.changed(navBackStackEntry);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new DestinationDependenciesContainerImpl(this);
            composer.updateRememberedValue(rememberedValue);
        }
        DestinationDependenciesContainerImpl destinationDependenciesContainerImpl = (DestinationDependenciesContainerImpl) rememberedValue;
        composer.endReplaceGroup();
        getDependenciesContainerBuilder().invoke(destinationDependenciesContainerImpl, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return destinationDependenciesContainerImpl;
    }

    public abstract Function3<DependenciesContainerBuilder<?>, Composer, Integer, Unit> getDependenciesContainerBuilder();

    @Override // com.ramcosta.composedestinations.scope.DestinationScope
    public DestinationsNavigator getDestinationsNavigator() {
        return NavControllerExtKt.toDestinationsNavigator(getNavController());
    }

    @Override // com.ramcosta.composedestinations.scope.DestinationScope
    public T getNavArgs() {
        return (T) this.navArgs.getValue();
    }
}
