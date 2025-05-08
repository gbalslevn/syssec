package dk.molslinjen.domain.model.account.user;

import dk.molslinjen.api.services.account.passenger.response.GenderDTO;
import dk.molslinjen.api.services.account.response.AccountInfoResponseDTO;
import dk.molslinjen.api.services.account.response.AccountUpdateInfoResponseDTO;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.shared.PhoneNumber;
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

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000256B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007BQ\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0006\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0018¢\u0006\u0004\b\u0006\u0010\u0019B7\b\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u0006\u0010 J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010)\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u001bHÖ\u0001J\t\u0010,\u001a\u00020\tHÖ\u0001J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010%¨\u00067"}, d2 = {"Ldk/molslinjen/domain/model/account/user/UserInfo;", BuildConfig.FLAVOR, "personalDetails", "Ldk/molslinjen/domain/model/account/user/UserPersonalDetails;", "contactDetails", "Ldk/molslinjen/domain/model/account/user/UserContactDetails;", "<init>", "(Ldk/molslinjen/domain/model/account/user/UserPersonalDetails;Ldk/molslinjen/domain/model/account/user/UserContactDetails;)V", "email", BuildConfig.FLAVOR, "gender", "Ldk/molslinjen/domain/model/account/Gender;", "firstName", "lastName", "birthDate", "Lorg/threeten/bp/LocalDate;", "nationality", "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "postalCode", "(Ljava/lang/String;Ldk/molslinjen/domain/model/account/Gender;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PhoneNumber;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/account/response/AccountInfoResponseDTO;", "(Ldk/molslinjen/api/services/account/response/AccountInfoResponseDTO;)V", "Ldk/molslinjen/api/services/account/response/AccountUpdateInfoResponseDTO;", "(Ldk/molslinjen/api/services/account/response/AccountUpdateInfoResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "isEmpty", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/domain/model/account/user/UserPersonalDetails;Ldk/molslinjen/domain/model/account/user/UserContactDetails;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPersonalDetails", "()Ldk/molslinjen/domain/model/account/user/UserPersonalDetails;", "getContactDetails", "()Ldk/molslinjen/domain/model/account/user/UserContactDetails;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class UserInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UserInfo empty = new UserInfo(null, null);
    private static final UserInfo mock = new UserInfo(new UserPersonalDetails(Gender.Male, "Hans", "Vossen Frandsen Jensen", LocalDate.now().minusYears(30), "DK"), new UserContactDetails("hans@email.com", new PhoneNumber("+45", "88112233"), "8000"));
    private final UserContactDetails contactDetails;
    private final boolean isEmpty;
    private final UserPersonalDetails personalDetails;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/account/user/UserInfo$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "empty", "Ldk/molslinjen/domain/model/account/user/UserInfo;", "getEmpty", "()Ldk/molslinjen/domain/model/account/user/UserInfo;", "mock", "getMock", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserInfo getEmpty() {
            return UserInfo.empty;
        }

        public final UserInfo getMock() {
            return UserInfo.mock;
        }

        public final KSerializer<UserInfo> serializer() {
            return UserInfo$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ UserInfo(int i5, UserPersonalDetails userPersonalDetails, UserContactDetails userContactDetails, boolean z5, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, UserInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.personalDetails = userPersonalDetails;
        this.contactDetails = userContactDetails;
        if ((i5 & 4) == 0) {
            this.isEmpty = userPersonalDetails == null && userContactDetails == null;
        } else {
            this.isEmpty = z5;
        }
    }

    public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, UserPersonalDetails userPersonalDetails, UserContactDetails userContactDetails, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            userPersonalDetails = userInfo.personalDetails;
        }
        if ((i5 & 2) != 0) {
            userContactDetails = userInfo.contactDetails;
        }
        return userInfo.copy(userPersonalDetails, userContactDetails);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(UserInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z5 = false;
        output.encodeNullableSerializableElement(serialDesc, 0, UserPersonalDetails$$serializer.INSTANCE, self.personalDetails);
        output.encodeNullableSerializableElement(serialDesc, 1, UserContactDetails$$serializer.INSTANCE, self.contactDetails);
        if (!output.shouldEncodeElementDefault(serialDesc, 2)) {
            boolean z6 = self.isEmpty;
            if (self.personalDetails == null && self.contactDetails == null) {
                z5 = true;
            }
            if (z6 == z5) {
                return;
            }
        }
        output.encodeBooleanElement(serialDesc, 2, self.isEmpty);
    }

    /* renamed from: component1, reason: from getter */
    public final UserPersonalDetails getPersonalDetails() {
        return this.personalDetails;
    }

    /* renamed from: component2, reason: from getter */
    public final UserContactDetails getContactDetails() {
        return this.contactDetails;
    }

    public final UserInfo copy(UserPersonalDetails personalDetails, UserContactDetails contactDetails) {
        return new UserInfo(personalDetails, contactDetails);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) other;
        return Intrinsics.areEqual(this.personalDetails, userInfo.personalDetails) && Intrinsics.areEqual(this.contactDetails, userInfo.contactDetails);
    }

    public final UserContactDetails getContactDetails() {
        return this.contactDetails;
    }

    public final UserPersonalDetails getPersonalDetails() {
        return this.personalDetails;
    }

    public int hashCode() {
        UserPersonalDetails userPersonalDetails = this.personalDetails;
        int hashCode = (userPersonalDetails == null ? 0 : userPersonalDetails.hashCode()) * 31;
        UserContactDetails userContactDetails = this.contactDetails;
        return hashCode + (userContactDetails != null ? userContactDetails.hashCode() : 0);
    }

    /* renamed from: isEmpty, reason: from getter */
    public final boolean getIsEmpty() {
        return this.isEmpty;
    }

    public String toString() {
        return "UserInfo(personalDetails=" + this.personalDetails + ", contactDetails=" + this.contactDetails + ")";
    }

    public UserInfo(UserPersonalDetails userPersonalDetails, UserContactDetails userContactDetails) {
        this.personalDetails = userPersonalDetails;
        this.contactDetails = userContactDetails;
        this.isEmpty = userPersonalDetails == null && userContactDetails == null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserInfo(String email, Gender gender, String firstName, String lastName, LocalDate localDate, String str, PhoneNumber phoneNumber, String str2) {
        this(new UserPersonalDetails(gender, firstName, lastName, localDate, str), new UserContactDetails(email, phoneNumber, str2));
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UserInfo(AccountInfoResponseDTO dto) {
        this(r2, r0 != null ? Gender.INSTANCE.invoke(r0) : null, dto.getFirstName(), dto.getLastName(), dto.getBirthDate(), dto.getNationality(), new PhoneNumber(dto), dto.getPostalCode());
        Intrinsics.checkNotNullParameter(dto, "dto");
        String email = dto.getEmail();
        GenderDTO gender = dto.getGender();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UserInfo(AccountUpdateInfoResponseDTO dto) {
        this(r2, r0 != null ? Gender.INSTANCE.invoke(r0) : null, dto.getFirstName(), dto.getLastName(), dto.getBirthDate(), dto.getNationality(), new PhoneNumber(dto), dto.getPostalCode());
        Intrinsics.checkNotNullParameter(dto, "dto");
        String email = dto.getEmail();
        GenderDTO gender = dto.getGender();
    }
}
