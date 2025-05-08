package dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterAgreement;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.screens.agreements.common.AgreementActiveTicketSectionKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.BornholmCommuterCardViewKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.BornholmCommuterDetailsScreenKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.BornholmCommuterDetailsViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aY\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\t2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\tH\u0003¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/details/BornholmCommuterDetailsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "BornholmCommuterDetailsScreen", "(Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/details/BornholmCommuterDetailsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;", "agreement", "Lkotlin/Function1;", "navigateToOrderTicket", "Lkotlin/Function2;", BuildConfig.FLAVOR, "navigateToTicketDetails", "navigateToTicketHistory", "Content", "(Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BornholmCommuterDetailsScreenKt {
    public static final void BornholmCommuterDetailsScreen(final BornholmCommuterDetailsViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(795876330);
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
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(795876330, i6, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.BornholmCommuterDetailsScreen (BornholmCommuterDetailsScreen.kt:39)");
            }
            BornholmCommuterAgreement bornholmCommuterAgreement = (BornholmCommuterAgreement) SnapshotStateKt.collectAsState(viewModel.getAgreement(), null, startRestartGroup, 0, 1).getValue();
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, bornholmCommuterAgreement == null, 0, false, null, ComposableLambdaKt.rememberComposableLambda(-451786588, true, new BornholmCommuterDetailsScreenKt$BornholmCommuterDetailsScreen$1$1(bornholmCommuterAgreement, viewModel, navigator), startRestartGroup, 54), startRestartGroup, 1572864, 59);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: s2.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BornholmCommuterDetailsScreen$lambda$1;
                    BornholmCommuterDetailsScreen$lambda$1 = BornholmCommuterDetailsScreenKt.BornholmCommuterDetailsScreen$lambda$1(BornholmCommuterDetailsViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return BornholmCommuterDetailsScreen$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BornholmCommuterDetailsScreen$lambda$1(BornholmCommuterDetailsViewModel bornholmCommuterDetailsViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        BornholmCommuterDetailsScreen(bornholmCommuterDetailsViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Content(final BornholmCommuterAgreement bornholmCommuterAgreement, final Function1<? super BornholmCommuterAgreement, Unit> function1, final Function2<? super String, ? super String, Unit> function2, final Function1<? super BornholmCommuterAgreement, Unit> function12, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-621993344);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(bornholmCommuterAgreement) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-621993344, i6, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.Content (BornholmCommuterDetailsScreen.kt:87)");
            }
            float f5 = 16;
            PaddingValues m309PaddingValuesa9UjIt4 = PaddingKt.m309PaddingValuesa9UjIt4(Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(46));
            startRestartGroup.startReplaceGroup(1767983311);
            boolean changedInstance = startRestartGroup.changedInstance(bornholmCommuterAgreement) | ((i6 & 112) == 32) | ((i6 & 896) == 256) | ((i6 & 7168) == 2048);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: s2.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$4$lambda$3;
                        Content$lambda$4$lambda$3 = BornholmCommuterDetailsScreenKt.Content$lambda$4$lambda$3(BornholmCommuterAgreement.this, function2, function1, function12, (LazyListScope) obj);
                        return Content$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LazyDslKt.LazyColumn(null, null, m309PaddingValuesa9UjIt4, false, null, null, null, false, (Function1) rememberedValue, startRestartGroup, 0, 251);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: s2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$5;
                    Content$lambda$5 = BornholmCommuterDetailsScreenKt.Content$lambda$5(BornholmCommuterAgreement.this, function1, function2, function12, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$4$lambda$3(final BornholmCommuterAgreement bornholmCommuterAgreement, Function2 function2, final Function1 function1, final Function1 function12, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(2067165804, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.BornholmCommuterDetailsScreenKt$Content$1$1$1
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
                    ComposerKt.traceEventStart(2067165804, i5, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.Content.<anonymous>.<anonymous>.<anonymous> (BornholmCommuterDetailsScreen.kt:92)");
                }
                BornholmCommuterCardViewKt.BornholmCommuterCardView(BornholmCommuterAgreement.this, null, function1, composer, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        AgreementActiveTicketSectionKt.agreementActiveTicketsSection(LazyColumn, R.string.commuter_tickets_title, R.string.commuter_details_emptyTickets, false, TicketCategoryType.Commuter, bornholmCommuterAgreement.getActiveTickets(), function2, new Function0() { // from class: s2.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit Content$lambda$4$lambda$3$lambda$2;
                Content$lambda$4$lambda$3$lambda$2 = BornholmCommuterDetailsScreenKt.Content$lambda$4$lambda$3$lambda$2(Function1.this, bornholmCommuterAgreement);
                return Content$lambda$4$lambda$3$lambda$2;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$4$lambda$3$lambda$2(Function1 function1, BornholmCommuterAgreement bornholmCommuterAgreement) {
        function1.invoke(bornholmCommuterAgreement);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$5(BornholmCommuterAgreement bornholmCommuterAgreement, Function1 function1, Function2 function2, Function1 function12, int i5, Composer composer, int i6) {
        Content(bornholmCommuterAgreement, function1, function2, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
