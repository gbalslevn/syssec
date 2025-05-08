package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.checkout.EarlyCheckInPassengerManager;
import dk.molslinjen.domain.managers.checkout.IPassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.passengers.IPassengerMergeHelper;
import dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.BookingPassengerInfo;
import dk.molslinjen.domain.model.booking.BookingTicket;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.config.AgeClassifications;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ5\u0010\u000e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010!\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001fH\u0096@¢\u0006\u0004\b!\u0010\"J\u0018\u0010$\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b$\u0010%J\u0018\u0010(\u001a\u00020\u00192\u0006\u0010'\u001a\u00020&H\u0096@¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010*R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010+R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010,R \u0010/\u001a\b\u0012\u0004\u0012\u00020.0-8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00065"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/EarlyCheckInPassengerManager;", "Ldk/molslinjen/domain/managers/checkout/IEarlyCheckInPassengerManager;", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "configurationManager", "Ldk/molslinjen/domain/managers/checkout/IPassengerSelectionHelper;", "passengerSelectionHelper", "Ldk/molslinjen/domain/managers/checkout/passengers/IPassengerMergeHelper;", "passengerMergeHelper", "<init>", "(Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;Ldk/molslinjen/domain/managers/checkout/IPassengerSelectionHelper;Ldk/molslinjen/domain/managers/checkout/passengers/IPassengerMergeHelper;)V", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "localPassengers", "Lkotlin/Pair;", "mergeWithEditingPassengers", "(Ljava/util/List;)Lkotlin/Pair;", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", "Ldk/molslinjen/domain/model/config/Transportation;", "transportation", "Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;", "calculatePassengerSelectionState", "(Ldk/molslinjen/domain/model/booking/PassengerInfo;Ldk/molslinjen/domain/model/config/Transportation;)Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;", "Ldk/molslinjen/domain/model/booking/Booking;", "booking", BuildConfig.FLAVOR, "load", "(Ldk/molslinjen/domain/model/booking/Booking;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "passenger", "toggleSelected", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;)V", BuildConfig.FLAVOR, "asSelected", "addPassenger", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatedPassenger", "updatePassenger", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "localPassengerId", "deletePassenger", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "Ldk/molslinjen/domain/managers/checkout/IPassengerSelectionHelper;", "Ldk/molslinjen/domain/managers/checkout/passengers/IPassengerMergeHelper;", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", "passengerState", "Lkotlinx/coroutines/flow/StateFlow;", "getPassengerState", "()Lkotlinx/coroutines/flow/StateFlow;", "lastLoadedBooking", "Ldk/molslinjen/domain/model/booking/Booking;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EarlyCheckInPassengerManager implements IEarlyCheckInPassengerManager {
    private final IConfigurationManager configurationManager;
    private Booking lastLoadedBooking;
    private final IPassengerMergeHelper passengerMergeHelper;
    private final IPassengerSelectionHelper passengerSelectionHelper;
    private final StateFlow<PassengerSelectionHelper.PassengerState> passengerState;

    public EarlyCheckInPassengerManager(IConfigurationManager configurationManager, IPassengerSelectionHelper passengerSelectionHelper, IPassengerMergeHelper passengerMergeHelper) {
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        Intrinsics.checkNotNullParameter(passengerSelectionHelper, "passengerSelectionHelper");
        Intrinsics.checkNotNullParameter(passengerMergeHelper, "passengerMergeHelper");
        this.configurationManager = configurationManager;
        this.passengerSelectionHelper = passengerSelectionHelper;
        this.passengerMergeHelper = passengerMergeHelper;
        this.passengerState = passengerSelectionHelper.getPassengerState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair load$lambda$0(EarlyCheckInPassengerManager earlyCheckInPassengerManager, List localPassengers, List list) {
        Intrinsics.checkNotNullParameter(localPassengers, "localPassengers");
        Intrinsics.checkNotNullParameter(list, "<unused var>");
        return earlyCheckInPassengerManager.mergeWithEditingPassengers(localPassengers);
    }

    private final Pair<List<BookingPassenger>, List<BookingPassenger>> mergeWithEditingPassengers(List<BookingPassenger> localPassengers) {
        List<BookingPassenger> emptyList;
        BookingTicket ticket;
        BookingPassengerInfo passengerInfo;
        IPassengerMergeHelper iPassengerMergeHelper = this.passengerMergeHelper;
        Booking booking = this.lastLoadedBooking;
        if (booking == null || (ticket = booking.getTicket()) == null || (passengerInfo = ticket.getPassengerInfo()) == null || (emptyList = passengerInfo.getPassengerData()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        return iPassengerMergeHelper.mergeWithEditingPassengers(true, emptyList, localPassengers);
    }

    @Override // dk.molslinjen.domain.managers.checkout.IEarlyCheckInPassengerManager
    public Object addPassenger(BookingPassenger bookingPassenger, boolean z5, Continuation<? super Unit> continuation) {
        Object addPassenger = this.passengerSelectionHelper.addPassenger(bookingPassenger, z5, continuation);
        return addPassenger == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? addPassenger : Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.managers.checkout.IEarlyCheckInPassengerManager
    public ISharedPassengerSelectionViewState calculatePassengerSelectionState(PassengerInfo passengerInfo, Transportation transportation) {
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(transportation, "transportation");
        return this.passengerSelectionHelper.calculatePassengerSelectionState(passengerInfo, transportation);
    }

    @Override // dk.molslinjen.domain.managers.checkout.IEarlyCheckInPassengerManager
    public Object deletePassenger(String str, Continuation<? super Unit> continuation) {
        Object deletePassenger = this.passengerSelectionHelper.deletePassenger(str, continuation);
        return deletePassenger == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? deletePassenger : Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.managers.checkout.IEarlyCheckInPassengerManager
    public StateFlow<PassengerSelectionHelper.PassengerState> getPassengerState() {
        return this.passengerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    @Override // dk.molslinjen.domain.managers.checkout.IEarlyCheckInPassengerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object load(Booking booking, Continuation<? super Unit> continuation) {
        EarlyCheckInPassengerManager$load$1 earlyCheckInPassengerManager$load$1;
        int i5;
        boolean isWalking;
        Object activeConfiguration;
        final EarlyCheckInPassengerManager earlyCheckInPassengerManager;
        PassengerInfo passengerInfo;
        Site site;
        IPassengerSelectionHelper iPassengerSelectionHelper;
        int i6;
        LocalizedSiteConfiguration localizedSiteConfiguration;
        AgeClassifications ageClassifications;
        Object obj;
        Booking booking2 = booking;
        if (continuation instanceof EarlyCheckInPassengerManager$load$1) {
            earlyCheckInPassengerManager$load$1 = (EarlyCheckInPassengerManager$load$1) continuation;
            int i7 = earlyCheckInPassengerManager$load$1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                earlyCheckInPassengerManager$load$1.label = i7 - Integer.MIN_VALUE;
                EarlyCheckInPassengerManager$load$1 earlyCheckInPassengerManager$load$12 = earlyCheckInPassengerManager$load$1;
                Object obj2 = earlyCheckInPassengerManager$load$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = earlyCheckInPassengerManager$load$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    this.lastLoadedBooking = booking2;
                    IPassengerSelectionHelper iPassengerSelectionHelper2 = this.passengerSelectionHelper;
                    Site site2 = booking.getSite();
                    isWalking = booking.getTicket().getTransport().isWalking();
                    PassengerInfo passengerInfo2 = booking.getTicket().getPassengerInfo().toPassengerInfo();
                    IConfigurationManager iConfigurationManager = this.configurationManager;
                    Site site3 = booking.getSite();
                    earlyCheckInPassengerManager$load$12.L$0 = this;
                    earlyCheckInPassengerManager$load$12.L$1 = booking2;
                    earlyCheckInPassengerManager$load$12.L$2 = iPassengerSelectionHelper2;
                    earlyCheckInPassengerManager$load$12.L$3 = site2;
                    earlyCheckInPassengerManager$load$12.L$4 = passengerInfo2;
                    earlyCheckInPassengerManager$load$12.Z$0 = isWalking;
                    earlyCheckInPassengerManager$load$12.I$0 = 0;
                    earlyCheckInPassengerManager$load$12.label = 1;
                    activeConfiguration = iConfigurationManager.getActiveConfiguration(site3, earlyCheckInPassengerManager$load$12);
                    if (activeConfiguration == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    earlyCheckInPassengerManager = this;
                    passengerInfo = passengerInfo2;
                    site = site2;
                    iPassengerSelectionHelper = iPassengerSelectionHelper2;
                    i6 = 0;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                        return Unit.INSTANCE;
                    }
                    int i8 = earlyCheckInPassengerManager$load$12.I$0;
                    boolean z5 = earlyCheckInPassengerManager$load$12.Z$0;
                    PassengerInfo passengerInfo3 = (PassengerInfo) earlyCheckInPassengerManager$load$12.L$4;
                    site = (Site) earlyCheckInPassengerManager$load$12.L$3;
                    IPassengerSelectionHelper iPassengerSelectionHelper3 = (IPassengerSelectionHelper) earlyCheckInPassengerManager$load$12.L$2;
                    Booking booking3 = (Booking) earlyCheckInPassengerManager$load$12.L$1;
                    earlyCheckInPassengerManager = (EarlyCheckInPassengerManager) earlyCheckInPassengerManager$load$12.L$0;
                    ResultKt.throwOnFailure(obj2);
                    i6 = i8;
                    booking2 = booking3;
                    passengerInfo = passengerInfo3;
                    isWalking = z5;
                    iPassengerSelectionHelper = iPassengerSelectionHelper3;
                    activeConfiguration = obj2;
                }
                localizedSiteConfiguration = (LocalizedSiteConfiguration) activeConfiguration;
                if (localizedSiteConfiguration != null || (ageClassifications = localizedSiteConfiguration.getAgeClassifications()) == null) {
                    return Unit.INSTANCE;
                }
                Function2 function2 = new Function2() { // from class: B1.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        Pair load$lambda$0;
                        load$lambda$0 = EarlyCheckInPassengerManager.load$lambda$0(EarlyCheckInPassengerManager.this, (List) obj3, (List) obj4);
                        return load$lambda$0;
                    }
                };
                DepartureDirection departureDirection = DepartureDirection.Outbound;
                Iterator<T> it = booking2.getTicket().getPassengerInfo().getPassengerData().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((BookingPassenger) obj).isCurrentUser()) {
                        break;
                    }
                }
                boolean z6 = i6 != 0;
                earlyCheckInPassengerManager$load$12.L$0 = null;
                earlyCheckInPassengerManager$load$12.L$1 = null;
                earlyCheckInPassengerManager$load$12.L$2 = null;
                earlyCheckInPassengerManager$load$12.L$3 = null;
                earlyCheckInPassengerManager$load$12.L$4 = null;
                earlyCheckInPassengerManager$load$12.label = 2;
                if (IPassengerSelectionHelper.DefaultImpls.loadPassengerState$default(iPassengerSelectionHelper, site, isWalking, passengerInfo, z6, ageClassifications, function2, false, null, departureDirection, (BookingPassenger) obj, earlyCheckInPassengerManager$load$12, 200, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        earlyCheckInPassengerManager$load$1 = new EarlyCheckInPassengerManager$load$1(this, continuation);
        EarlyCheckInPassengerManager$load$1 earlyCheckInPassengerManager$load$122 = earlyCheckInPassengerManager$load$1;
        Object obj22 = earlyCheckInPassengerManager$load$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = earlyCheckInPassengerManager$load$122.label;
        if (i5 != 0) {
        }
        localizedSiteConfiguration = (LocalizedSiteConfiguration) activeConfiguration;
        if (localizedSiteConfiguration != null) {
        }
        return Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.managers.checkout.IEarlyCheckInPassengerManager
    public void toggleSelected(BookingPassenger passenger) {
        Intrinsics.checkNotNullParameter(passenger, "passenger");
        this.passengerSelectionHelper.toggleSelected(passenger);
    }

    @Override // dk.molslinjen.domain.managers.checkout.IEarlyCheckInPassengerManager
    public Object updatePassenger(BookingPassenger bookingPassenger, Continuation<? super Unit> continuation) {
        Object updatePassenger = this.passengerSelectionHelper.updatePassenger(bookingPassenger, continuation);
        return updatePassenger == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updatePassenger : Unit.INSTANCE;
    }
}
