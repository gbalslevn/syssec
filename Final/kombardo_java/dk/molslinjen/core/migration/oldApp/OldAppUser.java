package dk.molslinjen.core.migration.oldApp;

import dk.molslinjen.domain.managers.user.UserInfoInput;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0087\b\u0018\u0000 E2\u00020\u0001:\u0002FEBµ\u0001\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0010\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010%\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0001¢\u0006\u0004\b#\u0010$J\r\u0010'\u001a\u00020&¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010/\u001a\u00020.2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b/\u00100R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b2\u0010*R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00103\u001a\u0004\b4\u00105R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u00101\u001a\u0004\b6\u0010*R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u00101\u001a\u0004\b7\u0010*R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00108\u001a\u0004\b9\u0010:R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u00101\u001a\u0004\b;\u0010*R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u00101\u001a\u0004\b<\u0010*R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u00101\u001a\u0004\b=\u0010*R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u00101\u001a\u0004\b>\u0010*R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010?\u001a\u0004\b@\u0010AR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00108\u0006¢\u0006\f\n\u0004\b\u0014\u0010?\u001a\u0004\bB\u0010AR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00108\u0006¢\u0006\f\n\u0004\b\u0016\u0010?\u001a\u0004\bC\u0010AR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00108\u0006¢\u0006\f\n\u0004\b\u0018\u0010?\u001a\u0004\bD\u0010A¨\u0006G"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppUser;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "seen0", BuildConfig.FLAVOR, "email", "Ldk/molslinjen/core/migration/oldApp/OldAppGender;", "gender", "firstName", "lastName", "Ldk/molslinjen/core/migration/oldApp/OldAppLocalDate;", "birthDate", "nationality", "phoneNumber", "phoneNumberCode", "postalCode", BuildConfig.FLAVOR, "Ldk/molslinjen/core/migration/oldApp/OldAppCreditCard;", "creditCards", "Ldk/molslinjen/core/migration/oldApp/OldAppPassenger;", "passengers", "Ldk/molslinjen/core/migration/oldApp/OldAppAgreement;", "agreements", "Ldk/molslinjen/core/migration/oldApp/OldAppBooking;", "activeBookings", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ldk/molslinjen/core/migration/oldApp/OldAppGender;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/core/migration/oldApp/OldAppLocalDate;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$app_kombardoProd", "(Ldk/molslinjen/core/migration/oldApp/OldAppUser;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ldk/molslinjen/domain/managers/user/UserInfoInput;", "toUserInput", "()Ldk/molslinjen/domain/managers/user/UserInfoInput;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEmail", "Ldk/molslinjen/core/migration/oldApp/OldAppGender;", "getGender", "()Ldk/molslinjen/core/migration/oldApp/OldAppGender;", "getFirstName", "getLastName", "Ldk/molslinjen/core/migration/oldApp/OldAppLocalDate;", "getBirthDate", "()Ldk/molslinjen/core/migration/oldApp/OldAppLocalDate;", "getNationality", "getPhoneNumber", "getPhoneNumberCode", "getPostalCode", "Ljava/util/List;", "getCreditCards", "()Ljava/util/List;", "getPassengers", "getAgreements", "getActiveBookings", "Companion", "$serializer", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class OldAppUser {
    private final List<OldAppBooking> activeBookings;
    private final List<OldAppAgreement> agreements;
    private final OldAppLocalDate birthDate;
    private final List<OldAppCreditCard> creditCards;
    private final String email;
    private final String firstName;
    private final OldAppGender gender;
    private final String lastName;
    private final String nationality;
    private final List<OldAppPassenger> passengers;
    private final String phoneNumber;
    private final String phoneNumberCode;
    private final String postalCode;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.core.migration.oldApp.OldAppGender", OldAppGender.values()), null, null, null, null, null, null, null, new ArrayListSerializer(OldAppCreditCard$$serializer.INSTANCE), new ArrayListSerializer(OldAppPassenger$$serializer.INSTANCE), new ArrayListSerializer(OldAppAgreement$$serializer.INSTANCE), new ArrayListSerializer(OldAppBooking$$serializer.INSTANCE)};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppUser$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/core/migration/oldApp/OldAppUser;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<OldAppUser> serializer() {
            return OldAppUser$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ OldAppUser(int i5, String str, OldAppGender oldAppGender, String str2, String str3, OldAppLocalDate oldAppLocalDate, String str4, String str5, String str6, String str7, List list, List list2, List list3, List list4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i5 & 1) == 0) {
            this.email = null;
        } else {
            this.email = str;
        }
        if ((i5 & 2) == 0) {
            this.gender = null;
        } else {
            this.gender = oldAppGender;
        }
        if ((i5 & 4) == 0) {
            this.firstName = null;
        } else {
            this.firstName = str2;
        }
        if ((i5 & 8) == 0) {
            this.lastName = null;
        } else {
            this.lastName = str3;
        }
        if ((i5 & 16) == 0) {
            this.birthDate = null;
        } else {
            this.birthDate = oldAppLocalDate;
        }
        if ((i5 & 32) == 0) {
            this.nationality = null;
        } else {
            this.nationality = str4;
        }
        if ((i5 & 64) == 0) {
            this.phoneNumber = null;
        } else {
            this.phoneNumber = str5;
        }
        if ((i5 & 128) == 0) {
            this.phoneNumberCode = null;
        } else {
            this.phoneNumberCode = str6;
        }
        if ((i5 & 256) == 0) {
            this.postalCode = null;
        } else {
            this.postalCode = str7;
        }
        this.creditCards = (i5 & 512) == 0 ? CollectionsKt.emptyList() : list;
        this.passengers = (i5 & 1024) == 0 ? CollectionsKt.emptyList() : list2;
        this.agreements = (i5 & 2048) == 0 ? CollectionsKt.emptyList() : list3;
        this.activeBookings = (i5 & 4096) == 0 ? CollectionsKt.emptyList() : list4;
    }

    public static final /* synthetic */ void write$Self$app_kombardoProd(OldAppUser self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.email != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.email);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.gender != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.gender);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.firstName != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.firstName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.lastName != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.lastName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.birthDate != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, OldAppLocalDate$$serializer.INSTANCE, self.birthDate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.nationality != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.nationality);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.phoneNumber != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.phoneNumber);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.phoneNumberCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.phoneNumberCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.postalCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.postalCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.creditCards, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 9, kSerializerArr[9], self.creditCards);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || !Intrinsics.areEqual(self.passengers, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 10, kSerializerArr[10], self.passengers);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || !Intrinsics.areEqual(self.agreements, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 11, kSerializerArr[11], self.agreements);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 12) && Intrinsics.areEqual(self.activeBookings, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 12, kSerializerArr[12], self.activeBookings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OldAppUser)) {
            return false;
        }
        OldAppUser oldAppUser = (OldAppUser) other;
        return Intrinsics.areEqual(this.email, oldAppUser.email) && this.gender == oldAppUser.gender && Intrinsics.areEqual(this.firstName, oldAppUser.firstName) && Intrinsics.areEqual(this.lastName, oldAppUser.lastName) && Intrinsics.areEqual(this.birthDate, oldAppUser.birthDate) && Intrinsics.areEqual(this.nationality, oldAppUser.nationality) && Intrinsics.areEqual(this.phoneNumber, oldAppUser.phoneNumber) && Intrinsics.areEqual(this.phoneNumberCode, oldAppUser.phoneNumberCode) && Intrinsics.areEqual(this.postalCode, oldAppUser.postalCode) && Intrinsics.areEqual(this.creditCards, oldAppUser.creditCards) && Intrinsics.areEqual(this.passengers, oldAppUser.passengers) && Intrinsics.areEqual(this.agreements, oldAppUser.agreements) && Intrinsics.areEqual(this.activeBookings, oldAppUser.activeBookings);
    }

    public final List<OldAppBooking> getActiveBookings() {
        return this.activeBookings;
    }

    public final List<OldAppAgreement> getAgreements() {
        return this.agreements;
    }

    public final List<OldAppCreditCard> getCreditCards() {
        return this.creditCards;
    }

    public final List<OldAppPassenger> getPassengers() {
        return this.passengers;
    }

    public int hashCode() {
        String str = this.email;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        OldAppGender oldAppGender = this.gender;
        int hashCode2 = (hashCode + (oldAppGender == null ? 0 : oldAppGender.hashCode())) * 31;
        String str2 = this.firstName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.lastName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        OldAppLocalDate oldAppLocalDate = this.birthDate;
        int hashCode5 = (hashCode4 + (oldAppLocalDate == null ? 0 : oldAppLocalDate.hashCode())) * 31;
        String str4 = this.nationality;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.phoneNumber;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.phoneNumberCode;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.postalCode;
        return ((((((((hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.creditCards.hashCode()) * 31) + this.passengers.hashCode()) * 31) + this.agreements.hashCode()) * 31) + this.activeBookings.hashCode();
    }

    public String toString() {
        return "OldAppUser(email=" + this.email + ", gender=" + this.gender + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", birthDate=" + this.birthDate + ", nationality=" + this.nationality + ", phoneNumber=" + this.phoneNumber + ", phoneNumberCode=" + this.phoneNumberCode + ", postalCode=" + this.postalCode + ", creditCards=" + this.creditCards + ", passengers=" + this.passengers + ", agreements=" + this.agreements + ", activeBookings=" + this.activeBookings + ")";
    }

    public final UserInfoInput toUserInput() {
        String str;
        String str2 = this.firstName;
        String str3 = this.lastName;
        String str4 = this.phoneNumber;
        PhoneNumber phoneNumber = (str4 == null || (str = this.phoneNumberCode) == null) ? new PhoneNumber((String) null, (String) null, 3, (DefaultConstructorMarker) null) : PhoneNumber.INSTANCE.asValidPhoneNumber(str, str4);
        OldAppLocalDate oldAppLocalDate = this.birthDate;
        LocalDate localDate = oldAppLocalDate != null ? oldAppLocalDate.toLocalDate() : null;
        String str5 = this.email;
        OldAppGender oldAppGender = this.gender;
        Gender gender = oldAppGender != null ? oldAppGender.toGender() : null;
        String str6 = this.nationality;
        return new UserInfoInput(str2, str3, gender, str6 != null ? new Locale(BuildConfig.FLAVOR, str6) : Constants.Defaults.INSTANCE.getDefaultNationality(), localDate, this.postalCode, phoneNumber, str5, null, false, 768, null);
    }
}
