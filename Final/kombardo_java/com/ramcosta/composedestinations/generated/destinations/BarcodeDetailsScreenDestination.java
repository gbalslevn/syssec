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
import com.ramcosta.composedestinations.generated.destinations.BarcodeDetailsScreenDestination;
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
import dk.molslinjen.ui.views.reusable.barcode.BarcodeViewType;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeDetailsScreenKt;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeDetailsScreenNavArgs;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeDetailsViewModel;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002J+\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\u0002J\u0017\u0010\u001e\u001a\u00020\u001f*\b\u0012\u0004\u0012\u00020\u00030 H\u0017¢\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H\u0016J\t\u0010'\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0010\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006("}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/BarcodeDetailsScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeDetailsScreenNavArgs;", "<init>", "()V", "invoke", "Lcom/ramcosta/composedestinations/spec/Direction;", "navArgs", "barcode", BuildConfig.FLAVOR, "text", "type", "Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;", "validity", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;", "baseRoute", "getBaseRoute", "()Ljava/lang/String;", "route", "getRoute", "arguments", BuildConfig.FLAVOR, "Landroidx/navigation/NamedNavArgument;", "getArguments", "()Ljava/util/List;", "style", "Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "getStyle", "()Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "Content", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", "argsFrom", "bundle", "Landroid/os/Bundle;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BarcodeDetailsScreenDestination extends BaseRoute implements TypedDestinationSpec<BarcodeDetailsScreenNavArgs> {
    public static final int $stable;
    public static final BarcodeDetailsScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;
    private static final DestinationStyle style;

    static {
        BarcodeDetailsScreenDestination barcodeDetailsScreenDestination = new BarcodeDetailsScreenDestination();
        INSTANCE = barcodeDetailsScreenDestination;
        baseRoute = "barcode_details_screen";
        route = barcodeDetailsScreenDestination.getBaseRoute() + "/{barcode}/{type}/{validity}?text={text}";
        style = DestinationStyleBottomSheet.INSTANCE;
        $stable = DestinationStyle.$stable;
    }

    private BarcodeDetailsScreenDestination() {
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
        navArgument.setNullable(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$3(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(EnumCustomNavTypesKt.getBarcodeViewTypeEnumNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$4(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(EnumCustomNavTypesKt.getBarcodeValidityEnumNavType());
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(DestinationScope<BarcodeDetailsScreenNavArgs> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(3906191);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(3906191, i5, -1, "com.ramcosta.composedestinations.generated.destinations.BarcodeDetailsScreenDestination.Content (BarcodeDetailsScreenDestination.kt:72)");
        }
        BarcodeDetailsScreenKt.BarcodeDetailsScreen((BarcodeDetailsViewModel) ((DestinationDependenciesContainerImpl) destinationScope.buildDependencies(composer, i5 & 14)).require(Reflection.getOrCreateKotlinClass(BarcodeDetailsViewModel.class), false), destinationScope.getDestinationsNavigator(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return CollectionsKt.listOf((Object[]) new NamedNavArgument[]{NamedNavArgumentKt.navArgument("barcode", new Function1() { // from class: f1.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$1;
                _get_arguments_$lambda$1 = BarcodeDetailsScreenDestination._get_arguments_$lambda$1((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$1;
            }
        }), NamedNavArgumentKt.navArgument("text", new Function1() { // from class: f1.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$2;
                _get_arguments_$lambda$2 = BarcodeDetailsScreenDestination._get_arguments_$lambda$2((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$2;
            }
        }), NamedNavArgumentKt.navArgument("type", new Function1() { // from class: f1.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$3;
                _get_arguments_$lambda$3 = BarcodeDetailsScreenDestination._get_arguments_$lambda$3((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$3;
            }
        }), NamedNavArgumentKt.navArgument("validity", new Function1() { // from class: f1.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$4;
                _get_arguments_$lambda$4 = BarcodeDetailsScreenDestination._get_arguments_$lambda$4((NavArgumentBuilder) obj);
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
        return style;
    }

    public String toString() {
        return "BarcodeDetailsScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(BarcodeDetailsScreenNavArgs navArgs) {
        Intrinsics.checkNotNullParameter(navArgs, "navArgs");
        return INSTANCE.invoke(navArgs.getBarcode(), navArgs.getText(), navArgs.getType(), navArgs.getValidity());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public BarcodeDetailsScreenNavArgs argsFrom(Bundle bundle) {
        String safeGet = DestinationsStringNavTypeKt.getStringNavType().safeGet(bundle, "barcode");
        if (safeGet != null) {
            String safeGet2 = DestinationsStringNavTypeKt.getStringNavType().safeGet(bundle, "text");
            BarcodeViewType barcodeViewType = (BarcodeViewType) EnumCustomNavTypesKt.getBarcodeViewTypeEnumNavType().safeGet(bundle, "type");
            if (barcodeViewType != null) {
                BarcodeValidity barcodeValidity = (BarcodeValidity) EnumCustomNavTypesKt.getBarcodeValidityEnumNavType().safeGet(bundle, "validity");
                if (barcodeValidity != null) {
                    return new BarcodeDetailsScreenNavArgs(safeGet, safeGet2, barcodeViewType, barcodeValidity);
                }
                throw new RuntimeException("'validity' argument is mandatory, but was not present!");
            }
            throw new RuntimeException("'type' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'barcode' argument is mandatory, but was not present!");
    }

    public final Direction invoke(String barcode, String text, BarcodeViewType type, BarcodeValidity validity) {
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(validity, "validity");
        return DirectionKt.Direction(getBaseRoute() + "/" + DestinationsStringNavTypeKt.getStringNavType().serializeValue("barcode", barcode) + "/" + EnumCustomNavTypesKt.getBarcodeViewTypeEnumNavType().serializeValue((DestinationsEnumNavType<BarcodeViewType>) type) + "/" + EnumCustomNavTypesKt.getBarcodeValidityEnumNavType().serializeValue((DestinationsEnumNavType<BarcodeValidity>) validity) + "?text=" + DestinationsStringNavTypeKt.getStringNavType().serializeValue("text", text));
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public BarcodeDetailsScreenNavArgs argsFrom(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        String str = DestinationsStringNavTypeKt.getStringNavType().get(savedStateHandle, "barcode");
        if (str != null) {
            String str2 = DestinationsStringNavTypeKt.getStringNavType().get(savedStateHandle, "text");
            BarcodeViewType barcodeViewType = EnumCustomNavTypesKt.getBarcodeViewTypeEnumNavType().get(savedStateHandle, "type");
            if (barcodeViewType != null) {
                BarcodeValidity barcodeValidity = EnumCustomNavTypesKt.getBarcodeValidityEnumNavType().get(savedStateHandle, "validity");
                if (barcodeValidity != null) {
                    return new BarcodeDetailsScreenNavArgs(str, str2, barcodeViewType, barcodeValidity);
                }
                throw new RuntimeException("'validity' argument is mandatory, but was not present!");
            }
            throw new RuntimeException("'type' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'barcode' argument is mandatory, but was not present!");
    }
}
