package dk.molslinjen.api.services.account.passenger.request;

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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fBW\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003JE\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u000eHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u00063"}, d2 = {"Ldk/molslinjen/api/services/account/passenger/request/UpdatePassengerRequestParameter;", BuildConfig.FLAVOR, "passengerId", BuildConfig.FLAVOR, "firstName", "lastName", "gender", "Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "birthdate", "Lorg/threeten/bp/LocalDate;", "nationality", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;Lorg/threeten/bp/LocalDate;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPassengerId", "()Ljava/lang/String;", "getFirstName", "getLastName", "getGender", "()Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "getBirthdate$annotations", "()V", "getBirthdate", "()Lorg/threeten/bp/LocalDate;", "getNationality", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class UpdatePassengerRequestParameter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final LocalDate birthdate;
    private final String firstName;
    private final GenderDTO gender;
    private final String lastName;
    private final String nationality;
    private final String passengerId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/passenger/request/UpdatePassengerRequestParameter$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/passenger/request/UpdatePassengerRequestParameter;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<UpdatePassengerRequestParameter> serializer() {
            return UpdatePassengerRequestParameter$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ UpdatePassengerRequestParameter(int i5, String str, String str2, String str3, GenderDTO genderDTO, LocalDate localDate, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i5 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 63, UpdatePassengerRequestParameter$$serializer.INSTANCE.getDescriptor());
        }
        this.passengerId = str;
        this.firstName = str2;
        this.lastName = str3;
        this.gender = genderDTO;
        this.birthdate = localDate;
        this.nationality = str4;
    }

    public static /* synthetic */ UpdatePassengerRequestParameter copy$default(UpdatePassengerRequestParameter updatePassengerRequestParameter, String str, String str2, String str3, GenderDTO genderDTO, LocalDate localDate, String str4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = updatePassengerRequestParameter.passengerId;
        }
        if ((i5 & 2) != 0) {
            str2 = updatePassengerRequestParameter.firstName;
        }
        String str5 = str2;
        if ((i5 & 4) != 0) {
            str3 = updatePassengerRequestParameter.lastName;
        }
        String str6 = str3;
        if ((i5 & 8) != 0) {
            genderDTO = updatePassengerRequestParameter.gender;
        }
        GenderDTO genderDTO2 = genderDTO;
        if ((i5 & 16) != 0) {
            localDate = updatePassengerRequestParameter.birthdate;
        }
        LocalDate localDate2 = localDate;
        if ((i5 & 32) != 0) {
            str4 = updatePassengerRequestParameter.nationality;
        }
        return updatePassengerRequestParameter.copy(str, str5, str6, genderDTO2, localDate2, str4);
    }

    @Serializable(with = LocalDateWithTimeSerializer.class)
    public static /* synthetic */ void getBirthdate$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(UpdatePassengerRequestParameter self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.passengerId);
        output.encodeStringElement(serialDesc, 1, self.firstName);
        output.encodeStringElement(serialDesc, 2, self.lastName);
        output.encodeSerializableElement(serialDesc, 3, GenderDTO.Serializer.INSTANCE, self.gender);
        output.encodeSerializableElement(serialDesc, 4, LocalDateWithTimeSerializer.INSTANCE, self.birthdate);
        output.encodeStringElement(serialDesc, 5, self.nationality);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPassengerId() {
        return this.passengerId;
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
    public final LocalDate getBirthdate() {
        return this.birthdate;
    }

    /* renamed from: component6, reason: from getter */
    public final String getNationality() {
        return this.nationality;
    }

    public final UpdatePassengerRequestParameter copy(String passengerId, String firstName, String lastName, GenderDTO gender, LocalDate birthdate, String nationality) {
        Intrinsics.checkNotNullParameter(passengerId, "passengerId");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(birthdate, "birthdate");
        Intrinsics.checkNotNullParameter(nationality, "nationality");
        return new UpdatePassengerRequestParameter(passengerId, firstName, lastName, gender, birthdate, nationality);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdatePassengerRequestParameter)) {
            return false;
        }
        UpdatePassengerRequestParameter updatePassengerRequestParameter = (UpdatePassengerRequestParameter) other;
        return Intrinsics.areEqual(this.passengerId, updatePassengerRequestParameter.passengerId) && Intrinsics.areEqual(this.firstName, updatePassengerRequestParameter.firstName) && Intrinsics.areEqual(this.lastName, updatePassengerRequestParameter.lastName) && this.gender == updatePassengerRequestParameter.gender && Intrinsics.areEqual(this.birthdate, updatePassengerRequestParameter.birthdate) && Intrinsics.areEqual(this.nationality, updatePassengerRequestParameter.nationality);
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

    public final String getLastName() {
        return this.lastName;
    }

    public final String getNationality() {
        return this.nationality;
    }

    public final String getPassengerId() {
        return this.passengerId;
    }

    public int hashCode() {
        return (((((((((this.passengerId.hashCode() * 31) + this.firstName.hashCode()) * 31) + this.lastName.hashCode()) * 31) + this.gender.hashCode()) * 31) + this.birthdate.hashCode()) * 31) + this.nationality.hashCode();
    }

    public String toString() {
        return "UpdatePassengerRequestParameter(passengerId=" + this.passengerId + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", gender=" + this.gender + ", birthdate=" + this.birthdate + ", nationality=" + this.nationality + ")";
    }

    public UpdatePassengerRequestParameter(String passengerId, String firstName, String lastName, GenderDTO gender, LocalDate birthdate, String nationality) {
        Intrinsics.checkNotNullParameter(passengerId, "passengerId");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(birthdate, "birthdate");
        Intrinsics.checkNotNullParameter(nationality, "nationality");
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.nationality = nationality;
    }
}
