package dk.molslinjen.ui.views.screens.developer;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import dk.molslinjen.core.ApiEnvironment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeveloperAppVersionViewKt$DeveloperAppVersionView$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ DeveloperViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeveloperAppVersionViewKt$DeveloperAppVersionView$1(DeveloperViewModel developerViewModel) {
        this.$viewModel = developerViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        String appVersion;
        String androidVersion;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2046376293, i5, -1, "dk.molslinjen.ui.views.screens.developer.DeveloperAppVersionView.<anonymous> (DeveloperAppVersionView.kt:27)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        composer.startReplaceGroup(1235689471);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.developer.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = DeveloperAppVersionViewKt$DeveloperAppVersionView$1.invoke$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Modifier statusBarsPadding = WindowInsetsPadding_androidKt.statusBarsPadding(SizeKt.fillMaxWidth(SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) rememberedValue), 1.0f));
        float f5 = 10;
        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(statusBarsPadding, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 10, null);
        DeveloperViewModel developerViewModel = this.$viewModel;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m315paddingqDBjuR0$default);
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
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        appVersion = DeveloperAppVersionViewKt.appVersion();
        TextKt.m940Text4IGK_g(appVersion + " | API: " + ((ApiEnvironment) SnapshotStateKt.collectAsState(developerViewModel.getApiEnvironmentState(), null, composer, 0, 1).getValue()).name(), null, 0L, TextUnitKt.getSp(10), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 3072, 0, 131062);
        SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
        androidVersion = DeveloperAppVersionViewKt.androidVersion();
        TextKt.m940Text4IGK_g(androidVersion, null, 0L, TextUnitKt.getSp(10), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 3072, 0, 131062);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
