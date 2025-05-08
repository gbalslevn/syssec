package dk.molslinjen.api.services.account.passenger.response;

import com.sdk.growthbook.utils.Constants;
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
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000256B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eB_\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0010HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010 ¨\u00067"}, d2 = {"Ldk/molslinjen/api/services/account/passenger/response/AccountPassengerDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "firstName", "lastName", "gender", "Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "nationality", "birthdate", "Lorg/threeten/bp/LocalDate;", "isCurrentUser", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Z)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;Ljava/lang/String;Lorg/threeten/bp/LocalDate;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getFirstName", "getLastName", "getGender", "()Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "getNationality", "getBirthdate$annotations", "getBirthdate", "()Lorg/threeten/bp/LocalDate;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class AccountPassengerDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final LocalDate birthdate;
    private final String firstName;
    private final GenderDTO gender;
    private final String id;
    private final boolean isCurrentUser;
    private final String lastName;
    private final String nationality;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/passenger/response/AccountPassengerDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/passenger/response/AccountPassengerDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<AccountPassengerDTO> serializer() {
            return AccountPassengerDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ AccountPassengerDTO(int i5, String str, String str2, String str3, GenderDTO genderDTO, String str4, LocalDate localDate, boolean z5, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i5 & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 127, AccountPassengerDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.firstName = str2;
        this.lastName = str3;
        this.gender = genderDTO;
        this.nationality = str4;
        this.birthdate = localDate;
        this.isCurrentUser = z5;
    }

    public static /* synthetic */ AccountPassengerDTO copy$default(AccountPassengerDTO accountPassengerDTO, String str, String str2, String str3, GenderDTO genderDTO, String str4, LocalDate localDate, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = accountPassengerDTO.id;
        }
        if ((i5 & 2) != 0) {
            str2 = accountPassengerDTO.firstName;
        }
        String str5 = str2;
        if ((i5 & 4) != 0) {
            str3 = accountPassengerDTO.lastName;
        }
        String str6 = str3;
        if ((i5 & 8) != 0) {
            genderDTO = accountPassengerDTO.gender;
        }
        GenderDTO genderDTO2 = genderDTO;
        if ((i5 & 16) != 0) {
            str4 = accountPassengerDTO.nationality;
        }
        String str7 = str4;
        if ((i5 & 32) != 0) {
            localDate = accountPassengerDTO.birthdate;
        }
        LocalDate localDate2 = localDate;
        if ((i5 & 64) != 0) {
            z5 = accountPassengerDTO.isCurrentUser;
        }
        return accountPassengerDTO.copy(str, str5, str6, genderDTO2, str7, localDate2, z5);
    }

    @Serializable(with = LocalDateWithTimeSerializer.class)
    public static /* synthetic */ void getBirthdate$annotations() {
    }

    public static /* synthetic */ void getId$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(AccountPassengerDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.firstName);
        output.encodeStringElement(serialDesc, 2, self.lastName);
        output.encodeSerializableElement(serialDesc, 3, GenderDTO.Serializer.INSTANCE, self.gender);
        output.encodeStringElement(serialDesc, 4, self.nationality);
        output.encodeSerializableElement(serialDesc, 5, LocalDateWithTimeSerializer.INSTANCE, self.birthdate);
        output.encodeBooleanElement(serialDesc, 6, self.isCurrentUser);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLastName() {
        return this.lastName;
    }

    /* renamed from: component4, reason: from getter */
    public final GenderDTO getGender() {
        return this.gender;
    }

    /* renamed from: component5, reason: from getter */
    public final String getNationality() {
        return this.nationality;
    }

    /* renamed from: component6, reason: from getter */
    public final LocalDate getBirthdate() {
        return this.birthdate;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsCurrentUser() {
        return this.isCurrentUser;
    }

    public final AccountPassengerDTO copy(String id, String firstName, String lastName, GenderDTO gender, String nationality, LocalDate birthdate, boolean isCurrentUser) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(nationality, "nationality");
        Intrinsics.checkNotNullParameter(birthdate, "birthdate");
        return new AccountPassengerDTO(id, firstName, lastName, gender, nationality, birthdate, isCurrentUser);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccountPassengerDTO)) {
            return false;
        }
        AccountPassengerDTO accountPassengerDTO = (AccountPassengerDTO) other;
        return Intrinsics.areEqual(this.id, accountPassengerDTO.id) && Intrinsics.areEqual(this.firstName, accountPassengerDTO.firstName) && Intrinsics.areEqual(this.lastName, accountPassengerDTO.lastName) && this.gender == accountPassengerDTO.gender && Intrinsics.areEqual(this.nationality, accountPassengerDTO.nationality) && Intrinsics.areEqual(this.birthdate, accountPassengerDTO.birthdate) && this.isCurrentUser == accountPassengerDTO.isCurrentUser;
    }

    public final LocalDate getBirthdate() {
        return this.birthdate;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final GenderDTO getGender() {
        return this.gender;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getNationality() {
        return this.nationality;
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.firstName.hashCode()) * 31) + this.lastName.hashCode()) * 31) + this.gender.hashCode()) * 31) + this.nationality.hashCode()) * 31) + this.birthdate.hashCode()) * 31) + Boolean.hashCode(this.isCurrentUser);
    }

    public final boolean isCurrentUser() {
        return this.isCurrentUser;
    }

    public String toString() {
        return "AccountPassengerDTO(id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", gender=" + this.gender + ", nationality=" + this.nationality + ", birthdate=" + this.birthdate + ", isCurrentUser=" + this.isCurrentUser + ")";
    }

    public AccountPassengerDTO(String id, String firstName, String lastName, GenderDTO gender, String nationality, LocalDate birthdate, boolean z5) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(nationality, "nationality");
        Intrinsics.checkNotNullParameter(birthdate, "birthdate");
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.nationality = nationality;
        this.birthdate = birthdate;
        this.isCurrentUser = z5;
    }
}
