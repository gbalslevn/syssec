package dk.molslinjen.api.services.account.response;

import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.services.account.passenger.response.GenderDTO;
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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0002=>BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fBu\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jk\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0011HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u001c\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u0016R\u001c\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u0016R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u0016¨\u0006?"}, d2 = {"Ldk/molslinjen/api/services/account/response/AccountUpdateInfoResponseDTO;", BuildConfig.FLAVOR, "email", BuildConfig.FLAVOR, "gender", "Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "firstName", "lastName", "birthDate", "Lorg/threeten/bp/LocalDate;", "nationality", "phoneNumberPrefix", "phoneNumber", "postalCode", "<init>", "(Ljava/lang/String;Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEmail", "()Ljava/lang/String;", "getGender", "()Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "getFirstName", "getLastName", "getBirthDate$annotations", "()V", "getBirthDate", "()Lorg/threeten/bp/LocalDate;", "getNationality", "getPhoneNumberPrefix$annotations", "getPhoneNumberPrefix", "getPhoneNumber$annotations", "getPhoneNumber", "getPostalCode$annotations", "getPostalCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class AccountUpdateInfoResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final LocalDate birthDate;
    private final String email;
    private final String firstName;
    private final GenderDTO gender;
    private final String lastName;
    private final String nationality;
    private final String phoneNumber;
    private final String phoneNumberPrefix;
    private final String postalCode;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/response/AccountUpdateInfoResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/response/AccountUpdateInfoResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<AccountUpdateInfoResponseDTO> serializer() {
            return AccountUpdateInfoResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ AccountUpdateInfoResponseDTO(int i5, String str, GenderDTO genderDTO, String str2, String str3, LocalDate localDate, String str4, String str5, String str6, String str7, SerializationConstructorMarker serializationConstructorMarker) {
        if (511 != (i5 & 511)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 511, AccountUpdateInfoResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.email = str;
        this.gender = genderDTO;
        this.firstName = str2;
        this.lastName = str3;
        this.birthDate = localDate;
        this.nationality = str4;
        this.phoneNumberPrefix = str5;
        this.phoneNumber = str6;
        this.postalCode = str7;
    }

    @Serializable(with = LocalDateWithTimeSerializer.class)
    public static /* synthetic */ void getBirthDate$annotations() {
    }

    public static /* synthetic */ void getPhoneNumber$annotations() {
    }

    public static /* synthetic */ void getPhoneNumberPrefix$annotations() {
    }

    public static /* synthetic */ void getPostalCode$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(AccountUpdateInfoResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.email);
        output.encodeNullableSerializableElement(serialDesc, 1, GenderDTO.Serializer.INSTANCE, self.gender);
        output.encodeStringElement(serialDesc, 2, self.firstName);
        output.encodeStringElement(serialDesc, 3, self.lastName);
        output.encodeNullableSerializableElement(serialDesc, 4, LocalDateWithTimeSerializer.INSTANCE, self.birthDate);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 5, stringSerializer, self.nationality);
        output.encodeStringElement(serialDesc, 6, self.phoneNumberPrefix);
        output.encodeStringElement(serialDesc, 7, self.phoneNumber);
        output.encodeNullableSerializableElement(serialDesc, 8, stringSerializer, self.postalCode);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component2, reason: from getter */
    public final GenderDTO getGender() {
        return this.gender;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLastName() {
        return this.lastName;
    }

    /* renamed from: component5, reason: from getter */
    public final LocalDate getBirthDate() {
        return this.birthDate;
    }

    /* renamed from: component6, reason: from getter */
    public final String getNationality() {
        return this.nationality;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPhoneNumberPrefix() {
        return this.phoneNumberPrefix;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component9, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    public final AccountUpdateInfoResponseDTO copy(String email, GenderDTO gender, String firstName, String lastName, LocalDate birthDate, String nationality, String phoneNumberPrefix, String phoneNumber, String postalCode) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(phoneNumberPrefix, "phoneNumberPrefix");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        return new AccountUpdateInfoResponseDTO(email, gender, firstName, lastName, birthDate, nationality, phoneNumberPrefix, phoneNumber, postalCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccountUpdateInfoResponseDTO)) {
            return false;
        }
        AccountUpdateInfoResponseDTO accountUpdateInfoResponseDTO = (AccountUpdateInfoResponseDTO) other;
        return Intrinsics.areEqual(this.email, accountUpdateInfoResponseDTO.email) && this.gender == accountUpdateInfoResponseDTO.gender && Intrinsics.areEqual(this.firstName, accountUpdateInfoResponseDTO.firstName) && Intrinsics.areEqual(this.lastName, accountUpdateInfoResponseDTO.lastName) && Intrinsics.areEqual(this.birthDate, accountUpdateInfoResponseDTO.birthDate) && Intrinsics.areEqual(this.nationality, accountUpdateInfoResponseDTO.nationality) && Intrinsics.areEqual(this.phoneNumberPrefix, accountUpdateInfoResponseDTO.phoneNumberPrefix) && Intrinsics.areEqual(this.phoneNumber, accountUpdateInfoResponseDTO.phoneNumber) && Intrinsics.areEqual(this.postalCode, accountUpdateInfoResponseDTO.postalCode);
    }

    public final LocalDate getBirthDate() {
        return this.birthDate;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final GenderDTO getGender() {
        return this.gender;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getNationality() {
        return this.nationality;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getPhoneNumberPrefix() {
        return this.phoneNumberPrefix;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public int hashCode() {
        int hashCode = this.email.hashCode() * 31;
        GenderDTO genderDTO = this.gender;
        int hashCode2 = (((((hashCode + (genderDTO == null ? 0 : genderDTO.hashCode())) * 31) + this.firstName.hashCode()) * 31) + this.lastName.hashCode()) * 31;
        LocalDate localDate = this.birthDate;
        int hashCode3 = (hashCode2 + (localDate == null ? 0 : localDate.hashCode())) * 31;
        String str = this.nationality;
        int hashCode4 = (((((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.phoneNumberPrefix.hashCode()) * 31) + this.phoneNumber.hashCode()) * 31;
        String str2 = this.postalCode;
        return hashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AccountUpdateInfoResponseDTO(email=" + this.email + ", gender=" + this.gender + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", birthDate=" + this.birthDate + ", nationality=" + this.nationality + ", phoneNumberPrefix=" + this.phoneNumberPrefix + ", phoneNumber=" + this.phoneNumber + ", postalCode=" + this.postalCode + ")";
    }

    public AccountUpdateInfoResponseDTO(String email, GenderDTO genderDTO, String firstName, String lastName, LocalDate localDate, String str, String phoneNumberPrefix, String phoneNumber, String str2) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(phoneNumberPrefix, "phoneNumberPrefix");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        this.email = email;
        this.gender = genderDTO;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = localDate;
        this.nationality = str;
        this.phoneNumberPrefix = phoneNumberPrefix;
        this.phoneNumber = phoneNumber;
        this.postalCode = str2;
    }
}
