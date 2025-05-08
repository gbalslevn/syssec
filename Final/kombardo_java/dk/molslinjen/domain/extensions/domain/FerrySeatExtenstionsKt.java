package dk.molslinjen.domain.extensions.domain;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.booking.request.BookRequestParameters;
import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.Amount;
import uniffi.molslinjen_shared.Currency;
import uniffi.molslinjen_shared.FerrySeat;
import uniffi.molslinjen_shared.FerrySeatId;
import uniffi.molslinjen_shared.FerrySeatType;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0006*\b\u0012\u0004\u0012\u00020\u00010\f\u001a\u0015\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\u0002\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"mock", "Luniffi/molslinjen_shared/FerrySeat;", "Luniffi/molslinjen_shared/FerrySeat$Companion;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "priceWithCurrency", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getPriceWithCurrency", "(Luniffi/molslinjen_shared/FerrySeat;)Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "toRequestParameter", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookSeatReservationRequestParameter$SeatRequestParameters;", "totalPrice", BuildConfig.FLAVOR, "invoke", "dto", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingSeatDTO;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FerrySeatExtenstionsKt {
    public static final PriceWithCurrency getPriceWithCurrency(FerrySeat ferrySeat) {
        Intrinsics.checkNotNullParameter(ferrySeat, "<this>");
        Amount price = ferrySeat.getPrice();
        if (price != null) {
            return AmountExtensionsKt.toPriceWithCurrency(price);
        }
        return null;
    }

    public static final FerrySeat invoke(FerrySeat.Companion companion, BookingResponseDTO.BookingSeatDTO dto) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(dto, "dto");
        return new FerrySeat(new FerrySeatId(dto.getId()), dto.getText(), FerrySeatType.AVAILABLE, dto.getSectionName(), AmountExtensionsKt.invoke(Amount.INSTANCE, dto.getSeatPrice()));
    }

    public static final FerrySeat mock(FerrySeat.Companion companion, int i5) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new FerrySeat(new FerrySeatId(i5), String.valueOf(i5), FerrySeatType.AVAILABLE, "Styrbor", new Amount.Monetary(100L, Currency.DKK));
    }

    public static final BookRequestParameters.BookSeatReservationRequestParameter.SeatRequestParameters toRequestParameter(FerrySeat ferrySeat) {
        Intrinsics.checkNotNullParameter(ferrySeat, "<this>");
        int value = ferrySeat.getId().getValue();
        PriceWithCurrency priceWithCurrency = getPriceWithCurrency(ferrySeat);
        if (priceWithCurrency == null) {
            priceWithCurrency = PriceWithCurrency.INSTANCE.m3248default();
        }
        return new BookRequestParameters.BookSeatReservationRequestParameter.SeatRequestParameters(value, new PriceWithCurrencyDTO(priceWithCurrency.getValue(), priceWithCurrency.getCurrencyType().toDTO()), ferrySeat.getName(), ferrySeat.getSection(), 0, 16, (DefaultConstructorMarker) null);
    }

    public static final PriceWithCurrency totalPrice(List<FerrySeat> list) {
        CurrencyType currencyType;
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            PriceWithCurrency priceWithCurrency = getPriceWithCurrency((FerrySeat) it.next());
            if (priceWithCurrency != null) {
                arrayList.add(priceWithCurrency);
            }
        }
        PriceWithCurrency priceWithCurrency2 = (PriceWithCurrency) CollectionsKt.firstOrNull((List) arrayList);
        if (priceWithCurrency2 == null || (currencyType = priceWithCurrency2.getCurrencyType()) == null) {
            return null;
        }
        Iterator it2 = arrayList.iterator();
        int i5 = 0;
        while (it2.hasNext()) {
            i5 += ((PriceWithCurrency) it2.next()).getValue();
        }
        return new PriceWithCurrency(i5, currencyType);
    }
}
