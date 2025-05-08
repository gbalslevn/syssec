package androidx.compose.material3;

import androidx.compose.runtime.RecomposeScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR.\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/FadeInFadeOutState;", "T", BuildConfig.FLAVOR, "<init>", "()V", "current", "Ljava/lang/Object;", "getCurrent", "()Ljava/lang/Object;", "setCurrent", "(Ljava/lang/Object;)V", BuildConfig.FLAVOR, "Landroidx/compose/material3/FadeInFadeOutAnimationItem;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "Landroidx/compose/runtime/RecomposeScope;", "scope", "Landroidx/compose/runtime/RecomposeScope;", "getScope", "()Landroidx/compose/runtime/RecomposeScope;", "setScope", "(Landroidx/compose/runtime/RecomposeScope;)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class FadeInFadeOutState<T> {
    private Object current = new Object();
    private List<FadeInFadeOutAnimationItem<T>> items = new ArrayList();
    private RecomposeScope scope;

    public final Object getCurrent() {
        return this.current;
    }

    public final List<FadeInFadeOutAnimationItem<T>> getItems() {
        return this.items;
    }

    public final RecomposeScope getScope() {
        return this.scope;
    }

    public final void setCurrent(Object obj) {
        this.current = obj;
    }

    public final void setScope(RecomposeScope recomposeScope) {
        this.scope = recomposeScope;
    }
}
