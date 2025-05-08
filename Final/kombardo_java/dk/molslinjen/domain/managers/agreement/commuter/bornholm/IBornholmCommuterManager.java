package dk.molslinjen.domain.managers.agreement.commuter.bornholm;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.agreement.commuter.CommuterDataState;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterAgreement;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterBooking;
import dk.molslinjen.domain.model.booking.BookingFromAlternateSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0017J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u000fJ*\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\rJ\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;", BuildConfig.FLAVOR, "state", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager$State;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "addAgreements", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "email", BuildConfig.FLAVOR, "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAgreements", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAgreementHistory", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterBooking;", "commuterId", "commuterAgreementId", "getAgreementBookingsAsAlternateSource", "Ldk/molslinjen/domain/model/booking/BookingFromAlternateSource;", "State", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IBornholmCommuterManager {
    Object addAgreements(String str, String str2, Continuation<? super ManagerResult<Unit>> continuation);

    List<BookingFromAlternateSource> getAgreementBookingsAsAlternateSource();

    Object getAgreementHistory(String str, String str2, Continuation<? super ManagerResult<? extends List<BornholmCommuterBooking>>> continuation);

    StateFlow<State> getState();

    Object loadAgreements(Continuation<? super Unit> continuation);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager$State;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/agreement/commuter/CommuterDataState;", "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;", "agreementsState", BuildConfig.FLAVOR, "hasLocalData", "<init>", "(Ldk/molslinjen/domain/managers/agreement/commuter/CommuterDataState;Ljava/lang/Boolean;)V", "copy", "(Ldk/molslinjen/domain/managers/agreement/commuter/CommuterDataState;Ljava/lang/Boolean;)Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager$State;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/managers/agreement/commuter/CommuterDataState;", "getAgreementsState", "()Ldk/molslinjen/domain/managers/agreement/commuter/CommuterDataState;", "Ljava/lang/Boolean;", "getHasLocalData", "()Ljava/lang/Boolean;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class State {
        private final CommuterDataState<BornholmCommuterAgreement> agreementsState;
        private final Boolean hasLocalData;

        public State(CommuterDataState<BornholmCommuterAgreement> agreementsState, Boolean bool) {
            Intrinsics.checkNotNullParameter(agreementsState, "agreementsState");
            this.agreementsState = agreementsState;
            this.hasLocalData = bool;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, CommuterDataState commuterDataState, Boolean bool, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                commuterDataState = state.agreementsState;
            }
            if ((i5 & 2) != 0) {
                bool = state.hasLocalData;
            }
            return state.copy(commuterDataState, bool);
        }

        public final State copy(CommuterDataState<BornholmCommuterAgreement> agreementsState, Boolean hasLocalData) {
            Intrinsics.checkNotNullParameter(agreementsState, "agreementsState");
            return new State(agreementsState, hasLocalData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.agreementsState, state.agreementsState) && Intrinsics.areEqual(this.hasLocalData, state.hasLocalData);
        }

        public final CommuterDataState<BornholmCommuterAgreement> getAgreementsState() {
            return this.agreementsState;
        }

        public final Boolean getHasLocalData() {
            return this.hasLocalData;
        }

        public int hashCode() {
            int hashCode = this.agreementsState.hashCode() * 31;
            Boolean bool = this.hasLocalData;
            return hashCode + (bool == null ? 0 : bool.hashCode());
        }

        public String toString() {
            return "State(agreementsState=" + this.agreementsState + ", hasLocalData=" + this.hasLocalData + ")";
        }

        public /* synthetic */ State(CommuterDataState commuterDataState, Boolean bool, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? CommuterDataState.Undetermined.INSTANCE : commuterDataState, (i5 & 2) != 0 ? null : bool);
        }
    }
}
