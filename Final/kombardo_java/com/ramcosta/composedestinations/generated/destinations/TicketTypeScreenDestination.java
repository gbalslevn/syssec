package com.ramcosta.composedestinations.generated.destinations;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.bottomsheet.spec.DestinationStyleBottomSheet;
import com.ramcosta.composedestinations.generated.destinations.TicketTypeScreenDestination;
import com.ramcosta.composedestinations.generated.navtype.EnumCustomNavTypesKt;
import com.ramcosta.composedestinations.generated.navtype.UUIDNavTypeKt;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsEnumNavType;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsStringNavTypeKt;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.scope.DestinationScopeKt;
import com.ramcosta.composedestinations.spec.BaseRoute;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.DirectionKt;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeScreenKt;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeScreenNavArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002J\u0017\u0010\u001b\u001a\u00020\u001c*\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0017¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0016J\t\u0010$\u001a\u00020\nHÖ\u0001R\u0014\u0010\r\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/TicketTypeScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeScreenNavArgs;", "<init>", "()V", "invoke", "Lcom/ramcosta/composedestinations/spec/Direction;", "navArgs", "departureId", BuildConfig.FLAVOR, "direction", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "baseRoute", "getBaseRoute", "()Ljava/lang/String;", "route", "getRoute", "arguments", BuildConfig.FLAVOR, "Landroidx/navigation/NamedNavArgument;", "getArguments", "()Ljava/util/List;", "style", "Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "getStyle", "()Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "Content", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", "argsFrom", "bundle", "Landroid/os/Bundle;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TicketTypeScreenDestination extends BaseRoute implements TypedDestinationSpec<TicketTypeScreenNavArgs> {
    public static final int $stable;
    public static final TicketTypeScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;
    private static final DestinationStyle style;

    static {
        TicketTypeScreenDestination ticketTypeScreenDestination = new TicketTypeScreenDestination();
        INSTANCE = ticketTypeScreenDestination;
        baseRoute = "ticket_type_screen";
        route = ticketTypeScreenDestination.getBaseRoute() + "/{departureId}/{direction}";
        style = DestinationStyleBottomSheet.INSTANCE;
        $stable = DestinationStyle.$stable;
    }

    private TicketTypeScreenDestination() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$1(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(DestinationsStringNavTypeKt.getStringNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$2(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(EnumCustomNavTypesKt.getDepartureDirectionEnumNavType());
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(DestinationScope<TicketTypeScreenNavArgs> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(345582863);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(345582863, i5, -1, "com.ramcosta.composedestinations.generated.destinations.TicketTypeScreenDestination.Content (TicketTypeScreenDestination.kt:61)");
        }
        TicketTypeScreenKt.TicketTypeScreen(destinationScope.getDestinationsNavigator(), DestinationScopeKt.resultBackNavigator(destinationScope, UUIDNavTypeKt.getUUIDNavType(), composer, i5 & 14), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return CollectionsKt.listOf((Object[]) new NamedNavArgument[]{NamedNavArgumentKt.navArgument("departureId", new Function1() { // from class: f1.x0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$1;
                _get_arguments_$lambda$1 = TicketTypeScreenDestination._get_arguments_$lambda$1((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$1;
            }
        }), NamedNavArgumentKt.navArgument("direction", new Function1() { // from class: f1.y0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$2;
                _get_arguments_$lambda$2 = TicketTypeScreenDestination._get_arguments_$lambda$2((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$2;
            }
        })});
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public String getBaseRoute() {
        return baseRoute;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NavDeepLink> getDeepLinks() {
        return TypedDestinationSpec.DefaultImpls.getDeepLinks(this);
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
        return "TicketTypeScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(TicketTypeScreenNavArgs navArgs) {
        Intrinsics.checkNotNullParameter(navArgs, "navArgs");
        return INSTANCE.invoke(navArgs.getDepartureId(), navArgs.getDirection());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public TicketTypeScreenNavArgs argsFrom(Bundle bundle) {
        String safeGet = DestinationsStringNavTypeKt.getStringNavType().safeGet(bundle, "departureId");
        if (safeGet != null) {
            DepartureDirection departureDirection = (DepartureDirection) EnumCustomNavTypesKt.getDepartureDirectionEnumNavType().safeGet(bundle, "direction");
            if (departureDirection != null) {
                return new TicketTypeScreenNavArgs(safeGet, departureDirection);
            }
            throw new RuntimeException("'direction' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'departureId' argument is mandatory, but was not present!");
    }

    public final Direction invoke(String departureId, DepartureDirection direction) {
        Intrinsics.checkNotNullParameter(departureId, "departureId");
        Intrinsics.checkNotNullParameter(direction, "direction");
        return DirectionKt.Direction(getBaseRoute() + "/" + DestinationsStringNavTypeKt.getStringNavType().serializeValue("departureId", departureId) + "/" + EnumCustomNavTypesKt.getDepartureDirectionEnumNavType().serializeValue((DestinationsEnumNavType<DepartureDirection>) direction));
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public TicketTypeScreenNavArgs argsFrom(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        String str = DestinationsStringNavTypeKt.getStringNavType().get(savedStateHandle, "departureId");
        if (str != null) {
            DepartureDirection departureDirection = EnumCustomNavTypesKt.getDepartureDirectionEnumNavType().get(savedStateHandle, "direction");
            if (departureDirection != null) {
                return new TicketTypeScreenNavArgs(str, departureDirection);
            }
            throw new RuntimeException("'direction' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'departureId' argument is mandatory, but was not present!");
    }
}
