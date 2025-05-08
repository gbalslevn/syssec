package com.ramcosta.composedestinations.generated.destinations;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.bottomsheet.spec.DestinationStyleBottomSheet;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsStringNavType;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsStringNavTypeKt;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainerImpl;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultCommonsKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.spec.BaseRoute;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec;
import dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketScreenKt;
import dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/AddExistingTicketScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/DirectionDestinationSpec;", "<init>", "()V", "Lcom/ramcosta/composedestinations/scope/DestinationScope;", BuildConfig.FLAVOR, "Content", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "baseRoute", "Ljava/lang/String;", "getBaseRoute", "route", "getRoute", "Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "style", "Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "getStyle", "()Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AddExistingTicketScreenDestination extends BaseRoute implements DirectionDestinationSpec {
    public static final int $stable;
    public static final AddExistingTicketScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;
    private static final DestinationStyle style;

    static {
        AddExistingTicketScreenDestination addExistingTicketScreenDestination = new AddExistingTicketScreenDestination();
        INSTANCE = addExistingTicketScreenDestination;
        baseRoute = "add_existing_ticket_screen";
        route = addExistingTicketScreenDestination.getBaseRoute();
        style = DestinationStyleBottomSheet.INSTANCE;
        $stable = DestinationStyle.$stable;
    }

    private AddExistingTicketScreenDestination() {
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(DestinationScope<Unit> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(766815627);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(766815627, i5, -1, "com.ramcosta.composedestinations.generated.destinations.AddExistingTicketScreenDestination.Content (AddExistingTicketScreenDestination.kt:31)");
        }
        int i6 = i5 & 14;
        AddExistingTicketViewModel addExistingTicketViewModel = (AddExistingTicketViewModel) ((DestinationDependenciesContainerImpl) destinationScope.buildDependencies(composer, i6)).require(Reflection.getOrCreateKotlinClass(AddExistingTicketViewModel.class), false);
        DestinationsNavigator destinationsNavigator = destinationScope.getDestinationsNavigator();
        DestinationsStringNavType stringNavType = DestinationsStringNavTypeKt.getStringNavType();
        int i7 = i6 | (DestinationsStringNavType.$stable << 3);
        composer.startReplaceGroup(1363506722);
        ResultRecipient resultRecipient = ResultCommonsKt.resultRecipient(destinationScope.getNavBackStackEntry(), Reflection.getOrCreateKotlinClass(PhoneNumberCodeSelectionScreenDestination.class), stringNavType, composer, (i7 << 3) & 896);
        composer.endReplaceGroup();
        AddExistingTicketScreenKt.AddExistingTicketScreen(addExistingTicketViewModel, destinationsNavigator, resultRecipient, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public /* bridge */ /* synthetic */ Object argsFrom(Bundle bundle) {
        m3033argsFrom(bundle);
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
        return style;
    }

    public String toString() {
        return "AddExistingTicketScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public /* bridge */ /* synthetic */ Object argsFrom(SavedStateHandle savedStateHandle) {
        m3034argsFrom(savedStateHandle);
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(Unit unit) {
        return DirectionDestinationSpec.DefaultImpls.invoke(this, unit);
    }

    /* renamed from: argsFrom, reason: collision with other method in class */
    public void m3033argsFrom(Bundle bundle) {
        DirectionDestinationSpec.DefaultImpls.argsFrom(this, bundle);
    }

    /* renamed from: argsFrom, reason: collision with other method in class */
    public void m3034argsFrom(SavedStateHandle savedStateHandle) {
        DirectionDestinationSpec.DefaultImpls.argsFrom(this, savedStateHandle);
    }
}
