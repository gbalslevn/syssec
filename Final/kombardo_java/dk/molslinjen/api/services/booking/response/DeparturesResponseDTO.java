package dk.molslinjen.api.services.booking.response;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import dk.molslinjen.api.helpers.serializers.IntToEnumSerializer;
import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
import dk.molslinjen.api.helpers.serializers.SerializableEnum;
import dk.molslinjen.api.services.booking.response.ProductTypeResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.FerryResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.FerryResponseDTO$$serializer;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO$$serializer;
import dk.molslinjen.api.shared.response.RouteTypeResponseDTO;
import dk.molslinjen.api.shared.response.TicketSurchargeDTO;
import dk.molslinjen.api.shared.response.TicketSurchargeDTO$$serializer;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u0000 22\u00020\u0001:\f'()*+,-./012B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\fHÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u00063"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO;", BuildConfig.FLAVOR, "timeTableStatus", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TimeTableStatusDTO;", "departures", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$DepartureResponseDTO;", "siteDeparturesNotice", BuildConfig.FLAVOR, "<init>", "(Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TimeTableStatusDTO;Ljava/util/List;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TimeTableStatusDTO;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTimeTableStatus", "()Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TimeTableStatusDTO;", "getDepartures", "()Ljava/util/List;", "getSiteDeparturesNotice", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "DepartureResponseDTO", "CheapestTicketDTO", "CheapestTicketPriceIndicatorDTO", "TicketResponseDTO", "CategoryResponseDTO", "DescriptionItemResponseDTO", "SimpleHarborDTO", "FeeResponseDTO", "ProductPriceResponseDTO", "TimeTableStatusDTO", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class DeparturesResponseDTO {
    private final List<DepartureResponseDTO> departures;
    private final String siteDeparturesNotice;
    private final TimeTableStatusDTO timeTableStatus;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(DeparturesResponseDTO$DepartureResponseDTO$$serializer.INSTANCE), null};

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./BG\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fBc\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003JU\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u000eHÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013¨\u00060"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CategoryResponseDTO;", BuildConfig.FLAVOR, "descriptionItems", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$DescriptionItemResponseDTO;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "subHeader", "shortDescription", "shortDescriptionItems", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDescriptionItems", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getName", "getSubHeader", "getShortDescription", "getShortDescriptionItems", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class CategoryResponseDTO {
        private final List<DescriptionItemResponseDTO> descriptionItems;
        private final String id;
        private final String name;
        private final String shortDescription;
        private final List<String> shortDescriptionItems;
        private final String subHeader;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(DeparturesResponseDTO$DescriptionItemResponseDTO$$serializer.INSTANCE), null, null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CategoryResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CategoryResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<CategoryResponseDTO> serializer() {
                return DeparturesResponseDTO$CategoryResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ CategoryResponseDTO(int i5, List list, String str, String str2, String str3, String str4, List list2, SerializationConstructorMarker serializationConstructorMarker) {
            if (63 != (i5 & 63)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 63, DeparturesResponseDTO$CategoryResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.descriptionItems = list;
            this.id = str;
            this.name = str2;
            this.subHeader = str3;
            this.shortDescription = str4;
            this.shortDescriptionItems = list2;
        }

        public static /* synthetic */ CategoryResponseDTO copy$default(CategoryResponseDTO categoryResponseDTO, List list, String str, String str2, String str3, String str4, List list2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                list = categoryResponseDTO.descriptionItems;
            }
            if ((i5 & 2) != 0) {
                str = categoryResponseDTO.id;
            }
            String str5 = str;
            if ((i5 & 4) != 0) {
                str2 = categoryResponseDTO.name;
            }
            String str6 = str2;
            if ((i5 & 8) != 0) {
                str3 = categoryResponseDTO.subHeader;
            }
            String str7 = str3;
            if ((i5 & 16) != 0) {
                str4 = categoryResponseDTO.shortDescription;
            }
            String str8 = str4;
            if ((i5 & 32) != 0) {
                list2 = categoryResponseDTO.shortDescriptionItems;
            }
            return categoryResponseDTO.copy(list, str5, str6, str7, str8, list2);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(CategoryResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.descriptionItems);
            output.encodeStringElement(serialDesc, 1, self.id);
            output.encodeStringElement(serialDesc, 2, self.name);
            output.encodeStringElement(serialDesc, 3, self.subHeader);
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.shortDescription);
            output.encodeNullableSerializableElement(serialDesc, 5, kSerializerArr[5], self.shortDescriptionItems);
        }

        public final List<DescriptionItemResponseDTO> component1() {
            return this.descriptionItems;
        }

        /* renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component4, reason: from getter */
        public final String getSubHeader() {
            return this.subHeader;
        }

        /* renamed from: component5, reason: from getter */
        public final String getShortDescription() {
            return this.shortDescription;
        }

        public final List<String> component6() {
            return this.shortDescriptionItems;
        }

        public final CategoryResponseDTO copy(List<DescriptionItemResponseDTO> descriptionItems, String id, String name, String subHeader, String shortDescription, List<String> shortDescriptionItems) {
            Intrinsics.checkNotNullParameter(descriptionItems, "descriptionItems");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(subHeader, "subHeader");
            return new CategoryResponseDTO(descriptionItems, id, name, subHeader, shortDescription, shortDescriptionItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CategoryResponseDTO)) {
                return false;
            }
            CategoryResponseDTO categoryResponseDTO = (CategoryResponseDTO) other;
            return Intrinsics.areEqual(this.descriptionItems, categoryResponseDTO.descriptionItems) && Intrinsics.areEqual(this.id, categoryResponseDTO.id) && Intrinsics.areEqual(this.name, categoryResponseDTO.name) && Intrinsics.areEqual(this.subHeader, categoryResponseDTO.subHeader) && Intrinsics.areEqual(this.shortDescription, categoryResponseDTO.shortDescription) && Intrinsics.areEqual(this.shortDescriptionItems, categoryResponseDTO.shortDescriptionItems);
        }

        public final List<DescriptionItemResponseDTO> getDescriptionItems() {
            return this.descriptionItems;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getShortDescription() {
            return this.shortDescription;
        }

        public final List<String> getShortDescriptionItems() {
            return this.shortDescriptionItems;
        }

        public final String getSubHeader() {
            return this.subHeader;
        }

        public int hashCode() {
            int hashCode = ((((((this.descriptionItems.hashCode() * 31) + this.id.hashCode()) * 31) + this.name.hashCode()) * 31) + this.subHeader.hashCode()) * 31;
            String str = this.shortDescription;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            List<String> list = this.shortDescriptionItems;
            return hashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "CategoryResponseDTO(descriptionItems=" + this.descriptionItems + ", id=" + this.id + ", name=" + this.name + ", subHeader=" + this.subHeader + ", shortDescription=" + this.shortDescription + ", shortDescriptionItems=" + this.shortDescriptionItems + ")";
        }

        public CategoryResponseDTO(List<DescriptionItemResponseDTO> descriptionItems, String id, String name, String subHeader, String str, List<String> list) {
            Intrinsics.checkNotNullParameter(descriptionItems, "descriptionItems");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(subHeader, "subHeader");
            this.descriptionItems = descriptionItems;
            this.id = id;
            this.name = name;
            this.subHeader = subHeader;
            this.shortDescription = str;
            this.shortDescriptionItems = list;
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002)*B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketDTO;", BuildConfig.FLAVOR, "priceIndicator", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketPriceIndicatorDTO;", "ticketTypeId", BuildConfig.FLAVOR, "ticketTypeName", "price", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "<init>", "(Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketPriceIndicatorDTO;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketPriceIndicatorDTO;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPriceIndicator", "()Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketPriceIndicatorDTO;", "getTicketTypeId", "()Ljava/lang/String;", "getTicketTypeName", "getPrice", "()Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class CheapestTicketDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final PriceWithCurrencyDTO price;
        private final CheapestTicketPriceIndicatorDTO priceIndicator;
        private final String ticketTypeId;
        private final String ticketTypeName;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<CheapestTicketDTO> serializer() {
                return DeparturesResponseDTO$CheapestTicketDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ CheapestTicketDTO(int i5, CheapestTicketPriceIndicatorDTO cheapestTicketPriceIndicatorDTO, String str, String str2, PriceWithCurrencyDTO priceWithCurrencyDTO, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i5 & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 15, DeparturesResponseDTO$CheapestTicketDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.priceIndicator = cheapestTicketPriceIndicatorDTO;
            this.ticketTypeId = str;
            this.ticketTypeName = str2;
            this.price = priceWithCurrencyDTO;
        }

        public static /* synthetic */ CheapestTicketDTO copy$default(CheapestTicketDTO cheapestTicketDTO, CheapestTicketPriceIndicatorDTO cheapestTicketPriceIndicatorDTO, String str, String str2, PriceWithCurrencyDTO priceWithCurrencyDTO, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                cheapestTicketPriceIndicatorDTO = cheapestTicketDTO.priceIndicator;
            }
            if ((i5 & 2) != 0) {
                str = cheapestTicketDTO.ticketTypeId;
            }
            if ((i5 & 4) != 0) {
                str2 = cheapestTicketDTO.ticketTypeName;
            }
            if ((i5 & 8) != 0) {
                priceWithCurrencyDTO = cheapestTicketDTO.price;
            }
            return cheapestTicketDTO.copy(cheapestTicketPriceIndicatorDTO, str, str2, priceWithCurrencyDTO);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(CheapestTicketDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, CheapestTicketPriceIndicatorDTO.Serializer.INSTANCE, self.priceIndicator);
            output.encodeStringElement(serialDesc, 1, self.ticketTypeId);
            output.encodeStringElement(serialDesc, 2, self.ticketTypeName);
            output.encodeSerializableElement(serialDesc, 3, PriceWithCurrencyDTO$$serializer.INSTANCE, self.price);
        }

        /* renamed from: component1, reason: from getter */
        public final CheapestTicketPriceIndicatorDTO getPriceIndicator() {
            return this.priceIndicator;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTicketTypeId() {
            return this.ticketTypeId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTicketTypeName() {
            return this.ticketTypeName;
        }

        /* renamed from: component4, reason: from getter */
        public final PriceWithCurrencyDTO getPrice() {
            return this.price;
        }

        public final CheapestTicketDTO copy(CheapestTicketPriceIndicatorDTO priceIndicator, String ticketTypeId, String ticketTypeName, PriceWithCurrencyDTO price) {
            Intrinsics.checkNotNullParameter(priceIndicator, "priceIndicator");
            Intrinsics.checkNotNullParameter(ticketTypeId, "ticketTypeId");
            Intrinsics.checkNotNullParameter(ticketTypeName, "ticketTypeName");
            Intrinsics.checkNotNullParameter(price, "price");
            return new CheapestTicketDTO(priceIndicator, ticketTypeId, ticketTypeName, price);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CheapestTicketDTO)) {
                return false;
            }
            CheapestTicketDTO cheapestTicketDTO = (CheapestTicketDTO) other;
            return this.priceIndicator == cheapestTicketDTO.priceIndicator && Intrinsics.areEqual(this.ticketTypeId, cheapestTicketDTO.ticketTypeId) && Intrinsics.areEqual(this.ticketTypeName, cheapestTicketDTO.ticketTypeName) && Intrinsics.areEqual(this.price, cheapestTicketDTO.price);
        }

        public final PriceWithCurrencyDTO getPrice() {
            return this.price;
        }

        public final CheapestTicketPriceIndicatorDTO getPriceIndicator() {
            return this.priceIndicator;
        }

        public final String getTicketTypeId() {
            return this.ticketTypeId;
        }

        public final String getTicketTypeName() {
            return this.ticketTypeName;
        }

        public int hashCode() {
            return (((((this.priceIndicator.hashCode() * 31) + this.ticketTypeId.hashCode()) * 31) + this.ticketTypeName.hashCode()) * 31) + this.price.hashCode();
        }

        public String toString() {
            return "CheapestTicketDTO(priceIndicator=" + this.priceIndicator + ", ticketTypeId=" + this.ticketTypeId + ", ticketTypeName=" + this.ticketTypeName + ", price=" + this.price + ")";
        }

        public CheapestTicketDTO(CheapestTicketPriceIndicatorDTO priceIndicator, String ticketTypeId, String ticketTypeName, PriceWithCurrencyDTO price) {
            Intrinsics.checkNotNullParameter(priceIndicator, "priceIndicator");
            Intrinsics.checkNotNullParameter(ticketTypeId, "ticketTypeId");
            Intrinsics.checkNotNullParameter(ticketTypeName, "ticketTypeName");
            Intrinsics.checkNotNullParameter(price, "price");
            this.priceIndicator = priceIndicator;
            this.ticketTypeId = ticketTypeId;
            this.ticketTypeName = ticketTypeName;
            this.price = price;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002\u000b\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketPriceIndicatorDTO;", "Ldk/molslinjen/api/helpers/serializers/SerializableEnum;", BuildConfig.FLAVOR, "rawValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getRawValue", "()I", "Regular", "Highlighted", "Serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable(with = Serializer.class)
    /* loaded from: classes2.dex */
    public static final class CheapestTicketPriceIndicatorDTO implements SerializableEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CheapestTicketPriceIndicatorDTO[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int rawValue;
        public static final CheapestTicketPriceIndicatorDTO Regular = new CheapestTicketPriceIndicatorDTO("Regular", 0, 0);
        public static final CheapestTicketPriceIndicatorDTO Highlighted = new CheapestTicketPriceIndicatorDTO("Highlighted", 1, 1);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketPriceIndicatorDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketPriceIndicatorDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<CheapestTicketPriceIndicatorDTO> serializer() {
                return Serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketPriceIndicatorDTO$Serializer;", "Ldk/molslinjen/api/helpers/serializers/IntToEnumSerializer;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketPriceIndicatorDTO;", "<init>", "()V", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Serializer extends IntToEnumSerializer<CheapestTicketPriceIndicatorDTO> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(CheapestTicketPriceIndicatorDTO.class);
            }
        }

        private static final /* synthetic */ CheapestTicketPriceIndicatorDTO[] $values() {
            return new CheapestTicketPriceIndicatorDTO[]{Regular, Highlighted};
        }

        static {
            CheapestTicketPriceIndicatorDTO[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        private CheapestTicketPriceIndicatorDTO(String str, int i5, int i6) {
            this.rawValue = i6;
        }

        public static EnumEntries<CheapestTicketPriceIndicatorDTO> getEntries() {
            return $ENTRIES;
        }

        public static CheapestTicketPriceIndicatorDTO valueOf(String str) {
            return (CheapestTicketPriceIndicatorDTO) Enum.valueOf(CheapestTicketPriceIndicatorDTO.class, str);
        }

        public static CheapestTicketPriceIndicatorDTO[] values() {
            return (CheapestTicketPriceIndicatorDTO[]) $VALUES.clone();
        }

        @Override // dk.molslinjen.api.helpers.serializers.SerializableEnum
        public int getRawValue() {
            return this.rawValue;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<DeparturesResponseDTO> serializer() {
            return DeparturesResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 p2\u00020\u0001:\u0002opBÍ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\u0007\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0017¢\u0006\u0004\b#\u0010$Bù\u0001\b\u0010\u0012\u0006\u0010%\u001a\u00020&\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010 \u001a\u00020\u0007\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0017\u0012\b\u0010'\u001a\u0004\u0018\u00010(¢\u0006\u0004\b#\u0010)J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0007HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010Q\u001a\u00020\u000bHÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010U\u001a\u00020\tHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010X\u001a\u00020\tHÆ\u0003J\t\u0010Y\u001a\u00020\tHÆ\u0003J\u000f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017HÆ\u0003J\t\u0010[\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010^\u001a\u00020\u001eHÆ\u0003J\t\u0010_\u001a\u00020\tHÆ\u0003J\t\u0010`\u001a\u00020\u0007HÆ\u0003J\u0011\u0010a\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0017HÆ\u0003Jù\u0001\u0010b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00072\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00172\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\u00072\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0017HÆ\u0001J\u0013\u0010c\u001a\u00020\u00072\b\u0010d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010e\u001a\u00020&HÖ\u0001J\t\u0010f\u001a\u00020\tHÖ\u0001J%\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020\u00002\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020mH\u0001¢\u0006\u0002\bnR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010-\u001a\u0004\b5\u00106R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010+R\u001c\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010-\u001a\u0004\b9\u0010/R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b<\u00103R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b=\u00103R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b@\u00103R\u0011\u0010\u0015\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bA\u00103R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010\u0019\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bD\u00101R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017¢\u0006\b\n\u0000\u001a\u0004\bE\u0010CR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bF\u00103R\u001c\u0010\u001d\u001a\u00020\u001e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u0010-\u001a\u0004\bH\u0010IR\u0011\u0010\u001f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bJ\u00103R\u0011\u0010 \u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bK\u00101R\u0019\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bL\u0010C¨\u0006q"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$DepartureResponseDTO;", BuildConfig.FLAVOR, "arrivalHarbor", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$SimpleHarborDTO;", "arrivalTime", "Lorg/threeten/bp/LocalTime;", "cancelled", BuildConfig.FLAVOR, "customRouteTypeText", BuildConfig.FLAVOR, "date", "Lorg/threeten/bp/LocalDate;", "departureHarbor", "departureTime", "ferry", "Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;", Constants.ID_ATTRIBUTE_KEY, "information", "lowestPrice", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketDTO;", "mainRouteId", "routeId", "routeTypes", BuildConfig.FLAVOR, "Ldk/molslinjen/api/shared/response/RouteTypeResponseDTO;", "soldOut", "tickets", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TicketResponseDTO;", "transportSwitchDescription", "travelTime", "Lorg/threeten/bp/Duration;", "timeTableId", "limitedAvailability", "availableProductTypes", "Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "<init>", "(Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$SimpleHarborDTO;Lorg/threeten/bp/LocalTime;ZLjava/lang/String;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$SimpleHarborDTO;Lorg/threeten/bp/LocalTime;Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketDTO;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/util/List;Ljava/lang/String;Lorg/threeten/bp/Duration;Ljava/lang/String;ZLjava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/booking/response/DeparturesResponseDTO$SimpleHarborDTO;Lorg/threeten/bp/LocalTime;ZLjava/lang/String;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$SimpleHarborDTO;Lorg/threeten/bp/LocalTime;Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketDTO;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/util/List;Ljava/lang/String;Lorg/threeten/bp/Duration;Ljava/lang/String;ZLjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getArrivalHarbor", "()Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$SimpleHarborDTO;", "getArrivalTime$annotations", "()V", "getArrivalTime", "()Lorg/threeten/bp/LocalTime;", "getCancelled", "()Z", "getCustomRouteTypeText", "()Ljava/lang/String;", "getDate$annotations", "getDate", "()Lorg/threeten/bp/LocalDate;", "getDepartureHarbor", "getDepartureTime$annotations", "getDepartureTime", "getFerry", "()Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;", "getId", "getInformation", "getLowestPrice", "()Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketDTO;", "getMainRouteId", "getRouteId", "getRouteTypes", "()Ljava/util/List;", "getSoldOut", "getTickets", "getTransportSwitchDescription", "getTravelTime$annotations", "getTravelTime", "()Lorg/threeten/bp/Duration;", "getTimeTableId", "getLimitedAvailability", "getAvailableProductTypes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class DepartureResponseDTO {
        private final SimpleHarborDTO arrivalHarbor;
        private final LocalTime arrivalTime;
        private final List<ProductTypeResponseDTO> availableProductTypes;
        private final boolean cancelled;
        private final String customRouteTypeText;
        private final LocalDate date;
        private final SimpleHarborDTO departureHarbor;
        private final LocalTime departureTime;
        private final FerryResponseDTO ferry;
        private final String id;
        private final String information;
        private final boolean limitedAvailability;
        private final CheapestTicketDTO lowestPrice;
        private final String mainRouteId;
        private final String routeId;
        private final List<RouteTypeResponseDTO> routeTypes;
        private final boolean soldOut;
        private final List<TicketResponseDTO> tickets;
        private final String timeTableId;
        private final String transportSwitchDescription;
        private final Duration travelTime;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(RouteTypeResponseDTO.Serializer.INSTANCE), null, new ArrayListSerializer(DeparturesResponseDTO$TicketResponseDTO$$serializer.INSTANCE), null, null, null, null, new ArrayListSerializer(ProductTypeResponseDTO.Serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$DepartureResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$DepartureResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<DepartureResponseDTO> serializer() {
                return DeparturesResponseDTO$DepartureResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ DepartureResponseDTO(int i5, SimpleHarborDTO simpleHarborDTO, LocalTime localTime, boolean z5, String str, LocalDate localDate, SimpleHarborDTO simpleHarborDTO2, LocalTime localTime2, FerryResponseDTO ferryResponseDTO, String str2, String str3, CheapestTicketDTO cheapestTicketDTO, String str4, String str5, List list, boolean z6, List list2, String str6, Duration duration, String str7, boolean z7, List list3, SerializationConstructorMarker serializationConstructorMarker) {
            if (2097151 != (i5 & 2097151)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 2097151, DeparturesResponseDTO$DepartureResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.arrivalHarbor = simpleHarborDTO;
            this.arrivalTime = localTime;
            this.cancelled = z5;
            this.customRouteTypeText = str;
            this.date = localDate;
            this.departureHarbor = simpleHarborDTO2;
            this.departureTime = localTime2;
            this.ferry = ferryResponseDTO;
            this.id = str2;
            this.information = str3;
            this.lowestPrice = cheapestTicketDTO;
            this.mainRouteId = str4;
            this.routeId = str5;
            this.routeTypes = list;
            this.soldOut = z6;
            this.tickets = list2;
            this.transportSwitchDescription = str6;
            this.travelTime = duration;
            this.timeTableId = str7;
            this.limitedAvailability = z7;
            this.availableProductTypes = list3;
        }

        @Serializable(with = LocalTimeSerializer.class)
        public static /* synthetic */ void getArrivalTime$annotations() {
        }

        @Serializable(with = LocalDateWithTimeSerializer.class)
        public static /* synthetic */ void getDate$annotations() {
        }

        @Serializable(with = LocalTimeSerializer.class)
        public static /* synthetic */ void getDepartureTime$annotations() {
        }

        @Serializable(with = DurationSerializer.class)
        public static /* synthetic */ void getTravelTime$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(DepartureResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            DeparturesResponseDTO$SimpleHarborDTO$$serializer departuresResponseDTO$SimpleHarborDTO$$serializer = DeparturesResponseDTO$SimpleHarborDTO$$serializer.INSTANCE;
            output.encodeSerializableElement(serialDesc, 0, departuresResponseDTO$SimpleHarborDTO$$serializer, self.arrivalHarbor);
            LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
            output.encodeSerializableElement(serialDesc, 1, localTimeSerializer, self.arrivalTime);
            output.encodeBooleanElement(serialDesc, 2, self.cancelled);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.customRouteTypeText);
            output.encodeSerializableElement(serialDesc, 4, LocalDateWithTimeSerializer.INSTANCE, self.date);
            output.encodeSerializableElement(serialDesc, 5, departuresResponseDTO$SimpleHarborDTO$$serializer, self.departureHarbor);
            output.encodeSerializableElement(serialDesc, 6, localTimeSerializer, self.departureTime);
            output.encodeNullableSerializableElement(serialDesc, 7, FerryResponseDTO$$serializer.INSTANCE, self.ferry);
            output.encodeStringElement(serialDesc, 8, self.id);
            output.encodeNullableSerializableElement(serialDesc, 9, stringSerializer, self.information);
            output.encodeNullableSerializableElement(serialDesc, 10, DeparturesResponseDTO$CheapestTicketDTO$$serializer.INSTANCE, self.lowestPrice);
            output.encodeStringElement(serialDesc, 11, self.mainRouteId);
            output.encodeStringElement(serialDesc, 12, self.routeId);
            output.encodeSerializableElement(serialDesc, 13, kSerializerArr[13], self.routeTypes);
            output.encodeBooleanElement(serialDesc, 14, self.soldOut);
            output.encodeSerializableElement(serialDesc, 15, kSerializerArr[15], self.tickets);
            output.encodeNullableSerializableElement(serialDesc, 16, stringSerializer, self.transportSwitchDescription);
            output.encodeSerializableElement(serialDesc, 17, DurationSerializer.INSTANCE, self.travelTime);
            output.encodeStringElement(serialDesc, 18, self.timeTableId);
            output.encodeBooleanElement(serialDesc, 19, self.limitedAvailability);
            output.encodeNullableSerializableElement(serialDesc, 20, kSerializerArr[20], self.availableProductTypes);
        }

        /* renamed from: component1, reason: from getter */
        public final SimpleHarborDTO getArrivalHarbor() {
            return this.arrivalHarbor;
        }

        /* renamed from: component10, reason: from getter */
        public final String getInformation() {
            return this.information;
        }

        /* renamed from: component11, reason: from getter */
        public final CheapestTicketDTO getLowestPrice() {
            return this.lowestPrice;
        }

        /* renamed from: component12, reason: from getter */
        public final String getMainRouteId() {
            return this.mainRouteId;
        }

        /* renamed from: component13, reason: from getter */
        public final String getRouteId() {
            return this.routeId;
        }

        public final List<RouteTypeResponseDTO> component14() {
            return this.routeTypes;
        }

        /* renamed from: component15, reason: from getter */
        public final boolean getSoldOut() {
            return this.soldOut;
        }

        public final List<TicketResponseDTO> component16() {
            return this.tickets;
        }

        /* renamed from: component17, reason: from getter */
        public final String getTransportSwitchDescription() {
            return this.transportSwitchDescription;
        }

        /* renamed from: component18, reason: from getter */
        public final Duration getTravelTime() {
            return this.travelTime;
        }

        /* renamed from: component19, reason: from getter */
        public final String getTimeTableId() {
            return this.timeTableId;
        }

        /* renamed from: component2, reason: from getter */
        public final LocalTime getArrivalTime() {
            return this.arrivalTime;
        }

        /* renamed from: component20, reason: from getter */
        public final boolean getLimitedAvailability() {
            return this.limitedAvailability;
        }

        public final List<ProductTypeResponseDTO> component21() {
            return this.availableProductTypes;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCancelled() {
            return this.cancelled;
        }

        /* renamed from: component4, reason: from getter */
        public final String getCustomRouteTypeText() {
            return this.customRouteTypeText;
        }

        /* renamed from: component5, reason: from getter */
        public final LocalDate getDate() {
            return this.date;
        }

        /* renamed from: component6, reason: from getter */
        public final SimpleHarborDTO getDepartureHarbor() {
            return this.departureHarbor;
        }

        /* renamed from: component7, reason: from getter */
        public final LocalTime getDepartureTime() {
            return this.departureTime;
        }

        /* renamed from: component8, reason: from getter */
        public final FerryResponseDTO getFerry() {
            return this.ferry;
        }

        /* renamed from: component9, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final DepartureResponseDTO copy(SimpleHarborDTO arrivalHarbor, LocalTime arrivalTime, boolean cancelled, String customRouteTypeText, LocalDate date, SimpleHarborDTO departureHarbor, LocalTime departureTime, FerryResponseDTO ferry, String id, String information, CheapestTicketDTO lowestPrice, String mainRouteId, String routeId, List<? extends RouteTypeResponseDTO> routeTypes, boolean soldOut, List<TicketResponseDTO> tickets, String transportSwitchDescription, Duration travelTime, String timeTableId, boolean limitedAvailability, List<? extends ProductTypeResponseDTO> availableProductTypes) {
            Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
            Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
            Intrinsics.checkNotNullParameter(departureTime, "departureTime");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(mainRouteId, "mainRouteId");
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            Intrinsics.checkNotNullParameter(routeTypes, "routeTypes");
            Intrinsics.checkNotNullParameter(tickets, "tickets");
            Intrinsics.checkNotNullParameter(travelTime, "travelTime");
            Intrinsics.checkNotNullParameter(timeTableId, "timeTableId");
            return new DepartureResponseDTO(arrivalHarbor, arrivalTime, cancelled, customRouteTypeText, date, departureHarbor, departureTime, ferry, id, information, lowestPrice, mainRouteId, routeId, routeTypes, soldOut, tickets, transportSwitchDescription, travelTime, timeTableId, limitedAvailability, availableProductTypes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DepartureResponseDTO)) {
                return false;
            }
            DepartureResponseDTO departureResponseDTO = (DepartureResponseDTO) other;
            return Intrinsics.areEqual(this.arrivalHarbor, departureResponseDTO.arrivalHarbor) && Intrinsics.areEqual(this.arrivalTime, departureResponseDTO.arrivalTime) && this.cancelled == departureResponseDTO.cancelled && Intrinsics.areEqual(this.customRouteTypeText, departureResponseDTO.customRouteTypeText) && Intrinsics.areEqual(this.date, departureResponseDTO.date) && Intrinsics.areEqual(this.departureHarbor, departureResponseDTO.departureHarbor) && Intrinsics.areEqual(this.departureTime, departureResponseDTO.departureTime) && Intrinsics.areEqual(this.ferry, departureResponseDTO.ferry) && Intrinsics.areEqual(this.id, departureResponseDTO.id) && Intrinsics.areEqual(this.information, departureResponseDTO.information) && Intrinsics.areEqual(this.lowestPrice, departureResponseDTO.lowestPrice) && Intrinsics.areEqual(this.mainRouteId, departureResponseDTO.mainRouteId) && Intrinsics.areEqual(this.routeId, departureResponseDTO.routeId) && Intrinsics.areEqual(this.routeTypes, departureResponseDTO.routeTypes) && this.soldOut == departureResponseDTO.soldOut && Intrinsics.areEqual(this.tickets, departureResponseDTO.tickets) && Intrinsics.areEqual(this.transportSwitchDescription, departureResponseDTO.transportSwitchDescription) && Intrinsics.areEqual(this.travelTime, departureResponseDTO.travelTime) && Intrinsics.areEqual(this.timeTableId, departureResponseDTO.timeTableId) && this.limitedAvailability == departureResponseDTO.limitedAvailability && Intrinsics.areEqual(this.availableProductTypes, departureResponseDTO.availableProductTypes);
        }

        public final SimpleHarborDTO getArrivalHarbor() {
            return this.arrivalHarbor;
        }

        public final LocalTime getArrivalTime() {
            return this.arrivalTime;
        }

        public final List<ProductTypeResponseDTO> getAvailableProductTypes() {
            return this.availableProductTypes;
        }

        public final boolean getCancelled() {
            return this.cancelled;
        }

        public final String getCustomRouteTypeText() {
            return this.customRouteTypeText;
        }

        public final LocalDate getDate() {
            return this.date;
        }

        public final SimpleHarborDTO getDepartureHarbor() {
            return this.departureHarbor;
        }

        public final LocalTime getDepartureTime() {
            return this.departureTime;
        }

        public final FerryResponseDTO getFerry() {
            return this.ferry;
        }

        public final String getId() {
            return this.id;
        }

        public final String getInformation() {
            return this.information;
        }

        public final boolean getLimitedAvailability() {
            return this.limitedAvailability;
        }

        public final CheapestTicketDTO getLowestPrice() {
            return this.lowestPrice;
        }

        public final String getMainRouteId() {
            return this.mainRouteId;
        }

        public final String getRouteId() {
            return this.routeId;
        }

        public final List<RouteTypeResponseDTO> getRouteTypes() {
            return this.routeTypes;
        }

        public final boolean getSoldOut() {
            return this.soldOut;
        }

        public final List<TicketResponseDTO> getTickets() {
            return this.tickets;
        }

        public final String getTimeTableId() {
            return this.timeTableId;
        }

        public final String getTransportSwitchDescription() {
            return this.transportSwitchDescription;
        }

        public final Duration getTravelTime() {
            return this.travelTime;
        }

        public int hashCode() {
            int hashCode = ((((this.arrivalHarbor.hashCode() * 31) + this.arrivalTime.hashCode()) * 31) + Boolean.hashCode(this.cancelled)) * 31;
            String str = this.customRouteTypeText;
            int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.date.hashCode()) * 31) + this.departureHarbor.hashCode()) * 31) + this.departureTime.hashCode()) * 31;
            FerryResponseDTO ferryResponseDTO = this.ferry;
            int hashCode3 = (((hashCode2 + (ferryResponseDTO == null ? 0 : ferryResponseDTO.hashCode())) * 31) + this.id.hashCode()) * 31;
            String str2 = this.information;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            CheapestTicketDTO cheapestTicketDTO = this.lowestPrice;
            int hashCode5 = (((((((((((hashCode4 + (cheapestTicketDTO == null ? 0 : cheapestTicketDTO.hashCode())) * 31) + this.mainRouteId.hashCode()) * 31) + this.routeId.hashCode()) * 31) + this.routeTypes.hashCode()) * 31) + Boolean.hashCode(this.soldOut)) * 31) + this.tickets.hashCode()) * 31;
            String str3 = this.transportSwitchDescription;
            int hashCode6 = (((((((hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.travelTime.hashCode()) * 31) + this.timeTableId.hashCode()) * 31) + Boolean.hashCode(this.limitedAvailability)) * 31;
            List<ProductTypeResponseDTO> list = this.availableProductTypes;
            return hashCode6 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "DepartureResponseDTO(arrivalHarbor=" + this.arrivalHarbor + ", arrivalTime=" + this.arrivalTime + ", cancelled=" + this.cancelled + ", customRouteTypeText=" + this.customRouteTypeText + ", date=" + this.date + ", departureHarbor=" + this.departureHarbor + ", departureTime=" + this.departureTime + ", ferry=" + this.ferry + ", id=" + this.id + ", information=" + this.information + ", lowestPrice=" + this.lowestPrice + ", mainRouteId=" + this.mainRouteId + ", routeId=" + this.routeId + ", routeTypes=" + this.routeTypes + ", soldOut=" + this.soldOut + ", tickets=" + this.tickets + ", transportSwitchDescription=" + this.transportSwitchDescription + ", travelTime=" + this.travelTime + ", timeTableId=" + this.timeTableId + ", limitedAvailability=" + this.limitedAvailability + ", availableProductTypes=" + this.availableProductTypes + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DepartureResponseDTO(SimpleHarborDTO arrivalHarbor, LocalTime arrivalTime, boolean z5, String str, LocalDate date, SimpleHarborDTO departureHarbor, LocalTime departureTime, FerryResponseDTO ferryResponseDTO, String id, String str2, CheapestTicketDTO cheapestTicketDTO, String mainRouteId, String routeId, List<? extends RouteTypeResponseDTO> routeTypes, boolean z6, List<TicketResponseDTO> tickets, String str3, Duration travelTime, String timeTableId, boolean z7, List<? extends ProductTypeResponseDTO> list) {
            Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
            Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
            Intrinsics.checkNotNullParameter(departureTime, "departureTime");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(mainRouteId, "mainRouteId");
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            Intrinsics.checkNotNullParameter(routeTypes, "routeTypes");
            Intrinsics.checkNotNullParameter(tickets, "tickets");
            Intrinsics.checkNotNullParameter(travelTime, "travelTime");
            Intrinsics.checkNotNullParameter(timeTableId, "timeTableId");
            this.arrivalHarbor = arrivalHarbor;
            this.arrivalTime = arrivalTime;
            this.cancelled = z5;
            this.customRouteTypeText = str;
            this.date = date;
            this.departureHarbor = departureHarbor;
            this.departureTime = departureTime;
            this.ferry = ferryResponseDTO;
            this.id = id;
            this.information = str2;
            this.lowestPrice = cheapestTicketDTO;
            this.mainRouteId = mainRouteId;
            this.routeId = routeId;
            this.routeTypes = routeTypes;
            this.soldOut = z6;
            this.tickets = tickets;
            this.transportSwitchDescription = str3;
            this.travelTime = travelTime;
            this.timeTableId = timeTableId;
            this.limitedAvailability = z7;
            this.availableProductTypes = list;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$DescriptionItemResponseDTO;", BuildConfig.FLAVOR, "description", BuildConfig.FLAVOR, "icon", "iconImageUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDescription", "()Ljava/lang/String;", "getIcon", "getIconImageUrl", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class DescriptionItemResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String description;
        private final String icon;
        private final String iconImageUrl;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$DescriptionItemResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$DescriptionItemResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<DescriptionItemResponseDTO> serializer() {
                return DeparturesResponseDTO$DescriptionItemResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ DescriptionItemResponseDTO(int i5, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, DeparturesResponseDTO$DescriptionItemResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.description = str;
            this.icon = str2;
            this.iconImageUrl = str3;
        }

        public static /* synthetic */ DescriptionItemResponseDTO copy$default(DescriptionItemResponseDTO descriptionItemResponseDTO, String str, String str2, String str3, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = descriptionItemResponseDTO.description;
            }
            if ((i5 & 2) != 0) {
                str2 = descriptionItemResponseDTO.icon;
            }
            if ((i5 & 4) != 0) {
                str3 = descriptionItemResponseDTO.iconImageUrl;
            }
            return descriptionItemResponseDTO.copy(str, str2, str3);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(DescriptionItemResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.description);
            output.encodeStringElement(serialDesc, 1, self.icon);
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.iconImageUrl);
        }

        /* renamed from: component1, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component2, reason: from getter */
        public final String getIcon() {
            return this.icon;
        }

        /* renamed from: component3, reason: from getter */
        public final String getIconImageUrl() {
            return this.iconImageUrl;
        }

        public final DescriptionItemResponseDTO copy(String description, String icon, String iconImageUrl) {
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(icon, "icon");
            return new DescriptionItemResponseDTO(description, icon, iconImageUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DescriptionItemResponseDTO)) {
                return false;
            }
            DescriptionItemResponseDTO descriptionItemResponseDTO = (DescriptionItemResponseDTO) other;
            return Intrinsics.areEqual(this.description, descriptionItemResponseDTO.description) && Intrinsics.areEqual(this.icon, descriptionItemResponseDTO.icon) && Intrinsics.areEqual(this.iconImageUrl, descriptionItemResponseDTO.iconImageUrl);
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final String getIconImageUrl() {
            return this.iconImageUrl;
        }

        public int hashCode() {
            int hashCode = ((this.description.hashCode() * 31) + this.icon.hashCode()) * 31;
            String str = this.iconImageUrl;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "DescriptionItemResponseDTO(description=" + this.description + ", icon=" + this.icon + ", iconImageUrl=" + this.iconImageUrl + ")";
        }

        public DescriptionItemResponseDTO(String description, String icon, String str) {
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(icon, "icon");
            this.description = description;
            this.icon = icon;
            this.iconImageUrl = str;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$FeeResponseDTO;", BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "price", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "<init>", "(Ljava/lang/String;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getPrice", "()Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class FeeResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final PriceWithCurrencyDTO price;
        private final String text;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$FeeResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$FeeResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<FeeResponseDTO> serializer() {
                return DeparturesResponseDTO$FeeResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ FeeResponseDTO(int i5, String str, PriceWithCurrencyDTO priceWithCurrencyDTO, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, DeparturesResponseDTO$FeeResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.text = str;
            this.price = priceWithCurrencyDTO;
        }

        public static /* synthetic */ FeeResponseDTO copy$default(FeeResponseDTO feeResponseDTO, String str, PriceWithCurrencyDTO priceWithCurrencyDTO, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = feeResponseDTO.text;
            }
            if ((i5 & 2) != 0) {
                priceWithCurrencyDTO = feeResponseDTO.price;
            }
            return feeResponseDTO.copy(str, priceWithCurrencyDTO);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(FeeResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.text);
            output.encodeSerializableElement(serialDesc, 1, PriceWithCurrencyDTO$$serializer.INSTANCE, self.price);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final PriceWithCurrencyDTO getPrice() {
            return this.price;
        }

        public final FeeResponseDTO copy(String text, PriceWithCurrencyDTO price) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(price, "price");
            return new FeeResponseDTO(text, price);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeeResponseDTO)) {
                return false;
            }
            FeeResponseDTO feeResponseDTO = (FeeResponseDTO) other;
            return Intrinsics.areEqual(this.text, feeResponseDTO.text) && Intrinsics.areEqual(this.price, feeResponseDTO.price);
        }

        public final PriceWithCurrencyDTO getPrice() {
            return this.price;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.price.hashCode();
        }

        public String toString() {
            return "FeeResponseDTO(text=" + this.text + ", price=" + this.price + ")";
        }

        public FeeResponseDTO(String text, PriceWithCurrencyDTO price) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(price, "price");
            this.text = text;
            this.price = price;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$ProductPriceResponseDTO;", BuildConfig.FLAVOR, "productId", BuildConfig.FLAVOR, "productType", "Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "unitPrice", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "<init>", "(Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProductId", "()Ljava/lang/String;", "getProductType", "()Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "getUnitPrice", "()Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class ProductPriceResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String productId;
        private final ProductTypeResponseDTO productType;
        private final PriceWithCurrencyDTO unitPrice;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$ProductPriceResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$ProductPriceResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<ProductPriceResponseDTO> serializer() {
                return DeparturesResponseDTO$ProductPriceResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ProductPriceResponseDTO(int i5, String str, ProductTypeResponseDTO productTypeResponseDTO, PriceWithCurrencyDTO priceWithCurrencyDTO, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, DeparturesResponseDTO$ProductPriceResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.productId = str;
            this.productType = productTypeResponseDTO;
            this.unitPrice = priceWithCurrencyDTO;
        }

        public static /* synthetic */ ProductPriceResponseDTO copy$default(ProductPriceResponseDTO productPriceResponseDTO, String str, ProductTypeResponseDTO productTypeResponseDTO, PriceWithCurrencyDTO priceWithCurrencyDTO, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = productPriceResponseDTO.productId;
            }
            if ((i5 & 2) != 0) {
                productTypeResponseDTO = productPriceResponseDTO.productType;
            }
            if ((i5 & 4) != 0) {
                priceWithCurrencyDTO = productPriceResponseDTO.unitPrice;
            }
            return productPriceResponseDTO.copy(str, productTypeResponseDTO, priceWithCurrencyDTO);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(ProductPriceResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.productId);
            output.encodeSerializableElement(serialDesc, 1, ProductTypeResponseDTO.Serializer.INSTANCE, self.productType);
            output.encodeSerializableElement(serialDesc, 2, PriceWithCurrencyDTO$$serializer.INSTANCE, self.unitPrice);
        }

        /* renamed from: component1, reason: from getter */
        public final String getProductId() {
            return this.productId;
        }

        /* renamed from: component2, reason: from getter */
        public final ProductTypeResponseDTO getProductType() {
            return this.productType;
        }

        /* renamed from: component3, reason: from getter */
        public final PriceWithCurrencyDTO getUnitPrice() {
            return this.unitPrice;
        }

        public final ProductPriceResponseDTO copy(String productId, ProductTypeResponseDTO productType, PriceWithCurrencyDTO unitPrice) {
            Intrinsics.checkNotNullParameter(productId, "productId");
            Intrinsics.checkNotNullParameter(productType, "productType");
            Intrinsics.checkNotNullParameter(unitPrice, "unitPrice");
            return new ProductPriceResponseDTO(productId, productType, unitPrice);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProductPriceResponseDTO)) {
                return false;
            }
            ProductPriceResponseDTO productPriceResponseDTO = (ProductPriceResponseDTO) other;
            return Intrinsics.areEqual(this.productId, productPriceResponseDTO.productId) && this.productType == productPriceResponseDTO.productType && Intrinsics.areEqual(this.unitPrice, productPriceResponseDTO.unitPrice);
        }

        public final String getProductId() {
            return this.productId;
        }

        public final ProductTypeResponseDTO getProductType() {
            return this.productType;
        }

        public final PriceWithCurrencyDTO getUnitPrice() {
            return this.unitPrice;
        }

        public int hashCode() {
            return (((this.productId.hashCode() * 31) + this.productType.hashCode()) * 31) + this.unitPrice.hashCode();
        }

        public String toString() {
            return "ProductPriceResponseDTO(productId=" + this.productId + ", productType=" + this.productType + ", unitPrice=" + this.unitPrice + ")";
        }

        public ProductPriceResponseDTO(String productId, ProductTypeResponseDTO productType, PriceWithCurrencyDTO unitPrice) {
            Intrinsics.checkNotNullParameter(productId, "productId");
            Intrinsics.checkNotNullParameter(productType, "productType");
            Intrinsics.checkNotNullParameter(unitPrice, "unitPrice");
            this.productId = productId;
            this.productType = productType;
            this.unitPrice = unitPrice;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006!"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$SimpleHarborDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class SimpleHarborDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;
        private final String name;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$SimpleHarborDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$SimpleHarborDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<SimpleHarborDTO> serializer() {
                return DeparturesResponseDTO$SimpleHarborDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ SimpleHarborDTO(int i5, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, DeparturesResponseDTO$SimpleHarborDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.name = str2;
        }

        public static /* synthetic */ SimpleHarborDTO copy$default(SimpleHarborDTO simpleHarborDTO, String str, String str2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = simpleHarborDTO.id;
            }
            if ((i5 & 2) != 0) {
                str2 = simpleHarborDTO.name;
            }
            return simpleHarborDTO.copy(str, str2);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(SimpleHarborDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
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

        public final SimpleHarborDTO copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            return new SimpleHarborDTO(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SimpleHarborDTO)) {
                return false;
            }
            SimpleHarborDTO simpleHarborDTO = (SimpleHarborDTO) other;
            return Intrinsics.areEqual(this.id, simpleHarborDTO.id) && Intrinsics.areEqual(this.name, simpleHarborDTO.name);
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
            return "SimpleHarborDTO(id=" + this.id + ", name=" + this.name + ")";
        }

        public SimpleHarborDTO(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            this.id = id;
            this.name = name;
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0002BCBg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r¢\u0006\u0004\b\u0014\u0010\u0015B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0014\u0010\u001aJ\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\t\u00102\u001a\u00020\u0010HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00130\rHÆ\u0003J}\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00072\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\rHÆ\u0001J\u0013\u00106\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0017HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001J%\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0001¢\u0006\u0002\bAR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&¨\u0006D"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TicketResponseDTO;", BuildConfig.FLAVOR, "carId", BuildConfig.FLAVOR, "category", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CategoryResponseDTO;", "changeFee", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "fees", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$FeeResponseDTO;", "goodsFee", "price", "productPrices", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$ProductPriceResponseDTO;", "soldOut", BuildConfig.FLAVOR, "totalPrice", "surcharges", "Ldk/molslinjen/api/shared/response/TicketSurchargeDTO;", "<init>", "(Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CategoryResponseDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$FeeResponseDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ljava/util/List;ZLdk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CategoryResponseDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$FeeResponseDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ljava/util/List;ZLdk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCarId", "()Ljava/lang/String;", "getCategory", "()Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CategoryResponseDTO;", "getChangeFee", "()Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "getFees", "()Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$FeeResponseDTO;", "getGoodsFee", "getPrice", "getProductPrices", "()Ljava/util/List;", "getSoldOut", "()Z", "getTotalPrice", "getSurcharges", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class TicketResponseDTO {
        private final String carId;
        private final CategoryResponseDTO category;
        private final PriceWithCurrencyDTO changeFee;
        private final FeeResponseDTO fees;
        private final PriceWithCurrencyDTO goodsFee;
        private final PriceWithCurrencyDTO price;
        private final List<ProductPriceResponseDTO> productPrices;
        private final boolean soldOut;
        private final List<TicketSurchargeDTO> surcharges;
        private final PriceWithCurrencyDTO totalPrice;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, new ArrayListSerializer(DeparturesResponseDTO$ProductPriceResponseDTO$$serializer.INSTANCE), null, null, new ArrayListSerializer(TicketSurchargeDTO$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TicketResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TicketResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<TicketResponseDTO> serializer() {
                return DeparturesResponseDTO$TicketResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ TicketResponseDTO(int i5, String str, CategoryResponseDTO categoryResponseDTO, PriceWithCurrencyDTO priceWithCurrencyDTO, FeeResponseDTO feeResponseDTO, PriceWithCurrencyDTO priceWithCurrencyDTO2, PriceWithCurrencyDTO priceWithCurrencyDTO3, List list, boolean z5, PriceWithCurrencyDTO priceWithCurrencyDTO4, List list2, SerializationConstructorMarker serializationConstructorMarker) {
            if (1023 != (i5 & 1023)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 1023, DeparturesResponseDTO$TicketResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.carId = str;
            this.category = categoryResponseDTO;
            this.changeFee = priceWithCurrencyDTO;
            this.fees = feeResponseDTO;
            this.goodsFee = priceWithCurrencyDTO2;
            this.price = priceWithCurrencyDTO3;
            this.productPrices = list;
            this.soldOut = z5;
            this.totalPrice = priceWithCurrencyDTO4;
            this.surcharges = list2;
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(TicketResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.carId);
            output.encodeSerializableElement(serialDesc, 1, DeparturesResponseDTO$CategoryResponseDTO$$serializer.INSTANCE, self.category);
            PriceWithCurrencyDTO$$serializer priceWithCurrencyDTO$$serializer = PriceWithCurrencyDTO$$serializer.INSTANCE;
            output.encodeSerializableElement(serialDesc, 2, priceWithCurrencyDTO$$serializer, self.changeFee);
            output.encodeNullableSerializableElement(serialDesc, 3, DeparturesResponseDTO$FeeResponseDTO$$serializer.INSTANCE, self.fees);
            output.encodeSerializableElement(serialDesc, 4, priceWithCurrencyDTO$$serializer, self.goodsFee);
            output.encodeSerializableElement(serialDesc, 5, priceWithCurrencyDTO$$serializer, self.price);
            output.encodeNullableSerializableElement(serialDesc, 6, kSerializerArr[6], self.productPrices);
            output.encodeBooleanElement(serialDesc, 7, self.soldOut);
            output.encodeSerializableElement(serialDesc, 8, priceWithCurrencyDTO$$serializer, self.totalPrice);
            output.encodeSerializableElement(serialDesc, 9, kSerializerArr[9], self.surcharges);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCarId() {
            return this.carId;
        }

        public final List<TicketSurchargeDTO> component10() {
            return this.surcharges;
        }

        /* renamed from: component2, reason: from getter */
        public final CategoryResponseDTO getCategory() {
            return this.category;
        }

        /* renamed from: component3, reason: from getter */
        public final PriceWithCurrencyDTO getChangeFee() {
            return this.changeFee;
        }

        /* renamed from: component4, reason: from getter */
        public final FeeResponseDTO getFees() {
            return this.fees;
        }

        /* renamed from: component5, reason: from getter */
        public final PriceWithCurrencyDTO getGoodsFee() {
            return this.goodsFee;
        }

        /* renamed from: component6, reason: from getter */
        public final PriceWithCurrencyDTO getPrice() {
            return this.price;
        }

        public final List<ProductPriceResponseDTO> component7() {
            return this.productPrices;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getSoldOut() {
            return this.soldOut;
        }

        /* renamed from: component9, reason: from getter */
        public final PriceWithCurrencyDTO getTotalPrice() {
            return this.totalPrice;
        }

        public final TicketResponseDTO copy(String carId, CategoryResponseDTO category, PriceWithCurrencyDTO changeFee, FeeResponseDTO fees, PriceWithCurrencyDTO goodsFee, PriceWithCurrencyDTO price, List<ProductPriceResponseDTO> productPrices, boolean soldOut, PriceWithCurrencyDTO totalPrice, List<TicketSurchargeDTO> surcharges) {
            Intrinsics.checkNotNullParameter(carId, "carId");
            Intrinsics.checkNotNullParameter(category, "category");
            Intrinsics.checkNotNullParameter(changeFee, "changeFee");
            Intrinsics.checkNotNullParameter(goodsFee, "goodsFee");
            Intrinsics.checkNotNullParameter(price, "price");
            Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
            Intrinsics.checkNotNullParameter(surcharges, "surcharges");
            return new TicketResponseDTO(carId, category, changeFee, fees, goodsFee, price, productPrices, soldOut, totalPrice, surcharges);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TicketResponseDTO)) {
                return false;
            }
            TicketResponseDTO ticketResponseDTO = (TicketResponseDTO) other;
            return Intrinsics.areEqual(this.carId, ticketResponseDTO.carId) && Intrinsics.areEqual(this.category, ticketResponseDTO.category) && Intrinsics.areEqual(this.changeFee, ticketResponseDTO.changeFee) && Intrinsics.areEqual(this.fees, ticketResponseDTO.fees) && Intrinsics.areEqual(this.goodsFee, ticketResponseDTO.goodsFee) && Intrinsics.areEqual(this.price, ticketResponseDTO.price) && Intrinsics.areEqual(this.productPrices, ticketResponseDTO.productPrices) && this.soldOut == ticketResponseDTO.soldOut && Intrinsics.areEqual(this.totalPrice, ticketResponseDTO.totalPrice) && Intrinsics.areEqual(this.surcharges, ticketResponseDTO.surcharges);
        }

        public final String getCarId() {
            return this.carId;
        }

        public final CategoryResponseDTO getCategory() {
            return this.category;
        }

        public final PriceWithCurrencyDTO getChangeFee() {
            return this.changeFee;
        }

        public final FeeResponseDTO getFees() {
            return this.fees;
        }

        public final PriceWithCurrencyDTO getGoodsFee() {
            return this.goodsFee;
        }

        public final PriceWithCurrencyDTO getPrice() {
            return this.price;
        }

        public final List<ProductPriceResponseDTO> getProductPrices() {
            return this.productPrices;
        }

        public final boolean getSoldOut() {
            return this.soldOut;
        }

        public final List<TicketSurchargeDTO> getSurcharges() {
            return this.surcharges;
        }

        public final PriceWithCurrencyDTO getTotalPrice() {
            return this.totalPrice;
        }

        public int hashCode() {
            int hashCode = ((((this.carId.hashCode() * 31) + this.category.hashCode()) * 31) + this.changeFee.hashCode()) * 31;
            FeeResponseDTO feeResponseDTO = this.fees;
            int hashCode2 = (((((hashCode + (feeResponseDTO == null ? 0 : feeResponseDTO.hashCode())) * 31) + this.goodsFee.hashCode()) * 31) + this.price.hashCode()) * 31;
            List<ProductPriceResponseDTO> list = this.productPrices;
            return ((((((hashCode2 + (list != null ? list.hashCode() : 0)) * 31) + Boolean.hashCode(this.soldOut)) * 31) + this.totalPrice.hashCode()) * 31) + this.surcharges.hashCode();
        }

        public String toString() {
            return "TicketResponseDTO(carId=" + this.carId + ", category=" + this.category + ", changeFee=" + this.changeFee + ", fees=" + this.fees + ", goodsFee=" + this.goodsFee + ", price=" + this.price + ", productPrices=" + this.productPrices + ", soldOut=" + this.soldOut + ", totalPrice=" + this.totalPrice + ", surcharges=" + this.surcharges + ")";
        }

        public TicketResponseDTO(String carId, CategoryResponseDTO category, PriceWithCurrencyDTO changeFee, FeeResponseDTO feeResponseDTO, PriceWithCurrencyDTO goodsFee, PriceWithCurrencyDTO price, List<ProductPriceResponseDTO> list, boolean z5, PriceWithCurrencyDTO totalPrice, List<TicketSurchargeDTO> surcharges) {
            Intrinsics.checkNotNullParameter(carId, "carId");
            Intrinsics.checkNotNullParameter(category, "category");
            Intrinsics.checkNotNullParameter(changeFee, "changeFee");
            Intrinsics.checkNotNullParameter(goodsFee, "goodsFee");
            Intrinsics.checkNotNullParameter(price, "price");
            Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
            Intrinsics.checkNotNullParameter(surcharges, "surcharges");
            this.carId = carId;
            this.category = category;
            this.changeFee = changeFee;
            this.fees = feeResponseDTO;
            this.goodsFee = goodsFee;
            this.price = price;
            this.productPrices = list;
            this.soldOut = z5;
            this.totalPrice = totalPrice;
            this.surcharges = surcharges;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002\r\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TimeTableStatusDTO;", "Ldk/molslinjen/api/helpers/serializers/SerializableEnum;", BuildConfig.FLAVOR, "rawValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getRawValue", "()I", "Available", "AvailableLaterDate", "NotAvailable", "NotAvailableForEdit", "Serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable(with = Serializer.class)
    /* loaded from: classes2.dex */
    public static final class TimeTableStatusDTO implements SerializableEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TimeTableStatusDTO[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int rawValue;
        public static final TimeTableStatusDTO Available = new TimeTableStatusDTO("Available", 0, 0);
        public static final TimeTableStatusDTO AvailableLaterDate = new TimeTableStatusDTO("AvailableLaterDate", 1, 1);
        public static final TimeTableStatusDTO NotAvailable = new TimeTableStatusDTO("NotAvailable", 2, 2);
        public static final TimeTableStatusDTO NotAvailableForEdit = new TimeTableStatusDTO("NotAvailableForEdit", 3, 3);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TimeTableStatusDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TimeTableStatusDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<TimeTableStatusDTO> serializer() {
                return Serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TimeTableStatusDTO$Serializer;", "Ldk/molslinjen/api/helpers/serializers/IntToEnumSerializer;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TimeTableStatusDTO;", "<init>", "()V", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Serializer extends IntToEnumSerializer<TimeTableStatusDTO> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(TimeTableStatusDTO.class);
            }
        }

        private static final /* synthetic */ TimeTableStatusDTO[] $values() {
            return new TimeTableStatusDTO[]{Available, AvailableLaterDate, NotAvailable, NotAvailableForEdit};
        }

        static {
            TimeTableStatusDTO[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        private TimeTableStatusDTO(String str, int i5, int i6) {
            this.rawValue = i6;
        }

        public static EnumEntries<TimeTableStatusDTO> getEntries() {
            return $ENTRIES;
        }

        public static TimeTableStatusDTO valueOf(String str) {
            return (TimeTableStatusDTO) Enum.valueOf(TimeTableStatusDTO.class, str);
        }

        public static TimeTableStatusDTO[] values() {
            return (TimeTableStatusDTO[]) $VALUES.clone();
        }

        @Override // dk.molslinjen.api.helpers.serializers.SerializableEnum
        public int getRawValue() {
            return this.rawValue;
        }
    }

    public /* synthetic */ DeparturesResponseDTO(int i5, TimeTableStatusDTO timeTableStatusDTO, List list, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, DeparturesResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.timeTableStatus = timeTableStatusDTO;
        this.departures = list;
        this.siteDeparturesNotice = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeparturesResponseDTO copy$default(DeparturesResponseDTO departuresResponseDTO, TimeTableStatusDTO timeTableStatusDTO, List list, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            timeTableStatusDTO = departuresResponseDTO.timeTableStatus;
        }
        if ((i5 & 2) != 0) {
            list = departuresResponseDTO.departures;
        }
        if ((i5 & 4) != 0) {
            str = departuresResponseDTO.siteDeparturesNotice;
        }
        return departuresResponseDTO.copy(timeTableStatusDTO, list, str);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(DeparturesResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, TimeTableStatusDTO.Serializer.INSTANCE, self.timeTableStatus);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.departures);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.siteDeparturesNotice);
    }

    /* renamed from: component1, reason: from getter */
    public final TimeTableStatusDTO getTimeTableStatus() {
        return this.timeTableStatus;
    }

    public final List<DepartureResponseDTO> component2() {
        return this.departures;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSiteDeparturesNotice() {
        return this.siteDeparturesNotice;
    }

    public final DeparturesResponseDTO copy(TimeTableStatusDTO timeTableStatus, List<DepartureResponseDTO> departures, String siteDeparturesNotice) {
        Intrinsics.checkNotNullParameter(timeTableStatus, "timeTableStatus");
        Intrinsics.checkNotNullParameter(departures, "departures");
        return new DeparturesResponseDTO(timeTableStatus, departures, siteDeparturesNotice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeparturesResponseDTO)) {
            return false;
        }
        DeparturesResponseDTO departuresResponseDTO = (DeparturesResponseDTO) other;
        return this.timeTableStatus == departuresResponseDTO.timeTableStatus && Intrinsics.areEqual(this.departures, departuresResponseDTO.departures) && Intrinsics.areEqual(this.siteDeparturesNotice, departuresResponseDTO.siteDeparturesNotice);
    }

    public final List<DepartureResponseDTO> getDepartures() {
        return this.departures;
    }

    public final String getSiteDeparturesNotice() {
        return this.siteDeparturesNotice;
    }

    public final TimeTableStatusDTO getTimeTableStatus() {
        return this.timeTableStatus;
    }

    public int hashCode() {
        int hashCode = ((this.timeTableStatus.hashCode() * 31) + this.departures.hashCode()) * 31;
        String str = this.siteDeparturesNotice;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DeparturesResponseDTO(timeTableStatus=" + this.timeTableStatus + ", departures=" + this.departures + ", siteDeparturesNotice=" + this.siteDeparturesNotice + ")";
    }

    public DeparturesResponseDTO(TimeTableStatusDTO timeTableStatus, List<DepartureResponseDTO> departures, String str) {
        Intrinsics.checkNotNullParameter(timeTableStatus, "timeTableStatus");
        Intrinsics.checkNotNullParameter(departures, "departures");
        this.timeTableStatus = timeTableStatus;
        this.departures = departures;
        this.siteDeparturesNotice = str;
    }
}
