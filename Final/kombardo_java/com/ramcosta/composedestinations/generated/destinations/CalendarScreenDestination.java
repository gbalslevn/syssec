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
import com.ramcosta.composedestinations.generated.destinations.CalendarScreenDestination;
import com.ramcosta.composedestinations.generated.navtype.EnumCustomNavTypesKt;
import com.ramcosta.composedestinations.generated.navtype.LocalDateNavTypeKt;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsEnumNavType;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainerImpl;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.scope.DestinationScopeKt;
import com.ramcosta.composedestinations.spec.BaseRoute;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.DirectionKt;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarScreenKt;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarScreenNavArgs;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarSheetType;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002J/\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0086\u0002J\u0017\u0010\u001e\u001a\u00020\u001f*\b\u0012\u0004\u0012\u00020\u00030 H\u0017¢\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H\u0016J\t\u0010'\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006("}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/CalendarScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarScreenNavArgs;", "<init>", "()V", "invoke", "Lcom/ramcosta/composedestinations/spec/Direction;", "navArgs", "selectedDate", "Lorg/threeten/bp/LocalDate;", "calendarType", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarSheetType;", "minDate", "maxDate", "baseRoute", BuildConfig.FLAVOR, "getBaseRoute", "()Ljava/lang/String;", "route", "getRoute", "arguments", BuildConfig.FLAVOR, "Landroidx/navigation/NamedNavArgument;", "getArguments", "()Ljava/util/List;", "style", "Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "getStyle", "()Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "Content", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", "argsFrom", "bundle", "Landroid/os/Bundle;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CalendarScreenDestination extends BaseRoute implements TypedDestinationSpec<CalendarScreenNavArgs> {
    public static final int $stable;
    public static final CalendarScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;
    private static final DestinationStyle style;

    static {
        CalendarScreenDestination calendarScreenDestination = new CalendarScreenDestination();
        INSTANCE = calendarScreenDestination;
        baseRoute = "calendar_screen";
        route = calendarScreenDestination.getBaseRoute() + "/{selectedDate}/{calendarType}?minDate={minDate}&maxDate={maxDate}";
        style = DestinationStyleBottomSheet.INSTANCE;
        $stable = DestinationStyle.$stable;
    }

    private CalendarScreenDestination() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$1(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(LocalDateNavTypeKt.getLocalDateNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$2(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(EnumCustomNavTypesKt.getCalendarSheetTypeEnumNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$3(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(LocalDateNavTypeKt.getLocalDateNavType());
        LocalDate now = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue(now, "now(...)");
        navArgument.setDefaultValue(now);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$4(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(LocalDateNavTypeKt.getLocalDateNavType());
        navArgument.setNullable(true);
        navArgument.setDefaultValue(null);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Direction invoke$default(CalendarScreenDestination calendarScreenDestination, LocalDate localDate, CalendarSheetType calendarSheetType, LocalDate localDate2, LocalDate localDate3, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            localDate2 = LocalDate.now();
        }
        if ((i5 & 8) != 0) {
            localDate3 = null;
        }
        return calendarScreenDestination.invoke(localDate, calendarSheetType, localDate2, localDate3);
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(DestinationScope<CalendarScreenNavArgs> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(-1457313009);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1457313009, i5, -1, "com.ramcosta.composedestinations.generated.destinations.CalendarScreenDestination.Content (CalendarScreenDestination.kt:75)");
        }
        int i6 = i5 & 14;
        DestinationDependenciesContainerImpl destinationDependenciesContainerImpl = (DestinationDependenciesContainerImpl) destinationScope.buildDependencies(composer, i6);
        CalendarScreenKt.CalendarScreen((CalendarViewModel) destinationDependenciesContainerImpl.require(Reflection.getOrCreateKotlinClass(CalendarViewModel.class), false), destinationScope.getDestinationsNavigator(), destinationScope.getNavBackStackEntry(), destinationScope.getNavController(), (BottomSheetDismissHandler) destinationDependenciesContainerImpl.require(Reflection.getOrCreateKotlinClass(BottomSheetDismissHandler.class), false), DestinationScopeKt.resultBackNavigator(destinationScope, LocalDateNavTypeKt.getLocalDateNavType(), composer, i6), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return CollectionsKt.listOf((Object[]) new NamedNavArgument[]{NamedNavArgumentKt.navArgument("selectedDate", new Function1() { // from class: f1.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$1;
                _get_arguments_$lambda$1 = CalendarScreenDestination._get_arguments_$lambda$1((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$1;
            }
        }), NamedNavArgumentKt.navArgument("calendarType", new Function1() { // from class: f1.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$2;
                _get_arguments_$lambda$2 = CalendarScreenDestination._get_arguments_$lambda$2((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$2;
            }
        }), NamedNavArgumentKt.navArgument("minDate", new Function1() { // from class: f1.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$3;
                _get_arguments_$lambda$3 = CalendarScreenDestination._get_arguments_$lambda$3((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$3;
            }
        }), NamedNavArgumentKt.navArgument("maxDate", new Function1() { // from class: f1.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$4;
                _get_arguments_$lambda$4 = CalendarScreenDestination._get_arguments_$lambda$4((NavArgumentBuilder) obj);
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
        return "CalendarScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(CalendarScreenNavArgs navArgs) {
        Intrinsics.checkNotNullParameter(navArgs, "navArgs");
        return INSTANCE.invoke(navArgs.getSelectedDate(), navArgs.getCalendarType(), navArgs.getMinDate(), navArgs.getMaxDate());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public CalendarScreenNavArgs argsFrom(Bundle bundle) {
        LocalDate safeGet = LocalDateNavTypeKt.getLocalDateNavType().safeGet(bundle, "selectedDate");
        if (safeGet != null) {
            CalendarSheetType calendarSheetType = (CalendarSheetType) EnumCustomNavTypesKt.getCalendarSheetTypeEnumNavType().safeGet(bundle, "calendarType");
            if (calendarSheetType != null) {
                LocalDate safeGet2 = LocalDateNavTypeKt.getLocalDateNavType().safeGet(bundle, "minDate");
                if (safeGet2 != null) {
                    return new CalendarScreenNavArgs(safeGet, calendarSheetType, safeGet2, LocalDateNavTypeKt.getLocalDateNavType().safeGet(bundle, "maxDate"));
                }
                throw new RuntimeException("'minDate' argument is not mandatory and not nullable but was not present!");
            }
            throw new RuntimeException("'calendarType' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'selectedDate' argument is mandatory, but was not present!");
    }

    public final Direction invoke(LocalDate selectedDate, CalendarSheetType calendarType, LocalDate minDate, LocalDate maxDate) {
        Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
        Intrinsics.checkNotNullParameter(calendarType, "calendarType");
        Intrinsics.checkNotNullParameter(minDate, "minDate");
        return DirectionKt.Direction(getBaseRoute() + "/" + LocalDateNavTypeKt.getLocalDateNavType().serializeValue(selectedDate) + "/" + EnumCustomNavTypesKt.getCalendarSheetTypeEnumNavType().serializeValue((DestinationsEnumNavType<CalendarSheetType>) calendarType) + "?minDate=" + LocalDateNavTypeKt.getLocalDateNavType().serializeValue(minDate) + "&maxDate=" + LocalDateNavTypeKt.getLocalDateNavType().serializeValue(maxDate));
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public CalendarScreenNavArgs argsFrom(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        LocalDate localDate = LocalDateNavTypeKt.getLocalDateNavType().get(savedStateHandle, "selectedDate");
        if (localDate != null) {
            CalendarSheetType calendarSheetType = EnumCustomNavTypesKt.getCalendarSheetTypeEnumNavType().get(savedStateHandle, "calendarType");
            if (calendarSheetType != null) {
                LocalDate localDate2 = LocalDateNavTypeKt.getLocalDateNavType().get(savedStateHandle, "minDate");
                if (localDate2 != null) {
                    return new CalendarScreenNavArgs(localDate, calendarSheetType, localDate2, LocalDateNavTypeKt.getLocalDateNavType().get(savedStateHandle, "maxDate"));
                }
                throw new RuntimeException("'minDate' argument is not mandatory and not nullable but was not present!");
            }
            throw new RuntimeException("'calendarType' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'selectedDate' argument is mandatory, but was not present!");
    }
}
