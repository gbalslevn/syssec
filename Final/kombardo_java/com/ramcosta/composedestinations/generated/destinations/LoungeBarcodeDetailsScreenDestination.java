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
import com.ramcosta.composedestinations.generated.destinations.LoungeBarcodeDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.navtype.LocalDateTimeNavTypeKt;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsIntNavTypeKt;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsStringNavTypeKt;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainerImpl;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.spec.BaseRoute;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.DirectionKt;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.LoungeBarcodeDetailsScreenKt;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.LoungeBarcodeDetailsScreenNavArgs;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.LoungeBarcodeDetailsViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002J!\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\u001e*\b\u0012\u0004\u0012\u00020\u00030\u001fH\u0017¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%H\u0016J\t\u0010&\u001a\u00020\nHÖ\u0001R\u0014\u0010\u000f\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006'"}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/LoungeBarcodeDetailsScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/LoungeBarcodeDetailsScreenNavArgs;", "<init>", "()V", "invoke", "Lcom/ramcosta/composedestinations/spec/Direction;", "navArgs", "barcode", BuildConfig.FLAVOR, "persons", BuildConfig.FLAVOR, "departureTime", "Lorg/threeten/bp/LocalDateTime;", "baseRoute", "getBaseRoute", "()Ljava/lang/String;", "route", "getRoute", "arguments", BuildConfig.FLAVOR, "Landroidx/navigation/NamedNavArgument;", "getArguments", "()Ljava/util/List;", "style", "Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "getStyle", "()Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "Content", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", "argsFrom", "bundle", "Landroid/os/Bundle;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class LoungeBarcodeDetailsScreenDestination extends BaseRoute implements TypedDestinationSpec<LoungeBarcodeDetailsScreenNavArgs> {
    public static final int $stable;
    public static final LoungeBarcodeDetailsScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;
    private static final DestinationStyle style;

    static {
        LoungeBarcodeDetailsScreenDestination loungeBarcodeDetailsScreenDestination = new LoungeBarcodeDetailsScreenDestination();
        INSTANCE = loungeBarcodeDetailsScreenDestination;
        baseRoute = "lounge_barcode_details_screen";
        route = loungeBarcodeDetailsScreenDestination.getBaseRoute() + "/{barcode}/{persons}/{departureTime}";
        style = DestinationStyleBottomSheet.INSTANCE;
        $stable = DestinationStyle.$stable;
    }

    private LoungeBarcodeDetailsScreenDestination() {
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
        navArgument.setType(DestinationsIntNavTypeKt.getIntNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$3(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(LocalDateTimeNavTypeKt.getLocalDateTimeNavType());
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(DestinationScope<LoungeBarcodeDetailsScreenNavArgs> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(-682707121);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-682707121, i5, -1, "com.ramcosta.composedestinations.generated.destinations.LoungeBarcodeDetailsScreenDestination.Content (LoungeBarcodeDetailsScreenDestination.kt:65)");
        }
        LoungeBarcodeDetailsScreenKt.LoungeBarcodeDetailsScreen((LoungeBarcodeDetailsViewModel) ((DestinationDependenciesContainerImpl) destinationScope.buildDependencies(composer, i5 & 14)).require(Reflection.getOrCreateKotlinClass(LoungeBarcodeDetailsViewModel.class), false), destinationScope.getDestinationsNavigator(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return CollectionsKt.listOf((Object[]) new NamedNavArgument[]{NamedNavArgumentKt.navArgument("barcode", new Function1() { // from class: f1.W
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$1;
                _get_arguments_$lambda$1 = LoungeBarcodeDetailsScreenDestination._get_arguments_$lambda$1((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$1;
            }
        }), NamedNavArgumentKt.navArgument("persons", new Function1() { // from class: f1.X
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$2;
                _get_arguments_$lambda$2 = LoungeBarcodeDetailsScreenDestination._get_arguments_$lambda$2((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$2;
            }
        }), NamedNavArgumentKt.navArgument("departureTime", new Function1() { // from class: f1.Y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$3;
                _get_arguments_$lambda$3 = LoungeBarcodeDetailsScreenDestination._get_arguments_$lambda$3((NavArgumentBuilder) obj);
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

    public String toString() {
        return "LoungeBarcodeDetailsScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(LoungeBarcodeDetailsScreenNavArgs navArgs) {
        Intrinsics.checkNotNullParameter(navArgs, "navArgs");
        return INSTANCE.invoke(navArgs.getBarcode(), navArgs.getPersons(), navArgs.getDepartureTime());
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public LoungeBarcodeDetailsScreenNavArgs argsFrom(Bundle bundle) {
        String safeGet = DestinationsStringNavTypeKt.getStringNavType().safeGet(bundle, "barcode");
        if (safeGet != null) {
            Integer safeGet2 = DestinationsIntNavTypeKt.getIntNavType().safeGet(bundle, "persons");
            if (safeGet2 != null) {
                int intValue = safeGet2.intValue();
                LocalDateTime safeGet3 = LocalDateTimeNavTypeKt.getLocalDateTimeNavType().safeGet(bundle, "departureTime");
                if (safeGet3 != null) {
                    return new LoungeBarcodeDetailsScreenNavArgs(safeGet, intValue, safeGet3);
                }
                throw new RuntimeException("'departureTime' argument is mandatory, but was not present!");
            }
            throw new RuntimeException("'persons' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'barcode' argument is mandatory, but was not present!");
    }

    public final Direction invoke(String barcode, int persons, LocalDateTime departureTime) {
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        return DirectionKt.Direction(getBaseRoute() + "/" + DestinationsStringNavTypeKt.getStringNavType().serializeValue("barcode", barcode) + "/" + DestinationsIntNavTypeKt.getIntNavType().serializeValue(Integer.valueOf(persons)) + "/" + LocalDateTimeNavTypeKt.getLocalDateTimeNavType().serializeValue(departureTime));
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public LoungeBarcodeDetailsScreenNavArgs argsFrom(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        String str = DestinationsStringNavTypeKt.getStringNavType().get(savedStateHandle, "barcode");
        if (str != null) {
            Integer num = DestinationsIntNavTypeKt.getIntNavType().get(savedStateHandle, "persons");
            if (num != null) {
                int intValue = num.intValue();
                LocalDateTime localDateTime = LocalDateTimeNavTypeKt.getLocalDateTimeNavType().get(savedStateHandle, "departureTime");
                if (localDateTime != null) {
                    return new LoungeBarcodeDetailsScreenNavArgs(str, intValue, localDateTime);
                }
                throw new RuntimeException("'departureTime' argument is mandatory, but was not present!");
            }
            throw new RuntimeException("'persons' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'barcode' argument is mandatory, but was not present!");
    }
}
