package com.ramcosta.composedestinations.generated.destinations;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavDeepLinkDslBuilder;
import androidx.navigation.NavDeepLinkDslBuilderKt;
import com.ramcosta.composedestinations.generated.destinations.DeepLinkScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainerImpl;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.spec.BaseRoute;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec;
import dk.molslinjen.ui.views.screens.deeplink.DeepLinkScreenKt;
import dk.molslinjen.ui.views.screens.deeplink.DeepLinkViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/DeepLinkScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/DirectionDestinationSpec;", "<init>", "()V", "Lcom/ramcosta/composedestinations/scope/DestinationScope;", BuildConfig.FLAVOR, "Content", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "baseRoute", "Ljava/lang/String;", "getBaseRoute", "route", "getRoute", BuildConfig.FLAVOR, "Landroidx/navigation/NavDeepLink;", "getDeepLinks", "()Ljava/util/List;", "deepLinks", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DeepLinkScreenDestination extends BaseRoute implements DirectionDestinationSpec {
    public static final DeepLinkScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;

    static {
        DeepLinkScreenDestination deepLinkScreenDestination = new DeepLinkScreenDestination();
        INSTANCE = deepLinkScreenDestination;
        baseRoute = "deep_link_screen";
        route = deepLinkScreenDestination.getBaseRoute();
    }

    private DeepLinkScreenDestination() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_deepLinks_$lambda$0(NavDeepLinkDslBuilder navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "$this$navDeepLink");
        navDeepLink.setUriPattern(".*/check-in?orderid={orderid}&phone={phone}");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_deepLinks_$lambda$1(NavDeepLinkDslBuilder navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "$this$navDeepLink");
        navDeepLink.setUriPattern(".*/profil/aktivering?token={token}");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_deepLinks_$lambda$2(NavDeepLinkDslBuilder navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "$this$navDeepLink");
        navDeepLink.setUriPattern(".*/profil/reset?token={token}");
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(DestinationScope<Unit> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(1386368527);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1386368527, i5, -1, "com.ramcosta.composedestinations.generated.destinations.DeepLinkScreenDestination.Content (DeepLinkScreenDestination.kt:40)");
        }
        DeepLinkScreenKt.DeepLinkScreen((DeepLinkViewModel) ((DestinationDependenciesContainerImpl) destinationScope.buildDependencies(composer, i5 & 14)).require(Reflection.getOrCreateKotlinClass(DeepLinkViewModel.class), false), destinationScope.getDestinationsNavigator(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public /* bridge */ /* synthetic */ Object argsFrom(Bundle bundle) {
        m3047argsFrom(bundle);
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return DirectionDestinationSpec.DefaultImpls.getArguments(this);
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public String getBaseRoute() {
        return baseRoute;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NavDeepLink> getDeepLinks() {
        return CollectionsKt.listOf((Object[]) new NavDeepLink[]{NavDeepLinkDslBuilderKt.navDeepLink(new Function1() { // from class: f1.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_deepLinks_$lambda$0;
                _get_deepLinks_$lambda$0 = DeepLinkScreenDestination._get_deepLinks_$lambda$0((NavDeepLinkDslBuilder) obj);
                return _get_deepLinks_$lambda$0;
            }
        }), NavDeepLinkDslBuilderKt.navDeepLink(new Function1() { // from class: f1.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_deepLinks_$lambda$1;
                _get_deepLinks_$lambda$1 = DeepLinkScreenDestination._get_deepLinks_$lambda$1((NavDeepLinkDslBuilder) obj);
                return _get_deepLinks_$lambda$1;
            }
        }), NavDeepLinkDslBuilderKt.navDeepLink(new Function1() { // from class: f1.A
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_deepLinks_$lambda$2;
                _get_deepLinks_$lambda$2 = DeepLinkScreenDestination._get_deepLinks_$lambda$2((NavDeepLinkDslBuilder) obj);
                return _get_deepLinks_$lambda$2;
            }
        })});
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute, com.ramcosta.composedestinations.spec.RouteOrDirection
    public String getRoute() {
        return route;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public DestinationStyle getStyle() {
        return DirectionDestinationSpec.DefaultImpls.getStyle(this);
    }

    public String toString() {
        return "DeepLinkScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public /* bridge */ /* synthetic */ Object argsFrom(SavedStateHandle savedStateHandle) {
        m3048argsFrom(savedStateHandle);
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(Unit unit) {
        return DirectionDestinationSpec.DefaultImpls.invoke(this, unit);
    }

    /* renamed from: argsFrom, reason: collision with other method in class */
    public void m3047argsFrom(Bundle bundle) {
        DirectionDestinationSpec.DefaultImpls.argsFrom(this, bundle);
    }

    /* renamed from: argsFrom, reason: collision with other method in class */
    public void m3048argsFrom(SavedStateHandle savedStateHandle) {
        DirectionDestinationSpec.DefaultImpls.argsFrom(this, savedStateHandle);
    }
}
