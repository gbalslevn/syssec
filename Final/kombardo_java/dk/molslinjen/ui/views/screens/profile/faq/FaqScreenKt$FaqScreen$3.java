package dk.molslinjen.ui.views.screens.profile.faq;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.ramcosta.composedestinations.generated.destinations.ContactScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.FaqSubjectScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.faq.FaqPopularQuestion;
import dk.molslinjen.domain.model.faq.FaqSubject;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.ui.views.screens.profile.faq.FaqViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FaqScreenKt$FaqScreen$3 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ FaqViewModel $viewModel;
    final /* synthetic */ FaqViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FaqScreenKt$FaqScreen$3(FaqViewModel.ViewState viewState, FaqViewModel faqViewModel, LazyListState lazyListState, DestinationsNavigator destinationsNavigator) {
        this.$viewState = viewState;
        this.$viewModel = faqViewModel;
        this.$lazyListState = lazyListState;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(DestinationsNavigator destinationsNavigator, FaqSubject it) {
        Intrinsics.checkNotNullParameter(it, "it");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, FaqSubjectScreenDestination.INSTANCE.m3069invoke3g9fzqg(it.m3239getIdpbmbVKA(), null), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3(DestinationsNavigator destinationsNavigator, FaqPopularQuestion it) {
        Intrinsics.checkNotNullParameter(it, "it");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, FaqSubjectScreenDestination.INSTANCE.m3069invoke3g9fzqg(it.m3224getSubjectIdpbmbVKA(), it.m3223getQuestionIdarQqKPc()), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$6(FaqViewModel.ViewState viewState, DestinationsNavigator destinationsNavigator) {
        SiteInfo selectedSite = viewState.getSelectedSite();
        if (selectedSite != null) {
            DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ContactScreenDestination.INSTANCE.invoke(selectedSite.getSite()), null, null, 6, null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(711306843, i5, -1, "dk.molslinjen.ui.views.screens.profile.faq.FaqScreen.<anonymous> (FaqScreen.kt:71)");
        }
        boolean isLoading = this.$viewState.getIsLoading();
        SiteInfo selectedSite = this.$viewState.getSelectedSite();
        List<SiteInfo> availableSites = this.$viewState.getAvailableSites();
        FaqViewModel faqViewModel = this.$viewModel;
        composer.startReplaceGroup(793067863);
        boolean changedInstance = composer.changedInstance(faqViewModel);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new FaqScreenKt$FaqScreen$3$1$1(faqViewModel);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        List<FaqSubject> categories = this.$viewState.getCategories();
        List<FaqPopularQuestion> popularQuestions = this.$viewState.getPopularQuestions();
        LazyListState lazyListState = this.$lazyListState;
        Function1 function1 = (Function1) ((KFunction) rememberedValue);
        composer.startReplaceGroup(793073176);
        boolean changed = composer.changed(this.$navigator);
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.faq.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = FaqScreenKt$FaqScreen$3.invoke$lambda$2$lambda$1(DestinationsNavigator.this, (FaqSubject) obj);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        Function1 function12 = (Function1) rememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(793077188);
        boolean changed2 = composer.changed(this.$navigator);
        final DestinationsNavigator destinationsNavigator2 = this.$navigator;
        Object rememberedValue3 = composer.rememberedValue();
        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.faq.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$4$lambda$3;
                    invoke$lambda$4$lambda$3 = FaqScreenKt$FaqScreen$3.invoke$lambda$4$lambda$3(DestinationsNavigator.this, (FaqPopularQuestion) obj);
                    return invoke$lambda$4$lambda$3;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        Function1 function13 = (Function1) rememberedValue3;
        composer.endReplaceGroup();
        composer.startReplaceGroup(793082488);
        boolean changedInstance2 = composer.changedInstance(this.$viewState) | composer.changed(this.$navigator);
        final FaqViewModel.ViewState viewState = this.$viewState;
        final DestinationsNavigator destinationsNavigator3 = this.$navigator;
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.faq.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$7$lambda$6;
                    invoke$lambda$7$lambda$6 = FaqScreenKt$FaqScreen$3.invoke$lambda$7$lambda$6(FaqViewModel.ViewState.this, destinationsNavigator3);
                    return invoke$lambda$7$lambda$6;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        FaqScreenKt.FaqContent(isLoading, lazyListState, selectedSite, availableSites, function1, categories, function12, popularQuestions, function13, (Function0) rememberedValue4, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
