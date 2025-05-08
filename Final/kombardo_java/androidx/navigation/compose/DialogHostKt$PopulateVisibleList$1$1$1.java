package androidx.navigation.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DialogHostKt$PopulateVisibleList$1$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ NavBackStackEntry $entry;
    final /* synthetic */ boolean $isInspecting;
    final /* synthetic */ List<NavBackStackEntry> $this_PopulateVisibleList;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogHostKt$PopulateVisibleList$1$1$1(NavBackStackEntry navBackStackEntry, boolean z5, List<NavBackStackEntry> list) {
        super(1);
        this.$entry = navBackStackEntry;
        this.$isInspecting = z5;
        this.$this_PopulateVisibleList = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(boolean z5, List list, NavBackStackEntry navBackStackEntry, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (z5 && !list.contains(navBackStackEntry)) {
            list.add(navBackStackEntry);
        }
        if (event == Lifecycle.Event.ON_START && !list.contains(navBackStackEntry)) {
            list.add(navBackStackEntry);
        }
        if (event == Lifecycle.Event.ON_STOP) {
            list.remove(navBackStackEntry);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        final boolean z5 = this.$isInspecting;
        final List<NavBackStackEntry> list = this.$this_PopulateVisibleList;
        final NavBackStackEntry navBackStackEntry = this.$entry;
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.navigation.compose.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                DialogHostKt$PopulateVisibleList$1$1$1.invoke$lambda$0(z5, list, navBackStackEntry, lifecycleOwner, event);
            }
        };
        this.$entry.getLifecycle().addObserver(lifecycleEventObserver);
        final NavBackStackEntry navBackStackEntry2 = this.$entry;
        return new DisposableEffectResult() { // from class: androidx.navigation.compose.DialogHostKt$PopulateVisibleList$1$1$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                NavBackStackEntry.this.getLifecycle().removeObserver(lifecycleEventObserver);
            }
        };
    }
}
