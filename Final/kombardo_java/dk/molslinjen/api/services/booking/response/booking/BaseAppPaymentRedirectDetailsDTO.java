package dk.molslinjen.api.services.booking.response.booking;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u0004\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0019¨\u0006\""}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BaseAppPaymentRedirectDetailsDTO;", BuildConfig.FLAVOR, "cardHolderName", BuildConfig.FLAVOR, "getCardHolderName", "()Ljava/lang/String;", "accept", "getAccept", "acceptLanguage", "getAcceptLanguage", "userAgent", "getUserAgent", "ip", "getIp", "forwardedIp", "getForwardedIp", "javaEnabled", BuildConfig.FLAVOR, "getJavaEnabled", "()Ljava/lang/Boolean;", "javeScriptEnabled", "getJaveScriptEnabled", "timeZone", BuildConfig.FLAVOR, "getTimeZone", "()Ljava/lang/Integer;", "screenHeight", BuildConfig.FLAVOR, "getScreenHeight", "()Ljava/lang/Float;", "screenWidth", "getScreenWidth", "colorDepth", "getColorDepth", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface BaseAppPaymentRedirectDetailsDTO {
    String getAccept();

    String getAcceptLanguage();

    String getCardHolderName();

    Integer getColorDepth();

    String getForwardedIp();

    String getIp();

    Boolean getJavaEnabled();

    Boolean getJaveScriptEnabled();

    Float getScreenHeight();

    Float getScreenWidth();

    Integer getTimeZone();

    String getUserAgent();
}
