package dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.history;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/history/CommuterTicketHistoryScreenNavArgs;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "commuterId", "commuterAgreementId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCommuterId", "getCommuterAgreementId", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CommuterTicketHistoryScreenNavArgs {
    private final String commuterAgreementId;
    private final String commuterId;

    public CommuterTicketHistoryScreenNavArgs(String commuterId, String commuterAgreementId) {
        Intrinsics.checkNotNullParameter(commuterId, "commuterId");
        Intrinsics.checkNotNullParameter(commuterAgreementId, "commuterAgreementId");
        this.commuterId = commuterId;
        this.commuterAgreementId = commuterAgreementId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommuterTicketHistoryScreenNavArgs)) {
            return false;
        }
        CommuterTicketHistoryScreenNavArgs commuterTicketHistoryScreenNavArgs = (CommuterTicketHistoryScreenNavArgs) other;
        return Intrinsics.areEqual(this.commuterId, commuterTicketHistoryScreenNavArgs.commuterId) && Intrinsics.areEqual(this.commuterAgreementId, commuterTicketHistoryScreenNavArgs.commuterAgreementId);
    }

    public final String getCommuterAgreementId() {
        return this.commuterAgreementId;
    }

    public final String getCommuterId() {
        return this.commuterId;
    }

    public int hashCode() {
        return (this.commuterId.hashCode() * 31) + this.commuterAgreementId.hashCode();
    }

    public String toString() {
        return "CommuterTicketHistoryScreenNavArgs(commuterId=" + this.commuterId + ", commuterAgreementId=" + this.commuterAgreementId + ")";
    }
}
