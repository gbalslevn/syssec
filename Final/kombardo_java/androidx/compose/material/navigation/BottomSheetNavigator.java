package androidx.compose.material.navigation;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorState;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Navigator.Name("bottomSheet")
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0015\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR+\u0010&\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00188B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0017\u0010(\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R&\u0010.\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\t0,8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R \u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R \u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f06028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b7\u00104¨\u0006<²\u0006\u0012\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000f068\nX\u008a\u0084\u0002²\u0006\u000e\u0010;\u001a\u0004\u0018\u00010\u000f8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material/navigation/BottomSheetNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/compose/material/navigation/BottomSheetNavigator$Destination;", "Landroidx/compose/material/ModalBottomSheetState;", "sheetState", "<init>", "(Landroidx/compose/material/ModalBottomSheetState;)V", "Landroidx/navigation/NavigatorState;", "state", BuildConfig.FLAVOR, "onAttach", "(Landroidx/navigation/NavigatorState;)V", "createDestination", "()Landroidx/compose/material/navigation/BottomSheetNavigator$Destination;", BuildConfig.FLAVOR, "Landroidx/navigation/NavBackStackEntry;", "entries", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "navigate", "(Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "popUpTo", BuildConfig.FLAVOR, "savedState", "popBackStack", "(Landroidx/navigation/NavBackStackEntry;Z)V", "Landroidx/compose/material/ModalBottomSheetState;", "getSheetState$material_navigation_release", "()Landroidx/compose/material/ModalBottomSheetState;", "<set-?>", "attached$delegate", "Landroidx/compose/runtime/MutableState;", "getAttached", "()Z", "setAttached", "(Z)V", "attached", "Landroidx/compose/material/navigation/BottomSheetNavigatorSheetState;", "navigatorSheetState", "Landroidx/compose/material/navigation/BottomSheetNavigatorSheetState;", "getNavigatorSheetState", "()Landroidx/compose/material/navigation/BottomSheetNavigatorSheetState;", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "sheetContent", "Lkotlin/jvm/functions/Function3;", "getSheetContent$material_navigation_release", "()Lkotlin/jvm/functions/Function3;", "Lkotlinx/coroutines/flow/StateFlow;", "getBackStack", "()Lkotlinx/coroutines/flow/StateFlow;", "backStack", BuildConfig.FLAVOR, "getTransitionsInProgress$material_navigation_release", "transitionsInProgress", "Destination", "transitionsInProgressEntries", "retainedEntry", "material-navigation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BottomSheetNavigator extends Navigator<Destination> {
    public static final int $stable = ModalBottomSheetState.$stable;

    /* renamed from: attached$delegate, reason: from kotlin metadata */
    private final MutableState attached;
    private final BottomSheetNavigatorSheetState navigatorSheetState;
    private final Function3<ColumnScope, Composer, Integer, Unit> sheetContent;
    private final ModalBottomSheetState sheetState;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\n\u0010\u000bR,\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/navigation/BottomSheetNavigator$Destination;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/FloatingWindow;", "Landroidx/compose/material/navigation/BottomSheetNavigator;", "navigator", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/navigation/NavBackStackEntry;", BuildConfig.FLAVOR, "content", "<init>", "(Landroidx/compose/material/navigation/BottomSheetNavigator;Lkotlin/jvm/functions/Function4;)V", "Lkotlin/jvm/functions/Function4;", "getContent$material_navigation_release", "()Lkotlin/jvm/functions/Function4;", "material-navigation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Destination extends NavDestination implements FloatingWindow {
        private final Function4<ColumnScope, NavBackStackEntry, Composer, Integer, Unit> content;

        /* JADX WARN: Multi-variable type inference failed */
        public Destination(BottomSheetNavigator bottomSheetNavigator, Function4<? super ColumnScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function4) {
            super(bottomSheetNavigator);
            this.content = function4;
        }

        public final Function4<ColumnScope, NavBackStackEntry, Composer, Integer, Unit> getContent$material_navigation_release() {
            return this.content;
        }
    }

    public BottomSheetNavigator(ModalBottomSheetState modalBottomSheetState) {
        MutableState mutableStateOf$default;
        this.sheetState = modalBottomSheetState;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.attached = mutableStateOf$default;
        this.navigatorSheetState = new BottomSheetNavigatorSheetState(modalBottomSheetState);
        this.sheetContent = ComposableLambdaKt.composableLambdaInstance(-1433084388, true, new BottomSheetNavigator$sheetContent$1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getAttached() {
        return ((Boolean) this.attached.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StateFlow<List<NavBackStackEntry>> getBackStack() {
        return getAttached() ? getState().getBackStack() : StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    }

    private final void setAttached(boolean z5) {
        this.attached.setValue(Boolean.valueOf(z5));
    }

    public final Function3<ColumnScope, Composer, Integer, Unit> getSheetContent$material_navigation_release() {
        return this.sheetContent;
    }

    /* renamed from: getSheetState$material_navigation_release, reason: from getter */
    public final ModalBottomSheetState getSheetState() {
        return this.sheetState;
    }

    public final StateFlow<Set<NavBackStackEntry>> getTransitionsInProgress$material_navigation_release() {
        return getAttached() ? getState().getTransitionsInProgress() : StateFlowKt.MutableStateFlow(SetsKt.emptySet());
    }

    @Override // androidx.navigation.Navigator
    public void navigate(List<NavBackStackEntry> entries, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        int size = entries.size();
        for (int i5 = 0; i5 < size; i5++) {
            getState().pushWithTransition(entries.get(i5));
        }
    }

    @Override // androidx.navigation.Navigator
    public void onAttach(NavigatorState state) {
        super.onAttach(state);
        setAttached(true);
    }

    @Override // androidx.navigation.Navigator
    public void popBackStack(NavBackStackEntry popUpTo, boolean savedState) {
        getState().popWithTransition(popUpTo, savedState);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.navigation.Navigator
    public Destination createDestination() {
        return new Destination(this, ComposableSingletons$BottomSheetNavigatorKt.INSTANCE.m749getLambda1$material_navigation_release());
    }
}
