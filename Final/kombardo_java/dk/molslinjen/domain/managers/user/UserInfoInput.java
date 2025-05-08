package dk.molslinjen.domain.managers.user;

import dk.molslinjen.core.extensions.LocaleExtensionsKt;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.account.user.UserContactDetails;
import dk.molslinjen.domain.model.account.user.UserInfo;
import dk.molslinjen.domain.model.account.user.UserPersonalDetails;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\b\u0018\u0000 62\u00020\u0001:\u00016B{\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u0013\b\u0016\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0012\u0010\u0016J\u0084\u0001\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u001aR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b#\u0010\u001aR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b-\u0010\u001aR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010.\u001a\u0004\b/\u00100R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b1\u0010\u001aR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b2\u0010\u001aR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u00103\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Ldk/molslinjen/domain/managers/user/UserInfoInput;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "firstName", "lastName", "Ldk/molslinjen/domain/model/account/Gender;", "gender", "Ljava/util/Locale;", "nationality", "Lorg/threeten/bp/LocalDate;", "birthdate", "postalCode", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "phoneNumber", "email", "password", BuildConfig.FLAVOR, "wasPrefilled", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/account/Gender;Ljava/util/Locale;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PhoneNumber;Ljava/lang/String;Ljava/lang/String;Z)V", "Ldk/molslinjen/domain/model/account/user/UserInfo;", "userInfo", "(Ldk/molslinjen/domain/model/account/user/UserInfo;)V", "copy", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/account/Gender;Ljava/util/Locale;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PhoneNumber;Ljava/lang/String;Ljava/lang/String;Z)Ldk/molslinjen/domain/managers/user/UserInfoInput;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFirstName", "getLastName", "Ldk/molslinjen/domain/model/account/Gender;", "getGender", "()Ldk/molslinjen/domain/model/account/Gender;", "Ljava/util/Locale;", "getNationality", "()Ljava/util/Locale;", "Lorg/threeten/bp/LocalDate;", "getBirthdate", "()Lorg/threeten/bp/LocalDate;", "getPostalCode", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "getPhoneNumber", "()Ldk/molslinjen/domain/model/shared/PhoneNumber;", "getEmail", "getPassword", "Z", "getWasPrefilled", "()Z", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class UserInfoInput {
    private static final UserInfoInput mock = new UserInfoInput("Mock", "Mocksen", Gender.Other, Locale.GERMAN, null, "8000", new PhoneNumber("+45", "12344321"), "mock@mocksen.dk", null, false);
    private final LocalDate birthdate;
    private final String email;
    private final String firstName;
    private final Gender gender;
    private final String lastName;
    private final Locale nationality;
    private final String password;
    private final PhoneNumber phoneNumber;
    private final String postalCode;
    private final boolean wasPrefilled;

    public UserInfoInput(String str, String str2, Gender gender, Locale locale, LocalDate localDate, String str3, PhoneNumber phoneNumber, String str4, String str5, boolean z5) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        this.firstName = str;
        this.lastName = str2;
        this.gender = gender;
        this.nationality = locale;
        this.birthdate = localDate;
        this.postalCode = str3;
        this.phoneNumber = phoneNumber;
        this.email = str4;
        this.password = str5;
        this.wasPrefilled = z5;
    }

    public final UserInfoInput copy(String firstName, String lastName, Gender gender, Locale nationality, LocalDate birthdate, String postalCode, PhoneNumber phoneNumber, String email, String password, boolean wasPrefilled) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        return new UserInfoInput(firstName, lastName, gender, nationality, birthdate, postalCode, phoneNumber, email, password, wasPrefilled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfoInput)) {
            return false;
        }
        UserInfoInput userInfoInput = (UserInfoInput) other;
        return Intrinsics.areEqual(this.firstName, userInfoInput.firstName) && Intrinsics.areEqual(this.lastName, userInfoInput.lastName) && this.gender == userInfoInput.gender && Intrinsics.areEqual(this.nationality, userInfoInput.nationality) && Intrinsics.areEqual(this.birthdate, userInfoInput.birthdate) && Intrinsics.areEqual(this.postalCode, userInfoInput.postalCode) && Intrinsics.areEqual(this.phoneNumber, userInfoInput.phoneNumber) && Intrinsics.areEqual(this.email, userInfoInput.email) && Intrinsics.areEqual(this.password, userInfoInput.password) && this.wasPrefilled == userInfoInput.wasPrefilled;
    }

    public final LocalDate getBirthdate() {
        return this.birthdate;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final Gender getGender() {
        return this.gender;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final Locale getNationality() {
        return this.nationality;
    }

    public final String getPassword() {
        return this.password;
    }

    public final PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public int hashCode() {
        String str = this.firstName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.lastName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Gender gender = this.gender;
        int hashCode3 = (hashCode2 + (gender == null ? 0 : gender.hashCode())) * 31;
        Locale locale = this.nationality;
        int hashCode4 = (hashCode3 + (locale == null ? 0 : locale.hashCode())) * 31;
        LocalDate localDate = this.birthdate;
        int hashCode5 = (hashCode4 + (localDate == null ? 0 : localDate.hashCode())) * 31;
        String str3 = this.postalCode;
        int hashCode6 = (((hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.phoneNumber.hashCode()) * 31;
        String str4 = this.email;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.password;
        return ((hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31) + Boolean.hashCode(this.wasPrefilled);
    }

    public String toString() {
        return "UserInfoInput(firstName=" + this.firstName + ", lastName=" + this.lastName + ", gender=" + this.gender + ", nationality=" + this.nationality + ", birthdate=" + this.birthdate + ", postalCode=" + this.postalCode + ", phoneNumber=" + this.phoneNumber + ", email=" + this.email + ", password=" + this.password + ", wasPrefilled=" + this.wasPrefilled + ")";
    }

    public /* synthetic */ UserInfoInput(String str, String str2, Gender gender, Locale locale, LocalDate localDate, String str3, PhoneNumber phoneNumber, String str4, String str5, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : str, (i5 & 2) != 0 ? null : str2, (i5 & 4) != 0 ? null : gender, (i5 & 8) != 0 ? null : locale, (i5 & 16) != 0 ? null : localDate, (i5 & 32) != 0 ? null : str3, (i5 & 64) != 0 ? new PhoneNumber((String) null, (String) null, 3, (DefaultConstructorMarker) null) : phoneNumber, (i5 & 128) != 0 ? null : str4, (i5 & 256) == 0 ? str5 : null, (i5 & 512) != 0 ? false : z5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UserInfoInput(UserInfo userInfo) {
        this(r3, r4, r5, r6, r7, r8, r9, r0, null, userInfo != null);
        UserContactDetails contactDetails;
        UserContactDetails contactDetails2;
        PhoneNumber phoneNumber;
        UserContactDetails contactDetails3;
        UserPersonalDetails personalDetails;
        UserPersonalDetails personalDetails2;
        UserPersonalDetails personalDetails3;
        UserPersonalDetails personalDetails4;
        UserPersonalDetails personalDetails5;
        String str = null;
        String firstName = (userInfo == null || (personalDetails5 = userInfo.getPersonalDetails()) == null) ? null : personalDetails5.getFirstName();
        String lastName = (userInfo == null || (personalDetails4 = userInfo.getPersonalDetails()) == null) ? null : personalDetails4.getLastName();
        Gender gender = (userInfo == null || (personalDetails3 = userInfo.getPersonalDetails()) == null) ? null : personalDetails3.getGender();
        String nullIfEmpty = StringExtensionsKt.nullIfEmpty((userInfo == null || (personalDetails2 = userInfo.getPersonalDetails()) == null) ? null : personalDetails2.getNationality());
        Locale locale = nullIfEmpty != null ? LocaleExtensionsKt.toLocale(nullIfEmpty) : null;
        LocalDate birthDate = (userInfo == null || (personalDetails = userInfo.getPersonalDetails()) == null) ? null : personalDetails.getBirthDate();
        String postalCode = (userInfo == null || (contactDetails3 = userInfo.getContactDetails()) == null) ? null : contactDetails3.getPostalCode();
        PhoneNumber phoneNumber2 = (userInfo == null || (contactDetails2 = userInfo.getContactDetails()) == null || (phoneNumber = contactDetails2.getPhoneNumber()) == null) ? new PhoneNumber((String) null, (String) null, 3, (DefaultConstructorMarker) null) : phoneNumber;
        if (userInfo != null && (contactDetails = userInfo.getContactDetails()) != null) {
            str = contactDetails.getEmail();
        }
    }
}
