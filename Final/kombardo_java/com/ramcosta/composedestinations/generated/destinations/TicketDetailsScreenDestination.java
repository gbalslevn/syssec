package com.ramcosta.composedestinations.generated.destinations;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.generated.destinations.TicketDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.navtype.EnumCustomNavTypesKt;
import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsBooleanNavTypeKt;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsEnumNavType;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsStringNavTypeKt;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainerImpl;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultCommonsKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.spec.BaseRoute;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.DirectionKt;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsScreenKt;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsScreenNavArgs;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002J)\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\u0002J\u0017\u0010\u001a\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0017¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u0016J\t\u0010#\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0010\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/TicketDetailsScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Ldk/molslinjen/ui/views/screens/tickets/details/TicketDetailsScreenNavArgs;", "<init>", "()V", "invoke", "Lcom/ramcosta/composedestinations/spec/Direction;", "navArgs", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "phone", "site", "Ldk/molslinjen/domain/model/config/Site;", "isHistory", BuildConfig.FLAVOR, "baseRoute", "getBaseRoute", "()Ljava/lang/String;", "route", "getRoute", "arguments", BuildConfig.FLAVOR, "Landroidx/navigation/NamedNavArgument;", "getArguments", "()Ljava/util/List;", "Content", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", "argsFrom", "bundle", "Landroid/os/Bundle;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TicketDetailsScreenDestination extends BaseRoute implements TypedDestinationSpec<TicketDetailsScreenNavArgs> {
    public static final TicketDetailsScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;

    static {
        TicketDetailsScreenDestination ticketDetailsScreenDestination = new TicketDetailsScreenDestination();
        INSTANCE = ticketDetailsScreenDestination;
        baseRoute = "ticket_details_screen";
        route = ticketDetailsScreenDestination.getBaseRoute() + "/{id}/{phone}/{site}/{isHistory}";
    }

    private TicketDetailsScreenDestination() {
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
        navArgument.setType(DestinationsStringNavTypeKt.getStringNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$3(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(EnumCustomNavTypesKt.getSiteEnumNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$4(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(DestinationsBooleanNavTypeKt.getBooleanNavType());
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(DestinationScope<TicketDetailsScreenNavArgs> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(1436578503);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1436578503, i5, -1, "com.ramcosta.composedestinations.generated.destinations.TicketDetailsScreenDestination.Content (TicketDetailsScreenDestination.kt:68)");
        }
        int i6 = i5 & 14;
        TicketDetailsViewModel ticketDetailsViewModel = (TicketDetailsViewModel) ((DestinationDependenciesContainerImpl) destinationScope.buildDependencies(composer, i6)).require(Reflection.getOrCreateKotlinClass(TicketDetailsViewModel.class), false);
        DestinationsNavigator destinationsNavigator = destinationScope.getDestinationsNavigator();
        DestinationsNavType<Boolean> booleanNavType = DestinationsBooleanNavTypeKt.getBooleanNavType();
        int i7 = DestinationsNavType.$stable;
        composer.startReplaceGroup(1363506722);
        ResultRecipient resultRecipient = ResultCommonsKt.resultRecipient(destinationScope.getNavBackStackEntry(), Reflection.getOrCreateKotlinClass(EarlyCheckInProcessingScreenDestination.class), booleanNavType, composer, (((i7 << 3) | i6) << 3) & 896);
        composer.endReplaceGroup();
        DestinationsNavType<Boolean> booleanNavType2 = DestinationsBooleanNavTypeKt.getBooleanNavType();
        composer.startReplaceGroup(1363506722);
        ResultRecipient resultRecipient2 = ResultCommonsKt.resultRecipient(destinationScope.getNavBackStackEntry(), Reflection.getOrCreateKotlinClass(SimpleChangeReceiptScreenDestination.class), booleanNavType2, composer, (((i7 << 3) | i6) << 3) & 896);
        composer.endReplaceGroup();
        DestinationsNavType<Boolean> booleanNavType3 = DestinationsBooleanNavTypeKt.getBooleanNavType();
        composer.startReplaceGroup(1363506722);
        ResultRecipient resultRecipient3 = ResultCommonsKt.resultRecipient(destinationScope.getNavBackStackEntry(), Reflection.getOrCreateKotlinClass(ReceiptScreenDestination.class), booleanNavType3, composer, (((i7 << 3) | i6) << 3) & 896);
        composer.endReplaceGroup();
        composer.startReplaceGroup(1363506722);
        ResultRecipient resultRecipient4 = ResultCommonsKt.resultRecipient(destinationScope.getNavBackStackEntry(), Reflection.getOrCreateKotlinClass(RefundReceiptScreenDestination.class), DestinationsBooleanNavTypeKt.getBooleanNavType(), composer, ((i6 | (i7 << 3)) << 3) & 896);
        composer.endReplaceGroup();
        TicketDetailsScreenKt.TicketDetailsScreen(ticketDetailsViewModel, destinationsNavigator, resultRecipient, resultRecipient2, resultRecipient3, resultRecipient4, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return CollectionsKt.listOf((Object[]) new NamedNavArgument[]{NamedNavArgumentKt.navArgument(Constants.ID_ATTRIBUTE_KEY, new Function1() { // from class: f1.t0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$1;
                _get_arguments_$lambda$1 = TicketDetailsScreenDestination._get_arguments_$lambda$1((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$1;
            }
        }), NamedNavArgumentKt.navArgument("phone", new Function1() { // from class: f1.u0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$2;
                _get_arguments_$lambda$2 = TicketDetailsScreenDestination._get_arguments_$lambda$2((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$2;
            }
        }), NamedNavArgumentKt.navArgument("site", new Function1() { // from class: f1.v0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$3;
                _get_arguments_$lambda$3 = TicketDetailsScreenDestination._get_arguments_$lambda$3((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$3;
            }
        }), NamedNavArgumentKt.navArgument("isHistory", new Function1() { // from class: f1.w0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$4;
                _get_arguments_$lambda$4 = TicketDetailsScreenDestination._get_arguments_$lambda$4((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$4;
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
        return TypedDestinationSpec.DefaultImpls.getStyle(this);
    }

    public String toString() {
        return "TicketDetailsScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(TicketDetailsScreenNavArgs navArgs) {
        Intrinsics.checkNotNullParameter(navArgs, "navArgs");
        return INSTANCE.invoke(navArgs.getId(), navArgs.getPhone(), navArgs.getSite(), navArgs.getIsHistory());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public TicketDetailsScreenNavArgs argsFrom(Bundle bundle) {
        String safeGet = DestinationsStringNavTypeKt.getStringNavType().safeGet(bundle, Constants.ID_ATTRIBUTE_KEY);
        if (safeGet != null) {
            String safeGet2 = DestinationsStringNavTypeKt.getStringNavType().safeGet(bundle, "phone");
            if (safeGet2 != null) {
                Site site = (Site) EnumCustomNavTypesKt.getSiteEnumNavType().safeGet(bundle, "site");
                if (site != null) {
                    Boolean safeGet3 = DestinationsBooleanNavTypeKt.getBooleanNavType().safeGet(bundle, "isHistory");
                    if (safeGet3 != null) {
                        return new TicketDetailsScreenNavArgs(safeGet, safeGet2, site, safeGet3.booleanValue());
                    }
                    throw new RuntimeException("'isHistory' argument is mandatory, but was not present!");
                }
                throw new RuntimeException("'site' argument is mandatory, but was not present!");
            }
            throw new RuntimeException("'phone' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'id' argument is mandatory, but was not present!");
    }

    public final Direction invoke(String id, String phone, Site site, boolean isHistory) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(site, "site");
        return DirectionKt.Direction(getBaseRoute() + "/" + DestinationsStringNavTypeKt.getStringNavType().serializeValue(Constants.ID_ATTRIBUTE_KEY, id) + "/" + DestinationsStringNavTypeKt.getStringNavType().serializeValue("phone", phone) + "/" + EnumCustomNavTypesKt.getSiteEnumNavType().serializeValue((DestinationsEnumNavType<Site>) site) + "/" + DestinationsBooleanNavTypeKt.getBooleanNavType().serializeValue(Boolean.valueOf(isHistory)));
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public TicketDetailsScreenNavArgs argsFrom(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        String str = DestinationsStringNavTypeKt.getStringNavType().get(savedStateHandle, Constants.ID_ATTRIBUTE_KEY);
        if (str != null) {
            String str2 = DestinationsStringNavTypeKt.getStringNavType().get(savedStateHandle, "phone");
            if (str2 != null) {
                Site site = EnumCustomNavTypesKt.getSiteEnumNavType().get(savedStateHandle, "site");
                if (site != null) {
                    Boolean bool = DestinationsBooleanNavTypeKt.getBooleanNavType().get(savedStateHandle, "isHistory");
                    if (bool != null) {
                        return new TicketDetailsScreenNavArgs(str, str2, site, bool.booleanValue());
                    }
                    throw new RuntimeException("'isHistory' argument is mandatory, but was not present!");
                }
                throw new RuntimeException("'site' argument is mandatory, but was not present!");
            }
            throw new RuntimeException("'phone' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'id' argument is mandatory, but was not present!");
    }
}
