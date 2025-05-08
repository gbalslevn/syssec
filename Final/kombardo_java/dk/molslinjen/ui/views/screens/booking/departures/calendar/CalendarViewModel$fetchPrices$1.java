package dk.molslinjen.ui.views.screens.booking.departures.calendar;

import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.extensions.domain.CurrencyTypeExtensionsKt;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.YearMonth;
import uniffi.molslinjen_shared.Currency;
import uniffi.molslinjen_shared.DepartureCalendarPrices;
import uniffi.molslinjen_shared.DepartureLowPriceException;
import uniffi.molslinjen_shared.DepartureLowPriceHandlerInterface;
import uniffi.molslinjen_shared.DepartureRouteId;
import uniffi.molslinjen_shared.RegionId;
import uniffi.molslinjen_shared.SiteId;
import uniffi.molslinjen_shared.TransportId;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel$fetchPrices$1", f = "CalendarViewModel.kt", l = {99}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class CalendarViewModel$fetchPrices$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ YearMonth $month;
    int label;
    final /* synthetic */ CalendarViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarViewModel$fetchPrices$1(CalendarViewModel calendarViewModel, YearMonth yearMonth, Continuation<? super CalendarViewModel$fetchPrices$1> continuation) {
        super(2, continuation);
        this.this$0 = calendarViewModel;
        this.$month = yearMonth;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CalendarViewModel$fetchPrices$1(this.this$0, this.$month, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Map map;
        MutableStateFlow mutableStateFlow;
        Object value;
        IRouteManager iRouteManager;
        IRouteManager iRouteManager2;
        IRouteManager iRouteManager3;
        IRouteManager iRouteManager4;
        DepartureLowPriceHandlerInterface departureLowPriceHandlerInterface;
        Transportation selectedTransportation;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        try {
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                map = this.this$0.pricesMap;
                CalendarViewModel.ViewState.PricesState pricesState = (CalendarViewModel.ViewState.PricesState) map.get(this.$month);
                if ((pricesState instanceof CalendarViewModel.ViewState.PricesState.Success) || (pricesState instanceof CalendarViewModel.ViewState.PricesState.Loading)) {
                    mutableStateFlow = this.this$0._pricesData;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, pricesState));
                    return Unit.INSTANCE;
                }
                this.this$0.updateLocalState(this.$month, CalendarViewModel.ViewState.PricesState.Loading.INSTANCE);
                iRouteManager = this.this$0.routeManager;
                RouteSharedSelectedState value2 = iRouteManager.getSharedSelectedState().getValue();
                Site site = value2 != null ? value2.getSite() : null;
                iRouteManager2 = this.this$0.routeManager;
                RouteSelectedState value3 = iRouteManager2.getActiveSelectedState().getValue();
                RouteDirectionGroup selectedRouteDirectionGroup = value3 != null ? value3.getSelectedRouteDirectionGroup() : null;
                iRouteManager3 = this.this$0.routeManager;
                RouteSharedSelectedState value4 = iRouteManager3.getSharedSelectedState().getValue();
                String id = (value4 == null || (selectedTransportation = value4.getSelectedTransportation()) == null) ? null : selectedTransportation.getId();
                iRouteManager4 = this.this$0.routeManager;
                RouteSharedSelectedState value5 = iRouteManager4.getSharedSelectedState().getValue();
                CurrencyType currency = value5 != null ? value5.getCurrency() : null;
                if (selectedRouteDirectionGroup != null && id != null && site != null && currency != null) {
                    String id2 = selectedRouteDirectionGroup.getDepartureHarbor().getRegion().getId();
                    LocalDateTime atStartOfDay = this.this$0.getViewState().getValue().getMinDate().atStartOfDay();
                    LocalDate maxDate = this.this$0.getViewState().getValue().getMaxDate();
                    LocalDateTime atStartOfDay2 = maxDate != null ? maxDate.atStartOfDay() : null;
                    LocalDateTime atStartOfDay3 = this.$month.atDay(1).atStartOfDay();
                    LocalDateTime atStartOfDay4 = this.$month.atEndOfMonth().atStartOfDay();
                    DepartureRouteId departureRouteId = selectedRouteDirectionGroup.getUseRegionsAsHarbors() ? null : new DepartureRouteId(selectedRouteDirectionGroup.getMainRouteId());
                    departureLowPriceHandlerInterface = this.this$0.priceHandler;
                    if (!atStartOfDay3.isBefore(atStartOfDay)) {
                        atStartOfDay = atStartOfDay3;
                    }
                    Intrinsics.checkNotNull(atStartOfDay);
                    LocalDateTime localDateTime = (atStartOfDay2 == null || !atStartOfDay4.isAfter(atStartOfDay2)) ? atStartOfDay4 : atStartOfDay2;
                    Intrinsics.checkNotNull(localDateTime);
                    Currency currency2 = CurrencyTypeExtensionsKt.toCurrency(currency);
                    TransportId transportId = new TransportId(id);
                    RegionId regionId = new RegionId(id2);
                    SiteId siteId = site.toSiteId();
                    this.label = 1;
                    obj = departureLowPriceHandlerInterface.getLowestPrices(atStartOfDay, localDateTime, currency2, transportId, regionId, departureRouteId, siteId, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.this$0.updateLocalState(this.$month, CalendarViewModel.ViewState.PricesState.Error.INSTANCE);
                return Unit.INSTANCE;
            }
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.updateLocalState(this.$month, new CalendarViewModel.ViewState.PricesState.Success((DepartureCalendarPrices) obj));
        } catch (DepartureLowPriceException e5) {
            Logger.INSTANCE.logError(e5);
            this.this$0.updateLocalState(this.$month, CalendarViewModel.ViewState.PricesState.Error.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CalendarViewModel$fetchPrices$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
