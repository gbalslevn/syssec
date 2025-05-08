package dk.molslinjen.domain.model.booking;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.booking.response.DeparturesResponseDTO;
import dk.molslinjen.domain.model.booking.TicketDescriptionItem;
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
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000245BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\u0011Bc\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\f\u0010\u0016J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003JQ\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0013HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J%\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001e¨\u00066"}, d2 = {"Ldk/molslinjen/domain/model/booking/TicketCategory;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "type", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "name", "subHeader", "descriptionItems", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/TicketDescriptionItem;", "shortDescriptionItems", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/booking/TicketCategoryType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "dto", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CategoryResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CategoryResponseDTO;)V", "(Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/domain/model/booking/TicketCategoryType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getType", "()Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "getName", "getSubHeader", "getDescriptionItems", "()Ljava/util/List;", "getShortDescriptionItems", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class TicketCategory {
    private static final TicketCategory mockBlueClass;
    private static final TicketCategory mockLowPrice;
    private static final TicketCategory mockStandard;
    private final List<TicketDescriptionItem> descriptionItems;
    private final String id;
    private final String name;
    private final List<String> shortDescriptionItems;
    private final String subHeader;
    private final TicketCategoryType type;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.booking.TicketCategoryType", TicketCategoryType.values()), null, null, new ArrayListSerializer(TicketDescriptionItem$$serializer.INSTANCE), new ArrayListSerializer(StringSerializer.INSTANCE)};

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/domain/model/booking/TicketCategory$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mockLowPrice", "Ldk/molslinjen/domain/model/booking/TicketCategory;", "getMockLowPrice", "()Ldk/molslinjen/domain/model/booking/TicketCategory;", "mockStandard", "getMockStandard", "mockBlueClass", "getMockBlueClass", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TicketCategory getMockBlueClass() {
            return TicketCategory.mockBlueClass;
        }

        public final TicketCategory getMockLowPrice() {
            return TicketCategory.mockLowPrice;
        }

        public final TicketCategory getMockStandard() {
            return TicketCategory.mockStandard;
        }

        public final KSerializer<TicketCategory> serializer() {
            return TicketCategory$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        TicketCategoryType ticketCategoryType = TicketCategoryType.LowPrice;
        TicketDescriptionItem.Companion companion = TicketDescriptionItem.INSTANCE;
        TicketCategory ticketCategory = new TicketCategory("1", ticketCategoryType, "Lavpris", "Den billigste billet", CollectionsKt.listOf((Object[]) new TicketDescriptionItem[]{companion.getMock1(), companion.getMock2(), companion.getMock3(), companion.getMock4(), companion.getMock5(), companion.getMock6()}), CollectionsKt.listOf((Object[]) new String[]{"Ingen refundering", "Ombook mod gebyr"}));
        mockLowPrice = ticketCategory;
        mockStandard = new TicketCategory("1", TicketCategoryType.Standard, "Standard", "Den billigste billet", CollectionsKt.listOf((Object[]) new TicketDescriptionItem[]{companion.getMock1(), companion.getMock2(), companion.getMock3(), companion.getMock4(), companion.getMock5(), companion.getMock6()}), CollectionsKt.listOf((Object[]) new String[]{"Ingen refundering", "Ombook mod gebyr"}));
        mockBlueClass = copy$default(ticketCategory, null, TicketCategoryType.BlueClass, null, null, null, null, 61, null);
    }

    public /* synthetic */ TicketCategory(int i5, String str, TicketCategoryType ticketCategoryType, String str2, String str3, List list, List list2, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i5 & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 31, TicketCategory$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.type = ticketCategoryType;
        this.name = str2;
        this.subHeader = str3;
        this.descriptionItems = list;
        if ((i5 & 32) == 0) {
            this.shortDescriptionItems = CollectionsKt.emptyList();
        } else {
            this.shortDescriptionItems = list2;
        }
    }

    public static /* synthetic */ TicketCategory copy$default(TicketCategory ticketCategory, String str, TicketCategoryType ticketCategoryType, String str2, String str3, List list, List list2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = ticketCategory.id;
        }
        if ((i5 & 2) != 0) {
            ticketCategoryType = ticketCategory.type;
        }
        TicketCategoryType ticketCategoryType2 = ticketCategoryType;
        if ((i5 & 4) != 0) {
            str2 = ticketCategory.name;
        }
        String str4 = str2;
        if ((i5 & 8) != 0) {
            str3 = ticketCategory.subHeader;
        }
        String str5 = str3;
        if ((i5 & 16) != 0) {
            list = ticketCategory.descriptionItems;
        }
        List list3 = list;
        if ((i5 & 32) != 0) {
            list2 = ticketCategory.shortDescriptionItems;
        }
        return ticketCategory.copy(str, ticketCategoryType2, str4, str5, list3, list2);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(TicketCategory self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.type);
        output.encodeStringElement(serialDesc, 2, self.name);
        output.encodeStringElement(serialDesc, 3, self.subHeader);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.descriptionItems);
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && Intrinsics.areEqual(self.shortDescriptionItems, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.shortDescriptionItems);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final TicketCategoryType getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSubHeader() {
        return this.subHeader;
    }

    public final List<TicketDescriptionItem> component5() {
        return this.descriptionItems;
    }

    public final List<String> component6() {
        return this.shortDescriptionItems;
    }

    public final TicketCategory copy(String id, TicketCategoryType type, String name, String subHeader, List<TicketDescriptionItem> descriptionItems, List<String> shortDescriptionItems) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subHeader, "subHeader");
        Intrinsics.checkNotNullParameter(descriptionItems, "descriptionItems");
        Intrinsics.checkNotNullParameter(shortDescriptionItems, "shortDescriptionItems");
        return new TicketCategory(id, type, name, subHeader, descriptionItems, shortDescriptionItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TicketCategory)) {
            return false;
        }
        TicketCategory ticketCategory = (TicketCategory) other;
        return Intrinsics.areEqual(this.id, ticketCategory.id) && this.type == ticketCategory.type && Intrinsics.areEqual(this.name, ticketCategory.name) && Intrinsics.areEqual(this.subHeader, ticketCategory.subHeader) && Intrinsics.areEqual(this.descriptionItems, ticketCategory.descriptionItems) && Intrinsics.areEqual(this.shortDescriptionItems, ticketCategory.shortDescriptionItems);
    }

    public final List<TicketDescriptionItem> getDescriptionItems() {
        return this.descriptionItems;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getShortDescriptionItems() {
        return this.shortDescriptionItems;
    }

    public final String getSubHeader() {
        return this.subHeader;
    }

    public final TicketCategoryType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.name.hashCode()) * 31) + this.subHeader.hashCode()) * 31) + this.descriptionItems.hashCode()) * 31) + this.shortDescriptionItems.hashCode();
    }

    public String toString() {
        return "TicketCategory(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", subHeader=" + this.subHeader + ", descriptionItems=" + this.descriptionItems + ", shortDescriptionItems=" + this.shortDescriptionItems + ")";
    }

    public TicketCategory(String id, TicketCategoryType type, String name, String subHeader, List<TicketDescriptionItem> descriptionItems, List<String> shortDescriptionItems) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subHeader, "subHeader");
        Intrinsics.checkNotNullParameter(descriptionItems, "descriptionItems");
        Intrinsics.checkNotNullParameter(shortDescriptionItems, "shortDescriptionItems");
        this.id = id;
        this.type = type;
        this.name = name;
        this.subHeader = subHeader;
        this.descriptionItems = descriptionItems;
        this.shortDescriptionItems = shortDescriptionItems;
    }

    public /* synthetic */ TicketCategory(String str, TicketCategoryType ticketCategoryType, String str2, String str3, List list, List list2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, ticketCategoryType, str2, str3, list, (i5 & 32) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TicketCategory(DeparturesResponseDTO.CategoryResponseDTO dto) {
        this(r2, r3, r4, r5, r6, r9 == null ? CollectionsKt.emptyList() : r9);
        Intrinsics.checkNotNullParameter(dto, "dto");
        String id = dto.getId();
        TicketCategoryType invoke = TicketCategoryType.INSTANCE.invoke(dto.getId());
        String name = dto.getName();
        String subHeader = dto.getSubHeader();
        List<DeparturesResponseDTO.DescriptionItemResponseDTO> descriptionItems = dto.getDescriptionItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(descriptionItems, 10));
        Iterator<T> it = descriptionItems.iterator();
        while (it.hasNext()) {
            arrayList.add(new TicketDescriptionItem((DeparturesResponseDTO.DescriptionItemResponseDTO) it.next()));
        }
        List<String> shortDescriptionItems = dto.getShortDescriptionItems();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TicketCategory(String id) {
        this(id, TicketCategoryType.INSTANCE.invoke(id), BuildConfig.FLAVOR, BuildConfig.FLAVOR, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(id, "id");
    }
}
