package dk.molslinjen.ui.views.screens.profile.faq;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.faq.FaqPopularQuestion;
import dk.molslinjen.domain.model.faq.FaqSubject;
import dk.molslinjen.domain.model.site.SiteInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FaqScreenKt$FaqContent$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ List<FaqSubject> $categories;
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ Function0<Unit> $navigateToContact;
    final /* synthetic */ Function1<FaqPopularQuestion, Unit> $onQuestionSelected;
    final /* synthetic */ Function1<SiteInfo, Unit> $onSiteChange;
    final /* synthetic */ Function1<FaqSubject, Unit> $onSubjectSelected;
    final /* synthetic */ List<FaqPopularQuestion> $popularQuestions;
    final /* synthetic */ SiteInfo $selectedSite;
    final /* synthetic */ List<SiteInfo> $sites;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public FaqScreenKt$FaqContent$1(LazyListState lazyListState, SiteInfo siteInfo, List<SiteInfo> list, Function1<? super SiteInfo, Unit> function1, List<FaqPopularQuestion> list2, Function1<? super FaqPopularQuestion, Unit> function12, List<FaqSubject> list3, Function1<? super FaqSubject, Unit> function13, Function0<Unit> function0) {
        this.$lazyListState = lazyListState;
        this.$selectedSite = siteInfo;
        this.$sites = list;
        this.$onSiteChange = function1;
        this.$popularQuestions = list2;
        this.$onQuestionSelected = function12;
        this.$categories = list3;
        this.$onSubjectSelected = function13;
        this.$navigateToContact = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(SiteInfo siteInfo, List list, List list2, Function1 function1, List list3, Function1 function12, Function1 function13, final Function0 function0, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        if (siteInfo != null && list != null && list.size() > 1) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1755167145, true, new FaqScreenKt$FaqContent$1$1$1$1(siteInfo, list, function13)), 3, null);
        }
        ComposableSingletons$FaqScreenKt composableSingletons$FaqScreenKt = ComposableSingletons$FaqScreenKt.INSTANCE;
        LazyListScope.item$default(LazyColumn, null, null, composableSingletons$FaqScreenKt.m3506getLambda1$app_kombardoProd(), 3, null);
        List list4 = list2;
        if (list4 != null && !list4.isEmpty()) {
            FaqScreenKt.popularQuestions(LazyColumn, list2, function1);
            LazyListScope.item$default(LazyColumn, null, null, composableSingletons$FaqScreenKt.m3507getLambda2$app_kombardoProd(), 3, null);
        }
        List list5 = list3;
        if (list5 != null && !list5.isEmpty()) {
            FaqScreenKt.allSubjects(LazyColumn, list3, function12);
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-391017395, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.faq.FaqScreenKt$FaqContent$1$1$1$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i5) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i5 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-391017395, i5, -1, "dk.molslinjen.ui.views.screens.profile.faq.FaqContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FaqScreen.kt:137)");
                }
                FaqContactViewKt.FaqContactView(function0, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(821032568, i5, -1, "dk.molslinjen.ui.views.screens.profile.faq.FaqContent.<anonymous> (FaqScreen.kt:105)");
        }
        LazyListState lazyListState = this.$lazyListState;
        PaddingValues m307PaddingValuesYgX7TsA = PaddingKt.m307PaddingValuesYgX7TsA(Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(8));
        composer.startReplaceGroup(-550516166);
        boolean changedInstance = composer.changedInstance(this.$selectedSite) | composer.changedInstance(this.$sites) | composer.changed(this.$onSiteChange) | composer.changedInstance(this.$popularQuestions) | composer.changed(this.$onQuestionSelected) | composer.changedInstance(this.$categories) | composer.changed(this.$onSubjectSelected) | composer.changed(this.$navigateToContact);
        final SiteInfo siteInfo = this.$selectedSite;
        final List<SiteInfo> list = this.$sites;
        final List<FaqPopularQuestion> list2 = this.$popularQuestions;
        final Function1<FaqPopularQuestion, Unit> function1 = this.$onQuestionSelected;
        final List<FaqSubject> list3 = this.$categories;
        final Function1<FaqSubject, Unit> function12 = this.$onSubjectSelected;
        final Function1<SiteInfo, Unit> function13 = this.$onSiteChange;
        final Function0<Unit> function0 = this.$navigateToContact;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.faq.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = FaqScreenKt$FaqContent$1.invoke$lambda$1$lambda$0(SiteInfo.this, list, list2, function1, list3, function12, function13, function0, (LazyListScope) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        LazyDslKt.LazyColumn(null, lazyListState, m307PaddingValuesYgX7TsA, false, null, null, null, false, (Function1) rememberedValue, composer, 0, 249);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
