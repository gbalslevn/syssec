package androidx.hilt.navigation;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.ViewModelProvider;
import androidx.view.ComponentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "Landroidx/lifecycle/ViewModelProvider$Factory;", "delegateFactory", "create", "(Landroid/content/Context;Landroidx/lifecycle/ViewModelProvider$Factory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "HiltViewModelFactory", "hilt-navigation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class HiltViewModelFactory {
    public static final ViewModelProvider.Factory create(Context context, ViewModelProvider.Factory delegateFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegateFactory, "delegateFactory");
        while (context instanceof ContextWrapper) {
            if (context instanceof ComponentActivity) {
                ViewModelProvider.Factory createInternal = dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.createInternal((ComponentActivity) context, delegateFactory);
                Intrinsics.checkNotNullExpressionValue(createInternal, "createInternal(\n        … */ delegateFactory\n    )");
                return createInternal;
            }
            context = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(context, "ctx.baseContext");
        }
        throw new IllegalStateException("Expected an activity context for creating a HiltViewModelFactory but instead found: " + context);
    }
}
