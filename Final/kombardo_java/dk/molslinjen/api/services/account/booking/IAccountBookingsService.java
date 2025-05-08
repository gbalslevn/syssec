package dk.molslinjen.api.services.account.booking;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.booking.response.AccountBookingHeadersResponseDTO;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\fJ,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0012J4\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H¦@¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/api/services/account/booking/IAccountBookingsService;", BuildConfig.FLAVOR, "getActiveBookings", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/account/booking/response/AccountBookingHeadersResponseDTO;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHistoricBookings", "take", BuildConfig.FLAVOR, "skip", "(IILdk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addExistingBooking", BuildConfig.FLAVOR, "reservationNumber", BuildConfig.FLAVOR, "phoneNumber", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadReceiptPdf", "outputFile", "Ljava/io/File;", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAccountBookingsService {
    Object addExistingBooking(String str, String str2, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<Unit>> continuation);

    Object downloadReceiptPdf(String str, String str2, AuthTokenDTO authTokenDTO, File file, Continuation<? super ApiResult<Unit>> continuation);

    Object getActiveBookings(AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AccountBookingHeadersResponseDTO>> continuation);

    Object getHistoricBookings(int i5, int i6, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AccountBookingHeadersResponseDTO>> continuation);
}
