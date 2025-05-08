package dk.molslinjen.domain.model.agreement.commuter.oeresund;

import dk.molslinjen.api.helpers.serializers.LocalDateSerializer;
import dk.molslinjen.api.services.commuter.oeresund.response.OeresundCommuterAgreementDTO;
import dk.molslinjen.api.services.commuter.oeresund.response.OeresundCommuterAgreementTypeDTO;
import dk.molslinjen.domain.model.constants.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 B2\u00020\u0001:\u0002BCB[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u000f\u0010\u0013Bu\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u000f\u0010\u0017J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003Jt\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\fHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001J%\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0001¢\u0006\u0002\bAR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0011\u0010(\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b(\u0010*¨\u0006D"}, d2 = {"Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;", BuildConfig.FLAVOR, "agreementId", BuildConfig.FLAVOR, "agreementType", "Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreementType;", Constants.IntentExtra.PushTitle, "transportImageUrl", "transportDescription", "validTo", "Lorg/threeten/bp/LocalDate;", "numberOfChargesLeft", BuildConfig.FLAVOR, "number", "lineName", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreementType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/commuter/oeresund/response/OeresundCommuterAgreementDTO;", "(Ldk/molslinjen/api/services/commuter/oeresund/response/OeresundCommuterAgreementDTO;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreementType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAgreementId", "()Ljava/lang/String;", "getAgreementType", "()Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreementType;", "getTitle", "getTransportImageUrl", "getTransportDescription", "getValidTo$annotations", "()V", "getValidTo", "()Lorg/threeten/bp/LocalDate;", "getNumberOfChargesLeft", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNumber", "getLineName", "isAvailable", BuildConfig.FLAVOR, "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreementType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class OeresundCommuterAgreement {
    private final String agreementId;
    private final OeresundCommuterAgreementType agreementType;
    private final String lineName;
    private final String number;
    private final Integer numberOfChargesLeft;
    private final String title;
    private final String transportDescription;
    private final String transportImageUrl;
    private final LocalDate validTo;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreementType", OeresundCommuterAgreementType.values()), null, null, null, null, null, null, null};
    private static final OeresundCommuterAgreement mock = new OeresundCommuterAgreement("123456789", OeresundCommuterAgreementType.Punchcard, "Pendlerkort", "https://www.molslinjen.dk/media/1067704/walking.svg", "Gående, Voksen", LocalDate.now().plusDays(30), 10, "12345678", "Øresundslinjen");

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;", "getMock", "()Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OeresundCommuterAgreement getMock() {
            return OeresundCommuterAgreement.mock;
        }

        public final KSerializer<OeresundCommuterAgreement> serializer() {
            return OeresundCommuterAgreement$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[OeresundCommuterAgreementType.values().length];
            try {
                iArr[OeresundCommuterAgreementType.Bizz.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OeresundCommuterAgreementType.Commute.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OeresundCommuterAgreementType.Punchcard.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[OeresundCommuterAgreementTypeDTO.values().length];
            try {
                iArr2[OeresundCommuterAgreementTypeDTO.Unknown.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OeresundCommuterAgreementTypeDTO.Bizz.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[OeresundCommuterAgreementTypeDTO.Commute.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[OeresundCommuterAgreementTypeDTO.Punchcard.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public /* synthetic */ OeresundCommuterAgreement(int i5, String str, OeresundCommuterAgreementType oeresundCommuterAgreementType, String str2, String str3, String str4, LocalDate localDate, Integer num, String str5, String str6, SerializationConstructorMarker serializationConstructorMarker) {
        if (511 != (i5 & 511)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 511, OeresundCommuterAgreement$$serializer.INSTANCE.getDescriptor());
        }
        this.agreementId = str;
        this.agreementType = oeresundCommuterAgreementType;
        this.title = str2;
        this.transportImageUrl = str3;
        this.transportDescription = str4;
        this.validTo = localDate;
        this.numberOfChargesLeft = num;
        this.number = str5;
        this.lineName = str6;
    }

    @Serializable(with = LocalDateSerializer.class)
    public static /* synthetic */ void getValidTo$annotations() {
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(OeresundCommuterAgreement self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.agreementId);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.agreementType);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.title);
        output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.transportImageUrl);
        output.encodeNullableSerializableElement(serialDesc, 4, stringSerializer, self.transportDescription);
        output.encodeNullableSerializableElement(serialDesc, 5, LocalDateSerializer.INSTANCE, self.validTo);
        output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.numberOfChargesLeft);
        output.encodeNullableSerializableElement(serialDesc, 7, stringSerializer, self.number);
        output.encodeStringElement(serialDesc, 8, self.lineName);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAgreementId() {
        return this.agreementId;
    }

    /* renamed from: component2, reason: from getter */
    public final OeresundCommuterAgreementType getAgreementType() {
        return this.agreementType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTransportImageUrl() {
        return this.transportImageUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTransportDescription() {
        return this.transportDescription;
    }

    /* renamed from: component6, reason: from getter */
    public final LocalDate getValidTo() {
        return this.validTo;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getNumberOfChargesLeft() {
        return this.numberOfChargesLeft;
    }

    /* renamed from: component8, reason: from getter */
    public final String getNumber() {
        return this.number;
    }

    /* renamed from: component9, reason: from getter */
    public final String getLineName() {
        return this.lineName;
    }

    public final OeresundCommuterAgreement copy(String agreementId, OeresundCommuterAgreementType agreementType, String title, String transportImageUrl, String transportDescription, LocalDate validTo, Integer numberOfChargesLeft, String number, String lineName) {
        Intrinsics.checkNotNullParameter(agreementId, "agreementId");
        Intrinsics.checkNotNullParameter(agreementType, "agreementType");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        return new OeresundCommuterAgreement(agreementId, agreementType, title, transportImageUrl, transportDescription, validTo, numberOfChargesLeft, number, lineName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OeresundCommuterAgreement)) {
            return false;
        }
        OeresundCommuterAgreement oeresundCommuterAgreement = (OeresundCommuterAgreement) other;
        return Intrinsics.areEqual(this.agreementId, oeresundCommuterAgreement.agreementId) && this.agreementType == oeresundCommuterAgreement.agreementType && Intrinsics.areEqual(this.title, oeresundCommuterAgreement.title) && Intrinsics.areEqual(this.transportImageUrl, oeresundCommuterAgreement.transportImageUrl) && Intrinsics.areEqual(this.transportDescription, oeresundCommuterAgreement.transportDescription) && Intrinsics.areEqual(this.validTo, oeresundCommuterAgreement.validTo) && Intrinsics.areEqual(this.numberOfChargesLeft, oeresundCommuterAgreement.numberOfChargesLeft) && Intrinsics.areEqual(this.number, oeresundCommuterAgreement.number) && Intrinsics.areEqual(this.lineName, oeresundCommuterAgreement.lineName);
    }

    public final String getAgreementId() {
        return this.agreementId;
    }

    public final OeresundCommuterAgreementType getAgreementType() {
        return this.agreementType;
    }

    public final String getLineName() {
        return this.lineName;
    }

    public final String getNumber() {
        return this.number;
    }

    public final Integer getNumberOfChargesLeft() {
        return this.numberOfChargesLeft;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTransportDescription() {
        return this.transportDescription;
    }

    public final String getTransportImageUrl() {
        return this.transportImageUrl;
    }

    public final LocalDate getValidTo() {
        return this.validTo;
    }

    public int hashCode() {
        int hashCode = ((this.agreementId.hashCode() * 31) + this.agreementType.hashCode()) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.transportImageUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.transportDescription;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        LocalDate localDate = this.validTo;
        int hashCode5 = (hashCode4 + (localDate == null ? 0 : localDate.hashCode())) * 31;
        Integer num = this.numberOfChargesLeft;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.number;
        return ((hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.lineName.hashCode();
    }

    public final boolean isAvailable() {
        Integer num = this.numberOfChargesLeft;
        boolean z5 = num != null && num.intValue() > 0;
        LocalDate localDate = this.validTo;
        boolean z6 = localDate != null && (localDate.isAfter(LocalDate.now()) || this.validTo.isEqual(LocalDate.now()));
        int i5 = WhenMappings.$EnumSwitchMapping$0[this.agreementType.ordinal()];
        if (i5 != 1) {
            if (i5 == 2) {
                return z6;
            }
            if (i5 != 3 || !z6 || !z5) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "OeresundCommuterAgreement(agreementId=" + this.agreementId + ", agreementType=" + this.agreementType + ", title=" + this.title + ", transportImageUrl=" + this.transportImageUrl + ", transportDescription=" + this.transportDescription + ", validTo=" + this.validTo + ", numberOfChargesLeft=" + this.numberOfChargesLeft + ", number=" + this.number + ", lineName=" + this.lineName + ")";
    }

    public OeresundCommuterAgreement(String agreementId, OeresundCommuterAgreementType agreementType, String str, String str2, String str3, LocalDate localDate, Integer num, String str4, String lineName) {
        Intrinsics.checkNotNullParameter(agreementId, "agreementId");
        Intrinsics.checkNotNullParameter(agreementType, "agreementType");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        this.agreementId = agreementId;
        this.agreementType = agreementType;
        this.title = str;
        this.transportImageUrl = str2;
        this.transportDescription = str3;
        this.validTo = localDate;
        this.numberOfChargesLeft = num;
        this.number = str4;
        this.lineName = lineName;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OeresundCommuterAgreement(OeresundCommuterAgreementDTO dto) {
        this(r2, r3, r4, r5, r6, r7, r8, r0, dto.getLineName());
        String str;
        Intrinsics.checkNotNullParameter(dto, "dto");
        String commuteAgreementId = dto.getCommuteAgreementId();
        OeresundCommuterAgreementType invoke = OeresundCommuterAgreementType.INSTANCE.invoke(dto.getAgreementModelType());
        String titleApp = dto.getTitleApp();
        String imageUrl = dto.getImageUrl();
        String transportFormTextApp = dto.getTransportFormTextApp();
        LocalDate validToDate = dto.getValidToDate();
        Integer remainingTrips = dto.getRemainingTrips();
        int i5 = WhenMappings.$EnumSwitchMapping$1[dto.getAgreementModelType().ordinal()];
        if (i5 == 1) {
            str = null;
        } else if (i5 == 2) {
            str = dto.getBizzNumber();
        } else {
            if (i5 != 3 && i5 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            str = dto.getCardNumber();
        }
    }
}
