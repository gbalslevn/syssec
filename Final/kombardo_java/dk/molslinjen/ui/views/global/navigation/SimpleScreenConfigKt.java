package dk.molslinjen.ui.views.global.navigation;

import androidx.compose.runtime.Composer;
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.ui.views.global.bottombar.BottomBarConfiguration;
import dk.molslinjen.ui.views.global.topbar.TopBarConfiguration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aU\u0010\u000b\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032(\b\u0002\u0010\t\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u00030\u0000j\u0002`\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Ldk/molslinjen/ui/views/global/topbar/TopBarConfiguration;", "topBarConfiguration", "Ldk/molslinjen/ui/views/global/bottombar/BottomBarConfiguration;", "bottomBarConfiguration", "Lkotlin/Function2;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "Lcom/ramcosta/composedestinations/navigation/DependenciesContainerBuilder;", BuildConfig.FLAVOR, "buildDependencies", "Ldk/molslinjen/ui/views/global/navigation/SimpleScreenConfig;", "createScreenConfig", "(Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;Ldk/molslinjen/ui/views/global/topbar/TopBarConfiguration;Ldk/molslinjen/ui/views/global/bottombar/BottomBarConfiguration;Lkotlin/jvm/functions/Function4;)Ldk/molslinjen/ui/views/global/navigation/SimpleScreenConfig;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SimpleScreenConfigKt {
    public static final SimpleScreenConfig createScreenConfig(TypedDestinationSpec<?> typedDestinationSpec, TopBarConfiguration topBarConfiguration, BottomBarConfiguration bottomBarConfiguration, Function4<? super TypedDestinationSpec<?>, ? super DependenciesContainerBuilder<?>, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(typedDestinationSpec, "<this>");
        Intrinsics.checkNotNullParameter(bottomBarConfiguration, "bottomBarConfiguration");
        return new SimpleScreenConfig(typedDestinationSpec, topBarConfiguration, bottomBarConfiguration, function4);
    }

    public static /* synthetic */ SimpleScreenConfig createScreenConfig$default(TypedDestinationSpec typedDestinationSpec, TopBarConfiguration topBarConfiguration, BottomBarConfiguration bottomBarConfiguration, Function4 function4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            topBarConfiguration = null;
        }
        if ((i5 & 2) != 0) {
            bottomBarConfiguration = BottomBarConfiguration.INSTANCE.getHidden();
        }
        if ((i5 & 4) != 0) {
            function4 = null;
        }
        return createScreenConfig(typedDestinationSpec, topBarConfiguration, bottomBarConfiguration, function4);
    }
}
