package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.request.BookRequestParameters;
import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/domain/model/booking/MultiRideInfo;", BuildConfig.FLAVOR, "cardType", BuildConfig.FLAVOR, "cardNumber", "customerId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$MultiRideInfoResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$MultiRideInfoResponseDTO;)V", "getCardType", "()Ljava/lang/String;", "getCardNumber", "getCustomerId", "toRequestParameters", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$MultiRideRequestParameters;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MultiRideInfo {
    private final String cardNumber;
    private final String cardType;
    private final String customerId;

    public MultiRideInfo(String cardType, String cardNumber, String customerId) {
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
        Intrinsics.checkNotNullParameter(customerId, "customerId");
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.customerId = customerId;
    }

    public static /* synthetic */ MultiRideInfo copy$default(MultiRideInfo multiRideInfo, String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = multiRideInfo.cardType;
        }
        if ((i5 & 2) != 0) {
            str2 = multiRideInfo.cardNumber;
        }
        if ((i5 & 4) != 0) {
            str3 = multiRideInfo.customerId;
        }
        return multiRideInfo.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCardType() {
        return this.cardType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCardNumber() {
        return this.cardNumber;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCustomerId() {
        return this.customerId;
    }

    public final MultiRideInfo copy(String cardType, String cardNumber, String customerId) {
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
        Intrinsics.checkNotNullParameter(customerId, "customerId");
        return new MultiRideInfo(cardType, cardNumber, customerId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRideInfo)) {
            return false;
        }
        MultiRideInfo multiRideInfo = (MultiRideInfo) other;
        return Intrinsics.areEqual(this.cardType, multiRideInfo.cardType) && Intrinsics.areEqual(this.cardNumber, multiRideInfo.cardNumber) && Intrinsics.areEqual(this.customerId, multiRideInfo.customerId);
    }

    public final String getCardNumber() {
        return this.cardNumber;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public int hashCode() {
        return (((this.cardType.hashCode() * 31) + this.cardNumber.hashCode()) * 31) + this.customerId.hashCode();
    }

    public final BookRequestParameters.MultiRideRequestParameters toRequestParameters() {
        return new BookRequestParameters.MultiRideRequestParameters(this.cardNumber, this.cardType, this.customerId);
    }

    public String toString() {
        return "MultiRideInfo(cardType=" + this.cardType + ", cardNumber=" + this.cardNumber + ", customerId=" + this.customerId + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiRideInfo(BookingResponseDTO.MultiRideInfoResponseDTO dto) {
        this(dto.getCardType(), dto.getCardNumber(), dto.getCustomerId());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
