package dk.molslinjen.api.services.config.response;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import dk.molslinjen.api.helpers.serializers.IntToEnumSerializer;
import dk.molslinjen.api.helpers.serializers.SerializableEnum;
import dk.molslinjen.api.shared.response.AreaDTO;
import dk.molslinjen.api.shared.response.AreaDTO$$serializer;
import dk.molslinjen.api.shared.response.HarborDTO;
import dk.molslinjen.api.shared.response.HarborDTO$$serializer;
import dk.molslinjen.api.shared.response.RouteTypeResponseDTO;
import dk.molslinjen.api.shared.response.SublineDTO;
import dk.molslinjen.api.shared.response.SublineDTO$$serializer;
import dk.molslinjen.api.shared.response.TransportResponseDTO;
import dk.molslinjen.api.shared.response.TransportResponseDTO$$serializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.Duration;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u0000 32\u00020\u0001:\u0014 !\"#$%&'()*+,-./0123B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u00064"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO;", BuildConfig.FLAVOR, "configs", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$ConfigDTO;", "<init>", "(Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConfigs$annotations", "()V", "getConfigs", "()Ljava/util/List;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "ConfigDTO", "LanguagesDTO", "LanguageSpecificConfigurationDTO", "TransportCategoryDTO", "CurrencyDTO", "RegionDTO", "RouteDTO", "RouteDirectionGroupDTO", "RouteDirectionDetailsDTO", "HarborReferenceDTO", "PassengerEntryTypeDTO", "MultiRideTypeDTO", "AgeClassificationsDTO", "AgeClassificationDTO", "SiteSupportInfoDTO", "SiteContactInfoDTO", "SiteSupportOpeningHourDTO", "SimpleFerryDTO", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class ConfigurationResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<ConfigDTO> configs;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B-\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ$\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationDTO;", BuildConfig.FLAVOR, "min", BuildConfig.FLAVOR, "max", "<init>", "(ILjava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMin", "()I", "getMax", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ILjava/lang/Integer;)Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationDTO;", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class AgeClassificationDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Integer max;
        private final int min;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<AgeClassificationDTO> serializer() {
                return ConfigurationResponseDTO$AgeClassificationDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ AgeClassificationDTO(int i5, int i6, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, ConfigurationResponseDTO$AgeClassificationDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.min = i6;
            this.max = num;
        }

        public static /* synthetic */ AgeClassificationDTO copy$default(AgeClassificationDTO ageClassificationDTO, int i5, Integer num, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i5 = ageClassificationDTO.min;
            }
            if ((i6 & 2) != 0) {
                num = ageClassificationDTO.max;
            }
            return ageClassificationDTO.copy(i5, num);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(AgeClassificationDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeIntElement(serialDesc, 0, self.min);
            output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.max);
        }

        /* renamed from: component1, reason: from getter */
        public final int getMin() {
            return this.min;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getMax() {
            return this.max;
        }

        public final AgeClassificationDTO copy(int min, Integer max) {
            return new AgeClassificationDTO(min, max);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AgeClassificationDTO)) {
                return false;
            }
            AgeClassificationDTO ageClassificationDTO = (AgeClassificationDTO) other;
            return this.min == ageClassificationDTO.min && Intrinsics.areEqual(this.max, ageClassificationDTO.max);
        }

        public final Integer getMax() {
            return this.max;
        }

        public final int getMin() {
            return this.min;
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.min) * 31;
            Integer num = this.max;
            return hashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "AgeClassificationDTO(min=" + this.min + ", max=" + this.max + ")";
        }

        public AgeClassificationDTO(int i5, Integer num) {
            this.min = i5;
            this.max = num;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006%"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationsDTO;", BuildConfig.FLAVOR, "infant", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationDTO;", "child", "adult", "<init>", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationDTO;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationDTO;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationDTO;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationDTO;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getInfant", "()Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationDTO;", "getChild", "getAdult", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class AgeClassificationsDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final AgeClassificationDTO adult;
        private final AgeClassificationDTO child;
        private final AgeClassificationDTO infant;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationsDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationsDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<AgeClassificationsDTO> serializer() {
                return ConfigurationResponseDTO$AgeClassificationsDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ AgeClassificationsDTO(int i5, AgeClassificationDTO ageClassificationDTO, AgeClassificationDTO ageClassificationDTO2, AgeClassificationDTO ageClassificationDTO3, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, ConfigurationResponseDTO$AgeClassificationsDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.infant = ageClassificationDTO;
            this.child = ageClassificationDTO2;
            this.adult = ageClassificationDTO3;
        }

        public static /* synthetic */ AgeClassificationsDTO copy$default(AgeClassificationsDTO ageClassificationsDTO, AgeClassificationDTO ageClassificationDTO, AgeClassificationDTO ageClassificationDTO2, AgeClassificationDTO ageClassificationDTO3, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                ageClassificationDTO = ageClassificationsDTO.infant;
            }
            if ((i5 & 2) != 0) {
                ageClassificationDTO2 = ageClassificationsDTO.child;
            }
            if ((i5 & 4) != 0) {
                ageClassificationDTO3 = ageClassificationsDTO.adult;
            }
            return ageClassificationsDTO.copy(ageClassificationDTO, ageClassificationDTO2, ageClassificationDTO3);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(AgeClassificationsDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            ConfigurationResponseDTO$AgeClassificationDTO$$serializer configurationResponseDTO$AgeClassificationDTO$$serializer = ConfigurationResponseDTO$AgeClassificationDTO$$serializer.INSTANCE;
            output.encodeSerializableElement(serialDesc, 0, configurationResponseDTO$AgeClassificationDTO$$serializer, self.infant);
            output.encodeSerializableElement(serialDesc, 1, configurationResponseDTO$AgeClassificationDTO$$serializer, self.child);
            output.encodeSerializableElement(serialDesc, 2, configurationResponseDTO$AgeClassificationDTO$$serializer, self.adult);
        }

        /* renamed from: component1, reason: from getter */
        public final AgeClassificationDTO getInfant() {
            return this.infant;
        }

        /* renamed from: component2, reason: from getter */
        public final AgeClassificationDTO getChild() {
            return this.child;
        }

        /* renamed from: component3, reason: from getter */
        public final AgeClassificationDTO getAdult() {
            return this.adult;
        }

        public final AgeClassificationsDTO copy(AgeClassificationDTO infant, AgeClassificationDTO child, AgeClassificationDTO adult) {
            Intrinsics.checkNotNullParameter(infant, "infant");
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(adult, "adult");
            return new AgeClassificationsDTO(infant, child, adult);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AgeClassificationsDTO)) {
                return false;
            }
            AgeClassificationsDTO ageClassificationsDTO = (AgeClassificationsDTO) other;
            return Intrinsics.areEqual(this.infant, ageClassificationsDTO.infant) && Intrinsics.areEqual(this.child, ageClassificationsDTO.child) && Intrinsics.areEqual(this.adult, ageClassificationsDTO.adult);
        }

        public final AgeClassificationDTO getAdult() {
            return this.adult;
        }

        public final AgeClassificationDTO getChild() {
            return this.child;
        }

        public final AgeClassificationDTO getInfant() {
            return this.infant;
        }

        public int hashCode() {
            return (((this.infant.hashCode() * 31) + this.child.hashCode()) * 31) + this.adult.hashCode();
        }

        public String toString() {
            return "AgeClassificationsDTO(infant=" + this.infant + ", child=" + this.child + ", adult=" + this.adult + ")";
        }

        public AgeClassificationsDTO(AgeClassificationDTO infant, AgeClassificationDTO child, AgeClassificationDTO adult) {
            Intrinsics.checkNotNullParameter(infant, "infant");
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(adult, "adult");
            this.infant = infant;
            this.child = child;
            this.adult = adult;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ConfigurationResponseDTO> serializer() {
            return ConfigurationResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$ConfigDTO;", BuildConfig.FLAVOR, "languages", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguagesDTO;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "<init>", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguagesDTO;Ldk/molslinjen/api/services/config/response/SiteDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguagesDTO;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLanguages", "()Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguagesDTO;", "getSite", "()Ldk/molslinjen/api/services/config/response/SiteDTO;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class ConfigDTO {
        private final LanguagesDTO languages;
        private final SiteDTO site;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.api.services.config.response.SiteDTO", SiteDTO.values())};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$ConfigDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$ConfigDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<ConfigDTO> serializer() {
                return ConfigurationResponseDTO$ConfigDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ConfigDTO(int i5, LanguagesDTO languagesDTO, SiteDTO siteDTO, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, ConfigurationResponseDTO$ConfigDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.languages = languagesDTO;
            this.site = siteDTO;
        }

        public static /* synthetic */ ConfigDTO copy$default(ConfigDTO configDTO, LanguagesDTO languagesDTO, SiteDTO siteDTO, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                languagesDTO = configDTO.languages;
            }
            if ((i5 & 2) != 0) {
                siteDTO = configDTO.site;
            }
            return configDTO.copy(languagesDTO, siteDTO);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(ConfigDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeSerializableElement(serialDesc, 0, ConfigurationResponseDTO$LanguagesDTO$$serializer.INSTANCE, self.languages);
            output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.site);
        }

        /* renamed from: component1, reason: from getter */
        public final LanguagesDTO getLanguages() {
            return this.languages;
        }

        /* renamed from: component2, reason: from getter */
        public final SiteDTO getSite() {
            return this.site;
        }

        public final ConfigDTO copy(LanguagesDTO languages, SiteDTO site) {
            Intrinsics.checkNotNullParameter(languages, "languages");
            Intrinsics.checkNotNullParameter(site, "site");
            return new ConfigDTO(languages, site);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConfigDTO)) {
                return false;
            }
            ConfigDTO configDTO = (ConfigDTO) other;
            return Intrinsics.areEqual(this.languages, configDTO.languages) && this.site == configDTO.site;
        }

        public final LanguagesDTO getLanguages() {
            return this.languages;
        }

        public final SiteDTO getSite() {
            return this.site;
        }

        public int hashCode() {
            return (this.languages.hashCode() * 31) + this.site.hashCode();
        }

        public String toString() {
            return "ConfigDTO(languages=" + this.languages + ", site=" + this.site + ")";
        }

        public ConfigDTO(LanguagesDTO languages, SiteDTO site) {
            Intrinsics.checkNotNullParameter(languages, "languages");
            Intrinsics.checkNotNullParameter(site, "site");
            this.languages = languages;
            this.site = site;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0001¢\u0006\u0002\b\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$CurrencyDTO;", BuildConfig.FLAVOR, "currency", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCurrency", "()Ljava/lang/String;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class CurrencyDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String currency;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$CurrencyDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$CurrencyDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<CurrencyDTO> serializer() {
                return ConfigurationResponseDTO$CurrencyDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ CurrencyDTO(int i5, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i5 & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 1, ConfigurationResponseDTO$CurrencyDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.currency = str;
        }

        public static /* synthetic */ CurrencyDTO copy$default(CurrencyDTO currencyDTO, String str, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = currencyDTO.currency;
            }
            return currencyDTO.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCurrency() {
            return this.currency;
        }

        public final CurrencyDTO copy(String currency) {
            Intrinsics.checkNotNullParameter(currency, "currency");
            return new CurrencyDTO(currency);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CurrencyDTO) && Intrinsics.areEqual(this.currency, ((CurrencyDTO) other).currency);
        }

        public final String getCurrency() {
            return this.currency;
        }

        public int hashCode() {
            return this.currency.hashCode();
        }

        public String toString() {
            return "CurrencyDTO(currency=" + this.currency + ")";
        }

        public CurrencyDTO(String currency) {
            Intrinsics.checkNotNullParameter(currency, "currency");
            this.currency = currency;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBK\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u000eHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$HarborReferenceDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "region", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RegionDTO;", "isFrequentlyUsed", BuildConfig.FLAVOR, "area", "Ldk/molslinjen/api/shared/response/AreaDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RegionDTO;ZLdk/molslinjen/api/shared/response/AreaDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RegionDTO;ZLdk/molslinjen/api/shared/response/AreaDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getRegion", "()Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RegionDTO;", "()Z", "getArea", "()Ldk/molslinjen/api/shared/response/AreaDTO;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class HarborReferenceDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final AreaDTO area;
        private final String id;
        private final boolean isFrequentlyUsed;
        private final String name;
        private final RegionDTO region;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$HarborReferenceDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$HarborReferenceDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<HarborReferenceDTO> serializer() {
                return ConfigurationResponseDTO$HarborReferenceDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ HarborReferenceDTO(int i5, String str, String str2, RegionDTO regionDTO, boolean z5, AreaDTO areaDTO, SerializationConstructorMarker serializationConstructorMarker) {
            if (31 != (i5 & 31)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 31, ConfigurationResponseDTO$HarborReferenceDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.name = str2;
            this.region = regionDTO;
            this.isFrequentlyUsed = z5;
            this.area = areaDTO;
        }

        public static /* synthetic */ HarborReferenceDTO copy$default(HarborReferenceDTO harborReferenceDTO, String str, String str2, RegionDTO regionDTO, boolean z5, AreaDTO areaDTO, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = harborReferenceDTO.id;
            }
            if ((i5 & 2) != 0) {
                str2 = harborReferenceDTO.name;
            }
            String str3 = str2;
            if ((i5 & 4) != 0) {
                regionDTO = harborReferenceDTO.region;
            }
            RegionDTO regionDTO2 = regionDTO;
            if ((i5 & 8) != 0) {
                z5 = harborReferenceDTO.isFrequentlyUsed;
            }
            boolean z6 = z5;
            if ((i5 & 16) != 0) {
                areaDTO = harborReferenceDTO.area;
            }
            return harborReferenceDTO.copy(str, str3, regionDTO2, z6, areaDTO);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(HarborReferenceDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.name);
            output.encodeSerializableElement(serialDesc, 2, ConfigurationResponseDTO$RegionDTO$$serializer.INSTANCE, self.region);
            output.encodeBooleanElement(serialDesc, 3, self.isFrequentlyUsed);
            output.encodeNullableSerializableElement(serialDesc, 4, AreaDTO$$serializer.INSTANCE, self.area);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component3, reason: from getter */
        public final RegionDTO getRegion() {
            return this.region;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsFrequentlyUsed() {
            return this.isFrequentlyUsed;
        }

        /* renamed from: component5, reason: from getter */
        public final AreaDTO getArea() {
            return this.area;
        }

        public final HarborReferenceDTO copy(String id, String name, RegionDTO region, boolean isFrequentlyUsed, AreaDTO area) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(region, "region");
            return new HarborReferenceDTO(id, name, region, isFrequentlyUsed, area);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HarborReferenceDTO)) {
                return false;
            }
            HarborReferenceDTO harborReferenceDTO = (HarborReferenceDTO) other;
            return Intrinsics.areEqual(this.id, harborReferenceDTO.id) && Intrinsics.areEqual(this.name, harborReferenceDTO.name) && Intrinsics.areEqual(this.region, harborReferenceDTO.region) && this.isFrequentlyUsed == harborReferenceDTO.isFrequentlyUsed && Intrinsics.areEqual(this.area, harborReferenceDTO.area);
        }

        public final AreaDTO getArea() {
            return this.area;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final RegionDTO getRegion() {
            return this.region;
        }

        public int hashCode() {
            int hashCode = ((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.region.hashCode()) * 31) + Boolean.hashCode(this.isFrequentlyUsed)) * 31;
            AreaDTO areaDTO = this.area;
            return hashCode + (areaDTO == null ? 0 : areaDTO.hashCode());
        }

        public final boolean isFrequentlyUsed() {
            return this.isFrequentlyUsed;
        }

        public String toString() {
            return "HarborReferenceDTO(id=" + this.id + ", name=" + this.name + ", region=" + this.region + ", isFrequentlyUsed=" + this.isFrequentlyUsed + ", area=" + this.area + ")";
        }

        public HarborReferenceDTO(String id, String name, RegionDTO region, boolean z5, AreaDTO areaDTO) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(region, "region");
            this.id = id;
            this.name = name;
            this.region = region;
            this.isFrequentlyUsed = z5;
            this.area = areaDTO;
        }
    }

    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0002MNB\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006¢\u0006\u0004\b\u001a\u0010\u001bBÃ\u0001\b\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0006\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0006\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0006\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001a\u0010 J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006HÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\r0\u0006HÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006HÆ\u0003J\t\u0010<\u001a\u00020\u0015HÆ\u0003J\t\u0010=\u001a\u00020\u0017HÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006HÆ\u0003Jµ\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006HÆ\u0001J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\u001dHÖ\u0001J\t\u0010D\u001a\u00020\u0003HÖ\u0001J%\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\bLR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001c\u0010\u0016\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%¨\u0006O"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguageSpecificConfigurationDTO;", BuildConfig.FLAVOR, "lineName", BuildConfig.FLAVOR, "lineLogoUrl", "harbors", BuildConfig.FLAVOR, "Ldk/molslinjen/api/shared/response/HarborDTO;", "regions", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RegionDTO;", "routes", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDTO;", "transportCategories", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$TransportCategoryDTO;", "extraTransports", "Ldk/molslinjen/api/shared/response/TransportResponseDTO;", "tripCardTypes", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$MultiRideTypeDTO;", "ferries", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SimpleFerryDTO;", "ageClassifications", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationsDTO;", "supportInfo", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteSupportInfoDTO;", "enabledCurrencies", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$CurrencyDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationsDTO;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteSupportInfoDTO;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationsDTO;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteSupportInfoDTO;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLineName", "()Ljava/lang/String;", "getLineLogoUrl", "getHarbors", "()Ljava/util/List;", "getRegions", "getRoutes", "getTransportCategories", "getExtraTransports", "getTripCardTypes", "getFerries", "getAgeClassifications", "()Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationsDTO;", "getSupportInfo$annotations", "()V", "getSupportInfo", "()Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteSupportInfoDTO;", "getEnabledCurrencies", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class LanguageSpecificConfigurationDTO {
        private final AgeClassificationsDTO ageClassifications;
        private final List<CurrencyDTO> enabledCurrencies;
        private final List<TransportResponseDTO> extraTransports;
        private final List<SimpleFerryDTO> ferries;
        private final List<HarborDTO> harbors;
        private final String lineLogoUrl;
        private final String lineName;
        private final List<RegionDTO> regions;
        private final List<RouteDTO> routes;
        private final SiteSupportInfoDTO supportInfo;
        private final List<TransportCategoryDTO> transportCategories;
        private final List<MultiRideTypeDTO> tripCardTypes;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(HarborDTO$$serializer.INSTANCE), new ArrayListSerializer(ConfigurationResponseDTO$RegionDTO$$serializer.INSTANCE), new ArrayListSerializer(ConfigurationResponseDTO$RouteDTO$$serializer.INSTANCE), new ArrayListSerializer(ConfigurationResponseDTO$TransportCategoryDTO$$serializer.INSTANCE), new ArrayListSerializer(TransportResponseDTO$$serializer.INSTANCE), new ArrayListSerializer(ConfigurationResponseDTO$MultiRideTypeDTO$$serializer.INSTANCE), new ArrayListSerializer(ConfigurationResponseDTO$SimpleFerryDTO$$serializer.INSTANCE), null, null, new ArrayListSerializer(ConfigurationResponseDTO$CurrencyDTO$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguageSpecificConfigurationDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<LanguageSpecificConfigurationDTO> serializer() {
                return ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ LanguageSpecificConfigurationDTO(int i5, String str, String str2, List list, List list2, List list3, List list4, List list5, List list6, List list7, AgeClassificationsDTO ageClassificationsDTO, SiteSupportInfoDTO siteSupportInfoDTO, List list8, SerializationConstructorMarker serializationConstructorMarker) {
            if (4085 != (i5 & 4085)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 4085, ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.lineName = str;
            if ((i5 & 2) == 0) {
                this.lineLogoUrl = null;
            } else {
                this.lineLogoUrl = str2;
            }
            this.harbors = list;
            if ((i5 & 8) == 0) {
                this.regions = null;
            } else {
                this.regions = list2;
            }
            this.routes = list3;
            this.transportCategories = list4;
            this.extraTransports = list5;
            this.tripCardTypes = list6;
            this.ferries = list7;
            this.ageClassifications = ageClassificationsDTO;
            this.supportInfo = siteSupportInfoDTO;
            this.enabledCurrencies = list8;
        }

        public static /* synthetic */ void getSupportInfo$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(LanguageSpecificConfigurationDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.lineName);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.lineLogoUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.lineLogoUrl);
            }
            output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.harbors);
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.regions != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, kSerializerArr[3], self.regions);
            }
            output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.routes);
            output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.transportCategories);
            output.encodeSerializableElement(serialDesc, 6, kSerializerArr[6], self.extraTransports);
            output.encodeSerializableElement(serialDesc, 7, kSerializerArr[7], self.tripCardTypes);
            output.encodeSerializableElement(serialDesc, 8, kSerializerArr[8], self.ferries);
            output.encodeSerializableElement(serialDesc, 9, ConfigurationResponseDTO$AgeClassificationsDTO$$serializer.INSTANCE, self.ageClassifications);
            output.encodeSerializableElement(serialDesc, 10, ConfigurationResponseDTO$SiteSupportInfoDTO$$serializer.INSTANCE, self.supportInfo);
            output.encodeSerializableElement(serialDesc, 11, kSerializerArr[11], self.enabledCurrencies);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLineName() {
            return this.lineName;
        }

        /* renamed from: component10, reason: from getter */
        public final AgeClassificationsDTO getAgeClassifications() {
            return this.ageClassifications;
        }

        /* renamed from: component11, reason: from getter */
        public final SiteSupportInfoDTO getSupportInfo() {
            return this.supportInfo;
        }

        public final List<CurrencyDTO> component12() {
            return this.enabledCurrencies;
        }

        /* renamed from: component2, reason: from getter */
        public final String getLineLogoUrl() {
            return this.lineLogoUrl;
        }

        public final List<HarborDTO> component3() {
            return this.harbors;
        }

        public final List<RegionDTO> component4() {
            return this.regions;
        }

        public final List<RouteDTO> component5() {
            return this.routes;
        }

        public final List<TransportCategoryDTO> component6() {
            return this.transportCategories;
        }

        public final List<TransportResponseDTO> component7() {
            return this.extraTransports;
        }

        public final List<MultiRideTypeDTO> component8() {
            return this.tripCardTypes;
        }

        public final List<SimpleFerryDTO> component9() {
            return this.ferries;
        }

        public final LanguageSpecificConfigurationDTO copy(String lineName, String lineLogoUrl, List<HarborDTO> harbors, List<RegionDTO> regions, List<RouteDTO> routes, List<TransportCategoryDTO> transportCategories, List<TransportResponseDTO> extraTransports, List<MultiRideTypeDTO> tripCardTypes, List<SimpleFerryDTO> ferries, AgeClassificationsDTO ageClassifications, SiteSupportInfoDTO supportInfo, List<CurrencyDTO> enabledCurrencies) {
            Intrinsics.checkNotNullParameter(lineName, "lineName");
            Intrinsics.checkNotNullParameter(harbors, "harbors");
            Intrinsics.checkNotNullParameter(routes, "routes");
            Intrinsics.checkNotNullParameter(transportCategories, "transportCategories");
            Intrinsics.checkNotNullParameter(extraTransports, "extraTransports");
            Intrinsics.checkNotNullParameter(tripCardTypes, "tripCardTypes");
            Intrinsics.checkNotNullParameter(ferries, "ferries");
            Intrinsics.checkNotNullParameter(ageClassifications, "ageClassifications");
            Intrinsics.checkNotNullParameter(supportInfo, "supportInfo");
            Intrinsics.checkNotNullParameter(enabledCurrencies, "enabledCurrencies");
            return new LanguageSpecificConfigurationDTO(lineName, lineLogoUrl, harbors, regions, routes, transportCategories, extraTransports, tripCardTypes, ferries, ageClassifications, supportInfo, enabledCurrencies);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LanguageSpecificConfigurationDTO)) {
                return false;
            }
            LanguageSpecificConfigurationDTO languageSpecificConfigurationDTO = (LanguageSpecificConfigurationDTO) other;
            return Intrinsics.areEqual(this.lineName, languageSpecificConfigurationDTO.lineName) && Intrinsics.areEqual(this.lineLogoUrl, languageSpecificConfigurationDTO.lineLogoUrl) && Intrinsics.areEqual(this.harbors, languageSpecificConfigurationDTO.harbors) && Intrinsics.areEqual(this.regions, languageSpecificConfigurationDTO.regions) && Intrinsics.areEqual(this.routes, languageSpecificConfigurationDTO.routes) && Intrinsics.areEqual(this.transportCategories, languageSpecificConfigurationDTO.transportCategories) && Intrinsics.areEqual(this.extraTransports, languageSpecificConfigurationDTO.extraTransports) && Intrinsics.areEqual(this.tripCardTypes, languageSpecificConfigurationDTO.tripCardTypes) && Intrinsics.areEqual(this.ferries, languageSpecificConfigurationDTO.ferries) && Intrinsics.areEqual(this.ageClassifications, languageSpecificConfigurationDTO.ageClassifications) && Intrinsics.areEqual(this.supportInfo, languageSpecificConfigurationDTO.supportInfo) && Intrinsics.areEqual(this.enabledCurrencies, languageSpecificConfigurationDTO.enabledCurrencies);
        }

        public final AgeClassificationsDTO getAgeClassifications() {
            return this.ageClassifications;
        }

        public final List<CurrencyDTO> getEnabledCurrencies() {
            return this.enabledCurrencies;
        }

        public final List<TransportResponseDTO> getExtraTransports() {
            return this.extraTransports;
        }

        public final List<SimpleFerryDTO> getFerries() {
            return this.ferries;
        }

        public final List<HarborDTO> getHarbors() {
            return this.harbors;
        }

        public final String getLineLogoUrl() {
            return this.lineLogoUrl;
        }

        public final String getLineName() {
            return this.lineName;
        }

        public final List<RegionDTO> getRegions() {
            return this.regions;
        }

        public final List<RouteDTO> getRoutes() {
            return this.routes;
        }

        public final SiteSupportInfoDTO getSupportInfo() {
            return this.supportInfo;
        }

        public final List<TransportCategoryDTO> getTransportCategories() {
            return this.transportCategories;
        }

        public final List<MultiRideTypeDTO> getTripCardTypes() {
            return this.tripCardTypes;
        }

        public int hashCode() {
            int hashCode = this.lineName.hashCode() * 31;
            String str = this.lineLogoUrl;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.harbors.hashCode()) * 31;
            List<RegionDTO> list = this.regions;
            return ((((((((((((((((hashCode2 + (list != null ? list.hashCode() : 0)) * 31) + this.routes.hashCode()) * 31) + this.transportCategories.hashCode()) * 31) + this.extraTransports.hashCode()) * 31) + this.tripCardTypes.hashCode()) * 31) + this.ferries.hashCode()) * 31) + this.ageClassifications.hashCode()) * 31) + this.supportInfo.hashCode()) * 31) + this.enabledCurrencies.hashCode();
        }

        public String toString() {
            return "LanguageSpecificConfigurationDTO(lineName=" + this.lineName + ", lineLogoUrl=" + this.lineLogoUrl + ", harbors=" + this.harbors + ", regions=" + this.regions + ", routes=" + this.routes + ", transportCategories=" + this.transportCategories + ", extraTransports=" + this.extraTransports + ", tripCardTypes=" + this.tripCardTypes + ", ferries=" + this.ferries + ", ageClassifications=" + this.ageClassifications + ", supportInfo=" + this.supportInfo + ", enabledCurrencies=" + this.enabledCurrencies + ")";
        }

        public LanguageSpecificConfigurationDTO(String lineName, String str, List<HarborDTO> harbors, List<RegionDTO> list, List<RouteDTO> routes, List<TransportCategoryDTO> transportCategories, List<TransportResponseDTO> extraTransports, List<MultiRideTypeDTO> tripCardTypes, List<SimpleFerryDTO> ferries, AgeClassificationsDTO ageClassifications, SiteSupportInfoDTO supportInfo, List<CurrencyDTO> enabledCurrencies) {
            Intrinsics.checkNotNullParameter(lineName, "lineName");
            Intrinsics.checkNotNullParameter(harbors, "harbors");
            Intrinsics.checkNotNullParameter(routes, "routes");
            Intrinsics.checkNotNullParameter(transportCategories, "transportCategories");
            Intrinsics.checkNotNullParameter(extraTransports, "extraTransports");
            Intrinsics.checkNotNullParameter(tripCardTypes, "tripCardTypes");
            Intrinsics.checkNotNullParameter(ferries, "ferries");
            Intrinsics.checkNotNullParameter(ageClassifications, "ageClassifications");
            Intrinsics.checkNotNullParameter(supportInfo, "supportInfo");
            Intrinsics.checkNotNullParameter(enabledCurrencies, "enabledCurrencies");
            this.lineName = lineName;
            this.lineLogoUrl = str;
            this.harbors = harbors;
            this.regions = list;
            this.routes = routes;
            this.transportCategories = transportCategories;
            this.extraTransports = extraTransports;
            this.tripCardTypes = tripCardTypes;
            this.ferries = ferries;
            this.ageClassifications = ageClassifications;
            this.supportInfo = supportInfo;
            this.enabledCurrencies = enabledCurrencies;
        }

        public /* synthetic */ LanguageSpecificConfigurationDTO(String str, String str2, List list, List list2, List list3, List list4, List list5, List list6, List list7, AgeClassificationsDTO ageClassificationsDTO, SiteSupportInfoDTO siteSupportInfoDTO, List list8, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i5 & 2) != 0 ? null : str2, list, (i5 & 8) != 0 ? null : list2, list3, list4, list5, list6, list7, ageClassificationsDTO, siteSupportInfoDTO, list8);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010¨\u0006)"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguagesDTO;", BuildConfig.FLAVOR, "danish", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguageSpecificConfigurationDTO;", "english", "swedish", "<init>", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguageSpecificConfigurationDTO;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguageSpecificConfigurationDTO;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguageSpecificConfigurationDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguageSpecificConfigurationDTO;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguageSpecificConfigurationDTO;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguageSpecificConfigurationDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDanish$annotations", "()V", "getDanish", "()Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguageSpecificConfigurationDTO;", "getEnglish$annotations", "getEnglish", "getSwedish$annotations", "getSwedish", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class LanguagesDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final LanguageSpecificConfigurationDTO danish;
        private final LanguageSpecificConfigurationDTO english;
        private final LanguageSpecificConfigurationDTO swedish;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguagesDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguagesDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<LanguagesDTO> serializer() {
                return ConfigurationResponseDTO$LanguagesDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ LanguagesDTO(int i5, LanguageSpecificConfigurationDTO languageSpecificConfigurationDTO, LanguageSpecificConfigurationDTO languageSpecificConfigurationDTO2, LanguageSpecificConfigurationDTO languageSpecificConfigurationDTO3, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, ConfigurationResponseDTO$LanguagesDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.danish = languageSpecificConfigurationDTO;
            this.english = languageSpecificConfigurationDTO2;
            this.swedish = languageSpecificConfigurationDTO3;
        }

        public static /* synthetic */ LanguagesDTO copy$default(LanguagesDTO languagesDTO, LanguageSpecificConfigurationDTO languageSpecificConfigurationDTO, LanguageSpecificConfigurationDTO languageSpecificConfigurationDTO2, LanguageSpecificConfigurationDTO languageSpecificConfigurationDTO3, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                languageSpecificConfigurationDTO = languagesDTO.danish;
            }
            if ((i5 & 2) != 0) {
                languageSpecificConfigurationDTO2 = languagesDTO.english;
            }
            if ((i5 & 4) != 0) {
                languageSpecificConfigurationDTO3 = languagesDTO.swedish;
            }
            return languagesDTO.copy(languageSpecificConfigurationDTO, languageSpecificConfigurationDTO2, languageSpecificConfigurationDTO3);
        }

        public static /* synthetic */ void getDanish$annotations() {
        }

        public static /* synthetic */ void getEnglish$annotations() {
        }

        public static /* synthetic */ void getSwedish$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(LanguagesDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer configurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer = ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer.INSTANCE;
            output.encodeSerializableElement(serialDesc, 0, configurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer, self.danish);
            output.encodeSerializableElement(serialDesc, 1, configurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer, self.english);
            output.encodeSerializableElement(serialDesc, 2, configurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer, self.swedish);
        }

        /* renamed from: component1, reason: from getter */
        public final LanguageSpecificConfigurationDTO getDanish() {
            return this.danish;
        }

        /* renamed from: component2, reason: from getter */
        public final LanguageSpecificConfigurationDTO getEnglish() {
            return this.english;
        }

        /* renamed from: component3, reason: from getter */
        public final LanguageSpecificConfigurationDTO getSwedish() {
            return this.swedish;
        }

        public final LanguagesDTO copy(LanguageSpecificConfigurationDTO danish, LanguageSpecificConfigurationDTO english, LanguageSpecificConfigurationDTO swedish) {
            Intrinsics.checkNotNullParameter(danish, "danish");
            Intrinsics.checkNotNullParameter(english, "english");
            Intrinsics.checkNotNullParameter(swedish, "swedish");
            return new LanguagesDTO(danish, english, swedish);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LanguagesDTO)) {
                return false;
            }
            LanguagesDTO languagesDTO = (LanguagesDTO) other;
            return Intrinsics.areEqual(this.danish, languagesDTO.danish) && Intrinsics.areEqual(this.english, languagesDTO.english) && Intrinsics.areEqual(this.swedish, languagesDTO.swedish);
        }

        public final LanguageSpecificConfigurationDTO getDanish() {
            return this.danish;
        }

        public final LanguageSpecificConfigurationDTO getEnglish() {
            return this.english;
        }

        public final LanguageSpecificConfigurationDTO getSwedish() {
            return this.swedish;
        }

        public int hashCode() {
            return (((this.danish.hashCode() * 31) + this.english.hashCode()) * 31) + this.swedish.hashCode();
        }

        public String toString() {
            return "LanguagesDTO(danish=" + this.danish + ", english=" + this.english + ", swedish=" + this.swedish + ")";
        }

        public LanguagesDTO(LanguageSpecificConfigurationDTO danish, LanguageSpecificConfigurationDTO english, LanguageSpecificConfigurationDTO swedish) {
            Intrinsics.checkNotNullParameter(danish, "danish");
            Intrinsics.checkNotNullParameter(english, "english");
            Intrinsics.checkNotNullParameter(swedish, "swedish");
            this.danish = danish;
            this.english = english;
            this.swedish = swedish;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bB?\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006&"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$MultiRideTypeDTO;", BuildConfig.FLAVOR, "allowedTransportIds", BuildConfig.FLAVOR, BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "name", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAllowedTransportIds", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class MultiRideTypeDTO {
        private final List<String> allowedTransportIds;
        private final String id;
        private final String name;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE), null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$MultiRideTypeDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$MultiRideTypeDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<MultiRideTypeDTO> serializer() {
                return ConfigurationResponseDTO$MultiRideTypeDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ MultiRideTypeDTO(int i5, List list, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, ConfigurationResponseDTO$MultiRideTypeDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.allowedTransportIds = list;
            this.id = str;
            this.name = str2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MultiRideTypeDTO copy$default(MultiRideTypeDTO multiRideTypeDTO, List list, String str, String str2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                list = multiRideTypeDTO.allowedTransportIds;
            }
            if ((i5 & 2) != 0) {
                str = multiRideTypeDTO.id;
            }
            if ((i5 & 4) != 0) {
                str2 = multiRideTypeDTO.name;
            }
            return multiRideTypeDTO.copy(list, str, str2);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(MultiRideTypeDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.allowedTransportIds);
            output.encodeStringElement(serialDesc, 1, self.id);
            output.encodeStringElement(serialDesc, 2, self.name);
        }

        public final List<String> component1() {
            return this.allowedTransportIds;
        }

        /* renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final MultiRideTypeDTO copy(List<String> allowedTransportIds, String id, String name) {
            Intrinsics.checkNotNullParameter(allowedTransportIds, "allowedTransportIds");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            return new MultiRideTypeDTO(allowedTransportIds, id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MultiRideTypeDTO)) {
                return false;
            }
            MultiRideTypeDTO multiRideTypeDTO = (MultiRideTypeDTO) other;
            return Intrinsics.areEqual(this.allowedTransportIds, multiRideTypeDTO.allowedTransportIds) && Intrinsics.areEqual(this.id, multiRideTypeDTO.id) && Intrinsics.areEqual(this.name, multiRideTypeDTO.name);
        }

        public final List<String> getAllowedTransportIds() {
            return this.allowedTransportIds;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (((this.allowedTransportIds.hashCode() * 31) + this.id.hashCode()) * 31) + this.name.hashCode();
        }

        public String toString() {
            return "MultiRideTypeDTO(allowedTransportIds=" + this.allowedTransportIds + ", id=" + this.id + ", name=" + this.name + ")";
        }

        public MultiRideTypeDTO(List<String> allowedTransportIds, String id, String name) {
            Intrinsics.checkNotNullParameter(allowedTransportIds, "allowedTransportIds");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            this.allowedTransportIds = allowedTransportIds;
            this.id = id;
            this.name = name;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002\r\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$PassengerEntryTypeDTO;", "Ldk/molslinjen/api/helpers/serializers/SerializableEnum;", BuildConfig.FLAVOR, "rawValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getRawValue", "()I", "None", "Standard", "AdultsAndChildren", "PassengersOnly", "Serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable(with = Serializer.class)
    /* loaded from: classes2.dex */
    public static final class PassengerEntryTypeDTO implements SerializableEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PassengerEntryTypeDTO[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int rawValue;
        public static final PassengerEntryTypeDTO None = new PassengerEntryTypeDTO("None", 0, 0);
        public static final PassengerEntryTypeDTO Standard = new PassengerEntryTypeDTO("Standard", 1, 1);
        public static final PassengerEntryTypeDTO AdultsAndChildren = new PassengerEntryTypeDTO("AdultsAndChildren", 2, 2);
        public static final PassengerEntryTypeDTO PassengersOnly = new PassengerEntryTypeDTO("PassengersOnly", 3, 3);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$PassengerEntryTypeDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$PassengerEntryTypeDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<PassengerEntryTypeDTO> serializer() {
                return Serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$PassengerEntryTypeDTO$Serializer;", "Ldk/molslinjen/api/helpers/serializers/IntToEnumSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$PassengerEntryTypeDTO;", "<init>", "()V", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Serializer extends IntToEnumSerializer<PassengerEntryTypeDTO> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(PassengerEntryTypeDTO.class);
            }
        }

        private static final /* synthetic */ PassengerEntryTypeDTO[] $values() {
            return new PassengerEntryTypeDTO[]{None, Standard, AdultsAndChildren, PassengersOnly};
        }

        static {
            PassengerEntryTypeDTO[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        private PassengerEntryTypeDTO(String str, int i5, int i6) {
            this.rawValue = i6;
        }

        public static EnumEntries<PassengerEntryTypeDTO> getEntries() {
            return $ENTRIES;
        }

        public static PassengerEntryTypeDTO valueOf(String str) {
            return (PassengerEntryTypeDTO) Enum.valueOf(PassengerEntryTypeDTO.class, str);
        }

        public static PassengerEntryTypeDTO[] values() {
            return (PassengerEntryTypeDTO[]) $VALUES.clone();
        }

        @Override // dk.molslinjen.api.helpers.serializers.SerializableEnum
        public int getRawValue() {
            return this.rawValue;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006!"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RegionDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class RegionDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;
        private final String name;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RegionDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RegionDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<RegionDTO> serializer() {
                return ConfigurationResponseDTO$RegionDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ RegionDTO(int i5, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, ConfigurationResponseDTO$RegionDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.name = str2;
        }

        public static /* synthetic */ RegionDTO copy$default(RegionDTO regionDTO, String str, String str2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = regionDTO.id;
            }
            if ((i5 & 2) != 0) {
                str2 = regionDTO.name;
            }
            return regionDTO.copy(str, str2);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(RegionDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.name);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final RegionDTO copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            return new RegionDTO(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RegionDTO)) {
                return false;
            }
            RegionDTO regionDTO = (RegionDTO) other;
            return Intrinsics.areEqual(this.id, regionDTO.id) && Intrinsics.areEqual(this.name, regionDTO.name);
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.name.hashCode();
        }

        public String toString() {
            return "RegionDTO(id=" + this.id + ", name=" + this.name + ")";
        }

        public RegionDTO(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            this.id = id;
            this.name = name;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006&"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "outRoute", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionGroupDTO;", "returnRoute", "<init>", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionGroupDTO;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionGroupDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionGroupDTO;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionGroupDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getOutRoute", "()Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionGroupDTO;", "getReturnRoute", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class RouteDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;
        private final RouteDirectionGroupDTO outRoute;
        private final RouteDirectionGroupDTO returnRoute;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<RouteDTO> serializer() {
                return ConfigurationResponseDTO$RouteDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ RouteDTO(int i5, String str, RouteDirectionGroupDTO routeDirectionGroupDTO, RouteDirectionGroupDTO routeDirectionGroupDTO2, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, ConfigurationResponseDTO$RouteDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.outRoute = routeDirectionGroupDTO;
            this.returnRoute = routeDirectionGroupDTO2;
        }

        public static /* synthetic */ RouteDTO copy$default(RouteDTO routeDTO, String str, RouteDirectionGroupDTO routeDirectionGroupDTO, RouteDirectionGroupDTO routeDirectionGroupDTO2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = routeDTO.id;
            }
            if ((i5 & 2) != 0) {
                routeDirectionGroupDTO = routeDTO.outRoute;
            }
            if ((i5 & 4) != 0) {
                routeDirectionGroupDTO2 = routeDTO.returnRoute;
            }
            return routeDTO.copy(str, routeDirectionGroupDTO, routeDirectionGroupDTO2);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(RouteDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.id);
            ConfigurationResponseDTO$RouteDirectionGroupDTO$$serializer configurationResponseDTO$RouteDirectionGroupDTO$$serializer = ConfigurationResponseDTO$RouteDirectionGroupDTO$$serializer.INSTANCE;
            output.encodeSerializableElement(serialDesc, 1, configurationResponseDTO$RouteDirectionGroupDTO$$serializer, self.outRoute);
            output.encodeSerializableElement(serialDesc, 2, configurationResponseDTO$RouteDirectionGroupDTO$$serializer, self.returnRoute);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final RouteDirectionGroupDTO getOutRoute() {
            return this.outRoute;
        }

        /* renamed from: component3, reason: from getter */
        public final RouteDirectionGroupDTO getReturnRoute() {
            return this.returnRoute;
        }

        public final RouteDTO copy(String id, RouteDirectionGroupDTO outRoute, RouteDirectionGroupDTO returnRoute) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(outRoute, "outRoute");
            Intrinsics.checkNotNullParameter(returnRoute, "returnRoute");
            return new RouteDTO(id, outRoute, returnRoute);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RouteDTO)) {
                return false;
            }
            RouteDTO routeDTO = (RouteDTO) other;
            return Intrinsics.areEqual(this.id, routeDTO.id) && Intrinsics.areEqual(this.outRoute, routeDTO.outRoute) && Intrinsics.areEqual(this.returnRoute, routeDTO.returnRoute);
        }

        public final String getId() {
            return this.id;
        }

        public final RouteDirectionGroupDTO getOutRoute() {
            return this.outRoute;
        }

        public final RouteDirectionGroupDTO getReturnRoute() {
            return this.returnRoute;
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.outRoute.hashCode()) * 31) + this.returnRoute.hashCode();
        }

        public String toString() {
            return "RouteDTO(id=" + this.id + ", outRoute=" + this.outRoute + ", returnRoute=" + this.returnRoute + ")";
        }

        public RouteDTO(String id, RouteDirectionGroupDTO outRoute, RouteDirectionGroupDTO returnRoute) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(outRoute, "outRoute");
            Intrinsics.checkNotNullParameter(returnRoute, "returnRoute");
            this.id = id;
            this.outRoute = outRoute;
            this.returnRoute = returnRoute;
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 E2\u00020\u0001:\u0002DEBg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015B\u0087\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0014\u0010\u001aJ\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\fHÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u007f\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001J\u0013\u00108\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0017HÖ\u0001J\t\u0010;\u001a\u00020\tHÖ\u0001J%\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0001¢\u0006\u0002\bCR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u001cR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006F"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionDetailsDTO;", BuildConfig.FLAVOR, "allowDangerousGoods", BuildConfig.FLAVOR, "arrivalHarbor", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$HarborReferenceDTO;", "departureHarbor", "askForPersonData", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "travelTime", "Lorg/threeten/bp/Duration;", "routeTypes", BuildConfig.FLAVOR, "Ldk/molslinjen/api/shared/response/RouteTypeResponseDTO;", "isSubRoute", "isEarlyCheckInPossible", "subline", "Ldk/molslinjen/api/shared/response/SublineDTO;", "<init>", "(ZLdk/molslinjen/api/services/config/response/ConfigurationResponseDTO$HarborReferenceDTO;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$HarborReferenceDTO;ZLjava/lang/String;Ljava/lang/String;Lorg/threeten/bp/Duration;Ljava/util/List;ZZLdk/molslinjen/api/shared/response/SublineDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLdk/molslinjen/api/services/config/response/ConfigurationResponseDTO$HarborReferenceDTO;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$HarborReferenceDTO;ZLjava/lang/String;Ljava/lang/String;Lorg/threeten/bp/Duration;Ljava/util/List;ZZLdk/molslinjen/api/shared/response/SublineDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAllowDangerousGoods", "()Z", "getArrivalHarbor", "()Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$HarborReferenceDTO;", "getDepartureHarbor", "getAskForPersonData", "getId", "()Ljava/lang/String;", "getName", "getTravelTime$annotations", "()V", "getTravelTime", "()Lorg/threeten/bp/Duration;", "getRouteTypes", "()Ljava/util/List;", "getSubline", "()Ldk/molslinjen/api/shared/response/SublineDTO;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class RouteDirectionDetailsDTO {
        private final boolean allowDangerousGoods;
        private final HarborReferenceDTO arrivalHarbor;
        private final boolean askForPersonData;
        private final HarborReferenceDTO departureHarbor;
        private final String id;
        private final boolean isEarlyCheckInPossible;
        private final boolean isSubRoute;
        private final String name;
        private final List<RouteTypeResponseDTO> routeTypes;
        private final SublineDTO subline;
        private final Duration travelTime;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, new ArrayListSerializer(RouteTypeResponseDTO.Serializer.INSTANCE), null, null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionDetailsDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionDetailsDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<RouteDirectionDetailsDTO> serializer() {
                return ConfigurationResponseDTO$RouteDirectionDetailsDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ RouteDirectionDetailsDTO(int i5, boolean z5, HarborReferenceDTO harborReferenceDTO, HarborReferenceDTO harborReferenceDTO2, boolean z6, String str, String str2, Duration duration, List list, boolean z7, boolean z8, SublineDTO sublineDTO, SerializationConstructorMarker serializationConstructorMarker) {
            if (2047 != (i5 & 2047)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 2047, ConfigurationResponseDTO$RouteDirectionDetailsDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.allowDangerousGoods = z5;
            this.arrivalHarbor = harborReferenceDTO;
            this.departureHarbor = harborReferenceDTO2;
            this.askForPersonData = z6;
            this.id = str;
            this.name = str2;
            this.travelTime = duration;
            this.routeTypes = list;
            this.isSubRoute = z7;
            this.isEarlyCheckInPossible = z8;
            this.subline = sublineDTO;
        }

        @Serializable(with = DurationSerializer.class)
        public static /* synthetic */ void getTravelTime$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(RouteDirectionDetailsDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeBooleanElement(serialDesc, 0, self.allowDangerousGoods);
            ConfigurationResponseDTO$HarborReferenceDTO$$serializer configurationResponseDTO$HarborReferenceDTO$$serializer = ConfigurationResponseDTO$HarborReferenceDTO$$serializer.INSTANCE;
            output.encodeSerializableElement(serialDesc, 1, configurationResponseDTO$HarborReferenceDTO$$serializer, self.arrivalHarbor);
            output.encodeSerializableElement(serialDesc, 2, configurationResponseDTO$HarborReferenceDTO$$serializer, self.departureHarbor);
            output.encodeBooleanElement(serialDesc, 3, self.askForPersonData);
            output.encodeStringElement(serialDesc, 4, self.id);
            output.encodeStringElement(serialDesc, 5, self.name);
            output.encodeSerializableElement(serialDesc, 6, DurationSerializer.INSTANCE, self.travelTime);
            output.encodeSerializableElement(serialDesc, 7, kSerializerArr[7], self.routeTypes);
            output.encodeBooleanElement(serialDesc, 8, self.isSubRoute);
            output.encodeBooleanElement(serialDesc, 9, self.isEarlyCheckInPossible);
            output.encodeNullableSerializableElement(serialDesc, 10, SublineDTO$$serializer.INSTANCE, self.subline);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getAllowDangerousGoods() {
            return this.allowDangerousGoods;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getIsEarlyCheckInPossible() {
            return this.isEarlyCheckInPossible;
        }

        /* renamed from: component11, reason: from getter */
        public final SublineDTO getSubline() {
            return this.subline;
        }

        /* renamed from: component2, reason: from getter */
        public final HarborReferenceDTO getArrivalHarbor() {
            return this.arrivalHarbor;
        }

        /* renamed from: component3, reason: from getter */
        public final HarborReferenceDTO getDepartureHarbor() {
            return this.departureHarbor;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getAskForPersonData() {
            return this.askForPersonData;
        }

        /* renamed from: component5, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component6, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component7, reason: from getter */
        public final Duration getTravelTime() {
            return this.travelTime;
        }

        public final List<RouteTypeResponseDTO> component8() {
            return this.routeTypes;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getIsSubRoute() {
            return this.isSubRoute;
        }

        public final RouteDirectionDetailsDTO copy(boolean allowDangerousGoods, HarborReferenceDTO arrivalHarbor, HarborReferenceDTO departureHarbor, boolean askForPersonData, String id, String name, Duration travelTime, List<? extends RouteTypeResponseDTO> routeTypes, boolean isSubRoute, boolean isEarlyCheckInPossible, SublineDTO subline) {
            Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
            Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(travelTime, "travelTime");
            Intrinsics.checkNotNullParameter(routeTypes, "routeTypes");
            return new RouteDirectionDetailsDTO(allowDangerousGoods, arrivalHarbor, departureHarbor, askForPersonData, id, name, travelTime, routeTypes, isSubRoute, isEarlyCheckInPossible, subline);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RouteDirectionDetailsDTO)) {
                return false;
            }
            RouteDirectionDetailsDTO routeDirectionDetailsDTO = (RouteDirectionDetailsDTO) other;
            return this.allowDangerousGoods == routeDirectionDetailsDTO.allowDangerousGoods && Intrinsics.areEqual(this.arrivalHarbor, routeDirectionDetailsDTO.arrivalHarbor) && Intrinsics.areEqual(this.departureHarbor, routeDirectionDetailsDTO.departureHarbor) && this.askForPersonData == routeDirectionDetailsDTO.askForPersonData && Intrinsics.areEqual(this.id, routeDirectionDetailsDTO.id) && Intrinsics.areEqual(this.name, routeDirectionDetailsDTO.name) && Intrinsics.areEqual(this.travelTime, routeDirectionDetailsDTO.travelTime) && Intrinsics.areEqual(this.routeTypes, routeDirectionDetailsDTO.routeTypes) && this.isSubRoute == routeDirectionDetailsDTO.isSubRoute && this.isEarlyCheckInPossible == routeDirectionDetailsDTO.isEarlyCheckInPossible && Intrinsics.areEqual(this.subline, routeDirectionDetailsDTO.subline);
        }

        public final boolean getAllowDangerousGoods() {
            return this.allowDangerousGoods;
        }

        public final HarborReferenceDTO getArrivalHarbor() {
            return this.arrivalHarbor;
        }

        public final boolean getAskForPersonData() {
            return this.askForPersonData;
        }

        public final HarborReferenceDTO getDepartureHarbor() {
            return this.departureHarbor;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final List<RouteTypeResponseDTO> getRouteTypes() {
            return this.routeTypes;
        }

        public final SublineDTO getSubline() {
            return this.subline;
        }

        public final Duration getTravelTime() {
            return this.travelTime;
        }

        public int hashCode() {
            int hashCode = ((((((((((((((((((Boolean.hashCode(this.allowDangerousGoods) * 31) + this.arrivalHarbor.hashCode()) * 31) + this.departureHarbor.hashCode()) * 31) + Boolean.hashCode(this.askForPersonData)) * 31) + this.id.hashCode()) * 31) + this.name.hashCode()) * 31) + this.travelTime.hashCode()) * 31) + this.routeTypes.hashCode()) * 31) + Boolean.hashCode(this.isSubRoute)) * 31) + Boolean.hashCode(this.isEarlyCheckInPossible)) * 31;
            SublineDTO sublineDTO = this.subline;
            return hashCode + (sublineDTO == null ? 0 : sublineDTO.hashCode());
        }

        public final boolean isEarlyCheckInPossible() {
            return this.isEarlyCheckInPossible;
        }

        public final boolean isSubRoute() {
            return this.isSubRoute;
        }

        public String toString() {
            return "RouteDirectionDetailsDTO(allowDangerousGoods=" + this.allowDangerousGoods + ", arrivalHarbor=" + this.arrivalHarbor + ", departureHarbor=" + this.departureHarbor + ", askForPersonData=" + this.askForPersonData + ", id=" + this.id + ", name=" + this.name + ", travelTime=" + this.travelTime + ", routeTypes=" + this.routeTypes + ", isSubRoute=" + this.isSubRoute + ", isEarlyCheckInPossible=" + this.isEarlyCheckInPossible + ", subline=" + this.subline + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RouteDirectionDetailsDTO(boolean z5, HarborReferenceDTO arrivalHarbor, HarborReferenceDTO departureHarbor, boolean z6, String id, String name, Duration travelTime, List<? extends RouteTypeResponseDTO> routeTypes, boolean z7, boolean z8, SublineDTO sublineDTO) {
            Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
            Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(travelTime, "travelTime");
            Intrinsics.checkNotNullParameter(routeTypes, "routeTypes");
            this.allowDangerousGoods = z5;
            this.arrivalHarbor = arrivalHarbor;
            this.departureHarbor = departureHarbor;
            this.askForPersonData = z6;
            this.id = id;
            this.name = name;
            this.travelTime = travelTime;
            this.routeTypes = routeTypes;
            this.isSubRoute = z7;
            this.isEarlyCheckInPossible = z8;
            this.subline = sublineDTO;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionGroupDTO;", BuildConfig.FLAVOR, "mainRouteId", BuildConfig.FLAVOR, "name", "routes", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionDetailsDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMainRouteId$annotations", "()V", "getMainRouteId", "()Ljava/lang/String;", "getName", "getRoutes", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class RouteDirectionGroupDTO {
        private final String mainRouteId;
        private final String name;
        private final List<RouteDirectionDetailsDTO> routes;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(ConfigurationResponseDTO$RouteDirectionDetailsDTO$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionGroupDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionGroupDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<RouteDirectionGroupDTO> serializer() {
                return ConfigurationResponseDTO$RouteDirectionGroupDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ RouteDirectionGroupDTO(int i5, String str, String str2, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, ConfigurationResponseDTO$RouteDirectionGroupDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.mainRouteId = str;
            this.name = str2;
            this.routes = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RouteDirectionGroupDTO copy$default(RouteDirectionGroupDTO routeDirectionGroupDTO, String str, String str2, List list, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = routeDirectionGroupDTO.mainRouteId;
            }
            if ((i5 & 2) != 0) {
                str2 = routeDirectionGroupDTO.name;
            }
            if ((i5 & 4) != 0) {
                list = routeDirectionGroupDTO.routes;
            }
            return routeDirectionGroupDTO.copy(str, str2, list);
        }

        public static /* synthetic */ void getMainRouteId$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(RouteDirectionGroupDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.mainRouteId);
            output.encodeStringElement(serialDesc, 1, self.name);
            output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.routes);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMainRouteId() {
            return this.mainRouteId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final List<RouteDirectionDetailsDTO> component3() {
            return this.routes;
        }

        public final RouteDirectionGroupDTO copy(String mainRouteId, String name, List<RouteDirectionDetailsDTO> routes) {
            Intrinsics.checkNotNullParameter(mainRouteId, "mainRouteId");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(routes, "routes");
            return new RouteDirectionGroupDTO(mainRouteId, name, routes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RouteDirectionGroupDTO)) {
                return false;
            }
            RouteDirectionGroupDTO routeDirectionGroupDTO = (RouteDirectionGroupDTO) other;
            return Intrinsics.areEqual(this.mainRouteId, routeDirectionGroupDTO.mainRouteId) && Intrinsics.areEqual(this.name, routeDirectionGroupDTO.name) && Intrinsics.areEqual(this.routes, routeDirectionGroupDTO.routes);
        }

        public final String getMainRouteId() {
            return this.mainRouteId;
        }

        public final String getName() {
            return this.name;
        }

        public final List<RouteDirectionDetailsDTO> getRoutes() {
            return this.routes;
        }

        public int hashCode() {
            return (((this.mainRouteId.hashCode() * 31) + this.name.hashCode()) * 31) + this.routes.hashCode();
        }

        public String toString() {
            return "RouteDirectionGroupDTO(mainRouteId=" + this.mainRouteId + ", name=" + this.name + ", routes=" + this.routes + ")";
        }

        public RouteDirectionGroupDTO(String mainRouteId, String name, List<RouteDirectionDetailsDTO> routes) {
            Intrinsics.checkNotNullParameter(mainRouteId, "mainRouteId");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(routes, "routes");
            this.mainRouteId = mainRouteId;
            this.name = name;
            this.routes = routes;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006!"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SimpleFerryDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class SimpleFerryDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;
        private final String name;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SimpleFerryDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SimpleFerryDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<SimpleFerryDTO> serializer() {
                return ConfigurationResponseDTO$SimpleFerryDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ SimpleFerryDTO(int i5, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, ConfigurationResponseDTO$SimpleFerryDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.name = str2;
        }

        public static /* synthetic */ SimpleFerryDTO copy$default(SimpleFerryDTO simpleFerryDTO, String str, String str2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = simpleFerryDTO.id;
            }
            if ((i5 & 2) != 0) {
                str2 = simpleFerryDTO.name;
            }
            return simpleFerryDTO.copy(str, str2);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(SimpleFerryDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.name);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final SimpleFerryDTO copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            return new SimpleFerryDTO(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SimpleFerryDTO)) {
                return false;
            }
            SimpleFerryDTO simpleFerryDTO = (SimpleFerryDTO) other;
            return Intrinsics.areEqual(this.id, simpleFerryDTO.id) && Intrinsics.areEqual(this.name, simpleFerryDTO.name);
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.name.hashCode();
        }

        public String toString() {
            return "SimpleFerryDTO(id=" + this.id + ", name=" + this.name + ")";
        }

        public SimpleFerryDTO(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            this.id = id;
            this.name = name;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteContactInfoDTO;", BuildConfig.FLAVOR, "supportEmail", BuildConfig.FLAVOR, "supportPhoneNumber", "zendeskUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSupportEmail", "()Ljava/lang/String;", "getSupportPhoneNumber", "getZendeskUrl", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class SiteContactInfoDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String supportEmail;
        private final String supportPhoneNumber;
        private final String zendeskUrl;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteContactInfoDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteContactInfoDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<SiteContactInfoDTO> serializer() {
                return ConfigurationResponseDTO$SiteContactInfoDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ SiteContactInfoDTO(int i5, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, ConfigurationResponseDTO$SiteContactInfoDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.supportEmail = str;
            this.supportPhoneNumber = str2;
            this.zendeskUrl = str3;
        }

        public static /* synthetic */ SiteContactInfoDTO copy$default(SiteContactInfoDTO siteContactInfoDTO, String str, String str2, String str3, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = siteContactInfoDTO.supportEmail;
            }
            if ((i5 & 2) != 0) {
                str2 = siteContactInfoDTO.supportPhoneNumber;
            }
            if ((i5 & 4) != 0) {
                str3 = siteContactInfoDTO.zendeskUrl;
            }
            return siteContactInfoDTO.copy(str, str2, str3);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(SiteContactInfoDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.supportEmail);
            output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.supportPhoneNumber);
            output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.zendeskUrl);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSupportEmail() {
            return this.supportEmail;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSupportPhoneNumber() {
            return this.supportPhoneNumber;
        }

        /* renamed from: component3, reason: from getter */
        public final String getZendeskUrl() {
            return this.zendeskUrl;
        }

        public final SiteContactInfoDTO copy(String supportEmail, String supportPhoneNumber, String zendeskUrl) {
            return new SiteContactInfoDTO(supportEmail, supportPhoneNumber, zendeskUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SiteContactInfoDTO)) {
                return false;
            }
            SiteContactInfoDTO siteContactInfoDTO = (SiteContactInfoDTO) other;
            return Intrinsics.areEqual(this.supportEmail, siteContactInfoDTO.supportEmail) && Intrinsics.areEqual(this.supportPhoneNumber, siteContactInfoDTO.supportPhoneNumber) && Intrinsics.areEqual(this.zendeskUrl, siteContactInfoDTO.zendeskUrl);
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
            String str = this.supportEmail;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.supportPhoneNumber;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zendeskUrl;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "SiteContactInfoDTO(supportEmail=" + this.supportEmail + ", supportPhoneNumber=" + this.supportPhoneNumber + ", zendeskUrl=" + this.zendeskUrl + ")";
        }

        public SiteContactInfoDTO(String str, String str2, String str3) {
            this.supportEmail = str;
            this.supportPhoneNumber = str2;
            this.zendeskUrl = str3;
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000256BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eBg\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003Ja\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0010HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019¨\u00067"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteSupportInfoDTO;", BuildConfig.FLAVOR, "contactInfo", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteContactInfoDTO;", "supportPhoneNumber", BuildConfig.FLAVOR, "openingHours", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteSupportOpeningHourDTO;", "lostAndFoundPageUrl", "suggestionsAndComplaintsPageUrl", "privacyPolicyPageUrl", "termsAndConditionsPageUrl", "<init>", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteContactInfoDTO;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteContactInfoDTO;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getContactInfo$annotations", "()V", "getContactInfo", "()Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteContactInfoDTO;", "getSupportPhoneNumber", "()Ljava/lang/String;", "getOpeningHours", "()Ljava/util/List;", "getLostAndFoundPageUrl", "getSuggestionsAndComplaintsPageUrl", "getPrivacyPolicyPageUrl", "getTermsAndConditionsPageUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class SiteSupportInfoDTO {
        private final SiteContactInfoDTO contactInfo;
        private final String lostAndFoundPageUrl;
        private final List<SiteSupportOpeningHourDTO> openingHours;
        private final String privacyPolicyPageUrl;
        private final String suggestionsAndComplaintsPageUrl;
        private final String supportPhoneNumber;
        private final String termsAndConditionsPageUrl;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(ConfigurationResponseDTO$SiteSupportOpeningHourDTO$$serializer.INSTANCE), null, null, null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteSupportInfoDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteSupportInfoDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<SiteSupportInfoDTO> serializer() {
                return ConfigurationResponseDTO$SiteSupportInfoDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ SiteSupportInfoDTO(int i5, SiteContactInfoDTO siteContactInfoDTO, String str, List list, String str2, String str3, String str4, String str5, SerializationConstructorMarker serializationConstructorMarker) {
            if (127 != (i5 & 127)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 127, ConfigurationResponseDTO$SiteSupportInfoDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.contactInfo = siteContactInfoDTO;
            this.supportPhoneNumber = str;
            this.openingHours = list;
            this.lostAndFoundPageUrl = str2;
            this.suggestionsAndComplaintsPageUrl = str3;
            this.privacyPolicyPageUrl = str4;
            this.termsAndConditionsPageUrl = str5;
        }

        public static /* synthetic */ SiteSupportInfoDTO copy$default(SiteSupportInfoDTO siteSupportInfoDTO, SiteContactInfoDTO siteContactInfoDTO, String str, List list, String str2, String str3, String str4, String str5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                siteContactInfoDTO = siteSupportInfoDTO.contactInfo;
            }
            if ((i5 & 2) != 0) {
                str = siteSupportInfoDTO.supportPhoneNumber;
            }
            String str6 = str;
            if ((i5 & 4) != 0) {
                list = siteSupportInfoDTO.openingHours;
            }
            List list2 = list;
            if ((i5 & 8) != 0) {
                str2 = siteSupportInfoDTO.lostAndFoundPageUrl;
            }
            String str7 = str2;
            if ((i5 & 16) != 0) {
                str3 = siteSupportInfoDTO.suggestionsAndComplaintsPageUrl;
            }
            String str8 = str3;
            if ((i5 & 32) != 0) {
                str4 = siteSupportInfoDTO.privacyPolicyPageUrl;
            }
            String str9 = str4;
            if ((i5 & 64) != 0) {
                str5 = siteSupportInfoDTO.termsAndConditionsPageUrl;
            }
            return siteSupportInfoDTO.copy(siteContactInfoDTO, str6, list2, str7, str8, str9, str5);
        }

        public static /* synthetic */ void getContactInfo$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(SiteSupportInfoDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeSerializableElement(serialDesc, 0, ConfigurationResponseDTO$SiteContactInfoDTO$$serializer.INSTANCE, self.contactInfo);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.supportPhoneNumber);
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.openingHours);
            output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.lostAndFoundPageUrl);
            output.encodeNullableSerializableElement(serialDesc, 4, stringSerializer, self.suggestionsAndComplaintsPageUrl);
            output.encodeNullableSerializableElement(serialDesc, 5, stringSerializer, self.privacyPolicyPageUrl);
            output.encodeNullableSerializableElement(serialDesc, 6, stringSerializer, self.termsAndConditionsPageUrl);
        }

        /* renamed from: component1, reason: from getter */
        public final SiteContactInfoDTO getContactInfo() {
            return this.contactInfo;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSupportPhoneNumber() {
            return this.supportPhoneNumber;
        }

        public final List<SiteSupportOpeningHourDTO> component3() {
            return this.openingHours;
        }

        /* renamed from: component4, reason: from getter */
        public final String getLostAndFoundPageUrl() {
            return this.lostAndFoundPageUrl;
        }

        /* renamed from: component5, reason: from getter */
        public final String getSuggestionsAndComplaintsPageUrl() {
            return this.suggestionsAndComplaintsPageUrl;
        }

        /* renamed from: component6, reason: from getter */
        public final String getPrivacyPolicyPageUrl() {
            return this.privacyPolicyPageUrl;
        }

        /* renamed from: component7, reason: from getter */
        public final String getTermsAndConditionsPageUrl() {
            return this.termsAndConditionsPageUrl;
        }

        public final SiteSupportInfoDTO copy(SiteContactInfoDTO contactInfo, String supportPhoneNumber, List<SiteSupportOpeningHourDTO> openingHours, String lostAndFoundPageUrl, String suggestionsAndComplaintsPageUrl, String privacyPolicyPageUrl, String termsAndConditionsPageUrl) {
            Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
            return new SiteSupportInfoDTO(contactInfo, supportPhoneNumber, openingHours, lostAndFoundPageUrl, suggestionsAndComplaintsPageUrl, privacyPolicyPageUrl, termsAndConditionsPageUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SiteSupportInfoDTO)) {
                return false;
            }
            SiteSupportInfoDTO siteSupportInfoDTO = (SiteSupportInfoDTO) other;
            return Intrinsics.areEqual(this.contactInfo, siteSupportInfoDTO.contactInfo) && Intrinsics.areEqual(this.supportPhoneNumber, siteSupportInfoDTO.supportPhoneNumber) && Intrinsics.areEqual(this.openingHours, siteSupportInfoDTO.openingHours) && Intrinsics.areEqual(this.lostAndFoundPageUrl, siteSupportInfoDTO.lostAndFoundPageUrl) && Intrinsics.areEqual(this.suggestionsAndComplaintsPageUrl, siteSupportInfoDTO.suggestionsAndComplaintsPageUrl) && Intrinsics.areEqual(this.privacyPolicyPageUrl, siteSupportInfoDTO.privacyPolicyPageUrl) && Intrinsics.areEqual(this.termsAndConditionsPageUrl, siteSupportInfoDTO.termsAndConditionsPageUrl);
        }

        public final SiteContactInfoDTO getContactInfo() {
            return this.contactInfo;
        }

        public final String getLostAndFoundPageUrl() {
            return this.lostAndFoundPageUrl;
        }

        public final List<SiteSupportOpeningHourDTO> getOpeningHours() {
            return this.openingHours;
        }

        public final String getPrivacyPolicyPageUrl() {
            return this.privacyPolicyPageUrl;
        }

        public final String getSuggestionsAndComplaintsPageUrl() {
            return this.suggestionsAndComplaintsPageUrl;
        }

        public final String getSupportPhoneNumber() {
            return this.supportPhoneNumber;
        }

        public final String getTermsAndConditionsPageUrl() {
            return this.termsAndConditionsPageUrl;
        }

        public int hashCode() {
            int hashCode = this.contactInfo.hashCode() * 31;
            String str = this.supportPhoneNumber;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            List<SiteSupportOpeningHourDTO> list = this.openingHours;
            int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
            String str2 = this.lostAndFoundPageUrl;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.suggestionsAndComplaintsPageUrl;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.privacyPolicyPageUrl;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.termsAndConditionsPageUrl;
            return hashCode6 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "SiteSupportInfoDTO(contactInfo=" + this.contactInfo + ", supportPhoneNumber=" + this.supportPhoneNumber + ", openingHours=" + this.openingHours + ", lostAndFoundPageUrl=" + this.lostAndFoundPageUrl + ", suggestionsAndComplaintsPageUrl=" + this.suggestionsAndComplaintsPageUrl + ", privacyPolicyPageUrl=" + this.privacyPolicyPageUrl + ", termsAndConditionsPageUrl=" + this.termsAndConditionsPageUrl + ")";
        }

        public SiteSupportInfoDTO(SiteContactInfoDTO contactInfo, String str, List<SiteSupportOpeningHourDTO> list, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
            this.contactInfo = contactInfo;
            this.supportPhoneNumber = str;
            this.openingHours = list;
            this.lostAndFoundPageUrl = str2;
            this.suggestionsAndComplaintsPageUrl = str3;
            this.privacyPolicyPageUrl = str4;
            this.termsAndConditionsPageUrl = str5;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006!"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteSupportOpeningHourDTO;", BuildConfig.FLAVOR, "days", BuildConfig.FLAVOR, "hours", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDays", "()Ljava/lang/String;", "getHours", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class SiteSupportOpeningHourDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String days;
        private final String hours;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteSupportOpeningHourDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteSupportOpeningHourDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<SiteSupportOpeningHourDTO> serializer() {
                return ConfigurationResponseDTO$SiteSupportOpeningHourDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ SiteSupportOpeningHourDTO(int i5, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, ConfigurationResponseDTO$SiteSupportOpeningHourDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.days = str;
            this.hours = str2;
        }

        public static /* synthetic */ SiteSupportOpeningHourDTO copy$default(SiteSupportOpeningHourDTO siteSupportOpeningHourDTO, String str, String str2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = siteSupportOpeningHourDTO.days;
            }
            if ((i5 & 2) != 0) {
                str2 = siteSupportOpeningHourDTO.hours;
            }
            return siteSupportOpeningHourDTO.copy(str, str2);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(SiteSupportOpeningHourDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.days);
            output.encodeStringElement(serialDesc, 1, self.hours);
        }

        /* renamed from: component1, reason: from getter */
        public final String getDays() {
            return this.days;
        }

        /* renamed from: component2, reason: from getter */
        public final String getHours() {
            return this.hours;
        }

        public final SiteSupportOpeningHourDTO copy(String days, String hours) {
            Intrinsics.checkNotNullParameter(days, "days");
            Intrinsics.checkNotNullParameter(hours, "hours");
            return new SiteSupportOpeningHourDTO(days, hours);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SiteSupportOpeningHourDTO)) {
                return false;
            }
            SiteSupportOpeningHourDTO siteSupportOpeningHourDTO = (SiteSupportOpeningHourDTO) other;
            return Intrinsics.areEqual(this.days, siteSupportOpeningHourDTO.days) && Intrinsics.areEqual(this.hours, siteSupportOpeningHourDTO.hours);
        }

        public final String getDays() {
            return this.days;
        }

        public final String getHours() {
            return this.hours;
        }

        public int hashCode() {
            return (this.days.hashCode() * 31) + this.hours.hashCode();
        }

        public String toString() {
            return "SiteSupportOpeningHourDTO(days=" + this.days + ", hours=" + this.hours + ")";
        }

        public SiteSupportOpeningHourDTO(String days, String hours) {
            Intrinsics.checkNotNullParameter(days, "days");
            Intrinsics.checkNotNullParameter(hours, "hours");
            this.days = days;
            this.hours = hours;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\rHÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u0006,"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$TransportCategoryDTO;", BuildConfig.FLAVOR, "allowedRouteIds", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isOnlyAvailableWithReturnTicket", BuildConfig.FLAVOR, "name", "transports", "Ldk/molslinjen/api/shared/response/TransportResponseDTO;", "<init>", "(Ljava/util/List;ZLjava/lang/String;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;ZLjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAllowedRouteIds$annotations", "()V", "getAllowedRouteIds", "()Ljava/util/List;", "()Z", "getName", "()Ljava/lang/String;", "getTransports", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class TransportCategoryDTO {
        private final List<String> allowedRouteIds;
        private final boolean isOnlyAvailableWithReturnTicket;
        private final String name;
        private final List<TransportResponseDTO> transports;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE), null, null, new ArrayListSerializer(TransportResponseDTO$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$TransportCategoryDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$TransportCategoryDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<TransportCategoryDTO> serializer() {
                return ConfigurationResponseDTO$TransportCategoryDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ TransportCategoryDTO(int i5, List list, boolean z5, String str, List list2, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i5 & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 15, ConfigurationResponseDTO$TransportCategoryDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.allowedRouteIds = list;
            this.isOnlyAvailableWithReturnTicket = z5;
            this.name = str;
            this.transports = list2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TransportCategoryDTO copy$default(TransportCategoryDTO transportCategoryDTO, List list, boolean z5, String str, List list2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                list = transportCategoryDTO.allowedRouteIds;
            }
            if ((i5 & 2) != 0) {
                z5 = transportCategoryDTO.isOnlyAvailableWithReturnTicket;
            }
            if ((i5 & 4) != 0) {
                str = transportCategoryDTO.name;
            }
            if ((i5 & 8) != 0) {
                list2 = transportCategoryDTO.transports;
            }
            return transportCategoryDTO.copy(list, z5, str, list2);
        }

        public static /* synthetic */ void getAllowedRouteIds$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(TransportCategoryDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.allowedRouteIds);
            output.encodeBooleanElement(serialDesc, 1, self.isOnlyAvailableWithReturnTicket);
            output.encodeStringElement(serialDesc, 2, self.name);
            output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.transports);
        }

        public final List<String> component1() {
            return this.allowedRouteIds;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsOnlyAvailableWithReturnTicket() {
            return this.isOnlyAvailableWithReturnTicket;
        }

        /* renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final List<TransportResponseDTO> component4() {
            return this.transports;
        }

        public final TransportCategoryDTO copy(List<String> allowedRouteIds, boolean isOnlyAvailableWithReturnTicket, String name, List<TransportResponseDTO> transports) {
            Intrinsics.checkNotNullParameter(allowedRouteIds, "allowedRouteIds");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(transports, "transports");
            return new TransportCategoryDTO(allowedRouteIds, isOnlyAvailableWithReturnTicket, name, transports);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TransportCategoryDTO)) {
                return false;
            }
            TransportCategoryDTO transportCategoryDTO = (TransportCategoryDTO) other;
            return Intrinsics.areEqual(this.allowedRouteIds, transportCategoryDTO.allowedRouteIds) && this.isOnlyAvailableWithReturnTicket == transportCategoryDTO.isOnlyAvailableWithReturnTicket && Intrinsics.areEqual(this.name, transportCategoryDTO.name) && Intrinsics.areEqual(this.transports, transportCategoryDTO.transports);
        }

        public final List<String> getAllowedRouteIds() {
            return this.allowedRouteIds;
        }

        public final String getName() {
            return this.name;
        }

        public final List<TransportResponseDTO> getTransports() {
            return this.transports;
        }

        public int hashCode() {
            return (((((this.allowedRouteIds.hashCode() * 31) + Boolean.hashCode(this.isOnlyAvailableWithReturnTicket)) * 31) + this.name.hashCode()) * 31) + this.transports.hashCode();
        }

        public final boolean isOnlyAvailableWithReturnTicket() {
            return this.isOnlyAvailableWithReturnTicket;
        }

        public String toString() {
            return "TransportCategoryDTO(allowedRouteIds=" + this.allowedRouteIds + ", isOnlyAvailableWithReturnTicket=" + this.isOnlyAvailableWithReturnTicket + ", name=" + this.name + ", transports=" + this.transports + ")";
        }

        public TransportCategoryDTO(List<String> allowedRouteIds, boolean z5, String name, List<TransportResponseDTO> transports) {
            Intrinsics.checkNotNullParameter(allowedRouteIds, "allowedRouteIds");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(transports, "transports");
            this.allowedRouteIds = allowedRouteIds;
            this.isOnlyAvailableWithReturnTicket = z5;
            this.name = name;
            this.transports = transports;
        }
    }

    public /* synthetic */ ConfigurationResponseDTO(int i5, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i5 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 1, ConfigurationResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.configs = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConfigurationResponseDTO copy$default(ConfigurationResponseDTO configurationResponseDTO, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = configurationResponseDTO.configs;
        }
        return configurationResponseDTO.copy(list);
    }

    @Serializable(with = ConfigDTOSafeSerializer.class)
    public static /* synthetic */ void getConfigs$annotations() {
    }

    public final List<ConfigDTO> component1() {
        return this.configs;
    }

    public final ConfigurationResponseDTO copy(List<ConfigDTO> configs) {
        Intrinsics.checkNotNullParameter(configs, "configs");
        return new ConfigurationResponseDTO(configs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ConfigurationResponseDTO) && Intrinsics.areEqual(this.configs, ((ConfigurationResponseDTO) other).configs);
    }

    public final List<ConfigDTO> getConfigs() {
        return this.configs;
    }

    public int hashCode() {
        return this.configs.hashCode();
    }

    public String toString() {
        return "ConfigurationResponseDTO(configs=" + this.configs + ")";
    }

    public ConfigurationResponseDTO(List<ConfigDTO> configs) {
        Intrinsics.checkNotNullParameter(configs, "configs");
        this.configs = configs;
    }
}
