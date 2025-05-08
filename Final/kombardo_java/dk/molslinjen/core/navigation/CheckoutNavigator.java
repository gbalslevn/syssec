package dk.molslinjen.core.navigation;

import com.ramcosta.composedestinations.generated.destinations.AddonsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.BookingSummaryScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.FoodScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PassengerCountScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PassengersScreenDestination;
import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.core.Feature;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.splitTest.ISplitTestManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.booking.TicketSection;
import dk.molslinjen.domain.model.config.PassengerEntryType;
import dk.molslinjen.domain.model.config.RouteDirectionDetails;
import dk.molslinjen.domain.model.config.Transportation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0013H\u0016J$\u0010 \u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002JR\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001e0\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001a2\u0006\u0010)\u001a\u00020\u001eH\u0002J\f\u0010*\u001a\u00020\u001a*\u00020\u001aH\u0002J4\u0010+\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J,\u0010,\u001a\u0004\u0018\u00010\u00162\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u001aH\u0002J\u001a\u00102\u001a\u0004\u0018\u00010\u00162\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u001eH\u0002J\u0018\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020'2\u0006\u00107\u001a\u000208H\u0002J\u0018\u00109\u001a\u00020'2\u0006\u00106\u001a\u00020'2\u0006\u00107\u001a\u000208H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Ldk/molslinjen/core/navigation/CheckoutNavigator;", "Ldk/molslinjen/core/navigation/ICheckoutNavigator;", "checkoutManager", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "checkoutPassengerManager", "Ldk/molslinjen/domain/managers/checkout/ICheckoutPassengerManager;", "returnManager", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "paymentManager", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "splitTestManager", "Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;", "<init>", "(Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;Ldk/molslinjen/domain/managers/checkout/ICheckoutPassengerManager;Ldk/molslinjen/domain/managers/checkout/IReturnManager;Ldk/molslinjen/domain/managers/checkout/IPaymentManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;)V", "fallbackProductTypes", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/ProductType;", "startCheckout", "Lcom/ramcosta/composedestinations/spec/Direction;", "startStep", "nextStep", "currentSection", "Ldk/molslinjen/domain/model/booking/TicketSection;", "bookingType", "Ldk/molslinjen/domain/model/booking/BookingType;", "currentDepartureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "sections", "nextStepInternally", "nextPossibleRouteAndDirection", "Lkotlin/Pair;", "Ldk/molslinjen/core/navigation/CheckoutStep;", "outboundAvailableProductTypes", "returnAvailableProductTypes", "isAddingReturnFromBookingSummary", BuildConfig.FLAVOR, "expectedNextSection", "expectedNextDirection", "nextSection", "isAvailableNextSection", "handlePassengerNavigation", "checkoutState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "nextDepartureDirection", "sectionToScreenRoute", "section", "screenRouteToNavPath", "checkoutStep", "departureDirection", "showPassengersPage", "askForPersonData", "transportation", "Ldk/molslinjen/domain/model/config/Transportation;", "passengerNameRegistrationRequired", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckoutNavigator implements ICheckoutNavigator {
    private final IAnalyticsTracker analyticsTracker;
    private final ICheckoutManager checkoutManager;
    private final ICheckoutPassengerManager checkoutPassengerManager;
    private final List<ProductType> fallbackProductTypes;
    private final IPaymentManager paymentManager;
    private final IReturnManager returnManager;
    private final ISplitTestManager splitTestManager;
    private final IUserManager userManager;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[TicketSection.values().length];
            try {
                iArr[TicketSection.Passenger.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TicketSection.Addons.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TicketSection.Food.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TicketSection.Summary.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DepartureDirection.values().length];
            try {
                iArr2[DepartureDirection.Outbound.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[DepartureDirection.Return.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[CheckoutStep.values().length];
            try {
                iArr3[CheckoutStep.Addons.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[CheckoutStep.Food.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[CheckoutStep.Summary.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public CheckoutNavigator(ICheckoutManager checkoutManager, ICheckoutPassengerManager checkoutPassengerManager, IReturnManager returnManager, IPaymentManager paymentManager, IAnalyticsTracker analyticsTracker, IUserManager userManager, ISplitTestManager splitTestManager) {
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(checkoutPassengerManager, "checkoutPassengerManager");
        Intrinsics.checkNotNullParameter(returnManager, "returnManager");
        Intrinsics.checkNotNullParameter(paymentManager, "paymentManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(splitTestManager, "splitTestManager");
        this.checkoutManager = checkoutManager;
        this.checkoutPassengerManager = checkoutPassengerManager;
        this.returnManager = returnManager;
        this.paymentManager = paymentManager;
        this.analyticsTracker = analyticsTracker;
        this.userManager = userManager;
        this.splitTestManager = splitTestManager;
        this.fallbackProductTypes = CollectionsKt.listOf((Object[]) new ProductType[]{ProductType.Catering, ProductType.Extra});
    }

    private final Direction handlePassengerNavigation(CheckoutManager.CheckoutState checkoutState, DepartureDirection nextDepartureDirection, TicketSection currentSection, boolean isAddingReturnFromBookingSummary) {
        RouteDirectionDetails routeDirectionDetails;
        RouteDirectionDetails routeDirectionDetails2;
        CheckoutManager.CheckoutDirectionState value = this.checkoutManager.getOutboundDirectionState().getValue();
        if (value == null || (routeDirectionDetails = value.getRouteDirectionDetails()) == null) {
            return null;
        }
        boolean askForPersonData = routeDirectionDetails.getAskForPersonData();
        CheckoutManager.CheckoutDirectionState value2 = this.checkoutManager.getReturnDirectionState().getValue();
        boolean askForPersonData2 = (value2 == null || (routeDirectionDetails2 = value2.getRouteDirectionDetails()) == null) ? false : routeDirectionDetails2.getAskForPersonData();
        Transportation transportation = checkoutState.getTransportation();
        if (currentSection != null && (currentSection != TicketSection.Passenger || isAddingReturnFromBookingSummary || nextDepartureDirection == DepartureDirection.Outbound)) {
            return null;
        }
        if (!Feature.OnlyWalkingPassengers.isEnabled()) {
            if (!showPassengersPage(askForPersonData, transportation)) {
                return null;
            }
            boolean passengerNameRegistrationRequired = passengerNameRegistrationRequired(askForPersonData, transportation);
            if (currentSection != TicketSection.Passenger || passengerNameRegistrationRequired) {
                return passengerNameRegistrationRequired ? PassengersScreenDestination.INSTANCE.invoke(nextDepartureDirection) : PassengerCountScreenDestination.INSTANCE;
            }
            return null;
        }
        DepartureDirection departureDirection = DepartureDirection.Outbound;
        if (nextDepartureDirection == departureDirection && askForPersonData) {
            return PassengersScreenDestination.INSTANCE.invoke(nextDepartureDirection);
        }
        if (nextDepartureDirection == departureDirection && askForPersonData2) {
            return PassengersScreenDestination.INSTANCE.invoke(DepartureDirection.Return);
        }
        if (nextDepartureDirection == DepartureDirection.Return && askForPersonData2) {
            return PassengersScreenDestination.INSTANCE.invoke(nextDepartureDirection);
        }
        return null;
    }

    private final boolean isAvailableNextSection(TicketSection expectedNextSection, DepartureDirection expectedNextDirection, List<? extends ProductType> outboundAvailableProductTypes, List<? extends ProductType> returnAvailableProductTypes) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[expectedNextSection.ordinal()];
        if (i5 == 2) {
            int i6 = WhenMappings.$EnumSwitchMapping$1[expectedNextDirection.ordinal()];
            if (i6 == 1) {
                List<? extends ProductType> list = outboundAvailableProductTypes;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    for (ProductType productType : list) {
                        if (productType == ProductType.Extra || productType == ProductType.Bunk) {
                            return true;
                        }
                    }
                }
            } else {
                if (i6 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                List<? extends ProductType> list2 = returnAvailableProductTypes;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    for (ProductType productType2 : list2) {
                        if (productType2 == ProductType.Extra || productType2 == ProductType.Bunk) {
                            return true;
                        }
                    }
                }
            }
        } else {
            if (i5 != 3) {
                return true;
            }
            int i7 = WhenMappings.$EnumSwitchMapping$1[expectedNextDirection.ordinal()];
            if (i7 == 1) {
                List<? extends ProductType> list3 = outboundAvailableProductTypes;
                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                    Iterator<T> it = list3.iterator();
                    while (it.hasNext()) {
                        if (((ProductType) it.next()) == ProductType.Catering) {
                            return true;
                        }
                    }
                }
            } else {
                if (i7 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                List<? extends ProductType> list4 = returnAvailableProductTypes;
                if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                    Iterator<T> it2 = list4.iterator();
                    while (it2.hasNext()) {
                        if (((ProductType) it2.next()) == ProductType.Catering) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private final Pair<CheckoutStep, DepartureDirection> nextPossibleRouteAndDirection(List<? extends ProductType> outboundAvailableProductTypes, List<? extends ProductType> returnAvailableProductTypes, BookingType bookingType, boolean isAddingReturnFromBookingSummary, TicketSection expectedNextSection, DepartureDirection expectedNextDirection) {
        Pair pair;
        if (expectedNextSection != null && expectedNextSection != null && isAvailableNextSection(expectedNextSection, expectedNextDirection, outboundAvailableProductTypes, returnAvailableProductTypes)) {
            return new Pair<>(sectionToScreenRoute(expectedNextSection), expectedNextDirection);
        }
        if (expectedNextSection == null) {
            pair = new Pair(TicketSection.Addons, isAddingReturnFromBookingSummary ? DepartureDirection.Return : DepartureDirection.Outbound);
        } else {
            BookingType bookingType2 = BookingType.TwoWay;
            pair = (bookingType == bookingType2 && !isAddingReturnFromBookingSummary && expectedNextDirection == DepartureDirection.Outbound) ? new Pair(expectedNextSection, DepartureDirection.Return) : (bookingType == bookingType2 && isAddingReturnFromBookingSummary) ? new Pair(nextSection(expectedNextSection), DepartureDirection.Return) : new Pair(nextSection(expectedNextSection), DepartureDirection.Outbound);
        }
        return nextPossibleRouteAndDirection(outboundAvailableProductTypes, returnAvailableProductTypes, bookingType, isAddingReturnFromBookingSummary, (TicketSection) pair.getFirst(), (DepartureDirection) pair.getSecond());
    }

    private final TicketSection nextSection(TicketSection ticketSection) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ticketSection.ordinal()];
        if (i5 == 1) {
            return TicketSection.Addons;
        }
        if (i5 == 2) {
            return TicketSection.Food;
        }
        if (i5 == 3 || i5 == 4) {
            return TicketSection.Summary;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Direction nextStepInternally(TicketSection currentSection, BookingType bookingType, DepartureDirection currentDepartureDirection) {
        TicketSection ticketSection;
        CheckoutManager.CheckoutDirectionState value;
        CheckoutManager.CheckoutDirectionState value2;
        Departure departure;
        Departure departure2;
        boolean isAddingReturnFromBookingSummary = this.returnManager.getReturnState().getValue().getIsAddingReturnFromBookingSummary();
        DepartureDirection invert = isAddingReturnFromBookingSummary ? DepartureDirection.Return : (bookingType == BookingType.Single || currentSection == null) ? DepartureDirection.Outbound : currentDepartureDirection.invert();
        CheckoutManager.CheckoutState value3 = this.checkoutManager.getCheckoutState().getValue();
        if (value3 == null) {
            return null;
        }
        Direction handlePassengerNavigation = handlePassengerNavigation(value3, invert, currentSection, isAddingReturnFromBookingSummary);
        if (handlePassengerNavigation != null) {
            return handlePassengerNavigation;
        }
        TicketSection ticketSection2 = TicketSection.Passenger;
        if (currentSection == ticketSection2 && !isAddingReturnFromBookingSummary) {
            invert = DepartureDirection.Outbound;
        }
        DepartureDirection departureDirection = invert;
        if (currentSection == null || isAddingReturnFromBookingSummary || departureDirection != DepartureDirection.Return) {
            if (currentSection == ticketSection2) {
                currentSection = TicketSection.Addons;
            } else {
                TicketSection ticketSection3 = TicketSection.Addons;
                if (currentSection == ticketSection3) {
                    currentSection = TicketSection.Food;
                } else {
                    if (currentSection != TicketSection.Food) {
                        ticketSection = ticketSection3;
                        value = this.checkoutManager.getOutboundDirectionState().getValue();
                        if (value != null || (departure2 = value.getDeparture()) == null || (r9 = departure2.getAvailableProductTypes()) == null) {
                            List<ProductType> list = this.fallbackProductTypes;
                        }
                        List<ProductType> list2 = list;
                        value2 = this.checkoutManager.getReturnDirectionState().getValue();
                        if (value2 != null || (departure = value2.getDeparture()) == null || (r9 = departure.getAvailableProductTypes()) == null) {
                            List<ProductType> list3 = this.fallbackProductTypes;
                        }
                        Pair<CheckoutStep, DepartureDirection> nextPossibleRouteAndDirection = nextPossibleRouteAndDirection(list2, list3, bookingType, isAddingReturnFromBookingSummary, ticketSection, departureDirection);
                        return screenRouteToNavPath(nextPossibleRouteAndDirection.component1(), nextPossibleRouteAndDirection.component2());
                    }
                    currentSection = TicketSection.Summary;
                }
            }
        }
        ticketSection = currentSection;
        value = this.checkoutManager.getOutboundDirectionState().getValue();
        if (value != null) {
        }
        List<ProductType> list4 = this.fallbackProductTypes;
        List<ProductType> list22 = list4;
        value2 = this.checkoutManager.getReturnDirectionState().getValue();
        if (value2 != null) {
        }
        List<ProductType> list32 = this.fallbackProductTypes;
        Pair<CheckoutStep, DepartureDirection> nextPossibleRouteAndDirection2 = nextPossibleRouteAndDirection(list22, list32, bookingType, isAddingReturnFromBookingSummary, ticketSection, departureDirection);
        return screenRouteToNavPath(nextPossibleRouteAndDirection2.component1(), nextPossibleRouteAndDirection2.component2());
    }

    private final boolean passengerNameRegistrationRequired(boolean askForPersonData, Transportation transportation) {
        return askForPersonData && transportation.getMaxPassengers() > 0;
    }

    private final Direction screenRouteToNavPath(CheckoutStep checkoutStep, DepartureDirection departureDirection) {
        Logger logger = Logger.INSTANCE;
        Logger.log$default(logger, "screenRouteToNavPath: " + checkoutStep + " with direction: " + departureDirection, "CheckoutNavigator", 0, 4, null);
        int i5 = WhenMappings.$EnumSwitchMapping$2[checkoutStep.ordinal()];
        if (i5 == 1) {
            return AddonsScreenDestination.INSTANCE.invoke(departureDirection);
        }
        if (i5 == 2) {
            return FoodScreenDestination.INSTANCE.invoke(departureDirection);
        }
        if (i5 == 3) {
            return BookingSummaryScreenDestination.INSTANCE;
        }
        logger.logCriticalThenFatalError(new CriticalLog("Screen route not handled: " + checkoutStep));
        return null;
    }

    private final CheckoutStep sectionToScreenRoute(TicketSection section) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[section.ordinal()];
        if (i5 == 1) {
            return CheckoutStep.Passenger;
        }
        if (i5 == 2) {
            return CheckoutStep.Addons;
        }
        if (i5 == 3) {
            return CheckoutStep.Food;
        }
        if (i5 == 4) {
            return CheckoutStep.Summary;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean showPassengersPage(boolean askForPersonData, Transportation transportation) {
        return (transportation.getPassengerEntryType() == PassengerEntryType.Standard || transportation.getPassengerEntryType() == PassengerEntryType.PassengersOnly) || passengerNameRegistrationRequired(askForPersonData, transportation);
    }

    @Override // dk.molslinjen.core.navigation.ICheckoutNavigator
    public Direction nextStep(TicketSection currentSection, BookingType bookingType, DepartureDirection currentDepartureDirection) {
        Intrinsics.checkNotNullParameter(currentSection, "currentSection");
        Intrinsics.checkNotNullParameter(bookingType, "bookingType");
        Intrinsics.checkNotNullParameter(currentDepartureDirection, "currentDepartureDirection");
        return nextStepInternally(currentSection, bookingType, currentDepartureDirection);
    }

    @Override // dk.molslinjen.core.navigation.ICheckoutNavigator
    public List<TicketSection> sections() {
        Transportation transportation;
        RouteDirectionDetails routeDirectionDetails;
        boolean z5;
        Departure departure;
        RouteDirectionDetails routeDirectionDetails2;
        CheckoutManager.CheckoutState value = this.checkoutManager.getCheckoutState().getValue();
        if (value == null || (transportation = value.getTransportation()) == null) {
            return CollectionsKt.emptyList();
        }
        CheckoutManager.CheckoutDirectionState value2 = this.checkoutManager.getOutboundDirectionState().getValue();
        CheckoutManager.CheckoutDirectionState value3 = this.checkoutManager.getReturnDirectionState().getValue();
        if (value2 == null || (routeDirectionDetails = value2.getRouteDirectionDetails()) == null) {
            return CollectionsKt.emptyList();
        }
        boolean askForPersonData = routeDirectionDetails.getAskForPersonData();
        boolean askForPersonData2 = (value3 == null || (routeDirectionDetails2 = value3.getRouteDirectionDetails()) == null) ? false : routeDirectionDetails2.getAskForPersonData();
        List<ProductType> availableProductTypes = value2.getDeparture().getAvailableProductTypes();
        List<ProductType> availableProductTypes2 = (value3 == null || (departure = value3.getDeparture()) == null) ? null : departure.getAvailableProductTypes();
        if (availableProductTypes2 == null) {
            availableProductTypes2 = CollectionsKt.emptyList();
        }
        Set union = CollectionsKt.union(availableProductTypes, availableProductTypes2);
        boolean showPassengersPage = showPassengersPage(askForPersonData || askForPersonData2, transportation);
        TicketSection[] values = TicketSection.values();
        ArrayList arrayList = new ArrayList();
        for (TicketSection ticketSection : values) {
            int i5 = WhenMappings.$EnumSwitchMapping$0[ticketSection.ordinal()];
            if (i5 == 1) {
                z5 = showPassengersPage;
            } else {
                if (i5 != 2) {
                    if (i5 == 3) {
                        Set set = union;
                        if (!(set instanceof Collection) || !set.isEmpty()) {
                            Iterator it = set.iterator();
                            while (it.hasNext()) {
                                if (((ProductType) it.next()) == ProductType.Catering) {
                                }
                            }
                        }
                        z5 = false;
                    } else if (i5 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    z5 = true;
                    break;
                }
                Set<ProductType> set2 = union;
                if (!(set2 instanceof Collection) || !set2.isEmpty()) {
                    for (ProductType productType : set2) {
                        if (productType != ProductType.Extra && productType != ProductType.Bunk) {
                        }
                        z5 = true;
                    }
                }
                z5 = false;
            }
            if (z5) {
                arrayList.add(ticketSection);
            }
        }
        return CollectionsKt.toList(arrayList);
    }

    @Override // dk.molslinjen.core.navigation.ICheckoutNavigator
    public Direction startCheckout() {
        Logger.log$default(Logger.INSTANCE, "A/A Split test case: " + this.splitTestManager.getAaTestCase(), null, 0, 6, null);
        boolean isAddingReturnFromBookingSummary = this.returnManager.getReturnState().getValue().getIsAddingReturnFromBookingSummary();
        if (!isAddingReturnFromBookingSummary) {
            this.checkoutPassengerManager.clear();
            this.paymentManager.resetPaymentState();
        }
        this.checkoutManager.setup(isAddingReturnFromBookingSummary);
        if (!isAddingReturnFromBookingSummary) {
            this.analyticsTracker.trackBeginCheckout(this.checkoutManager, this.userManager);
        }
        return startStep();
    }

    public Direction startStep() {
        BookingType bookingType;
        CheckoutManager.CheckoutState value = this.checkoutManager.getCheckoutState().getValue();
        if (value == null || (bookingType = value.getBookingType()) == null) {
            return null;
        }
        return nextStepInternally(null, bookingType, DepartureDirection.Outbound);
    }
}
