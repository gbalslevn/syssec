package dk.molslinjen.ui.views.screens.profile.faq.subject;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.ramcosta.composedestinations.generated.destinations.ContactScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.faq.FaqQuestionId;
import dk.molslinjen.domain.model.faq.FaqSubject;
import dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectViewModel;
import java.util.Set;
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
public final class FaqSubjectScreenKt$FaqSubjectScreen$4 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ FaqSubject $subject;
    final /* synthetic */ FaqSubjectViewModel $viewModel;
    final /* synthetic */ FaqSubjectViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FaqSubjectScreenKt$FaqSubjectScreen$4(FaqSubject faqSubject, LazyListState lazyListState, FaqSubjectViewModel.ViewState viewState, FaqSubjectViewModel faqSubjectViewModel, DestinationsNavigator destinationsNavigator) {
        this.$subject = faqSubject;
        this.$lazyListState = lazyListState;
        this.$viewState = viewState;
        this.$viewModel = faqSubjectViewModel;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3$lambda$2(FaqSubjectViewModel.ViewState viewState, DestinationsNavigator destinationsNavigator) {
        Site site = viewState.getSite();
        if (site != null) {
            DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ContactScreenDestination.INSTANCE.invoke(site), null, null, 6, null);
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
            ComposerKt.traceEventStart(335092477, i5, -1, "dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectScreen.<anonymous> (FaqSubjectScreen.kt:81)");
        }
        FaqSubject faqSubject = this.$subject;
        if (faqSubject != null) {
            LazyListState lazyListState = this.$lazyListState;
            final FaqSubjectViewModel.ViewState viewState = this.$viewState;
            Object obj = this.$viewModel;
            final DestinationsNavigator destinationsNavigator = this.$navigator;
            Set<FaqQuestionId> expandedQuestions = viewState.getExpandedQuestions();
            composer.startReplaceGroup(-59846655);
            boolean changedInstance = composer.changedInstance(obj);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new FaqSubjectScreenKt$FaqSubjectScreen$4$1$1$1(obj);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue);
            composer.startReplaceGroup(-59844367);
            boolean changedInstance2 = composer.changedInstance(viewState) | composer.changed(destinationsNavigator);
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.faq.subject.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$4$lambda$3$lambda$2;
                        invoke$lambda$4$lambda$3$lambda$2 = FaqSubjectScreenKt$FaqSubjectScreen$4.invoke$lambda$4$lambda$3$lambda$2(FaqSubjectViewModel.ViewState.this, destinationsNavigator);
                        return invoke$lambda$4$lambda$3$lambda$2;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            FaqSubjectScreenKt.FaqSubjectContent(lazyListState, faqSubject, expandedQuestions, function1, (Function0) rememberedValue2, composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
