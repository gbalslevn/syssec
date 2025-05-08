package dk.molslinjen.ui.views.screens.booking.passengers.create;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInPassengerCreateScreenDestination;
import dk.molslinjen.domain.managers.checkout.IEarlyCheckInPassengerManager;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.PassengerInputHandler;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0016J\u001a\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0096\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0096\u0001¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010%R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010&R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R \u00100\u001a\b\u0012\u0004\u0012\u00020,0/8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020:0/8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b;\u00103¨\u0006="}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/create/EarlyCheckInPassengerCreateViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;", "passengerManager", "Ldk/molslinjen/domain/managers/checkout/IEarlyCheckInPassengerManager;", "earlyCheckInPassengerManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "configurationManager", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "<init>", "(Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;Ldk/molslinjen/domain/managers/checkout/IEarlyCheckInPassengerManager;Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;Landroidx/lifecycle/SavedStateHandle;)V", "Lkotlin/Function0;", BuildConfig.FLAVOR, "proceed", "registerPassenger", "(Lkotlin/jvm/functions/Function0;)V", BuildConfig.FLAVOR, "firstName", "updateFirstName", "(Ljava/lang/String;)V", "lastName", "updateLastName", "Ldk/molslinjen/domain/model/account/Gender;", "gender", "updateGender", "(Ldk/molslinjen/domain/model/account/Gender;)V", "Lorg/threeten/bp/LocalDate;", "birthdate", "updateBirthDate", "(Lorg/threeten/bp/LocalDate;)V", "Ljava/util/Locale;", "nationality", "updateNationality", "(Ljava/util/Locale;)V", "Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;", "Ldk/molslinjen/domain/managers/checkout/IEarlyCheckInPassengerManager;", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "Ldk/molslinjen/ui/views/screens/booking/passengers/create/EarlyCheckInPassengerCreateScreenNavArgs;", "navArgs", "Ldk/molslinjen/ui/views/screens/booking/passengers/create/EarlyCheckInPassengerCreateScreenNavArgs;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/passengers/create/PassengerCreateViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", BuildConfig.FLAVOR, "selectAfterCreation", "Z", "Ldk/molslinjen/domain/model/config/Site;", "site", "Ldk/molslinjen/domain/model/config/Site;", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler$InputState;", "getPassengerInput", "passengerInput", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EarlyCheckInPassengerCreateViewModel extends ViewModel implements IPassengerInputHandler {
    private final /* synthetic */ PassengerInputHandler $$delegate_0;
    private final MutableStateFlow<PassengerCreateViewState> _viewState;
    private final IConfigurationManager configurationManager;
    private final IEarlyCheckInPassengerManager earlyCheckInPassengerManager;
    private final EarlyCheckInPassengerCreateScreenNavArgs navArgs;
    private final IUserPassengerManager passengerManager;
    private final boolean selectAfterCreation;
    private final Site site;
    private final StateFlow<PassengerCreateViewState> viewState;

    public EarlyCheckInPassengerCreateViewModel(IUserPassengerManager passengerManager, IEarlyCheckInPassengerManager earlyCheckInPassengerManager, IConfigurationManager configurationManager, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(passengerManager, "passengerManager");
        Intrinsics.checkNotNullParameter(earlyCheckInPassengerManager, "earlyCheckInPassengerManager");
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.$$delegate_0 = new PassengerInputHandler();
        this.passengerManager = passengerManager;
        this.earlyCheckInPassengerManager = earlyCheckInPassengerManager;
        this.configurationManager = configurationManager;
        EarlyCheckInPassengerCreateScreenNavArgs argsFrom = EarlyCheckInPassengerCreateScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        MutableStateFlow<PassengerCreateViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new PassengerCreateViewState(false, 1, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        this.selectAfterCreation = argsFrom.getSelectAfterCreation();
        this.site = argsFrom.getSite();
    }

    @Override // dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler
    public StateFlow<IPassengerInputHandler.InputState> getPassengerInput() {
        return this.$$delegate_0.getPassengerInput();
    }

    public StateFlow<PassengerCreateViewState> getViewState() {
        return this.viewState;
    }

    public void registerPassenger(Function0<Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new EarlyCheckInPassengerCreateViewModel$registerPassenger$1(this, proceed, null), 3, null);
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
}
