package dk.molslinjen.ui.views.screens.developer;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.screens.developer.DeveloperComponentsScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"DeveloperComponentsScreen", BuildConfig.FLAVOR, "(Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeveloperComponentsScreenKt {
    public static final void DeveloperComponentsScreen(Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(-1877612065);
        if (i5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1877612065, i5, -1, "dk.molslinjen.ui.views.screens.developer.DeveloperComponentsScreen (DeveloperComponentsScreen.kt:20)");
            }
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
            PaddingValues m308PaddingValuesYgX7TsA$default = PaddingKt.m308PaddingValuesYgX7TsA$default(0.0f, Dp.m2599constructorimpl(24), 1, null);
            startRestartGroup.startReplaceGroup(-2032603027);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: l3.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DeveloperComponentsScreen$lambda$1$lambda$0;
                        DeveloperComponentsScreen$lambda$1$lambda$0 = DeveloperComponentsScreenKt.DeveloperComponentsScreen$lambda$1$lambda$0((LazyListScope) obj);
                        return DeveloperComponentsScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            LazyDslKt.LazyColumn(m104backgroundbw27NRU$default, null, m308PaddingValuesYgX7TsA$default, false, null, null, null, false, (Function1) rememberedValue, startRestartGroup, 100663686, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: l3.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeveloperComponentsScreen$lambda$2;
                    DeveloperComponentsScreen$lambda$2 = DeveloperComponentsScreenKt.DeveloperComponentsScreen$lambda$2(i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeveloperComponentsScreen$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperComponentsScreen$lambda$1$lambda$0(LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        ComposableSingletons$DeveloperComponentsScreenKt composableSingletons$DeveloperComponentsScreenKt = ComposableSingletons$DeveloperComponentsScreenKt.INSTANCE;
        LazyListScope.item$default(LazyColumn, null, null, composableSingletons$DeveloperComponentsScreenKt.m3479getLambda1$app_kombardoProd(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, composableSingletons$DeveloperComponentsScreenKt.m3480getLambda2$app_kombardoProd(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, composableSingletons$DeveloperComponentsScreenKt.m3481getLambda3$app_kombardoProd(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, composableSingletons$DeveloperComponentsScreenKt.m3482getLambda4$app_kombardoProd(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, composableSingletons$DeveloperComponentsScreenKt.m3483getLambda5$app_kombardoProd(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, composableSingletons$DeveloperComponentsScreenKt.m3484getLambda6$app_kombardoProd(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, composableSingletons$DeveloperComponentsScreenKt.m3485getLambda7$app_kombardoProd(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, composableSingletons$DeveloperComponentsScreenKt.m3486getLambda8$app_kombardoProd(), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperComponentsScreen$lambda$2(int i5, Composer composer, int i6) {
        DeveloperComponentsScreen(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
