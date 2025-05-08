package dk.molslinjen.ui.views.screens.profile.faq.subject;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.faq.FaqQuestionAndAnswer;
import dk.molslinjen.domain.model.faq.FaqQuestionId;
import dk.molslinjen.domain.model.faq.FaqSubject;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.profile.faq.FaqContactViewKt;
import dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectScreenKt;
import dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectViewModel;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aO\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u001a3\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000eH\u0003¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001f²\u0006\u000e\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\nX\u008a\u0084\u0002²\u0006\f\u0010\u001e\u001a\u00020\u001d8\nX\u008a\u0084\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/faq/subject/FaqSubjectViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "FaqSubjectScreen", "(Ldk/molslinjen/ui/views/screens/profile/faq/subject/FaqSubjectViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/lazy/LazyListState;", "lazyListState", "Ldk/molslinjen/domain/model/faq/FaqSubject;", "subject", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/faq/FaqQuestionId;", "expandedQuestions", "Lkotlin/Function1;", "onQuestionSelected", "Lkotlin/Function0;", "navigateToContact", "FaqSubjectContent", "(Landroidx/compose/foundation/lazy/LazyListState;Ldk/molslinjen/domain/model/faq/FaqSubject;Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/faq/FaqQuestionAndAnswer;", "questionAndAnswer", BuildConfig.FLAVOR, "isExpanded", "onClick", "QAView", "(Ldk/molslinjen/domain/model/faq/FaqQuestionAndAnswer;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Lcom/airbnb/lottie/LottieComposition;", "lottieComposition", BuildConfig.FLAVOR, "lottieState", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FaqSubjectScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void FaqSubjectContent(final LazyListState lazyListState, final FaqSubject faqSubject, final Set<FaqQuestionId> set, final Function1<? super FaqQuestionId, Unit> function1, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-858737983);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(lazyListState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(faqSubject) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(set) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-858737983, i6, -1, "dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectContent (FaqSubjectScreen.kt:104)");
            }
            startRestartGroup.startReplaceGroup(1283635544);
            boolean changedInstance = startRestartGroup.changedInstance(faqSubject) | startRestartGroup.changedInstance(set) | ((i6 & 7168) == 2048) | ((57344 & i6) == 16384);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: N3.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit FaqSubjectContent$lambda$7$lambda$6;
                        FaqSubjectContent$lambda$7$lambda$6 = FaqSubjectScreenKt.FaqSubjectContent$lambda$7$lambda$6(FaqSubject.this, set, function1, function0, (LazyListScope) obj);
                        return FaqSubjectContent$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            LazyDslKt.LazyColumn(null, lazyListState, null, false, null, null, null, false, (Function1) rememberedValue, startRestartGroup, (i6 << 3) & 112, 253);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: N3.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FaqSubjectContent$lambda$8;
                    FaqSubjectContent$lambda$8 = FaqSubjectScreenKt.FaqSubjectContent$lambda$8(LazyListState.this, faqSubject, set, function1, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FaqSubjectContent$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FaqSubjectContent$lambda$7$lambda$6(final FaqSubject faqSubject, final Set set, final Function1 function1, final Function0 function0, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1007404629, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectScreenKt$FaqSubjectContent$1$1$1
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
                    ComposerKt.traceEventStart(1007404629, i5, -1, "dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectContent.<anonymous>.<anonymous>.<anonymous> (FaqSubjectScreen.kt:107)");
                }
                float f5 = 24;
                TextKt.m940Text4IGK_g(FaqSubject.this.getDescription(), PaddingKt.m314paddingqDBjuR0(Modifier.INSTANCE, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(8), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(32)), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer, 432, 1572864, 65528);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        final List<FaqQuestionAndAnswer> questionAndAnswers = faqSubject.getQuestionAndAnswers();
        LazyColumn.items(questionAndAnswers.size(), null, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectScreenKt$FaqSubjectContent$lambda$7$lambda$6$$inlined$itemsIndexed$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i5) {
                questionAndAnswers.get(i5);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectScreenKt$FaqSubjectContent$lambda$7$lambda$6$$inlined$itemsIndexed$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer, int i6) {
                int i7;
                if ((i6 & 6) == 0) {
                    i7 = (composer.changed(lazyItemScope) ? 4 : 2) | i6;
                } else {
                    i7 = i6;
                }
                if ((i6 & 48) == 0) {
                    i7 |= composer.changed(i5) ? 32 : 16;
                }
                if ((i7 & 147) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1091073711, i7, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:188)");
                }
                FaqQuestionAndAnswer faqQuestionAndAnswer = (FaqQuestionAndAnswer) questionAndAnswers.get(i5);
                composer.startReplaceGroup(-2045267632);
                composer.startReplaceGroup(-1867091905);
                if (i5 == 0) {
                    HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
                }
                composer.endReplaceGroup();
                FaqSubjectScreenKt.QAView(faqQuestionAndAnswer, set.contains(FaqQuestionId.m3229boximpl(faqQuestionAndAnswer.m3228getIdarQqKPc())), function1, composer, 0);
                HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1147954764, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectScreenKt$FaqSubjectContent$1$1$3
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
                    ComposerKt.traceEventStart(1147954764, i5, -1, "dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectContent.<anonymous>.<anonymous>.<anonymous> (FaqSubjectScreen.kt:131)");
                }
                FaqContactViewKt.FaqContactView(function0, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FaqSubjectContent$lambda$8(LazyListState lazyListState, FaqSubject faqSubject, Set set, Function1 function1, Function0 function0, int i5, Composer composer, int i6) {
        FaqSubjectContent(lazyListState, faqSubject, set, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void FaqSubjectScreen(final FaqSubjectViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        String str;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-1863420502);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1863420502, i6, -1, "dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectScreen (FaqSubjectScreen.kt:61)");
            }
            FaqSubjectViewModel.ViewState viewState = (FaqSubjectViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            FaqSubject subject = viewState.getSubject();
            LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
            Integer initialScrollIndex = viewState.getInitialScrollIndex();
            startRestartGroup.startReplaceGroup(1998329763);
            boolean changed = startRestartGroup.changed(initialScrollIndex) | startRestartGroup.changed(rememberLazyListState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new FaqSubjectScreenKt$FaqSubjectScreen$1$1(initialScrollIndex, rememberLazyListState, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(initialScrollIndex, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 0);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            FaqSubject subject2 = viewState.getSubject();
            if (subject2 == null || (str = subject2.getTitle()) == null) {
                str = BuildConfig.FLAVOR;
            }
            String str2 = str;
            startRestartGroup.startReplaceGroup(1998338205);
            int i7 = i6 & 112;
            boolean z5 = i7 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new FaqSubjectScreenKt$FaqSubjectScreen$2$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1998339773);
            boolean z6 = i7 == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new FaqSubjectScreenKt$FaqSubjectScreen$3$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(fillMaxSize$default, 0.0f, str2, null, 0L, function0, (Function0) rememberedValue3, rememberLazyListState, null, ComposableLambdaKt.rememberComposableLambda(335092477, true, new FaqSubjectScreenKt$FaqSubjectScreen$4(subject, rememberLazyListState, viewState, viewModel, navigator), startRestartGroup, 54), composer2, 805306374, 282);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: N3.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FaqSubjectScreen$lambda$4;
                    FaqSubjectScreen$lambda$4 = FaqSubjectScreenKt.FaqSubjectScreen$lambda$4(FaqSubjectViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FaqSubjectScreen$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FaqSubjectScreen$lambda$4(FaqSubjectViewModel faqSubjectViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        FaqSubjectScreen(faqSubjectViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QAView(final FaqQuestionAndAnswer faqQuestionAndAnswer, final boolean z5, final Function1<? super FaqQuestionId, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-326149601);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(faqQuestionAndAnswer) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-326149601, i6, -1, "dk.molslinjen.ui.views.screens.profile.faq.subject.QAView (FaqSubjectScreen.kt:137)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            startRestartGroup.startReplaceGroup(-294984486);
            boolean changedInstance = ((i6 & 896) == 256) | startRestartGroup.changedInstance(faqQuestionAndAnswer);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: N3.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit QAView$lambda$10$lambda$9;
                        QAView$lambda$10$lambda$9 = FaqSubjectScreenKt.QAView$lambda$10$lambda$9(Function1.this, faqQuestionAndAnswer);
                        return QAView$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            float f5 = 16;
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(ModifierExtensionsKt.noRippleClickable(companion, (Function0) rememberedValue), Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(f5));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            TextKt.m940Text4IGK_g(faqQuestionAndAnswer.getQuestion(), RowScope.weight$default(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), startRestartGroup, 0, 1572864, 65532);
            LottieCompositionResult rememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m2761boximpl(LottieCompositionSpec.RawRes.m2762constructorimpl(R.raw.animation_lottie_plus_to_minus)), null, null, null, null, null, startRestartGroup, 6, 62);
            final LottieAnimationState animateLottieCompositionAsState = AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(QAView$lambda$17$lambda$16$lambda$11(rememberLottieComposition), false, false, false, null, z5 ? 1.0f : -1.0f, 1, null, false, false, startRestartGroup, 1572864, 926);
            Modifier m108borderxT4_qwU = BorderKt.m108borderxT4_qwU(SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(32)), Dp.m2599constructorimpl(1), AppColor.INSTANCE.m3267getGrey40d7_KjU(), RoundedCornerShapeKt.getCircleShape());
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m108borderxT4_qwU);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier m331size3ABfNKs = SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(f5));
            LottieComposition QAView$lambda$17$lambda$16$lambda$11 = QAView$lambda$17$lambda$16$lambda$11(rememberLottieComposition);
            startRestartGroup.startReplaceGroup(-56791099);
            boolean changed = startRestartGroup.changed(animateLottieCompositionAsState);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: N3.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        float QAView$lambda$17$lambda$16$lambda$12;
                        QAView$lambda$17$lambda$16$lambda$12 = FaqSubjectScreenKt.QAView$lambda$17$lambda$16$lambda$12(LottieAnimationState.this);
                        return Float.valueOf(QAView$lambda$17$lambda$16$lambda$12);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            LottieAnimationKt.LottieAnimation(QAView$lambda$17$lambda$16$lambda$11, (Function0) rememberedValue2, m331size3ABfNKs, false, false, false, null, false, null, null, null, false, null, startRestartGroup, 384, 0, 8184);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            composer2 = startRestartGroup;
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z5, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(941004433, true, new FaqSubjectScreenKt$QAView$2$2(faqQuestionAndAnswer), startRestartGroup, 54), startRestartGroup, 1572870 | (i6 & 112), 30);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: N3.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit QAView$lambda$18;
                    QAView$lambda$18 = FaqSubjectScreenKt.QAView$lambda$18(FaqQuestionAndAnswer.this, z5, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return QAView$lambda$18;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QAView$lambda$10$lambda$9(Function1 function1, FaqQuestionAndAnswer faqQuestionAndAnswer) {
        function1.invoke(FaqQuestionId.m3229boximpl(faqQuestionAndAnswer.m3228getIdarQqKPc()));
        return Unit.INSTANCE;
    }

    private static final LottieComposition QAView$lambda$17$lambda$16$lambda$11(LottieCompositionResult lottieCompositionResult) {
        return lottieCompositionResult.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float QAView$lambda$17$lambda$16$lambda$12(LottieAnimationState lottieAnimationState) {
        return lottieAnimationState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QAView$lambda$18(FaqQuestionAndAnswer faqQuestionAndAnswer, boolean z5, Function1 function1, int i5, Composer composer, int i6) {
        QAView(faqQuestionAndAnswer, z5, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
