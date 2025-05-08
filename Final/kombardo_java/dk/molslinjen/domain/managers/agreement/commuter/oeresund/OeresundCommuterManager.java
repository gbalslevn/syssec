package dk.molslinjen.domain.managers.agreement.commuter.oeresund;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.commuter.oeresund.IOeresundCommuterService;
import dk.molslinjen.api.services.commuter.oeresund.response.OeresundCommuterAgreementDTO;
import dk.molslinjen.domain.localstorage.agreements.commuter.oeresund.IOeresundCommuterRepository;
import dk.molslinjen.domain.managers.agreement.commuter.CommuterDataState;
import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.AuthToken;
import dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreement;
import dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreementType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/domain/managers/agreement/commuter/oeresund/OeresundCommuterManager;", "Ldk/molslinjen/domain/managers/agreement/commuter/oeresund/IOeresundCommuterManager;", "service", "Ldk/molslinjen/api/services/commuter/oeresund/IOeresundCommuterService;", "oeresundCommuterRepository", "Ldk/molslinjen/domain/localstorage/agreements/commuter/oeresund/IOeresundCommuterRepository;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "<init>", "(Ldk/molslinjen/api/services/commuter/oeresund/IOeresundCommuterService;Ldk/molslinjen/domain/localstorage/agreements/commuter/oeresund/IOeresundCommuterRepository;Ldk/molslinjen/domain/managers/user/IUserManager;)V", "localScope", "Lkotlinx/coroutines/CoroutineScope;", "state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/agreement/commuter/CommuterDataState;", "Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;", "getState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "previousAuthenticationType", "Ldk/molslinjen/domain/managers/user/AuthenticationType;", "setupAuthenticationListener", BuildConfig.FLAVOR, "loadAgreements", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeLocalAssets", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OeresundCommuterManager implements IOeresundCommuterManager {
    private final CoroutineScope localScope;
    private final IOeresundCommuterRepository oeresundCommuterRepository;
    private AuthenticationType previousAuthenticationType;
    private final IOeresundCommuterService service;
    private final MutableStateFlow<CommuterDataState<OeresundCommuterAgreement>> state;
    private final IUserManager userManager;

    public OeresundCommuterManager(IOeresundCommuterService service, IOeresundCommuterRepository oeresundCommuterRepository, IUserManager userManager) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(oeresundCommuterRepository, "oeresundCommuterRepository");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        this.service = service;
        this.oeresundCommuterRepository = oeresundCommuterRepository;
        this.userManager = userManager;
        this.localScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.state = StateFlowKt.MutableStateFlow(CommuterDataState.Undetermined.INSTANCE);
        this.previousAuthenticationType = userManager.getAuthenticationType().getValue();
        setupAuthenticationListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object removeLocalAssets(Continuation<? super Unit> continuation) {
        MutableStateFlow<CommuterDataState<OeresundCommuterAgreement>> state = getState();
        do {
        } while (!state.compareAndSet(state.getValue(), CommuterDataState.Undetermined.INSTANCE));
        Object clear = this.oeresundCommuterRepository.clear(continuation);
        return clear == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clear : Unit.INSTANCE;
    }

    private final void setupAuthenticationListener() {
        BuildersKt__Builders_commonKt.launch$default(this.localScope, null, null, new OeresundCommuterManager$setupAuthenticationListener$1(this, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // dk.molslinjen.domain.managers.agreement.commuter.oeresund.IOeresundCommuterManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadAgreements(Continuation<? super Unit> continuation) {
        OeresundCommuterManager$loadAgreements$1 oeresundCommuterManager$loadAgreements$1;
        int i5;
        OeresundCommuterManager oeresundCommuterManager;
        List list;
        String mo3198getAuthTokenOEbVFrA;
        List list2;
        ApiResult apiResult;
        List<OeresundCommuterAgreement> list3;
        OeresundCommuterManager oeresundCommuterManager2;
        MutableStateFlow<CommuterDataState<OeresundCommuterAgreement>> state;
        if (continuation instanceof OeresundCommuterManager$loadAgreements$1) {
            oeresundCommuterManager$loadAgreements$1 = (OeresundCommuterManager$loadAgreements$1) continuation;
            int i6 = oeresundCommuterManager$loadAgreements$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                oeresundCommuterManager$loadAgreements$1.label = i6 - Integer.MIN_VALUE;
                Object obj = oeresundCommuterManager$loadAgreements$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = oeresundCommuterManager$loadAgreements$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IOeresundCommuterRepository iOeresundCommuterRepository = this.oeresundCommuterRepository;
                    oeresundCommuterManager$loadAgreements$1.L$0 = this;
                    oeresundCommuterManager$loadAgreements$1.label = 1;
                    obj = iOeresundCommuterRepository.getAgreements(oeresundCommuterManager$loadAgreements$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    oeresundCommuterManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            list3 = (List) oeresundCommuterManager$loadAgreements$1.L$1;
                            oeresundCommuterManager2 = (OeresundCommuterManager) oeresundCommuterManager$loadAgreements$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            state = oeresundCommuterManager2.getState();
                            do {
                            } while (!state.compareAndSet(state.getValue(), new CommuterDataState.Data(list3)));
                            return Unit.INSTANCE;
                        }
                        List list4 = (List) oeresundCommuterManager$loadAgreements$1.L$1;
                        OeresundCommuterManager oeresundCommuterManager3 = (OeresundCommuterManager) oeresundCommuterManager$loadAgreements$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        list2 = list4;
                        oeresundCommuterManager = oeresundCommuterManager3;
                        apiResult = (ApiResult) obj;
                        if (!(apiResult instanceof ApiResult.Error)) {
                            MutableStateFlow<CommuterDataState<OeresundCommuterAgreement>> state2 = oeresundCommuterManager.getState();
                            do {
                            } while (!state2.compareAndSet(state2.getValue(), new CommuterDataState.Error(list2)));
                            return Unit.INSTANCE;
                        }
                        if (!(apiResult instanceof ApiResult.Success)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Iterable iterable = (Iterable) ((ApiResult.Success) apiResult).getData();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                        Iterator it = iterable.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new OeresundCommuterAgreement((OeresundCommuterAgreementDTO) it.next()));
                        }
                        final Comparator comparator = new Comparator() { // from class: dk.molslinjen.domain.managers.agreement.commuter.oeresund.OeresundCommuterManager$loadAgreements$$inlined$compareBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t5, T t6) {
                                OeresundCommuterAgreementType agreementType = ((OeresundCommuterAgreement) t5).getAgreementType();
                                OeresundCommuterAgreementType oeresundCommuterAgreementType = OeresundCommuterAgreementType.Bizz;
                                return ComparisonsKt.compareValues(Boolean.valueOf(agreementType == oeresundCommuterAgreementType), Boolean.valueOf(((OeresundCommuterAgreement) t6).getAgreementType() == oeresundCommuterAgreementType));
                            }
                        };
                        List<OeresundCommuterAgreement> sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: dk.molslinjen.domain.managers.agreement.commuter.oeresund.OeresundCommuterManager$loadAgreements$$inlined$thenByDescending$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t5, T t6) {
                                int compare = comparator.compare(t5, t6);
                                return compare != 0 ? compare : ComparisonsKt.compareValues(((OeresundCommuterAgreement) t6).getAgreementId(), ((OeresundCommuterAgreement) t5).getAgreementId());
                            }
                        });
                        IOeresundCommuterRepository iOeresundCommuterRepository2 = oeresundCommuterManager.oeresundCommuterRepository;
                        oeresundCommuterManager$loadAgreements$1.L$0 = oeresundCommuterManager;
                        oeresundCommuterManager$loadAgreements$1.L$1 = sortedWith;
                        oeresundCommuterManager$loadAgreements$1.label = 3;
                        if (iOeresundCommuterRepository2.saveAll(sortedWith, oeresundCommuterManager$loadAgreements$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        list3 = sortedWith;
                        oeresundCommuterManager2 = oeresundCommuterManager;
                        state = oeresundCommuterManager2.getState();
                        do {
                        } while (!state.compareAndSet(state.getValue(), new CommuterDataState.Data(list3)));
                        return Unit.INSTANCE;
                    }
                    oeresundCommuterManager = (OeresundCommuterManager) oeresundCommuterManager$loadAgreements$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                list = (List) obj;
                if (!list.isEmpty()) {
                    MutableStateFlow<CommuterDataState<OeresundCommuterAgreement>> state3 = oeresundCommuterManager.getState();
                    do {
                    } while (!state3.compareAndSet(state3.getValue(), new CommuterDataState.Data(list)));
                }
                mo3198getAuthTokenOEbVFrA = oeresundCommuterManager.userManager.mo3198getAuthTokenOEbVFrA();
                if (mo3198getAuthTokenOEbVFrA != null) {
                    MutableStateFlow<CommuterDataState<OeresundCommuterAgreement>> state4 = oeresundCommuterManager.getState();
                    do {
                    } while (!state4.compareAndSet(state4.getValue(), new CommuterDataState.Data(CollectionsKt.emptyList())));
                    return Unit.INSTANCE;
                }
                IOeresundCommuterService iOeresundCommuterService = oeresundCommuterManager.service;
                AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                oeresundCommuterManager$loadAgreements$1.L$0 = oeresundCommuterManager;
                oeresundCommuterManager$loadAgreements$1.L$1 = list;
                oeresundCommuterManager$loadAgreements$1.label = 2;
                Object agreements = iOeresundCommuterService.getAgreements(m3214toDTOimpl, oeresundCommuterManager$loadAgreements$1);
                if (agreements == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list2 = list;
                obj = agreements;
                apiResult = (ApiResult) obj;
                if (!(apiResult instanceof ApiResult.Error)) {
                }
            }
        }
        oeresundCommuterManager$loadAgreements$1 = new OeresundCommuterManager$loadAgreements$1(this, continuation);
        Object obj2 = oeresundCommuterManager$loadAgreements$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = oeresundCommuterManager$loadAgreements$1.label;
        if (i5 != 0) {
        }
        list = (List) obj2;
        if (!list.isEmpty()) {
        }
        mo3198getAuthTokenOEbVFrA = oeresundCommuterManager.userManager.mo3198getAuthTokenOEbVFrA();
        if (mo3198getAuthTokenOEbVFrA != null) {
        }
    }

    @Override // dk.molslinjen.domain.managers.agreement.commuter.oeresund.IOeresundCommuterManager
    public MutableStateFlow<CommuterDataState<OeresundCommuterAgreement>> getState() {
        return this.state;
    }
}
