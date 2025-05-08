package dk.molslinjen.domain.managers.site;

import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.site.SiteInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/managers/site/SiteManager;", "Ldk/molslinjen/domain/managers/site/ISiteManager;", "configurationManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "<init>", "(Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;Ldk/molslinjen/domain/managers/route/IRouteManager;)V", "localScope", "Lkotlinx/coroutines/CoroutineScope;", "siteFromManager", "Lkotlinx/coroutines/flow/Flow;", "Ldk/molslinjen/domain/model/config/Site;", "availableSites", "Lkotlinx/coroutines/flow/MutableStateFlow;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/site/SiteInfo;", "getAvailableSites", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "selectedSite", "Lkotlinx/coroutines/flow/StateFlow;", "getSelectedSite", "()Lkotlinx/coroutines/flow/StateFlow;", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SiteManager implements ISiteManager {
    private final MutableStateFlow<List<SiteInfo>> availableSites;
    private final IConfigurationManager configurationManager;
    private final CoroutineScope localScope;
    private final StateFlow<SiteInfo> selectedSite;
    private final Flow<Site> siteFromManager;

    public SiteManager(IConfigurationManager configurationManager, IRouteManager routeManager) {
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        this.configurationManager = configurationManager;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.localScope = CoroutineScope;
        final StateFlow<RouteSharedSelectedState> sharedSelectedState = routeManager.getSharedSelectedState();
        Flow<Site> flow = new Flow<Site>() { // from class: dk.molslinjen.domain.managers.site.SiteManager$special$$inlined$map$1

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
            /* renamed from: dk.molslinjen.domain.managers.site.SiteManager$special$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "dk.molslinjen.domain.managers.site.SiteManager$special$$inlined$map$1$2", f = "SiteManager.kt", l = {223}, m = "emit")
                /* renamed from: dk.molslinjen.domain.managers.site.SiteManager$special$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i5;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i6 = anonymousClass1.label;
                        if ((i6 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i6 - Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i5 = anonymousClass1.label;
                            if (i5 != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                RouteSharedSelectedState routeSharedSelectedState = (RouteSharedSelectedState) obj;
                                Site site = routeSharedSelectedState != null ? routeSharedSelectedState.getSite() : null;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(site, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i5 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = anonymousClass1.label;
                    if (i5 != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Site> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        this.siteFromManager = flow;
        this.availableSites = StateFlowKt.MutableStateFlow(null);
        this.selectedSite = FlowKt.stateIn(FlowKt.flowCombine(flow, getAvailableSites(), new SiteManager$selectedSite$1(null)), CoroutineScope, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), null);
        getAvailableSites();
    }

    @Override // dk.molslinjen.domain.managers.site.ISiteManager
    public StateFlow<SiteInfo> getSelectedSite() {
        return this.selectedSite;
    }

    @Override // dk.molslinjen.domain.managers.site.ISiteManager
    public MutableStateFlow<List<SiteInfo>> getAvailableSites() {
        return this.availableSites;
    }

    private final void getAvailableSites() {
        BuildersKt__Builders_commonKt.launch$default(this.localScope, null, null, new SiteManager$getAvailableSites$1(this, null), 3, null);
    }
}
