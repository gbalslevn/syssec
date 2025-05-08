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
import com.ramcosta.composedestinations.generated.destinations.MultiRideRefillScreenDestination;
import com.ramcosta.composedestinations.generated.navtype.EnumCustomNavTypesKt;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsEnumNavType;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsStringNavTypeKt;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainerImpl;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.spec.BaseRoute;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.DirectionKt;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.ui.views.screens.agreements.multiride.refill.MultiRideRefillNavArgs;
import dk.molslinjen.ui.views.screens.agreements.multiride.refill.MultiRideRefillScreenKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.refill.MultiRideRefillViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002J!\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\u001e*\b\u0012\u0004\u0012\u00020\u00030\u001fH\u0017¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%H\u0016J\t\u0010&\u001a\u00020\nHÖ\u0001R\u0014\u0010\u000f\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006'"}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/MultiRideRefillScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Ldk/molslinjen/ui/views/screens/agreements/multiride/refill/MultiRideRefillNavArgs;", "<init>", "()V", "invoke", "Lcom/ramcosta/composedestinations/spec/Direction;", "navArgs", "multiRideId", BuildConfig.FLAVOR, "paymentOrigin", "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "site", "Ldk/molslinjen/domain/model/config/Site;", "baseRoute", "getBaseRoute", "()Ljava/lang/String;", "route", "getRoute", "arguments", BuildConfig.FLAVOR, "Landroidx/navigation/NamedNavArgument;", "getArguments", "()Ljava/util/List;", "style", "Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "getStyle", "()Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "Content", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", "argsFrom", "bundle", "Landroid/os/Bundle;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MultiRideRefillScreenDestination extends BaseRoute implements TypedDestinationSpec<MultiRideRefillNavArgs> {
    public static final int $stable;
    public static final MultiRideRefillScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;
    private static final DestinationStyle style;

    static {
        MultiRideRefillScreenDestination multiRideRefillScreenDestination = new MultiRideRefillScreenDestination();
        INSTANCE = multiRideRefillScreenDestination;
        baseRoute = "multi_ride_refill_screen";
        route = multiRideRefillScreenDestination.getBaseRoute() + "/{multiRideId}/{paymentOrigin}/{site}";
        style = DestinationStyleBottomSheet.INSTANCE;
        $stable = DestinationStyle.$stable;
    }

    private MultiRideRefillScreenDestination() {
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
        navArgument.setType(EnumCustomNavTypesKt.getPaymentOriginEnumNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$3(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(EnumCustomNavTypesKt.getSiteEnumNavType());
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(DestinationScope<MultiRideRefillNavArgs> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(666717737);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(666717737, i5, -1, "com.ramcosta.composedestinations.generated.destinations.MultiRideRefillScreenDestination.Content (MultiRideRefillScreenDestination.kt:66)");
        }
        MultiRideRefillScreenKt.MultiRideRefillScreen((MultiRideRefillViewModel) ((DestinationDependenciesContainerImpl) destinationScope.buildDependencies(composer, i5 & 14)).require(Reflection.getOrCreateKotlinClass(MultiRideRefillViewModel.class), false), destinationScope.getDestinationsNavigator(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return CollectionsKt.listOf((Object[]) new NamedNavArgument[]{NamedNavArgumentKt.navArgument("multiRideId", new Function1() { // from class: f1.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$1;
                _get_arguments_$lambda$1 = MultiRideRefillScreenDestination._get_arguments_$lambda$1((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$1;
            }
        }), NamedNavArgumentKt.navArgument("paymentOrigin", new Function1() { // from class: f1.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$2;
                _get_arguments_$lambda$2 = MultiRideRefillScreenDestination._get_arguments_$lambda$2((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$2;
            }
        }), NamedNavArgumentKt.navArgument("site", new Function1() { // from class: f1.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$3;
                _get_arguments_$lambda$3 = MultiRideRefillScreenDestination._get_arguments_$lambda$3((NavArgumentBuilder) obj);
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
        return "MultiRideRefillScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(MultiRideRefillNavArgs navArgs) {
        Intrinsics.checkNotNullParameter(navArgs, "navArgs");
        return INSTANCE.invoke(navArgs.getMultiRideId(), navArgs.getPaymentOrigin(), navArgs.getSite());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public MultiRideRefillNavArgs argsFrom(Bundle bundle) {
        String safeGet = DestinationsStringNavTypeKt.getStringNavType().safeGet(bundle, "multiRideId");
        if (safeGet != null) {
            PaymentOrigin paymentOrigin = (PaymentOrigin) EnumCustomNavTypesKt.getPaymentOriginEnumNavType().safeGet(bundle, "paymentOrigin");
            if (paymentOrigin != null) {
                Site site = (Site) EnumCustomNavTypesKt.getSiteEnumNavType().safeGet(bundle, "site");
                if (site != null) {
                    return new MultiRideRefillNavArgs(safeGet, paymentOrigin, site);
                }
                throw new RuntimeException("'site' argument is mandatory, but was not present!");
            }
            throw new RuntimeException("'paymentOrigin' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'multiRideId' argument is mandatory, but was not present!");
    }

    public final Direction invoke(String multiRideId, PaymentOrigin paymentOrigin, Site site) {
        Intrinsics.checkNotNullParameter(multiRideId, "multiRideId");
        Intrinsics.checkNotNullParameter(paymentOrigin, "paymentOrigin");
        Intrinsics.checkNotNullParameter(site, "site");
        return DirectionKt.Direction(getBaseRoute() + "/" + DestinationsStringNavTypeKt.getStringNavType().serializeValue("multiRideId", multiRideId) + "/" + EnumCustomNavTypesKt.getPaymentOriginEnumNavType().serializeValue((DestinationsEnumNavType<PaymentOrigin>) paymentOrigin) + "/" + EnumCustomNavTypesKt.getSiteEnumNavType().serializeValue((DestinationsEnumNavType<Site>) site));
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public MultiRideRefillNavArgs argsFrom(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        String str = DestinationsStringNavTypeKt.getStringNavType().get(savedStateHandle, "multiRideId");
        if (str != null) {
            PaymentOrigin paymentOrigin = EnumCustomNavTypesKt.getPaymentOriginEnumNavType().get(savedStateHandle, "paymentOrigin");
            if (paymentOrigin != null) {
                Site site = EnumCustomNavTypesKt.getSiteEnumNavType().get(savedStateHandle, "site");
                if (site != null) {
                    return new MultiRideRefillNavArgs(str, paymentOrigin, site);
                }
                throw new RuntimeException("'site' argument is mandatory, but was not present!");
            }
            throw new RuntimeException("'paymentOrigin' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'multiRideId' argument is mandatory, but was not present!");
    }
}
