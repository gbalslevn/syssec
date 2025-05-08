package com.ramcosta.composedestinations.generated.destinations;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInPassengerCreateScreenDestination;
import com.ramcosta.composedestinations.generated.navtype.EnumCustomNavTypesKt;
import com.ramcosta.composedestinations.generated.navtype.LocaleNavType;
import com.ramcosta.composedestinations.generated.navtype.LocaleNavTypeKt;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsBooleanNavTypeKt;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsEnumNavType;
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
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.screens.booking.passengers.create.EarlyCheckInPassengerCreateScreenKt;
import dk.molslinjen.ui.views.screens.booking.passengers.create.EarlyCheckInPassengerCreateScreenNavArgs;
import dk.molslinjen.ui.views.screens.booking.passengers.create.EarlyCheckInPassengerCreateViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002J\u0017\u0010\u0018\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00030\u001aH\u0017¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H\u0016J\t\u0010!\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/EarlyCheckInPassengerCreateScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Ldk/molslinjen/ui/views/screens/booking/passengers/create/EarlyCheckInPassengerCreateScreenNavArgs;", "<init>", "()V", "invoke", "Lcom/ramcosta/composedestinations/spec/Direction;", "navArgs", "selectAfterCreation", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/domain/model/config/Site;", "baseRoute", BuildConfig.FLAVOR, "getBaseRoute", "()Ljava/lang/String;", "route", "getRoute", "arguments", BuildConfig.FLAVOR, "Landroidx/navigation/NamedNavArgument;", "getArguments", "()Ljava/util/List;", "Content", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", "argsFrom", "bundle", "Landroid/os/Bundle;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class EarlyCheckInPassengerCreateScreenDestination extends BaseRoute implements TypedDestinationSpec<EarlyCheckInPassengerCreateScreenNavArgs> {
    public static final EarlyCheckInPassengerCreateScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;

    static {
        EarlyCheckInPassengerCreateScreenDestination earlyCheckInPassengerCreateScreenDestination = new EarlyCheckInPassengerCreateScreenDestination();
        INSTANCE = earlyCheckInPassengerCreateScreenDestination;
        baseRoute = "early_check_in_passenger_create_screen";
        route = earlyCheckInPassengerCreateScreenDestination.getBaseRoute() + "/{selectAfterCreation}/{site}";
    }

    private EarlyCheckInPassengerCreateScreenDestination() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$1(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(DestinationsBooleanNavTypeKt.getBooleanNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$2(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(EnumCustomNavTypesKt.getSiteEnumNavType());
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(DestinationScope<EarlyCheckInPassengerCreateScreenNavArgs> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(775517427);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(775517427, i5, -1, "com.ramcosta.composedestinations.generated.destinations.EarlyCheckInPassengerCreateScreenDestination.Content (EarlyCheckInPassengerCreateScreenDestination.kt:58)");
        }
        EarlyCheckInPassengerCreateViewModel earlyCheckInPassengerCreateViewModel = (EarlyCheckInPassengerCreateViewModel) ((DestinationDependenciesContainerImpl) destinationScope.buildDependencies(composer, i5 & 14)).require(Reflection.getOrCreateKotlinClass(EarlyCheckInPassengerCreateViewModel.class), false);
        DestinationsNavigator destinationsNavigator = destinationScope.getDestinationsNavigator();
        LocaleNavType localeNavType = LocaleNavTypeKt.getLocaleNavType();
        composer.startReplaceGroup(1363506722);
        ResultRecipient resultRecipient = ResultCommonsKt.resultRecipient(destinationScope.getNavBackStackEntry(), Reflection.getOrCreateKotlinClass(NationalitySelectionScreenDestination.class), localeNavType, composer, 0);
        composer.endReplaceGroup();
        EarlyCheckInPassengerCreateScreenKt.EarlyCheckInPassengerCreateScreen(earlyCheckInPassengerCreateViewModel, destinationsNavigator, resultRecipient, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return CollectionsKt.listOf((Object[]) new NamedNavArgument[]{NamedNavArgumentKt.navArgument("selectAfterCreation", new Function1() { // from class: f1.G
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$1;
                _get_arguments_$lambda$1 = EarlyCheckInPassengerCreateScreenDestination._get_arguments_$lambda$1((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$1;
            }
        }), NamedNavArgumentKt.navArgument("site", new Function1() { // from class: f1.H
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$2;
                _get_arguments_$lambda$2 = EarlyCheckInPassengerCreateScreenDestination._get_arguments_$lambda$2((NavArgumentBuilder) obj);
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
        return TypedDestinationSpec.DefaultImpls.getStyle(this);
    }

    public String toString() {
        return "EarlyCheckInPassengerCreateScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(EarlyCheckInPassengerCreateScreenNavArgs navArgs) {
        Intrinsics.checkNotNullParameter(navArgs, "navArgs");
        return INSTANCE.invoke(navArgs.getSelectAfterCreation(), navArgs.getSite());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public EarlyCheckInPassengerCreateScreenNavArgs argsFrom(Bundle bundle) {
        Boolean safeGet = DestinationsBooleanNavTypeKt.getBooleanNavType().safeGet(bundle, "selectAfterCreation");
        if (safeGet != null) {
            boolean booleanValue = safeGet.booleanValue();
            Site site = (Site) EnumCustomNavTypesKt.getSiteEnumNavType().safeGet(bundle, "site");
            if (site != null) {
                return new EarlyCheckInPassengerCreateScreenNavArgs(booleanValue, site);
            }
            throw new RuntimeException("'site' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'selectAfterCreation' argument is mandatory, but was not present!");
    }

    public final Direction invoke(boolean selectAfterCreation, Site site) {
        Intrinsics.checkNotNullParameter(site, "site");
        return DirectionKt.Direction(getBaseRoute() + "/" + DestinationsBooleanNavTypeKt.getBooleanNavType().serializeValue(Boolean.valueOf(selectAfterCreation)) + "/" + EnumCustomNavTypesKt.getSiteEnumNavType().serializeValue((DestinationsEnumNavType<Site>) site));
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public EarlyCheckInPassengerCreateScreenNavArgs argsFrom(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Boolean bool = DestinationsBooleanNavTypeKt.getBooleanNavType().get(savedStateHandle, "selectAfterCreation");
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            Site site = EnumCustomNavTypesKt.getSiteEnumNavType().get(savedStateHandle, "site");
            if (site != null) {
                return new EarlyCheckInPassengerCreateScreenNavArgs(booleanValue, site);
            }
            throw new RuntimeException("'site' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'selectAfterCreation' argument is mandatory, but was not present!");
    }
}
