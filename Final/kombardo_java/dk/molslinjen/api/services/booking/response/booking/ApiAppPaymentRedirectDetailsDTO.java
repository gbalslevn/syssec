package dk.molslinjen.api.services.booking.response.booking;

import dk.molslinjen.core.Environment;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 62\u00020\u0001:\u000256B\u007f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013B+\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0015B\u0093\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0012\u0010\u0019J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0018\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u0018\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b+\u0010)R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b,\u0010&¨\u00067"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/ApiAppPaymentRedirectDetailsDTO;", "Ldk/molslinjen/api/services/booking/response/booking/BaseAppPaymentRedirectDetailsDTO;", "cardHolderName", BuildConfig.FLAVOR, "accept", "acceptLanguage", "userAgent", "ip", "forwardedIp", "javaEnabled", BuildConfig.FLAVOR, "javeScriptEnabled", "timeZone", BuildConfig.FLAVOR, "screenHeight", BuildConfig.FLAVOR, "screenWidth", "colorDepth", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;)V", "language", "(FFLjava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCardHolderName", "()Ljava/lang/String;", "getAccept", "getAcceptLanguage", "getUserAgent", "getIp", "getForwardedIp", "getJavaEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getJaveScriptEnabled", "getTimeZone", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScreenHeight", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getScreenWidth", "getColorDepth", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class ApiAppPaymentRedirectDetailsDTO implements BaseAppPaymentRedirectDetailsDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String accept;
    private final String acceptLanguage;
    private final String cardHolderName;
    private final Integer colorDepth;
    private final String forwardedIp;
    private final String ip;
    private final Boolean javaEnabled;
    private final Boolean javeScriptEnabled;
    private final Float screenHeight;
    private final Float screenWidth;
    private final Integer timeZone;
    private final String userAgent;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/ApiAppPaymentRedirectDetailsDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/ApiAppPaymentRedirectDetailsDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ApiAppPaymentRedirectDetailsDTO> serializer() {
            return ApiAppPaymentRedirectDetailsDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ ApiAppPaymentRedirectDetailsDTO(int i5, String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, Integer num, Float f5, Float f6, Integer num2, SerializationConstructorMarker serializationConstructorMarker) {
        if (4095 != (i5 & 4095)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 4095, ApiAppPaymentRedirectDetailsDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.cardHolderName = str;
        this.accept = str2;
        this.acceptLanguage = str3;
        this.userAgent = str4;
        this.ip = str5;
        this.forwardedIp = str6;
        this.javaEnabled = bool;
        this.javeScriptEnabled = bool2;
        this.timeZone = num;
        this.screenHeight = f5;
        this.screenWidth = f6;
        this.colorDepth = num2;
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(ApiAppPaymentRedirectDetailsDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.getCardHolderName());
        output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.getAccept());
        output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.getAcceptLanguage());
        output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.getUserAgent());
        output.encodeNullableSerializableElement(serialDesc, 4, stringSerializer, self.getIp());
        output.encodeNullableSerializableElement(serialDesc, 5, stringSerializer, self.getForwardedIp());
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 6, booleanSerializer, self.getJavaEnabled());
        output.encodeNullableSerializableElement(serialDesc, 7, booleanSerializer, self.getJaveScriptEnabled());
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 8, intSerializer, self.getTimeZone());
        FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 9, floatSerializer, self.getScreenHeight());
        output.encodeNullableSerializableElement(serialDesc, 10, floatSerializer, self.getScreenWidth());
        output.encodeNullableSerializableElement(serialDesc, 11, intSerializer, self.getColorDepth());
    }

    @Override // dk.molslinjen.api.services.booking.response.booking.BaseAppPaymentRedirectDetailsDTO
    public String getAccept() {
        return this.accept;
    }

    @Override // dk.molslinjen.api.services.booking.response.booking.BaseAppPaymentRedirectDetailsDTO
    public String getAcceptLanguage() {
        return this.acceptLanguage;
    }

    @Override // dk.molslinjen.api.services.booking.response.booking.BaseAppPaymentRedirectDetailsDTO
    public String getCardHolderName() {
        return this.cardHolderName;
    }

    @Override // dk.molslinjen.api.services.booking.response.booking.BaseAppPaymentRedirectDetailsDTO
    public Integer getColorDepth() {
        return this.colorDepth;
    }

    @Override // dk.molslinjen.api.services.booking.response.booking.BaseAppPaymentRedirectDetailsDTO
    public String getForwardedIp() {
        return this.forwardedIp;
    }

    @Override // dk.molslinjen.api.services.booking.response.booking.BaseAppPaymentRedirectDetailsDTO
    public String getIp() {
        return this.ip;
    }

    @Override // dk.molslinjen.api.services.booking.response.booking.BaseAppPaymentRedirectDetailsDTO
    public Boolean getJavaEnabled() {
        return this.javaEnabled;
    }

    @Override // dk.molslinjen.api.services.booking.response.booking.BaseAppPaymentRedirectDetailsDTO
    public Boolean getJaveScriptEnabled() {
        return this.javeScriptEnabled;
    }

    @Override // dk.molslinjen.api.services.booking.response.booking.BaseAppPaymentRedirectDetailsDTO
    public Float getScreenHeight() {
        return this.screenHeight;
    }

    @Override // dk.molslinjen.api.services.booking.response.booking.BaseAppPaymentRedirectDetailsDTO
    public Float getScreenWidth() {
        return this.screenWidth;
    }

    @Override // dk.molslinjen.api.services.booking.response.booking.BaseAppPaymentRedirectDetailsDTO
    public Integer getTimeZone() {
        return this.timeZone;
    }

    @Override // dk.molslinjen.api.services.booking.response.booking.BaseAppPaymentRedirectDetailsDTO
    public String getUserAgent() {
        return this.userAgent;
    }

    public ApiAppPaymentRedirectDetailsDTO(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, Integer num, Float f5, Float f6, Integer num2) {
        this.cardHolderName = str;
        this.accept = str2;
        this.acceptLanguage = str3;
        this.userAgent = str4;
        this.ip = str5;
        this.forwardedIp = str6;
        this.javaEnabled = bool;
        this.javeScriptEnabled = bool2;
        this.timeZone = num;
        this.screenHeight = f5;
        this.screenWidth = f6;
        this.colorDepth = num2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ApiAppPaymentRedirectDetailsDTO(float f5, float f6, String language, String str) {
        this(null, null, language, r0, str, null, null, Boolean.TRUE, Integer.valueOf(TimeZone.getDefault().getRawOffset() / 60000), Float.valueOf(f5), Float.valueOf(f6), null);
        String str2;
        Intrinsics.checkNotNullParameter(language, "language");
        if (Environment.INSTANCE.isMolslinjen()) {
            str2 = "Molslinjen";
        } else {
            str2 = "Kombardo";
        }
    }
}
