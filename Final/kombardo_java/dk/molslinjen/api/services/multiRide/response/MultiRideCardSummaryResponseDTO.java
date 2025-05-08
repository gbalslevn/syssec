package dk.molslinjen.api.services.multiRide.response;

import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO$$serializer;
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
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000245B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eBU\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003JG\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J%\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00066"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRideCardSummaryResponseDTO;", BuildConfig.FLAVOR, "cardNumber", BuildConfig.FLAVOR, "cardType", "totalPrice", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "numberOfTickets", BuildConfig.FLAVOR, "validUntil", "Lorg/threeten/bp/LocalDate;", "category", "Ldk/molslinjen/api/services/multiRide/response/MultiRideTicketCategoryResponseDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;ILorg/threeten/bp/LocalDate;Ldk/molslinjen/api/services/multiRide/response/MultiRideTicketCategoryResponseDTO;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;ILorg/threeten/bp/LocalDate;Ldk/molslinjen/api/services/multiRide/response/MultiRideTicketCategoryResponseDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCardNumber", "()Ljava/lang/String;", "getCardType", "getTotalPrice", "()Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "getNumberOfTickets", "()I", "getValidUntil$annotations", "()V", "getValidUntil", "()Lorg/threeten/bp/LocalDate;", "getCategory", "()Ldk/molslinjen/api/services/multiRide/response/MultiRideTicketCategoryResponseDTO;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class MultiRideCardSummaryResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String cardNumber;
    private final String cardType;
    private final MultiRideTicketCategoryResponseDTO category;
    private final int numberOfTickets;
    private final PriceWithCurrencyDTO totalPrice;
    private final LocalDate validUntil;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRideCardSummaryResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/multiRide/response/MultiRideCardSummaryResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<MultiRideCardSummaryResponseDTO> serializer() {
            return MultiRideCardSummaryResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ MultiRideCardSummaryResponseDTO(int i5, String str, String str2, PriceWithCurrencyDTO priceWithCurrencyDTO, int i6, LocalDate localDate, MultiRideTicketCategoryResponseDTO multiRideTicketCategoryResponseDTO, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i5 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 63, MultiRideCardSummaryResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.cardNumber = str;
        this.cardType = str2;
        this.totalPrice = priceWithCurrencyDTO;
        this.numberOfTickets = i6;
        this.validUntil = localDate;
        this.category = multiRideTicketCategoryResponseDTO;
    }

    public static /* synthetic */ MultiRideCardSummaryResponseDTO copy$default(MultiRideCardSummaryResponseDTO multiRideCardSummaryResponseDTO, String str, String str2, PriceWithCurrencyDTO priceWithCurrencyDTO, int i5, LocalDate localDate, MultiRideTicketCategoryResponseDTO multiRideTicketCategoryResponseDTO, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = multiRideCardSummaryResponseDTO.cardNumber;
        }
        if ((i6 & 2) != 0) {
            str2 = multiRideCardSummaryResponseDTO.cardType;
        }
        String str3 = str2;
        if ((i6 & 4) != 0) {
            priceWithCurrencyDTO = multiRideCardSummaryResponseDTO.totalPrice;
        }
        PriceWithCurrencyDTO priceWithCurrencyDTO2 = priceWithCurrencyDTO;
        if ((i6 & 8) != 0) {
            i5 = multiRideCardSummaryResponseDTO.numberOfTickets;
        }
        int i7 = i5;
        if ((i6 & 16) != 0) {
            localDate = multiRideCardSummaryResponseDTO.validUntil;
        }
        LocalDate localDate2 = localDate;
        if ((i6 & 32) != 0) {
            multiRideTicketCategoryResponseDTO = multiRideCardSummaryResponseDTO.category;
        }
        return multiRideCardSummaryResponseDTO.copy(str, str3, priceWithCurrencyDTO2, i7, localDate2, multiRideTicketCategoryResponseDTO);
    }

    @Serializable(with = LocalDateWithTimeSerializer.class)
    public static /* synthetic */ void getValidUntil$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(MultiRideCardSummaryResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.cardNumber);
        output.encodeStringElement(serialDesc, 1, self.cardType);
        output.encodeSerializableElement(serialDesc, 2, PriceWithCurrencyDTO$$serializer.INSTANCE, self.totalPrice);
        output.encodeIntElement(serialDesc, 3, self.numberOfTickets);
        output.encodeSerializableElement(serialDesc, 4, LocalDateWithTimeSerializer.INSTANCE, self.validUntil);
        output.encodeSerializableElement(serialDesc, 5, MultiRideTicketCategoryResponseDTO$$serializer.INSTANCE, self.category);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCardNumber() {
        return this.cardNumber;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCardType() {
        return this.cardType;
    }

    /* renamed from: component3, reason: from getter */
    public final PriceWithCurrencyDTO getTotalPrice() {
        return this.totalPrice;
    }

    /* renamed from: component4, reason: from getter */
    public final int getNumberOfTickets() {
        return this.numberOfTickets;
    }

    /* renamed from: component5, reason: from getter */
    public final LocalDate getValidUntil() {
        return this.validUntil;
    }

    /* renamed from: component6, reason: from getter */
    public final MultiRideTicketCategoryResponseDTO getCategory() {
        return this.category;
    }

    public final MultiRideCardSummaryResponseDTO copy(String cardNumber, String cardType, PriceWithCurrencyDTO totalPrice, int numberOfTickets, LocalDate validUntil, MultiRideTicketCategoryResponseDTO category) {
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        Intrinsics.checkNotNullParameter(category, "category");
        return new MultiRideCardSummaryResponseDTO(cardNumber, cardType, totalPrice, numberOfTickets, validUntil, category);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRideCardSummaryResponseDTO)) {
            return false;
        }
        MultiRideCardSummaryResponseDTO multiRideCardSummaryResponseDTO = (MultiRideCardSummaryResponseDTO) other;
        return Intrinsics.areEqual(this.cardNumber, multiRideCardSummaryResponseDTO.cardNumber) && Intrinsics.areEqual(this.cardType, multiRideCardSummaryResponseDTO.cardType) && Intrinsics.areEqual(this.totalPrice, multiRideCardSummaryResponseDTO.totalPrice) && this.numberOfTickets == multiRideCardSummaryResponseDTO.numberOfTickets && Intrinsics.areEqual(this.validUntil, multiRideCardSummaryResponseDTO.validUntil) && Intrinsics.areEqual(this.category, multiRideCardSummaryResponseDTO.category);
    }

    public final String getCardNumber() {
        return this.cardNumber;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final MultiRideTicketCategoryResponseDTO getCategory() {
        return this.category;
    }

    public final int getNumberOfTickets() {
        return this.numberOfTickets;
    }

    public final PriceWithCurrencyDTO getTotalPrice() {
        return this.totalPrice;
    }

    public final LocalDate getValidUntil() {
        return this.validUntil;
    }

    public int hashCode() {
        String str = this.cardNumber;
        return ((((((((((str == null ? 0 : str.hashCode()) * 31) + this.cardType.hashCode()) * 31) + this.totalPrice.hashCode()) * 31) + Integer.hashCode(this.numberOfTickets)) * 31) + this.validUntil.hashCode()) * 31) + this.category.hashCode();
    }

    public String toString() {
        return "MultiRideCardSummaryResponseDTO(cardNumber=" + this.cardNumber + ", cardType=" + this.cardType + ", totalPrice=" + this.totalPrice + ", numberOfTickets=" + this.numberOfTickets + ", validUntil=" + this.validUntil + ", category=" + this.category + ")";
    }

    public MultiRideCardSummaryResponseDTO(String str, String cardType, PriceWithCurrencyDTO totalPrice, int i5, LocalDate validUntil, MultiRideTicketCategoryResponseDTO category) {
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        Intrinsics.checkNotNullParameter(category, "category");
        this.cardNumber = str;
        this.cardType = cardType;
        this.totalPrice = totalPrice;
        this.numberOfTickets = i5;
        this.validUntil = validUntil;
        this.category = category;
    }
}
