package com.ramcosta.composedestinations.generated.destinations;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.generated.navtype.UserVehicleNavType;
import com.ramcosta.composedestinations.generated.navtype.UserVehicleNavTypeKt;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsStringNavType;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsStringNavTypeKt;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainer;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainerImpl;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultCommonsKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.spec.BaseRoute;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec;
import com.ramcosta.composedestinations.wrapper.DestinationWrapper;
import com.ramcosta.composedestinations.wrapper.DestinationWrapperKt;
import dk.molslinjen.ui.views.global.navigation.wrappers.CheckoutStickyTopBarWrapper;
import dk.molslinjen.ui.views.global.navigation.wrappers.CommuterFlowStickyTopBarWrapper;
import dk.molslinjen.ui.views.global.navigation.wrappers.EditFlowStickyTopBarWrapper;
import dk.molslinjen.ui.views.global.navigation.wrappers.MultiRideFlowStickyTopBarWrapper;
import dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryScreenKt;
import dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel;
import dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.ICheckoutExpirationDialogHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/BookingSummaryScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/DirectionDestinationSpec;", "<init>", "()V", "Lcom/ramcosta/composedestinations/scope/DestinationScope;", BuildConfig.FLAVOR, "Content", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "baseRoute", "Ljava/lang/String;", "getBaseRoute", "route", "getRoute", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BookingSummaryScreenDestination extends BaseRoute implements DirectionDestinationSpec {
    public static final BookingSummaryScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;

    static {
        BookingSummaryScreenDestination bookingSummaryScreenDestination = new BookingSummaryScreenDestination();
        INSTANCE = bookingSummaryScreenDestination;
        baseRoute = "booking_summary_screen";
        route = bookingSummaryScreenDestination.getBaseRoute();
    }

    private BookingSummaryScreenDestination() {
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(final DestinationScope<Unit> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(-1314530321);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1314530321, i5, -1, "com.ramcosta.composedestinations.generated.destinations.BookingSummaryScreenDestination.Content (BookingSummaryScreenDestination.kt:34)");
        }
        int i6 = i5 & 14;
        final DestinationDependenciesContainer buildDependencies = destinationScope.buildDependencies(composer, i6);
        DestinationWrapperKt.Wrap(destinationScope, new DestinationWrapper[]{CheckoutStickyTopBarWrapper.INSTANCE, EditFlowStickyTopBarWrapper.INSTANCE, MultiRideFlowStickyTopBarWrapper.INSTANCE, CommuterFlowStickyTopBarWrapper.INSTANCE}, ComposableLambdaKt.rememberComposableLambda(1533363799, true, new Function2<Composer, Integer, Unit>() { // from class: com.ramcosta.composedestinations.generated.destinations.BookingSummaryScreenDestination$Content$1
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
                    ComposerKt.traceEventStart(1533363799, i7, -1, "com.ramcosta.composedestinations.generated.destinations.BookingSummaryScreenDestination.Content.<anonymous> (BookingSummaryScreenDestination.kt:37)");
                }
                BookingSummaryViewModel bookingSummaryViewModel = (BookingSummaryViewModel) ((DestinationDependenciesContainerImpl) DestinationDependenciesContainer.this).require(Reflection.getOrCreateKotlinClass(BookingSummaryViewModel.class), false);
                DestinationsNavigator destinationsNavigator = destinationScope.getDestinationsNavigator();
                DestinationScope<Unit> destinationScope2 = destinationScope;
                DestinationsStringNavType stringNavType = DestinationsStringNavTypeKt.getStringNavType();
                int i8 = DestinationsStringNavType.$stable;
                composer2.startReplaceGroup(1363506722);
                ResultRecipient resultRecipient = ResultCommonsKt.resultRecipient(destinationScope2.getNavBackStackEntry(), Reflection.getOrCreateKotlinClass(PhoneNumberCodeSelectionScreenDestination.class), stringNavType, composer2, (i8 << 6) & 896);
                composer2.endReplaceGroup();
                DestinationScope<Unit> destinationScope3 = destinationScope;
                UserVehicleNavType userVehicleNavType = UserVehicleNavTypeKt.getUserVehicleNavType();
                composer2.startReplaceGroup(1363506722);
                ResultRecipient resultRecipient2 = ResultCommonsKt.resultRecipient(destinationScope3.getNavBackStackEntry(), Reflection.getOrCreateKotlinClass(VehicleSelectorScreenDestination.class), userVehicleNavType, composer2, 0);
                composer2.endReplaceGroup();
                BookingSummaryScreenKt.BookingSummaryScreen(bookingSummaryViewModel, destinationsNavigator, resultRecipient, resultRecipient2, (ICheckoutExpirationDialogHandler) ((DestinationDependenciesContainerImpl) DestinationDependenciesContainer.this).require(Reflection.getOrCreateKotlinClass(ICheckoutExpirationDialogHandler.class), false), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, i6 | 384);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public /* bridge */ /* synthetic */ Object argsFrom(Bundle bundle) {
        m3037argsFrom(bundle);
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
        return "BookingSummaryScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public /* bridge */ /* synthetic */ Object argsFrom(SavedStateHandle savedStateHandle) {
        m3038argsFrom(savedStateHandle);
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(Unit unit) {
        return DirectionDestinationSpec.DefaultImpls.invoke(this, unit);
    }

    /* renamed from: argsFrom, reason: collision with other method in class */
    public void m3037argsFrom(Bundle bundle) {
        DirectionDestinationSpec.DefaultImpls.argsFrom(this, bundle);
    }

    /* renamed from: argsFrom, reason: collision with other method in class */
    public void m3038argsFrom(SavedStateHandle savedStateHandle) {
        DirectionDestinationSpec.DefaultImpls.argsFrom(this, savedStateHandle);
    }
}
