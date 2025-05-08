package dk.molslinjen.ui.views.reusable.snackbar;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import dk.molslinjen.core.snackbar.SnackbarMessageEvent;
import dk.molslinjen.ui.views.reusable.snackbar.CustomSnackbarHostKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"CustomSnackbarHost", BuildConfig.FLAVOR, "latestSnackbarMessageEvent", "Ldk/molslinjen/core/snackbar/SnackbarMessageEvent;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "scaffoldPaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Ldk/molslinjen/core/snackbar/SnackbarMessageEvent;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CustomSnackbarHostKt {
    public static final void CustomSnackbarHost(final SnackbarMessageEvent snackbarMessageEvent, final SnackbarHostState snackbarHostState, final PaddingValues scaffoldPaddingValues, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(scaffoldPaddingValues, "scaffoldPaddingValues");
        Composer startRestartGroup = composer.startRestartGroup(-470372873);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(snackbarMessageEvent) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(snackbarHostState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(scaffoldPaddingValues) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-470372873, i6, -1, "dk.molslinjen.ui.views.reusable.snackbar.CustomSnackbarHost (CustomSnackbarHost.kt:15)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            SnackbarHostKt.SnackbarHost(snackbarHostState, PaddingKt.m315paddingqDBjuR0$default(WindowInsetsPadding_androidKt.navigationBarsPadding(SizeKt.wrapContentHeight$default(BoxScopeInstance.INSTANCE.align(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), companion2.getBottomCenter()), companion2.getBottom(), false, 2, null)), 0.0f, 0.0f, 0.0f, scaffoldPaddingValues.getBottom(), 7, null), ComposableLambdaKt.rememberComposableLambda(1359348164, true, new CustomSnackbarHostKt$CustomSnackbarHost$1$1(snackbarMessageEvent), startRestartGroup, 54), startRestartGroup, ((i6 >> 3) & 14) | 384, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: k2.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CustomSnackbarHost$lambda$1;
                    CustomSnackbarHost$lambda$1 = CustomSnackbarHostKt.CustomSnackbarHost$lambda$1(SnackbarMessageEvent.this, snackbarHostState, scaffoldPaddingValues, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CustomSnackbarHost$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomSnackbarHost$lambda$1(SnackbarMessageEvent snackbarMessageEvent, SnackbarHostState snackbarHostState, PaddingValues paddingValues, int i5, Composer composer, int i6) {
        CustomSnackbarHost(snackbarMessageEvent, snackbarHostState, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
