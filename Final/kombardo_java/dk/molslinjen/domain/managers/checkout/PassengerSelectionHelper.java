package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.checkout.passengers.DefaultPassengerSelectionViewState;
import dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState;
import dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.domain.model.booking.AgeGroup;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.config.AgeClassifications;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00017B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ¢\u0001\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122>\u0010\u0018\u001a:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0017\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00020\u000f2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016H\u0096@¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\"\u0010#J \u0010%\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b%\u0010&J\u0018\u0010(\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0016H\u0096@¢\u0006\u0004\b(\u0010)J\u0018\u0010,\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020*H\u0096@¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u001eH\u0016¢\u0006\u0004\b.\u0010/R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00100R \u00103\u001a\b\u0012\u0004\u0012\u000202018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106¨\u00068"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper;", "Ldk/molslinjen/domain/managers/checkout/IPassengerSelectionHelper;", "Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;", "userPassengerManager", "<init>", "(Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;)V", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", "Ldk/molslinjen/domain/model/config/Transportation;", "transportation", "Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;", "calculatePassengerSelectionState", "(Ldk/molslinjen/domain/model/booking/PassengerInfo;Ldk/molslinjen/domain/model/config/Transportation;)Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;", "Ldk/molslinjen/domain/model/config/Site;", "site", BuildConfig.FLAVOR, "showAgeGroup", "onlySelectMe", "Ldk/molslinjen/domain/model/config/AgeClassifications;", "ageClassifications", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "Lkotlin/Pair;", "mergeWithPassengers", "enforceCurrentUserSelected", "enforceSelectedPassengers", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "departureDirection", "currentUserFallback", BuildConfig.FLAVOR, "loadPassengerState", "(Ldk/molslinjen/domain/model/config/Site;ZLdk/molslinjen/domain/model/booking/PassengerInfo;ZLdk/molslinjen/domain/model/config/AgeClassifications;Lkotlin/jvm/functions/Function2;ZLjava/util/List;Ldk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/domain/model/booking/BookingPassenger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "passenger", "toggleSelected", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;)V", "asSelected", "addPassenger", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatedPassenger", "updatePassenger", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "localPassengerId", "deletePassenger", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "()V", "Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", "passengerState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getPassengerState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "PassengerState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PassengerSelectionHelper implements IPassengerSelectionHelper {
    private final MutableStateFlow<PassengerState> passengerState;
    private final IUserPassengerManager userPassengerManager;

    public PassengerSelectionHelper(IUserPassengerManager userPassengerManager) {
        Intrinsics.checkNotNullParameter(userPassengerManager, "userPassengerManager");
        this.userPassengerManager = userPassengerManager;
        this.passengerState = StateFlowKt.MutableStateFlow(new PassengerState(false, null, null, null, 15, null));
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPassengerSelectionHelper
    public Object addPassenger(BookingPassenger bookingPassenger, boolean z5, Continuation<? super Unit> continuation) {
        PassengerState value;
        PassengerState copy$default;
        MutableStateFlow<PassengerState> passengerState = getPassengerState();
        do {
            value = passengerState.getValue();
            PassengerState passengerState2 = value;
            if (bookingPassenger.isCurrentUser()) {
                copy$default = PassengerState.copy$default(passengerState2, z5, bookingPassenger, null, null, 12, null);
            } else {
                copy$default = PassengerState.copy$default(passengerState2, false, null, CollectionsKt.sortedWith(CollectionsKt.plus((Collection<? extends BookingPassenger>) passengerState2.getPassengers(), bookingPassenger), new Comparator() { // from class: dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper$addPassenger$lambda$19$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t5, T t6) {
                        String firstName = ((BookingPassenger) t5).getFirstName();
                        Locale locale = Locale.ROOT;
                        String lowerCase = firstName.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = ((BookingPassenger) t6).getFirstName().toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                    }
                }), z5 ? CollectionsKt.sortedWith(CollectionsKt.plus((Collection<? extends BookingPassenger>) passengerState2.getSelectedPassengers(), bookingPassenger), new Comparator() { // from class: dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper$addPassenger$lambda$19$$inlined$sortedBy$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t5, T t6) {
                        String firstName = ((BookingPassenger) t5).getFirstName();
                        Locale locale = Locale.ROOT;
                        String lowerCase = firstName.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = ((BookingPassenger) t6).getFirstName().toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                    }
                }) : passengerState2.getSelectedPassengers(), 3, null);
            }
        } while (!passengerState.compareAndSet(value, copy$default));
        return Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPassengerSelectionHelper
    public ISharedPassengerSelectionViewState calculatePassengerSelectionState(PassengerInfo passengerInfo, Transportation transportation) {
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(transportation, "transportation");
        boolean isWalking = transportation.isWalking();
        PassengerState value = getPassengerState().getValue();
        List<BookingPassenger> selectedPassengers = (!value.getCurrentUserSelected() || value.getCurrentUser() == null) ? value.getSelectedPassengers() : CollectionsKt.plus((Collection<? extends BookingPassenger>) value.getSelectedPassengers(), value.getCurrentUser());
        List<BookingPassenger> list = selectedPassengers;
        boolean z5 = list instanceof Collection;
        int i7 = 0;
        if (z5 && list.isEmpty()) {
            i5 = 0;
        } else {
            Iterator<T> it = list.iterator();
            i5 = 0;
            while (it.hasNext()) {
                if (((BookingPassenger) it.next()).getAgeGroup() == AgeGroup.Adult && (i5 = i5 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (z5 && list.isEmpty()) {
            i6 = 0;
        } else {
            Iterator<T> it2 = list.iterator();
            i6 = 0;
            while (it2.hasNext()) {
                if (((BookingPassenger) it2.next()).getAgeGroup() == AgeGroup.Child && (i6 = i6 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (!z5 || !list.isEmpty()) {
            Iterator<T> it3 = list.iterator();
            while (it3.hasNext()) {
                if (((BookingPassenger) it3.next()).getAgeGroup() == AgeGroup.Infant && (i7 = i7 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        int size = selectedPassengers.size();
        return new DefaultPassengerSelectionViewState((isWalking ? passengerInfo.getTotalPassengerCount() : transportation.getMaxPassengers()) - size, passengerInfo.getAdultCount() - i5, passengerInfo.getChildCount() - i6, passengerInfo.getInfantCount() - i7, size, isWalking);
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPassengerSelectionHelper
    public void clear() {
        MutableStateFlow<PassengerState> passengerState = getPassengerState();
        do {
        } while (!passengerState.compareAndSet(passengerState.getValue(), new PassengerState(false, null, null, null, 15, null)));
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPassengerSelectionHelper
    public Object deletePassenger(String str, Continuation<? super Unit> continuation) {
        PassengerState value;
        PassengerState passengerState;
        ArrayList arrayList;
        ArrayList arrayList2;
        MutableStateFlow<PassengerState> passengerState2 = getPassengerState();
        do {
            value = passengerState2.getValue();
            passengerState = value;
            List<BookingPassenger> passengers = passengerState.getPassengers();
            arrayList = new ArrayList();
            for (Object obj : passengers) {
                if (!Intrinsics.areEqual(((BookingPassenger) obj).getLocalId(), str)) {
                    arrayList.add(obj);
                }
            }
            List<BookingPassenger> selectedPassengers = passengerState.getSelectedPassengers();
            arrayList2 = new ArrayList();
            for (Object obj2 : selectedPassengers) {
                if (!Intrinsics.areEqual(((BookingPassenger) obj2).getLocalId(), str)) {
                    arrayList2.add(obj2);
                }
            }
        } while (!passengerState2.compareAndSet(value, PassengerState.copy$default(passengerState, false, null, arrayList, arrayList2, 3, null)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0125 A[LOOP:0: B:11:0x011f->B:13:0x0125, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016d A[SYNTHETIC] */
    @Override // dk.molslinjen.domain.managers.checkout.IPassengerSelectionHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadPassengerState(Site site, boolean z5, PassengerInfo passengerInfo, boolean z6, AgeClassifications ageClassifications, Function2<? super List<BookingPassenger>, ? super List<BookingPassenger>, ? extends Pair<? extends List<BookingPassenger>, ? extends List<BookingPassenger>>> function2, boolean z7, List<BookingPassenger> list, DepartureDirection departureDirection, BookingPassenger bookingPassenger, Continuation<? super Unit> continuation) {
        PassengerSelectionHelper$loadPassengerState$1 passengerSelectionHelper$loadPassengerState$1;
        int i5;
        BookingPassenger currentUser;
        List<BookingPassenger> plus;
        PassengerState value;
        PassengerInfo passengerInfo2;
        AgeClassifications ageClassifications2;
        Function2<? super List<BookingPassenger>, ? super List<BookingPassenger>, ? extends Pair<? extends List<BookingPassenger>, ? extends List<BookingPassenger>>> function22;
        List list2;
        PassengerSelectionHelper passengerSelectionHelper;
        boolean z8;
        boolean z9;
        ArrayList arrayList;
        Iterator<T> it;
        List list3;
        List list4;
        Iterator it2;
        Object obj;
        BookingPassenger bookingPassenger2;
        boolean z10;
        List list5;
        MutableStateFlow<PassengerState> passengerState;
        PassengerState value2;
        PassengerState passengerState2;
        List<BookingPassenger> sortedWith;
        ArrayList arrayList2;
        boolean z11 = z7;
        if (continuation instanceof PassengerSelectionHelper$loadPassengerState$1) {
            passengerSelectionHelper$loadPassengerState$1 = (PassengerSelectionHelper$loadPassengerState$1) continuation;
            int i6 = passengerSelectionHelper$loadPassengerState$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                passengerSelectionHelper$loadPassengerState$1.label = i6 - Integer.MIN_VALUE;
                Object obj2 = passengerSelectionHelper$loadPassengerState$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = passengerSelectionHelper$loadPassengerState$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    currentUser = getPassengerState().getValue().getCurrentUser();
                    if (currentUser == null) {
                        currentUser = bookingPassenger;
                    }
                    plus = ((z11 || getPassengerState().getValue().getCurrentUserSelected()) && currentUser != null) ? CollectionsKt.plus((Collection<? extends BookingPassenger>) getPassengerState().getValue().getSelectedPassengers(), currentUser) : getPassengerState().getValue().getSelectedPassengers();
                    MutableStateFlow<PassengerState> passengerState3 = getPassengerState();
                    do {
                        value = passengerState3.getValue();
                    } while (!passengerState3.compareAndSet(value, PassengerState.copy$default(value, false, null, CollectionsKt.emptyList(), CollectionsKt.emptyList(), 3, null)));
                    IUserPassengerManager iUserPassengerManager = this.userPassengerManager;
                    passengerSelectionHelper$loadPassengerState$1.L$0 = this;
                    passengerInfo2 = passengerInfo;
                    passengerSelectionHelper$loadPassengerState$1.L$1 = passengerInfo2;
                    ageClassifications2 = ageClassifications;
                    passengerSelectionHelper$loadPassengerState$1.L$2 = ageClassifications2;
                    function22 = function2;
                    passengerSelectionHelper$loadPassengerState$1.L$3 = function22;
                    list2 = list;
                    passengerSelectionHelper$loadPassengerState$1.L$4 = list2;
                    passengerSelectionHelper$loadPassengerState$1.L$5 = currentUser;
                    passengerSelectionHelper$loadPassengerState$1.L$6 = plus;
                    passengerSelectionHelper$loadPassengerState$1.Z$0 = z5;
                    passengerSelectionHelper$loadPassengerState$1.Z$1 = z6;
                    passengerSelectionHelper$loadPassengerState$1.Z$2 = z11;
                    passengerSelectionHelper$loadPassengerState$1.label = 1;
                    if (iUserPassengerManager.loadPassengers(passengerSelectionHelper$loadPassengerState$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    passengerSelectionHelper = this;
                    z8 = z5;
                    z9 = z6;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z11 = passengerSelectionHelper$loadPassengerState$1.Z$2;
                    z9 = passengerSelectionHelper$loadPassengerState$1.Z$1;
                    z8 = passengerSelectionHelper$loadPassengerState$1.Z$0;
                    plus = (List) passengerSelectionHelper$loadPassengerState$1.L$6;
                    BookingPassenger bookingPassenger3 = (BookingPassenger) passengerSelectionHelper$loadPassengerState$1.L$5;
                    List list6 = (List) passengerSelectionHelper$loadPassengerState$1.L$4;
                    function22 = (Function2) passengerSelectionHelper$loadPassengerState$1.L$3;
                    AgeClassifications ageClassifications3 = (AgeClassifications) passengerSelectionHelper$loadPassengerState$1.L$2;
                    PassengerInfo passengerInfo3 = (PassengerInfo) passengerSelectionHelper$loadPassengerState$1.L$1;
                    passengerSelectionHelper = (PassengerSelectionHelper) passengerSelectionHelper$loadPassengerState$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    currentUser = bookingPassenger3;
                    passengerInfo2 = passengerInfo3;
                    list2 = list6;
                    ageClassifications2 = ageClassifications3;
                }
                List<UserPassenger> passengers = passengerSelectionHelper.userPassengerManager.getPassengersState().getValue().getPassengers();
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(passengers, 10));
                it = passengers.iterator();
                while (it.hasNext()) {
                    arrayList.add(new BookingPassenger((UserPassenger) it.next(), ageClassifications2));
                }
                if (function22 != null || (r7 = function22.invoke(arrayList, plus)) == null) {
                    Pair<? extends List<BookingPassenger>, ? extends List<BookingPassenger>> pair = TuplesKt.to(arrayList, CollectionsKt.emptyList());
                }
                List list7 = (List) pair.component1();
                list3 = (List) pair.component2();
                list4 = list7;
                it2 = list4.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (((BookingPassenger) obj).isCurrentUser()) {
                        break;
                    }
                }
                BookingPassenger bookingPassenger4 = (BookingPassenger) obj;
                bookingPassenger2 = bookingPassenger4 != null ? currentUser : bookingPassenger4;
                if (!z9 && !z11) {
                    if (list3.isEmpty()) {
                        List list8 = list3;
                        if (!(list8 instanceof Collection) || !list8.isEmpty()) {
                            Iterator it3 = list8.iterator();
                            while (it3.hasNext()) {
                                if (((BookingPassenger) it3.next()).isCurrentUser()) {
                                }
                            }
                        }
                        z10 = false;
                    } else {
                        if (z8) {
                        }
                        z10 = false;
                    }
                    if (!z9) {
                        list2 = CollectionsKt.emptyList();
                    } else if (list2 == null) {
                        list2 = new ArrayList();
                        for (Object obj3 : list3) {
                            if (!((BookingPassenger) obj3).isCurrentUser()) {
                                list2.add(obj3);
                            }
                        }
                    }
                    list5 = list2;
                    passengerState = passengerSelectionHelper.getPassengerState();
                    do {
                        value2 = passengerState.getValue();
                        passengerState2 = value2;
                        ArrayList arrayList3 = new ArrayList();
                        for (Object obj4 : list4) {
                            if (!((BookingPassenger) obj4).isCurrentUser()) {
                                arrayList3.add(obj4);
                            }
                        }
                        sortedWith = CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper$loadPassengerState$lambda$13$$inlined$sortedBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t5, T t6) {
                                String firstName = ((BookingPassenger) t5).getFirstName();
                                Locale locale = Locale.ROOT;
                                String lowerCase = firstName.toLowerCase(locale);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                String lowerCase2 = ((BookingPassenger) t6).getFirstName().toLowerCase(locale);
                                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                            }
                        });
                        arrayList2 = new ArrayList();
                        for (Object obj5 : list5) {
                            if (!((BookingPassenger) obj5).isCurrentUser()) {
                                arrayList2.add(obj5);
                            }
                        }
                    } while (!passengerState.compareAndSet(value2, passengerState2.copy(z10, bookingPassenger2, sortedWith, CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper$loadPassengerState$lambda$13$$inlined$sortedBy$2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t5, T t6) {
                            String firstName = ((BookingPassenger) t5).getFirstName();
                            Locale locale = Locale.ROOT;
                            String lowerCase = firstName.toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            String lowerCase2 = ((BookingPassenger) t6).getFirstName().toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                            return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                        }
                    }))));
                    return Unit.INSTANCE;
                }
                z10 = true;
                if (!z9) {
                }
                list5 = list2;
                passengerState = passengerSelectionHelper.getPassengerState();
                do {
                    value2 = passengerState.getValue();
                    passengerState2 = value2;
                    ArrayList arrayList32 = new ArrayList();
                    while (r6.hasNext()) {
                    }
                    sortedWith = CollectionsKt.sortedWith(arrayList32, new Comparator() { // from class: dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper$loadPassengerState$lambda$13$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t5, T t6) {
                            String firstName = ((BookingPassenger) t5).getFirstName();
                            Locale locale = Locale.ROOT;
                            String lowerCase = firstName.toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            String lowerCase2 = ((BookingPassenger) t6).getFirstName().toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                            return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                        }
                    });
                    arrayList2 = new ArrayList();
                    while (r6.hasNext()) {
                    }
                } while (!passengerState.compareAndSet(value2, passengerState2.copy(z10, bookingPassenger2, sortedWith, CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper$loadPassengerState$lambda$13$$inlined$sortedBy$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t5, T t6) {
                        String firstName = ((BookingPassenger) t5).getFirstName();
                        Locale locale = Locale.ROOT;
                        String lowerCase = firstName.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = ((BookingPassenger) t6).getFirstName().toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                    }
                }))));
                return Unit.INSTANCE;
            }
        }
        passengerSelectionHelper$loadPassengerState$1 = new PassengerSelectionHelper$loadPassengerState$1(this, continuation);
        Object obj22 = passengerSelectionHelper$loadPassengerState$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = passengerSelectionHelper$loadPassengerState$1.label;
        if (i5 != 0) {
        }
        List<UserPassenger> passengers2 = passengerSelectionHelper.userPassengerManager.getPassengersState().getValue().getPassengers();
        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(passengers2, 10));
        it = passengers2.iterator();
        while (it.hasNext()) {
        }
        if (function22 != null) {
        }
        Pair<? extends List<BookingPassenger>, ? extends List<BookingPassenger>> pair2 = TuplesKt.to(arrayList, CollectionsKt.emptyList());
        List list72 = (List) pair2.component1();
        list3 = (List) pair2.component2();
        list4 = list72;
        it2 = list4.iterator();
        while (true) {
            if (it2.hasNext()) {
            }
        }
        BookingPassenger bookingPassenger42 = (BookingPassenger) obj;
        if (bookingPassenger42 != null) {
        }
        if (!z9) {
            if (list3.isEmpty()) {
            }
            if (!z9) {
            }
            list5 = list2;
            passengerState = passengerSelectionHelper.getPassengerState();
            do {
                value2 = passengerState.getValue();
                passengerState2 = value2;
                ArrayList arrayList322 = new ArrayList();
                while (r6.hasNext()) {
                }
                sortedWith = CollectionsKt.sortedWith(arrayList322, new Comparator() { // from class: dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper$loadPassengerState$lambda$13$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t5, T t6) {
                        String firstName = ((BookingPassenger) t5).getFirstName();
                        Locale locale = Locale.ROOT;
                        String lowerCase = firstName.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = ((BookingPassenger) t6).getFirstName().toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                    }
                });
                arrayList2 = new ArrayList();
                while (r6.hasNext()) {
                }
            } while (!passengerState.compareAndSet(value2, passengerState2.copy(z10, bookingPassenger2, sortedWith, CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper$loadPassengerState$lambda$13$$inlined$sortedBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t5, T t6) {
                    String firstName = ((BookingPassenger) t5).getFirstName();
                    Locale locale = Locale.ROOT;
                    String lowerCase = firstName.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = ((BookingPassenger) t6).getFirstName().toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                }
            }))));
            return Unit.INSTANCE;
        }
        z10 = true;
        if (!z9) {
        }
        list5 = list2;
        passengerState = passengerSelectionHelper.getPassengerState();
        do {
            value2 = passengerState.getValue();
            passengerState2 = value2;
            ArrayList arrayList3222 = new ArrayList();
            while (r6.hasNext()) {
            }
            sortedWith = CollectionsKt.sortedWith(arrayList3222, new Comparator() { // from class: dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper$loadPassengerState$lambda$13$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t5, T t6) {
                    String firstName = ((BookingPassenger) t5).getFirstName();
                    Locale locale = Locale.ROOT;
                    String lowerCase = firstName.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = ((BookingPassenger) t6).getFirstName().toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                }
            });
            arrayList2 = new ArrayList();
            while (r6.hasNext()) {
            }
        } while (!passengerState.compareAndSet(value2, passengerState2.copy(z10, bookingPassenger2, sortedWith, CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper$loadPassengerState$lambda$13$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                String firstName = ((BookingPassenger) t5).getFirstName();
                Locale locale = Locale.ROOT;
                String lowerCase = firstName.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = ((BookingPassenger) t6).getFirstName().toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                return ComparisonsKt.compareValues(lowerCase, lowerCase2);
            }
        }))));
        return Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPassengerSelectionHelper
    public void toggleSelected(BookingPassenger passenger) {
        PassengerState value;
        List sortedWith;
        PassengerState copy$default;
        Intrinsics.checkNotNullParameter(passenger, "passenger");
        MutableStateFlow<PassengerState> passengerState = getPassengerState();
        do {
            value = passengerState.getValue();
            PassengerState passengerState2 = value;
            if (passenger.isCurrentUser()) {
                copy$default = PassengerState.copy$default(passengerState2, !passengerState2.getCurrentUserSelected(), null, null, null, 14, null);
            } else {
                if (passengerState2.getSelectedPassengers().contains(passenger)) {
                    List<BookingPassenger> selectedPassengers = passengerState2.getSelectedPassengers();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : selectedPassengers) {
                        if (!Intrinsics.areEqual((BookingPassenger) obj, passenger)) {
                            arrayList.add(obj);
                        }
                    }
                    sortedWith = arrayList;
                } else {
                    sortedWith = CollectionsKt.sortedWith(CollectionsKt.plus((Collection<? extends BookingPassenger>) passengerState2.getSelectedPassengers(), passenger), new Comparator() { // from class: dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper$toggleSelected$lambda$16$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t5, T t6) {
                            String firstName = ((BookingPassenger) t5).getFirstName();
                            Locale locale = Locale.ROOT;
                            String lowerCase = firstName.toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            String lowerCase2 = ((BookingPassenger) t6).getFirstName().toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                            return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                        }
                    });
                }
                copy$default = PassengerState.copy$default(passengerState2, false, null, null, sortedWith, 7, null);
            }
        } while (!passengerState.compareAndSet(value, copy$default));
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPassengerSelectionHelper
    public Object updatePassenger(BookingPassenger bookingPassenger, Continuation<? super Unit> continuation) {
        PassengerState value;
        PassengerState passengerState;
        ArrayList arrayList;
        ArrayList arrayList2;
        MutableStateFlow<PassengerState> passengerState2 = getPassengerState();
        do {
            value = passengerState2.getValue();
            passengerState = value;
            List<BookingPassenger> passengers = passengerState.getPassengers();
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(passengers, 10));
            for (BookingPassenger bookingPassenger2 : passengers) {
                if (Intrinsics.areEqual(bookingPassenger2.getLocalId(), bookingPassenger.getLocalId())) {
                    bookingPassenger2 = bookingPassenger;
                }
                arrayList.add(bookingPassenger2);
            }
            List<BookingPassenger> selectedPassengers = passengerState.getSelectedPassengers();
            arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(selectedPassengers, 10));
            for (BookingPassenger bookingPassenger3 : selectedPassengers) {
                if (Intrinsics.areEqual(bookingPassenger3.getLocalId(), bookingPassenger.getLocalId())) {
                    bookingPassenger3 = bookingPassenger;
                }
                arrayList2.add(bookingPassenger3);
            }
        } while (!passengerState2.compareAndSet(value, PassengerState.copy$default(passengerState, false, null, CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper$updatePassenger$lambda$24$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                String firstName = ((BookingPassenger) t5).getFirstName();
                Locale locale = Locale.ROOT;
                String lowerCase = firstName.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = ((BookingPassenger) t6).getFirstName().toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                return ComparisonsKt.compareValues(lowerCase, lowerCase2);
            }
        }), CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper$updatePassenger$lambda$24$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                String firstName = ((BookingPassenger) t5).getFirstName();
                Locale locale = Locale.ROOT;
                String lowerCase = firstName.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = ((BookingPassenger) t6).getFirstName().toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                return ComparisonsKt.compareValues(lowerCase, lowerCase2);
            }
        }), 3, null)));
        return Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPassengerSelectionHelper
    public MutableStateFlow<PassengerState> getPassengerState() {
        return this.passengerState;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\t\u0010\nJF\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068F¢\u0006\u0006\u001a\u0004\b \u0010\u001e¨\u0006\""}, d2 = {"Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "currentUserSelected", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "currentUser", BuildConfig.FLAVOR, "passengers", "selectedPassengers", "<init>", "(ZLdk/molslinjen/domain/model/booking/BookingPassenger;Ljava/util/List;Ljava/util/List;)V", "copy", "(ZLdk/molslinjen/domain/model/booking/BookingPassenger;Ljava/util/List;Ljava/util/List;)Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getCurrentUserSelected", "()Z", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "getCurrentUser", "()Ldk/molslinjen/domain/model/booking/BookingPassenger;", "Ljava/util/List;", "getPassengers", "()Ljava/util/List;", "getSelectedPassengers", "getAllSelectedPassengers", "allSelectedPassengers", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class PassengerState {
        private final BookingPassenger currentUser;
        private final boolean currentUserSelected;
        private final List<BookingPassenger> passengers;
        private final List<BookingPassenger> selectedPassengers;

        public PassengerState(boolean z5, BookingPassenger bookingPassenger, List<BookingPassenger> passengers, List<BookingPassenger> selectedPassengers) {
            Intrinsics.checkNotNullParameter(passengers, "passengers");
            Intrinsics.checkNotNullParameter(selectedPassengers, "selectedPassengers");
            this.currentUserSelected = z5;
            this.currentUser = bookingPassenger;
            this.passengers = passengers;
            this.selectedPassengers = selectedPassengers;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PassengerState copy$default(PassengerState passengerState, boolean z5, BookingPassenger bookingPassenger, List list, List list2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = passengerState.currentUserSelected;
            }
            if ((i5 & 2) != 0) {
                bookingPassenger = passengerState.currentUser;
            }
            if ((i5 & 4) != 0) {
                list = passengerState.passengers;
            }
            if ((i5 & 8) != 0) {
                list2 = passengerState.selectedPassengers;
            }
            return passengerState.copy(z5, bookingPassenger, list, list2);
        }

        public final PassengerState copy(boolean currentUserSelected, BookingPassenger currentUser, List<BookingPassenger> passengers, List<BookingPassenger> selectedPassengers) {
            Intrinsics.checkNotNullParameter(passengers, "passengers");
            Intrinsics.checkNotNullParameter(selectedPassengers, "selectedPassengers");
            return new PassengerState(currentUserSelected, currentUser, passengers, selectedPassengers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PassengerState)) {
                return false;
            }
            PassengerState passengerState = (PassengerState) other;
            return this.currentUserSelected == passengerState.currentUserSelected && Intrinsics.areEqual(this.currentUser, passengerState.currentUser) && Intrinsics.areEqual(this.passengers, passengerState.passengers) && Intrinsics.areEqual(this.selectedPassengers, passengerState.selectedPassengers);
        }

        public final List<BookingPassenger> getAllSelectedPassengers() {
            BookingPassenger bookingPassenger;
            return (!this.currentUserSelected || (bookingPassenger = this.currentUser) == null) ? this.selectedPassengers : CollectionsKt.plus((Collection<? extends BookingPassenger>) this.selectedPassengers, bookingPassenger);
        }

        public final BookingPassenger getCurrentUser() {
            return this.currentUser;
        }

        public final boolean getCurrentUserSelected() {
            return this.currentUserSelected;
        }

        public final List<BookingPassenger> getPassengers() {
            return this.passengers;
        }

        public final List<BookingPassenger> getSelectedPassengers() {
            return this.selectedPassengers;
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.currentUserSelected) * 31;
            BookingPassenger bookingPassenger = this.currentUser;
            return ((((hashCode + (bookingPassenger == null ? 0 : bookingPassenger.hashCode())) * 31) + this.passengers.hashCode()) * 31) + this.selectedPassengers.hashCode();
        }

        public String toString() {
            return "PassengerState(currentUserSelected=" + this.currentUserSelected + ", currentUser=" + this.currentUser + ", passengers=" + this.passengers + ", selectedPassengers=" + this.selectedPassengers + ")";
        }

        public /* synthetic */ PassengerState(boolean z5, BookingPassenger bookingPassenger, List list, List list2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? null : bookingPassenger, (i5 & 4) != 0 ? CollectionsKt.emptyList() : list, (i5 & 8) != 0 ? CollectionsKt.emptyList() : list2);
        }
    }
}
