package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.passengers.IPassengerMergeHelper;
import dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.config.AgeClassifications;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J>\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0096@¢\u0006\u0002\u0010&J\u0018\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010*\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010+\u001a\u00020#H\u0096@¢\u0006\u0002\u0010,J\u001e\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020)2\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010/J\u001e\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u0002022\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u00103J\b\u00104\u001a\u00020\u001fH\u0016J<\u00105\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020)07\u0012\n\u0012\b\u0012\u0004\u0012\u00020)07062\f\u00108\u001a\b\u0012\u0004\u0012\u00020)072\f\u00109\u001a\b\u0012\u0004\u0012\u00020)07H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006:"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/CheckoutPassengerManager;", "Ldk/molslinjen/domain/managers/checkout/ICheckoutPassengerManager;", "configurationManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "editManager", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "outboundPassengerSelectionHelper", "Ldk/molslinjen/domain/managers/checkout/IPassengerSelectionHelper;", "returnPassengerSelectionHelper", "passengerMergeHelper", "Ldk/molslinjen/domain/managers/checkout/passengers/IPassengerMergeHelper;", "<init>", "(Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;Ldk/molslinjen/domain/managers/checkout/IEditManager;Ldk/molslinjen/domain/managers/checkout/IPassengerSelectionHelper;Ldk/molslinjen/domain/managers/checkout/IPassengerSelectionHelper;Ldk/molslinjen/domain/managers/checkout/passengers/IPassengerMergeHelper;)V", "outboundPassengerState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", "getOutboundPassengerState", "()Lkotlinx/coroutines/flow/StateFlow;", "returnPassengerState", "getReturnPassengerState", "passengerState", "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "passengerSelectionHelper", "calculatePassengerSelectionState", "Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;", "passengerInfo", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "transportation", "Ldk/molslinjen/domain/model/config/Transportation;", "load", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/domain/model/config/Site;", "showAgeGroup", BuildConfig.FLAVOR, "onlySelectMe", "mergeAfterProfileChange", "(Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/booking/DepartureDirection;ZLdk/molslinjen/domain/model/booking/PassengerInfo;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleSelected", "passenger", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "addPassenger", "asSelected", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;Ldk/molslinjen/domain/model/booking/DepartureDirection;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePassenger", "updatedPassenger", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;Ldk/molslinjen/domain/model/booking/DepartureDirection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePassenger", "localPassengerId", BuildConfig.FLAVOR, "(Ljava/lang/String;Ldk/molslinjen/domain/model/booking/DepartureDirection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "mergeWithPassengersBeforeProfileChange", "Lkotlin/Pair;", BuildConfig.FLAVOR, "localPassengers", "previouslySelectedPassengers", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckoutPassengerManager implements ICheckoutPassengerManager {
    private final IConfigurationManager configurationManager;
    private final IEditManager editManager;
    private final IPassengerSelectionHelper outboundPassengerSelectionHelper;
    private final StateFlow<PassengerSelectionHelper.PassengerState> outboundPassengerState;
    private final IPassengerMergeHelper passengerMergeHelper;
    private final IPassengerSelectionHelper returnPassengerSelectionHelper;
    private final StateFlow<PassengerSelectionHelper.PassengerState> returnPassengerState;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DepartureDirection.values().length];
            try {
                iArr[DepartureDirection.Outbound.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DepartureDirection.Return.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CheckoutPassengerManager(IConfigurationManager configurationManager, IEditManager editManager, IPassengerSelectionHelper outboundPassengerSelectionHelper, IPassengerSelectionHelper returnPassengerSelectionHelper, IPassengerMergeHelper passengerMergeHelper) {
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        Intrinsics.checkNotNullParameter(editManager, "editManager");
        Intrinsics.checkNotNullParameter(outboundPassengerSelectionHelper, "outboundPassengerSelectionHelper");
        Intrinsics.checkNotNullParameter(returnPassengerSelectionHelper, "returnPassengerSelectionHelper");
        Intrinsics.checkNotNullParameter(passengerMergeHelper, "passengerMergeHelper");
        this.configurationManager = configurationManager;
        this.editManager = editManager;
        this.outboundPassengerSelectionHelper = outboundPassengerSelectionHelper;
        this.returnPassengerSelectionHelper = returnPassengerSelectionHelper;
        this.passengerMergeHelper = passengerMergeHelper;
        this.outboundPassengerState = outboundPassengerSelectionHelper.getPassengerState();
        this.returnPassengerState = returnPassengerSelectionHelper.getPassengerState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<List<BookingPassenger>, List<BookingPassenger>> mergeWithPassengersBeforeProfileChange(List<BookingPassenger> localPassengers, List<BookingPassenger> previouslySelectedPassengers) {
        return this.passengerMergeHelper.mergeWithPassengersBeforeProfileChange(previouslySelectedPassengers, localPassengers);
    }

    private final IPassengerSelectionHelper passengerSelectionHelper(DepartureDirection departureDirection) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[departureDirection.ordinal()];
        if (i5 == 1) {
            return this.outboundPassengerSelectionHelper;
        }
        if (i5 == 2) {
            return this.returnPassengerSelectionHelper;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object addPassenger(BookingPassenger bookingPassenger, DepartureDirection departureDirection, boolean z5, Continuation<? super Unit> continuation) {
        CheckoutPassengerManager$addPassenger$1 checkoutPassengerManager$addPassenger$1;
        int i5;
        CheckoutPassengerManager checkoutPassengerManager;
        if (continuation instanceof CheckoutPassengerManager$addPassenger$1) {
            checkoutPassengerManager$addPassenger$1 = (CheckoutPassengerManager$addPassenger$1) continuation;
            int i6 = checkoutPassengerManager$addPassenger$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                checkoutPassengerManager$addPassenger$1.label = i6 - Integer.MIN_VALUE;
                Object obj = checkoutPassengerManager$addPassenger$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = checkoutPassengerManager$addPassenger$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IPassengerSelectionHelper passengerSelectionHelper = passengerSelectionHelper(departureDirection);
                    checkoutPassengerManager$addPassenger$1.L$0 = this;
                    checkoutPassengerManager$addPassenger$1.L$1 = bookingPassenger;
                    checkoutPassengerManager$addPassenger$1.L$2 = departureDirection;
                    checkoutPassengerManager$addPassenger$1.label = 1;
                    if (passengerSelectionHelper.addPassenger(bookingPassenger, z5, checkoutPassengerManager$addPassenger$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    checkoutPassengerManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    departureDirection = (DepartureDirection) checkoutPassengerManager$addPassenger$1.L$2;
                    bookingPassenger = (BookingPassenger) checkoutPassengerManager$addPassenger$1.L$1;
                    checkoutPassengerManager = (CheckoutPassengerManager) checkoutPassengerManager$addPassenger$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (departureDirection == DepartureDirection.Return) {
                    return Unit.INSTANCE;
                }
                DepartureDirection departureDirection2 = DepartureDirection.Outbound;
                checkoutPassengerManager$addPassenger$1.L$0 = null;
                checkoutPassengerManager$addPassenger$1.L$1 = null;
                checkoutPassengerManager$addPassenger$1.L$2 = null;
                checkoutPassengerManager$addPassenger$1.label = 2;
                if (checkoutPassengerManager.addPassenger(bookingPassenger, departureDirection2, false, checkoutPassengerManager$addPassenger$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        checkoutPassengerManager$addPassenger$1 = new CheckoutPassengerManager$addPassenger$1(this, continuation);
        Object obj2 = checkoutPassengerManager$addPassenger$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = checkoutPassengerManager$addPassenger$1.label;
        if (i5 != 0) {
        }
        if (departureDirection == DepartureDirection.Return) {
        }
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager
    public ISharedPassengerSelectionViewState calculatePassengerSelectionState(PassengerInfo passengerInfo, Transportation transportation, DepartureDirection departureDirection) {
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(transportation, "transportation");
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        return passengerSelectionHelper(departureDirection).calculatePassengerSelectionState(passengerInfo, transportation);
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager
    public void clear() {
        this.outboundPassengerSelectionHelper.clear();
        this.returnPassengerSelectionHelper.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deletePassenger(String str, DepartureDirection departureDirection, Continuation<? super Unit> continuation) {
        CheckoutPassengerManager$deletePassenger$1 checkoutPassengerManager$deletePassenger$1;
        int i5;
        CheckoutPassengerManager checkoutPassengerManager;
        if (continuation instanceof CheckoutPassengerManager$deletePassenger$1) {
            checkoutPassengerManager$deletePassenger$1 = (CheckoutPassengerManager$deletePassenger$1) continuation;
            int i6 = checkoutPassengerManager$deletePassenger$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                checkoutPassengerManager$deletePassenger$1.label = i6 - Integer.MIN_VALUE;
                Object obj = checkoutPassengerManager$deletePassenger$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = checkoutPassengerManager$deletePassenger$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IPassengerSelectionHelper passengerSelectionHelper = passengerSelectionHelper(departureDirection);
                    checkoutPassengerManager$deletePassenger$1.L$0 = this;
                    checkoutPassengerManager$deletePassenger$1.L$1 = str;
                    checkoutPassengerManager$deletePassenger$1.L$2 = departureDirection;
                    checkoutPassengerManager$deletePassenger$1.label = 1;
                    if (passengerSelectionHelper.deletePassenger(str, checkoutPassengerManager$deletePassenger$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    checkoutPassengerManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    departureDirection = (DepartureDirection) checkoutPassengerManager$deletePassenger$1.L$2;
                    str = (String) checkoutPassengerManager$deletePassenger$1.L$1;
                    checkoutPassengerManager = (CheckoutPassengerManager) checkoutPassengerManager$deletePassenger$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (departureDirection == DepartureDirection.Return) {
                    return Unit.INSTANCE;
                }
                DepartureDirection departureDirection2 = DepartureDirection.Outbound;
                checkoutPassengerManager$deletePassenger$1.L$0 = null;
                checkoutPassengerManager$deletePassenger$1.L$1 = null;
                checkoutPassengerManager$deletePassenger$1.L$2 = null;
                checkoutPassengerManager$deletePassenger$1.label = 2;
                if (checkoutPassengerManager.deletePassenger(str, departureDirection2, checkoutPassengerManager$deletePassenger$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        checkoutPassengerManager$deletePassenger$1 = new CheckoutPassengerManager$deletePassenger$1(this, continuation);
        Object obj2 = checkoutPassengerManager$deletePassenger$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = checkoutPassengerManager$deletePassenger$1.label;
        if (i5 != 0) {
        }
        if (departureDirection == DepartureDirection.Return) {
        }
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager
    public StateFlow<PassengerSelectionHelper.PassengerState> getOutboundPassengerState() {
        return this.outboundPassengerState;
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager
    public StateFlow<PassengerSelectionHelper.PassengerState> getReturnPassengerState() {
        return this.returnPassengerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object load(Site site, DepartureDirection departureDirection, boolean z5, PassengerInfo passengerInfo, boolean z6, boolean z7, Continuation<? super Unit> continuation) {
        CheckoutPassengerManager$load$1 checkoutPassengerManager$load$1;
        int i5;
        IPassengerSelectionHelper passengerSelectionHelper;
        Function checkoutPassengerManager$load$3;
        PassengerInfo passengerInfo2;
        boolean z8;
        DepartureDirection departureDirection2;
        BookingPassenger bookingPassenger;
        boolean z9;
        CheckoutPassengerManager checkoutPassengerManager;
        Site site2;
        int i6;
        LocalizedSiteConfiguration localizedSiteConfiguration;
        AgeClassifications ageClassifications;
        if (continuation instanceof CheckoutPassengerManager$load$1) {
            checkoutPassengerManager$load$1 = (CheckoutPassengerManager$load$1) continuation;
            int i7 = checkoutPassengerManager$load$1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                checkoutPassengerManager$load$1.label = i7 - Integer.MIN_VALUE;
                Object obj = checkoutPassengerManager$load$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = checkoutPassengerManager$load$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    int i8 = departureDirection == DepartureDirection.Return ? 1 : 0;
                    passengerSelectionHelper = passengerSelectionHelper(departureDirection);
                    BookingPassenger currentUser = (i8 == 0 || passengerSelectionHelper.getPassengerState().getValue().getCurrentUser() != null) ? null : passengerSelectionHelper(DepartureDirection.Outbound).getPassengerState().getValue().getCurrentUser();
                    checkoutPassengerManager$load$3 = (!z7 || this.editManager.getEditState().getValue().getIsEditing()) ? new CheckoutPassengerManager$load$3(this.editManager) : new CheckoutPassengerManager$load$2(this);
                    IConfigurationManager iConfigurationManager = this.configurationManager;
                    checkoutPassengerManager$load$1.L$0 = this;
                    checkoutPassengerManager$load$1.L$1 = site;
                    checkoutPassengerManager$load$1.L$2 = departureDirection;
                    passengerInfo2 = passengerInfo;
                    checkoutPassengerManager$load$1.L$3 = passengerInfo2;
                    checkoutPassengerManager$load$1.L$4 = passengerSelectionHelper;
                    checkoutPassengerManager$load$1.L$5 = currentUser;
                    checkoutPassengerManager$load$1.L$6 = checkoutPassengerManager$load$3;
                    z8 = z5;
                    checkoutPassengerManager$load$1.Z$0 = z8;
                    checkoutPassengerManager$load$1.Z$1 = z6;
                    checkoutPassengerManager$load$1.I$0 = i8;
                    checkoutPassengerManager$load$1.label = 1;
                    Object activeConfiguration = iConfigurationManager.getActiveConfiguration(site, checkoutPassengerManager$load$1);
                    if (activeConfiguration == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    departureDirection2 = departureDirection;
                    bookingPassenger = currentUser;
                    z9 = z6;
                    checkoutPassengerManager = this;
                    site2 = site;
                    i6 = i8;
                    obj = activeConfiguration;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    i6 = checkoutPassengerManager$load$1.I$0;
                    z9 = checkoutPassengerManager$load$1.Z$1;
                    boolean z10 = checkoutPassengerManager$load$1.Z$0;
                    Function function = (KFunction) checkoutPassengerManager$load$1.L$6;
                    BookingPassenger bookingPassenger2 = (BookingPassenger) checkoutPassengerManager$load$1.L$5;
                    IPassengerSelectionHelper iPassengerSelectionHelper = (IPassengerSelectionHelper) checkoutPassengerManager$load$1.L$4;
                    passengerInfo2 = (PassengerInfo) checkoutPassengerManager$load$1.L$3;
                    DepartureDirection departureDirection3 = (DepartureDirection) checkoutPassengerManager$load$1.L$2;
                    site2 = (Site) checkoutPassengerManager$load$1.L$1;
                    checkoutPassengerManager = (CheckoutPassengerManager) checkoutPassengerManager$load$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    bookingPassenger = bookingPassenger2;
                    departureDirection2 = departureDirection3;
                    z8 = z10;
                    checkoutPassengerManager$load$3 = function;
                    passengerSelectionHelper = iPassengerSelectionHelper;
                }
                PassengerInfo passengerInfo3 = passengerInfo2;
                localizedSiteConfiguration = (LocalizedSiteConfiguration) obj;
                if (localizedSiteConfiguration != null || (ageClassifications = localizedSiteConfiguration.getAgeClassifications()) == null) {
                    return Unit.INSTANCE;
                }
                boolean currentUserSelected = i6 != 0 ? checkoutPassengerManager.getOutboundPassengerState().getValue().getCurrentUserSelected() : false;
                List<BookingPassenger> selectedPassengers = i6 != 0 ? checkoutPassengerManager.getOutboundPassengerState().getValue().getSelectedPassengers() : null;
                checkoutPassengerManager$load$1.L$0 = null;
                checkoutPassengerManager$load$1.L$1 = null;
                checkoutPassengerManager$load$1.L$2 = null;
                checkoutPassengerManager$load$1.L$3 = null;
                checkoutPassengerManager$load$1.L$4 = null;
                checkoutPassengerManager$load$1.L$5 = null;
                checkoutPassengerManager$load$1.L$6 = null;
                checkoutPassengerManager$load$1.label = 2;
                if (passengerSelectionHelper.loadPassengerState(site2, z8, passengerInfo3, z9, ageClassifications, (Function2) checkoutPassengerManager$load$3, currentUserSelected, selectedPassengers, departureDirection2, bookingPassenger, checkoutPassengerManager$load$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        checkoutPassengerManager$load$1 = new CheckoutPassengerManager$load$1(this, continuation);
        Object obj2 = checkoutPassengerManager$load$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = checkoutPassengerManager$load$1.label;
        if (i5 != 0) {
        }
        PassengerInfo passengerInfo32 = passengerInfo2;
        localizedSiteConfiguration = (LocalizedSiteConfiguration) obj2;
        if (localizedSiteConfiguration != null) {
        }
        return Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager
    public StateFlow<PassengerSelectionHelper.PassengerState> passengerState(DepartureDirection departureDirection) {
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        int i5 = WhenMappings.$EnumSwitchMapping$0[departureDirection.ordinal()];
        if (i5 == 1) {
            return getOutboundPassengerState();
        }
        if (i5 == 2) {
            return getReturnPassengerState();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager
    public void toggleSelected(BookingPassenger passenger, DepartureDirection departureDirection) {
        Intrinsics.checkNotNullParameter(passenger, "passenger");
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        passengerSelectionHelper(departureDirection).toggleSelected(passenger);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updatePassenger(BookingPassenger bookingPassenger, DepartureDirection departureDirection, Continuation<? super Unit> continuation) {
        CheckoutPassengerManager$updatePassenger$1 checkoutPassengerManager$updatePassenger$1;
        int i5;
        CheckoutPassengerManager checkoutPassengerManager;
        if (continuation instanceof CheckoutPassengerManager$updatePassenger$1) {
            checkoutPassengerManager$updatePassenger$1 = (CheckoutPassengerManager$updatePassenger$1) continuation;
            int i6 = checkoutPassengerManager$updatePassenger$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                checkoutPassengerManager$updatePassenger$1.label = i6 - Integer.MIN_VALUE;
                Object obj = checkoutPassengerManager$updatePassenger$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = checkoutPassengerManager$updatePassenger$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IPassengerSelectionHelper passengerSelectionHelper = passengerSelectionHelper(departureDirection);
                    checkoutPassengerManager$updatePassenger$1.L$0 = this;
                    checkoutPassengerManager$updatePassenger$1.L$1 = bookingPassenger;
                    checkoutPassengerManager$updatePassenger$1.L$2 = departureDirection;
                    checkoutPassengerManager$updatePassenger$1.label = 1;
                    if (passengerSelectionHelper.updatePassenger(bookingPassenger, checkoutPassengerManager$updatePassenger$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    checkoutPassengerManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    departureDirection = (DepartureDirection) checkoutPassengerManager$updatePassenger$1.L$2;
                    bookingPassenger = (BookingPassenger) checkoutPassengerManager$updatePassenger$1.L$1;
                    checkoutPassengerManager = (CheckoutPassengerManager) checkoutPassengerManager$updatePassenger$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (departureDirection == DepartureDirection.Return) {
                    return Unit.INSTANCE;
                }
                DepartureDirection departureDirection2 = DepartureDirection.Outbound;
                checkoutPassengerManager$updatePassenger$1.L$0 = null;
                checkoutPassengerManager$updatePassenger$1.L$1 = null;
                checkoutPassengerManager$updatePassenger$1.L$2 = null;
                checkoutPassengerManager$updatePassenger$1.label = 2;
                if (checkoutPassengerManager.updatePassenger(bookingPassenger, departureDirection2, checkoutPassengerManager$updatePassenger$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        checkoutPassengerManager$updatePassenger$1 = new CheckoutPassengerManager$updatePassenger$1(this, continuation);
        Object obj2 = checkoutPassengerManager$updatePassenger$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = checkoutPassengerManager$updatePassenger$1.label;
        if (i5 != 0) {
        }
        if (departureDirection == DepartureDirection.Return) {
        }
    }
}
