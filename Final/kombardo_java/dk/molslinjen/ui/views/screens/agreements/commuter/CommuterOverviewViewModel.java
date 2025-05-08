package dk.molslinjen.ui.views.screens.agreements.commuter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager;
import dk.molslinjen.domain.managers.agreement.commuter.oeresund.IOeresundCommuterManager;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterAgreement;
import dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreement;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterOverviewViewModel;", "Landroidx/lifecycle/ViewModel;", "bornholmCommuterManager", "Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;", "oeresundCommuterManager", "Ldk/molslinjen/domain/managers/agreement/commuter/oeresund/IOeresundCommuterManager;", "<init>", "(Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;Ldk/molslinjen/domain/managers/agreement/commuter/oeresund/IOeresundCommuterManager;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterOverviewViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "listenForOeresundChanges", BuildConfig.FLAVOR, "listenForBornholmChanges", "reloadBornholmAgreements", "reloadOeresundAgreements", "reload", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CommuterOverviewViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IBornholmCommuterManager bornholmCommuterManager;
    private final IOeresundCommuterManager oeresundCommuterManager;

    public CommuterOverviewViewModel(IBornholmCommuterManager bornholmCommuterManager, IOeresundCommuterManager oeresundCommuterManager) {
        Intrinsics.checkNotNullParameter(bornholmCommuterManager, "bornholmCommuterManager");
        Intrinsics.checkNotNullParameter(oeresundCommuterManager, "oeresundCommuterManager");
        this.bornholmCommuterManager = bornholmCommuterManager;
        this.oeresundCommuterManager = oeresundCommuterManager;
        this._viewState = StateFlowKt.MutableStateFlow(new ViewState(false, null, false, false, null, false, 63, null));
        listenForOeresundChanges();
        listenForBornholmChanges();
        reload();
    }

    private final void listenForBornholmChanges() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new CommuterOverviewViewModel$listenForBornholmChanges$1(this, null), 2, null);
    }

    private final void listenForOeresundChanges() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new CommuterOverviewViewModel$listenForOeresundChanges$1(this, null), 2, null);
    }

    public final StateFlow<ViewState> getViewState() {
        return this._viewState;
    }

    public final void reload() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CommuterOverviewViewModel$reload$1(this, null), 3, null);
    }

    public final void reloadBornholmAgreements() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CommuterOverviewViewModel$reloadBornholmAgreements$1(this, null), 3, null);
    }

    public final void reloadOeresundAgreements() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CommuterOverviewViewModel$reloadOeresundAgreements$1(this, null), 3, null);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJX\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u0003\u0010\u001aR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001e\u0010\u001aR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\b\u0010\u001aR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b \u0010\u001a¨\u0006!"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterOverviewViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isBornholmLoading", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;", "bornholmAgreements", "hasBornholmError", "isOeresundLoading", "Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;", "oeresundAgreements", "hasOeresundError", "<init>", "(ZLjava/util/List;ZZLjava/util/List;Z)V", "copy", "(ZLjava/util/List;ZZLjava/util/List;Z)Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterOverviewViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ljava/util/List;", "getBornholmAgreements", "()Ljava/util/List;", "getHasBornholmError", "getOeresundAgreements", "getHasOeresundError", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final List<BornholmCommuterAgreement> bornholmAgreements;
        private final boolean hasBornholmError;
        private final boolean hasOeresundError;
        private final boolean isBornholmLoading;
        private final boolean isOeresundLoading;
        private final List<OeresundCommuterAgreement> oeresundAgreements;

        public ViewState(boolean z5, List<BornholmCommuterAgreement> bornholmAgreements, boolean z6, boolean z7, List<OeresundCommuterAgreement> oeresundAgreements, boolean z8) {
            Intrinsics.checkNotNullParameter(bornholmAgreements, "bornholmAgreements");
            Intrinsics.checkNotNullParameter(oeresundAgreements, "oeresundAgreements");
            this.isBornholmLoading = z5;
            this.bornholmAgreements = bornholmAgreements;
            this.hasBornholmError = z6;
            this.isOeresundLoading = z7;
            this.oeresundAgreements = oeresundAgreements;
            this.hasOeresundError = z8;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, List list, boolean z6, boolean z7, List list2, boolean z8, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isBornholmLoading;
            }
            if ((i5 & 2) != 0) {
                list = viewState.bornholmAgreements;
            }
            List list3 = list;
            if ((i5 & 4) != 0) {
                z6 = viewState.hasBornholmError;
            }
            boolean z9 = z6;
            if ((i5 & 8) != 0) {
                z7 = viewState.isOeresundLoading;
            }
            boolean z10 = z7;
            if ((i5 & 16) != 0) {
                list2 = viewState.oeresundAgreements;
            }
            List list4 = list2;
            if ((i5 & 32) != 0) {
                z8 = viewState.hasOeresundError;
            }
            return viewState.copy(z5, list3, z9, z10, list4, z8);
        }

        public final ViewState copy(boolean isBornholmLoading, List<BornholmCommuterAgreement> bornholmAgreements, boolean hasBornholmError, boolean isOeresundLoading, List<OeresundCommuterAgreement> oeresundAgreements, boolean hasOeresundError) {
            Intrinsics.checkNotNullParameter(bornholmAgreements, "bornholmAgreements");
            Intrinsics.checkNotNullParameter(oeresundAgreements, "oeresundAgreements");
            return new ViewState(isBornholmLoading, bornholmAgreements, hasBornholmError, isOeresundLoading, oeresundAgreements, hasOeresundError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isBornholmLoading == viewState.isBornholmLoading && Intrinsics.areEqual(this.bornholmAgreements, viewState.bornholmAgreements) && this.hasBornholmError == viewState.hasBornholmError && this.isOeresundLoading == viewState.isOeresundLoading && Intrinsics.areEqual(this.oeresundAgreements, viewState.oeresundAgreements) && this.hasOeresundError == viewState.hasOeresundError;
        }

        public final List<BornholmCommuterAgreement> getBornholmAgreements() {
            return this.bornholmAgreements;
        }

        public final boolean getHasBornholmError() {
            return this.hasBornholmError;
        }

        public final boolean getHasOeresundError() {
            return this.hasOeresundError;
        }

        public final List<OeresundCommuterAgreement> getOeresundAgreements() {
            return this.oeresundAgreements;
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.isBornholmLoading) * 31) + this.bornholmAgreements.hashCode()) * 31) + Boolean.hashCode(this.hasBornholmError)) * 31) + Boolean.hashCode(this.isOeresundLoading)) * 31) + this.oeresundAgreements.hashCode()) * 31) + Boolean.hashCode(this.hasOeresundError);
        }

        /* renamed from: isBornholmLoading, reason: from getter */
        public final boolean getIsBornholmLoading() {
            return this.isBornholmLoading;
        }

        /* renamed from: isOeresundLoading, reason: from getter */
        public final boolean getIsOeresundLoading() {
            return this.isOeresundLoading;
        }

        public String toString() {
            return "ViewState(isBornholmLoading=" + this.isBornholmLoading + ", bornholmAgreements=" + this.bornholmAgreements + ", hasBornholmError=" + this.hasBornholmError + ", isOeresundLoading=" + this.isOeresundLoading + ", oeresundAgreements=" + this.oeresundAgreements + ", hasOeresundError=" + this.hasOeresundError + ")";
        }

        public /* synthetic */ ViewState(boolean z5, List list, boolean z6, boolean z7, List list2, boolean z8, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? true : z5, (i5 & 2) != 0 ? CollectionsKt.emptyList() : list, (i5 & 4) != 0 ? false : z6, (i5 & 8) == 0 ? z7 : true, (i5 & 16) != 0 ? CollectionsKt.emptyList() : list2, (i5 & 32) != 0 ? false : z8);
        }
    }
}
