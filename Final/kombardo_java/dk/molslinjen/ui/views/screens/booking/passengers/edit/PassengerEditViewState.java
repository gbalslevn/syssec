package dk.molslinjen.ui.views.screens.booking.passengers.edit;

import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJF\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u0007\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\b\u0010\u001eR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001f\u0010\u001e¨\u0006 "}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/edit/PassengerEditViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "passenger", "Ldk/molslinjen/domain/model/account/UserPassenger;", "userPassenger", BuildConfig.FLAVOR, "isLoading", "isDeleteLoading", "showDeleteDialog", "<init>", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;Ldk/molslinjen/domain/model/account/UserPassenger;ZZZ)V", "copy", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;Ldk/molslinjen/domain/model/account/UserPassenger;ZZZ)Ldk/molslinjen/ui/views/screens/booking/passengers/edit/PassengerEditViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "getPassenger", "()Ldk/molslinjen/domain/model/booking/BookingPassenger;", "Ldk/molslinjen/domain/model/account/UserPassenger;", "getUserPassenger", "()Ldk/molslinjen/domain/model/account/UserPassenger;", "Z", "()Z", "getShowDeleteDialog", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PassengerEditViewState {
    private final boolean isDeleteLoading;
    private final boolean isLoading;
    private final BookingPassenger passenger;
    private final boolean showDeleteDialog;
    private final UserPassenger userPassenger;

    public PassengerEditViewState(BookingPassenger bookingPassenger, UserPassenger userPassenger, boolean z5, boolean z6, boolean z7) {
        this.passenger = bookingPassenger;
        this.userPassenger = userPassenger;
        this.isLoading = z5;
        this.isDeleteLoading = z6;
        this.showDeleteDialog = z7;
    }

    public static /* synthetic */ PassengerEditViewState copy$default(PassengerEditViewState passengerEditViewState, BookingPassenger bookingPassenger, UserPassenger userPassenger, boolean z5, boolean z6, boolean z7, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            bookingPassenger = passengerEditViewState.passenger;
        }
        if ((i5 & 2) != 0) {
            userPassenger = passengerEditViewState.userPassenger;
        }
        UserPassenger userPassenger2 = userPassenger;
        if ((i5 & 4) != 0) {
            z5 = passengerEditViewState.isLoading;
        }
        boolean z8 = z5;
        if ((i5 & 8) != 0) {
            z6 = passengerEditViewState.isDeleteLoading;
        }
        boolean z9 = z6;
        if ((i5 & 16) != 0) {
            z7 = passengerEditViewState.showDeleteDialog;
        }
        return passengerEditViewState.copy(bookingPassenger, userPassenger2, z8, z9, z7);
    }

    public final PassengerEditViewState copy(BookingPassenger passenger, UserPassenger userPassenger, boolean isLoading, boolean isDeleteLoading, boolean showDeleteDialog) {
        return new PassengerEditViewState(passenger, userPassenger, isLoading, isDeleteLoading, showDeleteDialog);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PassengerEditViewState)) {
            return false;
        }
        PassengerEditViewState passengerEditViewState = (PassengerEditViewState) other;
        return Intrinsics.areEqual(this.passenger, passengerEditViewState.passenger) && Intrinsics.areEqual(this.userPassenger, passengerEditViewState.userPassenger) && this.isLoading == passengerEditViewState.isLoading && this.isDeleteLoading == passengerEditViewState.isDeleteLoading && this.showDeleteDialog == passengerEditViewState.showDeleteDialog;
    }

    public final boolean getShowDeleteDialog() {
        return this.showDeleteDialog;
    }

    public final UserPassenger getUserPassenger() {
        return this.userPassenger;
    }

    public int hashCode() {
        BookingPassenger bookingPassenger = this.passenger;
        int hashCode = (bookingPassenger == null ? 0 : bookingPassenger.hashCode()) * 31;
        UserPassenger userPassenger = this.userPassenger;
        return ((((((hashCode + (userPassenger != null ? userPassenger.hashCode() : 0)) * 31) + Boolean.hashCode(this.isLoading)) * 31) + Boolean.hashCode(this.isDeleteLoading)) * 31) + Boolean.hashCode(this.showDeleteDialog);
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
        return "PassengerEditViewState(passenger=" + this.passenger + ", userPassenger=" + this.userPassenger + ", isLoading=" + this.isLoading + ", isDeleteLoading=" + this.isDeleteLoading + ", showDeleteDialog=" + this.showDeleteDialog + ")";
    }

    public /* synthetic */ PassengerEditViewState(BookingPassenger bookingPassenger, UserPassenger userPassenger, boolean z5, boolean z6, boolean z7, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : bookingPassenger, (i5 & 2) == 0 ? userPassenger : null, (i5 & 4) != 0 ? false : z5, (i5 & 8) != 0 ? false : z6, (i5 & 16) != 0 ? false : z7);
    }
}
