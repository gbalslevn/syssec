package dk.molslinjen.domain.managers.user.newsletters;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.newsletters.INewslettersService;
import dk.molslinjen.api.services.newsletters.response.NewslettersSubscriptionsResponseDTO;
import dk.molslinjen.domain.extensions.ApiResultExtensionsKt;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.site.SiteManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.AuthToken;
import dk.molslinjen.domain.model.account.newsletters.NewsletterSubscription;
import dk.molslinjen.domain.model.config.Site;
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

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016J8\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0096@¢\u0006\u0002\u0010\u001dJ)\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Ldk/molslinjen/domain/managers/user/newsletters/NewslettersManager;", "Ldk/molslinjen/domain/managers/user/newsletters/INewslettersManager;", "newslettersService", "Ldk/molslinjen/api/services/newsletters/INewslettersService;", "siteManager", "Ldk/molslinjen/domain/managers/site/SiteManager;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "<init>", "(Ldk/molslinjen/api/services/newsletters/INewslettersService;Ldk/molslinjen/domain/managers/site/SiteManager;Ldk/molslinjen/domain/managers/user/IUserManager;)V", "localScope", "Lkotlinx/coroutines/CoroutineScope;", "state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/user/newsletters/NewslettersManagerState;", "getState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "loadSubscriptions", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "email", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSubscription", "site", "Ldk/molslinjen/domain/model/config/Site;", "allowNewsletter", BuildConfig.FLAVOR, "allowMarketingPromotions", "(Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocalState", "(Ldk/molslinjen/domain/model/config/Site;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NewslettersManager implements INewslettersManager {
    private final CoroutineScope localScope;
    private final INewslettersService newslettersService;
    private final SiteManager siteManager;
    private final MutableStateFlow<NewslettersManagerState> state;
    private final IUserManager userManager;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.user.newsletters.NewslettersManager$1", f = "NewslettersManager.kt", l = {30}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.user.newsletters.NewslettersManager$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/domain/model/site/SiteInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.domain.managers.user.newsletters.NewslettersManager$1$1", f = "NewslettersManager.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.domain.managers.user.newsletters.NewslettersManager$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00421 extends SuspendLambda implements Function2<SiteInfo, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NewslettersManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00421(NewslettersManager newslettersManager, Continuation<? super C00421> continuation) {
                super(2, continuation);
                this.this$0 = newslettersManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00421 c00421 = new C00421(this.this$0, continuation);
                c00421.L$0 = obj;
                return c00421;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(SiteInfo siteInfo, Continuation<? super Unit> continuation) {
                return ((C00421) create(siteInfo, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                NewslettersManagerState value;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                SiteInfo siteInfo = (SiteInfo) this.L$0;
                MutableStateFlow<NewslettersManagerState> state = this.this$0.getState();
                do {
                    value = state.getValue();
                } while (!state.compareAndSet(value, NewslettersManagerState.copy$default(value, null, siteInfo, 1, null)));
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
                StateFlow<SiteInfo> selectedSite = NewslettersManager.this.siteManager.getSelectedSite();
                C00421 c00421 = new C00421(NewslettersManager.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(selectedSite, c00421, this) == coroutine_suspended) {
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

    public NewslettersManager(INewslettersService newslettersService, SiteManager siteManager, IUserManager userManager) {
        Intrinsics.checkNotNullParameter(newslettersService, "newslettersService");
        Intrinsics.checkNotNullParameter(siteManager, "siteManager");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        this.newslettersService = newslettersService;
        this.siteManager = siteManager;
        this.userManager = userManager;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.localScope = CoroutineScope;
        this.state = StateFlowKt.MutableStateFlow(new NewslettersManagerState(null, null, 3, null));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    private final void updateLocalState(Site site, Boolean allowNewsletter, Boolean allowMarketingPromotions) {
        NewslettersManagerState value;
        NewslettersManagerState newslettersManagerState;
        ArrayList arrayList;
        MutableStateFlow<NewslettersManagerState> state = getState();
        do {
            value = state.getValue();
            newslettersManagerState = value;
            List<NewsletterSubscription> subscriptions = newslettersManagerState.getSubscriptions();
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subscriptions, 10));
            for (NewsletterSubscription newsletterSubscription : subscriptions) {
                if (newsletterSubscription.getSiteInfo().getSite() == site) {
                    newsletterSubscription = NewsletterSubscription.copy$default(newsletterSubscription, null, allowNewsletter != null ? allowNewsletter.booleanValue() : newsletterSubscription.isNewslettersSubscribed(), allowMarketingPromotions != null ? allowMarketingPromotions.booleanValue() : newsletterSubscription.isPromotionsSubscribed(), 1, null);
                }
                arrayList.add(newsletterSubscription);
            }
        } while (!state.compareAndSet(value, NewslettersManagerState.copy$default(newslettersManagerState, arrayList, null, 2, null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.user.newsletters.INewslettersManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadSubscriptions(String str, Continuation<? super ManagerResult<Unit>> continuation) {
        NewslettersManager$loadSubscriptions$1 newslettersManager$loadSubscriptions$1;
        int i5;
        NewslettersManager newslettersManager;
        ManagerResult managerResult;
        MutableStateFlow<NewslettersManagerState> state;
        NewslettersManagerState value;
        NewslettersManagerState copy$default;
        Object obj;
        if (continuation instanceof NewslettersManager$loadSubscriptions$1) {
            newslettersManager$loadSubscriptions$1 = (NewslettersManager$loadSubscriptions$1) continuation;
            int i6 = newslettersManager$loadSubscriptions$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                newslettersManager$loadSubscriptions$1.label = i6 - Integer.MIN_VALUE;
                Object obj2 = newslettersManager$loadSubscriptions$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = newslettersManager$loadSubscriptions$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    String mo3198getAuthTokenOEbVFrA = this.userManager.mo3198getAuthTokenOEbVFrA();
                    if (mo3198getAuthTokenOEbVFrA == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    INewslettersService iNewslettersService = this.newslettersService;
                    AuthTokenDTO m3214toDTOimpl = AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA);
                    newslettersManager$loadSubscriptions$1.L$0 = this;
                    newslettersManager$loadSubscriptions$1.label = 1;
                    obj2 = iNewslettersService.loadSubscriptions(str, m3214toDTOimpl, newslettersManager$loadSubscriptions$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    newslettersManager = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    newslettersManager = (NewslettersManager) newslettersManager$loadSubscriptions$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                }
                managerResult = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj2);
                state = newslettersManager.getState();
                do {
                    value = state.getValue();
                    NewslettersManagerState newslettersManagerState = value;
                    if (!(managerResult instanceof ManagerResult.Error)) {
                        copy$default = NewslettersManagerState.copy$default(newslettersManagerState, CollectionsKt.emptyList(), null, 2, null);
                    } else {
                        if (!(managerResult instanceof ManagerResult.Success)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        List<SiteInfo> value2 = newslettersManager.siteManager.getAvailableSites().getValue();
                        if (value2 == null) {
                            value2 = CollectionsKt.emptyList();
                        }
                        List<NewslettersSubscriptionsResponseDTO.NewsletterSubscriptionDTO> statuses = ((NewslettersSubscriptionsResponseDTO) ((ManagerResult.Success) managerResult).getData()).getStatuses();
                        ArrayList arrayList = new ArrayList();
                        for (NewslettersSubscriptionsResponseDTO.NewsletterSubscriptionDTO newsletterSubscriptionDTO : statuses) {
                            Site invoke = Site.INSTANCE.invoke(newsletterSubscriptionDTO.getSite());
                            Iterator<T> it = value2.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it.next();
                                if (((SiteInfo) obj).getSite() == invoke) {
                                    break;
                                }
                            }
                            SiteInfo siteInfo = (SiteInfo) obj;
                            NewsletterSubscription newsletterSubscription = siteInfo != null ? new NewsletterSubscription(siteInfo, newsletterSubscriptionDTO.getAllowsNewsletters(), newsletterSubscriptionDTO.getAllowsPromotions()) : null;
                            if (newsletterSubscription != null) {
                                arrayList.add(newsletterSubscription);
                            }
                        }
                        copy$default = NewslettersManagerState.copy$default(newslettersManagerState, arrayList, null, 2, null);
                    }
                } while (!state.compareAndSet(value, copy$default));
                return ManagerResultExtensionsKt.toUnitManagerResult(managerResult);
            }
        }
        newslettersManager$loadSubscriptions$1 = new NewslettersManager$loadSubscriptions$1(this, continuation);
        Object obj22 = newslettersManager$loadSubscriptions$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = newslettersManager$loadSubscriptions$1.label;
        if (i5 != 0) {
        }
        managerResult = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj22);
        state = newslettersManager.getState();
        do {
            value = state.getValue();
            NewslettersManagerState newslettersManagerState2 = value;
            if (!(managerResult instanceof ManagerResult.Error)) {
            }
        } while (!state.compareAndSet(value, copy$default));
        return ManagerResultExtensionsKt.toUnitManagerResult(managerResult);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // dk.molslinjen.domain.managers.user.newsletters.INewslettersManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateSubscription(String str, Site site, Boolean bool, Boolean bool2, Continuation<? super ManagerResult<Unit>> continuation) {
        NewslettersManager$updateSubscription$1 newslettersManager$updateSubscription$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        NewslettersManager newslettersManager;
        if (continuation instanceof NewslettersManager$updateSubscription$1) {
            newslettersManager$updateSubscription$1 = (NewslettersManager$updateSubscription$1) continuation;
            int i6 = newslettersManager$updateSubscription$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                newslettersManager$updateSubscription$1.label = i6 - Integer.MIN_VALUE;
                obj = newslettersManager$updateSubscription$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = newslettersManager$updateSubscription$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    updateLocalState(site, bool, bool2);
                    INewslettersService iNewslettersService = this.newslettersService;
                    SiteDTO dto = site.toDTO();
                    newslettersManager$updateSubscription$1.L$0 = this;
                    newslettersManager$updateSubscription$1.L$1 = str;
                    newslettersManager$updateSubscription$1.label = 1;
                    obj = iNewslettersService.updateSubscription(str, dto, bool, bool2, newslettersManager$updateSubscription$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    newslettersManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ManagerResult managerResult = (ManagerResult) newslettersManager$updateSubscription$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            return managerResult;
                        }
                        str = (String) newslettersManager$updateSubscription$1.L$1;
                        newslettersManager = (NewslettersManager) newslettersManager$updateSubscription$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        ManagerResult managerResult2 = (ManagerResult) obj;
                        NewslettersManager$updateSubscription$2 newslettersManager$updateSubscription$2 = new NewslettersManager$updateSubscription$2(newslettersManager, str, null);
                        newslettersManager$updateSubscription$1.L$0 = managerResult2;
                        newslettersManager$updateSubscription$1.L$1 = null;
                        newslettersManager$updateSubscription$1.label = 3;
                        return ManagerResultExtensionsKt.onFailure(managerResult2, newslettersManager$updateSubscription$2, newslettersManager$updateSubscription$1) == coroutine_suspended ? coroutine_suspended : managerResult2;
                    }
                    str = (String) newslettersManager$updateSubscription$1.L$1;
                    newslettersManager = (NewslettersManager) newslettersManager$updateSubscription$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                newslettersManager$updateSubscription$1.L$0 = newslettersManager;
                newslettersManager$updateSubscription$1.L$1 = str;
                newslettersManager$updateSubscription$1.label = 2;
                obj = ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj, newslettersManager$updateSubscription$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ManagerResult managerResult22 = (ManagerResult) obj;
                NewslettersManager$updateSubscription$2 newslettersManager$updateSubscription$22 = new NewslettersManager$updateSubscription$2(newslettersManager, str, null);
                newslettersManager$updateSubscription$1.L$0 = managerResult22;
                newslettersManager$updateSubscription$1.L$1 = null;
                newslettersManager$updateSubscription$1.label = 3;
                if (ManagerResultExtensionsKt.onFailure(managerResult22, newslettersManager$updateSubscription$22, newslettersManager$updateSubscription$1) == coroutine_suspended) {
                }
            }
        }
        newslettersManager$updateSubscription$1 = new NewslettersManager$updateSubscription$1(this, continuation);
        obj = newslettersManager$updateSubscription$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = newslettersManager$updateSubscription$1.label;
        if (i5 != 0) {
        }
        newslettersManager$updateSubscription$1.L$0 = newslettersManager;
        newslettersManager$updateSubscription$1.L$1 = str;
        newslettersManager$updateSubscription$1.label = 2;
        obj = ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj, newslettersManager$updateSubscription$1);
        if (obj == coroutine_suspended) {
        }
        ManagerResult managerResult222 = (ManagerResult) obj;
        NewslettersManager$updateSubscription$2 newslettersManager$updateSubscription$222 = new NewslettersManager$updateSubscription$2(newslettersManager, str, null);
        newslettersManager$updateSubscription$1.L$0 = managerResult222;
        newslettersManager$updateSubscription$1.L$1 = null;
        newslettersManager$updateSubscription$1.label = 3;
        if (ManagerResultExtensionsKt.onFailure(managerResult222, newslettersManager$updateSubscription$222, newslettersManager$updateSubscription$1) == coroutine_suspended) {
        }
    }

    @Override // dk.molslinjen.domain.managers.user.newsletters.INewslettersManager
    public MutableStateFlow<NewslettersManagerState> getState() {
        return this.state;
    }
}
