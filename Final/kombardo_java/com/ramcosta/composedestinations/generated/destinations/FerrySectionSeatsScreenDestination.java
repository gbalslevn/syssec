package com.ramcosta.composedestinations.generated.destinations;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.bottomsheet.spec.DestinationStyleBottomSheet;
import com.ramcosta.composedestinations.generated.destinations.FerrySectionSeatsScreenDestination;
import com.ramcosta.composedestinations.generated.navtype.EnumCustomNavTypesKt;
import com.ramcosta.composedestinations.generated.navtype.FerrySeatingSectionIdNavTypeKt;
import com.ramcosta.composedestinations.generated.navtype.OffsetNavTypeKt;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsEnumNavType;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainerImpl;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.spec.BaseRoute;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.DirectionKt;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsScreenKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsScreenNavArgs;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeatingSectionId;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002J,\u0010\u0006\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0086\u0002¢\u0006\u0002\b\u000fJ\u0017\u0010\u001f\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u00030!H\u0017¢\u0006\u0002\u0010\"J\u0012\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H\u0016J\t\u0010(\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006)"}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/FerrySectionSeatsScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsScreenNavArgs;", "<init>", "()V", "invoke", "Lcom/ramcosta/composedestinations/spec/Direction;", "navArgs", "sectionId", "Luniffi/molslinjen_shared/FerrySeatingSectionId;", "direction", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "offset", "Landroidx/compose/ui/geometry/Offset;", "invoke-b0fnrdo", "baseRoute", BuildConfig.FLAVOR, "getBaseRoute", "()Ljava/lang/String;", "route", "getRoute", "arguments", BuildConfig.FLAVOR, "Landroidx/navigation/NamedNavArgument;", "getArguments", "()Ljava/util/List;", "style", "Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "getStyle", "()Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "Content", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", "argsFrom", "bundle", "Landroid/os/Bundle;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class FerrySectionSeatsScreenDestination extends BaseRoute implements TypedDestinationSpec<FerrySectionSeatsScreenNavArgs> {
    public static final int $stable;
    public static final FerrySectionSeatsScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;
    private static final DestinationStyle style;

    static {
        FerrySectionSeatsScreenDestination ferrySectionSeatsScreenDestination = new FerrySectionSeatsScreenDestination();
        INSTANCE = ferrySectionSeatsScreenDestination;
        baseRoute = "ferry_section_seats_screen";
        route = ferrySectionSeatsScreenDestination.getBaseRoute() + "/{direction}?sectionId={sectionId}&offset={offset}";
        style = DestinationStyleBottomSheet.INSTANCE;
        $stable = DestinationStyle.$stable;
    }

    private FerrySectionSeatsScreenDestination() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$1(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(FerrySeatingSectionIdNavTypeKt.getFerrySeatingSectionIdNavType());
        navArgument.setNullable(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$2(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(EnumCustomNavTypesKt.getDepartureDirectionEnumNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$3(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(OffsetNavTypeKt.getOffsetNavType());
        navArgument.setNullable(true);
        navArgument.setDefaultValue(null);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-b0fnrdo$default, reason: not valid java name */
    public static /* synthetic */ Direction m3070invokeb0fnrdo$default(FerrySectionSeatsScreenDestination ferrySectionSeatsScreenDestination, FerrySeatingSectionId ferrySeatingSectionId, DepartureDirection departureDirection, Offset offset, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            offset = null;
        }
        return ferrySectionSeatsScreenDestination.m3071invokeb0fnrdo(ferrySeatingSectionId, departureDirection, offset);
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(DestinationScope<FerrySectionSeatsScreenNavArgs> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(-1544361759);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1544361759, i5, -1, "com.ramcosta.composedestinations.generated.destinations.FerrySectionSeatsScreenDestination.Content (FerrySectionSeatsScreenDestination.kt:70)");
        }
        DestinationDependenciesContainerImpl destinationDependenciesContainerImpl = (DestinationDependenciesContainerImpl) destinationScope.buildDependencies(composer, i5 & 14);
        FerrySectionSeatsScreenKt.FerrySectionSeatsScreen((FerrySectionSeatsViewModel) destinationDependenciesContainerImpl.require(Reflection.getOrCreateKotlinClass(FerrySectionSeatsViewModel.class), false), destinationScope.getDestinationsNavigator(), destinationScope.getNavController(), destinationScope.getNavBackStackEntry(), (BottomSheetDismissHandler) destinationDependenciesContainerImpl.require(Reflection.getOrCreateKotlinClass(BottomSheetDismissHandler.class), false), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return CollectionsKt.listOf((Object[]) new NamedNavArgument[]{NamedNavArgumentKt.navArgument("sectionId", new Function1() { // from class: f1.Q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$1;
                _get_arguments_$lambda$1 = FerrySectionSeatsScreenDestination._get_arguments_$lambda$1((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$1;
            }
        }), NamedNavArgumentKt.navArgument("direction", new Function1() { // from class: f1.S
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$2;
                _get_arguments_$lambda$2 = FerrySectionSeatsScreenDestination._get_arguments_$lambda$2((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$2;
            }
        }), NamedNavArgumentKt.navArgument("offset", new Function1() { // from class: f1.T
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$3;
                _get_arguments_$lambda$3 = FerrySectionSeatsScreenDestination._get_arguments_$lambda$3((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$3;
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

    /* renamed from: invoke-b0fnrdo, reason: not valid java name */
    public final Direction m3071invokeb0fnrdo(FerrySeatingSectionId sectionId, DepartureDirection direction, Offset offset) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        return DirectionKt.Direction(getBaseRoute() + "/" + EnumCustomNavTypesKt.getDepartureDirectionEnumNavType().serializeValue((DestinationsEnumNavType<DepartureDirection>) direction) + "?sectionId=" + FerrySeatingSectionIdNavTypeKt.getFerrySeatingSectionIdNavType().serializeValue(sectionId) + "&offset=" + OffsetNavTypeKt.getOffsetNavType().serializeValue(offset));
    }

    public String toString() {
        return "FerrySectionSeatsScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(FerrySectionSeatsScreenNavArgs navArgs) {
        Intrinsics.checkNotNullParameter(navArgs, "navArgs");
        return INSTANCE.m3071invokeb0fnrdo(navArgs.getSectionId(), navArgs.getDirection(), navArgs.getOffset());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public FerrySectionSeatsScreenNavArgs argsFrom(Bundle bundle) {
        FerrySeatingSectionId safeGet = FerrySeatingSectionIdNavTypeKt.getFerrySeatingSectionIdNavType().safeGet(bundle, "sectionId");
        DepartureDirection departureDirection = (DepartureDirection) EnumCustomNavTypesKt.getDepartureDirectionEnumNavType().safeGet(bundle, "direction");
        if (departureDirection != null) {
            return new FerrySectionSeatsScreenNavArgs(safeGet, departureDirection, OffsetNavTypeKt.getOffsetNavType().safeGet(bundle, "offset"), null);
        }
        throw new RuntimeException("'direction' argument is mandatory, but was not present!");
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public FerrySectionSeatsScreenNavArgs argsFrom(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        FerrySeatingSectionId ferrySeatingSectionId = FerrySeatingSectionIdNavTypeKt.getFerrySeatingSectionIdNavType().get(savedStateHandle, "sectionId");
        DepartureDirection departureDirection = EnumCustomNavTypesKt.getDepartureDirectionEnumNavType().get(savedStateHandle, "direction");
        if (departureDirection != null) {
            return new FerrySectionSeatsScreenNavArgs(ferrySeatingSectionId, departureDirection, OffsetNavTypeKt.getOffsetNavType().get(savedStateHandle, "offset"), null);
        }
        throw new RuntimeException("'direction' argument is mandatory, but was not present!");
    }
}
