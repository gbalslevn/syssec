package dk.molslinjen.domain.model.booking;

import androidx.core.text.HtmlCompat;
import dk.molslinjen.api.services.booking.response.DeparturesResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB/\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0005\u0010\u000eJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006$"}, d2 = {"Ldk/molslinjen/domain/model/booking/TicketDescriptionItem;", BuildConfig.FLAVOR, "description", BuildConfig.FLAVOR, "iconUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$DescriptionItemResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$DescriptionItemResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDescription", "()Ljava/lang/String;", "getIconUrl", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class TicketDescriptionItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TicketDescriptionItem mock1 = new TicketDescriptionItem("Check-in senest 10 min. før afgang", "https://qa.kombardoexpressen.dk/media/505711/included.svg");
    private static final TicketDescriptionItem mock2 = new TicketDescriptionItem("Ombooking </span>mod gebyr<span> samt evt. prisforskel helt frem til afgang", "https://qa.kombardoexpressen.dk/media/505711/included.svg");
    private static final TicketDescriptionItem mock3 = new TicketDescriptionItem("Kan ændres en måned frem fra oprindelig afgang", "https://qa.kombardoexpressen.dk/media/505711/included.svg");
    private static final TicketDescriptionItem mock4 = new TicketDescriptionItem("Gælder for Bil op til 1,85 mete", "https://qa.kombardoexpressen.dk/media/505711/included.svg");
    private static final TicketDescriptionItem mock5 = new TicketDescriptionItem("Op til 9 personer", "https://qa.kombardoexpressen.dk/media/505711/included.svg");
    private static final TicketDescriptionItem mock6 = new TicketDescriptionItem("Ingen refundering", "https://qa.kombardoexpressen.dk/media/505711/included.svg");
    private final String description;
    private final String iconUrl;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/domain/model/booking/TicketDescriptionItem$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock1", "Ldk/molslinjen/domain/model/booking/TicketDescriptionItem;", "getMock1", "()Ldk/molslinjen/domain/model/booking/TicketDescriptionItem;", "mock2", "getMock2", "mock3", "getMock3", "mock4", "getMock4", "mock5", "getMock5", "mock6", "getMock6", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TicketDescriptionItem getMock1() {
            return TicketDescriptionItem.mock1;
        }

        public final TicketDescriptionItem getMock2() {
            return TicketDescriptionItem.mock2;
        }

        public final TicketDescriptionItem getMock3() {
            return TicketDescriptionItem.mock3;
        }

        public final TicketDescriptionItem getMock4() {
            return TicketDescriptionItem.mock4;
        }

        public final TicketDescriptionItem getMock5() {
            return TicketDescriptionItem.mock5;
        }

        public final TicketDescriptionItem getMock6() {
            return TicketDescriptionItem.mock6;
        }

        public final KSerializer<TicketDescriptionItem> serializer() {
            return TicketDescriptionItem$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TicketDescriptionItem(int i5, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, TicketDescriptionItem$$serializer.INSTANCE.getDescriptor());
        }
        this.description = str;
        this.iconUrl = str2;
    }

    public static /* synthetic */ TicketDescriptionItem copy$default(TicketDescriptionItem ticketDescriptionItem, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = ticketDescriptionItem.description;
        }
        if ((i5 & 2) != 0) {
            str2 = ticketDescriptionItem.iconUrl;
        }
        return ticketDescriptionItem.copy(str, str2);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(TicketDescriptionItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.description);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.iconUrl);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component2, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final TicketDescriptionItem copy(String description, String iconUrl) {
        Intrinsics.checkNotNullParameter(description, "description");
        return new TicketDescriptionItem(description, iconUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TicketDescriptionItem)) {
            return false;
        }
        TicketDescriptionItem ticketDescriptionItem = (TicketDescriptionItem) other;
        return Intrinsics.areEqual(this.description, ticketDescriptionItem.description) && Intrinsics.areEqual(this.iconUrl, ticketDescriptionItem.iconUrl);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public int hashCode() {
        int hashCode = this.description.hashCode() * 31;
        String str = this.iconUrl;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "TicketDescriptionItem(description=" + this.description + ", iconUrl=" + this.iconUrl + ")";
    }

    public TicketDescriptionItem(String description, String str) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.description = description;
        this.iconUrl = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TicketDescriptionItem(DeparturesResponseDTO.DescriptionItemResponseDTO dto) {
        this(StringsKt.trim(HtmlCompat.fromHtml(dto.getDescription(), 0).toString(), '\n'), dto.getIconImageUrl());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
