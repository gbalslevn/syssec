package dk.molslinjen.ui.views.screens.profile.shared.userInfo;

import dk.molslinjen.domain.managers.user.UserInfoInput;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import java.util.Locale;
import kotlin.Metadata;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0006J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002H&¢\u0006\u0004\b\u001c\u0010\u0006J\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u0006R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/shared/userInfo/IUserInfoInputHandler;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "firstName", BuildConfig.FLAVOR, "updateFirstName", "(Ljava/lang/String;)V", "lastName", "updateLastName", "Ldk/molslinjen/domain/model/account/Gender;", "gender", "updateGender", "(Ldk/molslinjen/domain/model/account/Gender;)V", "Ljava/util/Locale;", "locale", "updateNationality", "(Ljava/util/Locale;)V", "Lorg/threeten/bp/LocalDate;", "birthdate", "updateBirthdate", "(Lorg/threeten/bp/LocalDate;)V", "zipCode", "updatePostalCode", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "phoneNumber", "updatePhoneNumber", "(Ldk/molslinjen/domain/model/shared/PhoneNumber;)V", "email", "updateEmail", "password", "updatePassword", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/user/UserInfoInput;", "getUserInfoInput", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "userInfoInput", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IUserInfoInputHandler {
    MutableStateFlow<UserInfoInput> getUserInfoInput();

    void updateBirthdate(LocalDate birthdate);

    void updateEmail(String email);

    void updateFirstName(String firstName);

    void updateGender(Gender gender);

    void updateLastName(String lastName);

    void updateNationality(Locale locale);

    void updatePassword(String password);

    void updatePhoneNumber(PhoneNumber phoneNumber);

    void updatePostalCode(String zipCode);
}
