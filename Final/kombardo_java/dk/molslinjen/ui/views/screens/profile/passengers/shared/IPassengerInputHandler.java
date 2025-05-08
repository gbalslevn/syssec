package dk.molslinjen.ui.views.screens.profile.passengers.shared;

import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.constants.Constants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "firstName", BuildConfig.FLAVOR, "updateFirstName", "(Ljava/lang/String;)V", "lastName", "updateLastName", "Ldk/molslinjen/domain/model/account/Gender;", "gender", "updateGender", "(Ldk/molslinjen/domain/model/account/Gender;)V", "Lorg/threeten/bp/LocalDate;", "birthdate", "updateBirthDate", "(Lorg/threeten/bp/LocalDate;)V", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler$InputState;", "getPassengerInput", "()Lkotlinx/coroutines/flow/StateFlow;", "passengerInput", "InputState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IPassengerInputHandler {
    StateFlow<InputState> getPassengerInput();

    void updateBirthDate(LocalDate birthdate);

    void updateFirstName(String firstName);

    void updateGender(Gender gender);

    void updateLastName(String lastName);

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J?\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler$InputState;", BuildConfig.FLAVOR, "firstName", BuildConfig.FLAVOR, "lastName", "gender", "Ldk/molslinjen/domain/model/account/Gender;", "birthdate", "Lorg/threeten/bp/LocalDate;", "nationality", "Ljava/util/Locale;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/account/Gender;Lorg/threeten/bp/LocalDate;Ljava/util/Locale;)V", "getFirstName", "()Ljava/lang/String;", "getLastName", "getGender", "()Ldk/molslinjen/domain/model/account/Gender;", "getBirthdate", "()Lorg/threeten/bp/LocalDate;", "getNationality", "()Ljava/util/Locale;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class InputState {
        private final LocalDate birthdate;
        private final String firstName;
        private final Gender gender;
        private final String lastName;
        private final Locale nationality;

        public InputState(String firstName, String lastName, Gender gender, LocalDate localDate, Locale nationality) {
            Intrinsics.checkNotNullParameter(firstName, "firstName");
            Intrinsics.checkNotNullParameter(lastName, "lastName");
            Intrinsics.checkNotNullParameter(nationality, "nationality");
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.birthdate = localDate;
            this.nationality = nationality;
        }

        public static /* synthetic */ InputState copy$default(InputState inputState, String str, String str2, Gender gender, LocalDate localDate, Locale locale, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = inputState.firstName;
            }
            if ((i5 & 2) != 0) {
                str2 = inputState.lastName;
            }
            String str3 = str2;
            if ((i5 & 4) != 0) {
                gender = inputState.gender;
            }
            Gender gender2 = gender;
            if ((i5 & 8) != 0) {
                localDate = inputState.birthdate;
            }
            LocalDate localDate2 = localDate;
            if ((i5 & 16) != 0) {
                locale = inputState.nationality;
            }
            return inputState.copy(str, str3, gender2, localDate2, locale);
        }

        /* renamed from: component1, reason: from getter */
        public final String getFirstName() {
            return this.firstName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getLastName() {
            return this.lastName;
        }

        /* renamed from: component3, reason: from getter */
        public final Gender getGender() {
            return this.gender;
        }

        /* renamed from: component4, reason: from getter */
        public final LocalDate getBirthdate() {
            return this.birthdate;
        }

        /* renamed from: component5, reason: from getter */
        public final Locale getNationality() {
            return this.nationality;
        }

        public final InputState copy(String firstName, String lastName, Gender gender, LocalDate birthdate, Locale nationality) {
            Intrinsics.checkNotNullParameter(firstName, "firstName");
            Intrinsics.checkNotNullParameter(lastName, "lastName");
            Intrinsics.checkNotNullParameter(nationality, "nationality");
            return new InputState(firstName, lastName, gender, birthdate, nationality);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InputState)) {
                return false;
            }
            InputState inputState = (InputState) other;
            return Intrinsics.areEqual(this.firstName, inputState.firstName) && Intrinsics.areEqual(this.lastName, inputState.lastName) && this.gender == inputState.gender && Intrinsics.areEqual(this.birthdate, inputState.birthdate) && Intrinsics.areEqual(this.nationality, inputState.nationality);
        }

        public final LocalDate getBirthdate() {
            return this.birthdate;
        }

        public final String getFirstName() {
            return this.firstName;
        }

        public final Gender getGender() {
            return this.gender;
        }

        public final String getLastName() {
            return this.lastName;
        }

        public final Locale getNationality() {
            return this.nationality;
        }

        public int hashCode() {
            int hashCode = ((this.firstName.hashCode() * 31) + this.lastName.hashCode()) * 31;
            Gender gender = this.gender;
            int hashCode2 = (hashCode + (gender == null ? 0 : gender.hashCode())) * 31;
            LocalDate localDate = this.birthdate;
            return ((hashCode2 + (localDate != null ? localDate.hashCode() : 0)) * 31) + this.nationality.hashCode();
        }

        public String toString() {
            return "InputState(firstName=" + this.firstName + ", lastName=" + this.lastName + ", gender=" + this.gender + ", birthdate=" + this.birthdate + ", nationality=" + this.nationality + ")";
        }

        public /* synthetic */ InputState(String str, String str2, Gender gender, LocalDate localDate, Locale locale, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? BuildConfig.FLAVOR : str, (i5 & 2) == 0 ? str2 : BuildConfig.FLAVOR, (i5 & 4) != 0 ? null : gender, (i5 & 8) != 0 ? null : localDate, (i5 & 16) != 0 ? Constants.Defaults.INSTANCE.getDefaultNationality() : locale);
        }
    }
}
