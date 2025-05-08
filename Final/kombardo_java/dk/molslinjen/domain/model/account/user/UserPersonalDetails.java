package dk.molslinjen.domain.model.account.user;

import dk.molslinjen.api.helpers.serializers.LocalDateSerializer;
import dk.molslinjen.domain.model.account.Gender;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000256B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003JA\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010)\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\rHÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u001d\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u00067"}, d2 = {"Ldk/molslinjen/domain/model/account/user/UserPersonalDetails;", BuildConfig.FLAVOR, "gender", "Ldk/molslinjen/domain/model/account/Gender;", "firstName", BuildConfig.FLAVOR, "lastName", "birthDate", "Lorg/threeten/bp/LocalDate;", "nationality", "<init>", "(Ldk/molslinjen/domain/model/account/Gender;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/domain/model/account/Gender;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGender", "()Ldk/molslinjen/domain/model/account/Gender;", "getFirstName", "()Ljava/lang/String;", "getLastName", "getBirthDate$annotations", "()V", "getBirthDate", "()Lorg/threeten/bp/LocalDate;", "getNationality", "initials", "getInitials", "fullName", "getFullName", "hasPartialData", BuildConfig.FLAVOR, "getHasPartialData", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "$serializer", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class UserPersonalDetails {
    private final LocalDate birthDate;
    private final String firstName;
    private final Gender gender;
    private final String lastName;
    private final String nationality;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.account.Gender", Gender.values()), null, null, null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/account/user/UserPersonalDetails$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/domain/model/account/user/UserPersonalDetails;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<UserPersonalDetails> serializer() {
            return UserPersonalDetails$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ UserPersonalDetails(int i5, Gender gender, String str, String str2, LocalDate localDate, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i5 & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 31, UserPersonalDetails$$serializer.INSTANCE.getDescriptor());
        }
        this.gender = gender;
        this.firstName = str;
        this.lastName = str2;
        this.birthDate = localDate;
        this.nationality = str3;
    }

    public static /* synthetic */ UserPersonalDetails copy$default(UserPersonalDetails userPersonalDetails, Gender gender, String str, String str2, LocalDate localDate, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            gender = userPersonalDetails.gender;
        }
        if ((i5 & 2) != 0) {
            str = userPersonalDetails.firstName;
        }
        String str4 = str;
        if ((i5 & 4) != 0) {
            str2 = userPersonalDetails.lastName;
        }
        String str5 = str2;
        if ((i5 & 8) != 0) {
            localDate = userPersonalDetails.birthDate;
        }
        LocalDate localDate2 = localDate;
        if ((i5 & 16) != 0) {
            str3 = userPersonalDetails.nationality;
        }
        return userPersonalDetails.copy(gender, str4, str5, localDate2, str3);
    }

    @Serializable(with = LocalDateSerializer.class)
    public static /* synthetic */ void getBirthDate$annotations() {
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(UserPersonalDetails self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, $childSerializers[0], self.gender);
        output.encodeStringElement(serialDesc, 1, self.firstName);
        output.encodeStringElement(serialDesc, 2, self.lastName);
        output.encodeNullableSerializableElement(serialDesc, 3, LocalDateSerializer.INSTANCE, self.birthDate);
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.nationality);
    }

    /* renamed from: component1, reason: from getter */
    public final Gender getGender() {
        return this.gender;
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
    public final LocalDate getBirthDate() {
        return this.birthDate;
    }

    /* renamed from: component5, reason: from getter */
    public final String getNationality() {
        return this.nationality;
    }

    public final UserPersonalDetails copy(Gender gender, String firstName, String lastName, LocalDate birthDate, String nationality) {
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        return new UserPersonalDetails(gender, firstName, lastName, birthDate, nationality);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserPersonalDetails)) {
            return false;
        }
        UserPersonalDetails userPersonalDetails = (UserPersonalDetails) other;
        return this.gender == userPersonalDetails.gender && Intrinsics.areEqual(this.firstName, userPersonalDetails.firstName) && Intrinsics.areEqual(this.lastName, userPersonalDetails.lastName) && Intrinsics.areEqual(this.birthDate, userPersonalDetails.birthDate) && Intrinsics.areEqual(this.nationality, userPersonalDetails.nationality);
    }

    public final LocalDate getBirthDate() {
        return this.birthDate;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public final Gender getGender() {
        return this.gender;
    }

    public final boolean getHasPartialData() {
        return this.gender == null || this.birthDate == null || this.nationality == null;
    }

    public final String getInitials() {
        Character orNull = StringsKt.getOrNull(this.firstName, 0);
        Character orNull2 = StringsKt.getOrNull(this.lastName, 0);
        if (orNull == null || orNull2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(orNull);
        sb.append(orNull2);
        return sb.toString();
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getNationality() {
        return this.nationality;
    }

    public int hashCode() {
        Gender gender = this.gender;
        int hashCode = (((((gender == null ? 0 : gender.hashCode()) * 31) + this.firstName.hashCode()) * 31) + this.lastName.hashCode()) * 31;
        LocalDate localDate = this.birthDate;
        int hashCode2 = (hashCode + (localDate == null ? 0 : localDate.hashCode())) * 31;
        String str = this.nationality;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "UserPersonalDetails(gender=" + this.gender + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", birthDate=" + this.birthDate + ", nationality=" + this.nationality + ")";
    }

    public UserPersonalDetails(Gender gender, String firstName, String lastName, LocalDate localDate, String str) {
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = localDate;
        this.nationality = str;
    }
}
