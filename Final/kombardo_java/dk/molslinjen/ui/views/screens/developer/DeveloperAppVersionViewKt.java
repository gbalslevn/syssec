package dk.molslinjen.ui.views.screens.developer;

import android.os.Build;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import dk.molslinjen.core.Environment;
import dk.molslinjen.ui.views.screens.developer.DeveloperAppVersionViewKt;
import dk.molslinjen.ui.views.screens.developer.DeveloperViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Ldk/molslinjen/ui/views/screens/developer/DeveloperViewModel;", "viewModel", BuildConfig.FLAVOR, "DeveloperAppVersionView", "(Ldk/molslinjen/ui/views/screens/developer/DeveloperViewModel;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "appVersion", "()Ljava/lang/String;", "androidVersion", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeveloperAppVersionViewKt {
    public static final void DeveloperAppVersionView(final DeveloperViewModel viewModel, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(1166214693);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1166214693, i6, -1, "dk.molslinjen.ui.views.screens.developer.DeveloperAppVersionView (DeveloperAppVersionView.kt:23)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(ColorKt.Color(4294940672L))), ComposableLambdaKt.rememberComposableLambda(2046376293, true, new DeveloperAppVersionViewKt$DeveloperAppVersionView$1(viewModel), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: l3.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeveloperAppVersionView$lambda$0;
                    DeveloperAppVersionView$lambda$0 = DeveloperAppVersionViewKt.DeveloperAppVersionView$lambda$0(DeveloperViewModel.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeveloperAppVersionView$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperAppVersionView$lambda$0(DeveloperViewModel developerViewModel, int i5, Composer composer, int i6) {
        DeveloperAppVersionView(developerViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String androidVersion() {
        return "Android " + Build.VERSION.SDK_INT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String appVersion() {
        String str;
        Environment.Companion companion = Environment.INSTANCE;
        String str2 = companion.isMolslinjen() ? "Molslinjen" : "Kombardo";
        String description = companion.current().description();
        if (description != null) {
            str = description + " ";
        } else {
            str = null;
        }
        return str2 + " " + str + "2.14.1 (100000362)";
    }
}
