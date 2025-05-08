package androidx.hilt.navigation.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.hilt.navigation.HiltViewModelFactory;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelProvider$Factory;", "createHiltViewModelFactory", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/compose/runtime/Composer;I)Landroidx/lifecycle/ViewModelProvider$Factory;", "hilt-navigation-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class HiltViewModelKt {
    public static final ViewModelProvider.Factory createHiltViewModelFactory(ViewModelStoreOwner viewModelStoreOwner, Composer composer, int i5) {
        composer.startReplaceableGroup(1770922558);
        ViewModelProvider.Factory create = viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? HiltViewModelFactory.create((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext()), ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory()) : null;
        composer.endReplaceableGroup();
        return create;
    }
}
