package dk.molslinjen.domain.model.booking;

import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.account.user.UserContactDetails;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0013\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\t\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\t\u0010\u0010J\u0006\u0010\u0018\u001a\u00020\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J1\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Ldk/molslinjen/domain/model/booking/CheckoutContactInfo;", BuildConfig.FLAVOR, "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "email", BuildConfig.FLAVOR, "postalCode", "wasPrefilled", BuildConfig.FLAVOR, "<init>", "(Ldk/molslinjen/domain/model/shared/PhoneNumber;Ljava/lang/String;Ljava/lang/String;Z)V", "userInfo", "Ldk/molslinjen/domain/model/account/user/UserContactDetails;", "(Ldk/molslinjen/domain/model/account/user/UserContactDetails;)V", "customerInfo", "Ldk/molslinjen/domain/model/booking/CustomerInfo;", "(Ldk/molslinjen/domain/model/booking/CustomerInfo;)V", "getPhoneNumber", "()Ldk/molslinjen/domain/model/shared/PhoneNumber;", "getEmail", "()Ljava/lang/String;", "getPostalCode", "getWasPrefilled", "()Z", "toUserContactDetails", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CheckoutContactInfo {
    private final String email;
    private final PhoneNumber phoneNumber;
    private final String postalCode;
    private final boolean wasPrefilled;

    public CheckoutContactInfo(PhoneNumber phoneNumber, String email, String postalCode, boolean z5) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(postalCode, "postalCode");
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.postalCode = postalCode;
        this.wasPrefilled = z5;
    }

    public static /* synthetic */ CheckoutContactInfo copy$default(CheckoutContactInfo checkoutContactInfo, PhoneNumber phoneNumber, String str, String str2, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            phoneNumber = checkoutContactInfo.phoneNumber;
        }
        if ((i5 & 2) != 0) {
            str = checkoutContactInfo.email;
        }
        if ((i5 & 4) != 0) {
            str2 = checkoutContactInfo.postalCode;
        }
        if ((i5 & 8) != 0) {
            z5 = checkoutContactInfo.wasPrefilled;
        }
        return checkoutContactInfo.copy(phoneNumber, str, str2, z5);
    }

    /* renamed from: component1, reason: from getter */
    public final PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getWasPrefilled() {
        return this.wasPrefilled;
    }

    public final CheckoutContactInfo copy(PhoneNumber phoneNumber, String email, String postalCode, boolean wasPrefilled) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(postalCode, "postalCode");
        return new CheckoutContactInfo(phoneNumber, email, postalCode, wasPrefilled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckoutContactInfo)) {
            return false;
        }
        CheckoutContactInfo checkoutContactInfo = (CheckoutContactInfo) other;
        return Intrinsics.areEqual(this.phoneNumber, checkoutContactInfo.phoneNumber) && Intrinsics.areEqual(this.email, checkoutContactInfo.email) && Intrinsics.areEqual(this.postalCode, checkoutContactInfo.postalCode) && this.wasPrefilled == checkoutContactInfo.wasPrefilled;
    }

    public final String getEmail() {
        return this.email;
    }

    public final PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public final boolean getWasPrefilled() {
        return this.wasPrefilled;
    }

    public int hashCode() {
        return (((((this.phoneNumber.hashCode() * 31) + this.email.hashCode()) * 31) + this.postalCode.hashCode()) * 31) + Boolean.hashCode(this.wasPrefilled);
    }

    public String toString() {
        return "CheckoutContactInfo(phoneNumber=" + this.phoneNumber + ", email=" + this.email + ", postalCode=" + this.postalCode + ", wasPrefilled=" + this.wasPrefilled + ")";
    }

    public final UserContactDetails toUserContactDetails() {
        return new UserContactDetails(this.email, this.phoneNumber, this.postalCode);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CheckoutContactInfo(UserContactDetails userContactDetails) {
        this(r2, r4, r3, r1 != null);
        String postalCode;
        String postalCode2;
        String str = null;
        PhoneNumber default$default = (userContactDetails == null || (default$default = userContactDetails.getPhoneNumber()) == null) ? PhoneNumber.Companion.default$default(PhoneNumber.INSTANCE, null, 1, null) : default$default;
        String str2 = BuildConfig.FLAVOR;
        String str3 = (userContactDetails == null || (str3 = userContactDetails.getEmail()) == null) ? BuildConfig.FLAVOR : str3;
        if (userContactDetails != null && (postalCode2 = userContactDetails.getPostalCode()) != null) {
            str2 = postalCode2;
        }
        if (userContactDetails != null && (postalCode = userContactDetails.getPostalCode()) != null) {
            str = StringExtensionsKt.nullIfEmpty(postalCode);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CheckoutContactInfo(CustomerInfo customerInfo) {
        this(customerInfo.getPhoneNumber(), customerInfo.getEmail(), customerInfo.getPostalCode(), true);
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
    }
}
