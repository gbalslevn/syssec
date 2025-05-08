package androidx.navigation.compose;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a1\u0010\u0006\u001a\u00020\u00022\"\u0010\u0007\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0\b\"\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0007¢\u0006\u0002\u0010\u000b\u001a\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r*\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"NavControllerSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/navigation/NavHostController;", "context", "Landroid/content/Context;", "createNavController", "rememberNavController", "navigators", BuildConfig.FLAVOR, "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "([Landroidx/navigation/Navigator;Landroidx/compose/runtime/Composer;I)Landroidx/navigation/NavHostController;", "currentBackStackEntryAsState", "Landroidx/compose/runtime/State;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/navigation/NavController;", "(Landroidx/navigation/NavController;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "navigation-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NavHostControllerKt {
    private static final Saver<NavHostController, ?> NavControllerSaver(final Context context) {
        return SaverKt.Saver(new Function2<SaverScope, NavHostController, Bundle>() { // from class: androidx.navigation.compose.NavHostControllerKt$NavControllerSaver$1
            @Override // kotlin.jvm.functions.Function2
            public final Bundle invoke(SaverScope saverScope, NavHostController navHostController) {
                return navHostController.saveState();
            }
        }, new Function1<Bundle, NavHostController>() { // from class: androidx.navigation.compose.NavHostControllerKt$NavControllerSaver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final NavHostController invoke(Bundle bundle) {
                NavHostController createNavController;
                createNavController = NavHostControllerKt.createNavController(context);
                createNavController.restoreState(bundle);
                return createNavController;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavHostController createNavController(Context context) {
        NavHostController navHostController = new NavHostController(context);
        navHostController.get_navigatorProvider().addNavigator(new ComposeNavGraphNavigator(navHostController.get_navigatorProvider()));
        navHostController.get_navigatorProvider().addNavigator(new ComposeNavigator());
        navHostController.get_navigatorProvider().addNavigator(new DialogNavigator());
        return navHostController;
    }

    public static final State<NavBackStackEntry> currentBackStackEntryAsState(NavController navController, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-120375203, i5, -1, "androidx.navigation.compose.currentBackStackEntryAsState (NavHostController.kt:41)");
        }
        State<NavBackStackEntry> collectAsState = SnapshotStateKt.collectAsState(navController.getCurrentBackStackEntryFlow(), null, null, composer, 48, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return collectAsState;
    }

    public static final NavHostController rememberNavController(Navigator<? extends NavDestination>[] navigatorArr, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-312215566, i5, -1, "androidx.navigation.compose.rememberNavController (NavHostController.kt:57)");
        }
        final Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Object[] copyOf = Arrays.copyOf(navigatorArr, navigatorArr.length);
        Saver<NavHostController, ?> NavControllerSaver = NavControllerSaver(context);
        boolean changedInstance = composer.changedInstance(context);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0<NavHostController>() { // from class: androidx.navigation.compose.NavHostControllerKt$rememberNavController$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final NavHostController invoke() {
                    NavHostController createNavController;
                    createNavController = NavHostControllerKt.createNavController(context);
                    return createNavController;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        NavHostController navHostController = (NavHostController) RememberSaveableKt.rememberSaveable(copyOf, NavControllerSaver, null, (Function0) rememberedValue, composer, 0, 4);
        for (Navigator<? extends NavDestination> navigator : navigatorArr) {
            navHostController.get_navigatorProvider().addNavigator(navigator);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return navHostController;
    }
}
