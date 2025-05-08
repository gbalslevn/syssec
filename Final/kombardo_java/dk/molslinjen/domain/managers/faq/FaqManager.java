package dk.molslinjen.domain.managers.faq;

import androidx.appcompat.R$styleable;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.faq.IFaqService;
import dk.molslinjen.api.services.faq.response.FaqCategoriesDTO;
import dk.molslinjen.api.services.faq.response.FaqSubjectDTO;
import dk.molslinjen.domain.extensions.ApiResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.site.ISiteManager;
import dk.molslinjen.domain.model.faq.FaqPopularQuestion;
import dk.molslinjen.domain.model.faq.FaqQuestionAndAnswer;
import dk.molslinjen.domain.model.faq.FaqSubject;
import dk.molslinjen.domain.model.faq.SiteFaq;
import dk.molslinjen.domain.model.site.SiteInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/domain/managers/faq/FaqManager;", "Ldk/molslinjen/domain/managers/faq/IFaqManager;", "Ldk/molslinjen/domain/managers/site/ISiteManager;", "siteManager", "Ldk/molslinjen/api/services/faq/IFaqService;", "service", "<init>", "(Ldk/molslinjen/domain/managers/site/ISiteManager;Ldk/molslinjen/api/services/faq/IFaqService;)V", "Ldk/molslinjen/domain/model/site/SiteInfo;", "siteInfo", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "loadFaq", "(Ldk/molslinjen/domain/model/site/SiteInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldk/molslinjen/domain/managers/site/ISiteManager;", "Ldk/molslinjen/api/services/faq/IFaqService;", "Lkotlinx/coroutines/CoroutineScope;", "localScope", "Lkotlinx/coroutines/CoroutineScope;", "getLocalScope", "()Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/faq/FaqManagerState;", "latestFaqState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getLatestFaqState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FaqManager implements IFaqManager {
    private final MutableStateFlow<FaqManagerState> latestFaqState;
    private final CoroutineScope localScope;
    private final IFaqService service;
    private final ISiteManager siteManager;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.faq.FaqManager$1", f = "FaqManager.kt", l = {R$styleable.Toolbar_titleTextColor}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.faq.FaqManager$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/site/SiteInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.domain.managers.faq.FaqManager$1$1", f = "FaqManager.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.domain.managers.faq.FaqManager$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00371 extends SuspendLambda implements Function2<List<? extends SiteInfo>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ FaqManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00371(FaqManager faqManager, Continuation<? super C00371> continuation) {
                super(2, continuation);
                this.this$0 = faqManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00371 c00371 = new C00371(this.this$0, continuation);
                c00371.L$0 = obj;
                return c00371;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(List<? extends SiteInfo> list, Continuation<? super Unit> continuation) {
                return invoke2((List<SiteInfo>) list, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                FaqManagerState value;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                List list = (List) this.L$0;
                MutableStateFlow<FaqManagerState> latestFaqState = this.this$0.getLatestFaqState();
                do {
                    value = latestFaqState.getValue();
                } while (!latestFaqState.compareAndSet(value, FaqManagerState.copy$default(value, null, list, 1, null)));
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(List<SiteInfo> list, Continuation<? super Unit> continuation) {
                return ((C00371) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
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
                StateFlow<List<SiteInfo>> availableSites = FaqManager.this.siteManager.getAvailableSites();
                C00371 c00371 = new C00371(FaqManager.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(availableSites, c00371, this) == coroutine_suspended) {
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

    public FaqManager(ISiteManager siteManager, IFaqService service) {
        Intrinsics.checkNotNullParameter(siteManager, "siteManager");
        Intrinsics.checkNotNullParameter(service, "service");
        this.siteManager = siteManager;
        this.service = service;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.localScope = CoroutineScope;
        this.latestFaqState = StateFlowKt.MutableStateFlow(new FaqManagerState(null, null, 3, null));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x016e A[PHI: r1
      0x016e: PHI (r1v7 java.lang.Object) = (r1v6 java.lang.Object), (r1v1 java.lang.Object) binds: [B:24:0x016b, B:10:0x002c] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x016d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // dk.molslinjen.domain.managers.faq.IFaqManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadFaq(SiteInfo siteInfo, Continuation<? super ManagerResult<Unit>> continuation) {
        FaqManager$loadFaq$1 faqManager$loadFaq$1;
        int i5;
        FaqManager faqManager;
        SiteInfo siteInfo2;
        ApiResult apiResult;
        FaqManagerState value;
        int i6;
        FaqManagerState value2;
        if (continuation instanceof FaqManager$loadFaq$1) {
            faqManager$loadFaq$1 = (FaqManager$loadFaq$1) continuation;
            int i7 = faqManager$loadFaq$1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                faqManager$loadFaq$1.label = i7 - Integer.MIN_VALUE;
                Object obj = faqManager$loadFaq$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = faqManager$loadFaq$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IFaqService iFaqService = this.service;
                    SiteDTO dto = siteInfo.getSite().toDTO();
                    faqManager$loadFaq$1.L$0 = this;
                    faqManager$loadFaq$1.L$1 = siteInfo;
                    faqManager$loadFaq$1.label = 1;
                    obj = iFaqService.getFaq(dto, faqManager$loadFaq$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    faqManager = this;
                    siteInfo2 = siteInfo;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    siteInfo2 = (SiteInfo) faqManager$loadFaq$1.L$1;
                    faqManager = (FaqManager) faqManager$loadFaq$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                apiResult = (ApiResult) obj;
                if (!(apiResult instanceof ApiResult.Error)) {
                    MutableStateFlow<FaqManagerState> latestFaqState = faqManager.getLatestFaqState();
                    do {
                        value2 = latestFaqState.getValue();
                    } while (!latestFaqState.compareAndSet(value2, FaqManagerState.copy$default(value2, new SiteFaq(siteInfo2, CollectionsKt.emptyList(), CollectionsKt.emptyList()), null, 2, null)));
                    i6 = 2;
                } else {
                    if (!(apiResult instanceof ApiResult.Success)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    List<FaqSubjectDTO> faqCategories = ((FaqCategoriesDTO) ((ApiResult.Success) apiResult).getData()).getFaqCategories();
                    int i8 = 10;
                    ArrayList<FaqSubject> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(faqCategories, 10));
                    Iterator<T> it = faqCategories.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new FaqSubject((FaqSubjectDTO) it.next()));
                    }
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                    for (FaqSubject faqSubject : arrayList) {
                        List<FaqQuestionAndAnswer> questionAndAnswers = faqSubject.getQuestionAndAnswers();
                        ArrayList<FaqQuestionAndAnswer> arrayList3 = new ArrayList();
                        for (Object obj2 : questionAndAnswers) {
                            if (((FaqQuestionAndAnswer) obj2).isPopular()) {
                                arrayList3.add(obj2);
                            }
                        }
                        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, i8));
                        for (FaqQuestionAndAnswer faqQuestionAndAnswer : arrayList3) {
                            arrayList4.add(new FaqPopularQuestion(faqSubject.m3239getIdpbmbVKA(), faqQuestionAndAnswer.m3228getIdarQqKPc(), faqQuestionAndAnswer.getQuestion(), null));
                        }
                        arrayList2.add(arrayList4);
                        i8 = 10;
                    }
                    List flatten = CollectionsKt.flatten(arrayList2);
                    MutableStateFlow<FaqManagerState> latestFaqState2 = faqManager.getLatestFaqState();
                    do {
                        value = latestFaqState2.getValue();
                        i6 = 2;
                    } while (!latestFaqState2.compareAndSet(value, FaqManagerState.copy$default(value, new SiteFaq(siteInfo2, flatten, arrayList), null, 2, null)));
                }
                faqManager$loadFaq$1.L$0 = null;
                faqManager$loadFaq$1.L$1 = null;
                faqManager$loadFaq$1.label = i6;
                obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult, faqManager$loadFaq$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        faqManager$loadFaq$1 = new FaqManager$loadFaq$1(this, continuation);
        Object obj3 = faqManager$loadFaq$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = faqManager$loadFaq$1.label;
        if (i5 != 0) {
        }
        apiResult = (ApiResult) obj3;
        if (!(apiResult instanceof ApiResult.Error)) {
        }
        faqManager$loadFaq$1.L$0 = null;
        faqManager$loadFaq$1.L$1 = null;
        faqManager$loadFaq$1.label = i6;
        obj3 = ApiResultExtensionsKt.toUnitManagerResult(apiResult, faqManager$loadFaq$1);
        if (obj3 != coroutine_suspended2) {
        }
    }

    @Override // dk.molslinjen.domain.managers.faq.IFaqManager
    public MutableStateFlow<FaqManagerState> getLatestFaqState() {
        return this.latestFaqState;
    }
}
