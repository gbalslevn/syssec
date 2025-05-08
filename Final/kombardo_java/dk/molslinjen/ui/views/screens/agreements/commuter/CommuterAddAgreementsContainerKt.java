package dk.molslinjen.ui.views.screens.agreements.commuter;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.buttons.OutlineDashedButtonKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterAddAgreementsContainerKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterAddAgreementsViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a5\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0003¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterAddAgreementsViewModel;", "viewModel", "Lkotlin/Function0;", BuildConfig.FLAVOR, "navigateToBornholmCommuterAgreement", "navigateToLogin", "CommuterAddAgreementsContainer", "(Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterAddAgreementsViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterAddAgreementsViewModel$State;", "type", "Content", "(Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterAddAgreementsViewModel$State;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CommuterAddAgreementsContainerKt {
    public static final void CommuterAddAgreementsContainer(final CommuterAddAgreementsViewModel viewModel, final Function0<Unit> navigateToBornholmCommuterAgreement, final Function0<Unit> navigateToLogin, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigateToBornholmCommuterAgreement, "navigateToBornholmCommuterAgreement");
        Intrinsics.checkNotNullParameter(navigateToLogin, "navigateToLogin");
        Composer startRestartGroup = composer.startRestartGroup(901049014);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToBornholmCommuterAgreement) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToLogin) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(901049014, i6, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.CommuterAddAgreementsContainer (CommuterAddAgreementsContainer.kt:20)");
            }
            Content((CommuterAddAgreementsViewModel.State) SnapshotStateKt.collectAsState(viewModel.getType(), null, startRestartGroup, 0, 1).getValue(), navigateToBornholmCommuterAgreement, navigateToLogin, startRestartGroup, i6 & 1008);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: p2.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CommuterAddAgreementsContainer$lambda$0;
                    CommuterAddAgreementsContainer$lambda$0 = CommuterAddAgreementsContainerKt.CommuterAddAgreementsContainer$lambda$0(CommuterAddAgreementsViewModel.this, navigateToBornholmCommuterAgreement, navigateToLogin, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CommuterAddAgreementsContainer$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommuterAddAgreementsContainer$lambda$0(CommuterAddAgreementsViewModel commuterAddAgreementsViewModel, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        CommuterAddAgreementsContainer(commuterAddAgreementsViewModel, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void Content(final CommuterAddAgreementsViewModel.State state, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1514252607);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(state) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        int i7 = i6;
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1514252607, i7, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.Content (CommuterAddAgreementsContainer.kt:29)");
            }
            if (state == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: p2.b
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit Content$lambda$1;
                            Content$lambda$1 = CommuterAddAgreementsContainerKt.Content$lambda$1(CommuterAddAgreementsViewModel.State.this, function0, function02, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return Content$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (state instanceof CommuterAddAgreementsViewModel.State.Large) {
                startRestartGroup.startReplaceGroup(-1136324466);
                CommuterOverviewEmptyCardKt.CommuterOverviewEmptyCard(StringResources_androidKt.stringResource(R.string.commuter_emptyState_title, startRestartGroup, 6), StringResources_androidKt.stringResource(R.string.commuter_emptyState_description, startRestartGroup, 6), StringResources_androidKt.stringResource(R.string.button_addCommuterAgreement, startRestartGroup, 6), function0, startRestartGroup, (i7 << 6) & 7168);
                if (((CommuterAddAgreementsViewModel.State.Large) state).getShowOeresund()) {
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(24)), startRestartGroup, 6);
                    CommuterOverviewEmptyCardKt.CommuterOverviewEmptyCard(StringResources_androidKt.stringResource(R.string.commuter_oeresund_emptyState_title, startRestartGroup, 6), StringResources_androidKt.stringResource(R.string.commuter_oeresund_emptyState_description, startRestartGroup, 6), StringResources_androidKt.stringResource(R.string.button_addOeresundCommuterAgreement, startRestartGroup, 6), function02, startRestartGroup, (i7 << 3) & 7168);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
            } else {
                if (!(state instanceof CommuterAddAgreementsViewModel.State.Small)) {
                    startRestartGroup.startReplaceGroup(-36657074);
                    startRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                startRestartGroup.startReplaceGroup(-1135297126);
                String stringResource = StringResources_androidKt.stringResource(R.string.button_small_addBornholmCommuterAgreement, startRestartGroup, 6);
                AppColor appColor = AppColor.INSTANCE;
                composer2 = startRestartGroup;
                OutlineDashedButtonKt.m3405OutlineDashedButtonEMNEwkI(null, stringResource, R.drawable.icon_plus_circled, appColor.m3269getGrey60d7_KjU(), 0L, 0L, function0, startRestartGroup, ((i7 << 15) & 3670016) | 3456, 49);
                if (((CommuterAddAgreementsViewModel.State.Small) state).getShowOeresund()) {
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(24)), composer2, 6);
                    OutlineDashedButtonKt.m3405OutlineDashedButtonEMNEwkI(null, StringResources_androidKt.stringResource(R.string.button_small_addOeresundCommuterAgreement, composer2, 6), R.drawable.icon_plus_circled, appColor.m3269getGrey60d7_KjU(), 0L, 0L, function02, composer2, ((i7 << 12) & 3670016) | 3456, 49);
                }
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: p2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$3;
                    Content$lambda$3 = CommuterAddAgreementsContainerKt.Content$lambda$3(CommuterAddAgreementsViewModel.State.this, function0, function02, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1(CommuterAddAgreementsViewModel.State state, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        Content(state, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$3(CommuterAddAgreementsViewModel.State state, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        Content(state, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
