package dk.molslinjen.ui.views.screens.profile.faq;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.faq.FaqPopularQuestion;
import dk.molslinjen.domain.model.faq.FaqSubject;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.profile.faq.FaqScreenKt;
import dk.molslinjen.ui.views.screens.profile.faq.FaqViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a£\u0001\u0010\u0019\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u000f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\r2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u000f2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\r2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00040\u000f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a5\u0010\u0015\u001a\u00020\u0004*\u00020\u001b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\r2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00040\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u001c\u001a+\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00040\u000fH\u0003¢\u0006\u0004\b\u001e\u0010\u001f\u001a5\u0010 \u001a\u00020\u0004*\u00020\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u000fH\u0002¢\u0006\u0004\b \u0010\u001c\u001a3\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010#\u001a\u00020\"H\u0003¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/faq/FaqViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "FaqScreen", "(Ldk/molslinjen/ui/views/screens/profile/faq/FaqViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "isLoading", "Landroidx/compose/foundation/lazy/LazyListState;", "lazyListState", "Ldk/molslinjen/domain/model/site/SiteInfo;", "selectedSite", BuildConfig.FLAVOR, "sites", "Lkotlin/Function1;", "onSiteChange", "Ldk/molslinjen/domain/model/faq/FaqSubject;", "categories", "onSubjectSelected", "Ldk/molslinjen/domain/model/faq/FaqPopularQuestion;", "popularQuestions", "onQuestionSelected", "Lkotlin/Function0;", "navigateToContact", "FaqContent", "(ZLandroidx/compose/foundation/lazy/LazyListState;Ldk/molslinjen/domain/model/site/SiteInfo;Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/lazy/LazyListScope;", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "popularQuestion", "PopularQuestionRow", "(Ldk/molslinjen/domain/model/faq/FaqPopularQuestion;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "allSubjects", "subject", "Landroidx/compose/ui/graphics/Shape;", "clipShape", "FaqSubjectRow", "(Ldk/molslinjen/domain/model/faq/FaqSubject;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FaqScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void FaqContent(final boolean z5, final LazyListState lazyListState, final SiteInfo siteInfo, final List<SiteInfo> list, final Function1<? super SiteInfo, Unit> function1, final List<FaqSubject> list2, final Function1<? super FaqSubject, Unit> function12, final List<FaqPopularQuestion> list3, final Function1<? super FaqPopularQuestion, Unit> function13, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(720848172);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(siteInfo) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(list) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(list2) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(list3) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function13) ? 67108864 : 33554432;
        }
        if ((805306368 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 536870912 : 268435456;
        }
        int i7 = i6;
        if ((306783379 & i7) == 306783378 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(720848172, i7, -1, "dk.molslinjen.ui.views.screens.profile.faq.FaqContent (FaqScreen.kt:100)");
            }
            composer2 = startRestartGroup;
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, z5, 0, siteInfo == null || list == null, null, ComposableLambdaKt.rememberComposableLambda(821032568, true, new FaqScreenKt$FaqContent$1(lazyListState, siteInfo, list, function1, list3, function13, list2, function12, function0), startRestartGroup, 54), composer2, ((i7 << 6) & 896) | 1572864, 43);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: M3.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FaqContent$lambda$4;
                    FaqContent$lambda$4 = FaqScreenKt.FaqContent$lambda$4(z5, lazyListState, siteInfo, list, function1, list2, function12, list3, function13, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FaqContent$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FaqContent$lambda$4(boolean z5, LazyListState lazyListState, SiteInfo siteInfo, List list, Function1 function1, List list2, Function1 function12, List list3, Function1 function13, Function0 function0, int i5, Composer composer, int i6) {
        FaqContent(z5, lazyListState, siteInfo, list, function1, list2, function12, list3, function13, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void FaqScreen(final FaqViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(1013335182);
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
                ComposerKt.traceEventStart(1013335182, i6, -1, "dk.molslinjen.ui.views.screens.profile.faq.FaqScreen (FaqScreen.kt:59)");
            }
            FaqViewModel.ViewState viewState = (FaqViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.faq_title, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-2125573225);
            int i7 = i6 & 112;
            boolean z5 = i7 == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new FaqScreenKt$FaqScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2125571657);
            boolean z6 = i7 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new FaqScreenKt$FaqScreen$2$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(711306843, true, new FaqScreenKt$FaqScreen$3(viewState, viewModel, rememberLazyListState, navigator), startRestartGroup, 54);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(fillMaxSize$default, 0.0f, stringResource, null, 0L, function0, (Function0) rememberedValue2, rememberLazyListState, null, rememberComposableLambda, startRestartGroup, 805306374, 282);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: M3.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FaqScreen$lambda$3;
                    FaqScreen$lambda$3 = FaqScreenKt.FaqScreen$lambda$3(FaqViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FaqScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FaqScreen$lambda$3(FaqViewModel faqViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        FaqScreen(faqViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FaqSubjectRow(final FaqSubject faqSubject, final Function1<? super FaqSubject, Unit> function1, final Shape shape, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-763617136);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(faqSubject) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(shape) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-763617136, i6, -1, "dk.molslinjen.ui.views.screens.profile.faq.FaqSubjectRow (FaqScreen.kt:223)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier clip = ClipKt.clip(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), shape);
            startRestartGroup.startReplaceGroup(-1926327424);
            boolean changedInstance = startRestartGroup.changedInstance(faqSubject) | ((i6 & 112) == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: M3.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit FaqSubjectRow$lambda$9$lambda$8;
                        FaqSubjectRow$lambda$9$lambda$8 = FaqScreenKt.FaqSubjectRow$lambda$9$lambda$8(Function1.this, faqSubject);
                        return FaqSubjectRow$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(ClickableKt.m122clickableXHw0xAI$default(clip, false, null, null, (Function0) rememberedValue, 7, null), Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(19));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            Modifier weight$default = RowScope.weight$default(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(faqSubject.getTitle(), weight$default, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer2, 0, 1572864, 65532);
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_chevron_right, composer2, 6), Accessibility.INSTANCE.getSkip(), (Modifier) null, AppColor.INSTANCE.m3253getBrandBlack10d7_KjU(), composer2, 3072, 4);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: M3.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FaqSubjectRow$lambda$11;
                    FaqSubjectRow$lambda$11 = FaqScreenKt.FaqSubjectRow$lambda$11(FaqSubject.this, function1, shape, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FaqSubjectRow$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FaqSubjectRow$lambda$11(FaqSubject faqSubject, Function1 function1, Shape shape, int i5, Composer composer, int i6) {
        FaqSubjectRow(faqSubject, function1, shape, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FaqSubjectRow$lambda$9$lambda$8(Function1 function1, FaqSubject faqSubject) {
        function1.invoke(faqSubject);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PopularQuestionRow(final FaqPopularQuestion faqPopularQuestion, final Function1<? super FaqPopularQuestion, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1742918341);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(faqPopularQuestion) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1742918341, i6, -1, "dk.molslinjen.ui.views.screens.profile.faq.PopularQuestionRow (FaqScreen.kt:174)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            startRestartGroup.startReplaceGroup(-2129696008);
            boolean changedInstance = ((i6 & 112) == 32) | startRestartGroup.changedInstance(faqPopularQuestion);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: M3.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PopularQuestionRow$lambda$6$lambda$5;
                        PopularQuestionRow$lambda$6$lambda$5 = FaqScreenKt.PopularQuestionRow$lambda$6$lambda$5(Function1.this, faqPopularQuestion);
                        return PopularQuestionRow$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, (Function0) rememberedValue, 7, null);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(faqPopularQuestion.getQuestion(), m122clickableXHw0xAI$default, 0L, 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 100663296, 1572864, 65276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: M3.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PopularQuestionRow$lambda$7;
                    PopularQuestionRow$lambda$7 = FaqScreenKt.PopularQuestionRow$lambda$7(FaqPopularQuestion.this, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PopularQuestionRow$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopularQuestionRow$lambda$6$lambda$5(Function1 function1, FaqPopularQuestion faqPopularQuestion) {
        function1.invoke(faqPopularQuestion);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopularQuestionRow$lambda$7(FaqPopularQuestion faqPopularQuestion, Function1 function1, int i5, Composer composer, int i6) {
        PopularQuestionRow(faqPopularQuestion, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void allSubjects(LazyListScope lazyListScope, final List<FaqSubject> list, final Function1<? super FaqSubject, Unit> function1) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$FaqScreenKt.INSTANCE.m3508getLambda3$app_kombardoProd(), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1012631347, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.faq.FaqScreenKt$allSubjects$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i5) {
                Shape rectangleShape;
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i5 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1012631347, i5, -1, "dk.molslinjen.ui.views.screens.profile.faq.allSubjects.<anonymous> (FaqScreen.kt:195)");
                }
                Modifier m108borderxT4_qwU = BorderKt.m108borderxT4_qwU(Modifier.INSTANCE, Dp.m2599constructorimpl(1), AppColor.INSTANCE.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium());
                List<FaqSubject> list2 = list;
                Function1<FaqSubject, Unit> function12 = function1;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m108borderxT4_qwU);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                composer.startReplaceGroup(862422275);
                int i6 = 0;
                for (Object obj : list2) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    FaqSubject faqSubject = (FaqSubject) obj;
                    if (i6 == 0) {
                        float f5 = 8;
                        float f6 = 0;
                        rectangleShape = RoundedCornerShapeKt.m461RoundedCornerShapea9UjIt4(Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6));
                    } else if (i6 == CollectionsKt.getLastIndex(list2)) {
                        float f7 = 0;
                        float f8 = 8;
                        rectangleShape = RoundedCornerShapeKt.m461RoundedCornerShapea9UjIt4(Dp.m2599constructorimpl(f7), Dp.m2599constructorimpl(f7), Dp.m2599constructorimpl(f8), Dp.m2599constructorimpl(f8));
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    FaqScreenKt.FaqSubjectRow(faqSubject, function12, rectangleShape, composer, 0);
                    composer.startReplaceGroup(862440737);
                    if (i6 < CollectionsKt.getLastIndex(list2)) {
                        HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
                    }
                    composer.endReplaceGroup();
                    i6 = i7;
                }
                composer.endReplaceGroup();
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void popularQuestions(LazyListScope lazyListScope, final List<FaqPopularQuestion> list, final Function1<? super FaqPopularQuestion, Unit> function1) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1645555660, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.faq.FaqScreenKt$popularQuestions$1
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
                    ComposerKt.traceEventStart(1645555660, i5, -1, "dk.molslinjen.ui.views.screens.profile.faq.popularQuestions.<anonymous> (FaqScreen.kt:145)");
                }
                String stringResource = StringResources_androidKt.stringResource(R.string.faq_popularTitle, composer, 6);
                TextStyle sub = TypographyKt.getSub();
                AppColor appColor = AppColor.INSTANCE;
                TextKt.m940Text4IGK_g(stringResource, null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub, composer, 384, 1572864, 65530);
                Modifier.Companion companion = Modifier.INSTANCE;
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(8)), composer, 6);
                CornerBasedShape medium = ThemeShapesKt.getThemeShapes().getMedium();
                Modifier m108borderxT4_qwU = BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), appColor.m3269getGrey60d7_KjU(), medium), Dp.m2599constructorimpl(1), appColor.m3268getGrey50d7_KjU(), medium);
                float f5 = 24;
                Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(m108borderxT4_qwU, Dp.m2599constructorimpl(f5));
                List<FaqPopularQuestion> list2 = list;
                Function1<FaqPopularQuestion, Unit> function12 = function1;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m311padding3ABfNKs);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                composer.startReplaceGroup(-2020050927);
                int i6 = 0;
                for (Object obj : list2) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    FaqScreenKt.PopularQuestionRow((FaqPopularQuestion) obj, function12, composer, 0);
                    composer.startReplaceGroup(-2020044307);
                    if (i6 < CollectionsKt.getLastIndex(list2)) {
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(f5)), composer, 6);
                    }
                    composer.endReplaceGroup();
                    i6 = i7;
                }
                composer.endReplaceGroup();
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
    }
}
