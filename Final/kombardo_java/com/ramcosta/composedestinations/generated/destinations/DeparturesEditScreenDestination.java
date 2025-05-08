package com.ramcosta.composedestinations.generated.destinations;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.generated.destinations.DeparturesEditScreenDestination;
import com.ramcosta.composedestinations.generated.navtype.LocalDateNavType;
import com.ramcosta.composedestinations.generated.navtype.LocalDateNavTypeKt;
import com.ramcosta.composedestinations.generated.navtype.UUIDNavType;
import com.ramcosta.composedestinations.generated.navtype.UUIDNavTypeKt;
import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsBooleanNavTypeKt;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainer;
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
import com.ramcosta.composedestinations.wrapper.DestinationWrapperKt;
import dk.molslinjen.ui.views.global.navigation.wrappers.EditFlowStickyTopBarWrapper;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesEditScreenKt;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesScreenNavArgs;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel;
import dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.ICheckoutExpirationDialogHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0086\u0002J\u0017\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0017¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\t\u0010\u001f\u001a\u00020\fHÖ\u0001R\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/DeparturesEditScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Ldk/molslinjen/ui/views/screens/booking/departures/DeparturesScreenNavArgs;", "<init>", "()V", "invoke", "Lcom/ramcosta/composedestinations/spec/Direction;", "navArgs", "isAddingReturnFromBookingSummary", BuildConfig.FLAVOR, "baseRoute", BuildConfig.FLAVOR, "getBaseRoute", "()Ljava/lang/String;", "route", "getRoute", "arguments", BuildConfig.FLAVOR, "Landroidx/navigation/NamedNavArgument;", "getArguments", "()Ljava/util/List;", "Content", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", "argsFrom", "bundle", "Landroid/os/Bundle;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DeparturesEditScreenDestination extends BaseRoute implements TypedDestinationSpec<DeparturesScreenNavArgs> {
    public static final DeparturesEditScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;

    static {
        DeparturesEditScreenDestination departuresEditScreenDestination = new DeparturesEditScreenDestination();
        INSTANCE = departuresEditScreenDestination;
        baseRoute = "departures_edit_screen";
        route = departuresEditScreenDestination.getBaseRoute() + "?isAddingReturnFromBookingSummary={isAddingReturnFromBookingSummary}";
    }

    private DeparturesEditScreenDestination() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$1(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(DestinationsBooleanNavTypeKt.getBooleanNavType());
        navArgument.setDefaultValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Direction invoke$default(DeparturesEditScreenDestination departuresEditScreenDestination, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        return departuresEditScreenDestination.invoke(z5);
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(final DestinationScope<DeparturesScreenNavArgs> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(-144089233);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-144089233, i5, -1, "com.ramcosta.composedestinations.generated.destinations.DeparturesEditScreenDestination.Content (DeparturesEditScreenDestination.kt:56)");
        }
        int i6 = i5 & 14;
        final DestinationDependenciesContainer buildDependencies = destinationScope.buildDependencies(composer, i6);
        DestinationWrapperKt.Wrap(destinationScope, EditFlowStickyTopBarWrapper.INSTANCE, ComposableLambdaKt.rememberComposableLambda(-1591162409, true, new Function2<Composer, Integer, Unit>() { // from class: com.ramcosta.composedestinations.generated.destinations.DeparturesEditScreenDestination$Content$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i7) {
                if ((i7 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1591162409, i7, -1, "com.ramcosta.composedestinations.generated.destinations.DeparturesEditScreenDestination.Content.<anonymous> (DeparturesEditScreenDestination.kt:59)");
                }
                DeparturesViewModel departuresViewModel = (DeparturesViewModel) ((DestinationDependenciesContainerImpl) DestinationDependenciesContainer.this).require(Reflection.getOrCreateKotlinClass(DeparturesViewModel.class), false);
                DestinationsNavigator destinationsNavigator = destinationScope.getDestinationsNavigator();
                DestinationScope<DeparturesScreenNavArgs> destinationScope2 = destinationScope;
                LocalDateNavType localDateNavType = LocalDateNavTypeKt.getLocalDateNavType();
                composer2.startReplaceGroup(1363506722);
                ResultRecipient resultRecipient = ResultCommonsKt.resultRecipient(destinationScope2.getNavBackStackEntry(), Reflection.getOrCreateKotlinClass(CalendarScreenDestination.class), localDateNavType, composer2, 0);
                composer2.endReplaceGroup();
                DestinationScope<DeparturesScreenNavArgs> destinationScope3 = destinationScope;
                DestinationsNavType<Boolean> booleanNavType = DestinationsBooleanNavTypeKt.getBooleanNavType();
                int i8 = DestinationsNavType.$stable;
                composer2.startReplaceGroup(1363506722);
                ResultRecipient resultRecipient2 = ResultCommonsKt.resultRecipient(destinationScope3.getNavBackStackEntry(), Reflection.getOrCreateKotlinClass(TransportationSelectorScreenDestination.class), booleanNavType, composer2, (i8 << 6) & 896);
                composer2.endReplaceGroup();
                DestinationScope<DeparturesScreenNavArgs> destinationScope4 = destinationScope;
                UUIDNavType uUIDNavType = UUIDNavTypeKt.getUUIDNavType();
                composer2.startReplaceGroup(1363506722);
                ResultRecipient resultRecipient3 = ResultCommonsKt.resultRecipient(destinationScope4.getNavBackStackEntry(), Reflection.getOrCreateKotlinClass(TicketTypeScreenDestination.class), uUIDNavType, composer2, 0);
                composer2.endReplaceGroup();
                DeparturesEditScreenKt.DeparturesEditScreen(departuresViewModel, destinationsNavigator, resultRecipient, resultRecipient2, resultRecipient3, (ICheckoutExpirationDialogHandler) ((DestinationDependenciesContainerImpl) DestinationDependenciesContainer.this).require(Reflection.getOrCreateKotlinClass(ICheckoutExpirationDialogHandler.class), false), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, i6 | 432);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return CollectionsKt.listOf(NamedNavArgumentKt.navArgument("isAddingReturnFromBookingSummary", new Function1() { // from class: f1.C
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$1;
                _get_arguments_$lambda$1 = DeparturesEditScreenDestination._get_arguments_$lambda$1((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$1;
            }
        }));
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
        return "DeparturesEditScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(DeparturesScreenNavArgs navArgs) {
        Intrinsics.checkNotNullParameter(navArgs, "navArgs");
        return INSTANCE.invoke(navArgs.getIsAddingReturnFromBookingSummary());
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public DeparturesScreenNavArgs argsFrom(Bundle bundle) {
        Boolean safeGet = DestinationsBooleanNavTypeKt.getBooleanNavType().safeGet(bundle, "isAddingReturnFromBookingSummary");
        if (safeGet != null) {
            return new DeparturesScreenNavArgs(safeGet.booleanValue());
        }
        throw new RuntimeException("'isAddingReturnFromBookingSummary' argument is not mandatory and not nullable but was not present!");
    }

    public final Direction invoke(boolean isAddingReturnFromBookingSummary) {
        return DirectionKt.Direction(getBaseRoute() + "?isAddingReturnFromBookingSummary=" + DestinationsBooleanNavTypeKt.getBooleanNavType().serializeValue(Boolean.valueOf(isAddingReturnFromBookingSummary)));
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public DeparturesScreenNavArgs argsFrom(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Boolean bool = DestinationsBooleanNavTypeKt.getBooleanNavType().get(savedStateHandle, "isAddingReturnFromBookingSummary");
        if (bool != null) {
            return new DeparturesScreenNavArgs(bool.booleanValue());
        }
        throw new RuntimeException("'isAddingReturnFromBookingSummary' argument is not mandatory and not nullable but was not present!");
    }
}
