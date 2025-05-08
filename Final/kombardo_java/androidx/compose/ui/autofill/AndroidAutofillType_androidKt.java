package androidx.compose.ui.autofill;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\"6\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002`\u00038\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\u0006\u0010\u0007\"\u001e\u0010\f\u001a\u00020\u0002*\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Ljava/util/HashMap;", "Landroidx/compose/ui/autofill/AutofillType;", BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "androidAutofillTypes", "Ljava/util/HashMap;", "getAndroidAutofillTypes$annotations", "()V", "getAndroidType", "(Landroidx/compose/ui/autofill/AutofillType;)Ljava/lang/String;", "getAndroidType$annotations", "(Landroidx/compose/ui/autofill/AutofillType;)V", "androidType", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidAutofillType_androidKt {
    private static final HashMap<AutofillType, String> androidAutofillTypes = MapsKt.hashMapOf(TuplesKt.to(AutofillType.EmailAddress, "emailAddress"), TuplesKt.to(AutofillType.Username, "username"), TuplesKt.to(AutofillType.Password, "password"), TuplesKt.to(AutofillType.NewUsername, "newUsername"), TuplesKt.to(AutofillType.NewPassword, "newPassword"), TuplesKt.to(AutofillType.PostalAddress, "postalAddress"), TuplesKt.to(AutofillType.PostalCode, "postalCode"), TuplesKt.to(AutofillType.CreditCardNumber, "creditCardNumber"), TuplesKt.to(AutofillType.CreditCardSecurityCode, "creditCardSecurityCode"), TuplesKt.to(AutofillType.CreditCardExpirationDate, "creditCardExpirationDate"), TuplesKt.to(AutofillType.CreditCardExpirationMonth, "creditCardExpirationMonth"), TuplesKt.to(AutofillType.CreditCardExpirationYear, "creditCardExpirationYear"), TuplesKt.to(AutofillType.CreditCardExpirationDay, "creditCardExpirationDay"), TuplesKt.to(AutofillType.AddressCountry, "addressCountry"), TuplesKt.to(AutofillType.AddressRegion, "addressRegion"), TuplesKt.to(AutofillType.AddressLocality, "addressLocality"), TuplesKt.to(AutofillType.AddressStreet, "streetAddress"), TuplesKt.to(AutofillType.AddressAuxiliaryDetails, "extendedAddress"), TuplesKt.to(AutofillType.PostalCodeExtended, "extendedPostalCode"), TuplesKt.to(AutofillType.PersonFullName, "personName"), TuplesKt.to(AutofillType.PersonFirstName, "personGivenName"), TuplesKt.to(AutofillType.PersonLastName, "personFamilyName"), TuplesKt.to(AutofillType.PersonMiddleName, "personMiddleName"), TuplesKt.to(AutofillType.PersonMiddleInitial, "personMiddleInitial"), TuplesKt.to(AutofillType.PersonNamePrefix, "personNamePrefix"), TuplesKt.to(AutofillType.PersonNameSuffix, "personNameSuffix"), TuplesKt.to(AutofillType.PhoneNumber, "phoneNumber"), TuplesKt.to(AutofillType.PhoneNumberDevice, "phoneNumberDevice"), TuplesKt.to(AutofillType.PhoneCountryCode, "phoneCountryCode"), TuplesKt.to(AutofillType.PhoneNumberNational, "phoneNational"), TuplesKt.to(AutofillType.Gender, "gender"), TuplesKt.to(AutofillType.BirthDateFull, "birthDateFull"), TuplesKt.to(AutofillType.BirthDateDay, "birthDateDay"), TuplesKt.to(AutofillType.BirthDateMonth, "birthDateMonth"), TuplesKt.to(AutofillType.BirthDateYear, "birthDateYear"), TuplesKt.to(AutofillType.SmsOtpCode, "smsOTPCode"));

    public static final String getAndroidType(AutofillType autofillType) {
        String str = androidAutofillTypes.get(autofillType);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Unsupported autofill type");
    }
}
