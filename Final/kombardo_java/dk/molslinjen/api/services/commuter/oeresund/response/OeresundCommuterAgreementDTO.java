package dk.molslinjen.api.services.commuter.oeresund.response;

import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.services.commuter.oeresund.response.OeresundCommuterAgreementTypeDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0002FGBw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013B\u0093\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\t\u00102\u001a\u00020\rHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0096\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\bHÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001J%\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0001¢\u0006\u0002\bER\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b$\u0010 R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019¨\u0006H"}, d2 = {"Ldk/molslinjen/api/services/commuter/oeresund/response/OeresundCommuterAgreementDTO;", BuildConfig.FLAVOR, "commuteAgreementId", BuildConfig.FLAVOR, "text", "validToDate", "Lorg/threeten/bp/LocalDate;", "remainingTrips", BuildConfig.FLAVOR, "cardNumber", "lineName", "agreementType", "agreementModelType", "Ldk/molslinjen/api/services/commuter/oeresund/response/OeresundCommuterAgreementTypeDTO;", "titleApp", "imageUrl", "transportFormTextApp", "bizzNumber", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ldk/molslinjen/api/services/commuter/oeresund/response/OeresundCommuterAgreementTypeDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ldk/molslinjen/api/services/commuter/oeresund/response/OeresundCommuterAgreementTypeDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCommuteAgreementId", "()Ljava/lang/String;", "getText", "getValidToDate$annotations", "()V", "getValidToDate", "()Lorg/threeten/bp/LocalDate;", "getRemainingTrips", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCardNumber", "getLineName", "getAgreementType", "getAgreementModelType", "()Ldk/molslinjen/api/services/commuter/oeresund/response/OeresundCommuterAgreementTypeDTO;", "getTitleApp", "getImageUrl", "getTransportFormTextApp", "getBizzNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ldk/molslinjen/api/services/commuter/oeresund/response/OeresundCommuterAgreementTypeDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ldk/molslinjen/api/services/commuter/oeresund/response/OeresundCommuterAgreementDTO;", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class OeresundCommuterAgreementDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final OeresundCommuterAgreementTypeDTO agreementModelType;
    private final Integer agreementType;
    private final String bizzNumber;
    private final String cardNumber;
    private final String commuteAgreementId;
    private final String imageUrl;
    private final String lineName;
    private final Integer remainingTrips;
    private final String text;
    private final String titleApp;
    private final String transportFormTextApp;
    private final LocalDate validToDate;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/commuter/oeresund/response/OeresundCommuterAgreementDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/commuter/oeresund/response/OeresundCommuterAgreementDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<OeresundCommuterAgreementDTO> serializer() {
            return OeresundCommuterAgreementDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ OeresundCommuterAgreementDTO(int i5, String str, String str2, LocalDate localDate, Integer num, String str3, String str4, Integer num2, OeresundCommuterAgreementTypeDTO oeresundCommuterAgreementTypeDTO, String str5, String str6, String str7, String str8, SerializationConstructorMarker serializationConstructorMarker) {
        if (4095 != (i5 & 4095)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 4095, OeresundCommuterAgreementDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.commuteAgreementId = str;
        this.text = str2;
        this.validToDate = localDate;
        this.remainingTrips = num;
        this.cardNumber = str3;
        this.lineName = str4;
        this.agreementType = num2;
        this.agreementModelType = oeresundCommuterAgreementTypeDTO;
        this.titleApp = str5;
        this.imageUrl = str6;
        this.transportFormTextApp = str7;
        this.bizzNumber = str8;
    }

    @Serializable(with = LocalDateWithTimeSerializer.class)
    public static /* synthetic */ void getValidToDate$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(OeresundCommuterAgreementDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.commuteAgreementId);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.text);
        output.encodeNullableSerializableElement(serialDesc, 2, LocalDateWithTimeSerializer.INSTANCE, self.validToDate);
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 3, intSerializer, self.remainingTrips);
        output.encodeStringElement(serialDesc, 4, self.cardNumber);
        output.encodeStringElement(serialDesc, 5, self.lineName);
        output.encodeNullableSerializableElement(serialDesc, 6, intSerializer, self.agreementType);
        output.encodeSerializableElement(serialDesc, 7, OeresundCommuterAgreementTypeDTO.Serializer.INSTANCE, self.agreementModelType);
        output.encodeNullableSerializableElement(serialDesc, 8, stringSerializer, self.titleApp);
        output.encodeNullableSerializableElement(serialDesc, 9, stringSerializer, self.imageUrl);
        output.encodeNullableSerializableElement(serialDesc, 10, stringSerializer, self.transportFormTextApp);
        output.encodeNullableSerializableElement(serialDesc, 11, stringSerializer, self.bizzNumber);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCommuteAgreementId() {
        return this.commuteAgreementId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component11, reason: from getter */
    public final String getTransportFormTextApp() {
        return this.transportFormTextApp;
    }

    /* renamed from: component12, reason: from getter */
    public final String getBizzNumber() {
        return this.bizzNumber;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalDate getValidToDate() {
        return this.validToDate;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getRemainingTrips() {
        return this.remainingTrips;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCardNumber() {
        return this.cardNumber;
    }

    /* renamed from: component6, reason: from getter */
    public final String getLineName() {
        return this.lineName;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getAgreementType() {
        return this.agreementType;
    }

    /* renamed from: component8, reason: from getter */
    public final OeresundCommuterAgreementTypeDTO getAgreementModelType() {
        return this.agreementModelType;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTitleApp() {
        return this.titleApp;
    }

    public final OeresundCommuterAgreementDTO copy(String commuteAgreementId, String text, LocalDate validToDate, Integer remainingTrips, String cardNumber, String lineName, Integer agreementType, OeresundCommuterAgreementTypeDTO agreementModelType, String titleApp, String imageUrl, String transportFormTextApp, String bizzNumber) {
        Intrinsics.checkNotNullParameter(commuteAgreementId, "commuteAgreementId");
        Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        Intrinsics.checkNotNullParameter(agreementModelType, "agreementModelType");
        return new OeresundCommuterAgreementDTO(commuteAgreementId, text, validToDate, remainingTrips, cardNumber, lineName, agreementType, agreementModelType, titleApp, imageUrl, transportFormTextApp, bizzNumber);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OeresundCommuterAgreementDTO)) {
            return false;
        }
        OeresundCommuterAgreementDTO oeresundCommuterAgreementDTO = (OeresundCommuterAgreementDTO) other;
        return Intrinsics.areEqual(this.commuteAgreementId, oeresundCommuterAgreementDTO.commuteAgreementId) && Intrinsics.areEqual(this.text, oeresundCommuterAgreementDTO.text) && Intrinsics.areEqual(this.validToDate, oeresundCommuterAgreementDTO.validToDate) && Intrinsics.areEqual(this.remainingTrips, oeresundCommuterAgreementDTO.remainingTrips) && Intrinsics.areEqual(this.cardNumber, oeresundCommuterAgreementDTO.cardNumber) && Intrinsics.areEqual(this.lineName, oeresundCommuterAgreementDTO.lineName) && Intrinsics.areEqual(this.agreementType, oeresundCommuterAgreementDTO.agreementType) && this.agreementModelType == oeresundCommuterAgreementDTO.agreementModelType && Intrinsics.areEqual(this.titleApp, oeresundCommuterAgreementDTO.titleApp) && Intrinsics.areEqual(this.imageUrl, oeresundCommuterAgreementDTO.imageUrl) && Intrinsics.areEqual(this.transportFormTextApp, oeresundCommuterAgreementDTO.transportFormTextApp) && Intrinsics.areEqual(this.bizzNumber, oeresundCommuterAgreementDTO.bizzNumber);
    }

    public final OeresundCommuterAgreementTypeDTO getAgreementModelType() {
        return this.agreementModelType;
    }

    public final Integer getAgreementType() {
        return this.agreementType;
    }

    public final String getBizzNumber() {
        return this.bizzNumber;
    }

    public final String getCardNumber() {
        return this.cardNumber;
    }

    public final String getCommuteAgreementId() {
        return this.commuteAgreementId;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getLineName() {
        return this.lineName;
    }

    public final Integer getRemainingTrips() {
        return this.remainingTrips;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitleApp() {
        return this.titleApp;
    }

    public final String getTransportFormTextApp() {
        return this.transportFormTextApp;
    }

    public final LocalDate getValidToDate() {
        return this.validToDate;
    }

    public int hashCode() {
        int hashCode = this.commuteAgreementId.hashCode() * 31;
        String str = this.text;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        LocalDate localDate = this.validToDate;
        int hashCode3 = (hashCode2 + (localDate == null ? 0 : localDate.hashCode())) * 31;
        Integer num = this.remainingTrips;
        int hashCode4 = (((((hashCode3 + (num == null ? 0 : num.hashCode())) * 31) + this.cardNumber.hashCode()) * 31) + this.lineName.hashCode()) * 31;
        Integer num2 = this.agreementType;
        int hashCode5 = (((hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31) + this.agreementModelType.hashCode()) * 31;
        String str2 = this.titleApp;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.imageUrl;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.transportFormTextApp;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.bizzNumber;
        return hashCode8 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "OeresundCommuterAgreementDTO(commuteAgreementId=" + this.commuteAgreementId + ", text=" + this.text + ", validToDate=" + this.validToDate + ", remainingTrips=" + this.remainingTrips + ", cardNumber=" + this.cardNumber + ", lineName=" + this.lineName + ", agreementType=" + this.agreementType + ", agreementModelType=" + this.agreementModelType + ", titleApp=" + this.titleApp + ", imageUrl=" + this.imageUrl + ", transportFormTextApp=" + this.transportFormTextApp + ", bizzNumber=" + this.bizzNumber + ")";
    }

    public OeresundCommuterAgreementDTO(String commuteAgreementId, String str, LocalDate localDate, Integer num, String cardNumber, String lineName, Integer num2, OeresundCommuterAgreementTypeDTO agreementModelType, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(commuteAgreementId, "commuteAgreementId");
        Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        Intrinsics.checkNotNullParameter(agreementModelType, "agreementModelType");
        this.commuteAgreementId = commuteAgreementId;
        this.text = str;
        this.validToDate = localDate;
        this.remainingTrips = num;
        this.cardNumber = cardNumber;
        this.lineName = lineName;
        this.agreementType = num2;
        this.agreementModelType = agreementModelType;
        this.titleApp = str2;
        this.imageUrl = str3;
        this.transportFormTextApp = str4;
        this.bizzNumber = str5;
    }
}
