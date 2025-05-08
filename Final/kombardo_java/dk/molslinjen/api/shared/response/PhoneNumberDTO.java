package dk.molslinjen.api.shared.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/api/shared/response/PhoneNumberDTO;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "countryCode", "nationalNumber", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCountryCode", "getNationalNumber", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PhoneNumberDTO {
    private final String countryCode;
    private final String nationalNumber;

    public PhoneNumberDTO(String countryCode, String nationalNumber) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(nationalNumber, "nationalNumber");
        this.countryCode = countryCode;
        this.nationalNumber = nationalNumber;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhoneNumberDTO)) {
            return false;
        }
        PhoneNumberDTO phoneNumberDTO = (PhoneNumberDTO) other;
        return Intrinsics.areEqual(this.countryCode, phoneNumberDTO.countryCode) && Intrinsics.areEqual(this.nationalNumber, phoneNumberDTO.nationalNumber);
    }

    public int hashCode() {
        return (this.countryCode.hashCode() * 31) + this.nationalNumber.hashCode();
    }

    public String toString() {
        return this.countryCode + this.nationalNumber;
    }
}
