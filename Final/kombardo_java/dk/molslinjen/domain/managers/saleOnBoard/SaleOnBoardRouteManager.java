package dk.molslinjen.domain.managers.saleOnBoard;

import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardRouteManager;", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardRouteManager;", "configurationManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "<init>", "(Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "routeState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardRouteState;", "getRouteState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setup", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dateSelected", "date", "Lorg/threeten/bp/LocalDate;", "flipDirection", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardRouteManager implements ISaleOnBoardRouteManager {
    private final IConfigurationManager configurationManager;
    private final CoroutineScope coroutineScope;
    private final MutableStateFlow<SaleOnBoardRouteState> routeState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardRouteManager$1", f = "SaleOnBoardRouteManager.kt", l = {22}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardRouteManager$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

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
                SaleOnBoardRouteManager saleOnBoardRouteManager = SaleOnBoardRouteManager.this;
                this.label = 1;
                if (saleOnBoardRouteManager.setup(this) == coroutine_suspended) {
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

    public SaleOnBoardRouteManager(IConfigurationManager configurationManager) {
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        this.configurationManager = configurationManager;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.coroutineScope = CoroutineScope;
        this.routeState = StateFlowKt.MutableStateFlow(null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardRouteManager
    public void dateSelected(LocalDate date) {
        SaleOnBoardRouteState value;
        SaleOnBoardRouteState saleOnBoardRouteState;
        Intrinsics.checkNotNullParameter(date, "date");
        MutableStateFlow<SaleOnBoardRouteState> routeState = getRouteState();
        do {
            value = routeState.getValue();
            saleOnBoardRouteState = value;
        } while (!routeState.compareAndSet(value, saleOnBoardRouteState != null ? SaleOnBoardRouteState.copy$default(saleOnBoardRouteState, null, null, null, null, date, null, null, 111, null) : null));
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardRouteManager
    public Object flipDirection(Continuation<? super Unit> continuation) {
        Route selectedRoute;
        SaleOnBoardRouteState value;
        SaleOnBoardRouteState saleOnBoardRouteState;
        SaleOnBoardRouteState value2 = getRouteState().getValue();
        if (value2 == null) {
            return Unit.INSTANCE;
        }
        RouteDirection flip = value2.getSelectedRouteDirection().flip();
        SaleOnBoardRouteState value3 = getRouteState().getValue();
        if (value3 == null || (selectedRoute = value3.getSelectedRoute()) == null) {
            return Unit.INSTANCE;
        }
        MutableStateFlow<SaleOnBoardRouteState> routeState = getRouteState();
        do {
            value = routeState.getValue();
            saleOnBoardRouteState = value;
        } while (!routeState.compareAndSet(value, saleOnBoardRouteState != null ? SaleOnBoardRouteState.copy$default(saleOnBoardRouteState, null, null, flip, selectedRoute.getRouteDirection(flip), null, null, null, 115, null) : null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardRouteManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object setup(Continuation<? super Unit> continuation) {
        SaleOnBoardRouteManager$setup$1 saleOnBoardRouteManager$setup$1;
        int i5;
        SaleOnBoardRouteManager saleOnBoardRouteManager;
        LocalizedSiteConfiguration localizedSiteConfiguration;
        if (continuation instanceof SaleOnBoardRouteManager$setup$1) {
            saleOnBoardRouteManager$setup$1 = (SaleOnBoardRouteManager$setup$1) continuation;
            int i6 = saleOnBoardRouteManager$setup$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                saleOnBoardRouteManager$setup$1.label = i6 - Integer.MIN_VALUE;
                Object obj = saleOnBoardRouteManager$setup$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = saleOnBoardRouteManager$setup$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IConfigurationManager iConfigurationManager = this.configurationManager;
                    Site site = Site.Mols;
                    saleOnBoardRouteManager$setup$1.L$0 = this;
                    saleOnBoardRouteManager$setup$1.label = 1;
                    obj = iConfigurationManager.getActiveConfiguration(site, saleOnBoardRouteManager$setup$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    saleOnBoardRouteManager = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    saleOnBoardRouteManager = (SaleOnBoardRouteManager) saleOnBoardRouteManager$setup$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                localizedSiteConfiguration = (LocalizedSiteConfiguration) obj;
                if (localizedSiteConfiguration != null) {
                    return Unit.INSTANCE;
                }
                Route route = (Route) CollectionsKt.first((List) localizedSiteConfiguration.getRoutes());
                for (Transportation transportation : localizedSiteConfiguration.getTransportations()) {
                    if (transportation.getAllowedRouteIds().contains(route.getId())) {
                        RouteDirection routeDirection = RouteDirection.Outbound;
                        RouteDirectionGroup routeDirection2 = route.getRouteDirection(routeDirection);
                        MutableStateFlow<SaleOnBoardRouteState> routeState = saleOnBoardRouteManager.getRouteState();
                        do {
                        } while (!routeState.compareAndSet(routeState.getValue(), new SaleOnBoardRouteState(localizedSiteConfiguration, route, routeDirection, routeDirection2, null, transportation, null, 80, null)));
                        return Unit.INSTANCE;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        saleOnBoardRouteManager$setup$1 = new SaleOnBoardRouteManager$setup$1(this, continuation);
        Object obj2 = saleOnBoardRouteManager$setup$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = saleOnBoardRouteManager$setup$1.label;
        if (i5 != 0) {
        }
        localizedSiteConfiguration = (LocalizedSiteConfiguration) obj2;
        if (localizedSiteConfiguration != null) {
        }
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardRouteManager
    public MutableStateFlow<SaleOnBoardRouteState> getRouteState() {
        return this.routeState;
    }
}
