package dk.molslinjen.ui.views.screens.profile.faq;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.faq.FaqManagerState;
import dk.molslinjen.domain.managers.faq.IFaqManager;
import dk.molslinjen.domain.managers.site.ISiteManager;
import dk.molslinjen.domain.model.faq.FaqPopularQuestion;
import dk.molslinjen.domain.model.faq.FaqSubject;
import dk.molslinjen.domain.model.site.SiteInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u001e\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/faq/FaqViewModel;", "Landroidx/lifecycle/ViewModel;", "faqManager", "Ldk/molslinjen/domain/managers/faq/IFaqManager;", "siteManager", "Ldk/molslinjen/domain/managers/site/ISiteManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "<init>", "(Ldk/molslinjen/domain/managers/faq/IFaqManager;Ldk/molslinjen/domain/managers/site/ISiteManager;Ldk/molslinjen/core/snackbar/ISnackbarService;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/faq/FaqViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "onSiteChanged", BuildConfig.FLAVOR, "siteInfo", "Ldk/molslinjen/domain/model/site/SiteInfo;", "loadFaq", "site", "mapData", "faqState", "Ldk/molslinjen/domain/managers/faq/FaqManagerState;", "(Ldk/molslinjen/ui/views/screens/profile/faq/FaqViewModel$ViewState;Ldk/molslinjen/domain/managers/faq/FaqManagerState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FaqViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IFaqManager faqManager;
    private final ISnackbarService snackbarService;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.faq.FaqViewModel$1", f = "FaqViewModel.kt", l = {40}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.faq.FaqViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ISiteManager $siteManager;
        int label;
        final /* synthetic */ FaqViewModel this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "siteManagerSiteInfo", "Ldk/molslinjen/domain/model/site/SiteInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.faq.FaqViewModel$1$1", f = "FaqViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.profile.faq.FaqViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00631 extends SuspendLambda implements Function2<SiteInfo, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ FaqViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00631(FaqViewModel faqViewModel, Continuation<? super C00631> continuation) {
                super(2, continuation);
                this.this$0 = faqViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00631 c00631 = new C00631(this.this$0, continuation);
                c00631.L$0 = obj;
                return c00631;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(SiteInfo siteInfo, Continuation<? super Unit> continuation) {
                return ((C00631) create(siteInfo, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                SiteInfo siteInfo = (SiteInfo) this.L$0;
                if (siteInfo != null) {
                    this.this$0.loadFaq(siteInfo);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ISiteManager iSiteManager, FaqViewModel faqViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$siteManager = iSiteManager;
            this.this$0 = faqViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$siteManager, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<SiteInfo> selectedSite = this.$siteManager.getSelectedSite();
                C00631 c00631 = new C00631(this.this$0, null);
                this.label = 1;
                if (FlowKt.collectLatest(selectedSite, c00631, this) == coroutine_suspended) {
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

    public FaqViewModel(IFaqManager faqManager, ISiteManager siteManager, ISnackbarService snackbarService) {
        Intrinsics.checkNotNullParameter(faqManager, "faqManager");
        Intrinsics.checkNotNullParameter(siteManager, "siteManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        this.faqManager = faqManager;
        this.snackbarService = snackbarService;
        int i5 = 31;
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z5 = false;
        SiteInfo siteInfo = null;
        List list = null;
        List list2 = null;
        List list3 = null;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(z5, siteInfo, list, list2, list3, i5, defaultConstructorMarker));
        this._viewState = MutableStateFlow;
        this.viewState = FlowKt.stateIn(FlowKt.flowCombine(MutableStateFlow, faqManager.getLatestFaqState(), new FaqViewModel$viewState$1(this)), ViewModelKt.getViewModelScope(this), SharingStarted.INSTANCE.getEagerly(), new ViewState(z5, siteInfo, list, list2, list3, i5, defaultConstructorMarker));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(siteManager, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadFaq(SiteInfo site) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FaqViewModel$loadFaq$1(this, site, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object mapData(ViewState viewState, FaqManagerState faqManagerState, Continuation<? super ViewState> continuation) {
        return BuildersKt.withContext(ViewModelKt.getViewModelScope(this).getCoroutineContext().plus(Dispatchers.getDefault()), new FaqViewModel$mapData$2(faqManagerState, viewState, null), continuation);
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void onSiteChanged(SiteInfo siteInfo) {
        Intrinsics.checkNotNullParameter(siteInfo, "siteInfo");
        loadFaq(siteInfo);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ\\\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u0003\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b!\u0010 R\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\"\u0010 ¨\u0006#"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/faq/FaqViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", "Ldk/molslinjen/domain/model/site/SiteInfo;", "selectedSite", BuildConfig.FLAVOR, "availableSites", "Ldk/molslinjen/domain/model/faq/FaqPopularQuestion;", "popularQuestions", "Ldk/molslinjen/domain/model/faq/FaqSubject;", "categories", "<init>", "(ZLdk/molslinjen/domain/model/site/SiteInfo;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "copy", "(ZLdk/molslinjen/domain/model/site/SiteInfo;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Ldk/molslinjen/ui/views/screens/profile/faq/FaqViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ldk/molslinjen/domain/model/site/SiteInfo;", "getSelectedSite", "()Ldk/molslinjen/domain/model/site/SiteInfo;", "Ljava/util/List;", "getAvailableSites", "()Ljava/util/List;", "getPopularQuestions", "getCategories", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final List<SiteInfo> availableSites;
        private final List<FaqSubject> categories;
        private final boolean isLoading;
        private final List<FaqPopularQuestion> popularQuestions;
        private final SiteInfo selectedSite;

        public ViewState(boolean z5, SiteInfo siteInfo, List<SiteInfo> list, List<FaqPopularQuestion> list2, List<FaqSubject> list3) {
            this.isLoading = z5;
            this.selectedSite = siteInfo;
            this.availableSites = list;
            this.popularQuestions = list2;
            this.categories = list3;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, SiteInfo siteInfo, List list, List list2, List list3, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 2) != 0) {
                siteInfo = viewState.selectedSite;
            }
            SiteInfo siteInfo2 = siteInfo;
            if ((i5 & 4) != 0) {
                list = viewState.availableSites;
            }
            List list4 = list;
            if ((i5 & 8) != 0) {
                list2 = viewState.popularQuestions;
            }
            List list5 = list2;
            if ((i5 & 16) != 0) {
                list3 = viewState.categories;
            }
            return viewState.copy(z5, siteInfo2, list4, list5, list3);
        }

        public final ViewState copy(boolean isLoading, SiteInfo selectedSite, List<SiteInfo> availableSites, List<FaqPopularQuestion> popularQuestions, List<FaqSubject> categories) {
            return new ViewState(isLoading, selectedSite, availableSites, popularQuestions, categories);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.selectedSite, viewState.selectedSite) && Intrinsics.areEqual(this.availableSites, viewState.availableSites) && Intrinsics.areEqual(this.popularQuestions, viewState.popularQuestions) && Intrinsics.areEqual(this.categories, viewState.categories);
        }

        public final List<SiteInfo> getAvailableSites() {
            return this.availableSites;
        }

        public final List<FaqSubject> getCategories() {
            return this.categories;
        }

        public final List<FaqPopularQuestion> getPopularQuestions() {
            return this.popularQuestions;
        }

        public final SiteInfo getSelectedSite() {
            return this.selectedSite;
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.isLoading) * 31;
            SiteInfo siteInfo = this.selectedSite;
            int hashCode2 = (hashCode + (siteInfo == null ? 0 : siteInfo.hashCode())) * 31;
            List<SiteInfo> list = this.availableSites;
            int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
            List<FaqPopularQuestion> list2 = this.popularQuestions;
            int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
            List<FaqSubject> list3 = this.categories;
            return hashCode4 + (list3 != null ? list3.hashCode() : 0);
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", selectedSite=" + this.selectedSite + ", availableSites=" + this.availableSites + ", popularQuestions=" + this.popularQuestions + ", categories=" + this.categories + ")";
        }

        public /* synthetic */ ViewState(boolean z5, SiteInfo siteInfo, List list, List list2, List list3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? true : z5, (i5 & 2) != 0 ? null : siteInfo, (i5 & 4) != 0 ? null : list, (i5 & 8) != 0 ? null : list2, (i5 & 16) == 0 ? list3 : null);
        }
    }
}
