package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001f"}, d2 = {"Ldk/molslinjen/domain/model/booking/CustomerInfo;", BuildConfig.FLAVOR, "email", BuildConfig.FLAVOR, "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "postalCode", "licensePlate", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PhoneNumber;Ljava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$CustomerInfoResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$CustomerInfoResponseDTO;)V", "getEmail", "()Ljava/lang/String;", "getPhoneNumber", "()Ldk/molslinjen/domain/model/shared/PhoneNumber;", "getPostalCode", "getLicensePlate", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CustomerInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CustomerInfo mock = new CustomerInfo("xxx@vertica.dk", new PhoneNumber("45", "12345678"), "8000", "AB123456");
    private final String email;
    private final String licensePlate;
    private final PhoneNumber phoneNumber;
    private final String postalCode;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/CustomerInfo$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/CustomerInfo;", "getMock", "()Ldk/molslinjen/domain/model/booking/CustomerInfo;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CustomerInfo getMock() {
            return CustomerInfo.mock;
        }

        private Companion() {
        }
    }

    public CustomerInfo(String email, PhoneNumber phoneNumber, String postalCode, String str) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(postalCode, "postalCode");
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
        this.licensePlate = str;
    }

    public static /* synthetic */ CustomerInfo copy$default(CustomerInfo customerInfo, String str, PhoneNumber phoneNumber, String str2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = customerInfo.email;
        }
        if ((i5 & 2) != 0) {
            phoneNumber = customerInfo.phoneNumber;
        }
        if ((i5 & 4) != 0) {
            str2 = customerInfo.postalCode;
        }
        if ((i5 & 8) != 0) {
            str3 = customerInfo.licensePlate;
        }
        return customerInfo.copy(str, phoneNumber, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component2, reason: from getter */
    public final PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLicensePlate() {
        return this.licensePlate;
    }

    public final CustomerInfo copy(String email, PhoneNumber phoneNumber, String postalCode, String licensePlate) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(postalCode, "postalCode");
        return new CustomerInfo(email, phoneNumber, postalCode, licensePlate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomerInfo)) {
            return false;
        }
        CustomerInfo customerInfo = (CustomerInfo) other;
        return Intrinsics.areEqual(this.email, customerInfo.email) && Intrinsics.areEqual(this.phoneNumber, customerInfo.phoneNumber) && Intrinsics.areEqual(this.postalCode, customerInfo.postalCode) && Intrinsics.areEqual(this.licensePlate, customerInfo.licensePlate);
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getLicensePlate() {
        return this.licensePlate;
    }

    public final PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public int hashCode() {
        int hashCode = ((((this.email.hashCode() * 31) + this.phoneNumber.hashCode()) * 31) + this.postalCode.hashCode()) * 31;
        String str = this.licensePlate;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CustomerInfo(email=" + this.email + ", phoneNumber=" + this.phoneNumber + ", postalCode=" + this.postalCode + ", licensePlate=" + this.licensePlate + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomerInfo(BookingResponseDTO.CustomerInfoResponseDTO dto) {
        this(dto.getEmail(), PhoneNumber.INSTANCE.asValidPhoneNumber(dto.getPrefix(), dto.getPhone()), dto.getPostalCode(), dto.getLicensePlate());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
