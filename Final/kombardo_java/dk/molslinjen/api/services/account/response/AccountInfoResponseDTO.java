package dk.molslinjen.api.services.account.response;

import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.services.account.passenger.response.GenderDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0002FGBm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u008f\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0012\u0010\u0018J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\u0085\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0015HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001J%\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0001¢\u0006\u0002\bER\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u001c\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010!\u001a\u0004\b&\u0010\u001aR\u001c\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010!\u001a\u0004\b(\u0010\u001aR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010!\u001a\u0004\b*\u0010\u001aR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006H"}, d2 = {"Ldk/molslinjen/api/services/account/response/AccountInfoResponseDTO;", BuildConfig.FLAVOR, "userId", BuildConfig.FLAVOR, "email", "gender", "Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "firstName", "lastName", "birthDate", "Lorg/threeten/bp/LocalDate;", "nationality", "phoneNumberPrefix", "phoneNumber", "postalCode", "companies", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/account/response/AccountCompanyDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUserId", "()Ljava/lang/String;", "getEmail", "getGender", "()Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "getFirstName", "getLastName", "getBirthDate$annotations", "()V", "getBirthDate", "()Lorg/threeten/bp/LocalDate;", "getNationality", "getPhoneNumberPrefix$annotations", "getPhoneNumberPrefix", "getPhoneNumber$annotations", "getPhoneNumber", "getPostalCode$annotations", "getPostalCode", "getCompanies", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class AccountInfoResponseDTO {
    private final LocalDate birthDate;
    private final List<AccountCompanyDTO> companies;
    private final String email;
    private final String firstName;
    private final GenderDTO gender;
    private final String lastName;
    private final String nationality;
    private final String phoneNumber;
    private final String phoneNumberPrefix;
    private final String postalCode;
    private final String userId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(AccountCompanyDTO$$serializer.INSTANCE)};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/response/AccountInfoResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/response/AccountInfoResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<AccountInfoResponseDTO> serializer() {
            return AccountInfoResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ AccountInfoResponseDTO(int i5, String str, String str2, GenderDTO genderDTO, String str3, String str4, LocalDate localDate, String str5, String str6, String str7, String str8, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (2047 != (i5 & 2047)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 2047, AccountInfoResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.userId = str;
        this.email = str2;
        this.gender = genderDTO;
        this.firstName = str3;
        this.lastName = str4;
        this.birthDate = localDate;
        this.nationality = str5;
        this.phoneNumberPrefix = str6;
        this.phoneNumber = str7;
        this.postalCode = str8;
        this.companies = list;
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

    public static final /* synthetic */ void write$Self$api_kombardoProd(AccountInfoResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.userId);
        output.encodeStringElement(serialDesc, 1, self.email);
        output.encodeNullableSerializableElement(serialDesc, 2, GenderDTO.Serializer.INSTANCE, self.gender);
        output.encodeStringElement(serialDesc, 3, self.firstName);
        output.encodeStringElement(serialDesc, 4, self.lastName);
        output.encodeNullableSerializableElement(serialDesc, 5, LocalDateWithTimeSerializer.INSTANCE, self.birthDate);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 6, stringSerializer, self.nationality);
        output.encodeStringElement(serialDesc, 7, self.phoneNumberPrefix);
        output.encodeStringElement(serialDesc, 8, self.phoneNumber);
        output.encodeNullableSerializableElement(serialDesc, 9, stringSerializer, self.postalCode);
        output.encodeSerializableElement(serialDesc, 10, kSerializerArr[10], self.companies);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    public final List<AccountCompanyDTO> component11() {
        return this.companies;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component3, reason: from getter */
    public final GenderDTO getGender() {
        return this.gender;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLastName() {
        return this.lastName;
    }

    /* renamed from: component6, reason: from getter */
    public final LocalDate getBirthDate() {
        return this.birthDate;
    }

    /* renamed from: component7, reason: from getter */
    public final String getNationality() {
        return this.nationality;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPhoneNumberPrefix() {
        return this.phoneNumberPrefix;
    }

    /* renamed from: component9, reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final AccountInfoResponseDTO copy(String userId, String email, GenderDTO gender, String firstName, String lastName, LocalDate birthDate, String nationality, String phoneNumberPrefix, String phoneNumber, String postalCode, List<AccountCompanyDTO> companies) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(phoneNumberPrefix, "phoneNumberPrefix");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(companies, "companies");
        return new AccountInfoResponseDTO(userId, email, gender, firstName, lastName, birthDate, nationality, phoneNumberPrefix, phoneNumber, postalCode, companies);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccountInfoResponseDTO)) {
            return false;
        }
        AccountInfoResponseDTO accountInfoResponseDTO = (AccountInfoResponseDTO) other;
        return Intrinsics.areEqual(this.userId, accountInfoResponseDTO.userId) && Intrinsics.areEqual(this.email, accountInfoResponseDTO.email) && this.gender == accountInfoResponseDTO.gender && Intrinsics.areEqual(this.firstName, accountInfoResponseDTO.firstName) && Intrinsics.areEqual(this.lastName, accountInfoResponseDTO.lastName) && Intrinsics.areEqual(this.birthDate, accountInfoResponseDTO.birthDate) && Intrinsics.areEqual(this.nationality, accountInfoResponseDTO.nationality) && Intrinsics.areEqual(this.phoneNumberPrefix, accountInfoResponseDTO.phoneNumberPrefix) && Intrinsics.areEqual(this.phoneNumber, accountInfoResponseDTO.phoneNumber) && Intrinsics.areEqual(this.postalCode, accountInfoResponseDTO.postalCode) && Intrinsics.areEqual(this.companies, accountInfoResponseDTO.companies);
    }

    public final LocalDate getBirthDate() {
        return this.birthDate;
    }

    public final List<AccountCompanyDTO> getCompanies() {
        return this.companies;
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

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int hashCode = ((this.userId.hashCode() * 31) + this.email.hashCode()) * 31;
        GenderDTO genderDTO = this.gender;
        int hashCode2 = (((((hashCode + (genderDTO == null ? 0 : genderDTO.hashCode())) * 31) + this.firstName.hashCode()) * 31) + this.lastName.hashCode()) * 31;
        LocalDate localDate = this.birthDate;
        int hashCode3 = (hashCode2 + (localDate == null ? 0 : localDate.hashCode())) * 31;
        String str = this.nationality;
        int hashCode4 = (((((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.phoneNumberPrefix.hashCode()) * 31) + this.phoneNumber.hashCode()) * 31;
        String str2 = this.postalCode;
        return ((hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.companies.hashCode();
    }

    public String toString() {
        return "AccountInfoResponseDTO(userId=" + this.userId + ", email=" + this.email + ", gender=" + this.gender + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", birthDate=" + this.birthDate + ", nationality=" + this.nationality + ", phoneNumberPrefix=" + this.phoneNumberPrefix + ", phoneNumber=" + this.phoneNumber + ", postalCode=" + this.postalCode + ", companies=" + this.companies + ")";
    }

    public AccountInfoResponseDTO(String userId, String email, GenderDTO genderDTO, String firstName, String lastName, LocalDate localDate, String str, String phoneNumberPrefix, String phoneNumber, String str2, List<AccountCompanyDTO> companies) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(phoneNumberPrefix, "phoneNumberPrefix");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(companies, "companies");
        this.userId = userId;
        this.email = email;
        this.gender = genderDTO;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = localDate;
        this.nationality = str;
        this.phoneNumberPrefix = phoneNumberPrefix;
        this.phoneNumber = phoneNumber;
        this.postalCode = str2;
        this.companies = companies;
    }
}
