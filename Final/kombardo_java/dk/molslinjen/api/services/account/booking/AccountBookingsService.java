package dk.molslinjen.api.services.account.booking;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.account.booking.response.AccountBookingHeadersResponseDTO;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0011J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0017J4\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ldk/molslinjen/api/services/account/booking/AccountBookingsService;", "Ldk/molslinjen/api/services/account/booking/IAccountBookingsService;", "Ldk/molslinjen/api/services/BaseService;", "api", "Ldk/molslinjen/api/services/account/booking/AccountBookingsApi;", "<init>", "(Ldk/molslinjen/api/services/account/booking/AccountBookingsApi;)V", "getActiveBookings", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/account/booking/response/AccountBookingHeadersResponseDTO;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHistoricBookings", "take", BuildConfig.FLAVOR, "skip", "(IILdk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addExistingBooking", BuildConfig.FLAVOR, "reservationNumber", BuildConfig.FLAVOR, "phoneNumber", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadReceiptPdf", "outputFile", "Ljava/io/File;", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyStreamToFile", "inputStream", "Ljava/io/InputStream;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AccountBookingsService extends BaseService implements IAccountBookingsService {
    private final AccountBookingsApi api;

    public AccountBookingsService(AccountBookingsApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void copyStreamToFile(InputStream inputStream, File outputFile) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            try {
                byte[] bArr = new byte[10240];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read < 0) {
                        fileOutputStream.flush();
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileOutputStream, null);
                        CloseableKt.closeFinally(inputStream, null);
                        return;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStream, th);
                throw th2;
            }
        }
    }

    @Override // dk.molslinjen.api.services.account.booking.IAccountBookingsService
    public Object addExistingBooking(String str, String str2, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountBookingsService$addExistingBooking$2(str, str2, this, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.booking.IAccountBookingsService
    public Object downloadReceiptPdf(String str, String str2, AuthTokenDTO authTokenDTO, File file, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountBookingsService$downloadReceiptPdf$2(this, str, str2, authTokenDTO, file, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.booking.IAccountBookingsService
    public Object getActiveBookings(AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AccountBookingHeadersResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountBookingsService$getActiveBookings$2(this, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.booking.IAccountBookingsService
    public Object getHistoricBookings(int i5, int i6, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AccountBookingHeadersResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountBookingsService$getHistoricBookings$2(this, i5, i6, authTokenDTO, null), continuation);
    }
}
