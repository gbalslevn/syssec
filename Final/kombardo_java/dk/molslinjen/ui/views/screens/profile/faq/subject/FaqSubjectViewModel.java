package dk.molslinjen.ui.views.screens.profile.faq.subject;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.FaqSubjectScreenDestination;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.faq.IFaqManager;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.faq.FaqQuestionAndAnswer;
import dk.molslinjen.domain.model.faq.FaqQuestionId;
import dk.molslinjen.domain.model.faq.FaqSubject;
import dk.molslinjen.domain.model.faq.FaqSubjectId;
import dk.molslinjen.domain.model.faq.SiteFaq;
import dk.molslinjen.domain.model.site.SiteInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/faq/subject/FaqSubjectViewModel;", "Landroidx/lifecycle/ViewModel;", "faqManager", "Ldk/molslinjen/domain/managers/faq/IFaqManager;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/domain/managers/faq/IFaqManager;Landroidx/lifecycle/SavedStateHandle;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/profile/faq/subject/FaqSubjectScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/faq/subject/FaqSubjectViewModel$ViewState;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "onQuestionSelected", BuildConfig.FLAVOR, "questionId", "Ldk/molslinjen/domain/model/faq/FaqQuestionId;", "onQuestionSelected-ItQmzgU", "(Ljava/lang/String;)V", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FaqSubjectViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final IFaqManager faqManager;
    private final FaqSubjectScreenNavArgs navArgs;
    private final MutableStateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectViewModel$1", f = "FaqSubjectViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectViewModel$1, reason: invalid class name */
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
            FaqSubject faqSubject;
            Object value;
            ViewState viewState;
            Set<FaqQuestionId> expandedQuestions;
            SiteInfo siteInfo;
            List<FaqQuestionAndAnswer> questionAndAnswers;
            List<FaqSubject> subjects;
            Object obj2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String subjectId = FaqSubjectViewModel.this.navArgs.getSubjectId();
            String questionId = FaqSubjectViewModel.this.navArgs.getQuestionId();
            SiteFaq siteFaq = FaqSubjectViewModel.this.faqManager.getLatestFaqState().getValue().getSiteFaq();
            if (siteFaq == null || (subjects = siteFaq.getSubjects()) == null) {
                faqSubject = null;
            } else {
                Iterator<T> it = subjects.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    if (FaqSubjectId.m3243equalsimpl0(((FaqSubject) obj2).m3239getIdpbmbVKA(), subjectId)) {
                        break;
                    }
                }
                faqSubject = (FaqSubject) obj2;
            }
            int i5 = -1;
            if (faqSubject != null && (questionAndAnswers = faqSubject.getQuestionAndAnswers()) != null) {
                Iterator<FaqQuestionAndAnswer> it2 = questionAndAnswers.iterator();
                int i6 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (questionId == null ? false : FaqQuestionId.m3232equalsimpl0(it2.next().m3228getIdarQqKPc(), questionId)) {
                        i5 = i6;
                        break;
                    }
                    i6++;
                }
            }
            MutableStateFlow mutableStateFlow = FaqSubjectViewModel.this._viewState;
            do {
                value = mutableStateFlow.getValue();
                viewState = (ViewState) value;
                if (questionId == null || (expandedQuestions = SetsKt.plus(viewState.getExpandedQuestions(), FaqQuestionId.m3229boximpl(questionId))) == null) {
                    expandedQuestions = viewState.getExpandedQuestions();
                }
            } while (!mutableStateFlow.compareAndSet(value, viewState.copy(faqSubject, (siteFaq == null || (siteInfo = siteFaq.getSiteInfo()) == null) ? null : siteInfo.getSite(), expandedQuestions, i5 >= 0 ? Boxing.boxInt(i5) : null)));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public FaqSubjectViewModel(IFaqManager faqManager, SavedStateHandle savedStateHandle, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(faqManager, "faqManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.faqManager = faqManager;
        this.analyticsTracker = analyticsTracker;
        this.navArgs = FaqSubjectScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, null, null, null, 15, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    /* renamed from: onQuestionSelected-ItQmzgU, reason: not valid java name */
    public final void m3512onQuestionSelectedItQmzgU(String questionId) {
        ViewState value;
        ViewState viewState;
        Set plus;
        FaqSubject subject;
        List<FaqQuestionAndAnswer> questionAndAnswers;
        Object obj;
        Intrinsics.checkNotNullParameter(questionId, "questionId");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
            viewState = value;
            boolean contains = viewState.getExpandedQuestions().contains(FaqQuestionId.m3229boximpl(questionId));
            plus = !contains ? SetsKt.plus(viewState.getExpandedQuestions(), FaqQuestionId.m3229boximpl(questionId)) : SetsKt.minus(viewState.getExpandedQuestions(), FaqQuestionId.m3229boximpl(questionId));
            if (!contains && (subject = viewState.getSubject()) != null && (questionAndAnswers = subject.getQuestionAndAnswers()) != null) {
                Iterator<T> it = questionAndAnswers.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (FaqQuestionId.m3232equalsimpl0(((FaqQuestionAndAnswer) obj).m3228getIdarQqKPc(), questionId)) {
                            break;
                        }
                    }
                }
                FaqQuestionAndAnswer faqQuestionAndAnswer = (FaqQuestionAndAnswer) obj;
                if (faqQuestionAndAnswer != null) {
                    this.analyticsTracker.trackEvent(new AnalyticsEvent.ShownFaqEvent(faqQuestionAndAnswer.getQuestion()));
                }
            }
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(viewState, null, null, plus, null, 11, null)));
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJD\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/faq/subject/FaqSubjectViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/faq/FaqSubject;", "subject", "Ldk/molslinjen/domain/model/config/Site;", "site", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/faq/FaqQuestionId;", "expandedQuestions", BuildConfig.FLAVOR, "initialScrollIndex", "<init>", "(Ldk/molslinjen/domain/model/faq/FaqSubject;Ldk/molslinjen/domain/model/config/Site;Ljava/util/Set;Ljava/lang/Integer;)V", "copy", "(Ldk/molslinjen/domain/model/faq/FaqSubject;Ldk/molslinjen/domain/model/config/Site;Ljava/util/Set;Ljava/lang/Integer;)Ldk/molslinjen/ui/views/screens/profile/faq/subject/FaqSubjectViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/faq/FaqSubject;", "getSubject", "()Ldk/molslinjen/domain/model/faq/FaqSubject;", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "Ljava/util/Set;", "getExpandedQuestions", "()Ljava/util/Set;", "Ljava/lang/Integer;", "getInitialScrollIndex", "()Ljava/lang/Integer;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final Set<FaqQuestionId> expandedQuestions;
        private final Integer initialScrollIndex;
        private final Site site;
        private final FaqSubject subject;

        public ViewState(FaqSubject faqSubject, Site site, Set<FaqQuestionId> expandedQuestions, Integer num) {
            Intrinsics.checkNotNullParameter(expandedQuestions, "expandedQuestions");
            this.subject = faqSubject;
            this.site = site;
            this.expandedQuestions = expandedQuestions;
            this.initialScrollIndex = num;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, FaqSubject faqSubject, Site site, Set set, Integer num, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                faqSubject = viewState.subject;
            }
            if ((i5 & 2) != 0) {
                site = viewState.site;
            }
            if ((i5 & 4) != 0) {
                set = viewState.expandedQuestions;
            }
            if ((i5 & 8) != 0) {
                num = viewState.initialScrollIndex;
            }
            return viewState.copy(faqSubject, site, set, num);
        }

        public final ViewState copy(FaqSubject subject, Site site, Set<FaqQuestionId> expandedQuestions, Integer initialScrollIndex) {
            Intrinsics.checkNotNullParameter(expandedQuestions, "expandedQuestions");
            return new ViewState(subject, site, expandedQuestions, initialScrollIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.subject, viewState.subject) && this.site == viewState.site && Intrinsics.areEqual(this.expandedQuestions, viewState.expandedQuestions) && Intrinsics.areEqual(this.initialScrollIndex, viewState.initialScrollIndex);
        }

        public final Set<FaqQuestionId> getExpandedQuestions() {
            return this.expandedQuestions;
        }

        public final Integer getInitialScrollIndex() {
            return this.initialScrollIndex;
        }

        public final Site getSite() {
            return this.site;
        }

        public final FaqSubject getSubject() {
            return this.subject;
        }

        public int hashCode() {
            FaqSubject faqSubject = this.subject;
            int hashCode = (faqSubject == null ? 0 : faqSubject.hashCode()) * 31;
            Site site = this.site;
            int hashCode2 = (((hashCode + (site == null ? 0 : site.hashCode())) * 31) + this.expandedQuestions.hashCode()) * 31;
            Integer num = this.initialScrollIndex;
            return hashCode2 + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "ViewState(subject=" + this.subject + ", site=" + this.site + ", expandedQuestions=" + this.expandedQuestions + ", initialScrollIndex=" + this.initialScrollIndex + ")";
        }

        public /* synthetic */ ViewState(FaqSubject faqSubject, Site site, Set set, Integer num, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : faqSubject, (i5 & 2) != 0 ? null : site, (i5 & 4) != 0 ? SetsKt.emptySet() : set, (i5 & 8) != 0 ? null : num);
        }
    }
}
