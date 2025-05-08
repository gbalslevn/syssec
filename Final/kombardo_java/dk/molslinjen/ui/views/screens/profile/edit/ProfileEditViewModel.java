package dk.molslinjen.ui.views.screens.profile.edit;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.UserInfoInput;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.account.user.AccountUser;
import dk.molslinjen.domain.model.account.user.LocalUser;
import dk.molslinjen.domain.model.account.user.Uninitialized;
import dk.molslinjen.domain.model.account.user.User;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoInputHandler;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002EFB!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ\u001b\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\u0004\b\u0013\u0010\u0012J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0014H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u0017J\u001a\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0096\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0014H\u0096\u0001¢\u0006\u0004\b#\u0010\u0017J\u001a\u0010&\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010$H\u0096\u0001¢\u0006\u0004\b&\u0010'J\u0018\u0010)\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0014H\u0096\u0001¢\u0006\u0004\b)\u0010\u0017J\u0018\u0010,\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*H\u0096\u0001¢\u0006\u0004\b,\u0010-J\u0018\u0010/\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0014H\u0096\u0001¢\u0006\u0004\b/\u0010\u0017J\u0018\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0014H\u0096\u0001¢\u0006\u0004\b1\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00102R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00103R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00104R\u001a\u00107\u001a\b\u0012\u0004\u0012\u000206058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u000206098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020>058\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020B098\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bC\u0010=¨\u0006G"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/edit/ProfileEditViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/ui/views/screens/profile/shared/userInfo/IUserInfoInputHandler;", "Ldk/molslinjen/domain/managers/user/IUserManager;", "userManager", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "snackbarService", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "analyticsTracker", "<init>", "(Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", BuildConfig.FLAVOR, "triggerDeleteAccount", "()V", "cancelDeleteAccount", "Lkotlin/Function0;", "dismissFlow", "onDeleteAccount", "(Lkotlin/jvm/functions/Function0;)V", "confirmChanges", BuildConfig.FLAVOR, "firstName", "updateFirstName", "(Ljava/lang/String;)V", "lastName", "updateLastName", "Ldk/molslinjen/domain/model/account/Gender;", "gender", "updateGender", "(Ldk/molslinjen/domain/model/account/Gender;)V", "Ljava/util/Locale;", "locale", "updateNationality", "(Ljava/util/Locale;)V", "phoneNumberCode", "updatePhoneNumberCode", "Lorg/threeten/bp/LocalDate;", "birthdate", "updateBirthdate", "(Lorg/threeten/bp/LocalDate;)V", "zipCode", "updatePostalCode", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "phoneNumber", "updatePhoneNumber", "(Ldk/molslinjen/domain/model/shared/PhoneNumber;)V", "email", "updateEmail", "password", "updatePassword", "Ldk/molslinjen/domain/managers/user/IUserManager;", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/edit/ProfileEditViewModel$ViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/user/UserInfoInput;", "getUserInfoInput", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "userInfoInput", BuildConfig.FLAVOR, "getHasChanges", "hasChanges", "ViewState", "EditMode", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileEditViewModel extends ViewModel implements IUserInfoInputHandler {
    private final /* synthetic */ UserInfoInputHandler $$delegate_0;
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final ISnackbarService snackbarService;
    private final IUserManager userManager;
    private final StateFlow<ViewState> viewState;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/edit/ProfileEditViewModel$EditMode;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "CreateLocal", "EditLocal", "EditAuthenticated", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class EditMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EditMode[] $VALUES;
        public static final EditMode CreateLocal = new EditMode("CreateLocal", 0);
        public static final EditMode EditLocal = new EditMode("EditLocal", 1);
        public static final EditMode EditAuthenticated = new EditMode("EditAuthenticated", 2);

        private static final /* synthetic */ EditMode[] $values() {
            return new EditMode[]{CreateLocal, EditLocal, EditAuthenticated};
        }

        static {
            EditMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private EditMode(String str, int i5) {
        }

        public static EditMode valueOf(String str) {
            return (EditMode) Enum.valueOf(EditMode.class, str);
        }

        public static EditMode[] values() {
            return (EditMode[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProfileEditViewModel(IUserManager userManager, ISnackbarService snackbarService, IAnalyticsTracker analyticsTracker) {
        EditMode editMode;
        ViewState value;
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.$$delegate_0 = new UserInfoInputHandler(userManager);
        this.userManager = userManager;
        this.snackbarService = snackbarService;
        this.analyticsTracker = analyticsTracker;
        boolean z5 = false;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, null, null, null, false, z5, 63, null));
        this._viewState = MutableStateFlow;
        this.viewState = FlowKt.stateIn(FlowKt.flowCombine(MutableStateFlow, userManager.getPendingAccountActivation(), new ProfileEditViewModel$viewState$1(null)), ViewModelKt.getViewModelScope(this), SharingStarted.INSTANCE.getLazily(), new ViewState(false, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, z5, false, 63, null));
        User user = userManager.getCurrentUserState().getValue().getUser();
        if (user instanceof AccountUser) {
            editMode = EditMode.EditAuthenticated;
        } else if (user instanceof LocalUser) {
            editMode = !((LocalUser) user).getUserInfo().getIsEmpty() ? EditMode.EditLocal : EditMode.CreateLocal;
        } else {
            if (!Intrinsics.areEqual(user, Uninitialized.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            editMode = EditMode.CreateLocal;
        }
        do {
            value = MutableStateFlow.getValue();
        } while (!MutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, editMode, null, user.getUserId(), false, false, 53, null)));
    }

    public final void cancelDeleteAccount() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, null, null, null, false, false, 47, null)));
    }

    public final void confirmChanges(Function0<Unit> dismissFlow) {
        Intrinsics.checkNotNullParameter(dismissFlow, "dismissFlow");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileEditViewModel$confirmChanges$1(this, dismissFlow, null), 3, null);
    }

    public StateFlow<Boolean> getHasChanges() {
        return this.$$delegate_0.getHasChanges();
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public MutableStateFlow<UserInfoInput> getUserInfoInput() {
        return this.$$delegate_0.getUserInfoInput();
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void onDeleteAccount(Function0<Unit> dismissFlow) {
        ViewState value;
        Intrinsics.checkNotNullParameter(dismissFlow, "dismissFlow");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, null, null, null, false, true, 31, null)));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileEditViewModel$onDeleteAccount$2(this, dismissFlow, null), 3, null);
    }

    public final void triggerDeleteAccount() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, null, null, null, true, false, 47, null)));
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateBirthdate(LocalDate birthdate) {
        this.$$delegate_0.updateBirthdate(birthdate);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateEmail(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        this.$$delegate_0.updateEmail(email);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateFirstName(String firstName) {
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        this.$$delegate_0.updateFirstName(firstName);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateGender(Gender gender) {
        this.$$delegate_0.updateGender(gender);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateLastName(String lastName) {
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        this.$$delegate_0.updateLastName(lastName);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateNationality(Locale locale) {
        this.$$delegate_0.updateNationality(locale);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updatePassword(String password) {
        Intrinsics.checkNotNullParameter(password, "password");
        this.$$delegate_0.updatePassword(password);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updatePhoneNumber(PhoneNumber phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        this.$$delegate_0.updatePhoneNumber(phoneNumber);
    }

    public void updatePhoneNumberCode(String phoneNumberCode) {
        this.$$delegate_0.updatePhoneNumberCode(phoneNumberCode);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updatePostalCode(String zipCode) {
        Intrinsics.checkNotNullParameter(zipCode, "zipCode");
        this.$$delegate_0.updatePostalCode(zipCode);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJR\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0003\u0010\u0019R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0011R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\"\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u000b\u0010\u0019¨\u0006#"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/edit/ProfileEditViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", "Ldk/molslinjen/ui/views/screens/profile/edit/ProfileEditViewModel$EditMode;", "editMode", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", "accountCardData", BuildConfig.FLAVOR, "userId", "showDeleteDialog", "isDeleteLoading", "<init>", "(ZLdk/molslinjen/ui/views/screens/profile/edit/ProfileEditViewModel$EditMode;Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;Ljava/lang/String;ZZ)V", "copy", "(ZLdk/molslinjen/ui/views/screens/profile/edit/ProfileEditViewModel$EditMode;Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;Ljava/lang/String;ZZ)Ldk/molslinjen/ui/views/screens/profile/edit/ProfileEditViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ldk/molslinjen/ui/views/screens/profile/edit/ProfileEditViewModel$EditMode;", "getEditMode", "()Ldk/molslinjen/ui/views/screens/profile/edit/ProfileEditViewModel$EditMode;", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", "getAccountCardData", "()Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", "Ljava/lang/String;", "getUserId", "getShowDeleteDialog", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final AccountCardData accountCardData;
        private final EditMode editMode;
        private final boolean isDeleteLoading;
        private final boolean isLoading;
        private final boolean showDeleteDialog;
        private final String userId;

        public ViewState(boolean z5, EditMode editMode, AccountCardData accountCardData, String str, boolean z6, boolean z7) {
            this.isLoading = z5;
            this.editMode = editMode;
            this.accountCardData = accountCardData;
            this.userId = str;
            this.showDeleteDialog = z6;
            this.isDeleteLoading = z7;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, EditMode editMode, AccountCardData accountCardData, String str, boolean z6, boolean z7, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 2) != 0) {
                editMode = viewState.editMode;
            }
            EditMode editMode2 = editMode;
            if ((i5 & 4) != 0) {
                accountCardData = viewState.accountCardData;
            }
            AccountCardData accountCardData2 = accountCardData;
            if ((i5 & 8) != 0) {
                str = viewState.userId;
            }
            String str2 = str;
            if ((i5 & 16) != 0) {
                z6 = viewState.showDeleteDialog;
            }
            boolean z8 = z6;
            if ((i5 & 32) != 0) {
                z7 = viewState.isDeleteLoading;
            }
            return viewState.copy(z5, editMode2, accountCardData2, str2, z8, z7);
        }

        public final ViewState copy(boolean isLoading, EditMode editMode, AccountCardData accountCardData, String userId, boolean showDeleteDialog, boolean isDeleteLoading) {
            return new ViewState(isLoading, editMode, accountCardData, userId, showDeleteDialog, isDeleteLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && this.editMode == viewState.editMode && Intrinsics.areEqual(this.accountCardData, viewState.accountCardData) && Intrinsics.areEqual(this.userId, viewState.userId) && this.showDeleteDialog == viewState.showDeleteDialog && this.isDeleteLoading == viewState.isDeleteLoading;
        }

        public final AccountCardData getAccountCardData() {
            return this.accountCardData;
        }

        public final EditMode getEditMode() {
            return this.editMode;
        }

        public final boolean getShowDeleteDialog() {
            return this.showDeleteDialog;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.isLoading) * 31;
            EditMode editMode = this.editMode;
            int hashCode2 = (hashCode + (editMode == null ? 0 : editMode.hashCode())) * 31;
            AccountCardData accountCardData = this.accountCardData;
            int hashCode3 = (hashCode2 + (accountCardData == null ? 0 : accountCardData.hashCode())) * 31;
            String str = this.userId;
            return ((((hashCode3 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.showDeleteDialog)) * 31) + Boolean.hashCode(this.isDeleteLoading);
        }

        /* renamed from: isDeleteLoading, reason: from getter */
        public final boolean getIsDeleteLoading() {
            return this.isDeleteLoading;
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", editMode=" + this.editMode + ", accountCardData=" + this.accountCardData + ", userId=" + this.userId + ", showDeleteDialog=" + this.showDeleteDialog + ", isDeleteLoading=" + this.isDeleteLoading + ")";
        }

        public /* synthetic */ ViewState(boolean z5, EditMode editMode, AccountCardData accountCardData, String str, boolean z6, boolean z7, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? null : editMode, (i5 & 4) != 0 ? null : accountCardData, (i5 & 8) == 0 ? str : null, (i5 & 16) != 0 ? false : z6, (i5 & 32) != 0 ? false : z7);
        }
    }
}
