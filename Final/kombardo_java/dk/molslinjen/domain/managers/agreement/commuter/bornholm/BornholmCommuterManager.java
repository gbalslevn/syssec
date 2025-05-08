package dk.molslinjen.domain.managers.agreement.commuter.bornholm;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.commuter.bornholm.IBornholmCommuterService;
import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterAgreementResponseDTO;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.extensions.ApiResultExtensionsKt;
import dk.molslinjen.domain.extensions.CommuterDataStateExtensionsKt;
import dk.molslinjen.domain.localstorage.agreements.commuter.bornholm.IBornholmCommuterRepository;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.agreement.commuter.CommuterDataState;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterAgreement;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterBooking;
import dk.molslinjen.domain.model.booking.BookingFromAlternateSource;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u000e\u0010\u001b\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u001cJ*\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00190\u00122\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0017J\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0019H\u0082@¢\u0006\u0002\u0010\u001cJ4\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00192\u0006\u0010\u001f\u001a\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00192\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0019H\u0002J\u0018\u0010(\u001a\b\u0012\u0004\u0012\u00020$0\u0019*\b\u0012\u0004\u0012\u00020$0\u0019H\u0002J'\u0010)\u001a\b\u0012\u0004\u0012\u00020$0**\b\u0012\u0004\u0012\u00020$0*2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0019H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006,"}, d2 = {"Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/BornholmCommuterManager;", "Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;", "service", "Ldk/molslinjen/api/services/commuter/bornholm/IBornholmCommuterService;", "configurationManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "repo", "Ldk/molslinjen/domain/localstorage/agreements/commuter/bornholm/IBornholmCommuterRepository;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/api/services/commuter/bornholm/IBornholmCommuterService;Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;Ldk/molslinjen/domain/localstorage/agreements/commuter/bornholm/IBornholmCommuterRepository;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager$State;", "getState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "addAgreements", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "email", BuildConfig.FLAVOR, "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAgreementBookingsAsAlternateSource", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingFromAlternateSource;", "loadAgreements", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAgreementHistory", "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterBooking;", "commuterId", "commuterAgreementId", "getConfigurationTransports", "Ldk/molslinjen/domain/model/config/Transportation;", "mapAgreements", "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;", "agreements", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterAgreementResponseDTO;", "transportations", "distinctById", "plus", "Ldk/molslinjen/domain/managers/agreement/commuter/CommuterDataState;", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BornholmCommuterManager implements IBornholmCommuterManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Site ForceBornholm = Site.Bornholm;
    private final IAnalyticsTracker analyticsTracker;
    private final IConfigurationManager configurationManager;
    private final IBornholmCommuterRepository repo;
    private final IBornholmCommuterService service;
    private final MutableStateFlow<IBornholmCommuterManager.State> state;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/BornholmCommuterManager$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "ForceBornholm", "Ldk/molslinjen/domain/model/config/Site;", "getForceBornholm", "()Ldk/molslinjen/domain/model/config/Site;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Site getForceBornholm() {
            return BornholmCommuterManager.ForceBornholm;
        }

        private Companion() {
        }
    }

    public BornholmCommuterManager(IBornholmCommuterService service, IConfigurationManager configurationManager, IBornholmCommuterRepository repo, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.service = service;
        this.configurationManager = configurationManager;
        this.repo = repo;
        this.analyticsTracker = analyticsTracker;
        this.state = StateFlowKt.MutableStateFlow(new IBornholmCommuterManager.State(null, null, 3, null));
    }

    private final List<BornholmCommuterAgreement> distinctById(List<BornholmCommuterAgreement> list) {
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (hashSet.add(((BornholmCommuterAgreement) obj).getCommuterAgreementId())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getConfigurationTransports(Continuation<? super List<Transportation>> continuation) {
        BornholmCommuterManager$getConfigurationTransports$1 bornholmCommuterManager$getConfigurationTransports$1;
        int i5;
        LocalizedSiteConfiguration localizedSiteConfiguration;
        if (continuation instanceof BornholmCommuterManager$getConfigurationTransports$1) {
            bornholmCommuterManager$getConfigurationTransports$1 = (BornholmCommuterManager$getConfigurationTransports$1) continuation;
            int i6 = bornholmCommuterManager$getConfigurationTransports$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                bornholmCommuterManager$getConfigurationTransports$1.label = i6 - Integer.MIN_VALUE;
                Object obj = bornholmCommuterManager$getConfigurationTransports$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = bornholmCommuterManager$getConfigurationTransports$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IConfigurationManager iConfigurationManager = this.configurationManager;
                    Site site = ForceBornholm;
                    bornholmCommuterManager$getConfigurationTransports$1.label = 1;
                    obj = iConfigurationManager.getActiveConfiguration(site, bornholmCommuterManager$getConfigurationTransports$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                localizedSiteConfiguration = (LocalizedSiteConfiguration) obj;
                if (localizedSiteConfiguration == null) {
                    return localizedSiteConfiguration.getTransportations();
                }
                return null;
            }
        }
        bornholmCommuterManager$getConfigurationTransports$1 = new BornholmCommuterManager$getConfigurationTransports$1(this, continuation);
        Object obj2 = bornholmCommuterManager$getConfigurationTransports$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = bornholmCommuterManager$getConfigurationTransports$1.label;
        if (i5 != 0) {
        }
        localizedSiteConfiguration = (LocalizedSiteConfiguration) obj2;
        if (localizedSiteConfiguration == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<BornholmCommuterAgreement> mapAgreements(String commuterId, List<BornholmCommuterAgreementResponseDTO> agreements, List<Transportation> transportations) {
        List<BornholmCommuterAgreementResponseDTO> list = agreements;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (BornholmCommuterAgreementResponseDTO bornholmCommuterAgreementResponseDTO : list) {
            Transportation transportation = null;
            if (transportations != null) {
                Iterator<T> it = transportations.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(((Transportation) next).getId(), bornholmCommuterAgreementResponseDTO.getTransportId())) {
                        transportation = next;
                        break;
                    }
                }
                transportation = transportation;
            }
            arrayList.add(new BornholmCommuterAgreement(bornholmCommuterAgreementResponseDTO, commuterId, transportation));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a8 A[PHI: r12
      0x00a8: PHI (r12v12 java.lang.Object) = (r12v11 java.lang.Object), (r12v1 java.lang.Object) binds: [B:19:0x00a5, B:12:0x002f] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object addAgreements(String str, String str2, Continuation<? super ManagerResult<Unit>> continuation) {
        BornholmCommuterManager$addAgreements$1 bornholmCommuterManager$addAgreements$1;
        Object coroutine_suspended;
        int i5;
        BornholmCommuterManager bornholmCommuterManager;
        Object configurationTransports;
        BornholmCommuterManager bornholmCommuterManager2;
        ApiResult apiResult;
        BornholmCommuterManager$addAgreements$2 bornholmCommuterManager$addAgreements$2;
        if (continuation instanceof BornholmCommuterManager$addAgreements$1) {
            bornholmCommuterManager$addAgreements$1 = (BornholmCommuterManager$addAgreements$1) continuation;
            int i6 = bornholmCommuterManager$addAgreements$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                bornholmCommuterManager$addAgreements$1.label = i6 - Integer.MIN_VALUE;
                Object obj = bornholmCommuterManager$addAgreements$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = bornholmCommuterManager$addAgreements$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IBornholmCommuterService iBornholmCommuterService = this.service;
                    bornholmCommuterManager$addAgreements$1.L$0 = this;
                    bornholmCommuterManager$addAgreements$1.label = 1;
                    obj = iBornholmCommuterService.login(str, str2, bornholmCommuterManager$addAgreements$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bornholmCommuterManager = this;
                } else if (i5 == 1) {
                    bornholmCommuterManager = (BornholmCommuterManager) bornholmCommuterManager$addAgreements$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 4) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        apiResult = (ApiResult) bornholmCommuterManager$addAgreements$1.L$1;
                        bornholmCommuterManager2 = (BornholmCommuterManager) bornholmCommuterManager$addAgreements$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        bornholmCommuterManager2.analyticsTracker.trackEvent(AnalyticsEvent.AddCommuterAgreements.INSTANCE);
                        bornholmCommuterManager$addAgreements$1.L$0 = null;
                        bornholmCommuterManager$addAgreements$1.L$1 = null;
                        bornholmCommuterManager$addAgreements$1.label = 4;
                        obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult, bornholmCommuterManager$addAgreements$1);
                        return obj == coroutine_suspended ? coroutine_suspended : obj;
                    }
                    apiResult = (ApiResult) bornholmCommuterManager$addAgreements$1.L$1;
                    bornholmCommuterManager2 = (BornholmCommuterManager) bornholmCommuterManager$addAgreements$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    bornholmCommuterManager$addAgreements$2 = new BornholmCommuterManager$addAgreements$2(bornholmCommuterManager2, (List) obj, null);
                    bornholmCommuterManager$addAgreements$1.L$0 = bornholmCommuterManager2;
                    bornholmCommuterManager$addAgreements$1.L$1 = apiResult;
                    bornholmCommuterManager$addAgreements$1.label = 3;
                    if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, bornholmCommuterManager$addAgreements$2, bornholmCommuterManager$addAgreements$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bornholmCommuterManager2.analyticsTracker.trackEvent(AnalyticsEvent.AddCommuterAgreements.INSTANCE);
                    bornholmCommuterManager$addAgreements$1.L$0 = null;
                    bornholmCommuterManager$addAgreements$1.L$1 = null;
                    bornholmCommuterManager$addAgreements$1.label = 4;
                    obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult, bornholmCommuterManager$addAgreements$1);
                    if (obj == coroutine_suspended) {
                    }
                }
                ApiResult apiResult2 = (ApiResult) obj;
                bornholmCommuterManager$addAgreements$1.L$0 = bornholmCommuterManager;
                bornholmCommuterManager$addAgreements$1.L$1 = apiResult2;
                bornholmCommuterManager$addAgreements$1.label = 2;
                configurationTransports = bornholmCommuterManager.getConfigurationTransports(bornholmCommuterManager$addAgreements$1);
                if (configurationTransports != coroutine_suspended) {
                    return coroutine_suspended;
                }
                bornholmCommuterManager2 = bornholmCommuterManager;
                apiResult = apiResult2;
                obj = configurationTransports;
                bornholmCommuterManager$addAgreements$2 = new BornholmCommuterManager$addAgreements$2(bornholmCommuterManager2, (List) obj, null);
                bornholmCommuterManager$addAgreements$1.L$0 = bornholmCommuterManager2;
                bornholmCommuterManager$addAgreements$1.L$1 = apiResult;
                bornholmCommuterManager$addAgreements$1.label = 3;
                if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, bornholmCommuterManager$addAgreements$2, bornholmCommuterManager$addAgreements$1) == coroutine_suspended) {
                }
                bornholmCommuterManager2.analyticsTracker.trackEvent(AnalyticsEvent.AddCommuterAgreements.INSTANCE);
                bornholmCommuterManager$addAgreements$1.L$0 = null;
                bornholmCommuterManager$addAgreements$1.L$1 = null;
                bornholmCommuterManager$addAgreements$1.label = 4;
                obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult, bornholmCommuterManager$addAgreements$1);
                if (obj == coroutine_suspended) {
                }
            }
        }
        bornholmCommuterManager$addAgreements$1 = new BornholmCommuterManager$addAgreements$1(this, continuation);
        Object obj2 = bornholmCommuterManager$addAgreements$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = bornholmCommuterManager$addAgreements$1.label;
        if (i5 != 0) {
        }
        ApiResult apiResult22 = (ApiResult) obj2;
        bornholmCommuterManager$addAgreements$1.L$0 = bornholmCommuterManager;
        bornholmCommuterManager$addAgreements$1.L$1 = apiResult22;
        bornholmCommuterManager$addAgreements$1.label = 2;
        configurationTransports = bornholmCommuterManager.getConfigurationTransports(bornholmCommuterManager$addAgreements$1);
        if (configurationTransports != coroutine_suspended) {
        }
    }

    @Override // dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager
    public List<BookingFromAlternateSource> getAgreementBookingsAsAlternateSource() {
        List agreements = CommuterDataStateExtensionsKt.getAgreements(getState().getValue().getAgreementsState());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(agreements, 10));
        Iterator it = agreements.iterator();
        while (it.hasNext()) {
            List<BornholmCommuterBooking> activeTickets = ((BornholmCommuterAgreement) it.next()).getActiveTickets();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(activeTickets, 10));
            Iterator<T> it2 = activeTickets.iterator();
            while (it2.hasNext()) {
                arrayList2.add(new BookingFromAlternateSource((BornholmCommuterBooking) it2.next()));
            }
            arrayList.add(arrayList2);
        }
        return CollectionsKt.flatten(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x009c A[PHI: r11
      0x009c: PHI (r11v14 java.lang.Object) = (r11v13 java.lang.Object), (r11v1 java.lang.Object) binds: [B:17:0x0099, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getAgreementHistory(String str, String str2, Continuation<? super ManagerResult<? extends List<BornholmCommuterBooking>>> continuation) {
        BornholmCommuterManager$getAgreementHistory$1 bornholmCommuterManager$getAgreementHistory$1;
        int i5;
        Object obj;
        String text;
        if (continuation instanceof BornholmCommuterManager$getAgreementHistory$1) {
            bornholmCommuterManager$getAgreementHistory$1 = (BornholmCommuterManager$getAgreementHistory$1) continuation;
            int i6 = bornholmCommuterManager$getAgreementHistory$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                bornholmCommuterManager$getAgreementHistory$1.label = i6 - Integer.MIN_VALUE;
                Object obj2 = bornholmCommuterManager$getAgreementHistory$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = bornholmCommuterManager$getAgreementHistory$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Iterator it = CommuterDataStateExtensionsKt.getAgreements(getState().getValue().getAgreementsState()).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        BornholmCommuterAgreement bornholmCommuterAgreement = (BornholmCommuterAgreement) obj;
                        if (Intrinsics.areEqual(bornholmCommuterAgreement.getCommuterId(), str) && Intrinsics.areEqual(bornholmCommuterAgreement.getCommuterAgreementId(), str2)) {
                            break;
                        }
                    }
                    BornholmCommuterAgreement bornholmCommuterAgreement2 = (BornholmCommuterAgreement) obj;
                    if (bornholmCommuterAgreement2 == null || (text = bornholmCommuterAgreement2.getText()) == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IBornholmCommuterService iBornholmCommuterService = this.service;
                    bornholmCommuterManager$getAgreementHistory$1.label = 1;
                    obj2 = iBornholmCommuterService.getCommuterHistory(str, str2, text, bornholmCommuterManager$getAgreementHistory$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj2);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj2);
                }
                BornholmCommuterManager$getAgreementHistory$2 bornholmCommuterManager$getAgreementHistory$2 = new BornholmCommuterManager$getAgreementHistory$2(null);
                bornholmCommuterManager$getAgreementHistory$1.label = 2;
                obj2 = ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj2, bornholmCommuterManager$getAgreementHistory$2, bornholmCommuterManager$getAgreementHistory$1);
                return obj2 != coroutine_suspended ? coroutine_suspended : obj2;
            }
        }
        bornholmCommuterManager$getAgreementHistory$1 = new BornholmCommuterManager$getAgreementHistory$1(this, continuation);
        Object obj22 = bornholmCommuterManager$getAgreementHistory$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = bornholmCommuterManager$getAgreementHistory$1.label;
        if (i5 != 0) {
        }
        BornholmCommuterManager$getAgreementHistory$2 bornholmCommuterManager$getAgreementHistory$22 = new BornholmCommuterManager$getAgreementHistory$2(null);
        bornholmCommuterManager$getAgreementHistory$1.label = 2;
        obj22 = ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj22, bornholmCommuterManager$getAgreementHistory$22, bornholmCommuterManager$getAgreementHistory$1);
        if (obj22 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0104 -> B:12:0x0108). Please report as a decompilation issue!!! */
    @Override // dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadAgreements(Continuation<? super Unit> continuation) {
        BornholmCommuterManager$loadAgreements$1 bornholmCommuterManager$loadAgreements$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        BornholmCommuterManager bornholmCommuterManager;
        List<Transportation> list;
        List list2;
        IBornholmCommuterManager.State value;
        List<Transportation> list3;
        CommuterDataState<BornholmCommuterAgreement> agreementsState;
        BornholmCommuterManager bornholmCommuterManager2;
        Iterator it;
        IBornholmCommuterManager.State value2;
        IBornholmCommuterManager.State value3;
        CommuterDataState<BornholmCommuterAgreement> plus;
        if (continuation instanceof BornholmCommuterManager$loadAgreements$1) {
            bornholmCommuterManager$loadAgreements$1 = (BornholmCommuterManager$loadAgreements$1) continuation;
            int i6 = bornholmCommuterManager$loadAgreements$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                bornholmCommuterManager$loadAgreements$1.label = i6 - Integer.MIN_VALUE;
                obj = bornholmCommuterManager$loadAgreements$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = bornholmCommuterManager$loadAgreements$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    bornholmCommuterManager$loadAgreements$1.L$0 = this;
                    bornholmCommuterManager$loadAgreements$1.label = 1;
                    obj = getConfigurationTransports(bornholmCommuterManager$loadAgreements$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bornholmCommuterManager = this;
                } else if (i5 == 1) {
                    BornholmCommuterManager bornholmCommuterManager3 = (BornholmCommuterManager) bornholmCommuterManager$loadAgreements$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    bornholmCommuterManager = bornholmCommuterManager3;
                } else if (i5 == 2) {
                    list = (List) bornholmCommuterManager$loadAgreements$1.L$1;
                    bornholmCommuterManager = (BornholmCommuterManager) bornholmCommuterManager$loadAgreements$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    list2 = (List) obj;
                    if (list2.isEmpty()) {
                        MutableStateFlow<IBornholmCommuterManager.State> state = bornholmCommuterManager.getState();
                        do {
                            value2 = state.getValue();
                        } while (!state.compareAndSet(value2, value2.copy(new CommuterDataState.Data(CollectionsKt.emptyList()), Boxing.boxBoolean(false))));
                        return Unit.INSTANCE;
                    }
                    MutableStateFlow<IBornholmCommuterManager.State> state2 = bornholmCommuterManager.getState();
                    do {
                        value = state2.getValue();
                    } while (!state2.compareAndSet(value, IBornholmCommuterManager.State.copy$default(value, null, Boxing.boxBoolean(true), 1, null)));
                    list3 = list;
                    agreementsState = bornholmCommuterManager.getState().getValue().getAgreementsState();
                    bornholmCommuterManager2 = bornholmCommuterManager;
                    it = list2.iterator();
                    BornholmCommuterManager bornholmCommuterManager4 = bornholmCommuterManager2;
                    if (it.hasNext()) {
                    }
                } else {
                    if (i5 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    CommuterDataState<BornholmCommuterAgreement> commuterDataState = (CommuterDataState) bornholmCommuterManager$loadAgreements$1.L$4;
                    String str = (String) bornholmCommuterManager$loadAgreements$1.L$3;
                    it = (Iterator) bornholmCommuterManager$loadAgreements$1.L$2;
                    list3 = (List) bornholmCommuterManager$loadAgreements$1.L$1;
                    BornholmCommuterManager bornholmCommuterManager5 = (BornholmCommuterManager) bornholmCommuterManager$loadAgreements$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    ApiResult apiResult = (ApiResult) obj;
                    if (apiResult instanceof ApiResult.Error) {
                        plus = new CommuterDataState.Error<>(CommuterDataStateExtensionsKt.getAgreements(commuterDataState));
                    } else {
                        if (!(apiResult instanceof ApiResult.Success)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        plus = bornholmCommuterManager5.plus(commuterDataState, bornholmCommuterManager5.mapAgreements(str, (List) ((ApiResult.Success) apiResult).getData(), list3));
                    }
                    bornholmCommuterManager2 = bornholmCommuterManager5;
                    agreementsState = plus;
                    BornholmCommuterManager bornholmCommuterManager42 = bornholmCommuterManager2;
                    if (it.hasNext()) {
                        str = (String) it.next();
                        IBornholmCommuterService iBornholmCommuterService = bornholmCommuterManager42.service;
                        bornholmCommuterManager$loadAgreements$1.L$0 = bornholmCommuterManager42;
                        bornholmCommuterManager$loadAgreements$1.L$1 = list3;
                        bornholmCommuterManager$loadAgreements$1.L$2 = it;
                        bornholmCommuterManager$loadAgreements$1.L$3 = str;
                        bornholmCommuterManager$loadAgreements$1.L$4 = agreementsState;
                        bornholmCommuterManager$loadAgreements$1.label = 3;
                        Object commuterAgreements = iBornholmCommuterService.getCommuterAgreements(str, bornholmCommuterManager$loadAgreements$1);
                        if (commuterAgreements == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        CommuterDataState<BornholmCommuterAgreement> commuterDataState2 = agreementsState;
                        bornholmCommuterManager5 = bornholmCommuterManager42;
                        obj = commuterAgreements;
                        commuterDataState = commuterDataState2;
                        ApiResult apiResult2 = (ApiResult) obj;
                        if (apiResult2 instanceof ApiResult.Error) {
                        }
                        bornholmCommuterManager2 = bornholmCommuterManager5;
                        agreementsState = plus;
                        BornholmCommuterManager bornholmCommuterManager422 = bornholmCommuterManager2;
                        if (it.hasNext()) {
                            MutableStateFlow<IBornholmCommuterManager.State> state3 = bornholmCommuterManager422.getState();
                            do {
                                value3 = state3.getValue();
                            } while (!state3.compareAndSet(value3, IBornholmCommuterManager.State.copy$default(value3, agreementsState, null, 2, null)));
                            return Unit.INSTANCE;
                        }
                    }
                }
                list = (List) obj;
                IBornholmCommuterRepository iBornholmCommuterRepository = bornholmCommuterManager.repo;
                bornholmCommuterManager$loadAgreements$1.L$0 = bornholmCommuterManager;
                bornholmCommuterManager$loadAgreements$1.L$1 = list;
                bornholmCommuterManager$loadAgreements$1.label = 2;
                obj = iBornholmCommuterRepository.getCommuterIds(bornholmCommuterManager$loadAgreements$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list2 = (List) obj;
                if (list2.isEmpty()) {
                }
            }
        }
        bornholmCommuterManager$loadAgreements$1 = new BornholmCommuterManager$loadAgreements$1(this, continuation);
        obj = bornholmCommuterManager$loadAgreements$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = bornholmCommuterManager$loadAgreements$1.label;
        if (i5 != 0) {
        }
        list = (List) obj;
        IBornholmCommuterRepository iBornholmCommuterRepository2 = bornholmCommuterManager.repo;
        bornholmCommuterManager$loadAgreements$1.L$0 = bornholmCommuterManager;
        bornholmCommuterManager$loadAgreements$1.L$1 = list;
        bornholmCommuterManager$loadAgreements$1.label = 2;
        obj = iBornholmCommuterRepository2.getCommuterIds(bornholmCommuterManager$loadAgreements$1);
        if (obj == coroutine_suspended) {
        }
        list2 = (List) obj;
        if (list2.isEmpty()) {
        }
    }

    public final CommuterDataState<BornholmCommuterAgreement> plus(CommuterDataState<BornholmCommuterAgreement> commuterDataState, List<BornholmCommuterAgreement> agreements) {
        CommuterDataState<BornholmCommuterAgreement> error;
        Intrinsics.checkNotNullParameter(commuterDataState, "<this>");
        Intrinsics.checkNotNullParameter(agreements, "agreements");
        if (commuterDataState instanceof CommuterDataState.Undetermined) {
            return new CommuterDataState.Data(agreements);
        }
        if (commuterDataState instanceof CommuterDataState.Data) {
            error = new CommuterDataState.Data<>(distinctById(CollectionsKt.plus((Collection) ((CommuterDataState.Data) commuterDataState).getAgreements(), (Iterable) agreements)));
        } else {
            if (!(commuterDataState instanceof CommuterDataState.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            List existingData = ((CommuterDataState.Error) commuterDataState).getExistingData();
            if (existingData == null) {
                existingData = CollectionsKt.emptyList();
            }
            error = new CommuterDataState.Error<>(distinctById(CollectionsKt.plus((Collection) existingData, (Iterable) agreements)));
        }
        return error;
    }

    @Override // dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager
    public MutableStateFlow<IBornholmCommuterManager.State> getState() {
        return this.state;
    }
}
