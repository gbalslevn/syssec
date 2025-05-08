package dk.molslinjen.domain.model.account;

import com.sun.jna.Function;
import dk.molslinjen.api.helpers.serializers.LocalDateSerializer;
import dk.molslinjen.api.services.account.passenger.response.AccountPassengerDTO;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.account.user.UserPersonalDetails;
import java.util.Locale;
import java.util.UUID;
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
import org.threeten.bp.format.FormatStyle;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0002@ABI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u000e\u0010\u0012B\u0087\u0001\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u000e\u0010\u001aJ\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\rHÆ\u0003J[\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u00104\u001a\u00020\r2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0014HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001J%\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0001¢\u0006\u0002\b?R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010'R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001c¨\u0006B"}, d2 = {"Ldk/molslinjen/domain/model/account/UserPassenger;", BuildConfig.FLAVOR, "localId", BuildConfig.FLAVOR, "remoteId", "firstName", "lastName", "gender", "Ldk/molslinjen/domain/model/account/Gender;", "birthdate", "Lorg/threeten/bp/LocalDate;", "nationality", "isCurrentUser", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/account/Gender;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Z)V", "dto", "Ldk/molslinjen/api/services/account/passenger/response/AccountPassengerDTO;", "(Ldk/molslinjen/api/services/account/passenger/response/AccountPassengerDTO;)V", "seen0", BuildConfig.FLAVOR, "formattedBirthdate", "fullName", "initials", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/account/Gender;Lorg/threeten/bp/LocalDate;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLocalId", "()Ljava/lang/String;", "getRemoteId", "getFirstName", "getLastName", "getGender", "()Ldk/molslinjen/domain/model/account/Gender;", "getBirthdate$annotations", "()V", "getBirthdate", "()Lorg/threeten/bp/LocalDate;", "getNationality", "()Z", "getFormattedBirthdate", "getFullName", "getInitials", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class UserPassenger {
    private static final UserPassenger mockChild;
    private static final UserPassenger mockCurrentUserPassenger;
    private static final UserPassenger mockFemale;
    private static final UserPassenger mockInfant;
    private static final UserPassenger mockMale;
    private static final UserPassenger mockOther;
    private final LocalDate birthdate;
    private final String firstName;
    private final String formattedBirthdate;
    private final String fullName;
    private final Gender gender;
    private final String initials;
    private final boolean isCurrentUser;
    private final String lastName;
    private final String localId;
    private final String nationality;
    private final String remoteId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.account.Gender", Gender.values()), null, null, null, null, null, null};

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\n¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/domain/model/account/UserPassenger$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/account/UserPassenger;", "userPersonalDetails", "Ldk/molslinjen/domain/model/account/user/UserPersonalDetails;", "mockCurrentUserPassenger", "getMockCurrentUserPassenger", "()Ldk/molslinjen/domain/model/account/UserPassenger;", "mockMale", "getMockMale", "mockFemale", "getMockFemale", "mockOther", "getMockOther", "mockChild", "getMockChild", "mockInfant", "getMockInfant", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserPassenger getMockChild() {
            return UserPassenger.mockChild;
        }

        public final UserPassenger getMockCurrentUserPassenger() {
            return UserPassenger.mockCurrentUserPassenger;
        }

        public final UserPassenger getMockFemale() {
            return UserPassenger.mockFemale;
        }

        public final UserPassenger getMockInfant() {
            return UserPassenger.mockInfant;
        }

        public final UserPassenger getMockMale() {
            return UserPassenger.mockMale;
        }

        public final UserPassenger getMockOther() {
            return UserPassenger.mockOther;
        }

        public final UserPassenger invoke(UserPersonalDetails userPersonalDetails) {
            LocalDate birthDate;
            String nationality;
            Intrinsics.checkNotNullParameter(userPersonalDetails, "userPersonalDetails");
            Gender gender = userPersonalDetails.getGender();
            if (gender == null || (birthDate = userPersonalDetails.getBirthDate()) == null || (nationality = userPersonalDetails.getNationality()) == null) {
                return null;
            }
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            return new UserPassenger(uuid, null, userPersonalDetails.getFirstName(), userPersonalDetails.getLastName(), gender, birthDate, nationality, true);
        }

        public final KSerializer<UserPassenger> serializer() {
            return UserPassenger$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        Gender gender = Gender.Other;
        LocalDate minusYears = LocalDate.now().minusYears(40L);
        Intrinsics.checkNotNullExpressionValue(minusYears, "minusYears(...)");
        mockCurrentUserPassenger = new UserPassenger("0", "0", "Morten", "Fjord", gender, minusYears, "DK", true);
        LocalDate minusYears2 = LocalDate.now().minusYears(30L);
        Intrinsics.checkNotNullExpressionValue(minusYears2, "minusYears(...)");
        Gender gender2 = Gender.Male;
        mockMale = new UserPassenger("1", "1", "Hans", "Schultz Jensen", gender2, minusYears2, "US", false);
        LocalDate minusYears3 = LocalDate.now().minusYears(40L);
        Intrinsics.checkNotNullExpressionValue(minusYears3, "minusYears(...)");
        Gender gender3 = Gender.Female;
        mockFemale = new UserPassenger("2", "2", "Signe", "Lorensen Hansen", gender3, minusYears3, "UK", false);
        LocalDate minusYears4 = LocalDate.now().minusYears(50L);
        Intrinsics.checkNotNullExpressionValue(minusYears4, "minusYears(...)");
        mockOther = new UserPassenger("3", "3", "Kurt", "Frandsen", gender, minusYears4, "DK", false);
        LocalDate minusYears5 = LocalDate.now().minusYears(8L);
        Intrinsics.checkNotNullExpressionValue(minusYears5, "minusYears(...)");
        mockChild = new UserPassenger("4", "4", "Victor", "Frandsen Vester Mogensen", gender2, minusYears5, "DK", false);
        LocalDate minusYears6 = LocalDate.now().minusYears(1L);
        Intrinsics.checkNotNullExpressionValue(minusYears6, "minusYears(...)");
        mockInfant = new UserPassenger("5", "5", "Josefine", "Le Ursula von Feltsted", gender3, minusYears6, "DK", false);
    }

    public /* synthetic */ UserPassenger(int i5, String str, String str2, String str3, String str4, Gender gender, LocalDate localDate, String str5, boolean z5, String str6, String str7, String str8, SerializationConstructorMarker serializationConstructorMarker) {
        if (255 != (i5 & Function.USE_VARARGS)) {
            PluginExceptionsKt.throwMissingFieldException(i5, Function.USE_VARARGS, UserPassenger$$serializer.INSTANCE.getDescriptor());
        }
        this.localId = str;
        this.remoteId = str2;
        this.firstName = str3;
        this.lastName = str4;
        this.gender = gender;
        this.birthdate = localDate;
        this.nationality = str5;
        this.isCurrentUser = z5;
        if ((i5 & 256) == 0) {
            FormatStyle formatStyle = FormatStyle.LONG;
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            this.formattedBirthdate = LocalDateTimeExtensionsKt.toFormat(localDate, formatStyle, locale);
        } else {
            this.formattedBirthdate = str6;
        }
        if ((i5 & 512) == 0) {
            this.fullName = str3 + " " + str4;
        } else {
            this.fullName = str7;
        }
        if ((i5 & 1024) != 0) {
            this.initials = str8;
            return;
        }
        String firstOrNull = StringsKt.firstOrNull(str3);
        firstOrNull = firstOrNull == null ? "-" : firstOrNull;
        Object firstOrNull2 = StringsKt.firstOrNull(str4);
        firstOrNull2 = firstOrNull2 == null ? BuildConfig.FLAVOR : firstOrNull2;
        StringBuilder sb = new StringBuilder();
        sb.append(firstOrNull);
        sb.append(firstOrNull2);
        String upperCase = sb.toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        this.initials = upperCase;
    }

    @Serializable(with = LocalDateSerializer.class)
    public static /* synthetic */ void getBirthdate$annotations() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0058, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1, dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt.toFormat(r2, r3, r4)) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0086, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r6.fullName, r6.firstName + " " + r6.lastName) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void write$Self$domain_kombardoProd(UserPassenger self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.localId);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.remoteId);
        output.encodeStringElement(serialDesc, 2, self.firstName);
        output.encodeStringElement(serialDesc, 3, self.lastName);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.gender);
        output.encodeSerializableElement(serialDesc, 5, LocalDateSerializer.INSTANCE, self.birthdate);
        output.encodeStringElement(serialDesc, 6, self.nationality);
        output.encodeBooleanElement(serialDesc, 7, self.isCurrentUser);
        if (!output.shouldEncodeElementDefault(serialDesc, 8)) {
            String str = self.formattedBirthdate;
            LocalDate localDate = self.birthdate;
            FormatStyle formatStyle = FormatStyle.LONG;
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        }
        output.encodeStringElement(serialDesc, 8, self.formattedBirthdate);
        if (!output.shouldEncodeElementDefault(serialDesc, 9)) {
        }
        output.encodeStringElement(serialDesc, 9, self.fullName);
        if (!output.shouldEncodeElementDefault(serialDesc, 10)) {
            String str2 = self.initials;
            Object firstOrNull = StringsKt.firstOrNull(self.firstName);
            if (firstOrNull == null) {
                firstOrNull = "-";
            }
            Object firstOrNull2 = StringsKt.firstOrNull(self.lastName);
            if (firstOrNull2 == null) {
                firstOrNull2 = BuildConfig.FLAVOR;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(firstOrNull);
            sb.append(firstOrNull2);
            String upperCase = sb.toString().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (Intrinsics.areEqual(str2, upperCase)) {
                return;
            }
        }
        output.encodeStringElement(serialDesc, 10, self.initials);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLocalId() {
        return this.localId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRemoteId() {
        return this.remoteId;
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
    public final Gender getGender() {
        return this.gender;
    }

    /* renamed from: component6, reason: from getter */
    public final LocalDate getBirthdate() {
        return this.birthdate;
    }

    /* renamed from: component7, reason: from getter */
    public final String getNationality() {
        return this.nationality;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsCurrentUser() {
        return this.isCurrentUser;
    }

    public final UserPassenger copy(String localId, String remoteId, String firstName, String lastName, Gender gender, LocalDate birthdate, String nationality, boolean isCurrentUser) {
        Intrinsics.checkNotNullParameter(localId, "localId");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(birthdate, "birthdate");
        Intrinsics.checkNotNullParameter(nationality, "nationality");
        return new UserPassenger(localId, remoteId, firstName, lastName, gender, birthdate, nationality, isCurrentUser);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserPassenger)) {
            return false;
        }
        UserPassenger userPassenger = (UserPassenger) other;
        return Intrinsics.areEqual(this.localId, userPassenger.localId) && Intrinsics.areEqual(this.remoteId, userPassenger.remoteId) && Intrinsics.areEqual(this.firstName, userPassenger.firstName) && Intrinsics.areEqual(this.lastName, userPassenger.lastName) && this.gender == userPassenger.gender && Intrinsics.areEqual(this.birthdate, userPassenger.birthdate) && Intrinsics.areEqual(this.nationality, userPassenger.nationality) && this.isCurrentUser == userPassenger.isCurrentUser;
    }

    public final LocalDate getBirthdate() {
        return this.birthdate;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getFormattedBirthdate() {
        return this.formattedBirthdate;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final Gender getGender() {
        return this.gender;
    }

    public final String getInitials() {
        return this.initials;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getLocalId() {
        return this.localId;
    }

    public final String getNationality() {
        return this.nationality;
    }

    public final String getRemoteId() {
        return this.remoteId;
    }

    public int hashCode() {
        int hashCode = this.localId.hashCode() * 31;
        String str = this.remoteId;
        return ((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.firstName.hashCode()) * 31) + this.lastName.hashCode()) * 31) + this.gender.hashCode()) * 31) + this.birthdate.hashCode()) * 31) + this.nationality.hashCode()) * 31) + Boolean.hashCode(this.isCurrentUser);
    }

    public final boolean isCurrentUser() {
        return this.isCurrentUser;
    }

    public String toString() {
        return "UserPassenger(localId=" + this.localId + ", remoteId=" + this.remoteId + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", gender=" + this.gender + ", birthdate=" + this.birthdate + ", nationality=" + this.nationality + ", isCurrentUser=" + this.isCurrentUser + ")";
    }

    public UserPassenger(String localId, String str, String firstName, String lastName, Gender gender, LocalDate birthdate, String nationality, boolean z5) {
        Intrinsics.checkNotNullParameter(localId, "localId");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(birthdate, "birthdate");
        Intrinsics.checkNotNullParameter(nationality, "nationality");
        this.localId = localId;
        this.remoteId = str;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.nationality = nationality;
        this.isCurrentUser = z5;
        FormatStyle formatStyle = FormatStyle.LONG;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        this.formattedBirthdate = LocalDateTimeExtensionsKt.toFormat(birthdate, formatStyle, locale);
        this.fullName = firstName + " " + lastName;
        String firstOrNull = StringsKt.firstOrNull(firstName);
        firstOrNull = firstOrNull == null ? "-" : firstOrNull;
        Object firstOrNull2 = StringsKt.firstOrNull(lastName);
        firstOrNull2 = firstOrNull2 == null ? BuildConfig.FLAVOR : firstOrNull2;
        StringBuilder sb = new StringBuilder();
        sb.append(firstOrNull);
        sb.append(firstOrNull2);
        String upperCase = sb.toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        this.initials = upperCase;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserPassenger(AccountPassengerDTO dto) {
        this(dto.getId(), dto.getId(), dto.getFirstName(), dto.getLastName(), Gender.INSTANCE.invoke(dto.getGender()), dto.getBirthdate(), dto.getNationality(), dto.isCurrentUser());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
