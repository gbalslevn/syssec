package dk.molslinjen.ui.views.screens.profile.newsletters;

import androidx.compose.material3.SnackbarDuration;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.newsletters.INewslettersManager;
import dk.molslinjen.domain.managers.user.newsletters.NewslettersManagerState;
import dk.molslinjen.domain.model.account.newsletters.NewsletterSubscription;
import dk.molslinjen.domain.model.account.user.UserContactDetails;
import dk.molslinjen.domain.model.account.user.UserInfo;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.kombardo.R;
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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001$B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ,\u0010\u001d\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/newsletters/ProfileNewslettersViewModel;", "Landroidx/lifecycle/ViewModel;", "newslettersManager", "Ldk/molslinjen/domain/managers/user/newsletters/INewslettersManager;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "<init>", "(Ldk/molslinjen/domain/managers/user/newsletters/INewslettersManager;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/core/snackbar/ISnackbarService;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/newsletters/ProfileNewslettersViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", Constants.FirebaseCustomKeys.UserEmail, BuildConfig.FLAVOR, "onSiteChange", BuildConfig.FLAVOR, "siteSubscriptions", "Ldk/molslinjen/domain/model/account/newsletters/NewsletterSubscription;", "updateNewsletterSubscription", "siteInfo", "Ldk/molslinjen/domain/model/site/SiteInfo;", "subscribe", BuildConfig.FLAVOR, "updatePromotionsSubscription", "showSnackbar", "subscribeResult", "Ldk/molslinjen/domain/managers/ManagerResult;", "successMessage", "Ldk/molslinjen/core/snackbar/SnackbarText;", "subscribed", "(Ldk/molslinjen/domain/managers/ManagerResult;Ldk/molslinjen/core/snackbar/SnackbarText;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileNewslettersViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final INewslettersManager newslettersManager;
    private final ISnackbarService snackbarService;
    private String userEmail;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersViewModel$1", f = "ProfileNewslettersViewModel.kt", l = {38}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "state", "Ldk/molslinjen/domain/managers/user/newsletters/NewslettersManagerState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersViewModel$1$1", f = "ProfileNewslettersViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00641 extends SuspendLambda implements Function2<NewslettersManagerState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ProfileNewslettersViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00641(ProfileNewslettersViewModel profileNewslettersViewModel, Continuation<? super C00641> continuation) {
                super(2, continuation);
                this.this$0 = profileNewslettersViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00641 c00641 = new C00641(this.this$0, continuation);
                c00641.L$0 = obj;
                return c00641;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(NewslettersManagerState newslettersManagerState, Continuation<? super Unit> continuation) {
                return ((C00641) create(newslettersManagerState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object value;
                ViewState viewState;
                Object obj2;
                Object obj3;
                NewsletterSubscription newsletterSubscription;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                NewslettersManagerState newslettersManagerState = (NewslettersManagerState) this.L$0;
                MutableStateFlow mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                    viewState = (ViewState) value;
                    Iterator<T> it = newslettersManagerState.getSubscriptions().iterator();
                    while (true) {
                        obj2 = null;
                        if (!it.hasNext()) {
                            obj3 = null;
                            break;
                        }
                        obj3 = it.next();
                        SiteInfo siteInfo = ((NewsletterSubscription) obj3).getSiteInfo();
                        NewsletterSubscription selectedSiteSubscriptions = viewState.getSelectedSiteSubscriptions();
                        if (Intrinsics.areEqual(siteInfo, selectedSiteSubscriptions != null ? selectedSiteSubscriptions.getSiteInfo() : null)) {
                            break;
                        }
                    }
                    newsletterSubscription = (NewsletterSubscription) obj3;
                    if (newsletterSubscription == null) {
                        Iterator<T> it2 = newslettersManagerState.getSubscriptions().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Object next = it2.next();
                            if (Intrinsics.areEqual(((NewsletterSubscription) next).getSiteInfo(), newslettersManagerState.getDefaultSite())) {
                                obj2 = next;
                                break;
                            }
                        }
                        newsletterSubscription = (NewsletterSubscription) obj2;
                        if (newsletterSubscription == null) {
                            newsletterSubscription = (NewsletterSubscription) CollectionsKt.firstOrNull((List) newslettersManagerState.getSubscriptions());
                        }
                    }
                } while (!mutableStateFlow.compareAndSet(value, viewState.copy(newsletterSubscription == null, newsletterSubscription, newslettersManagerState.getSubscriptions())));
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
                StateFlow<NewslettersManagerState> state = ProfileNewslettersViewModel.this.newslettersManager.getState();
                C00641 c00641 = new C00641(ProfileNewslettersViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(state, c00641, this) == coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersViewModel$2", f = "ProfileNewslettersViewModel.kt", l = {57}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersViewModel$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IUserManager $userManager;
        int label;
        final /* synthetic */ ProfileNewslettersViewModel this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "user", "Ldk/molslinjen/domain/managers/user/IUserManager$UserState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersViewModel$2$1", f = "ProfileNewslettersViewModel.kt", l = {61}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersViewModel$2$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<IUserManager.UserState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ProfileNewslettersViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ProfileNewslettersViewModel profileNewslettersViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = profileNewslettersViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(IUserManager.UserState userState, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(userState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                UserContactDetails contactDetails;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    IUserManager.UserState userState = (IUserManager.UserState) this.L$0;
                    ProfileNewslettersViewModel profileNewslettersViewModel = this.this$0;
                    UserInfo details = userState.getUser().getDetails();
                    profileNewslettersViewModel.userEmail = (details == null || (contactDetails = details.getContactDetails()) == null) ? null : contactDetails.getEmail();
                    String str = this.this$0.userEmail;
                    if (str != null) {
                        INewslettersManager iNewslettersManager = this.this$0.newslettersManager;
                        this.label = 1;
                        if (iNewslettersManager.loadSubscriptions(str, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(IUserManager iUserManager, ProfileNewslettersViewModel profileNewslettersViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$userManager = iUserManager;
            this.this$0 = profileNewslettersViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$userManager, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<IUserManager.UserState> currentUserState = this.$userManager.getCurrentUserState();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
                this.label = 1;
                if (FlowKt.collectLatest(currentUserState, anonymousClass1, this) == coroutine_suspended) {
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

    public ProfileNewslettersViewModel(INewslettersManager newslettersManager, IUserManager userManager, ISnackbarService snackbarService) {
        Intrinsics.checkNotNullParameter(newslettersManager, "newslettersManager");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        this.newslettersManager = newslettersManager;
        this.snackbarService = snackbarService;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, null, null, 7, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(userManager, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showSnackbar(ManagerResult<Unit> managerResult, SnackbarText snackbarText, boolean z5, Continuation<? super Unit> continuation) {
        if (managerResult instanceof ManagerResult.Error) {
            Object handleError = ManagerResultExtensionsKt.handleError((ManagerResult.Error) managerResult, this.snackbarService, continuation);
            return handleError == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? handleError : Unit.INSTANCE;
        }
        if (!(managerResult instanceof ManagerResult.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        Object publishEvent = this.snackbarService.publishEvent(new SnackbarEvent.Default(snackbarText, null, true, SnackbarDuration.Short, z5 ? Boxing.boxInt(R.drawable.icon_checkmark_circle) : null, 2, null), continuation);
        return publishEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? publishEvent : Unit.INSTANCE;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void onSiteChange(NewsletterSubscription siteSubscriptions) {
        ViewState value;
        Intrinsics.checkNotNullParameter(siteSubscriptions, "siteSubscriptions");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, siteSubscriptions, null, 5, null)));
    }

    public final void updateNewsletterSubscription(SiteInfo siteInfo, boolean subscribe) {
        Intrinsics.checkNotNullParameter(siteInfo, "siteInfo");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileNewslettersViewModel$updateNewsletterSubscription$1(this, siteInfo, subscribe, null), 3, null);
    }

    public final void updatePromotionsSubscription(SiteInfo siteInfo, boolean subscribe) {
        Intrinsics.checkNotNullParameter(siteInfo, "siteInfo");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileNewslettersViewModel$updatePromotionsSubscription$1(this, siteInfo, subscribe, null), 3, null);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ6\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u0003\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\rR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010\u000f¨\u0006 "}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/newsletters/ProfileNewslettersViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", "Ldk/molslinjen/domain/model/account/newsletters/NewsletterSubscription;", "selectedSiteSubscriptions", BuildConfig.FLAVOR, "subscriptions", "<init>", "(ZLdk/molslinjen/domain/model/account/newsletters/NewsletterSubscription;Ljava/util/List;)V", "component1", "()Z", "component2", "()Ldk/molslinjen/domain/model/account/newsletters/NewsletterSubscription;", "component3", "()Ljava/util/List;", "copy", "(ZLdk/molslinjen/domain/model/account/newsletters/NewsletterSubscription;Ljava/util/List;)Ldk/molslinjen/ui/views/screens/profile/newsletters/ProfileNewslettersViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ldk/molslinjen/domain/model/account/newsletters/NewsletterSubscription;", "getSelectedSiteSubscriptions", "Ljava/util/List;", "getSubscriptions", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final NewsletterSubscription selectedSiteSubscriptions;
        private final List<NewsletterSubscription> subscriptions;

        public ViewState(boolean z5, NewsletterSubscription newsletterSubscription, List<NewsletterSubscription> subscriptions) {
            Intrinsics.checkNotNullParameter(subscriptions, "subscriptions");
            this.isLoading = z5;
            this.selectedSiteSubscriptions = newsletterSubscription;
            this.subscriptions = subscriptions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, NewsletterSubscription newsletterSubscription, List list, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 2) != 0) {
                newsletterSubscription = viewState.selectedSiteSubscriptions;
            }
            if ((i5 & 4) != 0) {
                list = viewState.subscriptions;
            }
            return viewState.copy(z5, newsletterSubscription, list);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* renamed from: component2, reason: from getter */
        public final NewsletterSubscription getSelectedSiteSubscriptions() {
            return this.selectedSiteSubscriptions;
        }

        public final List<NewsletterSubscription> component3() {
            return this.subscriptions;
        }

        public final ViewState copy(boolean isLoading, NewsletterSubscription selectedSiteSubscriptions, List<NewsletterSubscription> subscriptions) {
            Intrinsics.checkNotNullParameter(subscriptions, "subscriptions");
            return new ViewState(isLoading, selectedSiteSubscriptions, subscriptions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.selectedSiteSubscriptions, viewState.selectedSiteSubscriptions) && Intrinsics.areEqual(this.subscriptions, viewState.subscriptions);
        }

        public final NewsletterSubscription getSelectedSiteSubscriptions() {
            return this.selectedSiteSubscriptions;
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.isLoading) * 31;
            NewsletterSubscription newsletterSubscription = this.selectedSiteSubscriptions;
            return ((hashCode + (newsletterSubscription == null ? 0 : newsletterSubscription.hashCode())) * 31) + this.subscriptions.hashCode();
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", selectedSiteSubscriptions=" + this.selectedSiteSubscriptions + ", subscriptions=" + this.subscriptions + ")";
        }

        public /* synthetic */ ViewState(boolean z5, NewsletterSubscription newsletterSubscription, List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? true : z5, (i5 & 2) != 0 ? null : newsletterSubscription, (i5 & 4) != 0 ? CollectionsKt.emptyList() : list);
        }
    }
}
