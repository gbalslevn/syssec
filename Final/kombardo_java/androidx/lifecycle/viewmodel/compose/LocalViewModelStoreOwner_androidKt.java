package androidx.lifecycle.viewmodel.compose;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000f\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"findViewTreeViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/compose/runtime/Composer;I)Landroidx/lifecycle/ViewModelStoreOwner;", "lifecycle-viewmodel-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LocalViewModelStoreOwner_androidKt {
    public static final ViewModelStoreOwner findViewTreeViewModelStoreOwner(Composer composer, int i5) {
        composer.startReplaceableGroup(1382572291);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1382572291, i5, -1, "androidx.lifecycle.viewmodel.compose.findViewTreeViewModelStoreOwner (LocalViewModelStoreOwner.android.kt:25)");
        }
        ViewModelStoreOwner viewModelStoreOwner = ViewTreeViewModelStoreOwner.get((View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return viewModelStoreOwner;
    }
}
