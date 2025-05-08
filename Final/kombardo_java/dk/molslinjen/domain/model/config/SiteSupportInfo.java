package dk.molslinjen.domain.model.config;

import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import dk.molslinjen.domain.model.config.SiteSupportOpeningHours;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000234BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\f\u0010\u0010B]\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\f\u0010\u0015J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003JU\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0012HÖ\u0001J\t\u0010*\u001a\u00020\bHÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001b¨\u00065"}, d2 = {"Ldk/molslinjen/domain/model/config/SiteSupportInfo;", BuildConfig.FLAVOR, "contactInfo", "Ldk/molslinjen/domain/model/config/SiteSupportContact;", "openingHours", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/SiteSupportOpeningHours;", "lostAndFoundPageUrl", BuildConfig.FLAVOR, "suggestionsAndComplaintsPageUrl", "privacyPolicyPageUrl", "termsAndConditionsPageUrl", "<init>", "(Ldk/molslinjen/domain/model/config/SiteSupportContact;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteSupportInfoDTO;", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteSupportInfoDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/domain/model/config/SiteSupportContact;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getContactInfo", "()Ldk/molslinjen/domain/model/config/SiteSupportContact;", "getOpeningHours", "()Ljava/util/List;", "getLostAndFoundPageUrl", "()Ljava/lang/String;", "getSuggestionsAndComplaintsPageUrl", "getPrivacyPolicyPageUrl", "getTermsAndConditionsPageUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class SiteSupportInfo {
    private static final SiteSupportInfo mock;
    private final SiteSupportContact contactInfo;
    private final String lostAndFoundPageUrl;
    private final List<SiteSupportOpeningHours> openingHours;
    private final String privacyPolicyPageUrl;
    private final String suggestionsAndComplaintsPageUrl;
    private final String termsAndConditionsPageUrl;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(SiteSupportOpeningHours$$serializer.INSTANCE), null, null, null, null};

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/config/SiteSupportInfo$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/config/SiteSupportInfo;", "getMock", "()Ldk/molslinjen/domain/model/config/SiteSupportInfo;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SiteSupportInfo getMock() {
            return SiteSupportInfo.mock;
        }

        public final KSerializer<SiteSupportInfo> serializer() {
            return SiteSupportInfo$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        SiteSupportContact mock2 = SiteSupportContact.INSTANCE.getMock();
        SiteSupportOpeningHours.Companion companion = SiteSupportOpeningHours.INSTANCE;
        mock = new SiteSupportInfo(mock2, CollectionsKt.listOf((Object[]) new SiteSupportOpeningHours[]{companion.getMock(), companion.getMock()}), "https://www.molslinjen.dk/lost-and-found", "https://www.molslinjen.dk/suggestions-and-complaints", "https://qa.molslinjen.dk/alt-det-praktiske/persondatapolitik", "https://qa.molslinjen.dk/alt-det-praktiske");
    }

    public /* synthetic */ SiteSupportInfo(int i5, SiteSupportContact siteSupportContact, List list, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i5 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 63, SiteSupportInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.contactInfo = siteSupportContact;
        this.openingHours = list;
        this.lostAndFoundPageUrl = str;
        this.suggestionsAndComplaintsPageUrl = str2;
        this.privacyPolicyPageUrl = str3;
        this.termsAndConditionsPageUrl = str4;
    }

    public static /* synthetic */ SiteSupportInfo copy$default(SiteSupportInfo siteSupportInfo, SiteSupportContact siteSupportContact, List list, String str, String str2, String str3, String str4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            siteSupportContact = siteSupportInfo.contactInfo;
        }
        if ((i5 & 2) != 0) {
            list = siteSupportInfo.openingHours;
        }
        List list2 = list;
        if ((i5 & 4) != 0) {
            str = siteSupportInfo.lostAndFoundPageUrl;
        }
        String str5 = str;
        if ((i5 & 8) != 0) {
            str2 = siteSupportInfo.suggestionsAndComplaintsPageUrl;
        }
        String str6 = str2;
        if ((i5 & 16) != 0) {
            str3 = siteSupportInfo.privacyPolicyPageUrl;
        }
        String str7 = str3;
        if ((i5 & 32) != 0) {
            str4 = siteSupportInfo.termsAndConditionsPageUrl;
        }
        return siteSupportInfo.copy(siteSupportContact, list2, str5, str6, str7, str4);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(SiteSupportInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, SiteSupportContact$$serializer.INSTANCE, self.contactInfo);
        output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.openingHours);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.lostAndFoundPageUrl);
        output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.suggestionsAndComplaintsPageUrl);
        output.encodeNullableSerializableElement(serialDesc, 4, stringSerializer, self.privacyPolicyPageUrl);
        output.encodeNullableSerializableElement(serialDesc, 5, stringSerializer, self.termsAndConditionsPageUrl);
    }

    /* renamed from: component1, reason: from getter */
    public final SiteSupportContact getContactInfo() {
        return this.contactInfo;
    }

    public final List<SiteSupportOpeningHours> component2() {
        return this.openingHours;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLostAndFoundPageUrl() {
        return this.lostAndFoundPageUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSuggestionsAndComplaintsPageUrl() {
        return this.suggestionsAndComplaintsPageUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPrivacyPolicyPageUrl() {
        return this.privacyPolicyPageUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTermsAndConditionsPageUrl() {
        return this.termsAndConditionsPageUrl;
    }

    public final SiteSupportInfo copy(SiteSupportContact contactInfo, List<SiteSupportOpeningHours> openingHours, String lostAndFoundPageUrl, String suggestionsAndComplaintsPageUrl, String privacyPolicyPageUrl, String termsAndConditionsPageUrl) {
        Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
        return new SiteSupportInfo(contactInfo, openingHours, lostAndFoundPageUrl, suggestionsAndComplaintsPageUrl, privacyPolicyPageUrl, termsAndConditionsPageUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SiteSupportInfo)) {
            return false;
        }
        SiteSupportInfo siteSupportInfo = (SiteSupportInfo) other;
        return Intrinsics.areEqual(this.contactInfo, siteSupportInfo.contactInfo) && Intrinsics.areEqual(this.openingHours, siteSupportInfo.openingHours) && Intrinsics.areEqual(this.lostAndFoundPageUrl, siteSupportInfo.lostAndFoundPageUrl) && Intrinsics.areEqual(this.suggestionsAndComplaintsPageUrl, siteSupportInfo.suggestionsAndComplaintsPageUrl) && Intrinsics.areEqual(this.privacyPolicyPageUrl, siteSupportInfo.privacyPolicyPageUrl) && Intrinsics.areEqual(this.termsAndConditionsPageUrl, siteSupportInfo.termsAndConditionsPageUrl);
    }

    public final SiteSupportContact getContactInfo() {
        return this.contactInfo;
    }

    public final String getLostAndFoundPageUrl() {
        return this.lostAndFoundPageUrl;
    }

    public final List<SiteSupportOpeningHours> getOpeningHours() {
        return this.openingHours;
    }

    public final String getPrivacyPolicyPageUrl() {
        return this.privacyPolicyPageUrl;
    }

    public final String getSuggestionsAndComplaintsPageUrl() {
        return this.suggestionsAndComplaintsPageUrl;
    }

    public final String getTermsAndConditionsPageUrl() {
        return this.termsAndConditionsPageUrl;
    }

    public int hashCode() {
        int hashCode = this.contactInfo.hashCode() * 31;
        List<SiteSupportOpeningHours> list = this.openingHours;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.lostAndFoundPageUrl;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.suggestionsAndComplaintsPageUrl;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.privacyPolicyPageUrl;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.termsAndConditionsPageUrl;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "SiteSupportInfo(contactInfo=" + this.contactInfo + ", openingHours=" + this.openingHours + ", lostAndFoundPageUrl=" + this.lostAndFoundPageUrl + ", suggestionsAndComplaintsPageUrl=" + this.suggestionsAndComplaintsPageUrl + ", privacyPolicyPageUrl=" + this.privacyPolicyPageUrl + ", termsAndConditionsPageUrl=" + this.termsAndConditionsPageUrl + ")";
    }

    public SiteSupportInfo(SiteSupportContact contactInfo, List<SiteSupportOpeningHours> list, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
        this.contactInfo = contactInfo;
        this.openingHours = list;
        this.lostAndFoundPageUrl = str;
        this.suggestionsAndComplaintsPageUrl = str2;
        this.privacyPolicyPageUrl = str3;
        this.termsAndConditionsPageUrl = str4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SiteSupportInfo(ConfigurationResponseDTO.SiteSupportInfoDTO dto) {
        this(r2, r3, dto.getLostAndFoundPageUrl(), dto.getSuggestionsAndComplaintsPageUrl(), dto.getPrivacyPolicyPageUrl(), dto.getTermsAndConditionsPageUrl());
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(dto, "dto");
        SiteSupportContact siteSupportContact = new SiteSupportContact(dto.getContactInfo());
        List<ConfigurationResponseDTO.SiteSupportOpeningHourDTO> openingHours = dto.getOpeningHours();
        if (openingHours != null) {
            List<ConfigurationResponseDTO.SiteSupportOpeningHourDTO> list = openingHours;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(new SiteSupportOpeningHours((ConfigurationResponseDTO.SiteSupportOpeningHourDTO) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
    }
}
