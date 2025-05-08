package dk.molslinjen.api.services.account.request;

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

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0002>?B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010B\u007f\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0012HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001J%\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0001¢\u0006\u0002\b=R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010\u0017¨\u0006@"}, d2 = {"Ldk/molslinjen/api/services/account/request/CreateAccountRequestParameters;", BuildConfig.FLAVOR, "email", BuildConfig.FLAVOR, "password", "gender", "Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "firstName", "lastName", "birthday", "Lorg/threeten/bp/LocalDate;", "nationality", "mobileNumberPrefix", "mobileNumber", "postalCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEmail", "()Ljava/lang/String;", "getPassword", "getGender", "()Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "getFirstName", "getLastName", "getBirthday$annotations", "()V", "getBirthday", "()Lorg/threeten/bp/LocalDate;", "getNationality", "getMobileNumberPrefix", "getMobileNumber", "getPostalCode$annotations", "getPostalCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class CreateAccountRequestParameters {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final LocalDate birthday;
    private final String email;
    private final String firstName;
    private final GenderDTO gender;
    private final String lastName;
    private final String mobileNumber;
    private final String mobileNumberPrefix;
    private final String nationality;
    private final String password;
    private final String postalCode;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/request/CreateAccountRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/request/CreateAccountRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<CreateAccountRequestParameters> serializer() {
            return CreateAccountRequestParameters$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ CreateAccountRequestParameters(int i5, String str, String str2, GenderDTO genderDTO, String str3, String str4, LocalDate localDate, String str5, String str6, String str7, String str8, SerializationConstructorMarker serializationConstructorMarker) {
        if (1023 != (i5 & 1023)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 1023, CreateAccountRequestParameters$$serializer.INSTANCE.getDescriptor());
        }
        this.email = str;
        this.password = str2;
        this.gender = genderDTO;
        this.firstName = str3;
        this.lastName = str4;
        this.birthday = localDate;
        this.nationality = str5;
        this.mobileNumberPrefix = str6;
        this.mobileNumber = str7;
        this.postalCode = str8;
    }

    @Serializable(with = LocalDateWithTimeSerializer.class)
    public static /* synthetic */ void getBirthday$annotations() {
    }

    public static /* synthetic */ void getPostalCode$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(CreateAccountRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.email);
        output.encodeStringElement(serialDesc, 1, self.password);
        output.encodeNullableSerializableElement(serialDesc, 2, GenderDTO.Serializer.INSTANCE, self.gender);
        output.encodeStringElement(serialDesc, 3, self.firstName);
        output.encodeStringElement(serialDesc, 4, self.lastName);
        output.encodeNullableSerializableElement(serialDesc, 5, LocalDateWithTimeSerializer.INSTANCE, self.birthday);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 6, stringSerializer, self.nationality);
        output.encodeStringElement(serialDesc, 7, self.mobileNumberPrefix);
        output.encodeStringElement(serialDesc, 8, self.mobileNumber);
        output.encodeNullableSerializableElement(serialDesc, 9, stringSerializer, self.postalCode);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component10, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPassword() {
        return this.password;
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
    public final LocalDate getBirthday() {
        return this.birthday;
    }

    /* renamed from: component7, reason: from getter */
    public final String getNationality() {
        return this.nationality;
    }

    /* renamed from: component8, reason: from getter */
    public final String getMobileNumberPrefix() {
        return this.mobileNumberPrefix;
    }

    /* renamed from: component9, reason: from getter */
    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    public final CreateAccountRequestParameters copy(String email, String password, GenderDTO gender, String firstName, String lastName, LocalDate birthday, String nationality, String mobileNumberPrefix, String mobileNumber, String postalCode) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(mobileNumberPrefix, "mobileNumberPrefix");
        Intrinsics.checkNotNullParameter(mobileNumber, "mobileNumber");
        return new CreateAccountRequestParameters(email, password, gender, firstName, lastName, birthday, nationality, mobileNumberPrefix, mobileNumber, postalCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateAccountRequestParameters)) {
            return false;
        }
        CreateAccountRequestParameters createAccountRequestParameters = (CreateAccountRequestParameters) other;
        return Intrinsics.areEqual(this.email, createAccountRequestParameters.email) && Intrinsics.areEqual(this.password, createAccountRequestParameters.password) && this.gender == createAccountRequestParameters.gender && Intrinsics.areEqual(this.firstName, createAccountRequestParameters.firstName) && Intrinsics.areEqual(this.lastName, createAccountRequestParameters.lastName) && Intrinsics.areEqual(this.birthday, createAccountRequestParameters.birthday) && Intrinsics.areEqual(this.nationality, createAccountRequestParameters.nationality) && Intrinsics.areEqual(this.mobileNumberPrefix, createAccountRequestParameters.mobileNumberPrefix) && Intrinsics.areEqual(this.mobileNumber, createAccountRequestParameters.mobileNumber) && Intrinsics.areEqual(this.postalCode, createAccountRequestParameters.postalCode);
    }

    public final LocalDate getBirthday() {
        return this.birthday;
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

    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    public final String getMobileNumberPrefix() {
        return this.mobileNumberPrefix;
    }

    public final String getNationality() {
        return this.nationality;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public int hashCode() {
        int hashCode = ((this.email.hashCode() * 31) + this.password.hashCode()) * 31;
        GenderDTO genderDTO = this.gender;
        int hashCode2 = (((((hashCode + (genderDTO == null ? 0 : genderDTO.hashCode())) * 31) + this.firstName.hashCode()) * 31) + this.lastName.hashCode()) * 31;
        LocalDate localDate = this.birthday;
        int hashCode3 = (hashCode2 + (localDate == null ? 0 : localDate.hashCode())) * 31;
        String str = this.nationality;
        int hashCode4 = (((((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.mobileNumberPrefix.hashCode()) * 31) + this.mobileNumber.hashCode()) * 31;
        String str2 = this.postalCode;
        return hashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "CreateAccountRequestParameters(email=" + this.email + ", password=" + this.password + ", gender=" + this.gender + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", birthday=" + this.birthday + ", nationality=" + this.nationality + ", mobileNumberPrefix=" + this.mobileNumberPrefix + ", mobileNumber=" + this.mobileNumber + ", postalCode=" + this.postalCode + ")";
    }

    public CreateAccountRequestParameters(String email, String password, GenderDTO genderDTO, String firstName, String lastName, LocalDate localDate, String str, String mobileNumberPrefix, String mobileNumber, String str2) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(mobileNumberPrefix, "mobileNumberPrefix");
        Intrinsics.checkNotNullParameter(mobileNumber, "mobileNumber");
        this.email = email;
        this.password = password;
        this.gender = genderDTO;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = localDate;
        this.nationality = str;
        this.mobileNumberPrefix = mobileNumberPrefix;
        this.mobileNumber = mobileNumber;
        this.postalCode = str2;
    }
}
