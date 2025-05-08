package dk.molslinjen.domain.managers.agreement.multiride;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.merge.IAssetsMerger;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideAssociatedVehicle;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideBookingTicket;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.domain.model.booking.BookingFromAlternateSource;
import dk.molslinjen.domain.model.config.Site;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001#J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H¦@¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H¦@¢\u0006\u0004\b\t\u0010\nJ$\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H¦@¢\u0006\u0004\b\r\u0010\u000eJ.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H¦@¢\u0006\u0004\b\u0012\u0010\u0013J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H¦@¢\u0006\u0004\b\u0014\u0010\nJ$\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000b0\u00022\u0006\u0010\u000f\u001a\u00020\u0006H¦@¢\u0006\u0004\b\u0016\u0010\u000eJ\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000bH¦@¢\u0006\u0004\b\u0018\u0010\u0005J&\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H¦@¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;", "Ldk/molslinjen/domain/managers/user/merge/IAssetsMerger;", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "loadMultiRides", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "multiRideCardId", "email", "addMultiRide", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideAssociatedVehicle;", "getVehiclesForMultiRideCard", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "multiRideId", "licensePlate", "vehicleName", "associateVehicle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeVehicleAssociation", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideBookingTicket;", "getActiveTickets", "Ldk/molslinjen/domain/model/booking/BookingFromAlternateSource;", "getAgreementBookingsAsAlternateSource", "Ldk/molslinjen/domain/model/config/Site;", "site", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "getMultiRide", "(Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager$MultiRideManagerState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "state", "MultiRideManagerState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IMultiRideManager extends IAssetsMerger {
    Object addMultiRide(String str, String str2, Continuation<? super ManagerResult<Unit>> continuation);

    Object associateVehicle(String str, String str2, String str3, Continuation<? super ManagerResult<Unit>> continuation);

    Object getActiveTickets(String str, Continuation<? super ManagerResult<? extends List<MultiRideBookingTicket>>> continuation);

    Object getAgreementBookingsAsAlternateSource(Continuation<? super List<BookingFromAlternateSource>> continuation);

    Object getMultiRide(String str, Site site, Continuation<? super ManagerResult<MultiRideCard>> continuation);

    StateFlow<MultiRideManagerState> getState();

    Object getVehiclesForMultiRideCard(String str, Continuation<? super ManagerResult<? extends List<MultiRideAssociatedVehicle>>> continuation);

    Object loadMultiRides(Continuation<? super ManagerResult<Unit>> continuation);

    Object removeVehicleAssociation(String str, String str2, Continuation<? super ManagerResult<Unit>> continuation);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager$MultiRideManagerState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "multiRideCards", BuildConfig.FLAVOR, "hasLocalData", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;)V", "copy", "(Ljava/util/List;Ljava/lang/Boolean;)Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager$MultiRideManagerState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getMultiRideCards", "()Ljava/util/List;", "Ljava/lang/Boolean;", "getHasLocalData", "()Ljava/lang/Boolean;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class MultiRideManagerState {
        private final Boolean hasLocalData;
        private final List<MultiRideCard> multiRideCards;

        public MultiRideManagerState(List<MultiRideCard> multiRideCards, Boolean bool) {
            Intrinsics.checkNotNullParameter(multiRideCards, "multiRideCards");
            this.multiRideCards = multiRideCards;
            this.hasLocalData = bool;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MultiRideManagerState copy$default(MultiRideManagerState multiRideManagerState, List list, Boolean bool, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                list = multiRideManagerState.multiRideCards;
            }
            if ((i5 & 2) != 0) {
                bool = multiRideManagerState.hasLocalData;
            }
            return multiRideManagerState.copy(list, bool);
        }

        public final MultiRideManagerState copy(List<MultiRideCard> multiRideCards, Boolean hasLocalData) {
            Intrinsics.checkNotNullParameter(multiRideCards, "multiRideCards");
            return new MultiRideManagerState(multiRideCards, hasLocalData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MultiRideManagerState)) {
                return false;
            }
            MultiRideManagerState multiRideManagerState = (MultiRideManagerState) other;
            return Intrinsics.areEqual(this.multiRideCards, multiRideManagerState.multiRideCards) && Intrinsics.areEqual(this.hasLocalData, multiRideManagerState.hasLocalData);
        }

        public final Boolean getHasLocalData() {
            return this.hasLocalData;
        }

        public final List<MultiRideCard> getMultiRideCards() {
            return this.multiRideCards;
        }

        public int hashCode() {
            int hashCode = this.multiRideCards.hashCode() * 31;
            Boolean bool = this.hasLocalData;
            return hashCode + (bool == null ? 0 : bool.hashCode());
        }

        public String toString() {
            return "MultiRideManagerState(multiRideCards=" + this.multiRideCards + ", hasLocalData=" + this.hasLocalData + ")";
        }

        public /* synthetic */ MultiRideManagerState(List list, Boolean bool, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? CollectionsKt.emptyList() : list, (i5 & 2) != 0 ? null : bool);
        }
    }
}
