package dk.molslinjen.ui.views.screens.profile.passengers.edit;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.ProfilePassengerEditScreenDestination;
import dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.PassengerInputHandler;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001;B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000bJ\u001b\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0004\b\u0012\u0010\u0011J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0016J\u001a\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0096\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0096\u0001¢\u0006\u0004\b#\u0010$J\u0018\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020%H\u0096\u0001¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u0004\u0018\u00010%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00101\u001a\b\u0012\u0004\u0012\u0002000/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001d\u00103\u001a\b\u0012\u0004\u0012\u0002000/8\u0006¢\u0006\f\n\u0004\b3\u00102\u001a\u0004\b4\u00105R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u000207068\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006<"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/passengers/edit/ProfilePassengerEditViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;", "Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;", "passengersManager", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "<init>", "(Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;Landroidx/lifecycle/SavedStateHandle;)V", BuildConfig.FLAVOR, "startDeleteFlow", "()V", "cancelDeleteFlow", "Lkotlin/Function0;", "finishFlow", "Lkotlinx/coroutines/Job;", "deletePassenger", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/Job;", "updatePassenger", BuildConfig.FLAVOR, "firstName", "updateFirstName", "(Ljava/lang/String;)V", "lastName", "updateLastName", "Ldk/molslinjen/domain/model/account/Gender;", "gender", "updateGender", "(Ldk/molslinjen/domain/model/account/Gender;)V", "Lorg/threeten/bp/LocalDate;", "birthdate", "updateBirthDate", "(Lorg/threeten/bp/LocalDate;)V", "Ljava/util/Locale;", "nationality", "updateNationality", "(Ljava/util/Locale;)V", "Ldk/molslinjen/domain/model/account/UserPassenger;", "passenger", "setDataForPassenger", "(Ldk/molslinjen/domain/model/account/UserPassenger;)V", "Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;", "Ldk/molslinjen/ui/views/screens/profile/passengers/edit/ProfilePassengerEditScreenNavArgs;", "navArgs", "Ldk/molslinjen/ui/views/screens/profile/passengers/edit/ProfilePassengerEditScreenNavArgs;", "originalPassenger", "Ldk/molslinjen/domain/model/account/UserPassenger;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/passengers/edit/ProfilePassengerEditViewModel$ViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler$InputState;", "getPassengerInput", "()Lkotlinx/coroutines/flow/StateFlow;", "passengerInput", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfilePassengerEditViewModel extends ViewModel implements IPassengerInputHandler {
    private final /* synthetic */ PassengerInputHandler $$delegate_0;
    private MutableStateFlow<ViewState> _viewState;
    private final ProfilePassengerEditScreenNavArgs navArgs;
    private final UserPassenger originalPassenger;
    private final IUserPassengerManager passengersManager;
    private final MutableStateFlow<ViewState> viewState;

    public ProfilePassengerEditViewModel(IUserPassengerManager passengersManager, SavedStateHandle savedStateHandle) {
        Object obj;
        ViewState value;
        Intrinsics.checkNotNullParameter(passengersManager, "passengersManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.$$delegate_0 = new PassengerInputHandler();
        this.passengersManager = passengersManager;
        this.navArgs = ProfilePassengerEditScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, false, false, false, 15, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        Iterator<T> it = passengersManager.getPassengersState().getValue().getPassengers().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((UserPassenger) obj).getLocalId(), this.navArgs.getPassengerLocalId())) {
                    break;
                }
            }
        }
        UserPassenger userPassenger = (UserPassenger) obj;
        this.originalPassenger = userPassenger;
        if (userPassenger != null) {
            MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, userPassenger, false, false, false, 14, null)));
            setDataForPassenger(userPassenger);
        }
    }

    public final void cancelDeleteFlow() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, false, false, false, 7, null)));
    }

    public final Job deletePassenger(Function0<Unit> finishFlow) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(finishFlow, "finishFlow");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfilePassengerEditViewModel$deletePassenger$1(this, finishFlow, null), 3, null);
        return launch$default;
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public StateFlow<IPassengerInputHandler.InputState> getPassengerInput() {
        return this.$$delegate_0.getPassengerInput();
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public void setDataForPassenger(UserPassenger passenger) {
        Intrinsics.checkNotNullParameter(passenger, "passenger");
        this.$$delegate_0.setDataForPassenger(passenger);
    }

    public final void startDeleteFlow() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, false, false, true, 7, null)));
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public void updateBirthDate(LocalDate birthdate) {
        this.$$delegate_0.updateBirthDate(birthdate);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public void updateFirstName(String firstName) {
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        this.$$delegate_0.updateFirstName(firstName);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public void updateGender(Gender gender) {
        this.$$delegate_0.updateGender(gender);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public void updateLastName(String lastName) {
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        this.$$delegate_0.updateLastName(lastName);
    }

    public void updateNationality(Locale nationality) {
        this.$$delegate_0.updateNationality(nationality);
    }

    public final Job updatePassenger(Function0<Unit> finishFlow) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(finishFlow, "finishFlow");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfilePassengerEditViewModel$updatePassenger$1(this, finishFlow, null), 3, null);
        return launch$default;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ:\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0005\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0006\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/passengers/edit/ProfilePassengerEditViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/UserPassenger;", "originalPassenger", BuildConfig.FLAVOR, "isLoading", "isDeleteLoading", "showDeleteDialog", "<init>", "(Ldk/molslinjen/domain/model/account/UserPassenger;ZZZ)V", "copy", "(Ldk/molslinjen/domain/model/account/UserPassenger;ZZZ)Ldk/molslinjen/ui/views/screens/profile/passengers/edit/ProfilePassengerEditViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/account/UserPassenger;", "getOriginalPassenger", "()Ldk/molslinjen/domain/model/account/UserPassenger;", "Z", "()Z", "getShowDeleteDialog", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isDeleteLoading;
        private final boolean isLoading;
        private final UserPassenger originalPassenger;
        private final boolean showDeleteDialog;

        public ViewState(UserPassenger userPassenger, boolean z5, boolean z6, boolean z7) {
            this.originalPassenger = userPassenger;
            this.isLoading = z5;
            this.isDeleteLoading = z6;
            this.showDeleteDialog = z7;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, UserPassenger userPassenger, boolean z5, boolean z6, boolean z7, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                userPassenger = viewState.originalPassenger;
            }
            if ((i5 & 2) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 4) != 0) {
                z6 = viewState.isDeleteLoading;
            }
            if ((i5 & 8) != 0) {
                z7 = viewState.showDeleteDialog;
            }
            return viewState.copy(userPassenger, z5, z6, z7);
        }

        public final ViewState copy(UserPassenger originalPassenger, boolean isLoading, boolean isDeleteLoading, boolean showDeleteDialog) {
            return new ViewState(originalPassenger, isLoading, isDeleteLoading, showDeleteDialog);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.originalPassenger, viewState.originalPassenger) && this.isLoading == viewState.isLoading && this.isDeleteLoading == viewState.isDeleteLoading && this.showDeleteDialog == viewState.showDeleteDialog;
        }

        public final UserPassenger getOriginalPassenger() {
            return this.originalPassenger;
        }

        public final boolean getShowDeleteDialog() {
            return this.showDeleteDialog;
        }

        public int hashCode() {
            UserPassenger userPassenger = this.originalPassenger;
            return ((((((userPassenger == null ? 0 : userPassenger.hashCode()) * 31) + Boolean.hashCode(this.isLoading)) * 31) + Boolean.hashCode(this.isDeleteLoading)) * 31) + Boolean.hashCode(this.showDeleteDialog);
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
            return "ViewState(originalPassenger=" + this.originalPassenger + ", isLoading=" + this.isLoading + ", isDeleteLoading=" + this.isDeleteLoading + ", showDeleteDialog=" + this.showDeleteDialog + ")";
        }

        public /* synthetic */ ViewState(UserPassenger userPassenger, boolean z5, boolean z6, boolean z7, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : userPassenger, (i5 & 2) != 0 ? false : z5, (i5 & 4) != 0 ? false : z6, (i5 & 8) != 0 ? false : z7);
        }
    }
}
