package dk.molslinjen.extensions.domain;

import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"countryCodeFlag", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "getCountryCodeFlag", "(Ldk/molslinjen/domain/model/shared/PhoneNumber;)Ljava/lang/Integer;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PhoneNumberExtensionsKt {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final Integer getCountryCodeFlag(PhoneNumber phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "<this>");
        String countryCode = phoneNumber.getCountryCode();
        switch (countryCode.hashCode()) {
            case 42988:
                if (countryCode.equals("+45")) {
                    return Integer.valueOf(R.drawable.flag_dk);
                }
                return null;
            case 42989:
                if (countryCode.equals("+46")) {
                    return Integer.valueOf(R.drawable.flag_se);
                }
                return null;
            case 42990:
                if (countryCode.equals("+47")) {
                    return Integer.valueOf(R.drawable.flag_no);
                }
                return null;
            case 42991:
            default:
                return null;
            case 42992:
                if (countryCode.equals("+49")) {
                    return Integer.valueOf(R.drawable.flag_de);
                }
                return null;
        }
    }
}
