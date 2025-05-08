package uniffi.molslinjen_shared;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013JS\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Luniffi/molslinjen_shared/DepartureLowPriceHandlerInterface;", BuildConfig.FLAVOR, "getLowestPrices", "Luniffi/molslinjen_shared/DepartureCalendarPrices;", "pricesFromDate", "Lorg/threeten/bp/LocalDateTime;", "Luniffi/molslinjen_shared/UtcDateTime;", "pricesToDate", "currencyType", "Luniffi/molslinjen_shared/Currency;", "transportId", "Luniffi/molslinjen_shared/TransportId;", "departureRegionId", "Luniffi/molslinjen_shared/RegionId;", "departureRouteId", "Luniffi/molslinjen_shared/DepartureRouteId;", "siteId", "Luniffi/molslinjen_shared/SiteId;", "(Lorg/threeten/bp/LocalDateTime;Lorg/threeten/bp/LocalDateTime;Luniffi/molslinjen_shared/Currency;Luniffi/molslinjen_shared/TransportId;Luniffi/molslinjen_shared/RegionId;Luniffi/molslinjen_shared/DepartureRouteId;Luniffi/molslinjen_shared/SiteId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface DepartureLowPriceHandlerInterface {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Luniffi/molslinjen_shared/DepartureLowPriceHandlerInterface$Companion;", BuildConfig.FLAVOR, "()V", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    Object getLowestPrices(LocalDateTime localDateTime, LocalDateTime localDateTime2, Currency currency, TransportId transportId, RegionId regionId, DepartureRouteId departureRouteId, SiteId siteId, Continuation<? super DepartureCalendarPrices> continuation);
}
