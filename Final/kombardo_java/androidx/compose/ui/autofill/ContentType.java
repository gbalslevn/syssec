package androidx.compose.ui.autofill;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0017\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/autofill/ContentType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "contentHints", "<init>", "(Ljava/util/Set;)V", "contentHint", "(Ljava/lang/String;)V", "Ljava/util/Set;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContentType {
    private final Set<String> contentHints;
    public static final int $stable = 8;
    private static final ContentType Username = new ContentType("username");
    private static final ContentType Password = new ContentType("password");
    private static final ContentType EmailAddress = new ContentType("emailAddress");
    private static final ContentType NewUsername = new ContentType("newUsername");
    private static final ContentType NewPassword = new ContentType("newPassword");
    private static final ContentType PostalAddress = new ContentType("postalAddress");
    private static final ContentType PostalCode = new ContentType("postalCode");
    private static final ContentType CreditCardNumber = new ContentType("creditCardNumber");
    private static final ContentType CreditCardSecurityCode = new ContentType("creditCardSecurityCode");
    private static final ContentType CreditCardExpirationDate = new ContentType("creditCardExpirationDate");
    private static final ContentType CreditCardExpirationMonth = new ContentType("creditCardExpirationMonth");
    private static final ContentType CreditCardExpirationYear = new ContentType("creditCardExpirationYear");
    private static final ContentType CreditCardExpirationDay = new ContentType("creditCardExpirationDay");
    private static final ContentType AddressCountry = new ContentType("addressCountry");
    private static final ContentType AddressRegion = new ContentType("addressRegion");
    private static final ContentType AddressLocality = new ContentType("addressLocality");
    private static final ContentType AddressStreet = new ContentType("streetAddress");
    private static final ContentType AddressAuxiliaryDetails = new ContentType("extendedAddress");
    private static final ContentType PostalCodeExtended = new ContentType("extendedPostalCode");
    private static final ContentType PersonFullName = new ContentType("personName");
    private static final ContentType PersonFirstName = new ContentType("personGivenName");
    private static final ContentType PersonLastName = new ContentType("personFamilyName");
    private static final ContentType PersonMiddleName = new ContentType("personMiddleName");
    private static final ContentType PersonMiddleInitial = new ContentType("personMiddleInitial");
    private static final ContentType PersonNamePrefix = new ContentType("personNamePrefix");
    private static final ContentType PersonNameSuffix = new ContentType("personNameSuffix");
    private static final ContentType PhoneNumber = new ContentType("phoneNumber");
    private static final ContentType PhoneNumberDevice = new ContentType("phoneNumberDevice");
    private static final ContentType PhoneCountryCode = new ContentType("phoneCountryCode");
    private static final ContentType PhoneNumberNational = new ContentType("phoneNational");
    private static final ContentType Gender = new ContentType("gender");
    private static final ContentType BirthDateFull = new ContentType("birthDateFull");
    private static final ContentType BirthDateDay = new ContentType("birthDateDay");
    private static final ContentType BirthDateMonth = new ContentType("birthDateMonth");
    private static final ContentType BirthDateYear = new ContentType("birthDateYear");
    private static final ContentType SmsOtpCode = new ContentType("smsOTPCode");

    private ContentType(Set<String> set) {
        this.contentHints = set;
    }

    public ContentType(String str) {
        this((Set<String>) SetsKt.setOf(str));
    }
}
