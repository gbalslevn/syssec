package androidx.compose.material.navigation;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.navigation.BottomSheetNavigator;
import androidx.compose.runtime.Composer;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavGraphBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001aS\u0010\r\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavGraphBuilder;", BuildConfig.FLAVOR, "route", BuildConfig.FLAVOR, "Landroidx/navigation/NamedNavArgument;", "arguments", "Landroidx/navigation/NavDeepLink;", "deepLinks", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/navigation/NavBackStackEntry;", BuildConfig.FLAVOR, "content", "bottomSheet", "(Landroidx/navigation/NavGraphBuilder;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function4;)V", "material-navigation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NavGraphBuilderKt {
    public static final void bottomSheet(NavGraphBuilder navGraphBuilder, String str, List<NamedNavArgument> list, List<NavDeepLink> list2, Function4<? super ColumnScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function4) {
        BottomSheetNavigator.Destination destination = new BottomSheetNavigator.Destination((BottomSheetNavigator) navGraphBuilder.getProvider().getNavigator(BottomSheetNavigator.class), function4);
        destination.setRoute(str);
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            NamedNavArgument namedNavArgument = list.get(i5);
            destination.addArgument(namedNavArgument.getName(), namedNavArgument.getArgument());
        }
        int size2 = list2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            destination.addDeepLink(list2.get(i6));
        }
        navGraphBuilder.addDestination(destination);
    }
}
