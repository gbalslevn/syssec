package dk.molslinjen.ui.views.screens.profile.passengers.register;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.PassengerInputHandler;
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

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00016B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001aJ\u001a\u0010\u001f\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0096\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0096\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010%H\u0096\u0001¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010)R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020+0.8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002030.8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u00102¨\u00067"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/passengers/register/ProfilePassengersRegisterViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;", "Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;", "passengerManager", "<init>", "(Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;)V", "Lkotlin/Function0;", BuildConfig.FLAVOR, "proceed", "Lkotlinx/coroutines/Job;", "registerPassenger", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/Job;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "firstName", "updateFirstName", "(Ljava/lang/String;)V", "lastName", "updateLastName", "Ldk/molslinjen/domain/model/account/Gender;", "gender", "updateGender", "(Ldk/molslinjen/domain/model/account/Gender;)V", "Lorg/threeten/bp/LocalDate;", "birthdate", "updateBirthDate", "(Lorg/threeten/bp/LocalDate;)V", "Ljava/util/Locale;", "nationality", "updateNationality", "(Ljava/util/Locale;)V", "Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/passengers/register/ProfilePassengersRegisterViewModel$ViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler$InputState;", "getPassengerInput", "passengerInput", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ProfilePassengersRegisterViewModel extends ViewModel implements IPassengerInputHandler {
    private final /* synthetic */ PassengerInputHandler $$delegate_0;
    private final MutableStateFlow<ViewState> _viewState;
    private final IUserPassengerManager passengerManager;
    private final StateFlow<ViewState> viewState;

    public ProfilePassengersRegisterViewModel(IUserPassengerManager passengerManager) {
        Intrinsics.checkNotNullParameter(passengerManager, "passengerManager");
        this.$$delegate_0 = new PassengerInputHandler();
        this.passengerManager = passengerManager;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, 1, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ProfilePassengersRegisterViewModel) && Intrinsics.areEqual(this.passengerManager, ((ProfilePassengersRegisterViewModel) other).passengerManager);
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public StateFlow<IPassengerInputHandler.InputState> getPassengerInput() {
        return this.$$delegate_0.getPassengerInput();
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public int hashCode() {
        return this.passengerManager.hashCode();
    }

    public final Job registerPassenger(Function0<Unit> proceed) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfilePassengersRegisterViewModel$registerPassenger$1(this, proceed, null), 3, null);
        return launch$default;
    }

    public String toString() {
        return "ProfilePassengersRegisterViewModel(passengerManager=" + this.passengerManager + ")";
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0003\u0010\u0012¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/passengers/register/ProfilePassengersRegisterViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", "<init>", "(Z)V", "copy", "(Z)Ldk/molslinjen/ui/views/screens/profile/passengers/register/ProfilePassengersRegisterViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isLoading;

        public ViewState(boolean z5) {
            this.isLoading = z5;
        }

        public final ViewState copy(boolean isLoading) {
            return new ViewState(isLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ViewState) && this.isLoading == ((ViewState) other).isLoading;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isLoading);
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ")";
        }

        public /* synthetic */ ViewState(boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? false : z5);
        }
    }
}
