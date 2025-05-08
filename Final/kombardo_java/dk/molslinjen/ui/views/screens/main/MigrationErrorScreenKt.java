package dk.molslinjen.ui.views.screens.main;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.migration.Migrator;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.screens.main.MigrationErrorScreenKt;
import dk.molslinjen.ui.views.screens.main.MigrationErrorViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a%\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/ui/views/screens/main/MigrationErrorViewModel;", "viewModel", BuildConfig.FLAVOR, "MigrationErrorScreen", "(Ldk/molslinjen/ui/views/screens/main/MigrationErrorViewModel;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/core/migration/Migrator$MigrationState;", "state", "Lkotlin/Function0;", "proceed", "MigrationErrorContent", "(Ldk/molslinjen/core/migration/Migrator$MigrationState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MigrationErrorScreenKt {
    private static final void MigrationErrorContent(final Migrator.MigrationState migrationState, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(890391706);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(migrationState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i7 = i6;
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(890391706, i7, -1, "dk.molslinjen.ui.views.screens.main.MigrationErrorContent (MigrationErrorScreen.kt:47)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m311padding3ABfNKs(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(32)), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getCenter(), companion2.getCenterHorizontally(), startRestartGroup, 54);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, verticalScroll$default);
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
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_info_dialog_warning, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), ColumnScopeInstance.INSTANCE.align(SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(41)), companion2.getCenterHorizontally()), Color.INSTANCE.m1501getUnspecified0d7_KjU(), startRestartGroup, 3072, 0);
            float f5 = 16;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.migration_title, startRestartGroup, 6);
            TextStyle paragraphBold = TypographyKt.getParagraphBold();
            TextAlign.Companion companion4 = TextAlign.INSTANCE;
            TextKt.m940Text4IGK_g(stringResource, fillMaxWidth$default, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraphBold, startRestartGroup, 48, 1572864, 65020);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.migration_description, startRestartGroup, 6), SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 48, 1572864, 65020);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(8)), startRestartGroup, 6);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            List<String> migrationErrors = migrationState.getMigrationErrors();
            startRestartGroup.startReplaceGroup(827776766);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: o3.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        CharSequence MigrationErrorContent$lambda$5$lambda$4$lambda$3;
                        MigrationErrorContent$lambda$5$lambda$4$lambda$3 = MigrationErrorScreenKt.MigrationErrorContent$lambda$5$lambda$4$lambda$3((String) obj);
                        return MigrationErrorContent$lambda$5$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.m940Text4IGK_g(CollectionsKt.joinToString$default(migrationErrors, "\n", null, null, 0, null, (Function1) rememberedValue, 30, null), fillMaxWidth$default2, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 48, 1572864, 65020);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(24)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            PrimaryButtonKt.PrimaryButton(null, StringResources_androidKt.stringResource(R.string.migration_proceedButton, startRestartGroup, 6), function0, null, null, false, false, false, startRestartGroup, (i7 << 3) & 896, 249);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: o3.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MigrationErrorContent$lambda$6;
                    MigrationErrorContent$lambda$6 = MigrationErrorScreenKt.MigrationErrorContent$lambda$6(Migrator.MigrationState.this, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MigrationErrorContent$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence MigrationErrorContent$lambda$5$lambda$4$lambda$3(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "• " + it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MigrationErrorContent$lambda$6(Migrator.MigrationState migrationState, Function0 function0, int i5, Composer composer, int i6) {
        MigrationErrorContent(migrationState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void MigrationErrorScreen(final MigrationErrorViewModel viewModel, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(-668724374);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-668724374, i6, -1, "dk.molslinjen.ui.views.screens.main.MigrationErrorScreen (MigrationErrorScreen.kt:35)");
            }
            Migrator.MigrationState migrationState = (Migrator.MigrationState) SnapshotStateKt.collectAsState(viewModel.getMigrationState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(1148619406);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: o3.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MigrationErrorScreen$lambda$1$lambda$0;
                        MigrationErrorScreen$lambda$1$lambda$0 = MigrationErrorScreenKt.MigrationErrorScreen$lambda$1$lambda$0(MigrationErrorViewModel.this);
                        return MigrationErrorScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            MigrationErrorContent(migrationState, (Function0) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: o3.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MigrationErrorScreen$lambda$2;
                    MigrationErrorScreen$lambda$2 = MigrationErrorScreenKt.MigrationErrorScreen$lambda$2(MigrationErrorViewModel.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MigrationErrorScreen$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MigrationErrorScreen$lambda$1$lambda$0(MigrationErrorViewModel migrationErrorViewModel) {
        migrationErrorViewModel.clearMigrationErrors();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MigrationErrorScreen$lambda$2(MigrationErrorViewModel migrationErrorViewModel, int i5, Composer composer, int i6) {
        MigrationErrorScreen(migrationErrorViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
