package dk.molslinjen.ui.views.screens.main.push;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.push.PushMessage;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.dialog.CustomDialogKt;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.screens.main.push.PushDialogViewKt;
import dk.molslinjen.ui.views.screens.main.push.PushDialogViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a+\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0003¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/screens/main/push/PushDialogViewModel;", "viewModel", BuildConfig.FLAVOR, "PushDialogView", "(Ldk/molslinjen/ui/views/screens/main/push/PushDialogViewModel;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/main/push/PushDialogViewModel$ViewState;", "state", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/push/PushMessage;", "setAsShown", "InfoAlertContent", "(Ldk/molslinjen/ui/views/screens/main/push/PushDialogViewModel$ViewState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PushDialogViewKt {
    private static final void InfoAlertContent(final PushDialogViewModel.ViewState viewState, final Function1<? super PushMessage, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1494316233);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1494316233, i6, -1, "dk.molslinjen.ui.views.screens.main.push.InfoAlertContent (PushDialogView.kt:32)");
            }
            final PushMessage pushMessageReadyToShownInDialog = viewState.getPushMessageReadyToShownInDialog();
            if (pushMessageReadyToShownInDialog != null) {
                String stringResource = StringResources_androidKt.stringResource(R.string.button_close, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(1320915598);
                int i7 = i6 & 112;
                boolean changedInstance = (i7 == 32) | startRestartGroup.changedInstance(pushMessageReadyToShownInDialog);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: p3.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit InfoAlertContent$lambda$3$lambda$2;
                            InfoAlertContent$lambda$3$lambda$2 = PushDialogViewKt.InfoAlertContent$lambda$3$lambda$2(Function1.this, pushMessageReadyToShownInDialog);
                            return InfoAlertContent$lambda$3$lambda$2;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                SimpleButtonData simpleButtonData = new SimpleButtonData(stringResource, false, false, (Function0) rememberedValue, 6, null);
                startRestartGroup.startReplaceGroup(1320919110);
                boolean changedInstance2 = startRestartGroup.changedInstance(pushMessageReadyToShownInDialog) | (i7 == 32);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: p3.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit InfoAlertContent$lambda$5$lambda$4;
                            InfoAlertContent$lambda$5$lambda$4 = PushDialogViewKt.InfoAlertContent$lambda$5$lambda$4(Function1.this, pushMessageReadyToShownInDialog);
                            return InfoAlertContent$lambda$5$lambda$4;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                CustomDialogKt.CustomDialog(simpleButtonData, null, null, (Function0) rememberedValue2, false, ComposableLambdaKt.rememberComposableLambda(847365261, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.main.push.PushDialogViewKt$InfoAlertContent$3
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                        invoke(columnScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ColumnScope CustomDialog, Composer composer2, int i8) {
                        Intrinsics.checkNotNullParameter(CustomDialog, "$this$CustomDialog");
                        if ((i8 & 17) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(847365261, i8, -1, "dk.molslinjen.ui.views.screens.main.push.InfoAlertContent.<anonymous> (PushDialogView.kt:47)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                        PushMessage pushMessage = PushMessage.this;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, fillMaxWidth$default);
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                        String title = pushMessage.getTitle();
                        TextStyle paragraphBold = TypographyKt.getParagraphBold();
                        TextAlign.Companion companion3 = TextAlign.INSTANCE;
                        TextKt.m940Text4IGK_g(title, fillMaxWidth$default2, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraphBold, composer2, 48, 1572864, 65020);
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(16)), composer2, 6);
                        TextKt.m940Text4IGK_g(pushMessage.getBody(), SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 48, 1572864, 65020);
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, 221184, 6);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: p3.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit InfoAlertContent$lambda$6;
                    InfoAlertContent$lambda$6 = PushDialogViewKt.InfoAlertContent$lambda$6(PushDialogViewModel.ViewState.this, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return InfoAlertContent$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoAlertContent$lambda$3$lambda$2(Function1 function1, PushMessage pushMessage) {
        function1.invoke(pushMessage);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoAlertContent$lambda$5$lambda$4(Function1 function1, PushMessage pushMessage) {
        function1.invoke(pushMessage);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoAlertContent$lambda$6(PushDialogViewModel.ViewState viewState, Function1 function1, int i5, Composer composer, int i6) {
        InfoAlertContent(viewState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void PushDialogView(final PushDialogViewModel viewModel, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(1341587890);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1341587890, i6, -1, "dk.molslinjen.ui.views.screens.main.push.PushDialogView (PushDialogView.kt:22)");
            }
            PushDialogViewModel.ViewState viewState = (PushDialogViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(1791907328);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new PushDialogViewKt$PushDialogView$1$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            InfoAlertContent(viewState, (Function1) ((KFunction) rememberedValue), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: p3.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PushDialogView$lambda$1;
                    PushDialogView$lambda$1 = PushDialogViewKt.PushDialogView$lambda$1(PushDialogViewModel.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PushDialogView$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PushDialogView$lambda$1(PushDialogViewModel pushDialogViewModel, int i5, Composer composer, int i6) {
        PushDialogView(pushDialogViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
