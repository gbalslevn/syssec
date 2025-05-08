package dk.molslinjen.domain.managers.agreement.multiride;

import com.sun.jna.Function;
import dk.molslinjen.api.extensions.ApiResultExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.multiRide.IAccountMultiRideService;
import dk.molslinjen.api.services.multiRide.IMultiRideService;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.localstorage.agreements.multiride.IMultiRideRepository;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager;
import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.merge.AssetsMergeType;
import dk.molslinjen.domain.model.account.AuthToken;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideAssociatedVehicle;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideBookingTicket;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.domain.model.booking.BookingFromAlternateSource;
import dk.molslinjen.domain.model.config.Site;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 A2\u00020\u0001:\u0001AB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010 J\u0014\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\"H\u0002J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0096@¢\u0006\u0002\u0010%J\u001c\u0010&\u001a\u00020\u001c2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0082@¢\u0006\u0002\u0010*J\"\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0(0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010-J,\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u00102J$\u00103\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010 J\"\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050(0\u001b2\u0006\u0010/\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010-J\"\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050(0\u001b2\u0006\u0010/\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010-J\u0014\u00107\u001a\b\u0012\u0004\u0012\u0002080(H\u0096@¢\u0006\u0002\u0010%J\u0018\u00109\u001a\b\u0012\u0004\u0012\u0002050(*\b\u0012\u0004\u0012\u0002050(H\u0002J\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0;H\u0096@¢\u0006\u0002\u0010%J\u000e\u0010<\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010%J$\u0010=\u001a\b\u0012\u0004\u0012\u00020)0\u001b2\u0006\u0010/\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020?H\u0096@¢\u0006\u0002\u0010@R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Ldk/molslinjen/domain/managers/agreement/multiride/MultiRideManager;", "Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;", "multiRideService", "Ldk/molslinjen/api/services/multiRide/IMultiRideService;", "accountMultiRideService", "Ldk/molslinjen/api/services/multiRide/IAccountMultiRideService;", "multiRideRepo", "Ldk/molslinjen/domain/localstorage/agreements/multiride/IMultiRideRepository;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/api/services/multiRide/IMultiRideService;Ldk/molslinjen/api/services/multiRide/IAccountMultiRideService;Ldk/molslinjen/domain/localstorage/agreements/multiride/IMultiRideRepository;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager$MultiRideManagerState;", "getState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "isAuthenticated", BuildConfig.FLAVOR, "()Z", "localScope", "Lkotlinx/coroutines/CoroutineScope;", "previousAuthenticationType", "Ldk/molslinjen/domain/managers/user/AuthenticationType;", "addMultiRide", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "multiRideCardId", BuildConfig.FLAVOR, "email", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onGoingLoadMultiRidesJob", "Lkotlinx/coroutines/Deferred;", "createLoadMultiRidesJob", "loadMultiRides", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUpdatedMultiRides", "multiRides", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVehiclesForMultiRideCard", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideAssociatedVehicle;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "associateVehicle", "multiRideId", "licensePlate", "vehicleName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeVehicleAssociation", "getActiveTickets", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideBookingTicket;", "getTicketHistory", "getAgreementBookingsAsAlternateSource", "Ldk/molslinjen/domain/model/booking/BookingFromAlternateSource;", "sortNewestFirst", "reportLocalAssets", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType;", "removeLocalAssets", "getMultiRide", "site", "Ldk/molslinjen/domain/model/config/Site;", "(Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiRideManager implements IMultiRideManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Site ForceMolsSite = Site.Mols;
    private final IAccountMultiRideService accountMultiRideService;
    private final IAnalyticsTracker analyticsTracker;
    private final CoroutineScope localScope;
    private final IMultiRideRepository multiRideRepo;
    private final IMultiRideService multiRideService;
    private Deferred<? extends ManagerResult<Unit>> onGoingLoadMultiRidesJob;
    private AuthenticationType previousAuthenticationType;
    private final MutableStateFlow<IMultiRideManager.MultiRideManagerState> state;
    private final IUserManager userManager;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$1", f = "MultiRideManager.kt", l = {50}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "newAuthenticationType", "Ldk/molslinjen/domain/managers/user/AuthenticationType;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$1$1", f = "MultiRideManager.kt", l = {55}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00341 extends SuspendLambda implements Function2<AuthenticationType, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MultiRideManager this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$1$1$1", f = "MultiRideManager.kt", l = {58}, m = "invokeSuspend")
            /* renamed from: dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$1$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C00351 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ MultiRideManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00351(MultiRideManager multiRideManager, Continuation<? super C00351> continuation) {
                    super(1, continuation);
                    this.this$0 = multiRideManager;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new C00351(this.this$0, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i5 = this.label;
                    if (i5 == 0) {
                        ResultKt.throwOnFailure(obj);
                        MultiRideManager multiRideManager = this.this$0;
                        this.label = 1;
                        if (multiRideManager.removeLocalAssets(this) == coroutine_suspended) {
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

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((C00351) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$1$1$2", f = "MultiRideManager.kt", l = {61}, m = "invokeSuspend")
            /* renamed from: dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$1$1$2, reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ MultiRideManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(MultiRideManager multiRideManager, Continuation<? super AnonymousClass2> continuation) {
                    super(1, continuation);
                    this.this$0 = multiRideManager;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass2(this.this$0, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i5 = this.label;
                    if (i5 == 0) {
                        ResultKt.throwOnFailure(obj);
                        MultiRideManager multiRideManager = this.this$0;
                        this.label = 1;
                        if (multiRideManager.loadMultiRides(this) == coroutine_suspended) {
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

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$1$1$3", f = "MultiRideManager.kt", l = {Function.THROW_LAST_ERROR, 65}, m = "invokeSuspend")
            /* renamed from: dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$1$1$3, reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ MultiRideManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(MultiRideManager multiRideManager, Continuation<? super AnonymousClass3> continuation) {
                    super(1, continuation);
                    this.this$0 = multiRideManager;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass3(this.this$0, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i5 = this.label;
                    if (i5 == 0) {
                        ResultKt.throwOnFailure(obj);
                        MultiRideManager multiRideManager = this.this$0;
                        this.label = 1;
                        if (multiRideManager.removeLocalAssets(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    MultiRideManager multiRideManager2 = this.this$0;
                    this.label = 2;
                    if (multiRideManager2.loadMultiRides(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00341(MultiRideManager multiRideManager, Continuation<? super C00341> continuation) {
                super(2, continuation);
                this.this$0 = multiRideManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00341 c00341 = new C00341(this.this$0, continuation);
                c00341.L$0 = obj;
                return c00341;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AuthenticationType authenticationType, Continuation<? super Unit> continuation) {
                return ((C00341) create(authenticationType, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    AuthenticationType authenticationType = (AuthenticationType) this.L$0;
                    AuthenticationType authenticationType2 = this.this$0.previousAuthenticationType;
                    this.this$0.previousAuthenticationType = authenticationType;
                    C00351 c00351 = new C00351(this.this$0, null);
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, null);
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, null);
                    this.label = 1;
                    if (authenticationType2.onNewAuthenticationType(authenticationType, c00351, anonymousClass2, anonymousClass3, this) == coroutine_suspended) {
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
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<AuthenticationType> authenticationType = MultiRideManager.this.userManager.getAuthenticationType();
                C00341 c00341 = new C00341(MultiRideManager.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(authenticationType, c00341, this) == coroutine_suspended) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/managers/agreement/multiride/MultiRideManager$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "ForceMolsSite", "Ldk/molslinjen/domain/model/config/Site;", "getForceMolsSite", "()Ldk/molslinjen/domain/model/config/Site;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Site getForceMolsSite() {
            return MultiRideManager.ForceMolsSite;
        }

        private Companion() {
        }
    }

    public MultiRideManager(IMultiRideService multiRideService, IAccountMultiRideService accountMultiRideService, IMultiRideRepository multiRideRepo, IUserManager userManager, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(multiRideService, "multiRideService");
        Intrinsics.checkNotNullParameter(accountMultiRideService, "accountMultiRideService");
        Intrinsics.checkNotNullParameter(multiRideRepo, "multiRideRepo");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.multiRideService = multiRideService;
        this.accountMultiRideService = accountMultiRideService;
        this.multiRideRepo = multiRideRepo;
        this.userManager = userManager;
        this.analyticsTracker = analyticsTracker;
        this.state = StateFlowKt.MutableStateFlow(new IMultiRideManager.MultiRideManagerState(null, null, 3, null));
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.localScope = CoroutineScope;
        this.previousAuthenticationType = userManager.getAuthenticationType().getValue();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    private final Deferred<ManagerResult<Unit>> createLoadMultiRidesJob() {
        Deferred<ManagerResult<Unit>> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this.localScope, null, null, new MultiRideManager$createLoadMultiRidesJob$1(this, null), 3, null);
        return async$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAuthenticated() {
        return this.userManager.getAuthenticationType().getValue().isAuthenticated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object setUpdatedMultiRides(List<MultiRideCard> list, Continuation<? super Unit> continuation) {
        MultiRideManager$setUpdatedMultiRides$1 multiRideManager$setUpdatedMultiRides$1;
        int i5;
        MultiRideManager multiRideManager;
        MutableStateFlow<IMultiRideManager.MultiRideManagerState> state;
        IMultiRideManager.MultiRideManagerState value;
        if (continuation instanceof MultiRideManager$setUpdatedMultiRides$1) {
            multiRideManager$setUpdatedMultiRides$1 = (MultiRideManager$setUpdatedMultiRides$1) continuation;
            int i6 = multiRideManager$setUpdatedMultiRides$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                multiRideManager$setUpdatedMultiRides$1.label = i6 - Integer.MIN_VALUE;
                Object obj = multiRideManager$setUpdatedMultiRides$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = multiRideManager$setUpdatedMultiRides$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IMultiRideRepository iMultiRideRepository = this.multiRideRepo;
                    multiRideManager$setUpdatedMultiRides$1.L$0 = this;
                    multiRideManager$setUpdatedMultiRides$1.L$1 = list;
                    multiRideManager$setUpdatedMultiRides$1.label = 1;
                    if (iMultiRideRepository.saveAll(list, multiRideManager$setUpdatedMultiRides$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    multiRideManager = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list = (List) multiRideManager$setUpdatedMultiRides$1.L$1;
                    multiRideManager = (MultiRideManager) multiRideManager$setUpdatedMultiRides$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                state = multiRideManager.getState();
                do {
                    value = state.getValue();
                } while (!state.compareAndSet(value, IMultiRideManager.MultiRideManagerState.copy$default(value, list, null, 2, null)));
                return Unit.INSTANCE;
            }
        }
        multiRideManager$setUpdatedMultiRides$1 = new MultiRideManager$setUpdatedMultiRides$1(this, continuation);
        Object obj2 = multiRideManager$setUpdatedMultiRides$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = multiRideManager$setUpdatedMultiRides$1.label;
        if (i5 != 0) {
        }
        state = multiRideManager.getState();
        do {
            value = state.getValue();
        } while (!state.compareAndSet(value, IMultiRideManager.MultiRideManagerState.copy$default(value, list, null, 2, null)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MultiRideBookingTicket> sortNewestFirst(List<MultiRideBookingTicket> list) {
        return CollectionsKt.sortedWith(list, ComparisonsKt.compareBy(new Function1() { // from class: z1.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Comparable sortNewestFirst$lambda$4;
                sortNewestFirst$lambda$4 = MultiRideManager.sortNewestFirst$lambda$4((MultiRideBookingTicket) obj);
                return sortNewestFirst$lambda$4;
            }
        }, new Function1() { // from class: z1.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Comparable sortNewestFirst$lambda$5;
                sortNewestFirst$lambda$5 = MultiRideManager.sortNewestFirst$lambda$5((MultiRideBookingTicket) obj);
                return sortNewestFirst$lambda$5;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable sortNewestFirst$lambda$4(MultiRideBookingTicket it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getDate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable sortNewestFirst$lambda$5(MultiRideBookingTicket it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getDepartureTime();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0021. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x011a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0107 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object addMultiRide(String str, String str2, Continuation<? super ManagerResult<Unit>> continuation) {
        MultiRideManager$addMultiRide$1 multiRideManager$addMultiRide$1;
        MultiRideManager multiRideManager;
        MultiRideManager multiRideManager2;
        ManagerResult managerResult;
        ApiResult apiResult;
        MultiRideManager$addMultiRide$result$1 multiRideManager$addMultiRide$result$1;
        MultiRideManager multiRideManager3;
        String str3;
        ApiResult apiResult2;
        if (continuation instanceof MultiRideManager$addMultiRide$1) {
            multiRideManager$addMultiRide$1 = (MultiRideManager$addMultiRide$1) continuation;
            int i5 = multiRideManager$addMultiRide$1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                multiRideManager$addMultiRide$1.label = i5 - Integer.MIN_VALUE;
                Object obj = multiRideManager$addMultiRide$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (multiRideManager$addMultiRide$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        if (isAuthenticated()) {
                            String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                            if (mo3198getAuthTokenOEbVFrA == null) {
                                return ManagerResult.Error.INSTANCE.noMessage();
                            }
                            IAccountMultiRideService iAccountMultiRideService = this.accountMultiRideService;
                            SiteDTO dto = ForceMolsSite.toDTO();
                            AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                            multiRideManager$addMultiRide$1.L$0 = this;
                            multiRideManager$addMultiRide$1.L$1 = str;
                            multiRideManager$addMultiRide$1.label = 1;
                            obj = iAccountMultiRideService.linkExistingMultiRide(str, str2, dto, m3214toDTOimpl, multiRideManager$addMultiRide$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            multiRideManager2 = this;
                            MultiRideManager$addMultiRide$result$loadResult$1 multiRideManager$addMultiRide$result$loadResult$1 = new MultiRideManager$addMultiRide$result$loadResult$1(multiRideManager2, null);
                            multiRideManager$addMultiRide$1.L$0 = multiRideManager2;
                            multiRideManager$addMultiRide$1.L$1 = str;
                            multiRideManager$addMultiRide$1.label = 2;
                            obj = ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, multiRideManager$addMultiRide$result$loadResult$1, multiRideManager$addMultiRide$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            multiRideManager$addMultiRide$1.L$0 = multiRideManager2;
                            multiRideManager$addMultiRide$1.L$1 = str;
                            multiRideManager$addMultiRide$1.label = 3;
                            obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj, multiRideManager$addMultiRide$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            managerResult = (ManagerResult) obj;
                            multiRideManager2.analyticsTracker.trackEvent(new AnalyticsEvent.AddExistingMultiRideCard(str));
                            return managerResult;
                        }
                        IMultiRideService iMultiRideService = this.multiRideService;
                        SiteDTO dto2 = ForceMolsSite.toDTO();
                        multiRideManager$addMultiRide$1.L$0 = this;
                        multiRideManager$addMultiRide$1.L$1 = str;
                        multiRideManager$addMultiRide$1.label = 4;
                        obj = iMultiRideService.getMultiRide(str, dto2, multiRideManager$addMultiRide$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        multiRideManager = this;
                        apiResult = (ApiResult) obj;
                        multiRideManager$addMultiRide$result$1 = new MultiRideManager$addMultiRide$result$1(multiRideManager, null);
                        multiRideManager$addMultiRide$1.L$0 = multiRideManager;
                        multiRideManager$addMultiRide$1.L$1 = str;
                        multiRideManager$addMultiRide$1.L$2 = apiResult;
                        multiRideManager$addMultiRide$1.label = 5;
                        if (ApiResultExtensionsKt.onSuccess(apiResult, multiRideManager$addMultiRide$result$1, multiRideManager$addMultiRide$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        multiRideManager3 = multiRideManager;
                        str3 = str;
                        apiResult2 = apiResult;
                        multiRideManager$addMultiRide$1.L$0 = multiRideManager3;
                        multiRideManager$addMultiRide$1.L$1 = str3;
                        multiRideManager$addMultiRide$1.L$2 = null;
                        multiRideManager$addMultiRide$1.label = 6;
                        obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult(apiResult2, multiRideManager$addMultiRide$1);
                        if (obj != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str = str3;
                        multiRideManager2 = multiRideManager3;
                        managerResult = (ManagerResult) obj;
                        multiRideManager2.analyticsTracker.trackEvent(new AnalyticsEvent.AddExistingMultiRideCard(str));
                        return managerResult;
                    case 1:
                        str = (String) multiRideManager$addMultiRide$1.L$1;
                        multiRideManager2 = (MultiRideManager) multiRideManager$addMultiRide$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        MultiRideManager$addMultiRide$result$loadResult$1 multiRideManager$addMultiRide$result$loadResult$12 = new MultiRideManager$addMultiRide$result$loadResult$1(multiRideManager2, null);
                        multiRideManager$addMultiRide$1.L$0 = multiRideManager2;
                        multiRideManager$addMultiRide$1.L$1 = str;
                        multiRideManager$addMultiRide$1.label = 2;
                        obj = ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, multiRideManager$addMultiRide$result$loadResult$12, multiRideManager$addMultiRide$1);
                        if (obj == coroutine_suspended) {
                        }
                        multiRideManager$addMultiRide$1.L$0 = multiRideManager2;
                        multiRideManager$addMultiRide$1.L$1 = str;
                        multiRideManager$addMultiRide$1.label = 3;
                        obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj, multiRideManager$addMultiRide$1);
                        if (obj == coroutine_suspended) {
                        }
                        managerResult = (ManagerResult) obj;
                        multiRideManager2.analyticsTracker.trackEvent(new AnalyticsEvent.AddExistingMultiRideCard(str));
                        return managerResult;
                    case 2:
                        str = (String) multiRideManager$addMultiRide$1.L$1;
                        multiRideManager2 = (MultiRideManager) multiRideManager$addMultiRide$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        multiRideManager$addMultiRide$1.L$0 = multiRideManager2;
                        multiRideManager$addMultiRide$1.L$1 = str;
                        multiRideManager$addMultiRide$1.label = 3;
                        obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj, multiRideManager$addMultiRide$1);
                        if (obj == coroutine_suspended) {
                        }
                        managerResult = (ManagerResult) obj;
                        multiRideManager2.analyticsTracker.trackEvent(new AnalyticsEvent.AddExistingMultiRideCard(str));
                        return managerResult;
                    case 3:
                        str = (String) multiRideManager$addMultiRide$1.L$1;
                        multiRideManager2 = (MultiRideManager) multiRideManager$addMultiRide$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        managerResult = (ManagerResult) obj;
                        multiRideManager2.analyticsTracker.trackEvent(new AnalyticsEvent.AddExistingMultiRideCard(str));
                        return managerResult;
                    case 4:
                        str = (String) multiRideManager$addMultiRide$1.L$1;
                        multiRideManager = (MultiRideManager) multiRideManager$addMultiRide$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        apiResult = (ApiResult) obj;
                        multiRideManager$addMultiRide$result$1 = new MultiRideManager$addMultiRide$result$1(multiRideManager, null);
                        multiRideManager$addMultiRide$1.L$0 = multiRideManager;
                        multiRideManager$addMultiRide$1.L$1 = str;
                        multiRideManager$addMultiRide$1.L$2 = apiResult;
                        multiRideManager$addMultiRide$1.label = 5;
                        if (ApiResultExtensionsKt.onSuccess(apiResult, multiRideManager$addMultiRide$result$1, multiRideManager$addMultiRide$1) != coroutine_suspended) {
                        }
                        break;
                    case 5:
                        apiResult2 = (ApiResult) multiRideManager$addMultiRide$1.L$2;
                        str3 = (String) multiRideManager$addMultiRide$1.L$1;
                        multiRideManager3 = (MultiRideManager) multiRideManager$addMultiRide$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        multiRideManager$addMultiRide$1.L$0 = multiRideManager3;
                        multiRideManager$addMultiRide$1.L$1 = str3;
                        multiRideManager$addMultiRide$1.L$2 = null;
                        multiRideManager$addMultiRide$1.label = 6;
                        obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult(apiResult2, multiRideManager$addMultiRide$1);
                        if (obj != coroutine_suspended) {
                        }
                        break;
                    case 6:
                        str = (String) multiRideManager$addMultiRide$1.L$1;
                        multiRideManager2 = (MultiRideManager) multiRideManager$addMultiRide$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        managerResult = (ManagerResult) obj;
                        multiRideManager2.analyticsTracker.trackEvent(new AnalyticsEvent.AddExistingMultiRideCard(str));
                        return managerResult;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        multiRideManager$addMultiRide$1 = new MultiRideManager$addMultiRide$1(this, continuation);
        Object obj2 = multiRideManager$addMultiRide$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (multiRideManager$addMultiRide$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005b A[PHI: r13
      0x005b: PHI (r13v7 java.lang.Object) = (r13v6 java.lang.Object), (r13v1 java.lang.Object) binds: [B:17:0x0058, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object associateVehicle(String str, String str2, String str3, Continuation<? super ManagerResult<Unit>> continuation) {
        MultiRideManager$associateVehicle$1 multiRideManager$associateVehicle$1;
        int i5;
        if (continuation instanceof MultiRideManager$associateVehicle$1) {
            multiRideManager$associateVehicle$1 = (MultiRideManager$associateVehicle$1) continuation;
            int i6 = multiRideManager$associateVehicle$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                multiRideManager$associateVehicle$1.label = i6 - Integer.MIN_VALUE;
                Object obj = multiRideManager$associateVehicle$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = multiRideManager$associateVehicle$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IMultiRideService iMultiRideService = this.multiRideService;
                    SiteDTO dto = ForceMolsSite.toDTO();
                    multiRideManager$associateVehicle$1.label = 1;
                    obj = iMultiRideService.addMultiRideVehicle(str, str2, str3, dto, multiRideManager$associateVehicle$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                multiRideManager$associateVehicle$1.label = 2;
                obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj, multiRideManager$associateVehicle$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        multiRideManager$associateVehicle$1 = new MultiRideManager$associateVehicle$1(this, continuation);
        Object obj2 = multiRideManager$associateVehicle$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = multiRideManager$associateVehicle$1.label;
        if (i5 != 0) {
        }
        multiRideManager$associateVehicle$1.label = 2;
        obj2 = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj2, multiRideManager$associateVehicle$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0066 A[PHI: r7
      0x0066: PHI (r7v7 java.lang.Object) = (r7v6 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x0063, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getActiveTickets(String str, Continuation<? super ManagerResult<? extends List<MultiRideBookingTicket>>> continuation) {
        MultiRideManager$getActiveTickets$1 multiRideManager$getActiveTickets$1;
        int i5;
        MultiRideManager multiRideManager;
        if (continuation instanceof MultiRideManager$getActiveTickets$1) {
            multiRideManager$getActiveTickets$1 = (MultiRideManager$getActiveTickets$1) continuation;
            int i6 = multiRideManager$getActiveTickets$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                multiRideManager$getActiveTickets$1.label = i6 - Integer.MIN_VALUE;
                Object obj = multiRideManager$getActiveTickets$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = multiRideManager$getActiveTickets$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IMultiRideService iMultiRideService = this.multiRideService;
                    SiteDTO dto = ForceMolsSite.toDTO();
                    multiRideManager$getActiveTickets$1.L$0 = this;
                    multiRideManager$getActiveTickets$1.label = 1;
                    obj = iMultiRideService.getActiveBookings(str, dto, multiRideManager$getActiveTickets$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    multiRideManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    multiRideManager = (MultiRideManager) multiRideManager$getActiveTickets$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                MultiRideManager$getActiveTickets$2 multiRideManager$getActiveTickets$2 = new MultiRideManager$getActiveTickets$2(multiRideManager, null);
                multiRideManager$getActiveTickets$1.L$0 = null;
                multiRideManager$getActiveTickets$1.label = 2;
                obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj, multiRideManager$getActiveTickets$2, multiRideManager$getActiveTickets$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        multiRideManager$getActiveTickets$1 = new MultiRideManager$getActiveTickets$1(this, continuation);
        Object obj2 = multiRideManager$getActiveTickets$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = multiRideManager$getActiveTickets$1.label;
        if (i5 != 0) {
        }
        MultiRideManager$getActiveTickets$2 multiRideManager$getActiveTickets$22 = new MultiRideManager$getActiveTickets$2(multiRideManager, null);
        multiRideManager$getActiveTickets$1.L$0 = null;
        multiRideManager$getActiveTickets$1.label = 2;
        obj2 = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj2, multiRideManager$getActiveTickets$22, multiRideManager$getActiveTickets$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0078 -> B:10:0x007b). Please report as a decompilation issue!!! */
    @Override // dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getAgreementBookingsAsAlternateSource(Continuation<? super List<BookingFromAlternateSource>> continuation) {
        MultiRideManager$getAgreementBookingsAsAlternateSource$1 multiRideManager$getAgreementBookingsAsAlternateSource$1;
        int i5;
        MultiRideManager multiRideManager;
        Collection arrayList;
        Iterator it;
        List list;
        Iterator it2;
        if (continuation instanceof MultiRideManager$getAgreementBookingsAsAlternateSource$1) {
            multiRideManager$getAgreementBookingsAsAlternateSource$1 = (MultiRideManager$getAgreementBookingsAsAlternateSource$1) continuation;
            int i6 = multiRideManager$getAgreementBookingsAsAlternateSource$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                multiRideManager$getAgreementBookingsAsAlternateSource$1.label = i6 - Integer.MIN_VALUE;
                Object obj = multiRideManager$getAgreementBookingsAsAlternateSource$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = multiRideManager$getAgreementBookingsAsAlternateSource$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    List<MultiRideCard> multiRideCards = getState().getValue().getMultiRideCards();
                    multiRideManager = this;
                    arrayList = new ArrayList();
                    it = multiRideCards.iterator();
                    if (it.hasNext()) {
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) multiRideManager$getAgreementBookingsAsAlternateSource$1.L$2;
                    arrayList = (Collection) multiRideManager$getAgreementBookingsAsAlternateSource$1.L$1;
                    multiRideManager = (MultiRideManager) multiRideManager$getAgreementBookingsAsAlternateSource$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList2 = null;
                    ManagerResult.Success success = !(obj instanceof ManagerResult.Success) ? (ManagerResult.Success) obj : null;
                    if (success != null && (list = (List) success.getData()) != null) {
                        arrayList2 = new ArrayList();
                        it2 = list.iterator();
                        while (it2.hasNext()) {
                            BookingFromAlternateSource from = BookingFromAlternateSource.INSTANCE.from((MultiRideBookingTicket) it2.next());
                            if (from != null) {
                                arrayList2.add(from);
                            }
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList.add(arrayList2);
                    }
                    if (it.hasNext()) {
                        String id = ((MultiRideCard) it.next()).getId();
                        multiRideManager$getAgreementBookingsAsAlternateSource$1.L$0 = multiRideManager;
                        multiRideManager$getAgreementBookingsAsAlternateSource$1.L$1 = arrayList;
                        multiRideManager$getAgreementBookingsAsAlternateSource$1.L$2 = it;
                        multiRideManager$getAgreementBookingsAsAlternateSource$1.label = 1;
                        obj = multiRideManager.getActiveTickets(id, multiRideManager$getAgreementBookingsAsAlternateSource$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ArrayList arrayList22 = null;
                        if (!(obj instanceof ManagerResult.Success)) {
                        }
                        if (success != null) {
                            arrayList22 = new ArrayList();
                            it2 = list.iterator();
                            while (it2.hasNext()) {
                            }
                        }
                        if (arrayList22 != null) {
                        }
                        if (it.hasNext()) {
                            return CollectionsKt.flatten((List) arrayList);
                        }
                    }
                }
            }
        }
        multiRideManager$getAgreementBookingsAsAlternateSource$1 = new MultiRideManager$getAgreementBookingsAsAlternateSource$1(this, continuation);
        Object obj2 = multiRideManager$getAgreementBookingsAsAlternateSource$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = multiRideManager$getAgreementBookingsAsAlternateSource$1.label;
        if (i5 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005b A[PHI: r8
      0x005b: PHI (r8v7 java.lang.Object) = (r8v6 java.lang.Object), (r8v1 java.lang.Object) binds: [B:17:0x0058, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getMultiRide(String str, Site site, Continuation<? super ManagerResult<MultiRideCard>> continuation) {
        MultiRideManager$getMultiRide$1 multiRideManager$getMultiRide$1;
        int i5;
        if (continuation instanceof MultiRideManager$getMultiRide$1) {
            multiRideManager$getMultiRide$1 = (MultiRideManager$getMultiRide$1) continuation;
            int i6 = multiRideManager$getMultiRide$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                multiRideManager$getMultiRide$1.label = i6 - Integer.MIN_VALUE;
                Object obj = multiRideManager$getMultiRide$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = multiRideManager$getMultiRide$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IMultiRideService iMultiRideService = this.multiRideService;
                    SiteDTO dto = site.toDTO();
                    multiRideManager$getMultiRide$1.label = 1;
                    obj = iMultiRideService.getMultiRide(str, dto, multiRideManager$getMultiRide$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                MultiRideManager$getMultiRide$2 multiRideManager$getMultiRide$2 = new MultiRideManager$getMultiRide$2(null);
                multiRideManager$getMultiRide$1.label = 2;
                obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj, multiRideManager$getMultiRide$2, multiRideManager$getMultiRide$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        multiRideManager$getMultiRide$1 = new MultiRideManager$getMultiRide$1(this, continuation);
        Object obj2 = multiRideManager$getMultiRide$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = multiRideManager$getMultiRide$1.label;
        if (i5 != 0) {
        }
        MultiRideManager$getMultiRide$2 multiRideManager$getMultiRide$22 = new MultiRideManager$getMultiRide$2(null);
        multiRideManager$getMultiRide$1.label = 2;
        obj2 = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj2, multiRideManager$getMultiRide$22, multiRideManager$getMultiRide$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0066 A[PHI: r7
      0x0066: PHI (r7v7 java.lang.Object) = (r7v6 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x0063, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getTicketHistory(String str, Continuation<? super ManagerResult<? extends List<MultiRideBookingTicket>>> continuation) {
        MultiRideManager$getTicketHistory$1 multiRideManager$getTicketHistory$1;
        int i5;
        MultiRideManager multiRideManager;
        if (continuation instanceof MultiRideManager$getTicketHistory$1) {
            multiRideManager$getTicketHistory$1 = (MultiRideManager$getTicketHistory$1) continuation;
            int i6 = multiRideManager$getTicketHistory$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                multiRideManager$getTicketHistory$1.label = i6 - Integer.MIN_VALUE;
                Object obj = multiRideManager$getTicketHistory$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = multiRideManager$getTicketHistory$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IMultiRideService iMultiRideService = this.multiRideService;
                    SiteDTO dto = ForceMolsSite.toDTO();
                    multiRideManager$getTicketHistory$1.L$0 = this;
                    multiRideManager$getTicketHistory$1.label = 1;
                    obj = iMultiRideService.getBookingHistory(str, dto, multiRideManager$getTicketHistory$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    multiRideManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    multiRideManager = (MultiRideManager) multiRideManager$getTicketHistory$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                MultiRideManager$getTicketHistory$2 multiRideManager$getTicketHistory$2 = new MultiRideManager$getTicketHistory$2(multiRideManager, null);
                multiRideManager$getTicketHistory$1.L$0 = null;
                multiRideManager$getTicketHistory$1.label = 2;
                obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj, multiRideManager$getTicketHistory$2, multiRideManager$getTicketHistory$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        multiRideManager$getTicketHistory$1 = new MultiRideManager$getTicketHistory$1(this, continuation);
        Object obj2 = multiRideManager$getTicketHistory$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = multiRideManager$getTicketHistory$1.label;
        if (i5 != 0) {
        }
        MultiRideManager$getTicketHistory$2 multiRideManager$getTicketHistory$22 = new MultiRideManager$getTicketHistory$2(multiRideManager, null);
        multiRideManager$getTicketHistory$1.L$0 = null;
        multiRideManager$getTicketHistory$1.label = 2;
        obj2 = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj2, multiRideManager$getTicketHistory$22, multiRideManager$getTicketHistory$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005d A[PHI: r7
      0x005d: PHI (r7v7 java.lang.Object) = (r7v6 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x005a, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getVehiclesForMultiRideCard(String str, Continuation<? super ManagerResult<? extends List<MultiRideAssociatedVehicle>>> continuation) {
        MultiRideManager$getVehiclesForMultiRideCard$1 multiRideManager$getVehiclesForMultiRideCard$1;
        int i5;
        if (continuation instanceof MultiRideManager$getVehiclesForMultiRideCard$1) {
            multiRideManager$getVehiclesForMultiRideCard$1 = (MultiRideManager$getVehiclesForMultiRideCard$1) continuation;
            int i6 = multiRideManager$getVehiclesForMultiRideCard$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                multiRideManager$getVehiclesForMultiRideCard$1.label = i6 - Integer.MIN_VALUE;
                Object obj = multiRideManager$getVehiclesForMultiRideCard$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = multiRideManager$getVehiclesForMultiRideCard$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IMultiRideService iMultiRideService = this.multiRideService;
                    SiteDTO dto = ForceMolsSite.toDTO();
                    multiRideManager$getVehiclesForMultiRideCard$1.label = 1;
                    obj = iMultiRideService.getMultiRideVehicles(str, dto, multiRideManager$getVehiclesForMultiRideCard$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                MultiRideManager$getVehiclesForMultiRideCard$2 multiRideManager$getVehiclesForMultiRideCard$2 = new MultiRideManager$getVehiclesForMultiRideCard$2(null);
                multiRideManager$getVehiclesForMultiRideCard$1.label = 2;
                obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj, multiRideManager$getVehiclesForMultiRideCard$2, multiRideManager$getVehiclesForMultiRideCard$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        multiRideManager$getVehiclesForMultiRideCard$1 = new MultiRideManager$getVehiclesForMultiRideCard$1(this, continuation);
        Object obj2 = multiRideManager$getVehiclesForMultiRideCard$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = multiRideManager$getVehiclesForMultiRideCard$1.label;
        if (i5 != 0) {
        }
        MultiRideManager$getVehiclesForMultiRideCard$2 multiRideManager$getVehiclesForMultiRideCard$22 = new MultiRideManager$getVehiclesForMultiRideCard$2(null);
        multiRideManager$getVehiclesForMultiRideCard$1.label = 2;
        obj2 = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj2, multiRideManager$getVehiclesForMultiRideCard$22, multiRideManager$getVehiclesForMultiRideCard$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    @Override // dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager
    public Object loadMultiRides(Continuation<? super ManagerResult<Unit>> continuation) {
        Deferred<? extends ManagerResult<Unit>> deferred = this.onGoingLoadMultiRidesJob;
        if (deferred != null) {
            deferred.cancel(new CancellationException("Restart loadMultiRides"));
        }
        Deferred<ManagerResult<Unit>> createLoadMultiRidesJob = createLoadMultiRidesJob();
        this.onGoingLoadMultiRidesJob = createLoadMultiRidesJob;
        return createLoadMultiRidesJob.await(continuation);
    }

    @Override // dk.molslinjen.domain.managers.user.merge.IAssetsMerger
    public Object removeLocalAssets(Continuation<? super Unit> continuation) {
        IMultiRideManager.MultiRideManagerState value;
        MutableStateFlow<IMultiRideManager.MultiRideManagerState> state = getState();
        do {
            value = state.getValue();
        } while (!state.compareAndSet(value, IMultiRideManager.MultiRideManagerState.copy$default(value, CollectionsKt.emptyList(), null, 2, null)));
        Object clear = this.multiRideRepo.clear(continuation);
        return clear == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clear : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0057 A[PHI: r8
      0x0057: PHI (r8v7 java.lang.Object) = (r8v6 java.lang.Object), (r8v1 java.lang.Object) binds: [B:17:0x0054, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object removeVehicleAssociation(String str, String str2, Continuation<? super ManagerResult<Unit>> continuation) {
        MultiRideManager$removeVehicleAssociation$1 multiRideManager$removeVehicleAssociation$1;
        int i5;
        if (continuation instanceof MultiRideManager$removeVehicleAssociation$1) {
            multiRideManager$removeVehicleAssociation$1 = (MultiRideManager$removeVehicleAssociation$1) continuation;
            int i6 = multiRideManager$removeVehicleAssociation$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                multiRideManager$removeVehicleAssociation$1.label = i6 - Integer.MIN_VALUE;
                Object obj = multiRideManager$removeVehicleAssociation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = multiRideManager$removeVehicleAssociation$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IMultiRideService iMultiRideService = this.multiRideService;
                    SiteDTO dto = ForceMolsSite.toDTO();
                    multiRideManager$removeVehicleAssociation$1.label = 1;
                    obj = iMultiRideService.removeMultiRideVehicle(str, str2, dto, multiRideManager$removeVehicleAssociation$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                multiRideManager$removeVehicleAssociation$1.label = 2;
                obj = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj, multiRideManager$removeVehicleAssociation$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        multiRideManager$removeVehicleAssociation$1 = new MultiRideManager$removeVehicleAssociation$1(this, continuation);
        Object obj2 = multiRideManager$removeVehicleAssociation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = multiRideManager$removeVehicleAssociation$1.label;
        if (i5 != 0) {
        }
        multiRideManager$removeVehicleAssociation$1.label = 2;
        obj2 = dk.molslinjen.domain.extensions.ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj2, multiRideManager$removeVehicleAssociation$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006e A[LOOP:0: B:12:0x0068->B:14:0x006e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.user.merge.IAssetsMerger
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object reportLocalAssets(Continuation<? super AssetsMergeType<String>> continuation) {
        MultiRideManager$reportLocalAssets$1 multiRideManager$reportLocalAssets$1;
        int i5;
        List<MultiRideCard> multiRideCards;
        Iterator<T> it;
        if (continuation instanceof MultiRideManager$reportLocalAssets$1) {
            multiRideManager$reportLocalAssets$1 = (MultiRideManager$reportLocalAssets$1) continuation;
            int i6 = multiRideManager$reportLocalAssets$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                multiRideManager$reportLocalAssets$1.label = i6 - Integer.MIN_VALUE;
                Object obj = multiRideManager$reportLocalAssets$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = multiRideManager$reportLocalAssets$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    multiRideCards = getState().getValue().getMultiRideCards();
                    if (multiRideCards.isEmpty()) {
                        IMultiRideRepository iMultiRideRepository = this.multiRideRepo;
                        multiRideManager$reportLocalAssets$1.label = 1;
                        obj = iMultiRideRepository.getMultiRides(multiRideManager$reportLocalAssets$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    List<MultiRideCard> list = multiRideCards;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((MultiRideCard) it.next()).getId());
                    }
                    return new AssetsMergeType.MultiRide(arrayList);
                }
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                multiRideCards = (List) obj;
                List<MultiRideCard> list2 = multiRideCards;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                it = list2.iterator();
                while (it.hasNext()) {
                }
                return new AssetsMergeType.MultiRide(arrayList2);
            }
        }
        multiRideManager$reportLocalAssets$1 = new MultiRideManager$reportLocalAssets$1(this, continuation);
        Object obj2 = multiRideManager$reportLocalAssets$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = multiRideManager$reportLocalAssets$1.label;
        if (i5 != 0) {
        }
        multiRideCards = (List) obj2;
        List<MultiRideCard> list22 = multiRideCards;
        ArrayList arrayList22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list22, 10));
        it = list22.iterator();
        while (it.hasNext()) {
        }
        return new AssetsMergeType.MultiRide(arrayList22);
    }

    @Override // dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager
    public MutableStateFlow<IMultiRideManager.MultiRideManagerState> getState() {
        return this.state;
    }
}
