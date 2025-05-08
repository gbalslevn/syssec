package dk.molslinjen.domain.model.config;

import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002%&B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB9\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0006\u0010\u000fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\fHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006'"}, d2 = {"Ldk/molslinjen/domain/model/config/SiteSupportContact;", BuildConfig.FLAVOR, "supportPhoneNumber", BuildConfig.FLAVOR, "supportEmail", "zendeskUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteContactInfoDTO;", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteContactInfoDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSupportPhoneNumber", "()Ljava/lang/String;", "getSupportEmail", "getZendeskUrl", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class SiteSupportContact {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SiteSupportContact mock = new SiteSupportContact("12345678", "email@molslinjen.dk", "https://helpdesk.molslinjen.dk/hc/da/requests/new");
    private final String supportEmail;
    private final String supportPhoneNumber;
    private final String zendeskUrl;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/config/SiteSupportContact$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/config/SiteSupportContact;", "getMock", "()Ldk/molslinjen/domain/model/config/SiteSupportContact;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SiteSupportContact getMock() {
            return SiteSupportContact.mock;
        }

        public final KSerializer<SiteSupportContact> serializer() {
            return SiteSupportContact$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SiteSupportContact(int i5, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, SiteSupportContact$$serializer.INSTANCE.getDescriptor());
        }
        this.supportPhoneNumber = str;
        this.supportEmail = str2;
        if ((i5 & 4) == 0) {
            this.zendeskUrl = null;
        } else {
            this.zendeskUrl = str3;
        }
    }

    public static /* synthetic */ SiteSupportContact copy$default(SiteSupportContact siteSupportContact, String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = siteSupportContact.supportPhoneNumber;
        }
        if ((i5 & 2) != 0) {
            str2 = siteSupportContact.supportEmail;
        }
        if ((i5 & 4) != 0) {
            str3 = siteSupportContact.zendeskUrl;
        }
        return siteSupportContact.copy(str, str2, str3);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(SiteSupportContact self, CompositeEncoder output, SerialDescriptor serialDesc) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.supportPhoneNumber);
        output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.supportEmail);
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.zendeskUrl == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.zendeskUrl);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSupportPhoneNumber() {
        return this.supportPhoneNumber;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSupportEmail() {
        return this.supportEmail;
    }

    /* renamed from: component3, reason: from getter */
    public final String getZendeskUrl() {
        return this.zendeskUrl;
    }

    public final SiteSupportContact copy(String supportPhoneNumber, String supportEmail, String zendeskUrl) {
        return new SiteSupportContact(supportPhoneNumber, supportEmail, zendeskUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SiteSupportContact)) {
            return false;
        }
        SiteSupportContact siteSupportContact = (SiteSupportContact) other;
        return Intrinsics.areEqual(this.supportPhoneNumber, siteSupportContact.supportPhoneNumber) && Intrinsics.areEqual(this.supportEmail, siteSupportContact.supportEmail) && Intrinsics.areEqual(this.zendeskUrl, siteSupportContact.zendeskUrl);
    }

    public final String getSupportEmail() {
        return this.supportEmail;
    }

    public final String getSupportPhoneNumber() {
        return this.supportPhoneNumber;
    }

    public final String getZendeskUrl() {
        return this.zendeskUrl;
    }

    public int hashCode() {
        String str = this.supportPhoneNumber;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.supportEmail;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.zendeskUrl;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "SiteSupportContact(supportPhoneNumber=" + this.supportPhoneNumber + ", supportEmail=" + this.supportEmail + ", zendeskUrl=" + this.zendeskUrl + ")";
    }

    public SiteSupportContact(String str, String str2, String str3) {
        this.supportPhoneNumber = str;
        this.supportEmail = str2;
        this.zendeskUrl = str3;
    }

    public /* synthetic */ SiteSupportContact(String str, String str2, String str3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i5 & 4) != 0 ? null : str3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SiteSupportContact(ConfigurationResponseDTO.SiteContactInfoDTO dto) {
        this(dto.getSupportPhoneNumber(), dto.getSupportEmail(), dto.getZendeskUrl());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
