package dk.molslinjen.ui.views.screens.tickets.history;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.model.booking.BookingHeader;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/history/TicketHistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "ticketsManager", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "<init>", "(Ldk/molslinjen/domain/managers/ticket/ITicketsManager;Ldk/molslinjen/core/snackbar/ISnackbarService;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/tickets/history/TicketHistoryViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "pagingLock", "Ljava/util/concurrent/locks/ReentrantLock;", "loadTicketsForPage", BuildConfig.FLAVOR, "page", BuildConfig.FLAVOR, "ticketIndexShown", "index", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TicketHistoryViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final ReentrantLock pagingLock;
    private final ISnackbarService snackbarService;
    private final ITicketsManager ticketsManager;
    private final StateFlow<ViewState> viewState;

    public TicketHistoryViewModel(ITicketsManager ticketsManager, ISnackbarService snackbarService) {
        Intrinsics.checkNotNullParameter(ticketsManager, "ticketsManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        this.ticketsManager = ticketsManager;
        this.snackbarService = snackbarService;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, false, 0, 0, false, 31, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        this.pagingLock = new ReentrantLock();
        loadTicketsForPage(1);
    }

    private final void loadTicketsForPage(int page) {
        if (this.viewState.getValue().getPossibilityOfMorePagesAvailable()) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TicketHistoryViewModel$loadTicketsForPage$1(this, page, null), 3, null);
        }
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void ticketIndexShown(int index) {
        ViewState value;
        ViewState viewState;
        ReentrantLock reentrantLock = this.pagingLock;
        reentrantLock.lock();
        try {
            if (index >= (this.viewState.getValue().getPage() * this.viewState.getValue().getPageSize()) - 5) {
                MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
                do {
                    value = mutableStateFlow.getValue();
                    viewState = value;
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(viewState, null, false, viewState.getPage() + 1, 0, false, 27, null)));
                loadTicketsForPage(this.viewState.getValue().getPage());
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJH\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u0006\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0013R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001e\u0010\u0013R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001f\u0010\u001b¨\u0006 "}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/history/TicketHistoryViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingHeader;", "bookings", BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "page", "pageSize", "possibilityOfMorePagesAvailable", "<init>", "(Ljava/util/List;ZIIZ)V", "copy", "(Ljava/util/List;ZIIZ)Ldk/molslinjen/ui/views/screens/tickets/history/TicketHistoryViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getBookings", "()Ljava/util/List;", "Z", "()Z", "I", "getPage", "getPageSize", "getPossibilityOfMorePagesAvailable", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final List<BookingHeader> bookings;
        private final boolean isLoading;
        private final int page;
        private final int pageSize;
        private final boolean possibilityOfMorePagesAvailable;

        public ViewState(List<BookingHeader> bookings, boolean z5, int i5, int i6, boolean z6) {
            Intrinsics.checkNotNullParameter(bookings, "bookings");
            this.bookings = bookings;
            this.isLoading = z5;
            this.page = i5;
            this.pageSize = i6;
            this.possibilityOfMorePagesAvailable = z6;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, boolean z5, int i5, int i6, boolean z6, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                list = viewState.bookings;
            }
            if ((i7 & 2) != 0) {
                z5 = viewState.isLoading;
            }
            boolean z7 = z5;
            if ((i7 & 4) != 0) {
                i5 = viewState.page;
            }
            int i8 = i5;
            if ((i7 & 8) != 0) {
                i6 = viewState.pageSize;
            }
            int i9 = i6;
            if ((i7 & 16) != 0) {
                z6 = viewState.possibilityOfMorePagesAvailable;
            }
            return viewState.copy(list, z7, i8, i9, z6);
        }

        public final ViewState copy(List<BookingHeader> bookings, boolean isLoading, int page, int pageSize, boolean possibilityOfMorePagesAvailable) {
            Intrinsics.checkNotNullParameter(bookings, "bookings");
            return new ViewState(bookings, isLoading, page, pageSize, possibilityOfMorePagesAvailable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.bookings, viewState.bookings) && this.isLoading == viewState.isLoading && this.page == viewState.page && this.pageSize == viewState.pageSize && this.possibilityOfMorePagesAvailable == viewState.possibilityOfMorePagesAvailable;
        }

        public final List<BookingHeader> getBookings() {
            return this.bookings;
        }

        public final int getPage() {
            return this.page;
        }

        public final int getPageSize() {
            return this.pageSize;
        }

        public final boolean getPossibilityOfMorePagesAvailable() {
            return this.possibilityOfMorePagesAvailable;
        }

        public int hashCode() {
            return (((((((this.bookings.hashCode() * 31) + Boolean.hashCode(this.isLoading)) * 31) + Integer.hashCode(this.page)) * 31) + Integer.hashCode(this.pageSize)) * 31) + Boolean.hashCode(this.possibilityOfMorePagesAvailable);
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(bookings=" + this.bookings + ", isLoading=" + this.isLoading + ", page=" + this.page + ", pageSize=" + this.pageSize + ", possibilityOfMorePagesAvailable=" + this.possibilityOfMorePagesAvailable + ")";
        }

        public /* synthetic */ ViewState(List list, boolean z5, int i5, int i6, boolean z6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
            this((i7 & 1) != 0 ? CollectionsKt.emptyList() : list, (i7 & 2) != 0 ? true : z5, (i7 & 4) != 0 ? 1 : i5, (i7 & 8) != 0 ? 10 : i6, (i7 & 16) == 0 ? z6 : true);
        }
    }
}
