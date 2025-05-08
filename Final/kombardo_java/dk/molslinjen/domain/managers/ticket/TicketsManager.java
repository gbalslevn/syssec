package dk.molslinjen.domain.managers.ticket;

import dk.molslinjen.api.extensions.ApiResultExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.booking.IAccountBookingsService;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.booking.IBookingService;
import dk.molslinjen.api.services.booking.request.BookingsRequestParameters;
import dk.molslinjen.api.services.booking.response.booking.BookingHeadersResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.localstorage.bookings.IBookingsRepository;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager;
import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.ticket.TicketsManager;
import dk.molslinjen.domain.managers.ticket.helper.IBookingHeaderMapper;
import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.merge.AssetsMergeType;
import dk.molslinjen.domain.model.account.AuthToken;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingFromAlternateSource;
import dk.molslinjen.domain.model.booking.BookingHeader;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.domain.providers.IStringsProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002YZBQ\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\"\u001a\u00020#H\u0002J\u000e\u0010$\u001a\u00020#H\u0082@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020#H\u0082@¢\u0006\u0002\u0010%J\b\u0010'\u001a\u00020#H\u0002J\u0010\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0018H\u0016J\u001c\u0010*\u001a\u00020#2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0096@¢\u0006\u0002\u0010.J$\u0010/\u001a\b\u0012\u0004\u0012\u00020#002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0096@¢\u0006\u0002\u00105J\"\u00106\u001a\b\u0012\u0004\u0012\u00020#002\f\u00107\u001a\b\u0012\u0004\u0012\u0002080,H\u0082@¢\u0006\u0002\u0010.J&\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u000104002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0096@¢\u0006\u0002\u00105J&\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u000104002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0096@¢\u0006\u0002\u00105J*\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0,002\u0006\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010?J\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020#00H\u0096@¢\u0006\u0002\u0010%J,\u0010A\u001a\b\u0012\u0004\u0012\u00020B002\u0006\u00103\u001a\u0002042\u0006\u0010C\u001a\u0002042\u0006\u0010D\u001a\u00020EH\u0096@¢\u0006\u0002\u0010FJ,\u0010G\u001a\b\u0012\u0004\u0012\u00020#002\u0006\u00103\u001a\u0002042\u0006\u00101\u001a\u0002042\u0006\u0010H\u001a\u00020IH\u0096@¢\u0006\u0002\u0010JJ(\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0,0L2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020N0,H\u0082@¢\u0006\u0002\u0010.J(\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0,0L2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020N0,H\u0082@¢\u0006\u0002\u0010.J$\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0,0L*\b\u0012\u0004\u0012\u00020Q0LH\u0082@¢\u0006\u0002\u0010RJ$\u0010S\u001a\b\u0012\u0004\u0012\u00020#002\u0006\u0010T\u001a\u00020B2\u0006\u0010D\u001a\u00020EH\u0096@¢\u0006\u0002\u0010UJ\u0012\u0010V\u001a\u0006\u0012\u0002\b\u00030WH\u0096@¢\u0006\u0002\u0010%J\u000e\u0010X\u001a\u00020#H\u0096@¢\u0006\u0002\u0010%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Ldk/molslinjen/domain/managers/ticket/TicketsManager;", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "accountBookingsService", "Ldk/molslinjen/api/services/account/booking/IAccountBookingsService;", "bookingService", "Ldk/molslinjen/api/services/booking/IBookingService;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "multiRideManager", "Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;", "commuterManager", "Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;", "bookingsRepository", "Ldk/molslinjen/domain/localstorage/bookings/IBookingsRepository;", "bookingHeaderMapper", "Ldk/molslinjen/domain/managers/ticket/helper/IBookingHeaderMapper;", "stringsProvider", "Ldk/molslinjen/domain/providers/IStringsProvider;", "configManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "<init>", "(Ldk/molslinjen/api/services/account/booking/IAccountBookingsService;Ldk/molslinjen/api/services/booking/IBookingService;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;Ldk/molslinjen/domain/localstorage/bookings/IBookingsRepository;Ldk/molslinjen/domain/managers/ticket/helper/IBookingHeaderMapper;Ldk/molslinjen/domain/providers/IStringsProvider;Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;)V", "ticketsState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/ticket/TicketsManager$TicketsState;", "getTicketsState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "activeTicketsCount", BuildConfig.FLAVOR, "getActiveTicketsCount", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "previousAuthenticationType", "Ldk/molslinjen/domain/managers/user/AuthenticationType;", "listenForAlternateBookingSources", BuildConfig.FLAVOR, "updateWithBookingsFromCommuterManager", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWithBookingsFromMultiRideManager", "listenForAuthentication", "updateActiveTicketCount", "state", "updateFromAlternateSource", "reservations", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingFromAlternateSource;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTicket", "Ldk/molslinjen/domain/managers/ManagerResult;", "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "reservationNumber", BuildConfig.FLAVOR, "(Ldk/molslinjen/domain/model/shared/PhoneNumber;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTickets", "bookings", "Ldk/molslinjen/domain/managers/ticket/TicketsManager$SimpleBookingFetchInfo;", "getReturnReservationNumber", "addTicketsAfterPurchase", "getTicketHistory", "Ldk/molslinjen/domain/model/booking/BookingHeader;", "page", "pageSize", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocalBookings", "getBooking", "Ldk/molslinjen/domain/model/booking/Booking;", "phone", "site", "Ldk/molslinjen/domain/model/config/Site;", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadReceipt", "outputFile", "Ljava/io/File;", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookingHeadersWithoutRetry", "Ldk/molslinjen/api/helpers/ApiResult;", "bookingRequestParameters", "Ldk/molslinjen/api/services/booking/request/BookingsRequestParameters$BookingRequestParameters;", "getBookingHeaders", "mapBookingHeadersResponse", "Ldk/molslinjen/api/services/booking/response/booking/BookingHeadersResponseDTO;", "(Ldk/molslinjen/api/helpers/ApiResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refund", "booking", "(Ldk/molslinjen/domain/model/booking/Booking;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportLocalAssets", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType;", "removeLocalAssets", "SimpleBookingFetchInfo", "TicketsState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TicketsManager implements ITicketsManager {
    private final IAccountBookingsService accountBookingsService;
    private final MutableStateFlow<Integer> activeTicketsCount;
    private final IBookingHeaderMapper bookingHeaderMapper;
    private final IBookingService bookingService;
    private final IBookingsRepository bookingsRepository;
    private final IBornholmCommuterManager commuterManager;
    private final IConfigurationManager configManager;
    private final CoroutineScope coroutineScope;
    private final IMultiRideManager multiRideManager;
    private AuthenticationType previousAuthenticationType;
    private final IStringsProvider stringsProvider;
    private final MutableStateFlow<TicketsState> ticketsState;
    private final IUserManager userManager;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.ticket.TicketsManager$1", f = "TicketsManager.kt", l = {57}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.ticket.TicketsManager$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:11:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x004d A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x004b -> B:5:0x004e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 1
                if (r1 == 0) goto L25
                if (r1 != r2) goto L1d
                java.lang.Object r1 = r8.L$3
                dk.molslinjen.domain.managers.ticket.TicketsManager$TicketsState r1 = (dk.molslinjen.domain.managers.ticket.TicketsManager.TicketsState) r1
                java.lang.Object r3 = r8.L$2
                java.lang.Object r4 = r8.L$1
                dk.molslinjen.domain.managers.ticket.TicketsManager r4 = (dk.molslinjen.domain.managers.ticket.TicketsManager) r4
                java.lang.Object r5 = r8.L$0
                kotlinx.coroutines.flow.MutableStateFlow r5 = (kotlinx.coroutines.flow.MutableStateFlow) r5
                kotlin.ResultKt.throwOnFailure(r9)
                goto L4e
            L1d:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L25:
                kotlin.ResultKt.throwOnFailure(r9)
                dk.molslinjen.domain.managers.ticket.TicketsManager r9 = dk.molslinjen.domain.managers.ticket.TicketsManager.this
                kotlinx.coroutines.flow.MutableStateFlow r9 = r9.getTicketsState()
                dk.molslinjen.domain.managers.ticket.TicketsManager r1 = dk.molslinjen.domain.managers.ticket.TicketsManager.this
                r5 = r9
                r4 = r1
            L32:
                java.lang.Object r3 = r5.getValue()
                r1 = r3
                dk.molslinjen.domain.managers.ticket.TicketsManager$TicketsState r1 = (dk.molslinjen.domain.managers.ticket.TicketsManager.TicketsState) r1
                dk.molslinjen.domain.localstorage.bookings.IBookingsRepository r9 = dk.molslinjen.domain.managers.ticket.TicketsManager.access$getBookingsRepository$p(r4)
                r8.L$0 = r5
                r8.L$1 = r4
                r8.L$2 = r3
                r8.L$3 = r1
                r8.label = r2
                java.lang.Object r9 = r9.getBookings(r8)
                if (r9 != r0) goto L4e
                return r0
            L4e:
                java.util.List r9 = (java.util.List) r9
                r6 = 2
                r7 = 0
                dk.molslinjen.domain.managers.ticket.TicketsManager$TicketsState r9 = dk.molslinjen.domain.managers.ticket.TicketsManager.TicketsState.copy$default(r1, r9, r7, r6, r7)
                boolean r9 = r5.compareAndSet(r3, r9)
                if (r9 == 0) goto L32
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.domain.managers.ticket.TicketsManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.ticket.TicketsManager$2", f = "TicketsManager.kt", l = {61}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.ticket.TicketsManager$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "state", "Ldk/molslinjen/domain/managers/ticket/TicketsManager$TicketsState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.domain.managers.ticket.TicketsManager$2$1", f = "TicketsManager.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.domain.managers.ticket.TicketsManager$2$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<TicketsState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TicketsManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TicketsManager ticketsManager, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = ticketsManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(TicketsState ticketsState, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(ticketsState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.updateActiveTicketCount((TicketsState) this.L$0);
                return Unit.INSTANCE;
            }
        }

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow<TicketsState> ticketsState = TicketsManager.this.getTicketsState();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(TicketsManager.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(ticketsState, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/domain/managers/ticket/TicketsManager$SimpleBookingFetchInfo;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "reservationNumber", "phone", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getReservationNumber", "getPhone", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SimpleBookingFetchInfo {
        private final String phone;
        private final String reservationNumber;

        public SimpleBookingFetchInfo(String reservationNumber, String phone) {
            Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
            Intrinsics.checkNotNullParameter(phone, "phone");
            this.reservationNumber = reservationNumber;
            this.phone = phone;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SimpleBookingFetchInfo)) {
                return false;
            }
            SimpleBookingFetchInfo simpleBookingFetchInfo = (SimpleBookingFetchInfo) other;
            return Intrinsics.areEqual(this.reservationNumber, simpleBookingFetchInfo.reservationNumber) && Intrinsics.areEqual(this.phone, simpleBookingFetchInfo.phone);
        }

        public final String getPhone() {
            return this.phone;
        }

        public final String getReservationNumber() {
            return this.reservationNumber;
        }

        public int hashCode() {
            return (this.reservationNumber.hashCode() * 31) + this.phone.hashCode();
        }

        public String toString() {
            return "SimpleBookingFetchInfo(reservationNumber=" + this.reservationNumber + ", phone=" + this.phone + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TicketsManager(IAccountBookingsService accountBookingsService, IBookingService bookingService, IUserManager userManager, IMultiRideManager multiRideManager, IBornholmCommuterManager commuterManager, IBookingsRepository bookingsRepository, IBookingHeaderMapper bookingHeaderMapper, IStringsProvider stringsProvider, IConfigurationManager configManager) {
        Intrinsics.checkNotNullParameter(accountBookingsService, "accountBookingsService");
        Intrinsics.checkNotNullParameter(bookingService, "bookingService");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(multiRideManager, "multiRideManager");
        Intrinsics.checkNotNullParameter(commuterManager, "commuterManager");
        Intrinsics.checkNotNullParameter(bookingsRepository, "bookingsRepository");
        Intrinsics.checkNotNullParameter(bookingHeaderMapper, "bookingHeaderMapper");
        Intrinsics.checkNotNullParameter(stringsProvider, "stringsProvider");
        Intrinsics.checkNotNullParameter(configManager, "configManager");
        this.accountBookingsService = accountBookingsService;
        this.bookingService = bookingService;
        this.userManager = userManager;
        this.multiRideManager = multiRideManager;
        this.commuterManager = commuterManager;
        this.bookingsRepository = bookingsRepository;
        this.bookingHeaderMapper = bookingHeaderMapper;
        this.stringsProvider = stringsProvider;
        this.configManager = configManager;
        this.ticketsState = StateFlowKt.MutableStateFlow(new TicketsState(null, null == true ? 1 : 0, 3, null == true ? 1 : 0));
        this.activeTicketsCount = StateFlowKt.MutableStateFlow(0);
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.coroutineScope = CoroutineScope;
        this.previousAuthenticationType = userManager.getAuthenticationType().getValue();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass2(null), 3, null);
        listenForAuthentication();
        listenForAlternateBookingSources();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x02c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x02e9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x02bf -> B:14:0x02c2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01ba -> B:46:0x01c2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object addTickets(java.util.List<dk.molslinjen.domain.managers.ticket.TicketsManager.SimpleBookingFetchInfo> r18, kotlin.coroutines.Continuation<? super dk.molslinjen.domain.managers.ManagerResult<kotlin.Unit>> r19) {
        /*
            Method dump skipped, instructions count: 786
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.domain.managers.ticket.TicketsManager.addTickets(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable addTickets$lambda$14$lambda$12(BookingHeader it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getDate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable addTickets$lambda$14$lambda$13(BookingHeader it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getDepartureTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final String addTicketsAfterPurchase$lambda$16(Ref$ObjectRef ref$ObjectRef, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (String) ref$ObjectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0094 A[PHI: r2
      0x0094: PHI (r2v8 java.lang.Object) = (r2v7 java.lang.Object), (r2v1 java.lang.Object) binds: [B:17:0x0091, B:10:0x002e] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getBookingHeaders(List<BookingsRequestParameters.BookingRequestParameters> list, Continuation<? super ApiResult<? extends List<BookingHeader>>> continuation) {
        TicketsManager$getBookingHeaders$1 ticketsManager$getBookingHeaders$1;
        int i5;
        TicketsManager ticketsManager;
        if (continuation instanceof TicketsManager$getBookingHeaders$1) {
            ticketsManager$getBookingHeaders$1 = (TicketsManager$getBookingHeaders$1) continuation;
            int i6 = ticketsManager$getBookingHeaders$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                ticketsManager$getBookingHeaders$1.label = i6 - Integer.MIN_VALUE;
                Object obj = ticketsManager$getBookingHeaders$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = ticketsManager$getBookingHeaders$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Logger.log$default(Logger.INSTANCE, "Get bookings: " + CollectionsKt.joinToString$default(list, null, null, null, 0, null, new Function1() { // from class: G1.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            CharSequence bookingHeaders$lambda$22;
                            bookingHeaders$lambda$22 = TicketsManager.getBookingHeaders$lambda$22((BookingsRequestParameters.BookingRequestParameters) obj2);
                            return bookingHeaders$lambda$22;
                        }
                    }, 31, null), null, 0, 6, null);
                    IBookingService iBookingService = this.bookingService;
                    BookingsRequestParameters bookingsRequestParameters = new BookingsRequestParameters(list);
                    ticketsManager$getBookingHeaders$1.L$0 = this;
                    ticketsManager$getBookingHeaders$1.label = 1;
                    obj = iBookingService.getBookingHeaders(bookingsRequestParameters, ticketsManager$getBookingHeaders$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ticketsManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ticketsManager = (TicketsManager) ticketsManager$getBookingHeaders$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ticketsManager$getBookingHeaders$1.L$0 = null;
                ticketsManager$getBookingHeaders$1.label = 2;
                obj = ticketsManager.mapBookingHeadersResponse((ApiResult) obj, ticketsManager$getBookingHeaders$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        ticketsManager$getBookingHeaders$1 = new TicketsManager$getBookingHeaders$1(this, continuation);
        Object obj2 = ticketsManager$getBookingHeaders$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = ticketsManager$getBookingHeaders$1.label;
        if (i5 != 0) {
        }
        ticketsManager$getBookingHeaders$1.L$0 = null;
        ticketsManager$getBookingHeaders$1.label = 2;
        obj2 = ticketsManager.mapBookingHeadersResponse((ApiResult) obj2, ticketsManager$getBookingHeaders$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getBookingHeaders$lambda$22(BookingsRequestParameters.BookingRequestParameters it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getReservationNumber() + " " + it.getPhone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0060 A[PHI: r7
      0x0060: PHI (r7v7 java.lang.Object) = (r7v6 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x005d, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getBookingHeadersWithoutRetry(List<BookingsRequestParameters.BookingRequestParameters> list, Continuation<? super ApiResult<? extends List<BookingHeader>>> continuation) {
        TicketsManager$getBookingHeadersWithoutRetry$1 ticketsManager$getBookingHeadersWithoutRetry$1;
        int i5;
        TicketsManager ticketsManager;
        if (continuation instanceof TicketsManager$getBookingHeadersWithoutRetry$1) {
            ticketsManager$getBookingHeadersWithoutRetry$1 = (TicketsManager$getBookingHeadersWithoutRetry$1) continuation;
            int i6 = ticketsManager$getBookingHeadersWithoutRetry$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                ticketsManager$getBookingHeadersWithoutRetry$1.label = i6 - Integer.MIN_VALUE;
                Object obj = ticketsManager$getBookingHeadersWithoutRetry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = ticketsManager$getBookingHeadersWithoutRetry$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IBookingService iBookingService = this.bookingService;
                    BookingsRequestParameters bookingsRequestParameters = new BookingsRequestParameters(list);
                    ticketsManager$getBookingHeadersWithoutRetry$1.L$0 = this;
                    ticketsManager$getBookingHeadersWithoutRetry$1.label = 1;
                    obj = iBookingService.getBookingHeadersWithoutRetry(bookingsRequestParameters, ticketsManager$getBookingHeadersWithoutRetry$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ticketsManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ticketsManager = (TicketsManager) ticketsManager$getBookingHeadersWithoutRetry$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ticketsManager$getBookingHeadersWithoutRetry$1.L$0 = null;
                ticketsManager$getBookingHeadersWithoutRetry$1.label = 2;
                obj = ticketsManager.mapBookingHeadersResponse((ApiResult) obj, ticketsManager$getBookingHeadersWithoutRetry$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        ticketsManager$getBookingHeadersWithoutRetry$1 = new TicketsManager$getBookingHeadersWithoutRetry$1(this, continuation);
        Object obj2 = ticketsManager$getBookingHeadersWithoutRetry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = ticketsManager$getBookingHeadersWithoutRetry$1.label;
        if (i5 != 0) {
        }
        ticketsManager$getBookingHeadersWithoutRetry$1.L$0 = null;
        ticketsManager$getBookingHeadersWithoutRetry$1.label = 2;
        obj2 = ticketsManager.mapBookingHeadersResponse((ApiResult) obj2, ticketsManager$getBookingHeadersWithoutRetry$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final String getReturnReservationNumber$lambda$15(Ref$ObjectRef ref$ObjectRef, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (String) ref$ObjectRef.element;
    }

    private final void listenForAlternateBookingSources() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new TicketsManager$listenForAlternateBookingSources$1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new TicketsManager$listenForAlternateBookingSources$2(this, null), 3, null);
    }

    private final void listenForAuthentication() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new TicketsManager$listenForAuthentication$1(this, null), 3, null);
    }

    private final Object mapBookingHeadersResponse(ApiResult<BookingHeadersResponseDTO> apiResult, Continuation<? super ApiResult<? extends List<BookingHeader>>> continuation) {
        return ApiResultExtensionsKt.mapOnSuccess(apiResult, new TicketsManager$mapBookingHeadersResponse$2(this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateWithBookingsFromCommuterManager(Continuation<? super Unit> continuation) {
        Object updateFromAlternateSource = updateFromAlternateSource(this.commuterManager.getAgreementBookingsAsAlternateSource(), continuation);
        return updateFromAlternateSource == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateFromAlternateSource : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateWithBookingsFromMultiRideManager(Continuation<? super Unit> continuation) {
        TicketsManager$updateWithBookingsFromMultiRideManager$1 ticketsManager$updateWithBookingsFromMultiRideManager$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        TicketsManager ticketsManager;
        if (continuation instanceof TicketsManager$updateWithBookingsFromMultiRideManager$1) {
            ticketsManager$updateWithBookingsFromMultiRideManager$1 = (TicketsManager$updateWithBookingsFromMultiRideManager$1) continuation;
            int i6 = ticketsManager$updateWithBookingsFromMultiRideManager$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                ticketsManager$updateWithBookingsFromMultiRideManager$1.label = i6 - Integer.MIN_VALUE;
                obj = ticketsManager$updateWithBookingsFromMultiRideManager$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = ticketsManager$updateWithBookingsFromMultiRideManager$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IMultiRideManager iMultiRideManager = this.multiRideManager;
                    ticketsManager$updateWithBookingsFromMultiRideManager$1.L$0 = this;
                    ticketsManager$updateWithBookingsFromMultiRideManager$1.label = 1;
                    obj = iMultiRideManager.getAgreementBookingsAsAlternateSource(ticketsManager$updateWithBookingsFromMultiRideManager$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ticketsManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    ticketsManager = (TicketsManager) ticketsManager$updateWithBookingsFromMultiRideManager$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ticketsManager$updateWithBookingsFromMultiRideManager$1.L$0 = null;
                ticketsManager$updateWithBookingsFromMultiRideManager$1.label = 2;
                if (ticketsManager.updateFromAlternateSource((List) obj, ticketsManager$updateWithBookingsFromMultiRideManager$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        ticketsManager$updateWithBookingsFromMultiRideManager$1 = new TicketsManager$updateWithBookingsFromMultiRideManager$1(this, continuation);
        obj = ticketsManager$updateWithBookingsFromMultiRideManager$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = ticketsManager$updateWithBookingsFromMultiRideManager$1.label;
        if (i5 != 0) {
        }
        ticketsManager$updateWithBookingsFromMultiRideManager$1.L$0 = null;
        ticketsManager$updateWithBookingsFromMultiRideManager$1.label = 2;
        if (ticketsManager.updateFromAlternateSource((List) obj, ticketsManager$updateWithBookingsFromMultiRideManager$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.managers.ticket.ITicketsManager
    public Object addTicket(PhoneNumber phoneNumber, String str, Continuation<? super ManagerResult<Unit>> continuation) {
        return addTickets(CollectionsKt.listOf(new SimpleBookingFetchInfo(str, phoneNumber.getCountryCode() + phoneNumber.getNationalNumber())), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // dk.molslinjen.domain.managers.ticket.ITicketsManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object addTicketsAfterPurchase(PhoneNumber phoneNumber, String str, Continuation<? super ManagerResult<String>> continuation) {
        TicketsManager$addTicketsAfterPurchase$1 ticketsManager$addTicketsAfterPurchase$1;
        Object coroutine_suspended;
        int i5;
        TicketsManager ticketsManager;
        Object obj;
        String str2;
        TicketsManager ticketsManager2;
        Object mapBookingHeadersResponse;
        String str3;
        ApiResult apiResult;
        TicketsManager$addTicketsAfterPurchase$2 ticketsManager$addTicketsAfterPurchase$2;
        ApiResult apiResult2;
        final Ref$ObjectRef ref$ObjectRef;
        if (continuation instanceof TicketsManager$addTicketsAfterPurchase$1) {
            ticketsManager$addTicketsAfterPurchase$1 = (TicketsManager$addTicketsAfterPurchase$1) continuation;
            int i6 = ticketsManager$addTicketsAfterPurchase$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                ticketsManager$addTicketsAfterPurchase$1.label = i6 - Integer.MIN_VALUE;
                Object obj2 = ticketsManager$addTicketsAfterPurchase$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = ticketsManager$addTicketsAfterPurchase$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    if (this.userManager.mo3198getAuthTokenOEbVFrA() != null) {
                        return new ManagerResult.Success(null);
                    }
                    String str4 = phoneNumber.getCountryCode() + phoneNumber.getNationalNumber();
                    IBookingService iBookingService = this.bookingService;
                    ticketsManager$addTicketsAfterPurchase$1.L$0 = this;
                    ticketsManager$addTicketsAfterPurchase$1.L$1 = str;
                    ticketsManager$addTicketsAfterPurchase$1.L$2 = this;
                    ticketsManager$addTicketsAfterPurchase$1.label = 1;
                    Object bookingHeadersIncludingReturn = iBookingService.getBookingHeadersIncludingReturn(str, str4, ticketsManager$addTicketsAfterPurchase$1);
                    if (bookingHeadersIncludingReturn == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ticketsManager = this;
                    obj = bookingHeadersIncludingReturn;
                    str2 = str;
                    ticketsManager2 = ticketsManager;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ref$ObjectRef = (Ref$ObjectRef) ticketsManager$addTicketsAfterPurchase$1.L$1;
                            apiResult2 = (ApiResult) ticketsManager$addTicketsAfterPurchase$1.L$0;
                            ResultKt.throwOnFailure(obj2);
                            return ManagerResultExtensionsKt.toManagerResult(apiResult2, new Function1() { // from class: G1.d
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    String addTicketsAfterPurchase$lambda$16;
                                    addTicketsAfterPurchase$lambda$16 = TicketsManager.addTicketsAfterPurchase$lambda$16(Ref$ObjectRef.this, (List) obj3);
                                    return addTicketsAfterPurchase$lambda$16;
                                }
                            });
                        }
                        str3 = (String) ticketsManager$addTicketsAfterPurchase$1.L$1;
                        ticketsManager2 = (TicketsManager) ticketsManager$addTicketsAfterPurchase$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        apiResult = (ApiResult) obj2;
                        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                        ticketsManager$addTicketsAfterPurchase$2 = new TicketsManager$addTicketsAfterPurchase$2(ref$ObjectRef2, ticketsManager2, str3, null);
                        ticketsManager$addTicketsAfterPurchase$1.L$0 = apiResult;
                        ticketsManager$addTicketsAfterPurchase$1.L$1 = ref$ObjectRef2;
                        ticketsManager$addTicketsAfterPurchase$1.label = 3;
                        if (ApiResultExtensionsKt.onSuccess(apiResult, ticketsManager$addTicketsAfterPurchase$2, ticketsManager$addTicketsAfterPurchase$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        apiResult2 = apiResult;
                        ref$ObjectRef = ref$ObjectRef2;
                        return ManagerResultExtensionsKt.toManagerResult(apiResult2, new Function1() { // from class: G1.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                String addTicketsAfterPurchase$lambda$16;
                                addTicketsAfterPurchase$lambda$16 = TicketsManager.addTicketsAfterPurchase$lambda$16(Ref$ObjectRef.this, (List) obj3);
                                return addTicketsAfterPurchase$lambda$16;
                            }
                        });
                    }
                    ticketsManager = (TicketsManager) ticketsManager$addTicketsAfterPurchase$1.L$2;
                    String str5 = (String) ticketsManager$addTicketsAfterPurchase$1.L$1;
                    TicketsManager ticketsManager3 = (TicketsManager) ticketsManager$addTicketsAfterPurchase$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    str2 = str5;
                    ticketsManager2 = ticketsManager3;
                    obj = obj2;
                }
                ticketsManager$addTicketsAfterPurchase$1.L$0 = ticketsManager2;
                ticketsManager$addTicketsAfterPurchase$1.L$1 = str2;
                ticketsManager$addTicketsAfterPurchase$1.L$2 = null;
                ticketsManager$addTicketsAfterPurchase$1.label = 2;
                mapBookingHeadersResponse = ticketsManager.mapBookingHeadersResponse((ApiResult) obj, ticketsManager$addTicketsAfterPurchase$1);
                if (mapBookingHeadersResponse != coroutine_suspended) {
                    return coroutine_suspended;
                }
                String str6 = str2;
                obj2 = mapBookingHeadersResponse;
                str3 = str6;
                apiResult = (ApiResult) obj2;
                Ref$ObjectRef ref$ObjectRef22 = new Ref$ObjectRef();
                ticketsManager$addTicketsAfterPurchase$2 = new TicketsManager$addTicketsAfterPurchase$2(ref$ObjectRef22, ticketsManager2, str3, null);
                ticketsManager$addTicketsAfterPurchase$1.L$0 = apiResult;
                ticketsManager$addTicketsAfterPurchase$1.L$1 = ref$ObjectRef22;
                ticketsManager$addTicketsAfterPurchase$1.label = 3;
                if (ApiResultExtensionsKt.onSuccess(apiResult, ticketsManager$addTicketsAfterPurchase$2, ticketsManager$addTicketsAfterPurchase$1) != coroutine_suspended) {
                }
            }
        }
        ticketsManager$addTicketsAfterPurchase$1 = new TicketsManager$addTicketsAfterPurchase$1(this, continuation);
        Object obj22 = ticketsManager$addTicketsAfterPurchase$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = ticketsManager$addTicketsAfterPurchase$1.label;
        if (i5 != 0) {
        }
        ticketsManager$addTicketsAfterPurchase$1.L$0 = ticketsManager2;
        ticketsManager$addTicketsAfterPurchase$1.L$1 = str2;
        ticketsManager$addTicketsAfterPurchase$1.L$2 = null;
        ticketsManager$addTicketsAfterPurchase$1.label = 2;
        mapBookingHeadersResponse = ticketsManager.mapBookingHeadersResponse((ApiResult) obj, ticketsManager$addTicketsAfterPurchase$1);
        if (mapBookingHeadersResponse != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Override // dk.molslinjen.domain.managers.ticket.ITicketsManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object downloadReceipt(String str, String str2, File file, Continuation<? super ManagerResult<Unit>> continuation) {
        TicketsManager$downloadReceipt$1 ticketsManager$downloadReceipt$1;
        int i5;
        if (continuation instanceof TicketsManager$downloadReceipt$1) {
            ticketsManager$downloadReceipt$1 = (TicketsManager$downloadReceipt$1) continuation;
            int i6 = ticketsManager$downloadReceipt$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                ticketsManager$downloadReceipt$1.label = i6 - Integer.MIN_VALUE;
                TicketsManager$downloadReceipt$1 ticketsManager$downloadReceipt$12 = ticketsManager$downloadReceipt$1;
                Object obj = ticketsManager$downloadReceipt$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = ticketsManager$downloadReceipt$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IAccountBookingsService iAccountBookingsService = this.accountBookingsService;
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    ticketsManager$downloadReceipt$12.label = 1;
                    obj = iAccountBookingsService.downloadReceiptPdf(str, str2, m3214toDTOimpl, file, ticketsManager$downloadReceipt$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
            }
        }
        ticketsManager$downloadReceipt$1 = new TicketsManager$downloadReceipt$1(this, continuation);
        TicketsManager$downloadReceipt$1 ticketsManager$downloadReceipt$122 = ticketsManager$downloadReceipt$1;
        Object obj2 = ticketsManager$downloadReceipt$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = ticketsManager$downloadReceipt$122.label;
        if (i5 != 0) {
        }
        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // dk.molslinjen.domain.managers.ticket.ITicketsManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getBooking(String str, String str2, Site site, Continuation<? super ManagerResult<Booking>> continuation) {
        TicketsManager$getBooking$1 ticketsManager$getBooking$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        TicketsState value;
        TicketsManager ticketsManager;
        if (continuation instanceof TicketsManager$getBooking$1) {
            ticketsManager$getBooking$1 = (TicketsManager$getBooking$1) continuation;
            int i6 = ticketsManager$getBooking$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                ticketsManager$getBooking$1.label = i6 - Integer.MIN_VALUE;
                obj = ticketsManager$getBooking$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = ticketsManager$getBooking$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableStateFlow<TicketsState> ticketsState = getTicketsState();
                    do {
                        value = ticketsState.getValue();
                    } while (!ticketsState.compareAndSet(value, TicketsState.copy$default(value, null, null, 1, null)));
                    IBookingService iBookingService = this.bookingService;
                    SiteDTO dto = site.toDTO();
                    ticketsManager$getBooking$1.L$0 = this;
                    ticketsManager$getBooking$1.L$1 = site;
                    ticketsManager$getBooking$1.label = 1;
                    obj = iBookingService.getBooking(str, str2, dto, ticketsManager$getBooking$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ticketsManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
                    }
                    site = (Site) ticketsManager$getBooking$1.L$1;
                    ticketsManager = (TicketsManager) ticketsManager$getBooking$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                TicketsManager$getBooking$3 ticketsManager$getBooking$3 = new TicketsManager$getBooking$3(ticketsManager, site, null);
                ticketsManager$getBooking$1.L$0 = null;
                ticketsManager$getBooking$1.L$1 = null;
                ticketsManager$getBooking$1.label = 2;
                obj = ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, ticketsManager$getBooking$3, ticketsManager$getBooking$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
            }
        }
        ticketsManager$getBooking$1 = new TicketsManager$getBooking$1(this, continuation);
        obj = ticketsManager$getBooking$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = ticketsManager$getBooking$1.label;
        if (i5 != 0) {
        }
        TicketsManager$getBooking$3 ticketsManager$getBooking$32 = new TicketsManager$getBooking$3(ticketsManager, site, null);
        ticketsManager$getBooking$1.L$0 = null;
        ticketsManager$getBooking$1.L$1 = null;
        ticketsManager$getBooking$1.label = 2;
        obj = ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, ticketsManager$getBooking$32, ticketsManager$getBooking$1);
        if (obj == coroutine_suspended) {
        }
        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // dk.molslinjen.domain.managers.ticket.ITicketsManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getReturnReservationNumber(PhoneNumber phoneNumber, String str, Continuation<? super ManagerResult<String>> continuation) {
        TicketsManager$getReturnReservationNumber$1 ticketsManager$getReturnReservationNumber$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        TicketsManager ticketsManager;
        String str2;
        ApiResult apiResult;
        TicketsManager$getReturnReservationNumber$2 ticketsManager$getReturnReservationNumber$2;
        final Ref$ObjectRef ref$ObjectRef;
        if (continuation instanceof TicketsManager$getReturnReservationNumber$1) {
            ticketsManager$getReturnReservationNumber$1 = (TicketsManager$getReturnReservationNumber$1) continuation;
            int i6 = ticketsManager$getReturnReservationNumber$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                ticketsManager$getReturnReservationNumber$1.label = i6 - Integer.MIN_VALUE;
                obj = ticketsManager$getReturnReservationNumber$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = ticketsManager$getReturnReservationNumber$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String str3 = phoneNumber.getCountryCode() + phoneNumber.getNationalNumber();
                    IBookingService iBookingService = this.bookingService;
                    ticketsManager$getReturnReservationNumber$1.L$0 = str;
                    ticketsManager$getReturnReservationNumber$1.L$1 = this;
                    ticketsManager$getReturnReservationNumber$1.label = 1;
                    obj = iBookingService.getBookingHeadersIncludingReturn(str, str3, ticketsManager$getReturnReservationNumber$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ticketsManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ref$ObjectRef = (Ref$ObjectRef) ticketsManager$getReturnReservationNumber$1.L$1;
                            apiResult = (ApiResult) ticketsManager$getReturnReservationNumber$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            return ManagerResultExtensionsKt.toManagerResult(apiResult, new Function1() { // from class: G1.e
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    String returnReservationNumber$lambda$15;
                                    returnReservationNumber$lambda$15 = TicketsManager.getReturnReservationNumber$lambda$15(Ref$ObjectRef.this, (List) obj2);
                                    return returnReservationNumber$lambda$15;
                                }
                            });
                        }
                        str2 = (String) ticketsManager$getReturnReservationNumber$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        apiResult = (ApiResult) obj;
                        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                        ticketsManager$getReturnReservationNumber$2 = new TicketsManager$getReturnReservationNumber$2(ref$ObjectRef2, str2, null);
                        ticketsManager$getReturnReservationNumber$1.L$0 = apiResult;
                        ticketsManager$getReturnReservationNumber$1.L$1 = ref$ObjectRef2;
                        ticketsManager$getReturnReservationNumber$1.label = 3;
                        if (ApiResultExtensionsKt.onSuccess(apiResult, ticketsManager$getReturnReservationNumber$2, ticketsManager$getReturnReservationNumber$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ref$ObjectRef = ref$ObjectRef2;
                        return ManagerResultExtensionsKt.toManagerResult(apiResult, new Function1() { // from class: G1.e
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                String returnReservationNumber$lambda$15;
                                returnReservationNumber$lambda$15 = TicketsManager.getReturnReservationNumber$lambda$15(Ref$ObjectRef.this, (List) obj2);
                                return returnReservationNumber$lambda$15;
                            }
                        });
                    }
                    ticketsManager = (TicketsManager) ticketsManager$getReturnReservationNumber$1.L$1;
                    str = (String) ticketsManager$getReturnReservationNumber$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ticketsManager$getReturnReservationNumber$1.L$0 = str;
                ticketsManager$getReturnReservationNumber$1.L$1 = null;
                ticketsManager$getReturnReservationNumber$1.label = 2;
                obj = ticketsManager.mapBookingHeadersResponse((ApiResult) obj, ticketsManager$getReturnReservationNumber$1);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                str2 = str;
                apiResult = (ApiResult) obj;
                Ref$ObjectRef ref$ObjectRef22 = new Ref$ObjectRef();
                ticketsManager$getReturnReservationNumber$2 = new TicketsManager$getReturnReservationNumber$2(ref$ObjectRef22, str2, null);
                ticketsManager$getReturnReservationNumber$1.L$0 = apiResult;
                ticketsManager$getReturnReservationNumber$1.L$1 = ref$ObjectRef22;
                ticketsManager$getReturnReservationNumber$1.label = 3;
                if (ApiResultExtensionsKt.onSuccess(apiResult, ticketsManager$getReturnReservationNumber$2, ticketsManager$getReturnReservationNumber$1) != coroutine_suspended) {
                }
            }
        }
        ticketsManager$getReturnReservationNumber$1 = new TicketsManager$getReturnReservationNumber$1(this, continuation);
        obj = ticketsManager$getReturnReservationNumber$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = ticketsManager$getReturnReservationNumber$1.label;
        if (i5 != 0) {
        }
        ticketsManager$getReturnReservationNumber$1.L$0 = str;
        ticketsManager$getReturnReservationNumber$1.L$1 = null;
        ticketsManager$getReturnReservationNumber$1.label = 2;
        obj = ticketsManager.mapBookingHeadersResponse((ApiResult) obj, ticketsManager$getReturnReservationNumber$1);
        if (obj != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // dk.molslinjen.domain.managers.ticket.ITicketsManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getTicketHistory(int i5, int i6, Continuation<? super ManagerResult<? extends List<BookingHeader>>> continuation) {
        TicketsManager$getTicketHistory$1 ticketsManager$getTicketHistory$1;
        int i7;
        TicketsManager ticketsManager;
        if (continuation instanceof TicketsManager$getTicketHistory$1) {
            ticketsManager$getTicketHistory$1 = (TicketsManager$getTicketHistory$1) continuation;
            int i8 = ticketsManager$getTicketHistory$1.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                ticketsManager$getTicketHistory$1.label = i8 - Integer.MIN_VALUE;
                Object obj = ticketsManager$getTicketHistory$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i7 = ticketsManager$getTicketHistory$1.label;
                if (i7 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        IBookingsRepository iBookingsRepository = this.bookingsRepository;
                        ticketsManager$getTicketHistory$1.I$0 = i5;
                        ticketsManager$getTicketHistory$1.I$1 = i6;
                        ticketsManager$getTicketHistory$1.label = 3;
                        obj = iBookingsRepository.getBookings(ticketsManager$getTicketHistory$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ArrayList arrayList = new ArrayList();
                        while (r9.hasNext()) {
                        }
                        final Comparator comparator = new Comparator() { // from class: dk.molslinjen.domain.managers.ticket.TicketsManager$getTicketHistory$$inlined$compareByDescending$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t5, T t6) {
                                return ComparisonsKt.compareValues(((BookingHeader) t6).getDate(), ((BookingHeader) t5).getDate());
                            }
                        };
                        return new ManagerResult.Success(CollectionsKt.take(CollectionsKt.drop(CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: dk.molslinjen.domain.managers.ticket.TicketsManager$getTicketHistory$$inlined$thenByDescending$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t5, T t6) {
                                int compare = comparator.compare(t5, t6);
                                return compare != 0 ? compare : ComparisonsKt.compareValues(((BookingHeader) t6).getDepartureTime(), ((BookingHeader) t5).getDepartureTime());
                            }
                        }), (i5 - 1) * i6), i6));
                    }
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    ticketsManager$getTicketHistory$1.L$0 = this;
                    ticketsManager$getTicketHistory$1.label = 1;
                    obj = this.accountBookingsService.getHistoricBookings(i6, (i5 - 1) * i6, m3214toDTOimpl, ticketsManager$getTicketHistory$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ticketsManager = this;
                    TicketsManager$getTicketHistory$result$1 ticketsManager$getTicketHistory$result$1 = new TicketsManager$getTicketHistory$result$1(ticketsManager, null);
                    ticketsManager$getTicketHistory$1.L$0 = null;
                    ticketsManager$getTicketHistory$1.label = 2;
                    obj = ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, ticketsManager$getTicketHistory$result$1, ticketsManager$getTicketHistory$1);
                    if (obj == coroutine_suspended) {
                    }
                } else if (i7 == 1) {
                    ticketsManager = (TicketsManager) ticketsManager$getTicketHistory$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    TicketsManager$getTicketHistory$result$1 ticketsManager$getTicketHistory$result$12 = new TicketsManager$getTicketHistory$result$1(ticketsManager, null);
                    ticketsManager$getTicketHistory$1.L$0 = null;
                    ticketsManager$getTicketHistory$1.label = 2;
                    obj = ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, ticketsManager$getTicketHistory$result$12, ticketsManager$getTicketHistory$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i6 = ticketsManager$getTicketHistory$1.I$1;
                        i5 = ticketsManager$getTicketHistory$1.I$0;
                        ResultKt.throwOnFailure(obj);
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj2 : (Iterable) obj) {
                            if (!((BookingHeader) obj2).isActive()) {
                                arrayList2.add(obj2);
                            }
                        }
                        final Comparator comparator2 = new Comparator() { // from class: dk.molslinjen.domain.managers.ticket.TicketsManager$getTicketHistory$$inlined$compareByDescending$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t5, T t6) {
                                return ComparisonsKt.compareValues(((BookingHeader) t6).getDate(), ((BookingHeader) t5).getDate());
                            }
                        };
                        return new ManagerResult.Success(CollectionsKt.take(CollectionsKt.drop(CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: dk.molslinjen.domain.managers.ticket.TicketsManager$getTicketHistory$$inlined$thenByDescending$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t5, T t6) {
                                int compare = comparator2.compare(t5, t6);
                                return compare != 0 ? compare : ComparisonsKt.compareValues(((BookingHeader) t6).getDepartureTime(), ((BookingHeader) t5).getDepartureTime());
                            }
                        }), (i5 - 1) * i6), i6));
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
            }
        }
        ticketsManager$getTicketHistory$1 = new TicketsManager$getTicketHistory$1(this, continuation);
        Object obj3 = ticketsManager$getTicketHistory$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i7 = ticketsManager$getTicketHistory$1.label;
        if (i7 != 0) {
        }
        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj3);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.ticket.ITicketsManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object refund(Booking booking, Site site, Continuation<? super ManagerResult<Unit>> continuation) {
        TicketsManager$refund$1 ticketsManager$refund$1;
        int i5;
        if (continuation instanceof TicketsManager$refund$1) {
            ticketsManager$refund$1 = (TicketsManager$refund$1) continuation;
            int i6 = ticketsManager$refund$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                ticketsManager$refund$1.label = i6 - Integer.MIN_VALUE;
                Object obj = ticketsManager$refund$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = ticketsManager$refund$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IBookingService iBookingService = this.bookingService;
                    String reservationNumber = booking.getReservationNumber();
                    String nationalNumber = booking.getCustomerInfo().getPhoneNumber().getNationalNumber();
                    SiteDTO dto = site.toDTO();
                    ticketsManager$refund$1.label = 1;
                    obj = iBookingService.refund(reservationNumber, nationalNumber, dto, ticketsManager$refund$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
            }
        }
        ticketsManager$refund$1 = new TicketsManager$refund$1(this, continuation);
        Object obj2 = ticketsManager$refund$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = ticketsManager$refund$1.label;
        if (i5 != 0) {
        }
        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.user.merge.IAssetsMerger
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object removeLocalAssets(Continuation<? super Unit> continuation) {
        TicketsManager$removeLocalAssets$1 ticketsManager$removeLocalAssets$1;
        int i5;
        TicketsManager ticketsManager;
        MutableStateFlow<TicketsState> ticketsState;
        if (continuation instanceof TicketsManager$removeLocalAssets$1) {
            ticketsManager$removeLocalAssets$1 = (TicketsManager$removeLocalAssets$1) continuation;
            int i6 = ticketsManager$removeLocalAssets$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                ticketsManager$removeLocalAssets$1.label = i6 - Integer.MIN_VALUE;
                Object obj = ticketsManager$removeLocalAssets$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = ticketsManager$removeLocalAssets$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IBookingsRepository iBookingsRepository = this.bookingsRepository;
                    ticketsManager$removeLocalAssets$1.L$0 = this;
                    ticketsManager$removeLocalAssets$1.label = 1;
                    if (iBookingsRepository.clear(ticketsManager$removeLocalAssets$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ticketsManager = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ticketsManager = (TicketsManager) ticketsManager$removeLocalAssets$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ticketsState = ticketsManager.getTicketsState();
                do {
                } while (!ticketsState.compareAndSet(ticketsState.getValue(), new TicketsState(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)));
                return Unit.INSTANCE;
            }
        }
        ticketsManager$removeLocalAssets$1 = new TicketsManager$removeLocalAssets$1(this, continuation);
        Object obj2 = ticketsManager$removeLocalAssets$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = ticketsManager$removeLocalAssets$1.label;
        if (i5 != 0) {
        }
        ticketsState = ticketsManager.getTicketsState();
        do {
        } while (!ticketsState.compareAndSet(ticketsState.getValue(), new TicketsState(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.user.merge.IAssetsMerger
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object reportLocalAssets(Continuation<? super AssetsMergeType<?>> continuation) {
        TicketsManager$reportLocalAssets$1 ticketsManager$reportLocalAssets$1;
        int i5;
        List<BookingHeader> bookings;
        if (continuation instanceof TicketsManager$reportLocalAssets$1) {
            ticketsManager$reportLocalAssets$1 = (TicketsManager$reportLocalAssets$1) continuation;
            int i6 = ticketsManager$reportLocalAssets$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                ticketsManager$reportLocalAssets$1.label = i6 - Integer.MIN_VALUE;
                Object obj = ticketsManager$reportLocalAssets$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = ticketsManager$reportLocalAssets$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    bookings = getTicketsState().getValue().getBookings();
                    if (bookings.isEmpty()) {
                        IBookingsRepository iBookingsRepository = this.bookingsRepository;
                        ticketsManager$reportLocalAssets$1.label = 1;
                        obj = iBookingsRepository.getBookings(ticketsManager$reportLocalAssets$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return new AssetsMergeType.Tickets(bookings);
                }
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                bookings = (List) obj;
                return new AssetsMergeType.Tickets(bookings);
            }
        }
        ticketsManager$reportLocalAssets$1 = new TicketsManager$reportLocalAssets$1(this, continuation);
        Object obj2 = ticketsManager$reportLocalAssets$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = ticketsManager$reportLocalAssets$1.label;
        if (i5 != 0) {
        }
        bookings = (List) obj2;
        return new AssetsMergeType.Tickets(bookings);
    }

    @Override // dk.molslinjen.domain.managers.ticket.ITicketsManager
    public void updateActiveTicketCount(TicketsState state) {
        Integer value;
        int i5;
        Intrinsics.checkNotNullParameter(state, "state");
        MutableStateFlow<Integer> activeTicketsCount = getActiveTicketsCount();
        do {
            value = activeTicketsCount.getValue();
            value.intValue();
            List<BookingHeader> bookings = state.getBookings();
            i5 = 0;
            if (!(bookings instanceof Collection) || !bookings.isEmpty()) {
                Iterator<T> it = bookings.iterator();
                while (it.hasNext()) {
                    if (((BookingHeader) it.next()).isActive() && (i5 = i5 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
        } while (!activeTicketsCount.compareAndSet(value, Integer.valueOf(i5)));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b7 A[LOOP:2: B:38:0x00b1->B:40:0x00b7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateFromAlternateSource(List<BookingFromAlternateSource> list, Continuation<? super Unit> continuation) {
        TicketsManager$updateFromAlternateSource$1 ticketsManager$updateFromAlternateSource$1;
        Object coroutine_suspended;
        int i5;
        TicketsManager ticketsManager;
        ArrayList arrayList;
        if (continuation instanceof TicketsManager$updateFromAlternateSource$1) {
            ticketsManager$updateFromAlternateSource$1 = (TicketsManager$updateFromAlternateSource$1) continuation;
            int i6 = ticketsManager$updateFromAlternateSource$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                ticketsManager$updateFromAlternateSource$1.label = i6 - Integer.MIN_VALUE;
                Object obj = ticketsManager$updateFromAlternateSource$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = ticketsManager$updateFromAlternateSource$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IBookingsRepository iBookingsRepository = this.bookingsRepository;
                    ticketsManager$updateFromAlternateSource$1.L$0 = this;
                    ticketsManager$updateFromAlternateSource$1.L$1 = list;
                    ticketsManager$updateFromAlternateSource$1.label = 1;
                    obj = iBookingsRepository.getBookings(ticketsManager$updateFromAlternateSource$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ticketsManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    list = (List) ticketsManager$updateFromAlternateSource$1.L$1;
                    ticketsManager = (TicketsManager) ticketsManager$updateFromAlternateSource$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                List list2 = (List) obj;
                ArrayList<BookingFromAlternateSource> arrayList2 = new ArrayList();
                for (Object obj2 : list) {
                    BookingFromAlternateSource bookingFromAlternateSource = (BookingFromAlternateSource) obj2;
                    List list3 = list2;
                    if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                        Iterator it = list3.iterator();
                        while (it.hasNext()) {
                            if (Intrinsics.areEqual(((BookingHeader) it.next()).getReservationId(), bookingFromAlternateSource.getReservationNumber())) {
                                break;
                            }
                        }
                    }
                    arrayList2.add(obj2);
                }
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                for (BookingFromAlternateSource bookingFromAlternateSource2 : arrayList2) {
                    arrayList.add(new SimpleBookingFetchInfo(bookingFromAlternateSource2.getReservationNumber(), bookingFromAlternateSource2.getPhone()));
                }
                ticketsManager$updateFromAlternateSource$1.L$0 = null;
                ticketsManager$updateFromAlternateSource$1.L$1 = null;
                ticketsManager$updateFromAlternateSource$1.label = 2;
                if (ticketsManager.addTickets(arrayList, ticketsManager$updateFromAlternateSource$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        ticketsManager$updateFromAlternateSource$1 = new TicketsManager$updateFromAlternateSource$1(this, continuation);
        Object obj3 = ticketsManager$updateFromAlternateSource$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = ticketsManager$updateFromAlternateSource$1.label;
        if (i5 != 0) {
        }
        List list22 = (List) obj3;
        ArrayList<BookingFromAlternateSource> arrayList22 = new ArrayList();
        while (r11.hasNext()) {
        }
        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList22, 10));
        while (r12.hasNext()) {
        }
        ticketsManager$updateFromAlternateSource$1.L$0 = null;
        ticketsManager$updateFromAlternateSource$1.L$1 = null;
        ticketsManager$updateFromAlternateSource$1.label = 2;
        if (ticketsManager.addTickets(arrayList, ticketsManager$updateFromAlternateSource$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0021. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0132 A[PHI: r9
      0x0132: PHI (r9v27 java.lang.Object) = (r9v26 java.lang.Object), (r9v1 java.lang.Object) binds: [B:15:0x012f, B:11:0x002c] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0131 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0123 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e0 A[LOOP:0: B:24:0x00da->B:26:0x00e0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b9 A[PHI: r9
      0x00b9: PHI (r9v15 java.lang.Object) = (r9v14 java.lang.Object), (r9v1 java.lang.Object) binds: [B:39:0x00b6, B:35:0x004c] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.ticket.ITicketsManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateLocalBookings(Continuation<? super ManagerResult<Unit>> continuation) {
        TicketsManager$updateLocalBookings$1 ticketsManager$updateLocalBookings$1;
        TicketsManager ticketsManager;
        TicketsManager ticketsManager2;
        ApiResult apiResult;
        TicketsManager$updateLocalBookings$2 ticketsManager$updateLocalBookings$2;
        ApiResult apiResult2;
        ArrayList arrayList;
        ApiResult apiResult3;
        TicketsManager$updateLocalBookings$3 ticketsManager$updateLocalBookings$3;
        ApiResult apiResult4;
        if (continuation instanceof TicketsManager$updateLocalBookings$1) {
            ticketsManager$updateLocalBookings$1 = (TicketsManager$updateLocalBookings$1) continuation;
            int i5 = ticketsManager$updateLocalBookings$1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                ticketsManager$updateLocalBookings$1.label = i5 - Integer.MIN_VALUE;
                Object obj = ticketsManager$updateLocalBookings$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (ticketsManager$updateLocalBookings$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                        if (mo3198getAuthTokenOEbVFrA != null) {
                            IAccountBookingsService iAccountBookingsService = this.accountBookingsService;
                            AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                            ticketsManager$updateLocalBookings$1.L$0 = this;
                            ticketsManager$updateLocalBookings$1.label = 1;
                            obj = iAccountBookingsService.getActiveBookings(m3214toDTOimpl, ticketsManager$updateLocalBookings$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ticketsManager2 = this;
                            TicketsManager$updateLocalBookings$result$1 ticketsManager$updateLocalBookings$result$1 = new TicketsManager$updateLocalBookings$result$1(ticketsManager2, null);
                            ticketsManager$updateLocalBookings$1.L$0 = ticketsManager2;
                            ticketsManager$updateLocalBookings$1.label = 2;
                            obj = ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, ticketsManager$updateLocalBookings$result$1, ticketsManager$updateLocalBookings$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            apiResult = (ApiResult) obj;
                            ticketsManager$updateLocalBookings$2 = new TicketsManager$updateLocalBookings$2(ticketsManager2, null);
                            ticketsManager$updateLocalBookings$1.L$0 = apiResult;
                            ticketsManager$updateLocalBookings$1.label = 3;
                            if (ApiResultExtensionsKt.onSuccess(apiResult, ticketsManager$updateLocalBookings$2, ticketsManager$updateLocalBookings$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            apiResult2 = apiResult;
                            ticketsManager$updateLocalBookings$1.L$0 = null;
                            ticketsManager$updateLocalBookings$1.label = 4;
                            obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult(apiResult2, ticketsManager$updateLocalBookings$1);
                            return obj != coroutine_suspended ? coroutine_suspended : obj;
                        }
                        IBookingsRepository iBookingsRepository = this.bookingsRepository;
                        ticketsManager$updateLocalBookings$1.L$0 = this;
                        ticketsManager$updateLocalBookings$1.label = 5;
                        obj = iBookingsRepository.getBookings(ticketsManager$updateLocalBookings$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ticketsManager = this;
                        Iterable<BookingHeader> iterable = (Iterable) obj;
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                        for (BookingHeader bookingHeader : iterable) {
                            arrayList.add(new BookingsRequestParameters.BookingRequestParameters(bookingHeader.getReservationId(), bookingHeader.getPhone()));
                        }
                        if (!arrayList.isEmpty()) {
                            return new ManagerResult.Success(Unit.INSTANCE);
                        }
                        ticketsManager$updateLocalBookings$1.L$0 = ticketsManager;
                        ticketsManager$updateLocalBookings$1.label = 6;
                        obj = ticketsManager.getBookingHeaders(arrayList, ticketsManager$updateLocalBookings$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        apiResult3 = (ApiResult) obj;
                        ticketsManager$updateLocalBookings$3 = new TicketsManager$updateLocalBookings$3(ticketsManager, null);
                        ticketsManager$updateLocalBookings$1.L$0 = apiResult3;
                        ticketsManager$updateLocalBookings$1.label = 7;
                        if (ApiResultExtensionsKt.onSuccess(apiResult3, ticketsManager$updateLocalBookings$3, ticketsManager$updateLocalBookings$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        apiResult4 = apiResult3;
                        ticketsManager$updateLocalBookings$1.L$0 = null;
                        ticketsManager$updateLocalBookings$1.label = 8;
                        obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult(apiResult4, ticketsManager$updateLocalBookings$1);
                        return obj != coroutine_suspended ? coroutine_suspended : obj;
                    case 1:
                        ticketsManager2 = (TicketsManager) ticketsManager$updateLocalBookings$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        TicketsManager$updateLocalBookings$result$1 ticketsManager$updateLocalBookings$result$12 = new TicketsManager$updateLocalBookings$result$1(ticketsManager2, null);
                        ticketsManager$updateLocalBookings$1.L$0 = ticketsManager2;
                        ticketsManager$updateLocalBookings$1.label = 2;
                        obj = ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, ticketsManager$updateLocalBookings$result$12, ticketsManager$updateLocalBookings$1);
                        if (obj == coroutine_suspended) {
                        }
                        apiResult = (ApiResult) obj;
                        ticketsManager$updateLocalBookings$2 = new TicketsManager$updateLocalBookings$2(ticketsManager2, null);
                        ticketsManager$updateLocalBookings$1.L$0 = apiResult;
                        ticketsManager$updateLocalBookings$1.label = 3;
                        if (ApiResultExtensionsKt.onSuccess(apiResult, ticketsManager$updateLocalBookings$2, ticketsManager$updateLocalBookings$1) == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        ticketsManager2 = (TicketsManager) ticketsManager$updateLocalBookings$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        apiResult = (ApiResult) obj;
                        ticketsManager$updateLocalBookings$2 = new TicketsManager$updateLocalBookings$2(ticketsManager2, null);
                        ticketsManager$updateLocalBookings$1.L$0 = apiResult;
                        ticketsManager$updateLocalBookings$1.label = 3;
                        if (ApiResultExtensionsKt.onSuccess(apiResult, ticketsManager$updateLocalBookings$2, ticketsManager$updateLocalBookings$1) == coroutine_suspended) {
                        }
                        break;
                    case 3:
                        apiResult2 = (ApiResult) ticketsManager$updateLocalBookings$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        ticketsManager$updateLocalBookings$1.L$0 = null;
                        ticketsManager$updateLocalBookings$1.label = 4;
                        obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult(apiResult2, ticketsManager$updateLocalBookings$1);
                        if (obj != coroutine_suspended) {
                        }
                        break;
                    case 4:
                        ResultKt.throwOnFailure(obj);
                    case 5:
                        ticketsManager = (TicketsManager) ticketsManager$updateLocalBookings$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        Iterable<BookingHeader> iterable2 = (Iterable) obj;
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                        while (r9.hasNext()) {
                        }
                        if (!arrayList.isEmpty()) {
                        }
                        break;
                    case 6:
                        ticketsManager = (TicketsManager) ticketsManager$updateLocalBookings$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        apiResult3 = (ApiResult) obj;
                        ticketsManager$updateLocalBookings$3 = new TicketsManager$updateLocalBookings$3(ticketsManager, null);
                        ticketsManager$updateLocalBookings$1.L$0 = apiResult3;
                        ticketsManager$updateLocalBookings$1.label = 7;
                        if (ApiResultExtensionsKt.onSuccess(apiResult3, ticketsManager$updateLocalBookings$3, ticketsManager$updateLocalBookings$1) != coroutine_suspended) {
                        }
                        break;
                    case 7:
                        apiResult4 = (ApiResult) ticketsManager$updateLocalBookings$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        ticketsManager$updateLocalBookings$1.L$0 = null;
                        ticketsManager$updateLocalBookings$1.label = 8;
                        obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult(apiResult4, ticketsManager$updateLocalBookings$1);
                        if (obj != coroutine_suspended) {
                        }
                        break;
                    case 8:
                        ResultKt.throwOnFailure(obj);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        ticketsManager$updateLocalBookings$1 = new TicketsManager$updateLocalBookings$1(this, continuation);
        Object obj2 = ticketsManager$updateLocalBookings$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (ticketsManager$updateLocalBookings$1.label) {
        }
    }

    @Override // dk.molslinjen.domain.managers.ticket.ITicketsManager
    public MutableStateFlow<Integer> getActiveTicketsCount() {
        return this.activeTicketsCount;
    }

    @Override // dk.molslinjen.domain.managers.ticket.ITicketsManager
    public MutableStateFlow<TicketsState> getTicketsState() {
        return this.ticketsState;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/domain/managers/ticket/TicketsManager$TicketsState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingHeader;", "bookings", "Ldk/molslinjen/domain/model/booking/Booking;", "lastActiveBooking", "<init>", "(Ljava/util/List;Ldk/molslinjen/domain/model/booking/Booking;)V", "copy", "(Ljava/util/List;Ldk/molslinjen/domain/model/booking/Booking;)Ldk/molslinjen/domain/managers/ticket/TicketsManager$TicketsState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getBookings", "()Ljava/util/List;", "Ldk/molslinjen/domain/model/booking/Booking;", "getLastActiveBooking", "()Ldk/molslinjen/domain/model/booking/Booking;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class TicketsState {
        private final List<BookingHeader> bookings;
        private final Booking lastActiveBooking;

        public TicketsState(List<BookingHeader> bookings, Booking booking) {
            Intrinsics.checkNotNullParameter(bookings, "bookings");
            this.bookings = bookings;
            this.lastActiveBooking = booking;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TicketsState copy$default(TicketsState ticketsState, List list, Booking booking, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                list = ticketsState.bookings;
            }
            if ((i5 & 2) != 0) {
                booking = ticketsState.lastActiveBooking;
            }
            return ticketsState.copy(list, booking);
        }

        public final TicketsState copy(List<BookingHeader> bookings, Booking lastActiveBooking) {
            Intrinsics.checkNotNullParameter(bookings, "bookings");
            return new TicketsState(bookings, lastActiveBooking);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TicketsState)) {
                return false;
            }
            TicketsState ticketsState = (TicketsState) other;
            return Intrinsics.areEqual(this.bookings, ticketsState.bookings) && Intrinsics.areEqual(this.lastActiveBooking, ticketsState.lastActiveBooking);
        }

        public final List<BookingHeader> getBookings() {
            return this.bookings;
        }

        public final Booking getLastActiveBooking() {
            return this.lastActiveBooking;
        }

        public int hashCode() {
            int hashCode = this.bookings.hashCode() * 31;
            Booking booking = this.lastActiveBooking;
            return hashCode + (booking == null ? 0 : booking.hashCode());
        }

        public String toString() {
            return "TicketsState(bookings=" + this.bookings + ", lastActiveBooking=" + this.lastActiveBooking + ")";
        }

        public /* synthetic */ TicketsState(List list, Booking booking, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? CollectionsKt.emptyList() : list, (i5 & 2) != 0 ? null : booking);
        }
    }
}
