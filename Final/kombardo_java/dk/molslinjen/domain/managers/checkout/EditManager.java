package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.checkout.passengers.IPassengerMergeHelper;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.BookingPassengerInfo;
import dk.molslinjen.domain.model.booking.BookingTicket;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001dB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J<\u0010\u0015\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/EditManager;", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "passengerMergeHelper", "Ldk/molslinjen/domain/managers/checkout/passengers/IPassengerMergeHelper;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/checkout/passengers/IPassengerMergeHelper;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "editState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;", "getEditState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "startEdit", BuildConfig.FLAVOR, "booking", "Ldk/molslinjen/domain/model/booking/Booking;", "mergeWithEditingPassengers", "Lkotlin/Pair;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "localPassengers", "previouslySelectedPassengers", "stopEdit", "clear", "EditState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditManager implements IEditManager {
    private final IAnalyticsTracker analyticsTracker;
    private final CoroutineScope coroutineScope;
    private final MutableStateFlow<EditState> editState;
    private final IPassengerMergeHelper passengerMergeHelper;
    private final IRouteManager routeManager;

    public EditManager(IRouteManager routeManager, IPassengerMergeHelper passengerMergeHelper, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(passengerMergeHelper, "passengerMergeHelper");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.routeManager = routeManager;
        this.passengerMergeHelper = passengerMergeHelper;
        this.analyticsTracker = analyticsTracker;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.editState = StateFlowKt.MutableStateFlow(new EditState(null, null, null, false, 15, null));
    }

    @Override // dk.molslinjen.domain.managers.checkout.IEditManager
    public void clear() {
        MutableStateFlow<EditState> editState = getEditState();
        do {
        } while (!editState.compareAndSet(editState.getValue(), new EditState(null, null, null, false, 15, null)));
    }

    @Override // dk.molslinjen.domain.managers.checkout.IEditManager
    public Pair<List<BookingPassenger>, List<BookingPassenger>> mergeWithEditingPassengers(List<BookingPassenger> localPassengers, List<BookingPassenger> previouslySelectedPassengers) {
        List<BookingPassenger> emptyList;
        BookingTicket ticket;
        BookingPassengerInfo passengerInfo;
        Intrinsics.checkNotNullParameter(localPassengers, "localPassengers");
        Intrinsics.checkNotNullParameter(previouslySelectedPassengers, "previouslySelectedPassengers");
        IPassengerMergeHelper iPassengerMergeHelper = this.passengerMergeHelper;
        boolean isEditing = getEditState().getValue().getIsEditing();
        Booking booking = getEditState().getValue().getBooking();
        if (booking == null || (ticket = booking.getTicket()) == null || (passengerInfo = ticket.getPassengerInfo()) == null || (emptyList = passengerInfo.getPassengerData()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        return iPassengerMergeHelper.mergeWithEditingPassengers(isEditing, emptyList, localPassengers);
    }

    @Override // dk.molslinjen.domain.managers.checkout.IEditManager
    public void startEdit(Booking booking) {
        EditState value;
        Intrinsics.checkNotNullParameter(booking, "booking");
        MutableStateFlow<EditState> editState = getEditState();
        do {
            value = editState.getValue();
        } while (!editState.compareAndSet(value, value.copy(booking.getReservationNumber(), booking.getCustomerInfo().getPhoneNumber().getNationalNumber(), booking, true)));
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new EditManager$startEdit$2(this, booking, null), 3, null);
        this.analyticsTracker.trackEvent(AnalyticsEvent.StartEditTicketEvent.INSTANCE);
    }

    @Override // dk.molslinjen.domain.managers.checkout.IEditManager
    public void stopEdit() {
        this.analyticsTracker.trackEvent(AnalyticsEvent.CancelledEditTicketEvent.INSTANCE);
        clear();
        this.routeManager.reload();
    }

    @Override // dk.molslinjen.domain.managers.checkout.IEditManager
    public MutableStateFlow<EditState> getEditState() {
        return this.editState;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ>\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u000eR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\u000eR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\b\u0010\u001c¨\u0006\u001d"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "editingReservationNumber", "editingPhoneNumber", "Ldk/molslinjen/domain/model/booking/Booking;", "booking", BuildConfig.FLAVOR, "isEditing", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/Booking;Z)V", "copy", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/Booking;Z)Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEditingReservationNumber", "getEditingPhoneNumber", "Ldk/molslinjen/domain/model/booking/Booking;", "getBooking", "()Ldk/molslinjen/domain/model/booking/Booking;", "Z", "()Z", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class EditState {
        private final Booking booking;
        private final String editingPhoneNumber;
        private final String editingReservationNumber;
        private final boolean isEditing;

        public EditState(String str, String str2, Booking booking, boolean z5) {
            this.editingReservationNumber = str;
            this.editingPhoneNumber = str2;
            this.booking = booking;
            this.isEditing = z5;
        }

        public final EditState copy(String editingReservationNumber, String editingPhoneNumber, Booking booking, boolean isEditing) {
            return new EditState(editingReservationNumber, editingPhoneNumber, booking, isEditing);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EditState)) {
                return false;
            }
            EditState editState = (EditState) other;
            return Intrinsics.areEqual(this.editingReservationNumber, editState.editingReservationNumber) && Intrinsics.areEqual(this.editingPhoneNumber, editState.editingPhoneNumber) && Intrinsics.areEqual(this.booking, editState.booking) && this.isEditing == editState.isEditing;
        }

        public final Booking getBooking() {
            return this.booking;
        }

        public final String getEditingPhoneNumber() {
            return this.editingPhoneNumber;
        }

        public final String getEditingReservationNumber() {
            return this.editingReservationNumber;
        }

        public int hashCode() {
            String str = this.editingReservationNumber;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.editingPhoneNumber;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Booking booking = this.booking;
            return ((hashCode2 + (booking != null ? booking.hashCode() : 0)) * 31) + Boolean.hashCode(this.isEditing);
        }

        /* renamed from: isEditing, reason: from getter */
        public final boolean getIsEditing() {
            return this.isEditing;
        }

        public String toString() {
            return "EditState(editingReservationNumber=" + this.editingReservationNumber + ", editingPhoneNumber=" + this.editingPhoneNumber + ", booking=" + this.booking + ", isEditing=" + this.isEditing + ")";
        }

        public /* synthetic */ EditState(String str, String str2, Booking booking, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : str, (i5 & 2) != 0 ? null : str2, (i5 & 4) != 0 ? null : booking, (i5 & 8) != 0 ? false : z5);
        }
    }
}
