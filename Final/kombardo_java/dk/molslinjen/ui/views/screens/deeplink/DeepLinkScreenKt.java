package dk.molslinjen.ui.views.screens.deeplink;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.screens.deeplink.DeepLinkScreenKt;
import dk.molslinjen.ui.views.screens.deeplink.DeepLinkViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"DeepLinkScreen", BuildConfig.FLAVOR, "viewModel", "Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkViewModel;", "navigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "(Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "navigateWithPop", "direction", "Lcom/ramcosta/composedestinations/spec/Direction;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeepLinkScreenKt {
    public static final void DeepLinkScreen(final DeepLinkViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-446088937);
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
                ComposerKt.traceEventStart(-446088937, i6, -1, "dk.molslinjen.ui.views.screens.deeplink.DeepLinkScreen (DeepLinkScreen.kt:27)");
            }
            Boolean bool = Boolean.TRUE;
            startRestartGroup.startReplaceGroup(-1292520331);
            boolean changedInstance = ((i6 & 112) == 32) | startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new DeepLinkScreenKt$DeepLinkScreen$1$1(viewModel, navigator, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(bool, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 6);
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, true, 0, false, null, ComposableSingletons$DeepLinkScreenKt.INSTANCE.m3477getLambda1$app_kombardoProd(), startRestartGroup, 1573254, 58);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: k3.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeepLinkScreen$lambda$1;
                    DeepLinkScreen$lambda$1 = DeepLinkScreenKt.DeepLinkScreen$lambda$1(DeepLinkViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeepLinkScreen$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeepLinkScreen$lambda$1(DeepLinkViewModel deepLinkViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        DeepLinkScreen(deepLinkViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateWithPop(DestinationsNavigator destinationsNavigator, Direction direction) {
        destinationsNavigator.popBackStack();
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, direction, null, null, 6, null);
    }
}
