package com.ramcosta.composedestinations.generated.destinations;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsBooleanNavTypeKt;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainerImpl;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.scope.DestinationScopeKt;
import com.ramcosta.composedestinations.spec.BaseRoute;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec;
import dk.molslinjen.ui.views.screens.booking.receipt.ReceiptScreenKt;
import dk.molslinjen.ui.views.screens.booking.receipt.ReceiptViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/ReceiptScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/DirectionDestinationSpec;", "<init>", "()V", "Lcom/ramcosta/composedestinations/scope/DestinationScope;", BuildConfig.FLAVOR, "Content", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "baseRoute", "Ljava/lang/String;", "getBaseRoute", "route", "getRoute", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ReceiptScreenDestination extends BaseRoute implements DirectionDestinationSpec {
    public static final ReceiptScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;

    static {
        ReceiptScreenDestination receiptScreenDestination = new ReceiptScreenDestination();
        INSTANCE = receiptScreenDestination;
        baseRoute = "receipt_screen";
        route = receiptScreenDestination.getBaseRoute();
    }

    private ReceiptScreenDestination() {
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(DestinationScope<Unit> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(-1866516341);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1866516341, i5, -1, "com.ramcosta.composedestinations.generated.destinations.ReceiptScreenDestination.Content (ReceiptScreenDestination.kt:28)");
        }
        int i6 = i5 & 14;
        ReceiptScreenKt.ReceiptScreen((ReceiptViewModel) ((DestinationDependenciesContainerImpl) destinationScope.buildDependencies(composer, i6)).require(Reflection.getOrCreateKotlinClass(ReceiptViewModel.class), false), destinationScope.getDestinationsNavigator(), DestinationScopeKt.resultBackNavigator(destinationScope, DestinationsBooleanNavTypeKt.getBooleanNavType(), composer, i6 | (DestinationsNavType.$stable << 3)), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public /* bridge */ /* synthetic */ Object argsFrom(Bundle bundle) {
        m3130argsFrom(bundle);
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
        return DirectionDestinationSpec.DefaultImpls.getDeepLinks(this);
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
        return "ReceiptScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public /* bridge */ /* synthetic */ Object argsFrom(SavedStateHandle savedStateHandle) {
        m3131argsFrom(savedStateHandle);
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(Unit unit) {
        return DirectionDestinationSpec.DefaultImpls.invoke(this, unit);
    }

    /* renamed from: argsFrom, reason: collision with other method in class */
    public void m3130argsFrom(Bundle bundle) {
        DirectionDestinationSpec.DefaultImpls.argsFrom(this, bundle);
    }

    /* renamed from: argsFrom, reason: collision with other method in class */
    public void m3131argsFrom(SavedStateHandle savedStateHandle) {
        DirectionDestinationSpec.DefaultImpls.argsFrom(this, savedStateHandle);
    }
}
