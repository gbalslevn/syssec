package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.domain.model.config.AgeClassifications;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 92\u00020\u0001:\u00019BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0010\u0010\u0014B\u0019\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0010\u0010\u0019J\u0006\u0010'\u001a\u00020\u0003J\u0013\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\rHÆ\u0003J\t\u00104\u001a\u00020\u000fHÆ\u0003Je\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010&R\u0011\u0010*\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001b¨\u0006:"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingPassenger;", BuildConfig.FLAVOR, "localId", BuildConfig.FLAVOR, "remoteId", "ageGroup", "Ldk/molslinjen/domain/model/booking/AgeGroup;", "birthDate", "Lorg/threeten/bp/LocalDate;", "firstName", "lastName", "nationality", "gender", "Ldk/molslinjen/domain/model/account/Gender;", "isCurrentUser", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/AgeGroup;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/account/Gender;Z)V", "dto", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingPassengerResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingPassengerResponseDTO;)V", "userPassenger", "Ldk/molslinjen/domain/model/account/UserPassenger;", "ageClassifications", "Ldk/molslinjen/domain/model/config/AgeClassifications;", "(Ldk/molslinjen/domain/model/account/UserPassenger;Ldk/molslinjen/domain/model/config/AgeClassifications;)V", "getLocalId", "()Ljava/lang/String;", "getRemoteId", "getAgeGroup", "()Ldk/molslinjen/domain/model/booking/AgeGroup;", "getBirthDate", "()Lorg/threeten/bp/LocalDate;", "getFirstName", "getLastName", "getNationality", "getGender", "()Ldk/molslinjen/domain/model/account/Gender;", "()Z", "fullName", "equals", "other", "initials", "getInitials", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BookingPassenger {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BookingPassenger mockChild;
    private static final BookingPassenger mockFemale;
    private static final BookingPassenger mockInfant;
    private static final BookingPassenger mockMale;
    private static final BookingPassenger mockOther;
    private final AgeGroup ageGroup;
    private final LocalDate birthDate;
    private final String firstName;
    private final Gender gender;
    private final String initials;
    private final boolean isCurrentUser;
    private final String lastName;
    private final String localId;
    private final String nationality;
    private final String remoteId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingPassenger$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mockMale", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "getMockMale", "()Ldk/molslinjen/domain/model/booking/BookingPassenger;", "mockFemale", "getMockFemale", "mockOther", "getMockOther", "mockChild", "getMockChild", "mockInfant", "getMockInfant", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BookingPassenger getMockChild() {
            return BookingPassenger.mockChild;
        }

        public final BookingPassenger getMockFemale() {
            return BookingPassenger.mockFemale;
        }

        public final BookingPassenger getMockInfant() {
            return BookingPassenger.mockInfant;
        }

        public final BookingPassenger getMockMale() {
            return BookingPassenger.mockMale;
        }

        public final BookingPassenger getMockOther() {
            return BookingPassenger.mockOther;
        }

        private Companion() {
        }
    }

    static {
        UserPassenger.Companion companion = UserPassenger.INSTANCE;
        UserPassenger mockMale2 = companion.getMockMale();
        AgeClassifications.Companion companion2 = AgeClassifications.INSTANCE;
        mockMale = new BookingPassenger(mockMale2, companion2.getMock());
        mockFemale = new BookingPassenger(companion.getMockFemale(), companion2.getMock());
        mockOther = new BookingPassenger(companion.getMockOther(), companion2.getMock());
        mockChild = new BookingPassenger(companion.getMockChild(), companion2.getMock());
        mockInfant = new BookingPassenger(companion.getMockInfant(), companion2.getMock());
    }

    public BookingPassenger(String localId, String str, AgeGroup ageGroup, LocalDate birthDate, String firstName, String lastName, String nationality, Gender gender, boolean z5) {
        Intrinsics.checkNotNullParameter(localId, "localId");
        Intrinsics.checkNotNullParameter(ageGroup, "ageGroup");
        Intrinsics.checkNotNullParameter(birthDate, "birthDate");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(nationality, "nationality");
        Intrinsics.checkNotNullParameter(gender, "gender");
        this.localId = localId;
        this.remoteId = str;
        this.ageGroup = ageGroup;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.gender = gender;
        this.isCurrentUser = z5;
        char charAt = firstName.charAt(0);
        char charAt2 = lastName.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(charAt);
        sb.append(charAt2);
        String upperCase = sb.toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        this.initials = upperCase;
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
    public final AgeGroup getAgeGroup() {
        return this.ageGroup;
    }

    /* renamed from: component4, reason: from getter */
    public final LocalDate getBirthDate() {
        return this.birthDate;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getLastName() {
        return this.lastName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getNationality() {
        return this.nationality;
    }

    /* renamed from: component8, reason: from getter */
    public final Gender getGender() {
        return this.gender;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsCurrentUser() {
        return this.isCurrentUser;
    }

    public final BookingPassenger copy(String localId, String remoteId, AgeGroup ageGroup, LocalDate birthDate, String firstName, String lastName, String nationality, Gender gender, boolean isCurrentUser) {
        Intrinsics.checkNotNullParameter(localId, "localId");
        Intrinsics.checkNotNullParameter(ageGroup, "ageGroup");
        Intrinsics.checkNotNullParameter(birthDate, "birthDate");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(nationality, "nationality");
        Intrinsics.checkNotNullParameter(gender, "gender");
        return new BookingPassenger(localId, remoteId, ageGroup, birthDate, firstName, lastName, nationality, gender, isCurrentUser);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(BookingPassenger.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type dk.molslinjen.domain.model.booking.BookingPassenger");
        BookingPassenger bookingPassenger = (BookingPassenger) other;
        return this.ageGroup == bookingPassenger.ageGroup && Intrinsics.areEqual(this.birthDate, bookingPassenger.birthDate) && Intrinsics.areEqual(this.firstName, bookingPassenger.firstName) && Intrinsics.areEqual(this.lastName, bookingPassenger.lastName) && Intrinsics.areEqual(this.nationality, bookingPassenger.nationality) && this.gender == bookingPassenger.gender && Intrinsics.areEqual(this.initials, bookingPassenger.initials);
    }

    public final String fullName() {
        return this.firstName + " " + this.lastName;
    }

    public final AgeGroup getAgeGroup() {
        return this.ageGroup;
    }

    public final LocalDate getBirthDate() {
        return this.birthDate;
    }

    public final String getFirstName() {
        return this.firstName;
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
        return ((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.ageGroup.hashCode()) * 31) + this.birthDate.hashCode()) * 31) + this.firstName.hashCode()) * 31) + this.lastName.hashCode()) * 31) + this.nationality.hashCode()) * 31) + this.gender.hashCode()) * 31) + Boolean.hashCode(this.isCurrentUser);
    }

    public final boolean isCurrentUser() {
        return this.isCurrentUser;
    }

    public String toString() {
        return "BookingPassenger(localId=" + this.localId + ", remoteId=" + this.remoteId + ", ageGroup=" + this.ageGroup + ", birthDate=" + this.birthDate + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", nationality=" + this.nationality + ", gender=" + this.gender + ", isCurrentUser=" + this.isCurrentUser + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BookingPassenger(BookingResponseDTO.BookingPassengerResponseDTO dto) {
        this(r2, null, AgeGroup.INSTANCE.invoke(dto.getAgeGroup()), dto.getBirthDate(), dto.getFirstName(), dto.getLastName(), dto.getNationality(), Gender.INSTANCE.invoke(dto.getSex()), false);
        Intrinsics.checkNotNullParameter(dto, "dto");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BookingPassenger(UserPassenger userPassenger, AgeClassifications ageClassifications) {
        this(userPassenger.getLocalId(), userPassenger.getRemoteId(), AgeGroup.INSTANCE.get(ageClassifications, userPassenger.getBirthdate()), userPassenger.getBirthdate(), userPassenger.getFirstName(), userPassenger.getLastName(), userPassenger.getNationality(), userPassenger.getGender(), userPassenger.isCurrentUser());
        Intrinsics.checkNotNullParameter(userPassenger, "userPassenger");
        Intrinsics.checkNotNullParameter(ageClassifications, "ageClassifications");
    }
}
